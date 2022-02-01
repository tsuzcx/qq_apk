package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static final HashMap<String, WeakReference<com.tencent.mm.ak.k>> idV;
  public static volatile HashMap<String, Integer> idW;
  public static volatile HashMap<String, Integer> idX;
  public static volatile HashMap<String, Integer> idY;
  
  static
  {
    AppMethodBeat.i(148492);
    idV = new HashMap();
    idW = new HashMap();
    idX = new HashMap();
    idY = new HashMap();
    AppMethodBeat.o(148492);
  }
  
  public static boolean EB(String paramString)
  {
    AppMethodBeat.i(148455);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString = o.aKp().EO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    if (paramString.iaK >= 250)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString.iaK += 1;
    paramString.drx = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(148455);
    return bool;
  }
  
  public static b EC(String paramString)
  {
    AppMethodBeat.i(148457);
    w localw = o.aKp();
    String str = getFullPath(paramString);
    switch (q.Ez(paramString))
    {
    default: 
      if (localw.ieh.get(str) == null) {
        localw.ieh.put(str, new a(str));
      }
      paramString = (b)localw.ieh.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 0: 
      if (localw.ieh.get(str) == null) {
        localw.ieh.put(str, new a(str));
      }
      paramString = (b)localw.ieh.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 1: 
      if (localw.iei.get(str) == null) {
        localw.iei.put(str, new n(str));
      }
      paramString = (b)localw.iei.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    }
    if (localw.iej.get(str) == null) {
      localw.iej.put(str, new j(str));
    }
    paramString = (b)localw.iej.get(str);
    AppMethodBeat.o(148457);
    return paramString;
  }
  
  private static void ED(String paramString)
  {
    AppMethodBeat.i(148458);
    w localw = o.aKp();
    String str = getFullPath(paramString);
    switch (q.Ez(paramString))
    {
    default: 
      paramString = (a)localw.ieh.get(str);
      if (paramString != null)
      {
        paramString.aKd();
        localw.ieh.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 0: 
      paramString = (a)localw.ieh.get(str);
      if (paramString != null)
      {
        paramString.aKd();
        localw.ieh.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 1: 
      paramString = (n)localw.iei.get(str);
      if (paramString != null)
      {
        paramString.aKd();
        localw.iei.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    }
    paramString = (j)localw.iej.get(str);
    if (paramString != null)
    {
      paramString.aKd();
      localw.iej.remove(str);
    }
    AppMethodBeat.o(148458);
  }
  
  public static String EE(String paramString)
  {
    AppMethodBeat.i(148461);
    String str = w.EN(u.axw());
    r localr = new r();
    localr.fileName = str;
    localr.drG = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.iaH = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.iaC = u.axw();
    localr.drx = -1;
    if (!o.aKp().b(localr))
    {
      AppMethodBeat.o(148461);
      return null;
    }
    ac.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(148461);
    return str;
  }
  
  public static boolean EF(String paramString)
  {
    AppMethodBeat.i(148463);
    if (paramString == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    ac.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.aKp().EO(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    localr.status = 8;
    localr.hux = q.DX(paramString);
    localr.drx = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(148463);
    return bool;
  }
  
  public static boolean EG(String paramString)
  {
    AppMethodBeat.i(148464);
    if (paramString == null)
    {
      AppMethodBeat.o(148464);
      return false;
    }
    r localr = o.aKp().EO(paramString);
    if (localr == null)
    {
      ac.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148464);
      return true;
    }
    ac.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.dpl);
    if (localr.dpl != 0L) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aR(localr.drG, localr.dpl);
    }
    boolean bool = EI(paramString);
    AppMethodBeat.o(148464);
    return bool;
  }
  
  public static boolean EH(String paramString)
  {
    AppMethodBeat.i(148465);
    if (paramString == null)
    {
      AppMethodBeat.o(148465);
      return false;
    }
    r localr = o.aKp().EO(paramString);
    if (localr == null)
    {
      ac.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148465);
      return true;
    }
    ac.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.iaJ);
    if (localr.iaJ != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vQ(localr.iaJ);
    }
    boolean bool = EI(paramString);
    AppMethodBeat.o(148465);
    return bool;
  }
  
  public static boolean EI(String paramString)
  {
    AppMethodBeat.i(148466);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    o.aKp().zB(paramString);
    ED(paramString);
    boolean bool = new com.tencent.mm.vfs.e(getFullPath(paramString)).delete();
    AppMethodBeat.o(148466);
    return bool;
  }
  
  /* Error */
  public static boolean EJ(String paramString)
  {
    // Byte code:
    //   0: ldc_w 285
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 46	com/tencent/mm/modelvoice/o:aKp	()Lcom/tencent/mm/modelvoice/w;
    //   9: aload_0
    //   10: invokevirtual 52	com/tencent/mm/modelvoice/w:EO	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +11 -> 26
    //   18: ldc_w 285
    //   21: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_1
    //   25: ireturn
    //   26: new 276	com/tencent/mm/vfs/e
    //   29: dup
    //   30: aload_0
    //   31: invokestatic 72	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokespecial 277	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_0
    //   39: invokestatic 287	com/tencent/mm/modelvoice/s:EC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +80 -> 124
    //   47: aload_1
    //   48: instanceof 90
    //   51: ifeq +73 -> 124
    //   54: aload_3
    //   55: invokevirtual 290	com/tencent/mm/vfs/e:length	()J
    //   58: aload_2
    //   59: getfield 201	com/tencent/mm/modelvoice/r:hux	I
    //   62: i2l
    //   63: lsub
    //   64: invokestatic 296	java/lang/Math:abs	(J)J
    //   67: ldc2_w 297
    //   70: lcmp
    //   71: ifne +53 -> 124
    //   74: ldc 169
    //   76: ldc_w 300
    //   79: iconst_2
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_3
    //   86: invokevirtual 290	com/tencent/mm/vfs/e:length	()J
    //   89: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_2
    //   96: getfield 201	com/tencent/mm/modelvoice/r:hux	I
    //   99: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 313	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokeinterface 314 1 0
    //   116: ldc_w 285
    //   119: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_3
    //   125: invokevirtual 290	com/tencent/mm/vfs/e:length	()J
    //   128: aload_2
    //   129: getfield 201	com/tencent/mm/modelvoice/r:hux	I
    //   132: i2l
    //   133: lcmp
    //   134: ifeq +53 -> 187
    //   137: ldc 169
    //   139: ldc_w 316
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_3
    //   149: invokevirtual 290	com/tencent/mm/vfs/e:length	()J
    //   152: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_2
    //   159: getfield 201	com/tencent/mm/modelvoice/r:hux	I
    //   162: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 314 1 0
    //   179: ldc_w 285
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_1
    //   188: iconst_0
    //   189: aload_2
    //   190: getfield 201	com/tencent/mm/modelvoice/r:hux	I
    //   193: invokeinterface 323 3 0
    //   198: astore_0
    //   199: aload_0
    //   200: getfield 328	com/tencent/mm/modelvoice/g:ret	I
    //   203: ifne +76 -> 279
    //   206: aload_2
    //   207: getfield 331	com/tencent/mm/modelvoice/r:idU	I
    //   210: ifeq +69 -> 279
    //   213: aload_2
    //   214: getfield 331	com/tencent/mm/modelvoice/r:idU	I
    //   217: aload_2
    //   218: getfield 331	com/tencent/mm/modelvoice/r:idU	I
    //   221: sipush 255
    //   224: iand
    //   225: aload_0
    //   226: getfield 335	com/tencent/mm/modelvoice/g:buf	[B
    //   229: aload_0
    //   230: getfield 338	com/tencent/mm/modelvoice/g:cWy	I
    //   233: invokestatic 342	com/tencent/mm/modelvoice/s:c	(I[BI)I
    //   236: if_icmpeq +43 -> 279
    //   239: ldc 169
    //   241: ldc_w 344
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_2
    //   251: getfield 331	com/tencent/mm/modelvoice/r:idU	I
    //   254: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_1
    //   262: ifnull +9 -> 271
    //   265: aload_1
    //   266: invokeinterface 314 1 0
    //   271: ldc_w 285
    //   274: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload_1
    //   280: ifnull +9 -> 289
    //   283: aload_1
    //   284: invokeinterface 314 1 0
    //   289: ldc_w 285
    //   292: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_1
    //   301: ifnull +9 -> 310
    //   304: aload_1
    //   305: invokeinterface 314 1 0
    //   310: ldc_w 285
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
    //   37	112	3	locale	com.tencent.mm.vfs.e
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
  
  public static bo EK(String paramString)
  {
    AppMethodBeat.i(148481);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = o.aKp().EO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramString.iaJ);
    AppMethodBeat.o(148481);
    return paramString;
  }
  
  public static r EL(String paramString)
  {
    AppMethodBeat.i(210504);
    paramString = o.aKp().EO(paramString);
    AppMethodBeat.o(210504);
    return paramString;
  }
  
  public static int EM(String paramString)
  {
    AppMethodBeat.i(148489);
    synchronized (idV)
    {
      if (idV.get(paramString) != null)
      {
        paramString = (com.tencent.mm.ak.k)((WeakReference)idV.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.Oq();
          AppMethodBeat.o(148489);
          return i;
        }
      }
      AppMethodBeat.o(148489);
      return -1;
    }
  }
  
  public static boolean Ea(String paramString)
  {
    AppMethodBeat.i(148480);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(148480);
      return false;
    }
    r localr = o.aKp().EO(paramString);
    if (localr == null)
    {
      ac.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148480);
      return false;
    }
    localr.status = 98;
    localr.iaH = (System.currentTimeMillis() / 1000L);
    localr.drx = 320;
    boolean bool = a(localr);
    ac.d("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localr.iaJ + " old stat:" + localr.status);
    if ((localr.iaJ == 0) || (bs.isNullOrNil(localr.drG)))
    {
      ac.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localr.iaJ + " user:" + localr.drG);
      AppMethodBeat.o(148480);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(localr.iaJ);
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 33L, 1L, true);
    paramString.setMsgId(localr.iaJ);
    paramString.setStatus(5);
    paramString.re(localr.drG);
    paramString.setContent(p.b(localr.iaC, -1L, true));
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(148480);
    return bool;
  }
  
  public static boolean Eb(String paramString)
  {
    AppMethodBeat.i(148477);
    paramString = o.aKp().EO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148477);
      return false;
    }
    if (paramString.status == 3)
    {
      bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramString.iaJ);
      localbo.setContent(p.b(paramString.iaC, paramString.idR, false));
      localbo.setStatus(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(paramString.iaJ, localbo);
    }
    paramString.status = 97;
    paramString.iaH = (System.currentTimeMillis() / 1000L);
    paramString.drx = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(148477);
    return bool;
  }
  
  public static boolean W(bo parambo)
  {
    AppMethodBeat.i(148486);
    if ((parambo == null) || (!parambo.eZl()))
    {
      AppMethodBeat.o(148486);
      return false;
    }
    boolean bool = new p(parambo.field_content).iaD;
    AppMethodBeat.o(148486);
    return bool;
  }
  
  public static boolean X(bo parambo)
  {
    AppMethodBeat.i(148487);
    if ((parambo == null) || (!parambo.eZl()) || (parambo.field_isSend == 1))
    {
      AppMethodBeat.o(148487);
      return false;
    }
    if (new p(parambo.field_content).time == 0L)
    {
      AppMethodBeat.o(148487);
      return true;
    }
    AppMethodBeat.o(148487);
    return false;
  }
  
  public static String Y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148460);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    String str = l.d(awN(), "msg_", paramString, ".amr", 2);
    ac.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.YH() + " " + str);
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(148460);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(148460);
      return str;
    }
    if (new com.tencent.mm.vfs.e(str).exists())
    {
      AppMethodBeat.o(148460);
      return str;
    }
    paramString = aKv() + paramString;
    if (new com.tencent.mm.vfs.e(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.i.ma(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(148460);
      return str;
      if (new com.tencent.mm.vfs.e(paramString).exists()) {
        com.tencent.mm.vfs.i.ma(paramString, str);
      }
    }
  }
  
  public static void Y(bo parambo)
  {
    AppMethodBeat.i(148488);
    if ((parambo == null) || (!parambo.eZl()))
    {
      AppMethodBeat.o(148488);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(parambo.field_msgId);
    if (((dy)localObject).field_msgId != parambo.field_msgId)
    {
      AppMethodBeat.o(148488);
      return;
    }
    localObject = new p(((dy)localObject).field_content);
    if (((p)localObject).iaD)
    {
      AppMethodBeat.o(148488);
      return;
    }
    ((p)localObject).iaD = true;
    StringBuilder localStringBuilder = new StringBuilder().append(((p)localObject).iaC).append(":").append(((p)localObject).time).append(":");
    if (((p)localObject).iaD) {}
    for (int i = 1;; i = 0)
    {
      parambo.setContent(i + "\n");
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(parambo.field_msgId, parambo);
      AppMethodBeat.o(148488);
      return;
    }
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, com.tencent.mm.ak.f.a parama)
  {
    AppMethodBeat.i(148473);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    r localr = o.aKp().qx(paramr.dpl);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    if ((((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(paramr.drG, paramr.dpl).field_msgSvrId == paramr.dpl) && (localr == null))
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
      paramr.drx |= 0x1;
      ac.d("MicroMsg.VoiceLogic", f.YG() + "checktime :" + locala.YH());
      boolean bool2 = false;
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length > 1)
        {
          if (localr != null) {
            ac.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
          }
          str1 = paramr.icF;
          str2 = paramr.fileName;
          i = bz(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label644;
          }
          ac.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label276:
          paramr.idU = c(paramr.idU, paramArrayOfByte, paramArrayOfByte.length);
          paramr.drx |= 0x80000;
        }
      }
      ac.d("MicroMsg.VoiceLogic", f.YG() + "checktime :" + locala.YH());
      paramr.iaH = (System.currentTimeMillis() / 1000L);
      paramr.drx |= 0x100;
      if (!bool1) {
        break label769;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.drx |= 0x40;
      if (localr != null) {
        break label841;
      }
      if (bool1) {
        paramr.iaJ = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      }
      if (parama != null)
      {
        paramr.euk = bi.d(parama);
        if (parama.fXi != null) {
          paramr.idS = parama.fXi.DQa;
        }
      }
      ac.d("MicroMsg.VoiceLogic", f.YG() + "checktime :" + locala.YH());
      paramr.drx = -1;
      ac.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.hZn + " total:" + paramr.hux);
      if (o.aKp().b(paramr)) {
        break label793;
      }
      ac.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.hZn + " total:" + paramr.hux);
      AppMethodBeat.o(148473);
      return -2;
      paramr.fileName = w.EN(paramr.iaC);
      break;
      label644:
      if (paramArrayOfByte.length != i)
      {
        ac.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label276;
      }
      ac.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      ED(str2);
      bool1 = true;
      break label276;
      label769:
      if (paramr.hux == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label793:
    ac.d("MicroMsg.VoiceLogic", f.YG() + "checktime :" + locala.YH());
    if (bool1)
    {
      AppMethodBeat.o(148473);
      return 1;
      label841:
      ac.d("MicroMsg.VoiceLogic", "Sync Update file:" + paramr.fileName + " stat:" + paramr.status);
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
    if ((localr != null) && (localr.iaE == paramr.hux))
    {
      a(localr.fileName, localr.iaE, parama);
      ac.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    ac.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), bs.eWi() });
    o.aKr().run();
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
    ac.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + paramString1 + "] newOff:" + paramInt1 + " SvrID:" + paramLong + " clientID:" + paramString2 + " hasSendEndFlag " + paramInt2);
    r localr = o.aKp().EO(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    localr.hZn = paramInt1;
    localr.iaH = (System.currentTimeMillis() / 1000L);
    localr.drx = 264;
    if ((bs.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.drx |= 0x200;
    }
    if ((localr.dpl == 0L) && (paramLong != 0L))
    {
      localr.dpl = paramLong;
      localr.drx |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.hux <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.drx |= 0x40;
          paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(localr.iaJ);
          paramString2.re(localr.drG);
          paramString2.oz(localr.dpl);
          paramString2.setStatus(2);
          paramString2.setContent(p.b(localr.iaC, localr.idR, false));
          paramString2.YN(paramInt3);
          Integer localInteger = (Integer)idW.get(getFullPath(paramString1));
          if (localInteger != null)
          {
            localr.idU = localInteger.intValue();
            localr.drx |= 0x80000;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(localr.iaJ, paramString2);
          ac.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.hux + " status:" + localr.status + " netTimes:" + localr.iaK + " msgId:" + paramString2.field_msgId);
          i = 1;
          ED(paramString1);
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
  
  public static int a(String paramString, int paramInt, com.tencent.mm.ak.f.a parama)
  {
    AppMethodBeat.i(148476);
    if (paramString == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    r localr = o.aKp().EO(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    localr.iaE = paramInt;
    localr.iaH = (System.currentTimeMillis() / 1000L);
    localr.drx = 272;
    int j = 0;
    int i = j;
    if (localr.hux > 0)
    {
      i = j;
      if (paramInt >= localr.hux)
      {
        a(localr, parama);
        localr.status = 99;
        localr.drx |= 0x40;
        ac.i("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.hux + " status:" + localr.status + " netTimes:" + localr.iaK);
        i = 1;
        ED(paramString);
      }
    }
    ac.i("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.hux + " status:" + localr.status);
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
    paramString = o.aKp().EO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148471);
      return -1;
    }
    paramString.idU = c(paramString.idU, paramArrayOfByte, paramInt);
    paramString.drx |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.idU;
      AppMethodBeat.o(148471);
      return paramInt;
    }
    AppMethodBeat.o(148471);
    return 0;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, com.tencent.mm.ak.f.a parama)
  {
    AppMethodBeat.i(148475);
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vR(paramr.dpl))
    {
      ac.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.dpl) });
      if (bs.nullAsNil(paramr.fileName).length() > 0) {
        o.aKp().zB(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(148475);
        return -1L;
        ac.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    bo localbo = new bo();
    localbo.oz(paramr.dpl);
    localbo.rf(paramr.fileName);
    localbo.oA(bi.z(paramr.drG, paramr.createTime));
    localbo.re(paramr.drG);
    int i;
    if (u.wh(paramr.iaC))
    {
      i = 1;
      localbo.jT(i);
      localbo.setType(34);
      localbo.rj(paramString1);
      localbo.YN(paramr.icM);
      localbo.setStatus(paramInt);
      if (parama != null) {
        break label566;
      }
      paramInt = paramr.euk;
      if (paramInt != 0)
      {
        ac.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
        localbo.setFlag(paramInt);
        if ((localbo.field_msgId == 0L) && (localbo.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
          localbo.oA(bi.l(localbo.field_talker, paramr.createTime, localbo.field_msgSeq));
        }
      }
      if (paramr.idS != 0) {
        localbo.oC(paramr.idS);
      }
      ac.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.idS) });
      label329:
      ac.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
      if (!bs.isNullOrNil(paramString2))
      {
        localbo.qf(paramString2);
        localbo.rk(bi.ys(paramString2));
      }
      if (paramBoolean) {
        break label576;
      }
      localbo.setContent(p.b(paramr.iaC, 0L, false));
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramString2))
      {
        localbo.qf(paramString2);
        localbo.rk(bi.ys(paramString2));
        paramr = bi.yr(paramString2);
        if (paramr != null)
        {
          localbo.rk(paramr.hoy);
          localbo.kk(paramr.hoz);
          localbo.ri(paramr.hox);
          ac.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramr.hox });
          if (paramr.hoC != null)
          {
            paramString1 = new kt();
            paramString1.dmz.cZc = localbo;
            paramString1.dmz.dmA = paramr;
            com.tencent.mm.sdk.b.a.GpY.l(paramString1);
          }
        }
      }
      ac.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localbo.field_msgSvrId), Long.valueOf(localbo.field_msgSeq) });
      long l = bi.u(localbo);
      AppMethodBeat.o(148475);
      return l;
      i = 0;
      break;
      label566:
      bi.a(localbo, parama);
      break label329;
      label576:
      localbo.setContent(p.b(paramr.iaC, paramr.idR, false));
    }
  }
  
  private static boolean a(r paramr)
  {
    AppMethodBeat.i(148484);
    if (paramr == null)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    if (paramr.drx == -1)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    boolean bool = o.aKp().a(paramr.fileName, paramr);
    AppMethodBeat.o(148484);
    return bool;
  }
  
  private static boolean a(r paramr, com.tencent.mm.ak.f.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      paramr.iaJ = ((int)a(paramr, true, 3, "", paramr.eul, parama));
      paramr.drx |= 0x800;
      boolean bool = a(paramr);
      AppMethodBeat.o(148474);
      return bool;
    }
    catch (Exception paramr)
    {
      ac.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { bs.m(paramr) });
      AppMethodBeat.o(148474);
    }
    return false;
  }
  
  public static boolean a(String paramString, com.tencent.mm.ak.k paramk)
  {
    AppMethodBeat.i(148462);
    if (paramString == null)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    r localr = o.aKp().EO(paramString);
    if (localr == null)
    {
      ac.d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148462);
      return false;
    }
    if (localr.status != 1)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    localr.status = 2;
    localr.drx = 64;
    synchronized (idV)
    {
      idV.put(paramString, new WeakReference(paramk));
      boolean bool = a(localr);
      AppMethodBeat.o(148462);
      return bool;
    }
  }
  
  public static List<r> aKu()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(148483);
    Object localObject1 = o.aKp();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).hpA.a((String)localObject2, null, 2);
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
    ac.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
    ((Cursor)localObject1).close();
    AppMethodBeat.o(148483);
    return localArrayList;
  }
  
  public static String aKv()
  {
    AppMethodBeat.i(148490);
    Object localObject = new StringBuilder();
    g.agS();
    localObject = g.agR().ghC + "voice/";
    AppMethodBeat.o(148490);
    return localObject;
  }
  
  public static boolean au(String paramString, int paramInt)
  {
    AppMethodBeat.i(148467);
    boolean bool = t(paramString, paramInt, 0);
    AppMethodBeat.o(148467);
    return bool;
  }
  
  public static String awN()
  {
    AppMethodBeat.i(148491);
    Object localObject = new StringBuilder();
    g.agS();
    localObject = g.agR().ghC + "voice2/";
    AppMethodBeat.o(148491);
    return localObject;
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
  
  public static b bz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148456);
    w localw = o.aKp();
    paramString2 = getFullPath(paramString2);
    switch (bs.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.ieh.get(paramString2) == null) {
        localw.ieh.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.ieh.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    case 4: 
      if (localw.iej.get(paramString2) == null) {
        localw.iej.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.iej.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    }
    if (localw.iei.get(paramString2) == null) {
      localw.iei.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.iei.get(paramString2);
    AppMethodBeat.o(148456);
    return paramString1;
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
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148459);
      return null;
    }
    paramString = Y(paramString, false);
    AppMethodBeat.o(148459);
    return paramString;
  }
  
  public static String n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148479);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if ((!bs.isNullOrNil(paramString2)) && (!paramString2.startsWith("amr_")) && (!paramString2.startsWith("spx_"))) {
      paramString2.startsWith("silk_");
    }
    paramString1 = EE(paramString1);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if (com.tencent.mm.vfs.i.lZ(getFullPath(paramString2), getFullPath(paramString1)) < 0L)
    {
      AppMethodBeat.o(148479);
      return null;
    }
    t(paramString1, paramInt, 1);
    AppMethodBeat.o(148479);
    return paramString1;
  }
  
  public static int pO(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean pP(int paramInt)
  {
    AppMethodBeat.i(148478);
    bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramInt);
    if ((localbo.field_msgId == 0L) || (localbo.field_imgPath == null))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    if (bs.isNullOrNil(localbo.field_imgPath))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    Object localObject = localbo.field_imgPath;
    localObject = o.aKp().EO((String)localObject);
    if ((localObject == null) || (bs.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).hZn = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).iaH = (System.currentTimeMillis() / 1000L);
    ((r)localObject).drx = 8648;
    boolean bool = a((r)localObject);
    ac.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).iaJ + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).iaJ == 0) || (bs.isNullOrNil(((r)localObject).drG)))
    {
      ac.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).iaJ + " user:" + ((r)localObject).drG);
      AppMethodBeat.o(148478);
      return bool;
    }
    localbo.setStatus(1);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(localbo.field_msgId, localbo);
    o.aKr().run();
    AppMethodBeat.o(148478);
    return true;
  }
  
  public static float qw(long paramLong)
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
  
  private static boolean t(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148468);
    if (paramString == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    ac.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.aKp().EO(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).hux = q.DX(paramString);
    if (((r)???).hux <= 0)
    {
      Ea(paramString);
      AppMethodBeat.o(148468);
      return false;
    }
    ((r)???).iaH = (System.currentTimeMillis() / 1000L);
    ((r)???).idR = paramInt1;
    ((r)???).drx = 3424;
    bo localbo = new bo();
    localbo.re(((r)???).drG);
    localbo.setType(34);
    localbo.jT(1);
    localbo.rf(paramString);
    if (((r)???).status == 97)
    {
      localbo.setStatus(2);
      localbo.setContent(p.b(((r)???).iaC, ((r)???).idR, false));
    }
    for (;;)
    {
      localbo.oA(bi.yp(((r)???).drG));
      localbo.YN(paramInt2);
      a.a.Xf().n(localbo);
      ((r)???).iaJ = ((int)bi.u(localbo));
      boolean bool = a((r)???);
      synchronized (idV)
      {
        idV.remove(paramString);
        AppMethodBeat.o(148468);
        return bool;
        if (((r)???).status == 98)
        {
          localbo.setStatus(5);
          localbo.setContent(p.b(((r)???).iaC, -1L, true));
          continue;
        }
        localbo.setStatus(1);
        localbo.setContent(p.b(((r)???).iaC, ((r)???).idR, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */