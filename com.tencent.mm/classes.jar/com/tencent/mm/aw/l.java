package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.wcdb.database.SQLiteException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class l
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static boolean DEBUG = true;
  private static long hir;
  private String TAG;
  private com.tencent.mm.al.g callback;
  public bl dbD;
  private float dpb;
  public String dxK;
  private int fLB;
  private int fYA;
  private e fYB;
  private boolean fYH;
  private long fYz;
  private int hgm;
  private long hgs;
  private final com.tencent.mm.al.h hhI;
  public long hhJ;
  private com.tencent.mm.modelstat.h hhM;
  private String hhN;
  private int hhQ;
  private g.a hhW;
  private String hic;
  private String hid;
  private boolean hie;
  private e hif;
  private int hig;
  public b hih;
  private String hii;
  public String hij;
  public boolean hik;
  private float hil;
  private String him;
  private String hin;
  public String hio;
  private boolean hip;
  private String hiq;
  private final com.tencent.mm.al.b rr;
  private int scene;
  private int startOffset;
  private long startTime;
  
  public l(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150698);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hic = "";
    this.hid = "";
    this.hie = true;
    this.hig = 16384;
    this.hgm = 0;
    this.dbD = null;
    this.hhM = null;
    this.hhN = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fLB = 0;
    this.hih = new b(null);
    this.hip = false;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ad.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
          AppMethodBeat.o(150686);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bt.eGO();
            i = com.tencent.mm.ao.c.cu(aj.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.ym(paramAnonymousd.fns))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aBj();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.deI != l.c(l.this)))
        {
          com.tencent.mm.ao.f.awL().xK(l.j(l.this));
          ad.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          l.a(l.this, locale, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afE().ax(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).nW(0);
                l.r(l.this).kY(bi.uj(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.ao.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dht)l.s(l.this).gUS.gUX;
                if (localObject == null) {
                  ad.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dht)localObject).ExR = new cmf().aEE(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.afE().ax(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(150684);
                  l.a(l.this, l.d(l.this));
                  AppMethodBeat.o(150684);
                }
              });
              AppMethodBeat.o(150686);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cw(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dhu();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bt.eGO();
          i = com.tencent.mm.ao.c.cu(aj.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aBj();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aBj();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.ym(paramAnonymousd.fns);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ad.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.vKh;
        if (locale.dep == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.ye(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bt.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ad.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.UC())
              {
                if (!bt.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ad.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.yc((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).yc((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.afA().gcy.a(new m(l.y(l.this), (dht)l.s(l.this).gUS.gUX, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
                    ad.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oh((int)l.b(l.this));
                      i.og((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).ayp();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.gTY, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dep;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.K(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hgm == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.by((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
              paramAnonymousString = new dhu();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.uKZ != 0L) {}
                for (l1 = paramAnonymousString.uKZ;; l1 = paramAnonymousInt)
                {
                  ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.gTY, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.CxC))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).ayp();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.uKX;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).ayp();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dht)l.s(l.this).gUS.gUX;
        py localpy = new py();
        localpy.COE = ((dht)localObject1).ExR.Ehn;
        localpy.sdQ = ((dht)localObject1).Cxx.Ehn;
        localpy.sdP = ((dht)localObject1).Cxy.Ehn;
        localpy.COF = ((dht)localObject1).ExY;
        localpy.COG = ((dht)localObject1).ExZ;
        localpy.Scene = l.z(l.this);
        localpy.COI = l.A(l.this);
        localpy.COJ = l.B(l.this);
        localpy.COK = l.C(l.this);
        localpy.CxC = ((dht)localObject1).CxC;
        localpy.COP = l.D(l.this);
        localpy.hnC = ((dht)localObject1).hnC;
        localpy.CuS = ((dht)localObject1).CuS;
        localpy.CuU = ((dht)localObject1).CuU;
        localpy.CuT = ((dht)localObject1).CuT;
        localpy.COT = ((dht)localObject1).COT;
        localObject1 = l.d(l.this);
        Object localObject2 = o.ayF().p(((e)localObject1).hgj, "", "");
        com.tencent.mm.ao.f.awM();
        localpy.COR = com.tencent.mm.ao.a.xF((String)localObject2);
        localpy.COS = ((e)localObject1).hgn;
        int i;
        label342:
        String str;
        if (localpy.COS <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localpy.COS = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localpy.rNz = 2;
            if (localpy.COS == 3) {
              localpy.rNz = 4;
            }
            ad.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localpy.COF), Integer.valueOf(localpy.COG), localpy.CxC, localpy.sdP, localpy.COP, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hgj, localObject2, Integer.valueOf(localpy.COR), Integer.valueOf(localpy.COS), Integer.valueOf(localpy.rNz) });
            paramAnonymousString = new b.a();
            paramAnonymousString.gUU = localpy;
            paramAnonymousString.gUV = new dhu();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.atI();
            localObject2 = l.F(l.this).avg();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).ava()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).ava())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mq(1), ((com.tencent.mm.network.c)localObject2).auZ(), ((com.tencent.mm.network.c)localObject2).avb(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localpy.COE });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localpy.rNz = 1;
          break label342;
          localpy.rNz = 3;
          break label342;
          localpy.rNz = 5;
          break label342;
        }
        label744:
        ad.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
        return;
        label776:
        ad.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        pz localpz = new pz();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.afA().gcy.gVH.avg().mq(1), localPInt, localpz);
          ad.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localpz.COP, localpz.CCm, localpz.COE });
          l.c(l.this, localpz.COP);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localpz.COU);
          ad.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localpz.COU) });
          ad.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.fYH = false;
    ad.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bt.eGN() });
    this.hhJ = paramInt1;
    this.fYz = paramInt1;
    this.hgm = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new dht();
    ((b.a)localObject1).gUV = new dhu();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).funcId = 110;
    ((b.a)localObject1).reqCmdId = 9;
    ((b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((b.a)localObject1).atI();
    this.hhI = null;
    ad.d(this.TAG, "FROM B SERVICE:" + this.hhJ);
    if (!i.of((int)this.hhJ))
    {
      this.hhJ = -1L;
      AppMethodBeat.o(150698);
      return;
    }
    localObject1 = o.ayF().b(Long.valueOf(this.hhJ));
    this.hgs = ((e)localObject1).hgs;
    if (paramInt2 == 1)
    {
      this.fYz = ((e)localObject1).hgu;
      localObject1 = o.ayF().b(Long.valueOf(this.fYz));
    }
    for (;;)
    {
      Object localObject2 = o.ayF().oe((int)((e)localObject1).deI);
      if (localObject2 != null) {
        this.hgs = ((e)localObject2).hgs;
      }
      this.dbD = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.hgs);
      if ((this.dbD != null) && (this.dbD.field_msgId != this.hgs))
      {
        ad.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.hgs) });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 206L, 1L, false);
        this.dbD = null;
        AppMethodBeat.o(150698);
        return;
      }
      if (this.dbD != null)
      {
        localObject2 = (dht)this.rr.gUS.gUX;
        ((dht)localObject2).Cxx = new cmf().aEE(com.tencent.mm.model.u.aqG());
        ((dht)localObject2).Cxy = new cmf().aEE(this.dbD.field_talker);
        ((dht)localObject2).uKR = ((e)localObject1).offset;
        ((dht)localObject2).uKQ = ((e)localObject1).gTY;
        ((dht)localObject2).saz = this.dbD.getType();
        ((dht)localObject2).DvO = paramInt2;
        if (!ae.cJ(aj.getContext())) {
          break label868;
        }
      }
      label868:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dht)localObject2).CYi = paramInt1;
        ((dht)localObject2).EnY = ((e)localObject1).dep;
        ((dht)localObject2).COS = ((e)localObject1).hgn;
        ((dht)localObject2).COS = ((e)localObject1).hgn;
        ((dht)localObject2).ExY = this.dbD.eOV;
        ((dht)localObject2).ExZ = this.dbD.eOU;
        a locala = f.ye(this.dbD.field_content);
        if ((locala != null) && (!bt.isNullOrNil(locala.appId)))
        {
          this.fYA = ((e)localObject1).dep;
          ((dht)localObject2).hnC = locala.appId;
          ((dht)localObject2).CuS = locala.mediaTagName;
          ((dht)localObject2).CuU = locala.messageAction;
          ((dht)localObject2).CuT = locala.messageExt;
          this.hii = this.dbD.field_content;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.dbD.field_talker)) {
          ((dht)localObject2).COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(this.dbD.field_talker);
        }
        ad.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dht)localObject2).ExY), Integer.valueOf(((dht)localObject2).ExZ) });
        ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).dep), Integer.valueOf(((dht)localObject2).COS) });
        if (((e)localObject1).offset == 0) {
          this.hhM = new com.tencent.mm.modelstat.h(getType(), true, ((e)localObject1).gTY);
        }
        AppMethodBeat.o(150698);
        return;
      }
    }
  }
  
  public l(int paramInt1, int paramInt2, byte paramByte)
  {
    AppMethodBeat.i(150699);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hic = "";
    this.hid = "";
    this.hie = true;
    this.hig = 16384;
    this.hgm = 0;
    this.dbD = null;
    this.hhM = null;
    this.hhN = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fLB = 0;
    this.hih = new b(null);
    this.hip = false;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ad.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
          AppMethodBeat.o(150686);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bt.eGO();
            i = com.tencent.mm.ao.c.cu(aj.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.ym(paramAnonymousd.fns))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aBj();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.deI != l.c(l.this)))
        {
          com.tencent.mm.ao.f.awL().xK(l.j(l.this));
          ad.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          l.a(l.this, locale, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afE().ax(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).nW(0);
                l.r(l.this).kY(bi.uj(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.ao.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dht)l.s(l.this).gUS.gUX;
                if (localObject == null) {
                  ad.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dht)localObject).ExR = new cmf().aEE(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.afE().ax(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(150684);
                  l.a(l.this, l.d(l.this));
                  AppMethodBeat.o(150684);
                }
              });
              AppMethodBeat.o(150686);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cw(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dhu();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bt.eGO();
          i = com.tencent.mm.ao.c.cu(aj.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aBj();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aBj();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.ym(paramAnonymousd.fns);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ad.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.vKh;
        if (locale.dep == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.ye(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bt.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ad.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.UC())
              {
                if (!bt.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ad.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.yc((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).yc((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.afA().gcy.a(new m(l.y(l.this), (dht)l.s(l.this).gUS.gUX, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
                    ad.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oh((int)l.b(l.this));
                      i.og((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).ayp();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.gTY, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dep;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.K(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hgm == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.by((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
              paramAnonymousString = new dhu();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.uKZ != 0L) {}
                for (l1 = paramAnonymousString.uKZ;; l1 = paramAnonymousInt)
                {
                  ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.gTY, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.CxC))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).ayp();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.uKX;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).ayp();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dht)l.s(l.this).gUS.gUX;
        py localpy = new py();
        localpy.COE = ((dht)localObject1).ExR.Ehn;
        localpy.sdQ = ((dht)localObject1).Cxx.Ehn;
        localpy.sdP = ((dht)localObject1).Cxy.Ehn;
        localpy.COF = ((dht)localObject1).ExY;
        localpy.COG = ((dht)localObject1).ExZ;
        localpy.Scene = l.z(l.this);
        localpy.COI = l.A(l.this);
        localpy.COJ = l.B(l.this);
        localpy.COK = l.C(l.this);
        localpy.CxC = ((dht)localObject1).CxC;
        localpy.COP = l.D(l.this);
        localpy.hnC = ((dht)localObject1).hnC;
        localpy.CuS = ((dht)localObject1).CuS;
        localpy.CuU = ((dht)localObject1).CuU;
        localpy.CuT = ((dht)localObject1).CuT;
        localpy.COT = ((dht)localObject1).COT;
        localObject1 = l.d(l.this);
        Object localObject2 = o.ayF().p(((e)localObject1).hgj, "", "");
        com.tencent.mm.ao.f.awM();
        localpy.COR = com.tencent.mm.ao.a.xF((String)localObject2);
        localpy.COS = ((e)localObject1).hgn;
        int i;
        label342:
        String str;
        if (localpy.COS <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localpy.COS = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localpy.rNz = 2;
            if (localpy.COS == 3) {
              localpy.rNz = 4;
            }
            ad.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localpy.COF), Integer.valueOf(localpy.COG), localpy.CxC, localpy.sdP, localpy.COP, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hgj, localObject2, Integer.valueOf(localpy.COR), Integer.valueOf(localpy.COS), Integer.valueOf(localpy.rNz) });
            paramAnonymousString = new b.a();
            paramAnonymousString.gUU = localpy;
            paramAnonymousString.gUV = new dhu();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.atI();
            localObject2 = l.F(l.this).avg();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).ava()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).ava())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mq(1), ((com.tencent.mm.network.c)localObject2).auZ(), ((com.tencent.mm.network.c)localObject2).avb(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localpy.COE });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localpy.rNz = 1;
          break label342;
          localpy.rNz = 3;
          break label342;
          localpy.rNz = 5;
          break label342;
        }
        label744:
        ad.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
        return;
        label776:
        ad.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        pz localpz = new pz();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.afA().gcy.gVH.avg().mq(1), localPInt, localpz);
          ad.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localpz.COP, localpz.CCm, localpz.COE });
          l.c(l.this, localpz.COP);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localpz.COU);
          ad.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localpz.COU) });
          ad.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.fYH = false;
    ad.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null, bt.eGN() });
    this.hhJ = paramInt1;
    this.fYz = paramInt1;
    this.hgm = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new dht();
    ((b.a)localObject1).gUV = new dhu();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).funcId = 110;
    ((b.a)localObject1).reqCmdId = 9;
    ((b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((b.a)localObject1).atI();
    this.hhI = null;
    ad.d(this.TAG, "FROM C SERVICE:" + this.hhJ);
    if (!i.of((int)this.hhJ))
    {
      this.hhJ = -1L;
      AppMethodBeat.o(150699);
      return;
    }
    localObject1 = o.ayF().b(Long.valueOf(this.hhJ));
    this.hgs = ((e)localObject1).hgs;
    ((e)localObject1).setStatus(0);
    ((e)localObject1).kX(0L);
    ((e)localObject1).setOffset(0);
    o.ayF().a((int)this.fYz, (e)localObject1);
    if (paramInt2 == 1)
    {
      this.fYz = ((e)localObject1).hgu;
      localObject1 = o.ayF().b(Long.valueOf(this.fYz));
    }
    for (;;)
    {
      this.dbD = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.hgs);
      Object localObject2;
      if (this.dbD != null)
      {
        this.dbD.setStatus(1);
        localObject2 = ((e)localObject1).hgl;
        if ((localObject2 == null) || (!((String)localObject2).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label801;
        }
        this.dbD.nZ((String)localObject2);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.hgs, this.dbD);
        localObject2 = (dht)this.rr.gUS.gUX;
        ((dht)localObject2).Cxx = new cmf().aEE(com.tencent.mm.model.u.aqG());
        ((dht)localObject2).Cxy = new cmf().aEE(this.dbD.field_talker);
        ((dht)localObject2).uKR = ((e)localObject1).offset;
        ((dht)localObject2).uKQ = ((e)localObject1).gTY;
        ((dht)localObject2).saz = this.dbD.getType();
        ((dht)localObject2).DvO = paramInt2;
        if (!ae.cJ(aj.getContext())) {
          break label832;
        }
      }
      label801:
      label832:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dht)localObject2).CYi = paramInt1;
        ((dht)localObject2).EnY = ((e)localObject1).dep;
        ((dht)localObject2).COS = ((e)localObject1).hgn;
        ((dht)localObject2).ExY = this.dbD.eOV;
        ((dht)localObject2).ExZ = this.dbD.eOU;
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.dbD.field_talker)) {
          ((dht)localObject2).COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(this.dbD.field_talker);
        }
        ad.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dht)localObject2).ExY), Integer.valueOf(((dht)localObject2).ExZ) });
        ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).dep), Integer.valueOf(((dht)localObject2).COS) });
        if (((e)localObject1).offset == 0) {
          this.hhM = new com.tencent.mm.modelstat.h(getType(), true, ((e)localObject1).gTY);
        }
        AppMethodBeat.o(150699);
        return;
        this.dbD.nZ("THUMBNAIL://" + ((e)localObject1).deI);
        break;
      }
    }
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.al.h paramh, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramh, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, 0, -1000.0F, -1000.0F, -1L, 0L, null);
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.al.h paramh, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, String paramString6)
  {
    AppMethodBeat.i(169188);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hic = "";
    this.hid = "";
    this.hie = true;
    this.hig = 16384;
    this.hgm = 0;
    this.dbD = null;
    this.hhM = null;
    this.hhN = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fLB = 0;
    this.hih = new b(null);
    this.hip = false;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ad.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
          AppMethodBeat.o(150686);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bt.eGO();
            i = com.tencent.mm.ao.c.cu(aj.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.ym(paramAnonymousd.fns))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aBj();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.deI != l.c(l.this)))
        {
          com.tencent.mm.ao.f.awL().xK(l.j(l.this));
          ad.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          l.a(l.this, locale, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afE().ax(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).nW(0);
                l.r(l.this).kY(bi.uj(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.ao.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dht)l.s(l.this).gUS.gUX;
                if (localObject == null) {
                  ad.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dht)localObject).ExR = new cmf().aEE(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.afE().ax(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(150684);
                  l.a(l.this, l.d(l.this));
                  AppMethodBeat.o(150684);
                }
              });
              AppMethodBeat.o(150686);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cw(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dhu();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bt.eGO();
          i = com.tencent.mm.ao.c.cu(aj.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aBj();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aBj();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.ym(paramAnonymousd.fns);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ad.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.vKh;
        if (locale.dep == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.ye(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bt.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ad.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.UC())
              {
                if (!bt.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ad.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.yc((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).yc((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.afA().gcy.a(new m(l.y(l.this), (dht)l.s(l.this).gUS.gUX, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
                    ad.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oh((int)l.b(l.this));
                      i.og((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).ayp();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.gTY, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dep;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.K(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hgm == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.by((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
              paramAnonymousString = new dhu();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.uKZ != 0L) {}
                for (l1 = paramAnonymousString.uKZ;; l1 = paramAnonymousInt)
                {
                  ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.gTY, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.CxC))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).ayp();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.uKX;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).ayp();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dht)l.s(l.this).gUS.gUX;
        py localpy = new py();
        localpy.COE = ((dht)localObject1).ExR.Ehn;
        localpy.sdQ = ((dht)localObject1).Cxx.Ehn;
        localpy.sdP = ((dht)localObject1).Cxy.Ehn;
        localpy.COF = ((dht)localObject1).ExY;
        localpy.COG = ((dht)localObject1).ExZ;
        localpy.Scene = l.z(l.this);
        localpy.COI = l.A(l.this);
        localpy.COJ = l.B(l.this);
        localpy.COK = l.C(l.this);
        localpy.CxC = ((dht)localObject1).CxC;
        localpy.COP = l.D(l.this);
        localpy.hnC = ((dht)localObject1).hnC;
        localpy.CuS = ((dht)localObject1).CuS;
        localpy.CuU = ((dht)localObject1).CuU;
        localpy.CuT = ((dht)localObject1).CuT;
        localpy.COT = ((dht)localObject1).COT;
        localObject1 = l.d(l.this);
        Object localObject2 = o.ayF().p(((e)localObject1).hgj, "", "");
        com.tencent.mm.ao.f.awM();
        localpy.COR = com.tencent.mm.ao.a.xF((String)localObject2);
        localpy.COS = ((e)localObject1).hgn;
        int i;
        label342:
        String str;
        if (localpy.COS <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localpy.COS = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localpy.rNz = 2;
            if (localpy.COS == 3) {
              localpy.rNz = 4;
            }
            ad.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localpy.COF), Integer.valueOf(localpy.COG), localpy.CxC, localpy.sdP, localpy.COP, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hgj, localObject2, Integer.valueOf(localpy.COR), Integer.valueOf(localpy.COS), Integer.valueOf(localpy.rNz) });
            paramAnonymousString = new b.a();
            paramAnonymousString.gUU = localpy;
            paramAnonymousString.gUV = new dhu();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.atI();
            localObject2 = l.F(l.this).avg();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).ava()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).ava())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mq(1), ((com.tencent.mm.network.c)localObject2).auZ(), ((com.tencent.mm.network.c)localObject2).avb(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localpy.COE });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localpy.rNz = 1;
          break label342;
          localpy.rNz = 3;
          break label342;
          localpy.rNz = 5;
          break label342;
        }
        label744:
        ad.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
        return;
        label776:
        ad.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        pz localpz = new pz();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.afA().gcy.gVH.avg().mq(1), localPInt, localpz);
          ad.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localpz.COP, localpz.CCm, localpz.COE });
          l.c(l.this, localpz.COP);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localpz.COU);
          ad.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localpz.COU) });
          ad.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.fYH = false;
    ad.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramh, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt4), Boolean.TRUE, bt.eGN(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.hik = paramBoolean;
    this.hhQ = paramInt4;
    this.hhI = paramh;
    this.hgm = paramInt2;
    this.scene = paramInt5;
    this.dpb = paramFloat2;
    this.hil = paramFloat1;
    this.fYA = paramInt1;
    this.hio = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.hii = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong1 > 0L)
    {
      paramString5 = o.ayF().b(Long.valueOf(paramLong1));
      paramString5 = o.ayF().p(paramString5.hgo, "", "");
    }
    if (paramLong2 > 0L) {
      this.hiq = bk.uo(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong2).esh);
    }
    try
    {
      for (;;)
      {
        this.hhJ = o.ayF().a(paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
        this.fYz = this.hhJ;
        ad.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.hhJ);
        if ((this.hhJ >= 0L) && (i.of((int)this.hhJ))) {
          break;
        }
        ad.e(this.TAG, "insert to img storage failed id:" + this.hhJ);
        this.hgs = -1L;
        this.rr = null;
        AppMethodBeat.o(169188);
        return;
        if (!bt.isNullOrNil(paramString6)) {
          this.hiq = paramString6;
        }
      }
    }
    catch (SQLiteException paramString6)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 182L, 1L, false);
        if (!paramString6.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        o.ayF().ayl();
        ad.e(this.TAG, "fallback to insert");
        this.hhJ = o.ayF().a(paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
      }
      AppMethodBeat.o(169188);
      throw paramString6;
    }
    if (this.hhJ >= 0L)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      paramString3 = new b.a();
      paramString3.gUU = new dht();
      paramString3.gUV = new dhu();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.reqCmdId = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.atI();
      this.dxK = paramString2;
      this.dbD = new bl();
      this.dbD.setType(com.tencent.mm.model.w.tr(paramString2));
      this.dbD.nY(paramString2);
      this.dbD.jV(1);
      this.dbD.setStatus(1);
      this.dbD.nZ(localPString.value);
      this.dbD.kh(localPInt1.value);
      this.dbD.ki(localPInt2.value);
      this.dbD.kY(bi.uj(this.dbD.field_talker));
      this.dbD.setContent(paramString4);
      a.a.Wh().n(this.dbD);
    }
    label1619:
    label1625:
    label1630:
    for (;;)
    {
      try
      {
        this.hgs = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().c(this.dbD, true);
        if (this.hgs >= 0L)
        {
          paramBoolean = true;
          Assert.assertTrue(paramBoolean);
          ad.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hgs);
          paramString3 = ayr();
          paramString3.mq((int)this.hgs);
          o.ayF().a(Long.valueOf(this.hhJ), paramString3);
          if (paramInt2 != 1) {
            break label1630;
          }
          this.fYz = paramString3.hgu;
          paramString3 = ayq();
          paramString3.nX((int)com.tencent.mm.vfs.i.aMN(o.ayF().p(paramString3.hgj, "", "")));
          o.ayF().a(Long.valueOf(this.fYz), paramString3);
          ad.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.fYz + " img len = " + paramString3.gTY);
          paramString5 = (dht)this.rr.gUS.gUX;
          paramString5.Cxx = new cmf().aEE(paramString1);
          paramString5.Cxy = new cmf().aEE(paramString2);
          paramString5.uKR = paramString3.offset;
          paramString5.uKQ = paramString3.gTY;
          paramString5.saz = this.dbD.getType();
          paramString5.DvO = paramInt2;
          if (!ae.cJ(aj.getContext())) {
            break label1619;
          }
          paramInt3 = 1;
          paramString5.CYi = paramInt3;
          paramString5.EnY = paramString3.dep;
          paramString5.COS = paramString3.hgn;
          paramString5.ExY = localPInt2.value;
          paramString5.ExZ = localPInt1.value;
          paramString1 = f.ye(paramString4);
          if ((paramString1 != null) && (!bt.isNullOrNil(paramString1.appId)))
          {
            paramString5.hnC = paramString1.appId;
            paramString5.CuS = paramString1.mediaTagName;
            paramString5.CuU = paramString1.messageAction;
            paramString5.CuT = paramString1.messageExt;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(paramString2)) {
            paramString5.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(paramString2);
          }
          ad.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.ExY), Integer.valueOf(paramString5.ExZ) });
          if (paramString5.COS == 0)
          {
            if (paramInt1 != 4) {
              break label1625;
            }
            paramInt1 = 2;
            paramString5.COS = paramInt1;
          }
          ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.dep), Integer.valueOf(paramString5.COS) });
          if (paramString3.offset == 0) {
            this.hhM = new com.tencent.mm.modelstat.h(getType(), true, paramString3.gTY);
          }
          paramLong1 = System.currentTimeMillis();
          oi(paramInt2);
          ad.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong1) });
          if (paramh != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150681);
                paramh.a(this.hhY, this.hhZ, l.this);
                AppMethodBeat.o(150681);
              }
            });
          }
          AppMethodBeat.o(169188);
          return;
          paramBoolean = false;
        }
      }
      catch (SQLiteException paramString3)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 182L, 1L, false);
        if (paramString3.toString().contains("UNIQUE constraint failed"))
        {
          ad.e(this.TAG, "fallback to insert");
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().cOR();
          this.hgs = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().c(this.dbD, true);
          continue;
        }
        AppMethodBeat.o(169188);
        throw paramString3;
      }
      paramBoolean = false;
      continue;
      paramInt3 = 2;
      continue;
      paramInt1 = 1;
    }
  }
  
  public l(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, final com.tencent.mm.al.h paramh, int paramInt2, String paramString4, String paramString5)
  {
    AppMethodBeat.i(150696);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hic = "";
    this.hid = "";
    this.hie = true;
    this.hig = 16384;
    this.hgm = 0;
    this.dbD = null;
    this.hhM = null;
    this.hhN = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fLB = 0;
    this.hih = new b(null);
    this.hip = false;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ad.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
          AppMethodBeat.o(150686);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bt.eGO();
            i = com.tencent.mm.ao.c.cu(aj.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.ym(paramAnonymousd.fns))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aBj();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.deI != l.c(l.this)))
        {
          com.tencent.mm.ao.f.awL().xK(l.j(l.this));
          ad.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).ayp();
          }
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          l.a(l.this, locale, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(150686);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afE().ax(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).nW(0);
                l.r(l.this).kY(bi.uj(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.ao.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dht)l.s(l.this).gUS.gUX;
                if (localObject == null) {
                  ad.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dht)localObject).ExR = new cmf().aEE(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.afE().ax(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(150684);
                  l.a(l.this, l.d(l.this));
                  AppMethodBeat.o(150684);
                }
              });
              AppMethodBeat.o(150686);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cw(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dhu();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bt.eGO();
          i = com.tencent.mm.ao.c.cu(aj.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aBj();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aBj();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).ayp();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.ym(paramAnonymousd.fns);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ad.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.vKh;
        if (locale.dep == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.ye(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.c(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bt.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ad.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.UC())
              {
                if (!bt.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ad.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.yc((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).yc((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.afA().gcy.a(new m(l.y(l.this), (dht)l.s(l.this).gUS.gUX, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
                    ad.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oh((int)l.b(l.this));
                      i.og((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).ayp();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.gTY, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dep;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.K(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hgm == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.by((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.by((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.by((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.ym(paramAnonymousd.fns) })).aBj();
              paramAnonymousString = new dhu();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.uKZ != 0L) {}
                for (l1 = paramAnonymousString.uKZ;; l1 = paramAnonymousInt)
                {
                  ad.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.gTY, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.CxC))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).ayp();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.uKX;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(l.f(l.this), "exception:%s", new Object[] { bt.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).ayp();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dht)l.s(l.this).gUS.gUX;
        py localpy = new py();
        localpy.COE = ((dht)localObject1).ExR.Ehn;
        localpy.sdQ = ((dht)localObject1).Cxx.Ehn;
        localpy.sdP = ((dht)localObject1).Cxy.Ehn;
        localpy.COF = ((dht)localObject1).ExY;
        localpy.COG = ((dht)localObject1).ExZ;
        localpy.Scene = l.z(l.this);
        localpy.COI = l.A(l.this);
        localpy.COJ = l.B(l.this);
        localpy.COK = l.C(l.this);
        localpy.CxC = ((dht)localObject1).CxC;
        localpy.COP = l.D(l.this);
        localpy.hnC = ((dht)localObject1).hnC;
        localpy.CuS = ((dht)localObject1).CuS;
        localpy.CuU = ((dht)localObject1).CuU;
        localpy.CuT = ((dht)localObject1).CuT;
        localpy.COT = ((dht)localObject1).COT;
        localObject1 = l.d(l.this);
        Object localObject2 = o.ayF().p(((e)localObject1).hgj, "", "");
        com.tencent.mm.ao.f.awM();
        localpy.COR = com.tencent.mm.ao.a.xF((String)localObject2);
        localpy.COS = ((e)localObject1).hgn;
        int i;
        label342:
        String str;
        if (localpy.COS <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localpy.COS = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localpy.rNz = 2;
            if (localpy.COS == 3) {
              localpy.rNz = 4;
            }
            ad.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localpy.COF), Integer.valueOf(localpy.COG), localpy.CxC, localpy.sdP, localpy.COP, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hgj, localObject2, Integer.valueOf(localpy.COR), Integer.valueOf(localpy.COS), Integer.valueOf(localpy.rNz) });
            paramAnonymousString = new b.a();
            paramAnonymousString.gUU = localpy;
            paramAnonymousString.gUV = new dhu();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.atI();
            localObject2 = l.F(l.this).avg();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).ava()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).ava())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mq(1), ((com.tencent.mm.network.c)localObject2).auZ(), ((com.tencent.mm.network.c)localObject2).avb(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localpy.COE });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localpy.rNz = 1;
          break label342;
          localpy.rNz = 3;
          break label342;
          localpy.rNz = 5;
          break label342;
        }
        label744:
        ad.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
        return;
        label776:
        ad.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localpy.COE });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        pz localpz = new pz();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.afA().gcy.gVH.avg().mq(1), localPInt, localpz);
          ad.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localpz.COP, localpz.CCm, localpz.COE });
          l.c(l.this, localpz.COP);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localpz.COU);
          ad.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localpz.COU) });
          ad.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.fYH = false;
    ad.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(3), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), paramh, Integer.valueOf(paramInt2), paramString4, paramString5, Boolean.TRUE, Integer.valueOf(2131231564), Boolean.TRUE, bt.eGN() });
    this.hik = true;
    this.hhQ = 2131231564;
    this.hhI = paramh;
    this.hgm = paramInt1;
    this.fYA = 3;
    this.hio = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.hii = paramString4;
    this.hhJ = paramLong;
    this.fYz = this.hhJ;
    paramString3 = ayr();
    this.dbD = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramString3.hgs);
    this.hgs = this.dbD.field_msgId;
    localPInt.value = this.dbD.eOV;
    paramString5.value = this.dbD.eOU;
    if (paramInt1 == 1)
    {
      this.fYz = paramString3.hgu;
      this.fYB = null;
      paramString3 = ayq();
    }
    for (;;)
    {
      if ((this.dbD.field_talker != null) && (!this.dbD.field_talker.equals(paramString2)))
      {
        ad.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.dbD.field_talker });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.dbD.field_talker;; paramString4 = paramString2)
      {
        ad.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.dbD.field_msgId);
        ad.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.hhJ);
        if ((this.hhJ < 0L) || (!i.of((int)this.hhJ)))
        {
          ad.e(this.TAG, "insert to img storage failed id:" + this.hhJ);
          this.hgs = -1L;
          this.rr = null;
          AppMethodBeat.o(150696);
          return;
        }
        boolean bool;
        if (this.hhJ >= 0L)
        {
          bool = true;
          Assert.assertTrue(bool);
          paramString2 = new b.a();
          paramString2.gUU = new dht();
          paramString2.gUV = new dhu();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.reqCmdId = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.atI();
          ad.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.fYz + " img len = " + paramString3.gTY);
          paramString2 = (dht)this.rr.gUS.gUX;
          paramString2.Cxx = new cmf().aEE(paramString1);
          paramString2.Cxy = new cmf().aEE(paramString4);
          paramString2.uKR = paramString3.offset;
          paramString2.uKQ = paramString3.gTY;
          paramString2.saz = this.dbD.getType();
          paramString2.DvO = paramInt1;
          if (!ae.cJ(aj.getContext())) {
            break label1078;
          }
        }
        label1078:
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          paramString2.CYi = paramInt1;
          paramString2.EnY = paramString3.dep;
          paramString2.COS = paramString3.hgn;
          paramString2.ExY = localPInt.value;
          paramString2.ExZ = paramString5.value;
          ad.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.ExY), Integer.valueOf(paramString2.ExZ) });
          if (paramString2.COS == 0) {
            paramString2.COS = 1;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(paramString4)) {
            paramString2.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(paramString4);
          }
          ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.dep), Integer.valueOf(paramString2.COS) });
          if (paramString3.offset == 0) {
            this.hhM = new com.tencent.mm.modelstat.h(getType(), true, paramString3.gTY);
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(150682);
              paramh.a(this.hhY, this.hhZ, l.this);
              AppMethodBeat.o(150682);
            }
          });
          AppMethodBeat.o(150696);
          return;
          bool = false;
          break;
        }
      }
    }
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, "", "");
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt1, com.tencent.mm.al.h paramh, int paramInt2, a parama)
  {
    this(3, paramString1, paramString2, paramString3, paramInt1, paramh, paramInt2, "", "", true, 2131231564);
    AppMethodBeat.i(150694);
    this.hih = new b(parama);
    AppMethodBeat.o(150694);
  }
  
  private l(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this(4, paramString1, paramString2, paramString3, paramInt, null, 0, paramString4, paramString5, false, -1);
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, long paramLong, String paramString6)
  {
    this(4, paramString1, paramString2, paramString3, paramInt, null, 0, paramString4, paramString5, true, 2131231564, 0, -1000.0F, -1000.0F, -1L, paramLong, paramString6);
  }
  
  private boolean a(e parame, int paramInt)
  {
    AppMethodBeat.i(150700);
    if (com.tencent.mm.model.w.tp(this.dbD.field_talker))
    {
      ad.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { this.dbD.field_talker });
      AppMethodBeat.o(150700);
      return false;
    }
    com.tencent.mm.ao.f.awL();
    if ((!com.tencent.mm.ao.b.nL(1)) && (bt.isNullOrNil(parame.hgv)))
    {
      localObject = this.TAG;
      com.tencent.mm.ao.f.awL();
      ad.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.nL(1)), parame.hgv });
      AppMethodBeat.o(150700);
      return false;
    }
    if (bt.isNullOrNil(this.hhN))
    {
      ad.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.fYz) });
      AppMethodBeat.o(150700);
      return false;
    }
    String str2 = o.ayF().p(parame.hgj, "", "");
    String str1 = o.ayF().p(parame.hgk, "", "");
    String str4 = o.ayF().p(parame.hgl, "", "");
    Object localObject = o.ayF().p(parame.hgo, "", "");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fnH = this.hhW;
    localg.field_mediaId = this.hhN;
    localg.field_fileType = this.fLB;
    localg.field_talker = this.dbD.field_talker;
    int i;
    boolean bool1;
    if (com.tencent.mm.model.w.pF(this.dbD.field_talker))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.fmV;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_sendmsg_viacdn = true;
      localg.field_enable_hitcheck = this.hie;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      if (paramInt != -5103237) {
        break label925;
      }
      this.hhN = com.tencent.mm.ao.c.a("upimgjpg", this.dbD.field_createTime, this.dbD.field_talker, this.dbD.field_msgId + "_" + this.fYz + "_" + this.hgm);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.hhN;
      this.hip = false;
      if (!this.hip)
      {
        bool1 = t.aFn(str4);
        ad.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", new Object[] { Boolean.valueOf(bool1) });
      }
      if ((localg.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) && (bt.isNullOrNil(localg.field_midimgpath)))
      {
        com.tencent.mm.ao.f.awL();
        if (com.tencent.mm.ao.b.nL(256))
        {
          ad.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = bw.K(this.hii, "msg");
      if (localObject == null) {
        break label1282;
      }
      if (this.hgm == 1) {
        break label1233;
      }
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"));
      localg.field_midFileLength = bt.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      label623:
      localg.field_aesKey = ((String)((Map)localObject).get(".msg.img.$aeskey"));
    }
    for (;;)
    {
      if ((bt.isNullOrNil(localg.field_aesKey)) || ("null".equalsIgnoreCase(localg.field_aesKey)))
      {
        com.tencent.mm.ao.f.awM();
        localg.field_aesKey = com.tencent.mm.ao.a.awE();
        ad.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      ad.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(parame.dep), localg.field_fileId });
      this.hic = localg.field_fileId;
      this.hid = localg.field_aesKey;
      ad.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.hin = null;
      if (com.tencent.mm.ao.f.awL().e(localg)) {
        break label1306;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 205L, 1L, false);
      ad.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.hhN });
      this.hhN = "";
      AppMethodBeat.o(150700);
      return false;
      i = 0;
      break;
      label925:
      boolean bool2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).bTU();
      String str3;
      boolean bool3;
      if ((this.fYA == 4) && (com.tencent.mm.vfs.i.eK((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Tl(str1);
        bool3 = bf(str1, str3);
        if (!bool2) {
          break label1207;
        }
        label990:
        localg.field_fullpath = ((String)localObject);
        localg.field_thumbpath = str4;
        if (!bool3) {
          break label1214;
        }
        localObject = str3;
        label1013:
        localg.field_midimgpath = ((String)localObject);
        if ((!bool2) && (!bool3)) {
          break label1221;
        }
        bool1 = true;
        label1033:
        this.hip = bool1;
        localObject = this.TAG;
        if (localg.field_fileType != com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) {
          break label1227;
        }
      }
      label1207:
      label1214:
      label1221:
      label1227:
      for (bool1 = true;; bool1 = false)
      {
        ad.d((String)localObject, "hevc upload full size %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        break;
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Tl(str2);
        bool1 = t.aFo(str2).equals(".png");
        if ((this.hgm == 0) && (!bool1) && (bf(str2, str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          parame.yd(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Tl(parame.hgj));
          bool2 = bool1;
          localObject = str3;
          break;
        }
        localObject = str2;
        break label990;
        localObject = str1;
        break label1013;
        bool1 = false;
        break label1033;
      }
      label1233:
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"));
      localg.field_midFileLength = bt.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      break label623;
      label1282:
      ad.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { parame.hgv });
    }
    label1306:
    if (bt.nullAsNil(parame.hgv).length() <= 0)
    {
      parame.yc("CDNINFO_SEND");
      parame.dtM = 4096;
    }
    AppMethodBeat.o(150700);
    return true;
  }
  
  private boolean a(e parame, int paramInt1, long paramLong, int paramInt2, d paramd, String paramString)
  {
    AppMethodBeat.i(169189);
    ad.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.hhN, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    ad.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(ab.hVD), Long.valueOf(this.hhJ), Long.valueOf(this.fYz) });
    long l = paramLong;
    if (10007 == ab.hVC)
    {
      l = paramLong;
      if (ab.hVD != 0)
      {
        l = ab.hVD;
        ab.hVD = 0;
      }
    }
    b(parame.deI, paramInt1, parame.gTY);
    parame.setOffset(paramInt1);
    parame.kX(l);
    if ((f.b(parame)) && (this.hhJ != this.fYz))
    {
      e locale = o.ayF().b(Long.valueOf(this.hhJ));
      locale.kX(l);
      locale.nX(parame.gTY);
      locale.setOffset(parame.gTY);
      o.ayF().a(Long.valueOf(this.hhJ), locale);
    }
    if (f.b(parame))
    {
      if (bt.isNullOrNil(this.hhN)) {
        com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.fLB), Integer.valueOf(parame.gTY - this.startOffset) });
      }
      this.dbD.setStatus(2);
      this.dbD.kX(l);
      this.dbD.mZ(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.hgs, this.dbD);
      if (com.tencent.mm.modelstat.r.hxt != null) {
        com.tencent.mm.modelstat.r.hxt.q(this.dbD);
      }
      if (this.hhM != null) {
        this.hhM.mB(0L);
      }
      if (r.hjt != null) {
        r.hjt.a(this.fYz, this.dbD, this.rr, this.fYA, this.fYH, paramd);
      }
      if (this.hih != null) {
        this.hih.ayp();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      i.og((int)this.hhJ);
      AppMethodBeat.o(169189);
      return false;
    }
    AppMethodBeat.o(169189);
    return true;
  }
  
  private e ayq()
  {
    AppMethodBeat.i(150692);
    if (this.fYB == null) {
      this.fYB = o.ayF().b(Long.valueOf(this.fYz));
    }
    e locale = this.fYB;
    AppMethodBeat.o(150692);
    return locale;
  }
  
  private e ayr()
  {
    AppMethodBeat.i(150693);
    if (this.hif == null) {
      this.hif = o.ayF().b(Long.valueOf(this.hhJ));
    }
    e locale = this.hif;
    AppMethodBeat.o(150693);
    return locale;
  }
  
  private void b(final long paramLong, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150707);
    if (this.hhI != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150690);
          n localn = n.ayt();
          long l1 = paramLong;
          long l2 = paramInt1;
          long l3 = this.hiv;
          if (localn.hiz.containsKey(Long.valueOf(l1))) {}
          for (n.d locald = (n.d)localn.hiz.get(Long.valueOf(l1));; locald = new n.d())
          {
            locald.offset = l3;
            locald.dpt = l2;
            localn.hiz.put(Long.valueOf(l1), locald);
            l.G(l.this).a(this.hiv, paramInt1, l.this);
            AppMethodBeat.o(150690);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(150707);
  }
  
  private boolean bf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150701);
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).bTU())
    {
      AppMethodBeat.o(150701);
      return false;
    }
    if (com.tencent.mm.vfs.i.aMN(paramString1) > 0L)
    {
      if (com.tencent.mm.vfs.i.aMN(paramString2) > 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(944, 9);
        com.tencent.mm.vfs.i.deleteFile(paramString2);
      }
      if (!com.tencent.mm.vfs.i.eK(paramString2)) {
        com.tencent.mm.vfs.i.aMR(paramString2);
      }
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).eV(paramString1, paramString2) == 0)
      {
        AppMethodBeat.o(150701);
        return true;
      }
      ad.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
    }
    AppMethodBeat.o(150701);
    return false;
  }
  
  public static void mt(long paramLong)
  {
    hir = paramLong;
  }
  
  private int oj(int paramInt)
  {
    AppMethodBeat.i(150703);
    ad.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.hih != null) {
      this.hih.ayp();
    }
    AppMethodBeat.o(150703);
    return -1;
  }
  
  public static String ym(String paramString)
  {
    AppMethodBeat.i(150708);
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150708);
        return paramString;
      }
      Object localObject = paramString.split(",");
      if ((localObject != null) && (localObject.length > 19))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = hir;
        hir = -1L;
        localObject[19] = l;
        localObject = bt.n(bt.S((String[])localObject), ",");
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
  
  public final void ays()
  {
    AppMethodBeat.i(150705);
    ad.i(this.TAG, "send img from system");
    this.fYH = true;
    AppMethodBeat.o(150705);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150702);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150689);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agm("SendImgSpeeder");
        AppMethodBeat.o(150689);
      }
    }, 100L);
    if (this.fYz < 0L)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 204L, 1L, false);
      ad.e(this.TAG, "doScene invalid imgLocalId:" + this.fYz);
      i = oj(-1);
      AppMethodBeat.o(150702);
      return i;
    }
    if (this.dbD == null)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 203L, 1L, false);
      ad.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.fYz) });
      i.oh((int)this.hhJ);
      i = oj(-2);
      AppMethodBeat.o(150702);
      return i;
    }
    this.callback = paramg;
    prepareDispatcher(parame);
    dht localdht = (dht)this.rr.gUS.gUX;
    e locale = ayq();
    paramg = o.ayF().oe((int)locale.deI);
    if (paramg != null)
    {
      if (paramg.status == -1)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 202L, 1L, false);
        ad.e(this.TAG, "doScene hd img info is null or error.");
        i = oj(-3);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else if ((locale == null) || (locale.status == -1))
    {
      ad.e(this.TAG, "doScene img info is null or error.");
      i = oj(-4);
      AppMethodBeat.o(150702);
      return i;
    }
    Object localObject;
    if (a.a.Wh().pc(this.dbD.field_talker))
    {
      localdht.CxC = a.a.Wh().o(this.dbD);
      ad.i(this.TAG, "upload img msg source %s", new Object[] { localdht.CxC });
      paramg = o.ayF().p(locale.hgj, "", "");
      localObject = o.ayF().p(locale.hgl, "", "");
      if (!bt.isNullOrNil(locale.hgk)) {
        o.ayF().p(locale.hgk, "", "");
      }
      if ((com.tencent.mm.vfs.i.aMN(paramg) <= 0L) || (com.tencent.mm.vfs.i.aMN((String)localObject) <= 0L))
      {
        ad.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.fYz), Long.valueOf(com.tencent.mm.vfs.i.aMN(paramg)), Long.valueOf(com.tencent.mm.vfs.i.aMN((String)localObject)), paramg, localObject });
        i = oj(-5);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else
    {
      if (bt.isNullOrNil(this.hiq))
      {
        paramg = com.tencent.mm.vfs.i.aEN(this.hio);
        localObject = v.hUC;
        this.hiq = v.BC(paramg);
      }
      if (!bt.isNullOrNil(this.hiq)) {}
      for (paramg = bk.up(this.hiq);; paramg = bk.SM())
      {
        if (((paramg != null) && (!paramg.equals(this.dbD.esh))) || ((paramg == null) && (!bt.isNullOrNil(this.dbD.esh))))
        {
          this.dbD.mZ(paramg);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.dbD.field_msgId, this.dbD);
        }
        localdht.CxC = this.dbD.esh;
        break;
      }
    }
    if ((localdht.ExR == null) || (bt.isNullOrNil(localdht.ExR.Ehn)))
    {
      if (bt.isNullOrNil(this.hhN))
      {
        ad.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.dbD.field_createTime), this.dbD.field_talker, Long.valueOf(this.dbD.field_msgId), Long.valueOf(this.fYz), Integer.valueOf(this.hgm) });
        this.hhN = com.tencent.mm.ao.c.a("upimg", this.dbD.field_createTime, this.dbD.field_talker, this.dbD.field_msgId + "_" + this.fYz + "_" + this.hgm);
      }
      localdht.ExR = new cmf().aEE(this.hhN);
      bl localbl = this.dbD;
      localbl.ePa = this.hhN;
      localbl.erH = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.eGO();
      this.startOffset = locale.offset;
      if (this.hgm != 1) {
        break label974;
      }
    }
    label974:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.fLB = i;
      ad.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", new Object[] { paramg, localObject, locale.hgj });
      if (!a(locale, 0)) {
        break;
      }
      ad.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localdht.ExR.Ehn });
      AppMethodBeat.o(150702);
      return 0;
    }
    ad.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
    if ((com.tencent.mm.m.g.Zd().getInt("UploadMsgImgType", 0) == 1) && (this.hgm == 0))
    {
      locale.yd(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Tl(locale.hgj));
      localObject = o.ayF().p(locale.hgo, "", "");
      i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).eV(paramg, (String)localObject);
      if (i != 0) {
        break label1207;
      }
      locale.oa(1);
      locale.nX((int)com.tencent.mm.vfs.i.aMN((String)localObject));
    }
    for (;;)
    {
      ad.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.fYz), localObject, Integer.valueOf(i), Integer.valueOf(locale.gTY) });
      i = locale.hgt;
      if (i < securityLimitCount()) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 201L, 1L, false);
      ad.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
      i.oh((int)this.hhJ);
      i = oj(-6);
      AppMethodBeat.o(150702);
      return i;
      label1207:
      locale.oa(0);
    }
    locale.nW(i + 1);
    locale.dtM = 512;
    o.ayF().a(Long.valueOf(this.fYz), locale);
    int j = locale.gTY - locale.offset;
    i = j;
    if (j > this.hig) {
      i = this.hig;
    }
    com.tencent.mm.vfs.i.aMN(paramg);
    if (locale.hgp == 1) {}
    for (paramg = o.ayF().p(locale.hgo, "", "");; paramg = o.ayF().p(locale.hgj, "", ""))
    {
      paramg = com.tencent.mm.vfs.i.aR(paramg, locale.offset, i);
      if ((paramg != null) && (paramg.length > 0)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 199L, 1L, false);
      ad.e(this.TAG, "doScene, file read buf error.");
      i = oj(-8);
      AppMethodBeat.o(150702);
      return i;
    }
    localdht.uKS = paramg.length;
    localdht.uKQ = locale.gTY;
    localdht.uKR = locale.offset;
    localdht.uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
    localdht.DPf = locale.hgp;
    if (this.hhM != null) {
      this.hhM.aBI();
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      ad.e(this.TAG, "doScene netId error");
      i.oh((int)this.hhJ);
      i = oj(-9);
      AppMethodBeat.o(150702);
      return i;
    }
    AppMethodBeat.o(150702);
    return i;
  }
  
  public final int getType()
  {
    return 110;
  }
  
  public final void oi(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(150697);
    if (this.dbD == null)
    {
      ad.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.hgs), Integer.valueOf(paramInt) });
      AppMethodBeat.o(150697);
      return;
    }
    if (this.hik)
    {
      if (this.dbD.eOY == 0)
      {
        boolean bool = o.ayF().a(this.dbD, this.hhQ, paramInt);
        bl localbl = this.dbD;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localbl.kk(paramInt);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.hgs, this.dbD);
          AppMethodBeat.o(150697);
          return;
        }
      }
    }
    else {
      o.ayF().a(this.dbD.field_imgPath, com.tencent.mm.cd.a.getDensity(aj.getContext()), true);
    }
    AppMethodBeat.o(150697);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150704);
    ad.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.hhN);
    paramq = (dhu)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.COU);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 198L, 1L, false);
      i.oh((int)this.hhJ);
      i.og((int)this.hhJ);
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.fLB), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.hih != null) {
        this.hih.ayp();
      }
      AppMethodBeat.o(150704);
      return;
    }
    this.hig = paramq.uKS;
    if (this.hig > 16384) {
      this.hig = 16384;
    }
    paramString = ayq();
    ad.v(this.TAG, "onGYNetEnd localId:" + this.fYz + "  totalLen:" + paramString.gTY + " offSet:" + paramString.offset);
    if ((paramq.uKR < 0) || ((paramq.uKR > paramString.gTY) && (paramString.gTY > 0)))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 197L, 1L, false);
      ad.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + paramq.uKR + " img totalLen = " + paramString.gTY);
      i.oh((int)this.hhJ);
      i.og((int)this.hhJ);
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.fLB), Integer.valueOf(0) });
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.hih != null) {
        this.hih.ayp();
      }
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramq.uKR < paramString.offset) || ((f.b(paramString)) && (this.hig <= 0)))
    {
      ad.e(this.TAG, "onGYNetEnd invalid data startPos = " + paramq.uKR + " totalLen = " + paramString.gTY + " off:" + paramString.offset);
      i.oh((int)this.hhJ);
      i.og((int)this.hhJ);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.hih != null) {
        this.hih.ayp();
      }
      AppMethodBeat.o(150704);
      return;
    }
    ad.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + paramq.uKR);
    if ((a(paramString, paramq.uKR, paramq.uKZ, paramq.CreateTime, null, paramq.CxC)) && (doScene(dispatcher(), this.callback) < 0))
    {
      i.og((int)this.hhJ);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.hih != null) {
        this.hih.ayp();
      }
    }
    AppMethodBeat.o(150704);
  }
  
  public final int securityLimitCount()
  {
    if (this.hgm == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
  
  public static abstract interface a
  {
    public abstract void ayp();
  }
  
  public final class b
  {
    public l.a hiw;
    
    public b(l.a parama)
    {
      this.hiw = parama;
    }
    
    final void ayp()
    {
      AppMethodBeat.i(150691);
      if (l.b(l.this) == l.c(l.this)) {}
      for (Object localObject = l.d(l.this);; localObject = l.e(l.this))
      {
        if (((e)localObject).hgw == 1)
        {
          com.tencent.mm.plugin.report.service.g.KJ(23);
          com.tencent.mm.plugin.report.service.g.KJ(21);
        }
        ad.i(l.f(l.this), "UploadEndWrapper onUploadEnd %s done", new Object[] { l.h(l.d(l.this)) });
        if (o.ayF().a(Long.valueOf(l.c(l.this)), l.d(l.this)) < 0)
        {
          ad.e(l.f(l.this), "update db failed local id:" + l.c(l.this) + " server id:" + l.d(l.this).drA);
          i.oh((int)l.b(l.this));
          i.og((int)l.b(l.this));
          l.g(l.this).onSceneEnd(3, -1, "", l.this);
        }
        if (l.c(l.this) != l.b(l.this))
        {
          ad.i(l.f(l.this), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { l.h(l.e(l.this)) });
          o.ayF().a(Long.valueOf(l.b(l.this)), l.e(l.this));
        }
        if ((!com.tencent.mm.sdk.a.b.eEQ()) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
          break;
        }
        localObject = o.ayF().ayn();
        if (localObject == null) {
          break;
        }
        int i = 0;
        while (i < ((List)localObject).size())
        {
          ad.i(l.f(l.this), "UploadEndWrapper onUploadEnd duminfo %s %s", new Object[] { Integer.valueOf(i), l.h((e)((List)localObject).get(i)) });
          i += 1;
        }
      }
      l.a(l.this, l.c(l.this));
      if (l.b(l.this) != l.c(l.this)) {
        l.a(l.this, l.b(l.this));
      }
      if (this.hiw != null) {
        this.hiw.ayp();
      }
      l.this.oi(l.h(l.this));
      l.i(l.this);
      AppMethodBeat.o(150691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.l
 * JD-Core Version:    0.7.0.1
 */