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
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.od;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class e
  implements b.d
{
  private d naL;
  public c naT;
  public a naU;
  public e naV;
  public d naW;
  public f naX;
  com.tencent.mm.plugin.backup.bakoldlogic.c.e naY;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a naZ;
  public int nba;
  public String nbb;
  public String nbc;
  public int nbd;
  public int nbe;
  private boolean nbf;
  
  public e()
  {
    AppMethodBeat.i(21900);
    this.naW = new d();
    this.naX = new f();
    this.nba = -1;
    this.nbd = -1;
    this.nbe = 1;
    this.nbf = false;
    AppMethodBeat.o(21900);
  }
  
  public static void a(int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(21909);
    com.tencent.mm.plugin.backup.i.ac localac = new com.tencent.mm.plugin.backup.i.ac();
    localac.ncx = paramInt1;
    localac.ndj = paramInt2;
    localac.ned = params;
    try
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), xg(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.L(localac.toByteArray(), 4);
      AppMethodBeat.o(21909);
      return;
    }
    catch (Exception params)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BakPcProcessMgr", params, "buf to PacketCommandResponse err", new Object[0]);
      AppMethodBeat.o(21909);
    }
  }
  
  public static void bFj()
  {
    AppMethodBeat.i(21906);
    Object localObject = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_error_notification");
    Context localContext = ai.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21906);
  }
  
  public static void bFl()
  {
    AppMethodBeat.i(21912);
    od localod = new od();
    com.tencent.mm.sdk.b.a.GpY.l(localod);
    AppMethodBeat.o(21912);
  }
  
  public static void xf(int paramInt)
  {
    AppMethodBeat.i(21910);
    ab localab = new ab();
    localab.ncx = paramInt;
    try
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), xg(paramInt) });
      com.tencent.mm.plugin.backup.g.b.L(localab.toByteArray(), 3);
      AppMethodBeat.o(21910);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException, "buf to PacketCommandRequest err", new Object[0]);
      AppMethodBeat.o(21910);
    }
  }
  
  private static String xg(int paramInt)
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
    //   13: getfield 275	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   16: instanceof 277
    //   19: ifeq +20 -> 39
    //   22: ldc 106
    //   24: ldc_w 279
    //   27: invokestatic 282	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: sipush 21901
    //   33: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: ldc 106
    //   41: ldc_w 284
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokestatic 286	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload_1
    //   57: putfield 275	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   60: aload_0
    //   61: getfield 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   64: aload_1
    //   65: putfield 287	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:naL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   68: aload_0
    //   69: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naX	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   72: aload_1
    //   73: putfield 288	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:naL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
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
    //   9: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naX	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naX	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   19: invokevirtual 292	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   22: aload_0
    //   23: new 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   26: dup
    //   27: invokespecial 74	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   30: putfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naX	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   33: aload_0
    //   34: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naX	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 298	com/tencent/mm/plugin/backup/i/r:ndz	Ljava/util/LinkedList;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 301	com/tencent/mm/plugin/backup/i/r:ndA	Ljava/util/LinkedList;
    //   49: astore 6
    //   51: aload_1
    //   52: getfield 305	com/tencent/mm/plugin/backup/i/r:ndi	J
    //   55: lstore_2
    //   56: aload 4
    //   58: aload 5
    //   60: putfield 309	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbl	Ljava/util/List;
    //   63: aload 4
    //   65: aload 6
    //   67: putfield 312	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbm	Ljava/util/List;
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 315	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:dhO	Z
    //   76: aload 4
    //   78: iconst_0
    //   79: putfield 318	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:gRx	Z
    //   82: aload 4
    //   84: getfield 322	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:naK	Ljava/util/HashSet;
    //   87: invokevirtual 327	java/util/HashSet:clear	()V
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 330	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:naN	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 333	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbo	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 336	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mTI	Z
    //   108: aload 4
    //   110: iconst_0
    //   111: putfield 339	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbn	I
    //   114: aload 4
    //   116: lconst_0
    //   117: putfield 342	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbq	J
    //   120: aload 4
    //   122: lload_2
    //   123: putfield 345	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbp	J
    //   126: iconst_0
    //   127: invokestatic 350	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   130: aload_0
    //   131: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naX	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   134: aload_0
    //   135: getfield 275	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   138: putfield 288	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:naL	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   141: ldc 106
    //   143: ldc_w 352
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: getfield 298	com/tencent/mm/plugin/backup/i/r:ndz	Ljava/util/LinkedList;
    //   156: invokevirtual 358	java/util/LinkedList:size	()I
    //   159: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: getfield 301	com/tencent/mm/plugin/backup/i/r:ndA	Ljava/util/LinkedList;
    //   169: invokevirtual 358	java/util/LinkedList:size	()I
    //   172: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: getfield 305	com/tencent/mm/plugin/backup/i/r:ndi	J
    //   182: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 123	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:naX	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 366	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:naR	I
    //   201: aload 4
    //   203: getfield 312	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbm	Ljava/util/List;
    //   206: invokeinterface 369 1 0
    //   211: aload_1
    //   212: getfield 372	com/tencent/mm/plugin/backup/i/r:ndn	I
    //   215: if_icmplt +20 -> 235
    //   218: aload 4
    //   220: getfield 309	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nbl	Ljava/util/List;
    //   223: invokeinterface 369 1 0
    //   228: aload_1
    //   229: getfield 375	com/tencent/mm/plugin/backup/i/r:ndm	I
    //   232: if_icmpge +46 -> 278
    //   235: iconst_3
    //   236: new 377	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   239: dup
    //   240: aload 4
    //   242: invokespecial 380	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   245: invokestatic 383	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/ak/g;)V
    //   248: ldc_w 385
    //   251: ldc_w 387
    //   254: invokestatic 389	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: new 391	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 393	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   265: invokevirtual 397	com/tencent/mm/plugin/backup/bakoldlogic/c/b:bEA	()Z
    //   268: pop
    //   269: sipush 21911
    //   272: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: ldc_w 385
    //   281: ldc_w 399
    //   284: invokestatic 389	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: getstatic 405	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   290: new 407	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1
    //   293: dup
    //   294: aload 4
    //   296: invokespecial 408	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   299: invokeinterface 414 2 0
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
      aw(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.bEZ().bFb().naD = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.bEZ().mSd, a.bEZ().mSe, com.tencent.mm.plugin.backup.b.d.bCT(), a.bEZ().mSc).bEA();
    }
    Object localObject;
    if (paramInt1 == 3)
    {
      this.nba = -1;
      localObject = new ab();
    }
    for (;;)
    {
      try
      {
        ((ab)localObject).parseFrom(paramArrayOfByte);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(((ab)localObject).ncx), xg(((ab)localObject).ncx) });
        paramInt1 = ((ab)localObject).ncx;
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
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BakPcProcessMgr", paramArrayOfByte, "buf to PacketCommandReq error", new Object[0]);
      }
      if (!az.agM())
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
        a(((ab)localObject).ncx, 1, null);
        AppMethodBeat.o(21905);
        return;
      }
      this.nba = ((ab)localObject).ncx;
      if (this.naU != null)
      {
        this.naU.bFm();
        this.nbd = 0;
        this.nbe = 1;
        AppMethodBeat.o(21905);
        return;
        AppMethodBeat.o(21905);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
      localObject = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
      ((Intent)localObject).putExtra("newPCBackup", false);
      paramArrayOfByte = ai.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      a.bEZ().bFc().bFd();
      a.bEZ().bFb().azv();
      aw(-1, null);
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      AppMethodBeat.o(21905);
      return;
      this.nbe = 2;
      this.nbd = 3;
      bFl();
      a(((ab)localObject).ncx, 0, null);
      paramArrayOfByte = this.naW;
      h.JZN.aV(new d.1(paramArrayOfByte));
      AppMethodBeat.o(21905);
      return;
      this.nbd = -1;
      this.nbe = 1;
      bFl();
      a(((ab)localObject).ncx, 0, null);
      if (this.naY != null)
      {
        this.naY.cancel();
        this.naY = null;
      }
      if (this.naW != null) {
        this.naW.cancel();
      }
      if (this.naZ != null)
      {
        paramArrayOfByte = this.naZ;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakCalculator", "calculator cancel.");
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { bs.eWi() });
        paramArrayOfByte.gRx = true;
        this.naZ = null;
      }
      if (this.naL != null)
      {
        this.naL.bFo();
        AppMethodBeat.o(21905);
        return;
        this.nbd = 5;
        this.nbe = 4;
        bFl();
        this.nba = ((ab)localObject).ncx;
        if (this.naT != null) {
          this.naT.onEvent(((ab)localObject).ncx);
        }
        for (;;)
        {
          paramArrayOfByte = a.bEZ().bFb();
          paramArrayOfByte.naG += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().a(new b.a()
          {
            public final void run()
            {
              AppMethodBeat.i(21895);
              s locals = new s();
              if (this.ncq)
              {
                locals.ndf = this.dbSize;
                locals.ndC = (this.ncs - this.dbSize);
                locals.ndB = this.ncr;
                e locale = e.this;
                e.a(6, 0, locals);
                com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).bEA();
                AppMethodBeat.o(21895);
                return;
              }
              if ((this.dbSize > this.ncs) && (this.ncs > 0L))
              {
                locals.ndf = this.dbSize;
                locals.ndC = (this.ncs - this.dbSize);
              }
              e.a(6, 14, locals);
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
              AppMethodBeat.o(21895);
            }
          });
          AppMethodBeat.o(21905);
          return;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "callback is null");
        }
        this.nbd = -1;
        this.nbe = 1;
        bFl();
        a(((ab)localObject).ncx, 0, null);
        if (this.naY != null)
        {
          this.naY.cancel();
          this.naY = null;
        }
        if (this.naX != null) {
          this.naX.cancel();
        }
        if (this.naL != null)
        {
          this.naL.bFo();
          AppMethodBeat.o(21905);
          return;
          a(((ab)localObject).ncx, 0, null);
          if (this.naW != null)
          {
            this.naW.pause();
            AppMethodBeat.o(21905);
            return;
            a(((ab)localObject).ncx, 0, null);
            if (this.naX != null)
            {
              this.naX.pause();
              AppMethodBeat.o(21905);
              return;
              a(((ab)localObject).ncx, 0, null);
              if (this.naW != null)
              {
                this.naW.resume();
                AppMethodBeat.o(21905);
                return;
                a(((ab)localObject).ncx, 0, null);
                if (this.naX != null)
                {
                  this.naX.resume();
                  AppMethodBeat.o(21905);
                  return;
                  a.bEZ().bFc().bFd();
                  a.bEZ().bFb().azv();
                  aw(15, null);
                  AppMethodBeat.o(21905);
                  return;
                  a(((ab)localObject).ncx, 0, null);
                  if (this.naV != null) {
                    this.naV.bFp();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final void aw(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(21904);
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[] { Integer.valueOf(paramInt), paramString });
        if ((paramInt != 10006) && (paramInt != 10008)) {
          break label391;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
        this.nbd = -1;
        this.nbe = 1;
        bFl();
        a.bEZ().bFb().naD = 2;
        a.bEZ().bFb().azv();
        if (this.naT != null) {
          this.naT.onError(paramInt);
        }
        if (this.naU != null) {
          this.naU.onError(paramInt);
        }
        if (this.naL != null) {
          this.naL.onError(paramInt);
        }
        if (this.naV == null) {
          break label391;
        }
        this.naV.onError(paramInt);
      }
      finally {}
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.bEZ().bFb().naD = 2;
      a.bEZ().bFb().azv();
      bFj();
      AppMethodBeat.o(21904);
      return;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.naU, this.naL, this.naT });
      if (paramInt == 15)
      {
        if (this.naU != null) {
          this.naU.onError(paramInt);
        }
        if (this.naL != null) {
          this.naL.onError(paramInt);
        }
        if (this.naT != null) {
          this.naT.xh(paramInt);
        }
      }
      if (paramInt == -1)
      {
        if (this.naU != null)
        {
          this.naU.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.naL != null)
        {
          this.naL.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.naT != null) {
          this.naT.xh(paramInt);
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
  
  public final void bEk()
  {
    AppMethodBeat.i(21902);
    if (this.naX.nbo)
    {
      f localf = this.naX;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.mTI)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        AppMethodBeat.o(21902);
        return;
      }
      localf.naR = 0;
      a.bEZ().bFa().nbe = 6;
      localf.mTI = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().a(new f.4(localf));
      AppMethodBeat.o(21902);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    AppMethodBeat.o(21902);
  }
  
  public final boolean bFh()
  {
    try
    {
      boolean bool = this.nbf;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bFi()
  {
    try
    {
      this.naL = null;
      this.naW.naL = null;
      this.naX.naL = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bFk()
  {
    AppMethodBeat.i(21907);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.nbe) });
    int i;
    if ((this.nbe == 2) || (this.nbe == 3))
    {
      i = this.naW.naQ;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.nbe == 4) || (this.nbe == 5))
    {
      i = this.naX.nbr;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.nbe == 6) || (this.nbe == 7))
    {
      i = this.naX.nbn;
      AppMethodBeat.o(21907);
      return i;
    }
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    AppMethodBeat.o(21907);
    return 0;
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    this.nbb = paramString1;
    this.nbc = paramString2;
  }
  
  public final void iz(boolean paramBoolean)
  {
    try
    {
      this.nbf = paramBoolean;
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
    if (this.nba == 1)
    {
      this.naW.pause();
      AppMethodBeat.o(21903);
      return;
    }
    if (this.nba == 6) {
      this.naX.pause();
    }
    AppMethodBeat.o(21903);
  }
  
  public final void xe(int paramInt)
  {
    AppMethodBeat.i(21908);
    if (paramInt == 0) {}
    for (this.nbd = 1; paramInt == 1; this.nbd = -1)
    {
      com.tencent.mm.plugin.backup.i.ac localac = new com.tencent.mm.plugin.backup.i.ac();
      localac.ncx = 0;
      localac.ndj = paramInt;
      try
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.ndj) });
        com.tencent.mm.plugin.backup.g.b.L(localac.toByteArray(), 4);
        AppMethodBeat.o(21908);
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException1, "buf to PacketCommandResponse err", new Object[0]);
        AppMethodBeat.o(21908);
        return;
      }
    }
    com.tencent.mm.plugin.backup.i.q localq = new com.tencent.mm.plugin.backup.i.q();
    localq.ndu = 0L;
    localq.ndw = Build.MANUFACTURER;
    localq.ncW = Build.MODEL;
    localq.ndv = 0L;
    localq.Version = Build.VERSION.RELEASE;
    Object localObject2 = ah.GDu;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apb()).exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.YD())
      {
        localObject3 = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aph());
        if (!((com.tencent.mm.vfs.e)localObject3).exists())
        {
          localObject1 = localObject2;
          if (!((com.tencent.mm.vfs.e)localObject3).mkdirs()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.loader.j.b.aph();
        }
      }
    }
    localq.ndt = ((String)localObject1);
    localq.nds = u.axy();
    localq.ndr = u.axw();
    localq.ndq = com.tencent.mm.protocal.d.DIc;
    try
    {
      localObject1 = ai.getContext().getPackageManager().getPackageInfo(ai.getContext().getPackageName(), 0);
      localq.ndq = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.DIc);
      p.aBh();
      localObject2 = com.tencent.mm.aj.e.Ab(localq.ndr);
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
        p.aBh();
        localObject2 = com.tencent.mm.aj.e.K(localq.ndr, true);
        if (localObject1 == null)
        {
          i = 0;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!bs.cv((byte[])localObject1)) {
            localq.ndx = new com.tencent.mm.bw.b((byte[])localObject1);
          }
          localObject1 = com.tencent.mm.vfs.i.aU((String)localObject2, 0, -1);
          if (!bs.cv((byte[])localObject1)) {
            localq.ndy = new com.tencent.mm.bw.b((byte[])localObject1);
          }
          localObject1 = new com.tencent.mm.plugin.backup.i.ac();
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).ncx = 0;
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).ndj = paramInt;
          ((com.tencent.mm.plugin.backup.i.ac)localObject1).nea = localq;
        }
        try
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.ac)localObject1).ndj) });
          com.tencent.mm.plugin.backup.g.b.L(((com.tencent.mm.plugin.backup.i.ac)localObject1).toByteArray(), 4);
          AppMethodBeat.o(21908);
          return;
        }
        catch (Exception localException3)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException3, "buf to PacketCommandResponse err", new Object[0]);
          AppMethodBeat.o(21908);
        }
        localException2 = localException2;
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException2, "get packageInfo failed", new Object[0]);
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException4, "close", new Object[0]);
          continue;
          int i = localException2.length;
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void bFm();
  }
  
  public static abstract interface b
  {
    public abstract void onError(int paramInt);
  }
  
  public static abstract interface c
    extends e.b
  {
    public abstract void onEvent(int paramInt);
    
    public abstract void xh(int paramInt);
  }
  
  public static abstract interface d
    extends e.b
  {
    public abstract void bCO();
    
    public abstract void bFn();
    
    public abstract void bFo();
    
    public abstract void xi(int paramInt);
    
    public abstract void xj(int paramInt);
  }
  
  public static abstract interface e
    extends e.b
  {
    public abstract void bFp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */