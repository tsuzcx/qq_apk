package com.tencent.mm.modelvoice;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.xz;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static final HashMap<String, WeakReference<com.tencent.mm.ak.j>> iAj;
  public static volatile HashMap<String, Integer> iAk;
  public static volatile HashMap<String, Integer> iAl;
  public static volatile HashMap<String, Integer> iAm;
  
  static
  {
    AppMethodBeat.i(148492);
    iAj = new HashMap();
    iAk = new HashMap();
    iAl = new HashMap();
    iAm = new HashMap();
    AppMethodBeat.o(148492);
  }
  
  public static boolean HR(String paramString)
  {
    AppMethodBeat.i(148480);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(148480);
      return false;
    }
    Object localObject = o.aNW().IF(paramString);
    if (localObject == null)
    {
      ae.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148480);
      return false;
    }
    ((r)localObject).status = 98;
    ((r)localObject).iwX = (System.currentTimeMillis() / 1000L);
    ((r)localObject).dEu = 320;
    boolean bool = a((r)localObject);
    ae.i("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + ((r)localObject).iwZ + " old stat:" + ((r)localObject).status);
    if ((((r)localObject).iwZ == 0) || (bu.isNullOrNil(((r)localObject).dED)))
    {
      ae.e("MicroMsg.VoiceLogic", "setError failed msg id:" + ((r)localObject).iwZ + " user:" + ((r)localObject).dED);
      AppMethodBeat.o(148480);
      return bool;
    }
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(((r)localObject).iwZ);
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 33L, 1L, true);
    paramString.setMsgId(((r)localObject).iwZ);
    paramString.setStatus(5);
    paramString.ui(((r)localObject).dED);
    paramString.setContent(p.b(((r)localObject).iwS, Math.max(((r)localObject).iAf, 0), true));
    paramString.fwl();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(paramString.field_msgId, paramString);
    localObject = new xz();
    ((xz)localObject).dNt.msgId = paramString.field_msgId;
    ((xz)localObject).dNt.success = false;
    com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    AppMethodBeat.o(148480);
    return bool;
  }
  
  public static boolean HS(String paramString)
  {
    AppMethodBeat.i(148477);
    paramString = o.aNW().IF(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148477);
      return false;
    }
    if (paramString.status == 3)
    {
      bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramString.iwZ);
      localbv.setContent(p.b(paramString.iwS, paramString.iAf, false));
      localbv.setStatus(2);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(paramString.iwZ, localbv);
    }
    paramString.status = 97;
    paramString.iwX = (System.currentTimeMillis() / 1000L);
    paramString.dEu = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(148477);
    return bool;
  }
  
  /* Error */
  public static boolean IA(String paramString)
  {
    // Byte code:
    //   0: ldc_w 259
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 60	com/tencent/mm/modelvoice/o:aNW	()Lcom/tencent/mm/modelvoice/w;
    //   9: aload_0
    //   10: invokevirtual 66	com/tencent/mm/modelvoice/w:IF	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +11 -> 26
    //   18: ldc_w 259
    //   21: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_1
    //   25: ireturn
    //   26: new 261	com/tencent/mm/vfs/k
    //   29: dup
    //   30: aload_0
    //   31: invokestatic 264	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokespecial 265	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_0
    //   39: invokestatic 269	com/tencent/mm/modelvoice/s:It	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +80 -> 124
    //   47: aload_1
    //   48: instanceof 271
    //   51: ifeq +73 -> 124
    //   54: aload_3
    //   55: invokevirtual 274	com/tencent/mm/vfs/k:length	()J
    //   58: aload_2
    //   59: getfield 277	com/tencent/mm/modelvoice/r:hPI	I
    //   62: i2l
    //   63: lsub
    //   64: invokestatic 281	java/lang/Math:abs	(J)J
    //   67: ldc2_w 282
    //   70: lcmp
    //   71: ifne +53 -> 124
    //   74: ldc 68
    //   76: ldc_w 285
    //   79: iconst_2
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_3
    //   86: invokevirtual 274	com/tencent/mm/vfs/k:length	()J
    //   89: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_2
    //   96: getfield 277	com/tencent/mm/modelvoice/r:hPI	I
    //   99: invokestatic 295	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokeinterface 303 1 0
    //   116: ldc_w 259
    //   119: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_3
    //   125: invokevirtual 274	com/tencent/mm/vfs/k:length	()J
    //   128: aload_2
    //   129: getfield 277	com/tencent/mm/modelvoice/r:hPI	I
    //   132: i2l
    //   133: lcmp
    //   134: ifeq +53 -> 187
    //   137: ldc 68
    //   139: ldc_w 305
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_3
    //   149: invokevirtual 274	com/tencent/mm/vfs/k:length	()J
    //   152: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_2
    //   159: getfield 277	com/tencent/mm/modelvoice/r:hPI	I
    //   162: invokestatic 295	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 307	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 303 1 0
    //   179: ldc_w 259
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_1
    //   188: iconst_0
    //   189: aload_2
    //   190: getfield 277	com/tencent/mm/modelvoice/r:hPI	I
    //   193: invokeinterface 311 3 0
    //   198: astore_0
    //   199: aload_0
    //   200: getfield 316	com/tencent/mm/modelvoice/g:ret	I
    //   203: ifne +76 -> 279
    //   206: aload_2
    //   207: getfield 319	com/tencent/mm/modelvoice/r:iAi	I
    //   210: ifeq +69 -> 279
    //   213: aload_2
    //   214: getfield 319	com/tencent/mm/modelvoice/r:iAi	I
    //   217: aload_2
    //   218: getfield 319	com/tencent/mm/modelvoice/r:iAi	I
    //   221: sipush 255
    //   224: iand
    //   225: aload_0
    //   226: getfield 323	com/tencent/mm/modelvoice/g:buf	[B
    //   229: aload_0
    //   230: getfield 326	com/tencent/mm/modelvoice/g:diR	I
    //   233: invokestatic 330	com/tencent/mm/modelvoice/s:c	(I[BI)I
    //   236: if_icmpeq +43 -> 279
    //   239: ldc 68
    //   241: ldc_w 332
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_2
    //   251: getfield 319	com/tencent/mm/modelvoice/r:iAi	I
    //   254: invokestatic 295	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 307	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_1
    //   262: ifnull +9 -> 271
    //   265: aload_1
    //   266: invokeinterface 303 1 0
    //   271: ldc_w 259
    //   274: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload_1
    //   280: ifnull +9 -> 289
    //   283: aload_1
    //   284: invokeinterface 303 1 0
    //   289: ldc_w 259
    //   292: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_1
    //   301: ifnull +9 -> 310
    //   304: aload_1
    //   305: invokeinterface 303 1 0
    //   310: ldc_w 259
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
    //   37	112	3	localk	k
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
  
  public static bv IB(String paramString)
  {
    AppMethodBeat.i(148481);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = o.aNW().IF(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramString.iwZ);
    AppMethodBeat.o(148481);
    return paramString;
  }
  
  public static r IC(String paramString)
  {
    AppMethodBeat.i(224399);
    paramString = o.aNW().IF(paramString);
    AppMethodBeat.o(224399);
    return paramString;
  }
  
  public static int ID(String paramString)
  {
    AppMethodBeat.i(148489);
    synchronized (iAj)
    {
      if (iAj.get(paramString) != null)
      {
        paramString = (com.tencent.mm.ak.j)((WeakReference)iAj.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.PY();
          AppMethodBeat.o(148489);
          return i;
        }
      }
      AppMethodBeat.o(148489);
      return -1;
    }
  }
  
  public static boolean Is(String paramString)
  {
    AppMethodBeat.i(148455);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString = o.aNW().IF(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    if (paramString.ixa >= 250)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString.ixa += 1;
    paramString.dEu = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(148455);
    return bool;
  }
  
  public static b It(String paramString)
  {
    AppMethodBeat.i(148457);
    w localw = o.aNW();
    String str = getFullPath(paramString);
    switch (q.Iq(paramString))
    {
    default: 
      if (localw.iAv.get(str) == null) {
        localw.iAv.put(str, new a(str));
      }
      paramString = (b)localw.iAv.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 0: 
      if (localw.iAv.get(str) == null) {
        localw.iAv.put(str, new a(str));
      }
      paramString = (b)localw.iAv.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 1: 
      if (localw.iAw.get(str) == null) {
        localw.iAw.put(str, new n(str));
      }
      paramString = (b)localw.iAw.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    }
    if (localw.iAx.get(str) == null) {
      localw.iAx.put(str, new j(str));
    }
    paramString = (b)localw.iAx.get(str);
    AppMethodBeat.o(148457);
    return paramString;
  }
  
  private static void Iu(String paramString)
  {
    AppMethodBeat.i(148458);
    w localw = o.aNW();
    String str = getFullPath(paramString);
    switch (q.Iq(paramString))
    {
    default: 
      paramString = (a)localw.iAv.get(str);
      if (paramString != null)
      {
        paramString.aNK();
        localw.iAv.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 0: 
      paramString = (a)localw.iAv.get(str);
      if (paramString != null)
      {
        paramString.aNK();
        localw.iAv.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 1: 
      paramString = (n)localw.iAw.get(str);
      if (paramString != null)
      {
        paramString.aNK();
        localw.iAw.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    }
    paramString = (j)localw.iAx.get(str);
    if (paramString != null)
    {
      paramString.aNK();
      localw.iAx.remove(str);
    }
    AppMethodBeat.o(148458);
  }
  
  public static String Iv(String paramString)
  {
    AppMethodBeat.i(148461);
    String str = w.IE(v.aAC());
    r localr = new r();
    localr.fileName = str;
    localr.dED = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.iwX = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.iwS = v.aAC();
    localr.dEu = -1;
    if (!o.aNW().b(localr))
    {
      AppMethodBeat.o(148461);
      return null;
    }
    ae.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(148461);
    return str;
  }
  
  public static boolean Iw(String paramString)
  {
    AppMethodBeat.i(148463);
    if (paramString == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    ae.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.aNW().IF(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    localr.status = 8;
    localr.hPI = q.HL(paramString);
    localr.dEu = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(148463);
    return bool;
  }
  
  public static boolean Ix(String paramString)
  {
    AppMethodBeat.i(148464);
    if (paramString == null)
    {
      AppMethodBeat.o(148464);
      return false;
    }
    r localr = o.aNW().IF(paramString);
    if (localr == null)
    {
      ae.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148464);
      return true;
    }
    ae.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.dCd);
    if (localr.dCd != 0L) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aT(localr.dED, localr.dCd);
    }
    boolean bool = Iz(paramString);
    AppMethodBeat.o(148464);
    return bool;
  }
  
  public static boolean Iy(String paramString)
  {
    AppMethodBeat.i(148465);
    if (paramString == null)
    {
      AppMethodBeat.o(148465);
      return false;
    }
    r localr = o.aNW().IF(paramString);
    if (localr == null)
    {
      ae.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148465);
      return true;
    }
    ae.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.iwZ);
    if (localr.iwZ != 0) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().yt(localr.iwZ);
    }
    boolean bool = Iz(paramString);
    AppMethodBeat.o(148465);
    return bool;
  }
  
  public static boolean Iz(String paramString)
  {
    AppMethodBeat.i(148466);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    o.aNW().Dc(paramString);
    Iu(paramString);
    boolean bool = new k(getFullPath(paramString)).delete();
    AppMethodBeat.o(148466);
    return bool;
  }
  
  public static String Y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148460);
    f.a locala = new f.a();
    String str = com.tencent.mm.sdk.platformtools.n.d(azS(), "msg_", paramString, ".amr", 2);
    ae.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.abs() + " " + str);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(148460);
      return null;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(148460);
      return str;
    }
    if (new k(str).exists())
    {
      AppMethodBeat.o(148460);
      return str;
    }
    paramString = aOc() + paramString;
    if (new k(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.o.mG(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(148460);
      return str;
      if (new k(paramString).exists()) {
        com.tencent.mm.vfs.o.mG(paramString, str);
      }
    }
  }
  
  public static boolean Y(bv parambv)
  {
    AppMethodBeat.i(148486);
    if ((parambv == null) || (!parambv.ftf()))
    {
      AppMethodBeat.o(148486);
      return false;
    }
    boolean bool = new p(parambv.field_content).iwT;
    AppMethodBeat.o(148486);
    return bool;
  }
  
  public static boolean Z(bv parambv)
  {
    AppMethodBeat.i(148487);
    if ((parambv == null) || (!parambv.ftf()) || (parambv.field_isSend == 1))
    {
      AppMethodBeat.o(148487);
      return false;
    }
    if (new p(parambv.field_content).time == 0L)
    {
      AppMethodBeat.o(148487);
      return true;
    }
    AppMethodBeat.o(148487);
    return false;
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    AppMethodBeat.i(148473);
    f.a locala = new f.a();
    r localr = o.aNW().sJ(paramr.dCd);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    if ((((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(paramr.dED, paramr.dCd).field_msgSvrId == paramr.dCd) && (localr == null))
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
      paramr.dEu |= 0x1;
      ae.d("MicroMsg.VoiceLogic", f.abr() + "checktime :" + locala.abs());
      boolean bool2 = false;
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length > 1)
        {
          if (localr != null) {
            ae.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
          }
          str1 = paramr.iyU;
          str2 = paramr.fileName;
          i = bA(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label639;
          }
          ae.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label276:
          paramr.iAi = c(paramr.iAi, paramArrayOfByte, paramArrayOfByte.length);
          paramr.dEu |= 0x80000;
        }
      }
      ae.d("MicroMsg.VoiceLogic", f.abr() + "checktime :" + locala.abs());
      paramr.iwX = (System.currentTimeMillis() / 1000L);
      paramr.dEu |= 0x100;
      if (!bool1) {
        break label764;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.dEu |= 0x40;
      if (localr != null) {
        break label836;
      }
      paramr.iwZ = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      if (parama != null)
      {
        paramr.eNc = bl.d(parama);
        if (parama.gte != null) {
          paramr.iAg = parama.gte.FNN;
        }
      }
      ae.d("MicroMsg.VoiceLogic", f.abr() + "checktime :" + locala.abs());
      paramr.dEu = -1;
      ae.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.ivD + " total:" + paramr.hPI);
      if (o.aNW().b(paramr)) {
        break label788;
      }
      ae.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.ivD + " total:" + paramr.hPI);
      AppMethodBeat.o(148473);
      return -2;
      paramr.fileName = w.IE(paramr.iwS);
      break;
      label639:
      if (paramArrayOfByte.length != i)
      {
        ae.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label276;
      }
      ae.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      Iu(str2);
      bool1 = true;
      break label276;
      label764:
      if (paramr.hPI == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label788:
    ae.d("MicroMsg.VoiceLogic", f.abr() + "checktime :" + locala.abs());
    if (bool1)
    {
      AppMethodBeat.o(148473);
      return 1;
      label836:
      ae.d("MicroMsg.VoiceLogic", "Sync Update file:" + paramr.fileName + " stat:" + paramr.status);
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
    if ((localr != null) && (localr.iwU == paramr.hPI))
    {
      a(localr.fileName, localr.iwU, parama);
      ae.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    ae.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), bu.fpN() });
    o.aNY().run();
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
    ae.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + paramString1 + "] newOff:" + paramInt1 + " SvrID:" + paramLong + " clientID:" + paramString2 + " hasSendEndFlag " + paramInt2);
    r localr = o.aNW().IF(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    localr.ivD = paramInt1;
    localr.iwX = (System.currentTimeMillis() / 1000L);
    localr.dEu = 264;
    if ((bu.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.dEu |= 0x200;
    }
    if ((localr.dCd == 0L) && (paramLong != 0L))
    {
      localr.dCd = paramLong;
      localr.dEu |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.hPI <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.dEu |= 0x40;
          paramString2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localr.iwZ);
          paramString2.ui(localr.dED);
          paramString2.qM(localr.dCd);
          paramString2.setStatus(2);
          paramString2.setContent(p.b(localr.iwS, localr.iAf, false));
          paramString2.abE(paramInt3);
          Integer localInteger = (Integer)iAk.get(getFullPath(paramString1));
          if (localInteger != null)
          {
            localr.iAi = localInteger.intValue();
            localr.dEu |= 0x80000;
          }
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(localr.iwZ, paramString2);
          ae.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.hPI + " status:" + localr.status + " netTimes:" + localr.ixa + " msgId:" + paramString2.field_msgId);
          i = 1;
          Iu(paramString1);
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
  
  public static int a(String paramString, int paramInt, e.a parama)
  {
    AppMethodBeat.i(148476);
    if (paramString == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    r localr = o.aNW().IF(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    localr.iwU = paramInt;
    localr.iwX = (System.currentTimeMillis() / 1000L);
    localr.dEu = 272;
    int j = 0;
    int i = j;
    if (localr.hPI > 0)
    {
      i = j;
      if (paramInt >= localr.hPI)
      {
        a(localr, parama);
        localr.status = 99;
        localr.dEu |= 0x40;
        ae.i("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.hPI + " status:" + localr.status + " netTimes:" + localr.ixa);
        i = 1;
        Iu(paramString);
      }
    }
    ae.i("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.hPI + " status:" + localr.status);
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
    paramString = o.aNW().IF(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148471);
      return -1;
    }
    paramString.iAi = c(paramString.iAi, paramArrayOfByte, paramInt);
    paramString.dEu |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.iAi;
      AppMethodBeat.o(148471);
      return paramInt;
    }
    AppMethodBeat.o(148471);
    return 0;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    AppMethodBeat.i(148475);
    if (((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().yu(paramr.dCd))
    {
      ae.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.dCd) });
      if (bu.nullAsNil(paramr.fileName).length() > 0) {
        o.aNW().Dc(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(148475);
        return -1L;
        ae.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(paramr.dED, paramr.dCd);
    int i = 0;
    if (localbv.field_msgSvrId != paramr.dCd)
    {
      localbv = new bv();
      localbv.qM(paramr.dCd);
      localbv.uj(paramr.fileName);
      localbv.qN(bl.B(paramr.dED, paramr.createTime));
      localbv.ui(paramr.dED);
      if (v.zK(paramr.iwS))
      {
        i = 1;
        localbv.kt(i);
        localbv.setType(34);
        localbv.abE(paramr.izb);
        i = 1;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localbv.fwl();
        label242:
        localbv.uq(paramString1);
        localbv.setStatus(paramInt);
        if (parama != null) {
          break label564;
        }
        paramInt = paramr.eNc;
        if (paramInt != 0)
        {
          ae.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
          localbv.setFlag(paramInt);
          if ((localbv.field_msgId == 0L) && (localbv.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
            localbv.qN(bl.l(localbv.field_talker, paramr.createTime, localbv.field_msgSeq));
          }
        }
        if (paramr.iAg != 0) {
          localbv.qP(paramr.iAg);
        }
        ae.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.iAg) });
        label385:
        ae.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
        if (!bu.isNullOrNil(paramString2))
        {
          localbv.tk(paramString2);
          localbv.ur(bl.BT(paramString2));
        }
        if (paramBoolean) {
          break label574;
        }
        localbv.setContent(p.b(paramr.iwS, Math.max(paramr.iAf, 0), false));
        label453:
        ae.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localbv.field_msgSvrId), Long.valueOf(localbv.field_msgSeq) });
        if (i == 0) {
          break label716;
        }
      }
      for (long l = bl.v(localbv);; l = localbv.field_msgId)
      {
        if (paramBoolean)
        {
          paramr = new xz();
          paramr.dNt.msgId = localbv.field_msgId;
          paramr.dNt.success = true;
          com.tencent.mm.sdk.b.a.IvT.a(paramr, Looper.getMainLooper());
        }
        AppMethodBeat.o(148475);
        return l;
        i = 0;
        break;
        localbv.fwk();
        break label242;
        label564:
        bl.a(localbv, parama);
        break label385;
        label574:
        localbv.setContent(p.b(paramr.iwS, paramr.iAf, false));
        if (bu.isNullOrNil(paramString2)) {
          break label453;
        }
        localbv.tk(paramString2);
        localbv.ur(bl.BT(paramString2));
        paramr = bl.BS(paramString2);
        if (paramr == null) {
          break label453;
        }
        localbv.ur(paramr.hJI);
        localbv.kJ(paramr.hJJ);
        localbv.um(paramr.hJH);
        ae.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramr.hJH });
        if (paramr.hJM == null) {
          break label453;
        }
        paramString1 = new ld();
        paramString1.dzs.dlw = localbv;
        paramString1.dzs.dzt = paramr;
        com.tencent.mm.sdk.b.a.IvT.l(paramString1);
        break label453;
        label716:
        bl.w(localbv);
      }
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
    if (paramr.dEu == -1)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    boolean bool = o.aNW().a(paramr.fileName, paramr);
    AppMethodBeat.o(148484);
    return bool;
  }
  
  private static boolean a(r paramr, e.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      paramr.iwZ = ((int)a(paramr, true, 3, "", paramr.eNd, parama));
      paramr.dEu |= 0x800;
      boolean bool = a(paramr);
      AppMethodBeat.o(148474);
      return bool;
    }
    catch (Exception paramr)
    {
      ae.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { bu.o(paramr) });
      AppMethodBeat.o(148474);
    }
    return false;
  }
  
  public static boolean a(String paramString, com.tencent.mm.ak.j paramj)
  {
    AppMethodBeat.i(148462);
    if (paramString == null)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    r localr = o.aNW().IF(paramString);
    if (localr == null)
    {
      ae.d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148462);
      return false;
    }
    if (localr.status != 1)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    localr.status = 2;
    localr.dEu = 64;
    synchronized (iAj)
    {
      iAj.put(paramString, new WeakReference(paramj));
      boolean bool = a(localr);
      AppMethodBeat.o(148462);
      return bool;
    }
  }
  
  public static List<r> aOb()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(148483);
    Object localObject1 = o.aNW();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).hKK.a((String)localObject2, null, 2);
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
    ae.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
    ((Cursor)localObject1).close();
    AppMethodBeat.o(148483);
    return localArrayList;
  }
  
  public static String aOc()
  {
    AppMethodBeat.i(148490);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "voice/";
    AppMethodBeat.o(148490);
    return localObject;
  }
  
  public static void aa(bv parambv)
  {
    AppMethodBeat.i(148488);
    if ((parambv == null) || (!parambv.ftf()))
    {
      AppMethodBeat.o(148488);
      return;
    }
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(parambv.field_msgId);
    if (((ei)localObject).field_msgId != parambv.field_msgId)
    {
      AppMethodBeat.o(148488);
      return;
    }
    localObject = new p(((ei)localObject).field_content);
    if (((p)localObject).iwT)
    {
      AppMethodBeat.o(148488);
      return;
    }
    ((p)localObject).iwT = true;
    StringBuilder localStringBuilder = new StringBuilder().append(((p)localObject).iwS).append(":").append(((p)localObject).time).append(":");
    if (((p)localObject).iwT) {}
    for (int i = 1;; i = 0)
    {
      parambv.setContent(i + "\n");
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(parambv.field_msgId, parambv);
      AppMethodBeat.o(148488);
      return;
    }
  }
  
  public static boolean ax(String paramString, int paramInt)
  {
    AppMethodBeat.i(148467);
    boolean bool = v(paramString, paramInt, 0);
    AppMethodBeat.o(148467);
    return bool;
  }
  
  public static String azS()
  {
    AppMethodBeat.i(148491);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "voice2/";
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
  
  public static b bA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148456);
    w localw = o.aNW();
    paramString2 = getFullPath(paramString2);
    switch (bu.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.iAv.get(paramString2) == null) {
        localw.iAv.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.iAv.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    case 4: 
      if (localw.iAx.get(paramString2) == null) {
        localw.iAx.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.iAx.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    }
    if (localw.iAw.get(paramString2) == null) {
      localw.iAw.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.iAw.get(paramString2);
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
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148459);
      return null;
    }
    paramString = Y(paramString, false);
    AppMethodBeat.o(148459);
    return paramString;
  }
  
  public static String o(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148479);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if ((!bu.isNullOrNil(paramString2)) && (!paramString2.startsWith("amr_")) && (!paramString2.startsWith("spx_"))) {
      paramString2.startsWith("silk_");
    }
    paramString1 = Iv(paramString1);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if (com.tencent.mm.vfs.o.mF(getFullPath(paramString2), getFullPath(paramString1)) < 0L)
    {
      AppMethodBeat.o(148479);
      return null;
    }
    v(paramString1, paramInt, 1);
    AppMethodBeat.o(148479);
    return paramString1;
  }
  
  public static int qt(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean qu(int paramInt)
  {
    AppMethodBeat.i(148478);
    bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramInt);
    if ((localbv.field_msgId == 0L) || (localbv.field_imgPath == null))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    if (bu.isNullOrNil(localbv.field_imgPath))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    Object localObject = localbv.field_imgPath;
    localObject = o.aNW().IF((String)localObject);
    if ((localObject == null) || (bu.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).ivD = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).iwX = (System.currentTimeMillis() / 1000L);
    ((r)localObject).dEu = 8648;
    boolean bool = a((r)localObject);
    ae.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).iwZ + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).iwZ == 0) || (bu.isNullOrNil(((r)localObject).dED)))
    {
      ae.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).iwZ + " user:" + ((r)localObject).dED);
      AppMethodBeat.o(148478);
      return bool;
    }
    localbv.setStatus(1);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
    o.aNY().run();
    AppMethodBeat.o(148478);
    return true;
  }
  
  public static float sI(long paramLong)
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
  
  private static boolean v(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148468);
    if (paramString == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    ae.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.aNW().IF(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).hPI = q.HL(paramString);
    if (((r)???).hPI <= 0)
    {
      HR(paramString);
      AppMethodBeat.o(148468);
      return false;
    }
    ((r)???).iwX = (System.currentTimeMillis() / 1000L);
    ((r)???).iAf = paramInt1;
    ((r)???).dEu = 3424;
    bv localbv = new bv();
    localbv.ui(((r)???).dED);
    localbv.setType(34);
    localbv.kt(1);
    localbv.uj(paramString);
    if (((r)???).status == 97)
    {
      localbv.setStatus(2);
      localbv.setContent(p.b(((r)???).iwS, ((r)???).iAf, false));
    }
    for (;;)
    {
      localbv.qN(bl.BQ(((r)???).dED));
      localbv.abE(paramInt2);
      a.a.ZP().n(localbv);
      ((r)???).iwZ = ((int)bl.v(localbv));
      boolean bool = a((r)???);
      synchronized (iAj)
      {
        iAj.remove(paramString);
        AppMethodBeat.o(148468);
        return bool;
        if (((r)???).status == 98)
        {
          localbv.setStatus(5);
          localbv.setContent(p.b(((r)???).iwS, -1L, true));
          continue;
        }
        localbv.setStatus(1);
        localbv.setContent(p.b(((r)???).iwS, ((r)???).iAf, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */