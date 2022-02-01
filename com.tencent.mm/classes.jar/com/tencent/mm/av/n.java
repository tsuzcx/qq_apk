package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.ak.x;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelstat.r;
import com.tencent.mm.modelstat.r.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.wcdb.database.SQLiteException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class n
  extends com.tencent.mm.ak.q
  implements m
{
  public static boolean DEBUG = true;
  private static long iZx;
  private String TAG;
  private com.tencent.mm.ak.i callback;
  private ca dCM;
  public String dkV;
  private int gVY;
  private long hmj;
  private int hmk;
  private g hml;
  private boolean hmr;
  private int iXp;
  private long iXv;
  private final j iYO;
  public long iYP;
  private com.tencent.mm.modelstat.h iYS;
  private String iYT;
  private int iYW;
  private com.tencent.mm.i.g.a iZc;
  private String iZi;
  private String iZj;
  private boolean iZk;
  private g iZl;
  private int iZm;
  public a iZn;
  private String iZo;
  public String iZp;
  public boolean iZq;
  private String iZr;
  private String iZs;
  public String iZt;
  private boolean iZu;
  private String iZv;
  private com.tencent.mm.pluginsdk.f.d.a iZw;
  private float latitude;
  private float longtitude;
  private final com.tencent.mm.ak.d rr;
  private int scene;
  private int startOffset;
  private long startTime;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150698);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iZi = "";
    this.iZj = "";
    this.iZk = true;
    this.iZm = 16384;
    this.iXp = 0;
    this.dCM = null;
    this.iYS = null;
    this.iYT = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.gVY = 0;
    this.iZn = new a(null);
    this.iZu = false;
    this.iZw = new com.tencent.mm.pluginsdk.f.d.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(223613);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.tp((int)n.b(n.this));
        k.to((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aYO();
        }
        AppMethodBeat.o(223613);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(223614);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223614);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(223614);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(223612);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.jPY) });
        long l1 = paramAnonymousa.jPY;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.pkL;
        final g localg = n.d(n.this);
        Object localObject1 = q.bcR().o(localg.iXm, "", "");
        Object localObject2 = q.bcR().o(localg.iXn, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.s.boW(q.bcR().o(localg.iXo, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.s.boW((String)localObject2));
        locald.field_fileLength = paramAnonymousa.jPY;
        com.tencent.mm.an.f.baR();
        locald.field_filecrc = com.tencent.mm.an.a.NW((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Ov((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.c(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            n.a(n.this, localg);
            localg.Ot((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Ot((String)localObject1);
            }
            localObject1 = c.bcn();
            ((c)localObject1).hmk = n.q(n.this);
            ((c)localObject1).iWW = ((enu)n.p(n.this).iLK.iLR);
            ((c)localObject1).iWX = localg;
            ((c)localObject1).aesKey = paramAnonymousa.JUg;
            ((c)localObject1).hmq = locald;
            ((c)localObject1).iWY = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(223611);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.tp((int)n.b(n.this));
                  k.to((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aYO();
                  }
                  AppMethodBeat.o(223611);
                  return;
                }
                n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(223611);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bdQ().execute();
            AppMethodBeat.o(223612);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.iXp == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1040:
              for (localObject1 = l1 + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1040;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.iZc = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(223618);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(223618);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          Log.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.OI(paramAnonymousd.gqk))
          {
            new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bfK();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.an.f.baQ().Ob(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          Log.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(223615);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).te(0);
                n.m(n.this).setCreateTime(bp.Kw(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (enu)n.p(n.this).iLK.iLR;
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(223615);
                  return;
                  ((enu)localObject).NlB = new dqi().bhy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(223618);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(223616);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(223616);
                }
              });
              AppMethodBeat.o(223618);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new env();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new y(paramAnonymousc).bfK();
            new w(paramAnonymousc).bfK();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (g.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            paramAnonymousc = n.OI(paramAnonymousd.gqk);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Ov(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3150;
          }
        }
        label1606:
        label3147:
        label3150:
        for (paramAnonymousc = h.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.alL())
              {
                if (!Util.isNullOrNil(n.y(n.this))) {
                  break label2563;
                }
                Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                n.a(n.this, localg);
                localg.Ot((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Ot((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2735;
                }
                paramAnonymousString = c.bcn();
                paramAnonymousString.hmk = n.q(n.this);
                paramAnonymousString.iWW = ((enu)n.p(n.this).iLK.iLR);
                paramAnonymousString.iWX = localg;
                paramAnonymousString.aesKey = n.z(n.this);
                paramAnonymousString.hmq = paramAnonymousd;
                paramAnonymousString.iWY = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(223617);
                    new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
                    Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.tp((int)n.b(n.this));
                      k.to((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aYO();
                      }
                      AppMethodBeat.o(223617);
                      return;
                    }
                    n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(223617);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.bdQ().execute();
                break;
                paramAnonymousInt = localg.source;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
                if (localObject == null) {
                  break label3147;
                }
                if (localg.iXp == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2161:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2161;
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
              paramAnonymousString = new env();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.Brn != 0L) {}
                for (l1 = paramAnonymousString.Brn;; l1 = paramAnonymousInt)
                {
                  Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.iKP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.KHq))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aYO();
                    }
                  }
                  AppMethodBeat.o(223618);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.Brl;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aYO();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(223619);
        Object localObject1 = (enu)n.p(n.this).iLK.iLR;
        te localte = new te();
        localte.Lby = ((enu)localObject1).NlB.MTo;
        localte.xNH = ((enu)localObject1).KHl.MTo;
        localte.xNG = ((enu)localObject1).KHm.MTo;
        localte.Lbz = ((enu)localObject1).NlI;
        localte.LbA = ((enu)localObject1).NlJ;
        localte.Scene = n.A(n.this);
        localte.LbC = n.B(n.this);
        localte.LbD = n.C(n.this);
        localte.LbE = n.D(n.this);
        localte.KHq = ((enu)localObject1).KHq;
        localte.LbJ = n.z(n.this);
        localte.jfi = ((enu)localObject1).jfi;
        localte.KEq = ((enu)localObject1).KEq;
        localte.KEs = ((enu)localObject1).KEs;
        localte.KEr = ((enu)localObject1).KEr;
        localte.LbN = ((enu)localObject1).LbN;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bcR().o(((g)localObject1).iXm, "", "");
        com.tencent.mm.an.f.baR();
        localte.LbL = com.tencent.mm.an.a.NW((String)localObject2);
        localte.LbM = ((g)localObject1).iXq;
        int i;
        label342:
        String str;
        if (localte.LbM <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localte.LbM = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localte.xub = 2;
            if (localte.LbM == 3) {
              localte.xub = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localte.Lbz), Integer.valueOf(localte.LbA), localte.KHq, localte.xNG, localte.LbJ, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).iXm, localObject2, Integer.valueOf(localte.LbL), Integer.valueOf(localte.LbM), Integer.valueOf(localte.xub) });
            paramAnonymousString = new com.tencent.mm.ak.d.a();
            paramAnonymousString.iLN = localte;
            paramAnonymousString.iLO = new env();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.iLP = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aXF();
            localObject2 = n.F(n.this).aZh();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.e)localObject2).aZb()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.e)localObject2).aZb())) {
            break label776;
          }
          if (!x.a(((com.tencent.mm.network.e)localObject2).qe(1), ((com.tencent.mm.network.e)localObject2).aZa(), ((com.tencent.mm.network.e)localObject2).aZc(), ((com.tencent.mm.ak.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localte.Lby });
          AppMethodBeat.o(223619);
          return;
          i = 1;
          break;
          localte.xub = 1;
          break label342;
          localte.xub = 3;
          break label342;
          localte.xub = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(223620);
        PInt localPInt = new PInt();
        tf localtf = new tf();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), localPInt, localtf);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localtf.LbJ, localtf.KMl, localtf.Lby });
          n.c(n.this, localtf.LbJ);
          ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(localtf.LbO);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localtf.LbO) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(223620);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(223620);
        }
        return null;
      }
    };
    this.hmr = false;
    Log.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.getStack() });
    this.iYP = paramInt1;
    this.hmj = paramInt1;
    this.iXp = paramInt2;
    Object localObject1 = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject1).iLN = new enu();
    ((com.tencent.mm.ak.d.a)localObject1).iLO = new env();
    ((com.tencent.mm.ak.d.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((com.tencent.mm.ak.d.a)localObject1).funcId = 110;
    ((com.tencent.mm.ak.d.a)localObject1).iLP = 9;
    ((com.tencent.mm.ak.d.a)localObject1).respCmdId = 1000000009;
    this.rr = ((com.tencent.mm.ak.d.a)localObject1).aXF();
    this.iYO = null;
    Log.d(this.TAG, "FROM B SERVICE:" + this.iYP);
    if (!k.tn((int)this.iYP))
    {
      this.iYP = -1L;
      AppMethodBeat.o(150698);
      return;
    }
    localObject1 = q.bcR().c(Long.valueOf(this.iYP));
    this.iXv = ((g)localObject1).iXv;
    if (paramInt2 == 1)
    {
      this.hmj = ((g)localObject1).iXx;
      localObject1 = q.bcR().c(Long.valueOf(this.hmj));
    }
    for (;;)
    {
      Object localObject2 = q.bcR().tm((int)((g)localObject1).localId);
      if (localObject2 != null) {
        this.iXv = ((g)localObject2).iXv;
      }
      this.dCM = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.iXv);
      if ((this.dCM != null) && (this.dCM.field_msgId != this.iXv))
      {
        Log.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.iXv) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 206L, 1L, false);
        this.dCM = null;
        AppMethodBeat.o(150698);
        return;
      }
      if (this.dCM != null)
      {
        localObject2 = (enu)this.rr.iLK.iLR;
        ((enu)localObject2).KHl = new dqi().bhy(com.tencent.mm.model.z.aTY());
        ((enu)localObject2).KHm = new dqi().bhy(this.dCM.field_talker);
        ((enu)localObject2).BsG = ((g)localObject1).offset;
        ((enu)localObject2).BsF = ((g)localObject1).iKP;
        ((enu)localObject2).xKb = this.dCM.getType();
        ((enu)localObject2).LYt = paramInt2;
        if (!ag.dm(MMApplicationContext.getContext())) {
          break label880;
        }
      }
      label880:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((enu)localObject2).Llx = paramInt1;
        ((enu)localObject2).NaY = ((g)localObject1).source;
        ((enu)localObject2).LbM = ((g)localObject1).iXq;
        ((enu)localObject2).LbM = ((g)localObject1).iXq;
        ((enu)localObject2).NlI = this.dCM.fQT;
        ((enu)localObject2).NlJ = this.dCM.fQS;
        a locala = h.Ov(this.dCM.field_content);
        if ((locala != null) && (!Util.isNullOrNil(locala.appId)))
        {
          this.hmk = ((g)localObject1).source;
          ((enu)localObject2).jfi = locala.appId;
          ((enu)localObject2).KEq = locala.mediaTagName;
          ((enu)localObject2).KEs = locala.messageAction;
          ((enu)localObject2).KEr = locala.messageExt;
          this.iZo = this.dCM.field_content;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dCM.field_talker)) {
          ((enu)localObject2).LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.dCM.field_talker);
        }
        Log.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((enu)localObject2).NlI), Integer.valueOf(((enu)localObject2).NlJ) });
        Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((g)localObject1).source), Integer.valueOf(((enu)localObject2).LbM) });
        if (((g)localObject1).offset == 0) {
          this.iYS = new com.tencent.mm.modelstat.h(getType(), true, ((g)localObject1).iKP);
        }
        AppMethodBeat.o(150698);
        return;
      }
    }
  }
  
  public n(int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(223626);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iZi = "";
    this.iZj = "";
    this.iZk = true;
    this.iZm = 16384;
    this.iXp = 0;
    this.dCM = null;
    this.iYS = null;
    this.iYT = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.gVY = 0;
    this.iZn = new a(null);
    this.iZu = false;
    this.iZw = new com.tencent.mm.pluginsdk.f.d.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(223613);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.tp((int)n.b(n.this));
        k.to((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aYO();
        }
        AppMethodBeat.o(223613);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(223614);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223614);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(223614);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(223612);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.jPY) });
        long l1 = paramAnonymousa.jPY;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.pkL;
        final g localg = n.d(n.this);
        Object localObject1 = q.bcR().o(localg.iXm, "", "");
        Object localObject2 = q.bcR().o(localg.iXn, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.s.boW(q.bcR().o(localg.iXo, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.s.boW((String)localObject2));
        locald.field_fileLength = paramAnonymousa.jPY;
        com.tencent.mm.an.f.baR();
        locald.field_filecrc = com.tencent.mm.an.a.NW((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Ov((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.c(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            n.a(n.this, localg);
            localg.Ot((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Ot((String)localObject1);
            }
            localObject1 = c.bcn();
            ((c)localObject1).hmk = n.q(n.this);
            ((c)localObject1).iWW = ((enu)n.p(n.this).iLK.iLR);
            ((c)localObject1).iWX = localg;
            ((c)localObject1).aesKey = paramAnonymousa.JUg;
            ((c)localObject1).hmq = locald;
            ((c)localObject1).iWY = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(223611);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.tp((int)n.b(n.this));
                  k.to((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aYO();
                  }
                  AppMethodBeat.o(223611);
                  return;
                }
                n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(223611);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bdQ().execute();
            AppMethodBeat.o(223612);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.iXp == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1040:
              for (localObject1 = l1 + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1040;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.iZc = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(223618);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(223618);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          Log.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.OI(paramAnonymousd.gqk))
          {
            new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bfK();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.an.f.baQ().Ob(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          Log.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(223615);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).te(0);
                n.m(n.this).setCreateTime(bp.Kw(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (enu)n.p(n.this).iLK.iLR;
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(223615);
                  return;
                  ((enu)localObject).NlB = new dqi().bhy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(223618);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(223616);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(223616);
                }
              });
              AppMethodBeat.o(223618);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new env();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new y(paramAnonymousc).bfK();
            new w(paramAnonymousc).bfK();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (g.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            paramAnonymousc = n.OI(paramAnonymousd.gqk);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Ov(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3150;
          }
        }
        label1606:
        label3147:
        label3150:
        for (paramAnonymousc = h.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.alL())
              {
                if (!Util.isNullOrNil(n.y(n.this))) {
                  break label2563;
                }
                Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                n.a(n.this, localg);
                localg.Ot((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Ot((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2735;
                }
                paramAnonymousString = c.bcn();
                paramAnonymousString.hmk = n.q(n.this);
                paramAnonymousString.iWW = ((enu)n.p(n.this).iLK.iLR);
                paramAnonymousString.iWX = localg;
                paramAnonymousString.aesKey = n.z(n.this);
                paramAnonymousString.hmq = paramAnonymousd;
                paramAnonymousString.iWY = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(223617);
                    new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
                    Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.tp((int)n.b(n.this));
                      k.to((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aYO();
                      }
                      AppMethodBeat.o(223617);
                      return;
                    }
                    n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(223617);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.bdQ().execute();
                break;
                paramAnonymousInt = localg.source;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
                if (localObject == null) {
                  break label3147;
                }
                if (localg.iXp == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2161:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2161;
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
              paramAnonymousString = new env();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.Brn != 0L) {}
                for (l1 = paramAnonymousString.Brn;; l1 = paramAnonymousInt)
                {
                  Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.iKP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.KHq))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aYO();
                    }
                  }
                  AppMethodBeat.o(223618);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.Brl;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aYO();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(223619);
        Object localObject1 = (enu)n.p(n.this).iLK.iLR;
        te localte = new te();
        localte.Lby = ((enu)localObject1).NlB.MTo;
        localte.xNH = ((enu)localObject1).KHl.MTo;
        localte.xNG = ((enu)localObject1).KHm.MTo;
        localte.Lbz = ((enu)localObject1).NlI;
        localte.LbA = ((enu)localObject1).NlJ;
        localte.Scene = n.A(n.this);
        localte.LbC = n.B(n.this);
        localte.LbD = n.C(n.this);
        localte.LbE = n.D(n.this);
        localte.KHq = ((enu)localObject1).KHq;
        localte.LbJ = n.z(n.this);
        localte.jfi = ((enu)localObject1).jfi;
        localte.KEq = ((enu)localObject1).KEq;
        localte.KEs = ((enu)localObject1).KEs;
        localte.KEr = ((enu)localObject1).KEr;
        localte.LbN = ((enu)localObject1).LbN;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bcR().o(((g)localObject1).iXm, "", "");
        com.tencent.mm.an.f.baR();
        localte.LbL = com.tencent.mm.an.a.NW((String)localObject2);
        localte.LbM = ((g)localObject1).iXq;
        int i;
        label342:
        String str;
        if (localte.LbM <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localte.LbM = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localte.xub = 2;
            if (localte.LbM == 3) {
              localte.xub = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localte.Lbz), Integer.valueOf(localte.LbA), localte.KHq, localte.xNG, localte.LbJ, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).iXm, localObject2, Integer.valueOf(localte.LbL), Integer.valueOf(localte.LbM), Integer.valueOf(localte.xub) });
            paramAnonymousString = new com.tencent.mm.ak.d.a();
            paramAnonymousString.iLN = localte;
            paramAnonymousString.iLO = new env();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.iLP = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aXF();
            localObject2 = n.F(n.this).aZh();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.e)localObject2).aZb()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.e)localObject2).aZb())) {
            break label776;
          }
          if (!x.a(((com.tencent.mm.network.e)localObject2).qe(1), ((com.tencent.mm.network.e)localObject2).aZa(), ((com.tencent.mm.network.e)localObject2).aZc(), ((com.tencent.mm.ak.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localte.Lby });
          AppMethodBeat.o(223619);
          return;
          i = 1;
          break;
          localte.xub = 1;
          break label342;
          localte.xub = 3;
          break label342;
          localte.xub = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(223620);
        PInt localPInt = new PInt();
        tf localtf = new tf();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), localPInt, localtf);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localtf.LbJ, localtf.KMl, localtf.Lby });
          n.c(n.this, localtf.LbJ);
          ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(localtf.LbO);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localtf.LbO) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(223620);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(223620);
        }
        return null;
      }
    };
    this.hmr = false;
    Log.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramj, Util.getStack() });
    this.iYP = paramInt1;
    this.hmj = paramInt1;
    this.iXp = paramInt2;
    paramj = new com.tencent.mm.ak.d.a();
    paramj.iLN = new enu();
    paramj.iLO = new env();
    paramj.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    paramj.funcId = 110;
    paramj.iLP = 9;
    paramj.respCmdId = 1000000009;
    this.rr = paramj.aXF();
    this.iYO = null;
    Log.d(this.TAG, "FROM C SERVICE:" + this.iYP);
    if (!k.tn((int)this.iYP))
    {
      this.iYP = -1L;
      AppMethodBeat.o(223626);
      return;
    }
    paramj = q.bcR().c(Long.valueOf(this.iYP));
    this.iXv = paramj.iXv;
    paramj.setStatus(0);
    paramj.yF(0L);
    paramj.setOffset(0);
    q.bcR().a((int)this.hmj, paramj);
    if (paramInt2 == 1)
    {
      this.hmj = paramj.iXx;
      paramj = q.bcR().c(Long.valueOf(this.hmj));
    }
    for (;;)
    {
      this.dCM = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.iXv);
      Object localObject;
      if (this.dCM != null)
      {
        this.dCM.setStatus(1);
        localObject = paramj.iXo;
        if ((localObject == null) || (!((String)localObject).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label789;
        }
        this.dCM.Cz((String)localObject);
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.iXv, this.dCM);
        localObject = (enu)this.rr.iLK.iLR;
        ((enu)localObject).KHl = new dqi().bhy(com.tencent.mm.model.z.aTY());
        ((enu)localObject).KHm = new dqi().bhy(this.dCM.field_talker);
        ((enu)localObject).BsG = paramj.offset;
        ((enu)localObject).BsF = paramj.iKP;
        ((enu)localObject).xKb = this.dCM.getType();
        ((enu)localObject).LYt = paramInt2;
        if (!ag.dm(MMApplicationContext.getContext())) {
          break label819;
        }
      }
      label789:
      label819:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((enu)localObject).Llx = paramInt1;
        ((enu)localObject).NaY = paramj.source;
        ((enu)localObject).LbM = paramj.iXq;
        ((enu)localObject).NlI = this.dCM.fQT;
        ((enu)localObject).NlJ = this.dCM.fQS;
        if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dCM.field_talker)) {
          ((enu)localObject).LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(this.dCM.field_talker);
        }
        Log.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((enu)localObject).NlI), Integer.valueOf(((enu)localObject).NlJ) });
        Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramj.source), Integer.valueOf(((enu)localObject).LbM) });
        if (paramj.offset == 0) {
          this.iYS = new com.tencent.mm.modelstat.h(getType(), true, paramj.iKP);
        }
        AppMethodBeat.o(223626);
        return;
        this.dCM.Cz("THUMBNAIL://" + paramj.localId);
        break;
      }
    }
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, j paramj)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramj, 0, "", "");
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, j paramj, int paramInt3, com.tencent.mm.ak.n paramn, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramj, paramInt3, "", "", true, paramInt4);
    AppMethodBeat.i(223623);
    this.iZn = new a(paramn);
    AppMethodBeat.o(223623);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, j paramj, int paramInt3, String paramString4, String paramString5)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramj, paramInt3, paramString4, paramString5, false, -1);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, j paramj, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramj, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, 0L, null);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, j paramj, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, long paramLong, String paramString6)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramj, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, paramLong, paramString6);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final j paramj, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2, int paramInt5, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, String paramString6)
  {
    AppMethodBeat.i(223624);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iZi = "";
    this.iZj = "";
    this.iZk = true;
    this.iZm = 16384;
    this.iXp = 0;
    this.dCM = null;
    this.iYS = null;
    this.iYT = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.gVY = 0;
    this.iZn = new a(null);
    this.iZu = false;
    this.iZw = new com.tencent.mm.pluginsdk.f.d.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(223613);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.tp((int)n.b(n.this));
        k.to((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aYO();
        }
        AppMethodBeat.o(223613);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(223614);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223614);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(223614);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(223612);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.jPY) });
        long l1 = paramAnonymousa.jPY;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.pkL;
        final g localg = n.d(n.this);
        Object localObject1 = q.bcR().o(localg.iXm, "", "");
        Object localObject2 = q.bcR().o(localg.iXn, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.s.boW(q.bcR().o(localg.iXo, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.s.boW((String)localObject2));
        locald.field_fileLength = paramAnonymousa.jPY;
        com.tencent.mm.an.f.baR();
        locald.field_filecrc = com.tencent.mm.an.a.NW((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Ov((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.c(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            n.a(n.this, localg);
            localg.Ot((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Ot((String)localObject1);
            }
            localObject1 = c.bcn();
            ((c)localObject1).hmk = n.q(n.this);
            ((c)localObject1).iWW = ((enu)n.p(n.this).iLK.iLR);
            ((c)localObject1).iWX = localg;
            ((c)localObject1).aesKey = paramAnonymousa.JUg;
            ((c)localObject1).hmq = locald;
            ((c)localObject1).iWY = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(223611);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.tp((int)n.b(n.this));
                  k.to((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aYO();
                  }
                  AppMethodBeat.o(223611);
                  return;
                }
                n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(223611);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bdQ().execute();
            AppMethodBeat.o(223612);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.iXp == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1040:
              for (localObject1 = l1 + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1040;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.iZc = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(223618);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(223618);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          Log.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.OI(paramAnonymousd.gqk))
          {
            new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bfK();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.an.f.baQ().Ob(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          Log.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(223615);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).te(0);
                n.m(n.this).setCreateTime(bp.Kw(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (enu)n.p(n.this).iLK.iLR;
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(223615);
                  return;
                  ((enu)localObject).NlB = new dqi().bhy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(223618);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(223616);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(223616);
                }
              });
              AppMethodBeat.o(223618);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new env();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new y(paramAnonymousc).bfK();
            new w(paramAnonymousc).bfK();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (g.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            paramAnonymousc = n.OI(paramAnonymousd.gqk);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Ov(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3150;
          }
        }
        label1606:
        label3147:
        label3150:
        for (paramAnonymousc = h.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.alL())
              {
                if (!Util.isNullOrNil(n.y(n.this))) {
                  break label2563;
                }
                Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                n.a(n.this, localg);
                localg.Ot((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Ot((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2735;
                }
                paramAnonymousString = c.bcn();
                paramAnonymousString.hmk = n.q(n.this);
                paramAnonymousString.iWW = ((enu)n.p(n.this).iLK.iLR);
                paramAnonymousString.iWX = localg;
                paramAnonymousString.aesKey = n.z(n.this);
                paramAnonymousString.hmq = paramAnonymousd;
                paramAnonymousString.iWY = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(223617);
                    new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
                    Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.tp((int)n.b(n.this));
                      k.to((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aYO();
                      }
                      AppMethodBeat.o(223617);
                      return;
                    }
                    n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(223617);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.bdQ().execute();
                break;
                paramAnonymousInt = localg.source;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
                if (localObject == null) {
                  break label3147;
                }
                if (localg.iXp == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2161:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2161;
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
              paramAnonymousString = new env();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.Brn != 0L) {}
                for (l1 = paramAnonymousString.Brn;; l1 = paramAnonymousInt)
                {
                  Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.iKP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.KHq))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aYO();
                    }
                  }
                  AppMethodBeat.o(223618);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.Brl;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aYO();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(223619);
        Object localObject1 = (enu)n.p(n.this).iLK.iLR;
        te localte = new te();
        localte.Lby = ((enu)localObject1).NlB.MTo;
        localte.xNH = ((enu)localObject1).KHl.MTo;
        localte.xNG = ((enu)localObject1).KHm.MTo;
        localte.Lbz = ((enu)localObject1).NlI;
        localte.LbA = ((enu)localObject1).NlJ;
        localte.Scene = n.A(n.this);
        localte.LbC = n.B(n.this);
        localte.LbD = n.C(n.this);
        localte.LbE = n.D(n.this);
        localte.KHq = ((enu)localObject1).KHq;
        localte.LbJ = n.z(n.this);
        localte.jfi = ((enu)localObject1).jfi;
        localte.KEq = ((enu)localObject1).KEq;
        localte.KEs = ((enu)localObject1).KEs;
        localte.KEr = ((enu)localObject1).KEr;
        localte.LbN = ((enu)localObject1).LbN;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bcR().o(((g)localObject1).iXm, "", "");
        com.tencent.mm.an.f.baR();
        localte.LbL = com.tencent.mm.an.a.NW((String)localObject2);
        localte.LbM = ((g)localObject1).iXq;
        int i;
        label342:
        String str;
        if (localte.LbM <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localte.LbM = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localte.xub = 2;
            if (localte.LbM == 3) {
              localte.xub = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localte.Lbz), Integer.valueOf(localte.LbA), localte.KHq, localte.xNG, localte.LbJ, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).iXm, localObject2, Integer.valueOf(localte.LbL), Integer.valueOf(localte.LbM), Integer.valueOf(localte.xub) });
            paramAnonymousString = new com.tencent.mm.ak.d.a();
            paramAnonymousString.iLN = localte;
            paramAnonymousString.iLO = new env();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.iLP = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aXF();
            localObject2 = n.F(n.this).aZh();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.e)localObject2).aZb()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.e)localObject2).aZb())) {
            break label776;
          }
          if (!x.a(((com.tencent.mm.network.e)localObject2).qe(1), ((com.tencent.mm.network.e)localObject2).aZa(), ((com.tencent.mm.network.e)localObject2).aZc(), ((com.tencent.mm.ak.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localte.Lby });
          AppMethodBeat.o(223619);
          return;
          i = 1;
          break;
          localte.xub = 1;
          break label342;
          localte.xub = 3;
          break label342;
          localte.xub = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(223620);
        PInt localPInt = new PInt();
        tf localtf = new tf();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), localPInt, localtf);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localtf.LbJ, localtf.KMl, localtf.Lby });
          n.c(n.this, localtf.LbJ);
          ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(localtf.LbO);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localtf.LbO) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(223620);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(223620);
        }
        return null;
      }
    };
    this.hmr = false;
    Log.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramj, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), Util.getStack(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.iZq = paramBoolean1;
    this.iYW = paramInt4;
    this.iYO = paramj;
    this.iXp = paramInt2;
    this.scene = paramInt5;
    this.latitude = paramFloat2;
    this.longtitude = paramFloat1;
    this.hmk = paramInt1;
    this.iZt = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.iZo = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong1 > 0L)
    {
      paramString5 = q.bcR().c(Long.valueOf(paramLong1));
      paramString5 = q.bcR().o(paramString5.iXr, "", "");
    }
    if (paramLong2 > 0L) {
      this.iZv = br.KB(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramLong2).fqK);
    }
    try
    {
      for (;;)
      {
        this.iYP = q.bcR().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
        this.hmj = this.iYP;
        Log.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.iYP);
        if ((!paramBoolean2) || ((this.iYP >= 0L) && (k.tn((int)this.iYP)))) {
          break;
        }
        Log.e(this.TAG, "insert to img storage failed id:" + this.iYP);
        this.iXv = -1L;
        this.rr = null;
        AppMethodBeat.o(223624);
        return;
        if (!Util.isNullOrNil(paramString6)) {
          this.iZv = paramString6;
        }
      }
    }
    catch (SQLiteException paramString6)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(111L, 182L, 1L, false);
        if (!paramString6.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        q.bcR().bcy();
        Log.e(this.TAG, "fallback to insert");
        this.iYP = q.bcR().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
      }
      AppMethodBeat.o(223624);
      throw paramString6;
    }
    if (this.iYP >= 0L)
    {
      paramBoolean1 = true;
      Assert.assertTrue(paramBoolean1);
      paramString3 = new com.tencent.mm.ak.d.a();
      paramString3.iLN = new enu();
      paramString3.iLO = new env();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.iLP = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.aXF();
      this.dkV = paramString2;
      this.dCM = new ca();
      this.dCM.setType(ab.JH(paramString2));
      this.dCM.Cy(paramString2);
      this.dCM.nv(1);
      this.dCM.setStatus(1);
      this.dCM.Cz(localPString.value);
      this.dCM.nG(localPInt1.value);
      this.dCM.nH(localPInt2.value);
      this.dCM.setCreateTime(bp.Kw(this.dCM.field_talker));
      this.dCM.setContent(paramString4);
      a.a.anC().n(this.dCM);
    }
    label1640:
    label1646:
    label1651:
    for (;;)
    {
      try
      {
        this.iXv = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().c(this.dCM, true);
        if (this.iXv >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.iXv);
          paramString3 = bcC();
          paramString3.Aw((int)this.iXv);
          q.bcR().a(Long.valueOf(this.iYP), paramString3);
          if (paramInt2 != 1) {
            break label1651;
          }
          this.hmj = paramString3.iXx;
          paramString3 = bcB();
          paramString3.tf((int)com.tencent.mm.vfs.s.boW(q.bcR().o(paramString3.iXm, "", "")));
          q.bcR().a(Long.valueOf(this.hmj), paramString3);
          Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.hmj + " img len = " + paramString3.iKP);
          paramString5 = (enu)this.rr.iLK.iLR;
          paramString5.KHl = new dqi().bhy(paramString1);
          paramString5.KHm = new dqi().bhy(paramString2);
          paramString5.BsG = paramString3.offset;
          paramString5.BsF = paramString3.iKP;
          paramString5.xKb = this.dCM.getType();
          paramString5.LYt = paramInt2;
          if (!ag.dm(MMApplicationContext.getContext())) {
            break label1640;
          }
          paramInt3 = 1;
          paramString5.Llx = paramInt3;
          paramString5.NaY = paramString3.source;
          paramString5.LbM = paramString3.iXq;
          paramString5.NlI = localPInt2.value;
          paramString5.NlJ = localPInt1.value;
          paramString1 = h.Ov(paramString4);
          if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.appId)))
          {
            paramString5.jfi = paramString1.appId;
            paramString5.KEq = paramString1.mediaTagName;
            paramString5.KEs = paramString1.messageAction;
            paramString5.KEr = paramString1.messageExt;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(paramString2)) {
            paramString5.LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(paramString2);
          }
          Log.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.NlI), Integer.valueOf(paramString5.NlJ) });
          if (paramString5.LbM == 0)
          {
            if (paramInt1 != 4) {
              break label1646;
            }
            paramInt1 = 2;
            paramString5.LbM = paramInt1;
          }
          Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString5.LbM) });
          if (paramString3.offset == 0) {
            this.iYS = new com.tencent.mm.modelstat.h(getType(), true, paramString3.iKP);
          }
          paramLong1 = System.currentTimeMillis();
          tq(paramInt2);
          Log.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong1) });
          if (paramj != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150681);
                paramj.a(this.iZe, this.iZf, n.this);
                AppMethodBeat.o(150681);
              }
            });
          }
          AppMethodBeat.o(223624);
          return;
          paramBoolean1 = false;
        }
      }
      catch (SQLiteException paramString3)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(111L, 182L, 1L, false);
        if (paramString3.toString().contains("UNIQUE constraint failed"))
        {
          Log.e(this.TAG, "fallback to insert");
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().eiI();
          this.iXv = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().c(this.dCM, true);
          continue;
        }
        AppMethodBeat.o(223624);
        throw paramString3;
      }
      paramBoolean1 = false;
      continue;
      paramInt3 = 2;
      continue;
      paramInt1 = 1;
    }
  }
  
  public n(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final j paramj, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(223625);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iZi = "";
    this.iZj = "";
    this.iZk = true;
    this.iZm = 16384;
    this.iXp = 0;
    this.dCM = null;
    this.iYS = null;
    this.iYT = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.gVY = 0;
    this.iZn = new a(null);
    this.iZu = false;
    this.iZw = new com.tencent.mm.pluginsdk.f.d.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(223613);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.tp((int)n.b(n.this));
        k.to((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aYO();
        }
        AppMethodBeat.o(223613);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(223614);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223614);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(223614);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(223612);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.jPY) });
        long l1 = paramAnonymousa.jPY;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.pkL;
        final g localg = n.d(n.this);
        Object localObject1 = q.bcR().o(localg.iXm, "", "");
        Object localObject2 = q.bcR().o(localg.iXn, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.s.boW(q.bcR().o(localg.iXo, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.s.boW((String)localObject2));
        locald.field_fileLength = paramAnonymousa.jPY;
        com.tencent.mm.an.f.baR();
        locald.field_filecrc = com.tencent.mm.an.a.NW((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Ov((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.c(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            n.a(n.this, localg);
            localg.Ot((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Ot((String)localObject1);
            }
            localObject1 = c.bcn();
            ((c)localObject1).hmk = n.q(n.this);
            ((c)localObject1).iWW = ((enu)n.p(n.this).iLK.iLR);
            ((c)localObject1).iWX = localg;
            ((c)localObject1).aesKey = paramAnonymousa.JUg;
            ((c)localObject1).hmq = locald;
            ((c)localObject1).iWY = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(223611);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.tp((int)n.b(n.this));
                  k.to((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aYO();
                  }
                  AppMethodBeat.o(223611);
                  return;
                }
                n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(223611);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bdQ().execute();
            AppMethodBeat.o(223612);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.iXp == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1040:
              for (localObject1 = l1 + "\" hdlength=\"" + Util.nullAs((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1040;
                localObject2 = "<msg><img aeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.iZc = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(223618);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(223618);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          Log.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.OI(paramAnonymousd.gqk))
          {
            new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bfK();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.an.f.baQ().Ob(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aYO();
          }
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(223618);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          Log.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            Log.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(223615);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).te(0);
                n.m(n.this).setCreateTime(bp.Kw(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (enu)n.p(n.this).iLK.iLR;
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(223615);
                  return;
                  ((enu)localObject).NlB = new dqi().bhy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(223618);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(223616);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(223616);
                }
              });
              AppMethodBeat.o(223618);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new env();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new y(paramAnonymousc).bfK();
            new w(paramAnonymousc).bfK();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aYO();
            }
            AppMethodBeat.o(223618);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
          }
        }
        catch (g.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            Log.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousc) });
            continue;
            paramAnonymousc = n.OI(paramAnonymousd.gqk);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Ov(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3150;
          }
        }
        label1606:
        label3147:
        label3150:
        for (paramAnonymousc = h.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.alL())
              {
                if (!Util.isNullOrNil(n.y(n.this))) {
                  break label2563;
                }
                Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                n.a(n.this, localg);
                localg.Ot((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Ot((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2735;
                }
                paramAnonymousString = c.bcn();
                paramAnonymousString.hmk = n.q(n.this);
                paramAnonymousString.iWW = ((enu)n.p(n.this).iLK.iLR);
                paramAnonymousString.iWX = localg;
                paramAnonymousString.aesKey = n.z(n.this);
                paramAnonymousString.hmq = paramAnonymousd;
                paramAnonymousString.iWY = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(223617);
                    new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
                    Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.tp((int)n.b(n.this));
                      k.to((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aYO();
                      }
                      AppMethodBeat.o(223617);
                      return;
                    }
                    n.a(n.this, localg, localg.iKP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(223617);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.bdQ().execute();
                break;
                paramAnonymousInt = localg.source;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
                if (localObject == null) {
                  break label3147;
                }
                if (localg.iXp == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2161:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  Log.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2161;
                  paramAnonymousString = "<msg><img aeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + Util.nullAs((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.OI(paramAnonymousd.gqk) })).bfK();
              paramAnonymousString = new env();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.Brn != 0L) {}
                for (l1 = paramAnonymousString.Brn;; l1 = paramAnonymousInt)
                {
                  Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.iKP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.KHq))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aYO();
                    }
                  }
                  AppMethodBeat.o(223618);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.Brl;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aYO();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(223619);
        Object localObject1 = (enu)n.p(n.this).iLK.iLR;
        te localte = new te();
        localte.Lby = ((enu)localObject1).NlB.MTo;
        localte.xNH = ((enu)localObject1).KHl.MTo;
        localte.xNG = ((enu)localObject1).KHm.MTo;
        localte.Lbz = ((enu)localObject1).NlI;
        localte.LbA = ((enu)localObject1).NlJ;
        localte.Scene = n.A(n.this);
        localte.LbC = n.B(n.this);
        localte.LbD = n.C(n.this);
        localte.LbE = n.D(n.this);
        localte.KHq = ((enu)localObject1).KHq;
        localte.LbJ = n.z(n.this);
        localte.jfi = ((enu)localObject1).jfi;
        localte.KEq = ((enu)localObject1).KEq;
        localte.KEs = ((enu)localObject1).KEs;
        localte.KEr = ((enu)localObject1).KEr;
        localte.LbN = ((enu)localObject1).LbN;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bcR().o(((g)localObject1).iXm, "", "");
        com.tencent.mm.an.f.baR();
        localte.LbL = com.tencent.mm.an.a.NW((String)localObject2);
        localte.LbM = ((g)localObject1).iXq;
        int i;
        label342:
        String str;
        if (localte.LbM <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localte.LbM = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localte.xub = 2;
            if (localte.LbM == 3) {
              localte.xub = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localte.Lbz), Integer.valueOf(localte.LbA), localte.KHq, localte.xNG, localte.LbJ, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).iXm, localObject2, Integer.valueOf(localte.LbL), Integer.valueOf(localte.LbM), Integer.valueOf(localte.xub) });
            paramAnonymousString = new com.tencent.mm.ak.d.a();
            paramAnonymousString.iLN = localte;
            paramAnonymousString.iLO = new env();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.iLP = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aXF();
            localObject2 = n.F(n.this).aZh();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.e)localObject2).aZb()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.e)localObject2).aZb())) {
            break label776;
          }
          if (!x.a(((com.tencent.mm.network.e)localObject2).qe(1), ((com.tencent.mm.network.e)localObject2).aZa(), ((com.tencent.mm.network.e)localObject2).aZc(), ((com.tencent.mm.ak.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localte.Lby });
          AppMethodBeat.o(223619);
          return;
          i = 1;
          break;
          localte.xub = 1;
          break label342;
          localte.xub = 3;
          break label342;
          localte.xub = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localte.Lby });
        AppMethodBeat.o(223619);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(223620);
        PInt localPInt = new PInt();
        tf localtf = new tf();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.aAg().hqi.iMw.aZh().qe(1), localPInt, localtf);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localtf.LbJ, localtf.KMl, localtf.Lby });
          n.c(n.this, localtf.LbJ);
          ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(localtf.LbO);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localtf.LbO) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(223620);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(223620);
        }
        return null;
      }
    };
    this.hmr = false;
    Log.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramj, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), Util.getStack() });
    this.iZq = paramBoolean1;
    this.iYW = paramInt4;
    this.iYO = paramj;
    this.iXp = paramInt2;
    this.hmk = paramInt1;
    this.iZt = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.iZo = paramString4;
    this.iYP = paramLong;
    this.hmj = this.iYP;
    paramString3 = bcC();
    this.dCM = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramString3.iXv);
    this.iXv = this.dCM.field_msgId;
    localPInt.value = this.dCM.fQT;
    paramString5.value = this.dCM.fQS;
    if (paramInt2 == 1)
    {
      this.hmj = paramString3.iXx;
      this.hml = null;
      paramString3 = bcB();
    }
    for (;;)
    {
      if ((this.dCM.field_talker != null) && (!this.dCM.field_talker.equals(paramString2)))
      {
        Log.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.dCM.field_talker });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.dCM.field_talker;; paramString4 = paramString2)
      {
        Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.dCM.field_msgId);
        Log.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.iYP);
        if ((paramBoolean2) && ((this.iYP < 0L) || (!k.tn((int)this.iYP))))
        {
          Log.e(this.TAG, "insert to img storage failed id:" + this.iYP);
          this.iXv = -1L;
          this.rr = null;
          AppMethodBeat.o(223625);
          return;
        }
        if (this.iYP >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          paramString2 = new com.tencent.mm.ak.d.a();
          paramString2.iLN = new enu();
          paramString2.iLO = new env();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.iLP = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.aXF();
          Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.hmj + " img len = " + paramString3.iKP);
          paramString2 = (enu)this.rr.iLK.iLR;
          paramString2.KHl = new dqi().bhy(paramString1);
          paramString2.KHm = new dqi().bhy(paramString4);
          paramString2.BsG = paramString3.offset;
          paramString2.BsF = paramString3.iKP;
          paramString2.xKb = this.dCM.getType();
          paramString2.LYt = paramInt2;
          if (!ag.dm(MMApplicationContext.getContext())) {
            break label1112;
          }
          paramInt2 = 1;
          label856:
          paramString2.Llx = paramInt2;
          paramString2.NaY = paramString3.source;
          paramString2.LbM = paramString3.iXq;
          paramString2.NlI = localPInt.value;
          paramString2.NlJ = paramString5.value;
          Log.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.NlI), Integer.valueOf(paramString2.NlJ) });
          if (paramString2.LbM == 0) {
            if (paramInt1 != 4) {
              break label1118;
            }
          }
        }
        label1112:
        label1118:
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString2.LbM = paramInt1;
          if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(paramString4)) {
            paramString2.LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(paramString4);
          }
          Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString2.LbM) });
          if (paramString3.offset == 0) {
            this.iYS = new com.tencent.mm.modelstat.h(getType(), true, paramString3.iKP);
          }
          if (paramj != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150682);
                paramj.a(this.iZe, this.iZf, n.this);
                AppMethodBeat.o(150682);
              }
            });
          }
          AppMethodBeat.o(223625);
          return;
          paramBoolean1 = false;
          break;
          paramInt2 = 2;
          break label856;
        }
      }
    }
  }
  
  public static void Az(long paramLong)
  {
    iZx = paramLong;
  }
  
  public static String OI(String paramString)
  {
    AppMethodBeat.i(150708);
    try
    {
      boolean bool = Util.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150708);
        return paramString;
      }
      Object localObject = paramString.split(",");
      if ((localObject != null) && (localObject.length > 19))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = iZx;
        iZx = -1L;
        localObject[19] = l;
        localObject = Util.listToString(Util.stringsToList((String[])localObject), ",");
        AppMethodBeat.o(150708);
        return localObject;
      }
      AppMethodBeat.o(150708);
      return paramString;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150708);
    }
    return paramString;
  }
  
  private boolean a(g paramg, int paramInt)
  {
    AppMethodBeat.i(150700);
    String str3 = this.dCM.field_talker;
    if (ab.JF(str3))
    {
      Log.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { str3 });
      AppMethodBeat.o(150700);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.f.b.gmg())
    {
      Log.i(this.TAG, "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(150700);
      return false;
    }
    com.tencent.mm.an.f.baQ();
    if ((!com.tencent.mm.an.b.sS(1)) && (Util.isNullOrNil(paramg.iXy)))
    {
      localObject = this.TAG;
      com.tencent.mm.an.f.baQ();
      Log.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.sS(1)), paramg.iXy });
      AppMethodBeat.o(150700);
      return false;
    }
    if (Util.isNullOrNil(this.iYT))
    {
      Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.hmj) });
      AppMethodBeat.o(150700);
      return false;
    }
    String str2 = q.bcR().o(paramg.iXm, "", "");
    String str1 = q.bcR().o(paramg.iXn, "", "");
    String str4 = q.bcR().o(paramg.iXo, "", "");
    Object localObject = q.bcR().o(paramg.iXr, "", "");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_NetSceneUploadMsgImg";
    localg.gqy = this.iZc;
    localg.field_mediaId = this.iYT;
    localg.field_fileType = this.gVY;
    localg.field_talker = str3;
    int i;
    boolean bool1;
    if (ab.Eq(str3))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.gpM;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      if (as.bjw(this.dCM.field_talker)) {
        break label1010;
      }
      bool1 = true;
      label351:
      localg.field_sendmsg_viacdn = bool1;
      if ((as.bjw(this.dCM.field_talker)) || (!this.iZk)) {
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
      this.iYT = com.tencent.mm.an.c.a("upimgjpg", this.dCM.field_createTime, str3, this.dCM.field_msgId + "_" + this.hmj + "_" + this.iXp);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.iYT;
      this.iZu = false;
      if (!this.iZu)
      {
        bool1 = ImgUtil.isWXGF(str4);
        Log.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", new Object[] { Boolean.valueOf(bool1) });
      }
      if ((localg.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) && (Util.isNullOrNil(localg.field_midimgpath)))
      {
        com.tencent.mm.an.f.baQ();
        if (com.tencent.mm.an.b.sS(256))
        {
          Log.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = XmlParser.parseXml(this.iZo, "msg", null);
      if (localObject == null) {
        break label1379;
      }
      if (this.iXp == 1) {
        break label1330;
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
        com.tencent.mm.an.f.baR();
        localg.field_aesKey = com.tencent.mm.an.a.baG();
        Log.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      Log.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(paramg.source), localg.field_fileId });
      this.iZi = localg.field_fileId;
      this.iZj = localg.field_aesKey;
      Log.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.iZs = null;
      if (com.tencent.mm.an.f.baQ().f(localg)) {
        break label1403;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 205L, 1L, false);
      Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.iYT });
      this.iYT = "";
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
      boolean bool2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).cEO();
      boolean bool3;
      if ((this.hmk == 4) && (com.tencent.mm.vfs.s.YS((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(str1);
        bool3 = bq(str1, str3);
        if (!bool2) {
          break label1304;
        }
        label1087:
        localg.field_fullpath = ((String)localObject);
        localg.field_thumbpath = str4;
        if (!bool3) {
          break label1311;
        }
        localObject = str3;
        label1110:
        localg.field_midimgpath = ((String)localObject);
        if ((!bool2) && (!bool3)) {
          break label1318;
        }
        bool1 = true;
        label1130:
        this.iZu = bool1;
        localObject = this.TAG;
        if (localg.field_fileType != com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) {
          break label1324;
        }
      }
      label1304:
      label1311:
      label1318:
      label1324:
      for (bool1 = true;; bool1 = false)
      {
        Log.d((String)localObject, "hevc upload full size %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        break;
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(str2);
        bool1 = ImgUtil.identifyImgType(str2).equals(".png");
        if ((this.iXp == 0) && (!bool1) && (bq(str2, str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          paramg.Ou(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(paramg.iXm));
          bool2 = bool1;
          localObject = str3;
          break;
        }
        localObject = str2;
        break label1087;
        localObject = str1;
        break label1110;
        bool1 = false;
        break label1130;
      }
      label1330:
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"));
      localg.field_midFileLength = Util.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      break label708;
      label1379:
      Log.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.iXy });
    }
    label1403:
    if (Util.nullAsNil(paramg.iXy).length() <= 0)
    {
      paramg.Ot("CDNINFO_SEND");
      paramg.cSx = 4096;
    }
    AppMethodBeat.o(150700);
    return true;
  }
  
  private boolean a(g paramg, int paramInt1, long paramLong, int paramInt2, com.tencent.mm.i.d paramd, String paramString)
  {
    AppMethodBeat.i(169189);
    Log.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.iYT, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    Log.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(ac.jOD), Long.valueOf(this.iYP), Long.valueOf(this.hmj) });
    long l = paramLong;
    if (10007 == ac.jOC)
    {
      l = paramLong;
      if (ac.jOD != 0)
      {
        l = ac.jOD;
        ac.jOD = 0;
      }
    }
    b(paramg.localId, paramInt1, paramg.iKP);
    paramg.setOffset(paramInt1);
    paramg.yF(l);
    Object localObject;
    if (h.b(paramg))
    {
      if (this.iYP == this.hmj) {
        break label522;
      }
      localObject = q.bcR().c(Long.valueOf(this.iYP));
      ((g)localObject).yF(l);
      ((g)localObject).tf(paramg.iKP);
      ((g)localObject).setOffset(paramg.iKP);
      q.bcR().a(Long.valueOf(this.iYP), (g)localObject);
    }
    while (h.b(paramg))
    {
      if (Util.isNullOrNil(this.iYT)) {
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(paramg.iKP - this.startOffset) });
      }
      this.dCM.setStatus(2);
      this.dCM.yF(l);
      this.dCM.BB(paramString);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.iXv, this.dCM);
      if (r.jpw != null) {
        r.jpw.s(this.dCM);
      }
      if (this.iYS != null) {
        this.iYS.AH(0L);
      }
      if (u.jaE != null)
      {
        localObject = this.iZv;
        paramg = (g)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramg = br.KB(paramString);
        }
        u.jaE.a(this.hmj, this.dCM, this.rr, this.hmk, this.hmr, paramd, paramg);
      }
      if (this.iZn != null) {
        this.iZn.aYO();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      k.to((int)this.iYP);
      AppMethodBeat.o(169189);
      return false;
      label522:
      localObject = q.bcR().c(Long.valueOf(paramg.localId));
      ((g)localObject).yF(l);
      ((g)localObject).tf(paramg.iKP);
      ((g)localObject).setOffset(paramg.iKP);
      q.bcR().a(Long.valueOf(((g)localObject).localId), (g)localObject);
    }
    AppMethodBeat.o(169189);
    return true;
  }
  
  private void b(final long paramLong, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150707);
    if (this.iYO != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(223621);
          p localp = p.bcF();
          long l1 = paramLong;
          long l2 = paramInt1;
          long l3 = this.iZD;
          if (localp.iZG.containsKey(Long.valueOf(l1))) {}
          for (p.d locald = (p.d)localp.iZG.get(Long.valueOf(l1));; locald = new p.d())
          {
            locald.offset = l3;
            locald.total = l2;
            localp.iZG.put(Long.valueOf(l1), locald);
            n.G(n.this).a(this.iZD, paramInt1, n.this);
            AppMethodBeat.o(223621);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(150707);
  }
  
  private g bcB()
  {
    AppMethodBeat.i(150692);
    if (this.hml == null) {
      this.hml = q.bcR().c(Long.valueOf(this.hmj));
    }
    g localg = this.hml;
    AppMethodBeat.o(150692);
    return localg;
  }
  
  private g bcC()
  {
    AppMethodBeat.i(150693);
    if (this.iZl == null) {
      this.iZl = q.bcR().c(Long.valueOf(this.iYP));
    }
    g localg = this.iZl;
    AppMethodBeat.o(150693);
    return localg;
  }
  
  private boolean bq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150701);
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).cEO())
    {
      AppMethodBeat.o(150701);
      return false;
    }
    if (com.tencent.mm.vfs.s.boW(paramString1) > 0L)
    {
      if (com.tencent.mm.vfs.s.boW(paramString2) > 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(944, 9);
        com.tencent.mm.vfs.s.deleteFile(paramString2);
      }
      if (!com.tencent.mm.vfs.s.YS(paramString2)) {
        com.tencent.mm.vfs.s.bpa(paramString2);
      }
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).fO(paramString1, paramString2) == 0)
      {
        AppMethodBeat.o(150701);
        return true;
      }
      Log.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
    }
    AppMethodBeat.o(150701);
    return false;
  }
  
  private int tr(int paramInt)
  {
    AppMethodBeat.i(150703);
    Log.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.iZn != null) {
      this.iZn.aYO();
    }
    AppMethodBeat.o(150703);
    return -1;
  }
  
  public final ca bcD()
  {
    AppMethodBeat.i(223622);
    if (this.dCM == null) {
      Log.e(this.TAG, "msg is null. %s", new Object[] { Util.getStack() });
    }
    ca localca = this.dCM;
    AppMethodBeat.o(223622);
    return localca;
  }
  
  public final void bcE()
  {
    AppMethodBeat.i(150705);
    Log.i(this.TAG, "send img from system");
    this.hmr = true;
    AppMethodBeat.o(150705);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(150702);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150690);
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEt("SendImgSpeeder");
        AppMethodBeat.o(150690);
      }
    }, 100L);
    if (this.hmj < 0L)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 204L, 1L, false);
      Log.e(this.TAG, "doScene invalid imgLocalId:" + this.hmj);
      i = tr(-1);
      AppMethodBeat.o(150702);
      return i;
    }
    if (this.dCM == null)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 203L, 1L, false);
      Log.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.hmj) });
      k.tp((int)this.iYP);
      i = tr(-2);
      AppMethodBeat.o(150702);
      return i;
    }
    this.callback = parami;
    prepareDispatcher(paramg);
    enu localenu = (enu)this.rr.iLK.iLR;
    g localg = bcB();
    parami = q.bcR().tm((int)localg.localId);
    if (parami != null)
    {
      if (parami.status == -1)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 202L, 1L, false);
        Log.e(this.TAG, "doScene hd img info is null or error.");
        i = tr(-3);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else if ((localg == null) || (localg.status == -1))
    {
      Log.e(this.TAG, "doScene img info is null or error.");
      i = tr(-4);
      AppMethodBeat.o(150702);
      return i;
    }
    String str1;
    if (a.a.anC().DQ(this.dCM.field_talker))
    {
      localenu.KHq = a.a.anC().o(this.dCM);
      Log.i(this.TAG, "upload img msg source %s", new Object[] { localenu.KHq });
      str1 = q.bcR().o(localg.iXm, "", "");
      parami = q.bcR().o(localg.iXo, "", "");
      if (!Util.isNullOrNil(localg.iXn)) {
        q.bcR().o(localg.iXn, "", "");
      }
      if ((com.tencent.mm.vfs.s.boW(str1) <= 0L) || (com.tencent.mm.vfs.s.boW(parami) <= 0L))
      {
        Log.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.hmj), Long.valueOf(com.tencent.mm.vfs.s.boW(str1)), Long.valueOf(com.tencent.mm.vfs.s.boW(parami)), str1, parami });
        i = tr(-5);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else
    {
      if (Util.isNullOrNil(this.iZv))
      {
        parami = com.tencent.mm.vfs.s.bhK(this.iZt);
        localObject = v.jNy;
        this.iZv = v.Ss(parami);
      }
      if (!Util.isNullOrNil(this.iZv)) {}
      for (parami = br.KC(this.iZv);; parami = br.ajw())
      {
        if (((parami != null) && (!parami.equals(this.dCM.fqK))) || ((parami == null) && (!Util.isNullOrNil(this.dCM.fqK))))
        {
          this.dCM.BB(parami);
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.dCM.field_msgId, this.dCM);
        }
        localenu.KHq = this.dCM.fqK;
        break;
      }
    }
    if ((localenu.NlB == null) || (Util.isNullOrNil(localenu.NlB.MTo)))
    {
      if (Util.isNullOrNil(this.iYT))
      {
        Log.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.dCM.field_createTime), this.dCM.field_talker, Long.valueOf(this.dCM.field_msgId), Long.valueOf(this.hmj), Integer.valueOf(this.iXp) });
        this.iYT = com.tencent.mm.an.c.a("upimg", this.dCM.field_createTime, this.dCM.field_talker, this.dCM.field_msgId + "_" + this.hmj + "_" + this.iXp);
      }
      localenu.NlB = new dqi().bhy(this.iYT);
      parami = this.dCM;
      parami.fQY = this.iYT;
      parami.fqk = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.startOffset = localg.offset;
      if (this.iXp != 1) {
        break label940;
      }
    }
    label940:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.gVY = i;
      if (!a(localg, 0)) {
        break;
      }
      Log.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localenu.NlB.MTo });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (as.bjw(this.dkV))
    {
      Log.w(this.TAG, "just return without using cdn for byp. %s", new Object[] { this.dkV });
      k.tp((int)this.iYP);
      i = tr(-99);
      AppMethodBeat.o(150702);
      return i;
    }
    if (com.tencent.mm.n.h.aqJ().getInt("UploadMsgImgType", 0) == 1) {}
    for (boolean bool1 = true; ab.JF(this.dCM.field_talker); bool1 = false)
    {
      Log.w(this.TAG, "cdntra not use parallel-upload user:%s", new Object[] { this.dCM.field_talker });
      i = 0;
      if (i == 0) {
        break label1489;
      }
      Log.d(this.TAG, "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { localenu.NlB.MTo });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smg, 0)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label1148;
      }
      Log.i(this.TAG, "NOT ALLOW USE PARALLEL UPLOAD IMG");
      i = 0;
      break;
    }
    label1148:
    Object localObject = q.bcR().o(localg.iXm, "", "");
    String str2 = q.bcR().o(localg.iXo, "", "");
    parami = q.bcR().o(localg.iXn, "", "");
    boolean bool2 = Util.isNullOrNil(parami);
    if (bool2) {
      parami = (com.tencent.mm.ak.i)localObject;
    }
    for (;;)
    {
      String str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(parami);
      String str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX((String)localObject);
      com.tencent.mm.pluginsdk.f.d locald = new com.tencent.mm.pluginsdk.f.d();
      locald.iXv = this.iXv;
      locald.JTT = this.iZw;
      locald.scene = 1;
      locald.fileType = 2;
      if (!bool2) {
        locald.fileType = 1;
      }
      String str5;
      if ((bool1) && (this.iXp == 0))
      {
        localg.Ou(str4);
        str5 = q.bcR().o(localg.iXr, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).fO((String)localObject, str5);
        if (i != 0) {
          break label1480;
        }
        localg.ti(1);
        localg.tf((int)com.tencent.mm.vfs.s.boW(str5));
      }
      for (;;)
      {
        Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.hmj), str5, Integer.valueOf(i), Integer.valueOf(localg.iKP) });
        locald.thumbPath = str2;
        locald.iXn = parami;
        locald.JTV = str3;
        locald.fullPath = ((String)localObject);
        locald.JTU = str4;
        parami = new com.tencent.mm.pluginsdk.f.c();
        parami.JTQ = bool1;
        parami.a(locald);
        i = 1;
        break;
        label1480:
        localg.ti(0);
      }
      label1489:
      if ((bool1) && (this.iXp == 0))
      {
        localg.Ou(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(localg.iXm));
        parami = q.bcR().o(localg.iXr, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).fO(str1, parami);
        if (i != 0) {
          break label1693;
        }
        localg.ti(1);
        localg.tf((int)com.tencent.mm.vfs.s.boW(parami));
      }
      for (;;)
      {
        Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.hmj), parami, Integer.valueOf(i), Integer.valueOf(localg.iKP) });
        i = localg.iXw;
        if (i < securityLimitCount()) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 201L, 1L, false);
        Log.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
        k.tp((int)this.iYP);
        i = tr(-6);
        AppMethodBeat.o(150702);
        return i;
        label1693:
        localg.ti(0);
      }
      localg.te(i + 1);
      localg.cSx = 512;
      q.bcR().a(Long.valueOf(this.hmj), localg);
      int j = localg.iKP - localg.offset;
      i = j;
      if (j > this.iZm) {
        i = this.iZm;
      }
      com.tencent.mm.vfs.s.boW(str1);
      if (localg.iXs == 1) {}
      for (parami = q.bcR().o(localg.iXr, "", "");; parami = q.bcR().o(localg.iXm, "", ""))
      {
        parami = com.tencent.mm.vfs.s.aW(parami, localg.offset, i);
        if ((parami != null) && (parami.length > 0)) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 199L, 1L, false);
        Log.e(this.TAG, "doScene, file read buf error.");
        i = tr(-8);
        AppMethodBeat.o(150702);
        return i;
      }
      localenu.BsH = parami.length;
      localenu.BsF = localg.iKP;
      localenu.BsG = localg.offset;
      localenu.BsI = new SKBuiltinBuffer_t().setBuffer(parami);
      localenu.Mwb = localg.iXs;
      if (this.iYS != null) {
        this.iYS.bgi();
      }
      i = dispatch(paramg, this.rr, this);
      if (i < 0)
      {
        Log.e(this.TAG, "doScene netId error");
        k.tp((int)this.iYP);
        i = tr(-9);
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
    Log.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.iYT);
    params = (env)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(params.LbO);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.iYT)))
    {
      Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.iYT });
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 198L, 1L, false);
      k.tp((int)this.iYP);
      k.to((int)this.iYP);
      com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.iZn != null) {
        this.iZn.aYO();
      }
      AppMethodBeat.o(150704);
      return;
    }
    this.iZm = params.BsH;
    if (this.iZm > 16384) {
      this.iZm = 16384;
    }
    paramString = bcB();
    Log.v(this.TAG, "onGYNetEnd localId:" + this.hmj + "  totalLen:" + paramString.iKP + " offSet:" + paramString.offset);
    if ((params.BsG < 0) || ((params.BsG > paramString.iKP) && (paramString.iKP > 0)))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 197L, 1L, false);
      Log.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + params.BsG + " img totalLen = " + paramString.iKP);
      k.tp((int)this.iYP);
      k.to((int)this.iYP);
      com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY), Integer.valueOf(0) });
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.iZn != null) {
        this.iZn.aYO();
      }
      AppMethodBeat.o(150704);
      return;
    }
    if ((params.BsG < paramString.offset) || ((h.b(paramString)) && (this.iZm <= 0)))
    {
      Log.e(this.TAG, "onGYNetEnd invalid data startPos = " + params.BsG + " totalLen = " + paramString.iKP + " off:" + paramString.offset);
      k.tp((int)this.iYP);
      k.to((int)this.iYP);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.iZn != null) {
        this.iZn.aYO();
      }
      AppMethodBeat.o(150704);
      return;
    }
    Log.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + params.BsG);
    if ((a(paramString, params.BsG, params.Brn, params.CreateTime, null, params.KHq)) && (doScene(dispatcher(), this.callback) < 0))
    {
      k.to((int)this.iYP);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.iZn != null) {
        this.iZn.aYO();
      }
    }
    AppMethodBeat.o(150704);
  }
  
  public final int securityLimitCount()
  {
    if (this.iXp == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final void tq(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(150697);
    if (this.dCM == null)
    {
      Log.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.iXv), Integer.valueOf(paramInt) });
      AppMethodBeat.o(150697);
      return;
    }
    if (this.iZq)
    {
      if (this.dCM.fQW == 0)
      {
        boolean bool = q.bcR().a(this.dCM, this.iYW, paramInt);
        ca localca = this.dCM;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localca.nJ(paramInt);
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.iXv, this.dCM);
          AppMethodBeat.o(150697);
          return;
        }
      }
    }
    else {
      q.bcR().c(this.dCM.field_imgPath, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()));
    }
    AppMethodBeat.o(150697);
  }
  
  public final class a
  {
    public com.tencent.mm.ak.n iZE;
    
    public a(com.tencent.mm.ak.n paramn)
    {
      this.iZE = paramn;
    }
    
    final void aYO()
    {
      AppMethodBeat.i(150691);
      if (n.b(n.this) == n.c(n.this)) {}
      for (Object localObject = n.d(n.this);; localObject = n.e(n.this))
      {
        if (((g)localObject).iXz == 1)
        {
          com.tencent.mm.plugin.report.service.g.Wm(23);
          com.tencent.mm.plugin.report.service.g.Wm(21);
        }
        Log.i(n.f(n.this), "UploadEndWrapper onUploadEnd %s done", new Object[] { n.e(n.d(n.this)) });
        if (q.bcR().a(Long.valueOf(n.c(n.this)), n.d(n.this)) < 0)
        {
          Log.e(n.f(n.this), "update db failed local id:" + n.c(n.this) + " server id:" + n.d(n.this).dTS);
          k.tp((int)n.b(n.this));
          k.to((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -1, "", n.this);
        }
        if (n.c(n.this) != n.b(n.this))
        {
          Log.i(n.f(n.this), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { n.e(n.e(n.this)) });
          q.bcR().a(Long.valueOf(n.b(n.this)), n.e(n.this));
        }
        if ((!CrashReportFactory.hasDebuger()) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
          break;
        }
        localObject = q.bcR().bcz();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          Log.i(n.f(n.this), "UploadEndWrapper onUploadEnd duminfo %s %s", new Object[] { Integer.valueOf(i), n.e((g)((List)localObject).get(i)) });
          i += 1;
        }
      }
      n.a(n.this, n.c(n.this));
      if (n.b(n.this) != n.c(n.this)) {
        n.a(n.this, n.b(n.this));
      }
      if (this.iZE != null) {
        this.iZE.aYO();
      }
      n.this.tq(n.h(n.this));
      n.i(n.this);
      AppMethodBeat.o(150691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.n
 * JD-Core Version:    0.7.0.1
 */