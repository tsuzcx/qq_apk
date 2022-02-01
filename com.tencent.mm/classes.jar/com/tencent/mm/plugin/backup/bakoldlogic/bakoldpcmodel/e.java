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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.om;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class e
  implements b.d
{
  private d nGD;
  public c nGL;
  public a nGM;
  public e nGN;
  public d nGO;
  public f nGP;
  com.tencent.mm.plugin.backup.bakoldlogic.c.e nGQ;
  private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a nGR;
  public int nGS;
  public String nGT;
  public String nGU;
  public int nGV;
  public int nGW;
  private boolean nGX;
  
  public e()
  {
    AppMethodBeat.i(21900);
    this.nGO = new d();
    this.nGP = new f();
    this.nGS = -1;
    this.nGV = -1;
    this.nGW = 1;
    this.nGX = false;
    AppMethodBeat.o(21900);
  }
  
  public static void a(int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(21909);
    ac localac = new ac();
    localac.nIp = paramInt1;
    localac.nJb = paramInt2;
    localac.nJV = params;
    try
    {
      ae.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), xQ(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.L(localac.toByteArray(), 4);
      AppMethodBeat.o(21909);
      return;
    }
    catch (Exception params)
    {
      ae.printErrStackTrace("MicroMsg.BakPcProcessMgr", params, "buf to PacketCommandResponse err", new Object[0]);
      AppMethodBeat.o(21909);
    }
  }
  
  public static void bKq()
  {
    AppMethodBeat.i(21906);
    Object localObject = new Intent().setClassName(ak.getContext(), "com.tencent.mm.ui.LauncherUI");
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_error_notification");
    Context localContext = ak.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(21906);
  }
  
  public static void bKs()
  {
    AppMethodBeat.i(21912);
    om localom = new om();
    com.tencent.mm.sdk.b.a.IvT.l(localom);
    AppMethodBeat.o(21912);
  }
  
  public static void xP(int paramInt)
  {
    AppMethodBeat.i(21910);
    ab localab = new ab();
    localab.nIp = paramInt;
    try
    {
      ae.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[] { Integer.valueOf(paramInt), xQ(paramInt) });
      com.tencent.mm.plugin.backup.g.b.L(localab.toByteArray(), 3);
      AppMethodBeat.o(21910);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException, "buf to PacketCommandRequest err", new Object[0]);
      AppMethodBeat.o(21910);
    }
  }
  
  private static String xQ(int paramInt)
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
    //   13: getfield 275	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGD	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   16: instanceof 277
    //   19: ifeq +20 -> 39
    //   22: ldc 106
    //   24: ldc_w 279
    //   27: invokestatic 282	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   52: invokestatic 286	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload_1
    //   57: putfield 275	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGD	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   60: aload_0
    //   61: getfield 71	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGO	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d;
    //   64: aload_1
    //   65: putfield 287	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGD	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   68: aload_0
    //   69: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   72: aload_1
    //   73: putfield 288	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nGD	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
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
    //   9: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   19: invokevirtual 292	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:cancel	()V
    //   22: aload_0
    //   23: new 73	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f
    //   26: dup
    //   27: invokespecial 74	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:<init>	()V
    //   30: putfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   33: aload_0
    //   34: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 298	com/tencent/mm/plugin/backup/i/r:nJr	Ljava/util/LinkedList;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 301	com/tencent/mm/plugin/backup/i/r:nJs	Ljava/util/LinkedList;
    //   49: astore 6
    //   51: aload_1
    //   52: getfield 305	com/tencent/mm/plugin/backup/i/r:nJa	J
    //   55: lstore_2
    //   56: aload 4
    //   58: aload 5
    //   60: putfield 309	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHd	Ljava/util/List;
    //   63: aload 4
    //   65: aload 6
    //   67: putfield 312	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHe	Ljava/util/List;
    //   70: aload 4
    //   72: iconst_0
    //   73: putfield 315	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:dus	Z
    //   76: aload 4
    //   78: iconst_0
    //   79: putfield 318	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:hmD	Z
    //   82: aload 4
    //   84: getfield 322	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nGC	Ljava/util/HashSet;
    //   87: invokevirtual 327	java/util/HashSet:clear	()V
    //   90: aload 4
    //   92: iconst_0
    //   93: putfield 330	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nGF	Z
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 333	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHg	Z
    //   102: aload 4
    //   104: iconst_0
    //   105: putfield 336	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nzB	Z
    //   108: aload 4
    //   110: iconst_0
    //   111: putfield 339	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHf	I
    //   114: aload 4
    //   116: lconst_0
    //   117: putfield 342	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHi	J
    //   120: aload 4
    //   122: lload_2
    //   123: putfield 345	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHh	J
    //   126: iconst_0
    //   127: invokestatic 350	com/tencent/mm/plugin/backup/bakoldlogic/c/d:setProgress	(I)V
    //   130: aload_0
    //   131: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   134: aload_0
    //   135: getfield 275	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGD	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   138: putfield 288	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nGD	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e$d;
    //   141: ldc 106
    //   143: ldc_w 352
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: getfield 298	com/tencent/mm/plugin/backup/i/r:nJr	Ljava/util/LinkedList;
    //   156: invokevirtual 358	java/util/LinkedList:size	()I
    //   159: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: getfield 301	com/tencent/mm/plugin/backup/i/r:nJs	Ljava/util/LinkedList;
    //   169: invokevirtual 358	java/util/LinkedList:size	()I
    //   172: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: getfield 305	com/tencent/mm/plugin/backup/i/r:nJa	J
    //   182: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 123	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 76	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/e:nGP	Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: putfield 366	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nGJ	I
    //   201: aload 4
    //   203: getfield 312	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHe	Ljava/util/List;
    //   206: invokeinterface 369 1 0
    //   211: aload_1
    //   212: getfield 372	com/tencent/mm/plugin/backup/i/r:nJf	I
    //   215: if_icmplt +20 -> 235
    //   218: aload 4
    //   220: getfield 309	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f:nHd	Ljava/util/List;
    //   223: invokeinterface 369 1 0
    //   228: aload_1
    //   229: getfield 375	com/tencent/mm/plugin/backup/i/r:nJe	I
    //   232: if_icmpge +46 -> 278
    //   235: iconst_3
    //   236: new 377	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2
    //   239: dup
    //   240: aload 4
    //   242: invokespecial 380	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f$2:<init>	(Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/f;)V
    //   245: invokestatic 383	com/tencent/mm/plugin/backup/g/b:a	(ILcom/tencent/mm/ak/f;)V
    //   248: ldc_w 385
    //   251: ldc_w 387
    //   254: invokestatic 389	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: new 391	com/tencent/mm/plugin/backup/bakoldlogic/c/b
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 393	com/tencent/mm/plugin/backup/bakoldlogic/c/b:<init>	(I)V
    //   265: invokevirtual 397	com/tencent/mm/plugin/backup/bakoldlogic/c/b:bJH	()Z
    //   268: pop
    //   269: sipush 21911
    //   272: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: monitorexit
    //   277: return
    //   278: ldc_w 385
    //   281: ldc_w 399
    //   284: invokestatic 389	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: getstatic 405	com/tencent/e/h:MqF	Lcom/tencent/e/i;
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
      ax(paramInt1, new String(paramArrayOfByte));
    }
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      a.bKg().bKi().nGv = 1;
      new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.bKg().nxX, a.bKg().nxY, com.tencent.mm.plugin.backup.b.d.bHZ(), a.bKg().nxW).bJH();
    }
    Object localObject;
    if (paramInt1 == 3)
    {
      this.nGS = -1;
      localObject = new ab();
    }
    for (;;)
    {
      try
      {
        ((ab)localObject).parseFrom(paramArrayOfByte);
        ae.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[] { Integer.valueOf(((ab)localObject).nIp), xQ(((ab)localObject).nIp) });
        paramInt1 = ((ab)localObject).nIp;
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
        ae.printErrStackTrace("MicroMsg.BakPcProcessMgr", paramArrayOfByte, "buf to PacketCommandReq error", new Object[0]);
      }
      if (!bc.ajM())
      {
        ae.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
        a(((ab)localObject).nIp, 1, null);
        AppMethodBeat.o(21905);
        return;
      }
      this.nGS = ((ab)localObject).nIp;
      if (this.nGM != null)
      {
        this.nGM.bKt();
        this.nGV = 0;
        this.nGW = 1;
        AppMethodBeat.o(21905);
        return;
        AppMethodBeat.o(21905);
        return;
      }
      ae.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
      localObject = new Intent().setClassName(ak.getContext(), "com.tencent.mm.ui.LauncherUI");
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).putExtra("nofification_type", "back_to_pcmgr_notification");
      ((Intent)localObject).putExtra("newPCBackup", false);
      paramArrayOfByte = ak.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramArrayOfByte.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfByte, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      a.bKg().bKj().bKk();
      a.bKg().bKi().aCO();
      ax(-1, null);
      ae.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
      AppMethodBeat.o(21905);
      return;
      this.nGW = 2;
      this.nGV = 3;
      bKs();
      a(((ab)localObject).nIp, 0, null);
      paramArrayOfByte = this.nGO;
      h.MqF.aR(new d.1(paramArrayOfByte));
      AppMethodBeat.o(21905);
      return;
      this.nGV = -1;
      this.nGW = 1;
      bKs();
      a(((ab)localObject).nIp, 0, null);
      if (this.nGQ != null)
      {
        this.nGQ.cancel();
        this.nGQ = null;
      }
      if (this.nGO != null) {
        this.nGO.cancel();
      }
      if (this.nGR != null)
      {
        paramArrayOfByte = this.nGR;
        ae.i("MicroMsg.BakCalculator", "calculator cancel.");
        ae.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[] { bu.fpN() });
        paramArrayOfByte.hmD = true;
        this.nGR = null;
      }
      if (this.nGD != null)
      {
        this.nGD.bKv();
        AppMethodBeat.o(21905);
        return;
        this.nGV = 5;
        this.nGW = 4;
        bKs();
        this.nGS = ((ab)localObject).nIp;
        if (this.nGL != null) {
          this.nGL.onEvent(((ab)localObject).nIp);
        }
        for (;;)
        {
          paramArrayOfByte = a.bKg().bKi();
          paramArrayOfByte.nGy += 1;
          com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().a(new b.a()
          {
            public final void run()
            {
              AppMethodBeat.i(21895);
              s locals = new s();
              if (this.nIi)
              {
                locals.nIX = this.dbSize;
                locals.nJu = (this.nIk - this.dbSize);
                locals.nJt = this.nIj;
                e locale = e.this;
                e.a(6, 0, locals);
                com.tencent.mm.plugin.backup.g.b.a(3, new e.2(locale));
                ae.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).bJH();
                AppMethodBeat.o(21895);
                return;
              }
              if ((this.dbSize > this.nIk) && (this.nIk > 0L))
              {
                locals.nIX = this.dbSize;
                locals.nJu = (this.nIk - this.dbSize);
              }
              e.a(6, 14, locals);
              ae.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
              AppMethodBeat.o(21895);
            }
          });
          AppMethodBeat.o(21905);
          return;
          ae.i("MicroMsg.BakPcProcessMgr", "callback is null");
        }
        this.nGV = -1;
        this.nGW = 1;
        bKs();
        a(((ab)localObject).nIp, 0, null);
        if (this.nGQ != null)
        {
          this.nGQ.cancel();
          this.nGQ = null;
        }
        if (this.nGP != null) {
          this.nGP.cancel();
        }
        if (this.nGD != null)
        {
          this.nGD.bKv();
          AppMethodBeat.o(21905);
          return;
          a(((ab)localObject).nIp, 0, null);
          if (this.nGO != null)
          {
            this.nGO.pause();
            AppMethodBeat.o(21905);
            return;
            a(((ab)localObject).nIp, 0, null);
            if (this.nGP != null)
            {
              this.nGP.pause();
              AppMethodBeat.o(21905);
              return;
              a(((ab)localObject).nIp, 0, null);
              if (this.nGO != null)
              {
                this.nGO.resume();
                AppMethodBeat.o(21905);
                return;
                a(((ab)localObject).nIp, 0, null);
                if (this.nGP != null)
                {
                  this.nGP.resume();
                  AppMethodBeat.o(21905);
                  return;
                  a.bKg().bKj().bKk();
                  a.bKg().bKi().aCO();
                  ax(15, null);
                  AppMethodBeat.o(21905);
                  return;
                  a(((ab)localObject).nIp, 0, null);
                  if (this.nGN != null) {
                    this.nGN.bKw();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final void ax(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(21904);
        ae.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[] { Integer.valueOf(paramInt), paramString });
        if ((paramInt != 10006) && (paramInt != 10008)) {
          break label391;
        }
        ae.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
        this.nGV = -1;
        this.nGW = 1;
        bKs();
        a.bKg().bKi().nGv = 2;
        a.bKg().bKi().aCO();
        if (this.nGL != null) {
          this.nGL.onError(paramInt);
        }
        if (this.nGM != null) {
          this.nGM.onError(paramInt);
        }
        if (this.nGD != null) {
          this.nGD.onError(paramInt);
        }
        if (this.nGN == null) {
          break label391;
        }
        this.nGN.onError(paramInt);
      }
      finally {}
      ae.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[] { Integer.valueOf(paramInt) });
      a.bKg().bKi().nGv = 2;
      a.bKg().bKi().aCO();
      bKq();
      AppMethodBeat.o(21904);
      return;
      ae.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[] { Integer.valueOf(paramInt), this.nGM, this.nGD, this.nGL });
      if (paramInt == 15)
      {
        if (this.nGM != null) {
          this.nGM.onError(paramInt);
        }
        if (this.nGD != null) {
          this.nGD.onError(paramInt);
        }
        if (this.nGL != null) {
          this.nGL.xR(paramInt);
        }
      }
      if (paramInt == -1)
      {
        if (this.nGM != null)
        {
          this.nGM.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.nGD != null)
        {
          this.nGD.onError(paramInt);
          AppMethodBeat.o(21904);
          continue;
        }
        if (this.nGL != null) {
          this.nGL.xR(paramInt);
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
  
  public final void bJr()
  {
    AppMethodBeat.i(21902);
    if (this.nGP.nHg)
    {
      f localf = this.nGP;
      ae.i("MicroMsg.RecoverPCServer", "startMerge");
      if (localf.nzB)
      {
        ae.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
        AppMethodBeat.o(21902);
        return;
      }
      localf.nGJ = 0;
      a.bKg().bKh().nGW = 6;
      localf.nzB = true;
      com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().a(new f.4(localf));
      AppMethodBeat.o(21902);
      return;
    }
    ae.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    AppMethodBeat.o(21902);
  }
  
  public final boolean bKo()
  {
    try
    {
      boolean bool = this.nGX;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bKp()
  {
    try
    {
      this.nGD = null;
      this.nGO.nGD = null;
      this.nGP.nGD = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bKr()
  {
    AppMethodBeat.i(21907);
    ae.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[] { Integer.valueOf(this.nGW) });
    int i;
    if ((this.nGW == 2) || (this.nGW == 3))
    {
      i = this.nGO.nGI;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.nGW == 4) || (this.nGW == 5))
    {
      i = this.nGP.nHj;
      AppMethodBeat.o(21907);
      return i;
    }
    if ((this.nGW == 6) || (this.nGW == 7))
    {
      i = this.nGP.nHf;
      AppMethodBeat.o(21907);
      return i;
    }
    ae.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
    AppMethodBeat.o(21907);
    return 0;
  }
  
  public final void eA(String paramString1, String paramString2)
  {
    this.nGT = paramString1;
    this.nGU = paramString2;
  }
  
  public final void iG(boolean paramBoolean)
  {
    try
    {
      this.nGX = paramBoolean;
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
    if (this.nGS == 1)
    {
      this.nGO.pause();
      AppMethodBeat.o(21903);
      return;
    }
    if (this.nGS == 6) {
      this.nGP.pause();
    }
    AppMethodBeat.o(21903);
  }
  
  public final void xO(int paramInt)
  {
    AppMethodBeat.i(21908);
    if (paramInt == 0) {}
    for (this.nGV = 1; paramInt == 1; this.nGV = -1)
    {
      ac localac = new ac();
      localac.nIp = 0;
      localac.nJb = paramInt;
      try
      {
        ae.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(localac.nJb) });
        com.tencent.mm.plugin.backup.g.b.L(localac.toByteArray(), 4);
        AppMethodBeat.o(21908);
        return;
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException1, "buf to PacketCommandResponse err", new Object[0]);
        AppMethodBeat.o(21908);
        return;
      }
    }
    com.tencent.mm.plugin.backup.i.q localq = new com.tencent.mm.plugin.backup.i.q();
    localq.nJm = 0L;
    localq.nJo = Build.MANUFACTURER;
    localq.nIO = Build.MODEL;
    localq.nJn = 0L;
    localq.Version = Build.VERSION.RELEASE;
    Object localObject2 = am.IKh;
    Object localObject1 = localObject2;
    Object localObject3;
    if (new k(com.tencent.mm.loader.j.b.asd()).exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.abo())
      {
        localObject3 = new k(com.tencent.mm.loader.j.b.asj());
        if (!((k)localObject3).exists())
        {
          localObject1 = localObject2;
          if (!((k)localObject3).mkdirs()) {}
        }
        else
        {
          localObject1 = com.tencent.mm.loader.j.b.asj();
        }
      }
    }
    localq.nJl = ((String)localObject1);
    localq.nJk = v.aAE();
    localq.nJj = v.aAC();
    localq.nJi = com.tencent.mm.protocal.d.FFH;
    try
    {
      localObject1 = ak.getContext().getPackageManager().getPackageInfo(ak.getContext().getPackageName(), 0);
      localq.nJi = (((PackageInfo)localObject1).versionName + ";" + ((PackageInfo)localObject1).versionCode + ";" + com.tencent.mm.protocal.d.FFH);
      p.aEA();
      localObject2 = com.tencent.mm.aj.e.DC(localq.nJj);
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
        p.aEA();
        localObject2 = com.tencent.mm.aj.e.K(localq.nJj, true);
        if (localObject1 == null)
        {
          i = 0;
          ae.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", new Object[] { localObject2, Integer.valueOf(i) });
          if (!bu.cF((byte[])localObject1)) {
            localq.nJp = new com.tencent.mm.bw.b((byte[])localObject1);
          }
          localObject1 = o.bb((String)localObject2, 0, -1);
          if (!bu.cF((byte[])localObject1)) {
            localq.nJq = new com.tencent.mm.bw.b((byte[])localObject1);
          }
          localObject1 = new ac();
          ((ac)localObject1).nIp = 0;
          ((ac)localObject1).nJb = paramInt;
          ((ac)localObject1).nJS = localq;
        }
        try
        {
          ae.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[] { Integer.valueOf(((ac)localObject1).nJb) });
          com.tencent.mm.plugin.backup.g.b.L(((ac)localObject1).toByteArray(), 4);
          AppMethodBeat.o(21908);
          return;
        }
        catch (Exception localException3)
        {
          ae.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException3, "buf to PacketCommandResponse err", new Object[0]);
          AppMethodBeat.o(21908);
        }
        localException2 = localException2;
        ae.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException2, "get packageInfo failed", new Object[0]);
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.BakPcProcessMgr", localException4, "close", new Object[0]);
          continue;
          int i = localException2.length;
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void bKt();
  }
  
  public static abstract interface b
  {
    public abstract void onError(int paramInt);
  }
  
  public static abstract interface c
    extends e.b
  {
    public abstract void onEvent(int paramInt);
    
    public abstract void xR(int paramInt);
  }
  
  public static abstract interface d
    extends e.b
  {
    public abstract void bHU();
    
    public abstract void bKu();
    
    public abstract void bKv();
    
    public abstract void xS(int paramInt);
    
    public abstract void xT(int paramInt);
  }
  
  public static abstract interface e
    extends e.b
  {
    public abstract void bKw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e
 * JD-Core Version:    0.7.0.1
 */