package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class e
  implements b.d
{
  private d oRA;
  public c oRI;
  public a oRJ;
  public e oRK;
  public d oRL;
  public f oRM;
  com.tencent.mm.plugin.backup.bakoldlogic.c.e oRN;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a oRO;
  public int oRP;
  public String oRQ;
  public String oRR;
  public int oRS;
  public int oRT;
  private boolean oRU;
  
  public e()
  {
    AppMethodBeat.i(21900);
    this.oRL = new d();
    this.oRM = new f();
    this.oRP = -1;
    this.oRS = -1;
    this.oRT = 1;
    this.oRU = false;
    AppMethodBeat.o(21900);
  }
  
  public static void Bv(int paramInt)
  {
    AppMethodBeat.i(21910);
    ab localab = new ab();
    localab.oTl = paramInt;
    try
    {
      Log.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), Bw(paramInt) });
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
  
  private static String Bw(int paramInt)
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
    localac.oTl = paramInt1;
    localac.oTW = paramInt2;
    localac.oUQ = params;
    try
    {
      Log.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Bw(paramInt1) });
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
  
  public static void chj()
  {
    AppMethodBeat.i(21906);
    Object localObject = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_error_notification");
    Context localContext = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21906);
  }
  
  public static void chl()
  {
    AppMethodBeat.i(21912);
    pe localpe = new pe();
    EventCenter.instance.publish(localpe);
    AppMethodBeat.o(21912);
  }
  
  public final void Bu(int paramInt)
  {
    AppMethodBeat.i(21908);
    if (paramInt == 0) {}
    for (this.oRS = 1; paramInt == 1; this.oRS = -1)
    {
      ac localac = new ac();
      localac.oTl = 0;
      localac.oTW = paramInt;
      try
      {
        Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.oTW) });
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
    localq.oUh = 0L;
    localq.oUj = Build.MANUFACTURER;
    localq.oTJ = Build.MODEL;
    localq.oUi = 0L;
    localq.Version = Build.VERSION.RELEASE;
    Object localObject2 = ar.NSe;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new o(com.tencent.mm.loader.j.b.aKD()).exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.apn())
      {
        localObject3 = new o(com.tencent.mm.loader.j.b.aKJ());
        if (!((o)localObject3).exists())
        {
          localObject1 = localObject2;
          if (!((o)localObject3).mkdirs()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.loader.j.b.aKJ();
        }
      }
    }
    localq.oUg = ((String)localObject1);
    localq.oUf = z.aUa();
    localq.oUe = z.aTY();
    localq.oUd = com.tencent.mm.protocal.d.KyO;
    try
    {
      localObject1 = MMApplicationContext.getContext().getPackageManager().getPackageInfo(MMApplicationContext.getContext().getPackageName(), 0);
      localq.oUd = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.KyO);
      p.aYn();
      localObject2 = com.tencent.mm.aj.e.Mn(localq.oUe);
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
        p.aYn();
        localObject2 = com.tencent.mm.aj.e.M(localq.oUe, true);
        if (localObject1 == null)
        {
          i = 0;
          Log.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!Util.isNullOrNil((byte[])localObject1)) {
            localq.oUk = new com.tencent.mm.bw.b((byte[])localObject1);
          }
          localObject1 = com.tencent.mm.vfs.s.aW((String)localObject2, 0, -1);
          if (!Util.isNullOrNil((byte[])localObject1)) {
            localq.oUl = new com.tencent.mm.bw.b((byte[])localObject1);
          }
          localObject1 = new ac();
          ((ac)localObject1).oTl = 0;
          ((ac)localObject1).oTW = paramInt;
          ((ac)localObject1).oUN = localq;
        }
        try
        {
          Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((ac)localObject1).oTW) });
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
    //   13: getfield 470	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRA	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   16: instanceof 472
    //   19: ifeq +20 -> 39
    //   22: ldc 99
    //   24: ldc_w 474
    //   27: invokestatic 477	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: sipush 21901
    //   33: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: ldc 99
    //   41: ldc_w 479
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokestatic 481	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload_1
    //   57: putfield 470	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRA	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   60: aload_0
    //   61: getfield 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   64: aload_1
    //   65: putfield 482	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:oRA	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   68: aload_0
    //   69: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRM	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   72: aload_1
    //   73: putfield 483	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oRA	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
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
    //   9: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRM	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRM	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   19: invokevirtual 487	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   22: aload_0
    //   23: new 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   26: dup
    //   27: invokespecial 74	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   30: putfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRM	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   33: aload_0
    //   34: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRM	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 493	com/tencent/mm/plugin/backup/i/r:oUm	Ljava/util/LinkedList;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 496	com/tencent/mm/plugin/backup/i/r:oUn	Ljava/util/LinkedList;
    //   49: astore 6
    //   51: aload_1
    //   52: getfield 499	com/tencent/mm/plugin/backup/i/r:oTV	J
    //   55: lstore_2
    //   56: aload 4
    //   58: aload 5
    //   60: putfield 503	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSa	Ljava/util/List;
    //   63: aload 4
    //   65: aload 6
    //   67: putfield 506	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSb	Ljava/util/List;
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 509	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:dLD	Z
    //   76: aload 4
    //   78: iconst_0
    //   79: putfield 512	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:ifz	Z
    //   82: aload 4
    //   84: getfield 516	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oRz	Ljava/util/HashSet;
    //   87: invokevirtual 521	java/util/HashSet:clear	()V
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 524	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oRC	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 527	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSd	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 530	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oKz	Z
    //   108: aload 4
    //   110: iconst_0
    //   111: putfield 533	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSc	I
    //   114: aload 4
    //   116: lconst_0
    //   117: putfield 536	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSf	J
    //   120: aload 4
    //   122: lload_2
    //   123: putfield 539	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSe	J
    //   126: iconst_0
    //   127: invokestatic 544	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   130: aload_0
    //   131: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRM	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   134: aload_0
    //   135: getfield 470	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRA	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   138: putfield 483	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oRA	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   141: ldc 99
    //   143: ldc_w 546
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: getfield 493	com/tencent/mm/plugin/backup/i/r:oUm	Ljava/util/LinkedList;
    //   156: invokevirtual 552	java/util/LinkedList:size	()I
    //   159: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: getfield 496	com/tencent/mm/plugin/backup/i/r:oUn	Ljava/util/LinkedList;
    //   169: invokevirtual 552	java/util/LinkedList:size	()I
    //   172: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: getfield 499	com/tencent/mm/plugin/backup/i/r:oTV	J
    //   182: invokestatic 557	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:oRM	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 560	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oRG	I
    //   201: aload 4
    //   203: getfield 506	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSb	Ljava/util/List;
    //   206: invokeinterface 563 1 0
    //   211: aload_1
    //   212: getfield 566	com/tencent/mm/plugin/backup/i/r:oUa	I
    //   215: if_icmplt +20 -> 235
    //   218: aload 4
    //   220: getfield 503	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:oSa	Ljava/util/List;
    //   223: invokeinterface 563 1 0
    //   228: aload_1
    //   229: getfield 569	com/tencent/mm/plugin/backup/i/r:oTZ	I
    //   232: if_icmpge +46 -> 278
    //   235: iconst_3
    //   236: new 571	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   239: dup
    //   240: aload 4
    //   242: invokespecial 574	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   245: invokestatic 577	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/ak/i;)V
    //   248: ldc_w 579
    //   251: ldc_w 581
    //   254: invokestatic 583	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: new 585	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 587	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   265: invokevirtual 590	com/tencent/mm/plugin/backup/bakoldlogic/c/b:cgA	()Z
    //   268: pop
    //   269: sipush 21911
    //   272: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: ldc_w 579
    //   281: ldc_w 592
    //   284: invokestatic 583	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: getstatic 598	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   290: new 600	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1
    //   293: dup
    //   294: aload 4
    //   296: invokespecial 601	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   299: invokeinterface 607 2 0
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
      aA(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.cgZ().chb().oRs = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.cgZ().oIV, a.cgZ().oIW, com.tencent.mm.plugin.backup.b.d.ceQ(), a.cgZ().oIU).cgA();
    }
    Object localObject;
    if (paramInt1 == 3)
    {
      this.oRP = -1;
      localObject = new ab();
    }
    for (;;)
    {
      try
      {
        ((ab)localObject).parseFrom(paramArrayOfByte);
        Log.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(((ab)localObject).oTl), Bw(((ab)localObject).oTl) });
        paramInt1 = ((ab)localObject).oTl;
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
      if (!bg.aAc())
      {
        Log.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
        a(((ab)localObject).oTl, 1, null);
        AppMethodBeat.o(21905);
        return;
      }
      this.oRP = ((ab)localObject).oTl;
      if (this.oRJ != null)
      {
        this.oRJ.chm();
        this.oRS = 0;
        this.oRT = 1;
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      a.cgZ().chc().chd();
      a.cgZ().chb().aWm();
      aA(-1, null);
      Log.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      AppMethodBeat.o(21905);
      return;
      this.oRT = 2;
      this.oRS = 3;
      chl();
      a(((ab)localObject).oTl, 0, null);
      paramArrayOfByte = this.oRL;
      h.RTc.ba(new d.1(paramArrayOfByte));
      AppMethodBeat.o(21905);
      return;
      this.oRS = -1;
      this.oRT = 1;
      chl();
      a(((ab)localObject).oTl, 0, null);
      if (this.oRN != null)
      {
        this.oRN.cancel();
        this.oRN = null;
      }
      if (this.oRL != null) {
        this.oRL.cancel();
      }
      if (this.oRO != null)
      {
        paramArrayOfByte = this.oRO;
        Log.i("MicroMsg.BakCalculator", "calculator cancel.");
        Log.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { Util.getStack() });
        paramArrayOfByte.ifz = true;
        this.oRO = null;
      }
      if (this.oRA != null)
      {
        this.oRA.cho();
        AppMethodBeat.o(21905);
        return;
        this.oRS = 5;
        this.oRT = 4;
        chl();
        this.oRP = ((ab)localObject).oTl;
        if (this.oRI != null) {
          this.oRI.onEvent(((ab)localObject).oTl);
        }
        for (;;)
        {
          paramArrayOfByte = a.cgZ().chb();
          paramArrayOfByte.oRv += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().a(new b.a()
          {
            public final void run()
            {
              AppMethodBeat.i(21895);
              com.tencent.mm.plugin.backup.i.s locals = new com.tencent.mm.plugin.backup.i.s();
              if (this.oTe)
              {
                locals.oTS = this.dbSize;
                locals.oUp = (this.oTg - this.dbSize);
                locals.oUo = this.oTf;
                e locale = e.this;
                e.a(6, 0, locals);
                com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
                Log.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).cgA();
                AppMethodBeat.o(21895);
                return;
              }
              if ((this.dbSize > this.oTg) && (this.oTg > 0L))
              {
                locals.oTS = this.dbSize;
                locals.oUp = (this.oTg - this.dbSize);
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
        this.oRS = -1;
        this.oRT = 1;
        chl();
        a(((ab)localObject).oTl, 0, null);
        if (this.oRN != null)
        {
          this.oRN.cancel();
          this.oRN = null;
        }
        if (this.oRM != null) {
          this.oRM.cancel();
        }
        if (this.oRA != null)
        {
          this.oRA.cho();
          AppMethodBeat.o(21905);
          return;
          a(((ab)localObject).oTl, 0, null);
          if (this.oRL != null)
          {
            this.oRL.pause();
            AppMethodBeat.o(21905);
            return;
            a(((ab)localObject).oTl, 0, null);
            if (this.oRM != null)
            {
              this.oRM.pause();
              AppMethodBeat.o(21905);
              return;
              a(((ab)localObject).oTl, 0, null);
              if (this.oRL != null)
              {
                this.oRL.resume();
                AppMethodBeat.o(21905);
                return;
                a(((ab)localObject).oTl, 0, null);
                if (this.oRM != null)
                {
                  this.oRM.resume();
                  AppMethodBeat.o(21905);
                  return;
                  a.cgZ().chc().chd();
                  a.cgZ().chb().aWm();
                  aA(15, null);
                  AppMethodBeat.o(21905);
                  return;
                  a(((ab)localObject).oTl, 0, null);
                  if (this.oRK != null) {
                    this.oRK.chp();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final void aA(int paramInt, String paramString)
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
        this.oRS = -1;
        this.oRT = 1;
        chl();
        a.cgZ().chb().oRs = 2;
        a.cgZ().chb().aWm();
        if (this.oRI != null) {
          this.oRI.onError(paramInt);
        }
        if (this.oRJ != null) {
          this.oRJ.onError(paramInt);
        }
        if (this.oRA != null) {
          this.oRA.onError(paramInt);
        }
        if (this.oRK == null) {
          break label391;
        }
        this.oRK.onError(paramInt);
      }
      finally {}
      Log.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.cgZ().chb().oRs = 2;
      a.cgZ().chb().aWm();
      chj();
      AppMethodBeat.o(21904);
      return;
      Log.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.oRJ, this.oRA, this.oRI });
      if (paramInt == 15)
      {
        if (this.oRJ != null) {
          this.oRJ.onError(paramInt);
        }
        if (this.oRA != null) {
          this.oRA.onError(paramInt);
        }
        if (this.oRI != null) {
          this.oRI.Bx(paramInt);
        }
      }
      if (paramInt == -1)
      {
        if (this.oRJ != null)
        {
          this.oRJ.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.oRA != null)
        {
          this.oRA.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.oRI != null) {
          this.oRI.Bx(paramInt);
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
  
  public final void cgk()
  {
    AppMethodBeat.i(21902);
    if (this.oRM.oSd)
    {
      f localf = this.oRM;
      Log.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.oKz)
      {
        Log.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        AppMethodBeat.o(21902);
        return;
      }
      localf.oRG = 0;
      a.cgZ().cha().oRT = 6;
      localf.oKz = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().a(new f.4(localf));
      AppMethodBeat.o(21902);
      return;
    }
    Log.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    AppMethodBeat.o(21902);
  }
  
  public final boolean chh()
  {
    try
    {
      boolean bool = this.oRU;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void chi()
  {
    try
    {
      this.oRA = null;
      this.oRL.oRA = null;
      this.oRM.oRA = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int chk()
  {
    AppMethodBeat.i(21907);
    Log.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.oRT) });
    int i;
    if ((this.oRT == 2) || (this.oRT == 3))
    {
      i = this.oRL.oRF;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.oRT == 4) || (this.oRT == 5))
    {
      i = this.oRM.oSg;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.oRT == 6) || (this.oRT == 7))
    {
      i = this.oRM.oSc;
      AppMethodBeat.o(21907);
      return i;
    }
    Log.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    AppMethodBeat.o(21907);
    return 0;
  }
  
  public final void eR(String paramString1, String paramString2)
  {
    this.oRQ = paramString1;
    this.oRR = paramString2;
  }
  
  public final void jH(boolean paramBoolean)
  {
    try
    {
      this.oRU = paramBoolean;
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
    if (this.oRP == 1)
    {
      this.oRL.pause();
      AppMethodBeat.o(21903);
      return;
    }
    if (this.oRP == 6) {
      this.oRM.pause();
    }
    AppMethodBeat.o(21903);
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void chm();
  }
  
  public static abstract interface b
  {
    public abstract void onError(int paramInt);
  }
  
  public static abstract interface c
    extends e.b
  {
    public abstract void Bx(int paramInt);
    
    public abstract void onEvent(int paramInt);
  }
  
  public static abstract interface d
    extends e.b
  {
    public abstract void By(int paramInt);
    
    public abstract void Bz(int paramInt);
    
    public abstract void ceL();
    
    public abstract void chn();
    
    public abstract void cho();
  }
  
  public static abstract interface e
    extends e.b
  {
    public abstract void chp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */