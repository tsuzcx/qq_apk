package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelimage.a;
import com.tencent.mm.network.m;
import com.tencent.mm.pluginsdk.g.d.a;
import com.tencent.mm.pluginsdk.g.g.a;
import com.tencent.mm.protocal.protobuf.eyj;
import com.tencent.mm.protocal.protobuf.eyk;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.y;
import java.util.Map;
import junit.framework.Assert;

public final class n
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private String fileName;
  private d.a oIA;
  private boolean oIo;
  private int oJI;
  public com.tencent.mm.g.d oJJ;
  public com.tencent.mm.modelimage.g oJK;
  private String oJM;
  private z oYN;
  private String oYk;
  private z oZE;
  private com.tencent.mm.g.d oZF;
  private com.tencent.mm.pluginsdk.g.c oZI;
  private com.tencent.mm.am.c rr;
  
  public n(String paramString, int paramInt, com.tencent.mm.g.d paramd, com.tencent.mm.modelimage.g paramg)
  {
    AppMethodBeat.i(241265);
    this.fileName = null;
    this.oJI = 0;
    this.oJJ = null;
    this.oJK = null;
    this.oIo = true;
    this.oIA = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(241251);
        Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "onUploadFailure, uploadId:%s", new Object[] { paramAnonymousString });
        ab.Qf(n.a(n.this));
        n.j(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        AppMethodBeat.o(241251);
      }
      
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(241249);
        Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        locald.field_fileLength = paramAnonymousa.fileLength;
        v.bOh();
        paramAnonymousa = aa.PX(n.a(n.this));
        v.bOh();
        Object localObject1 = aa.PY(n.a(n.this));
        locald.field_thumbimgLength = ((int)y.bEl(n.a(n.this, (String)localObject1)));
        k.bHX();
        locald.field_filecrc = com.tencent.mm.modelcdntran.d.Nt(paramAnonymousa);
        locald.field_toUser = n.b(n.this).bOs();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241178);
            if (!n.a(n.this, this.oHA).equals(this.oHA))
            {
              y.deleteFile(n.a(n.this, this.oHA));
              Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "delete thumbPath %s", new Object[] { this.oHA });
            }
            AppMethodBeat.o(241178);
          }
        });
        paramAnonymousa = ab.Qo(n.a(n.this));
        if (Util.isNullOrNil(paramAnonymousa.bOu()))
        {
          localObject1 = "<msg><videomsg aeskey=\"" + locald.field_aesKey + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnvideourl=\"" + locald.field_fileId + "\" ";
          localObject1 = (String)localObject1 + "cdnthumburl=\"" + locald.field_fileId + "\" ";
          localObject1 = (String)localObject1 + "length=\"" + locald.field_fileLength + "\" ";
          localObject1 = (String)localObject1 + "cdnthumblength=\"" + locald.field_thumbimgLength + "\"/>";
          localObject1 = (String)localObject1 + Util.nullAs(paramAnonymousa.pbo, "");
          localObject1 = (String)localObject1 + "</msg>";
          Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "%s cgi callback new build cgiInfo:%s", new Object[] { n.c(n.this), localObject1 });
          paramAnonymousa.pbh = ((String)localObject1);
          ab.f(paramAnonymousa);
        }
        Object localObject2;
        if (n.d(n.this) != null)
        {
          localObject1 = paramAnonymousa.bOu();
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = ae.pbN;
            localObject2 = ae.a.Qv((String)localObject1);
            int i = ((String)localObject1).indexOf("/>");
            if ((i != -1) && ((localObject2 == null) || (Util.isNullOrNil(((ae)localObject2).pbQ))))
            {
              localObject1 = ((String)localObject1).substring(0, i);
              localObject1 = (String)localObject1 + "cdnrawvideourl=\"" + locald.field_fileId + "\" ";
              localObject1 = (String)localObject1 + "cdnrawvideoaeskey=\"" + locald.field_aesKey + "\" ";
              localObject1 = (String)localObject1 + "rawlength=\"" + locald.field_fileLength + "\"/>";
              localObject1 = (String)localObject1 + Util.nullAs(paramAnonymousa.pbo, "");
              localObject1 = (String)localObject1 + "</msg>";
              Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "%s cgi origin file callback  reBuild cgiInfo:%s", new Object[] { n.c(n.this), localObject1 });
              paramAnonymousa.pbh = ((String)localObject1);
              ab.f(paramAnonymousa);
            }
          }
        }
        localObject1 = XmlParser.parseXml(paramAnonymousa.bOu(), "msg", null);
        if (localObject1 != null)
        {
          localObject2 = v.bOh();
          v.bOh();
          ((aa)localObject2).x(aa.PX(n.a(n.this)), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          if (n.d(n.this) != null)
          {
            localObject2 = v.bOh();
            v.bOh();
            ((aa)localObject2).x(aa.PX(n.e(n.this)), (String)((Map)localObject1).get(".msg.videomsg.$cdnrawvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$cdnrawvideoaeskey"));
          }
        }
        if (Util.isNullOrNil(n.e(n.this)))
        {
          n.b(n.this, paramAnonymousa.oYk);
          if (!Util.isNullOrNil(n.e(n.this)))
          {
            n.a(n.this, ab.Qo(n.e(n.this)));
            if (n.d(n.this) != null)
            {
              n.a(n.this, locald);
              n.f(n.this);
              AppMethodBeat.o(241249);
              return;
            }
          }
        }
        localObject1 = com.tencent.mm.kernel.h.aZW();
        if (n.g(n.this) == null) {}
        for (paramAnonymousa = new l(n.a(n.this), n.h(n.this), n.i(n.this), locald, n.this.oJK);; paramAnonymousa = new l(n.a(n.this), n.h(n.this), n.i(n.this), n.g(n.this), locald, n.this.oJK))
        {
          ((com.tencent.mm.am.s)localObject1).a(paramAnonymousa, 0);
          AppMethodBeat.o(241249);
          return;
        }
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(241255);
        n.b(n.this, ab.Qo(n.a(n.this)));
        if ((n.b(n.this) == null) || (n.b(n.this).status == 105))
        {
          if (n.b(n.this) == null) {}
          for (int i = -1;; i = n.b(n.this).status)
          {
            Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "%s info is null or has paused, status:%d", new Object[] { n.c(n.this), Integer.valueOf(i) });
            if (n.k(n.this) != null) {
              n.k(n.this).iGP();
            }
            n.j(n.this).onSceneEnd(3, 0, "info is null or has paused, status".concat(String.valueOf(i)), n.this);
            n.this.oJK.eF(3, 0);
            AppMethodBeat.o(241255);
            return;
          }
        }
        if (n.d(n.this) != null)
        {
          if (n.d(n.this).oZm > paramAnonymousLong)
          {
            Log.w("MicroMsg.NetSceneUploadVideoOriginCgi", "%s cdntra originFileInfo cdnEndProc error oldpos:%d newpos:%d", new Object[] { n.c(n.this), Integer.valueOf(n.d(n.this).oZm), Long.valueOf(paramAnonymousLong) });
            AppMethodBeat.o(241255);
            return;
          }
          n.d(n.this).pba = Util.nowSecond();
          n.d(n.this).oZm = ((int)paramAnonymousLong);
          n.d(n.this).eQp = 1032;
          ab.f(n.d(n.this));
          AppMethodBeat.o(241255);
          return;
        }
        if (n.b(n.this).oZm > paramAnonymousLong)
        {
          Log.w("MicroMsg.NetSceneUploadVideoOriginCgi", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { n.c(n.this), Integer.valueOf(n.b(n.this).oZm), Long.valueOf(paramAnonymousLong) });
          AppMethodBeat.o(241255);
          return;
        }
        n.b(n.this).pba = Util.nowSecond();
        n.b(n.this).oZm = ((int)paramAnonymousLong);
        n.b(n.this).eQp = 1032;
        ab.f(n.b(n.this));
        AppMethodBeat.o(241255);
      }
    };
    if (paramString != null) {
      bool = true;
    }
    Assert.assertTrue(bool);
    Assert.assertTrue(true);
    Assert.assertTrue(true);
    this.fileName = paramString;
    this.oJJ = paramd;
    this.oJK = paramg;
    this.oJI = paramInt;
    AppMethodBeat.o(241265);
  }
  
  /* Error */
  private String PE(String paramString)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 80	com/tencent/mm/vfs/u
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 83	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: new 80	com/tencent/mm/vfs/u
    //   18: dup
    //   19: aload 9
    //   21: invokevirtual 87	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   24: new 89	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 91
    //   30: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 9
    //   35: invokevirtual 96	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   38: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 106	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 6
    //   61: ldc 108
    //   63: ldc 110
    //   65: iconst_1
    //   66: anewarray 112	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 9
    //   73: invokevirtual 116	com/tencent/mm/vfs/u:length	()J
    //   76: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: invokevirtual 116	com/tencent/mm/vfs/u:length	()J
    //   88: ldc2_w 129
    //   91: lcmp
    //   92: ifle +573 -> 665
    //   95: aload 10
    //   97: invokevirtual 134	com/tencent/mm/vfs/u:jKS	()Z
    //   100: ifeq +119 -> 219
    //   103: ldc 108
    //   105: ldc 136
    //   107: iconst_1
    //   108: anewarray 112	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 10
    //   115: invokevirtual 140	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   118: invokestatic 146	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aastore
    //   122: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_1
    //   126: istore_2
    //   127: aload 8
    //   129: astore 4
    //   131: aload 6
    //   133: astore 5
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 151	java/io/InputStream:close	()V
    //   145: iload_2
    //   146: istore_3
    //   147: aload 5
    //   149: ifnull +10 -> 159
    //   152: aload 5
    //   154: invokevirtual 154	java/io/OutputStream:close	()V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_3
    //   160: ifeq +388 -> 548
    //   163: ldc 108
    //   165: ldc 156
    //   167: iconst_3
    //   168: anewarray 112	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_0
    //   174: invokespecial 159	com/tencent/mm/modelvideo/n:bNX	()Ljava/lang/String;
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload 10
    //   182: invokevirtual 116	com/tencent/mm/vfs/u:length	()J
    //   185: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: aload 10
    //   193: invokevirtual 140	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   196: invokestatic 146	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   199: aastore
    //   200: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: aload 10
    //   205: invokevirtual 140	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   208: invokestatic 146	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   211: astore_1
    //   212: ldc 78
    //   214: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: areturn
    //   219: aload 9
    //   221: invokevirtual 140	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   224: invokestatic 146	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   227: invokestatic 167	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   230: astore 11
    //   232: aload 11
    //   234: ifnonnull +118 -> 352
    //   237: ldc 169
    //   239: astore 4
    //   241: ldc 108
    //   243: ldc 171
    //   245: iconst_1
    //   246: anewarray 112	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload 4
    //   253: aastore
    //   254: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: aload 11
    //   259: ifnull +129 -> 388
    //   262: aload 11
    //   264: getfield 176	android/graphics/BitmapFactory$Options:outWidth	I
    //   267: sipush 288
    //   270: if_icmpgt +14 -> 284
    //   273: aload 11
    //   275: getfield 179	android/graphics/BitmapFactory$Options:outHeight	I
    //   278: sipush 288
    //   281: if_icmple +107 -> 388
    //   284: aload 9
    //   286: invokevirtual 140	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   289: invokestatic 146	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   292: sipush 288
    //   295: sipush 288
    //   298: getstatic 185	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   301: bipush 60
    //   303: new 89	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   310: aload 10
    //   312: invokevirtual 87	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   315: invokevirtual 140	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   318: invokestatic 146	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   321: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 188
    //   326: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload 10
    //   334: invokevirtual 96	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   337: invokestatic 192	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   340: istore_2
    //   341: aload 6
    //   343: astore 5
    //   345: aload 8
    //   347: astore 4
    //   349: goto -214 -> 135
    //   352: new 89	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   359: aload 11
    //   361: getfield 176	android/graphics/BitmapFactory$Options:outWidth	I
    //   364: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc 197
    //   369: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 11
    //   374: getfield 179	android/graphics/BitmapFactory$Options:outHeight	I
    //   377: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: astore 4
    //   385: goto -144 -> 241
    //   388: aload 9
    //   390: invokestatic 203	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   393: astore 4
    //   395: aload 4
    //   397: fconst_0
    //   398: sipush 288
    //   401: sipush 288
    //   404: invokestatic 207	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   407: astore 8
    //   409: aload 8
    //   411: ifnull +245 -> 656
    //   414: aload 10
    //   416: invokestatic 211	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   419: astore 6
    //   421: aload 6
    //   423: astore 5
    //   425: aload 5
    //   427: astore 7
    //   429: aload 4
    //   431: astore 6
    //   433: aload 8
    //   435: getstatic 185	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   438: bipush 60
    //   440: aload 5
    //   442: invokevirtual 217	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   445: istore_2
    //   446: goto -311 -> 135
    //   449: astore 8
    //   451: aconst_null
    //   452: astore 5
    //   454: aconst_null
    //   455: astore 4
    //   457: aload 5
    //   459: astore 7
    //   461: aload 4
    //   463: astore 6
    //   465: ldc 108
    //   467: ldc 219
    //   469: iconst_1
    //   470: anewarray 112	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload 8
    //   477: invokestatic 225	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   480: aastore
    //   481: invokestatic 228	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload 4
    //   486: ifnull +8 -> 494
    //   489: aload 4
    //   491: invokevirtual 151	java/io/InputStream:close	()V
    //   494: aload 5
    //   496: ifnull +155 -> 651
    //   499: aload 5
    //   501: invokevirtual 154	java/io/OutputStream:close	()V
    //   504: iconst_0
    //   505: istore_3
    //   506: goto -347 -> 159
    //   509: astore 4
    //   511: iconst_0
    //   512: istore_3
    //   513: goto -354 -> 159
    //   516: astore_1
    //   517: aload 7
    //   519: astore 4
    //   521: aload 4
    //   523: ifnull +8 -> 531
    //   526: aload 4
    //   528: invokevirtual 151	java/io/InputStream:close	()V
    //   531: aload 5
    //   533: ifnull +8 -> 541
    //   536: aload 5
    //   538: invokevirtual 154	java/io/OutputStream:close	()V
    //   541: ldc 78
    //   543: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   546: aload_1
    //   547: athrow
    //   548: ldc 108
    //   550: ldc 230
    //   552: iconst_3
    //   553: anewarray 112	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: aload_0
    //   559: invokespecial 159	com/tencent/mm/modelvideo/n:bNX	()Ljava/lang/String;
    //   562: aastore
    //   563: dup
    //   564: iconst_1
    //   565: aload 9
    //   567: invokevirtual 116	com/tencent/mm/vfs/u:length	()J
    //   570: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   573: aastore
    //   574: dup
    //   575: iconst_2
    //   576: aload 9
    //   578: invokevirtual 140	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   581: invokestatic 146	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   584: aastore
    //   585: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: ldc 78
    //   590: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   593: aload_1
    //   594: areturn
    //   595: astore 4
    //   597: goto -452 -> 145
    //   600: astore 4
    //   602: iload_2
    //   603: istore_3
    //   604: goto -445 -> 159
    //   607: astore 4
    //   609: goto -115 -> 494
    //   612: astore 4
    //   614: goto -83 -> 531
    //   617: astore 4
    //   619: goto -78 -> 541
    //   622: astore_1
    //   623: goto -102 -> 521
    //   626: astore_1
    //   627: aload 7
    //   629: astore 5
    //   631: aload 6
    //   633: astore 4
    //   635: goto -114 -> 521
    //   638: astore 8
    //   640: aconst_null
    //   641: astore 5
    //   643: goto -186 -> 457
    //   646: astore 8
    //   648: goto -191 -> 457
    //   651: iconst_0
    //   652: istore_3
    //   653: goto -494 -> 159
    //   656: iconst_0
    //   657: istore_2
    //   658: aload 6
    //   660: astore 5
    //   662: goto -527 -> 135
    //   665: iconst_0
    //   666: istore_2
    //   667: aload 6
    //   669: astore 5
    //   671: aload 8
    //   673: astore 4
    //   675: goto -540 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	n
    //   0	678	1	paramString	String
    //   126	541	2	bool1	boolean
    //   146	507	3	bool2	boolean
    //   129	361	4	localObject1	Object
    //   509	1	4	localIOException1	java.io.IOException
    //   519	8	4	localObject2	Object
    //   595	1	4	localIOException2	java.io.IOException
    //   600	1	4	localIOException3	java.io.IOException
    //   607	1	4	localIOException4	java.io.IOException
    //   612	1	4	localIOException5	java.io.IOException
    //   617	1	4	localIOException6	java.io.IOException
    //   633	41	4	localObject3	Object
    //   56	614	5	localObject4	Object
    //   59	609	6	localObject5	Object
    //   50	578	7	localObject6	Object
    //   53	381	8	localBitmap	android.graphics.Bitmap
    //   449	27	8	localException1	java.lang.Exception
    //   638	1	8	localException2	java.lang.Exception
    //   646	26	8	localException3	java.lang.Exception
    //   13	564	9	localu1	com.tencent.mm.vfs.u
    //   47	368	10	localu2	com.tencent.mm.vfs.u
    //   230	143	11	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   83	125	449	java/lang/Exception
    //   219	232	449	java/lang/Exception
    //   241	257	449	java/lang/Exception
    //   262	284	449	java/lang/Exception
    //   284	341	449	java/lang/Exception
    //   352	385	449	java/lang/Exception
    //   388	395	449	java/lang/Exception
    //   499	504	509	java/io/IOException
    //   83	125	516	finally
    //   219	232	516	finally
    //   241	257	516	finally
    //   262	284	516	finally
    //   284	341	516	finally
    //   352	385	516	finally
    //   388	395	516	finally
    //   140	145	595	java/io/IOException
    //   152	157	600	java/io/IOException
    //   489	494	607	java/io/IOException
    //   526	531	612	java/io/IOException
    //   536	541	617	java/io/IOException
    //   395	409	622	finally
    //   414	421	622	finally
    //   433	446	626	finally
    //   465	484	626	finally
    //   395	409	638	java/lang/Exception
    //   414	421	638	java/lang/Exception
    //   433	446	646	java/lang/Exception
  }
  
  private String bNX()
  {
    AppMethodBeat.i(241269);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(241269);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(241335);
    if (this.oZI != null) {
      this.oZI.iGP();
    }
    super.cancel();
    AppMethodBeat.o(241335);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(241309);
    z localz = ab.Qo(this.fileName);
    if (localz == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "Get info Failed file:" + this.fileName);
      this.oJK.eF(3, -1);
      AppMethodBeat.o(241309);
      return -1;
    }
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new eyj();
    paramh.otF = new eyk();
    paramh.uri = "/cgi-bin/micromsg-bin/sendvideouploadmsg";
    paramh.funcId = 6828;
    paramh.otG = 39;
    paramh.respCmdId = 1000000039;
    this.rr = paramh.bEF();
    eyj localeyj = (eyj)c.b.b(this.rr.otB);
    localeyj.YHk = this.fileName;
    localeyj.IMh = com.tencent.mm.model.z.bAM();
    localeyj.IMg = this.oJJ.field_toUser;
    localeyj.aaGn = this.oJJ.field_fileId;
    localeyj.aaGp = this.oJJ.field_aesKey;
    localeyj.abzD = this.oJJ.field_thumbimgLength;
    v.bOh();
    paramh = aa.PY(this.fileName);
    Object localObject = BitmapUtil.getImageOptions(paramh);
    if (localObject != null)
    {
      localeyj.abzF = ((BitmapFactory.Options)localObject).outWidth;
      localeyj.abzE = ((BitmapFactory.Options)localObject).outHeight;
      localeyj.abzG = localz.omT;
      paramh = ab.Qo(this.fileName);
      if (paramh == null) {
        break label853;
      }
      if (Util.isNullOrNil(paramh.pbn)) {
        break label656;
      }
      paramh = paramh.pbn;
    }
    for (;;)
    {
      label294:
      Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.oJI), paramh });
      if ((this.oJI <= 0) || (this.oJI > 1048576)) {
        if (Util.isNullOrNil(paramh))
        {
          paramh = bt.bCQ();
          label348:
          localeyj.YFJ = paramh;
          v.bOh();
          localeyj.abzH = y.bub(aa.PX(this.fileName));
          localeyj.abzJ = localz.omT;
          localeyj.abzM = this.oJJ.field_fileId;
          paramh = "";
          if (Util.isNullOrNil(localz.bOu())) {
            break label830;
          }
          paramh = localz.bOu();
        }
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramh))
        {
          if (Util.isNullOrNil(localz.bOu()))
          {
            Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "uploadVideo video.recvXml is empty and update: %s", new Object[] { paramh });
            localz.pbh = paramh;
            ab.f(localz);
          }
          localObject = a.NM(paramh);
          if ((localObject != null) && (!Util.isNullOrNil(((a)localObject).appId)))
          {
            localeyj.oOI = ((a)localObject).appId;
            localeyj.YCm = ((a)localObject).mediaTagName;
            localeyj.YCn = ((a)localObject).messageExt;
            localeyj.YCo = ((a)localObject).messageAction;
          }
          if (Util.isNullOrNil(localeyj.aaGp))
          {
            paramh = XmlParser.parseXml(paramh, "msg", null);
            if (paramh != null) {
              localeyj.aaGp = ((String)paramh.get(".msg.videomsg.$cdnthumbaeskey"));
            }
          }
        }
        if (!Util.isNullOrNil(localz.oYk))
        {
          paramh = ab.Qo(localz.oYk);
          if (paramh != null)
          {
            v.bOh();
            localeyj.abzK = y.bub(aa.PX(localz.oYk));
            localeyj.abzL = paramh.omT;
          }
        }
        int i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(241309);
        return i;
        Log.w("MicroMsg.NetSceneUploadVideoOriginCgi", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramh });
        break;
        label656:
        if (paramh.pbm > 0)
        {
          paramh = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramh.pbm);
          if (paramh == null) {
            break label853;
          }
          paramh = bt.JV(paramh.jUr);
          break label294;
        }
        paramh = y.bub(paramh.bOt());
        localObject = com.tencent.mm.platformtools.s.pBi;
        paramh = com.tencent.mm.platformtools.s.Si(paramh);
        break label294;
        paramh = bt.JW(paramh);
        break label348;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<msgsource>");
        ((StringBuilder)localObject).append("<videopreloadlen>").append(this.oJI).append("</videopreloadlen>");
        if (!Util.isNullOrNil(paramh)) {
          ((StringBuilder)localObject).append("<sec_msg_node><uuid>").append(paramh).append("</uuid></sec_msg_node>");
        }
        ((StringBuilder)localObject).append("</msgsource>");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 35L, 1L, false);
        paramh = ((StringBuilder)localObject).toString();
        break label348;
        label830:
        if (!Util.isNullOrNil(localz.pbo)) {
          paramh = a.NL(localz.pbo);
        }
      }
      label853:
      paramh = null;
    }
  }
  
  public final int getType()
  {
    return 6828;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(241331);
    Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { bNX(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = (eyk)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.oYN = ab.Qo(this.fileName);
    if (this.oYN == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.oJK.eF(3, -1);
      AppMethodBeat.o(241331);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == 102))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.oJK.eF(paramInt2, paramInt3);
      AppMethodBeat.o(241331);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      ab.Qg(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.oJK.eF(paramInt2, paramInt3);
      AppMethodBeat.o(241331);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.oJK.eF(paramInt2, paramInt3);
      AppMethodBeat.o(241331);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.oJK.eF(paramInt2, paramInt3);
      AppMethodBeat.o(241331);
      return;
    }
    this.oYN.pba = Util.nowSecond();
    this.oYN.hTh = params.Njv;
    this.oJM = params.abzN;
    Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { bNX(), Long.valueOf(this.oYN.hTh), Integer.valueOf(com.tencent.mm.platformtools.z.pCn) });
    if ((10007 == com.tencent.mm.platformtools.z.pCm) && (com.tencent.mm.platformtools.z.pCn != 0) && (this.oYN.hTh != 0L))
    {
      this.oYN.hTh = com.tencent.mm.platformtools.z.pCn;
      com.tencent.mm.platformtools.z.pCn = 0;
    }
    this.oYN.eQp = 1028;
    ab.f(this.oYN);
    this.oIo = true;
    params = this.oYN.bOs();
    params = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(params);
    boolean bool;
    if ((params == null) || ((int)params.maN <= 0))
    {
      bool = false;
      if ((!bool) && (!au.bwc(this.oYN.bOs()))) {
        break label1037;
      }
      Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "%s upload to biz :%s", new Object[] { bNX(), this.oYN.bOs() });
      if (this.oYN.hTh < 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "ERR: finish video invaild MSGSVRID :" + this.oYN.hTh + " file:" + this.fileName + " toUser:" + this.oYN.bOs());
        ab.Qf(this.fileName);
        this.oJK.eF(3, -1);
      }
    }
    for (;;)
    {
      v.bOh();
      params = aa.PX(this.fileName);
      paramArrayOfByte = new com.tencent.mm.pluginsdk.g.d();
      paramArrayOfByte.oGz = this.oYN.pbc;
      paramArrayOfByte.XPa = this.oIA;
      paramArrayOfByte.scene = 2;
      paramArrayOfByte.fileType = 4;
      paramArrayOfByte.fullPath = params;
      this.oZI = new com.tencent.mm.pluginsdk.g.c();
      this.oZI.XOX = true;
      this.oZI.XOD = this.oJJ.field_fileId;
      this.oZI.nRv = this.oJJ.field_aesKey;
      this.oZI.a(paramArrayOfByte);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(241331);
      return;
      bool = params.iZC();
      break;
      label1037:
      Log.i("MicroMsg.NetSceneUploadVideoOriginCgi", "%s not upload to biz", new Object[] { bNX() });
      if (this.oYN.hTh <= 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoOriginCgi", "ERR: finish video invaild MSGSVRID :" + this.oYN.hTh + " file:" + this.fileName + " toUser:" + this.oYN.bOs());
        ab.Qf(this.fileName);
        this.oJK.eF(3, -1);
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 1;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(241317);
    ab.Qf(this.fileName);
    AppMethodBeat.o(241317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n
 * JD-Core Version:    0.7.0.1
 */