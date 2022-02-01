package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.am.w;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.j.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.modelstat.q.a;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.g.d.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ftv;
import com.tencent.mm.protocal.protobuf.ftw;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.wcdb.database.SQLiteException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class o
  extends p
  implements com.tencent.mm.network.m
{
  public static boolean DEBUG = true;
  private static long oIB;
  private String TAG;
  private com.tencent.mm.am.h callback;
  public String hgl;
  private cc hzO;
  private float latitude;
  private float longtitude;
  private int mgx;
  private long mxN;
  private int mxO;
  private h mxP;
  private boolean mxV;
  private int oGu;
  private long oGz;
  private final com.tencent.mm.am.i oHS;
  public long oHT;
  private com.tencent.mm.modelstat.g oHW;
  private String oHX;
  private int oHY;
  private d.a oIA;
  private int oIb;
  private String oIm;
  private String oIn;
  private boolean oIo;
  private h oIp;
  private int oIq;
  public a oIr;
  private String oIs;
  public String oIt;
  public boolean oIu;
  private String oIv;
  private String oIw;
  public String oIx;
  private boolean oIy;
  private String oIz;
  private com.tencent.mm.g.g.a osH;
  private final com.tencent.mm.am.c rr;
  private int scene;
  private long startTime;
  
  public o(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150698);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.oIm = "";
    this.oIn = "";
    this.oIo = true;
    this.oIq = 16384;
    this.oGu = 0;
    this.hzO = null;
    this.oHW = null;
    this.oHX = "";
    this.startTime = 0L;
    this.oHY = -1;
    this.mgx = 0;
    this.oIr = new a(null);
    this.oIy = false;
    this.oIA = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(238955);
        Log.e(o.f(o.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l.wu((int)o.b(o.this));
        l.wt((int)o.b(o.this));
        o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
        if (o.n(o.this) != null) {
          o.n(o.this).bFL();
        }
        AppMethodBeat.o(238955);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(238954);
        Log.i(o.f(o.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        Util.nowMilliSecond();
        o.j(o.this);
        final com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        final h localh = o.d(o.this);
        Object localObject1 = r.bKa().v(localh.oGr, "", "");
        Object localObject2 = r.bKa().v(localh.oGs, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.y.bEl(r.bKa().v(localh.oGt, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.y.bEl((String)localObject2));
        locald.field_fileLength = paramAnonymousa.fileLength;
        k.bHX();
        locald.field_filecrc = com.tencent.mm.modelcdntran.d.Nt((String)localObject1);
        localObject2 = o.k(o.this);
        localObject1 = a.NM((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = a.a((a)localObject1);; localObject1 = "")
        {
          long l;
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l = locald.field_fileLength;
              localObject1 = l + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            o.a(o.this, localh);
            localh.NT((String)localObject1);
            o.a(o.this, (String)localObject1);
            if (o.b(o.this) != o.c(o.this)) {
              o.e(o.this).NT((String)localObject1);
            }
            localObject1 = d.bJA();
            ((d)localObject1).mxO = o.p(o.this);
            ((d)localObject1).oGa = ((ftv)c.b.b(o.o(o.this).otB));
            ((d)localObject1).oGb = localh;
            ((d)localObject1).aesKey = paramAnonymousa.XPn;
            ((d)localObject1).mxU = locald;
            ((d)localObject1).oGc = new p.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(238945);
                Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  l.wu((int)o.b(o.this));
                  l.wt((int)o.b(o.this));
                  o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                  if (o.n(o.this) != null) {
                    o.n(o.this).bFL();
                  }
                  AppMethodBeat.o(238945);
                  return;
                }
                o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(238945);
              }
            };
            ((t.e)localObject1).toUser = o.l(o.this).field_talker;
            ((t.e)localObject1).bKW().aXz();
            AppMethodBeat.o(238954);
            return;
            l = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localh.oGu == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l = locald.field_fileLength;
                }
              }
              label886:
              for (localObject1 = l + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l = locald.field_midimgLength;
                break label886;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(238957);
        h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          Log.e(o.f(o.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, -5, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238957);
          return;
        }
        o.a(o.this, localh, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(238957);
      }
    };
    this.osH = new com.tencent.mm.g.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(238956);
        Log.d(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(o.f(o.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        final h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          k.bHW().Ny(o.m(o.this));
          Log.e(o.f(o.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(o.c(o.this)), o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          o.a(o.this, localh, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(o.f(o.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label896;
          }
          Log.e(o.f(o.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(o.f(o.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { o.m(o.this), Boolean.valueOf(o.q(o.this)) });
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(238979);
                o.r(o.this);
                o.s(o.this);
                o.t(o.this);
                Object localObject = o.d(o.this);
                ((h)localObject).wi(0);
                o.l(o.this).setCreateTime(br.JN(o.l(o.this).field_talker));
                o.b(o.this, com.tencent.mm.modelcdntran.h.a("upimg", o.l(o.this).getCreateTime(), o.l(o.this).field_talker, o.l(o.this).field_msgId + "_" + o.c(o.this) + "_" + o.h(o.this)));
                boolean bool = o.a(o.this, (h)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (ftv)c.b.b(o.o(o.this).otB);
                if (localObject == null) {
                  Log.w(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(o.q(o.this)), Boolean.valueOf(bool), o.m(o.this), Long.valueOf(o.l(o.this).getCreateTime()) });
                  o.this.doScene(o.u(o.this), o.g(o.this));
                  AppMethodBeat.o(238979);
                  return;
                  ((ftv)localObject).abRT = new etl().btH(o.m(o.this));
                }
              }
            });
            AppMethodBeat.o(238956);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(o.f(o.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(o.v(o.this)) });
            if (o.v(o.this))
            {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(238977);
                  o.b(o.this, o.d(o.this));
                  AppMethodBeat.o(238977);
                }
              });
              AppMethodBeat.o(238956);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new ux();
          }
        }
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          if ((paramAnonymousString != null) && (paramAnonymousString.BaseResponse.Idd != 0))
          {
            o.g(o.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Idd, paramAnonymousString.BaseResponse.akjO.toString(), o.this);
            if (o.n(o.this) != null) {
              o.n(o.this).bFL();
            }
            AppMethodBeat.o(238956);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (i.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
          }
        }
        label896:
        Log.i(o.f(o.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
        if (localh.source == 0)
        {
          paramAnonymousInt = 3;
          label948:
          paramAnonymousString.b(13230, new Object[] { Integer.valueOf(paramAnonymousInt), o.w(o.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = o.k(o.this);
          paramAnonymousc = a.NM(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label2540;
          }
        }
        label1178:
        label1730:
        label2132:
        label2537:
        label2540:
        for (paramAnonymousc = a.a(paramAnonymousc);; paramAnonymousc = "")
        {
          long l;
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l = paramAnonymousd.field_fileLength;
              paramAnonymousString = l + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            Object localObject = paramAnonymousString;
            if (paramAnonymousd.aLG())
            {
              if (!Util.isNullOrNil(o.x(o.this))) {
                break label2132;
              }
              Log.w(o.f(o.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              o.a(o.this, localh);
              localh.NT((String)localObject);
              o.a(o.this, (String)localObject);
              if (o.b(o.this) != o.c(o.this)) {
                o.e(o.this).NT((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2304;
              }
              paramAnonymousString = d.bJA();
              paramAnonymousString.mxO = o.p(o.this);
              paramAnonymousString.oGa = ((ftv)c.b.b(o.o(o.this).otB));
              paramAnonymousString.oGb = localh;
              paramAnonymousString.aesKey = o.y(o.this);
              paramAnonymousString.mxU = paramAnonymousd;
              paramAnonymousString.oGc = new p.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238976);
                  Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    l.wu((int)o.b(o.this));
                    l.wt((int)o.b(o.this));
                    o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                    if (o.n(o.this) != null) {
                      o.n(o.this).bFL();
                    }
                    AppMethodBeat.o(238976);
                    return;
                  }
                  o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238976);
                }
              };
              paramAnonymousString.toUser = o.l(o.this).field_talker;
              paramAnonymousString.bKW().aXz();
              break;
              paramAnonymousInt = localh.source;
              break label948;
              l = paramAnonymousd.field_midimgLength;
              break label1178;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label2537;
              }
              if (localh.oGu == 0)
              {
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                if (paramAnonymousd.field_midimgLength == 0) {
                  l = paramAnonymousd.field_fileLength;
                }
              }
              for (paramAnonymousString = l + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                break;
                l = paramAnonymousd.field_midimgLength;
                break label1730;
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
              }
              paramAnonymousString = "<msg><img aeskey=\"" + o.x(o.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + o.x(o.this) + "\" ";
            }
            paramAnonymousString = new ux();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l = paramAnonymousString.Njv;
              Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
              if (o.a(o.this, localh, localh.osy, l, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.YFJ))
              {
                o.g(o.this).onSceneEnd(0, 0, "", o.this);
                if (o.n(o.this) != null) {
                  o.n(o.this).bFL();
                }
              }
              AppMethodBeat.o(238956);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
            }
            if (o.n(o.this) == null) {
              break;
            }
            o.n(o.this).bFL();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(238962);
        Object localObject1 = (ftv)c.b.b(o.o(o.this).otB);
        uw localuw = new uw();
        localuw.ZaC = ((ftv)localObject1).abRT.abwM;
        localuw.IMh = ((ftv)localObject1).YFE.abwM;
        localuw.IMg = ((ftv)localObject1).YFF.abwM;
        localuw.ZaD = ((ftv)localObject1).abzE;
        localuw.ZaE = ((ftv)localObject1).abzF;
        localuw.IJG = o.z(o.this);
        localuw.ZaG = o.A(o.this);
        localuw.ZaH = o.B(o.this);
        localuw.ZaI = o.C(o.this);
        localuw.YFJ = ((ftv)localObject1).YFJ;
        localuw.ZaN = o.y(o.this);
        localuw.oOI = ((ftv)localObject1).oOI;
        localuw.YCm = ((ftv)localObject1).YCm;
        localuw.YCo = ((ftv)localObject1).YCo;
        localuw.YCn = ((ftv)localObject1).YCn;
        localuw.ZaR = ((ftv)localObject1).ZaR;
        localObject1 = o.d(o.this);
        Object localObject2 = r.bKa().v(((h)localObject1).oGr, "", "");
        k.bHX();
        localuw.ZaP = com.tencent.mm.modelcdntran.d.Nt((String)localObject2);
        localuw.ZaQ = ((h)localObject1).oGv;
        int i;
        label342:
        String str;
        if (localuw.ZaQ <= 0)
        {
          if (o.p(o.this) == 4)
          {
            i = 2;
            localuw.ZaQ = i;
          }
        }
        else {
          switch (o.p(o.this))
          {
          case 3: 
          case 5: 
          default: 
            localuw.IcB = 2;
            if (localuw.ZaQ == 3) {
              localuw.IcB = 4;
            }
            Log.i(o.f(o.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localuw.ZaD), Integer.valueOf(localuw.ZaE), localuw.YFJ, localuw.IMg, localuw.ZaN, Long.valueOf(o.c(o.this)), Long.valueOf(o.D(o.this)), ((h)localObject1).oGr, localObject2, Integer.valueOf(localuw.ZaP), Integer.valueOf(localuw.ZaQ), Integer.valueOf(localuw.IcB) });
            paramAnonymousString = new com.tencent.mm.am.c.a();
            paramAnonymousString.otE = localuw;
            paramAnonymousString.otF = new ftw();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.otG = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bEF();
            localObject2 = o.E(o.this).bGg();
            str = o.f(o.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).bGa()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).bGa())) {
            break label776;
          }
          if (!w.a(((e)localObject2).sA(1), ((e)localObject2).bFZ(), ((e)localObject2).bGb(), ((com.tencent.mm.am.c)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(o.f(o.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localuw.ZaC });
          AppMethodBeat.o(238962);
          return;
          i = 1;
          break;
          localuw.IcB = 1;
          break label342;
          localuw.IcB = 3;
          break label342;
          localuw.IcB = 5;
          break label342;
        }
        label744:
        Log.e(o.f(o.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
        return;
        label776:
        Log.e(o.f(o.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(238966);
        PInt localPInt = new PInt();
        ux localux = new ux();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.am.y.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.baD().mCm.oun.bGg().sA(1), localPInt, localux);
          Log.i(o.f(o.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localux.ZaN, localux.YKw, localux.ZaC });
          o.c(o.this, localux.ZaN);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localux.ZaS);
          Log.i(o.f(o.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localux.ZaS) });
          Log.i(o.f(o.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(238966);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(o.f(o.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          o.c(o.this, null);
          AppMethodBeat.o(238966);
        }
        return null;
      }
    };
    this.mxV = false;
    Log.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.getStack() });
    this.oHT = paramInt1;
    this.mxN = paramInt1;
    this.oGu = paramInt2;
    Object localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).otE = new ftv();
    ((com.tencent.mm.am.c.a)localObject1).otF = new ftw();
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((com.tencent.mm.am.c.a)localObject1).funcId = 110;
    ((com.tencent.mm.am.c.a)localObject1).otG = 9;
    ((com.tencent.mm.am.c.a)localObject1).respCmdId = 1000000009;
    this.rr = ((com.tencent.mm.am.c.a)localObject1).bEF();
    this.oHS = null;
    Log.d(this.TAG, "FROM B SERVICE:" + this.oHT);
    if (!l.ws((int)this.oHT))
    {
      this.oHT = -1L;
      AppMethodBeat.o(150698);
      return;
    }
    localObject1 = r.bKa().b(Long.valueOf(this.oHT));
    this.oGz = ((h)localObject1).oGz;
    if (localObject1 != null)
    {
      if (paramInt2 != 1) {
        break label886;
      }
      this.mxN = ((h)localObject1).oGB;
      localObject1 = r.bKa().b(Long.valueOf(this.mxN));
    }
    label881:
    label886:
    for (;;)
    {
      Object localObject2 = r.bKa().wr((int)((h)localObject1).localId);
      if (localObject2 != null) {
        this.oGz = ((h)localObject2).oGz;
      }
      this.hzO = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.oGz);
      if ((this.hzO != null) && (this.hzO.field_msgId != this.oGz))
      {
        Log.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.oGz) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 206L, 1L, false);
        this.hzO = null;
        AppMethodBeat.o(150698);
        return;
      }
      if (this.hzO != null)
      {
        localObject2 = (ftv)c.b.b(this.rr.otB);
        ((ftv)localObject2).YFE = new etl().btH(com.tencent.mm.model.z.bAM());
        ((ftv)localObject2).YFF = new etl().btH(this.hzO.field_talker);
        ((ftv)localObject2).NkO = ((h)localObject1).offset;
        ((ftv)localObject2).NkN = ((h)localObject1).osy;
        ((ftv)localObject2).IIs = this.hzO.getType();
        ((ftv)localObject2).aava = paramInt2;
        if (!ah.eb(MMApplicationContext.getContext())) {
          break label881;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((ftv)localObject2).ZkT = paramInt1;
        ((ftv)localObject2).abFB = ((h)localObject1).source;
        ((ftv)localObject2).ZaQ = ((h)localObject1).oGv;
        ((ftv)localObject2).ZaQ = ((h)localObject1).oGv;
        ((ftv)localObject2).abzE = this.hzO.kLi;
        ((ftv)localObject2).abzF = this.hzO.kLh;
        a locala = a.NM(this.hzO.field_content);
        if ((locala != null) && (!Util.isNullOrNil(locala.appId)))
        {
          this.mxO = ((h)localObject1).source;
          ((ftv)localObject2).oOI = locala.appId;
          ((ftv)localObject2).YCm = locala.mediaTagName;
          ((ftv)localObject2).YCo = locala.messageAction;
          ((ftv)localObject2).YCn = locala.messageExt;
          this.oIs = this.hzO.field_content;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.hzO.field_talker)) {
          ((ftv)localObject2).ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(this.hzO.field_talker);
        }
        Log.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((ftv)localObject2).abzE), Integer.valueOf(((ftv)localObject2).abzF) });
        Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((h)localObject1).source), Integer.valueOf(((ftv)localObject2).ZaQ) });
        if (((h)localObject1).offset == 0) {
          this.oHW = new com.tencent.mm.modelstat.g(getType(), true, ((h)localObject1).osy);
        }
        AppMethodBeat.o(150698);
        return;
      }
    }
  }
  
  public o(int paramInt1, int paramInt2, com.tencent.mm.am.i parami)
  {
    AppMethodBeat.i(239016);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.oIm = "";
    this.oIn = "";
    this.oIo = true;
    this.oIq = 16384;
    this.oGu = 0;
    this.hzO = null;
    this.oHW = null;
    this.oHX = "";
    this.startTime = 0L;
    this.oHY = -1;
    this.mgx = 0;
    this.oIr = new a(null);
    this.oIy = false;
    this.oIA = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(238955);
        Log.e(o.f(o.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l.wu((int)o.b(o.this));
        l.wt((int)o.b(o.this));
        o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
        if (o.n(o.this) != null) {
          o.n(o.this).bFL();
        }
        AppMethodBeat.o(238955);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(238954);
        Log.i(o.f(o.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        Util.nowMilliSecond();
        o.j(o.this);
        final com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        final h localh = o.d(o.this);
        Object localObject1 = r.bKa().v(localh.oGr, "", "");
        Object localObject2 = r.bKa().v(localh.oGs, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.y.bEl(r.bKa().v(localh.oGt, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.y.bEl((String)localObject2));
        locald.field_fileLength = paramAnonymousa.fileLength;
        k.bHX();
        locald.field_filecrc = com.tencent.mm.modelcdntran.d.Nt((String)localObject1);
        localObject2 = o.k(o.this);
        localObject1 = a.NM((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = a.a((a)localObject1);; localObject1 = "")
        {
          long l;
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l = locald.field_fileLength;
              localObject1 = l + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            o.a(o.this, localh);
            localh.NT((String)localObject1);
            o.a(o.this, (String)localObject1);
            if (o.b(o.this) != o.c(o.this)) {
              o.e(o.this).NT((String)localObject1);
            }
            localObject1 = d.bJA();
            ((d)localObject1).mxO = o.p(o.this);
            ((d)localObject1).oGa = ((ftv)c.b.b(o.o(o.this).otB));
            ((d)localObject1).oGb = localh;
            ((d)localObject1).aesKey = paramAnonymousa.XPn;
            ((d)localObject1).mxU = locald;
            ((d)localObject1).oGc = new p.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(238945);
                Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  l.wu((int)o.b(o.this));
                  l.wt((int)o.b(o.this));
                  o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                  if (o.n(o.this) != null) {
                    o.n(o.this).bFL();
                  }
                  AppMethodBeat.o(238945);
                  return;
                }
                o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(238945);
              }
            };
            ((t.e)localObject1).toUser = o.l(o.this).field_talker;
            ((t.e)localObject1).bKW().aXz();
            AppMethodBeat.o(238954);
            return;
            l = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localh.oGu == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l = locald.field_fileLength;
                }
              }
              label886:
              for (localObject1 = l + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l = locald.field_midimgLength;
                break label886;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(238957);
        h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          Log.e(o.f(o.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, -5, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238957);
          return;
        }
        o.a(o.this, localh, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(238957);
      }
    };
    this.osH = new com.tencent.mm.g.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(238956);
        Log.d(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(o.f(o.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        final h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          k.bHW().Ny(o.m(o.this));
          Log.e(o.f(o.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(o.c(o.this)), o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          o.a(o.this, localh, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(o.f(o.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label896;
          }
          Log.e(o.f(o.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(o.f(o.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { o.m(o.this), Boolean.valueOf(o.q(o.this)) });
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(238979);
                o.r(o.this);
                o.s(o.this);
                o.t(o.this);
                Object localObject = o.d(o.this);
                ((h)localObject).wi(0);
                o.l(o.this).setCreateTime(br.JN(o.l(o.this).field_talker));
                o.b(o.this, com.tencent.mm.modelcdntran.h.a("upimg", o.l(o.this).getCreateTime(), o.l(o.this).field_talker, o.l(o.this).field_msgId + "_" + o.c(o.this) + "_" + o.h(o.this)));
                boolean bool = o.a(o.this, (h)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (ftv)c.b.b(o.o(o.this).otB);
                if (localObject == null) {
                  Log.w(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(o.q(o.this)), Boolean.valueOf(bool), o.m(o.this), Long.valueOf(o.l(o.this).getCreateTime()) });
                  o.this.doScene(o.u(o.this), o.g(o.this));
                  AppMethodBeat.o(238979);
                  return;
                  ((ftv)localObject).abRT = new etl().btH(o.m(o.this));
                }
              }
            });
            AppMethodBeat.o(238956);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(o.f(o.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(o.v(o.this)) });
            if (o.v(o.this))
            {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(238977);
                  o.b(o.this, o.d(o.this));
                  AppMethodBeat.o(238977);
                }
              });
              AppMethodBeat.o(238956);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new ux();
          }
        }
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          if ((paramAnonymousString != null) && (paramAnonymousString.BaseResponse.Idd != 0))
          {
            o.g(o.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Idd, paramAnonymousString.BaseResponse.akjO.toString(), o.this);
            if (o.n(o.this) != null) {
              o.n(o.this).bFL();
            }
            AppMethodBeat.o(238956);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (i.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
          }
        }
        label896:
        Log.i(o.f(o.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
        if (localh.source == 0)
        {
          paramAnonymousInt = 3;
          label948:
          paramAnonymousString.b(13230, new Object[] { Integer.valueOf(paramAnonymousInt), o.w(o.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = o.k(o.this);
          paramAnonymousc = a.NM(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label2540;
          }
        }
        label1178:
        label1730:
        label2132:
        label2537:
        label2540:
        for (paramAnonymousc = a.a(paramAnonymousc);; paramAnonymousc = "")
        {
          long l;
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l = paramAnonymousd.field_fileLength;
              paramAnonymousString = l + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            Object localObject = paramAnonymousString;
            if (paramAnonymousd.aLG())
            {
              if (!Util.isNullOrNil(o.x(o.this))) {
                break label2132;
              }
              Log.w(o.f(o.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              o.a(o.this, localh);
              localh.NT((String)localObject);
              o.a(o.this, (String)localObject);
              if (o.b(o.this) != o.c(o.this)) {
                o.e(o.this).NT((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2304;
              }
              paramAnonymousString = d.bJA();
              paramAnonymousString.mxO = o.p(o.this);
              paramAnonymousString.oGa = ((ftv)c.b.b(o.o(o.this).otB));
              paramAnonymousString.oGb = localh;
              paramAnonymousString.aesKey = o.y(o.this);
              paramAnonymousString.mxU = paramAnonymousd;
              paramAnonymousString.oGc = new p.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238976);
                  Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    l.wu((int)o.b(o.this));
                    l.wt((int)o.b(o.this));
                    o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                    if (o.n(o.this) != null) {
                      o.n(o.this).bFL();
                    }
                    AppMethodBeat.o(238976);
                    return;
                  }
                  o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238976);
                }
              };
              paramAnonymousString.toUser = o.l(o.this).field_talker;
              paramAnonymousString.bKW().aXz();
              break;
              paramAnonymousInt = localh.source;
              break label948;
              l = paramAnonymousd.field_midimgLength;
              break label1178;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label2537;
              }
              if (localh.oGu == 0)
              {
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                if (paramAnonymousd.field_midimgLength == 0) {
                  l = paramAnonymousd.field_fileLength;
                }
              }
              for (paramAnonymousString = l + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                break;
                l = paramAnonymousd.field_midimgLength;
                break label1730;
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
              }
              paramAnonymousString = "<msg><img aeskey=\"" + o.x(o.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + o.x(o.this) + "\" ";
            }
            paramAnonymousString = new ux();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l = paramAnonymousString.Njv;
              Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
              if (o.a(o.this, localh, localh.osy, l, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.YFJ))
              {
                o.g(o.this).onSceneEnd(0, 0, "", o.this);
                if (o.n(o.this) != null) {
                  o.n(o.this).bFL();
                }
              }
              AppMethodBeat.o(238956);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
            }
            if (o.n(o.this) == null) {
              break;
            }
            o.n(o.this).bFL();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(238962);
        Object localObject1 = (ftv)c.b.b(o.o(o.this).otB);
        uw localuw = new uw();
        localuw.ZaC = ((ftv)localObject1).abRT.abwM;
        localuw.IMh = ((ftv)localObject1).YFE.abwM;
        localuw.IMg = ((ftv)localObject1).YFF.abwM;
        localuw.ZaD = ((ftv)localObject1).abzE;
        localuw.ZaE = ((ftv)localObject1).abzF;
        localuw.IJG = o.z(o.this);
        localuw.ZaG = o.A(o.this);
        localuw.ZaH = o.B(o.this);
        localuw.ZaI = o.C(o.this);
        localuw.YFJ = ((ftv)localObject1).YFJ;
        localuw.ZaN = o.y(o.this);
        localuw.oOI = ((ftv)localObject1).oOI;
        localuw.YCm = ((ftv)localObject1).YCm;
        localuw.YCo = ((ftv)localObject1).YCo;
        localuw.YCn = ((ftv)localObject1).YCn;
        localuw.ZaR = ((ftv)localObject1).ZaR;
        localObject1 = o.d(o.this);
        Object localObject2 = r.bKa().v(((h)localObject1).oGr, "", "");
        k.bHX();
        localuw.ZaP = com.tencent.mm.modelcdntran.d.Nt((String)localObject2);
        localuw.ZaQ = ((h)localObject1).oGv;
        int i;
        label342:
        String str;
        if (localuw.ZaQ <= 0)
        {
          if (o.p(o.this) == 4)
          {
            i = 2;
            localuw.ZaQ = i;
          }
        }
        else {
          switch (o.p(o.this))
          {
          case 3: 
          case 5: 
          default: 
            localuw.IcB = 2;
            if (localuw.ZaQ == 3) {
              localuw.IcB = 4;
            }
            Log.i(o.f(o.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localuw.ZaD), Integer.valueOf(localuw.ZaE), localuw.YFJ, localuw.IMg, localuw.ZaN, Long.valueOf(o.c(o.this)), Long.valueOf(o.D(o.this)), ((h)localObject1).oGr, localObject2, Integer.valueOf(localuw.ZaP), Integer.valueOf(localuw.ZaQ), Integer.valueOf(localuw.IcB) });
            paramAnonymousString = new com.tencent.mm.am.c.a();
            paramAnonymousString.otE = localuw;
            paramAnonymousString.otF = new ftw();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.otG = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bEF();
            localObject2 = o.E(o.this).bGg();
            str = o.f(o.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).bGa()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).bGa())) {
            break label776;
          }
          if (!w.a(((e)localObject2).sA(1), ((e)localObject2).bFZ(), ((e)localObject2).bGb(), ((com.tencent.mm.am.c)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(o.f(o.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localuw.ZaC });
          AppMethodBeat.o(238962);
          return;
          i = 1;
          break;
          localuw.IcB = 1;
          break label342;
          localuw.IcB = 3;
          break label342;
          localuw.IcB = 5;
          break label342;
        }
        label744:
        Log.e(o.f(o.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
        return;
        label776:
        Log.e(o.f(o.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(238966);
        PInt localPInt = new PInt();
        ux localux = new ux();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.am.y.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.baD().mCm.oun.bGg().sA(1), localPInt, localux);
          Log.i(o.f(o.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localux.ZaN, localux.YKw, localux.ZaC });
          o.c(o.this, localux.ZaN);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localux.ZaS);
          Log.i(o.f(o.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localux.ZaS) });
          Log.i(o.f(o.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(238966);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(o.f(o.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          o.c(o.this, null);
          AppMethodBeat.o(238966);
        }
        return null;
      }
    };
    this.mxV = false;
    Log.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), parami, Util.getStack() });
    this.oHT = paramInt1;
    this.mxN = paramInt1;
    this.oGu = paramInt2;
    parami = new com.tencent.mm.am.c.a();
    parami.otE = new ftv();
    parami.otF = new ftw();
    parami.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    parami.funcId = 110;
    parami.otG = 9;
    parami.respCmdId = 1000000009;
    this.rr = parami.bEF();
    this.oHS = null;
    Log.d(this.TAG, "FROM C SERVICE:" + this.oHT);
    if (!l.ws((int)this.oHT))
    {
      this.oHT = -1L;
      AppMethodBeat.o(239016);
      return;
    }
    parami = r.bKa().b(Long.valueOf(this.oHT));
    this.oGz = parami.oGz;
    parami.setStatus(0);
    parami.gX(0L);
    parami.wj(0);
    r.bKa().a((int)this.mxN, parami);
    if (parami != null)
    {
      if (paramInt2 != 1) {
        break label825;
      }
      this.mxN = parami.oGB;
      parami = r.bKa().b(Long.valueOf(this.mxN));
    }
    label790:
    label820:
    label825:
    for (;;)
    {
      this.hzO = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.oGz);
      Object localObject;
      if (this.hzO != null)
      {
        this.hzO.setStatus(1);
        localObject = parami.oGt;
        if ((localObject == null) || (!((String)localObject).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label790;
        }
        this.hzO.BT((String)localObject);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.oGz, this.hzO);
        localObject = (ftv)c.b.b(this.rr.otB);
        ((ftv)localObject).YFE = new etl().btH(com.tencent.mm.model.z.bAM());
        ((ftv)localObject).YFF = new etl().btH(this.hzO.field_talker);
        ((ftv)localObject).NkO = parami.offset;
        ((ftv)localObject).NkN = parami.osy;
        ((ftv)localObject).IIs = this.hzO.getType();
        ((ftv)localObject).aava = paramInt2;
        if (!ah.eb(MMApplicationContext.getContext())) {
          break label820;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((ftv)localObject).ZkT = paramInt1;
        ((ftv)localObject).abFB = parami.source;
        ((ftv)localObject).ZaQ = parami.oGv;
        ((ftv)localObject).abzE = this.hzO.kLi;
        ((ftv)localObject).abzF = this.hzO.kLh;
        if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.hzO.field_talker)) {
          ((ftv)localObject).ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(this.hzO.field_talker);
        }
        Log.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((ftv)localObject).abzE), Integer.valueOf(((ftv)localObject).abzF) });
        Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(parami.source), Integer.valueOf(((ftv)localObject).ZaQ) });
        if (parami.offset == 0) {
          this.oHW = new com.tencent.mm.modelstat.g(getType(), true, parami.osy);
        }
        AppMethodBeat.o(239016);
        return;
        this.hzO.BT("THUMBNAIL://" + parami.localId);
        break;
      }
    }
  }
  
  public o(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.am.i parami)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, parami, 0, "", "");
  }
  
  public o(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.am.i parami, int paramInt3, com.tencent.mm.am.m paramm, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, parami, paramInt3, "", "", true, paramInt4);
    AppMethodBeat.i(238984);
    this.oIr = new a(paramm);
    AppMethodBeat.o(238984);
  }
  
  public o(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.am.i parami, int paramInt3, String paramString4, String paramString5)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, parami, paramInt3, paramString4, paramString5, false, -1);
  }
  
  public o(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.am.i parami, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, parami, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, 0L, null);
  }
  
  public o(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.am.i parami, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, long paramLong, String paramString6)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, parami, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, paramLong, paramString6);
  }
  
  public o(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.am.i parami, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2, int paramInt5, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, String paramString6)
  {
    AppMethodBeat.i(239000);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.oIm = "";
    this.oIn = "";
    this.oIo = true;
    this.oIq = 16384;
    this.oGu = 0;
    this.hzO = null;
    this.oHW = null;
    this.oHX = "";
    this.startTime = 0L;
    this.oHY = -1;
    this.mgx = 0;
    this.oIr = new a(null);
    this.oIy = false;
    this.oIA = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(238955);
        Log.e(o.f(o.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l.wu((int)o.b(o.this));
        l.wt((int)o.b(o.this));
        o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
        if (o.n(o.this) != null) {
          o.n(o.this).bFL();
        }
        AppMethodBeat.o(238955);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(238954);
        Log.i(o.f(o.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        Util.nowMilliSecond();
        o.j(o.this);
        final com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        final h localh = o.d(o.this);
        Object localObject1 = r.bKa().v(localh.oGr, "", "");
        Object localObject2 = r.bKa().v(localh.oGs, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.y.bEl(r.bKa().v(localh.oGt, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.y.bEl((String)localObject2));
        locald.field_fileLength = paramAnonymousa.fileLength;
        k.bHX();
        locald.field_filecrc = com.tencent.mm.modelcdntran.d.Nt((String)localObject1);
        localObject2 = o.k(o.this);
        localObject1 = a.NM((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = a.a((a)localObject1);; localObject1 = "")
        {
          long l;
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l = locald.field_fileLength;
              localObject1 = l + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            o.a(o.this, localh);
            localh.NT((String)localObject1);
            o.a(o.this, (String)localObject1);
            if (o.b(o.this) != o.c(o.this)) {
              o.e(o.this).NT((String)localObject1);
            }
            localObject1 = d.bJA();
            ((d)localObject1).mxO = o.p(o.this);
            ((d)localObject1).oGa = ((ftv)c.b.b(o.o(o.this).otB));
            ((d)localObject1).oGb = localh;
            ((d)localObject1).aesKey = paramAnonymousa.XPn;
            ((d)localObject1).mxU = locald;
            ((d)localObject1).oGc = new p.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(238945);
                Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  l.wu((int)o.b(o.this));
                  l.wt((int)o.b(o.this));
                  o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                  if (o.n(o.this) != null) {
                    o.n(o.this).bFL();
                  }
                  AppMethodBeat.o(238945);
                  return;
                }
                o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(238945);
              }
            };
            ((t.e)localObject1).toUser = o.l(o.this).field_talker;
            ((t.e)localObject1).bKW().aXz();
            AppMethodBeat.o(238954);
            return;
            l = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localh.oGu == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l = locald.field_fileLength;
                }
              }
              label886:
              for (localObject1 = l + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l = locald.field_midimgLength;
                break label886;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(238957);
        h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          Log.e(o.f(o.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, -5, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238957);
          return;
        }
        o.a(o.this, localh, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(238957);
      }
    };
    this.osH = new com.tencent.mm.g.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(238956);
        Log.d(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(o.f(o.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        final h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          k.bHW().Ny(o.m(o.this));
          Log.e(o.f(o.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(o.c(o.this)), o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          o.a(o.this, localh, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(o.f(o.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label896;
          }
          Log.e(o.f(o.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(o.f(o.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { o.m(o.this), Boolean.valueOf(o.q(o.this)) });
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(238979);
                o.r(o.this);
                o.s(o.this);
                o.t(o.this);
                Object localObject = o.d(o.this);
                ((h)localObject).wi(0);
                o.l(o.this).setCreateTime(br.JN(o.l(o.this).field_talker));
                o.b(o.this, com.tencent.mm.modelcdntran.h.a("upimg", o.l(o.this).getCreateTime(), o.l(o.this).field_talker, o.l(o.this).field_msgId + "_" + o.c(o.this) + "_" + o.h(o.this)));
                boolean bool = o.a(o.this, (h)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (ftv)c.b.b(o.o(o.this).otB);
                if (localObject == null) {
                  Log.w(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(o.q(o.this)), Boolean.valueOf(bool), o.m(o.this), Long.valueOf(o.l(o.this).getCreateTime()) });
                  o.this.doScene(o.u(o.this), o.g(o.this));
                  AppMethodBeat.o(238979);
                  return;
                  ((ftv)localObject).abRT = new etl().btH(o.m(o.this));
                }
              }
            });
            AppMethodBeat.o(238956);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(o.f(o.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(o.v(o.this)) });
            if (o.v(o.this))
            {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(238977);
                  o.b(o.this, o.d(o.this));
                  AppMethodBeat.o(238977);
                }
              });
              AppMethodBeat.o(238956);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new ux();
          }
        }
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          if ((paramAnonymousString != null) && (paramAnonymousString.BaseResponse.Idd != 0))
          {
            o.g(o.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Idd, paramAnonymousString.BaseResponse.akjO.toString(), o.this);
            if (o.n(o.this) != null) {
              o.n(o.this).bFL();
            }
            AppMethodBeat.o(238956);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (i.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
          }
        }
        label896:
        Log.i(o.f(o.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
        if (localh.source == 0)
        {
          paramAnonymousInt = 3;
          label948:
          paramAnonymousString.b(13230, new Object[] { Integer.valueOf(paramAnonymousInt), o.w(o.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = o.k(o.this);
          paramAnonymousc = a.NM(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label2540;
          }
        }
        label1178:
        label1730:
        label2132:
        label2537:
        label2540:
        for (paramAnonymousc = a.a(paramAnonymousc);; paramAnonymousc = "")
        {
          long l;
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l = paramAnonymousd.field_fileLength;
              paramAnonymousString = l + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            Object localObject = paramAnonymousString;
            if (paramAnonymousd.aLG())
            {
              if (!Util.isNullOrNil(o.x(o.this))) {
                break label2132;
              }
              Log.w(o.f(o.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              o.a(o.this, localh);
              localh.NT((String)localObject);
              o.a(o.this, (String)localObject);
              if (o.b(o.this) != o.c(o.this)) {
                o.e(o.this).NT((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2304;
              }
              paramAnonymousString = d.bJA();
              paramAnonymousString.mxO = o.p(o.this);
              paramAnonymousString.oGa = ((ftv)c.b.b(o.o(o.this).otB));
              paramAnonymousString.oGb = localh;
              paramAnonymousString.aesKey = o.y(o.this);
              paramAnonymousString.mxU = paramAnonymousd;
              paramAnonymousString.oGc = new p.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238976);
                  Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    l.wu((int)o.b(o.this));
                    l.wt((int)o.b(o.this));
                    o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                    if (o.n(o.this) != null) {
                      o.n(o.this).bFL();
                    }
                    AppMethodBeat.o(238976);
                    return;
                  }
                  o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238976);
                }
              };
              paramAnonymousString.toUser = o.l(o.this).field_talker;
              paramAnonymousString.bKW().aXz();
              break;
              paramAnonymousInt = localh.source;
              break label948;
              l = paramAnonymousd.field_midimgLength;
              break label1178;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label2537;
              }
              if (localh.oGu == 0)
              {
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                if (paramAnonymousd.field_midimgLength == 0) {
                  l = paramAnonymousd.field_fileLength;
                }
              }
              for (paramAnonymousString = l + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                break;
                l = paramAnonymousd.field_midimgLength;
                break label1730;
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
              }
              paramAnonymousString = "<msg><img aeskey=\"" + o.x(o.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + o.x(o.this) + "\" ";
            }
            paramAnonymousString = new ux();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l = paramAnonymousString.Njv;
              Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
              if (o.a(o.this, localh, localh.osy, l, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.YFJ))
              {
                o.g(o.this).onSceneEnd(0, 0, "", o.this);
                if (o.n(o.this) != null) {
                  o.n(o.this).bFL();
                }
              }
              AppMethodBeat.o(238956);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
            }
            if (o.n(o.this) == null) {
              break;
            }
            o.n(o.this).bFL();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(238962);
        Object localObject1 = (ftv)c.b.b(o.o(o.this).otB);
        uw localuw = new uw();
        localuw.ZaC = ((ftv)localObject1).abRT.abwM;
        localuw.IMh = ((ftv)localObject1).YFE.abwM;
        localuw.IMg = ((ftv)localObject1).YFF.abwM;
        localuw.ZaD = ((ftv)localObject1).abzE;
        localuw.ZaE = ((ftv)localObject1).abzF;
        localuw.IJG = o.z(o.this);
        localuw.ZaG = o.A(o.this);
        localuw.ZaH = o.B(o.this);
        localuw.ZaI = o.C(o.this);
        localuw.YFJ = ((ftv)localObject1).YFJ;
        localuw.ZaN = o.y(o.this);
        localuw.oOI = ((ftv)localObject1).oOI;
        localuw.YCm = ((ftv)localObject1).YCm;
        localuw.YCo = ((ftv)localObject1).YCo;
        localuw.YCn = ((ftv)localObject1).YCn;
        localuw.ZaR = ((ftv)localObject1).ZaR;
        localObject1 = o.d(o.this);
        Object localObject2 = r.bKa().v(((h)localObject1).oGr, "", "");
        k.bHX();
        localuw.ZaP = com.tencent.mm.modelcdntran.d.Nt((String)localObject2);
        localuw.ZaQ = ((h)localObject1).oGv;
        int i;
        label342:
        String str;
        if (localuw.ZaQ <= 0)
        {
          if (o.p(o.this) == 4)
          {
            i = 2;
            localuw.ZaQ = i;
          }
        }
        else {
          switch (o.p(o.this))
          {
          case 3: 
          case 5: 
          default: 
            localuw.IcB = 2;
            if (localuw.ZaQ == 3) {
              localuw.IcB = 4;
            }
            Log.i(o.f(o.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localuw.ZaD), Integer.valueOf(localuw.ZaE), localuw.YFJ, localuw.IMg, localuw.ZaN, Long.valueOf(o.c(o.this)), Long.valueOf(o.D(o.this)), ((h)localObject1).oGr, localObject2, Integer.valueOf(localuw.ZaP), Integer.valueOf(localuw.ZaQ), Integer.valueOf(localuw.IcB) });
            paramAnonymousString = new com.tencent.mm.am.c.a();
            paramAnonymousString.otE = localuw;
            paramAnonymousString.otF = new ftw();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.otG = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bEF();
            localObject2 = o.E(o.this).bGg();
            str = o.f(o.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).bGa()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).bGa())) {
            break label776;
          }
          if (!w.a(((e)localObject2).sA(1), ((e)localObject2).bFZ(), ((e)localObject2).bGb(), ((com.tencent.mm.am.c)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(o.f(o.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localuw.ZaC });
          AppMethodBeat.o(238962);
          return;
          i = 1;
          break;
          localuw.IcB = 1;
          break label342;
          localuw.IcB = 3;
          break label342;
          localuw.IcB = 5;
          break label342;
        }
        label744:
        Log.e(o.f(o.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
        return;
        label776:
        Log.e(o.f(o.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(238966);
        PInt localPInt = new PInt();
        ux localux = new ux();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.am.y.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.baD().mCm.oun.bGg().sA(1), localPInt, localux);
          Log.i(o.f(o.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localux.ZaN, localux.YKw, localux.ZaC });
          o.c(o.this, localux.ZaN);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localux.ZaS);
          Log.i(o.f(o.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localux.ZaS) });
          Log.i(o.f(o.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(238966);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(o.f(o.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          o.c(o.this, null);
          AppMethodBeat.o(238966);
        }
        return null;
      }
    };
    this.mxV = false;
    Log.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), parami, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), Util.getStack(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.oIu = paramBoolean1;
    this.oIb = paramInt4;
    this.oHS = parami;
    this.oGu = paramInt2;
    this.scene = paramInt5;
    this.latitude = paramFloat2;
    this.longtitude = paramFloat1;
    this.mxO = paramInt1;
    this.oIx = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.oIs = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong1 > 0L)
    {
      paramString5 = r.bKa().b(Long.valueOf(paramLong1));
      paramString5 = r.bKa().v(paramString5.oGw, "", "");
    }
    if (paramLong2 > 0L)
    {
      paramString6 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong2);
      if (paramString6 != null) {
        this.oIz = bt.JV(paramString6.jUr);
      }
    }
    try
    {
      for (;;)
      {
        this.oHT = r.bKa().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
        this.mxN = this.oHT;
        Log.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.oHT);
        if ((!paramBoolean2) || ((this.oHT >= 0L) && (l.ws((int)this.oHT)))) {
          break;
        }
        Log.e(this.TAG, "insert to img storage failed id:" + this.oHT);
        this.oGz = -1L;
        this.rr = null;
        AppMethodBeat.o(239000);
        return;
        if (!Util.isNullOrNil(paramString6)) {
          this.oIz = paramString6;
        }
      }
    }
    catch (SQLiteException paramString6)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 182L, 1L, false);
        if (!paramString6.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        r.bKa().bJH();
        Log.e(this.TAG, "fallback to insert");
        this.oHT = r.bKa().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
      }
      AppMethodBeat.o(239000);
      throw paramString6;
    }
    if (this.oHT >= 0L)
    {
      paramBoolean1 = true;
      Assert.assertTrue(paramBoolean1);
      paramString3 = new com.tencent.mm.am.c.a();
      paramString3.otE = new ftv();
      paramString3.otF = new ftw();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.otG = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.bEF();
      this.hgl = paramString2;
      this.hzO = new cc();
      this.hzO.setType(ab.IY(paramString2));
      this.hzO.BS(paramString2);
      this.hzO.pI(1);
      this.hzO.setStatus(1);
      this.hzO.BT(localPString.value);
      this.hzO.pW(localPInt1.value);
      this.hzO.pX(localPInt2.value);
      this.hzO.setCreateTime(br.JN(this.hzO.field_talker));
      this.hzO.setContent(paramString4);
      a.a.aOb().n(this.hzO);
    }
    label1646:
    label1652:
    label1657:
    for (;;)
    {
      try
      {
        this.oGz = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().c(this.hzO, true);
        if (this.oGz >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.oGz);
          paramString3 = bJL();
          paramString3.iP((int)this.oGz);
          r.bKa().a(Long.valueOf(this.oHT), paramString3);
          if (paramInt2 != 1) {
            break label1657;
          }
          this.mxN = paramString3.oGB;
          paramString3 = bJK();
          paramString3.wk((int)com.tencent.mm.vfs.y.bEl(r.bKa().v(paramString3.oGr, "", "")));
          r.bKa().a(Long.valueOf(this.mxN), paramString3);
          Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.mxN + " img len = " + paramString3.osy);
          paramString5 = (ftv)c.b.b(this.rr.otB);
          paramString5.YFE = new etl().btH(paramString1);
          paramString5.YFF = new etl().btH(paramString2);
          paramString5.NkO = paramString3.offset;
          paramString5.NkN = paramString3.osy;
          paramString5.IIs = this.hzO.getType();
          paramString5.aava = paramInt2;
          if (!ah.eb(MMApplicationContext.getContext())) {
            break label1646;
          }
          paramInt3 = 1;
          paramString5.ZkT = paramInt3;
          paramString5.abFB = paramString3.source;
          paramString5.ZaQ = paramString3.oGv;
          paramString5.abzE = localPInt2.value;
          paramString5.abzF = localPInt1.value;
          paramString1 = a.NM(paramString4);
          if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.appId)))
          {
            paramString5.oOI = paramString1.appId;
            paramString5.YCm = paramString1.mediaTagName;
            paramString5.YCo = paramString1.messageAction;
            paramString5.YCn = paramString1.messageExt;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(paramString2)) {
            paramString5.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(paramString2);
          }
          Log.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.abzE), Integer.valueOf(paramString5.abzF) });
          if (paramString5.ZaQ == 0)
          {
            if (paramInt1 != 4) {
              break label1652;
            }
            paramInt1 = 2;
            paramString5.ZaQ = paramInt1;
          }
          Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString5.ZaQ) });
          if (paramString3.offset == 0) {
            this.oHW = new com.tencent.mm.modelstat.g(getType(), true, paramString3.osy);
          }
          paramLong1 = System.currentTimeMillis();
          wv(paramInt2);
          Log.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong1) });
          if (parami != null) {
            MMHandlerThread.postToMainThread(new o.2(this, parami, paramString3.offset, paramString3.osy));
          }
          AppMethodBeat.o(239000);
          return;
          paramBoolean1 = false;
        }
      }
      catch (SQLiteException paramString3)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 182L, 1L, false);
        if (paramString3.toString().contains("UNIQUE constraint failed"))
        {
          Log.e(this.TAG, "fallback to insert");
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().gbj();
          this.oGz = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().c(this.hzO, true);
          continue;
        }
        AppMethodBeat.o(239000);
        throw paramString3;
      }
      paramBoolean1 = false;
      continue;
      paramInt3 = 2;
      continue;
      paramInt1 = 1;
    }
  }
  
  public o(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.am.i parami, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(239007);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.oIm = "";
    this.oIn = "";
    this.oIo = true;
    this.oIq = 16384;
    this.oGu = 0;
    this.hzO = null;
    this.oHW = null;
    this.oHX = "";
    this.startTime = 0L;
    this.oHY = -1;
    this.mgx = 0;
    this.oIr = new a(null);
    this.oIy = false;
    this.oIA = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(238955);
        Log.e(o.f(o.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l.wu((int)o.b(o.this));
        l.wt((int)o.b(o.this));
        o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
        if (o.n(o.this) != null) {
          o.n(o.this).bFL();
        }
        AppMethodBeat.o(238955);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(238954);
        Log.i(o.f(o.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        Util.nowMilliSecond();
        o.j(o.this);
        final com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        final h localh = o.d(o.this);
        Object localObject1 = r.bKa().v(localh.oGr, "", "");
        Object localObject2 = r.bKa().v(localh.oGs, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.y.bEl(r.bKa().v(localh.oGt, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.y.bEl((String)localObject2));
        locald.field_fileLength = paramAnonymousa.fileLength;
        k.bHX();
        locald.field_filecrc = com.tencent.mm.modelcdntran.d.Nt((String)localObject1);
        localObject2 = o.k(o.this);
        localObject1 = a.NM((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = a.a((a)localObject1);; localObject1 = "")
        {
          long l;
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l = locald.field_fileLength;
              localObject1 = l + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            o.a(o.this, localh);
            localh.NT((String)localObject1);
            o.a(o.this, (String)localObject1);
            if (o.b(o.this) != o.c(o.this)) {
              o.e(o.this).NT((String)localObject1);
            }
            localObject1 = d.bJA();
            ((d)localObject1).mxO = o.p(o.this);
            ((d)localObject1).oGa = ((ftv)c.b.b(o.o(o.this).otB));
            ((d)localObject1).oGb = localh;
            ((d)localObject1).aesKey = paramAnonymousa.XPn;
            ((d)localObject1).mxU = locald;
            ((d)localObject1).oGc = new p.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(238945);
                Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  l.wu((int)o.b(o.this));
                  l.wt((int)o.b(o.this));
                  o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                  if (o.n(o.this) != null) {
                    o.n(o.this).bFL();
                  }
                  AppMethodBeat.o(238945);
                  return;
                }
                o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(238945);
              }
            };
            ((t.e)localObject1).toUser = o.l(o.this).field_talker;
            ((t.e)localObject1).bKW().aXz();
            AppMethodBeat.o(238954);
            return;
            l = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localh.oGu == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l = locald.field_fileLength;
                }
              }
              label886:
              for (localObject1 = l + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l = locald.field_midimgLength;
                break label886;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(238957);
        h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          Log.e(o.f(o.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, -5, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238957);
          return;
        }
        o.a(o.this, localh, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(238957);
      }
    };
    this.osH = new com.tencent.mm.g.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(238956);
        Log.d(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(o.f(o.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e(o.f(o.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousInt) });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, paramAnonymousInt, "", o.this);
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        final h localh = o.d(o.this);
        if ((localh == null) || (localh.localId != o.c(o.this)))
        {
          k.bHW().Ny(o.m(o.this));
          Log.e(o.f(o.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(o.c(o.this)), o.m(o.this) });
          if (o.n(o.this) != null) {
            o.n(o.this).bFL();
          }
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          o.a(o.this, localh, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(238956);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(o.f(o.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label896;
          }
          Log.e(o.f(o.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(o.f(o.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { o.m(o.this), Boolean.valueOf(o.q(o.this)) });
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(238979);
                o.r(o.this);
                o.s(o.this);
                o.t(o.this);
                Object localObject = o.d(o.this);
                ((h)localObject).wi(0);
                o.l(o.this).setCreateTime(br.JN(o.l(o.this).field_talker));
                o.b(o.this, com.tencent.mm.modelcdntran.h.a("upimg", o.l(o.this).getCreateTime(), o.l(o.this).field_talker, o.l(o.this).field_msgId + "_" + o.c(o.this) + "_" + o.h(o.this)));
                boolean bool = o.a(o.this, (h)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (ftv)c.b.b(o.o(o.this).otB);
                if (localObject == null) {
                  Log.w(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(o.f(o.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(o.q(o.this)), Boolean.valueOf(bool), o.m(o.this), Long.valueOf(o.l(o.this).getCreateTime()) });
                  o.this.doScene(o.u(o.this), o.g(o.this));
                  AppMethodBeat.o(238979);
                  return;
                  ((ftv)localObject).abRT = new etl().btH(o.m(o.this));
                }
              }
            });
            AppMethodBeat.o(238956);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(o.f(o.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(o.v(o.this)) });
            if (o.v(o.this))
            {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(238977);
                  o.b(o.this, o.d(o.this));
                  AppMethodBeat.o(238977);
                }
              });
              AppMethodBeat.o(238956);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new ux();
          }
        }
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          if ((paramAnonymousString != null) && (paramAnonymousString.BaseResponse.Idd != 0))
          {
            o.g(o.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Idd, paramAnonymousString.BaseResponse.akjO.toString(), o.this);
            if (o.n(o.this) != null) {
              o.n(o.this).bFL();
            }
            AppMethodBeat.o(238956);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (i.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(o.f(o.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
          }
        }
        label896:
        Log.i(o.f(o.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
        if (localh.source == 0)
        {
          paramAnonymousInt = 3;
          label948:
          paramAnonymousString.b(13230, new Object[] { Integer.valueOf(paramAnonymousInt), o.w(o.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = o.k(o.this);
          paramAnonymousc = a.NM(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label2540;
          }
        }
        label1178:
        label1730:
        label2132:
        label2537:
        label2540:
        for (paramAnonymousc = a.a(paramAnonymousc);; paramAnonymousc = "")
        {
          long l;
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l = paramAnonymousd.field_fileLength;
              paramAnonymousString = l + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(o.f(o.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            Object localObject = paramAnonymousString;
            if (paramAnonymousd.aLG())
            {
              if (!Util.isNullOrNil(o.x(o.this))) {
                break label2132;
              }
              Log.w(o.f(o.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              o.a(o.this, localh);
              localh.NT((String)localObject);
              o.a(o.this, (String)localObject);
              if (o.b(o.this) != o.c(o.this)) {
                o.e(o.this).NT((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2304;
              }
              paramAnonymousString = d.bJA();
              paramAnonymousString.mxO = o.p(o.this);
              paramAnonymousString.oGa = ((ftv)c.b.b(o.o(o.this).otB));
              paramAnonymousString.oGb = localh;
              paramAnonymousString.aesKey = o.y(o.this);
              paramAnonymousString.mxU = paramAnonymousd;
              paramAnonymousString.oGc = new p.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238976);
                  Log.i(o.f(o.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { o.m(o.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    l.wu((int)o.b(o.this));
                    l.wt((int)o.b(o.this));
                    o.g(o.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", o.this);
                    if (o.n(o.this) != null) {
                      o.n(o.this).bFL();
                    }
                    AppMethodBeat.o(238976);
                    return;
                  }
                  o.a(o.this, localh, localh.osy, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238976);
                }
              };
              paramAnonymousString.toUser = o.l(o.this).field_talker;
              paramAnonymousString.bKW().aXz();
              break;
              paramAnonymousInt = localh.source;
              break label948;
              l = paramAnonymousd.field_midimgLength;
              break label1178;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label2537;
              }
              if (localh.oGu == 0)
              {
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                if (paramAnonymousd.field_midimgLength == 0) {
                  l = paramAnonymousd.field_fileLength;
                }
              }
              for (paramAnonymousString = l + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                Log.i(o.f(o.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                break;
                l = paramAnonymousd.field_midimgLength;
                break label1730;
                paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
              }
              paramAnonymousString = "<msg><img aeskey=\"" + o.x(o.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
              paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + o.x(o.this) + "\" ";
            }
            paramAnonymousString = new ux();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l = paramAnonymousString.Njv;
              Log.d(o.f(o.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Idd), paramAnonymousString.BaseResponse.akjO.toString() });
              if (o.a(o.this, localh, localh.osy, l, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.YFJ))
              {
                o.g(o.this).onSceneEnd(0, 0, "", o.this);
                if (o.n(o.this) != null) {
                  o.n(o.this).bFL();
                }
              }
              AppMethodBeat.o(238956);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(o.f(o.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(o.f(o.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              o.g(o.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", o.this);
            }
            if (o.n(o.this) == null) {
              break;
            }
            o.n(o.this).bFL();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(238962);
        Object localObject1 = (ftv)c.b.b(o.o(o.this).otB);
        uw localuw = new uw();
        localuw.ZaC = ((ftv)localObject1).abRT.abwM;
        localuw.IMh = ((ftv)localObject1).YFE.abwM;
        localuw.IMg = ((ftv)localObject1).YFF.abwM;
        localuw.ZaD = ((ftv)localObject1).abzE;
        localuw.ZaE = ((ftv)localObject1).abzF;
        localuw.IJG = o.z(o.this);
        localuw.ZaG = o.A(o.this);
        localuw.ZaH = o.B(o.this);
        localuw.ZaI = o.C(o.this);
        localuw.YFJ = ((ftv)localObject1).YFJ;
        localuw.ZaN = o.y(o.this);
        localuw.oOI = ((ftv)localObject1).oOI;
        localuw.YCm = ((ftv)localObject1).YCm;
        localuw.YCo = ((ftv)localObject1).YCo;
        localuw.YCn = ((ftv)localObject1).YCn;
        localuw.ZaR = ((ftv)localObject1).ZaR;
        localObject1 = o.d(o.this);
        Object localObject2 = r.bKa().v(((h)localObject1).oGr, "", "");
        k.bHX();
        localuw.ZaP = com.tencent.mm.modelcdntran.d.Nt((String)localObject2);
        localuw.ZaQ = ((h)localObject1).oGv;
        int i;
        label342:
        String str;
        if (localuw.ZaQ <= 0)
        {
          if (o.p(o.this) == 4)
          {
            i = 2;
            localuw.ZaQ = i;
          }
        }
        else {
          switch (o.p(o.this))
          {
          case 3: 
          case 5: 
          default: 
            localuw.IcB = 2;
            if (localuw.ZaQ == 3) {
              localuw.IcB = 4;
            }
            Log.i(o.f(o.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localuw.ZaD), Integer.valueOf(localuw.ZaE), localuw.YFJ, localuw.IMg, localuw.ZaN, Long.valueOf(o.c(o.this)), Long.valueOf(o.D(o.this)), ((h)localObject1).oGr, localObject2, Integer.valueOf(localuw.ZaP), Integer.valueOf(localuw.ZaQ), Integer.valueOf(localuw.IcB) });
            paramAnonymousString = new com.tencent.mm.am.c.a();
            paramAnonymousString.otE = localuw;
            paramAnonymousString.otF = new ftw();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.otG = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bEF();
            localObject2 = o.E(o.this).bGg();
            str = o.f(o.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).bGa()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).bGa())) {
            break label776;
          }
          if (!w.a(((e)localObject2).sA(1), ((e)localObject2).bFZ(), ((e)localObject2).bGb(), ((com.tencent.mm.am.c)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(o.f(o.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localuw.ZaC });
          AppMethodBeat.o(238962);
          return;
          i = 1;
          break;
          localuw.IcB = 1;
          break label342;
          localuw.IcB = 3;
          break label342;
          localuw.IcB = 5;
          break label342;
        }
        label744:
        Log.e(o.f(o.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
        return;
        label776:
        Log.e(o.f(o.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localuw.ZaC });
        AppMethodBeat.o(238962);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(238966);
        PInt localPInt = new PInt();
        ux localux = new ux();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.am.y.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.baD().mCm.oun.bGg().sA(1), localPInt, localux);
          Log.i(o.f(o.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localux.ZaN, localux.YKw, localux.ZaC });
          o.c(o.this, localux.ZaN);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localux.ZaS);
          Log.i(o.f(o.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localux.ZaS) });
          Log.i(o.f(o.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(238966);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(o.f(o.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          o.c(o.this, null);
          AppMethodBeat.o(238966);
        }
        return null;
      }
    };
    this.mxV = false;
    Log.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), parami, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), Util.getStack() });
    this.oIu = paramBoolean1;
    this.oIb = paramInt4;
    this.oHS = parami;
    this.oGu = paramInt2;
    this.mxO = paramInt1;
    this.oIx = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.oIs = paramString4;
    this.oHT = paramLong;
    this.mxN = this.oHT;
    paramString3 = bJL();
    this.hzO = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramString3.oGz);
    this.oGz = this.hzO.field_msgId;
    localPInt.value = this.hzO.kLi;
    paramString5.value = this.hzO.kLh;
    if (paramInt2 == 1)
    {
      this.mxN = paramString3.oGB;
      this.mxP = null;
      paramString3 = bJK();
    }
    for (;;)
    {
      if ((this.hzO.field_talker != null) && (!this.hzO.field_talker.equals(paramString2)))
      {
        Log.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.hzO.field_talker });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.hzO.field_talker;; paramString4 = paramString2)
      {
        Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hzO.field_msgId);
        Log.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.oHT);
        if ((paramBoolean2) && ((this.oHT < 0L) || (!l.ws((int)this.oHT))))
        {
          Log.e(this.TAG, "insert to img storage failed id:" + this.oHT);
          this.oGz = -1L;
          this.rr = null;
          AppMethodBeat.o(239007);
          return;
        }
        if (this.oHT >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          paramString2 = new com.tencent.mm.am.c.a();
          paramString2.otE = new ftv();
          paramString2.otF = new ftw();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.otG = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.bEF();
          Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.mxN + " img len = " + paramString3.osy);
          paramString2 = (ftv)c.b.b(this.rr.otB);
          paramString2.YFE = new etl().btH(paramString1);
          paramString2.YFF = new etl().btH(paramString4);
          paramString2.NkO = paramString3.offset;
          paramString2.NkN = paramString3.osy;
          paramString2.IIs = this.hzO.getType();
          paramString2.aava = paramInt2;
          if (!ah.eb(MMApplicationContext.getContext())) {
            break label1109;
          }
          paramInt2 = 1;
          label853:
          paramString2.ZkT = paramInt2;
          paramString2.abFB = paramString3.source;
          paramString2.ZaQ = paramString3.oGv;
          paramString2.abzE = localPInt.value;
          paramString2.abzF = paramString5.value;
          Log.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.abzE), Integer.valueOf(paramString2.abzF) });
          if (paramString2.ZaQ == 0) {
            if (paramInt1 != 4) {
              break label1115;
            }
          }
        }
        label1109:
        label1115:
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString2.ZaQ = paramInt1;
          if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(paramString4)) {
            paramString2.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(paramString4);
          }
          Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString2.ZaQ) });
          if (paramString3.offset == 0) {
            this.oHW = new com.tencent.mm.modelstat.g(getType(), true, paramString3.osy);
          }
          if (parami != null) {
            MMHandlerThread.postToMainThread(new o.3(this, parami, paramString3.offset, paramString3.osy));
          }
          AppMethodBeat.o(239007);
          return;
          paramBoolean1 = false;
          break;
          paramInt2 = 2;
          break label853;
        }
      }
    }
  }
  
  private boolean a(h paramh, int paramInt)
  {
    AppMethodBeat.i(150700);
    String str3 = this.hzO.field_talker;
    if (ab.IW(str3))
    {
      Log.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { str3 });
      AppMethodBeat.o(150700);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.g.b.iGQ())
    {
      Log.i(this.TAG, "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(150700);
      return false;
    }
    k.bHW();
    if ((!com.tencent.mm.modelcdntran.g.vV(1)) && (Util.isNullOrNil(paramh.oGC)))
    {
      localObject = this.TAG;
      k.bHW();
      Log.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(1)), paramh.oGC });
      AppMethodBeat.o(150700);
      return false;
    }
    if (Util.isNullOrNil(this.oHX))
    {
      Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.mxN) });
      AppMethodBeat.o(150700);
      return false;
    }
    String str2 = r.bKa().v(paramh.oGr, "", "");
    String str1 = r.bKa().v(paramh.oGs, "", "");
    String str4 = r.bKa().v(paramh.oGt, "", "");
    Object localObject = r.bKa().v(paramh.oGw, "", "");
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_NetSceneUploadMsgImg";
    localg.lwL = this.osH;
    localg.field_mediaId = this.oHX;
    localg.field_fileType = this.mgx;
    localg.field_talker = str3;
    int i;
    boolean bool1;
    if (au.bwE(str3))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.g.a.lvZ;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      if (au.bwZ(this.hzO.field_talker)) {
        break label1010;
      }
      bool1 = true;
      label351:
      localg.field_sendmsg_viacdn = bool1;
      if ((au.bwZ(this.hzO.field_talker)) || (!this.oIo)) {
        break label1016;
      }
      bool1 = true;
      label381:
      localg.field_enable_hitcheck = bool1;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      Log.i(this.TAG, "field_sendmsg_viacdn=%s talker=%s", new Object[] { Boolean.valueOf(localg.field_sendmsg_viacdn), str3 });
      if (paramInt != -5103237) {
        break label1022;
      }
      this.oHX = com.tencent.mm.modelcdntran.h.a("upimgjpg", this.hzO.getCreateTime(), str3, this.hzO.field_msgId + "_" + this.mxN + "_" + this.oGu);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.oHX;
      this.oIy = false;
      if (!this.oIy)
      {
        bool1 = ImgUtil.isWXGF(str4);
        Log.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", new Object[] { Boolean.valueOf(bool1) });
      }
      if ((localg.field_fileType == com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE) && (Util.isNullOrNil(localg.field_midimgpath)))
      {
        k.bHW();
        if (!com.tencent.mm.modelcdntran.g.vV(256))
        {
          Log.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = XmlParser.parseXml(this.oIs, "msg", null);
      if (localObject == null) {
        break label1477;
      }
      if (this.oGu == 1) {
        break label1428;
      }
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"));
      localg.field_midFileLength = Util.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      label708:
      localg.field_aesKey = ((String)((Map)localObject).get(".msg.img.$aeskey"));
    }
    for (;;)
    {
      if ((Util.isNullOrNil(localg.field_aesKey)) || ("null".equalsIgnoreCase(localg.field_aesKey)))
      {
        k.bHX();
        localg.field_aesKey = com.tencent.mm.modelcdntran.d.bHI();
        Log.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      Log.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(paramh.source), localg.field_fileId });
      this.oIm = localg.field_fileId;
      this.oIn = localg.field_aesKey;
      Log.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.oIw = null;
      if (k.bHW().g(localg)) {
        break label1501;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 205L, 1L, false);
      Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.oHX });
      this.oHX = "";
      AppMethodBeat.o(150700);
      return false;
      i = 0;
      break;
      label1010:
      bool1 = false;
      break label351;
      label1016:
      bool1 = false;
      break label381;
      label1022:
      boolean bool2 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).dxO();
      if ((this.mxO == 4) && (com.tencent.mm.vfs.y.ZC((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(str1);
        if ((!((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).dxO()) || (com.tencent.mm.vfs.y.bEl(str1) <= 0L)) {
          break label1396;
        }
        if (com.tencent.mm.vfs.y.bEl(str3) > 0L)
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(944, 9);
          com.tencent.mm.vfs.y.deleteFile(str3);
        }
        if (!com.tencent.mm.vfs.y.ZC(str3)) {
          com.tencent.mm.vfs.y.bEp(str3);
        }
        if (((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).gG(str1, str3) != 0) {
          break label1377;
        }
        bool1 = true;
        label1164:
        if (!bool2) {
          break label1402;
        }
        label1169:
        localg.field_fullpath = ((String)localObject);
        localg.field_thumbpath = str4;
        if (!bool1) {
          break label1409;
        }
        localObject = str3;
        label1192:
        localg.field_midimgpath = ((String)localObject);
        if ((!bool2) && (!bool1)) {
          break label1416;
        }
        bool3 = true;
        label1212:
        this.oIy = bool3;
        localObject = this.TAG;
        if (localg.field_fileType != com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE) {
          break label1422;
        }
      }
      label1409:
      label1416:
      label1422:
      for (boolean bool3 = true;; bool3 = false)
      {
        Log.d((String)localObject, "hevc upload full size %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        break;
        str3 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(str2);
        ImgUtil.identifyImgType(str2).equals(".png");
        if ((this.oGu == 0) && (com.tencent.mm.vfs.y.ZC(str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          paramh.NU(((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(paramh.oGr));
          bool2 = bool1;
          localObject = str3;
          break;
        }
        label1377:
        Log.w(this.TAG, "file to hevc failed %s", new Object[] { str1 });
        label1396:
        bool1 = false;
        break label1164;
        label1402:
        localObject = str2;
        break label1169;
        localObject = str1;
        break label1192;
        bool3 = false;
        break label1212;
      }
      label1428:
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"));
      localg.field_midFileLength = Util.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      break label708;
      label1477:
      Log.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramh.oGC });
    }
    label1501:
    if (Util.nullAsNil(paramh.oGC).length() <= 0)
    {
      paramh.NT("CDNINFO_SEND");
      paramh.eQp = 4096;
    }
    AppMethodBeat.o(150700);
    return true;
  }
  
  private boolean a(h paramh, int paramInt1, long paramLong, int paramInt2, com.tencent.mm.g.d paramd, String paramString)
  {
    AppMethodBeat.i(169189);
    Log.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.oHX, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    Log.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(com.tencent.mm.platformtools.z.pCn), Long.valueOf(this.oHT), Long.valueOf(this.mxN) });
    long l = paramLong;
    if (10007 == com.tencent.mm.platformtools.z.pCm)
    {
      l = paramLong;
      if (com.tencent.mm.platformtools.z.pCn != 0)
      {
        l = com.tencent.mm.platformtools.z.pCn;
        com.tencent.mm.platformtools.z.pCn = 0;
      }
    }
    d(paramh.localId, paramInt1, paramh.osy);
    paramh.wj(paramInt1);
    paramh.gX(l);
    Object localObject;
    if (i.b(paramh))
    {
      if (this.oHT == this.mxN) {
        break label427;
      }
      localObject = r.bKa().b(Long.valueOf(this.oHT));
      ((h)localObject).gX(l);
      ((h)localObject).wk(paramh.osy);
      ((h)localObject).wj(paramh.osy);
      r.bKa().a(Long.valueOf(this.oHT), (h)localObject);
    }
    while (i.b(paramh))
    {
      this.hzO.setStatus(2);
      this.hzO.gX(l);
      this.hzO.AU(paramString);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.oGz, this.hzO);
      if (q.oXJ != null) {
        q.oXJ.u(this.hzO);
      }
      if (this.oHW != null) {
        this.oHW.ja(0L);
      }
      if (v.oJN != null)
      {
        localObject = this.oIz;
        paramh = (h)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramh = bt.JV(paramString);
        }
        v.oJN.a(this.mxN, this.hzO, this.rr, this.mxO, this.mxV, paramd, paramh);
      }
      if (this.oIr != null) {
        this.oIr.bFL();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      l.wt((int)this.oHT);
      AppMethodBeat.o(169189);
      return false;
      label427:
      localObject = r.bKa().b(Long.valueOf(paramh.localId));
      ((h)localObject).gX(l);
      ((h)localObject).wk(paramh.osy);
      ((h)localObject).wj(paramh.osy);
      r.bKa().a(Long.valueOf(((h)localObject).localId), (h)localObject);
    }
    AppMethodBeat.o(169189);
    return true;
  }
  
  private h bJK()
  {
    AppMethodBeat.i(150692);
    if (this.mxP == null) {
      this.mxP = r.bKa().b(Long.valueOf(this.mxN));
    }
    h localh = this.mxP;
    AppMethodBeat.o(150692);
    return localh;
  }
  
  private h bJL()
  {
    AppMethodBeat.i(150693);
    if (this.oIp == null) {
      this.oIp = r.bKa().b(Long.valueOf(this.oHT));
    }
    h localh = this.oIp;
    AppMethodBeat.o(150693);
    return localh;
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150707);
    if (this.oHS != null) {
      MMHandlerThread.postToMainThread(new o.7(this, paramLong, paramInt2, paramInt1));
    }
    AppMethodBeat.o(150707);
  }
  
  public static void iS(long paramLong)
  {
    oIB = paramLong;
  }
  
  private int ww(int paramInt)
  {
    AppMethodBeat.i(150703);
    Log.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.oIr != null) {
      this.oIr.bFL();
    }
    AppMethodBeat.o(150703);
    return -1;
  }
  
  public final cc bJM()
  {
    AppMethodBeat.i(239136);
    if (this.hzO == null) {
      Log.e(this.TAG, "msg is null. %s", new Object[] { Util.getStack() });
    }
    cc localcc = this.hzO;
    AppMethodBeat.o(239136);
    return localcc;
  }
  
  public final void bJN()
  {
    AppMethodBeat.i(150705);
    Log.i(this.TAG, "send img from system");
    this.mxV = true;
    AppMethodBeat.o(150705);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150702);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new o.6(this), 100L);
    if (this.mxN < 0L)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 204L, 1L, false);
      Log.e(this.TAG, "doScene invalid imgLocalId:" + this.mxN);
      i = ww(-1);
      AppMethodBeat.o(150702);
      return i;
    }
    if (this.hzO == null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 203L, 1L, false);
      Log.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.mxN) });
      l.wu((int)this.oHT);
      i = ww(-2);
      AppMethodBeat.o(150702);
      return i;
    }
    this.callback = paramh;
    prepareDispatcher(paramg);
    ftv localftv = (ftv)c.b.b(this.rr.otB);
    h localh = bJK();
    paramh = r.bKa().wr((int)localh.localId);
    if (paramh != null)
    {
      if (paramh.status == -1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 202L, 1L, false);
        Log.e(this.TAG, "doScene hd img info is null or error.");
        i = ww(-3);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else if ((localh == null) || (localh.status == -1))
    {
      Log.e(this.TAG, "doScene img info is null or error.");
      i = ww(-4);
      AppMethodBeat.o(150702);
      return i;
    }
    String str1;
    if (a.a.aOb().Dn(this.hzO.field_talker))
    {
      localftv.YFJ = a.a.aOb().o(this.hzO);
      Log.i(this.TAG, "upload img msg source %s", new Object[] { localftv.YFJ });
      str1 = r.bKa().v(localh.oGr, "", "");
      paramh = r.bKa().v(localh.oGt, "", "");
      if (!Util.isNullOrNil(localh.oGs)) {
        r.bKa().v(localh.oGs, "", "");
      }
      if ((com.tencent.mm.vfs.y.bEl(str1) <= 0L) || (com.tencent.mm.vfs.y.bEl(paramh) <= 0L))
      {
        Log.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.mxN), Long.valueOf(com.tencent.mm.vfs.y.bEl(str1)), Long.valueOf(com.tencent.mm.vfs.y.bEl(paramh)), str1, paramh });
        i = ww(-5);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else
    {
      if (Util.isNullOrNil(this.oIz))
      {
        paramh = com.tencent.mm.vfs.y.bub(this.oIx);
        localObject = com.tencent.mm.platformtools.s.pBi;
        this.oIz = com.tencent.mm.platformtools.s.Si(paramh);
      }
      if (!Util.isNullOrNil(this.oIz)) {}
      for (paramh = bt.JW(this.oIz);; paramh = bt.bCQ())
      {
        if (((paramh != null) && (!paramh.equals(this.hzO.jUr))) || ((paramh == null) && (!Util.isNullOrNil(this.hzO.jUr))))
        {
          this.hzO.AU(paramh);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hzO.field_msgId, this.hzO);
        }
        localftv.YFJ = this.hzO.jUr;
        break;
      }
    }
    if ((localftv.abRT == null) || (Util.isNullOrNil(localftv.abRT.abwM)))
    {
      if (Util.isNullOrNil(this.oHX))
      {
        Log.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.hzO.getCreateTime()), this.hzO.field_talker, Long.valueOf(this.hzO.field_msgId), Long.valueOf(this.mxN), Integer.valueOf(this.oGu) });
        this.oHX = com.tencent.mm.modelcdntran.h.a("upimg", this.hzO.getCreateTime(), this.hzO.field_talker, this.hzO.field_msgId + "_" + this.mxN + "_" + this.oGu);
      }
      localftv.abRT = new etl().btH(this.oHX);
      paramh = this.hzO;
      paramh.kLn = this.oHX;
      paramh.jTR = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.oHY = localh.offset;
      if (this.oGu != 1) {
        break label937;
      }
    }
    label937:
    for (int i = com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.g.a.MediaType_IMAGE)
    {
      this.mgx = i;
      if (!a(localh, 0)) {
        break;
      }
      Log.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localftv.abRT.abwM });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (au.bwZ(this.hgl))
    {
      Log.w(this.TAG, "just return without using cdn for byp. %s", new Object[] { this.hgl });
      l.wu((int)this.oHT);
      i = ww(-99);
      AppMethodBeat.o(150702);
      return i;
    }
    if (com.tencent.mm.k.i.aRC().getInt("UploadMsgImgType", 0) == 1) {}
    for (boolean bool1 = true; ab.IW(this.hzO.field_talker); bool1 = false)
    {
      Log.w(this.TAG, "cdntra not use parallel-upload user:%s", new Object[] { this.hzO.field_talker });
      i = 0;
      if (i == 0) {
        break label1486;
      }
      Log.d(this.TAG, "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { localftv.abRT.abwM });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpA, 0)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label1145;
      }
      Log.i(this.TAG, "NOT ALLOW USE PARALLEL UPLOAD IMG");
      i = 0;
      break;
    }
    label1145:
    Object localObject = r.bKa().v(localh.oGr, "", "");
    String str2 = r.bKa().v(localh.oGt, "", "");
    paramh = r.bKa().v(localh.oGs, "", "");
    boolean bool2 = Util.isNullOrNil(paramh);
    if (bool2) {
      paramh = (com.tencent.mm.am.h)localObject;
    }
    for (;;)
    {
      String str3 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(paramh);
      String str4 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI((String)localObject);
      com.tencent.mm.pluginsdk.g.d locald = new com.tencent.mm.pluginsdk.g.d();
      locald.oGz = this.oGz;
      locald.XPa = this.oIA;
      locald.scene = 1;
      locald.fileType = 2;
      if (!bool2) {
        locald.fileType = 1;
      }
      String str5;
      if ((bool1) && (this.oGu == 0))
      {
        localh.NU(str4);
        str5 = r.bKa().v(localh.oGw, "", "");
        i = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).gG((String)localObject, str5);
        if (i != 0) {
          break label1477;
        }
        localh.wn(1);
        localh.wk((int)com.tencent.mm.vfs.y.bEl(str5));
      }
      for (;;)
      {
        Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.mxN), str5, Integer.valueOf(i), Integer.valueOf(localh.osy) });
        locald.thumbPath = str2;
        locald.oGs = paramh;
        locald.XPc = str3;
        locald.fullPath = ((String)localObject);
        locald.XPb = str4;
        paramh = new com.tencent.mm.pluginsdk.g.c();
        paramh.XOW = bool1;
        paramh.a(locald);
        i = 1;
        break;
        label1477:
        localh.wn(0);
      }
      label1486:
      if ((bool1) && (this.oGu == 0))
      {
        localh.NU(((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(localh.oGr));
        paramh = r.bKa().v(localh.oGw, "", "");
        i = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).gG(str1, paramh);
        if (i != 0) {
          break label1690;
        }
        localh.wn(1);
        localh.wk((int)com.tencent.mm.vfs.y.bEl(paramh));
      }
      for (;;)
      {
        Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.mxN), paramh, Integer.valueOf(i), Integer.valueOf(localh.osy) });
        i = localh.oGA;
        if (i < securityLimitCount()) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 201L, 1L, false);
        Log.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
        l.wu((int)this.oHT);
        i = ww(-6);
        AppMethodBeat.o(150702);
        return i;
        label1690:
        localh.wn(0);
      }
      localh.wi(i + 1);
      localh.eQp = 512;
      r.bKa().a(Long.valueOf(this.mxN), localh);
      int j = localh.osy - localh.offset;
      i = j;
      if (j > this.oIq) {
        i = this.oIq;
      }
      com.tencent.mm.vfs.y.bEl(str1);
      if (localh.oGx == 1) {}
      for (paramh = r.bKa().v(localh.oGw, "", "");; paramh = r.bKa().v(localh.oGr, "", ""))
      {
        paramh = com.tencent.mm.vfs.y.bi(paramh, localh.offset, i);
        if ((paramh != null) && (paramh.length > 0)) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 199L, 1L, false);
        Log.e(this.TAG, "doScene, file read buf error.");
        i = ww(-8);
        AppMethodBeat.o(150702);
        return i;
      }
      localftv.NkP = paramh.length;
      localftv.NkN = localh.osy;
      localftv.NkO = localh.offset;
      localftv.NkQ = new gol().df(paramh);
      localftv.aaWH = localh.oGx;
      if (this.oHW != null) {
        this.oHW.bNd();
      }
      i = dispatch(paramg, this.rr, this);
      if (i < 0)
      {
        Log.e(this.TAG, "doScene netId error");
        l.wu((int)this.oHT);
        i = ww(-9);
        AppMethodBeat.o(150702);
        return i;
      }
      AppMethodBeat.o(150702);
      return i;
    }
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150704);
    Log.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.oHX);
    params = (ftw)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(params.ZaS);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 198L, 1L, false);
      l.wu((int)this.oHT);
      l.wt((int)this.oHT);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.oIr != null) {
        this.oIr.bFL();
      }
      AppMethodBeat.o(150704);
      return;
    }
    this.oIq = params.NkP;
    if (this.oIq > 16384) {
      this.oIq = 16384;
    }
    paramString = bJK();
    Log.v(this.TAG, "onGYNetEnd localId:" + this.mxN + "  totalLen:" + paramString.osy + " offSet:" + paramString.offset);
    if ((params.NkO < 0) || ((params.NkO > paramString.osy) && (paramString.osy > 0)))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 197L, 1L, false);
      Log.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + params.NkO + " img totalLen = " + paramString.osy);
      l.wu((int)this.oHT);
      l.wt((int)this.oHT);
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.oIr != null) {
        this.oIr.bFL();
      }
      AppMethodBeat.o(150704);
      return;
    }
    if ((params.NkO < paramString.offset) || ((i.b(paramString)) && (this.oIq <= 0)))
    {
      Log.e(this.TAG, "onGYNetEnd invalid data startPos = " + params.NkO + " totalLen = " + paramString.osy + " off:" + paramString.offset);
      l.wu((int)this.oHT);
      l.wt((int)this.oHT);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.oIr != null) {
        this.oIr.bFL();
      }
      AppMethodBeat.o(150704);
      return;
    }
    Log.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + params.NkO);
    if ((a(paramString, params.NkO, params.Njv, params.CreateTime, null, params.YFJ)) && (doScene(dispatcher(), this.callback) < 0))
    {
      l.wt((int)this.oHT);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.oIr != null) {
        this.oIr.bFL();
      }
    }
    AppMethodBeat.o(150704);
  }
  
  public final int securityLimitCount()
  {
    if (this.oGu == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void wv(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(150697);
    if (this.hzO == null)
    {
      Log.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.oGz), Integer.valueOf(paramInt) });
      AppMethodBeat.o(150697);
      return;
    }
    if (this.oIu)
    {
      if (this.hzO.kLl == 0)
      {
        boolean bool = r.bKa().a(this.hzO, this.oIb, paramInt);
        cc localcc = this.hzO;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localcc.pY(paramInt);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.oGz, this.hzO);
          AppMethodBeat.o(150697);
          return;
        }
      }
    }
    else {
      r.bKa().d(this.hzO.field_imgPath, com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()));
    }
    AppMethodBeat.o(150697);
  }
  
  public final class a
  {
    public com.tencent.mm.am.m oIJ;
    
    public a(com.tencent.mm.am.m paramm)
    {
      this.oIJ = paramm;
    }
    
    final void bFL()
    {
      AppMethodBeat.i(150691);
      if (o.b(o.this) == o.c(o.this)) {}
      for (Object localObject = o.d(o.this);; localObject = o.e(o.this))
      {
        if (((h)localObject).oGD == 1)
        {
          com.tencent.mm.plugin.report.service.g.ahx(23);
          com.tencent.mm.plugin.report.service.g.ahx(21);
        }
        Log.i(o.f(o.this), "UploadEndWrapper onUploadEnd %s done", new Object[] { o.f(o.d(o.this)) });
        if (r.bKa().a(Long.valueOf(o.c(o.this)), o.d(o.this)) < 0)
        {
          Log.e(o.f(o.this), "update db failed local id:" + o.c(o.this) + " server id:" + o.d(o.this).hTh);
          l.wu((int)o.b(o.this));
          l.wt((int)o.b(o.this));
          o.g(o.this).onSceneEnd(3, -1, "", o.this);
        }
        if (o.c(o.this) != o.b(o.this))
        {
          Log.i(o.f(o.this), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { o.f(o.e(o.this)) });
          r.bKa().a(Long.valueOf(o.b(o.this)), o.e(o.this));
        }
        if ((!CrashReportFactory.hasDebuger()) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
          break;
        }
        localObject = r.bKa().bJI();
        if (localObject == null) {
          break;
        }
        int i = 0;
        while (i < ((List)localObject).size())
        {
          Log.i(o.f(o.this), "UploadEndWrapper onUploadEnd duminfo %s %s", new Object[] { Integer.valueOf(i), o.f((h)((List)localObject).get(i)) });
          i += 1;
        }
      }
      o.a(o.this, o.c(o.this));
      if (o.b(o.this) != o.c(o.this)) {
        o.a(o.this, o.b(o.this));
      }
      if (this.oIJ != null) {
        this.oIJ.bFL();
      }
      o.this.wv(o.h(o.this));
      o.i(o.this);
      AppMethodBeat.o(150691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.o
 * JD-Core Version:    0.7.0.1
 */