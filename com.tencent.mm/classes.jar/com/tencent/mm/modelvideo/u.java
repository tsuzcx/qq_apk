package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class u
{
  public static boolean W(String paramString, int paramInt)
  {
    int i = 0;
    s locals = oe(paramString);
    if (locals == null)
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramString);
      return false;
    }
    if (paramInt != locals.ebK)
    {
      y.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locals.ebK) });
      locals.ebK = paramInt;
      i = 32;
    }
    locals.eHC = paramInt;
    locals.eHF = bk.UX();
    e(locals);
    locals.status = 199;
    locals.bcw = (i | 0x510);
    boolean bool = f(locals);
    y.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + locals.ebK + " status:" + locals.status + " netTimes:" + locals.eHJ + " update ret: " + bool);
    return bool;
  }
  
  public static void X(String paramString, int paramInt)
  {
    paramString = oe(paramString);
    if (paramString != null)
    {
      paramString.status = 122;
      paramString.eHG = bk.UX();
      paramString.eHF = bk.UX();
      paramString.dmi = paramInt;
      paramString.bcw = 268438784;
      boolean bool = o.Sr().c(paramString);
      y.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
  }
  
  public static boolean Y(String paramString, int paramInt)
  {
    return b(oe(paramString), paramInt);
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    long l;
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      l = -1L;
      return l;
    }
    if (bk.bl(paramString2))
    {
      y.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      return -1L;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.eHH = 1;
    locals.bVI = paramString2;
    locals.eHA = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
    locals.createTime = bk.UX();
    locals.eHF = bk.UX();
    locals.eHN = null;
    locals.eFj = paramString3;
    if (!bk.bl(paramString3)) {
      locals.eHL = 1;
    }
    int i;
    if (62 == paramInt)
    {
      locals.eHL = 0;
      i = 3;
    }
    for (;;)
    {
      locals.eHO = i;
      locals.ebK = 0;
      locals.status = 106;
      paramString2 = new bi();
      paramString2.ec(locals.SA());
      paramString2.setType(paramInt);
      paramString2.fA(1);
      paramString2.ed(paramString1);
      paramString2.setStatus(8);
      paramString2.bg(bd.iK(locals.SA()));
      l = bd.h(paramString2);
      locals.eHI = ((int)l);
      if (o.Sr().b(locals)) {
        break;
      }
      return -1L;
      if (locals.eHL == 0) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3)
  {
    return a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramInt3, null, "");
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, bwa parambwa, String paramString5)
  {
    s locals = new s();
    locals.fileName = paramString1;
    locals.eHH = paramInt1;
    locals.bVI = paramString2;
    locals.eHA = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
    locals.createTime = bk.UX();
    locals.eHF = bk.UX();
    locals.eHN = paramString4;
    locals.eFj = paramString3;
    locals.eHQ = parambwa;
    locals.bYN = paramString5;
    if (!bk.bl(paramString3)) {
      locals.eHL = 1;
    }
    if (paramInt2 > 0) {
      locals.eHL = 1;
    }
    if (62 == paramInt3) {
      locals.eHO = 3;
    }
    for (;;)
    {
      o.Sr();
      paramInt1 = t.nU(t.nS(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      y.e("MicroMsg.VideoLogic", "get Video size failed :" + paramString1);
      return false;
      if (paramInt2 > 0) {
        locals.eHO = 2;
      } else {
        locals.eHO = 1;
      }
    }
    locals.ebK = paramInt1;
    o.Sr();
    paramString2 = t.nT(paramString1);
    paramInt1 = t.nU(paramString2);
    if (paramInt1 <= 0)
    {
      y.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      return false;
    }
    locals.eHE = paramInt1;
    y.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.eHE + " videosize:" + locals.ebK + " msgType:" + paramInt3);
    locals.status = 102;
    paramString2 = new bi();
    paramString2.ec(locals.SA());
    paramString2.setType(paramInt3);
    paramString2.fA(1);
    paramString2.ed(paramString1);
    paramString2.setStatus(1);
    paramString2.bg(bd.iK(locals.SA()));
    locals.eHI = ((int)bd.h(paramString2));
    return o.Sr().b(locals);
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 144	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +13 -> 17
    //   7: ldc 12
    //   9: ldc_w 288
    //   12: invokestatic 290	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: iconst_0
    //   16: ireturn
    //   17: new 292	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 293	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 296	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload 4
    //   37: astore_3
    //   38: aload_1
    //   39: aload 4
    //   41: bipush 9
    //   43: invokevirtual 300	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   46: iconst_0
    //   47: invokestatic 304	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   50: i2l
    //   51: invokestatic 308	com/tencent/mm/sdk/platformtools/bk:hv	(J)I
    //   54: putfield 313	com/tencent/mm/pointers/PInt:value	I
    //   57: aload 4
    //   59: astore_3
    //   60: aload_2
    //   61: aload 4
    //   63: bipush 20
    //   65: invokevirtual 300	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   68: iconst_0
    //   69: invokestatic 304	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   72: sipush 1000
    //   75: idiv
    //   76: putfield 313	com/tencent/mm/pointers/PInt:value	I
    //   79: aload 4
    //   81: invokevirtual 316	android/media/MediaMetadataRetriever:release	()V
    //   84: ldc 12
    //   86: ldc_w 318
    //   89: iconst_3
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_2
    //   96: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   99: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   109: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: aload_0
    //   116: aastore
    //   117: invokestatic 321	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: iconst_1
    //   121: ireturn
    //   122: astore 5
    //   124: aconst_null
    //   125: astore 4
    //   127: aload 4
    //   129: astore_3
    //   130: ldc 12
    //   132: aload 5
    //   134: ldc_w 323
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: aastore
    //   145: invokestatic 327	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload 4
    //   150: ifnull -66 -> 84
    //   153: aload 4
    //   155: invokevirtual 316	android/media/MediaMetadataRetriever:release	()V
    //   158: goto -74 -> 84
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_3
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 316	android/media/MediaMetadataRetriever:release	()V
    //   172: aload_0
    //   173: athrow
    //   174: astore_0
    //   175: goto -11 -> 164
    //   178: astore 5
    //   180: goto -53 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   0	183	1	paramPInt1	PInt
    //   0	183	2	paramPInt2	PInt
    //   28	141	3	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   24	130	4	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   122	11	5	localException1	Exception
    //   178	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   17	26	122	java/lang/Exception
    //   17	26	161	finally
    //   29	35	174	finally
    //   38	57	174	finally
    //   60	79	174	finally
    //   130	148	174	finally
    //   29	35	178	java/lang/Exception
    //   38	57	178	java/lang/Exception
    //   60	79	178	java/lang/Exception
  }
  
  public static boolean b(s params, int paramInt)
  {
    if (params != null)
    {
      params.dmi = paramInt;
      params.bcw = 268435456;
      return f(params);
    }
    return false;
  }
  
  public static boolean c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return a(paramString1, paramInt, paramString2, paramString3, 0, "", 43);
  }
  
  public static int cj(long paramLong)
  {
    Object localObject = o.Sr().ci(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((Iterator)localObject).next();
      int i = locals.status;
      locals.status = 200;
      y.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.zI() + "startSend file:" + locals.getFileName() + " status:[" + i + "->" + locals.status + "]");
      locals.eHG = bk.UX();
      locals.eHF = bk.UX();
      locals.bcw = 3328;
      if (!f(locals))
      {
        y.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.zI() + " update failed: " + locals.getFileName());
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
    }
    localObject = o.Sx();
    com.tencent.mm.kernel.g.DS().O(new m.3((m)localObject));
    return 0;
  }
  
  public static String d(long paramLong, int paramInt)
  {
    return paramLong + "_" + paramInt;
  }
  
  public static void d(s params)
  {
    if (params == null) {
      y.e("MicroMsg.VideoLogic", "video info is null");
    }
    bi localbi;
    int i;
    do
    {
      return;
      localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(params.eHI);
      i = localbi.getType();
      y.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    } while ((43 != i) && (62 != i));
    localbi.fA(1);
    localbi.ec(params.SA());
    localbi.bf(params.bXr);
    localbi.setStatus(2);
    localbi.setContent(q.d(params.SB(), params.eHH, false));
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(params.eHI, localbi);
    y.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
  }
  
  public static boolean d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    s locals = new s();
    locals.fileName = paramString1;
    locals.eHH = paramInt;
    locals.bVI = paramString2;
    locals.eHA = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
    locals.createTime = bk.UX();
    locals.eHF = bk.UX();
    locals.eHN = paramString3;
    locals.eHO = 1;
    o.Sr();
    locals.ebK = t.nU(t.nS(paramString1));
    o.Sr();
    locals.eHE = t.nU(t.nT(paramString1));
    y.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.eHE + " videosize:" + locals.ebK + " msgType:43");
    locals.status = 102;
    paramString2 = new bi();
    paramString2.ec(locals.SA());
    paramString2.setType(43);
    paramString2.fA(1);
    paramString2.ed(paramString1);
    paramString2.setStatus(1);
    paramString2.bg(bd.iK(locals.SA()));
    locals.eHI = ((int)bd.h(paramString2));
    return o.Sr().b(locals);
  }
  
  static boolean e(s params)
  {
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(params.eHI);
    int i = localbi.getType();
    y.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i)) {
      return false;
    }
    localbi.bf(params.bXr);
    localbi.setContent(q.d(params.SB(), params.eHH, false));
    localbi.ec(params.SA());
    y.d("MicroMsg.VideoLogic", "set msg content :" + localbi.field_content);
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(params.bXr, localbi);
    y.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
    if (localbi.aRR()) {
      y.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(params.ebK) });
    }
    return true;
  }
  
  public static void f(String paramString, int paramInt, boolean paramBoolean)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[] { paramString });
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i /= 1000;
    long l1 = bk.UZ();
    x localx;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.Su().ok(paramString))
    {
      localx = o.Su();
      int j = (int)(bk.UY() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (bk.bl(paramString)) {
          break label245;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localx.dXw.insert("VideoPlayHistory", "filename", localContentValues);
        y.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : " + l2);
        if (l2 <= 0L) {
          break label245;
        }
        bool = true;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(bk.cp(l1)) });
      return;
      paramInt = 0;
      break;
      label245:
      bool = false;
      continue;
      localx = o.Su();
      paramInt = (int)(bk.UY() / 1000L);
      if (!bk.bl(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localx.dXw.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
        y.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : " + l2);
        if (l2 > 0L)
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  public static boolean f(s params)
  {
    if (params == null) {}
    while (((params.getFileName() == null) || (params.getFileName().length() <= 0)) && (params.bcw == -1)) {
      return false;
    }
    return o.Sr().c(params);
  }
  
  public static int g(s params)
  {
    if (params.ebK == 0) {
      return 0;
    }
    y.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + params.eHC + " " + params.ebK);
    return params.eHC * 100 / params.ebK;
  }
  
  public static int h(long paramLong, String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return -1;
      try
      {
        paramString = paramString.split("_");
        if ((paramString != null) && (paramString.length == 2) && (bk.getLong(paramString[0], 0L) == paramLong))
        {
          int i = bk.getInt(paramString[1], 0);
          return i;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + paramString.toString());
      }
    }
    return -1;
  }
  
  public static int h(s params)
  {
    if (params.ebK == 0) {
      return 0;
    }
    y.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + params.eGk + " " + params.ebK);
    return params.eGk * 100 / params.ebK;
  }
  
  public static void l(String paramString, int paramInt1, int paramInt2)
  {
    s locals = oe(paramString);
    if (locals == null)
    {
      y.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      return;
    }
    o.Sr();
    int i = t.nU(t.nS(paramString));
    y.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    locals.ebK = i;
    locals.eHH = paramInt1;
    Object localObject = locals.eHR;
    ((avn)localObject).tqZ = false;
    locals.eHR = ((avn)localObject);
    locals.status = 102;
    o.Sr();
    locals.eHE = t.nU(t.nT(paramString));
    y.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + locals.eHE);
    locals.bcw = 4512;
    y.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(locals)), Integer.valueOf(paramInt2) });
    localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(locals.eHI);
    y.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((cs)localObject).field_msgId), Long.valueOf(((cs)localObject).field_msgSvrId), ((cs)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((cs)localObject).field_isSend), ((cs)localObject).field_imgPath, Integer.valueOf(((cs)localObject).field_status), Long.valueOf(((cs)localObject).field_createTime) });
    ((bi)localObject).ec(locals.SA());
    ((bi)localObject).setType(paramInt2);
    ((bi)localObject).fA(1);
    ((bi)localObject).ed(paramString);
    ((bi)localObject).setStatus(1);
    y.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((cs)localObject).field_msgId), Long.valueOf(((cs)localObject).field_msgSvrId), ((cs)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((cs)localObject).field_isSend), ((cs)localObject).field_imgPath, Integer.valueOf(((cs)localObject).field_status), Long.valueOf(((cs)localObject).field_createTime) });
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(locals.eHI, (bi)localObject);
  }
  
  public static boolean nW(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = oe(paramString);
    } while ((paramString == null) || (paramString.eHJ >= 2500));
    paramString.eHJ += 1;
    paramString.bcw = 16384;
    return f(paramString);
  }
  
  public static boolean nX(String paramString)
  {
    h.nFQ.a(111L, 218L, 1L, false);
    y.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, bk.csb() });
    o.Sw().bDU.remove(paramString);
    if (paramString == null) {
      return false;
    }
    s locals = oe(paramString);
    if (locals == null)
    {
      y.e("MicroMsg.VideoLogic", "Set error failed file:" + paramString);
      return false;
    }
    locals.status = 198;
    locals.eHF = (System.currentTimeMillis() / 1000L);
    locals.bcw = 1280;
    avn localavn = locals.eHR;
    localavn.trb = 0;
    locals.eHR = localavn;
    boolean bool = f(locals);
    y.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + locals.eHI + " old stat:" + locals.status);
    if ((locals == null) || (locals.eHI == 0)) {
      return bool;
    }
    paramString = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(locals.eHI);
    int i = paramString.getType();
    y.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i)) {
      return bool;
    }
    f.nEG.a(111L, 32L, 1L, true);
    paramString.ec(locals.SA());
    paramString.setContent(q.d(locals.SB(), -1L, true));
    y.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramString.field_msgId, paramString);
    return bool;
  }
  
  public static boolean nY(String paramString)
  {
    paramString = oe(paramString);
    if ((paramString == null) || (paramString.eHI == 0)) {
      return false;
    }
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramString.eHI);
    int i = localbi.getType();
    y.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i)) {
      return false;
    }
    localbi.setContent(q.d(paramString.SB(), paramString.eHH, false));
    localbi.setStatus(2);
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramString.eHI, localbi);
    paramString.status = 197;
    paramString.eHF = bk.UX();
    paramString.bcw = 1280;
    y.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    return f(paramString);
  }
  
  public static int nZ(String paramString)
  {
    s locals = oe(paramString);
    if (locals == null)
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    if ((locals.status != 102) && (locals.status != 105))
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + paramString + " status:" + locals.status);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    int i = locals.status;
    if ((locals.status != 102) && (locals.eHE == locals.eHD)) {}
    for (locals.status = 104;; locals.status = 103)
    {
      y.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.zI() + "startSend file:" + paramString + " status:[" + i + "->" + locals.status + "]");
      locals.eHG = bk.UX();
      locals.eHF = bk.UX();
      locals.bcw = 3328;
      if (f(locals)) {
        break;
      }
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " update failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    o.Sw().run();
    return 0;
  }
  
  public static int oa(String paramString)
  {
    s locals = oe(paramString);
    if (locals == null)
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + paramString + " status:" + locals.status);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    locals.status = 112;
    locals.eHG = bk.UX();
    locals.eHF = bk.UX();
    locals.bcw = 3328;
    if (!f(locals))
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " update failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    o.Sw().SN();
    o.Sw().run();
    return 0;
  }
  
  public static int ob(String paramString)
  {
    s locals = oe(paramString);
    if (locals == null)
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    if ((locals.status != 112) && (locals.status != 120) && (locals.status != 122) && (locals.status != 123))
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + paramString + " status:" + locals.status);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    locals.status = 113;
    locals.eHF = bk.UX();
    locals.bcw = 1280;
    if (!f(locals))
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " update failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    return 0;
  }
  
  public static boolean oc(String paramString)
  {
    y.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : " + paramString);
    s locals = new s();
    locals.status = 112;
    locals.eHF = bk.UX();
    locals.eHG = bk.UX();
    locals.fileName = paramString;
    locals.bcw = 3328;
    if (!f(locals)) {
      return false;
    }
    o.Sw().run();
    return true;
  }
  
  public static boolean od(String paramString)
  {
    s locals = oe(paramString);
    if (locals == null) {
      return false;
    }
    y.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = locals.eHR;
    if (paramString != null)
    {
      paramString.trb = 0;
      locals.eHR = paramString;
    }
    if (locals.eHD < locals.eHE) {}
    for (locals.status = 103;; locals.status = 104)
    {
      locals.createTime = bk.UX();
      locals.eHF = bk.UX();
      locals.eHG = bk.UX();
      locals.bcw = 536874752;
      if (!f(locals)) {
        break;
      }
      o.Sw().run();
      return true;
    }
  }
  
  public static s oe(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return o.Sr().nQ(paramString);
  }
  
  public static String of(String paramString)
  {
    String str2 = com.tencent.mm.compatible.util.e.dzD + bk.UY() + ".mp4";
    String str1 = str2;
    if (com.tencent.mm.vfs.e.r(paramString, str2) < 0L) {
      str1 = null;
    }
    return str1;
  }
  
  public static boolean og(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
    }
    Object localObject;
    int i;
    int j;
    do
    {
      do
      {
        return false;
        y.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: " + paramString);
        localObject = oe(paramString);
      } while ((localObject == null) || (((s)localObject).status != 199));
      i = ((s)localObject).ebK;
      o.Sr();
      j = (int)com.tencent.mm.vfs.e.aeQ(t.nS(paramString));
      y.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    } while ((j <= 0) || (Math.abs(j - i) <= 16));
    y.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    paramString = ((s)localObject).getFileName();
    h.nFQ.a(111L, 217L, 1L, false);
    paramString = oe(paramString);
    if (paramString != null)
    {
      localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramString.eHI);
      i = ((bi)localObject).getType();
      y.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
      if ((43 == i) || (62 == i))
      {
        ((bi)localObject).setContent(q.d(paramString.SB(), paramString.eHH, false));
        ((bi)localObject).setStatus(2);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramString.eHI, (bi)localObject);
        paramString.status = 196;
        paramString.eHF = bk.UX();
        paramString.bcw = 1280;
        y.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
        f(paramString);
      }
    }
    return true;
  }
  
  public static void oh(String paramString)
  {
    boolean bool = true;
    if (bk.bl(paramString)) {
      return;
    }
    if (o.Su().dXw.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      y.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      return;
      bool = false;
    }
  }
  
  public static boolean oi(String paramString)
  {
    paramString = oe(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.bcw = 2;
      boolean bool = o.Sr().c(paramString);
      y.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      return bool;
    }
    return false;
  }
  
  public static int oj(String paramString)
  {
    s locals = oe(paramString);
    if (locals == null)
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + paramString + " status:" + locals.status);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    int i = 256;
    d.Nl();
    if (d.Nq()) {
      locals.status = 122;
    }
    for (;;)
    {
      locals.eHG = bk.UX();
      locals.eHF = bk.UX();
      locals.bcw = (i | 0x800 | 0x400);
      if (f(locals)) {
        break;
      }
      y.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " update failed: " + paramString);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
      y.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      locals.status = 112;
      locals.eHC = 0;
      i = 272;
    }
    o.Sw().SN();
    o.Sw().run();
    return 0;
  }
  
  public static int u(int paramInt, String paramString)
  {
    long l = bk.UZ();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.Su().b(paramString, localPInt1, localPInt2)) && (bk.cn(localPInt1.value) < 300L)) {}
    for (int i = localPInt2.value;; i = 0)
    {
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < paramInt - 1) {}
      }
      else
      {
        j = 0;
      }
      y.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(bk.cp(l)) });
      return j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */