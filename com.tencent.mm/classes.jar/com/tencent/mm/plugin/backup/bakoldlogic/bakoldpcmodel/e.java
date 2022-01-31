package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.q;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public final class e
  implements b.d
{
  public e.c jHA;
  public e.a jHB;
  public e.e jHC;
  public d jHD;
  public f jHE;
  com.tencent.mm.plugin.backup.bakoldlogic.c.e jHF;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a jHG;
  public int jHH;
  public String jHI;
  public String jHJ;
  public int jHK;
  public int jHL;
  private boolean jHM;
  private e.d jHs;
  
  public e()
  {
    AppMethodBeat.i(17843);
    this.jHD = new d();
    this.jHE = new f();
    this.jHH = -1;
    this.jHK = -1;
    this.jHL = 1;
    this.jHM = false;
    AppMethodBeat.o(17843);
  }
  
  public static void a(int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(17852);
    com.tencent.mm.plugin.backup.i.ac localac = new com.tencent.mm.plugin.backup.i.ac();
    localac.jJg = paramInt1;
    localac.jJS = paramInt2;
    localac.jKN = params;
    try
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), rD(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.J(localac.toByteArray(), 4);
      AppMethodBeat.o(17852);
      return;
    }
    catch (Exception params)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", params, "buf to PacketCommandResponse err", new Object[0]);
      AppMethodBeat.o(17852);
    }
  }
  
  public static void aVe()
  {
    AppMethodBeat.i(17849);
    Intent localIntent = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
    localIntent.addFlags(335544320);
    localIntent.putExtra("nofification_type", "back_to_pcmgr_error_notification");
    ah.getContext().startActivity(localIntent);
    AppMethodBeat.o(17849);
  }
  
  public static void aVg()
  {
    AppMethodBeat.i(17855);
    mi localmi = new mi();
    com.tencent.mm.sdk.b.a.ymk.l(localmi);
    AppMethodBeat.o(17855);
  }
  
  public static void rC(int paramInt)
  {
    AppMethodBeat.i(17853);
    com.tencent.mm.plugin.backup.i.ab localab = new com.tencent.mm.plugin.backup.i.ab();
    localab.jJg = paramInt;
    try
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), rD(paramInt) });
      com.tencent.mm.plugin.backup.g.b.J(localab.toByteArray(), 3);
      AppMethodBeat.o(17853);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException, "buf to PacketCommandRequest err", new Object[0]);
      AppMethodBeat.o(17853);
    }
  }
  
  private static String rD(int paramInt)
  {
    AppMethodBeat.i(17856);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(17856);
      return String.valueOf(paramInt);
    case 0: 
      AppMethodBeat.o(17856);
      return "AUTHORIZE";
    case 1: 
      AppMethodBeat.o(17856);
      return "BACKUP_INFO";
    case 2: 
      AppMethodBeat.o(17856);
      return "RESTORE_INFO";
    case 3: 
      AppMethodBeat.o(17856);
      return "BACKUP_START";
    case 4: 
      AppMethodBeat.o(17856);
      return "BACKUP_CANCEL";
    case 5: 
      AppMethodBeat.o(17856);
      return "BACKUP_FINISH";
    case 6: 
      AppMethodBeat.o(17856);
      return "RESTORE_START";
    case 7: 
      AppMethodBeat.o(17856);
      return "RESTORE_CANCE";
    case 8: 
      AppMethodBeat.o(17856);
      return "RESTORE_FINISH";
    case 9: 
      AppMethodBeat.o(17856);
      return "BACKUP_PAUSE";
    case 10: 
      AppMethodBeat.o(17856);
      return "RESTORE_PAUSE";
    case 11: 
      AppMethodBeat.o(17856);
      return "BACKUP_RESUME";
    case 12: 
      AppMethodBeat.o(17856);
      return "RESTORE_RESUME";
    case 13: 
      AppMethodBeat.o(17856);
      return "MERGE_PROGRESS";
    case 14: 
      AppMethodBeat.o(17856);
      return "LOGOFF";
    case 15: 
      AppMethodBeat.o(17856);
      return "EXIT";
    case 16: 
      AppMethodBeat.o(17856);
      return "SHOW_BACKUP_RESTORE";
    case 17: 
      AppMethodBeat.o(17856);
      return "COMMAND_WECHAT_LEAVE";
    }
    AppMethodBeat.o(17856);
    return "COMMAND_NOT_SUPPORT";
  }
  
  /* Error */
  public final void a(e.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 17844
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +29 -> 38
    //   12: aload_0
    //   13: getfield 231	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHs	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   16: instanceof 233
    //   19: ifeq +19 -> 38
    //   22: ldc 94
    //   24: ldc 235
    //   26: invokestatic 239	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: sipush 17844
    //   32: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: ldc 94
    //   40: ldc 241
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: aastore
    //   50: invokestatic 243	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_0
    //   54: aload_1
    //   55: putfield 231	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHs	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   58: aload_0
    //   59: getfield 58	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHD	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   62: aload_1
    //   63: putfield 244	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHs	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   66: aload_0
    //   67: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHE	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   70: aload_1
    //   71: putfield 245	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHs	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   74: sipush 17844
    //   77: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: goto -45 -> 35
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	e
    //   0	88	1	paramd	e.d
    // Exception table:
    //   from	to	target	type
    //   2	8	83	finally
    //   12	35	83	finally
    //   38	80	83	finally
  }
  
  /* Error */
  final void a(com.tencent.mm.plugin.backup.i.r paramr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 17854
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHE	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHE	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   19: invokevirtual 249	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   22: aload_0
    //   23: new 60	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   26: dup
    //   27: invokespecial 61	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   30: putfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHE	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   33: aload_0
    //   34: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHE	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 255	com/tencent/mm/plugin/backup/i/r:jKj	Ljava/util/LinkedList;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 258	com/tencent/mm/plugin/backup/i/r:jKk	Ljava/util/LinkedList;
    //   49: astore 6
    //   51: aload_1
    //   52: getfield 261	com/tencent/mm/plugin/backup/i/r:jJR	J
    //   55: lstore_2
    //   56: aload 4
    //   58: aload 5
    //   60: putfield 265	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHS	Ljava/util/List;
    //   63: aload 4
    //   65: aload 6
    //   67: putfield 268	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHT	Ljava/util/List;
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 271	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cvo	Z
    //   76: aload 4
    //   78: iconst_0
    //   79: putfield 274	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:eUJ	Z
    //   82: aload 4
    //   84: getfield 278	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHr	Ljava/util/HashSet;
    //   87: invokevirtual 283	java/util/HashSet:clear	()V
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 286	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHu	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 289	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHV	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 292	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jAk	Z
    //   108: aload 4
    //   110: iconst_0
    //   111: putfield 295	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHU	I
    //   114: aload 4
    //   116: lconst_0
    //   117: putfield 298	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHX	J
    //   120: aload 4
    //   122: lload_2
    //   123: putfield 301	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHW	J
    //   126: iconst_0
    //   127: invokestatic 306	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   130: aload_0
    //   131: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHE	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   134: aload_0
    //   135: getfield 231	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHs	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   138: putfield 245	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHs	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   141: ldc 94
    //   143: ldc_w 308
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: getfield 255	com/tencent/mm/plugin/backup/i/r:jKj	Ljava/util/LinkedList;
    //   156: invokevirtual 314	java/util/LinkedList:size	()I
    //   159: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: getfield 258	com/tencent/mm/plugin/backup/i/r:jKk	Ljava/util/LinkedList;
    //   169: invokevirtual 314	java/util/LinkedList:size	()I
    //   172: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: getfield 261	com/tencent/mm/plugin/backup/i/r:jJR	J
    //   182: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 111	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:jHE	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 322	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHy	I
    //   201: aload 4
    //   203: getfield 268	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHT	Ljava/util/List;
    //   206: invokeinterface 325 1 0
    //   211: aload_1
    //   212: getfield 328	com/tencent/mm/plugin/backup/i/r:jJW	I
    //   215: if_icmplt +20 -> 235
    //   218: aload 4
    //   220: getfield 265	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:jHS	Ljava/util/List;
    //   223: invokeinterface 325 1 0
    //   228: aload_1
    //   229: getfield 331	com/tencent/mm/plugin/backup/i/r:jJV	I
    //   232: if_icmpge +46 -> 278
    //   235: iconst_3
    //   236: new 333	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   239: dup
    //   240: aload 4
    //   242: invokespecial 336	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   245: invokestatic 339	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/ai/f;)V
    //   248: ldc_w 341
    //   251: ldc_w 343
    //   254: invokestatic 345	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: new 347	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 349	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   265: invokevirtual 353	com/tencent/mm/plugin/backup/bakoldlogic/c/b:aUv	()Z
    //   268: pop
    //   269: sipush 17854
    //   272: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: ldc_w 341
    //   281: ldc_w 355
    //   284: invokestatic 345	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: new 357	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1
    //   290: dup
    //   291: aload 4
    //   293: invokespecial 358	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   296: ldc_w 360
    //   299: invokestatic 366	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   302: sipush 17854
    //   305: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: goto -33 -> 275
    //   311: astore_1
    //   312: aload_0
    //   313: monitorexit
    //   314: aload_1
    //   315: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	e
    //   0	316	1	paramr	com.tencent.mm.plugin.backup.i.r
    //   55	68	2	l	long
    //   37	255	4	localf	f
    //   43	16	5	localLinkedList1	java.util.LinkedList
    //   49	17	6	localLinkedList2	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	22	311	finally
    //   22	235	311	finally
    //   235	275	311	finally
    //   278	308	311	finally
  }
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(17848);
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      ai(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.aUU().aUW().jHk = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.aUU().jyG, a.aUU().jyH, com.tencent.mm.plugin.backup.b.d.aSP(), a.aUU().jyF).aUv();
    }
    com.tencent.mm.plugin.backup.i.ab localab;
    if (paramInt1 == 3)
    {
      this.jHH = -1;
      localab = new com.tencent.mm.plugin.backup.i.ab();
    }
    for (;;)
    {
      try
      {
        localab.parseFrom(paramArrayOfByte);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(localab.jJg), rD(localab.jJg) });
        paramInt1 = localab.jJg;
        switch (paramInt1)
        {
        case 2: 
        case 5: 
        case 8: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(17848);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", paramArrayOfByte, "buf to PacketCommandReq error", new Object[0]);
      }
      if (!aw.RG())
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
        a(localab.jJg, 1, null);
        AppMethodBeat.o(17848);
        return;
      }
      this.jHH = localab.jJg;
      if (this.jHB != null)
      {
        this.jHB.aVh();
        this.jHK = 0;
        this.jHL = 1;
        AppMethodBeat.o(17848);
        return;
        AppMethodBeat.o(17848);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
      paramArrayOfByte = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramArrayOfByte.addFlags(335544320);
      paramArrayOfByte.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramArrayOfByte.putExtra("newPCBackup", false);
      ah.getContext().startActivity(paramArrayOfByte);
      continue;
      a.aUU().aUX().aUY();
      a.aUU().aUW().abd();
      ai(-1, null);
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      AppMethodBeat.o(17848);
      return;
      this.jHL = 2;
      this.jHK = 3;
      aVg();
      a(localab.jJg, 0, null);
      com.tencent.mm.sdk.g.d.h(new d.1(this.jHD), "BakPCServer_startBak").start();
      AppMethodBeat.o(17848);
      return;
      this.jHK = -1;
      this.jHL = 1;
      aVg();
      a(localab.jJg, 0, null);
      if (this.jHF != null)
      {
        this.jHF.cancel();
        this.jHF = null;
      }
      if (this.jHD != null) {
        this.jHD.cancel();
      }
      if (this.jHG != null)
      {
        paramArrayOfByte = this.jHG;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakCalculator", "calculator cancel.");
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { bo.dtY() });
        paramArrayOfByte.eUJ = true;
        this.jHG = null;
      }
      if (this.jHs != null)
      {
        this.jHs.aVj();
        AppMethodBeat.o(17848);
        return;
        this.jHK = 5;
        this.jHL = 4;
        aVg();
        this.jHH = localab.jJg;
        if (this.jHA != null) {
          this.jHA.onEvent(localab.jJg);
        }
        for (;;)
        {
          paramArrayOfByte = a.aUU().aUW();
          paramArrayOfByte.jHn += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().a(new e.1(this));
          AppMethodBeat.o(17848);
          return;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "callback is null");
        }
        this.jHK = -1;
        this.jHL = 1;
        aVg();
        a(localab.jJg, 0, null);
        if (this.jHF != null)
        {
          this.jHF.cancel();
          this.jHF = null;
        }
        if (this.jHE != null) {
          this.jHE.cancel();
        }
        if (this.jHs != null)
        {
          this.jHs.aVj();
          AppMethodBeat.o(17848);
          return;
          a(localab.jJg, 0, null);
          if (this.jHD != null)
          {
            this.jHD.pause();
            AppMethodBeat.o(17848);
            return;
            a(localab.jJg, 0, null);
            if (this.jHE != null)
            {
              this.jHE.pause();
              AppMethodBeat.o(17848);
              return;
              a(localab.jJg, 0, null);
              if (this.jHD != null)
              {
                this.jHD.resume();
                AppMethodBeat.o(17848);
                return;
                a(localab.jJg, 0, null);
                if (this.jHE != null)
                {
                  this.jHE.resume();
                  AppMethodBeat.o(17848);
                  return;
                  a.aUU().aUX().aUY();
                  a.aUU().aUW().abd();
                  ai(15, null);
                  AppMethodBeat.o(17848);
                  return;
                  a(localab.jJg, 0, null);
                  if (this.jHC != null) {
                    this.jHC.aVk();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void aTd()
  {
    AppMethodBeat.i(17845);
    if (this.jHE.jHV)
    {
      f localf = this.jHE;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.jAk)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        AppMethodBeat.o(17845);
        return;
      }
      localf.jHy = 0;
      a.aUU().aUV().jHL = 6;
      localf.jAk = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().a(new f.4(localf));
      AppMethodBeat.o(17845);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    AppMethodBeat.o(17845);
  }
  
  public final boolean aVc()
  {
    try
    {
      boolean bool = this.jHM;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void aVd()
  {
    try
    {
      this.jHs = null;
      this.jHD.jHs = null;
      this.jHE.jHs = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int aVf()
  {
    AppMethodBeat.i(17850);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.jHL) });
    int i;
    if ((this.jHL == 2) || (this.jHL == 3))
    {
      i = this.jHD.jHx;
      AppMethodBeat.o(17850);
      return i;
    }
    if ((this.jHL == 4) || (this.jHL == 5))
    {
      i = this.jHE.jHY;
      AppMethodBeat.o(17850);
      return i;
    }
    if ((this.jHL == 6) || (this.jHL == 7))
    {
      i = this.jHE.jHU;
      AppMethodBeat.o(17850);
      return i;
    }
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    AppMethodBeat.o(17850);
    return 0;
  }
  
  final void ai(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(17847);
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[] { Integer.valueOf(paramInt), paramString });
        if ((paramInt != 10006) && (paramInt != 10008)) {
          break label391;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
        this.jHK = -1;
        this.jHL = 1;
        aVg();
        a.aUU().aUW().jHk = 2;
        a.aUU().aUW().abd();
        if (this.jHA != null) {
          this.jHA.onError(paramInt);
        }
        if (this.jHB != null) {
          this.jHB.onError(paramInt);
        }
        if (this.jHs != null) {
          this.jHs.onError(paramInt);
        }
        if (this.jHC == null) {
          break label391;
        }
        this.jHC.onError(paramInt);
      }
      finally {}
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.aUU().aUW().jHk = 2;
      a.aUU().aUW().abd();
      aVe();
      AppMethodBeat.o(17847);
      return;
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.jHB, this.jHs, this.jHA });
      if (paramInt == 15)
      {
        if (this.jHB != null) {
          this.jHB.onError(paramInt);
        }
        if (this.jHs != null) {
          this.jHs.onError(paramInt);
        }
        if (this.jHA != null) {
          this.jHA.rE(paramInt);
        }
      }
      if (paramInt == -1)
      {
        if (this.jHB != null)
        {
          this.jHB.onError(paramInt);
          AppMethodBeat.o(17847);
          continue;
        }
        if (this.jHs != null)
        {
          this.jHs.onError(paramInt);
          AppMethodBeat.o(17847);
          continue;
        }
        if (this.jHA != null) {
          this.jHA.rE(paramInt);
        }
      }
      AppMethodBeat.o(17847);
      continue;
      label391:
      if (paramInt != 10009) {
        if (paramInt != 10004) {}
      }
    }
  }
  
  public final void db(String paramString1, String paramString2)
  {
    this.jHI = paramString1;
    this.jHJ = paramString2;
  }
  
  public final void fF(boolean paramBoolean)
  {
    try
    {
      this.jHM = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(17846);
    if (this.jHH == 1)
    {
      this.jHD.pause();
      AppMethodBeat.o(17846);
      return;
    }
    if (this.jHH == 6) {
      this.jHE.pause();
    }
    AppMethodBeat.o(17846);
  }
  
  public final void rB(int paramInt)
  {
    AppMethodBeat.i(17851);
    if (paramInt == 0) {}
    for (this.jHK = 1; paramInt == 1; this.jHK = -1)
    {
      com.tencent.mm.plugin.backup.i.ac localac = new com.tencent.mm.plugin.backup.i.ac();
      localac.jJg = 0;
      localac.jJS = paramInt;
      try
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.jJS) });
        com.tencent.mm.plugin.backup.g.b.J(localac.toByteArray(), 4);
        AppMethodBeat.o(17851);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException1, "buf to PacketCommandResponse err", new Object[0]);
        AppMethodBeat.o(17851);
        return;
      }
    }
    q localq = new q();
    localq.jKd = 0L;
    localq.jKf = Build.MANUFACTURER;
    localq.jJF = Build.MODEL;
    localq.jKe = 0L;
    localq.jKg = Build.VERSION.RELEASE;
    Object localObject2 = com.tencent.mm.storage.ac.eQv;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new File(com.tencent.mm.compatible.util.e.eQx).exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.f.Mi())
      {
        localObject3 = new File(com.tencent.mm.compatible.util.e.eQz);
        if (!((File)localObject3).exists())
        {
          localObject1 = localObject2;
          if (!((File)localObject3).mkdirs()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.compatible.util.e.eQz;
        }
      }
    }
    localq.jKc = ((String)localObject1);
    localq.jKb = r.Zp();
    localq.jKa = r.Zn();
    localq.jJZ = com.tencent.mm.protocal.d.whH;
    try
    {
      localObject1 = ah.getContext().getPackageManager().getPackageInfo(ah.getContext().getPackageName(), 0);
      localq.jJZ = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.whH);
      o.acQ();
      localObject2 = com.tencent.mm.ah.d.ra(localq.jKa);
      localObject1 = null;
      if (localObject2 != null)
      {
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)localObject3);
        localObject1 = ((ByteArrayOutputStream)localObject3).toByteArray();
      }
    }
    catch (Exception localException2)
    {
      try
      {
        ((ByteArrayOutputStream)localObject3).close();
        o.acQ();
        localObject2 = com.tencent.mm.ah.d.E(localq.jKa, true);
        if (localObject1 == null)
        {
          i = 0;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!bo.ce((byte[])localObject1)) {
            localq.jKh = new com.tencent.mm.bv.b((byte[])localObject1);
          }
          localObject1 = com.tencent.mm.a.e.j((String)localObject2, 0, -1);
          if (!bo.ce((byte[])localObject1)) {
            localq.jKi = new com.tencent.mm.bv.b((byte[])localObject1);
          }
          localObject1 = new com.tencent.mm.plugin.backup.i.ac();
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).jJg = 0;
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).jJS = paramInt;
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).jKK = localq;
        }
        try
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.ac)localObject1).jJS) });
          com.tencent.mm.plugin.backup.g.b.J(((com.tencent.mm.plugin.backup.i.ac)localObject1).toByteArray(), 4);
          AppMethodBeat.o(17851);
          return;
        }
        catch (Exception localException3)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException3, "buf to PacketCommandResponse err", new Object[0]);
          AppMethodBeat.o(17851);
        }
        localException2 = localException2;
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException2, "get packageInfo failed", new Object[0]);
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException4, "close", new Object[0]);
          continue;
          int i = localException2.length;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */