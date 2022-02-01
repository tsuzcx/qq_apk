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
import com.tencent.mm.ak.p;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class e
  implements b.d
{
  private d myK;
  public c myS;
  public a myT;
  public e myU;
  public d myV;
  public f myW;
  com.tencent.mm.plugin.backup.bakoldlogic.c.e myX;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a myY;
  public int myZ;
  public String mza;
  public String mzb;
  public int mzc;
  public int mzd;
  private boolean mze;
  
  public e()
  {
    AppMethodBeat.i(21900);
    this.myV = new d();
    this.myW = new f();
    this.myZ = -1;
    this.mzc = -1;
    this.mzd = 1;
    this.mze = false;
    AppMethodBeat.o(21900);
  }
  
  public static void a(int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(21909);
    ac localac = new ac();
    localac.mAw = paramInt1;
    localac.mBi = paramInt2;
    localac.mCc = params;
    try
    {
      ad.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), wp(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.N(localac.toByteArray(), 4);
      AppMethodBeat.o(21909);
      return;
    }
    catch (Exception params)
    {
      ad.printErrStackTrace("MicroMsg.BakPcProcessMgr", params, "buf to PacketCommandResponse err", new Object[0]);
      AppMethodBeat.o(21909);
    }
  }
  
  public static void byn()
  {
    AppMethodBeat.i(21906);
    Object localObject = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_error_notification");
    Context localContext = aj.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21906);
  }
  
  public static void byp()
  {
    AppMethodBeat.i(21912);
    nu localnu = new nu();
    com.tencent.mm.sdk.b.a.ESL.l(localnu);
    AppMethodBeat.o(21912);
  }
  
  public static void wo(int paramInt)
  {
    AppMethodBeat.i(21910);
    ab localab = new ab();
    localab.mAw = paramInt;
    try
    {
      ad.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), wp(paramInt) });
      com.tencent.mm.plugin.backup.g.b.N(localab.toByteArray(), 3);
      AppMethodBeat.o(21910);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException, "buf to PacketCommandRequest err", new Object[0]);
      AppMethodBeat.o(21910);
    }
  }
  
  private static String wp(int paramInt)
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
    //   5: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +30 -> 39
    //   12: aload_0
    //   13: getfield 272	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myK	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   16: instanceof 274
    //   19: ifeq +20 -> 39
    //   22: ldc 103
    //   24: ldc_w 276
    //   27: invokestatic 279	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: sipush 21901
    //   33: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: ldc 103
    //   41: ldc_w 281
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokestatic 283	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload_1
    //   57: putfield 272	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myK	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   60: aload_0
    //   61: getfield 68	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myV	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   64: aload_1
    //   65: putfield 284	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:myK	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   68: aload_0
    //   69: getfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   72: aload_1
    //   73: putfield 285	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:myK	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   76: sipush 21901
    //   79: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   5: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   19: invokevirtual 289	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   22: aload_0
    //   23: new 70	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   26: dup
    //   27: invokespecial 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   30: putfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   33: aload_0
    //   34: getfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 295	com/tencent/mm/plugin/backup/i/r:mBy	Ljava/util/LinkedList;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 298	com/tencent/mm/plugin/backup/i/r:mBz	Ljava/util/LinkedList;
    //   49: astore 6
    //   51: aload_1
    //   52: getfield 302	com/tencent/mm/plugin/backup/i/r:mBh	J
    //   55: lstore_2
    //   56: aload 4
    //   58: aload 5
    //   60: putfield 306	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzk	Ljava/util/List;
    //   63: aload 4
    //   65: aload 6
    //   67: putfield 309	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzl	Ljava/util/List;
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 312	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:dkt	Z
    //   76: aload 4
    //   78: iconst_0
    //   79: putfield 315	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:gqP	Z
    //   82: aload 4
    //   84: getfield 319	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:myJ	Ljava/util/HashSet;
    //   87: invokevirtual 324	java/util/HashSet:clear	()V
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 327	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:myM	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 330	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzn	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 333	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mrG	Z
    //   108: aload 4
    //   110: iconst_0
    //   111: putfield 336	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzm	I
    //   114: aload 4
    //   116: lconst_0
    //   117: putfield 339	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzp	J
    //   120: aload 4
    //   122: lload_2
    //   123: putfield 342	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzo	J
    //   126: iconst_0
    //   127: invokestatic 347	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   130: aload_0
    //   131: getfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   134: aload_0
    //   135: getfield 272	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myK	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   138: putfield 285	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:myK	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   141: ldc 103
    //   143: ldc_w 349
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: getfield 295	com/tencent/mm/plugin/backup/i/r:mBy	Ljava/util/LinkedList;
    //   156: invokevirtual 355	java/util/LinkedList:size	()I
    //   159: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: getfield 298	com/tencent/mm/plugin/backup/i/r:mBz	Ljava/util/LinkedList;
    //   169: invokevirtual 355	java/util/LinkedList:size	()I
    //   172: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: getfield 302	com/tencent/mm/plugin/backup/i/r:mBh	J
    //   182: invokestatic 360	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 120	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:myW	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 363	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:myQ	I
    //   201: aload 4
    //   203: getfield 309	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzl	Ljava/util/List;
    //   206: invokeinterface 366 1 0
    //   211: aload_1
    //   212: getfield 369	com/tencent/mm/plugin/backup/i/r:mBm	I
    //   215: if_icmplt +20 -> 235
    //   218: aload 4
    //   220: getfield 306	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:mzk	Ljava/util/List;
    //   223: invokeinterface 366 1 0
    //   228: aload_1
    //   229: getfield 372	com/tencent/mm/plugin/backup/i/r:mBl	I
    //   232: if_icmpge +46 -> 278
    //   235: iconst_3
    //   236: new 374	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   239: dup
    //   240: aload 4
    //   242: invokespecial 377	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   245: invokestatic 380	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/al/g;)V
    //   248: ldc_w 382
    //   251: ldc_w 384
    //   254: invokestatic 386	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: new 388	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 390	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   265: invokevirtual 394	com/tencent/mm/plugin/backup/bakoldlogic/c/b:bxE	()Z
    //   268: pop
    //   269: sipush 21911
    //   272: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: ldc_w 382
    //   281: ldc_w 396
    //   284: invokestatic 386	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: getstatic 402	com/tencent/e/h:Iye	Lcom/tencent/e/i;
    //   290: new 404	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1
    //   293: dup
    //   294: aload 4
    //   296: invokespecial 405	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$1:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   299: invokeinterface 411 2 0
    //   304: pop
    //   305: sipush 21911
    //   308: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      av(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.byd().byf().myC = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.byd().mqc, a.byd().mqd, com.tencent.mm.plugin.backup.b.d.bvX(), a.byd().mqb).bxE();
    }
    Object localObject;
    if (paramInt1 == 3)
    {
      this.myZ = -1;
      localObject = new ab();
    }
    for (;;)
    {
      try
      {
        ((ab)localObject).parseFrom(paramArrayOfByte);
        ad.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(((ab)localObject).mAw), wp(((ab)localObject).mAw) });
        paramInt1 = ((ab)localObject).mAw;
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
        ad.printErrStackTrace("MicroMsg.BakPcProcessMgr", paramArrayOfByte, "buf to PacketCommandReq error", new Object[0]);
      }
      if (!az.afw())
      {
        ad.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
        a(((ab)localObject).mAw, 1, null);
        AppMethodBeat.o(21905);
        return;
      }
      this.myZ = ((ab)localObject).mAw;
      if (this.myT != null)
      {
        this.myT.byq();
        this.mzc = 0;
        this.mzd = 1;
        AppMethodBeat.o(21905);
        return;
        AppMethodBeat.o(21905);
        return;
      }
      ad.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
      localObject = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
      ((Intent)localObject).putExtra("newPCBackup", false);
      paramArrayOfByte = aj.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      a.byd().byg().byh();
      a.byd().byf().asE();
      av(-1, null);
      ad.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      AppMethodBeat.o(21905);
      return;
      this.mzd = 2;
      this.mzc = 3;
      byp();
      a(((ab)localObject).mAw, 0, null);
      paramArrayOfByte = this.myV;
      h.Iye.aS(new d.1(paramArrayOfByte));
      AppMethodBeat.o(21905);
      return;
      this.mzc = -1;
      this.mzd = 1;
      byp();
      a(((ab)localObject).mAw, 0, null);
      if (this.myX != null)
      {
        this.myX.cancel();
        this.myX = null;
      }
      if (this.myV != null) {
        this.myV.cancel();
      }
      if (this.myY != null)
      {
        paramArrayOfByte = this.myY;
        ad.i("MicroMsg.BakCalculator", "calculator cancel.");
        ad.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { bt.eGN() });
        paramArrayOfByte.gqP = true;
        this.myY = null;
      }
      if (this.myK != null)
      {
        this.myK.bys();
        AppMethodBeat.o(21905);
        return;
        this.mzc = 5;
        this.mzd = 4;
        byp();
        this.myZ = ((ab)localObject).mAw;
        if (this.myS != null) {
          this.myS.onEvent(((ab)localObject).mAw);
        }
        for (;;)
        {
          paramArrayOfByte = a.byd().byf();
          paramArrayOfByte.myF += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().a(new b.a()
          {
            public final void run()
            {
              AppMethodBeat.i(21895);
              s locals = new s();
              if (this.mAp)
              {
                locals.mBe = this.dbSize;
                locals.mBB = (this.mAr - this.dbSize);
                locals.mBA = this.mAq;
                e locale = e.this;
                e.a(6, 0, locals);
                com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
                ad.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).bxE();
                AppMethodBeat.o(21895);
                return;
              }
              if ((this.dbSize > this.mAr) && (this.mAr > 0L))
              {
                locals.mBe = this.dbSize;
                locals.mBB = (this.mAr - this.dbSize);
              }
              e.a(6, 14, locals);
              ad.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
              AppMethodBeat.o(21895);
            }
          });
          AppMethodBeat.o(21905);
          return;
          ad.i("MicroMsg.BakPcProcessMgr", "callback is null");
        }
        this.mzc = -1;
        this.mzd = 1;
        byp();
        a(((ab)localObject).mAw, 0, null);
        if (this.myX != null)
        {
          this.myX.cancel();
          this.myX = null;
        }
        if (this.myW != null) {
          this.myW.cancel();
        }
        if (this.myK != null)
        {
          this.myK.bys();
          AppMethodBeat.o(21905);
          return;
          a(((ab)localObject).mAw, 0, null);
          if (this.myV != null)
          {
            this.myV.pause();
            AppMethodBeat.o(21905);
            return;
            a(((ab)localObject).mAw, 0, null);
            if (this.myW != null)
            {
              this.myW.pause();
              AppMethodBeat.o(21905);
              return;
              a(((ab)localObject).mAw, 0, null);
              if (this.myV != null)
              {
                this.myV.resume();
                AppMethodBeat.o(21905);
                return;
                a(((ab)localObject).mAw, 0, null);
                if (this.myW != null)
                {
                  this.myW.resume();
                  AppMethodBeat.o(21905);
                  return;
                  a.byd().byg().byh();
                  a.byd().byf().asE();
                  av(15, null);
                  AppMethodBeat.o(21905);
                  return;
                  a(((ab)localObject).mAw, 0, null);
                  if (this.myU != null) {
                    this.myU.byt();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final void av(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(21904);
        ad.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[] { Integer.valueOf(paramInt), paramString });
        if ((paramInt != 10006) && (paramInt != 10008)) {
          break label391;
        }
        ad.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
        this.mzc = -1;
        this.mzd = 1;
        byp();
        a.byd().byf().myC = 2;
        a.byd().byf().asE();
        if (this.myS != null) {
          this.myS.onError(paramInt);
        }
        if (this.myT != null) {
          this.myT.onError(paramInt);
        }
        if (this.myK != null) {
          this.myK.onError(paramInt);
        }
        if (this.myU == null) {
          break label391;
        }
        this.myU.onError(paramInt);
      }
      finally {}
      ad.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.byd().byf().myC = 2;
      a.byd().byf().asE();
      byn();
      AppMethodBeat.o(21904);
      return;
      ad.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.myT, this.myK, this.myS });
      if (paramInt == 15)
      {
        if (this.myT != null) {
          this.myT.onError(paramInt);
        }
        if (this.myK != null) {
          this.myK.onError(paramInt);
        }
        if (this.myS != null) {
          this.myS.wq(paramInt);
        }
      }
      if (paramInt == -1)
      {
        if (this.myT != null)
        {
          this.myT.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.myK != null)
        {
          this.myK.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.myS != null) {
          this.myS.wq(paramInt);
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
  
  public final void bxo()
  {
    AppMethodBeat.i(21902);
    if (this.myW.mzn)
    {
      f localf = this.myW;
      ad.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.mrG)
      {
        ad.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        AppMethodBeat.o(21902);
        return;
      }
      localf.myQ = 0;
      a.byd().bye().mzd = 6;
      localf.mrG = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().a(new f.4(localf));
      AppMethodBeat.o(21902);
      return;
    }
    ad.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    AppMethodBeat.o(21902);
  }
  
  public final boolean byl()
  {
    try
    {
      boolean bool = this.mze;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bym()
  {
    try
    {
      this.myK = null;
      this.myV.myK = null;
      this.myW.myK = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int byo()
  {
    AppMethodBeat.i(21907);
    ad.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.mzd) });
    int i;
    if ((this.mzd == 2) || (this.mzd == 3))
    {
      i = this.myV.myP;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.mzd == 4) || (this.mzd == 5))
    {
      i = this.myW.mzq;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.mzd == 6) || (this.mzd == 7))
    {
      i = this.myW.mzm;
      AppMethodBeat.o(21907);
      return i;
    }
    ad.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    AppMethodBeat.o(21907);
    return 0;
  }
  
  public final void ec(String paramString1, String paramString2)
  {
    this.mza = paramString1;
    this.mzb = paramString2;
  }
  
  public final void hZ(boolean paramBoolean)
  {
    try
    {
      this.mze = paramBoolean;
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
    if (this.myZ == 1)
    {
      this.myV.pause();
      AppMethodBeat.o(21903);
      return;
    }
    if (this.myZ == 6) {
      this.myW.pause();
    }
    AppMethodBeat.o(21903);
  }
  
  public final void wn(int paramInt)
  {
    AppMethodBeat.i(21908);
    if (paramInt == 0) {}
    for (this.mzc = 1; paramInt == 1; this.mzc = -1)
    {
      ac localac = new ac();
      localac.mAw = 0;
      localac.mBi = paramInt;
      try
      {
        ad.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.mBi) });
        com.tencent.mm.plugin.backup.g.b.N(localac.toByteArray(), 4);
        AppMethodBeat.o(21908);
        return;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException1, "buf to PacketCommandResponse err", new Object[0]);
        AppMethodBeat.o(21908);
        return;
      }
    }
    com.tencent.mm.plugin.backup.i.q localq = new com.tencent.mm.plugin.backup.i.q();
    localq.mBt = 0L;
    localq.mBv = Build.MANUFACTURER;
    localq.mAV = Build.MODEL;
    localq.mBu = 0L;
    localq.Version = Build.VERSION.RELEASE;
    Object localObject2 = ae.FfH;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aib()).exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.XG())
      {
        localObject3 = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aih());
        if (!((com.tencent.mm.vfs.e)localObject3).exists())
        {
          localObject1 = localObject2;
          if (!((com.tencent.mm.vfs.e)localObject3).mkdirs()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.loader.j.b.aih();
        }
      }
    }
    localq.mBs = ((String)localObject1);
    localq.mBr = u.aqI();
    localq.mBq = u.aqG();
    localq.mBp = com.tencent.mm.protocal.d.CpK;
    try
    {
      localObject1 = aj.getContext().getPackageManager().getPackageInfo(aj.getContext().getPackageName(), 0);
      localq.mBp = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.CpK);
      p.auq();
      localObject2 = com.tencent.mm.ak.e.vV(localq.mBq);
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
        p.auq();
        localObject2 = com.tencent.mm.ak.e.J(localq.mBq, true);
        if (localObject1 == null)
        {
          i = 0;
          ad.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!bt.cw((byte[])localObject1)) {
            localq.mBw = new com.tencent.mm.bx.b((byte[])localObject1);
          }
          localObject1 = com.tencent.mm.vfs.i.aR((String)localObject2, 0, -1);
          if (!bt.cw((byte[])localObject1)) {
            localq.mBx = new com.tencent.mm.bx.b((byte[])localObject1);
          }
          localObject1 = new ac();
          ((ac)localObject1).mAw = 0;
          ((ac)localObject1).mBi = paramInt;
          ((ac)localObject1).mBZ = localq;
        }
        try
        {
          ad.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((ac)localObject1).mBi) });
          com.tencent.mm.plugin.backup.g.b.N(((ac)localObject1).toByteArray(), 4);
          AppMethodBeat.o(21908);
          return;
        }
        catch (Exception localException3)
        {
          ad.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException3, "buf to PacketCommandResponse err", new Object[0]);
          AppMethodBeat.o(21908);
        }
        localException2 = localException2;
        ad.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException2, "get packageInfo failed", new Object[0]);
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException4, "close", new Object[0]);
          continue;
          int i = localException2.length;
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void byq();
  }
  
  public static abstract interface c
    extends e.b
  {
    public abstract void onEvent(int paramInt);
    
    public abstract void wq(int paramInt);
  }
  
  public static abstract interface d
    extends e.b
  {
    public abstract void bvS();
    
    public abstract void byr();
    
    public abstract void bys();
    
    public abstract void wr(int paramInt);
    
    public abstract void ws(int paramInt);
  }
  
  public static abstract interface e
    extends e.b
  {
    public abstract void byt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */