package com.tencent.mm.modelvoice;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static final HashMap<String, WeakReference<com.tencent.mm.al.j>> ixq;
  public static volatile HashMap<String, Integer> ixr;
  public static volatile HashMap<String, Integer> ixs;
  public static volatile HashMap<String, Integer> ixt;
  
  static
  {
    AppMethodBeat.i(148492);
    ixq = new HashMap();
    ixr = new HashMap();
    ixs = new HashMap();
    ixt = new HashMap();
    AppMethodBeat.o(148492);
  }
  
  public static boolean HQ(String paramString)
  {
    AppMethodBeat.i(148455);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString = o.aNy().Id(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    if (paramString.iug >= 250)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString.iug += 1;
    paramString.dDp = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(148455);
    return bool;
  }
  
  public static b HR(String paramString)
  {
    AppMethodBeat.i(148457);
    w localw = o.aNy();
    String str = getFullPath(paramString);
    switch (q.HO(paramString))
    {
    default: 
      if (localw.ixC.get(str) == null) {
        localw.ixC.put(str, new a(str));
      }
      paramString = (b)localw.ixC.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 0: 
      if (localw.ixC.get(str) == null) {
        localw.ixC.put(str, new a(str));
      }
      paramString = (b)localw.ixC.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 1: 
      if (localw.ixD.get(str) == null) {
        localw.ixD.put(str, new n(str));
      }
      paramString = (b)localw.ixD.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    }
    if (localw.ixE.get(str) == null) {
      localw.ixE.put(str, new j(str));
    }
    paramString = (b)localw.ixE.get(str);
    AppMethodBeat.o(148457);
    return paramString;
  }
  
  private static void HS(String paramString)
  {
    AppMethodBeat.i(148458);
    w localw = o.aNy();
    String str = getFullPath(paramString);
    switch (q.HO(paramString))
    {
    default: 
      paramString = (a)localw.ixC.get(str);
      if (paramString != null)
      {
        paramString.aNm();
        localw.ixC.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 0: 
      paramString = (a)localw.ixC.get(str);
      if (paramString != null)
      {
        paramString.aNm();
        localw.ixC.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 1: 
      paramString = (n)localw.ixD.get(str);
      if (paramString != null)
      {
        paramString.aNm();
        localw.ixD.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    }
    paramString = (j)localw.ixE.get(str);
    if (paramString != null)
    {
      paramString.aNm();
      localw.ixE.remove(str);
    }
    AppMethodBeat.o(148458);
  }
  
  public static String HT(String paramString)
  {
    AppMethodBeat.i(148461);
    String str = w.Ic(u.aAm());
    r localr = new r();
    localr.fileName = str;
    localr.dDy = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.iud = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.itY = u.aAm();
    localr.dDp = -1;
    if (!o.aNy().b(localr))
    {
      AppMethodBeat.o(148461);
      return null;
    }
    ad.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(148461);
    return str;
  }
  
  public static boolean HU(String paramString)
  {
    AppMethodBeat.i(148463);
    if (paramString == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    ad.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.aNy().Id(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    localr.status = 8;
    localr.hMP = q.Hj(paramString);
    localr.dDp = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(148463);
    return bool;
  }
  
  public static boolean HV(String paramString)
  {
    AppMethodBeat.i(148464);
    if (paramString == null)
    {
      AppMethodBeat.o(148464);
      return false;
    }
    r localr = o.aNy().Id(paramString);
    if (localr == null)
    {
      ad.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148464);
      return true;
    }
    ad.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.dAY);
    if (localr.dAY != 0L) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aS(localr.dDy, localr.dAY);
    }
    boolean bool = HX(paramString);
    AppMethodBeat.o(148464);
    return bool;
  }
  
  public static boolean HW(String paramString)
  {
    AppMethodBeat.i(148465);
    if (paramString == null)
    {
      AppMethodBeat.o(148465);
      return false;
    }
    r localr = o.aNy().Id(paramString);
    if (localr == null)
    {
      ad.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148465);
      return true;
    }
    ad.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.iuf);
    if (localr.iuf != 0) {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xZ(localr.iuf);
    }
    boolean bool = HX(paramString);
    AppMethodBeat.o(148465);
    return bool;
  }
  
  public static boolean HX(String paramString)
  {
    AppMethodBeat.i(148466);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    o.aNy().CA(paramString);
    HS(paramString);
    boolean bool = new com.tencent.mm.vfs.e(getFullPath(paramString)).delete();
    AppMethodBeat.o(148466);
    return bool;
  }
  
  /* Error */
  public static boolean HY(String paramString)
  {
    // Byte code:
    //   0: ldc_w 285
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 46	com/tencent/mm/modelvoice/o:aNy	()Lcom/tencent/mm/modelvoice/w;
    //   9: aload_0
    //   10: invokevirtual 52	com/tencent/mm/modelvoice/w:Id	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
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
    //   39: invokestatic 287	com/tencent/mm/modelvoice/s:HR	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +80 -> 124
    //   47: aload_1
    //   48: instanceof 90
    //   51: ifeq +73 -> 124
    //   54: aload_3
    //   55: invokevirtual 290	com/tencent/mm/vfs/e:length	()J
    //   58: aload_2
    //   59: getfield 201	com/tencent/mm/modelvoice/r:hMP	I
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
    //   96: getfield 201	com/tencent/mm/modelvoice/r:hMP	I
    //   99: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 313	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   129: getfield 201	com/tencent/mm/modelvoice/r:hMP	I
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
    //   159: getfield 201	com/tencent/mm/modelvoice/r:hMP	I
    //   162: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 319	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   190: getfield 201	com/tencent/mm/modelvoice/r:hMP	I
    //   193: invokeinterface 323 3 0
    //   198: astore_0
    //   199: aload_0
    //   200: getfield 328	com/tencent/mm/modelvoice/g:ret	I
    //   203: ifne +76 -> 279
    //   206: aload_2
    //   207: getfield 331	com/tencent/mm/modelvoice/r:ixp	I
    //   210: ifeq +69 -> 279
    //   213: aload_2
    //   214: getfield 331	com/tencent/mm/modelvoice/r:ixp	I
    //   217: aload_2
    //   218: getfield 331	com/tencent/mm/modelvoice/r:ixp	I
    //   221: sipush 255
    //   224: iand
    //   225: aload_0
    //   226: getfield 335	com/tencent/mm/modelvoice/g:buf	[B
    //   229: aload_0
    //   230: getfield 338	com/tencent/mm/modelvoice/g:dhO	I
    //   233: invokestatic 342	com/tencent/mm/modelvoice/s:c	(I[BI)I
    //   236: if_icmpeq +43 -> 279
    //   239: ldc 169
    //   241: ldc_w 344
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_2
    //   251: getfield 331	com/tencent/mm/modelvoice/r:ixp	I
    //   254: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 319	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static bu HZ(String paramString)
  {
    AppMethodBeat.i(148481);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = o.aNy().Id(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramString.iuf);
    AppMethodBeat.o(148481);
    return paramString;
  }
  
  public static boolean Hp(String paramString)
  {
    AppMethodBeat.i(148480);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(148480);
      return false;
    }
    Object localObject = o.aNy().Id(paramString);
    if (localObject == null)
    {
      ad.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148480);
      return false;
    }
    ((r)localObject).status = 98;
    ((r)localObject).iud = (System.currentTimeMillis() / 1000L);
    ((r)localObject).dDp = 320;
    boolean bool = a((r)localObject);
    ad.i("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + ((r)localObject).iuf + " old stat:" + ((r)localObject).status);
    if ((((r)localObject).iuf == 0) || (bt.isNullOrNil(((r)localObject).dDy)))
    {
      ad.e("MicroMsg.VoiceLogic", "setError failed msg id:" + ((r)localObject).iuf + " user:" + ((r)localObject).dDy);
      AppMethodBeat.o(148480);
      return bool;
    }
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(((r)localObject).iuf);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 33L, 1L, true);
    paramString.setMsgId(((r)localObject).iuf);
    paramString.setStatus(5);
    paramString.tN(((r)localObject).dDy);
    paramString.setContent(p.b(((r)localObject).itY, Math.max(((r)localObject).ixm, 0), true));
    paramString.fsk();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(paramString.field_msgId, paramString);
    localObject = new xu();
    ((xu)localObject).dMd.msgId = paramString.field_msgId;
    ((xu)localObject).dMd.success = false;
    com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    AppMethodBeat.o(148480);
    return bool;
  }
  
  public static boolean Hq(String paramString)
  {
    AppMethodBeat.i(148477);
    paramString = o.aNy().Id(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148477);
      return false;
    }
    if (paramString.status == 3)
    {
      bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramString.iuf);
      localbu.setContent(p.b(paramString.itY, paramString.ixm, false));
      localbu.setStatus(2);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(paramString.iuf, localbu);
    }
    paramString.status = 97;
    paramString.iud = (System.currentTimeMillis() / 1000L);
    paramString.dDp = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(148477);
    return bool;
  }
  
  public static r Ia(String paramString)
  {
    AppMethodBeat.i(221421);
    paramString = o.aNy().Id(paramString);
    AppMethodBeat.o(221421);
    return paramString;
  }
  
  public static int Ib(String paramString)
  {
    AppMethodBeat.i(148489);
    synchronized (ixq)
    {
      if (ixq.get(paramString) != null)
      {
        paramString = (com.tencent.mm.al.j)((WeakReference)ixq.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.PZ();
          AppMethodBeat.o(148489);
          return i;
        }
      }
      AppMethodBeat.o(148489);
      return -1;
    }
  }
  
  public static String Y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148460);
    f.a locala = new f.a();
    String str = m.d(azC(), "msg_", paramString, ".amr", 2);
    ad.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.abj() + " " + str);
    if (bt.isNullOrNil(str))
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
    paramString = aNE() + paramString;
    if (new com.tencent.mm.vfs.e(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.i.mA(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(148460);
      return str;
      if (new com.tencent.mm.vfs.e(paramString).exists()) {
        com.tencent.mm.vfs.i.mA(paramString, str);
      }
    }
  }
  
  public static boolean Z(bu parambu)
  {
    AppMethodBeat.i(148486);
    if ((parambu == null) || (!parambu.fph()))
    {
      AppMethodBeat.o(148486);
      return false;
    }
    boolean bool = new p(parambu.field_content).itZ;
    AppMethodBeat.o(148486);
    return bool;
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    AppMethodBeat.i(148473);
    f.a locala = new f.a();
    r localr = o.aNy().sw(paramr.dAY);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    if ((((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(paramr.dDy, paramr.dAY).field_msgSvrId == paramr.dAY) && (localr == null))
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
      paramr.dDp |= 0x1;
      ad.d("MicroMsg.VoiceLogic", f.abi() + "checktime :" + locala.abj());
      boolean bool2 = false;
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length > 1)
        {
          if (localr != null) {
            ad.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
          }
          str1 = paramr.iwb;
          str2 = paramr.fileName;
          i = bA(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label639;
          }
          ad.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label276:
          paramr.ixp = c(paramr.ixp, paramArrayOfByte, paramArrayOfByte.length);
          paramr.dDp |= 0x80000;
        }
      }
      ad.d("MicroMsg.VoiceLogic", f.abi() + "checktime :" + locala.abj());
      paramr.iud = (System.currentTimeMillis() / 1000L);
      paramr.dDp |= 0x100;
      if (!bool1) {
        break label764;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.dDp |= 0x40;
      if (localr != null) {
        break label836;
      }
      paramr.iuf = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      if (parama != null)
      {
        paramr.eLr = bj.d(parama);
        if (parama.gqE != null) {
          paramr.ixn = parama.gqE.Fvp;
        }
      }
      ad.d("MicroMsg.VoiceLogic", f.abi() + "checktime :" + locala.abj());
      paramr.dDp = -1;
      ad.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.isJ + " total:" + paramr.hMP);
      if (o.aNy().b(paramr)) {
        break label788;
      }
      ad.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.isJ + " total:" + paramr.hMP);
      AppMethodBeat.o(148473);
      return -2;
      paramr.fileName = w.Ic(paramr.itY);
      break;
      label639:
      if (paramArrayOfByte.length != i)
      {
        ad.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label276;
      }
      ad.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      HS(str2);
      bool1 = true;
      break label276;
      label764:
      if (paramr.hMP == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label788:
    ad.d("MicroMsg.VoiceLogic", f.abi() + "checktime :" + locala.abj());
    if (bool1)
    {
      AppMethodBeat.o(148473);
      return 1;
      label836:
      ad.d("MicroMsg.VoiceLogic", "Sync Update file:" + paramr.fileName + " stat:" + paramr.status);
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
    if ((localr != null) && (localr.iua == paramr.hMP))
    {
      a(localr.fileName, localr.iua, parama);
      ad.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    ad.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), bt.flS() });
    o.aNA().run();
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
    ad.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + paramString1 + "] newOff:" + paramInt1 + " SvrID:" + paramLong + " clientID:" + paramString2 + " hasSendEndFlag " + paramInt2);
    r localr = o.aNy().Id(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    localr.isJ = paramInt1;
    localr.iud = (System.currentTimeMillis() / 1000L);
    localr.dDp = 264;
    if ((bt.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.dDp |= 0x200;
    }
    if ((localr.dAY == 0L) && (paramLong != 0L))
    {
      localr.dAY = paramLong;
      localr.dDp |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.hMP <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.dDp |= 0x40;
          paramString2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(localr.iuf);
          paramString2.tN(localr.dDy);
          paramString2.qz(localr.dAY);
          paramString2.setStatus(2);
          paramString2.setContent(p.b(localr.itY, localr.ixm, false));
          paramString2.aaW(paramInt3);
          Integer localInteger = (Integer)ixr.get(getFullPath(paramString1));
          if (localInteger != null)
          {
            localr.ixp = localInteger.intValue();
            localr.dDp |= 0x80000;
          }
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(localr.iuf, paramString2);
          ad.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.hMP + " status:" + localr.status + " netTimes:" + localr.iug + " msgId:" + paramString2.field_msgId);
          i = 1;
          HS(paramString1);
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
    r localr = o.aNy().Id(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    localr.iua = paramInt;
    localr.iud = (System.currentTimeMillis() / 1000L);
    localr.dDp = 272;
    int j = 0;
    int i = j;
    if (localr.hMP > 0)
    {
      i = j;
      if (paramInt >= localr.hMP)
      {
        a(localr, parama);
        localr.status = 99;
        localr.dDp |= 0x40;
        ad.i("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.hMP + " status:" + localr.status + " netTimes:" + localr.iug);
        i = 1;
        HS(paramString);
      }
    }
    ad.i("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.hMP + " status:" + localr.status);
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
    paramString = o.aNy().Id(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148471);
      return -1;
    }
    paramString.ixp = c(paramString.ixp, paramArrayOfByte, paramInt);
    paramString.dDp |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.ixp;
      AppMethodBeat.o(148471);
      return paramInt;
    }
    AppMethodBeat.o(148471);
    return 0;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, e.a parama)
  {
    AppMethodBeat.i(148475);
    if (((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().ya(paramr.dAY))
    {
      ad.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.dAY) });
      if (bt.nullAsNil(paramr.fileName).length() > 0) {
        o.aNy().CA(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(148475);
        return -1L;
        ad.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(paramr.dDy, paramr.dAY);
    int i = 0;
    if (localbu.field_msgSvrId != paramr.dAY)
    {
      localbu = new bu();
      localbu.qz(paramr.dAY);
      localbu.tO(paramr.fileName);
      localbu.qA(bj.B(paramr.dDy, paramr.createTime));
      localbu.tN(paramr.dDy);
      if (u.za(paramr.itY))
      {
        i = 1;
        localbu.kr(i);
        localbu.setType(34);
        localbu.aaW(paramr.iwi);
        i = 1;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localbu.fsk();
        label242:
        localbu.tV(paramString1);
        localbu.setStatus(paramInt);
        if (parama != null) {
          break label564;
        }
        paramInt = paramr.eLr;
        if (paramInt != 0)
        {
          ad.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
          localbu.setFlag(paramInt);
          if ((localbu.field_msgId == 0L) && (localbu.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
            localbu.qA(bj.l(localbu.field_talker, paramr.createTime, localbu.field_msgSeq));
          }
        }
        if (paramr.ixn != 0) {
          localbu.qC(paramr.ixn);
        }
        ad.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.ixn) });
        label385:
        ad.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
        if (!bt.isNullOrNil(paramString2))
        {
          localbu.sP(paramString2);
          localbu.tW(bj.Br(paramString2));
        }
        if (paramBoolean) {
          break label574;
        }
        localbu.setContent(p.b(paramr.itY, Math.max(paramr.ixm, 0), false));
        label453:
        ad.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localbu.field_msgSvrId), Long.valueOf(localbu.field_msgSeq) });
        if (i == 0) {
          break label716;
        }
      }
      for (long l = bj.v(localbu);; l = localbu.field_msgId)
      {
        if (paramBoolean)
        {
          paramr = new xu();
          paramr.dMd.msgId = localbu.field_msgId;
          paramr.dMd.success = true;
          com.tencent.mm.sdk.b.a.IbL.a(paramr, Looper.getMainLooper());
        }
        AppMethodBeat.o(148475);
        return l;
        i = 0;
        break;
        localbu.fsj();
        break label242;
        label564:
        bj.a(localbu, parama);
        break label385;
        label574:
        localbu.setContent(p.b(paramr.itY, paramr.ixm, false));
        if (bt.isNullOrNil(paramString2)) {
          break label453;
        }
        localbu.sP(paramString2);
        localbu.tW(bj.Br(paramString2));
        paramr = bj.Bq(paramString2);
        if (paramr == null) {
          break label453;
        }
        localbu.tW(paramr.hGQ);
        localbu.kH(paramr.hGR);
        localbu.tR(paramr.hGP);
        ad.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramr.hGP });
        if (paramr.hGU == null) {
          break label453;
        }
        paramString1 = new lc();
        paramString1.dyn.dku = localbu;
        paramString1.dyn.dyo = paramr;
        com.tencent.mm.sdk.b.a.IbL.l(paramString1);
        break label453;
        label716:
        bj.w(localbu);
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
    if (paramr.dDp == -1)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    boolean bool = o.aNy().a(paramr.fileName, paramr);
    AppMethodBeat.o(148484);
    return bool;
  }
  
  private static boolean a(r paramr, e.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      paramr.iuf = ((int)a(paramr, true, 3, "", paramr.eLs, parama));
      paramr.dDp |= 0x800;
      boolean bool = a(paramr);
      AppMethodBeat.o(148474);
      return bool;
    }
    catch (Exception paramr)
    {
      ad.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { bt.n(paramr) });
      AppMethodBeat.o(148474);
    }
    return false;
  }
  
  public static boolean a(String paramString, com.tencent.mm.al.j paramj)
  {
    AppMethodBeat.i(148462);
    if (paramString == null)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    r localr = o.aNy().Id(paramString);
    if (localr == null)
    {
      ad.d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148462);
      return false;
    }
    if (localr.status != 1)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    localr.status = 2;
    localr.dDp = 64;
    synchronized (ixq)
    {
      ixq.put(paramString, new WeakReference(paramj));
      boolean bool = a(localr);
      AppMethodBeat.o(148462);
      return bool;
    }
  }
  
  public static List<r> aND()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(148483);
    Object localObject1 = o.aNy();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).hHS.a((String)localObject2, null, 2);
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
    ad.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(j)));
    ((Cursor)localObject1).close();
    AppMethodBeat.o(148483);
    return localArrayList;
  }
  
  public static String aNE()
  {
    AppMethodBeat.i(148490);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "voice/";
    AppMethodBeat.o(148490);
    return localObject;
  }
  
  public static boolean aa(bu parambu)
  {
    AppMethodBeat.i(148487);
    if ((parambu == null) || (!parambu.fph()) || (parambu.field_isSend == 1))
    {
      AppMethodBeat.o(148487);
      return false;
    }
    if (new p(parambu.field_content).time == 0L)
    {
      AppMethodBeat.o(148487);
      return true;
    }
    AppMethodBeat.o(148487);
    return false;
  }
  
  public static void ab(bu parambu)
  {
    AppMethodBeat.i(148488);
    if ((parambu == null) || (!parambu.fph()))
    {
      AppMethodBeat.o(148488);
      return;
    }
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(parambu.field_msgId);
    if (((ei)localObject).field_msgId != parambu.field_msgId)
    {
      AppMethodBeat.o(148488);
      return;
    }
    localObject = new p(((ei)localObject).field_content);
    if (((p)localObject).itZ)
    {
      AppMethodBeat.o(148488);
      return;
    }
    ((p)localObject).itZ = true;
    StringBuilder localStringBuilder = new StringBuilder().append(((p)localObject).itY).append(":").append(((p)localObject).time).append(":");
    if (((p)localObject).itZ) {}
    for (int i = 1;; i = 0)
    {
      parambu.setContent(i + "\n");
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(parambu.field_msgId, parambu);
      AppMethodBeat.o(148488);
      return;
    }
  }
  
  public static boolean aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(148467);
    boolean bool = v(paramString, paramInt, 0);
    AppMethodBeat.o(148467);
    return bool;
  }
  
  public static String azC()
  {
    AppMethodBeat.i(148491);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "voice2/";
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
    w localw = o.aNy();
    paramString2 = getFullPath(paramString2);
    switch (bt.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.ixC.get(paramString2) == null) {
        localw.ixC.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.ixC.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    case 4: 
      if (localw.ixE.get(paramString2) == null) {
        localw.ixE.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.ixE.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    }
    if (localw.ixD.get(paramString2) == null) {
      localw.ixD.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.ixD.get(paramString2);
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
    if (bt.isNullOrNil(paramString))
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
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if ((!bt.isNullOrNil(paramString2)) && (!paramString2.startsWith("amr_")) && (!paramString2.startsWith("spx_"))) {
      paramString2.startsWith("silk_");
    }
    paramString1 = HT(paramString1);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if (com.tencent.mm.vfs.i.mz(getFullPath(paramString2), getFullPath(paramString1)) < 0L)
    {
      AppMethodBeat.o(148479);
      return null;
    }
    v(paramString1, paramInt, 1);
    AppMethodBeat.o(148479);
    return paramString1;
  }
  
  public static int qq(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean qr(int paramInt)
  {
    AppMethodBeat.i(148478);
    bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramInt);
    if ((localbu.field_msgId == 0L) || (localbu.field_imgPath == null))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    if (bt.isNullOrNil(localbu.field_imgPath))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    Object localObject = localbu.field_imgPath;
    localObject = o.aNy().Id((String)localObject);
    if ((localObject == null) || (bt.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).isJ = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).iud = (System.currentTimeMillis() / 1000L);
    ((r)localObject).dDp = 8648;
    boolean bool = a((r)localObject);
    ad.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).iuf + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).iuf == 0) || (bt.isNullOrNil(((r)localObject).dDy)))
    {
      ad.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).iuf + " user:" + ((r)localObject).dDy);
      AppMethodBeat.o(148478);
      return bool;
    }
    localbu.setStatus(1);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(localbu.field_msgId, localbu);
    o.aNA().run();
    AppMethodBeat.o(148478);
    return true;
  }
  
  public static float sv(long paramLong)
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
    ad.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.aNy().Id(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).hMP = q.Hj(paramString);
    if (((r)???).hMP <= 0)
    {
      Hp(paramString);
      AppMethodBeat.o(148468);
      return false;
    }
    ((r)???).iud = (System.currentTimeMillis() / 1000L);
    ((r)???).ixm = paramInt1;
    ((r)???).dDp = 3424;
    bu localbu = new bu();
    localbu.tN(((r)???).dDy);
    localbu.setType(34);
    localbu.kr(1);
    localbu.tO(paramString);
    if (((r)???).status == 97)
    {
      localbu.setStatus(2);
      localbu.setContent(p.b(((r)???).itY, ((r)???).ixm, false));
    }
    for (;;)
    {
      localbu.qA(bj.Bo(((r)???).dDy));
      localbu.aaW(paramInt2);
      a.a.ZG().n(localbu);
      ((r)???).iuf = ((int)bj.v(localbu));
      boolean bool = a((r)???);
      synchronized (ixq)
      {
        ixq.remove(paramString);
        AppMethodBeat.o(148468);
        return bool;
        if (((r)???).status == 98)
        {
          localbu.setStatus(5);
          localbu.setContent(p.b(((r)???).itY, -1L, true));
          continue;
        }
        localbu.setStatus(1);
        localbu.setContent(p.b(((r)???).itY, ((r)???).ixm, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */