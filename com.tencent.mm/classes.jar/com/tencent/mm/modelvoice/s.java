package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.bl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static final HashMap<String, WeakReference<com.tencent.mm.al.k>> hDt;
  public static volatile HashMap<String, Integer> hDu;
  public static volatile HashMap<String, Integer> hDv;
  public static volatile HashMap<String, Integer> hDw;
  
  static
  {
    AppMethodBeat.i(148492);
    hDt = new HashMap();
    hDu = new HashMap();
    hDv = new HashMap();
    hDw = new HashMap();
    AppMethodBeat.o(148492);
  }
  
  public static boolean AA(String paramString)
  {
    AppMethodBeat.i(148463);
    if (paramString == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    ad.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + paramString + "]");
    r localr = o.aDy().AJ(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148463);
      return false;
    }
    localr.status = 8;
    localr.gTY = q.zS(paramString);
    localr.dtM = 96;
    boolean bool = a(localr);
    AppMethodBeat.o(148463);
    return bool;
  }
  
  public static boolean AB(String paramString)
  {
    AppMethodBeat.i(148464);
    if (paramString == null)
    {
      AppMethodBeat.o(148464);
      return false;
    }
    r localr = o.aDy().AJ(paramString);
    if (localr == null)
    {
      ad.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148464);
      return true;
    }
    ad.d("MicroMsg.VoiceLogic", "cancel download : " + paramString + " SvrlId:" + localr.drA);
    if (localr.drA != 0L) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aP(localr.dtV, localr.drA);
    }
    boolean bool = AD(paramString);
    AppMethodBeat.o(148464);
    return bool;
  }
  
  public static boolean AC(String paramString)
  {
    AppMethodBeat.i(148465);
    if (paramString == null)
    {
      AppMethodBeat.o(148465);
      return false;
    }
    r localr = o.aDy().AJ(paramString);
    if (localr == null)
    {
      ad.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148465);
      return true;
    }
    ad.i("MicroMsg.VoiceLogic", "cancel record : " + paramString + " LocalId:" + localr.hAi);
    if (localr.hAi != 0) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rn(localr.hAi);
    }
    boolean bool = AD(paramString);
    AppMethodBeat.o(148465);
    return bool;
  }
  
  public static boolean AD(String paramString)
  {
    AppMethodBeat.i(148466);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148466);
      return false;
    }
    o.aDy().vv(paramString);
    Ay(paramString);
    boolean bool = new com.tencent.mm.vfs.e(getFullPath(paramString)).delete();
    AppMethodBeat.o(148466);
    return bool;
  }
  
  /* Error */
  public static boolean AE(String paramString)
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 71	com/tencent/mm/modelvoice/o:aDy	()Lcom/tencent/mm/modelvoice/w;
    //   8: aload_0
    //   9: invokevirtual 77	com/tencent/mm/modelvoice/w:AJ	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +10 -> 24
    //   17: ldc 195
    //   19: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: iconst_1
    //   23: ireturn
    //   24: new 183	com/tencent/mm/vfs/e
    //   27: dup
    //   28: aload_0
    //   29: invokestatic 186	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokespecial 187	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_0
    //   37: invokestatic 199	com/tencent/mm/modelvoice/s:Ax	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +78 -> 120
    //   45: aload_1
    //   46: instanceof 201
    //   49: ifeq +71 -> 120
    //   52: aload_3
    //   53: invokevirtual 205	com/tencent/mm/vfs/e:length	()J
    //   56: aload_2
    //   57: getfield 92	com/tencent/mm/modelvoice/r:gTY	I
    //   60: i2l
    //   61: lsub
    //   62: invokestatic 211	java/lang/Math:abs	(J)J
    //   65: ldc2_w 212
    //   68: lcmp
    //   69: ifne +51 -> 120
    //   72: ldc 42
    //   74: ldc 215
    //   76: iconst_2
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_3
    //   83: invokevirtual 205	com/tencent/mm/vfs/e:length	()J
    //   86: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload_2
    //   93: getfield 92	com/tencent/mm/modelvoice/r:gTY	I
    //   96: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokestatic 228	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_1
    //   104: ifnull +9 -> 113
    //   107: aload_1
    //   108: invokeinterface 233 1 0
    //   113: ldc 195
    //   115: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_1
    //   119: ireturn
    //   120: aload_3
    //   121: invokevirtual 205	com/tencent/mm/vfs/e:length	()J
    //   124: aload_2
    //   125: getfield 92	com/tencent/mm/modelvoice/r:gTY	I
    //   128: i2l
    //   129: lcmp
    //   130: ifeq +51 -> 181
    //   133: ldc 42
    //   135: ldc 235
    //   137: iconst_2
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_3
    //   144: invokevirtual 205	com/tencent/mm/vfs/e:length	()J
    //   147: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: aload_2
    //   154: getfield 92	com/tencent/mm/modelvoice/r:gTY	I
    //   157: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokestatic 238	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_1
    //   165: ifnull +9 -> 174
    //   168: aload_1
    //   169: invokeinterface 233 1 0
    //   174: ldc 195
    //   176: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_0
    //   180: ireturn
    //   181: aload_1
    //   182: iconst_0
    //   183: aload_2
    //   184: getfield 92	com/tencent/mm/modelvoice/r:gTY	I
    //   187: invokeinterface 242 3 0
    //   192: astore_0
    //   193: aload_0
    //   194: getfield 247	com/tencent/mm/modelvoice/g:ret	I
    //   197: ifne +75 -> 272
    //   200: aload_2
    //   201: getfield 250	com/tencent/mm/modelvoice/r:hDs	I
    //   204: ifeq +68 -> 272
    //   207: aload_2
    //   208: getfield 250	com/tencent/mm/modelvoice/r:hDs	I
    //   211: aload_2
    //   212: getfield 250	com/tencent/mm/modelvoice/r:hDs	I
    //   215: sipush 255
    //   218: iand
    //   219: aload_0
    //   220: getfield 254	com/tencent/mm/modelvoice/g:buf	[B
    //   223: aload_0
    //   224: getfield 257	com/tencent/mm/modelvoice/g:cZc	I
    //   227: invokestatic 261	com/tencent/mm/modelvoice/s:c	(I[BI)I
    //   230: if_icmpeq +42 -> 272
    //   233: ldc 42
    //   235: ldc_w 263
    //   238: iconst_1
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload_2
    //   245: getfield 250	com/tencent/mm/modelvoice/r:hDs	I
    //   248: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: invokestatic 238	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload_1
    //   256: ifnull +9 -> 265
    //   259: aload_1
    //   260: invokeinterface 233 1 0
    //   265: ldc 195
    //   267: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: iconst_0
    //   271: ireturn
    //   272: aload_1
    //   273: ifnull +9 -> 282
    //   276: aload_1
    //   277: invokeinterface 233 1 0
    //   282: ldc 195
    //   284: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: iconst_1
    //   288: ireturn
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_1
    //   292: aload_1
    //   293: ifnull +9 -> 302
    //   296: aload_1
    //   297: invokeinterface 233 1 0
    //   302: ldc 195
    //   304: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload_0
    //   308: athrow
    //   309: astore_0
    //   310: goto -197 -> 113
    //   313: astore_0
    //   314: goto -140 -> 174
    //   317: astore_0
    //   318: goto -53 -> 265
    //   321: astore_0
    //   322: goto -40 -> 282
    //   325: astore_1
    //   326: goto -24 -> 302
    //   329: astore_0
    //   330: goto -38 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramString	String
    //   40	257	1	localb	b
    //   325	1	1	localThrowable	java.lang.Throwable
    //   12	233	2	localr	r
    //   35	109	3	locale	com.tencent.mm.vfs.e
    // Exception table:
    //   from	to	target	type
    //   36	41	289	finally
    //   107	113	309	java/lang/Throwable
    //   168	174	313	java/lang/Throwable
    //   259	265	317	java/lang/Throwable
    //   276	282	321	java/lang/Throwable
    //   296	302	325	java/lang/Throwable
    //   45	103	329	finally
    //   120	164	329	finally
    //   181	255	329	finally
  }
  
  public static bl AF(String paramString)
  {
    AppMethodBeat.i(148481);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = o.aDy().AJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148481);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramString.hAi);
    AppMethodBeat.o(148481);
    return paramString;
  }
  
  public static r AG(String paramString)
  {
    AppMethodBeat.i(205922);
    paramString = o.aDy().AJ(paramString);
    AppMethodBeat.o(205922);
    return paramString;
  }
  
  public static int AH(String paramString)
  {
    AppMethodBeat.i(148489);
    synchronized (hDt)
    {
      if (hDt.get(paramString) != null)
      {
        paramString = (com.tencent.mm.al.k)((WeakReference)hDt.get(paramString)).get();
        if (paramString != null)
        {
          int i = (int)paramString.Ou();
          AppMethodBeat.o(148489);
          return i;
        }
      }
      AppMethodBeat.o(148489);
      return -1;
    }
  }
  
  public static boolean Aw(String paramString)
  {
    AppMethodBeat.i(148455);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString = o.aDy().AJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    if (paramString.hAj >= 250)
    {
      AppMethodBeat.o(148455);
      return false;
    }
    paramString.hAj += 1;
    paramString.dtM = 8192;
    boolean bool = a(paramString);
    AppMethodBeat.o(148455);
    return bool;
  }
  
  public static b Ax(String paramString)
  {
    AppMethodBeat.i(148457);
    w localw = o.aDy();
    String str = getFullPath(paramString);
    switch (q.Au(paramString))
    {
    default: 
      if (localw.hDF.get(str) == null) {
        localw.hDF.put(str, new a(str));
      }
      paramString = (b)localw.hDF.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 0: 
      if (localw.hDF.get(str) == null) {
        localw.hDF.put(str, new a(str));
      }
      paramString = (b)localw.hDF.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    case 1: 
      if (localw.hDG.get(str) == null) {
        localw.hDG.put(str, new n(str));
      }
      paramString = (b)localw.hDG.get(str);
      AppMethodBeat.o(148457);
      return paramString;
    }
    if (localw.hDH.get(str) == null) {
      localw.hDH.put(str, new j(str));
    }
    paramString = (b)localw.hDH.get(str);
    AppMethodBeat.o(148457);
    return paramString;
  }
  
  private static void Ay(String paramString)
  {
    AppMethodBeat.i(148458);
    w localw = o.aDy();
    String str = getFullPath(paramString);
    switch (q.Au(paramString))
    {
    default: 
      paramString = (a)localw.hDF.get(str);
      if (paramString != null)
      {
        paramString.aDm();
        localw.hDF.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 0: 
      paramString = (a)localw.hDF.get(str);
      if (paramString != null)
      {
        paramString.aDm();
        localw.hDF.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    case 1: 
      paramString = (n)localw.hDG.get(str);
      if (paramString != null)
      {
        paramString.aDm();
        localw.hDG.remove(str);
      }
      AppMethodBeat.o(148458);
      return;
    }
    paramString = (j)localw.hDH.get(str);
    if (paramString != null)
    {
      paramString.aDm();
      localw.hDH.remove(str);
    }
    AppMethodBeat.o(148458);
  }
  
  public static String Az(String paramString)
  {
    AppMethodBeat.i(148461);
    String str = w.AI(u.aqG());
    r localr = new r();
    localr.fileName = str;
    localr.dtV = paramString;
    localr.createTime = (System.currentTimeMillis() / 1000L);
    localr.clientId = str;
    localr.hAg = (System.currentTimeMillis() / 1000L);
    localr.status = 1;
    localr.hAb = u.aqG();
    localr.dtM = -1;
    if (!o.aDy().b(localr))
    {
      AppMethodBeat.o(148461);
      return null;
    }
    ad.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
    AppMethodBeat.o(148461);
    return str;
  }
  
  public static boolean W(bl parambl)
  {
    AppMethodBeat.i(148486);
    if ((parambl == null) || (!parambl.eJN()))
    {
      AppMethodBeat.o(148486);
      return false;
    }
    boolean bool = new p(parambl.field_content).hAc;
    AppMethodBeat.o(148486);
    return bool;
  }
  
  public static String X(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148460);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    String str = l.d(apY(), "msg_", paramString, ".amr", 2);
    ad.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + locala.XK() + " " + str);
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
    paramString = aDE() + paramString;
    if (new com.tencent.mm.vfs.e(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.i.lD(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(148460);
      return str;
      if (new com.tencent.mm.vfs.e(paramString).exists()) {
        com.tencent.mm.vfs.i.lD(paramString, str);
      }
    }
  }
  
  public static boolean X(bl parambl)
  {
    AppMethodBeat.i(148487);
    if ((parambl == null) || (!parambl.eJN()) || (parambl.field_isSend == 1))
    {
      AppMethodBeat.o(148487);
      return false;
    }
    if (new p(parambl.field_content).time == 0L)
    {
      AppMethodBeat.o(148487);
      return true;
    }
    AppMethodBeat.o(148487);
    return false;
  }
  
  public static void Y(bl parambl)
  {
    AppMethodBeat.i(148488);
    if ((parambl == null) || (!parambl.eJN()))
    {
      AppMethodBeat.o(148488);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(parambl.field_msgId);
    if (((du)localObject).field_msgId != parambl.field_msgId)
    {
      AppMethodBeat.o(148488);
      return;
    }
    localObject = new p(((du)localObject).field_content);
    if (((p)localObject).hAc)
    {
      AppMethodBeat.o(148488);
      return;
    }
    ((p)localObject).hAc = true;
    StringBuilder localStringBuilder = new StringBuilder().append(((p)localObject).hAb).append(":").append(((p)localObject).time).append(":");
    if (((p)localObject).hAc) {}
    for (int i = 1;; i = 0)
    {
      parambl.setContent(i + "\n");
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(parambl.field_msgId, parambl);
      AppMethodBeat.o(148488);
      return;
    }
  }
  
  public static int a(r paramr, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2, com.tencent.mm.al.f.a parama)
  {
    AppMethodBeat.i(148473);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    r localr = o.aDy().mJ(paramr.drA);
    if ((localr != null) && (localr.status == 99))
    {
      AppMethodBeat.o(148473);
      return 0;
    }
    if ((((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(paramr.dtV, paramr.drA).field_msgSvrId == paramr.drA) && (localr == null))
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
      paramr.dtM |= 0x1;
      ad.d("MicroMsg.VoiceLogic", f.XJ() + "checktime :" + locala.XK());
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
          str1 = paramr.hCe;
          str2 = paramr.fileName;
          i = br(str1, str2).write(paramArrayOfByte, paramArrayOfByte.length, 0);
          if (i >= 0) {
            break label644;
          }
          ad.e("MicroMsg.VoiceLogic", "Write Failed File:" + str2 + " newOffset:" + i + " voiceFormat:" + str1);
          bool1 = false;
          label276:
          paramr.hDs = c(paramr.hDs, paramArrayOfByte, paramArrayOfByte.length);
          paramr.dtM |= 0x80000;
        }
      }
      ad.d("MicroMsg.VoiceLogic", f.XJ() + "checktime :" + locala.XK());
      paramr.hAg = (System.currentTimeMillis() / 1000L);
      paramr.dtM |= 0x100;
      if (!bool1) {
        break label769;
      }
      paramr.status = 99;
    }
    for (;;)
    {
      paramr.dtM |= 0x40;
      if (localr != null) {
        break label841;
      }
      if (bool1) {
        paramr.hAi = ((int)a(paramr, bool1, paramInt, paramString1, paramString2, parama));
      }
      if (parama != null)
      {
        paramr.esg = bi.d(parama);
        if (parama.fTo != null) {
          paramr.hDq = parama.fTo.CxE;
        }
      }
      ad.d("MicroMsg.VoiceLogic", f.XJ() + "checktime :" + locala.XK());
      paramr.dtM = -1;
      ad.d("MicroMsg.VoiceLogic", "Insert fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.hyM + " total:" + paramr.gTY);
      if (o.aDy().b(paramr)) {
        break label793;
      }
      ad.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + paramr.fileName + " stat:" + paramr.status + " net:" + paramr.hyM + " total:" + paramr.gTY);
      AppMethodBeat.o(148473);
      return -2;
      paramr.fileName = w.AI(paramr.hAb);
      break;
      label644:
      if (paramArrayOfByte.length != i)
      {
        ad.e("MicroMsg.VoiceLogic", "Write File:" + str2 + " fileOff:" + i + " bufLen:" + paramArrayOfByte.length + " voiceFormat:" + str1);
        bool1 = false;
        break label276;
      }
      ad.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str2 + "] + buf:" + paramArrayOfByte.length + " voiceFormat:" + str1);
      Ay(str2);
      bool1 = true;
      break label276;
      label769:
      if (paramr.gTY == 0) {
        paramr.status = 5;
      } else {
        paramr.status = 6;
      }
    }
    label793:
    ad.d("MicroMsg.VoiceLogic", f.XJ() + "checktime :" + locala.XK());
    if (bool1)
    {
      AppMethodBeat.o(148473);
      return 1;
      label841:
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
    if ((localr != null) && (localr.hAd == paramr.gTY))
    {
      a(localr.fileName, localr.hAd, parama);
      ad.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + localr.fileName);
    }
    ad.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", new Object[] { parama, Boolean.valueOf(bool1), bt.eGN() });
    o.aDA().run();
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
    r localr = o.aDy().AJ(paramString1);
    if (localr == null)
    {
      AppMethodBeat.o(148469);
      return -1;
    }
    localr.hyM = paramInt1;
    localr.hAg = (System.currentTimeMillis() / 1000L);
    localr.dtM = 264;
    if ((bt.isNullOrNil(localr.clientId)) && (paramString2 != null))
    {
      localr.clientId = paramString2;
      localr.dtM |= 0x200;
    }
    if ((localr.drA == 0L) && (paramLong != 0L))
    {
      localr.drA = paramLong;
      localr.dtM |= 0x4;
    }
    int j = 0;
    int i = j;
    if (localr.gTY <= paramInt1)
    {
      i = j;
      if (localr.status == 3)
      {
        i = j;
        if (paramInt2 == 1)
        {
          localr.status = 99;
          localr.dtM |= 0x40;
          paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(localr.hAi);
          paramString2.nY(localr.dtV);
          paramString2.kX(localr.drA);
          paramString2.setStatus(2);
          paramString2.setContent(p.b(localr.hAb, localr.hDp, false));
          paramString2.WD(paramInt3);
          Integer localInteger = (Integer)hDu.get(getFullPath(paramString1));
          if (localInteger != null)
          {
            localr.hDs = localInteger.intValue();
            localr.dtM |= 0x80000;
          }
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(localr.hAi, paramString2);
          ad.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + paramString1 + " total:" + localr.gTY + " status:" + localr.status + " netTimes:" + localr.hAj + " msgId:" + paramString2.field_msgId);
          i = 1;
          Ay(paramString1);
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
  
  public static int a(String paramString, int paramInt, com.tencent.mm.al.f.a parama)
  {
    AppMethodBeat.i(148476);
    if (paramString == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    r localr = o.aDy().AJ(paramString);
    if (localr == null)
    {
      AppMethodBeat.o(148476);
      return -1;
    }
    localr.hAd = paramInt;
    localr.hAg = (System.currentTimeMillis() / 1000L);
    localr.dtM = 272;
    int j = 0;
    int i = j;
    if (localr.gTY > 0)
    {
      i = j;
      if (paramInt >= localr.gTY)
      {
        a(localr, parama);
        localr.status = 99;
        localr.dtM |= 0x40;
        ad.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + localr.gTY + " status:" + localr.status + " netTimes:" + localr.hAj);
        i = 1;
        Ay(paramString);
      }
    }
    ad.d("MicroMsg.VoiceLogic", "updateRecv file:" + paramString + " newsize:" + paramInt + " total:" + localr.gTY + " status:" + localr.status);
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
    paramString = o.aDy().AJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148471);
      return -1;
    }
    paramString.hDs = c(paramString.hDs, paramArrayOfByte, paramInt);
    paramString.dtM |= 0x80000;
    if (a(paramString))
    {
      paramInt = paramString.hDs;
      AppMethodBeat.o(148471);
      return paramInt;
    }
    AppMethodBeat.o(148471);
    return 0;
  }
  
  private static long a(r paramr, boolean paramBoolean, int paramInt, String paramString1, String paramString2, com.tencent.mm.al.f.a parama)
  {
    AppMethodBeat.i(148475);
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().ro(paramr.drA))
    {
      ad.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[] { Long.valueOf(paramr.drA) });
      if (bt.nullAsNil(paramr.fileName).length() > 0) {
        o.aDy().vv(paramr.fileName);
      }
      for (;;)
      {
        AppMethodBeat.o(148475);
        return -1L;
        ad.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
      }
    }
    bl localbl = new bl();
    localbl.kX(paramr.drA);
    localbl.nZ(paramr.fileName);
    localbl.kY(bi.y(paramr.dtV, paramr.createTime));
    localbl.nY(paramr.dtV);
    int i;
    if (u.se(paramr.hAb))
    {
      i = 1;
      localbl.jV(i);
      localbl.setType(34);
      localbl.od(paramString1);
      localbl.WD(paramr.hCl);
      localbl.setStatus(paramInt);
      if (parama != null) {
        break label566;
      }
      paramInt = paramr.esg;
      if (paramInt != 0)
      {
        ad.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", new Object[] { Integer.valueOf(paramInt) });
        localbl.setFlag(paramInt);
        if ((localbl.field_msgId == 0L) && (localbl.field_isSend == 0) && ((paramInt & 0x2) != 0)) {
          localbl.kY(bi.n(localbl.field_talker, paramr.createTime, localbl.field_msgSeq));
        }
      }
      if (paramr.hDq != 0) {
        localbl.la(paramr.hDq);
      }
      ad.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramr.hDq) });
      label329:
      ad.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", new Object[] { paramString2 });
      if (!bt.isNullOrNil(paramString2))
      {
        localbl.mZ(paramString2);
        localbl.oe(bi.um(paramString2));
      }
      if (paramBoolean) {
        break label576;
      }
      localbl.setContent(p.b(paramr.hAb, 0L, false));
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        localbl.mZ(paramString2);
        localbl.oe(bi.um(paramString2));
        paramr = bi.ul(paramString2);
        if (paramr != null)
        {
          localbl.oe(paramr.gNY);
          localbl.kn(paramr.gNZ);
          localbl.oc(paramr.gNX);
          ad.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", new Object[] { paramr.gNX });
          if (paramr.gOc != null)
          {
            paramString1 = new kl();
            paramString1.doR.dbD = localbl;
            paramString1.doR.doS = paramr;
            com.tencent.mm.sdk.b.a.ESL.l(paramString1);
          }
        }
      }
      ad.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", new Object[] { Long.valueOf(localbl.field_msgSvrId), Long.valueOf(localbl.field_msgSeq) });
      long l = bi.u(localbl);
      AppMethodBeat.o(148475);
      return l;
      i = 0;
      break;
      label566:
      bi.a(localbl, parama);
      break label329;
      label576:
      localbl.setContent(p.b(paramr.hAb, paramr.hDp, false));
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
    if (paramr.dtM == -1)
    {
      AppMethodBeat.o(148484);
      return false;
    }
    boolean bool = o.aDy().a(paramr.fileName, paramr);
    AppMethodBeat.o(148484);
    return bool;
  }
  
  private static boolean a(r paramr, com.tencent.mm.al.f.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      paramr.hAi = ((int)a(paramr, true, 3, "", paramr.esh, parama));
      paramr.dtM |= 0x800;
      boolean bool = a(paramr);
      AppMethodBeat.o(148474);
      return bool;
    }
    catch (Exception paramr)
    {
      ad.e("MicroMsg.VoiceLogic", "exception:%s", new Object[] { bt.m(paramr) });
      AppMethodBeat.o(148474);
    }
    return false;
  }
  
  public static boolean a(String paramString, com.tencent.mm.al.k paramk)
  {
    AppMethodBeat.i(148462);
    if (paramString == null)
    {
      AppMethodBeat.o(148462);
      return false;
    }
    r localr = o.aDy().AJ(paramString);
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
    localr.dtM = 64;
    synchronized (hDt)
    {
      hDt.put(paramString, new WeakReference(paramk));
      boolean bool = a(localr);
      AppMethodBeat.o(148462);
      return bool;
    }
  }
  
  public static List<r> aDD()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(148483);
    Object localObject1 = o.aDy();
    Object localObject2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo";
    localObject2 = (String)localObject2 + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime";
    localObject1 = ((w)localObject1).gPa.a((String)localObject2, null, 2);
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
  
  public static String aDE()
  {
    AppMethodBeat.i(148490);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = g.afB().gcW + "voice/";
    AppMethodBeat.o(148490);
    return localObject;
  }
  
  public static String apY()
  {
    AppMethodBeat.i(148491);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = g.afB().gcW + "voice2/";
    AppMethodBeat.o(148491);
    return localObject;
  }
  
  public static boolean aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(148467);
    boolean bool = u(paramString, paramInt, 0);
    AppMethodBeat.o(148467);
    return bool;
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
  
  public static b br(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148456);
    w localw = o.aDy();
    paramString2 = getFullPath(paramString2);
    switch (bt.getInt(paramString1, -1))
    {
    case 2: 
    case 3: 
    default: 
      if (localw.hDF.get(paramString2) == null) {
        localw.hDF.put(paramString2, new a(paramString2));
      }
      paramString1 = (b)localw.hDF.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    case 4: 
      if (localw.hDH.get(paramString2) == null) {
        localw.hDH.put(paramString2, new j(paramString2));
      }
      paramString1 = (b)localw.hDH.get(paramString2);
      AppMethodBeat.o(148456);
      return paramString1;
    }
    if (localw.hDG.get(paramString2) == null) {
      localw.hDG.put(paramString2, new n(paramString2));
    }
    paramString1 = (b)localw.hDG.get(paramString2);
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
    paramString = X(paramString, false);
    AppMethodBeat.o(148459);
    return paramString;
  }
  
  public static String m(String paramString1, String paramString2, int paramInt)
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
    paramString1 = Az(paramString1);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(148479);
      return null;
    }
    if (com.tencent.mm.vfs.i.lC(getFullPath(paramString2), getFullPath(paramString1)) < 0L)
    {
      AppMethodBeat.o(148479);
      return null;
    }
    u(paramString1, paramInt, 1);
    AppMethodBeat.o(148479);
    return paramString1;
  }
  
  public static float mI(long paramLong)
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
  
  public static int oZ(int paramInt)
  {
    return (paramInt - 6) / 32 * 20;
  }
  
  public static boolean pa(int paramInt)
  {
    AppMethodBeat.i(148478);
    bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramInt);
    if ((localbl.field_msgId == 0L) || (localbl.field_imgPath == null))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    if (bt.isNullOrNil(localbl.field_imgPath))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    Object localObject = localbl.field_imgPath;
    localObject = o.aDy().AJ((String)localObject);
    if ((localObject == null) || (bt.isNullOrNil(((r)localObject).fileName)))
    {
      AppMethodBeat.o(148478);
      return false;
    }
    ((r)localObject).status = 3;
    ((r)localObject).hyM = 0;
    ((r)localObject).createTime = (System.currentTimeMillis() / 1000L);
    ((r)localObject).hAg = (System.currentTimeMillis() / 1000L);
    ((r)localObject).dtM = 8648;
    boolean bool = a((r)localObject);
    ad.d("MicroMsg.VoiceLogic", " file:" + ((r)localObject).fileName + " msgid:" + ((r)localObject).hAi + "  stat:" + ((r)localObject).status);
    if ((((r)localObject).hAi == 0) || (bt.isNullOrNil(((r)localObject).dtV)))
    {
      ad.e("MicroMsg.VoiceLogic", " failed msg id:" + ((r)localObject).hAi + " user:" + ((r)localObject).dtV);
      AppMethodBeat.o(148478);
      return bool;
    }
    localbl.setStatus(1);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(localbl.field_msgId, localbl);
    o.aDA().run();
    AppMethodBeat.o(148478);
    return true;
  }
  
  private static boolean u(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148468);
    if (paramString == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    ad.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + paramString + "], fullPath[" + getFullPath(paramString) + "]");
    ??? = o.aDy().AJ(paramString);
    if (??? == null)
    {
      AppMethodBeat.o(148468);
      return false;
    }
    if ((((r)???).status != 97) && (((r)???).status != 98)) {
      ((r)???).status = 3;
    }
    ((r)???).gTY = q.zS(paramString);
    if (((r)???).gTY <= 0)
    {
      zV(paramString);
      AppMethodBeat.o(148468);
      return false;
    }
    ((r)???).hAg = (System.currentTimeMillis() / 1000L);
    ((r)???).hDp = paramInt1;
    ((r)???).dtM = 3424;
    bl localbl = new bl();
    localbl.nY(((r)???).dtV);
    localbl.setType(34);
    localbl.jV(1);
    localbl.nZ(paramString);
    if (((r)???).status == 97)
    {
      localbl.setStatus(2);
      localbl.setContent(p.b(((r)???).hAb, ((r)???).hDp, false));
    }
    for (;;)
    {
      localbl.kY(bi.uj(((r)???).dtV));
      localbl.WD(paramInt2);
      a.a.Wh().n(localbl);
      ((r)???).hAi = ((int)bi.u(localbl));
      boolean bool = a((r)???);
      synchronized (hDt)
      {
        hDt.remove(paramString);
        AppMethodBeat.o(148468);
        return bool;
        if (((r)???).status == 98)
        {
          localbl.setStatus(5);
          localbl.setContent(p.b(((r)???).hAb, -1L, true));
          continue;
        }
        localbl.setStatus(1);
        localbl.setContent(p.b(((r)???).hAb, ((r)???).hDp, false));
      }
    }
  }
  
  public static boolean zV(String paramString)
  {
    AppMethodBeat.i(148480);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 234L, 1L, false);
    if (paramString == null)
    {
      AppMethodBeat.o(148480);
      return false;
    }
    r localr = o.aDy().AJ(paramString);
    if (localr == null)
    {
      ad.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(148480);
      return false;
    }
    localr.status = 98;
    localr.hAg = (System.currentTimeMillis() / 1000L);
    localr.dtM = 320;
    boolean bool = a(localr);
    ad.d("MicroMsg.VoiceLogic", "setError file:" + paramString + " msgid:" + localr.hAi + " old stat:" + localr.status);
    if ((localr.hAi == 0) || (bt.isNullOrNil(localr.dtV)))
    {
      ad.e("MicroMsg.VoiceLogic", "setError failed msg id:" + localr.hAi + " user:" + localr.dtV);
      AppMethodBeat.o(148480);
      return bool;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(localr.hAi);
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 33L, 1L, true);
    paramString.setMsgId(localr.hAi);
    paramString.setStatus(5);
    paramString.nY(localr.dtV);
    paramString.setContent(p.b(localr.hAb, -1L, true));
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(148480);
    return bool;
  }
  
  public static boolean zW(String paramString)
  {
    AppMethodBeat.i(148477);
    paramString = o.aDy().AJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(148477);
      return false;
    }
    if (paramString.status == 3)
    {
      bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramString.hAi);
      localbl.setContent(p.b(paramString.hAb, paramString.hDp, false));
      localbl.setStatus(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramString.hAi, localbl);
    }
    paramString.status = 97;
    paramString.hAg = (System.currentTimeMillis() / 1000L);
    paramString.dtM = 320;
    boolean bool = a(paramString);
    AppMethodBeat.o(148477);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s
 * JD-Core Version:    0.7.0.1
 */