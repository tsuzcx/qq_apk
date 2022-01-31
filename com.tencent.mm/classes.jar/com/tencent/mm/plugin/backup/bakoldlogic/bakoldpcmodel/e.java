package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ls;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public final class e
  implements b.d
{
  private e.d hNQ;
  public e.c hNY;
  public e.a hNZ;
  public e.e hOa;
  public d hOb = new d();
  public f hOc = new f();
  com.tencent.mm.plugin.backup.bakoldlogic.c.e hOd;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a hOe;
  public int hOf = -1;
  public String hOg;
  public String hOh;
  public int hOi = -1;
  public int hOj = 1;
  private boolean hOk = false;
  
  public static void a(int paramInt1, int paramInt2, s params)
  {
    com.tencent.mm.plugin.backup.i.ac localac = new com.tencent.mm.plugin.backup.i.ac();
    localac.hPE = paramInt1;
    localac.hQq = paramInt2;
    localac.hRm = params;
    try
    {
      y.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), nP(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.I(localac.toByteArray(), 4);
      return;
    }
    catch (Exception params)
    {
      y.printErrStackTrace("MicroMsg.BakPcProcessMgr", params, "buf to PacketCommandResponse err", new Object[0]);
    }
  }
  
  public static void avB()
  {
    Intent localIntent = new Intent().setClassName(ae.getContext(), "com.tencent.mm.ui.LauncherUI");
    localIntent.addFlags(335544320);
    localIntent.putExtra("nofification_type", "back_to_pcmgr_error_notification");
    ae.getContext().startActivity(localIntent);
  }
  
  public static void avD()
  {
    ls localls = new ls();
    com.tencent.mm.sdk.b.a.udP.m(localls);
  }
  
  public static void nO(int paramInt)
  {
    ab localab = new ab();
    localab.hPE = paramInt;
    try
    {
      y.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), nP(paramInt) });
      com.tencent.mm.plugin.backup.g.b.I(localab.toByteArray(), 3);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException, "buf to PacketCommandRequest err", new Object[0]);
    }
  }
  
  private static String nP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 0: 
      return "AUTHORIZE";
    case 1: 
      return "BACKUP_INFO";
    case 2: 
      return "RESTORE_INFO";
    case 3: 
      return "BACKUP_START";
    case 4: 
      return "BACKUP_CANCEL";
    case 5: 
      return "BACKUP_FINISH";
    case 6: 
      return "RESTORE_START";
    case 7: 
      return "RESTORE_CANCE";
    case 8: 
      return "RESTORE_FINISH";
    case 9: 
      return "BACKUP_PAUSE";
    case 10: 
      return "RESTORE_PAUSE";
    case 11: 
      return "BACKUP_RESUME";
    case 12: 
      return "RESTORE_RESUME";
    case 13: 
      return "MERGE_PROGRESS";
    case 14: 
      return "LOGOFF";
    case 15: 
      return "EXIT";
    case 16: 
      return "SHOW_BACKUP_RESTORE";
    case 17: 
      return "COMMAND_WECHAT_LEAVE";
    }
    return "COMMAND_NOT_SUPPORT";
  }
  
  final void T(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        y.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[] { Integer.valueOf(paramInt), paramString });
        if ((paramInt != 10006) && (paramInt != 10008)) {
          break label359;
        }
        y.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
        this.hOi = -1;
        this.hOj = 1;
        avD();
        a.avr().avt().hNI = 2;
        a.avr().avt().Ig();
        if (this.hNY != null) {
          this.hNY.onError(paramInt);
        }
        if (this.hNZ != null) {
          this.hNZ.onError(paramInt);
        }
        if (this.hNQ != null) {
          this.hNQ.onError(paramInt);
        }
        if (this.hOa == null) {
          break label359;
        }
        this.hOa.onError(paramInt);
      }
      finally {}
      y.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.avr().avt().hNI = 2;
      a.avr().avt().Ig();
      avB();
      return;
      y.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.hNZ, this.hNQ, this.hNY });
      if (paramInt == 15)
      {
        if (this.hNZ != null) {
          this.hNZ.onError(paramInt);
        }
        if (this.hNQ != null) {
          this.hNQ.onError(paramInt);
        }
        if (this.hNY != null) {
          this.hNY.nR(paramInt);
        }
      }
      if (paramInt == -1) {
        if (this.hNZ != null)
        {
          this.hNZ.onError(paramInt);
        }
        else if (this.hNQ != null)
        {
          this.hNQ.onError(paramInt);
        }
        else if (this.hNY != null)
        {
          this.hNY.nR(paramInt);
          continue;
          label359:
          if (paramInt != 10009) {
            if (paramInt != 10004) {}
          }
        }
      }
    }
  }
  
  /* Error */
  public final void a(e.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +24 -> 27
    //   6: aload_0
    //   7: getfield 262	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hNQ	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   10: instanceof 281
    //   13: ifeq +14 -> 27
    //   16: ldc 85
    //   18: ldc_w 283
    //   21: invokestatic 285	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: ldc 85
    //   29: ldc_w 287
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: invokestatic 275	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_0
    //   44: aload_1
    //   45: putfield 262	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hNQ	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   48: aload_0
    //   49: getfield 52	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   52: aload_1
    //   53: putfield 288	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNQ	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   56: aload_0
    //   57: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOc	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   60: aload_1
    //   61: putfield 289	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hNQ	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   64: goto -40 -> 24
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	e
    //   0	72	1	paramd	e.d
    // Exception table:
    //   from	to	target	type
    //   6	24	67	finally
    //   27	64	67	finally
  }
  
  /* Error */
  final void a(com.tencent.mm.plugin.backup.i.r paramr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOc	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOc	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   13: invokevirtual 293	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   16: aload_0
    //   17: new 54	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   20: dup
    //   21: invokespecial 55	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   24: putfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOc	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   27: aload_0
    //   28: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOc	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   31: astore 4
    //   33: aload_1
    //   34: getfield 299	com/tencent/mm/plugin/backup/i/r:hQH	Ljava/util/LinkedList;
    //   37: astore 5
    //   39: aload_1
    //   40: getfield 302	com/tencent/mm/plugin/backup/i/r:hQI	Ljava/util/LinkedList;
    //   43: astore 6
    //   45: aload_1
    //   46: getfield 306	com/tencent/mm/plugin/backup/i/r:hQp	J
    //   49: lstore_2
    //   50: aload 4
    //   52: aload 5
    //   54: putfield 310	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOq	Ljava/util/List;
    //   57: aload 4
    //   59: aload 6
    //   61: putfield 313	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOr	Ljava/util/List;
    //   64: aload 4
    //   66: iconst_0
    //   67: putfield 316	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:bNW	Z
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 319	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:edT	Z
    //   76: aload 4
    //   78: getfield 323	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hNP	Ljava/util/HashSet;
    //   81: invokevirtual 328	java/util/HashSet:clear	()V
    //   84: aload 4
    //   86: iconst_0
    //   87: putfield 331	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hNS	Z
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 334	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOt	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 337	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hGO	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 340	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOs	I
    //   108: aload 4
    //   110: lconst_0
    //   111: putfield 343	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOv	J
    //   114: aload 4
    //   116: lload_2
    //   117: putfield 346	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOu	J
    //   120: iconst_0
    //   121: invokestatic 351	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   124: aload_0
    //   125: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOc	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   128: aload_0
    //   129: getfield 262	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hNQ	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   132: putfield 289	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hNQ	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   135: ldc 85
    //   137: ldc_w 353
    //   140: iconst_3
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload_1
    //   147: getfield 299	com/tencent/mm/plugin/backup/i/r:hQH	Ljava/util/LinkedList;
    //   150: invokevirtual 359	java/util/LinkedList:size	()I
    //   153: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload_1
    //   160: getfield 302	com/tencent/mm/plugin/backup/i/r:hQI	Ljava/util/LinkedList;
    //   163: invokevirtual 359	java/util/LinkedList:size	()I
    //   166: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: dup
    //   171: iconst_2
    //   172: aload_1
    //   173: getfield 306	com/tencent/mm/plugin/backup/i/r:hQp	J
    //   176: invokestatic 364	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: aastore
    //   180: invokestatic 103	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:hOc	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   187: astore 4
    //   189: aload 4
    //   191: iconst_0
    //   192: putfield 367	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hNW	I
    //   195: aload 4
    //   197: getfield 313	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOr	Ljava/util/List;
    //   200: invokeinterface 370 1 0
    //   205: aload_1
    //   206: getfield 373	com/tencent/mm/plugin/backup/i/r:hQu	I
    //   209: if_icmplt +20 -> 229
    //   212: aload 4
    //   214: getfield 310	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hOq	Ljava/util/List;
    //   217: invokeinterface 370 1 0
    //   222: aload_1
    //   223: getfield 376	com/tencent/mm/plugin/backup/i/r:hQt	I
    //   226: if_icmpge +40 -> 266
    //   229: iconst_3
    //   230: new 378	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   233: dup
    //   234: aload 4
    //   236: invokespecial 381	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   239: invokestatic 384	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/ah/f;)V
    //   242: ldc_w 386
    //   245: ldc_w 388
    //   248: invokestatic 390	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: new 392	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   254: dup
    //   255: iconst_2
    //   256: invokespecial 394	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   259: invokevirtual 398	com/tencent/mm/plugin/backup/bakoldlogic/c/b:auT	()Z
    //   262: pop
    //   263: aload_0
    //   264: monitorexit
    //   265: return
    //   266: ldc_w 386
    //   269: ldc_w 400
    //   272: invokestatic 390	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: new 402	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1
    //   278: dup
    //   279: aload 4
    //   281: invokespecial 403	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   284: ldc_w 405
    //   287: invokestatic 411	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   290: goto -27 -> 263
    //   293: astore_1
    //   294: aload_0
    //   295: monitorexit
    //   296: aload_1
    //   297: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	e
    //   0	298	1	paramr	com.tencent.mm.plugin.backup.i.r
    //   49	68	2	l	long
    //   31	249	4	localf	f
    //   37	16	5	localLinkedList1	java.util.LinkedList
    //   43	17	6	localLinkedList2	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	16	293	finally
    //   16	229	293	finally
    //   229	263	293	finally
    //   266	290	293	finally
  }
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      T(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.avr().avt().hNI = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.avr().hFn, a.avr().hFo, com.tencent.mm.plugin.backup.b.d.atr(), a.avr().hFm).auT();
    }
    if (paramInt1 == 3)
    {
      this.hOf = -1;
      ab localab = new ab();
      try
      {
        localab.aH(paramArrayOfByte);
        y.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(localab.hPE), nP(localab.hPE) });
        switch (localab.hPE)
        {
        case 0: 
          if (!au.DK())
          {
            y.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
            a(localab.hPE, 1, null);
            return;
          }
          break;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.BakPcProcessMgr", paramArrayOfByte, "buf to PacketCommandReq error", new Object[0]);
        return;
      }
      this.hOf = localab.hPE;
      if (this.hNZ != null) {
        this.hNZ.avE();
      }
      for (;;)
      {
        this.hOi = 0;
        this.hOj = 1;
        return;
        y.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
        paramArrayOfByte = new Intent().setClassName(ae.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramArrayOfByte.addFlags(335544320);
        paramArrayOfByte.putExtra("nofification_type", "back_to_pcmgr_notification");
        paramArrayOfByte.putExtra("newPCBackup", false);
        ae.getContext().startActivity(paramArrayOfByte);
      }
      a.avr().avu().avv();
      a.avr().avt().Ig();
      T(-1, null);
      y.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      return;
      this.hOj = 2;
      this.hOi = 3;
      avD();
      a(localab.hPE, 0, null);
      com.tencent.mm.sdk.f.e.b(new d.1(this.hOb), "BakPCServer_startBak").start();
      return;
      this.hOi = -1;
      this.hOj = 1;
      avD();
      a(localab.hPE, 0, null);
      if (this.hOd != null)
      {
        this.hOd.cancel();
        this.hOd = null;
      }
      if (this.hOb != null) {
        this.hOb.cancel();
      }
      if (this.hOe != null)
      {
        paramArrayOfByte = this.hOe;
        y.i("MicroMsg.BakCalculator", "calculator cancel.");
        y.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { bk.csb() });
        paramArrayOfByte.edT = true;
        this.hOe = null;
      }
      if (this.hNQ != null)
      {
        this.hNQ.avG();
        return;
        this.hOi = 5;
        this.hOj = 4;
        avD();
        this.hOf = localab.hPE;
        if (this.hNY != null) {
          this.hNY.nQ(localab.hPE);
        }
        for (;;)
        {
          paramArrayOfByte = a.avr().avt();
          paramArrayOfByte.hNL += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().a(new e.1(this));
          return;
          y.i("MicroMsg.BakPcProcessMgr", "callback is null");
        }
        this.hOi = -1;
        this.hOj = 1;
        avD();
        a(localab.hPE, 0, null);
        if (this.hOd != null)
        {
          this.hOd.cancel();
          this.hOd = null;
        }
        if (this.hOc != null) {
          this.hOc.cancel();
        }
        if (this.hNQ != null)
        {
          this.hNQ.avG();
          return;
          a(localab.hPE, 0, null);
          if (this.hOb != null)
          {
            this.hOb.pause();
            return;
            a(localab.hPE, 0, null);
            if (this.hOc != null)
            {
              this.hOc.pause();
              return;
              a(localab.hPE, 0, null);
              if (this.hOb != null)
              {
                this.hOb.resume();
                return;
                a(localab.hPE, 0, null);
                if (this.hOc != null)
                {
                  this.hOc.resume();
                  return;
                  a.avr().avu().avv();
                  a.avr().avt().Ig();
                  T(15, null);
                  return;
                  a(localab.hPE, 0, null);
                  if (this.hOa != null)
                  {
                    this.hOa.avH();
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void atF()
  {
    if (this.hOc.hOt)
    {
      f localf = this.hOc;
      y.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.hGO)
      {
        y.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        return;
      }
      localf.hNW = 0;
      a.avr().avs().hOj = 6;
      localf.hGO = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().a(new f.4(localf));
      return;
    }
    y.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
  }
  
  public final void avA()
  {
    try
    {
      this.hNQ = null;
      this.hOb.hNQ = null;
      this.hOc.hNQ = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int avC()
  {
    y.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.hOj) });
    if ((this.hOj == 2) || (this.hOj == 3)) {
      return this.hOb.hNV;
    }
    if ((this.hOj == 4) || (this.hOj == 5)) {
      return this.hOc.hOw;
    }
    if ((this.hOj == 6) || (this.hOj == 7)) {
      return this.hOc.hOs;
    }
    y.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    return 0;
  }
  
  public final boolean avz()
  {
    try
    {
      boolean bool = this.hOk;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ck(String paramString1, String paramString2)
  {
    this.hOg = paramString1;
    this.hOh = paramString2;
  }
  
  public final void ej(boolean paramBoolean)
  {
    try
    {
      this.hOk = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void nN(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.hOi = 1; paramInt == 1; this.hOi = -1)
    {
      com.tencent.mm.plugin.backup.i.ac localac = new com.tencent.mm.plugin.backup.i.ac();
      localac.hPE = 0;
      localac.hQq = paramInt;
      try
      {
        y.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.hQq) });
        com.tencent.mm.plugin.backup.g.b.I(localac.toByteArray(), 4);
        return;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException1, "buf to PacketCommandResponse err", new Object[0]);
        return;
      }
    }
    com.tencent.mm.plugin.backup.i.q localq = new com.tencent.mm.plugin.backup.i.q();
    localq.hQB = 0L;
    localq.hQD = Build.MANUFACTURER;
    localq.hQd = Build.MODEL;
    localq.hQC = 0L;
    localq.hQE = Build.VERSION.RELEASE;
    Object localObject2 = com.tencent.mm.storage.ac.dOP;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new File(com.tencent.mm.compatible.util.e.bkF).exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.f.zF())
      {
        localObject3 = new File(com.tencent.mm.compatible.util.e.bkH);
        if (!((File)localObject3).exists())
        {
          localObject1 = localObject2;
          if (!((File)localObject3).mkdirs()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.compatible.util.e.bkH;
        }
      }
    }
    localq.hQA = ((String)localObject1);
    localq.hQz = com.tencent.mm.model.q.Gl();
    localq.hQy = com.tencent.mm.model.q.Gj();
    localq.hQx = com.tencent.mm.protocal.d.spa;
    try
    {
      localObject1 = ae.getContext().getPackageManager().getPackageInfo(ae.getContext().getPackageName(), 0);
      localq.hQx = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.spa);
      o.JQ();
      localObject2 = com.tencent.mm.ag.d.kg(localq.hQy);
      localObject1 = null;
      if (localObject2 != null)
      {
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)localObject3);
        localObject1 = ((ByteArrayOutputStream)localObject3).toByteArray();
      }
    }
    catch (Exception localException3)
    {
      try
      {
        ((ByteArrayOutputStream)localObject3).close();
        o.JQ();
        localObject2 = com.tencent.mm.ag.d.A(localq.hQy, true);
        if (localObject1 == null)
        {
          i = 0;
          y.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!bk.bE((byte[])localObject1)) {
            localq.hQF = new com.tencent.mm.bv.b((byte[])localObject1);
          }
          localObject1 = com.tencent.mm.a.e.d((String)localObject2, 0, -1);
          if (!bk.bE((byte[])localObject1)) {
            localq.hQG = new com.tencent.mm.bv.b((byte[])localObject1);
          }
          localObject1 = new com.tencent.mm.plugin.backup.i.ac();
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).hPE = 0;
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).hQq = paramInt;
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).hRj = localq;
          try
          {
            y.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.ac)localObject1).hQq) });
            com.tencent.mm.plugin.backup.g.b.I(((com.tencent.mm.plugin.backup.i.ac)localObject1).toByteArray(), 4);
            return;
          }
          catch (Exception localException2)
          {
            y.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException2, "buf to PacketCommandResponse err", new Object[0]);
            return;
          }
          localException3 = localException3;
          y.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException3, "get packageInfo failed", new Object[0]);
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException4, "close", new Object[0]);
          continue;
          int i = localException3.length;
        }
      }
    }
  }
  
  public final void pause()
  {
    if (this.hOf == 1) {
      this.hOb.pause();
    }
    while (this.hOf != 6) {
      return;
    }
    this.hOc.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */