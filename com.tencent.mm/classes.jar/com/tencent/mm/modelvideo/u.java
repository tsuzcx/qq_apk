package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

public final class u
{
  public static int D(int paramInt, String paramString)
  {
    AppMethodBeat.i(50846);
    long l = bo.yB();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if ((o.alH().b(paramString, localPInt1, localPInt2)) && (bo.gz(localPInt1.value) < 300L)) {}
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
      ab.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localPInt1.value), paramString, Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(50846);
      return j;
    }
  }
  
  public static long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(50828);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(50828);
      return -1L;
    }
    if (bo.isNullOrNil(paramString2))
    {
      ab.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(50828);
      return -1L;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.fXx = 1;
    locals.cDt = paramString2;
    locals.fXq = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
    locals.createTime = bo.aox();
    locals.fXv = bo.aox();
    locals.fXD = null;
    locals.fVa = paramString3;
    if (!bo.isNullOrNil(paramString3)) {
      locals.fXB = 1;
    }
    int i;
    if (62 == paramInt)
    {
      locals.fXB = 0;
      i = 3;
    }
    for (;;)
    {
      locals.fXE = i;
      locals.fsd = 0;
      locals.status = 106;
      paramString2 = new bi();
      paramString2.kj(locals.getUser());
      paramString2.setType(paramInt);
      paramString2.hL(1);
      paramString2.kk(paramString1);
      paramString2.setStatus(8);
      paramString2.fQ(bf.py(locals.getUser()));
      long l = bf.l(paramString2);
      locals.fXy = ((int)l);
      if (!o.alE().b(locals)) {
        break;
      }
      AppMethodBeat.o(50828);
      return l;
      if (locals.fXB == 0) {
        i = 1;
      } else {
        i = -1;
      }
    }
    AppMethodBeat.o(50828);
    return -1L;
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(50825);
    boolean bool = a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramInt3, null, "");
    AppMethodBeat.o(50825);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, cii paramcii, String paramString5)
  {
    AppMethodBeat.i(50826);
    s locals = new s();
    locals.fileName = paramString1;
    locals.fXx = paramInt1;
    locals.cDt = paramString2;
    locals.fXq = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
    locals.createTime = bo.aox();
    locals.fXv = bo.aox();
    locals.fXD = paramString4;
    locals.fVa = paramString3;
    locals.fXG = paramcii;
    locals.cGU = paramString5;
    if (!bo.isNullOrNil(paramString3)) {
      locals.fXB = 1;
    }
    if (paramInt2 > 0) {
      locals.fXB = 1;
    }
    if (62 == paramInt3) {
      locals.fXE = 3;
    }
    for (;;)
    {
      o.alE();
      paramInt1 = t.vh(t.vf(paramString1));
      if (paramInt1 > 0) {
        break;
      }
      ab.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(50826);
      return false;
      if (paramInt2 > 0) {
        locals.fXE = 2;
      } else {
        locals.fXE = 1;
      }
    }
    locals.fsd = paramInt1;
    o.alE();
    paramString2 = t.vg(paramString1);
    paramInt1 = t.vh(paramString2);
    if (paramInt1 <= 0)
    {
      ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + paramString2 + " size:" + paramInt1);
      AppMethodBeat.o(50826);
      return false;
    }
    locals.fXu = paramInt1;
    ab.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.fXu + " videosize:" + locals.fsd + " msgType:" + paramInt3);
    locals.status = 102;
    paramString2 = new bi();
    paramString2.kj(locals.getUser());
    paramString2.setType(paramInt3);
    paramString2.hL(1);
    paramString2.kk(paramString1);
    paramString2.setStatus(1);
    paramString2.fQ(bf.py(locals.getUser()));
    locals.fXy = ((int)bf.l(paramString2));
    boolean bool = o.alE().b(locals);
    AppMethodBeat.o(50826);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 82	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 49
    //   15: ldc_w 278
    //   18: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 276
    //   24: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: new 282	android/media/MediaMetadataRetriever
    //   32: dup
    //   33: invokespecial 283	android/media/MediaMetadataRetriever:<init>	()V
    //   36: astore 4
    //   38: aload 4
    //   40: astore_3
    //   41: aload 4
    //   43: aload_0
    //   44: invokevirtual 286	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   47: aload 4
    //   49: astore_3
    //   50: aload_1
    //   51: aload 4
    //   53: bipush 9
    //   55: invokevirtual 290	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   58: iconst_0
    //   59: invokestatic 294	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   62: i2l
    //   63: invokestatic 298	com/tencent/mm/sdk/platformtools/bo:nX	(J)I
    //   66: putfield 41	com/tencent/mm/pointers/PInt:value	I
    //   69: aload 4
    //   71: astore_3
    //   72: aload_2
    //   73: aload 4
    //   75: bipush 20
    //   77: invokevirtual 290	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   80: iconst_0
    //   81: invokestatic 294	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   84: sipush 1000
    //   87: idiv
    //   88: putfield 41	com/tencent/mm/pointers/PInt:value	I
    //   91: aload 4
    //   93: invokevirtual 301	android/media/MediaMetadataRetriever:release	()V
    //   96: ldc 49
    //   98: ldc_w 303
    //   101: iconst_3
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_2
    //   108: getfield 41	com/tencent/mm/pointers/PInt:value	I
    //   111: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_1
    //   118: getfield 41	com/tencent/mm/pointers/PInt:value	I
    //   121: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: aload_0
    //   128: aastore
    //   129: invokestatic 71	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: ldc_w 276
    //   135: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_1
    //   139: ireturn
    //   140: astore 5
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 4
    //   147: astore_3
    //   148: ldc 49
    //   150: aload 5
    //   152: ldc_w 305
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: aastore
    //   163: invokestatic 309	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload 4
    //   168: ifnull -72 -> 96
    //   171: aload 4
    //   173: invokevirtual 301	android/media/MediaMetadataRetriever:release	()V
    //   176: goto -80 -> 96
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull +7 -> 190
    //   186: aload_3
    //   187: invokevirtual 301	android/media/MediaMetadataRetriever:release	()V
    //   190: ldc_w 276
    //   193: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_0
    //   197: athrow
    //   198: astore_0
    //   199: goto -17 -> 182
    //   202: astore 5
    //   204: goto -59 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramString	String
    //   0	207	1	paramPInt1	PInt
    //   0	207	2	paramPInt2	PInt
    //   40	147	3	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   36	136	4	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   140	11	5	localException1	Exception
    //   202	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   29	38	140	java/lang/Exception
    //   29	38	179	finally
    //   41	47	198	finally
    //   50	69	198	finally
    //   72	91	198	finally
    //   148	166	198	finally
    //   41	47	202	java/lang/Exception
    //   50	69	202	java/lang/Exception
    //   72	91	202	java/lang/Exception
  }
  
  public static boolean ae(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(50837);
    s locals = vr(paramString);
    if (locals == null)
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " getinfo failed: " + paramString);
      AppMethodBeat.o(50837);
      return false;
    }
    if (paramInt != locals.fsd)
    {
      ab.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locals.fsd) });
      locals.fsd = paramInt;
      i = 32;
    }
    locals.fXs = paramInt;
    locals.fXv = bo.aox();
    e(locals);
    locals.status = 199;
    locals.bsY = (i | 0x510);
    boolean bool = f(locals);
    ab.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramString + " newsize:" + paramInt + " total:" + locals.fsd + " status:" + locals.status + " netTimes:" + locals.fXz + " update ret: " + bool);
    AppMethodBeat.o(50837);
    return bool;
  }
  
  public static void af(String paramString, int paramInt)
  {
    AppMethodBeat.i(50851);
    paramString = vr(paramString);
    if (paramString != null)
    {
      paramString.status = 122;
      paramString.fXw = bo.aox();
      paramString.fXv = bo.aox();
      paramString.edL = paramInt;
      paramString.bsY = 268438784;
      boolean bool = o.alE().c(paramString);
      ab.i("MicroMsg.VideoLogic", "set online video Completion ret: " + bool + " status: " + paramString.status);
    }
    AppMethodBeat.o(50851);
  }
  
  public static boolean ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(50856);
    boolean bool = b(vr(paramString), paramInt);
    AppMethodBeat.o(50856);
    return bool;
  }
  
  public static boolean b(s params, int paramInt)
  {
    AppMethodBeat.i(50857);
    if (params != null)
    {
      params.edL = paramInt;
      params.bsY = 268435456;
      boolean bool = f(params);
      AppMethodBeat.o(50857);
      return bool;
    }
    AppMethodBeat.o(50857);
    return false;
  }
  
  public static boolean c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(50824);
    boolean bool = a(paramString1, paramInt, paramString2, paramString3, 0, "", 43);
    AppMethodBeat.o(50824);
    return bool;
  }
  
  public static void d(s params)
  {
    AppMethodBeat.i(50833);
    if (params == null)
    {
      ab.e("MicroMsg.VideoLogic", "video info is null");
      AppMethodBeat.o(50833);
      return;
    }
    bi localbi = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(params.fXy);
    int i = localbi.getType();
    ab.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(50833);
      return;
    }
    localbi.hL(1);
    localbi.kj(params.getUser());
    localbi.fP(params.cFn);
    localbi.setStatus(2);
    localbi.setContent(q.d(params.alM(), params.fXx, false));
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(params.fXy, localbi);
    ab.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
    AppMethodBeat.o(50833);
  }
  
  public static boolean d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(50827);
    s locals = new s();
    locals.fileName = paramString1;
    locals.fXx = paramInt;
    locals.cDt = paramString2;
    locals.fXq = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
    locals.createTime = bo.aox();
    locals.fXv = bo.aox();
    locals.fXD = paramString3;
    locals.fXE = 1;
    o.alE();
    locals.fsd = t.vh(t.vf(paramString1));
    o.alE();
    locals.fXu = t.vh(t.vg(paramString1));
    ab.i("MicroMsg.VideoLogic", "init record file:" + paramString1 + " thumbsize:" + locals.fXu + " videosize:" + locals.fsd + " msgType:43");
    locals.status = 102;
    paramString2 = new bi();
    paramString2.kj(locals.getUser());
    paramString2.setType(43);
    paramString2.hL(1);
    paramString2.kk(paramString1);
    paramString2.setStatus(1);
    paramString2.fQ(bf.py(locals.getUser()));
    locals.fXy = ((int)bf.l(paramString2));
    boolean bool = o.alE().b(locals);
    AppMethodBeat.o(50827);
    return bool;
  }
  
  public static String e(long paramLong, int paramInt)
  {
    AppMethodBeat.i(50849);
    String str = paramLong + "_" + paramInt;
    AppMethodBeat.o(50849);
    return str;
  }
  
  static boolean e(s params)
  {
    AppMethodBeat.i(50834);
    bi localbi = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(params.fXy);
    int i = localbi.getType();
    ab.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(50834);
      return false;
    }
    localbi.fP(params.cFn);
    localbi.setContent(q.d(params.alM(), params.fXx, false));
    localbi.kj(params.getUser());
    ab.d("MicroMsg.VideoLogic", "set msg content :" + localbi.field_content);
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().b(params.cFn, localbi);
    ab.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
    if (localbi.byk()) {
      ab.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[] { Integer.valueOf(params.fsd) });
    }
    AppMethodBeat.o(50834);
    return true;
  }
  
  public static int f(long paramLong, String paramString)
  {
    AppMethodBeat.i(50850);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50850);
      return -1;
    }
    try
    {
      paramString = paramString.split("_");
      int i;
      if (paramString != null)
      {
        i = paramString.length;
        if (i == 2) {}
      }
      else
      {
        AppMethodBeat.o(50850);
        return -1;
      }
      if (bo.getLong(paramString[0], 0L) == paramLong)
      {
        i = bo.getInt(paramString[1], 0);
        AppMethodBeat.o(50850);
        return i;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + paramString.toString());
      AppMethodBeat.o(50850);
    }
    return -1;
  }
  
  public static void f(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(50847);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[] { paramString });
      AppMethodBeat.o(50847);
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    i /= 1000;
    long l1 = bo.yB();
    x localx;
    ContentValues localContentValues;
    long l2;
    boolean bool;
    if (!o.alH().vz(paramString))
    {
      localx = o.alH();
      int j = (int)(bo.aoy() / 1000L);
      if (paramBoolean)
      {
        paramInt = 1;
        if (bo.isNullOrNil(paramString)) {
          break label256;
        }
        localContentValues = new ContentValues();
        localContentValues.put("filename", paramString);
        localContentValues.put("starttime", Integer.valueOf(j));
        localContentValues.put("playduration", Integer.valueOf(i));
        localContentValues.put("downloadway", Integer.valueOf(paramInt));
        l2 = localx.db.insert("VideoPlayHistory", "filename", localContentValues);
        ab.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(l2)));
        if (l2 <= 0L) {
          break label256;
        }
        bool = true;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(i), Boolean.valueOf(paramBoolean), Long.valueOf(bo.av(l1)) });
      AppMethodBeat.o(50847);
      return;
      paramInt = 0;
      break;
      label256:
      bool = false;
      continue;
      localx = o.alH();
      paramInt = (int)(bo.aoy() / 1000L);
      if (!bo.isNullOrNil(paramString))
      {
        localContentValues = new ContentValues();
        localContentValues.put("starttime", Integer.valueOf(paramInt));
        localContentValues.put("playduration", Integer.valueOf(i));
        l2 = localx.db.update("VideoPlayHistory", localContentValues, "filename=?", new String[] { paramString });
        ab.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(l2)));
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
    AppMethodBeat.i(50841);
    if (params == null)
    {
      AppMethodBeat.o(50841);
      return false;
    }
    if (((params.getFileName() == null) || (params.getFileName().length() <= 0)) && (params.bsY == -1))
    {
      AppMethodBeat.o(50841);
      return false;
    }
    boolean bool = o.alE().c(params);
    AppMethodBeat.o(50841);
    return bool;
  }
  
  public static int g(s params)
  {
    AppMethodBeat.i(50843);
    if (params.fsd == 0)
    {
      AppMethodBeat.o(50843);
      return 0;
    }
    ab.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + params.fXs + " " + params.fsd);
    int i = params.fXs * 100 / params.fsd;
    AppMethodBeat.o(50843);
    return i;
  }
  
  public static int h(s params)
  {
    AppMethodBeat.i(50844);
    if (params.fsd == 0)
    {
      AppMethodBeat.o(50844);
      return 0;
    }
    ab.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + params.fWa + " " + params.fsd);
    int i = params.fWa * 100 / params.fsd;
    AppMethodBeat.o(50844);
    return i;
  }
  
  public static int hf(long paramLong)
  {
    AppMethodBeat.i(50832);
    Object localObject = o.alE().he(paramLong).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((Iterator)localObject).next();
      int i = locals.status;
      locals.status = 200;
      ab.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.Ml() + "startSend file:" + locals.getFileName() + " status:[" + i + "->" + locals.status + "]");
      locals.fXw = bo.aox();
      locals.fXv = bo.aox();
      locals.bsY = 3328;
      if (!f(locals))
      {
        ab.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.Ml() + " update failed: " + locals.getFileName());
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(50832);
        return 0 - i;
      }
    }
    localObject = o.alK();
    com.tencent.mm.kernel.g.RO().ac(new m.3((m)localObject));
    AppMethodBeat.o(50832);
    return 0;
  }
  
  public static long t(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(50829);
    long l = a(paramString1, paramString2, paramString3, 43);
    AppMethodBeat.o(50829);
    return l;
  }
  
  public static void v(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50830);
    s locals = vr(paramString);
    if (locals == null)
    {
      ab.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(50830);
      return;
    }
    o.alE();
    int i = t.vh(t.vf(paramString));
    ab.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    locals.fsd = i;
    locals.fXx = paramInt1;
    Object localObject = locals.fXH;
    ((bby)localObject).xqZ = false;
    locals.fXH = ((bby)localObject);
    locals.status = 102;
    o.alE();
    locals.fXu = t.vh(t.vg(paramString));
    ab.i("MicroMsg.VideoLogic", "update prepare:" + paramString + " thumbsize:" + locals.fXu);
    locals.bsY = 4512;
    ab.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[] { Boolean.valueOf(f(locals)), Integer.valueOf(paramInt2) });
    localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(locals.fXy);
    ab.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((dd)localObject).field_msgId), Long.valueOf(((dd)localObject).field_msgSvrId), ((dd)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((dd)localObject).field_isSend), ((dd)localObject).field_imgPath, Integer.valueOf(((dd)localObject).field_status), Long.valueOf(((dd)localObject).field_createTime) });
    ((bi)localObject).kj(locals.getUser());
    ((bi)localObject).setType(paramInt2);
    ((bi)localObject).hL(1);
    ((bi)localObject).kk(paramString);
    ((bi)localObject).setStatus(1);
    ab.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((dd)localObject).field_msgId), Long.valueOf(((dd)localObject).field_msgSvrId), ((dd)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((dd)localObject).field_isSend), ((dd)localObject).field_imgPath, Integer.valueOf(((dd)localObject).field_status), Long.valueOf(((dd)localObject).field_createTime) });
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(locals.fXy, (bi)localObject);
    AppMethodBeat.o(50830);
  }
  
  public static boolean vj(String paramString)
  {
    AppMethodBeat.i(50821);
    if (paramString == null)
    {
      AppMethodBeat.o(50821);
      return false;
    }
    paramString = vr(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(50821);
      return false;
    }
    if (paramString.fXz >= 2500)
    {
      AppMethodBeat.o(50821);
      return false;
    }
    paramString.fXz += 1;
    paramString.bsY = 16384;
    boolean bool = f(paramString);
    AppMethodBeat.o(50821);
    return bool;
  }
  
  public static boolean vk(String paramString)
  {
    AppMethodBeat.i(50822);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 218L, 1L, false);
    ab.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[] { paramString, bo.dtY() });
    o.alJ().vA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(50822);
      return false;
    }
    s locals = vr(paramString);
    if (locals == null)
    {
      ab.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(50822);
      return false;
    }
    locals.status = 198;
    locals.fXv = (System.currentTimeMillis() / 1000L);
    locals.bsY = 1280;
    bby localbby = locals.fXH;
    localbby.xrb = 0;
    locals.fXH = localbby;
    boolean bool = f(locals);
    ab.d("MicroMsg.VideoLogic", "setError file:" + paramString + " msgid:" + locals.fXy + " old stat:" + locals.status);
    if ((locals == null) || (locals.fXy == 0))
    {
      AppMethodBeat.o(50822);
      return bool;
    }
    paramString = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(locals.fXy);
    int i = paramString.getType();
    ab.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(50822);
      return bool;
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 32L, 1L, true);
    paramString.kj(locals.getUser());
    paramString.setContent(q.d(locals.alM(), -1L, true));
    ab.d("MicroMsg.VideoLogic", "[oneliang][setError]");
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(paramString.field_msgId, paramString);
    AppMethodBeat.o(50822);
    return bool;
  }
  
  public static boolean vl(String paramString)
  {
    AppMethodBeat.i(50823);
    paramString = vr(paramString);
    if ((paramString == null) || (paramString.fXy == 0))
    {
      AppMethodBeat.o(50823);
      return false;
    }
    bi localbi = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(paramString.fXy);
    int i = localbi.getType();
    ab.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[] { Integer.valueOf(i) });
    if ((43 != i) && (62 != i))
    {
      AppMethodBeat.o(50823);
      return false;
    }
    localbi.setContent(q.d(paramString.alM(), paramString.fXx, false));
    localbi.setStatus(2);
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(paramString.fXy, localbi);
    paramString.status = 197;
    paramString.fXv = bo.aox();
    paramString.bsY = 1280;
    ab.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
    boolean bool = f(paramString);
    AppMethodBeat.o(50823);
    return bool;
  }
  
  public static int vm(String paramString)
  {
    AppMethodBeat.i(50831);
    s locals = vr(paramString);
    if (locals == null)
    {
      ab.e("MicroMsg.VideoLogic", "SENDERR:" + com.tencent.mm.compatible.util.g.Ml() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50831);
      return 0 - i;
    }
    if ((locals.status != 102) && (locals.status != 105))
    {
      ab.e("MicroMsg.VideoLogic", "SENDERR:" + com.tencent.mm.compatible.util.g.Ml() + " get status failed: " + paramString + " status:" + locals.status);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50831);
      return 0 - i;
    }
    int i = locals.status;
    if ((locals.status != 102) && (locals.fXu == locals.fXt)) {}
    for (locals.status = 104;; locals.status = 103)
    {
      ab.i("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.Ml() + "startSend file:" + paramString + " status:[" + i + "->" + locals.status + "]");
      locals.fXw = bo.aox();
      locals.fXv = bo.aox();
      locals.bsY = 3328;
      if (f(locals)) {
        break;
      }
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50831);
      return 0 - i;
    }
    o.alJ().run();
    AppMethodBeat.o(50831);
    return 0;
  }
  
  public static int vn(String paramString)
  {
    AppMethodBeat.i(50835);
    s locals = vr(paramString);
    int i;
    if (locals == null)
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50835);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " get status failed: " + paramString + " status:" + locals.status);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50835);
      return 0 - i;
    }
    locals.status = 112;
    locals.fXw = bo.aox();
    locals.fXv = bo.aox();
    locals.bsY = 3328;
    if (!f(locals))
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50835);
      return 0 - i;
    }
    o.alJ().alZ();
    o.alJ().run();
    AppMethodBeat.o(50835);
    return 0;
  }
  
  public static int vo(String paramString)
  {
    AppMethodBeat.i(50836);
    s locals = vr(paramString);
    int i;
    if (locals == null)
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50836);
      return 0 - i;
    }
    if ((locals.status != 112) && (locals.status != 120) && (locals.status != 122) && (locals.status != 123))
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " get status failed: " + paramString + " status:" + locals.status);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50836);
      return 0 - i;
    }
    locals.status = 113;
    locals.fXv = bo.aox();
    locals.bsY = 1280;
    if (!f(locals))
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50836);
      return 0 - i;
    }
    AppMethodBeat.o(50836);
    return 0;
  }
  
  public static boolean vp(String paramString)
  {
    AppMethodBeat.i(50838);
    ab.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(paramString)));
    s locals = new s();
    locals.status = 112;
    locals.fXv = bo.aox();
    locals.fXw = bo.aox();
    locals.fileName = paramString;
    locals.bsY = 3328;
    if (!f(locals))
    {
      AppMethodBeat.o(50838);
      return false;
    }
    o.alJ().run();
    AppMethodBeat.o(50838);
    return true;
  }
  
  public static boolean vq(String paramString)
  {
    AppMethodBeat.i(50839);
    s locals = vr(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(50839);
      return false;
    }
    ab.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[] { paramString });
    paramString = locals.fXH;
    if (paramString != null)
    {
      paramString.xrb = 0;
      locals.fXH = paramString;
    }
    if (locals.fXt < locals.fXu) {}
    for (locals.status = 103;; locals.status = 104)
    {
      locals.createTime = bo.aox();
      locals.fXv = bo.aox();
      locals.fXw = bo.aox();
      locals.bsY = 536874752;
      if (f(locals)) {
        break;
      }
      AppMethodBeat.o(50839);
      return false;
    }
    o.alJ().run();
    AppMethodBeat.o(50839);
    return true;
  }
  
  public static s vr(String paramString)
  {
    AppMethodBeat.i(50840);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50840);
      return null;
    }
    paramString = o.alE().vd(paramString);
    AppMethodBeat.o(50840);
    return paramString;
  }
  
  public static String vs(String paramString)
  {
    AppMethodBeat.i(50842);
    String str = com.tencent.mm.compatible.util.e.esr + bo.aoy() + ".mp4";
    if (com.tencent.mm.vfs.e.C(paramString, str) < 0L)
    {
      AppMethodBeat.o(50842);
      return null;
    }
    AppMethodBeat.o(50842);
    return str;
  }
  
  public static boolean vt(String paramString)
  {
    AppMethodBeat.i(50845);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
      AppMethodBeat.o(50845);
      return false;
    }
    ab.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(paramString)));
    Object localObject = vr(paramString);
    if ((localObject != null) && (((s)localObject).status == 199))
    {
      int i = ((s)localObject).fsd;
      o.alE();
      int j = (int)com.tencent.mm.vfs.e.avI(t.vf(paramString));
      ab.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j > 0) && (Math.abs(j - i) > 16))
      {
        ab.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramString = ((s)localObject).getFileName();
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 217L, 1L, false);
        paramString = vr(paramString);
        if (paramString != null)
        {
          localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(paramString.fXy);
          i = ((bi)localObject).getType();
          ab.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[] { Integer.valueOf(i) });
          if ((43 == i) || (62 == i))
          {
            ((bi)localObject).setContent(q.d(paramString.alM(), paramString.fXx, false));
            ((bi)localObject).setStatus(2);
            ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(paramString.fXy, (bi)localObject);
            paramString.status = 196;
            paramString.fXv = bo.aox();
            paramString.bsY = 1280;
            ab.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
            f(paramString);
          }
        }
        AppMethodBeat.o(50845);
        return true;
      }
    }
    AppMethodBeat.o(50845);
    return false;
  }
  
  public static void vu(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(50848);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50848);
      return;
    }
    if (o.alH().db.delete("VideoPlayHistory", "filename= ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      ab.d("MicroMsg.VideoLogic", "delete video play history ret : " + bool + " filename : " + paramString);
      AppMethodBeat.o(50848);
      return;
      bool = false;
    }
  }
  
  public static boolean vv(String paramString)
  {
    AppMethodBeat.i(50852);
    s locals = vr(paramString);
    if (locals != null)
    {
      locals.videoFormat = 2;
      locals.bsY = 2;
      boolean bool = o.alE().c(locals);
      ab.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(bool), paramString, Integer.valueOf(2) });
      AppMethodBeat.o(50852);
      return bool;
    }
    AppMethodBeat.o(50852);
    return false;
  }
  
  public static boolean vw(String paramString)
  {
    AppMethodBeat.i(50853);
    paramString = vr(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.status = 199;
      paramString.fXw = bo.aox();
      paramString.fXv = bo.aox();
      paramString.edL = 19;
      paramString.bsY = 268438786;
      boolean bool = o.alE().c(paramString);
      ab.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(50853);
      return bool;
    }
    AppMethodBeat.o(50853);
    return false;
  }
  
  public static boolean vx(String paramString)
  {
    AppMethodBeat.i(50854);
    paramString = vr(paramString);
    if (paramString != null)
    {
      paramString.videoFormat = 2;
      paramString.bsY = 2;
      boolean bool = o.alE().c(paramString);
      ab.i("MicroMsg.VideoLogic", "set hevc video format ret: " + bool + " status: " + paramString.status);
      AppMethodBeat.o(50854);
      return bool;
    }
    AppMethodBeat.o(50854);
    return false;
  }
  
  public static int vy(String paramString)
  {
    AppMethodBeat.i(50855);
    s locals = vr(paramString);
    if (locals == null)
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " getinfo failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50855);
      return 0 - i;
    }
    if ((locals.status != 111) && (locals.status != 113) && (locals.status != 121) && (locals.status != 122) && (locals.status != 123))
    {
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " get status failed: " + paramString + " status:" + locals.status);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50855);
      return 0 - i;
    }
    int i = 256;
    d.afW();
    if (d.agd()) {
      locals.status = 122;
    }
    for (;;)
    {
      locals.fXw = bo.aox();
      locals.fXv = bo.aox();
      locals.bsY = (i | 0x800 | 0x400);
      if (f(locals)) {
        break;
      }
      ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Ml() + " update failed: " + paramString);
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(50855);
      return 0 - i;
      ab.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
      locals.status = 112;
      locals.fXs = 0;
      i = 272;
    }
    o.alJ().alZ();
    o.alJ().run();
    AppMethodBeat.o(50855);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */