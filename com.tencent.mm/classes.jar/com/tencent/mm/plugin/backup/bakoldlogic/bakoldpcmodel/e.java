package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.qc;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class e
  implements b.d
{
  public c rTH;
  public a rTI;
  public e rTJ;
  public d rTK;
  public f rTL;
  com.tencent.mm.plugin.backup.bakoldlogic.c.e rTM;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a rTN;
  public int rTO;
  public String rTP;
  public String rTQ;
  public int rTR;
  public int rTS;
  private boolean rTT;
  private d rTz;
  
  public e()
  {
    AppMethodBeat.i(21900);
    this.rTK = new d();
    this.rTL = new f();
    this.rTO = -1;
    this.rTR = -1;
    this.rTS = 1;
    this.rTT = false;
    AppMethodBeat.o(21900);
  }
  
  public static void EW(int paramInt)
  {
    AppMethodBeat.i(21910);
    ab localab = new ab();
    localab.rVj = paramInt;
    try
    {
      Log.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), EX(paramInt) });
      com.tencent.mm.plugin.backup.g.b.O(localab.toByteArray(), 3);
      AppMethodBeat.o(21910);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException, "buf to PacketCommandRequest err", new Object[0]);
      AppMethodBeat.o(21910);
    }
  }
  
  private static String EX(int paramInt)
  {
    AppMethodBeat.i(21913);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(21913);
      return String.valueOf(paramInt);
    case 0: 
      AppMethodBeat.o(21913);
      return "AUTHORIZE";
    case 1: 
      AppMethodBeat.o(21913);
      return "BACKUP_INFO";
    case 2: 
      AppMethodBeat.o(21913);
      return "RESTORE_INFO";
    case 3: 
      AppMethodBeat.o(21913);
      return "BACKUP_START";
    case 4: 
      AppMethodBeat.o(21913);
      return "BACKUP_CANCEL";
    case 5: 
      AppMethodBeat.o(21913);
      return "BACKUP_FINISH";
    case 6: 
      AppMethodBeat.o(21913);
      return "RESTORE_START";
    case 7: 
      AppMethodBeat.o(21913);
      return "RESTORE_CANCE";
    case 8: 
      AppMethodBeat.o(21913);
      return "RESTORE_FINISH";
    case 9: 
      AppMethodBeat.o(21913);
      return "BACKUP_PAUSE";
    case 10: 
      AppMethodBeat.o(21913);
      return "RESTORE_PAUSE";
    case 11: 
      AppMethodBeat.o(21913);
      return "BACKUP_RESUME";
    case 12: 
      AppMethodBeat.o(21913);
      return "RESTORE_RESUME";
    case 13: 
      AppMethodBeat.o(21913);
      return "MERGE_PROGRESS";
    case 14: 
      AppMethodBeat.o(21913);
      return "LOGOFF";
    case 15: 
      AppMethodBeat.o(21913);
      return "EXIT";
    case 16: 
      AppMethodBeat.o(21913);
      return "SHOW_BACKUP_RESTORE";
    case 17: 
      AppMethodBeat.o(21913);
      return "COMMAND_WECHAT_LEAVE";
    }
    AppMethodBeat.o(21913);
    return "COMMAND_NOT_SUPPORT";
  }
  
  public static void a(int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(21909);
    ac localac = new ac();
    localac.rVj = paramInt1;
    localac.rVU = paramInt2;
    localac.rWP = params;
    try
    {
      Log.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), EX(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.O(localac.toByteArray(), 4);
      AppMethodBeat.o(21909);
      return;
    }
    catch (Exception params)
    {
      Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", params, "buf to PacketCommandResponse err", new Object[0]);
      AppMethodBeat.o(21909);
    }
  }
  
  public static void cuu()
  {
    AppMethodBeat.i(21906);
    Object localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_error_notification");
    Context localContext = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21906);
  }
  
  public static void cuw()
  {
    AppMethodBeat.i(21912);
    qc localqc = new qc();
    EventCenter.instance.publish(localqc);
    AppMethodBeat.o(21912);
  }
  
  public final void EV(int paramInt)
  {
    AppMethodBeat.i(21908);
    if (paramInt == 0) {}
    for (this.rTR = 1; paramInt == 1; this.rTR = -1)
    {
      ac localac = new ac();
      localac.rVj = 0;
      localac.rVU = paramInt;
      try
      {
        Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.rVU) });
        com.tencent.mm.plugin.backup.g.b.O(localac.toByteArray(), 4);
        AppMethodBeat.o(21908);
        return;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException1, "buf to PacketCommandResponse err", new Object[0]);
        AppMethodBeat.o(21908);
        return;
      }
    }
    com.tencent.mm.plugin.backup.i.q localq = new com.tencent.mm.plugin.backup.i.q();
    localq.rWf = 0L;
    localq.rWh = Build.MANUFACTURER;
    localq.rVH = Build.MODEL;
    localq.rWg = 0L;
    localq.Version = Build.VERSION.RELEASE;
    Object localObject2 = ar.Vgb;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSF()).ifE())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.avA())
      {
        localObject3 = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSL());
        if (!((com.tencent.mm.vfs.q)localObject3).ifE())
        {
          localObject1 = localObject2;
          if (!((com.tencent.mm.vfs.q)localObject3).ifL()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.loader.j.b.aSL();
        }
      }
    }
    localq.rWe = ((String)localObject1);
    localq.rWd = z.bdb();
    localq.rWc = z.bcZ();
    localq.rWb = com.tencent.mm.protocal.d.RAD;
    try
    {
      localObject1 = MMApplicationContext.getContext().getPackageManager().getPackageInfo(MMApplicationContext.getContext().getPackageName(), 0);
      localq.rWb = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.RAD);
      com.tencent.mm.am.q.bhz();
      localObject2 = com.tencent.mm.am.f.TI(localq.rWc);
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
        com.tencent.mm.am.q.bhz();
        localObject2 = com.tencent.mm.am.f.O(localq.rWc, true);
        if (localObject1 == null)
        {
          i = 0;
          Log.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!Util.isNullOrNil((byte[])localObject1)) {
            localq.rWi = new com.tencent.mm.cd.b((byte[])localObject1);
          }
          localObject1 = u.aY((String)localObject2, 0, -1);
          if (!Util.isNullOrNil((byte[])localObject1)) {
            localq.rWj = new com.tencent.mm.cd.b((byte[])localObject1);
          }
          localObject1 = new ac();
          ((ac)localObject1).rVj = 0;
          ((ac)localObject1).rVU = paramInt;
          ((ac)localObject1).rWM = localq;
        }
        try
        {
          Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((ac)localObject1).rVU) });
          com.tencent.mm.plugin.backup.g.b.O(((ac)localObject1).toByteArray(), 4);
          AppMethodBeat.o(21908);
          return;
        }
        catch (Exception localException3)
        {
          Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException3, "buf to PacketCommandResponse err", new Object[0]);
          AppMethodBeat.o(21908);
        }
        localException2 = localException2;
        Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException2, "get packageInfo failed", new Object[0]);
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException4, "close", new Object[0]);
          continue;
          int i = localException2.length;
        }
      }
    }
  }
  
  /* Error */
  public final void a(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 21901
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +30 -> 39
    //   12: aload_0
    //   13: getfield 469	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTz	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   16: instanceof 471
    //   19: ifeq +20 -> 39
    //   22: ldc 99
    //   24: ldc_w 473
    //   27: invokestatic 476	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: sipush 21901
    //   33: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: ldc 99
    //   41: ldc_w 478
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload_1
    //   57: putfield 469	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTz	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   60: aload_0
    //   61: getfield 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTK	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   64: aload_1
    //   65: putfield 481	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTz	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   68: aload_0
    //   69: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   72: aload_1
    //   73: putfield 482	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rTz	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   76: sipush 21901
    //   79: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: goto -46 -> 36
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	e
    //   0	90	1	paramd	d
    // Exception table:
    //   from	to	target	type
    //   2	8	85	finally
    //   12	36	85	finally
    //   39	82	85	finally
  }
  
  /* Error */
  final void a(r paramr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 21911
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   19: invokevirtual 486	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   22: aload_0
    //   23: new 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   26: dup
    //   27: invokespecial 74	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   30: putfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   33: aload_0
    //   34: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 492	com/tencent/mm/plugin/backup/i/r:rWk	Ljava/util/LinkedList;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 495	com/tencent/mm/plugin/backup/i/r:rWl	Ljava/util/LinkedList;
    //   49: astore 6
    //   51: aload_1
    //   52: getfield 498	com/tencent/mm/plugin/backup/i/r:rVT	J
    //   55: lstore_2
    //   56: aload 4
    //   58: aload 5
    //   60: putfield 502	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rTZ	Ljava/util/List;
    //   63: aload 4
    //   65: aload 6
    //   67: putfield 505	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rUa	Ljava/util/List;
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 508	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:fEs	Z
    //   76: aload 4
    //   78: iconst_0
    //   79: putfield 511	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:kUn	Z
    //   82: aload 4
    //   84: getfield 515	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rTy	Ljava/util/HashSet;
    //   87: invokevirtual 520	java/util/HashSet:clear	()V
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 523	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rTB	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 526	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rUc	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 529	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rMp	Z
    //   108: aload 4
    //   110: iconst_0
    //   111: putfield 532	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rUb	I
    //   114: aload 4
    //   116: lconst_0
    //   117: putfield 535	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rUe	J
    //   120: aload 4
    //   122: lload_2
    //   123: putfield 538	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rUd	J
    //   126: iconst_0
    //   127: invokestatic 543	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   130: aload_0
    //   131: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   134: aload_0
    //   135: getfield 469	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTz	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   138: putfield 482	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rTz	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   141: ldc 99
    //   143: ldc_w 545
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: getfield 492	com/tencent/mm/plugin/backup/i/r:rWk	Ljava/util/LinkedList;
    //   156: invokevirtual 551	java/util/LinkedList:size	()I
    //   159: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: getfield 495	com/tencent/mm/plugin/backup/i/r:rWl	Ljava/util/LinkedList;
    //   169: invokevirtual 551	java/util/LinkedList:size	()I
    //   172: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: getfield 498	com/tencent/mm/plugin/backup/i/r:rVT	J
    //   182: invokestatic 556	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:rTL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 559	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rTF	I
    //   201: aload 4
    //   203: getfield 505	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rUa	Ljava/util/List;
    //   206: invokeinterface 562 1 0
    //   211: aload_1
    //   212: getfield 565	com/tencent/mm/plugin/backup/i/r:rVY	I
    //   215: if_icmplt +20 -> 235
    //   218: aload 4
    //   220: getfield 502	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:rTZ	Ljava/util/List;
    //   223: invokeinterface 562 1 0
    //   228: aload_1
    //   229: getfield 568	com/tencent/mm/plugin/backup/i/r:rVX	I
    //   232: if_icmpge +46 -> 278
    //   235: iconst_3
    //   236: new 570	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   239: dup
    //   240: aload 4
    //   242: invokespecial 573	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   245: invokestatic 576	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/an/i;)V
    //   248: ldc_w 578
    //   251: ldc_w 580
    //   254: invokestatic 582	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: new 584	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 586	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   265: invokevirtual 589	com/tencent/mm/plugin/backup/bakoldlogic/c/b:ctM	()Z
    //   268: pop
    //   269: sipush 21911
    //   272: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: ldc_w 578
    //   281: ldc_w 591
    //   284: invokestatic 582	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: getstatic 597	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   290: new 599	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1
    //   293: dup
    //   294: aload 4
    //   296: invokespecial 600	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   299: invokeinterface 606 2 0
    //   304: pop
    //   305: sipush 21911
    //   308: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: goto -36 -> 275
    //   314: astore_1
    //   315: aload_0
    //   316: monitorexit
    //   317: aload_1
    //   318: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	e
    //   0	319	1	paramr	r
    //   55	68	2	l	long
    //   37	258	4	localf	f
    //   43	16	5	localLinkedList1	java.util.LinkedList
    //   49	17	6	localLinkedList2	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	22	314	finally
    //   22	235	314	finally
    //   235	275	314	finally
    //   278	311	314	finally
  }
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(21905);
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      aC(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.cuk().cum().rTr = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.cuk().rKL, a.cuk().rKM, com.tencent.mm.plugin.backup.b.d.csd(), a.cuk().rKK).ctM();
    }
    Object localObject;
    if (paramInt1 == 3)
    {
      this.rTO = -1;
      localObject = new ab();
    }
    for (;;)
    {
      try
      {
        ((ab)localObject).parseFrom(paramArrayOfByte);
        Log.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(((ab)localObject).rVj), EX(((ab)localObject).rVj) });
        paramInt1 = ((ab)localObject).rVj;
        switch (paramInt1)
        {
        case 2: 
        case 5: 
        case 8: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(21905);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", paramArrayOfByte, "buf to PacketCommandReq error", new Object[0]);
      }
      if (!bh.aHB())
      {
        Log.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
        a(((ab)localObject).rVj, 1, null);
        AppMethodBeat.o(21905);
        return;
      }
      this.rTO = ((ab)localObject).rVj;
      if (this.rTI != null)
      {
        this.rTI.cux();
        this.rTR = 0;
        this.rTS = 1;
        AppMethodBeat.o(21905);
        return;
        AppMethodBeat.o(21905);
        return;
      }
      Log.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
      localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
      ((Intent)localObject).putExtra("newPCBackup", false);
      paramArrayOfByte = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfByte, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      a.cuk().cun().cuo();
      a.cuk().cum().bfq();
      aC(-1, null);
      Log.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      AppMethodBeat.o(21905);
      return;
      this.rTS = 2;
      this.rTR = 3;
      cuw();
      a(((ab)localObject).rVj, 0, null);
      paramArrayOfByte = this.rTK;
      h.ZvG.bh(new d.1(paramArrayOfByte));
      AppMethodBeat.o(21905);
      return;
      this.rTR = -1;
      this.rTS = 1;
      cuw();
      a(((ab)localObject).rVj, 0, null);
      if (this.rTM != null)
      {
        this.rTM.cancel();
        this.rTM = null;
      }
      if (this.rTK != null) {
        this.rTK.cancel();
      }
      if (this.rTN != null)
      {
        Log.i("MicroMsg.BakCalculator", "calculator cancel.");
        Log.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { Util.getStack() });
        AppMethodBeat.o(21905);
        throw null;
      }
      if (this.rTz != null)
      {
        this.rTz.cuz();
        AppMethodBeat.o(21905);
        return;
        this.rTR = 5;
        this.rTS = 4;
        cuw();
        this.rTO = ((ab)localObject).rVj;
        if (this.rTH != null) {
          this.rTH.onEvent(((ab)localObject).rVj);
        }
        for (;;)
        {
          paramArrayOfByte = a.cuk().cum();
          paramArrayOfByte.rTu += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().a(new b.a()
          {
            public final void run()
            {
              AppMethodBeat.i(21895);
              s locals = new s();
              if (this.rVc)
              {
                locals.rVQ = this.dbSize;
                locals.rWn = (this.rVe - this.dbSize);
                locals.rWm = this.rVd;
                e locale = e.this;
                e.a(6, 0, locals);
                com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
                Log.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).ctM();
                AppMethodBeat.o(21895);
                return;
              }
              if ((this.dbSize > this.rVe) && (this.rVe > 0L))
              {
                locals.rVQ = this.dbSize;
                locals.rWn = (this.rVe - this.dbSize);
              }
              e.a(6, 14, locals);
              Log.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
              AppMethodBeat.o(21895);
            }
          });
          AppMethodBeat.o(21905);
          return;
          Log.i("MicroMsg.BakPcProcessMgr", "callback is null");
        }
        this.rTR = -1;
        this.rTS = 1;
        cuw();
        a(((ab)localObject).rVj, 0, null);
        if (this.rTM != null)
        {
          this.rTM.cancel();
          this.rTM = null;
        }
        if (this.rTL != null) {
          this.rTL.cancel();
        }
        if (this.rTz != null)
        {
          this.rTz.cuz();
          AppMethodBeat.o(21905);
          return;
          a(((ab)localObject).rVj, 0, null);
          if (this.rTK != null)
          {
            this.rTK.pause();
            AppMethodBeat.o(21905);
            return;
            a(((ab)localObject).rVj, 0, null);
            if (this.rTL != null)
            {
              this.rTL.pause();
              AppMethodBeat.o(21905);
              return;
              a(((ab)localObject).rVj, 0, null);
              if (this.rTK != null)
              {
                this.rTK.resume();
                AppMethodBeat.o(21905);
                return;
                a(((ab)localObject).rVj, 0, null);
                if (this.rTL != null)
                {
                  this.rTL.resume();
                  AppMethodBeat.o(21905);
                  return;
                  a.cuk().cun().cuo();
                  a.cuk().cum().bfq();
                  aC(15, null);
                  AppMethodBeat.o(21905);
                  return;
                  a(((ab)localObject).rVj, 0, null);
                  if (this.rTJ != null) {
                    this.rTJ.cuA();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final void aC(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(21904);
        Log.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[] { Integer.valueOf(paramInt), paramString });
        if ((paramInt != 10006) && (paramInt != 10008)) {
          break label391;
        }
        Log.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
        this.rTR = -1;
        this.rTS = 1;
        cuw();
        a.cuk().cum().rTr = 2;
        a.cuk().cum().bfq();
        if (this.rTH != null) {
          this.rTH.kv(paramInt);
        }
        if (this.rTI != null) {
          this.rTI.kv(paramInt);
        }
        if (this.rTz != null) {
          this.rTz.kv(paramInt);
        }
        if (this.rTJ == null) {
          break label391;
        }
        this.rTJ.kv(paramInt);
      }
      finally {}
      Log.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.cuk().cum().rTr = 2;
      a.cuk().cum().bfq();
      cuu();
      AppMethodBeat.o(21904);
      return;
      Log.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.rTI, this.rTz, this.rTH });
      if (paramInt == 15)
      {
        if (this.rTI != null) {
          this.rTI.kv(paramInt);
        }
        if (this.rTz != null) {
          this.rTz.kv(paramInt);
        }
        if (this.rTH != null) {
          this.rTH.EY(paramInt);
        }
      }
      if (paramInt == -1)
      {
        if (this.rTI != null)
        {
          this.rTI.kv(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.rTz != null)
        {
          this.rTz.kv(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.rTH != null) {
          this.rTH.EY(paramInt);
        }
      }
      AppMethodBeat.o(21904);
      continue;
      label391:
      if (paramInt != 10009) {
        if (paramInt != 10004) {}
      }
    }
  }
  
  public final void ctw()
  {
    AppMethodBeat.i(21902);
    if (this.rTL.rUc)
    {
      f localf = this.rTL;
      Log.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.rMp)
      {
        Log.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        AppMethodBeat.o(21902);
        return;
      }
      localf.rTF = 0;
      a.cuk().cul().rTS = 6;
      localf.rMp = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().a(new f.4(localf));
      AppMethodBeat.o(21902);
      return;
    }
    Log.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    AppMethodBeat.o(21902);
  }
  
  public final boolean cus()
  {
    try
    {
      boolean bool = this.rTT;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cut()
  {
    try
    {
      this.rTz = null;
      this.rTK.rTz = null;
      this.rTL.rTz = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int cuv()
  {
    AppMethodBeat.i(21907);
    Log.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.rTS) });
    int i;
    if ((this.rTS == 2) || (this.rTS == 3))
    {
      i = this.rTK.rTE;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.rTS == 4) || (this.rTS == 5))
    {
      i = this.rTL.rUf;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.rTS == 6) || (this.rTS == 7))
    {
      i = this.rTL.rUb;
      AppMethodBeat.o(21907);
      return i;
    }
    Log.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    AppMethodBeat.o(21907);
    return 0;
  }
  
  public final void ff(String paramString1, String paramString2)
  {
    this.rTP = paramString1;
    this.rTQ = paramString2;
  }
  
  public final void kS(boolean paramBoolean)
  {
    try
    {
      this.rTT = paramBoolean;
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
    AppMethodBeat.i(21903);
    if (this.rTO == 1)
    {
      this.rTK.pause();
      AppMethodBeat.o(21903);
      return;
    }
    if (this.rTO == 6) {
      this.rTL.pause();
    }
    AppMethodBeat.o(21903);
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void cux();
  }
  
  public static abstract interface b
  {
    public abstract void kv(int paramInt);
  }
  
  public static abstract interface c
    extends e.b
  {
    public abstract void EY(int paramInt);
    
    public abstract void onEvent(int paramInt);
  }
  
  public static abstract interface d
    extends e.b
  {
    public abstract void EZ(int paramInt);
    
    public abstract void Fa(int paramInt);
    
    public abstract void crY();
    
    public abstract void cuy();
    
    public abstract void cuz();
  }
  
  public static abstract interface e
    extends e.b
  {
    public abstract void cuA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */