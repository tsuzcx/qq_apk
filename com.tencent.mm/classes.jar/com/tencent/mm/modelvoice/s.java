package com.tencent.mm.modelvoice;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.m;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.a.aai;
import com.tencent.mm.f.a.mk;
import com.tencent.mm.f.c.et;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static final HashMap<String, WeakReference<m>> mlb;
  public static volatile HashMap<String, Integer> mlc;
  public static volatile HashMap<String, Integer> mld;
  public static volatile HashMap<String, Integer> mle;
  
  static
  {
    AppMethodBeat.i(148492);
    mlb = new HashMap();
    mlc = new HashMap();
    mld = new HashMap();
    mle = new HashMap();
    AppMethodBeat.o(148492);
  }
  
  public static float GW(long paramLong)
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
  
  public static boolean YB(String paramString)
  {
    AppMethodBeat.i(148455);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString = o.brz().YO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    if (paramString.mhS >= 250)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString.mhS += 1;
    paramString.cUP = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(148455);
    return bool;
  }
  
  public static b YC(String paramString)
  {
    AppMethodBeat.i(148457);
    w localw = o.brz();
    String str = getFullPath(paramString);
    switch (q.Yz(paramString))
    {
    default: 
      if (localw.mln.get(str) == null) {
        localw.mln.put(str, new a(str));
      }
      paramString = (b)localw.mln.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 0: 
      if (localw.mln.get(str) == null) {
        localw.mln.put(str, new a(str));
      }
      paramString = (b)localw.mln.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 1: 
      if (localw.mlo.get(str) == null) {
        localw.mlo.put(str, new n(str));
      }
      paramString = (b)localw.mlo.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    }
    if (localw.mlp.get(str) == null) {
      localw.mlp.put(str, new j(str));
    }
    paramString = (b)localw.mlp.get(str);
    AppMethodBeat.o(148457);
    return paramString;
  }
  
  private static void YD(String paramString)
  {
    AppMethodBeat.i(148458);
    w localw = o.brz();
    String str = getFullPath(paramString);
    switch (q.Yz(paramString))
    {
    default: 
      paramString = (a)localw.mln.get(str);
      if (paramString != null)
      {
        paramString.brn();
        localw.mln.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 0: 
      paramString = (a)localw.mln.get(str);
      if (paramString != null)
      {
        paramString.brn();
        localw.mln.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 1: 
      paramString = (n)localw.mlo.get(str);
      if (paramString != null)
      {
        paramString.brn();
        localw.mlo.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    }
    paramString = (j)localw.mlp.get(str);
    if (paramString != null)
    {
      paramString.brn();
      localw.mlp.remove(str);
    }
    AppMethodBeat.o(148458);
  }
  
  public static String YE(String paramString)
  {
    AppMethodBeat.i(148461);
    String str = w.YN(z.bcZ());
    r localr = new r();
    localr.fileName = str;
    localr.fPV = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.mhP = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.mhK = z.bcZ();
    localr.cUP = -1;
    if (!o.brz().b(localr))
    {
      AppMethodBeat.o(148461);
      return null;
    }
    Log.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(148461);
    return str;
  }
  
  public static boolean YF(String paramString)
  {
    AppMethodBeat.i(148463);
    if (paramString == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    Log.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.brz().YO(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    localr.status = 8;
    localr.lAW = q.XV(paramString);
    localr.cUP = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(148463);
    return bool;
  }
  
  public static boolean YG(String paramString)
  {
    AppMethodBeat.i(148464);
    if (paramString == null)
    {
      AppMethodBeat.o(148464);
      return false;
    }
    r localr = o.brz().YO(paramString);
    if (localr == null)
    {
      Log.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148464);
      return true;
    }
    Log.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.fNu);
    if (localr.fNu != 0L) {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aV(localr.fPV, localr.fNu);
    }
    boolean bool = YI(paramString);
    AppMethodBeat.o(148464);
    return bool;
  }
  
  public static boolean YH(String paramString)
  {
    AppMethodBeat.i(148465);
    if (paramString == null)
    {
      AppMethodBeat.o(148465);
      return false;
    }
    r localr = o.brz().YO(paramString);
    if (localr == null)
    {
      Log.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148465);
      return true;
    }
    Log.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.mhR);
    if (localr.mhR != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Or(localr.mhR);
    }
    boolean bool = YI(paramString);
    AppMethodBeat.o(148465);
    return bool;
  }
  
  public static boolean YI(String paramString)
  {
    AppMethodBeat.i(148466);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    o.brz().ho(paramString);
    YD(paramString);
    paramString = getFullPath(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    boolean bool = new com.tencent.mm.vfs.q(paramString).cFq();
    AppMethodBeat.o(148466);
    return bool;
  }
  
  /* Error */
  public static boolean YJ(String paramString)
  {
    // Byte code:
    //   0: ldc_w 296
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 57	com/tencent/mm/modelvoice/o:brz	()Lcom/tencent/mm/modelvoice/w;
    //   9: aload_0
    //   10: invokevirtual 63	com/tencent/mm/modelvoice/w:YO	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +11 -> 26
    //   18: ldc_w 296
    //   21: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_1
    //   25: ireturn
    //   26: new 287	com/tencent/mm/vfs/q
    //   29: dup
    //   30: aload_0
    //   31: invokestatic 83	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokespecial 288	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_0
    //   39: invokestatic 298	com/tencent/mm/modelvoice/s:YC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +80 -> 124
    //   47: aload_1
    //   48: instanceof 101
    //   51: ifeq +73 -> 124
    //   54: aload_3
    //   55: invokevirtual 301	com/tencent/mm/vfs/q:length	()J
    //   58: aload_2
    //   59: getfield 212	com/tencent/mm/modelvoice/r:lAW	I
    //   62: i2l
    //   63: lsub
    //   64: invokestatic 305	java/lang/Math:abs	(J)J
    //   67: ldc2_w 306
    //   70: lcmp
    //   71: ifne +53 -> 124
    //   74: ldc 180
    //   76: ldc_w 309
    //   79: iconst_2
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_3
    //   86: invokevirtual 301	com/tencent/mm/vfs/q:length	()J
    //   89: invokestatic 314	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_2
    //   96: getfield 212	com/tencent/mm/modelvoice/r:lAW	I
    //   99: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokeinterface 323 1 0
    //   116: ldc_w 296
    //   119: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_3
    //   125: invokevirtual 301	com/tencent/mm/vfs/q:length	()J
    //   128: aload_2
    //   129: getfield 212	com/tencent/mm/modelvoice/r:lAW	I
    //   132: i2l
    //   133: lcmp
    //   134: ifeq +53 -> 187
    //   137: ldc 180
    //   139: ldc_w 325
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_3
    //   149: invokevirtual 301	com/tencent/mm/vfs/q:length	()J
    //   152: invokestatic 314	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_2
    //   159: getfield 212	com/tencent/mm/modelvoice/r:lAW	I
    //   162: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 328	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 323 1 0
    //   179: ldc_w 296
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_1
    //   188: iconst_0
    //   189: aload_2
    //   190: getfield 212	com/tencent/mm/modelvoice/r:lAW	I
    //   193: invokeinterface 332 3 0
    //   198: astore_0
    //   199: aload_0
    //   200: getfield 337	com/tencent/mm/modelvoice/g:ret	I
    //   203: ifne +76 -> 279
    //   206: aload_2
    //   207: getfield 340	com/tencent/mm/modelvoice/r:mkZ	I
    //   210: ifeq +69 -> 279
    //   213: aload_2
    //   214: getfield 340	com/tencent/mm/modelvoice/r:mkZ	I
    //   217: aload_2
    //   218: getfield 340	com/tencent/mm/modelvoice/r:mkZ	I
    //   221: sipush 255
    //   224: iand
    //   225: aload_0
    //   226: getfield 344	com/tencent/mm/modelvoice/g:buf	[B
    //   229: aload_0
    //   230: getfield 347	com/tencent/mm/modelvoice/g:fsR	I
    //   233: invokestatic 351	com/tencent/mm/modelvoice/s:c	(I[BI)I
    //   236: if_icmpeq +43 -> 279
    //   239: ldc 180
    //   241: ldc_w 353
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_2
    //   251: getfield 340	com/tencent/mm/modelvoice/r:mkZ	I
    //   254: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 328	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_1
    //   262: ifnull +9 -> 271
    //   265: aload_1
    //   266: invokeinterface 323 1 0
    //   271: ldc_w 296
    //   274: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload_1
    //   280: ifnull +9 -> 289
    //   283: aload_1
    //   284: invokeinterface 323 1 0
    //   289: ldc_w 296
    //   292: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_1
    //   301: ifnull +9 -> 310
    //   304: aload_1
    //   305: invokeinterface 323 1 0
    //   310: ldc_w 296
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
    //   334	1	1	localThrowable	java.lang.Throwable
    //   13	238	2	localr	r
    //   37	112	3	localq	com.tencent.mm.vfs.q
    // Exception table:
    //   from	to	target	type
    //   38	43	297	finally
    //   110	116	318	java/lang/Throwable
    //   173	179	322	java/lang/Throwable
    //   265	271	326	java/lang/Throwable
    //   283	289	330	java/lang/Throwable
    //   304	310	334	java/lang/Throwable
    //   47	106	338	finally
    //   124	169	338	finally
    //   187	261	338	finally
  }
  
  public static ca YK(String paramString)
  {
    AppMethodBeat.i(148481);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = o.brz().YO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramString.mhR);
    AppMethodBeat.o(148481);
    return paramString;
  }
  
  public static r YL(String paramString)
  {
    AppMethodBeat.i(292906);
    paramString = o.brz().YO(paramString);
    AppMethodBeat.o(292906);
    return paramString;
  }
  
  public static int YM(String paramString)
  {
    AppMethodBeat.i(148489);
    synchronized (mlb)
    {
      if (mlb.get(paramString) != null)
      {
        paramString = (m)((WeakReference)mlb.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.aff();
          AppMethodBeat.o(148489);
          return i;
        }
      }
      AppMethodBeat.o(148489);
      return -1;
    }
  }
  
  public static boolean Yb(String paramString)
  {
    AppMethodBeat.i(148480);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(148480);
      return false;
    }
    r localr = o.brz().YO(paramString);
    if (localr == null)
    {
      Log.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148480);
      return false;
    }
    localr.status = 98;
    localr.mhP = (System.currentTimeMillis() / 1000L);
    localr.cUP = 320;
    boolean bool = a(localr);
    Log.i("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localr.mhR + " old stat:" + localr.status);
    if ((localr.mhR == 0) || (Util.isNullOrNil(localr.fPV)))
    {
      Log.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localr.mhR + " user:" + localr.fPV);
      AppMethodBeat.o(148480);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(localr.mhR);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 33L, 1L, true);
    paramString.setMsgId(localr.mhR);
    paramString.setStatus(5);
    paramString.Jm(localr.fPV);
    paramString.setContent(p.a(localr.mhK, Math.max(localr.mkW, 0), true));
    paramString.hAf();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(paramString.field_msgId, paramString);
    aai localaai = new aai();
    localaai.fZA.msgId = paramString.field_msgId;
    localaai.fZA.success = false;
    localaai.fZA.fZB = localr.brF();
    EventCenter.instance.asyncPublish(localaai, Looper.getMainLooper());
    AppMethodBeat.o(148480);
    return bool;
  }
  
  public static boolean Yc(String paramString)
  {
    AppMethodBeat.i(148477);
    paramString = o.brz().YO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148477);
      return false;
    }
    if (paramString.status == 3)
    {
      ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramString.mhR);
      localca.setContent(p.a(paramString.mhK, paramString.mkW, false));
      localca.setStatus(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(paramString.mhR, localca);
    }
    paramString.status = 97;
    paramString.mhP = (System.currentTimeMillis() / 1000L);
    paramString.cUP = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(148477);
    return bool;
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, h.a parama)
  {
    AppMethodBeat.i(148473);
    f.a locala = new f.a();
    r localr = o.brz().GX(paramr.fNu);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    if ((((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aL(paramr.fPV, paramr.fNu).field_msgSvrId == paramr.fNu) && (localr == null))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    boolean bool1;
    String str1;
    String str2;
    int i;
    if (localr != null)
    {
      paramr.fileName = localr.fileName;
      paramr.cUP |= 0x1;
      Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.avD() + "checktime :" + locala.avE());
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
          str1 = paramr.mjM;
          str2 = paramr.fileName;
          i = bH(str1, str2).A(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label639;
          }
          Log.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label276:
          paramr.mkZ = c(paramr.mkZ, paramArrayOfByte, paramArrayOfByte.length);
          paramr.cUP |= 0x80000;
        }
      }
      Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.avD() + "checktime :" + locala.avE());
      paramr.mhP = (System.currentTimeMillis() / 1000L);
      paramr.cUP |= 0x100;
      if (!bool1) {
        break label764;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.cUP |= 0x40;
      if (localr != null) {
        break label836;
      }
      paramr.mhR = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      if (parama != null)
      {
        paramr.hxx = bq.d(parama);
        if (parama.jQG != null) {
          paramr.mkX = parama.jQG.RIK;
        }
      }
      Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.avD() + "checktime :" + locala.avE());
      paramr.cUP = -1;
      Log.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.mgq + " total:" + paramr.lAW);
      if (o.brz().b(paramr)) {
        break label788;
      }
      Log.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.mgq + " total:" + paramr.lAW);
      AppMethodBeat.o(148473);
      return -2;
      paramr.fileName = w.YN(paramr.mhK);
      break;
      label639:
      if (paramArrayOfByte.length != i)
      {
        Log.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label276;
      }
      Log.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      YD(str2);
      bool1 = true;
      break label276;
      label764:
      if (paramr.lAW == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label788:
    Log.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.f.avD() + "checktime :" + locala.avE());
    if (bool1)
    {
      AppMethodBeat.o(148473);
      return 1;
      label836:
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
    if ((localr != null) && (localr.mhM == paramr.lAW))
    {
      a(localr.fileName, localr.mhM, parama);
      Log.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    Log.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), Util.getStack() });
    o.brB().run();
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
    r localr = o.brz().YO(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    localr.mgq = paramInt1;
    localr.mhP = (System.currentTimeMillis() / 1000L);
    localr.cUP = 264;
    if ((Util.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.cUP |= 0x200;
    }
    if ((localr.fNu == 0L) && (paramLong != 0L))
    {
      localr.fNu = paramLong;
      localr.cUP |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.lAW <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.cUP |= 0x40;
          paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(localr.mhR);
          paramString2.Jm(localr.fPV);
          paramString2.EG(localr.fNu);
          paramString2.setStatus(2);
          paramString2.setContent(p.a(localr.mhK, localr.mkW, false));
          paramString2.asJ(paramInt3);
          Integer localInteger = (Integer)mlc.get(getFullPath(paramString1));
          if (localInteger != null)
          {
            localr.mkZ = localInteger.intValue();
            localr.cUP |= 0x80000;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(localr.mhR, paramString2);
          Log.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.lAW + " status:" + localr.status + " netTimes:" + localr.mhS + " msgId:" + paramString2.field_msgId);
          i = 1;
          YD(paramString1);
        }
      }
    }
    if (!a(localr))
    {
      AppMethodBeat.o(148469);
      return -4;
    }
    AppMethodBeat.o(148469);
    return i;
  }
  
  public static int a(String paramString, int paramInt, h.a parama)
  {
    int j = 0;
    AppMethodBeat.i(148476);
    if (paramString == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    r localr = o.brz().YO(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    localr.mhM = paramInt;
    localr.mhP = (System.currentTimeMillis() / 1000L);
    localr.cUP = 272;
    int i = j;
    if (localr.lAW > 0)
    {
      i = j;
      if (paramInt >= localr.lAW)
      {
        a(localr, parama);
        localr.status = 99;
        localr.mla = 0;
        localr.cUP = (localr.cUP | 0x40 | 0x100000);
        Log.i("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.lAW + " status:" + localr.status + " netTimes:" + localr.mhS);
        i = 1;
        YD(paramString);
      }
    }
    Log.i("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.lAW + " status:" + localr.status);
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
    paramString = o.brz().YO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148471);
      return -1;
    }
    paramString.mkZ = c(paramString.mkZ, paramArrayOfByte, paramInt);
    paramString.cUP |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.mkZ;
      AppMethodBeat.o(148471);
      return paramInt;
    }
    AppMethodBeat.o(148471);
    return 0;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, h.a parama)
  {
    AppMethodBeat.i(148475);
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Os(paramr.fNu))
    {
      Log.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.fNu) });
      if (Util.nullAsNil(paramr.fileName).length() > 0) {
        o.brz().ho(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(148475);
        return -1L;
        Log.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aL(paramr.fPV, paramr.fNu);
    int i = 0;
    if (localca.field_msgSvrId != paramr.fNu)
    {
      localca = new ca();
      localca.EG(paramr.fNu);
      localca.Jn(paramr.fileName);
      localca.setCreateTime(bq.z(paramr.fPV, paramr.createTime));
      localca.Jm(paramr.fPV);
      if (z.PD(paramr.mhK))
      {
        i = 1;
        localca.pJ(i);
        localca.setType(34);
        localca.asJ(paramr.mjT);
        i = 1;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localca.hAf();
        label242:
        localca.Ju(paramString1);
        localca.setStatus(paramInt);
        if (parama != null) {
          break label575;
        }
        paramInt = paramr.hxx;
        if (paramInt != 0)
        {
          Log.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
          localca.setFlag(paramInt);
          if ((localca.field_msgId == 0L) && (localca.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
            localca.setCreateTime(bq.k(localca.field_talker, paramr.createTime, localca.field_msgSeq));
          }
        }
        if (paramr.mkX != 0) {
          localca.EI(paramr.mkX);
        }
        Log.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.mkX) });
        label385:
        Log.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
        if (!Util.isNullOrNil(paramString2))
        {
          localca.Ip(paramString2);
          localca.Jv(bq.RS(paramString2));
        }
        if (paramBoolean) {
          break label585;
        }
        localca.setContent(p.a(paramr.mhK, Math.max(paramr.mkW, 0), false));
        label453:
        Log.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localca.field_msgSvrId), Long.valueOf(localca.field_msgSeq) });
        if (i == 0) {
          break label731;
        }
      }
      for (long l = bq.z(localca);; l = localca.field_msgId)
      {
        if (paramBoolean)
        {
          paramString1 = new aai();
          paramString1.fZA.msgId = localca.field_msgId;
          paramString1.fZA.success = true;
          paramString1.fZA.fZB = paramr.brF();
          EventCenter.instance.asyncPublish(paramString1, Looper.getMainLooper());
        }
        AppMethodBeat.o(148475);
        return l;
        i = 0;
        break;
        localca.hAe();
        break label242;
        label575:
        bq.a(localca, parama);
        break label385;
        label585:
        localca.setContent(p.a(paramr.mhK, paramr.mkW, false));
        if (Util.isNullOrNil(paramString2)) {
          break label453;
        }
        localca.Ip(paramString2);
        localca.Jv(bq.RS(paramString2));
        paramString1 = bq.RR(paramString2);
        if (paramString1 == null) {
          break label453;
        }
        localca.Jv(paramString1.lut);
        localca.qb(paramString1.luu);
        localca.Jq(paramString1.lus);
        Log.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramString1.lus });
        if (paramString1.luy == null) {
          break label453;
        }
        paramString2 = new mk();
        paramString2.fKv.fvt = localca;
        paramString2.fKv.fKw = paramString1;
        EventCenter.instance.publish(paramString2);
        break label453;
        label731:
        bq.A(localca);
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
    if (paramr.cUP == -1)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    boolean bool = o.brz().a(paramr.fileName, paramr);
    AppMethodBeat.o(148484);
    return bool;
  }
  
  private static boolean a(r paramr, h.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      paramr.mhR = ((int)a(paramr, true, 3, "", paramr.hxy, parama));
      paramr.cUP |= 0x800;
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
  
  public static boolean a(String paramString, m paramm)
  {
    AppMethodBeat.i(148462);
    if (paramString == null)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    r localr = o.brz().YO(paramString);
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
    localr.cUP = 64;
    synchronized (mlb)
    {
      mlb.put(paramString, new WeakReference(paramm));
      boolean bool = a(localr);
      AppMethodBeat.o(148462);
      return bool;
    }
  }
  
  public static boolean aU(String paramString, int paramInt)
  {
    AppMethodBeat.i(148467);
    boolean bool = w(paramString, paramInt, 0);
    AppMethodBeat.o(148467);
    return bool;
  }
  
  public static String aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148460);
    f.a locala = new f.a();
    String str = FilePathGenerator.genPath(bbY(), "msg_", paramString, ".amr", 2);
    Log.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.avE() + " " + str);
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
    if (new com.tencent.mm.vfs.q(str).ifE())
    {
      AppMethodBeat.o(148460);
      return str;
    }
    paramString = brH() + paramString;
    if (new com.tencent.mm.vfs.q(paramString + ".amr").ifE()) {
      u.oo(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(148460);
      return str;
      if (new com.tencent.mm.vfs.q(paramString).ifE()) {
        u.oo(paramString, str);
      }
    }
  }
  
  public static boolean aq(ca paramca)
  {
    AppMethodBeat.i(148486);
    if ((paramca == null) || (!paramca.hwF()))
    {
      AppMethodBeat.o(148486);
      return false;
    }
    boolean bool = new p(paramca.field_content).mhL;
    AppMethodBeat.o(148486);
    return bool;
  }
  
  public static boolean ar(ca paramca)
  {
    AppMethodBeat.i(148487);
    if ((paramca == null) || (!paramca.hwF()) || (paramca.field_isSend == 1))
    {
      AppMethodBeat.o(148487);
      return false;
    }
    if (new p(paramca.field_content).time == 0L)
    {
      AppMethodBeat.o(148487);
      return true;
    }
    AppMethodBeat.o(148487);
    return false;
  }
  
  public static void as(ca paramca)
  {
    AppMethodBeat.i(148488);
    if ((paramca == null) || (!paramca.hwF()))
    {
      AppMethodBeat.o(148488);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramca.field_msgId);
    if (((et)localObject).field_msgId != paramca.field_msgId)
    {
      AppMethodBeat.o(148488);
      return;
    }
    localObject = new p(((et)localObject).field_content);
    if (((p)localObject).mhL)
    {
      AppMethodBeat.o(148488);
      return;
    }
    ((p)localObject).mhL = true;
    paramca.setContent(((p)localObject).brC());
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(paramca.field_msgId, paramca);
    AppMethodBeat.o(148488);
  }
  
  /* Error */
  public static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
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
  
  public static b bH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148456);
    w localw = o.brz();
    paramString2 = getFullPath(paramString2);
    switch (Util.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.mln.get(paramString2) == null) {
        localw.mln.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.mln.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    case 4: 
      if (localw.mlp.get(paramString2) == null) {
        localw.mlp.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.mlp.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    }
    if (localw.mlo.get(paramString2) == null) {
      localw.mlo.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.mlo.get(paramString2);
    AppMethodBeat.o(148456);
    return paramString1;
  }
  
  public static String bbY()
  {
    AppMethodBeat.i(148491);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().kcB + "voice2/";
    AppMethodBeat.o(148491);
    return localObject;
  }
  
  public static List<r> brG()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(148483);
    Object localObject1 = o.brz();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).lvy.rawQuery((String)localObject2, null, 2);
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
  
  public static String brH()
  {
    AppMethodBeat.i(148490);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().kcB + "voice/";
    AppMethodBeat.o(148490);
    return localObject;
  }
  
  public static int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
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
  
  public static String getFullPath(String paramString)
  {
    AppMethodBeat.i(148459);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148459);
      return null;
    }
    paramString = aa(paramString, false);
    AppMethodBeat.o(148459);
    return paramString;
  }
  
  public static String p(String paramString1, String paramString2, int paramInt)
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
    paramString1 = YE(paramString1);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if (u.on(getFullPath(paramString2), getFullPath(paramString1)) < 0L)
    {
      AppMethodBeat.o(148479);
      return null;
    }
    w(paramString1, paramInt, 1);
    AppMethodBeat.o(148479);
    return paramString1;
  }
  
  private static boolean w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148468);
    if (paramString == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    Log.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.brz().YO(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).lAW = q.XV(paramString);
    if (((r)???).lAW <= 0)
    {
      Yb(paramString);
      AppMethodBeat.o(148468);
      return false;
    }
    ((r)???).mhP = (System.currentTimeMillis() / 1000L);
    ((r)???).mkW = paramInt1;
    ((r)???).cUP = 3424;
    ca localca = new ca();
    localca.Jm(((r)???).fPV);
    localca.setType(34);
    localca.pJ(1);
    localca.Jn(paramString);
    if (((r)???).status == 97)
    {
      localca.setStatus(2);
      localca.setContent(p.a(((r)???).mhK, ((r)???).mkW, false));
    }
    for (;;)
    {
      localca.setCreateTime(bq.RP(((r)???).fPV));
      localca.asJ(paramInt2);
      a.a.atD().n(localca);
      ((r)???).mhR = ((int)bq.z(localca));
      boolean bool = a((r)???);
      synchronized (mlb)
      {
        mlb.remove(paramString);
        AppMethodBeat.o(148468);
        return bool;
        if (((r)???).status == 98)
        {
          localca.setStatus(5);
          localca.setContent(p.a(((r)???).mhK, -1L, true));
          continue;
        }
        localca.setStatus(1);
        localca.setContent(p.a(((r)???).mhK, ((r)???).mkW, false));
      }
    }
  }
  
  public static int xi(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean xj(int paramInt)
  {
    AppMethodBeat.i(148478);
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramInt);
    if ((localca.field_msgId == 0L) || (localca.field_imgPath == null))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    if (Util.isNullOrNil(localca.field_imgPath))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    Object localObject = localca.field_imgPath;
    localObject = o.brz().YO((String)localObject);
    if ((localObject == null) || (Util.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).mgq = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).mhP = (System.currentTimeMillis() / 1000L);
    ((r)localObject).cUP = 8648;
    boolean bool = a((r)localObject);
    Log.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).mhR + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).mhR == 0) || (Util.isNullOrNil(((r)localObject).fPV)))
    {
      Log.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).mhR + " user:" + ((r)localObject).fPV);
      AppMethodBeat.o(148478);
      return bool;
    }
    localca.setStatus(1);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(localca.field_msgId, localca);
    o.brB().run();
    AppMethodBeat.o(148478);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */