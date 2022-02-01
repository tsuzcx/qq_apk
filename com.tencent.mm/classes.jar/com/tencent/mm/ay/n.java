package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.an.x;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelstat.q.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.th;
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
  extends com.tencent.mm.an.q
  implements m
{
  public static boolean DEBUG = true;
  private static long lPS;
  private String TAG;
  private com.tencent.mm.an.i callback;
  public String fcD;
  private ca fvt;
  private int jGU;
  private long jXT;
  private int jXU;
  private g jXV;
  private boolean jYb;
  private int lNK;
  private long lNP;
  private String lPD;
  private String lPE;
  private boolean lPF;
  private g lPG;
  private int lPH;
  public a lPI;
  private String lPJ;
  public String lPK;
  public boolean lPL;
  private String lPM;
  private String lPN;
  public String lPO;
  private boolean lPP;
  private String lPQ;
  private com.tencent.mm.pluginsdk.g.d.a lPR;
  private final j lPi;
  public long lPj;
  private com.tencent.mm.modelstat.g lPm;
  private String lPn;
  private int lPo;
  private int lPr;
  private com.tencent.mm.i.g.a lPx;
  private float latitude;
  private float longtitude;
  private final com.tencent.mm.an.d rr;
  private int scene;
  private long startTime;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150698);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.lPD = "";
    this.lPE = "";
    this.lPF = true;
    this.lPH = 16384;
    this.lNK = 0;
    this.fvt = null;
    this.lPm = null;
    this.lPn = "";
    this.startTime = 0L;
    this.lPo = -1;
    this.jGU = 0;
    this.lPI = new a(null);
    this.lPP = false;
    this.lPR = new com.tencent.mm.pluginsdk.g.d.a()
    {
      public final void O(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(215947);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.wp((int)n.b(n.this));
        k.wo((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).bid();
        }
        AppMethodBeat.o(215947);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(215949);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(215949);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(215949);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(215944);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.mHi) });
        long l1 = paramAnonymousa.mHi;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.smU;
        final g localg = n.d(n.this);
        Object localObject1 = q.bmh().r(localg.lNH, "", "");
        Object localObject2 = q.bmh().r(localg.lNI, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.u.bBQ(q.bmh().r(localg.lNJ, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.u.bBQ((String)localObject2));
        locald.field_fileLength = paramAnonymousa.mHi;
        com.tencent.mm.aq.f.bkh();
        locald.field_filecrc = com.tencent.mm.aq.a.Vt((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.VS((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
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
            localg.VQ((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).VQ((String)localObject1);
            }
            localObject1 = c.blC();
            ((c)localObject1).jXU = n.q(n.this);
            ((c)localObject1).lNr = ((eyc)d.b.b(n.p(n.this).lBR));
            ((c)localObject1).lNs = localg;
            ((c)localObject1).aesKey = paramAnonymousa.QTm;
            ((c)localObject1).jYa = locald;
            ((c)localObject1).lNt = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(222057);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.wp((int)n.b(n.this));
                  k.wo((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).bid();
                  }
                  AppMethodBeat.o(222057);
                  return;
                }
                n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(222057);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bnl().aEv();
            AppMethodBeat.o(215944);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.lNK == 0)
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
    this.lPx = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(189706);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(189706);
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
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Wg(paramAnonymousd.iUs))
          {
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bpa();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.aq.f.bkg().Vy(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(189706);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(189706);
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
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243170);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).wd(0);
                n.m(n.this).setCreateTime(bq.RP(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.aq.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (eyc)d.b.b(n.p(n.this).lBR);
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(243170);
                  return;
                  ((eyc)localObject).Uym = new eaf().btQ(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(189706);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(243999);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(243999);
                }
              });
              AppMethodBeat.o(189706);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new th();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new ae(paramAnonymousc).bpa();
            new com.tencent.mm.f.b.a.ac(paramAnonymousc).bpa();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.CqV == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.CqV, paramAnonymousString.BaseResponse.Tef.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
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
            paramAnonymousc = n.Wg(paramAnonymousd.iUs);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.VS(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3129;
          }
        }
        label2563:
        label2735:
        label3126:
        label3129:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            localObject = paramAnonymousString;
            if (paramAnonymousd.arK())
            {
              if (!Util.isNullOrNil(n.y(n.this))) {
                break label2563;
              }
              Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              n.a(n.this, localg);
              localg.VQ((String)localObject);
              n.a(n.this, (String)localObject);
              if (n.b(n.this) != n.c(n.this)) {
                n.e(n.this).VQ((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2735;
              }
              paramAnonymousString = c.blC();
              paramAnonymousString.jXU = n.q(n.this);
              paramAnonymousString.lNr = ((eyc)d.b.b(n.p(n.this).lBR));
              paramAnonymousString.lNs = localg;
              paramAnonymousString.aesKey = n.z(n.this);
              paramAnonymousString.jYa = paramAnonymousd;
              paramAnonymousString.lNt = new o.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238521);
                  new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
                  Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    k.wp((int)n.b(n.this));
                    k.wo((int)n.b(n.this));
                    n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).bid();
                    }
                    AppMethodBeat.o(238521);
                    return;
                  }
                  n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238521);
                }
              };
              paramAnonymousString.toUser = n.m(n.this).field_talker;
              paramAnonymousString.bnl().aEv();
              break;
              paramAnonymousInt = localg.source;
              break label1361;
              l1 = paramAnonymousd.field_midimgLength;
              break label1606;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label3126;
              }
              if (localg.lNK == 0)
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
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
            paramAnonymousString = new th();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l1 = paramAnonymousString.HlH;
              Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
              if (n.a(n.this, localg, localg.lAW, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.RII))
              {
                n.g(n.this).onSceneEnd(0, 0, "", n.this);
                if (n.o(n.this) != null) {
                  n.o(n.this).bid();
                }
              }
              AppMethodBeat.o(189706);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
            }
            if (n.o(n.this) == null) {
              break;
            }
            n.o(n.this).bid();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(189719);
        Object localObject1 = (eyc)d.b.b(n.p(n.this).lBR);
        tg localtg = new tg();
        localtg.ScK = ((eyc)localObject1).Uym.Ufy;
        localtg.CRR = ((eyc)localObject1).RID.Ufy;
        localtg.CRQ = ((eyc)localObject1).RIE.Ufy;
        localtg.ScL = ((eyc)localObject1).Uyt;
        localtg.ScM = ((eyc)localObject1).Uyu;
        localtg.CPw = n.A(n.this);
        localtg.ScO = n.B(n.this);
        localtg.ScP = n.C(n.this);
        localtg.ScQ = n.D(n.this);
        localtg.RII = ((eyc)localObject1).RII;
        localtg.ScV = n.z(n.this);
        localtg.lVG = ((eyc)localObject1).lVG;
        localtg.RFI = ((eyc)localObject1).RFI;
        localtg.RFK = ((eyc)localObject1).RFK;
        localtg.RFJ = ((eyc)localObject1).RFJ;
        localtg.ScZ = ((eyc)localObject1).ScZ;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bmh().r(((g)localObject1).lNH, "", "");
        com.tencent.mm.aq.f.bkh();
        localtg.ScX = com.tencent.mm.aq.a.Vt((String)localObject2);
        localtg.ScY = ((g)localObject1).lNL;
        int i;
        label342:
        String str;
        if (localtg.ScY <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localtg.ScY = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localtg.Cqs = 2;
            if (localtg.ScY == 3) {
              localtg.Cqs = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localtg.ScL), Integer.valueOf(localtg.ScM), localtg.RII, localtg.CRQ, localtg.ScV, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).lNH, localObject2, Integer.valueOf(localtg.ScX), Integer.valueOf(localtg.ScY), Integer.valueOf(localtg.Cqs) });
            paramAnonymousString = new com.tencent.mm.an.d.a();
            paramAnonymousString.lBU = localtg;
            paramAnonymousString.lBV = new eyd();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.lBW = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bgN();
            localObject2 = n.F(n.this).biw();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).biq()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).biq())) {
            break label776;
          }
          if (!x.a(((e)localObject2).sE(1), ((e)localObject2).bip(), ((e)localObject2).bir(), ((com.tencent.mm.an.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localtg.ScK });
          AppMethodBeat.o(189719);
          return;
          i = 1;
          break;
          localtg.Cqs = 1;
          break label342;
          localtg.Cqs = 3;
          break label342;
          localtg.Cqs = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(189727);
        PInt localPInt = new PInt();
        th localth = new th();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.an.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.aHF().kcd.lCD.biw().sE(1), localPInt, localth);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localth.ScV, localth.RNi, localth.ScK });
          n.c(n.this, localth.ScV);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localth.Sda);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localth.Sda) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(189727);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(189727);
        }
        return null;
      }
    };
    this.jYb = false;
    Log.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.getStack() });
    this.lPj = paramInt1;
    this.jXT = paramInt1;
    this.lNK = paramInt2;
    Object localObject1 = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject1).lBU = new eyc();
    ((com.tencent.mm.an.d.a)localObject1).lBV = new eyd();
    ((com.tencent.mm.an.d.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((com.tencent.mm.an.d.a)localObject1).funcId = 110;
    ((com.tencent.mm.an.d.a)localObject1).lBW = 9;
    ((com.tencent.mm.an.d.a)localObject1).respCmdId = 1000000009;
    this.rr = ((com.tencent.mm.an.d.a)localObject1).bgN();
    this.lPi = null;
    Log.d(this.TAG, "FROM B SERVICE:" + this.lPj);
    if (!k.wn((int)this.lPj))
    {
      this.lPj = -1L;
      AppMethodBeat.o(150698);
      return;
    }
    localObject1 = q.bmh().b(Long.valueOf(this.lPj));
    this.lNP = ((g)localObject1).lNP;
    if (paramInt2 == 1)
    {
      this.jXT = ((g)localObject1).lNR;
      localObject1 = q.bmh().b(Long.valueOf(this.jXT));
    }
    for (;;)
    {
      Object localObject2 = q.bmh().wm((int)((g)localObject1).localId);
      if (localObject2 != null) {
        this.lNP = ((g)localObject2).lNP;
      }
      this.fvt = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(this.lNP);
      if ((this.fvt != null) && (this.fvt.field_msgId != this.lNP))
      {
        Log.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.lNP) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 206L, 1L, false);
        this.fvt = null;
        AppMethodBeat.o(150698);
        return;
      }
      if (this.fvt != null)
      {
        localObject2 = (eyc)d.b.b(this.rr.lBR);
        ((eyc)localObject2).RID = new eaf().btQ(com.tencent.mm.model.z.bcZ());
        ((eyc)localObject2).RIE = new eaf().btQ(this.fvt.field_talker);
        ((eyc)localObject2).Hna = ((g)localObject1).offset;
        ((eyc)localObject2).HmZ = ((g)localObject1).lAW;
        ((eyc)localObject2).COi = this.fvt.getType();
        ((eyc)localObject2).ThK = paramInt2;
        if (!ag.dj(MMApplicationContext.getContext())) {
          break label880;
        }
      }
      label880:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((eyc)localObject2).SmH = paramInt1;
        ((eyc)localObject2).Uns = ((g)localObject1).source;
        ((eyc)localObject2).ScY = ((g)localObject1).lNL;
        ((eyc)localObject2).ScY = ((g)localObject1).lNL;
        ((eyc)localObject2).Uyt = this.fvt.ilj;
        ((eyc)localObject2).Uyu = this.fvt.ili;
        a locala = h.VS(this.fvt.field_content);
        if ((locala != null) && (!Util.isNullOrNil(locala.appId)))
        {
          this.jXU = ((g)localObject1).source;
          ((eyc)localObject2).lVG = locala.appId;
          ((eyc)localObject2).RFI = locala.mediaTagName;
          ((eyc)localObject2).RFK = locala.messageAction;
          ((eyc)localObject2).RFJ = locala.messageExt;
          this.lPJ = this.fvt.field_content;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.fvt.field_talker)) {
          ((eyc)localObject2).ScZ = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bws(this.fvt.field_talker);
        }
        Log.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((eyc)localObject2).Uyt), Integer.valueOf(((eyc)localObject2).Uyu) });
        Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((g)localObject1).source), Integer.valueOf(((eyc)localObject2).ScY) });
        if (((g)localObject1).offset == 0) {
          this.lPm = new com.tencent.mm.modelstat.g(getType(), true, ((g)localObject1).lAW);
        }
        AppMethodBeat.o(150698);
        return;
      }
    }
  }
  
  public n(int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(229037);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.lPD = "";
    this.lPE = "";
    this.lPF = true;
    this.lPH = 16384;
    this.lNK = 0;
    this.fvt = null;
    this.lPm = null;
    this.lPn = "";
    this.startTime = 0L;
    this.lPo = -1;
    this.jGU = 0;
    this.lPI = new a(null);
    this.lPP = false;
    this.lPR = new com.tencent.mm.pluginsdk.g.d.a()
    {
      public final void O(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(215947);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.wp((int)n.b(n.this));
        k.wo((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).bid();
        }
        AppMethodBeat.o(215947);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(215949);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(215949);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(215949);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(215944);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.mHi) });
        long l1 = paramAnonymousa.mHi;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.smU;
        final g localg = n.d(n.this);
        Object localObject1 = q.bmh().r(localg.lNH, "", "");
        Object localObject2 = q.bmh().r(localg.lNI, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.u.bBQ(q.bmh().r(localg.lNJ, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.u.bBQ((String)localObject2));
        locald.field_fileLength = paramAnonymousa.mHi;
        com.tencent.mm.aq.f.bkh();
        locald.field_filecrc = com.tencent.mm.aq.a.Vt((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.VS((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
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
            localg.VQ((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).VQ((String)localObject1);
            }
            localObject1 = c.blC();
            ((c)localObject1).jXU = n.q(n.this);
            ((c)localObject1).lNr = ((eyc)d.b.b(n.p(n.this).lBR));
            ((c)localObject1).lNs = localg;
            ((c)localObject1).aesKey = paramAnonymousa.QTm;
            ((c)localObject1).jYa = locald;
            ((c)localObject1).lNt = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(222057);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.wp((int)n.b(n.this));
                  k.wo((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).bid();
                  }
                  AppMethodBeat.o(222057);
                  return;
                }
                n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(222057);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bnl().aEv();
            AppMethodBeat.o(215944);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.lNK == 0)
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
    this.lPx = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(189706);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(189706);
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
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Wg(paramAnonymousd.iUs))
          {
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bpa();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.aq.f.bkg().Vy(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(189706);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(189706);
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
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243170);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).wd(0);
                n.m(n.this).setCreateTime(bq.RP(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.aq.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (eyc)d.b.b(n.p(n.this).lBR);
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(243170);
                  return;
                  ((eyc)localObject).Uym = new eaf().btQ(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(189706);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(243999);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(243999);
                }
              });
              AppMethodBeat.o(189706);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new th();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new ae(paramAnonymousc).bpa();
            new com.tencent.mm.f.b.a.ac(paramAnonymousc).bpa();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.CqV == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.CqV, paramAnonymousString.BaseResponse.Tef.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
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
            paramAnonymousc = n.Wg(paramAnonymousd.iUs);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.VS(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3129;
          }
        }
        label2563:
        label2735:
        label3126:
        label3129:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            localObject = paramAnonymousString;
            if (paramAnonymousd.arK())
            {
              if (!Util.isNullOrNil(n.y(n.this))) {
                break label2563;
              }
              Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              n.a(n.this, localg);
              localg.VQ((String)localObject);
              n.a(n.this, (String)localObject);
              if (n.b(n.this) != n.c(n.this)) {
                n.e(n.this).VQ((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2735;
              }
              paramAnonymousString = c.blC();
              paramAnonymousString.jXU = n.q(n.this);
              paramAnonymousString.lNr = ((eyc)d.b.b(n.p(n.this).lBR));
              paramAnonymousString.lNs = localg;
              paramAnonymousString.aesKey = n.z(n.this);
              paramAnonymousString.jYa = paramAnonymousd;
              paramAnonymousString.lNt = new o.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238521);
                  new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
                  Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    k.wp((int)n.b(n.this));
                    k.wo((int)n.b(n.this));
                    n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).bid();
                    }
                    AppMethodBeat.o(238521);
                    return;
                  }
                  n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238521);
                }
              };
              paramAnonymousString.toUser = n.m(n.this).field_talker;
              paramAnonymousString.bnl().aEv();
              break;
              paramAnonymousInt = localg.source;
              break label1361;
              l1 = paramAnonymousd.field_midimgLength;
              break label1606;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label3126;
              }
              if (localg.lNK == 0)
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
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
            paramAnonymousString = new th();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l1 = paramAnonymousString.HlH;
              Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
              if (n.a(n.this, localg, localg.lAW, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.RII))
              {
                n.g(n.this).onSceneEnd(0, 0, "", n.this);
                if (n.o(n.this) != null) {
                  n.o(n.this).bid();
                }
              }
              AppMethodBeat.o(189706);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
            }
            if (n.o(n.this) == null) {
              break;
            }
            n.o(n.this).bid();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(189719);
        Object localObject1 = (eyc)d.b.b(n.p(n.this).lBR);
        tg localtg = new tg();
        localtg.ScK = ((eyc)localObject1).Uym.Ufy;
        localtg.CRR = ((eyc)localObject1).RID.Ufy;
        localtg.CRQ = ((eyc)localObject1).RIE.Ufy;
        localtg.ScL = ((eyc)localObject1).Uyt;
        localtg.ScM = ((eyc)localObject1).Uyu;
        localtg.CPw = n.A(n.this);
        localtg.ScO = n.B(n.this);
        localtg.ScP = n.C(n.this);
        localtg.ScQ = n.D(n.this);
        localtg.RII = ((eyc)localObject1).RII;
        localtg.ScV = n.z(n.this);
        localtg.lVG = ((eyc)localObject1).lVG;
        localtg.RFI = ((eyc)localObject1).RFI;
        localtg.RFK = ((eyc)localObject1).RFK;
        localtg.RFJ = ((eyc)localObject1).RFJ;
        localtg.ScZ = ((eyc)localObject1).ScZ;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bmh().r(((g)localObject1).lNH, "", "");
        com.tencent.mm.aq.f.bkh();
        localtg.ScX = com.tencent.mm.aq.a.Vt((String)localObject2);
        localtg.ScY = ((g)localObject1).lNL;
        int i;
        label342:
        String str;
        if (localtg.ScY <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localtg.ScY = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localtg.Cqs = 2;
            if (localtg.ScY == 3) {
              localtg.Cqs = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localtg.ScL), Integer.valueOf(localtg.ScM), localtg.RII, localtg.CRQ, localtg.ScV, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).lNH, localObject2, Integer.valueOf(localtg.ScX), Integer.valueOf(localtg.ScY), Integer.valueOf(localtg.Cqs) });
            paramAnonymousString = new com.tencent.mm.an.d.a();
            paramAnonymousString.lBU = localtg;
            paramAnonymousString.lBV = new eyd();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.lBW = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bgN();
            localObject2 = n.F(n.this).biw();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).biq()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).biq())) {
            break label776;
          }
          if (!x.a(((e)localObject2).sE(1), ((e)localObject2).bip(), ((e)localObject2).bir(), ((com.tencent.mm.an.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localtg.ScK });
          AppMethodBeat.o(189719);
          return;
          i = 1;
          break;
          localtg.Cqs = 1;
          break label342;
          localtg.Cqs = 3;
          break label342;
          localtg.Cqs = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(189727);
        PInt localPInt = new PInt();
        th localth = new th();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.an.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.aHF().kcd.lCD.biw().sE(1), localPInt, localth);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localth.ScV, localth.RNi, localth.ScK });
          n.c(n.this, localth.ScV);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localth.Sda);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localth.Sda) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(189727);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(189727);
        }
        return null;
      }
    };
    this.jYb = false;
    Log.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramj, Util.getStack() });
    this.lPj = paramInt1;
    this.jXT = paramInt1;
    this.lNK = paramInt2;
    paramj = new com.tencent.mm.an.d.a();
    paramj.lBU = new eyc();
    paramj.lBV = new eyd();
    paramj.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    paramj.funcId = 110;
    paramj.lBW = 9;
    paramj.respCmdId = 1000000009;
    this.rr = paramj.bgN();
    this.lPi = null;
    Log.d(this.TAG, "FROM C SERVICE:" + this.lPj);
    if (!k.wn((int)this.lPj))
    {
      this.lPj = -1L;
      AppMethodBeat.o(229037);
      return;
    }
    paramj = q.bmh().b(Long.valueOf(this.lPj));
    this.lNP = paramj.lNP;
    paramj.setStatus(0);
    paramj.EG(0L);
    paramj.we(0);
    q.bmh().a((int)this.jXT, paramj);
    if (paramInt2 == 1)
    {
      this.jXT = paramj.lNR;
      paramj = q.bmh().b(Long.valueOf(this.jXT));
    }
    for (;;)
    {
      this.fvt = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(this.lNP);
      Object localObject;
      if (this.fvt != null)
      {
        this.fvt.setStatus(1);
        localObject = paramj.lNJ;
        if ((localObject == null) || (!((String)localObject).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label789;
        }
        this.fvt.Jn((String)localObject);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.lNP, this.fvt);
        localObject = (eyc)d.b.b(this.rr.lBR);
        ((eyc)localObject).RID = new eaf().btQ(com.tencent.mm.model.z.bcZ());
        ((eyc)localObject).RIE = new eaf().btQ(this.fvt.field_talker);
        ((eyc)localObject).Hna = paramj.offset;
        ((eyc)localObject).HmZ = paramj.lAW;
        ((eyc)localObject).COi = this.fvt.getType();
        ((eyc)localObject).ThK = paramInt2;
        if (!ag.dj(MMApplicationContext.getContext())) {
          break label819;
        }
      }
      label789:
      label819:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((eyc)localObject).SmH = paramInt1;
        ((eyc)localObject).Uns = paramj.source;
        ((eyc)localObject).ScY = paramj.lNL;
        ((eyc)localObject).Uyt = this.fvt.ilj;
        ((eyc)localObject).Uyu = this.fvt.ili;
        if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.fvt.field_talker)) {
          ((eyc)localObject).ScZ = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bws(this.fvt.field_talker);
        }
        Log.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((eyc)localObject).Uyt), Integer.valueOf(((eyc)localObject).Uyu) });
        Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramj.source), Integer.valueOf(((eyc)localObject).ScY) });
        if (paramj.offset == 0) {
          this.lPm = new com.tencent.mm.modelstat.g(getType(), true, paramj.lAW);
        }
        AppMethodBeat.o(229037);
        return;
        this.fvt.Jn("THUMBNAIL://" + paramj.localId);
        break;
      }
    }
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, j paramj)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramj, 0, "", "");
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, j paramj, int paramInt3, com.tencent.mm.an.n paramn, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramj, paramInt3, "", "", true, paramInt4);
    AppMethodBeat.i(228955);
    this.lPI = new a(paramn);
    AppMethodBeat.o(228955);
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
    AppMethodBeat.i(228985);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.lPD = "";
    this.lPE = "";
    this.lPF = true;
    this.lPH = 16384;
    this.lNK = 0;
    this.fvt = null;
    this.lPm = null;
    this.lPn = "";
    this.startTime = 0L;
    this.lPo = -1;
    this.jGU = 0;
    this.lPI = new a(null);
    this.lPP = false;
    this.lPR = new com.tencent.mm.pluginsdk.g.d.a()
    {
      public final void O(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(215947);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.wp((int)n.b(n.this));
        k.wo((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).bid();
        }
        AppMethodBeat.o(215947);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(215949);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(215949);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(215949);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(215944);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.mHi) });
        long l1 = paramAnonymousa.mHi;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.smU;
        final g localg = n.d(n.this);
        Object localObject1 = q.bmh().r(localg.lNH, "", "");
        Object localObject2 = q.bmh().r(localg.lNI, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.u.bBQ(q.bmh().r(localg.lNJ, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.u.bBQ((String)localObject2));
        locald.field_fileLength = paramAnonymousa.mHi;
        com.tencent.mm.aq.f.bkh();
        locald.field_filecrc = com.tencent.mm.aq.a.Vt((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.VS((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
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
            localg.VQ((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).VQ((String)localObject1);
            }
            localObject1 = c.blC();
            ((c)localObject1).jXU = n.q(n.this);
            ((c)localObject1).lNr = ((eyc)d.b.b(n.p(n.this).lBR));
            ((c)localObject1).lNs = localg;
            ((c)localObject1).aesKey = paramAnonymousa.QTm;
            ((c)localObject1).jYa = locald;
            ((c)localObject1).lNt = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(222057);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.wp((int)n.b(n.this));
                  k.wo((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).bid();
                  }
                  AppMethodBeat.o(222057);
                  return;
                }
                n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(222057);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bnl().aEv();
            AppMethodBeat.o(215944);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.lNK == 0)
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
    this.lPx = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(189706);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(189706);
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
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Wg(paramAnonymousd.iUs))
          {
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bpa();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.aq.f.bkg().Vy(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(189706);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(189706);
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
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243170);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).wd(0);
                n.m(n.this).setCreateTime(bq.RP(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.aq.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (eyc)d.b.b(n.p(n.this).lBR);
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(243170);
                  return;
                  ((eyc)localObject).Uym = new eaf().btQ(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(189706);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(243999);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(243999);
                }
              });
              AppMethodBeat.o(189706);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new th();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new ae(paramAnonymousc).bpa();
            new com.tencent.mm.f.b.a.ac(paramAnonymousc).bpa();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.CqV == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.CqV, paramAnonymousString.BaseResponse.Tef.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
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
            paramAnonymousc = n.Wg(paramAnonymousd.iUs);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.VS(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3129;
          }
        }
        label2563:
        label2735:
        label3126:
        label3129:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            localObject = paramAnonymousString;
            if (paramAnonymousd.arK())
            {
              if (!Util.isNullOrNil(n.y(n.this))) {
                break label2563;
              }
              Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              n.a(n.this, localg);
              localg.VQ((String)localObject);
              n.a(n.this, (String)localObject);
              if (n.b(n.this) != n.c(n.this)) {
                n.e(n.this).VQ((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2735;
              }
              paramAnonymousString = c.blC();
              paramAnonymousString.jXU = n.q(n.this);
              paramAnonymousString.lNr = ((eyc)d.b.b(n.p(n.this).lBR));
              paramAnonymousString.lNs = localg;
              paramAnonymousString.aesKey = n.z(n.this);
              paramAnonymousString.jYa = paramAnonymousd;
              paramAnonymousString.lNt = new o.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238521);
                  new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
                  Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    k.wp((int)n.b(n.this));
                    k.wo((int)n.b(n.this));
                    n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).bid();
                    }
                    AppMethodBeat.o(238521);
                    return;
                  }
                  n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238521);
                }
              };
              paramAnonymousString.toUser = n.m(n.this).field_talker;
              paramAnonymousString.bnl().aEv();
              break;
              paramAnonymousInt = localg.source;
              break label1361;
              l1 = paramAnonymousd.field_midimgLength;
              break label1606;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label3126;
              }
              if (localg.lNK == 0)
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
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
            paramAnonymousString = new th();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l1 = paramAnonymousString.HlH;
              Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
              if (n.a(n.this, localg, localg.lAW, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.RII))
              {
                n.g(n.this).onSceneEnd(0, 0, "", n.this);
                if (n.o(n.this) != null) {
                  n.o(n.this).bid();
                }
              }
              AppMethodBeat.o(189706);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
            }
            if (n.o(n.this) == null) {
              break;
            }
            n.o(n.this).bid();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(189719);
        Object localObject1 = (eyc)d.b.b(n.p(n.this).lBR);
        tg localtg = new tg();
        localtg.ScK = ((eyc)localObject1).Uym.Ufy;
        localtg.CRR = ((eyc)localObject1).RID.Ufy;
        localtg.CRQ = ((eyc)localObject1).RIE.Ufy;
        localtg.ScL = ((eyc)localObject1).Uyt;
        localtg.ScM = ((eyc)localObject1).Uyu;
        localtg.CPw = n.A(n.this);
        localtg.ScO = n.B(n.this);
        localtg.ScP = n.C(n.this);
        localtg.ScQ = n.D(n.this);
        localtg.RII = ((eyc)localObject1).RII;
        localtg.ScV = n.z(n.this);
        localtg.lVG = ((eyc)localObject1).lVG;
        localtg.RFI = ((eyc)localObject1).RFI;
        localtg.RFK = ((eyc)localObject1).RFK;
        localtg.RFJ = ((eyc)localObject1).RFJ;
        localtg.ScZ = ((eyc)localObject1).ScZ;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bmh().r(((g)localObject1).lNH, "", "");
        com.tencent.mm.aq.f.bkh();
        localtg.ScX = com.tencent.mm.aq.a.Vt((String)localObject2);
        localtg.ScY = ((g)localObject1).lNL;
        int i;
        label342:
        String str;
        if (localtg.ScY <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localtg.ScY = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localtg.Cqs = 2;
            if (localtg.ScY == 3) {
              localtg.Cqs = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localtg.ScL), Integer.valueOf(localtg.ScM), localtg.RII, localtg.CRQ, localtg.ScV, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).lNH, localObject2, Integer.valueOf(localtg.ScX), Integer.valueOf(localtg.ScY), Integer.valueOf(localtg.Cqs) });
            paramAnonymousString = new com.tencent.mm.an.d.a();
            paramAnonymousString.lBU = localtg;
            paramAnonymousString.lBV = new eyd();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.lBW = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bgN();
            localObject2 = n.F(n.this).biw();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).biq()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).biq())) {
            break label776;
          }
          if (!x.a(((e)localObject2).sE(1), ((e)localObject2).bip(), ((e)localObject2).bir(), ((com.tencent.mm.an.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localtg.ScK });
          AppMethodBeat.o(189719);
          return;
          i = 1;
          break;
          localtg.Cqs = 1;
          break label342;
          localtg.Cqs = 3;
          break label342;
          localtg.Cqs = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(189727);
        PInt localPInt = new PInt();
        th localth = new th();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.an.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.aHF().kcd.lCD.biw().sE(1), localPInt, localth);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localth.ScV, localth.RNi, localth.ScK });
          n.c(n.this, localth.ScV);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localth.Sda);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localth.Sda) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(189727);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(189727);
        }
        return null;
      }
    };
    this.jYb = false;
    Log.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramj, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), Util.getStack(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.lPL = paramBoolean1;
    this.lPr = paramInt4;
    this.lPi = paramj;
    this.lNK = paramInt2;
    this.scene = paramInt5;
    this.latitude = paramFloat2;
    this.longtitude = paramFloat1;
    this.jXU = paramInt1;
    this.lPO = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.lPJ = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong1 > 0L)
    {
      paramString5 = q.bmh().b(Long.valueOf(paramLong1));
      paramString5 = q.bmh().r(paramString5.lNM, "", "");
    }
    if (paramLong2 > 0L) {
      this.lPQ = bs.RU(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramLong2).hxy);
    }
    try
    {
      for (;;)
      {
        this.lPj = q.bmh().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
        this.jXT = this.lPj;
        Log.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.lPj);
        if ((!paramBoolean2) || ((this.lPj >= 0L) && (k.wn((int)this.lPj)))) {
          break;
        }
        Log.e(this.TAG, "insert to img storage failed id:" + this.lPj);
        this.lNP = -1L;
        this.rr = null;
        AppMethodBeat.o(228985);
        return;
        if (!Util.isNullOrNil(paramString6)) {
          this.lPQ = paramString6;
        }
      }
    }
    catch (SQLiteException paramString6)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 182L, 1L, false);
        if (!paramString6.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        q.bmh().blO();
        Log.e(this.TAG, "fallback to insert");
        this.lPj = q.bmh().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
      }
      AppMethodBeat.o(228985);
      throw paramString6;
    }
    if (this.lPj >= 0L)
    {
      paramBoolean1 = true;
      Assert.assertTrue(paramBoolean1);
      paramString3 = new com.tencent.mm.an.d.a();
      paramString3.lBU = new eyc();
      paramString3.lBV = new eyd();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.lBW = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.bgN();
      this.fcD = paramString2;
      this.fvt = new ca();
      this.fvt.setType(ab.Ra(paramString2));
      this.fvt.Jm(paramString2);
      this.fvt.pJ(1);
      this.fvt.setStatus(1);
      this.fvt.Jn(localPString.value);
      this.fvt.pW(localPInt1.value);
      this.fvt.pX(localPInt2.value);
      this.fvt.setCreateTime(bq.RP(this.fvt.field_talker));
      this.fvt.setContent(paramString4);
      a.a.atD().n(this.fvt);
    }
    label1640:
    label1646:
    label1651:
    for (;;)
    {
      try
      {
        this.lNP = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().c(this.fvt, true);
        if (this.lNP >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.lNP);
          paramString3 = blS();
          paramString3.GE((int)this.lNP);
          q.bmh().a(Long.valueOf(this.lPj), paramString3);
          if (paramInt2 != 1) {
            break label1651;
          }
          this.jXT = paramString3.lNR;
          paramString3 = blR();
          paramString3.wf((int)com.tencent.mm.vfs.u.bBQ(q.bmh().r(paramString3.lNH, "", "")));
          q.bmh().a(Long.valueOf(this.jXT), paramString3);
          Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.jXT + " img len = " + paramString3.lAW);
          paramString5 = (eyc)d.b.b(this.rr.lBR);
          paramString5.RID = new eaf().btQ(paramString1);
          paramString5.RIE = new eaf().btQ(paramString2);
          paramString5.Hna = paramString3.offset;
          paramString5.HmZ = paramString3.lAW;
          paramString5.COi = this.fvt.getType();
          paramString5.ThK = paramInt2;
          if (!ag.dj(MMApplicationContext.getContext())) {
            break label1640;
          }
          paramInt3 = 1;
          paramString5.SmH = paramInt3;
          paramString5.Uns = paramString3.source;
          paramString5.ScY = paramString3.lNL;
          paramString5.Uyt = localPInt2.value;
          paramString5.Uyu = localPInt1.value;
          paramString1 = h.VS(paramString4);
          if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.appId)))
          {
            paramString5.lVG = paramString1.appId;
            paramString5.RFI = paramString1.mediaTagName;
            paramString5.RFK = paramString1.messageAction;
            paramString5.RFJ = paramString1.messageExt;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(paramString2)) {
            paramString5.ScZ = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bws(paramString2);
          }
          Log.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.Uyt), Integer.valueOf(paramString5.Uyu) });
          if (paramString5.ScY == 0)
          {
            if (paramInt1 != 4) {
              break label1646;
            }
            paramInt1 = 2;
            paramString5.ScY = paramInt1;
          }
          Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString5.ScY) });
          if (paramString3.offset == 0) {
            this.lPm = new com.tencent.mm.modelstat.g(getType(), true, paramString3.lAW);
          }
          paramLong1 = System.currentTimeMillis();
          wq(paramInt2);
          Log.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong1) });
          if (paramj != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150681);
                paramj.a(this.lPz, this.lPA, n.this);
                AppMethodBeat.o(150681);
              }
            });
          }
          AppMethodBeat.o(228985);
          return;
          paramBoolean1 = false;
        }
      }
      catch (SQLiteException paramString3)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 182L, 1L, false);
        if (paramString3.toString().contains("UNIQUE constraint failed"))
        {
          Log.e(this.TAG, "fallback to insert");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().eSo();
          this.lNP = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().c(this.fvt, true);
          continue;
        }
        AppMethodBeat.o(228985);
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
    AppMethodBeat.i(229013);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.lPD = "";
    this.lPE = "";
    this.lPF = true;
    this.lPH = 16384;
    this.lNK = 0;
    this.fvt = null;
    this.lPm = null;
    this.lPn = "";
    this.startTime = 0L;
    this.lPo = -1;
    this.jGU = 0;
    this.lPI = new a(null);
    this.lPP = false;
    this.lPR = new com.tencent.mm.pluginsdk.g.d.a()
    {
      public final void O(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(215947);
        Log.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.wp((int)n.b(n.this));
        k.wo((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).bid();
        }
        AppMethodBeat.o(215947);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(215949);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          Log.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(215949);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(215949);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(215944);
        Log.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.mHi) });
        long l1 = paramAnonymousa.mHi;
        long l2 = Util.nowMilliSecond();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.smU;
        final g localg = n.d(n.this);
        Object localObject1 = q.bmh().r(localg.lNH, "", "");
        Object localObject2 = q.bmh().r(localg.lNI, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.u.bBQ(q.bmh().r(localg.lNJ, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.u.bBQ((String)localObject2));
        locald.field_fileLength = paramAnonymousa.mHi;
        com.tencent.mm.aq.f.bkh();
        locald.field_filecrc = com.tencent.mm.aq.a.Vt((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.VS((String)localObject2);
        if ((localObject1 != null) && (!Util.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
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
            localg.VQ((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).VQ((String)localObject1);
            }
            localObject1 = c.blC();
            ((c)localObject1).jXU = n.q(n.this);
            ((c)localObject1).lNr = ((eyc)d.b.b(n.p(n.this).lBR));
            ((c)localObject1).lNs = localg;
            ((c)localObject1).aesKey = paramAnonymousa.QTm;
            ((c)localObject1).jYa = locald;
            ((c)localObject1).lNt = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(222057);
                Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.wp((int)n.b(n.this));
                  k.wo((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).bid();
                  }
                  AppMethodBeat.o(222057);
                  return;
                }
                n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(222057);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).bnl().aEv();
            AppMethodBeat.o(215944);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = XmlParser.parseXml((String)localObject2, "msg", null);
            if (localMap != null)
            {
              if (localg.lNK == 0)
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
    this.lPx = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(189706);
        Log.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(189706);
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
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Wg(paramAnonymousd.iUs))
          {
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).bpa();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.localId != n.c(n.this)))
        {
          com.tencent.mm.aq.f.bkg().Vy(n.n(n.this));
          Log.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).bid();
          }
          AppMethodBeat.o(189706);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(189706);
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
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(243170);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).wd(0);
                n.m(n.this).setCreateTime(bq.RP(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.aq.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (eyc)d.b.b(n.p(n.this).lBR);
                if (localObject == null) {
                  Log.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  Log.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(243170);
                  return;
                  ((eyc)localObject).Uym = new eaf().btQ(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(189706);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            Log.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(243999);
                  n.b(n.this, n.d(n.this));
                  AppMethodBeat.o(243999);
                }
              });
              AppMethodBeat.o(189706);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!Util.isNullOrNil(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new th();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new ae(paramAnonymousc).bpa();
            new com.tencent.mm.f.b.a.ac(paramAnonymousc).bpa();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.CqV == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.CqV, paramAnonymousString.BaseResponse.Tef.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).bid();
            }
            AppMethodBeat.o(189706);
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
            paramAnonymousc = n.Wg(paramAnonymousd.iUs);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        Log.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
        if (localg.source == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.a(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.VS(paramAnonymousString);
          if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.appId))) {
            break label3129;
          }
        }
        label2563:
        label2735:
        label3126:
        label3129:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (Util.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              Log.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            localObject = paramAnonymousString;
            if (paramAnonymousd.arK())
            {
              if (!Util.isNullOrNil(n.y(n.this))) {
                break label2563;
              }
              Log.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
            }
            for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
            {
              n.a(n.this, localg);
              localg.VQ((String)localObject);
              n.a(n.this, (String)localObject);
              if (n.b(n.this) != n.c(n.this)) {
                n.e(n.this).VQ((String)localObject);
              }
              if (!paramAnonymousd.field_needSendMsgField) {
                break label2735;
              }
              paramAnonymousString = c.blC();
              paramAnonymousString.jXU = n.q(n.this);
              paramAnonymousString.lNr = ((eyc)d.b.b(n.p(n.this).lBR));
              paramAnonymousString.lNs = localg;
              paramAnonymousString.aesKey = n.z(n.this);
              paramAnonymousString.jYa = paramAnonymousd;
              paramAnonymousString.lNt = new o.a()
              {
                public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                {
                  AppMethodBeat.i(238521);
                  new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
                  Log.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                  if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                  {
                    k.wp((int)n.b(n.this));
                    k.wo((int)n.b(n.this));
                    n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).bid();
                    }
                    AppMethodBeat.o(238521);
                    return;
                  }
                  n.a(n.this, localg, localg.lAW, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                  AppMethodBeat.o(238521);
                }
              };
              paramAnonymousString.toUser = n.m(n.this).field_talker;
              paramAnonymousString.bnl().aEv();
              break;
              paramAnonymousInt = localg.source;
              break label1361;
              l1 = paramAnonymousd.field_midimgLength;
              break label1606;
              localObject = XmlParser.parseXml(paramAnonymousString, "msg", null);
              if (localObject == null) {
                break label3126;
              }
              if (localg.lNK == 0)
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
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Wg(paramAnonymousd.iUs) })).bpa();
            paramAnonymousString = new th();
            try
            {
              paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
              l1 = paramAnonymousString.HlH;
              Log.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.CqV), paramAnonymousString.BaseResponse.Tef.toString() });
              if (n.a(n.this, localg, localg.lAW, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.RII))
              {
                n.g(n.this).onSceneEnd(0, 0, "", n.this);
                if (n.o(n.this) != null) {
                  n.o(n.this).bid();
                }
              }
              AppMethodBeat.o(189706);
              return 0;
            }
            catch (IOException paramAnonymousString)
            {
              Log.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
              Log.e(n.f(n.this), "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
              n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
            }
            if (n.o(n.this) == null) {
              break;
            }
            n.o(n.this).bid();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(189719);
        Object localObject1 = (eyc)d.b.b(n.p(n.this).lBR);
        tg localtg = new tg();
        localtg.ScK = ((eyc)localObject1).Uym.Ufy;
        localtg.CRR = ((eyc)localObject1).RID.Ufy;
        localtg.CRQ = ((eyc)localObject1).RIE.Ufy;
        localtg.ScL = ((eyc)localObject1).Uyt;
        localtg.ScM = ((eyc)localObject1).Uyu;
        localtg.CPw = n.A(n.this);
        localtg.ScO = n.B(n.this);
        localtg.ScP = n.C(n.this);
        localtg.ScQ = n.D(n.this);
        localtg.RII = ((eyc)localObject1).RII;
        localtg.ScV = n.z(n.this);
        localtg.lVG = ((eyc)localObject1).lVG;
        localtg.RFI = ((eyc)localObject1).RFI;
        localtg.RFK = ((eyc)localObject1).RFK;
        localtg.RFJ = ((eyc)localObject1).RFJ;
        localtg.ScZ = ((eyc)localObject1).ScZ;
        localObject1 = n.d(n.this);
        Object localObject2 = q.bmh().r(((g)localObject1).lNH, "", "");
        com.tencent.mm.aq.f.bkh();
        localtg.ScX = com.tencent.mm.aq.a.Vt((String)localObject2);
        localtg.ScY = ((g)localObject1).lNL;
        int i;
        label342:
        String str;
        if (localtg.ScY <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localtg.ScY = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localtg.Cqs = 2;
            if (localtg.ScY == 3) {
              localtg.Cqs = 4;
            }
            Log.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localtg.ScL), Integer.valueOf(localtg.ScM), localtg.RII, localtg.CRQ, localtg.ScV, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).lNH, localObject2, Integer.valueOf(localtg.ScX), Integer.valueOf(localtg.ScY), Integer.valueOf(localtg.Cqs) });
            paramAnonymousString = new com.tencent.mm.an.d.a();
            paramAnonymousString.lBU = localtg;
            paramAnonymousString.lBV = new eyd();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.lBW = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.bgN();
            localObject2 = n.F(n.this).biw();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((e)localObject2).biq()))
        {
          Log.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((e)localObject2).biq())) {
            break label776;
          }
          if (!x.a(((e)localObject2).sE(1), ((e)localObject2).bip(), ((e)localObject2).bir(), ((com.tencent.mm.an.d)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((e)localObject2).isForeground())) {
            break label744;
          }
          Log.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localtg.ScK });
          AppMethodBeat.o(189719);
          return;
          i = 1;
          break;
          localtg.Cqs = 1;
          break label342;
          localtg.Cqs = 3;
          break label342;
          localtg.Cqs = 5;
          break label342;
        }
        label744:
        Log.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
        return;
        label776:
        Log.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localtg.ScK });
        AppMethodBeat.o(189719);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(189727);
        PInt localPInt = new PInt();
        th localth = new th();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.an.z.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.h.aHF().kcd.lCD.biw().sE(1), localPInt, localth);
          Log.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localth.ScV, localth.RNi, localth.ScK });
          n.c(n.this, localth.ScV);
          ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(localth.Sda);
          Log.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localth.Sda) });
          Log.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(189727);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(189727);
        }
        return null;
      }
    };
    this.jYb = false;
    Log.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramj, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), Util.getStack() });
    this.lPL = paramBoolean1;
    this.lPr = paramInt4;
    this.lPi = paramj;
    this.lNK = paramInt2;
    this.jXU = paramInt1;
    this.lPO = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.lPJ = paramString4;
    this.lPj = paramLong;
    this.jXT = this.lPj;
    paramString3 = blS();
    this.fvt = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramString3.lNP);
    this.lNP = this.fvt.field_msgId;
    localPInt.value = this.fvt.ilj;
    paramString5.value = this.fvt.ili;
    if (paramInt2 == 1)
    {
      this.jXT = paramString3.lNR;
      this.jXV = null;
      paramString3 = blR();
    }
    for (;;)
    {
      if ((this.fvt.field_talker != null) && (!this.fvt.field_talker.equals(paramString2)))
      {
        Log.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.fvt.field_talker });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.fvt.field_talker;; paramString4 = paramString2)
      {
        Log.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fvt.field_msgId);
        Log.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.lPj);
        if ((paramBoolean2) && ((this.lPj < 0L) || (!k.wn((int)this.lPj))))
        {
          Log.e(this.TAG, "insert to img storage failed id:" + this.lPj);
          this.lNP = -1L;
          this.rr = null;
          AppMethodBeat.o(229013);
          return;
        }
        if (this.lPj >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          paramString2 = new com.tencent.mm.an.d.a();
          paramString2.lBU = new eyc();
          paramString2.lBV = new eyd();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.lBW = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.bgN();
          Log.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.jXT + " img len = " + paramString3.lAW);
          paramString2 = (eyc)d.b.b(this.rr.lBR);
          paramString2.RID = new eaf().btQ(paramString1);
          paramString2.RIE = new eaf().btQ(paramString4);
          paramString2.Hna = paramString3.offset;
          paramString2.HmZ = paramString3.lAW;
          paramString2.COi = this.fvt.getType();
          paramString2.ThK = paramInt2;
          if (!ag.dj(MMApplicationContext.getContext())) {
            break label1112;
          }
          paramInt2 = 1;
          label856:
          paramString2.SmH = paramInt2;
          paramString2.Uns = paramString3.source;
          paramString2.ScY = paramString3.lNL;
          paramString2.Uyt = localPInt.value;
          paramString2.Uyu = paramString5.value;
          Log.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.Uyt), Integer.valueOf(paramString2.Uyu) });
          if (paramString2.ScY == 0) {
            if (paramInt1 != 4) {
              break label1118;
            }
          }
        }
        label1112:
        label1118:
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString2.ScY = paramInt1;
          if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(paramString4)) {
            paramString2.ScZ = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bws(paramString4);
          }
          Log.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.source), Integer.valueOf(paramString2.ScY) });
          if (paramString3.offset == 0) {
            this.lPm = new com.tencent.mm.modelstat.g(getType(), true, paramString3.lAW);
          }
          if (paramj != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150682);
                paramj.a(this.lPz, this.lPA, n.this);
                AppMethodBeat.o(150682);
              }
            });
          }
          AppMethodBeat.o(229013);
          return;
          paramBoolean1 = false;
          break;
          paramInt2 = 2;
          break label856;
        }
      }
    }
  }
  
  public static void GH(long paramLong)
  {
    lPS = paramLong;
  }
  
  public static String Wg(String paramString)
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
        long l = lPS;
        lPS = -1L;
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
    String str3 = this.fvt.field_talker;
    if (ab.QY(str3))
    {
      Log.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { str3 });
      AppMethodBeat.o(150700);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.g.b.hfX())
    {
      Log.i(this.TAG, "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(150700);
      return false;
    }
    com.tencent.mm.aq.f.bkg();
    if ((!com.tencent.mm.aq.b.vQ(1)) && (Util.isNullOrNil(paramg.lNS)))
    {
      localObject = this.TAG;
      com.tencent.mm.aq.f.bkg();
      Log.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.aq.b.vQ(1)), paramg.lNS });
      AppMethodBeat.o(150700);
      return false;
    }
    if (Util.isNullOrNil(this.lPn))
    {
      Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.jXT) });
      AppMethodBeat.o(150700);
      return false;
    }
    String str2 = q.bmh().r(paramg.lNH, "", "");
    String str1 = q.bmh().r(paramg.lNI, "", "");
    String str4 = q.bmh().r(paramg.lNJ, "", "");
    Object localObject = q.bmh().r(paramg.lNM, "", "");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.taskName = "task_NetSceneUploadMsgImg";
    localg.iUG = this.lPx;
    localg.field_mediaId = this.lPn;
    localg.field_fileType = this.jGU;
    localg.field_talker = str3;
    int i;
    boolean bool1;
    if (ab.Lj(str3))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.iTU;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      if (as.bvS(this.fvt.field_talker)) {
        break label1010;
      }
      bool1 = true;
      label351:
      localg.field_sendmsg_viacdn = bool1;
      if ((as.bvS(this.fvt.field_talker)) || (!this.lPF)) {
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
      this.lPn = com.tencent.mm.aq.c.a("upimgjpg", this.fvt.field_createTime, str3, this.fvt.field_msgId + "_" + this.jXT + "_" + this.lNK);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.lPn;
      this.lPP = false;
      if (!this.lPP)
      {
        bool1 = ImgUtil.isWXGF(str4);
        Log.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", new Object[] { Boolean.valueOf(bool1) });
      }
      if ((localg.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) && (Util.isNullOrNil(localg.field_midimgpath)))
      {
        com.tencent.mm.aq.f.bkg();
        if (com.tencent.mm.aq.b.vQ(256))
        {
          Log.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = XmlParser.parseXml(this.lPJ, "msg", null);
      if (localObject == null) {
        break label1379;
      }
      if (this.lNK == 1) {
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
        com.tencent.mm.aq.f.bkh();
        localg.field_aesKey = com.tencent.mm.aq.a.bjV();
        Log.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      Log.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(paramg.source), localg.field_fileId });
      this.lPD = localg.field_fileId;
      this.lPE = localg.field_aesKey;
      Log.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.lPN = null;
      if (com.tencent.mm.aq.f.bkg().f(localg)) {
        break label1403;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 205L, 1L, false);
      Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.lPn });
      this.lPn = "";
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
      boolean bool2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).cTt();
      boolean bool3;
      if ((this.jXU == 4) && (com.tencent.mm.vfs.u.agG((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR(str1);
        bool3 = bu(str1, str3);
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
        this.lPP = bool1;
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
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR(str2);
        bool1 = ImgUtil.identifyImgType(str2).equals(".png");
        if ((this.lNK == 0) && (!bool1) && (bu(str2, str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          paramg.VR(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR(paramg.lNH));
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
      Log.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.lNS });
    }
    label1403:
    if (Util.nullAsNil(paramg.lNS).length() <= 0)
    {
      paramg.VQ("CDNINFO_SEND");
      paramg.cUP = 4096;
    }
    AppMethodBeat.o(150700);
    return true;
  }
  
  private boolean a(g paramg, int paramInt1, long paramLong, int paramInt2, com.tencent.mm.i.d paramd, String paramString)
  {
    AppMethodBeat.i(169189);
    Log.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.lPn, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    Log.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(com.tencent.mm.platformtools.ac.mFN), Long.valueOf(this.lPj), Long.valueOf(this.jXT) });
    long l = paramLong;
    if (10007 == com.tencent.mm.platformtools.ac.mFM)
    {
      l = paramLong;
      if (com.tencent.mm.platformtools.ac.mFN != 0)
      {
        l = com.tencent.mm.platformtools.ac.mFN;
        com.tencent.mm.platformtools.ac.mFN = 0;
      }
    }
    b(paramg.localId, paramInt1, paramg.lAW);
    paramg.we(paramInt1);
    paramg.EG(l);
    Object localObject;
    if (h.b(paramg))
    {
      if (this.lPj == this.jXT) {
        break label522;
      }
      localObject = q.bmh().b(Long.valueOf(this.lPj));
      ((g)localObject).EG(l);
      ((g)localObject).wf(paramg.lAW);
      ((g)localObject).we(paramg.lAW);
      q.bmh().a(Long.valueOf(this.lPj), (g)localObject);
    }
    while (h.b(paramg))
    {
      if (Util.isNullOrNil(this.lPn)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.jGU), Integer.valueOf(paramg.lAW - this.lPo) });
      }
      this.fvt.setStatus(2);
      this.fvt.EG(l);
      this.fvt.Ip(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.lNP, this.fvt);
      if (com.tencent.mm.modelstat.q.meR != null) {
        com.tencent.mm.modelstat.q.meR.u(this.fvt);
      }
      if (this.lPm != null) {
        this.lPm.GP(0L);
      }
      if (u.lRb != null)
      {
        localObject = this.lPQ;
        paramg = (g)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramg = bs.RU(paramString);
        }
        u.lRb.a(this.jXT, this.fvt, this.rr, this.jXU, this.jYb, paramd, paramg);
      }
      if (this.lPI != null) {
        this.lPI.bid();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      k.wo((int)this.lPj);
      AppMethodBeat.o(169189);
      return false;
      label522:
      localObject = q.bmh().b(Long.valueOf(paramg.localId));
      ((g)localObject).EG(l);
      ((g)localObject).wf(paramg.lAW);
      ((g)localObject).we(paramg.lAW);
      q.bmh().a(Long.valueOf(((g)localObject).localId), (g)localObject);
    }
    AppMethodBeat.o(169189);
    return true;
  }
  
  private void b(final long paramLong, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150707);
    if (this.lPi != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224303);
          p localp = p.blV();
          long l1 = paramLong;
          long l2 = paramInt1;
          long l3 = this.lPY;
          if (localp.lQb.containsKey(Long.valueOf(l1))) {}
          for (p.d locald = (p.d)localp.lQb.get(Long.valueOf(l1));; locald = new p.d())
          {
            locald.offset = l3;
            locald.total = l2;
            localp.lQb.put(Long.valueOf(l1), locald);
            n.G(n.this).a(this.lPY, paramInt1, n.this);
            AppMethodBeat.o(224303);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(150707);
  }
  
  private g blR()
  {
    AppMethodBeat.i(150692);
    if (this.jXV == null) {
      this.jXV = q.bmh().b(Long.valueOf(this.jXT));
    }
    g localg = this.jXV;
    AppMethodBeat.o(150692);
    return localg;
  }
  
  private g blS()
  {
    AppMethodBeat.i(150693);
    if (this.lPG == null) {
      this.lPG = q.bmh().b(Long.valueOf(this.lPj));
    }
    g localg = this.lPG;
    AppMethodBeat.o(150693);
    return localg;
  }
  
  private boolean bu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150701);
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).cTt())
    {
      AppMethodBeat.o(150701);
      return false;
    }
    if (com.tencent.mm.vfs.u.bBQ(paramString1) > 0L)
    {
      if (com.tencent.mm.vfs.u.bBQ(paramString2) > 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(944, 9);
        com.tencent.mm.vfs.u.deleteFile(paramString2);
      }
      if (!com.tencent.mm.vfs.u.agG(paramString2)) {
        com.tencent.mm.vfs.u.bBV(paramString2);
      }
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).gb(paramString1, paramString2) == 0)
      {
        AppMethodBeat.o(150701);
        return true;
      }
      Log.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
    }
    AppMethodBeat.o(150701);
    return false;
  }
  
  private int wr(int paramInt)
  {
    AppMethodBeat.i(150703);
    Log.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.lPI != null) {
      this.lPI.bid();
    }
    AppMethodBeat.o(150703);
    return -1;
  }
  
  public final ca blT()
  {
    AppMethodBeat.i(228950);
    if (this.fvt == null) {
      Log.e(this.TAG, "msg is null. %s", new Object[] { Util.getStack() });
    }
    ca localca = this.fvt;
    AppMethodBeat.o(228950);
    return localca;
  }
  
  public final void blU()
  {
    AppMethodBeat.i(150705);
    Log.i(this.TAG, "send img from system");
    this.jYb = true;
    AppMethodBeat.o(150705);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(150702);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150690);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOD("SendImgSpeeder");
        AppMethodBeat.o(150690);
      }
    }, 100L);
    if (this.jXT < 0L)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 204L, 1L, false);
      Log.e(this.TAG, "doScene invalid imgLocalId:" + this.jXT);
      i = wr(-1);
      AppMethodBeat.o(150702);
      return i;
    }
    if (this.fvt == null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 203L, 1L, false);
      Log.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.jXT) });
      k.wp((int)this.lPj);
      i = wr(-2);
      AppMethodBeat.o(150702);
      return i;
    }
    this.callback = parami;
    prepareDispatcher(paramg);
    eyc localeyc = (eyc)d.b.b(this.rr.lBR);
    g localg = blR();
    parami = q.bmh().wm((int)localg.localId);
    if (parami != null)
    {
      if (parami.status == -1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 202L, 1L, false);
        Log.e(this.TAG, "doScene hd img info is null or error.");
        i = wr(-3);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else if ((localg == null) || (localg.status == -1))
    {
      Log.e(this.TAG, "doScene img info is null or error.");
      i = wr(-4);
      AppMethodBeat.o(150702);
      return i;
    }
    String str1;
    if (a.a.atD().KI(this.fvt.field_talker))
    {
      localeyc.RII = a.a.atD().o(this.fvt);
      Log.i(this.TAG, "upload img msg source %s", new Object[] { localeyc.RII });
      str1 = q.bmh().r(localg.lNH, "", "");
      parami = q.bmh().r(localg.lNJ, "", "");
      if (!Util.isNullOrNil(localg.lNI)) {
        q.bmh().r(localg.lNI, "", "");
      }
      if ((com.tencent.mm.vfs.u.bBQ(str1) <= 0L) || (com.tencent.mm.vfs.u.bBQ(parami) <= 0L))
      {
        Log.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.jXT), Long.valueOf(com.tencent.mm.vfs.u.bBQ(str1)), Long.valueOf(com.tencent.mm.vfs.u.bBQ(parami)), str1, parami });
        i = wr(-5);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else
    {
      if (Util.isNullOrNil(this.lPQ))
      {
        parami = com.tencent.mm.vfs.u.buc(this.lPO);
        localObject = com.tencent.mm.platformtools.v.mEG;
        this.lPQ = com.tencent.mm.platformtools.v.ZU(parami);
      }
      if (!Util.isNullOrNil(this.lPQ)) {}
      for (parami = bs.RV(this.lPQ);; parami = bs.apc())
      {
        if (((parami != null) && (!parami.equals(this.fvt.hxy))) || ((parami == null) && (!Util.isNullOrNil(this.fvt.hxy))))
        {
          this.fvt.Ip(parami);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.fvt.field_msgId, this.fvt);
        }
        localeyc.RII = this.fvt.hxy;
        break;
      }
    }
    if ((localeyc.Uym == null) || (Util.isNullOrNil(localeyc.Uym.Ufy)))
    {
      if (Util.isNullOrNil(this.lPn))
      {
        Log.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.fvt.field_createTime), this.fvt.field_talker, Long.valueOf(this.fvt.field_msgId), Long.valueOf(this.jXT), Integer.valueOf(this.lNK) });
        this.lPn = com.tencent.mm.aq.c.a("upimg", this.fvt.field_createTime, this.fvt.field_talker, this.fvt.field_msgId + "_" + this.jXT + "_" + this.lNK);
      }
      localeyc.Uym = new eaf().btQ(this.lPn);
      parami = this.fvt;
      parami.ilo = this.lPn;
      parami.hwY = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.lPo = localg.offset;
      if (this.lNK != 1) {
        break label940;
      }
    }
    label940:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.jGU = i;
      if (!a(localg, 0)) {
        break;
      }
      Log.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localeyc.Uym.Ufy });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (as.bvS(this.fcD))
    {
      Log.w(this.TAG, "just return without using cdn for byp. %s", new Object[] { this.fcD });
      k.wp((int)this.lPj);
      i = wr(-99);
      AppMethodBeat.o(150702);
      return i;
    }
    if (com.tencent.mm.n.h.axc().getInt("UploadMsgImgType", 0) == 1) {}
    for (boolean bool1 = true; ab.QY(this.fvt.field_talker); bool1 = false)
    {
      Log.w(this.TAG, "cdntra not use parallel-upload user:%s", new Object[] { this.fvt.field_talker });
      i = 0;
      if (i == 0) {
        break label1489;
      }
      Log.d(this.TAG, "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { localeyc.Uym.Ufy });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWV, 0)) {}
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
    Object localObject = q.bmh().r(localg.lNH, "", "");
    String str2 = q.bmh().r(localg.lNJ, "", "");
    parami = q.bmh().r(localg.lNI, "", "");
    boolean bool2 = Util.isNullOrNil(parami);
    if (bool2) {
      parami = (com.tencent.mm.an.i)localObject;
    }
    for (;;)
    {
      String str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR(parami);
      String str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR((String)localObject);
      com.tencent.mm.pluginsdk.g.d locald = new com.tencent.mm.pluginsdk.g.d();
      locald.lNP = this.lNP;
      locald.QSZ = this.lPR;
      locald.scene = 1;
      locald.fileType = 2;
      if (!bool2) {
        locald.fileType = 1;
      }
      String str5;
      if ((bool1) && (this.lNK == 0))
      {
        localg.VR(str4);
        str5 = q.bmh().r(localg.lNM, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).gb((String)localObject, str5);
        if (i != 0) {
          break label1480;
        }
        localg.wi(1);
        localg.wf((int)com.tencent.mm.vfs.u.bBQ(str5));
      }
      for (;;)
      {
        Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.jXT), str5, Integer.valueOf(i), Integer.valueOf(localg.lAW) });
        locald.thumbPath = str2;
        locald.lNI = parami;
        locald.QTb = str3;
        locald.fullPath = ((String)localObject);
        locald.QTa = str4;
        parami = new com.tencent.mm.pluginsdk.g.c();
        parami.QSW = bool1;
        parami.a(locald);
        i = 1;
        break;
        label1480:
        localg.wi(0);
      }
      label1489:
      if ((bool1) && (this.lNK == 0))
      {
        localg.VR(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR(localg.lNH));
        parami = q.bmh().r(localg.lNM, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).gb(str1, parami);
        if (i != 0) {
          break label1693;
        }
        localg.wi(1);
        localg.wf((int)com.tencent.mm.vfs.u.bBQ(parami));
      }
      for (;;)
      {
        Log.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.jXT), parami, Integer.valueOf(i), Integer.valueOf(localg.lAW) });
        i = localg.lNQ;
        if (i < securityLimitCount()) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 201L, 1L, false);
        Log.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
        k.wp((int)this.lPj);
        i = wr(-6);
        AppMethodBeat.o(150702);
        return i;
        label1693:
        localg.wi(0);
      }
      localg.wd(i + 1);
      localg.cUP = 512;
      q.bmh().a(Long.valueOf(this.jXT), localg);
      int j = localg.lAW - localg.offset;
      i = j;
      if (j > this.lPH) {
        i = this.lPH;
      }
      com.tencent.mm.vfs.u.bBQ(str1);
      if (localg.lNN == 1) {}
      for (parami = q.bmh().r(localg.lNM, "", "");; parami = q.bmh().r(localg.lNH, "", ""))
      {
        parami = com.tencent.mm.vfs.u.aY(parami, localg.offset, i);
        if ((parami != null) && (parami.length > 0)) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 199L, 1L, false);
        Log.e(this.TAG, "doScene, file read buf error.");
        i = wr(-8);
        AppMethodBeat.o(150702);
        return i;
      }
      localeyc.Hnb = parami.length;
      localeyc.HmZ = localg.lAW;
      localeyc.Hna = localg.offset;
      localeyc.Hnc = new eae().dc(parami);
      localeyc.TGZ = localg.lNN;
      if (this.lPm != null) {
        this.lPm.bpw();
      }
      i = dispatch(paramg, this.rr, this);
      if (i < 0)
      {
        Log.e(this.TAG, "doScene netId error");
        k.wp((int)this.lPj);
        i = wr(-9);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150704);
    Log.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.lPn);
    params = (eyd)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(params.Sda);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 198L, 1L, false);
      k.wp((int)this.lPj);
      k.wo((int)this.lPj);
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.jGU), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.lPI != null) {
        this.lPI.bid();
      }
      AppMethodBeat.o(150704);
      return;
    }
    this.lPH = params.Hnb;
    if (this.lPH > 16384) {
      this.lPH = 16384;
    }
    paramString = blR();
    Log.v(this.TAG, "onGYNetEnd localId:" + this.jXT + "  totalLen:" + paramString.lAW + " offSet:" + paramString.offset);
    if ((params.Hna < 0) || ((params.Hna > paramString.lAW) && (paramString.lAW > 0)))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 197L, 1L, false);
      Log.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + params.Hna + " img totalLen = " + paramString.lAW);
      k.wp((int)this.lPj);
      k.wo((int)this.lPj);
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.jGU), Integer.valueOf(0) });
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.lPI != null) {
        this.lPI.bid();
      }
      AppMethodBeat.o(150704);
      return;
    }
    if ((params.Hna < paramString.offset) || ((h.b(paramString)) && (this.lPH <= 0)))
    {
      Log.e(this.TAG, "onGYNetEnd invalid data startPos = " + params.Hna + " totalLen = " + paramString.lAW + " off:" + paramString.offset);
      k.wp((int)this.lPj);
      k.wo((int)this.lPj);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.lPI != null) {
        this.lPI.bid();
      }
      AppMethodBeat.o(150704);
      return;
    }
    Log.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + params.Hna);
    if ((a(paramString, params.Hna, params.HlH, params.CreateTime, null, params.RII)) && (doScene(dispatcher(), this.callback) < 0))
    {
      k.wo((int)this.lPj);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.lPI != null) {
        this.lPI.bid();
      }
    }
    AppMethodBeat.o(150704);
  }
  
  public final int securityLimitCount()
  {
    if (this.lNK == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void wq(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(150697);
    if (this.fvt == null)
    {
      Log.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.lNP), Integer.valueOf(paramInt) });
      AppMethodBeat.o(150697);
      return;
    }
    if (this.lPL)
    {
      if (this.fvt.ilm == 0)
      {
        boolean bool = q.bmh().a(this.fvt, this.lPr, paramInt);
        ca localca = this.fvt;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localca.pY(paramInt);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.lNP, this.fvt);
          AppMethodBeat.o(150697);
          return;
        }
      }
    }
    else {
      q.bmh().c(this.fvt.field_imgPath, com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext()));
    }
    AppMethodBeat.o(150697);
  }
  
  public final class a
  {
    public com.tencent.mm.an.n lPZ;
    
    public a(com.tencent.mm.an.n paramn)
    {
      this.lPZ = paramn;
    }
    
    final void bid()
    {
      AppMethodBeat.i(150691);
      if (n.b(n.this) == n.c(n.this)) {}
      for (Object localObject = n.d(n.this);; localObject = n.e(n.this))
      {
        if (((g)localObject).lNT == 1)
        {
          com.tencent.mm.plugin.report.service.g.adb(23);
          com.tencent.mm.plugin.report.service.g.adb(21);
        }
        Log.i(n.f(n.this), "UploadEndWrapper onUploadEnd %s done", new Object[] { n.e(n.d(n.this)) });
        if (q.bmh().a(Long.valueOf(n.c(n.this)), n.d(n.this)) < 0)
        {
          Log.e(n.f(n.this), "update db failed local id:" + n.c(n.this) + " server id:" + n.d(n.this).fNu);
          k.wp((int)n.b(n.this));
          k.wo((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -1, "", n.this);
        }
        if (n.c(n.this) != n.b(n.this))
        {
          Log.i(n.f(n.this), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { n.e(n.e(n.this)) });
          q.bmh().a(Long.valueOf(n.b(n.this)), n.e(n.this));
        }
        if ((!CrashReportFactory.hasDebuger()) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
          break;
        }
        localObject = q.bmh().blP();
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
      if (this.lPZ != null) {
        this.lPZ.bid();
      }
      n.this.wq(n.h(n.this));
      n.i(n.this);
      AppMethodBeat.o(150691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.n
 * JD-Core Version:    0.7.0.1
 */