package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.api.r;
import com.tencent.mm.api.v;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.platformtools.af.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public final class f
  implements com.tencent.mm.plugin.messenger.foundation.a.o
{
  private long hmu;
  public a hmv;
  private final LinkedHashMap<String, b> hmw;
  
  public f()
  {
    AppMethodBeat.i(20310);
    this.hmu = -1L;
    this.hmw = new LinkedHashMap();
    h localh = new h();
    this.hmw.put(localh.getSubType(), localh);
    AppMethodBeat.o(20310);
  }
  
  static void a(long paramLong, bo parambo, com.tencent.mm.ak.f.a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20311);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "xmlSrvMsgId=%d msgInfo=%s isGet=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(parambo.field_msgId), Boolean.valueOf(parama.hvF) });
    if (0L != paramLong) {}
    bo localbo;
    com.tencent.mm.storage.ap localap;
    int i;
    Object localObject;
    com.tencent.mm.storage.bh localbh;
    for (long l = paramLong;; l = parambo.field_msgId)
    {
      localbo = bo.aK(parambo);
      if ((parambo.euk & 0x4) != 4)
      {
        parambo.setContent(paramString1);
        parambo.setType(10000);
        bi.a(parambo, parama);
        az.ayM();
        c.awD().a(parambo.field_msgId, parambo);
      }
      ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySvrId(paramLong);
      az.ayM();
      localap = c.awG().aNI(parambo.field_talker);
      if ((localap != null) && (localap.field_unReadCount > 0))
      {
        az.ayM();
        i = c.awD().ao(parambo);
        if (localap.field_unReadCount >= i)
        {
          localap.jR(localap.field_unReadCount - 1);
          az.ayM();
          c.awG().a(localap, localap.field_username);
        }
      }
      if ((parama == null) || (!parama.hvF)) {
        break label634;
      }
      localObject = parama.fXi;
      String str = z.a(((cu)localObject).DPV);
      localbh = new com.tencent.mm.storage.bh();
      localbh.field_originSvrId = l;
      if (parambo.field_msgId != 0L) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.i(paramString2, "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(l) });
      localbh.field_content = str;
      localbh.field_createTime = ((cu)localObject).CreateTime;
      localbh.field_flag = bi.d(parama);
      localbh.field_fromUserName = z.a(((cu)localObject).DPT);
      localbh.field_toUserName = z.a(((cu)localObject).DPU);
      localbh.field_newMsgId = ((cu)localObject).vTQ;
      com.tencent.mm.modelmulti.o.aGn();
      com.tencent.mm.sdk.platformtools.ac.i(paramString2, "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelmulti.o.aGl().insert(localbh)), Long.valueOf(localbh.systemRowid) });
      AppMethodBeat.o(20311);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i(paramString2, "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(l) });
    com.tencent.mm.modelmulti.o.aGn();
    com.tencent.mm.modelmulti.o.aGl().delete(localbh, true, new String[0]);
    az.ayM();
    c.awD().vT(l);
    if ((localap != null) && (parama.fXi != null) && (localap.field_lastSeq == parama.fXi.DQa))
    {
      com.tencent.mm.sdk.platformtools.ac.i(paramString2, "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(localap.field_lastSeq), Long.valueOf(localap.field_firstUnDeliverSeq) });
      az.ayM();
      localObject = c.awD().all(localap.field_username);
      if (localObject != null)
      {
        localap.ow(((dy)localObject).field_msgSeq);
        az.ayM();
        i = c.awG().a(localap, localap.field_username);
        com.tencent.mm.sdk.platformtools.ac.i(paramString2, "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((dy)localObject).field_msgSvrId), Long.valueOf(((dy)localObject).field_msgSeq), Long.valueOf(localap.field_lastSeq), Long.valueOf(localap.field_firstUnDeliverSeq), Integer.valueOf(i) });
      }
    }
    label634:
    if ((parambo.field_msgId == 0L) && ((parama == null) || (!parama.hvF)))
    {
      com.tencent.mm.sdk.platformtools.ac.i(paramString2, "summer revoke msg id is 0 and svrid[%d]", new Object[] { Long.valueOf(l) });
      az.ayM();
      c.awD().vT(l);
    }
    if (aa.i(localbo))
    {
      parama = new mv();
      parama.dpp.dpq = localbo;
      com.tencent.mm.sdk.b.a.GpY.l(parama);
    }
    parama = new rn();
    parama.dux.msgId = parambo.field_msgId;
    parama.dux.duy = paramString1;
    parama.dux.dpq = parambo;
    parama.dux.duz = localbo;
    parama.dux.duA = l;
    com.tencent.mm.sdk.b.a.GpY.l(parama);
    if (localbo == null)
    {
      AppMethodBeat.o(20311);
      return;
    }
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20308);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(this.hmA.field_msgId), Integer.valueOf(this.hmA.getType()) });
        switch (this.hmA.getType())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(20308);
          return;
          bi.v(this.hmA);
        }
      }
    });
    AppMethodBeat.o(20311);
  }
  
  private static String i(Object... paramVarArgs)
  {
    AppMethodBeat.i(20315);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        int m = paramVarArgs.length;
        i = 0;
        if (i >= m) {
          break label240;
        }
        localObject = paramVarArgs[i];
        if ((localObject instanceof String))
        {
          localByteArrayOutputStream.write(((String)localObject).getBytes());
        }
        else if ((localObject instanceof Integer))
        {
          int k = ((Integer)localObject).intValue();
          j = 0;
          if (j < 4)
          {
            localByteArrayOutputStream.write(k & 0xFF);
            k >>= 8;
            j += 1;
            continue;
          }
        }
        else if ((localObject instanceof Long))
        {
          long l = ((Long)localObject).longValue();
          j = 0;
          if (j < 8)
          {
            localByteArrayOutputStream.write((int)(0xFF & l));
            l >>= 8;
            j += 1;
            continue;
          }
        }
        else if ((localObject instanceof Boolean))
        {
          if (((Boolean)localObject).booleanValue())
          {
            j = 1;
            localByteArrayOutputStream.write(j);
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        AppMethodBeat.o(20315);
        return "";
      }
      int j = 0;
      continue;
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      AppMethodBeat.o(20315);
      return "";
      label240:
      paramVarArgs = bs.cx(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
      AppMethodBeat.o(20315);
      return paramVarArgs;
      i += 1;
    }
  }
  
  /* Error */
  private static String k(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: sipush 20313
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 429
    //   10: invokevirtual 433	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifeq +70 -> 83
    //   16: new 435	java/util/zip/ZipFile
    //   19: dup
    //   20: invokestatic 441	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   23: invokevirtual 447	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 452	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   29: invokespecial 454	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   32: astore 9
    //   34: aload 9
    //   36: aload 9
    //   38: aload_0
    //   39: iconst_1
    //   40: invokevirtual 458	java/lang/String:substring	(I)Ljava/lang/String;
    //   43: invokevirtual 462	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: invokevirtual 466	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   49: astore 8
    //   51: aload 9
    //   53: astore_0
    //   54: lload_1
    //   55: lconst_0
    //   56: lcmp
    //   57: ifle +37 -> 94
    //   60: aload_0
    //   61: astore 10
    //   63: aload 8
    //   65: astore 9
    //   67: aload 8
    //   69: lload_1
    //   70: invokevirtual 472	java/io/InputStream:skip	(J)J
    //   73: lstore 6
    //   75: lload_1
    //   76: lload 6
    //   78: lsub
    //   79: lstore_1
    //   80: goto -26 -> 54
    //   83: aload_0
    //   84: invokestatic 478	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   87: astore 8
    //   89: aconst_null
    //   90: astore_0
    //   91: goto -37 -> 54
    //   94: aload_0
    //   95: astore 10
    //   97: aload 8
    //   99: astore 9
    //   101: ldc_w 404
    //   104: invokestatic 410	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   107: astore 11
    //   109: aload_0
    //   110: astore 10
    //   112: aload 8
    //   114: astore 9
    //   116: sipush 2048
    //   119: newarray byte
    //   121: astore 12
    //   123: lload_3
    //   124: lconst_0
    //   125: lcmp
    //   126: ifle +60 -> 186
    //   129: aload_0
    //   130: astore 10
    //   132: aload 8
    //   134: astore 9
    //   136: aload 8
    //   138: aload 12
    //   140: iconst_0
    //   141: ldc2_w 479
    //   144: lload_3
    //   145: invokestatic 486	java/lang/Math:min	(JJ)J
    //   148: l2i
    //   149: invokevirtual 490	java/io/InputStream:read	([BII)I
    //   152: istore 5
    //   154: iload 5
    //   156: iconst_m1
    //   157: if_icmpeq +29 -> 186
    //   160: aload_0
    //   161: astore 10
    //   163: aload 8
    //   165: astore 9
    //   167: aload 11
    //   169: aload 12
    //   171: iconst_0
    //   172: iload 5
    //   174: invokevirtual 494	java/security/MessageDigest:update	([BII)V
    //   177: lload_3
    //   178: iload 5
    //   180: i2l
    //   181: lsub
    //   182: lstore_3
    //   183: goto -60 -> 123
    //   186: aload_0
    //   187: astore 10
    //   189: aload 8
    //   191: astore 9
    //   193: aload 11
    //   195: invokevirtual 496	java/security/MessageDigest:digest	()[B
    //   198: invokestatic 423	com/tencent/mm/sdk/platformtools/bs:cx	([B)Ljava/lang/String;
    //   201: astore 11
    //   203: aload 8
    //   205: ifnull +8 -> 213
    //   208: aload 8
    //   210: invokevirtual 499	java/io/InputStream:close	()V
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 500	java/util/zip/ZipFile:close	()V
    //   221: sipush 20313
    //   224: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload 11
    //   229: areturn
    //   230: astore 11
    //   232: aconst_null
    //   233: astore_0
    //   234: aconst_null
    //   235: astore 8
    //   237: aload_0
    //   238: astore 10
    //   240: aload 8
    //   242: astore 9
    //   244: ldc 62
    //   246: aload 11
    //   248: ldc_w 393
    //   251: iconst_0
    //   252: anewarray 4	java/lang/Object
    //   255: invokestatic 397	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: aload 8
    //   260: ifnull +8 -> 268
    //   263: aload 8
    //   265: invokevirtual 499	java/io/InputStream:close	()V
    //   268: aload_0
    //   269: ifnull +7 -> 276
    //   272: aload_0
    //   273: invokevirtual 500	java/util/zip/ZipFile:close	()V
    //   276: sipush 20313
    //   279: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: ldc_w 393
    //   285: areturn
    //   286: astore_0
    //   287: aconst_null
    //   288: astore 10
    //   290: aconst_null
    //   291: astore 9
    //   293: aload 9
    //   295: ifnull +8 -> 303
    //   298: aload 9
    //   300: invokevirtual 499	java/io/InputStream:close	()V
    //   303: aload 10
    //   305: ifnull +8 -> 313
    //   308: aload 10
    //   310: invokevirtual 500	java/util/zip/ZipFile:close	()V
    //   313: sipush 20313
    //   316: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: aload_0
    //   320: athrow
    //   321: astore 8
    //   323: goto -110 -> 213
    //   326: astore_0
    //   327: goto -106 -> 221
    //   330: astore 8
    //   332: goto -64 -> 268
    //   335: astore_0
    //   336: goto -60 -> 276
    //   339: astore 8
    //   341: goto -38 -> 303
    //   344: astore 8
    //   346: goto -33 -> 313
    //   349: astore_0
    //   350: aconst_null
    //   351: astore 8
    //   353: aload 9
    //   355: astore 10
    //   357: aload 8
    //   359: astore 9
    //   361: goto -68 -> 293
    //   364: astore_0
    //   365: goto -72 -> 293
    //   368: astore 11
    //   370: aconst_null
    //   371: astore 8
    //   373: aload 9
    //   375: astore_0
    //   376: goto -139 -> 237
    //   379: astore 11
    //   381: goto -144 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString	String
    //   0	384	1	paramLong1	long
    //   0	384	3	paramLong2	long
    //   152	27	5	i	int
    //   73	4	6	l	long
    //   49	215	8	localInputStream	java.io.InputStream
    //   321	1	8	localIOException1	java.io.IOException
    //   330	1	8	localIOException2	java.io.IOException
    //   339	1	8	localIOException3	java.io.IOException
    //   344	1	8	localIOException4	java.io.IOException
    //   351	21	8	localObject1	Object
    //   32	342	9	localObject2	Object
    //   61	295	10	localObject3	Object
    //   107	121	11	localObject4	Object
    //   230	17	11	localException1	Exception
    //   368	1	11	localException2	Exception
    //   379	1	11	localException3	Exception
    //   121	49	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	34	230	java/lang/Exception
    //   83	89	230	java/lang/Exception
    //   6	34	286	finally
    //   83	89	286	finally
    //   208	213	321	java/io/IOException
    //   217	221	326	java/io/IOException
    //   263	268	330	java/io/IOException
    //   272	276	335	java/io/IOException
    //   298	303	339	java/io/IOException
    //   308	313	344	java/io/IOException
    //   34	51	349	finally
    //   67	75	364	finally
    //   101	109	364	finally
    //   116	123	364	finally
    //   136	154	364	finally
    //   167	177	364	finally
    //   193	203	364	finally
    //   244	258	364	finally
    //   34	51	368	java/lang/Exception
    //   67	75	379	java/lang/Exception
    //   101	109	379	java/lang/Exception
    //   116	123	379	java/lang/Exception
    //   136	154	379	java/lang/Exception
    //   167	177	379	java/lang/Exception
    //   193	203	379	java/lang/Exception
  }
  
  /* Error */
  private static long vK(String paramString)
  {
    // Byte code:
    //   0: sipush 20314
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 429
    //   10: invokevirtual 433	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifeq +132 -> 145
    //   16: new 435	java/util/zip/ZipFile
    //   19: dup
    //   20: invokestatic 441	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   23: invokevirtual 447	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 452	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   29: invokespecial 454	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: aload_0
    //   40: iconst_1
    //   41: invokevirtual 458	java/lang/String:substring	(I)Ljava/lang/String;
    //   44: invokevirtual 462	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnonnull +18 -> 67
    //   52: aload 4
    //   54: invokevirtual 500	java/util/zip/ZipFile:close	()V
    //   57: sipush 20314
    //   60: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: ldc2_w 36
    //   66: lreturn
    //   67: aload 4
    //   69: astore_3
    //   70: aload_0
    //   71: invokevirtual 507	java/util/zip/ZipEntry:getSize	()J
    //   74: lstore_1
    //   75: aload 4
    //   77: invokevirtual 500	java/util/zip/ZipFile:close	()V
    //   80: sipush 20314
    //   83: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: lload_1
    //   87: lreturn
    //   88: astore 5
    //   90: aconst_null
    //   91: astore_0
    //   92: aload_0
    //   93: astore_3
    //   94: ldc 62
    //   96: aload 5
    //   98: ldc_w 393
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 397	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 500	java/util/zip/ZipFile:close	()V
    //   116: sipush 20314
    //   119: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: ldc2_w 36
    //   125: lreturn
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_3
    //   129: aload_3
    //   130: ifnull +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 500	java/util/zip/ZipFile:close	()V
    //   137: sipush 20314
    //   140: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_0
    //   144: athrow
    //   145: aload_0
    //   146: invokestatic 510	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   149: lstore_1
    //   150: sipush 20314
    //   153: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: lload_1
    //   157: lreturn
    //   158: astore_0
    //   159: goto -102 -> 57
    //   162: astore_0
    //   163: goto -83 -> 80
    //   166: astore_0
    //   167: goto -51 -> 116
    //   170: astore_3
    //   171: goto -34 -> 137
    //   174: astore_0
    //   175: goto -46 -> 129
    //   178: astore 5
    //   180: aload 4
    //   182: astore_0
    //   183: goto -91 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramString	String
    //   74	83	1	l	long
    //   36	98	3	localObject	Object
    //   170	1	3	localIOException1	java.io.IOException
    //   32	149	4	localZipFile	java.util.zip.ZipFile
    //   88	9	5	localIOException2	java.io.IOException
    //   178	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   16	34	88	java/io/IOException
    //   16	34	126	finally
    //   52	57	158	java/io/IOException
    //   75	80	162	java/io/IOException
    //   112	116	166	java/io/IOException
    //   133	137	170	java/io/IOException
    //   37	48	174	finally
    //   70	75	174	finally
    //   94	108	174	finally
    //   37	48	178	java/io/IOException
    //   70	75	178	java/io/IOException
  }
  
  public final com.tencent.mm.ak.f.b a(String paramString, final Map<String, String> paramMap, com.tencent.mm.ak.f.a parama)
  {
    AppMethodBeat.i(20312);
    localObject6 = parama.fXi;
    localObject5 = z.a(((cu)localObject6).DPV);
    String str = null;
    if (paramString != null)
    {
      Object localObject1 = (b)this.hmw.get(paramString);
      if (localObject1 != null) {
        try
        {
          localObject1 = ((b)localObject1).a(paramString, paramMap, parama);
          AppMethodBeat.o(20312);
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", localThrowable, "consumeNewXml dispatch handle subType [%s] error", new Object[] { paramString });
        }
      }
    }
    localObject2 = str;
    if (paramString != null)
    {
      localObject2 = str;
      if (paramString.equals("addcontact"))
      {
        ((cu)localObject6).DPV = z.FI((String)paramMap.get(".sysmsg.addcontact.content"));
        ((cu)localObject6).tit = 1;
        localObject2 = f.d.bY(Integer.valueOf(1));
        if (localObject2 != null) {
          break label814;
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.equals("dynacfg")))
      {
        com.tencent.mm.m.g.ZY().a((String)localObject5, paramMap, false);
        com.tencent.mm.m.g.ZZ();
        if (com.tencent.mm.m.c.ZL() == 2) {
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10879, "");
        }
        i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("MuteRoomDisable"), 0);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
      }
      if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
        com.tencent.mm.m.g.ZY().a((String)localObject5, paramMap, true);
      }
      if ((paramString != null) && (paramString.equals("banner")))
      {
        str = (String)paramMap.get(".sysmsg.mainframebanner.$type");
        localObject7 = (String)paramMap.get(".sysmsg.mainframebanner.showtype");
        localObject8 = (String)paramMap.get(".sysmsg.mainframebanner.data");
        if ((str == null) || (str.length() <= 0)) {}
      }
      try
      {
        bh.ayS().a(new bg(bs.getInt(str, 0), bs.getInt((String)localObject7, 0), (String)localObject8));
        str = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject7 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((str == null) || (localObject7 == null)) {}
      }
      catch (Exception localException1)
      {
        try
        {
          az.ayM().awZ().a((String)localObject7, true, null);
          str = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject7 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
          localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
          localObject10 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((!bs.isNullOrNil(str)) && (!bs.isNullOrNil((String)localObject10))) {}
          try
          {
            if (!((String)localObject10).equals("1")) {
              break label6487;
            }
            bool1 = true;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              long l;
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
              continue;
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l), paramString.toString() });
              continue;
              if ((paramString != null) && (paramString.equals("clouddelmsg")))
              {
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                localObject3 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
                localObject2 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
                paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
                i = ((String)localObject5).indexOf("<msg>");
                j = ((String)localObject5).indexOf("</msg>");
                if ((i == -1) || (j == -1))
                {
                  paramString = "";
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject3, localObject2, paramMap, paramString });
                }
                for (;;)
                {
                  try
                  {
                    az.ayM();
                    paramMap = c.awD().hJ(paramMap, (String)localObject2);
                    if ((paramMap == null) || (paramMap.size() <= 0))
                    {
                      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                      AppMethodBeat.o(20312);
                      return null;
                      paramString = com.tencent.mm.sdk.platformtools.bi.bF(bv.L(((String)localObject5).substring(i, j + 6), "msg"));
                      break;
                    }
                    paramMap = paramMap.iterator();
                    if (paramMap.hasNext())
                    {
                      localObject6 = (bo)paramMap.next();
                      if (localObject6 != null) {
                        break label1195;
                      }
                      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                    }
                    if (((dy)localObject6).field_msgSvrId >= 0L) {
                      break label1242;
                    }
                  }
                  catch (Exception paramString)
                  {
                    com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject2, paramString.toString() });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((dy)localObject6).field_msgId), Long.valueOf(((dy)localObject6).field_msgSvrId) });
                }
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((dy)localObject6).field_msgId), Long.valueOf(((dy)localObject6).field_msgSvrId) });
                localObject5 = bo.aK((bo)localObject6);
                i = bs.getInt((String)localObject3, 0);
                if (i == 1)
                {
                  az.ayM();
                  c.awD().aR(((dy)localObject6).field_talker, ((dy)localObject6).field_msgSvrId);
                }
                for (;;)
                {
                  localObject7 = new rn();
                  ((rn)localObject7).dux.msgId = ((dy)localObject6).field_msgId;
                  ((rn)localObject7).dux.duy = paramString;
                  ((rn)localObject7).dux.dpq = ((bo)localObject6);
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject7);
                  if (!aa.i((bo)localObject5)) {
                    break;
                  }
                  localObject6 = new mv();
                  ((mv)localObject6).dpp.dpq = ((bo)localObject5);
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject6);
                  break;
                  if ((i == 2) && (((bo)localObject6).eZj()))
                  {
                    ((bo)localObject6).setContent(paramString);
                    bi.a((bo)localObject6, parama);
                    az.ayM();
                    c.awD().b(((dy)localObject6).field_msgSvrId, (bo)localObject6);
                    az.ayM();
                    localObject7 = c.awG().aNI(((dy)localObject6).field_talker);
                    if ((localObject7 != null) && (((com.tencent.mm.g.c.az)localObject7).field_unReadCount > 0))
                    {
                      az.ayM();
                      i = c.awD().ao((bo)localObject6);
                      if (((com.tencent.mm.g.c.az)localObject7).field_unReadCount >= i)
                      {
                        ((com.tencent.mm.storage.ap)localObject7).jR(((com.tencent.mm.g.c.az)localObject7).field_unReadCount - 1);
                        az.ayM();
                        c.awG().a((com.tencent.mm.storage.ap)localObject7, ((com.tencent.mm.g.c.az)localObject7).field_username);
                      }
                    }
                  }
                }
              }
              if ((paramString != null) && (paramString.equals("updatepackage")))
              {
                localObject2 = f.d.bY(Integer.valueOf(-1879048175));
                if (localObject2 == null) {
                  localObject3 = null;
                }
                for (;;)
                {
                  localObject2 = localObject3;
                  if (paramString != null)
                  {
                    localObject2 = localObject3;
                    if (paramString.equals("deletepackage"))
                    {
                      localObject2 = f.d.bY(Integer.valueOf(-1879048174));
                      if (localObject2 != null) {
                        break label2480;
                      }
                      localObject2 = null;
                    }
                  }
                  if ((paramString != null) && (paramString.equals("delchatroommember")))
                  {
                    localObject3 = z.a(((cu)localObject6).DPT);
                    az.ayM();
                    localObject7 = c.awD().aF((String)localObject3, ((cu)localObject6).vTQ);
                    i = 0;
                    if (((dy)localObject7).field_msgId > 0L) {
                      i = 1;
                    }
                    ((bo)localObject7).oz(((cu)localObject6).vTQ);
                    if ((parama == null) || (!parama.hvF) || (!parama.hvH)) {
                      ((bo)localObject7).oA(bi.z((String)localObject3, ((cu)localObject6).CreateTime));
                    }
                    ((bo)localObject7).setType(10002);
                    ((bo)localObject7).setContent((String)localObject5);
                    ((bo)localObject7).jT(0);
                    ((bo)localObject7).re((String)localObject3);
                    ((bo)localObject7).qf(((cu)localObject6).DPY);
                    bi.a((bo)localObject7, parama);
                    if (i == 0) {
                      bi.u((bo)localObject7);
                    }
                  }
                  else
                  {
                    localObject3 = localObject2;
                    if (paramString != null)
                    {
                      localObject3 = localObject2;
                      if (paramString.equals("WakenPush"))
                      {
                        localObject3 = localObject2;
                        if (this.hmu != ((cu)localObject6).vTQ)
                        {
                          this.hmu = ((cu)localObject6).vTQ;
                          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                          localObject3 = new cj(paramMap);
                          localObject5 = (String)((cj)localObject3).hkv.get(".sysmsg.WakenPush.PushContent");
                          localObject7 = (String)((cj)localObject3).hkv.get(".sysmsg.WakenPush.Jump");
                          localObject2 = (String)((cj)localObject3).hkv.get(".sysmsg.WakenPush.ExpiredTime");
                          localObject8 = (String)((cj)localObject3).hkv.get(".sysmsg.WakenPush.Username");
                          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject5, localObject7, localObject2 });
                          localObject2 = com.tencent.mm.m.g.ZY().getValue("WakenPushDeepLinkBitSet");
                          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject2 });
                          if (bs.isNullOrNil((String)localObject2)) {
                            break label2515;
                          }
                          l = bs.getLong((String)localObject2, 0L);
                          localObject9 = com.tencent.mm.aj.c.a((String)localObject8, false, -1, null);
                          localObject10 = az.getNotification();
                          if (!bs.isNullOrNil((String)localObject7)) {
                            break label2521;
                          }
                          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                          localObject2 = "com.tencent.mm.ui.LauncherUI";
                          localObject11 = new Intent();
                          ((Intent)localObject11).setClassName(ai.getContext(), (String)localObject2);
                          ((Intent)localObject11).setFlags(536870912);
                          ((Intent)localObject11).putExtra("LauncherUI.Show.Update.DialogMsg", (String)((cj)localObject3).hkv.get(".sysmsg.WakenPush.PushContent"));
                          if (!((String)localObject7).equals("weixin://dl/update_newest_version")) {
                            ((Intent)localObject11).putExtra("LauncherUI.Show.Update.Url", (String)((cj)localObject3).hkv.get(".sysmsg.WakenPush.Jump"));
                          }
                          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 32L, 1L, true);
                          localObject2 = ((aq)localObject10).a(PendingIntent.getActivity(ai.getContext(), UUID.randomUUID().hashCode(), (Intent)localObject11, 134217728), ai.getContext().getString(2131755822), (String)localObject5, (String)localObject5, (Bitmap)localObject9, (String)localObject8);
                          ((Notification)localObject2).flags |= 0x10;
                          az.getNotification().a((Notification)localObject2, false);
                          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 31L, 1L, true);
                          localObject3 = null;
                        }
                      }
                    }
                    localObject2 = localObject3;
                    if (paramString == null) {
                      break label2783;
                    }
                    localObject2 = localObject3;
                    if (!paramString.equals("DisasterNotice")) {
                      break label2783;
                    }
                    localObject7 = (String)paramMap.get(".sysmsg.NoticeId");
                    localObject8 = (String)paramMap.get(".sysmsg.Content");
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject7, localObject8 });
                    localObject9 = ai.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.YK());
                    localObject5 = ((SharedPreferences)localObject9).getString("disaster_noticeid_list_key", "");
                    if (((String)localObject5).contains((CharSequence)localObject7)) {
                      break label2726;
                    }
                    localObject10 = ((String)localObject5).split(";");
                    if ((localObject10 == null) || (localObject10.length <= 10)) {
                      break label2637;
                    }
                    localObject2 = "";
                    j = localObject10.length;
                    i = 0;
                    localObject3 = localObject2;
                    if (i >= j) {
                      break label2641;
                    }
                    localObject11 = localObject10[i].split(",");
                    localObject3 = localObject2;
                  }
                  try
                  {
                    if (bs.pN(bs.getLong(localObject11[0], 0L)) < 1296000L) {
                      localObject3 = (String)localObject2 + localObject11[0] + "," + localObject11[1] + ";";
                    }
                    i += 1;
                    localObject2 = localObject3;
                    break label2365;
                    localObject3 = ((com.tencent.mm.ak.f)localObject2).b(parama);
                    continue;
                    localObject2 = ((com.tencent.mm.ak.f)localObject2).b(parama);
                    break label1621;
                    az.ayM();
                    c.awD().b(((cu)localObject6).vTQ, (bo)localObject7);
                    break label1781;
                    l = 0L;
                    break label1992;
                    if (((0x4 & l) == 4L) && (((String)localObject7).startsWith("weixin://dl/moments")))
                    {
                      localObject2 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                      break label2029;
                    }
                    if (((l & 0x40000) == 262144L) && (((String)localObject7).startsWith("weixin://dl/recommendation")))
                    {
                      localObject2 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                      break label2029;
                    }
                    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { localObject7 });
                    localObject2 = "com.tencent.mm.ui.LauncherUI";
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
                      localObject4 = localObject2;
                    }
                  }
                }
                localObject4 = localObject5;
                localObject2 = (String)localObject4 + bs.aNx() + "," + (String)localObject7 + ";";
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject5, localObject2 });
                ((SharedPreferences)localObject9).edit().putString("disaster_noticeid_list_key", (String)localObject2).commit();
                new ao(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(20306);
                    if (f.this.hmv != null) {
                      f.this.hmv.eG(this.hmx);
                    }
                    AppMethodBeat.o(20306);
                  }
                });
                ((cu)localObject6).DPV = z.FI((String)localObject8);
                ((cu)localObject6).tit = 1;
                localObject2 = f.d.bY(Integer.valueOf(1));
                if (localObject2 == null) {
                  localObject2 = null;
                }
                while ((paramString != null) && (paramString.equals("EmotionKv")))
                {
                  paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
                  localObject2 = (String)paramMap.get(".sysmsg.EmotionKv.I");
                  if (paramString != null) {
                    break label6477;
                  }
                  paramString = "";
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject2 });
                  localObject4 = com.tencent.mm.protocal.ac.eRt().DJD.getBytes();
                  localObject5 = com.tencent.mm.protocal.ac.eRt().DJE.getBytes();
                  paramMap = null;
                  try
                  {
                    parama = az.agi().hwg.aBZ().aBU();
                    paramMap = parama;
                  }
                  catch (Exception parama)
                  {
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { bs.m(parama) });
                    }
                    localObject6 = com.tencent.mm.protocal.f.eRf();
                    if (!bs.cv((byte[])localObject6)) {
                      break label2994;
                    }
                    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    parama = new PByteArray();
                    if (bs.isNullOrNil(paramString)) {
                      break label3040;
                    }
                  }
                  if (bs.cv(paramMap))
                  {
                    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    localObject2 = ((com.tencent.mm.ak.f)localObject2).b(parama);
                  }
                  else
                  {
                    if ((bs.cv((byte[])localObject5)) || (bs.cv((byte[])localObject4)) || (bs.cv(paramMap)) || (bs.cv((byte[])localObject6))) {
                      if (paramString == null)
                      {
                        i = -1;
                        if (localObject5 != null) {
                          break label3263;
                        }
                        j = -1;
                        if (localObject4 != null) {
                          break label3271;
                        }
                        k = -1;
                        if (paramMap != null) {
                          break label3279;
                        }
                        m = -1;
                        if (localObject6 != null) {
                          break label3286;
                        }
                        n = -1;
                        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
                        paramString = parama.value;
                        paramMap = new bod();
                        if (parama.value == null) {
                          break label3316;
                        }
                        paramMap.wTM = new String(parama.value);
                        if (paramString != null) {
                          break label3326;
                        }
                      }
                    }
                    for (i = -1;; i = paramString.length)
                    {
                      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.wTM.length()), com.tencent.mm.b.g.getMessageDigest(paramMap.wTM.getBytes()) });
                      paramMap.FdG = ((String)localObject2);
                      az.ayM();
                      c.awA().c(new j.a(59, paramMap));
                      AppMethodBeat.o(20312);
                      return null;
                      i = paramString.length();
                      break;
                      j = localObject5.length;
                      break label3055;
                      k = localObject4.length;
                      break label3063;
                      m = paramMap.length;
                      break label3070;
                      n = localObject6.length;
                      break label3078;
                      az.ayM();
                      MMProtocalJni.genClientCheckKVRes(c.getUin(), paramString, (byte[])localObject4, (byte[])localObject5, paramMap, (byte[])localObject6, parama);
                      break label3130;
                      paramMap.wTM = "";
                      break label3165;
                    }
                  }
                }
                if ((paramString != null) && (paramString.equals("globalalert")))
                {
                  paramString = (String)paramMap.get(".sysmsg.uuid");
                  i = bs.getInt((String)paramMap.get(".sysmsg.id"), -1);
                  j = bs.getInt((String)paramMap.get(".sysmsg.important"), -1);
                  if ((bs.isNullOrNil(paramString)) || (i < 0) || (j < 0))
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  parama = (String)paramMap.get(".sysmsg.title");
                  localObject2 = (String)paramMap.get(".sysmsg.msg");
                  if ((bs.isNullOrNil(parama)) && (bs.isNullOrNil((String)localObject2)))
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject2 });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
                  k = bs.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
                  m = bs.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                  localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn");
                  if ((bs.isNullOrNil((String)localObject5)) || (k < 0) || (m < 0))
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  localObject4 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
                  n = bs.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
                  i1 = bs.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                  paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
                  bool1 = true;
                  if ((bs.isNullOrNil((String)localObject4)) || (n < 0) || (i1 < 0))
                  {
                    bool1 = false;
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
                  }
                  localObject7 = new jm();
                  localObject8 = new com.tencent.mm.protocal.b.a.b();
                  ((jm)localObject7).dkX.dkY = ((com.tencent.mm.protocal.b.a.b)localObject8);
                  ((com.tencent.mm.protocal.b.a.b)localObject8).id = i;
                  ((com.tencent.mm.protocal.b.a.b)localObject8).title = parama;
                  ((com.tencent.mm.protocal.b.a.b)localObject8).bIO = ((String)localObject2);
                  ((com.tencent.mm.protocal.b.a.b)localObject8).DKx = new LinkedList();
                  localObject9 = new com.tencent.mm.protocal.b.a.a();
                  ((com.tencent.mm.protocal.b.a.a)localObject9).id = k;
                  ((com.tencent.mm.protocal.b.a.a)localObject9).actionType = m;
                  ((com.tencent.mm.protocal.b.a.a)localObject9).DKv = ((String)localObject5);
                  ((com.tencent.mm.protocal.b.a.a)localObject9).DKw = ((String)localObject6);
                  ((com.tencent.mm.protocal.b.a.b)localObject8).DKx.add(localObject9);
                  if (bool1)
                  {
                    localObject5 = new com.tencent.mm.protocal.b.a.a();
                    ((com.tencent.mm.protocal.b.a.a)localObject5).id = n;
                    ((com.tencent.mm.protocal.b.a.a)localObject5).actionType = i1;
                    ((com.tencent.mm.protocal.b.a.a)localObject5).DKv = ((String)localObject4);
                    ((com.tencent.mm.protocal.b.a.a)localObject5).DKw = paramMap;
                    ((com.tencent.mm.protocal.b.a.b)localObject8).DKx.add(localObject5);
                  }
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject2, Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject7)) });
                  AppMethodBeat.o(20312);
                  return null;
                }
                if ((paramString != null) && (paramString.equals("yybsigcheck")))
                {
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 14L, 1L, false);
                  l = System.currentTimeMillis();
                  paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                  parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
                  paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
                  com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                  if (bs.isNullOrNil(paramString))
                  {
                    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 15L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  localObject2 = paramString.split(";");
                  if (localObject2 == null) {}
                  for (i = -1;; i = localObject2.length)
                  {
                    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
                    if ((localObject2 != null) && (localObject2.length != 0)) {
                      break;
                    }
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 16L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4016), paramString });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  localObject4 = new ArrayList();
                  i = 0;
                  if (i < localObject2.length)
                  {
                    localObject5 = localObject2[i];
                    if (bs.isNullOrNil((String)localObject5)) {
                      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
                    }
                    for (;;)
                    {
                      i += 1;
                      break;
                      localObject6 = ((String)localObject5).split(",");
                      if (localObject6 == null) {}
                      for (j = -1;; j = localObject6.length)
                      {
                        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                        if ((localObject6 != null) && (localObject6.length == 3)) {
                          break label4472;
                        }
                        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                        break;
                      }
                      try
                      {
                        ((ArrayList)localObject4).add(new af.c(localObject6[0], bs.getInt(localObject6[1], 0), localObject6[2]));
                      }
                      catch (Exception localException5)
                      {
                        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 17L, 1L, false);
                        com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4017), localObject5 });
                      }
                    }
                  }
                  if (((ArrayList)localObject4).size() == 0)
                  {
                    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 18L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
                  {
                    bool1 = true;
                    bool2 = com.tencent.mm.platformtools.af.a(ai.getContext(), (ArrayList)localObject4, bool1);
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject4).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
                    if (bool2) {
                      break label4870;
                    }
                    az.ayK().setInt(46, 4);
                    localObject2 = new kh();
                    ((kh)localObject2).dlP.dlQ = parama;
                    ((kh)localObject2).dlP.url = paramMap;
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 20L, 1L, true);
                    com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(20312);
                    return null;
                    bool1 = false;
                    break;
                    az.ayK().setInt(46, 0);
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(322L, 19L, 1L, true);
                    com.tencent.mm.plugin.report.service.h.wUl.f(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                  }
                }
                if ((paramString != null) && (paramString.equals("qy_status_notify")))
                {
                  parama = (String)paramMap.get(".sysmsg.chat_id");
                  paramMap.get(".sysmsg.last_create_time");
                  paramString = (String)paramMap.get(".sysmsg.brand_username");
                  l = com.tencent.mm.al.a.e.Bx(parama);
                  if (l == -1L)
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  i = com.tencent.mm.al.af.aCZ().pT(l).field_newUnReadCount;
                  com.tencent.mm.al.af.aCZ().pV(l);
                  paramMap = com.tencent.mm.al.af.aCY().bd(l);
                  az.ayM();
                  parama = c.awG().aNI(paramString);
                  if (parama == null)
                  {
                    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if (paramMap.hc(1))
                  {
                    if (parama.field_unReadMuteCount <= i)
                    {
                      parama.jX(0);
                      az.ayM();
                      c.awG().a(parama, paramString);
                      az.getNotification().cancelNotification(paramString);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      parama.jX(parama.field_unReadMuteCount - i);
                      az.ayM();
                      c.awG().a(parama, paramString);
                    }
                  }
                  if (parama.field_unReadCount <= i)
                  {
                    az.ayM();
                    c.awG().aNK(paramString);
                    az.getNotification().cancelNotification(paramString);
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(20312);
                    return null;
                    parama.jW(0);
                    parama.jZ(0);
                    parama.jR(parama.field_unReadCount - i);
                    az.ayM();
                    c.awG().a(parama, paramString);
                  }
                }
                if ((paramString != null) && (paramString.equals("qy_chat_update")))
                {
                  parama = (String)paramMap.get(".sysmsg.chat_id");
                  localObject4 = (String)paramMap.get(".sysmsg.ver");
                  com.tencent.mm.al.a.e.o((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject4);
                }
                if ((paramString != null) && (paramString.equals("bindmobiletip")))
                {
                  i = bs.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
                  parama = bs.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
                  paramString = bs.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
                  paramMap = new String(Base64.decode(parama.getBytes(), 0));
                  parama = new String(com.tencent.mm.bw.b.cc(com.tencent.mm.compatible.deviceinfo.q.XX().getBytes()).XD(16).xy);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
                  if ((bs.isNullOrNil(paramMap)) || (paramMap.equals(parama)))
                  {
                    az.ayM();
                    c.agA().set(ah.a.GFV, Boolean.TRUE);
                    az.ayM();
                    paramMap = c.agA();
                    parama = ah.a.GFW;
                    if (i != 1) {
                      break label5547;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    paramMap.set(parama, Boolean.valueOf(bool1));
                    az.ayM();
                    c.agA().set(ah.a.GFX, paramString);
                    AppMethodBeat.o(20312);
                    return null;
                  }
                }
                if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
                {
                  parama = new bzl();
                  parama.Eou = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
                  parama.For = bs.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                  parama.Fos = bs.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                  parama.EeA = bs.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                  parama.Fot = k(parama.Eou, parama.For, parama.Fos);
                  parama.FileSize = ((int)vK(parama.Eou));
                  if (!com.tencent.mm.plugin.normsg.a.b.vor.dkx()) {
                    break label6419;
                  }
                  i = 1;
                }
                for (;;)
                {
                  parama.Fou = i;
                  parama.EqS = ab.Yu();
                  parama.Fov = i(new Object[] { parama.Eou, Integer.valueOf(parama.For), Integer.valueOf(parama.Fos), Integer.valueOf(parama.EeA), parama.Fot, Integer.valueOf(parama.FileSize), Integer.valueOf(parama.Fou), Integer.valueOf(parama.EqS) });
                  az.ayM();
                  c.awA().c(new j.a(61, parama));
                  if ((paramString != null) && (paramString.equals("ClientCheckHook")))
                  {
                    parama = new bzn();
                    parama.EeA = bs.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                    parama.Fox = com.tencent.mm.plugin.normsg.a.b.vor.oJ(false);
                    if (com.tencent.mm.plugin.normsg.a.b.vor.dkx())
                    {
                      i = 1;
                      parama.Fou = i;
                      parama.EqS = ab.Yu();
                      parama.Fov = i(new Object[] { Integer.valueOf(parama.EeA), parama.Fox, Integer.valueOf(parama.Fou), Integer.valueOf(parama.EqS) });
                      az.ayM();
                      c.awA().c(new j.a(62, parama));
                    }
                  }
                  else
                  {
                    if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
                    {
                      parama = new bzm();
                      parama.EeA = bs.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                      parama.Fow = com.tencent.mm.plugin.normsg.a.b.vor.dkw();
                      if (!com.tencent.mm.plugin.normsg.a.b.vor.dkx()) {
                        break label6431;
                      }
                      i = 1;
                      parama.Fou = i;
                      parama.EqS = ab.Yu();
                      parama.Fov = i(new Object[] { Integer.valueOf(parama.EeA), parama.Fow, Integer.valueOf(parama.Fou), Integer.valueOf(parama.EqS) });
                      az.ayM();
                      c.awA().c(new j.a(63, parama));
                    }
                    if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                      com.tencent.mm.sdk.g.b.e(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(20307);
                          int i = bs.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                          if (bs.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0)
                          {
                            com.tencent.mm.plugin.secinforeport.a.d.xnP.hd(i, 0);
                            AppMethodBeat.o(20307);
                            return;
                          }
                          com.tencent.mm.plugin.secinforeport.a.d.xnP.hd(i, 31);
                          AppMethodBeat.o(20307);
                        }
                      }, "syscmd_rpt_cc");
                    }
                    if ((!bs.isNullOrNil(paramString)) && (paramString.equals("functionmsg")))
                    {
                      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                      ((v)com.tencent.mm.kernel.g.ad(v.class)).getReceiver().a(localException5, paramMap);
                    }
                    if ((!bs.isNullOrNil(paramString)) && (paramString.equals("paymsg")))
                    {
                      i = bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                      localObject4 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                      paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                      parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                      paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(localException5.vTQ), paramString, parama, paramMap, localObject4 });
                    }
                  }
                  try
                  {
                    localObject4 = URLDecoder.decode((String)localObject4, "UTF-8");
                    if (!bs.isNullOrNil((String)localObject4))
                    {
                      localObject5 = new pl();
                      ((pl)localObject5).dss.type = i;
                      ((pl)localObject5).dss.content = ((String)localObject4);
                      ((pl)localObject5).dss.dng = paramString;
                      ((pl)localObject5).dss.toUser = parama;
                      ((pl)localObject5).dss.dsu = paramMap;
                      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject5);
                    }
                    AppMethodBeat.o(20312);
                    return localObject2;
                    i = 0;
                    continue;
                    i = 0;
                    break label5884;
                    i = 0;
                  }
                  catch (Exception paramString)
                  {
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
                      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
                    }
                  }
                }
              }
              boolean bool1 = false;
            }
          }
          az.ayM().axa().a(str, bool1, new String[] { localObject7, localObject8, localObject9 });
          az.ayM().axb().s(paramMap);
          if ((!bs.isNullOrNil(paramString)) && (paramString.equals("midinfo")))
          {
            str = (String)paramMap.get(".sysmsg.midinfo.json_buffer");
            localObject7 = (String)paramMap.get(".sysmsg.midinfo.time_interval");
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[] { localObject7, str, localObject5 });
            i = bs.getInt((String)localObject7, 0);
            if ((i > 86400L) && (i < 864000L))
            {
              az.ayM();
              c.agA().set(331777, Long.valueOf(bs.aNx() + i));
            }
            if (!bs.isNullOrNil(str)) {
              com.tencent.mm.plugin.report.c.d.arB(str);
            }
          }
          if ((paramString != null) && (paramString.equals("revokemsg")))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
            paramString = (String)paramMap.get(".sysmsg.revokemsg.session");
            localObject2 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
            paramMap = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject2, paramMap });
            try
            {
              l = bs.getLong((String)localObject2, 0L);
            }
            catch (Exception paramString)
            {
              label814:
              l = 0L;
            }
          }
          try
          {
            az.ayM();
            a(l, c.awD().aF(paramString, l), parama, paramMap, "MicroMsg.BigBallSysCmdMsgConsumer");
            AppMethodBeat.o(20312);
            return null;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Object localObject3;
              int j;
              Object localObject11;
              int k;
              int m;
              int n;
              int i1;
              boolean bool2;
              continue;
              continue;
              Object localObject4 = localObject2;
            }
          }
          localObject2 = ((com.tencent.mm.ak.f)localObject2).b(parama);
          continue;
          localException1 = localException1;
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void eG(String paramString);
  }
  
  public static abstract interface b
    extends com.tencent.mm.plugin.messenger.foundation.a.o
  {
    public abstract String getSubType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.f
 * JD-Core Version:    0.7.0.1
 */