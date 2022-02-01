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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.rp;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class e
  implements b.d
{
  private d veP;
  public c veX;
  public a veY;
  public e veZ;
  public d vfa;
  public f vfb;
  com.tencent.mm.plugin.backup.bakoldlogic.c.e vfc;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a vfd;
  public int vfe;
  public String vff;
  public String vfg;
  public int vfh;
  public int vfi;
  private boolean vfj;
  
  public e()
  {
    AppMethodBeat.i(21900);
    this.vfa = new d();
    this.vfb = new f();
    this.vfe = -1;
    this.vfh = -1;
    this.vfi = 1;
    this.vfj = false;
    AppMethodBeat.o(21900);
  }
  
  public static void Fx(int paramInt)
  {
    AppMethodBeat.i(21910);
    ab localab = new ab();
    localab.vgz = paramInt;
    try
    {
      Log.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), Fy(paramInt) });
      com.tencent.mm.plugin.backup.g.b.N(localab.toByteArray(), 3);
      AppMethodBeat.o(21910);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException, "buf to PacketCommandRequest err", new Object[0]);
      AppMethodBeat.o(21910);
    }
  }
  
  private static String Fy(int paramInt)
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
  
  public static void a(int paramInt1, int paramInt2, com.tencent.mm.plugin.backup.i.s params)
  {
    AppMethodBeat.i(21909);
    ac localac = new ac();
    localac.vgz = paramInt1;
    localac.vhk = paramInt2;
    localac.vig = params;
    try
    {
      Log.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Fy(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.N(localac.toByteArray(), 4);
      AppMethodBeat.o(21909);
      return;
    }
    catch (Exception params)
    {
      Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", params, "buf to PacketCommandResponse err", new Object[0]);
      AppMethodBeat.o(21909);
    }
  }
  
  public static void cXe()
  {
    AppMethodBeat.i(21906);
    Object localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_error_notification");
    Context localContext = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21906);
  }
  
  public static void cXg()
  {
    AppMethodBeat.i(21912);
    new rp().publish();
    AppMethodBeat.o(21912);
  }
  
  public final void Fw(int paramInt)
  {
    AppMethodBeat.i(21908);
    if (paramInt == 0) {}
    for (this.vfh = 1; paramInt == 1; this.vfh = -1)
    {
      ac localac = new ac();
      localac.vgz = 0;
      localac.vhk = paramInt;
      try
      {
        Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.vhk) });
        com.tencent.mm.plugin.backup.g.b.N(localac.toByteArray(), 4);
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
    localq.vhv = 0L;
    localq.vhx = Build.MANUFACTURER;
    localq.vgX = com.tencent.mm.compatible.deviceinfo.q.aPo();
    localq.vhw = 0L;
    localq.Version = Build.VERSION.RELEASE;
    Object localObject2 = at.acHq;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new u(com.tencent.mm.loader.i.b.bmt()).jKS())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.aPU())
      {
        localObject3 = new u(com.tencent.mm.loader.i.b.bmz());
        if (!((u)localObject3).jKS())
        {
          localObject1 = localObject2;
          if (!((u)localObject3).jKY()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.loader.i.b.bmz();
        }
      }
    }
    localq.vhu = ((String)localObject1);
    localq.vht = z.bAO();
    localq.vhs = z.bAM();
    localq.vhr = com.tencent.mm.protocal.d.Yxh;
    try
    {
      localObject1 = MMApplicationContext.getContext().getPackageManager().getPackageInfo(MMApplicationContext.getContext().getPackageName(), 0);
      localq.vhr = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.Yxh);
      com.tencent.mm.modelavatar.q.bFp();
      localObject2 = AvatarStorage.LI(localq.vhs);
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
        com.tencent.mm.modelavatar.q.bFp();
        localObject2 = AvatarStorage.R(localq.vhs, true);
        if (localObject1 == null)
        {
          i = 0;
          Log.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!Util.isNullOrNil((byte[])localObject1)) {
            localq.vhy = new com.tencent.mm.bx.b((byte[])localObject1);
          }
          localObject1 = y.bi((String)localObject2, 0, -1);
          if (!Util.isNullOrNil((byte[])localObject1)) {
            localq.vhz = new com.tencent.mm.bx.b((byte[])localObject1);
          }
          localObject1 = new ac();
          ((ac)localObject1).vgz = 0;
          ((ac)localObject1).vhk = paramInt;
          ((ac)localObject1).vic = localq;
        }
        try
        {
          Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((ac)localObject1).vhk) });
          com.tencent.mm.plugin.backup.g.b.N(((ac)localObject1).toByteArray(), 4);
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
    //   13: getfield 465	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:veP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   16: instanceof 467
    //   19: ifeq +20 -> 39
    //   22: ldc 99
    //   24: ldc_w 469
    //   27: invokestatic 472	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: sipush 21901
    //   33: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: ldc 99
    //   41: ldc_w 474
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokestatic 476	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload_1
    //   57: putfield 465	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:veP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   60: aload_0
    //   61: getfield 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfa	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   64: aload_1
    //   65: putfield 477	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   68: aload_0
    //   69: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   72: aload_1
    //   73: putfield 478	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:veP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
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
    //   9: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   19: invokevirtual 482	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   22: aload_0
    //   23: new 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   26: dup
    //   27: invokespecial 74	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   30: putfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   33: aload_0
    //   34: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 488	com/tencent/mm/plugin/backup/i/r:vhA	Ljava/util/LinkedList;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 491	com/tencent/mm/plugin/backup/i/r:vhB	Ljava/util/LinkedList;
    //   49: astore 6
    //   51: aload_1
    //   52: getfield 494	com/tencent/mm/plugin/backup/i/r:vhj	J
    //   55: lstore_2
    //   56: aload 4
    //   58: aload 5
    //   60: putfield 498	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:vfp	Ljava/util/List;
    //   63: aload 4
    //   65: aload 6
    //   67: putfield 501	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nZr	Ljava/util/List;
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 504	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hJi	Z
    //   76: aload 4
    //   78: iconst_0
    //   79: putfield 507	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nzW	Z
    //   82: aload 4
    //   84: getfield 511	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:veO	Ljava/util/HashSet;
    //   87: invokevirtual 516	java/util/HashSet:clear	()V
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 519	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:veR	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 522	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:vfr	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 525	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:uXC	Z
    //   108: aload 4
    //   110: iconst_0
    //   111: putfield 528	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:vfq	I
    //   114: aload 4
    //   116: lconst_0
    //   117: putfield 531	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:vft	J
    //   120: aload 4
    //   122: lload_2
    //   123: putfield 534	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:vfs	J
    //   126: iconst_0
    //   127: invokestatic 539	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   130: aload_0
    //   131: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   134: aload_0
    //   135: getfield 465	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:veP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   138: putfield 478	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:veP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   141: ldc 99
    //   143: ldc_w 541
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: getfield 488	com/tencent/mm/plugin/backup/i/r:vhA	Ljava/util/LinkedList;
    //   156: invokevirtual 547	java/util/LinkedList:size	()I
    //   159: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: getfield 491	com/tencent/mm/plugin/backup/i/r:vhB	Ljava/util/LinkedList;
    //   169: invokevirtual 547	java/util/LinkedList:size	()I
    //   172: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: getfield 494	com/tencent/mm/plugin/backup/i/r:vhj	J
    //   182: invokestatic 552	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:vfb	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 555	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:veV	I
    //   201: aload 4
    //   203: getfield 501	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nZr	Ljava/util/List;
    //   206: invokeinterface 558 1 0
    //   211: aload_1
    //   212: getfield 561	com/tencent/mm/plugin/backup/i/r:vho	I
    //   215: if_icmplt +20 -> 235
    //   218: aload 4
    //   220: getfield 498	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:vfp	Ljava/util/List;
    //   223: invokeinterface 558 1 0
    //   228: aload_1
    //   229: getfield 564	com/tencent/mm/plugin/backup/i/r:vhn	I
    //   232: if_icmpge +46 -> 278
    //   235: iconst_3
    //   236: new 566	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   239: dup
    //   240: aload 4
    //   242: invokespecial 569	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   245: invokestatic 572	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/am/h;)V
    //   248: ldc_w 574
    //   251: ldc_w 576
    //   254: invokestatic 578	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: new 580	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 582	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   265: invokevirtual 585	com/tencent/mm/plugin/backup/bakoldlogic/c/b:cWw	()Z
    //   268: pop
    //   269: sipush 21911
    //   272: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: ldc_w 574
    //   281: ldc_w 587
    //   284: invokestatic 578	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: getstatic 593	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   290: new 595	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1
    //   293: dup
    //   294: aload 4
    //   296: invokespecial 596	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   299: invokeinterface 602 2 0
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
      aP(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.cWU().cWW().veH = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.cWU().uVZ, a.cWU().uWa, com.tencent.mm.plugin.backup.b.d.cUN(), a.cWU().uVY).cWw();
    }
    Object localObject;
    if (paramInt1 == 3)
    {
      this.vfe = -1;
      localObject = new ab();
    }
    for (;;)
    {
      try
      {
        ((ab)localObject).parseFrom(paramArrayOfByte);
        Log.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(((ab)localObject).vgz), Fy(((ab)localObject).vgz) });
        paramInt1 = ((ab)localObject).vgz;
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
      if (!bh.baz())
      {
        Log.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
        a(((ab)localObject).vgz, 1, null);
        AppMethodBeat.o(21905);
        return;
      }
      this.vfe = ((ab)localObject).vgz;
      if (this.veY != null)
      {
        this.veY.cXh();
        this.vfh = 0;
        this.vfi = 1;
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfByte, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      a.cWU().cWX().cWY();
      a.cWU().cWW().bDh();
      aP(-1, null);
      Log.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      AppMethodBeat.o(21905);
      return;
      this.vfi = 2;
      this.vfh = 3;
      cXg();
      a(((ab)localObject).vgz, 0, null);
      paramArrayOfByte = this.vfa;
      com.tencent.threadpool.h.ahAA.bp(new d.1(paramArrayOfByte));
      AppMethodBeat.o(21905);
      return;
      this.vfh = -1;
      this.vfi = 1;
      cXg();
      a(((ab)localObject).vgz, 0, null);
      if (this.vfc != null)
      {
        this.vfc.cancel();
        this.vfc = null;
      }
      if (this.vfa != null) {
        this.vfa.cancel();
      }
      if (this.vfd != null)
      {
        Log.i("MicroMsg.BakCalculator", "calculator cancel.");
        Log.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { Util.getStack() });
        AppMethodBeat.o(21905);
        throw null;
      }
      if (this.veP != null)
      {
        this.veP.cXj();
        AppMethodBeat.o(21905);
        return;
        this.vfh = 5;
        this.vfi = 4;
        cXg();
        this.vfe = ((ab)localObject).vgz;
        if (this.veX != null) {
          this.veX.onEvent(((ab)localObject).vgz);
        }
        for (;;)
        {
          paramArrayOfByte = a.cWU().cWW();
          paramArrayOfByte.veK += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().a(new b.a()
          {
            public final void run()
            {
              AppMethodBeat.i(21895);
              com.tencent.mm.plugin.backup.i.s locals = new com.tencent.mm.plugin.backup.i.s();
              if (this.vgr)
              {
                locals.vhg = this.dbSize;
                locals.vhD = (this.vgt - this.dbSize);
                locals.vhC = this.vgs;
                e locale = e.this;
                e.a(6, 0, locals);
                com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
                Log.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).cWw();
                AppMethodBeat.o(21895);
                return;
              }
              if ((this.dbSize > this.vgt) && (this.vgt > 0L))
              {
                locals.vhg = this.dbSize;
                locals.vhD = (this.vgt - this.dbSize);
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
        this.vfh = -1;
        this.vfi = 1;
        cXg();
        a(((ab)localObject).vgz, 0, null);
        if (this.vfc != null)
        {
          this.vfc.cancel();
          this.vfc = null;
        }
        if (this.vfb != null) {
          this.vfb.cancel();
        }
        if (this.veP != null)
        {
          this.veP.cXj();
          AppMethodBeat.o(21905);
          return;
          a(((ab)localObject).vgz, 0, null);
          if (this.vfa != null)
          {
            this.vfa.pause();
            AppMethodBeat.o(21905);
            return;
            a(((ab)localObject).vgz, 0, null);
            if (this.vfb != null)
            {
              this.vfb.pause();
              AppMethodBeat.o(21905);
              return;
              a(((ab)localObject).vgz, 0, null);
              if (this.vfa != null)
              {
                this.vfa.resume();
                AppMethodBeat.o(21905);
                return;
                a(((ab)localObject).vgz, 0, null);
                if (this.vfb != null)
                {
                  this.vfb.resume();
                  AppMethodBeat.o(21905);
                  return;
                  a.cWU().cWX().cWY();
                  a.cWU().cWW().bDh();
                  aP(15, null);
                  AppMethodBeat.o(21905);
                  return;
                  a(((ab)localObject).vgz, 0, null);
                  if (this.veZ != null) {
                    this.veZ.cXk();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final void aP(int paramInt, String paramString)
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
        this.vfh = -1;
        this.vfi = 1;
        cXg();
        a.cWU().cWW().veH = 2;
        a.cWU().cWW().bDh();
        if (this.veX != null) {
          this.veX.oc(paramInt);
        }
        if (this.veY != null) {
          this.veY.oc(paramInt);
        }
        if (this.veP != null) {
          this.veP.oc(paramInt);
        }
        if (this.veZ == null) {
          break label391;
        }
        this.veZ.oc(paramInt);
      }
      finally {}
      Log.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.cWU().cWW().veH = 2;
      a.cWU().cWW().bDh();
      cXe();
      AppMethodBeat.o(21904);
      return;
      Log.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.veY, this.veP, this.veX });
      if (paramInt == 15)
      {
        if (this.veY != null) {
          this.veY.oc(paramInt);
        }
        if (this.veP != null) {
          this.veP.oc(paramInt);
        }
        if (this.veX != null) {
          this.veX.Fz(paramInt);
        }
      }
      if (paramInt == -1)
      {
        if (this.veY != null)
        {
          this.veY.oc(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.veP != null)
        {
          this.veP.oc(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.veX != null) {
          this.veX.Fz(paramInt);
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
  
  public final void cWg()
  {
    AppMethodBeat.i(21902);
    if (this.vfb.vfr)
    {
      f localf = this.vfb;
      Log.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.uXC)
      {
        Log.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        AppMethodBeat.o(21902);
        return;
      }
      localf.veV = 0;
      a.cWU().cWV().vfi = 6;
      localf.uXC = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().a(new f.4(localf));
      AppMethodBeat.o(21902);
      return;
    }
    Log.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    AppMethodBeat.o(21902);
  }
  
  public final boolean cXc()
  {
    try
    {
      boolean bool = this.vfj;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cXd()
  {
    try
    {
      this.veP = null;
      this.vfa.veP = null;
      this.vfb.veP = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int cXf()
  {
    AppMethodBeat.i(21907);
    Log.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.vfi) });
    int i;
    if ((this.vfi == 2) || (this.vfi == 3))
    {
      i = this.vfa.veU;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.vfi == 4) || (this.vfi == 5))
    {
      i = this.vfb.vfu;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.vfi == 6) || (this.vfi == 7))
    {
      i = this.vfb.vfq;
      AppMethodBeat.o(21907);
      return i;
    }
    Log.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    AppMethodBeat.o(21907);
    return 0;
  }
  
  public final void fw(String paramString1, String paramString2)
  {
    this.vff = paramString1;
    this.vfg = paramString2;
  }
  
  public final void mf(boolean paramBoolean)
  {
    try
    {
      this.vfj = paramBoolean;
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
    if (this.vfe == 1)
    {
      this.vfa.pause();
      AppMethodBeat.o(21903);
      return;
    }
    if (this.vfe == 6) {
      this.vfb.pause();
    }
    AppMethodBeat.o(21903);
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void cXh();
  }
  
  public static abstract interface b
  {
    public abstract void oc(int paramInt);
  }
  
  public static abstract interface c
    extends e.b
  {
    public abstract void Fz(int paramInt);
    
    public abstract void onEvent(int paramInt);
  }
  
  public static abstract interface d
    extends e.b
  {
    public abstract void FA(int paramInt);
    
    public abstract void FB(int paramInt);
    
    public abstract void cUI();
    
    public abstract void cXi();
    
    public abstract void cXj();
  }
  
  public static abstract interface e
    extends e.b
  {
    public abstract void cXk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */