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
import com.tencent.mm.g.g.a;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelimage.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.af;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.eyj;
import com.tencent.mm.protocal.protobuf.eyk;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.am.h callback;
  private String fileName;
  private String oHX;
  private boolean oIo;
  private int oJI;
  public com.tencent.mm.g.d oJJ;
  public com.tencent.mm.modelimage.g oJK;
  private String oJM;
  private z oYN;
  private String oYk;
  private z oZE;
  private com.tencent.mm.g.d oZF;
  private final g.a oZG;
  private int oZp;
  private com.tencent.mm.am.c rr;
  
  public m(String paramString, int paramInt, com.tencent.mm.g.d paramd, com.tencent.mm.modelimage.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(241274);
    this.fileName = null;
    this.oJI = 0;
    this.oJJ = null;
    this.oJK = null;
    this.oZG = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(241215);
        Log.d("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { m.a(m.this), paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneUploadVideoOrigin", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(241215);
          return 0;
        }
        int i;
        if (paramAnonymousInt != 0)
        {
          ab.Qf(m.b(m.this));
          if (m.c(m.this) == null)
          {
            i = 6;
            paramAnonymousString = com.tencent.mm.cb.d.acls;
            paramAnonymousString = m.b(m.this);
            if (m.d(m.this) == null) {
              break label191;
            }
          }
          label191:
          for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
          {
            com.tencent.mm.cb.d.a(null, paramAnonymousString, i, 0L, 0L, 0L, 0L, paramAnonymousBoolean, paramAnonymousInt);
            m.e(m.this).onSceneEnd(3, paramAnonymousInt, "", m.this);
            m.this.oJK.eF(3, paramAnonymousInt);
            AppMethodBeat.o(241215);
            return 0;
            i = 7;
            break;
          }
        }
        m.a(m.this, ab.Qo(m.b(m.this)));
        if ((m.f(m.this) == null) || (m.f(m.this).status == 105))
        {
          if (m.f(m.this) == null)
          {
            i = -1;
            Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s info is null or has paused, status:%d", new Object[] { m.a(m.this), Integer.valueOf(i) });
            k.bHW().Ny(m.g(m.this));
            if (m.f(m.this) == null) {
              break label384;
            }
            paramAnonymousString = com.tencent.mm.cb.d.acls;
            com.tencent.mm.cb.d.btM(m.b(m.this));
          }
          for (;;)
          {
            m.e(m.this).onSceneEnd(3, paramAnonymousInt, "info is null or has paused, status".concat(String.valueOf(i)), m.this);
            m.this.oJK.eF(3, paramAnonymousInt);
            AppMethodBeat.o(241215);
            return 0;
            i = m.f(m.this).status;
            break;
            label384:
            paramAnonymousString = com.tencent.mm.cb.d.acls;
            com.tencent.mm.cb.d.a(null, m.b(m.this), 5, 0L, 0L, 0L, 0L, false, paramAnonymousInt);
          }
        }
        if (paramAnonymousc != null)
        {
          if (m.c(m.this) != null)
          {
            if (m.c(m.this).oZm > paramAnonymousc.field_finishedLength)
            {
              Log.w("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra originFileInfo cdnEndProc error oldpos:%d newpos:%d", new Object[] { m.a(m.this), Integer.valueOf(m.c(m.this).oZm), Long.valueOf(paramAnonymousc.field_finishedLength) });
              AppMethodBeat.o(241215);
              return 0;
            }
            m.c(m.this).pba = Util.nowSecond();
            m.c(m.this).oZm = ((int)paramAnonymousc.field_finishedLength);
            m.c(m.this).eQp = 1032;
            ab.f(m.c(m.this));
          }
          for (;;)
          {
            AppMethodBeat.o(241215);
            return 0;
            if (m.f(m.this).oZm > paramAnonymousc.field_finishedLength)
            {
              Log.w("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[] { m.a(m.this), Integer.valueOf(m.f(m.this).oZm), Long.valueOf(paramAnonymousc.field_finishedLength) });
              AppMethodBeat.o(241215);
              return 0;
            }
            m.f(m.this).pba = Util.nowSecond();
            m.f(m.this).oZm = ((int)paramAnonymousc.field_finishedLength);
            m.f(m.this).eQp = 1032;
            ab.f(m.f(m.this));
          }
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label870;
          }
          Log.e("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { m.a(m.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo });
          ab.Qf(m.b(m.this));
          if (m.c(m.this) != null) {
            break label857;
          }
          i = 6;
          paramAnonymousString = com.tencent.mm.cb.d.acls;
          paramAnonymousString = m.b(m.this);
          if (m.d(m.this) == null) {
            break label864;
          }
        }
        label857:
        label864:
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          com.tencent.mm.cb.d.a(null, paramAnonymousString, i, 0L, 0L, 0L, 0L, paramAnonymousBoolean, paramAnonymousd.field_retCode);
          m.e(m.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", m.this);
          m.this.oJK.eF(3, paramAnonymousInt);
          AppMethodBeat.o(241215);
          return 0;
          i = 7;
          break;
        }
        label870:
        paramAnonymousBoolean = paramAnonymousd.field_isVideoReduced;
        Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s it video was reduced by cdn %b %s", new Object[] { m.a(m.this), Boolean.valueOf(paramAnonymousBoolean), m.b(m.this) });
        if (!paramAnonymousBoolean)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 205L, 1L, false);
          if ((m.h(m.this) > 0) && (paramAnonymousd.field_thumbimgLength > 0))
          {
            Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s send video thumb too big thumb length [%d, %d] ", new Object[] { m.a(m.this), Integer.valueOf(m.h(m.this)), Integer.valueOf(paramAnonymousd.field_thumbimgLength) });
            if (m.h(m.this) * 2 > paramAnonymousd.field_thumbimgLength) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 206L, 1L, false);
            }
          }
          else
          {
            v.bOh();
            paramAnonymousInt = (int)y.bEl(aa.PX(m.b(m.this)));
            Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s send video too big thumb length [%d, %d] ", new Object[] { m.a(m.this), Integer.valueOf(m.f(m.this).osy), Integer.valueOf(paramAnonymousInt) });
            if (m.f(m.this).osy == paramAnonymousInt) {
              break label1951;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 208L, 1L, false);
            label1120:
            m.a(m.this, ab.Qo(m.b(m.this)));
            if (Util.isNullOrNil(m.f(m.this).bOu()))
            {
              paramAnonymousString = "<msg><videomsg aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "length=\"" + paramAnonymousd.field_fileLength + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\"/>";
              paramAnonymousString = paramAnonymousString + Util.nullAs(m.f(m.this).pbo, "");
              paramAnonymousString = paramAnonymousString + "</msg>";
              Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s cdn callback new build cdnInfo:%s", new Object[] { m.a(m.this), paramAnonymousString });
              m.f(m.this).pbh = paramAnonymousString;
              ab.f(m.f(m.this));
            }
            if (m.c(m.this) != null)
            {
              paramAnonymousString = m.f(m.this).bOu();
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                paramAnonymousc = ae.pbN;
                paramAnonymousc = ae.a.Qv(paramAnonymousString);
                paramAnonymousInt = paramAnonymousString.indexOf("/>");
                if ((paramAnonymousInt != -1) && ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.pbQ))))
                {
                  paramAnonymousString = paramAnonymousString.substring(0, paramAnonymousInt);
                  paramAnonymousString = paramAnonymousString + "cdnrawvideourl=\"" + paramAnonymousd.field_fileId + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnrawvideoaeskey=\"" + paramAnonymousd.field_aesKey + "\" ";
                  paramAnonymousString = paramAnonymousString + "rawlength=\"" + paramAnonymousd.field_fileLength + "\"/>";
                  paramAnonymousString = paramAnonymousString + "</msg>";
                  Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s cdn origin file callback  reBuild cdnInfo:%s", new Object[] { m.a(m.this), paramAnonymousString });
                  m.f(m.this).pbh = paramAnonymousString;
                  ab.f(m.f(m.this));
                }
              }
            }
            paramAnonymousString = XmlParser.parseXml(m.f(m.this).bOu(), "msg", null);
            if (paramAnonymousString != null)
            {
              paramAnonymousc = v.bOh();
              v.bOh();
              boolean bool = paramAnonymousc.x(aa.PX(m.b(m.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$aeskey"));
              paramAnonymousc = com.tencent.mm.plugin.report.service.h.OAn;
              if (!bool) {
                break label1985;
              }
            }
          }
        }
        label1951:
        label1985:
        for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
        {
          paramAnonymousc.b(12696, new Object[] { Integer.valueOf(paramAnonymousInt + 900), Integer.valueOf(m.f(m.this).osy) });
          if (m.c(m.this) != null)
          {
            paramAnonymousc = v.bOh();
            v.bOh();
            paramAnonymousc.x(aa.PX(m.d(m.this)), (String)paramAnonymousString.get(".msg.videomsg.$cdnrawvideourl"), (String)paramAnonymousString.get(".msg.videomsg.$cdnrawvideoaeskey"));
          }
          if (!Util.isNullOrNil(m.d(m.this))) {
            break label1990;
          }
          m.a(m.this, m.f(m.this).oYk);
          if (Util.isNullOrNil(m.d(m.this))) {
            break label1990;
          }
          m.b(m.this, ab.Qo(m.d(m.this)));
          if (m.c(m.this) == null) {
            break label1990;
          }
          m.a(m.this, paramAnonymousd);
          m.i(m.this);
          AppMethodBeat.o(241215);
          return 0;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 207L, 1L, false);
          break;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 209L, 1L, false);
          break label1120;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 200L, 1L, false);
          break label1120;
        }
        label1990:
        paramAnonymousString = t.bKi();
        paramAnonymousString.fileName = m.b(m.this);
        paramAnonymousString.oJM = m.k(m.this);
        if (paramAnonymousBoolean)
        {
          paramAnonymousInt = 0;
          label2023:
          paramAnonymousString.oJI = paramAnonymousInt;
          if (m.l(m.this) == null) {
            break label2093;
          }
          paramAnonymousString.oJJ = m.l(m.this);
          paramAnonymousString.oJL = paramAnonymousd;
        }
        for (;;)
        {
          paramAnonymousString.oJK = m.this.oJK;
          paramAnonymousString.oNj = 4;
          paramAnonymousString.bKW().aXz();
          break;
          paramAnonymousInt = m.j(m.this);
          break label2023;
          label2093:
          paramAnonymousString.oJJ = paramAnonymousd;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    if (paramString != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramd == null) {
        break label121;
      }
      bool1 = true;
      label63:
      Assert.assertTrue(bool1);
      if (paramg == null) {
        break label127;
      }
    }
    label121:
    label127:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      this.fileName = paramString;
      this.oJJ = paramd;
      this.oJK = paramg;
      this.oJI = paramInt;
      this.oIo = paramBoolean;
      AppMethodBeat.o(241274);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label63;
    }
  }
  
  /* Error */
  private String PE(String paramString)
  {
    // Byte code:
    //   0: ldc 76
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 78	com/tencent/mm/vfs/u
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 81	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: new 78	com/tencent/mm/vfs/u
    //   18: dup
    //   19: aload 9
    //   21: invokevirtual 85	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   24: new 87	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 89
    //   30: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 9
    //   35: invokevirtual 94	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   38: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 6
    //   61: ldc 106
    //   63: ldc 108
    //   65: iconst_1
    //   66: anewarray 110	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 9
    //   73: invokevirtual 114	com/tencent/mm/vfs/u:length	()J
    //   76: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: invokevirtual 114	com/tencent/mm/vfs/u:length	()J
    //   88: ldc2_w 127
    //   91: lcmp
    //   92: ifle +573 -> 665
    //   95: aload 10
    //   97: invokevirtual 132	com/tencent/mm/vfs/u:jKS	()Z
    //   100: ifeq +119 -> 219
    //   103: ldc 106
    //   105: ldc 134
    //   107: iconst_1
    //   108: anewarray 110	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 10
    //   115: invokevirtual 138	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   118: invokestatic 144	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aastore
    //   122: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_1
    //   126: istore_2
    //   127: aload 8
    //   129: astore 4
    //   131: aload 6
    //   133: astore 5
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 149	java/io/InputStream:close	()V
    //   145: iload_2
    //   146: istore_3
    //   147: aload 5
    //   149: ifnull +10 -> 159
    //   152: aload 5
    //   154: invokevirtual 152	java/io/OutputStream:close	()V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_3
    //   160: ifeq +388 -> 548
    //   163: ldc 106
    //   165: ldc 154
    //   167: iconst_3
    //   168: anewarray 110	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_0
    //   174: invokespecial 157	com/tencent/mm/modelvideo/m:bNX	()Ljava/lang/String;
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload 10
    //   182: invokevirtual 114	com/tencent/mm/vfs/u:length	()J
    //   185: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: aload 10
    //   193: invokevirtual 138	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   196: invokestatic 144	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   199: aastore
    //   200: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: aload 10
    //   205: invokevirtual 138	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   208: invokestatic 144	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   211: astore_1
    //   212: ldc 76
    //   214: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: areturn
    //   219: aload 9
    //   221: invokevirtual 138	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   224: invokestatic 144	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   227: invokestatic 165	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   230: astore 11
    //   232: aload 11
    //   234: ifnonnull +118 -> 352
    //   237: ldc 167
    //   239: astore 4
    //   241: ldc 106
    //   243: ldc 169
    //   245: iconst_1
    //   246: anewarray 110	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload 4
    //   253: aastore
    //   254: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: aload 11
    //   259: ifnull +129 -> 388
    //   262: aload 11
    //   264: getfield 174	android/graphics/BitmapFactory$Options:outWidth	I
    //   267: sipush 288
    //   270: if_icmpgt +14 -> 284
    //   273: aload 11
    //   275: getfield 177	android/graphics/BitmapFactory$Options:outHeight	I
    //   278: sipush 288
    //   281: if_icmple +107 -> 388
    //   284: aload 9
    //   286: invokevirtual 138	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   289: invokestatic 144	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   292: sipush 288
    //   295: sipush 288
    //   298: getstatic 183	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   301: bipush 60
    //   303: new 87	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   310: aload 10
    //   312: invokevirtual 85	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   315: invokevirtual 138	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   318: invokestatic 144	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   321: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 186
    //   326: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload 10
    //   334: invokevirtual 94	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   337: invokestatic 190	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   340: istore_2
    //   341: aload 6
    //   343: astore 5
    //   345: aload 8
    //   347: astore 4
    //   349: goto -214 -> 135
    //   352: new 87	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   359: aload 11
    //   361: getfield 174	android/graphics/BitmapFactory$Options:outWidth	I
    //   364: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc 195
    //   369: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 11
    //   374: getfield 177	android/graphics/BitmapFactory$Options:outHeight	I
    //   377: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: astore 4
    //   385: goto -144 -> 241
    //   388: aload 9
    //   390: invokestatic 201	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   393: astore 4
    //   395: aload 4
    //   397: fconst_0
    //   398: sipush 288
    //   401: sipush 288
    //   404: invokestatic 205	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;FII)Landroid/graphics/Bitmap;
    //   407: astore 8
    //   409: aload 8
    //   411: ifnull +245 -> 656
    //   414: aload 10
    //   416: invokestatic 209	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   419: astore 6
    //   421: aload 6
    //   423: astore 5
    //   425: aload 5
    //   427: astore 7
    //   429: aload 4
    //   431: astore 6
    //   433: aload 8
    //   435: getstatic 183	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   438: bipush 60
    //   440: aload 5
    //   442: invokevirtual 215	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
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
    //   465: ldc 106
    //   467: ldc 217
    //   469: iconst_1
    //   470: anewarray 110	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload 8
    //   477: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   480: aastore
    //   481: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload 4
    //   486: ifnull +8 -> 494
    //   489: aload 4
    //   491: invokevirtual 149	java/io/InputStream:close	()V
    //   494: aload 5
    //   496: ifnull +155 -> 651
    //   499: aload 5
    //   501: invokevirtual 152	java/io/OutputStream:close	()V
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
    //   528: invokevirtual 149	java/io/InputStream:close	()V
    //   531: aload 5
    //   533: ifnull +8 -> 541
    //   536: aload 5
    //   538: invokevirtual 152	java/io/OutputStream:close	()V
    //   541: ldc 76
    //   543: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   546: aload_1
    //   547: athrow
    //   548: ldc 106
    //   550: ldc 228
    //   552: iconst_3
    //   553: anewarray 110	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: aload_0
    //   559: invokespecial 157	com/tencent/mm/modelvideo/m:bNX	()Ljava/lang/String;
    //   562: aastore
    //   563: dup
    //   564: iconst_1
    //   565: aload 9
    //   567: invokevirtual 114	com/tencent/mm/vfs/u:length	()J
    //   570: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   573: aastore
    //   574: dup
    //   575: iconst_2
    //   576: aload 9
    //   578: invokevirtual 138	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   581: invokestatic 144	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   584: aastore
    //   585: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: ldc 76
    //   590: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	678	0	this	m
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
    //   449	27	8	localException1	Exception
    //   638	1	8	localException2	Exception
    //   646	26	8	localException3	Exception
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
    AppMethodBeat.i(241277);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(241277);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(241322);
    z localz = ab.Qo(this.fileName);
    if (localz == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "Get info Failed file:" + this.fileName);
      this.oJK.eF(3, -1);
      AppMethodBeat.o(241322);
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
      Log.i("MicroMsg.NetSceneUploadVideoOrigin", "createVideoMsgSource preLoadLength: %s, forward uuid %s", new Object[] { Integer.valueOf(this.oJI), paramh });
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
            Log.i("MicroMsg.NetSceneUploadVideoOrigin", "uploadVideo video.recvXml is empty and update: %s", new Object[] { paramh });
            localz.pbh = paramh;
            ab.f(localz);
          }
          localObject = com.tencent.mm.modelimage.a.NM(paramh);
          if ((localObject != null) && (!Util.isNullOrNil(((com.tencent.mm.modelimage.a)localObject).appId)))
          {
            localeyj.oOI = ((com.tencent.mm.modelimage.a)localObject).appId;
            localeyj.YCm = ((com.tencent.mm.modelimage.a)localObject).mediaTagName;
            localeyj.YCn = ((com.tencent.mm.modelimage.a)localObject).messageExt;
            localeyj.YCo = ((com.tencent.mm.modelimage.a)localObject).messageAction;
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
        AppMethodBeat.o(241322);
        return i;
        Log.w("MicroMsg.NetSceneUploadVideoOrigin", "cdntra getImageOptions for thumb failed path:%s", new Object[] { paramh });
        break;
        label656:
        if (paramh.pbm > 0)
        {
          paramh = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramh.pbm);
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
          paramh = com.tencent.mm.modelimage.a.NL(localz.pbo);
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
    AppMethodBeat.i(241358);
    Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra onGYNetEnd errtype[%d %d]", new Object[] { bNX(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = (eyk)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.oYN = ab.Qo(this.fileName);
    if (this.oYN == null)
    {
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk != null) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.cb.d.a(null, params, 5, 0L, 0L, 0L, 0L, bool, -1);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.oJK.eF(3, -1);
        AppMethodBeat.o(241358);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == 102))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk != null) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.cb.d.a(null, params, 4, 0L, 0L, 0L, 0L, bool, paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.oJK.eF(paramInt2, paramInt3);
        AppMethodBeat.o(241358);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "ERR: onGYNetEnd BLACK  errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk != null) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.cb.d.a(null, params, 4, 0L, 0L, 0L, 0L, bool, paramInt3);
        ab.Qg(this.fileName);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.oJK.eF(paramInt2, paramInt3);
        AppMethodBeat.o(241358);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      ab.Qf(this.fileName);
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk != null) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.cb.d.a(null, params, 4, 0L, 0L, 0L, 0L, bool, paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.oJK.eF(paramInt2, paramInt3);
        AppMethodBeat.o(241358);
        return;
      }
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + paramInt2 + " errCode:" + paramInt3 + "  file:" + this.fileName + " user:" + this.oYN.bOs());
      ab.Qf(this.fileName);
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk != null) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.cb.d.a(null, params, 4, 0L, 0L, 0L, 0L, bool, paramInt3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.oJK.eF(paramInt2, paramInt3);
        AppMethodBeat.o(241358);
        return;
      }
    }
    this.oYN.pba = Util.nowSecond();
    this.oYN.hTh = params.Njv;
    this.oJM = params.abzN;
    Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s dkmsgid  set svrmsgid %d -> %d", new Object[] { bNX(), Long.valueOf(this.oYN.hTh), Integer.valueOf(com.tencent.mm.platformtools.z.pCn) });
    if ((10007 == com.tencent.mm.platformtools.z.pCm) && (com.tencent.mm.platformtools.z.pCn != 0) && (this.oYN.hTh != 0L))
    {
      this.oYN.hTh = com.tencent.mm.platformtools.z.pCn;
      com.tencent.mm.platformtools.z.pCn = 0;
    }
    this.oYN.eQp = 1028;
    ab.f(this.oYN);
    params = this.oYN.bOs();
    params = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(params);
    if ((params == null) || ((int)params.maN <= 0))
    {
      bool = false;
      if ((!bool) && (!au.bwc(this.oYN.bOs()))) {
        break label1234;
      }
      Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s upload to biz :%s", new Object[] { bNX(), this.oYN.bOs() });
      if (this.oYN.hTh < 0L)
      {
        Log.e("MicroMsg.NetSceneUploadVideoOrigin", "ERR: finish video invaild MSGSVRID :" + this.oYN.hTh + " file:" + this.fileName + " toUser:" + this.oYN.bOs());
        ab.Qf(this.fileName);
        this.oJK.eF(3, -1);
      }
      label1086:
      this.oHX = com.tencent.mm.modelcdntran.h.a("upvideo", this.oYN.createTime, this.oYN.bOs(), this.oYN.getFileName());
      if (!Util.isNullOrNil(this.oHX)) {
        break label1350;
      }
      Log.w("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bNX(), this.oYN.getFileName() });
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk == null) {
        break label1344;
      }
    }
    label1344:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.cb.d.a(null, params, 6, 0L, 0L, 0L, 0L, bool, -1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.oJK.eF(3, -1);
      AppMethodBeat.o(241358);
      return;
      bool = params.iZC();
      break;
      label1234:
      Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s not upload to biz", new Object[] { bNX() });
      if (this.oYN.hTh > 0L) {
        break label1086;
      }
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "ERR: finish video invaild MSGSVRID :" + this.oYN.hTh + " file:" + this.fileName + " toUser:" + this.oYN.bOs());
      ab.Qf(this.fileName);
      this.oJK.eF(3, -1);
      break label1086;
    }
    label1350:
    v.bOh();
    params = aa.PY(this.fileName);
    v.bOh();
    String str1 = aa.PX(this.fileName);
    paramArrayOfByte = new com.tencent.mm.g.g();
    paramArrayOfByte.taskName = "task_NetSceneUploadVideo_1";
    paramArrayOfByte.lwL = this.oZG;
    paramArrayOfByte.field_mediaId = this.oHX;
    paramArrayOfByte.field_fullpath = str1;
    paramArrayOfByte.field_thumbpath = PE(params);
    paramArrayOfByte.field_fileType = com.tencent.mm.g.a.MediaType_VIDEO;
    if (au.bwZ(this.oYN.bOs()))
    {
      paramArrayOfByte.field_sendmsg_viacdn = false;
      if ((au.bwZ(this.oYN.bOs())) || (!this.oIo)) {
        break label1989;
      }
      bool = true;
      label1479:
      paramArrayOfByte.field_enable_hitcheck = bool;
      if (!e.bIg().NE(str1)) {
        break label1995;
      }
      paramInt1 = 1;
      label1499:
      paramArrayOfByte.field_largesvideo = paramInt1;
      if ((this.oYN != null) && (3 == this.oYN.pbi)) {
        paramArrayOfByte.field_smallVideoFlag = 1;
      }
      params = bNX();
      if (this.oYN.pbl != null) {
        break label2000;
      }
      bool = true;
      label1548:
      Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s upload video MMSightExtInfo is null? %b %s", new Object[] { params, Boolean.valueOf(bool), this.fileName });
      if ((this.oYN.pbl != null) && (this.oYN.pbl.aaSg))
      {
        Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s local capture video, mark use large video", new Object[] { bNX() });
        e.bIg();
        paramArrayOfByte.field_largesvideo = e.b(e.bIg().bIh());
      }
      params = this.oYN;
      Object localObject = u.bOf();
      v.bOh();
      ((u)localObject).a("", aa.PX(this.fileName), params.bOs(), "", "", 2, 2);
      localObject = bNX();
      String str2 = this.oYN.getFileName();
      if (this.oYN.pbk != null) {
        break label2006;
      }
      params = "null";
      label1712:
      Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s checkAD file:%s adinfo:%s", new Object[] { localObject, str2, params });
      if ((this.oYN.pbk != null) && (!Util.isNullOrNil(this.oYN.pbk.nTA))) {
        paramArrayOfByte.field_advideoflag = 1;
      }
      paramArrayOfByte.field_talker = this.oYN.bOs();
      if (!au.bwG(this.oYN.bOs())) {
        break label2021;
      }
      paramInt1 = 1;
      label1798:
      paramArrayOfByte.field_chattype = paramInt1;
      paramArrayOfByte.field_priority = com.tencent.mm.g.a.lvZ;
      paramArrayOfByte.field_needStorage = false;
      paramArrayOfByte.field_isStreamMedia = false;
      paramArrayOfByte.field_trysafecdn = true;
      this.oZp = ((int)y.bEl(paramArrayOfByte.field_thumbpath));
      if (this.oZp < com.tencent.mm.g.a.lwv) {
        break label2032;
      }
      Log.w("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { bNX(), paramArrayOfByte.field_thumbpath, Integer.valueOf(this.oZp) });
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk == null) {
        break label2026;
      }
    }
    label1989:
    label1995:
    label2000:
    label2006:
    label2021:
    label2026:
    for (bool = true;; bool = false)
    {
      com.tencent.mm.cb.d.a(null, params, 6, 0L, 0L, 0L, 0L, bool, -1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.oJK.eF(3, -1);
      AppMethodBeat.o(241358);
      return;
      if (!af.bpG(str1)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 30L, 1L, false);
      paramArrayOfByte.field_use_multithread = true;
      break;
      bool = false;
      break label1479;
      paramInt1 = 0;
      break label1499;
      bool = false;
      break label1548;
      params = this.oYN.pbk.nTA;
      break label1712;
      paramInt1 = 0;
      break label1798;
    }
    label2032:
    params = XmlParser.parseXml(this.oYN.bOu(), "msg", null);
    if (params != null)
    {
      paramArrayOfByte.field_fileId = ((String)params.get(".msg.videomsg.$cdnvideourl"));
      paramArrayOfByte.field_aesKey = ((String)params.get(".msg.videomsg.$aeskey"));
      if ((Util.isNullOrNil(paramArrayOfByte.field_aesKey)) || (Util.isNullOrNil(paramArrayOfByte.field_aesKey)))
      {
        paramArrayOfByte.field_aesKey = "";
        paramArrayOfByte.field_fileId = "";
        k.bHX();
        paramArrayOfByte.field_aesKey = com.tencent.mm.modelcdntran.d.bHI();
      }
      Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %d", new Object[] { bNX(), paramArrayOfByte.field_mediaId, paramArrayOfByte.field_fileId, paramArrayOfByte.field_aesKey, Boolean.valueOf(this.oIo), Integer.valueOf(paramArrayOfByte.field_largesvideo) });
      if (k.bHW().g(paramArrayOfByte)) {
        break label2596;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 226L, 1L, false);
      Log.e("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra addSendTask failed.", new Object[] { bNX() });
      this.oHX = "";
      params = com.tencent.mm.cb.d.acls;
      params = this.fileName;
      if (this.oYk != null)
      {
        bool = true;
        label2276:
        com.tencent.mm.cb.d.a(null, params, 6, 0L, 0L, 0L, 0L, bool, -1);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.oJK.eF(3, -1);
        AppMethodBeat.o(241358);
      }
    }
    else
    {
      Log.i("MicroMsg.NetSceneUploadVideoOrigin", "%s cdntra parse video recv xml failed", new Object[] { bNX() });
    }
    label2562:
    label2567:
    label2572:
    label2578:
    label2584:
    label2596:
    label2744:
    for (;;)
    {
      try
      {
        params = Util.nullAsNil(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("UseVideoHash")).split(",");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baC();
        i = com.tencent.mm.b.i.jdMethod_do(b.getUin(), 100);
        if ((params == null) || (params.length <= 0)) {
          break label2567;
        }
        if (Util.getInt(params[0], 0) < i) {
          break label2562;
        }
        paramInt1 = 1;
        if ((params == null) || (params.length < 2)) {
          break label2578;
        }
        if (Util.getInt(params[1], 0) < i) {
          break label2572;
        }
        i = 1;
        if ((params != null) && (params.length >= 3)) {
          Util.getInt(params[2], 0);
        }
        if (!CrashReportFactory.hasDebuger()) {
          break label2744;
        }
        paramInt1 = 1;
        i = 1;
        if (paramInt1 == 0) {
          break label2584;
        }
        params = v.bOh().bc(str1, Util.getInt(params[2], 0));
        if ((i == 0) || (params == null) || (params.length != 2)) {
          break;
        }
        paramArrayOfByte.field_fileId = params[0];
        paramArrayOfByte.field_aesKey = params[1];
      }
      catch (Exception params)
      {
        Log.e("MicroMsg.NetSceneUploadVideoOrigin", "Check use videohash :%s", new Object[] { Util.stackTraceToString(params) });
      }
      break;
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
      continue;
      int i = 0;
      continue;
      i = 0;
      continue;
      params = null;
      continue;
      bool = false;
      break label2276;
      params = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.oYN.pbc);
      params.gX(this.oYN.hTh);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.oYN.pbc, params);
      if (this.oYN.pbg != 1)
      {
        this.oYN.pbg = 1;
        this.oYN.status = 104;
        this.oYN.clientId = this.oHX;
        this.oYN.eQp = 524544;
        ab.f(this.oYN);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(241358);
      return;
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
    AppMethodBeat.i(241333);
    ab.Qf(this.fileName);
    AppMethodBeat.o(241333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */