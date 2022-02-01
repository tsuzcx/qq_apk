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
import com.tencent.mm.R.l;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.d;
import com.tencent.mm.api.y;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.f.a.lb;
import com.tencent.mm.f.a.lx;
import com.tencent.mm.f.a.os;
import com.tencent.mm.f.a.rq;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.bind.ui.BindMobilePolicyUI;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMWizardActivity;
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
  implements s
{
  private long lro;
  public a lrp;
  private final LinkedHashMap<String, b> lrq;
  
  public f()
  {
    AppMethodBeat.i(20310);
    this.lro = -1L;
    this.lrq = new LinkedHashMap();
    h localh = new h();
    this.lrq.put(localh.bcy(), localh);
    AppMethodBeat.o(20310);
  }
  
  /* Error */
  private static long Pc(String paramString)
  {
    // Byte code:
    //   0: sipush 20314
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 65
    //   9: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +131 -> 143
    //   15: new 73	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 79	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   22: invokevirtual 85	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 91	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 94	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: aload_0
    //   39: iconst_1
    //   40: invokevirtual 98	java/lang/String:substring	(I)Ljava/lang/String;
    //   43: invokevirtual 102	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +18 -> 66
    //   51: aload 4
    //   53: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   56: sipush 20314
    //   59: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc2_w 36
    //   65: lreturn
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: invokevirtual 111	java/util/zip/ZipEntry:getSize	()J
    //   73: lstore_1
    //   74: aload 4
    //   76: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   79: sipush 20314
    //   82: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: lload_1
    //   86: lreturn
    //   87: astore 5
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: astore_3
    //   93: ldc 113
    //   95: aload 5
    //   97: ldc 115
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   114: sipush 20314
    //   117: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: ldc2_w 36
    //   123: lreturn
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   135: sipush 20314
    //   138: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    //   143: aload_0
    //   144: invokestatic 126	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   147: lstore_1
    //   148: sipush 20314
    //   151: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: lload_1
    //   155: lreturn
    //   156: astore_0
    //   157: goto -101 -> 56
    //   160: astore_0
    //   161: goto -82 -> 79
    //   164: astore_0
    //   165: goto -51 -> 114
    //   168: astore_3
    //   169: goto -34 -> 135
    //   172: astore_0
    //   173: goto -46 -> 127
    //   176: astore 5
    //   178: aload 4
    //   180: astore_0
    //   181: goto -90 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   73	82	1	l	long
    //   35	97	3	localObject	Object
    //   168	1	3	localIOException1	java.io.IOException
    //   31	148	4	localZipFile	java.util.zip.ZipFile
    //   87	9	5	localIOException2	java.io.IOException
    //   176	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   15	33	87	java/io/IOException
    //   15	33	124	finally
    //   51	56	156	java/io/IOException
    //   74	79	160	java/io/IOException
    //   110	114	164	java/io/IOException
    //   131	135	168	java/io/IOException
    //   36	47	172	finally
    //   69	74	172	finally
    //   93	106	172	finally
    //   36	47	176	java/io/IOException
    //   69	74	176	java/io/IOException
  }
  
  private void a(String paramString1, long paramLong, h.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(284300);
    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "xmlSrvMsgId=%d talker=%s isGet=%s", new Object[] { Long.valueOf(paramLong), paramString1, Boolean.valueOf(parama.lCc) });
    ca localca1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(paramString1, paramLong);
    final ca localca2 = ca.bs(localca1);
    bh.beI();
    az localaz = c.bbR().bwx(paramString1);
    Object localObject2;
    int i;
    if ((parama != null) && (parama.lCc))
    {
      localObject1 = parama.jQG;
      localObject2 = z.a(((db)localObject1).RIF);
      bt localbt = new bt();
      localbt.field_originSvrId = paramLong;
      if (localca1.field_msgId == 0L)
      {
        Log.i(paramString3, "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(paramLong) });
        localbt.field_content = ((String)localObject2);
        localbt.field_createTime = ((db)localObject1).CreateTime;
        localbt.field_flag = bq.d(parama);
        localbt.field_fromUserName = z.a(((db)localObject1).RID);
        localbt.field_toUserName = z.a(((db)localObject1).RIE);
        localbt.field_newMsgId = ((db)localObject1).HlH;
        p.bno();
        Log.i(paramString3, "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(p.bnm().insert(localbt)), Long.valueOf(localbt.systemRowid) });
        AppMethodBeat.o(284300);
        return;
      }
      Log.i(paramString3, "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(paramLong) });
      p.bno();
      p.bnm().delete(localbt, true, new String[0]);
      if ((localaz != null) && (parama.jQG != null) && (localaz.field_lastSeq == parama.jQG.RIK))
      {
        Log.i(paramString3, "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(localaz.field_lastSeq), Long.valueOf(localaz.field_firstUnDeliverSeq) });
        bh.beI();
        localObject1 = c.bbO().aOJ(localaz.field_username);
        if (localObject1 != null)
        {
          localaz.ED(((et)localObject1).field_msgSeq);
          bh.beI();
          i = c.bbR().a(localaz, localaz.field_username);
          Log.i(paramString3, "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((et)localObject1).field_msgSvrId), Long.valueOf(((et)localObject1).field_msgSeq), Long.valueOf(localaz.field_lastSeq), Long.valueOf(localaz.field_firstUnDeliverSeq), Integer.valueOf(i) });
        }
      }
    }
    Object localObject1 = localca1;
    if (localca1.field_msgId == 0L)
    {
      localObject2 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.ag(PluginMessengerFoundation.class)).getFileMsgInfoStorage().Va(paramLong);
      localObject1 = localca1;
      if (localObject2 != null)
      {
        localObject1 = localca1;
        if (((com.tencent.mm.storage.a.a)localObject2).field_msgSvrId != 0L) {
          localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(paramString1, ((com.tencent.mm.storage.a.a)localObject2).field_msgSvrId);
        }
      }
    }
    if (((et)localObject1).field_msgId == 0L)
    {
      if (((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).getRecvRecord(paramLong) != null)
      {
        ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).be(paramString1, paramLong);
        AppMethodBeat.o(284300);
        return;
      }
      Log.i(paramString3, "summerbadcr get a revoke newxml, but original msg has not been found, originSvrId[%d]", new Object[] { Long.valueOf(paramLong) });
      bh.beI();
      c.bbO().Ou(paramLong);
      AppMethodBeat.o(284300);
      return;
    }
    if (((ca)localObject1).getType() == 922746929)
    {
      ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).be(paramString1, paramLong);
      AppMethodBeat.o(284300);
      return;
    }
    if ((((et)localObject1).hxx & 0x4) != 4)
    {
      ((ca)localObject1).setContent(paramString2);
      ((ca)localObject1).Jz(paramString2);
      ((ca)localObject1).setType(268445456);
      bq.a((ca)localObject1, parama);
      bh.beI();
      c.bbO().a(((et)localObject1).field_msgId, (ca)localObject1);
    }
    paramString1 = new tx();
    paramString1.fTi.msgId = ((et)localObject1).field_msgId;
    paramString1.fTi.fTj = paramString2;
    paramString1.fTi.fNz = ((ca)localObject1);
    paramString1.fTi.fTk = localca2;
    paramString1.fTi.fTl = paramLong;
    EventCenter.instance.publish(paramString1);
    if (localca2 != null) {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20308);
          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localca2.field_msgId), Integer.valueOf(localca2.getType()) });
          switch (localca2.getType())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(20308);
            return;
            bq.B(localca2);
          }
        }
      });
    }
    ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySvrId(paramLong);
    if ((localaz != null) && (localaz.field_unReadCount > 0))
    {
      bh.beI();
      i = c.bbO().aL((ca)localObject1);
      if (localaz.field_unReadCount >= i)
      {
        localaz.pH(localaz.field_unReadCount - 1);
        bh.beI();
        c.bbR().a(localaz, localaz.field_username);
      }
    }
    if (aa.i(localca2))
    {
      paramString1 = new os();
      paramString1.fNy.fNz = localca2;
      EventCenter.instance.publish(paramString1);
    }
    AppMethodBeat.o(284300);
  }
  
  private static String g(Object... paramVarArgs)
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
          break label237;
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
        Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        AppMethodBeat.o(20315);
        return "";
      }
      int j = 0;
      continue;
      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      AppMethodBeat.o(20315);
      return "";
      label237:
      paramVarArgs = Util.encodeHexString(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
      AppMethodBeat.o(20315);
      return paramVarArgs;
      i += 1;
    }
  }
  
  /* Error */
  private static String j(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: sipush 20313
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 65
    //   9: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +70 -> 82
    //   15: new 73	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 79	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   22: invokevirtual 85	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 91	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 94	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 9
    //   33: aload 9
    //   35: aload 9
    //   37: aload_0
    //   38: iconst_1
    //   39: invokevirtual 98	java/lang/String:substring	(I)Ljava/lang/String;
    //   42: invokevirtual 102	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: invokevirtual 527	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   48: astore 8
    //   50: aload 9
    //   52: astore_0
    //   53: lload_1
    //   54: lconst_0
    //   55: lcmp
    //   56: ifle +37 -> 93
    //   59: aload_0
    //   60: astore 10
    //   62: aload 8
    //   64: astore 9
    //   66: aload 8
    //   68: lload_1
    //   69: invokevirtual 533	java/io/InputStream:skip	(J)J
    //   72: lstore 6
    //   74: lload_1
    //   75: lload 6
    //   77: lsub
    //   78: lstore_1
    //   79: goto -26 -> 53
    //   82: aload_0
    //   83: invokestatic 537	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   86: astore 8
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -37 -> 53
    //   93: aload_0
    //   94: astore 10
    //   96: aload 8
    //   98: astore 9
    //   100: ldc_w 502
    //   103: invokestatic 508	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   106: astore 11
    //   108: aload_0
    //   109: astore 10
    //   111: aload 8
    //   113: astore 9
    //   115: sipush 2048
    //   118: newarray byte
    //   120: astore 12
    //   122: lload_3
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +60 -> 185
    //   128: aload_0
    //   129: astore 10
    //   131: aload 8
    //   133: astore 9
    //   135: aload 8
    //   137: aload 12
    //   139: iconst_0
    //   140: ldc2_w 538
    //   143: lload_3
    //   144: invokestatic 545	java/lang/Math:min	(JJ)J
    //   147: l2i
    //   148: invokevirtual 549	java/io/InputStream:read	([BII)I
    //   151: istore 5
    //   153: iload 5
    //   155: iconst_m1
    //   156: if_icmpeq +29 -> 185
    //   159: aload_0
    //   160: astore 10
    //   162: aload 8
    //   164: astore 9
    //   166: aload 11
    //   168: aload 12
    //   170: iconst_0
    //   171: iload 5
    //   173: invokevirtual 553	java/security/MessageDigest:update	([BII)V
    //   176: lload_3
    //   177: iload 5
    //   179: i2l
    //   180: lsub
    //   181: lstore_3
    //   182: goto -60 -> 122
    //   185: aload_0
    //   186: astore 10
    //   188: aload 8
    //   190: astore 9
    //   192: aload 11
    //   194: invokevirtual 555	java/security/MessageDigest:digest	()[B
    //   197: invokestatic 521	com/tencent/mm/sdk/platformtools/Util:encodeHexString	([B)Ljava/lang/String;
    //   200: astore 11
    //   202: aload 8
    //   204: ifnull +8 -> 212
    //   207: aload 8
    //   209: invokevirtual 556	java/io/InputStream:close	()V
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   220: sipush 20313
    //   223: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload 11
    //   228: areturn
    //   229: astore 11
    //   231: aconst_null
    //   232: astore_0
    //   233: aconst_null
    //   234: astore 8
    //   236: aload_0
    //   237: astore 10
    //   239: aload 8
    //   241: astore 9
    //   243: ldc 113
    //   245: aload 11
    //   247: ldc 115
    //   249: iconst_0
    //   250: anewarray 4	java/lang/Object
    //   253: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: aload 8
    //   258: ifnull +8 -> 266
    //   261: aload 8
    //   263: invokevirtual 556	java/io/InputStream:close	()V
    //   266: aload_0
    //   267: ifnull +7 -> 274
    //   270: aload_0
    //   271: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   274: sipush 20313
    //   277: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: ldc 115
    //   282: areturn
    //   283: astore_0
    //   284: aconst_null
    //   285: astore 10
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 9
    //   292: ifnull +8 -> 300
    //   295: aload 9
    //   297: invokevirtual 556	java/io/InputStream:close	()V
    //   300: aload 10
    //   302: ifnull +8 -> 310
    //   305: aload 10
    //   307: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   310: sipush 20313
    //   313: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_0
    //   317: athrow
    //   318: astore 8
    //   320: goto -108 -> 212
    //   323: astore_0
    //   324: goto -104 -> 220
    //   327: astore 8
    //   329: goto -63 -> 266
    //   332: astore_0
    //   333: goto -59 -> 274
    //   336: astore 8
    //   338: goto -38 -> 300
    //   341: astore 8
    //   343: goto -33 -> 310
    //   346: astore_0
    //   347: aconst_null
    //   348: astore 8
    //   350: aload 9
    //   352: astore 10
    //   354: aload 8
    //   356: astore 9
    //   358: goto -68 -> 290
    //   361: astore_0
    //   362: goto -72 -> 290
    //   365: astore 11
    //   367: aconst_null
    //   368: astore 8
    //   370: aload 9
    //   372: astore_0
    //   373: goto -137 -> 236
    //   376: astore 11
    //   378: goto -142 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramString	String
    //   0	381	1	paramLong1	long
    //   0	381	3	paramLong2	long
    //   151	27	5	i	int
    //   72	4	6	l	long
    //   48	214	8	localInputStream	java.io.InputStream
    //   318	1	8	localIOException1	java.io.IOException
    //   327	1	8	localIOException2	java.io.IOException
    //   336	1	8	localIOException3	java.io.IOException
    //   341	1	8	localIOException4	java.io.IOException
    //   348	21	8	localObject1	Object
    //   31	340	9	localObject2	Object
    //   60	293	10	localObject3	Object
    //   106	121	11	localObject4	Object
    //   229	17	11	localException1	Exception
    //   365	1	11	localException2	Exception
    //   376	1	11	localException3	Exception
    //   120	49	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	33	229	java/lang/Exception
    //   82	88	229	java/lang/Exception
    //   6	33	283	finally
    //   82	88	283	finally
    //   207	212	318	java/io/IOException
    //   216	220	323	java/io/IOException
    //   261	266	327	java/io/IOException
    //   270	274	332	java/io/IOException
    //   295	300	336	java/io/IOException
    //   305	310	341	java/io/IOException
    //   33	50	346	finally
    //   66	74	361	finally
    //   100	108	361	finally
    //   115	122	361	finally
    //   135	153	361	finally
    //   166	176	361	finally
    //   192	202	361	finally
    //   243	256	361	finally
    //   33	50	365	java/lang/Exception
    //   66	74	376	java/lang/Exception
    //   100	108	376	java/lang/Exception
    //   115	122	376	java/lang/Exception
    //   135	153	376	java/lang/Exception
    //   166	176	376	java/lang/Exception
    //   192	202	376	java/lang/Exception
  }
  
  public final h.b a(String paramString, final Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(20312);
    localObject7 = parama.jQG;
    localObject6 = z.a(((db)localObject7).RIF);
    String str = null;
    if (paramString != null)
    {
      Object localObject1 = (b)this.lrq.get(paramString);
      if (localObject1 != null) {
        try
        {
          localObject1 = ((b)localObject1).a(paramString, paramMap, parama);
          AppMethodBeat.o(20312);
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", localThrowable, "consumeNewXml dispatch handle subType [%s] error", new Object[] { paramString });
        }
      }
    }
    localObject2 = str;
    if (paramString != null)
    {
      localObject2 = str;
      if (paramString.equals("addcontact"))
      {
        ((db)localObject7).RIF = z.ZW((String)paramMap.get(".sysmsg.addcontact.content"));
        ((db)localObject7).COi = 1;
        localObject2 = h.d.cj(Integer.valueOf(1));
        if (localObject2 != null) {
          break label696;
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.equals("dynacfg")))
      {
        com.tencent.mm.n.h.axc().a((String)localObject6, paramMap, false);
        com.tencent.mm.n.h.axd();
        if (com.tencent.mm.n.d.awQ() == 2) {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10879, "");
        }
        i = Util.getInt(com.tencent.mm.n.h.axc().getValue("MuteRoomDisable"), 0);
        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
      }
      if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
        com.tencent.mm.n.h.axc().a((String)localObject6, paramMap, true);
      }
      if ((paramString != null) && (paramString.equals("banner")))
      {
        str = (String)paramMap.get(".sysmsg.mainframebanner.$type");
        localObject5 = (String)paramMap.get(".sysmsg.mainframebanner.showtype");
        localObject8 = (String)paramMap.get(".sysmsg.mainframebanner.data");
        if ((str == null) || (str.length() <= 0)) {}
      }
      try
      {
        bp.beO().a(new bo(Util.getInt(str, 0), Util.getInt((String)localObject5, 0), (String)localObject8));
        str = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject5 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((str == null) || (localObject5 == null)) {}
      }
      catch (Exception localException1)
      {
        try
        {
          bh.beI().bck().a((String)localObject5, true, null);
          str = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject5 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
          localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
          localObject10 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject10))) {}
          try
          {
            if (!((String)localObject10).equals("1")) {
              break label6612;
            }
            bool1 = true;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              long l1;
              Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
              continue;
              int j;
              if ((paramString != null) && (paramString.equals("clouddelmsg")))
              {
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                localObject3 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
                localObject2 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
                paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
                i = ((String)localObject6).indexOf("<msg>");
                j = ((String)localObject6).indexOf("</msg>");
                if ((i == -1) || (j == -1))
                {
                  paramString = "";
                  Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject3, localObject2, paramMap, paramString });
                }
                for (;;)
                {
                  try
                  {
                    bh.beI();
                    paramMap = c.bbO().iU(paramMap, (String)localObject2);
                    if ((paramMap == null) || (paramMap.size() <= 0))
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                      AppMethodBeat.o(20312);
                      return null;
                      paramString = SemiXml.encode(XmlParser.parseXml(((String)localObject6).substring(i, j + 6), "msg", null));
                      break;
                    }
                    paramMap = paramMap.iterator();
                    if (paramMap.hasNext())
                    {
                      localObject6 = (ca)paramMap.next();
                      if (localObject6 != null) {
                        break label1074;
                      }
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                    }
                    if (((et)localObject6).field_msgSvrId >= 0L) {
                      break label1121;
                    }
                  }
                  catch (Exception paramString)
                  {
                    Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject2, paramString.toString() });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((et)localObject6).field_msgId), Long.valueOf(((et)localObject6).field_msgSvrId) });
                }
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((et)localObject6).field_msgId), Long.valueOf(((et)localObject6).field_msgSvrId) });
                localObject5 = ca.bs((ca)localObject6);
                i = Util.getInt((String)localObject3, 0);
                if (i == 1)
                {
                  bh.beI();
                  c.bbO().aV(((et)localObject6).field_talker, ((et)localObject6).field_msgSvrId);
                }
                for (;;)
                {
                  localObject7 = new tx();
                  ((tx)localObject7).fTi.msgId = ((et)localObject6).field_msgId;
                  ((tx)localObject7).fTi.fTj = paramString;
                  ((tx)localObject7).fTi.fNz = ((ca)localObject6);
                  EventCenter.instance.publish((IEvent)localObject7);
                  if (!aa.i((ca)localObject5)) {
                    break;
                  }
                  localObject6 = new os();
                  ((os)localObject6).fNy.fNz = ((ca)localObject5);
                  EventCenter.instance.publish((IEvent)localObject6);
                  break;
                  if ((i == 2) && (((ca)localObject6).hwA()))
                  {
                    ((ca)localObject6).setContent(paramString);
                    bq.a((ca)localObject6, parama);
                    bh.beI();
                    c.bbO().b(((et)localObject6).field_msgSvrId, (ca)localObject6);
                    bh.beI();
                    localObject7 = c.bbR().bwx(((et)localObject6).field_talker);
                    if ((localObject7 != null) && (((bb)localObject7).field_unReadCount > 0))
                    {
                      bh.beI();
                      i = c.bbO().aL((ca)localObject6);
                      if (((bb)localObject7).field_unReadCount >= i)
                      {
                        ((az)localObject7).pH(((bb)localObject7).field_unReadCount - 1);
                        bh.beI();
                        c.bbR().a((az)localObject7, ((bb)localObject7).field_username);
                      }
                    }
                  }
                }
              }
              if ((paramString != null) && (paramString.equals("updatepackage")))
              {
                localObject2 = h.d.cj(Integer.valueOf(-1879048175));
                if (localObject2 != null) {}
              }
              Object localObject4;
              for (Object localObject3 = null;; localObject4 = localObject2)
              {
                for (;;)
                {
                  localObject2 = localObject3;
                  if (paramString != null)
                  {
                    localObject2 = localObject3;
                    if (paramString.equals("deletepackage"))
                    {
                      localObject2 = h.d.cj(Integer.valueOf(-1879048174));
                      if (localObject2 != null) {
                        break label2357;
                      }
                      localObject2 = null;
                    }
                  }
                  Object localObject12;
                  if ((paramString != null) && (paramString.equals("delchatroommember")))
                  {
                    localObject3 = z.a(((db)localObject7).RID);
                    bh.beI();
                    localObject5 = c.bbO().aL((String)localObject3, ((db)localObject7).HlH);
                    i = 0;
                    if (((et)localObject5).field_msgId > 0L) {
                      i = 1;
                    }
                    ((ca)localObject5).EG(((db)localObject7).HlH);
                    if ((parama == null) || (!parama.lCc) || (!parama.lCe)) {
                      ((ca)localObject5).setCreateTime(bq.z((String)localObject3, ((db)localObject7).CreateTime));
                    }
                    ((ca)localObject5).setType(10002);
                    ((ca)localObject5).setContent((String)localObject6);
                    ((ca)localObject5).pJ(0);
                    ((ca)localObject5).Jm((String)localObject3);
                    ((ca)localObject5).Ip(((db)localObject7).RII);
                    bq.a((ca)localObject5, parama);
                    if (i == 0) {
                      bq.z((ca)localObject5);
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
                        if (this.lro != ((db)localObject7).HlH)
                        {
                          this.lro = ((db)localObject7).HlH;
                          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                          localObject3 = new cr(paramMap);
                          localObject5 = (String)((cr)localObject3).lpa.get(".sysmsg.WakenPush.PushContent");
                          localObject8 = (String)((cr)localObject3).lpa.get(".sysmsg.WakenPush.Jump");
                          localObject2 = (String)((cr)localObject3).lpa.get(".sysmsg.WakenPush.ExpiredTime");
                          localObject9 = (String)((cr)localObject3).lpa.get(".sysmsg.WakenPush.Username");
                          Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject5, localObject8, localObject2 });
                          localObject2 = com.tencent.mm.n.h.axc().getValue("WakenPushDeepLinkBitSet");
                          Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject2 });
                          if (Util.isNullOrNil((String)localObject2)) {
                            break label2392;
                          }
                          l1 = Util.getLong((String)localObject2, 0L);
                          localObject10 = com.tencent.mm.am.d.a((String)localObject9, false, -1, null);
                          localObject11 = bh.getNotification();
                          if (!Util.isNullOrNil((String)localObject8)) {
                            break label2398;
                          }
                          Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                          localObject2 = "com.tencent.mm.ui.LauncherUI";
                          localObject12 = new Intent();
                          ((Intent)localObject12).setClassName(MMApplicationContext.getContext(), (String)localObject2);
                          ((Intent)localObject12).setFlags(536870912);
                          ((Intent)localObject12).putExtra("LauncherUI.Show.Update.DialogMsg", (String)((cr)localObject3).lpa.get(".sysmsg.WakenPush.PushContent"));
                          if (!((String)localObject8).equals("weixin://dl/update_newest_version")) {
                            ((Intent)localObject12).putExtra("LauncherUI.Show.Update.Url", (String)((cr)localObject3).lpa.get(".sysmsg.WakenPush.Jump"));
                          }
                          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 32L, 1L, true);
                          localObject2 = ((ay)localObject11).a(PendingIntent.getActivity(MMApplicationContext.getContext(), UUID.randomUUID().hashCode(), (Intent)localObject12, 134217728), MMApplicationContext.getContext().getString(R.l.app_name), (String)localObject5, (String)localObject5, (Bitmap)localObject10, (String)localObject9);
                          ((Notification)localObject2).flags |= 0x10;
                          bh.getNotification().a((Notification)localObject2, false);
                          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 31L, 1L, true);
                          localObject3 = null;
                        }
                      }
                    }
                    localObject2 = localObject3;
                    if (paramString == null) {
                      break label2660;
                    }
                    localObject2 = localObject3;
                    if (!paramString.equals("DisasterNotice")) {
                      break label2660;
                    }
                    localObject8 = (String)paramMap.get(".sysmsg.NoticeId");
                    localObject9 = (String)paramMap.get(".sysmsg.Content");
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject8, localObject9 });
                    localObject10 = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.avK());
                    localObject5 = ((SharedPreferences)localObject10).getString("disaster_noticeid_list_key", "");
                    if (((String)localObject5).contains((CharSequence)localObject8)) {
                      break label2603;
                    }
                    Object localObject11 = ((String)localObject5).split(";");
                    if ((localObject11 == null) || (localObject11.length <= 10)) {
                      break label2514;
                    }
                    localObject2 = "";
                    j = localObject11.length;
                    i = 0;
                    localObject3 = localObject2;
                    if (i >= j) {
                      break label2518;
                    }
                    localObject12 = localObject11[i].split(",");
                    localObject3 = localObject2;
                  }
                  try
                  {
                    if (Util.secondsToNow(Util.getLong(localObject12[0], 0L)) < 1296000L) {
                      localObject3 = (String)localObject2 + localObject12[0] + "," + localObject12[1] + ";";
                    }
                    i += 1;
                    localObject2 = localObject3;
                    break label2242;
                    localObject3 = ((com.tencent.mm.an.h)localObject2).b(parama);
                    continue;
                    localObject2 = ((com.tencent.mm.an.h)localObject2).b(parama);
                    break label1500;
                    bh.beI();
                    c.bbO().b(((db)localObject7).HlH, (ca)localObject5);
                    break label1660;
                    l1 = 0L;
                    break label1871;
                    if (((0x4 & l1) == 4L) && (((String)localObject8).startsWith("weixin://dl/moments")))
                    {
                      localObject2 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                      break label1908;
                    }
                    if (((l1 & 0x40000) == 262144L) && (((String)localObject8).startsWith("weixin://dl/recommendation")))
                    {
                      localObject2 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                      break label1908;
                    }
                    Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { localObject8 });
                    localObject2 = "com.tencent.mm.ui.LauncherUI";
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
                      localObject4 = localObject2;
                    }
                  }
                }
                localObject4 = localObject5;
                localObject2 = (String)localObject4 + Util.nowSecond() + "," + (String)localObject8 + ";";
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject5, localObject2 });
                ((SharedPreferences)localObject10).edit().putString("disaster_noticeid_list_key", (String)localObject2).commit();
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(20306);
                    if (f.this.lrp != null) {
                      f.this.lrp.hd(this.lrr);
                    }
                    AppMethodBeat.o(20306);
                  }
                });
                ((db)localObject7).RIF = z.ZW((String)localObject9);
                ((db)localObject7).COi = 1;
                localObject2 = h.d.cj(Integer.valueOf(1));
                if (localObject2 == null)
                {
                  localObject2 = null;
                  if ((paramString == null) || (!paramString.equals("EmotionKv"))) {
                    break label3208;
                  }
                  paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
                  localObject2 = (String)paramMap.get(".sysmsg.EmotionKv.I");
                  if (paramString != null) {
                    break label6602;
                  }
                  paramString = "";
                }
                for (;;)
                {
                  Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject2 });
                  localObject4 = com.tencent.mm.protocal.ac.hph().RCm.getBytes();
                  localObject5 = com.tencent.mm.protocal.ac.hph().RCn.getBytes();
                  paramMap = null;
                  try
                  {
                    parama = bh.aGY().lCD.biw().bir();
                    paramMap = parama;
                  }
                  catch (Exception parama)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { Util.stackTraceToString(parama) });
                    }
                    localObject6 = com.tencent.mm.protocal.f.hoN();
                    if (!Util.isNullOrNil((byte[])localObject6)) {
                      break label2870;
                    }
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    parama = new PByteArray();
                    if (Util.isNullOrNil(paramString)) {
                      break label2916;
                    }
                  }
                  if (Util.isNullOrNil(paramMap))
                  {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    localObject2 = ((com.tencent.mm.an.h)localObject2).b(parama);
                    break;
                  }
                  int k;
                  int m;
                  int n;
                  if ((Util.isNullOrNil((byte[])localObject5)) || (Util.isNullOrNil((byte[])localObject4)) || (Util.isNullOrNil(paramMap)) || (Util.isNullOrNil((byte[])localObject6))) {
                    if (paramString == null)
                    {
                      i = -1;
                      if (localObject5 != null) {
                        break label3139;
                      }
                      j = -1;
                      if (localObject4 != null) {
                        break label3147;
                      }
                      k = -1;
                      if (paramMap != null) {
                        break label3155;
                      }
                      m = -1;
                      if (localObject6 != null) {
                        break label3162;
                      }
                      n = -1;
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
                      paramString = parama.value;
                      paramMap = new coy();
                      if (parama.value == null) {
                        break label3192;
                      }
                      paramMap.Izj = new String(parama.value);
                      if (paramString != null) {
                        break label3201;
                      }
                    }
                  }
                  for (i = -1;; i = paramString.length)
                  {
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.Izj.length()), com.tencent.mm.b.g.getMessageDigest(paramMap.Izj.getBytes()) });
                    paramMap.TwI = ((String)localObject2);
                    bh.beI();
                    c.bbK().d(new k.a(59, paramMap));
                    AppMethodBeat.o(20312);
                    return null;
                    i = paramString.length();
                    break;
                    j = localObject5.length;
                    break label2931;
                    k = localObject4.length;
                    break label2939;
                    m = paramMap.length;
                    break label2946;
                    n = localObject6.length;
                    break label2954;
                    bh.beI();
                    MMProtocalJni.genClientCheckKVRes(c.getUin(), paramString, (byte[])localObject4, (byte[])localObject5, paramMap, (byte[])localObject6, parama);
                    break label3006;
                    paramMap.Izj = "";
                    break label3041;
                  }
                  if ((paramString != null) && (paramString.equals("globalalert")))
                  {
                    paramString = (String)paramMap.get(".sysmsg.uuid");
                    i = Util.getInt((String)paramMap.get(".sysmsg.id"), -1);
                    j = Util.getInt((String)paramMap.get(".sysmsg.important"), -1);
                    if ((Util.isNullOrNil(paramString)) || (i < 0) || (j < 0))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    parama = (String)paramMap.get(".sysmsg.title");
                    localObject2 = (String)paramMap.get(".sysmsg.msg");
                    if ((Util.isNullOrNil(parama)) && (Util.isNullOrNil((String)localObject2)))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject2 });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
                    k = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
                    m = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                    localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn");
                    if ((Util.isNullOrNil((String)localObject5)) || (k < 0) || (m < 0))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject4 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
                    n = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
                    int i1 = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                    paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
                    bool1 = true;
                    if ((Util.isNullOrNil((String)localObject4)) || (n < 0) || (i1 < 0))
                    {
                      bool1 = false;
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
                    }
                    localObject7 = new lb();
                    localObject8 = new com.tencent.mm.protocal.b.a.b();
                    ((lb)localObject7).fIK.fIL = ((com.tencent.mm.protocal.b.a.b)localObject8);
                    ((com.tencent.mm.protocal.b.a.b)localObject8).id = i;
                    ((com.tencent.mm.protocal.b.a.b)localObject8).title = parama;
                    ((com.tencent.mm.protocal.b.a.b)localObject8).msg = ((String)localObject2);
                    ((com.tencent.mm.protocal.b.a.b)localObject8).RDg = new LinkedList();
                    localObject9 = new com.tencent.mm.protocal.b.a.a();
                    ((com.tencent.mm.protocal.b.a.a)localObject9).id = k;
                    ((com.tencent.mm.protocal.b.a.a)localObject9).actionType = m;
                    ((com.tencent.mm.protocal.b.a.a)localObject9).RDe = ((String)localObject5);
                    ((com.tencent.mm.protocal.b.a.a)localObject9).RDf = ((String)localObject6);
                    ((com.tencent.mm.protocal.b.a.b)localObject8).RDg.add(localObject9);
                    if (bool1)
                    {
                      localObject5 = new com.tencent.mm.protocal.b.a.a();
                      ((com.tencent.mm.protocal.b.a.a)localObject5).id = n;
                      ((com.tencent.mm.protocal.b.a.a)localObject5).actionType = i1;
                      ((com.tencent.mm.protocal.b.a.a)localObject5).RDe = ((String)localObject4);
                      ((com.tencent.mm.protocal.b.a.a)localObject5).RDf = paramMap;
                      ((com.tencent.mm.protocal.b.a.b)localObject8).RDg.add(localObject5);
                    }
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject2, Boolean.valueOf(bool1), Boolean.valueOf(EventCenter.instance.publish((IEvent)localObject7)) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if ((paramString != null) && (paramString.equals("yybsigcheck")))
                  {
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 14L, 1L, false);
                    l1 = System.currentTimeMillis();
                    paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                    parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
                    paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
                    com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    if (Util.isNullOrNil(paramString))
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 15L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject2 = paramString.split(";");
                    if (localObject2 == null) {}
                    for (i = -1;; i = localObject2.length)
                    {
                      Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
                      if ((localObject2 != null) && (localObject2.length != 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 16L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4016), paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject4 = new ArrayList();
                    i = 0;
                    if (i < localObject2.length)
                    {
                      localObject5 = localObject2[i];
                      if (Util.isNullOrNil((String)localObject5)) {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        localObject6 = ((String)localObject5).split(",");
                        if (localObject6 == null) {}
                        for (j = -1;; j = localObject6.length)
                        {
                          Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                          if ((localObject6 != null) && (localObject6.length == 3)) {
                            break label4347;
                          }
                          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                          break;
                        }
                        try
                        {
                          ((ArrayList)localObject4).add(new af.c(localObject6[0], Util.getInt(localObject6[1], 0), localObject6[2]));
                        }
                        catch (Exception localException5)
                        {
                          Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 17L, 1L, false);
                          com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4017), localObject5 });
                        }
                      }
                    }
                    if (((ArrayList)localObject4).size() == 0)
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 18L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (Util.getInt(com.tencent.mm.n.h.axc().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
                    {
                      bool1 = true;
                      boolean bool2 = com.tencent.mm.platformtools.af.a(MMApplicationContext.getContext(), (ArrayList)localObject4, bool1);
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject4).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
                      if (bool2) {
                        break label4745;
                      }
                      bh.beG().setInt(46, 4);
                      localObject2 = new lx();
                      ((lx)localObject2).fJN.wording = parama;
                      ((lx)localObject2).fJN.url = paramMap;
                      EventCenter.instance.publish((IEvent)localObject2);
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 20L, 1L, true);
                      com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      bool1 = false;
                      break;
                      bh.beG().setInt(46, 0);
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(322L, 19L, 1L, true);
                      com.tencent.mm.plugin.report.service.h.IzE.a(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_status_notify")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    paramMap.get(".sysmsg.last_create_time");
                    paramString = (String)paramMap.get(".sysmsg.brand_username");
                    l1 = com.tencent.mm.ao.a.e.Vi(parama);
                    if (l1 == -1L)
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    i = com.tencent.mm.ao.af.bjy().Gt(l1).field_newUnReadCount;
                    com.tencent.mm.ao.af.bjy().Gv(l1);
                    paramMap = com.tencent.mm.ao.af.bjx().bF(l1);
                    bh.beI();
                    parama = c.bbR().bwx(paramString);
                    if (parama == null)
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (paramMap.jQ(1))
                    {
                      if (parama.field_unReadMuteCount <= i)
                      {
                        parama.pN(0);
                        bh.beI();
                        c.bbR().a(parama, paramString);
                        bh.getNotification().hg(paramString);
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(20312);
                        return null;
                        parama.pN(parama.field_unReadMuteCount - i);
                        bh.beI();
                        c.bbR().a(parama, paramString);
                      }
                    }
                    if (parama.field_unReadCount <= i)
                    {
                      bh.beI();
                      c.bbR().bwz(paramString);
                      bh.getNotification().hg(paramString);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      parama.pM(0);
                      parama.pP(0);
                      parama.pH(parama.field_unReadCount - i);
                      bh.beI();
                      c.bbR().a(parama, paramString);
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_chat_update")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    localObject4 = (String)paramMap.get(".sysmsg.ver");
                    com.tencent.mm.ao.a.e.q((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject4);
                  }
                  if ((paramString != null) && (paramString.equals("bindmobiletip")))
                  {
                    i = Util.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
                    parama = Util.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
                    paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
                    paramMap = new String(Base64.decode(parama.getBytes(), 0));
                    parama = new String(com.tencent.mm.cd.b.cU(q.auM().getBytes()).arf(16).UH);
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
                    if ((Util.isNullOrNil(paramMap)) || (paramMap.equals(parama)))
                    {
                      bh.beI();
                      c.aHp().set(ar.a.ViL, Boolean.TRUE);
                      bh.beI();
                      paramMap = c.aHp();
                      parama = ar.a.ViM;
                      if (i != 1) {
                        break label5422;
                      }
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramMap.set(parama, Boolean.valueOf(bool1));
                      bh.beI();
                      c.aHp().set(ar.a.ViN, paramString);
                      AppMethodBeat.o(20312);
                      return null;
                    }
                  }
                  if ((paramString != null) && ("BindPhoneGuidance".equals(paramString)))
                  {
                    paramString = (String)paramMap.get(".sysmsg.BindPhoneGuidance.deviceid");
                    paramMap = (String)paramMap.get(".sysmsg.BindPhoneGuidance.forceShow=no");
                    localObject2 = com.tencent.mm.cd.b.cU(q.auM().getBytes());
                    ((com.tencent.mm.cd.b)localObject2).arf(16);
                    bh.beI();
                    parama = (String)c.aHp().b(6, "");
                    localObject2 = Base64.encodeToString(((com.tencent.mm.cd.b)localObject2).toByteArray(), 2);
                    if (((Util.isNullOrNil(parama)) || ("yes".equals(paramMap))) && ((Util.isNullOrNil(paramString)) || (paramString.equals(localObject2))))
                    {
                      paramString = new Intent(MMApplicationContext.getContext(), BindMobilePolicyUI.class);
                      paramString.putExtra("key_upload_scene", 9);
                      paramString.putExtra("key_wording_cfg", localException5);
                      MMWizardActivity.aH(MMApplicationContext.getContext(), paramString);
                    }
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
                  {
                    parama = new den();
                    parama.CqQ = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
                    parama.TMj = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                    parama.TMk = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                    parama.RYY = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                    parama.TMl = j(parama.CqQ, parama.TMj, parama.TMk);
                    parama.HlG = ((int)Pc(parama.CqQ));
                    if (com.tencent.mm.plugin.normsg.a.d.GxJ.fjl())
                    {
                      i = 1;
                      parama.TMm = i;
                      parama.SmH = com.tencent.mm.compatible.deviceinfo.ac.avq();
                      parama.TMn = g(new Object[] { parama.CqQ, Integer.valueOf(parama.TMj), Integer.valueOf(parama.TMk), Integer.valueOf(parama.RYY), parama.TMl, Integer.valueOf(parama.HlG), Integer.valueOf(parama.TMm), Integer.valueOf(parama.SmH) });
                      bh.beI();
                      c.bbK().d(new k.a(61, parama));
                    }
                  }
                  else
                  {
                    if ((paramString != null) && (paramString.equals("ClientCheckHook")))
                    {
                      parama = new dep();
                      parama.RYY = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                      parama.TMp = com.tencent.mm.plugin.normsg.a.d.GxJ.vJ(false);
                      if (!com.tencent.mm.plugin.normsg.a.d.GxJ.fjl()) {
                        break label6264;
                      }
                      i = 1;
                      parama.TMm = i;
                      parama.SmH = com.tencent.mm.compatible.deviceinfo.ac.avq();
                      parama.TMn = g(new Object[] { Integer.valueOf(parama.RYY), parama.TMp, Integer.valueOf(parama.TMm), Integer.valueOf(parama.SmH) });
                      bh.beI();
                      c.bbK().d(new k.a(62, parama));
                    }
                    if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
                    {
                      parama = new deo();
                      parama.RYY = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                      parama.TMo = com.tencent.mm.plugin.normsg.a.d.GxJ.fjk();
                      if (!com.tencent.mm.plugin.normsg.a.d.GxJ.fjl()) {
                        break label6270;
                      }
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    parama.TMm = i;
                    parama.SmH = com.tencent.mm.compatible.deviceinfo.ac.avq();
                    parama.TMn = g(new Object[] { Integer.valueOf(parama.RYY), parama.TMo, Integer.valueOf(parama.TMm), Integer.valueOf(parama.SmH) });
                    bh.beI();
                    c.bbK().d(new k.a(63, parama));
                    if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                      ThreadPool.postAtFront(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(20307);
                          int i = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                          if (Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0)
                          {
                            com.tencent.mm.plugin.secinforeport.a.d.Jcm.jr(i, 0);
                            AppMethodBeat.o(20307);
                            return;
                          }
                          com.tencent.mm.plugin.secinforeport.a.d.Jcm.jr(i, 127);
                          AppMethodBeat.o(20307);
                        }
                      }, "syscmd_rpt_cc");
                    }
                    if ((paramString == null) || (!paramString.equals("ClientCheckSensorCollect"))) {
                      break label6288;
                    }
                    i = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckSensorCollect.SensorScene"), 0);
                    parama = (String)paramMap.get(".sysmsg.ClientCheckSensorCollect.BehaviorID");
                    if ((!Util.isNullOrNil(parama)) && (!Util.isNullOrNil(parama.trim()))) {
                      break label6276;
                    }
                    AppMethodBeat.o(20312);
                    return null;
                    i = 0;
                    break;
                    i = 0;
                    break label5929;
                  }
                  com.tencent.mm.plugin.normsg.a.d.GxJ.fx(parama.trim(), i);
                  if ((!Util.isNullOrNil(paramString)) && (paramString.equals("functionmsg")))
                  {
                    Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                    ((y)com.tencent.mm.kernel.h.ag(y.class)).getReceiver().a((db)localObject7, paramMap, "newSync");
                  }
                  if ((!Util.isNullOrNil(paramString)) && (paramString.equals("paymsg")))
                  {
                    i = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                    localObject4 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                    paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                    parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                    paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                    Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(((db)localObject7).HlH), paramString, parama, paramMap, localObject4 });
                  }
                  try
                  {
                    localObject4 = URLDecoder.decode((String)localObject4, "UTF-8");
                    if (!Util.isNullOrNil((String)localObject4))
                    {
                      localObject5 = new rq();
                      ((rq)localObject5).fQQ.type = i;
                      ((rq)localObject5).fQQ.content = ((String)localObject4);
                      ((rq)localObject5).fQQ.fLi = paramString;
                      ((rq)localObject5).fQQ.toUser = parama;
                      ((rq)localObject5).fQQ.fQR = paramMap;
                      EventCenter.instance.publish((IEvent)localObject5);
                    }
                    AppMethodBeat.o(20312);
                    return localObject2;
                  }
                  catch (Exception paramString)
                  {
                    for (;;)
                    {
                      Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
                      Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
                    }
                  }
                }
              }
              boolean bool1 = false;
            }
          }
          bh.beI().bcl().a(str, bool1, new String[] { localObject5, localObject8, localObject9 });
          bh.beI().bcm().v(paramMap);
          if ((!Util.isNullOrNil(paramString)) && (paramString.equals("midinfo"))) {
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "midinfo has been deprecated, bye bye!");
          }
          if ((paramString != null) && (paramString.equals("revokemsg")))
          {
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
            paramString = (String)paramMap.get(".sysmsg.revokemsg.session");
            localObject2 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
            paramMap = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject2, paramMap });
            l1 = 0L;
            try
            {
              long l2 = Util.getLong((String)localObject2, 0L);
              l1 = l2;
              a(paramString, l2, parama, paramMap, "MicroMsg.BigBallSysCmdMsgConsumer");
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                label696:
                Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
              }
            }
            AppMethodBeat.o(20312);
            return null;
            localObject2 = ((com.tencent.mm.an.h)localObject2).b(parama);
            continue;
            localException1 = localException1;
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void hd(String paramString);
  }
  
  public static abstract interface b
    extends s
  {
    public abstract String bcy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.f
 * JD-Core Version:    0.7.0.1
 */