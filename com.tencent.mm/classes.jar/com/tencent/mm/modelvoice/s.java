package com.tencent.mm.modelvoice;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.l;
import com.tencent.mm.autogen.a.acf;
import com.tencent.mm.autogen.a.nq;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static final HashMap<String, WeakReference<l>> peN;
  public static volatile HashMap<String, Integer> peO;
  public static volatile HashMap<String, Integer> peP;
  public static volatile HashMap<String, Integer> peQ;
  
  static
  {
    AppMethodBeat.i(148492);
    peN = new HashMap();
    peO = new HashMap();
    peP = new HashMap();
    peQ = new HashMap();
    AppMethodBeat.o(148492);
  }
  
  public static boolean QG(String paramString)
  {
    AppMethodBeat.i(148455);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString = o.bPf().QT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    if (paramString.pbd >= 250)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString.pbd += 1;
    paramString.eQp = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(148455);
    return bool;
  }
  
  public static b QH(String paramString)
  {
    AppMethodBeat.i(148457);
    w localw = o.bPf();
    String str = getFullPath(paramString);
    switch (q.QE(paramString))
    {
    default: 
      if (localw.peZ.get(str) == null) {
        localw.peZ.put(str, new a(str));
      }
      paramString = (b)localw.peZ.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 0: 
      if (localw.peZ.get(str) == null) {
        localw.peZ.put(str, new a(str));
      }
      paramString = (b)localw.peZ.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 1: 
      if (localw.pfa.get(str) == null) {
        localw.pfa.put(str, new n(str));
      }
      paramString = (b)localw.pfa.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    }
    if (localw.pfb.get(str) == null) {
      localw.pfb.put(str, new j(str));
    }
    paramString = (b)localw.pfb.get(str);
    AppMethodBeat.o(148457);
    return paramString;
  }
  
  private static void QI(String paramString)
  {
    AppMethodBeat.i(148458);
    w localw = o.bPf();
    String str = getFullPath(paramString);
    switch (q.QE(paramString))
    {
    default: 
      paramString = (a)localw.peZ.get(str);
      if (paramString != null)
      {
        paramString.bOT();
        localw.peZ.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 0: 
      paramString = (a)localw.peZ.get(str);
      if (paramString != null)
      {
        paramString.bOT();
        localw.peZ.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 1: 
      paramString = (n)localw.pfa.get(str);
      if (paramString != null)
      {
        paramString.bOT();
        localw.pfa.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    }
    paramString = (j)localw.pfb.get(str);
    if (paramString != null)
    {
      paramString.bOT();
      localw.pfb.remove(str);
    }
    AppMethodBeat.o(148458);
  }
  
  public static String QJ(String paramString)
  {
    AppMethodBeat.i(148461);
    String str = w.QS(z.bAM());
    r localr = new r();
    localr.fileName = str;
    localr.hVQ = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.pba = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.paV = z.bAM();
    localr.eQp = -1;
    if (!o.bPf().b(localr))
    {
      AppMethodBeat.o(148461);
      return null;
    }
    Log.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(148461);
    return str;
  }
  
  public static boolean QK(String paramString)
  {
    AppMethodBeat.i(148463);
    if (paramString == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    Log.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.bPf().QT(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    localr.status = 8;
    localr.osy = q.PZ(paramString);
    localr.eQp = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(148463);
    return bool;
  }
  
  public static boolean QL(String paramString)
  {
    AppMethodBeat.i(148464);
    if (paramString == null)
    {
      AppMethodBeat.o(148464);
      return false;
    }
    r localr = o.bPf().QT(paramString);
    if (localr == null)
    {
      Log.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148464);
      return true;
    }
    Log.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.hTh);
    if (localr.hTh != 0L) {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().be(localr.hVQ, localr.hTh);
    }
    boolean bool = QN(paramString);
    AppMethodBeat.o(148464);
    return bool;
  }
  
  public static boolean QM(String paramString)
  {
    AppMethodBeat.i(148465);
    if (paramString == null)
    {
      AppMethodBeat.o(148465);
      return false;
    }
    r localr = o.bPf().QT(paramString);
    if (localr == null)
    {
      Log.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148465);
      return true;
    }
    Log.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.pbc);
    if (localr.pbc != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sm(localr.pbc);
    }
    boolean bool = QN(paramString);
    AppMethodBeat.o(148465);
    return bool;
  }
  
  public static boolean QN(String paramString)
  {
    AppMethodBeat.i(148466);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    if (!o.bPf().iP(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    QI(paramString);
    paramString = getFullPath(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    boolean bool = new u(paramString).diJ();
    AppMethodBeat.o(148466);
    return bool;
  }
  
  /* Error */
  public static boolean QO(String paramString)
  {
    // Byte code:
    //   0: ldc_w 283
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 46	com/tencent/mm/modelvoice/o:bPf	()Lcom/tencent/mm/modelvoice/w;
    //   9: aload_0
    //   10: invokevirtual 52	com/tencent/mm/modelvoice/w:QT	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +11 -> 26
    //   18: ldc_w 283
    //   21: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_1
    //   25: ireturn
    //   26: new 276	com/tencent/mm/vfs/u
    //   29: dup
    //   30: aload_0
    //   31: invokestatic 72	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokespecial 277	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_0
    //   39: invokestatic 285	com/tencent/mm/modelvoice/s:QH	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +80 -> 124
    //   47: aload_1
    //   48: instanceof 90
    //   51: ifeq +73 -> 124
    //   54: aload_3
    //   55: invokevirtual 288	com/tencent/mm/vfs/u:length	()J
    //   58: aload_2
    //   59: getfield 201	com/tencent/mm/modelvoice/r:osy	I
    //   62: i2l
    //   63: lsub
    //   64: invokestatic 294	java/lang/Math:abs	(J)J
    //   67: ldc2_w 295
    //   70: lcmp
    //   71: ifne +53 -> 124
    //   74: ldc 169
    //   76: ldc_w 298
    //   79: iconst_2
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_3
    //   86: invokevirtual 288	com/tencent/mm/vfs/u:length	()J
    //   89: invokestatic 303	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_2
    //   96: getfield 201	com/tencent/mm/modelvoice/r:osy	I
    //   99: invokestatic 308	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 311	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokeinterface 312 1 0
    //   116: ldc_w 283
    //   119: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_3
    //   125: invokevirtual 288	com/tencent/mm/vfs/u:length	()J
    //   128: aload_2
    //   129: getfield 201	com/tencent/mm/modelvoice/r:osy	I
    //   132: i2l
    //   133: lcmp
    //   134: ifeq +53 -> 187
    //   137: ldc 169
    //   139: ldc_w 314
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_3
    //   149: invokevirtual 288	com/tencent/mm/vfs/u:length	()J
    //   152: invokestatic 303	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_2
    //   159: getfield 201	com/tencent/mm/modelvoice/r:osy	I
    //   162: invokestatic 308	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 312 1 0
    //   179: ldc_w 283
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_1
    //   188: iconst_0
    //   189: aload_2
    //   190: getfield 201	com/tencent/mm/modelvoice/r:osy	I
    //   193: invokeinterface 321 3 0
    //   198: astore_0
    //   199: aload_0
    //   200: getfield 326	com/tencent/mm/modelvoice/g:ret	I
    //   203: ifne +76 -> 279
    //   206: aload_2
    //   207: getfield 329	com/tencent/mm/modelvoice/r:peK	I
    //   210: ifeq +69 -> 279
    //   213: aload_2
    //   214: getfield 329	com/tencent/mm/modelvoice/r:peK	I
    //   217: aload_2
    //   218: getfield 329	com/tencent/mm/modelvoice/r:peK	I
    //   221: sipush 255
    //   224: iand
    //   225: aload_0
    //   226: getfield 333	com/tencent/mm/modelvoice/g:buf	[B
    //   229: aload_0
    //   230: getfield 336	com/tencent/mm/modelvoice/g:hxg	I
    //   233: invokestatic 339	com/tencent/mm/modelvoice/s:b	(I[BI)I
    //   236: if_icmpeq +43 -> 279
    //   239: ldc 169
    //   241: ldc_w 341
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_2
    //   251: getfield 329	com/tencent/mm/modelvoice/r:peK	I
    //   254: invokestatic 308	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_1
    //   262: ifnull +9 -> 271
    //   265: aload_1
    //   266: invokeinterface 312 1 0
    //   271: ldc_w 283
    //   274: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload_1
    //   280: ifnull +9 -> 289
    //   283: aload_1
    //   284: invokeinterface 312 1 0
    //   289: ldc_w 283
    //   292: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_1
    //   301: ifnull +9 -> 310
    //   304: aload_1
    //   305: invokeinterface 312 1 0
    //   310: ldc_w 283
    //   313: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_0
    //   317: athrow
    //   318: astore_0
    //   319: goto -203 -> 116
    //   322: astore_0
    //   323: goto -144 -> 179
    //   326: astore_0
    //   327: goto -56 -> 271
    //   330: astore_0
    //   331: goto -42 -> 289
    //   334: astore_1
    //   335: goto -25 -> 310
    //   338: astore_0
    //   339: goto -39 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramString	String
    //   42	263	1	localb	b
    //   334	1	1	localObject	Object
    //   13	238	2	localr	r
    //   37	112	3	localu	u
    // Exception table:
    //   from	to	target	type
    //   38	43	297	finally
    //   110	116	318	finally
    //   173	179	322	finally
    //   265	271	326	finally
    //   283	289	330	finally
    //   304	310	334	finally
    //   47	106	338	finally
    //   124	169	338	finally
    //   187	261	338	finally
  }
  
  public static cc QP(String paramString)
  {
    AppMethodBeat.i(148481);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = o.bPf().QT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramString.pbc);
    AppMethodBeat.o(148481);
    return paramString;
  }
  
  public static r QQ(String paramString)
  {
    AppMethodBeat.i(369556);
    paramString = o.bPf().QT(paramString);
    AppMethodBeat.o(369556);
    return paramString;
  }
  
  public static int QR(String paramString)
  {
    AppMethodBeat.i(148489);
    synchronized (peN)
    {
      if (peN.get(paramString) != null)
      {
        paramString = (l)((WeakReference)peN.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.aHd();
          AppMethodBeat.o(148489);
          return i;
        }
      }
      AppMethodBeat.o(148489);
      return -1;
    }
  }
  
  public static boolean Qf(String paramString)
  {
    AppMethodBeat.i(148480);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(148480);
      return false;
    }
    r localr = o.bPf().QT(paramString);
    if (localr == null)
    {
      Log.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148480);
      return false;
    }
    localr.status = 98;
    localr.pba = (System.currentTimeMillis() / 1000L);
    localr.eQp = 320;
    boolean bool = a(localr);
    Log.i("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localr.pbc + " old stat:" + localr.status);
    if ((localr.pbc == 0) || (Util.isNullOrNil(localr.hVQ)))
    {
      Log.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localr.pbc + " user:" + localr.hVQ);
      AppMethodBeat.o(148480);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(localr.pbc);
    if (paramString == null)
    {
      Log.e("MicroMsg.VoiceLogic", "setError error, cannot get the msgInfo, create a default one");
      paramString = new cc();
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 33L, 1L, true);
      paramString.setMsgId(localr.pbc);
      paramString.setStatus(5);
      paramString.BS(localr.hVQ);
      paramString.setContent(p.a(localr.paV, Math.max(localr.peH, 0), true));
      paramString.jcj();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramString.field_msgId, paramString);
      acf localacf = new acf();
      localacf.ifI.msgId = paramString.field_msgId;
      localacf.ifI.success = false;
      localacf.ifI.ifJ = localr.bPl();
      localacf.asyncPublish(Looper.getMainLooper());
      AppMethodBeat.o(148480);
      return bool;
    }
  }
  
  public static boolean Qg(String paramString)
  {
    AppMethodBeat.i(148477);
    paramString = o.bPf().QT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148477);
      return false;
    }
    if (paramString.status == 3)
    {
      cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramString.pbc);
      localcc.setContent(p.a(paramString.paV, paramString.peH, false));
      localcc.setStatus(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramString.pbc, localcc);
    }
    paramString.status = 97;
    paramString.pba = (System.currentTimeMillis() / 1000L);
    paramString.eQp = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(148477);
    return bool;
  }
  
  /* Error */
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnull +12 -> 18
    //   9: aload_1
    //   10: arraylength
    //   11: istore 4
    //   13: iload 4
    //   15: ifne +12 -> 27
    //   18: iconst_0
    //   19: istore 4
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload 4
    //   26: ireturn
    //   27: iload_0
    //   28: istore 4
    //   30: iload_3
    //   31: iload_2
    //   32: if_icmpge -11 -> 21
    //   35: iload_0
    //   36: aload_1
    //   37: iload_3
    //   38: iconst_0
    //   39: iadd
    //   40: baload
    //   41: iadd
    //   42: istore_0
    //   43: iload_3
    //   44: iconst_1
    //   45: iadd
    //   46: istore_3
    //   47: goto -20 -> 27
    //   50: astore_1
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramInt1	int
    //   0	56	1	paramArrayOfByte	byte[]
    //   0	56	2	paramInt2	int
    //   1	46	3	i	int
    //   11	18	4	j	int
    // Exception table:
    //   from	to	target	type
    //   9	13	50	finally
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, g.a parama)
  {
    AppMethodBeat.i(148473);
    f.a locala = new f.a();
    r localr = o.bPf().ji(paramr.hTh);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aU(paramr.hVQ, paramr.hTh);
    if ((localObject != null) && (((fi)localObject).field_msgSvrId == paramr.hTh) && (localr == null))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    boolean bool1;
    String str;
    int i;
    if (localr != null)
    {
      paramr.fileName = localr.fileName;
      paramr.eQp |= 0x1;
      Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.aPX() + "checktime :" + locala.aPY());
      boolean bool2 = false;
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length > 1)
        {
          if (localr != null) {
            Log.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
          }
          localObject = paramr.pdj;
          str = paramr.fileName;
          i = bT((String)localObject, str).y(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label648;
          }
          Log.e("MicroMsg.VoiceLogic", "Write Failed File:" + str + " newOffset:" + i + " voiceFormat:" + (String)localObject);
          bool1 = false;
          label285:
          paramr.peK = b(paramr.peK, paramArrayOfByte, paramArrayOfByte.length);
          paramr.eQp |= 0x80000;
        }
      }
      Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.aPX() + "checktime :" + locala.aPY());
      paramr.pba = (System.currentTimeMillis() / 1000L);
      paramr.eQp |= 0x100;
      if (!bool1) {
        break label773;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.eQp |= 0x40;
      if (localr != null) {
        break label845;
      }
      paramr.pbc = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      if (parama != null)
      {
        paramr.jUq = br.d(parama);
        if (parama.mpN != null) {
          paramr.peI = parama.mpN.YFL;
        }
      }
      Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.aPX() + "checktime :" + locala.aPY());
      paramr.eQp = -1;
      Log.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.oZm + " total:" + paramr.osy);
      if (o.bPf().b(paramr)) {
        break label797;
      }
      Log.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.oZm + " total:" + paramr.osy);
      AppMethodBeat.o(148473);
      return -2;
      paramr.fileName = w.QS(paramr.paV);
      break;
      label648:
      if (paramArrayOfByte.length != i)
      {
        Log.e("MicroMsg.VoiceLogic", "Write File:" + str + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + (String)localObject);
        bool1 = false;
        break label285;
      }
      Log.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + (String)localObject);
      QI(str);
      bool1 = true;
      break label285;
      label773:
      if (paramr.osy == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label797:
    Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.aPX() + "checktime :" + locala.aPY());
    if (bool1)
    {
      AppMethodBeat.o(148473);
      return 1;
      label845:
      Log.d("MicroMsg.VoiceLogic", "Sync Update file:" + paramr.fileName + " stat:" + paramr.status);
      if (!a(paramr))
      {
        AppMethodBeat.o(148473);
        return -44;
      }
      if (bool1)
      {
        a(paramr, parama);
        AppMethodBeat.o(148473);
        return 1;
      }
    }
    if ((localr != null) && (localr.paX == paramr.osy))
    {
      a(localr.fileName, localr.paX, parama);
      Log.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    Log.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), Util.getStack() });
    o.bPh().run();
    AppMethodBeat.o(148473);
    return 0;
  }
  
  public static int a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148469);
    if (paramString1 == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    Log.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + paramString1 + "] newOff:" + paramInt1 + " SvrID:" + paramLong + " clientID:" + paramString2 + " hasSendEndFlag " + paramInt2);
    r localr = o.bPf().QT(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    localr.oZm = paramInt1;
    localr.pba = (System.currentTimeMillis() / 1000L);
    localr.eQp = 264;
    if ((Util.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.eQp |= 0x200;
    }
    if ((localr.hTh == 0L) && (paramLong != 0L))
    {
      localr.hTh = paramLong;
      localr.eQp |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.osy <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.eQp |= 0x40;
          paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(localr.pbc);
          if (paramString2 != null) {
            break label542;
          }
          Log.e("MicroMsg.VoiceLogic", "Error, cannot get the msgInfo in updateAfterSend, create a default one");
          paramString2 = new cc();
        }
      }
    }
    label542:
    for (;;)
    {
      paramString2.BS(localr.hVQ);
      paramString2.gX(localr.hTh);
      paramString2.setStatus(2);
      paramString2.setContent(p.a(localr.paV, localr.peH, false));
      paramString2.ayZ(paramInt3);
      Integer localInteger = (Integer)peO.get(getFullPath(paramString1));
      if (localInteger != null)
      {
        localr.peK = localInteger.intValue();
        localr.eQp |= 0x80000;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(localr.pbc, paramString2);
      Log.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.osy + " status:" + localr.status + " netTimes:" + localr.pbd + " msgId:" + paramString2.field_msgId);
      i = 1;
      QI(paramString1);
      if (!a(localr))
      {
        AppMethodBeat.o(148469);
        return -4;
      }
      AppMethodBeat.o(148469);
      return i;
    }
  }
  
  public static int a(String paramString, int paramInt, g.a parama)
  {
    int j = 0;
    AppMethodBeat.i(148476);
    if (paramString == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    r localr = o.bPf().QT(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    localr.paX = paramInt;
    localr.pba = (System.currentTimeMillis() / 1000L);
    localr.eQp = 272;
    int i = j;
    if (localr.osy > 0)
    {
      i = j;
      if (paramInt >= localr.osy)
      {
        a(localr, parama);
        localr.status = 99;
        localr.peL = 0;
        localr.eQp = (localr.eQp | 0x40 | 0x100000);
        Log.i("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.osy + " status:" + localr.status + " netTimes:" + localr.pbd);
        i = 1;
        QI(paramString);
      }
    }
    Log.i("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.osy + " status:" + localr.status);
    if (!a(localr))
    {
      AppMethodBeat.o(148476);
      return -3;
    }
    AppMethodBeat.o(148476);
    return i;
  }
  
  public static int a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(148471);
    paramString = o.bPf().QT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148471);
      return -1;
    }
    paramString.peK = b(paramString.peK, paramArrayOfByte, paramInt);
    paramString.eQp |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.peK;
      AppMethodBeat.o(148471);
      return paramInt;
    }
    AppMethodBeat.o(148471);
    return 0;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, g.a parama)
  {
    AppMethodBeat.i(148475);
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sn(paramr.hTh))
    {
      Log.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.hTh) });
      if (Util.nullAsNil(paramr.fileName).length() > 0) {
        o.bPf().iP(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(148475);
        return -1L;
        Log.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aU(paramr.hVQ, paramr.hTh);
    int i = 0;
    if (localcc.field_msgSvrId != paramr.hTh)
    {
      localcc = new cc();
      localcc.gX(paramr.hTh);
      localcc.BT(paramr.fileName);
      localcc.setCreateTime(br.D(paramr.hVQ, paramr.createTime));
      localcc.BS(paramr.hVQ);
      if (z.Iy(paramr.paV))
      {
        i = 1;
        localcc.pI(i);
        localcc.setType(34);
        localcc.ayZ(paramr.pdq);
        i = 1;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localcc.jcj();
        label242:
        localcc.Ca(paramString1);
        localcc.setStatus(paramInt);
        if (parama != null) {
          break label572;
        }
        paramInt = paramr.jUq;
        if (paramInt != 0)
        {
          Log.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
          localcc.setFlag(paramInt);
          if ((localcc.field_msgId == 0L) && (localcc.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
            localcc.setCreateTime(br.m(localcc.field_talker, paramr.createTime, localcc.field_msgSeq));
          }
        }
        if (paramr.peI != 0) {
          localcc.gZ(paramr.peI);
        }
        Log.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.peI) });
        label385:
        Log.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
        if (!Util.isNullOrNil(paramString2))
        {
          localcc.AU(paramString2);
          localcc.Cb(br.JQ(paramString2));
        }
        if (paramBoolean) {
          break label582;
        }
        localcc.setContent(p.a(paramr.paV, Math.max(paramr.peH, 0), false));
        label453:
        Log.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localcc.field_msgSvrId), Long.valueOf(localcc.field_msgSeq) });
        if (i == 0) {
          break label725;
        }
      }
      for (long l = br.B(localcc);; l = localcc.field_msgId)
      {
        if (paramBoolean)
        {
          paramString1 = new acf();
          paramString1.ifI.msgId = localcc.field_msgId;
          paramString1.ifI.success = true;
          paramString1.ifI.ifJ = paramr.bPl();
          paramString1.asyncPublish(Looper.getMainLooper());
        }
        AppMethodBeat.o(148475);
        return l;
        i = 0;
        break;
        localcc.jci();
        break label242;
        label572:
        br.a(localcc, parama);
        break label385;
        label582:
        localcc.setContent(p.a(paramr.paV, paramr.peH, false));
        if (Util.isNullOrNil(paramString2)) {
          break label453;
        }
        localcc.AU(paramString2);
        localcc.Cb(br.JQ(paramString2));
        paramString1 = br.JP(paramString2);
        if (paramString1 == null) {
          break label453;
        }
        localcc.Cb(paramString1.olS);
        localcc.qb(paramString1.olT);
        localcc.BW(paramString1.olR);
        Log.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramString1.olR });
        if (paramString1.olW == null) {
          break label453;
        }
        paramString2 = new nq();
        paramString2.hQb.hzO = localcc;
        paramString2.hQb.hQc = paramString1;
        paramString2.publish();
        break label453;
        label725:
        br.C(localcc);
      }
    }
  }
  
  public static boolean a(r paramr)
  {
    AppMethodBeat.i(148484);
    if (paramr == null)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    if (paramr.eQp == -1)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    boolean bool = o.bPf().a(paramr.fileName, paramr);
    AppMethodBeat.o(148484);
    return bool;
  }
  
  private static boolean a(r paramr, g.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      paramr.pbc = ((int)a(paramr, true, 3, "", paramr.jUr, parama));
      paramr.eQp |= 0x800;
      boolean bool = a(paramr);
      AppMethodBeat.o(148474);
      return bool;
    }
    catch (Exception paramr)
    {
      Log.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { Util.stackTraceToString(paramr) });
      AppMethodBeat.o(148474);
    }
    return false;
  }
  
  public static boolean a(String paramString, l paraml)
  {
    AppMethodBeat.i(148462);
    if (paramString == null)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    r localr = o.bPf().QT(paramString);
    if (localr == null)
    {
      Log.d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148462);
      return false;
    }
    if (localr.status != 1)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    localr.status = 2;
    localr.eQp = 64;
    synchronized (peN)
    {
      peN.put(paramString, new WeakReference(paraml));
      boolean bool = a(localr);
      AppMethodBeat.o(148462);
      return bool;
    }
  }
  
  public static String af(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148460);
    f.a locala = new f.a();
    String str = FilePathGenerator.genPath(bzN(), "msg_", paramString, ".amr", 2);
    Log.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.aPY() + " " + str);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(148460);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(148460);
      return str;
    }
    if (new u(str).jKS())
    {
      AppMethodBeat.o(148460);
      return str;
    }
    paramString = bPn() + paramString;
    if (new u(paramString + ".amr").jKS()) {
      y.qn(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(148460);
      return str;
      if (new u(paramString).jKS()) {
        y.qn(paramString, str);
      }
    }
  }
  
  public static boolean aw(cc paramcc)
  {
    AppMethodBeat.i(148486);
    if ((paramcc == null) || (!paramcc.iYj()))
    {
      AppMethodBeat.o(148486);
      return false;
    }
    boolean bool = new p(paramcc.field_content).paW;
    AppMethodBeat.o(148486);
    return bool;
  }
  
  public static boolean ax(cc paramcc)
  {
    AppMethodBeat.i(148487);
    if ((paramcc == null) || (!paramcc.iYj()) || (paramcc.field_isSend == 1))
    {
      AppMethodBeat.o(148487);
      return false;
    }
    if (new p(paramcc.field_content).time == 0L)
    {
      AppMethodBeat.o(148487);
      return true;
    }
    AppMethodBeat.o(148487);
    return false;
  }
  
  public static void ay(cc paramcc)
  {
    AppMethodBeat.i(148488);
    if ((paramcc == null) || (!paramcc.iYj()))
    {
      AppMethodBeat.o(148488);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramcc.field_msgId);
    if ((localObject == null) || (((fi)localObject).field_msgId != paramcc.field_msgId))
    {
      AppMethodBeat.o(148488);
      return;
    }
    localObject = new p(((fi)localObject).field_content);
    if (((p)localObject).paW)
    {
      AppMethodBeat.o(148488);
      return;
    }
    ((p)localObject).paW = true;
    paramcc.setContent(((p)localObject).bPi());
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramcc.field_msgId, paramcc);
    AppMethodBeat.o(148488);
  }
  
  public static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(148470);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(148470);
      return paramInt1;
    }
    if (paramInt1 == 0) {
      paramInt1 = paramArrayOfByte.hashCode() & 0xFF;
    }
    int j;
    for (int i = paramInt1;; i = paramInt1 & 0xFF)
    {
      int k = 0;
      j = paramInt1;
      paramInt1 = k;
      while (paramInt1 < paramInt2)
      {
        j += (paramArrayOfByte[(paramInt1 + 0)] & i) * 256;
        paramInt1 += 1;
      }
    }
    AppMethodBeat.o(148470);
    return j;
  }
  
  public static List<r> bPm()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(148483);
    Object localObject1 = o.bPf();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag, VoiceInfoExt" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).omV.rawQuery((String)localObject2, null, 2);
    int j = 0;
    int i = 0;
    if (((Cursor)localObject1).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        localObject2 = new r();
        ((r)localObject2).convertFrom((Cursor)localObject1);
        localArrayList.add(localObject2);
        j = i + 1;
        i = j;
      } while (((Cursor)localObject1).moveToNext());
    }
    Log.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
    ((Cursor)localObject1).close();
    AppMethodBeat.o(148483);
    return localArrayList;
  }
  
  public static String bPn()
  {
    AppMethodBeat.i(148490);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().mCJ + "voice/";
    AppMethodBeat.o(148490);
    return localObject;
  }
  
  public static b bT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148456);
    w localw = o.bPf();
    paramString2 = getFullPath(paramString2);
    switch (Util.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.peZ.get(paramString2) == null) {
        localw.peZ.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.peZ.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    case 4: 
      if (localw.pfb.get(paramString2) == null) {
        localw.pfb.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.pfb.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    }
    if (localw.pfa.get(paramString2) == null) {
      localw.pfa.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.pfa.get(paramString2);
    AppMethodBeat.o(148456);
    return paramString1;
  }
  
  public static boolean bi(String paramString, int paramInt)
  {
    AppMethodBeat.i(148467);
    boolean bool = z(paramString, paramInt, 0);
    AppMethodBeat.o(148467);
    return bool;
  }
  
  public static String bzN()
  {
    AppMethodBeat.i(148491);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().mCJ + "voice2/";
    AppMethodBeat.o(148491);
    return localObject;
  }
  
  public static String getFullPath(String paramString)
  {
    AppMethodBeat.i(148459);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148459);
      return null;
    }
    paramString = af(paramString, false);
    AppMethodBeat.o(148459);
    return paramString;
  }
  
  public static float jh(long paramLong)
  {
    float f2 = 60.0F;
    float f1 = 1.0F;
    AppMethodBeat.i(148485);
    float f3 = (float)paramLong / 1000.0F;
    if (f3 < 1.0F) {}
    for (;;)
    {
      if (f1 > 60.0F) {
        f1 = f2;
      }
      for (;;)
      {
        f1 = Math.round(f1);
        AppMethodBeat.o(148485);
        return f1;
      }
      f1 = f3;
    }
  }
  
  public static String s(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148479);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if ((!Util.isNullOrNil(paramString2)) && (!paramString2.startsWith("amr_")) && (!paramString2.startsWith("spx_"))) {
      paramString2.startsWith("silk_");
    }
    paramString1 = QJ(paramString1);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if (y.O(getFullPath(paramString2), getFullPath(paramString1), false) < 0L)
    {
      AppMethodBeat.o(148479);
      return null;
    }
    z(paramString1, paramInt, 1);
    AppMethodBeat.o(148479);
    return paramString1;
  }
  
  public static int xi(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean xj(int paramInt)
  {
    AppMethodBeat.i(148478);
    cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramInt);
    if ((localcc == null) || (localcc.field_msgId == 0L) || (localcc.field_imgPath == null))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    if (Util.isNullOrNil(localcc.field_imgPath))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    Object localObject = localcc.field_imgPath;
    localObject = o.bPf().QT((String)localObject);
    if ((localObject == null) || (Util.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).oZm = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).pba = (System.currentTimeMillis() / 1000L);
    ((r)localObject).eQp = 8648;
    boolean bool = a((r)localObject);
    Log.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).pbc + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).pbc == 0) || (Util.isNullOrNil(((r)localObject).hVQ)))
    {
      Log.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).pbc + " user:" + ((r)localObject).hVQ);
      AppMethodBeat.o(148478);
      return bool;
    }
    localcc.setStatus(1);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(localcc.field_msgId, localcc);
    o.bPh().run();
    AppMethodBeat.o(148478);
    return true;
  }
  
  private static boolean z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148468);
    if (paramString == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    Log.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.bPf().QT(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).osy = q.PZ(paramString);
    if (((r)???).osy <= 0)
    {
      Qf(paramString);
      AppMethodBeat.o(148468);
      return false;
    }
    ((r)???).pba = (System.currentTimeMillis() / 1000L);
    ((r)???).peH = paramInt1;
    ((r)???).eQp = 3424;
    cc localcc = new cc();
    localcc.BS(((r)???).hVQ);
    localcc.setType(34);
    localcc.pI(1);
    localcc.BT(paramString);
    if (((r)???).status == 97)
    {
      localcc.setStatus(2);
      localcc.setContent(p.a(((r)???).paV, ((r)???).peH, false));
    }
    for (;;)
    {
      localcc.setCreateTime(br.JN(((r)???).hVQ));
      localcc.ayZ(paramInt2);
      a.a.aOb().n(localcc);
      ((r)???).pbc = ((int)br.B(localcc));
      boolean bool = a((r)???);
      synchronized (peN)
      {
        peN.remove(paramString);
        AppMethodBeat.o(148468);
        return bool;
        if (((r)???).status == 98)
        {
          localcc.setStatus(5);
          localcc.setContent(p.a(((r)???).paV, -1L, true));
          continue;
        }
        localcc.setStatus(1);
        localcc.setContent(p.a(((r)???).paV, ((r)???).peH, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */