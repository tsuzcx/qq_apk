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
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.d;
import com.tencent.mm.an.af;
import com.tencent.mm.api.v;
import com.tencent.mm.api.z;
import com.tencent.mm.autogen.a.mf;
import com.tencent.mm.autogen.a.nd;
import com.tencent.mm.autogen.a.qc;
import com.tencent.mm.autogen.a.tf;
import com.tencent.mm.autogen.a.vm;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.d.ad;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.modelmulti.u;
import com.tencent.mm.platformtools.ac.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.bind.ui.BindMobilePolicyUI;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.dfs;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dwm;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
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
  implements com.tencent.mm.plugin.messenger.foundation.a.s
{
  private long oiP;
  public a oiQ;
  private final LinkedHashMap<String, b> oiR;
  
  public f()
  {
    AppMethodBeat.i(20310);
    this.oiP = -1L;
    this.oiR = new LinkedHashMap();
    h localh = new h();
    this.oiR.put(localh.bAm(), localh);
    AppMethodBeat.o(20310);
  }
  
  /* Error */
  private static long HV(String paramString)
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
    //   144: invokestatic 126	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
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
  
  private void a(String paramString1, long paramLong, g.a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241924);
    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "xmlSrvMsgId=%d talker=%s isGet=%s", new Object[] { Long.valueOf(paramLong), paramString1, Boolean.valueOf(parama.otM) });
    cc localcc1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(paramString1, paramLong);
    final cc localcc2 = cc.bI(localcc1);
    bh.bCz();
    bb localbb = c.bzG().bxM(paramString1);
    Object localObject2;
    int i;
    if ((parama != null) && (parama.otM))
    {
      localObject1 = parama.mpN;
      localObject2 = w.a(((dl)localObject1).YFG);
      bv localbv = new bv();
      localbv.field_originSvrId = paramLong;
      if (localcc1.field_msgId == 0L)
      {
        Log.i(paramString3, "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(paramLong) });
        localbv.field_content = ((String)localObject2);
        localbv.field_createTime = ((dl)localObject1).CreateTime;
        localbv.field_flag = br.d(parama);
        localbv.field_fromUserName = w.a(((dl)localObject1).YFE);
        localbv.field_toUserName = w.a(((dl)localObject1).YFF);
        localbv.field_newMsgId = ((dl)localObject1).Njv;
        u.bKZ();
        Log.i(paramString3, "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(u.bKX().insert(localbv)), Long.valueOf(localbv.systemRowid) });
        AppMethodBeat.o(241924);
        return;
      }
      Log.i(paramString3, "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(paramLong) });
      u.bKZ();
      u.bKX().delete(localbv, true, new String[0]);
      if ((localbb != null) && (parama.mpN != null) && (localbb.field_lastSeq == parama.mpN.YFL))
      {
        Log.i(paramString3, "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(localbb.field_lastSeq), Long.valueOf(localbb.field_firstUnDeliverSeq) });
        bh.bCz();
        localObject1 = c.bzD().aLI(localbb.field_username);
        if (localObject1 != null)
        {
          localbb.gT(((fi)localObject1).field_msgSeq);
          bh.bCz();
          i = c.bzG().c(localbb, localbb.field_username);
          Log.i(paramString3, "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((fi)localObject1).field_msgSvrId), Long.valueOf(((fi)localObject1).field_msgSeq), Long.valueOf(localbb.field_lastSeq), Long.valueOf(localbb.field_firstUnDeliverSeq), Integer.valueOf(i) });
        }
      }
    }
    Object localObject1 = localcc1;
    if (localcc1.field_msgId == 0L)
    {
      localObject2 = ((PluginMessengerFoundation)com.tencent.mm.kernel.h.az(PluginMessengerFoundation.class)).getFileMsgInfoStorage().zh(paramLong);
      localObject1 = localcc1;
      if (localObject2 != null)
      {
        localObject1 = localcc1;
        if (((com.tencent.mm.storage.a.a)localObject2).field_msgSvrId != 0L) {
          localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(paramString1, ((com.tencent.mm.storage.a.a)localObject2).field_msgSvrId);
        }
      }
    }
    if (((fi)localObject1).field_msgId == 0L)
    {
      if (((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).getRecvRecord(paramLong) != null)
      {
        ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).bo(paramString1, paramLong);
        AppMethodBeat.o(241924);
        return;
      }
      Log.i(paramString3, "summerbadcr get a revoke newxml, but original msg has not been found, originSvrId[%d]", new Object[] { Long.valueOf(paramLong) });
      bh.bCz();
      c.bzD().sp(paramLong);
      AppMethodBeat.o(241924);
      return;
    }
    if (((cc)localObject1).getType() == 922746929)
    {
      ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).bo(paramString1, paramLong);
      AppMethodBeat.o(241924);
      return;
    }
    if ((((fi)localObject1).jUq & 0x4) != 4)
    {
      ((cc)localObject1).setContent(paramString2);
      ((cc)localObject1).Cf(paramString2);
      ((cc)localObject1).setType(268445456);
      br.a((cc)localObject1, parama);
      bh.bCz();
      c.bzD().a(((fi)localObject1).field_msgId, (cc)localObject1);
    }
    paramString1 = new vm();
    paramString1.hZg.msgId = ((fi)localObject1).field_msgId;
    paramString1.hZg.hZh = paramString2;
    paramString1.hZg.hTm = ((cc)localObject1);
    paramString1.hZg.hZi = localcc2;
    paramString1.hZg.hZj = paramLong;
    paramString1.publish();
    if (localcc2 != null) {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20308);
          int i = ((an)com.tencent.mm.kernel.h.ax(an.class)).va(localcc2.getType());
          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s serverType:%s", new Object[] { Long.valueOf(localcc2.field_msgId), Integer.valueOf(localcc2.getType()), Integer.valueOf(i) });
          switch (i)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(20308);
            return;
            br.D(localcc2);
          }
        }
      });
    }
    ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySvrId(paramLong);
    if ((localbb != null) && (localbb.field_unReadCount > 0))
    {
      bh.bCz();
      i = c.bzD().aZ((cc)localObject1);
      if (localbb.field_unReadCount >= i)
      {
        localbb.pG(localbb.field_unReadCount - 1);
        bh.bCz();
        c.bzG().c(localbb, localbb.field_username);
      }
    }
    if (ad.i(localcc2))
    {
      paramString1 = new qc();
      paramString1.hTl.hTm = localcc2;
      paramString1.publish();
    }
    AppMethodBeat.o(241924);
  }
  
  private static String j(Object... paramVarArgs)
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
  private static String l(String paramString, long paramLong1, long paramLong2)
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
    //   45: invokevirtual 523	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
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
    //   69: invokevirtual 529	java/io/InputStream:skip	(J)J
    //   72: lstore 6
    //   74: lload_1
    //   75: lload 6
    //   77: lsub
    //   78: lstore_1
    //   79: goto -26 -> 53
    //   82: aload_0
    //   83: invokestatic 533	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   86: astore 8
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -37 -> 53
    //   93: aload_0
    //   94: astore 10
    //   96: aload 8
    //   98: astore 9
    //   100: ldc_w 498
    //   103: invokestatic 504	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
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
    //   140: ldc2_w 534
    //   143: lload_3
    //   144: invokestatic 541	java/lang/Math:min	(JJ)J
    //   147: l2i
    //   148: invokevirtual 545	java/io/InputStream:read	([BII)I
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
    //   173: invokevirtual 549	java/security/MessageDigest:update	([BII)V
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
    //   194: invokevirtual 551	java/security/MessageDigest:digest	()[B
    //   197: invokestatic 517	com/tencent/mm/sdk/platformtools/Util:encodeHexString	([B)Ljava/lang/String;
    //   200: astore 11
    //   202: aload 8
    //   204: ifnull +8 -> 212
    //   207: aload 8
    //   209: invokevirtual 552	java/io/InputStream:close	()V
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
    //   263: invokevirtual 552	java/io/InputStream:close	()V
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
    //   297: invokevirtual 552	java/io/InputStream:close	()V
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
  
  public final g.b a(String paramString, final Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(20312);
    Object localObject8 = parama.mpN;
    Object localObject7 = w.a(((dl)localObject8).YFG);
    Object localObject1 = null;
    Object localObject6;
    if (paramString != null)
    {
      localObject6 = (b)this.oiR.get(paramString);
      if (localObject6 == null) {}
    }
    label835:
    label1006:
    label2419:
    label5492:
    for (;;)
    {
      boolean bool1;
      int i;
      try
      {
        localObject2 = ((b)localObject6).a(paramString, paramMap, parama);
        localObject1 = localObject2;
        bool1 = ((b)localObject6).bAn();
        if (bool1)
        {
          AppMethodBeat.o(20312);
          return localObject2;
        }
        localObject1 = localObject2;
        localObject2 = localObject1;
      }
      finally
      {
        try
        {
          bq.bCF().a(new bp(Util.getInt((String)localObject2, 0), Util.getInt((String)localObject6, 0), str1));
          localObject2 = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
          localObject6 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
          if ((localObject2 == null) || (localObject6 == null)) {
            continue;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            bh.bCz().bzZ().a((String)localObject6, true, null);
            Object localObject2 = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
            localObject6 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
            str1 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
            str2 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
            localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
            if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject9))) {
              continue;
            }
            try
            {
              if (!((String)localObject9).equals("1")) {
                break label6679;
              }
              bool1 = true;
            }
            catch (Exception localException3)
            {
              long l1;
              Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
              continue;
              if ((paramString == null) || (!paramString.equals("clouddelmsg"))) {
                break label1453;
              }
              Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
              Object localObject4 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
              localObject1 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
              paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
              i = ((String)localObject7).indexOf("<msg>");
              int j = ((String)localObject7).indexOf("</msg>");
              if ((i != -1) && (j != -1)) {
                break label1006;
              }
              paramString = "";
              Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject4, localObject1, paramMap, paramString });
              for (;;)
              {
                try
                {
                  bh.bCz();
                  paramMap = c.bzD().ki(paramMap, (String)localObject1);
                  if ((paramMap == null) || (paramMap.size() <= 0))
                  {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                    AppMethodBeat.o(20312);
                    return null;
                    paramString = SemiXml.encode(XmlParser.parseXml(((String)localObject7).substring(i, j + 6), "msg", null));
                    break;
                  }
                  paramMap = paramMap.iterator();
                  if (paramMap.hasNext())
                  {
                    localObject7 = (cc)paramMap.next();
                    if (localObject7 != null) {
                      break label1107;
                    }
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                  }
                  if (((fi)localObject7).field_msgSvrId >= 0L) {
                    break label1154;
                  }
                }
                catch (Exception paramString)
                {
                  Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject1, paramString.toString() });
                  AppMethodBeat.o(20312);
                  return null;
                }
                Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((fi)localObject7).field_msgId), Long.valueOf(((fi)localObject7).field_msgSvrId) });
              }
              Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((fi)localObject7).field_msgId), Long.valueOf(((fi)localObject7).field_msgSvrId) });
              localObject6 = cc.bI((cc)localObject7);
              i = Util.getInt((String)localObject4, 0);
              if (i != 1) {
                break label1315;
              }
              bh.bCz();
              c.bzD().be(((fi)localObject7).field_talker, ((fi)localObject7).field_msgSvrId);
              for (;;)
              {
                localObject8 = new vm();
                ((vm)localObject8).hZg.msgId = ((fi)localObject7).field_msgId;
                ((vm)localObject8).hZg.hZh = paramString;
                ((vm)localObject8).hZg.hTm = ((cc)localObject7);
                ((vm)localObject8).publish();
                if (!ad.i((cc)localObject6)) {
                  break;
                }
                localObject7 = new qc();
                ((qc)localObject7).hTl.hTm = ((cc)localObject6);
                ((qc)localObject7).publish();
                break;
                if ((i == 2) && (((cc)localObject7).iYe()))
                {
                  ((cc)localObject7).setContent(paramString);
                  br.a((cc)localObject7, parama);
                  bh.bCz();
                  c.bzD().b(((fi)localObject7).field_msgSvrId, (cc)localObject7);
                  bh.bCz();
                  localObject8 = c.bzG().bxM(((fi)localObject7).field_talker);
                  if ((localObject8 != null) && (((bd)localObject8).field_unReadCount > 0))
                  {
                    bh.bCz();
                    i = c.bzD().aZ((cc)localObject7);
                    if (((bd)localObject8).field_unReadCount >= i)
                    {
                      ((bb)localObject8).pG(((bd)localObject8).field_unReadCount - 1);
                      bh.bCz();
                      c.bzG().c((bb)localObject8, ((bd)localObject8).field_username);
                    }
                  }
                }
              }
              if ((paramString == null) || (!paramString.equals("updatepackage"))) {
                break label6672;
              }
              localObject1 = g.d.dB(Integer.valueOf(-1879048175));
              if (localObject1 != null) {
                break label2371;
              }
              for (localObject4 = null;; localObject5 = localObject1)
              {
                for (;;)
                {
                  localObject1 = localObject4;
                  if (paramString != null)
                  {
                    localObject1 = localObject4;
                    if (paramString.equals("deletepackage"))
                    {
                      localObject1 = g.d.dB(Integer.valueOf(-1879048174));
                      if (localObject1 != null) {
                        break label2384;
                      }
                      localObject1 = null;
                    }
                  }
                  Object localObject11;
                  if ((paramString != null) && (paramString.equals("delchatroommember")))
                  {
                    localObject4 = w.a(((dl)localObject8).YFE);
                    bh.bCz();
                    localObject6 = c.bzD().aU((String)localObject4, ((dl)localObject8).Njv);
                    i = 0;
                    if (((fi)localObject6).field_msgId > 0L) {
                      i = 1;
                    }
                    ((cc)localObject6).gX(((dl)localObject8).Njv);
                    if ((parama == null) || (!parama.otM) || (!parama.otO)) {
                      ((cc)localObject6).setCreateTime(br.D((String)localObject4, ((dl)localObject8).CreateTime));
                    }
                    ((cc)localObject6).setType(10002);
                    ((cc)localObject6).setContent((String)localObject7);
                    ((cc)localObject6).pI(0);
                    ((cc)localObject6).BS((String)localObject4);
                    ((cc)localObject6).AU(((dl)localObject8).YFJ);
                    br.a((cc)localObject6, parama);
                    if (i == 0) {
                      br.B((cc)localObject6);
                    }
                  }
                  else
                  {
                    localObject4 = localObject1;
                    if (paramString != null)
                    {
                      localObject4 = localObject1;
                      if (paramString.equals("WakenPush"))
                      {
                        localObject4 = localObject1;
                        if (this.oiP != ((dl)localObject8).Njv)
                        {
                          this.oiP = ((dl)localObject8).Njv;
                          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                          localObject4 = new cs(paramMap);
                          localObject6 = (String)((cs)localObject4).nUd.get(".sysmsg.WakenPush.PushContent");
                          str1 = (String)((cs)localObject4).nUd.get(".sysmsg.WakenPush.Jump");
                          localObject1 = (String)((cs)localObject4).nUd.get(".sysmsg.WakenPush.ExpiredTime");
                          str2 = (String)((cs)localObject4).nUd.get(".sysmsg.WakenPush.Username");
                          Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject6, str1, localObject1 });
                          localObject1 = com.tencent.mm.k.i.aRC().getValue("WakenPushDeepLinkBitSet");
                          Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject1 });
                          if (Util.isNullOrNil((String)localObject1)) {
                            break label2419;
                          }
                          l1 = Util.getLong((String)localObject1, 0L);
                          localObject9 = com.tencent.mm.modelavatar.d.a(str2, false, -1, null);
                          localObject10 = bh.getNotification();
                          if (!Util.isNullOrNil(str1)) {
                            break label2425;
                          }
                          Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                          localObject1 = "com.tencent.mm.ui.LauncherUI";
                          localObject11 = new Intent();
                          ((Intent)localObject11).setClassName(MMApplicationContext.getContext(), (String)localObject1);
                          ((Intent)localObject11).setFlags(536870912);
                          ((Intent)localObject11).putExtra("LauncherUI.Show.Update.DialogMsg", (String)((cs)localObject4).nUd.get(".sysmsg.WakenPush.PushContent"));
                          if (!str1.equals("weixin://dl/update_newest_version")) {
                            ((Intent)localObject11).putExtra("LauncherUI.Show.Update.Url", (String)((cs)localObject4).nUd.get(".sysmsg.WakenPush.Jump"));
                          }
                          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 32L, 1L, true);
                          localObject1 = ((ay)localObject10).a(PendingIntent.getActivity(MMApplicationContext.getContext(), UUID.randomUUID().hashCode(), (Intent)localObject11, 134217728), MMApplicationContext.getContext().getString(R.l.app_name), (String)localObject6, (String)localObject6, (Bitmap)localObject9, str2);
                          ((Notification)localObject1).flags |= 0x10;
                          bh.getNotification().a((Notification)localObject1, false);
                          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 31L, 1L, true);
                          localObject4 = null;
                        }
                      }
                    }
                    localObject1 = localObject4;
                    if (paramString == null) {
                      break label2687;
                    }
                    localObject1 = localObject4;
                    if (!paramString.equals("DisasterNotice")) {
                      break label2687;
                    }
                    str1 = (String)paramMap.get(".sysmsg.NoticeId");
                    str2 = (String)paramMap.get(".sysmsg.Content");
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { str1, str2 });
                    localObject9 = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.aQe());
                    localObject6 = ((SharedPreferences)localObject9).getString("disaster_noticeid_list_key", "");
                    if (((String)localObject6).contains(str1)) {
                      break label2630;
                    }
                    Object localObject10 = ((String)localObject6).split(";");
                    if ((localObject10 == null) || (localObject10.length <= 10)) {
                      break label2541;
                    }
                    localObject1 = "";
                    j = localObject10.length;
                    i = 0;
                    localObject4 = localObject1;
                    if (i >= j) {
                      break label2545;
                    }
                    localObject11 = localObject10[i].split(",");
                    localObject4 = localObject1;
                  }
                  try
                  {
                    if (Util.secondsToNow(Util.getLong(localObject11[0], 0L)) < 1296000L) {
                      localObject4 = (String)localObject1 + localObject11[0] + "," + localObject11[1] + ";";
                    }
                    i += 1;
                    localObject1 = localObject4;
                    break label2269;
                    localObject4 = ((com.tencent.mm.am.g)localObject1).b(parama);
                    continue;
                    localObject1 = ((com.tencent.mm.am.g)localObject1).b(parama);
                    break label1527;
                    bh.bCz();
                    c.bzD().b(((dl)localObject8).Njv, (cc)localObject6);
                    break label1687;
                    l1 = 0L;
                    break label1898;
                    if (((0x4 & l1) == 4L) && (str1.startsWith("weixin://dl/moments")))
                    {
                      localObject1 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                      break label1935;
                    }
                    if (((l1 & 0x40000) == 262144L) && (str1.startsWith("weixin://dl/recommendation")))
                    {
                      localObject1 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                      break label1935;
                    }
                    Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { str1 });
                    localObject1 = "com.tencent.mm.ui.LauncherUI";
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
                      localObject5 = localObject1;
                    }
                  }
                }
                localObject5 = localObject6;
                localObject1 = (String)localObject5 + Util.nowSecond() + "," + str1 + ";";
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject6, localObject1 });
                ((SharedPreferences)localObject9).edit().putString("disaster_noticeid_list_key", (String)localObject1).commit();
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(20306);
                    if (f.this.oiQ != null) {
                      f.this.oiQ.iE(str1);
                    }
                    AppMethodBeat.o(20306);
                  }
                });
                ((dl)localObject8).YFG = w.Sk(str2);
                ((dl)localObject8).IIs = 1;
                localObject1 = g.d.dB(Integer.valueOf(1));
                if (localObject1 == null)
                {
                  localObject1 = null;
                  if ((paramString == null) || (!paramString.equals("EmotionKv"))) {
                    break label3235;
                  }
                  paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
                  localObject1 = (String)paramMap.get(".sysmsg.EmotionKv.I");
                  if (paramString != null) {
                    break label6669;
                  }
                  paramString = "";
                }
                for (;;)
                {
                  Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject1 });
                  localObject5 = com.tencent.mm.protocal.ac.iQc().YyO.getBytes();
                  localObject6 = com.tencent.mm.protocal.ac.iQc().YyP.getBytes();
                  paramMap = null;
                  try
                  {
                    parama = bh.aZW().oun.bGg().bGb();
                    paramMap = parama;
                  }
                  catch (Exception parama)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { Util.stackTraceToString(parama) });
                    }
                    localObject7 = com.tencent.mm.protocal.f.iPJ();
                    if (!Util.isNullOrNil((byte[])localObject7)) {
                      break label2897;
                    }
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    parama = new PByteArray();
                    if (Util.isNullOrNil(paramString)) {
                      break label2943;
                    }
                  }
                  if (Util.isNullOrNil(paramMap))
                  {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    localObject1 = ((com.tencent.mm.am.g)localObject1).b(parama);
                    break;
                  }
                  int k;
                  int m;
                  int n;
                  if ((Util.isNullOrNil((byte[])localObject6)) || (Util.isNullOrNil((byte[])localObject5)) || (Util.isNullOrNil(paramMap)) || (Util.isNullOrNil((byte[])localObject7))) {
                    if (paramString == null)
                    {
                      i = -1;
                      if (localObject6 != null) {
                        break label3166;
                      }
                      j = -1;
                      if (localObject5 != null) {
                        break label3174;
                      }
                      k = -1;
                      if (paramMap != null) {
                        break label3182;
                      }
                      m = -1;
                      if (localObject7 != null) {
                        break label3189;
                      }
                      n = -1;
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
                      paramString = parama.value;
                      paramMap = new dfs();
                      if (parama.value == null) {
                        break label3219;
                      }
                      paramMap.OzQ = new String(parama.value);
                      if (paramString != null) {
                        break label3228;
                      }
                    }
                  }
                  for (i = -1;; i = paramString.length)
                  {
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.OzQ.length()), com.tencent.mm.b.g.getMessageDigest(paramMap.OzQ.getBytes()) });
                    paramMap.aaLp = ((String)localObject1);
                    bh.bCz();
                    c.bzz().d(new k.a(59, paramMap));
                    AppMethodBeat.o(20312);
                    return null;
                    i = paramString.length();
                    break;
                    j = localObject6.length;
                    break label2958;
                    k = localObject5.length;
                    break label2966;
                    m = paramMap.length;
                    break label2973;
                    n = localObject7.length;
                    break label2981;
                    bh.bCz();
                    MMProtocalJni.genClientCheckKVRes(c.getUin(), paramString, (byte[])localObject5, (byte[])localObject6, paramMap, (byte[])localObject7, parama);
                    break label3033;
                    paramMap.OzQ = "";
                    break label3068;
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
                    localObject1 = (String)paramMap.get(".sysmsg.msg");
                    if ((Util.isNullOrNil(parama)) && (Util.isNullOrNil((String)localObject1)))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject1 });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    str1 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
                    k = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
                    m = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                    str2 = (String)paramMap.get(".sysmsg.btnlist.btn");
                    if ((Util.isNullOrNil(str1)) || (k < 0) || (m < 0))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { str1, Integer.valueOf(k), Integer.valueOf(m) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
                    n = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
                    int i1 = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                    localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn1");
                    bool1 = true;
                    if ((Util.isNullOrNil((String)localObject5)) || (n < 0) || (i1 < 0))
                    {
                      bool1 = false;
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { str1, Integer.valueOf(k), Integer.valueOf(m) });
                    }
                    localObject7 = new mf();
                    localObject8 = new com.tencent.mm.protocal.b.a.b();
                    ((mf)localObject7).hOl.hOm = ((com.tencent.mm.protocal.b.a.b)localObject8);
                    ((com.tencent.mm.protocal.b.a.b)localObject8).id = i;
                    ((com.tencent.mm.protocal.b.a.b)localObject8).title = parama;
                    ((com.tencent.mm.protocal.b.a.b)localObject8).msg = ((String)localObject1);
                    ((com.tencent.mm.protocal.b.a.b)localObject8).YzJ = Util.getInt((String)paramMap.get(".sysmsg.btnlist.$autoSelectBtnIdx"), -1);
                    ((com.tencent.mm.protocal.b.a.b)localObject8).YzI = new LinkedList();
                    paramMap = new com.tencent.mm.protocal.b.a.a();
                    paramMap.id = k;
                    paramMap.actionType = m;
                    paramMap.YzG = str1;
                    paramMap.YzH = str2;
                    ((com.tencent.mm.protocal.b.a.b)localObject8).YzI.add(paramMap);
                    if (bool1)
                    {
                      paramMap = new com.tencent.mm.protocal.b.a.a();
                      paramMap.id = n;
                      paramMap.actionType = i1;
                      paramMap.YzG = ((String)localObject5);
                      paramMap.YzH = ((String)localObject6);
                      ((com.tencent.mm.protocal.b.a.b)localObject8).YzI.add(paramMap);
                    }
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(((mf)localObject7).publish()) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if ((paramString != null) && (paramString.equals("yybsigcheck")))
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 14L, 1L, false);
                    l1 = System.currentTimeMillis();
                    paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                    parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
                    paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
                    com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    if (Util.isNullOrNil(paramString))
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 15L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject1 = paramString.split(";");
                    if (localObject1 == null) {}
                    for (i = -1;; i = localObject1.length)
                    {
                      Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
                      if ((localObject1 != null) && (localObject1.length != 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 16L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4016), paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = new ArrayList();
                    i = 0;
                    if (i < localObject1.length)
                    {
                      localObject6 = localObject1[i];
                      if (Util.isNullOrNil((String)localObject6)) {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        localObject7 = ((String)localObject6).split(",");
                        if (localObject7 == null) {}
                        for (j = -1;; j = localObject7.length)
                        {
                          Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                          if ((localObject7 != null) && (localObject7.length == 3)) {
                            break label4382;
                          }
                          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                          break;
                        }
                        try
                        {
                          ((ArrayList)localObject5).add(new ac.c(localObject7[0], Util.getInt(localObject7[1], 0), localObject7[2]));
                        }
                        catch (Exception localException5)
                        {
                          Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 17L, 1L, false);
                          com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4017), localObject6 });
                        }
                      }
                    }
                    if (((ArrayList)localObject5).size() == 0)
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 18L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
                    {
                      bool1 = true;
                      boolean bool2 = com.tencent.mm.platformtools.ac.a(MMApplicationContext.getContext(), (ArrayList)localObject5, bool1);
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject5).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
                      if (bool2) {
                        break label4777;
                      }
                      bh.bCx().setInt(46, 4);
                      localObject1 = new nd();
                      ((nd)localObject1).hPt.wording = parama;
                      ((nd)localObject1).hPt.url = paramMap;
                      ((nd)localObject1).publish();
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 20L, 1L, true);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      bool1 = false;
                      break;
                      bh.bCx().setInt(46, 0);
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 19L, 1L, true);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_status_notify")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    paramMap.get(".sysmsg.last_create_time");
                    paramString = (String)paramMap.get(".sysmsg.brand_username");
                    l1 = com.tencent.mm.an.a.e.Nh(parama);
                    if (l1 == -1L)
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    paramMap = af.bHi().iD(l1);
                    if (paramMap == null)
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizCvs == null:%s", new Object[] { Long.valueOf(l1) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    i = paramMap.field_newUnReadCount;
                    af.bHi().iF(l1);
                    paramMap = af.bHh().dW(l1);
                    bh.bCz();
                    parama = c.bzG().bxM(paramString);
                    if (parama == null)
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if ((paramMap != null) && (paramMap.nG(1)))
                    {
                      if (parama.field_unReadMuteCount <= i)
                      {
                        parama.pM(0);
                        bh.bCz();
                        c.bzG().c(parama, paramString);
                        bh.getNotification().iH(paramString);
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(20312);
                        return null;
                        parama.pM(parama.field_unReadMuteCount - i);
                        bh.bCz();
                        c.bzG().c(parama, paramString);
                      }
                    }
                    if (parama.field_unReadCount <= i)
                    {
                      bh.bCz();
                      c.bzG().bxO(paramString);
                      bh.getNotification().iH(paramString);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      parama.pL(0);
                      parama.pO(0);
                      parama.pG(parama.field_unReadCount - i);
                      bh.bCz();
                      c.bzG().c(parama, paramString);
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_chat_update")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    localObject5 = (String)paramMap.get(".sysmsg.ver");
                    com.tencent.mm.an.a.e.u((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject5);
                  }
                  if ((paramString != null) && (paramString.equals("bindmobiletip")))
                  {
                    i = Util.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
                    parama = Util.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
                    paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
                    paramMap = new String(Base64.decode(parama.getBytes(), 0));
                    parama = new String(com.tencent.mm.bx.b.cX(q.aPg().getBytes()).axn(16).Op);
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
                    if ((Util.isNullOrNil(paramMap)) || (paramMap.equals(parama)))
                    {
                      bh.bCz();
                      c.ban().set(at.a.acKf, Boolean.TRUE);
                      bh.bCz();
                      paramMap = c.ban();
                      parama = at.a.acKg;
                      if (i != 1) {
                        break label5492;
                      }
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramMap.set(parama, Boolean.valueOf(bool1));
                      bh.bCz();
                      c.ban().set(at.a.acKh, paramString);
                      AppMethodBeat.o(20312);
                      return null;
                    }
                  }
                  if ((paramString != null) && ("BindPhoneGuidance".equals(paramString)))
                  {
                    paramString = (String)paramMap.get(".sysmsg.BindPhoneGuidance.deviceid");
                    paramMap = (String)paramMap.get(".sysmsg.BindPhoneGuidance.forceShow=no");
                    localObject1 = com.tencent.mm.bx.b.cX(q.aPg().getBytes());
                    ((com.tencent.mm.bx.b)localObject1).axn(16);
                    bh.bCz();
                    parama = (String)c.ban().d(6, "");
                    localObject1 = Base64.encodeToString(((com.tencent.mm.bx.b)localObject1).toByteArray(), 2);
                    if (((Util.isNullOrNil(parama)) || ("yes".equals(paramMap))) && ((Util.isNullOrNil(paramString)) || (paramString.equals(localObject1))))
                    {
                      paramString = new Intent(MMApplicationContext.getContext(), BindMobilePolicyUI.class);
                      paramString.putExtra("key_upload_scene", 9);
                      paramString.putExtra("key_wording_cfg", localException5);
                      MMWizardActivity.aQ(MMApplicationContext.getContext(), paramString);
                    }
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
                  {
                    parama = new dwm();
                    parama.IcZ = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
                    parama.abcs = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                    parama.abct = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                    parama.YWY = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                    parama.abcu = l(parama.IcZ, parama.abcs, parama.abct);
                    parama.Nju = ((int)HV(parama.IcZ));
                    if (com.tencent.mm.plugin.normsg.a.d.MtP.gtC())
                    {
                      i = 1;
                      parama.abcv = i;
                      parama.ZkT = com.tencent.mm.compatible.deviceinfo.ac.aPK();
                      parama.abcw = j(new Object[] { parama.IcZ, Integer.valueOf(parama.abcs), Integer.valueOf(parama.abct), Integer.valueOf(parama.YWY), parama.abcu, Integer.valueOf(parama.Nju), Integer.valueOf(parama.abcv), Integer.valueOf(parama.ZkT) });
                      bh.bCz();
                      c.bzz().d(new k.a(61, parama));
                    }
                  }
                  else
                  {
                    if ((paramString != null) && (paramString.equals("ClientCheckHook")))
                    {
                      parama = new dwo();
                      parama.YWY = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                      parama.abcy = com.tencent.mm.plugin.normsg.a.d.MtP.Af(false);
                      if (!com.tencent.mm.plugin.normsg.a.d.MtP.gtC()) {
                        break label6334;
                      }
                      i = 1;
                      parama.abcv = i;
                      parama.ZkT = com.tencent.mm.compatible.deviceinfo.ac.aPK();
                      parama.abcw = j(new Object[] { Integer.valueOf(parama.YWY), parama.abcy, Integer.valueOf(parama.abcv), Integer.valueOf(parama.ZkT) });
                      bh.bCz();
                      c.bzz().d(new k.a(62, parama));
                    }
                    if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
                    {
                      parama = new dwn();
                      parama.YWY = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                      parama.abcx = com.tencent.mm.plugin.normsg.a.d.MtP.gtB();
                      if (!com.tencent.mm.plugin.normsg.a.d.MtP.gtC()) {
                        break label6340;
                      }
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    parama.abcv = i;
                    parama.ZkT = com.tencent.mm.compatible.deviceinfo.ac.aPK();
                    parama.abcw = j(new Object[] { Integer.valueOf(parama.YWY), parama.abcx, Integer.valueOf(parama.abcv), Integer.valueOf(parama.ZkT) });
                    bh.bCz();
                    c.bzz().d(new k.a(63, parama));
                    if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                      ThreadPool.postAtFront(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(20307);
                          int i = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                          if (Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0)
                          {
                            com.tencent.mm.plugin.secinforeport.a.d.Pmb.kZ(i, 0);
                            AppMethodBeat.o(20307);
                            return;
                          }
                          com.tencent.mm.plugin.secinforeport.a.d.Pmb.kZ(i, 1008);
                          AppMethodBeat.o(20307);
                        }
                      }, "syscmd_rpt_cc");
                    }
                    if ((paramString == null) || (!paramString.equals("ClientCheckSensorCollect"))) {
                      break label6358;
                    }
                    i = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckSensorCollect.SensorScene"), 0);
                    parama = (String)paramMap.get(".sysmsg.ClientCheckSensorCollect.BehaviorID");
                    if ((!Util.isNullOrNil(parama)) && (!Util.isNullOrNil(parama.trim()))) {
                      break label6346;
                    }
                    AppMethodBeat.o(20312);
                    return null;
                    i = 0;
                    break;
                    i = 0;
                    break label5999;
                  }
                  com.tencent.mm.plugin.normsg.a.d.MtP.gq(parama.trim(), i);
                  if ((!Util.isNullOrNil(paramString)) && (paramString.equals("functionmsg")))
                  {
                    Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                    ((z)com.tencent.mm.kernel.h.az(z.class)).getReceiver().a((dl)localObject8, paramMap, "newSync");
                  }
                  if ((!Util.isNullOrNil(paramString)) && (paramString.equals("paymsg")))
                  {
                    i = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                    localObject5 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                    paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                    parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                    paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                    Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(((dl)localObject8).Njv), paramString, parama, paramMap, localObject5 });
                  }
                  try
                  {
                    localObject5 = URLDecoder.decode((String)localObject5, "UTF-8");
                    if (!Util.isNullOrNil((String)localObject5))
                    {
                      localObject6 = new tf();
                      ((tf)localObject6).hWN.type = i;
                      ((tf)localObject6).hWN.content = ((String)localObject5);
                      ((tf)localObject6).hWN.hQQ = paramString;
                      ((tf)localObject6).hWN.toUser = parama;
                      ((tf)localObject6).hWN.hWO = paramMap;
                      ((tf)localObject6).publish();
                    }
                    AppMethodBeat.o(20312);
                    return localObject1;
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
              bool1 = false;
              continue;
            }
            bh.bCz().bAa().a((String)localObject2, bool1, new String[] { localObject6, str1, str2 });
            bh.bCz().bAb().C(paramMap);
            if ((Util.isNullOrNil(paramString)) || (!paramString.equals("midinfo"))) {
              continue;
            }
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "midinfo has been deprecated, bye bye!");
            if ((paramString == null) || (!paramString.equals("revokemsg"))) {
              break label835;
            }
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
            paramString = (String)paramMap.get(".sysmsg.revokemsg.session");
            localObject1 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
            paramMap = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject1, paramMap });
            l1 = 0L;
            try
            {
              long l2 = Util.getLong((String)localObject1, 0L);
              l1 = l2;
              a(paramString, l2, parama, paramMap, "MicroMsg.BigBallSysCmdMsgConsumer");
            }
            catch (Exception paramString)
            {
              Object localObject3;
              Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
              continue;
            }
            AppMethodBeat.o(20312);
            return null;
            localThrowable = finally;
            Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", localThrowable, "consumeNewXml dispatch handle subType [%s] error", new Object[] { paramString });
            localObject3 = localObject1;
            continue;
            localObject1 = ((com.tencent.mm.am.g)localObject1).b(parama);
            continue;
            localException1 = localException1;
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
          }
          catch (Exception localException2)
          {
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
            continue;
          }
        }
      }
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (paramString.equals("addcontact"))
        {
          ((dl)localObject8).YFG = w.Sk((String)paramMap.get(".sysmsg.addcontact.content"));
          ((dl)localObject8).IIs = 1;
          localObject1 = g.d.dB(Integer.valueOf(1));
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
        }
      }
      if ((paramString != null) && (paramString.equals("dynacfg")))
      {
        com.tencent.mm.k.i.aRC().a((String)localObject7, paramMap, false);
        com.tencent.mm.k.i.aRD();
        if (com.tencent.mm.k.d.aRq() == 2) {
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10879, "");
        }
        i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("MuteRoomDisable"), 0);
        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
      }
      if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
        com.tencent.mm.k.i.aRC().a((String)localObject7, paramMap, true);
      }
      final String str1;
      if ((paramString != null) && (paramString.equals("banner")))
      {
        localObject2 = (String)paramMap.get(".sysmsg.mainframebanner.$type");
        localObject6 = (String)paramMap.get(".sysmsg.mainframebanner.showtype");
        str1 = (String)paramMap.get(".sysmsg.mainframebanner.data");
        if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {}
      }
      String str2;
      Object localObject9;
      label1527:
      label2425:
      label2687:
      label2943:
      localObject1 = null;
      label3068:
      continue;
      label3189:
      Object localObject5 = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void iE(String paramString);
  }
  
  public static abstract interface b
    extends com.tencent.mm.plugin.messenger.foundation.a.s
  {
    public abstract String bAm();
    
    public abstract boolean bAn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.f
 * JD-Core Version:    0.7.0.1
 */