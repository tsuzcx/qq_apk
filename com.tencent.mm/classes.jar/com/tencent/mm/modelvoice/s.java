package com.tencent.mm.modelvoice;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.m;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  public static volatile HashMap<String, Integer> jvA;
  public static volatile HashMap<String, Integer> jvB;
  private static final HashMap<String, WeakReference<m>> jvy;
  public static volatile HashMap<String, Integer> jvz;
  
  static
  {
    AppMethodBeat.i(148492);
    jvy = new HashMap();
    jvz = new HashMap();
    jvA = new HashMap();
    jvB = new HashMap();
    AppMethodBeat.o(148492);
  }
  
  public static float AO(long paramLong)
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
  
  public static boolean QE(String paramString)
  {
    AppMethodBeat.i(148480);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(148480);
      return false;
    }
    r localr = o.bib().Rr(paramString);
    if (localr == null)
    {
      Log.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148480);
      return false;
    }
    localr.status = 98;
    localr.jsm = (System.currentTimeMillis() / 1000L);
    localr.cSx = 320;
    boolean bool = a(localr);
    Log.i("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localr.jso + " old stat:" + localr.status);
    if ((localr.jso == 0) || (Util.isNullOrNil(localr.dWq)))
    {
      Log.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localr.jso + " user:" + localr.dWq);
      AppMethodBeat.o(148480);
      return bool;
    }
    paramString = ((l)g.af(l.class)).eiy().Hb(localr.jso);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(111L, 33L, 1L, true);
    paramString.setMsgId(localr.jso);
    paramString.setStatus(5);
    paramString.Cy(localr.dWq);
    paramString.setContent(p.b(localr.jsh, Math.max(localr.jvt, 0), true));
    paramString.gDR();
    ((l)g.af(l.class)).eiy().a(paramString.field_msgId, paramString);
    zb localzb = new zb();
    localzb.efl.msgId = paramString.field_msgId;
    localzb.efl.success = false;
    localzb.efl.efm = localr.bih();
    EventCenter.instance.asyncPublish(localzb, Looper.getMainLooper());
    AppMethodBeat.o(148480);
    return bool;
  }
  
  public static boolean QF(String paramString)
  {
    AppMethodBeat.i(148477);
    paramString = o.bib().Rr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148477);
      return false;
    }
    if (paramString.status == 3)
    {
      ca localca = ((l)g.af(l.class)).eiy().Hb(paramString.jso);
      localca.setContent(p.b(paramString.jsh, paramString.jvt, false));
      localca.setStatus(2);
      ((l)g.af(l.class)).eiy().a(paramString.jso, localca);
    }
    paramString.status = 97;
    paramString.jsm = (System.currentTimeMillis() / 1000L);
    paramString.cSx = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(148477);
    return bool;
  }
  
  public static boolean Re(String paramString)
  {
    AppMethodBeat.i(148455);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString = o.bib().Rr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    if (paramString.jsp >= 250)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString.jsp += 1;
    paramString.cSx = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(148455);
    return bool;
  }
  
  public static b Rf(String paramString)
  {
    AppMethodBeat.i(148457);
    w localw = o.bib();
    String str = getFullPath(paramString);
    switch (q.Rc(paramString))
    {
    default: 
      if (localw.jvK.get(str) == null) {
        localw.jvK.put(str, new a(str));
      }
      paramString = (b)localw.jvK.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 0: 
      if (localw.jvK.get(str) == null) {
        localw.jvK.put(str, new a(str));
      }
      paramString = (b)localw.jvK.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 1: 
      if (localw.jvL.get(str) == null) {
        localw.jvL.put(str, new n(str));
      }
      paramString = (b)localw.jvL.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    }
    if (localw.jvM.get(str) == null) {
      localw.jvM.put(str, new j(str));
    }
    paramString = (b)localw.jvM.get(str);
    AppMethodBeat.o(148457);
    return paramString;
  }
  
  private static void Rg(String paramString)
  {
    AppMethodBeat.i(148458);
    w localw = o.bib();
    String str = getFullPath(paramString);
    switch (q.Rc(paramString))
    {
    default: 
      paramString = (a)localw.jvK.get(str);
      if (paramString != null)
      {
        paramString.bhP();
        localw.jvK.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 0: 
      paramString = (a)localw.jvK.get(str);
      if (paramString != null)
      {
        paramString.bhP();
        localw.jvK.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 1: 
      paramString = (n)localw.jvL.get(str);
      if (paramString != null)
      {
        paramString.bhP();
        localw.jvL.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    }
    paramString = (j)localw.jvM.get(str);
    if (paramString != null)
    {
      paramString.bhP();
      localw.jvM.remove(str);
    }
    AppMethodBeat.o(148458);
  }
  
  public static String Rh(String paramString)
  {
    AppMethodBeat.i(148461);
    String str = w.Rq(z.aTY());
    r localr = new r();
    localr.fileName = str;
    localr.dWq = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.jsm = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.jsh = z.aTY();
    localr.cSx = -1;
    if (!o.bib().b(localr))
    {
      AppMethodBeat.o(148461);
      return null;
    }
    Log.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(148461);
    return str;
  }
  
  public static boolean Ri(String paramString)
  {
    AppMethodBeat.i(148463);
    if (paramString == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    Log.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.bib().Rr(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    localr.status = 8;
    localr.iKP = q.Qy(paramString);
    localr.cSx = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(148463);
    return bool;
  }
  
  public static boolean Rj(String paramString)
  {
    AppMethodBeat.i(148464);
    if (paramString == null)
    {
      AppMethodBeat.o(148464);
      return false;
    }
    r localr = o.bib().Rr(paramString);
    if (localr == null)
    {
      Log.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148464);
      return true;
    }
    Log.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.dTS);
    if (localr.dTS != 0L) {
      ((l)g.af(l.class)).eiy().aT(localr.dWq, localr.dTS);
    }
    boolean bool = Rl(paramString);
    AppMethodBeat.o(148464);
    return bool;
  }
  
  public static boolean Rk(String paramString)
  {
    AppMethodBeat.i(148465);
    if (paramString == null)
    {
      AppMethodBeat.o(148465);
      return false;
    }
    r localr = o.bib().Rr(paramString);
    if (localr == null)
    {
      Log.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148465);
      return true;
    }
    Log.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.jso);
    if (localr.jso != 0) {
      ((l)g.af(l.class)).eiy().Hc(localr.jso);
    }
    boolean bool = Rl(paramString);
    AppMethodBeat.o(148465);
    return bool;
  }
  
  public static boolean Rl(String paramString)
  {
    AppMethodBeat.i(148466);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    o.bib().gC(paramString);
    Rg(paramString);
    paramString = getFullPath(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    boolean bool = new com.tencent.mm.vfs.o(paramString).delete();
    AppMethodBeat.o(148466);
    return bool;
  }
  
  /* Error */
  public static boolean Rm(String paramString)
  {
    // Byte code:
    //   0: ldc_w 418
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 71	com/tencent/mm/modelvoice/o:bib	()Lcom/tencent/mm/modelvoice/w;
    //   9: aload_0
    //   10: invokevirtual 77	com/tencent/mm/modelvoice/w:Rr	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +11 -> 26
    //   18: ldc_w 418
    //   21: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_1
    //   25: ireturn
    //   26: new 410	com/tencent/mm/vfs/o
    //   29: dup
    //   30: aload_0
    //   31: invokestatic 283	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokespecial 411	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_0
    //   39: invokestatic 420	com/tencent/mm/modelvoice/s:Rf	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +80 -> 124
    //   47: aload_1
    //   48: instanceof 301
    //   51: ifeq +73 -> 124
    //   54: aload_3
    //   55: invokevirtual 423	com/tencent/mm/vfs/o:length	()J
    //   58: aload_2
    //   59: getfield 369	com/tencent/mm/modelvoice/r:iKP	I
    //   62: i2l
    //   63: lsub
    //   64: invokestatic 427	java/lang/Math:abs	(J)J
    //   67: ldc2_w 428
    //   70: lcmp
    //   71: ifne +53 -> 124
    //   74: ldc 79
    //   76: ldc_w 431
    //   79: iconst_2
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_3
    //   86: invokevirtual 423	com/tencent/mm/vfs/o:length	()J
    //   89: invokestatic 436	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_2
    //   96: getfield 369	com/tencent/mm/modelvoice/r:iKP	I
    //   99: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 444	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokeinterface 445 1 0
    //   116: ldc_w 418
    //   119: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_3
    //   125: invokevirtual 423	com/tencent/mm/vfs/o:length	()J
    //   128: aload_2
    //   129: getfield 369	com/tencent/mm/modelvoice/r:iKP	I
    //   132: i2l
    //   133: lcmp
    //   134: ifeq +53 -> 187
    //   137: ldc 79
    //   139: ldc_w 447
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_3
    //   149: invokevirtual 423	com/tencent/mm/vfs/o:length	()J
    //   152: invokestatic 436	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_2
    //   159: getfield 369	com/tencent/mm/modelvoice/r:iKP	I
    //   162: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 445 1 0
    //   179: ldc_w 418
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_1
    //   188: iconst_0
    //   189: aload_2
    //   190: getfield 369	com/tencent/mm/modelvoice/r:iKP	I
    //   193: invokeinterface 453 3 0
    //   198: astore_0
    //   199: aload_0
    //   200: getfield 458	com/tencent/mm/modelvoice/g:ret	I
    //   203: ifne +76 -> 279
    //   206: aload_2
    //   207: getfield 461	com/tencent/mm/modelvoice/r:jvw	I
    //   210: ifeq +69 -> 279
    //   213: aload_2
    //   214: getfield 461	com/tencent/mm/modelvoice/r:jvw	I
    //   217: aload_2
    //   218: getfield 461	com/tencent/mm/modelvoice/r:jvw	I
    //   221: sipush 255
    //   224: iand
    //   225: aload_0
    //   226: getfield 465	com/tencent/mm/modelvoice/g:buf	[B
    //   229: aload_0
    //   230: getfield 468	com/tencent/mm/modelvoice/g:dAc	I
    //   233: invokestatic 472	com/tencent/mm/modelvoice/s:c	(I[BI)I
    //   236: if_icmpeq +43 -> 279
    //   239: ldc 79
    //   241: ldc_w 474
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_2
    //   251: getfield 461	com/tencent/mm/modelvoice/r:jvw	I
    //   254: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_1
    //   262: ifnull +9 -> 271
    //   265: aload_1
    //   266: invokeinterface 445 1 0
    //   271: ldc_w 418
    //   274: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload_1
    //   280: ifnull +9 -> 289
    //   283: aload_1
    //   284: invokeinterface 445 1 0
    //   289: ldc_w 418
    //   292: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_1
    //   301: ifnull +9 -> 310
    //   304: aload_1
    //   305: invokeinterface 445 1 0
    //   310: ldc_w 418
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
    //   37	112	3	localo	com.tencent.mm.vfs.o
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
  
  public static ca Rn(String paramString)
  {
    AppMethodBeat.i(148481);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = o.bib().Rr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = ((l)g.af(l.class)).eiy().Hb(paramString.jso);
    AppMethodBeat.o(148481);
    return paramString;
  }
  
  public static r Ro(String paramString)
  {
    AppMethodBeat.i(258703);
    paramString = o.bib().Rr(paramString);
    AppMethodBeat.o(258703);
    return paramString;
  }
  
  public static int Rp(String paramString)
  {
    AppMethodBeat.i(148489);
    synchronized (jvy)
    {
      if (jvy.get(paramString) != null)
      {
        paramString = (m)((WeakReference)jvy.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.aas();
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
    String str = FilePathGenerator.genPath(aTa(), "msg_", paramString, ".amr", 2);
    Log.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.apr() + " " + str);
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
    if (new com.tencent.mm.vfs.o(str).exists())
    {
      AppMethodBeat.o(148460);
      return str;
    }
    paramString = bij() + paramString;
    if (new com.tencent.mm.vfs.o(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.s.nx(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(148460);
      return str;
      if (new com.tencent.mm.vfs.o(paramString).exists()) {
        com.tencent.mm.vfs.s.nx(paramString, str);
      }
    }
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, h.a parama)
  {
    AppMethodBeat.i(148473);
    f.a locala = new f.a();
    r localr = o.bib().AP(paramr.dTS);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    if ((((l)g.af(l.class)).eiy().aJ(paramr.dWq, paramr.dTS).field_msgSvrId == paramr.dTS) && (localr == null))
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
      paramr.cSx |= 0x1;
      Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + locala.apr());
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
          str1 = paramr.jui;
          str2 = paramr.fileName;
          i = bE(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label639;
          }
          Log.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label276:
          paramr.jvw = c(paramr.jvw, paramArrayOfByte, paramArrayOfByte.length);
          paramr.cSx |= 0x80000;
        }
      }
      Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + locala.apr());
      paramr.jsm = (System.currentTimeMillis() / 1000L);
      paramr.cSx |= 0x100;
      if (!bool1) {
        break label764;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.cSx |= 0x40;
      if (localr != null) {
        break label836;
      }
      paramr.jso = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      if (parama != null)
      {
        paramr.fqJ = bp.d(parama);
        if (parama.heO != null) {
          paramr.jvu = parama.heO.KHs;
        }
      }
      Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + locala.apr());
      paramr.cSx = -1;
      Log.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.jqP + " total:" + paramr.iKP);
      if (o.bib().b(paramr)) {
        break label788;
      }
      Log.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.jqP + " total:" + paramr.iKP);
      AppMethodBeat.o(148473);
      return -2;
      paramr.fileName = w.Rq(paramr.jsh);
      break;
      label639:
      if (paramArrayOfByte.length != i)
      {
        Log.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label276;
      }
      Log.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      Rg(str2);
      bool1 = true;
      break label276;
      label764:
      if (paramr.iKP == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label788:
    Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + locala.apr());
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
    if ((localr != null) && (localr.jsj == paramr.iKP))
    {
      a(localr.fileName, localr.jsj, parama);
      Log.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    Log.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), Util.getStack() });
    o.bid().run();
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
    r localr = o.bib().Rr(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    localr.jqP = paramInt1;
    localr.jsm = (System.currentTimeMillis() / 1000L);
    localr.cSx = 264;
    if ((Util.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.cSx |= 0x200;
    }
    if ((localr.dTS == 0L) && (paramLong != 0L))
    {
      localr.dTS = paramLong;
      localr.cSx |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.iKP <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.cSx |= 0x40;
          paramString2 = ((l)g.af(l.class)).eiy().Hb(localr.jso);
          paramString2.Cy(localr.dWq);
          paramString2.yF(localr.dTS);
          paramString2.setStatus(2);
          paramString2.setContent(p.b(localr.jsh, localr.jvt, false));
          paramString2.akm(paramInt3);
          Integer localInteger = (Integer)jvz.get(getFullPath(paramString1));
          if (localInteger != null)
          {
            localr.jvw = localInteger.intValue();
            localr.cSx |= 0x80000;
          }
          ((l)g.af(l.class)).eiy().a(localr.jso, paramString2);
          Log.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.iKP + " status:" + localr.status + " netTimes:" + localr.jsp + " msgId:" + paramString2.field_msgId);
          i = 1;
          Rg(paramString1);
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
    r localr = o.bib().Rr(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    localr.jsj = paramInt;
    localr.jsm = (System.currentTimeMillis() / 1000L);
    localr.cSx = 272;
    int i = j;
    if (localr.iKP > 0)
    {
      i = j;
      if (paramInt >= localr.iKP)
      {
        a(localr, parama);
        localr.status = 99;
        localr.jvx = 0;
        localr.cSx = (localr.cSx | 0x40 | 0x100000);
        Log.i("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.iKP + " status:" + localr.status + " netTimes:" + localr.jsp);
        i = 1;
        Rg(paramString);
      }
    }
    Log.i("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.iKP + " status:" + localr.status);
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
    paramString = o.bib().Rr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148471);
      return -1;
    }
    paramString.jvw = c(paramString.jvw, paramArrayOfByte, paramInt);
    paramString.cSx |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.jvw;
      AppMethodBeat.o(148471);
      return paramInt;
    }
    AppMethodBeat.o(148471);
    return 0;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, h.a parama)
  {
    AppMethodBeat.i(148475);
    if (((l)g.af(l.class)).eiy().Hd(paramr.dTS))
    {
      Log.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.dTS) });
      if (Util.nullAsNil(paramr.fileName).length() > 0) {
        o.bib().gC(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(148475);
        return -1L;
        Log.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    ca localca = ((l)g.af(l.class)).eiy().aJ(paramr.dWq, paramr.dTS);
    int i = 0;
    if (localca.field_msgSvrId != paramr.dTS)
    {
      localca = new ca();
      localca.yF(paramr.dTS);
      localca.Cz(paramr.fileName);
      localca.setCreateTime(bp.C(paramr.dWq, paramr.createTime));
      localca.Cy(paramr.dWq);
      if (z.Im(paramr.jsh))
      {
        i = 1;
        localca.nv(i);
        localca.setType(34);
        localca.akm(paramr.jup);
        i = 1;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localca.gDR();
        label242:
        localca.CG(paramString1);
        localca.setStatus(paramInt);
        if (parama != null) {
          break label575;
        }
        paramInt = paramr.fqJ;
        if (paramInt != 0)
        {
          Log.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
          localca.setFlag(paramInt);
          if ((localca.field_msgId == 0L) && (localca.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
            localca.setCreateTime(bp.l(localca.field_talker, paramr.createTime, localca.field_msgSeq));
          }
        }
        if (paramr.jvu != 0) {
          localca.yH(paramr.jvu);
        }
        Log.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.jvu) });
        label385:
        Log.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
        if (!Util.isNullOrNil(paramString2))
        {
          localca.BB(paramString2);
          localca.CH(bp.Kz(paramString2));
        }
        if (paramBoolean) {
          break label585;
        }
        localca.setContent(p.b(paramr.jsh, Math.max(paramr.jvt, 0), false));
        label453:
        Log.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localca.field_msgSvrId), Long.valueOf(localca.field_msgSeq) });
        if (i == 0) {
          break label731;
        }
      }
      for (long l = bp.x(localca);; l = localca.field_msgId)
      {
        if (paramBoolean)
        {
          paramString1 = new zb();
          paramString1.efl.msgId = localca.field_msgId;
          paramString1.efl.success = true;
          paramString1.efl.efm = paramr.bih();
          EventCenter.instance.asyncPublish(paramString1, Looper.getMainLooper());
        }
        AppMethodBeat.o(148475);
        return l;
        i = 0;
        break;
        localca.gDQ();
        break label242;
        label575:
        bp.a(localca, parama);
        break label385;
        label585:
        localca.setContent(p.b(paramr.jsh, paramr.jvt, false));
        if (Util.isNullOrNil(paramString2)) {
          break label453;
        }
        localca.BB(paramString2);
        localca.CH(bp.Kz(paramString2));
        paramString1 = bp.Ky(paramString2);
        if (paramString1 == null) {
          break label453;
        }
        localca.CH(paramString1.iEs);
        localca.nM(paramString1.iEt);
        localca.CC(paramString1.iEr);
        Log.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramString1.iEr });
        if (paramString1.iEw == null) {
          break label453;
        }
        paramString2 = new lt();
        paramString2.dRf.dCM = localca;
        paramString2.dRf.dRg = paramString1;
        EventCenter.instance.publish(paramString2);
        break label453;
        label731:
        bp.y(localca);
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
    if (paramr.cSx == -1)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    boolean bool = o.bib().a(paramr.fileName, paramr);
    AppMethodBeat.o(148484);
    return bool;
  }
  
  private static boolean a(r paramr, h.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      paramr.jso = ((int)a(paramr, true, 3, "", paramr.fqK, parama));
      paramr.cSx |= 0x800;
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
    r localr = o.bib().Rr(paramString);
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
    localr.cSx = 64;
    synchronized (jvy)
    {
      jvy.put(paramString, new WeakReference(paramm));
      boolean bool = a(localr);
      AppMethodBeat.o(148462);
      return bool;
    }
  }
  
  public static boolean aB(String paramString, int paramInt)
  {
    AppMethodBeat.i(148467);
    boolean bool = v(paramString, paramInt, 0);
    AppMethodBeat.o(148467);
    return bool;
  }
  
  public static String aTa()
  {
    AppMethodBeat.i(148491);
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = g.aAh().hqG + "voice2/";
    AppMethodBeat.o(148491);
    return localObject;
  }
  
  public static boolean ai(ca paramca)
  {
    AppMethodBeat.i(148486);
    if ((paramca == null) || (!paramca.gAy()))
    {
      AppMethodBeat.o(148486);
      return false;
    }
    boolean bool = new p(paramca.field_content).jsi;
    AppMethodBeat.o(148486);
    return bool;
  }
  
  public static boolean aj(ca paramca)
  {
    AppMethodBeat.i(148487);
    if ((paramca == null) || (!paramca.gAy()) || (paramca.field_isSend == 1))
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
  
  public static void ak(ca paramca)
  {
    AppMethodBeat.i(148488);
    if ((paramca == null) || (!paramca.gAy()))
    {
      AppMethodBeat.o(148488);
      return;
    }
    Object localObject = ((l)g.af(l.class)).eiy().Hb(paramca.field_msgId);
    if (((eo)localObject).field_msgId != paramca.field_msgId)
    {
      AppMethodBeat.o(148488);
      return;
    }
    localObject = new p(((eo)localObject).field_content);
    if (((p)localObject).jsi)
    {
      AppMethodBeat.o(148488);
      return;
    }
    ((p)localObject).jsi = true;
    paramca.setContent(((p)localObject).bie());
    ((l)g.af(l.class)).eiy().a(paramca.field_msgId, paramca);
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
  
  public static b bE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148456);
    w localw = o.bib();
    paramString2 = getFullPath(paramString2);
    switch (Util.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.jvK.get(paramString2) == null) {
        localw.jvK.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.jvK.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    case 4: 
      if (localw.jvM.get(paramString2) == null) {
        localw.jvM.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.jvM.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    }
    if (localw.jvL.get(paramString2) == null) {
      localw.jvL.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.jvL.get(paramString2);
    AppMethodBeat.o(148456);
    return paramString1;
  }
  
  public static List<r> bii()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(148483);
    Object localObject1 = o.bib();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).iFy.rawQuery((String)localObject2, null, 2);
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
  
  public static String bij()
  {
    AppMethodBeat.i(148490);
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = g.aAh().hqG + "voice/";
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
    paramString = Y(paramString, false);
    AppMethodBeat.o(148459);
    return paramString;
  }
  
  public static String n(String paramString1, String paramString2, int paramInt)
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
    paramString1 = Rh(paramString1);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if (com.tencent.mm.vfs.s.nw(getFullPath(paramString2), getFullPath(paramString1)) < 0L)
    {
      AppMethodBeat.o(148479);
      return null;
    }
    v(paramString1, paramInt, 1);
    AppMethodBeat.o(148479);
    return paramString1;
  }
  
  public static int ui(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean uj(int paramInt)
  {
    AppMethodBeat.i(148478);
    ca localca = ((l)g.af(l.class)).eiy().Hb(paramInt);
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
    localObject = o.bib().Rr((String)localObject);
    if ((localObject == null) || (Util.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).jqP = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).jsm = (System.currentTimeMillis() / 1000L);
    ((r)localObject).cSx = 8648;
    boolean bool = a((r)localObject);
    Log.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).jso + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).jso == 0) || (Util.isNullOrNil(((r)localObject).dWq)))
    {
      Log.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).jso + " user:" + ((r)localObject).dWq);
      AppMethodBeat.o(148478);
      return bool;
    }
    localca.setStatus(1);
    ((l)g.af(l.class)).eiy().a(localca.field_msgId, localca);
    o.bid().run();
    AppMethodBeat.o(148478);
    return true;
  }
  
  private static boolean v(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148468);
    if (paramString == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    Log.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.bib().Rr(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).iKP = q.Qy(paramString);
    if (((r)???).iKP <= 0)
    {
      QE(paramString);
      AppMethodBeat.o(148468);
      return false;
    }
    ((r)???).jsm = (System.currentTimeMillis() / 1000L);
    ((r)???).jvt = paramInt1;
    ((r)???).cSx = 3424;
    ca localca = new ca();
    localca.Cy(((r)???).dWq);
    localca.setType(34);
    localca.nv(1);
    localca.Cz(paramString);
    if (((r)???).status == 97)
    {
      localca.setStatus(2);
      localca.setContent(p.b(((r)???).jsh, ((r)???).jvt, false));
    }
    for (;;)
    {
      localca.setCreateTime(bp.Kw(((r)???).dWq));
      localca.akm(paramInt2);
      a.a.anC().n(localca);
      ((r)???).jso = ((int)bp.x(localca));
      boolean bool = a((r)???);
      synchronized (jvy)
      {
        jvy.remove(paramString);
        AppMethodBeat.o(148468);
        return bool;
        if (((r)???).status == 98)
        {
          localca.setStatus(5);
          localca.setContent(p.b(((r)???).jsh, -1L, true));
          continue;
        }
        localca.setStatus(1);
        localca.setContent(p.b(((r)???).jsh, ((r)???).jvt, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */