package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.wcdb.database.SQLiteException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class l
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static boolean DEBUG = true;
  private static long hIU;
  private String TAG;
  public bo cZc;
  private com.tencent.mm.ak.g callback;
  private float dmL;
  public String dvw;
  private int fPn;
  private long gdf;
  private int gdg;
  private e gdh;
  private boolean gdn;
  private int hGP;
  private long hGV;
  private String hIF;
  private String hIG;
  private boolean hIH;
  private e hII;
  private int hIJ;
  public b hIK;
  private String hIL;
  public String hIM;
  public boolean hIN;
  private float hIO;
  private String hIP;
  private String hIQ;
  public String hIR;
  private boolean hIS;
  private String hIT;
  private final com.tencent.mm.ak.h hIl;
  public long hIm;
  private com.tencent.mm.modelstat.h hIp;
  private String hIq;
  private int hIt;
  private g.a hIz;
  private final com.tencent.mm.ak.b rr;
  private int scene;
  private int startOffset;
  private long startTime;
  
  public l(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150698);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hIF = "";
    this.hIG = "";
    this.hIH = true;
    this.hIJ = 16384;
    this.hGP = 0;
    this.cZc = null;
    this.hIp = null;
    this.hIq = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fPn = 0;
    this.hIK = new b(null);
    this.hIS = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ac.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ac.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bs.eWj();
            i = com.tencent.mm.an.c.cD(ai.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.Cr(paramAnonymousd.fqM))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aHZ();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.dcd != l.c(l.this)))
        {
          com.tencent.mm.an.f.aDD().BQ(l.j(l.this));
          ac.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ac.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ac.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agU().az(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).oK(0);
                l.r(l.this).oA(bi.yp(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.an.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dni)l.s(l.this).hvr.hvw;
                if (localObject == null) {
                  ac.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ac.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dni)localObject).FUT = new crm().aJV(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ac.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          if (!bs.cv(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dnj();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bs.eWj();
          i = com.tencent.mm.an.c.cD(ai.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aHZ();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aHZ();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
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
            ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ac.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.Cr(paramAnonymousd.fqM);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ac.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
        if (locale.dbL == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.Cj(paramAnonymousString);
          if ((paramAnonymousc == null) || (bs.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.e(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bs.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ac.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.Vx())
              {
                if (!bs.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ac.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.Ch((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).Ch((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.agQ().ghe.a(new m(l.y(l.this), (dni)l.s(l.this).hvr.hvw, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
                    ac.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oV((int)l.b(l.this));
                      i.oU((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).aFh();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.hux, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dbL;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bv.L(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hGP == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ac.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
              paramAnonymousString = new dnj();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.vTQ != 0L) {}
                for (l1 = paramAnonymousString.vTQ;; l1 = paramAnonymousInt)
                {
                  ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.hux, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.DPY))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).aFh();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.vTO;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).aFh();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dni)l.s(l.this).hvr.hvw;
        qi localqi = new qi();
        localqi.Ehp = ((dni)localObject1).FUT.FEm;
        localqi.tlK = ((dni)localObject1).DPT.FEm;
        localqi.tlJ = ((dni)localObject1).DPU.FEm;
        localqi.Ehq = ((dni)localObject1).FVa;
        localqi.Ehr = ((dni)localObject1).FVb;
        localqi.Scene = l.z(l.this);
        localqi.Eht = l.A(l.this);
        localqi.Ehu = l.B(l.this);
        localqi.Ehv = l.C(l.this);
        localqi.DPY = ((dni)localObject1).DPY;
        localqi.EhA = l.D(l.this);
        localqi.hOf = ((dni)localObject1).hOf;
        localqi.DNn = ((dni)localObject1).DNn;
        localqi.DNp = ((dni)localObject1).DNp;
        localqi.DNo = ((dni)localObject1).DNo;
        localqi.EhE = ((dni)localObject1).EhE;
        localObject1 = l.d(l.this);
        Object localObject2 = o.aFx().p(((e)localObject1).hGM, "", "");
        com.tencent.mm.an.f.aDE();
        localqi.EhC = com.tencent.mm.an.a.BL((String)localObject2);
        localqi.EhD = ((e)localObject1).hGQ;
        int i;
        label342:
        String str;
        if (localqi.EhD <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localqi.EhD = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localqi.sVo = 2;
            if (localqi.EhD == 3) {
              localqi.sVo = 4;
            }
            ac.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localqi.Ehq), Integer.valueOf(localqi.Ehr), localqi.DPY, localqi.tlJ, localqi.EhA, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hGM, localObject2, Integer.valueOf(localqi.EhC), Integer.valueOf(localqi.EhD), Integer.valueOf(localqi.sVo) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hvt = localqi;
            paramAnonymousString.hvu = new dnj();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aAz();
            localObject2 = l.F(l.this).aBZ();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aBT()))
        {
          ac.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aBT())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mp(1), ((com.tencent.mm.network.c)localObject2).aBS(), ((com.tencent.mm.network.c)localObject2).aBU(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ac.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localqi.Ehp });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localqi.sVo = 1;
          break label342;
          localqi.sVo = 3;
          break label342;
          localqi.sVo = 5;
          break label342;
        }
        label744:
        ac.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
        return;
        label776:
        ac.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        qj localqj = new qj();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.agQ().ghe.hwg.aBZ().mp(1), localPInt, localqj);
          ac.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localqj.EhA, localqj.DUJ, localqj.Ehp });
          l.c(l.this, localqj.EhA);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localqj.EhF);
          ac.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localqj.EhF) });
          ac.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.gdn = false;
    ac.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bs.eWi() });
    this.hIm = paramInt1;
    this.gdf = paramInt1;
    this.hGP = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new dni();
    ((b.a)localObject1).hvu = new dnj();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).funcId = 110;
    ((b.a)localObject1).reqCmdId = 9;
    ((b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((b.a)localObject1).aAz();
    this.hIl = null;
    ac.d(this.TAG, "FROM B SERVICE:" + this.hIm);
    if (!i.oT((int)this.hIm))
    {
      this.hIm = -1L;
      AppMethodBeat.o(150698);
      return;
    }
    localObject1 = o.aFx().c(Long.valueOf(this.hIm));
    this.hGV = ((e)localObject1).hGV;
    if (paramInt2 == 1)
    {
      this.gdf = ((e)localObject1).hGX;
      localObject1 = o.aFx().c(Long.valueOf(this.gdf));
    }
    for (;;)
    {
      Object localObject2 = o.aFx().oS((int)((e)localObject1).dcd);
      if (localObject2 != null) {
        this.hGV = ((e)localObject2).hGV;
      }
      this.cZc = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.hGV);
      if ((this.cZc != null) && (this.cZc.field_msgId != this.hGV))
      {
        ac.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.hGV) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 206L, 1L, false);
        this.cZc = null;
        AppMethodBeat.o(150698);
        return;
      }
      if (this.cZc != null)
      {
        localObject2 = (dni)this.rr.hvr.hvw;
        ((dni)localObject2).DPT = new crm().aJV(com.tencent.mm.model.u.axw());
        ((dni)localObject2).DPU = new crm().aJV(this.cZc.field_talker);
        ((dni)localObject2).vTI = ((e)localObject1).offset;
        ((dni)localObject2).vTH = ((e)localObject1).hux;
        ((dni)localObject2).tit = this.cZc.getType();
        ((dni)localObject2).ERj = paramInt2;
        if (!ae.cS(ai.getContext())) {
          break label868;
        }
      }
      label868:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dni)localObject2).EqS = paramInt1;
        ((dni)localObject2).FKX = ((e)localObject1).dbL;
        ((dni)localObject2).EhD = ((e)localObject1).hGQ;
        ((dni)localObject2).EhD = ((e)localObject1).hGQ;
        ((dni)localObject2).FVa = this.cZc.eSd;
        ((dni)localObject2).FVb = this.cZc.eSc;
        a locala = f.Cj(this.cZc.field_content);
        if ((locala != null) && (!bs.isNullOrNil(locala.appId)))
        {
          this.gdg = ((e)localObject1).dbL;
          ((dni)localObject2).hOf = locala.appId;
          ((dni)localObject2).DNn = locala.mediaTagName;
          ((dni)localObject2).DNp = locala.messageAction;
          ((dni)localObject2).DNo = locala.messageExt;
          this.hIL = this.cZc.field_content;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.cZc.field_talker)) {
          ((dni)localObject2).EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(this.cZc.field_talker);
        }
        ac.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dni)localObject2).FVa), Integer.valueOf(((dni)localObject2).FVb) });
        ac.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).dbL), Integer.valueOf(((dni)localObject2).EhD) });
        if (((e)localObject1).offset == 0) {
          this.hIp = new com.tencent.mm.modelstat.h(getType(), true, ((e)localObject1).hux);
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
    this.hIF = "";
    this.hIG = "";
    this.hIH = true;
    this.hIJ = 16384;
    this.hGP = 0;
    this.cZc = null;
    this.hIp = null;
    this.hIq = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fPn = 0;
    this.hIK = new b(null);
    this.hIS = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ac.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ac.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bs.eWj();
            i = com.tencent.mm.an.c.cD(ai.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.Cr(paramAnonymousd.fqM))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aHZ();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.dcd != l.c(l.this)))
        {
          com.tencent.mm.an.f.aDD().BQ(l.j(l.this));
          ac.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ac.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ac.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agU().az(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).oK(0);
                l.r(l.this).oA(bi.yp(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.an.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dni)l.s(l.this).hvr.hvw;
                if (localObject == null) {
                  ac.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ac.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dni)localObject).FUT = new crm().aJV(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ac.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          if (!bs.cv(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dnj();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bs.eWj();
          i = com.tencent.mm.an.c.cD(ai.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aHZ();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aHZ();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
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
            ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ac.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.Cr(paramAnonymousd.fqM);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ac.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
        if (locale.dbL == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.Cj(paramAnonymousString);
          if ((paramAnonymousc == null) || (bs.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.e(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bs.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ac.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.Vx())
              {
                if (!bs.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ac.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.Ch((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).Ch((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.agQ().ghe.a(new m(l.y(l.this), (dni)l.s(l.this).hvr.hvw, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
                    ac.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oV((int)l.b(l.this));
                      i.oU((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).aFh();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.hux, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dbL;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bv.L(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hGP == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ac.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
              paramAnonymousString = new dnj();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.vTQ != 0L) {}
                for (l1 = paramAnonymousString.vTQ;; l1 = paramAnonymousInt)
                {
                  ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.hux, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.DPY))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).aFh();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.vTO;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).aFh();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dni)l.s(l.this).hvr.hvw;
        qi localqi = new qi();
        localqi.Ehp = ((dni)localObject1).FUT.FEm;
        localqi.tlK = ((dni)localObject1).DPT.FEm;
        localqi.tlJ = ((dni)localObject1).DPU.FEm;
        localqi.Ehq = ((dni)localObject1).FVa;
        localqi.Ehr = ((dni)localObject1).FVb;
        localqi.Scene = l.z(l.this);
        localqi.Eht = l.A(l.this);
        localqi.Ehu = l.B(l.this);
        localqi.Ehv = l.C(l.this);
        localqi.DPY = ((dni)localObject1).DPY;
        localqi.EhA = l.D(l.this);
        localqi.hOf = ((dni)localObject1).hOf;
        localqi.DNn = ((dni)localObject1).DNn;
        localqi.DNp = ((dni)localObject1).DNp;
        localqi.DNo = ((dni)localObject1).DNo;
        localqi.EhE = ((dni)localObject1).EhE;
        localObject1 = l.d(l.this);
        Object localObject2 = o.aFx().p(((e)localObject1).hGM, "", "");
        com.tencent.mm.an.f.aDE();
        localqi.EhC = com.tencent.mm.an.a.BL((String)localObject2);
        localqi.EhD = ((e)localObject1).hGQ;
        int i;
        label342:
        String str;
        if (localqi.EhD <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localqi.EhD = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localqi.sVo = 2;
            if (localqi.EhD == 3) {
              localqi.sVo = 4;
            }
            ac.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localqi.Ehq), Integer.valueOf(localqi.Ehr), localqi.DPY, localqi.tlJ, localqi.EhA, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hGM, localObject2, Integer.valueOf(localqi.EhC), Integer.valueOf(localqi.EhD), Integer.valueOf(localqi.sVo) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hvt = localqi;
            paramAnonymousString.hvu = new dnj();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aAz();
            localObject2 = l.F(l.this).aBZ();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aBT()))
        {
          ac.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aBT())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mp(1), ((com.tencent.mm.network.c)localObject2).aBS(), ((com.tencent.mm.network.c)localObject2).aBU(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ac.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localqi.Ehp });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localqi.sVo = 1;
          break label342;
          localqi.sVo = 3;
          break label342;
          localqi.sVo = 5;
          break label342;
        }
        label744:
        ac.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
        return;
        label776:
        ac.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        qj localqj = new qj();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.agQ().ghe.hwg.aBZ().mp(1), localPInt, localqj);
          ac.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localqj.EhA, localqj.DUJ, localqj.Ehp });
          l.c(l.this, localqj.EhA);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localqj.EhF);
          ac.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localqj.EhF) });
          ac.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.gdn = false;
    ac.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null, bs.eWi() });
    this.hIm = paramInt1;
    this.gdf = paramInt1;
    this.hGP = paramInt2;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new dni();
    ((b.a)localObject1).hvu = new dnj();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((b.a)localObject1).funcId = 110;
    ((b.a)localObject1).reqCmdId = 9;
    ((b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((b.a)localObject1).aAz();
    this.hIl = null;
    ac.d(this.TAG, "FROM C SERVICE:" + this.hIm);
    if (!i.oT((int)this.hIm))
    {
      this.hIm = -1L;
      AppMethodBeat.o(150699);
      return;
    }
    localObject1 = o.aFx().c(Long.valueOf(this.hIm));
    this.hGV = ((e)localObject1).hGV;
    ((e)localObject1).setStatus(0);
    ((e)localObject1).oz(0L);
    ((e)localObject1).setOffset(0);
    o.aFx().a((int)this.gdf, (e)localObject1);
    if (paramInt2 == 1)
    {
      this.gdf = ((e)localObject1).hGX;
      localObject1 = o.aFx().c(Long.valueOf(this.gdf));
    }
    for (;;)
    {
      this.cZc = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.hGV);
      Object localObject2;
      if (this.cZc != null)
      {
        this.cZc.setStatus(1);
        localObject2 = ((e)localObject1).hGO;
        if ((localObject2 == null) || (!((String)localObject2).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label801;
        }
        this.cZc.rf((String)localObject2);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.hGV, this.cZc);
        localObject2 = (dni)this.rr.hvr.hvw;
        ((dni)localObject2).DPT = new crm().aJV(com.tencent.mm.model.u.axw());
        ((dni)localObject2).DPU = new crm().aJV(this.cZc.field_talker);
        ((dni)localObject2).vTI = ((e)localObject1).offset;
        ((dni)localObject2).vTH = ((e)localObject1).hux;
        ((dni)localObject2).tit = this.cZc.getType();
        ((dni)localObject2).ERj = paramInt2;
        if (!ae.cS(ai.getContext())) {
          break label832;
        }
      }
      label801:
      label832:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dni)localObject2).EqS = paramInt1;
        ((dni)localObject2).FKX = ((e)localObject1).dbL;
        ((dni)localObject2).EhD = ((e)localObject1).hGQ;
        ((dni)localObject2).FVa = this.cZc.eSd;
        ((dni)localObject2).FVb = this.cZc.eSc;
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.cZc.field_talker)) {
          ((dni)localObject2).EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(this.cZc.field_talker);
        }
        ac.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dni)localObject2).FVa), Integer.valueOf(((dni)localObject2).FVb) });
        ac.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((e)localObject1).dbL), Integer.valueOf(((dni)localObject2).EhD) });
        if (((e)localObject1).offset == 0) {
          this.hIp = new com.tencent.mm.modelstat.h(getType(), true, ((e)localObject1).hux);
        }
        AppMethodBeat.o(150699);
        return;
        this.cZc.rf("THUMBNAIL://" + ((e)localObject1).dcd);
        break;
      }
    }
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ak.h paramh, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramh, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, 0, -1000.0F, -1000.0F, -1L, 0L, null);
  }
  
  public l(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.ak.h paramh, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, String paramString6)
  {
    AppMethodBeat.i(169188);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hIF = "";
    this.hIG = "";
    this.hIH = true;
    this.hIJ = 16384;
    this.hGP = 0;
    this.cZc = null;
    this.hIp = null;
    this.hIq = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fPn = 0;
    this.hIK = new b(null);
    this.hIS = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ac.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ac.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bs.eWj();
            i = com.tencent.mm.an.c.cD(ai.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.Cr(paramAnonymousd.fqM))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aHZ();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.dcd != l.c(l.this)))
        {
          com.tencent.mm.an.f.aDD().BQ(l.j(l.this));
          ac.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ac.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ac.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agU().az(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).oK(0);
                l.r(l.this).oA(bi.yp(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.an.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dni)l.s(l.this).hvr.hvw;
                if (localObject == null) {
                  ac.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ac.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dni)localObject).FUT = new crm().aJV(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ac.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          if (!bs.cv(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dnj();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bs.eWj();
          i = com.tencent.mm.an.c.cD(ai.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aHZ();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aHZ();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
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
            ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ac.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.Cr(paramAnonymousd.fqM);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ac.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
        if (locale.dbL == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.Cj(paramAnonymousString);
          if ((paramAnonymousc == null) || (bs.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.e(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bs.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ac.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.Vx())
              {
                if (!bs.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ac.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.Ch((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).Ch((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.agQ().ghe.a(new m(l.y(l.this), (dni)l.s(l.this).hvr.hvw, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
                    ac.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oV((int)l.b(l.this));
                      i.oU((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).aFh();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.hux, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dbL;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bv.L(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hGP == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ac.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
              paramAnonymousString = new dnj();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.vTQ != 0L) {}
                for (l1 = paramAnonymousString.vTQ;; l1 = paramAnonymousInt)
                {
                  ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.hux, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.DPY))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).aFh();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.vTO;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).aFh();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dni)l.s(l.this).hvr.hvw;
        qi localqi = new qi();
        localqi.Ehp = ((dni)localObject1).FUT.FEm;
        localqi.tlK = ((dni)localObject1).DPT.FEm;
        localqi.tlJ = ((dni)localObject1).DPU.FEm;
        localqi.Ehq = ((dni)localObject1).FVa;
        localqi.Ehr = ((dni)localObject1).FVb;
        localqi.Scene = l.z(l.this);
        localqi.Eht = l.A(l.this);
        localqi.Ehu = l.B(l.this);
        localqi.Ehv = l.C(l.this);
        localqi.DPY = ((dni)localObject1).DPY;
        localqi.EhA = l.D(l.this);
        localqi.hOf = ((dni)localObject1).hOf;
        localqi.DNn = ((dni)localObject1).DNn;
        localqi.DNp = ((dni)localObject1).DNp;
        localqi.DNo = ((dni)localObject1).DNo;
        localqi.EhE = ((dni)localObject1).EhE;
        localObject1 = l.d(l.this);
        Object localObject2 = o.aFx().p(((e)localObject1).hGM, "", "");
        com.tencent.mm.an.f.aDE();
        localqi.EhC = com.tencent.mm.an.a.BL((String)localObject2);
        localqi.EhD = ((e)localObject1).hGQ;
        int i;
        label342:
        String str;
        if (localqi.EhD <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localqi.EhD = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localqi.sVo = 2;
            if (localqi.EhD == 3) {
              localqi.sVo = 4;
            }
            ac.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localqi.Ehq), Integer.valueOf(localqi.Ehr), localqi.DPY, localqi.tlJ, localqi.EhA, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hGM, localObject2, Integer.valueOf(localqi.EhC), Integer.valueOf(localqi.EhD), Integer.valueOf(localqi.sVo) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hvt = localqi;
            paramAnonymousString.hvu = new dnj();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aAz();
            localObject2 = l.F(l.this).aBZ();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aBT()))
        {
          ac.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aBT())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mp(1), ((com.tencent.mm.network.c)localObject2).aBS(), ((com.tencent.mm.network.c)localObject2).aBU(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ac.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localqi.Ehp });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localqi.sVo = 1;
          break label342;
          localqi.sVo = 3;
          break label342;
          localqi.sVo = 5;
          break label342;
        }
        label744:
        ac.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
        return;
        label776:
        ac.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        qj localqj = new qj();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.agQ().ghe.hwg.aBZ().mp(1), localPInt, localqj);
          ac.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localqj.EhA, localqj.DUJ, localqj.Ehp });
          l.c(l.this, localqj.EhA);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localqj.EhF);
          ac.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localqj.EhF) });
          ac.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.gdn = false;
    ac.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramh, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt4), Boolean.TRUE, bs.eWi(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.hIN = paramBoolean;
    this.hIt = paramInt4;
    this.hIl = paramh;
    this.hGP = paramInt2;
    this.scene = paramInt5;
    this.dmL = paramFloat2;
    this.hIO = paramFloat1;
    this.gdg = paramInt1;
    this.hIR = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.hIL = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong1 > 0L)
    {
      paramString5 = o.aFx().c(Long.valueOf(paramLong1));
      paramString5 = o.aFx().p(paramString5.hGR, "", "");
    }
    if (paramLong2 > 0L) {
      this.hIT = bk.yu(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong2).eul);
    }
    try
    {
      for (;;)
      {
        this.hIm = o.aFx().a(paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
        this.gdf = this.hIm;
        ac.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.hIm);
        if ((this.hIm >= 0L) && (i.oT((int)this.hIm))) {
          break;
        }
        ac.e(this.TAG, "insert to img storage failed id:" + this.hIm);
        this.hGV = -1L;
        this.rr = null;
        AppMethodBeat.o(169188);
        return;
        if (!bs.isNullOrNil(paramString6)) {
          this.hIT = paramString6;
        }
      }
    }
    catch (SQLiteException paramString6)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 182L, 1L, false);
        if (!paramString6.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        o.aFx().aFd();
        ac.e(this.TAG, "fallback to insert");
        this.hIm = o.aFx().a(paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
      }
      AppMethodBeat.o(169188);
      throw paramString6;
    }
    if (this.hIm >= 0L)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      paramString3 = new b.a();
      paramString3.hvt = new dni();
      paramString3.hvu = new dnj();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.reqCmdId = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.aAz();
      this.dvw = paramString2;
      this.cZc = new bo();
      this.cZc.setType(com.tencent.mm.model.w.xu(paramString2));
      this.cZc.re(paramString2);
      this.cZc.jT(1);
      this.cZc.setStatus(1);
      this.cZc.rf(localPString.value);
      this.cZc.ke(localPInt1.value);
      this.cZc.kf(localPInt2.value);
      this.cZc.oA(bi.yp(this.cZc.field_talker));
      this.cZc.setContent(paramString4);
      a.a.Xf().n(this.cZc);
    }
    label1619:
    label1625:
    label1630:
    for (;;)
    {
      try
      {
        this.hGV = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().c(this.cZc, true);
        if (this.hGV >= 0L)
        {
          paramBoolean = true;
          Assert.assertTrue(paramBoolean);
          ac.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hGV);
          paramString3 = aFj();
          paramString3.qe((int)this.hGV);
          o.aFx().a(Long.valueOf(this.hIm), paramString3);
          if (paramInt2 != 1) {
            break label1630;
          }
          this.gdf = paramString3.hGX;
          paramString3 = aFi();
          paramString3.oL((int)com.tencent.mm.vfs.i.aSp(o.aFx().p(paramString3.hGM, "", "")));
          o.aFx().a(Long.valueOf(this.gdf), paramString3);
          ac.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gdf + " img len = " + paramString3.hux);
          paramString5 = (dni)this.rr.hvr.hvw;
          paramString5.DPT = new crm().aJV(paramString1);
          paramString5.DPU = new crm().aJV(paramString2);
          paramString5.vTI = paramString3.offset;
          paramString5.vTH = paramString3.hux;
          paramString5.tit = this.cZc.getType();
          paramString5.ERj = paramInt2;
          if (!ae.cS(ai.getContext())) {
            break label1619;
          }
          paramInt3 = 1;
          paramString5.EqS = paramInt3;
          paramString5.FKX = paramString3.dbL;
          paramString5.EhD = paramString3.hGQ;
          paramString5.FVa = localPInt2.value;
          paramString5.FVb = localPInt1.value;
          paramString1 = f.Cj(paramString4);
          if ((paramString1 != null) && (!bs.isNullOrNil(paramString1.appId)))
          {
            paramString5.hOf = paramString1.appId;
            paramString5.DNn = paramString1.mediaTagName;
            paramString5.DNp = paramString1.messageAction;
            paramString5.DNo = paramString1.messageExt;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(paramString2)) {
            paramString5.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(paramString2);
          }
          ac.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.FVa), Integer.valueOf(paramString5.FVb) });
          if (paramString5.EhD == 0)
          {
            if (paramInt1 != 4) {
              break label1625;
            }
            paramInt1 = 2;
            paramString5.EhD = paramInt1;
          }
          ac.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.dbL), Integer.valueOf(paramString5.EhD) });
          if (paramString3.offset == 0) {
            this.hIp = new com.tencent.mm.modelstat.h(getType(), true, paramString3.hux);
          }
          paramLong1 = System.currentTimeMillis();
          oW(paramInt2);
          ac.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong1) });
          if (paramh != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150681);
                paramh.a(this.hIB, this.hIC, l.this);
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
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 182L, 1L, false);
        if (paramString3.toString().contains("UNIQUE constraint failed"))
        {
          ac.e(this.TAG, "fallback to insert");
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().dcA();
          this.hGV = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().c(this.cZc, true);
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
  
  public l(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, final com.tencent.mm.ak.h paramh, int paramInt2, String paramString4, String paramString5)
  {
    AppMethodBeat.i(150696);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.hIF = "";
    this.hIG = "";
    this.hIH = true;
    this.hIJ = 16384;
    this.hGP = 0;
    this.cZc = null;
    this.hIp = null;
    this.hIq = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fPn = 0;
    this.hIK = new b(null);
    this.hIS = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150686);
        ac.d(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ac.w(l.f(l.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.e(l.f(l.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousInt) });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          if (paramAnonymousd != null)
          {
            l1 = l.l(l.this);
            l2 = bs.eWj();
            i = com.tencent.mm.an.c.cD(ai.getContext());
            j = l.m(l.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = l.Cr(paramAnonymousd.fqM))
          {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aHZ();
            l.g(l.this).onSceneEnd(3, paramAnonymousInt, "", l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
            }
            AppMethodBeat.o(150686);
            return 0;
          }
        }
        final e locale = l.d(l.this);
        if ((locale == null) || (locale.dcd != l.c(l.this)))
        {
          com.tencent.mm.an.f.aDD().BQ(l.j(l.this));
          ac.e(l.f(l.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(l.c(l.this)), l.j(l.this) });
          if (l.k(l.this) != null) {
            l.k(l.this).aFh();
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
          ac.i(l.f(l.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ac.e(l.f(l.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ac.w(l.f(l.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { l.j(l.this), Boolean.valueOf(l.n(l.this)) });
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agU().az(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150683);
                l.o(l.this);
                l.p(l.this);
                l.q(l.this);
                Object localObject = l.d(l.this);
                ((e)localObject).oK(0);
                l.r(l.this).oA(bi.yp(l.r(l.this).field_talker));
                l.a(l.this, com.tencent.mm.an.c.a("upimg", l.r(l.this).field_createTime, l.r(l.this).field_talker, l.r(l.this).field_msgId + "_" + l.c(l.this) + "_" + l.h(l.this)));
                boolean bool = l.a(l.this, (e)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dni)l.s(l.this).hvr.hvw;
                if (localObject == null) {
                  ac.w(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ac.i(l.f(l.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(l.n(l.this)), Boolean.valueOf(bool), l.j(l.this), Long.valueOf(l.r(l.this).field_createTime) });
                  l.this.doScene(l.t(l.this), l.g(l.this));
                  AppMethodBeat.o(150683);
                  return;
                  ((dni)localObject).FUT = new crm().aJV(l.j(l.this));
                }
              }
            });
            AppMethodBeat.o(150686);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ac.w(l.f(l.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(l.u(l.this)) });
            if (l.u(l.this))
            {
              com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          if (!bs.cv(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dnj();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = l.l(l.this);
          l2 = bs.eWj();
          i = com.tencent.mm.an.c.cD(ai.getContext());
          j = l.m(l.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aHZ();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aHZ();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            l.g(l.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), l.this);
            if (l.k(l.this) != null) {
              l.k(l.this).aFh();
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
            ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ac.e(l.f(l.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousc) });
            continue;
            paramAnonymousc = l.Cr(paramAnonymousd.fqM);
            continue;
            label1281:
            l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
          }
        }
        label1308:
        ac.i(l.f(l.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
        if (locale.dbL == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), l.v(l.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = l.w(l.this);
          paramAnonymousc = f.Cj(paramAnonymousString);
          if ((paramAnonymousc == null) || (bs.isNullOrNil(paramAnonymousc.appId))) {
            break label3101;
          }
        }
        label3098:
        label3101:
        for (paramAnonymousc = f.e(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bs.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              ac.i(l.f(l.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.Vx())
              {
                if (!bs.isNullOrNil(l.x(l.this))) {
                  break label2514;
                }
                ac.w(l.f(l.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                locale.Ch((String)localObject);
                l.b(l.this, (String)localObject);
                if (l.b(l.this) != l.c(l.this)) {
                  l.e(l.this).Ch((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2686;
                }
                com.tencent.mm.kernel.g.agQ().ghe.a(new m(l.y(l.this), (dni)l.s(l.this).hvr.hvw, locale, paramAnonymousd, new m.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(169187);
                    new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
                    ac.i(l.f(l.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { l.j(l.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      i.oV((int)l.b(l.this));
                      i.oU((int)l.b(l.this));
                      l.g(l.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", l.this);
                      if (l.k(l.this) != null) {
                        l.k(l.this).aFh();
                      }
                      AppMethodBeat.o(169187);
                      return;
                    }
                    l.a(l.this, locale, locale.hux, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(169187);
                  }
                }), 0);
                break;
                paramAnonymousInt = locale.dbL;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bv.L(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3098;
                }
                if (locale.hGP == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2112:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ac.i(l.f(l.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2112;
                  paramAnonymousString = "<msg><img aeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bs.bG((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bs.bG((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2514:
                paramAnonymousString = "<msg><img aeskey=\"" + l.x(l.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + l.x(l.this) + "\" ";
              }
              label2686:
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(l.this)), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(l.m(l.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", l.Cr(paramAnonymousd.fqM) })).aHZ();
              paramAnonymousString = new dnj();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.vTQ != 0L) {}
                for (l1 = paramAnonymousString.vTQ;; l1 = paramAnonymousInt)
                {
                  ac.d(l.f(l.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (l.a(l.this, locale, locale.hux, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.DPY))
                  {
                    l.g(l.this).onSceneEnd(0, 0, "", l.this);
                    if (l.k(l.this) != null) {
                      l.k(l.this).aFh();
                    }
                  }
                  AppMethodBeat.o(150686);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.vTO;
                }
                if (l.k(l.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ac.e(l.f(l.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ac.e(l.f(l.this), "exception:%s", new Object[] { bs.m(paramAnonymousString) });
                l.g(l.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", l.this);
              }
            }
            l.k(l.this).aFh();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(150687);
        Object localObject1 = (dni)l.s(l.this).hvr.hvw;
        qi localqi = new qi();
        localqi.Ehp = ((dni)localObject1).FUT.FEm;
        localqi.tlK = ((dni)localObject1).DPT.FEm;
        localqi.tlJ = ((dni)localObject1).DPU.FEm;
        localqi.Ehq = ((dni)localObject1).FVa;
        localqi.Ehr = ((dni)localObject1).FVb;
        localqi.Scene = l.z(l.this);
        localqi.Eht = l.A(l.this);
        localqi.Ehu = l.B(l.this);
        localqi.Ehv = l.C(l.this);
        localqi.DPY = ((dni)localObject1).DPY;
        localqi.EhA = l.D(l.this);
        localqi.hOf = ((dni)localObject1).hOf;
        localqi.DNn = ((dni)localObject1).DNn;
        localqi.DNp = ((dni)localObject1).DNp;
        localqi.DNo = ((dni)localObject1).DNo;
        localqi.EhE = ((dni)localObject1).EhE;
        localObject1 = l.d(l.this);
        Object localObject2 = o.aFx().p(((e)localObject1).hGM, "", "");
        com.tencent.mm.an.f.aDE();
        localqi.EhC = com.tencent.mm.an.a.BL((String)localObject2);
        localqi.EhD = ((e)localObject1).hGQ;
        int i;
        label342:
        String str;
        if (localqi.EhD <= 0)
        {
          if (l.y(l.this) == 4)
          {
            i = 2;
            localqi.EhD = i;
          }
        }
        else {
          switch (l.y(l.this))
          {
          case 3: 
          case 5: 
          default: 
            localqi.sVo = 2;
            if (localqi.EhD == 3) {
              localqi.sVo = 4;
            }
            ac.i(l.f(l.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localqi.Ehq), Integer.valueOf(localqi.Ehr), localqi.DPY, localqi.tlJ, localqi.EhA, Long.valueOf(l.c(l.this)), Long.valueOf(l.E(l.this)), ((e)localObject1).hGM, localObject2, Integer.valueOf(localqi.EhC), Integer.valueOf(localqi.EhD), Integer.valueOf(localqi.sVo) });
            paramAnonymousString = new b.a();
            paramAnonymousString.hvt = localqi;
            paramAnonymousString.hvu = new dnj();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.reqCmdId = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aAz();
            localObject2 = l.F(l.this).aBZ();
            str = l.f(l.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aBT()))
        {
          ac.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aBT())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mp(1), ((com.tencent.mm.network.c)localObject2).aBS(), ((com.tencent.mm.network.c)localObject2).aBU(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ac.d(l.f(l.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localqi.Ehp });
          AppMethodBeat.o(150687);
          return;
          i = 1;
          break;
          localqi.sVo = 1;
          break label342;
          localqi.sVo = 3;
          break label342;
          localqi.sVo = 5;
          break label342;
        }
        label744:
        ac.e(l.f(l.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
        return;
        label776:
        ac.e(l.f(l.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localqi.Ehp });
        AppMethodBeat.o(150687);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(150688);
        PInt localPInt = new PInt();
        qj localqj = new qj();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.ak.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.agQ().ghe.hwg.aBZ().mp(1), localPInt, localqj);
          ac.i(l.f(l.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localqj.EhA, localqj.DUJ, localqj.Ehp });
          l.c(l.this, localqj.EhA);
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(localqj.EhF);
          ac.i(l.f(l.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localqj.EhF) });
          ac.i(l.f(l.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(150688);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e(l.f(l.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          l.c(l.this, null);
          AppMethodBeat.o(150688);
        }
        return null;
      }
    };
    this.gdn = false;
    ac.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(3), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), paramh, Integer.valueOf(paramInt2), paramString4, paramString5, Boolean.TRUE, Integer.valueOf(2131231564), Boolean.TRUE, bs.eWi() });
    this.hIN = true;
    this.hIt = 2131231564;
    this.hIl = paramh;
    this.hGP = paramInt1;
    this.gdg = 3;
    this.hIR = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.hIL = paramString4;
    this.hIm = paramLong;
    this.gdf = this.hIm;
    paramString3 = aFj();
    this.cZc = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramString3.hGV);
    this.hGV = this.cZc.field_msgId;
    localPInt.value = this.cZc.eSd;
    paramString5.value = this.cZc.eSc;
    if (paramInt1 == 1)
    {
      this.gdf = paramString3.hGX;
      this.gdh = null;
      paramString3 = aFi();
    }
    for (;;)
    {
      if ((this.cZc.field_talker != null) && (!this.cZc.field_talker.equals(paramString2)))
      {
        ac.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.cZc.field_talker });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.cZc.field_talker;; paramString4 = paramString2)
      {
        ac.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.cZc.field_msgId);
        ac.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.hIm);
        if ((this.hIm < 0L) || (!i.oT((int)this.hIm)))
        {
          ac.e(this.TAG, "insert to img storage failed id:" + this.hIm);
          this.hGV = -1L;
          this.rr = null;
          AppMethodBeat.o(150696);
          return;
        }
        boolean bool;
        if (this.hIm >= 0L)
        {
          bool = true;
          Assert.assertTrue(bool);
          paramString2 = new b.a();
          paramString2.hvt = new dni();
          paramString2.hvu = new dnj();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.reqCmdId = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.aAz();
          ac.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gdf + " img len = " + paramString3.hux);
          paramString2 = (dni)this.rr.hvr.hvw;
          paramString2.DPT = new crm().aJV(paramString1);
          paramString2.DPU = new crm().aJV(paramString4);
          paramString2.vTI = paramString3.offset;
          paramString2.vTH = paramString3.hux;
          paramString2.tit = this.cZc.getType();
          paramString2.ERj = paramInt1;
          if (!ae.cS(ai.getContext())) {
            break label1078;
          }
        }
        label1078:
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          paramString2.EqS = paramInt1;
          paramString2.FKX = paramString3.dbL;
          paramString2.EhD = paramString3.hGQ;
          paramString2.FVa = localPInt.value;
          paramString2.FVb = paramString5.value;
          ac.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.FVa), Integer.valueOf(paramString2.FVb) });
          if (paramString2.EhD == 0) {
            paramString2.EhD = 1;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(paramString4)) {
            paramString2.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(paramString4);
          }
          ac.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.dbL), Integer.valueOf(paramString2.EhD) });
          if (paramString3.offset == 0) {
            this.hIp = new com.tencent.mm.modelstat.h(getType(), true, paramString3.hux);
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(150682);
              paramh.a(this.hIB, this.hIC, l.this);
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
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt1, com.tencent.mm.ak.h paramh, int paramInt2, a parama)
  {
    this(3, paramString1, paramString2, paramString3, paramInt1, paramh, paramInt2, "", "", true, 2131231564);
    AppMethodBeat.i(150694);
    this.hIK = new b(parama);
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
  
  public static String Cr(String paramString)
  {
    AppMethodBeat.i(150708);
    try
    {
      boolean bool = bs.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150708);
        return paramString;
      }
      Object localObject = paramString.split(",");
      if ((localObject != null) && (localObject.length > 19))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = hIU;
        hIU = -1L;
        localObject[19] = l;
        localObject = bs.n(bs.S((String[])localObject), ",");
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
  
  private boolean a(e parame, int paramInt)
  {
    AppMethodBeat.i(150700);
    if (com.tencent.mm.model.w.xs(this.cZc.field_talker))
    {
      ac.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { this.cZc.field_talker });
      AppMethodBeat.o(150700);
      return false;
    }
    com.tencent.mm.an.f.aDD();
    if ((!com.tencent.mm.an.b.oz(1)) && (bs.isNullOrNil(parame.hGY)))
    {
      localObject = this.TAG;
      com.tencent.mm.an.f.aDD();
      ac.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.oz(1)), parame.hGY });
      AppMethodBeat.o(150700);
      return false;
    }
    if (bs.isNullOrNil(this.hIq))
    {
      ac.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gdf) });
      AppMethodBeat.o(150700);
      return false;
    }
    String str2 = o.aFx().p(parame.hGM, "", "");
    String str1 = o.aFx().p(parame.hGN, "", "");
    String str4 = o.aFx().p(parame.hGO, "", "");
    Object localObject = o.aFx().p(parame.hGR, "", "");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.frb = this.hIz;
    localg.field_mediaId = this.hIq;
    localg.field_fileType = this.fPn;
    localg.field_talker = this.cZc.field_talker;
    int i;
    boolean bool1;
    if (com.tencent.mm.model.w.sQ(this.cZc.field_talker))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.fqp;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_sendmsg_viacdn = true;
      localg.field_enable_hitcheck = this.hIH;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      if (paramInt != -5103237) {
        break label925;
      }
      this.hIq = com.tencent.mm.an.c.a("upimgjpg", this.cZc.field_createTime, this.cZc.field_talker, this.cZc.field_msgId + "_" + this.gdf + "_" + this.hGP);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.hIq;
      this.hIS = false;
      if (!this.hIS)
      {
        bool1 = s.aKE(str4);
        ac.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", new Object[] { Boolean.valueOf(bool1) });
      }
      if ((localg.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) && (bs.isNullOrNil(localg.field_midimgpath)))
      {
        com.tencent.mm.an.f.aDD();
        if (com.tencent.mm.an.b.oz(256))
        {
          ac.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = bv.L(this.hIL, "msg");
      if (localObject == null) {
        break label1282;
      }
      if (this.hGP == 1) {
        break label1233;
      }
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"));
      localg.field_midFileLength = bs.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      label623:
      localg.field_aesKey = ((String)((Map)localObject).get(".msg.img.$aeskey"));
    }
    for (;;)
    {
      if ((bs.isNullOrNil(localg.field_aesKey)) || ("null".equalsIgnoreCase(localg.field_aesKey)))
      {
        com.tencent.mm.an.f.aDE();
        localg.field_aesKey = com.tencent.mm.an.a.aDw();
        ac.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      ac.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(parame.dbL), localg.field_fileId });
      this.hIF = localg.field_fileId;
      this.hIG = localg.field_aesKey;
      ac.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.hIQ = null;
      if (com.tencent.mm.an.f.aDD().f(localg)) {
        break label1306;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 205L, 1L, false);
      ac.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.hIq });
      this.hIq = "";
      AppMethodBeat.o(150700);
      return false;
      i = 0;
      break;
      label925:
      boolean bool2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cbi();
      String str3;
      boolean bool3;
      if ((this.gdg == 4) && (com.tencent.mm.vfs.i.eA((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Xx(str1);
        bool3 = bn(str1, str3);
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
        this.hIS = bool1;
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
        ac.d((String)localObject, "hevc upload full size %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        break;
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Xx(str2);
        bool1 = s.aKF(str2).equals(".png");
        if ((this.hGP == 0) && (!bool1) && (bn(str2, str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          parame.Ci(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Xx(parame.hGM));
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
      localg.field_midFileLength = bs.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      break label623;
      label1282:
      ac.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { parame.hGY });
    }
    label1306:
    if (bs.nullAsNil(parame.hGY).length() <= 0)
    {
      parame.Ch("CDNINFO_SEND");
      parame.drx = 4096;
    }
    AppMethodBeat.o(150700);
    return true;
  }
  
  private boolean a(e parame, int paramInt1, long paramLong, int paramInt2, d paramd, String paramString)
  {
    AppMethodBeat.i(169189);
    ac.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.hIq, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    ac.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(ab.ivH), Long.valueOf(this.hIm), Long.valueOf(this.gdf) });
    long l = paramLong;
    if (10007 == ab.ivG)
    {
      l = paramLong;
      if (ab.ivH != 0)
      {
        l = ab.ivH;
        ab.ivH = 0;
      }
    }
    b(parame.dcd, paramInt1, parame.hux);
    parame.setOffset(paramInt1);
    parame.oz(l);
    if ((f.b(parame)) && (this.hIm != this.gdf))
    {
      e locale = o.aFx().c(Long.valueOf(this.hIm));
      locale.oz(l);
      locale.oL(parame.hux);
      locale.setOffset(parame.hux);
      o.aFx().a(Long.valueOf(this.hIm), locale);
    }
    if (f.b(parame))
    {
      if (bs.isNullOrNil(this.hIq)) {
        com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.fPn), Integer.valueOf(parame.hux - this.startOffset) });
      }
      this.cZc.setStatus(2);
      this.cZc.oz(l);
      this.cZc.qf(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.hGV, this.cZc);
      if (com.tencent.mm.modelstat.r.hXU != null) {
        com.tencent.mm.modelstat.r.hXU.q(this.cZc);
      }
      if (this.hIp != null) {
        this.hIp.qp(0L);
      }
      if (r.hJW != null) {
        r.hJW.a(this.gdf, this.cZc, this.rr, this.gdg, this.gdn, paramd);
      }
      if (this.hIK != null) {
        this.hIK.aFh();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      i.oU((int)this.hIm);
      AppMethodBeat.o(169189);
      return false;
    }
    AppMethodBeat.o(169189);
    return true;
  }
  
  private e aFi()
  {
    AppMethodBeat.i(150692);
    if (this.gdh == null) {
      this.gdh = o.aFx().c(Long.valueOf(this.gdf));
    }
    e locale = this.gdh;
    AppMethodBeat.o(150692);
    return locale;
  }
  
  private e aFj()
  {
    AppMethodBeat.i(150693);
    if (this.hII == null) {
      this.hII = o.aFx().c(Long.valueOf(this.hIm));
    }
    e locale = this.hII;
    AppMethodBeat.o(150693);
    return locale;
  }
  
  private void b(final long paramLong, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150707);
    if (this.hIl != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150690);
          n localn = n.aFl();
          long l1 = paramLong;
          long l2 = paramInt1;
          long l3 = this.hIY;
          if (localn.hJc.containsKey(Long.valueOf(l1))) {}
          for (n.d locald = (n.d)localn.hJc.get(Long.valueOf(l1));; locald = new n.d())
          {
            locald.offset = l3;
            locald.dne = l2;
            localn.hJc.put(Long.valueOf(l1), locald);
            l.G(l.this).a(this.hIY, paramInt1, l.this);
            AppMethodBeat.o(150690);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(150707);
  }
  
  private boolean bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150701);
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cbi())
    {
      AppMethodBeat.o(150701);
      return false;
    }
    if (com.tencent.mm.vfs.i.aSp(paramString1) > 0L)
    {
      if (com.tencent.mm.vfs.i.aSp(paramString2) > 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.dB(944, 9);
        com.tencent.mm.vfs.i.deleteFile(paramString2);
      }
      if (!com.tencent.mm.vfs.i.eA(paramString2)) {
        com.tencent.mm.vfs.i.aSt(paramString2);
      }
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fi(paramString1, paramString2) == 0)
      {
        AppMethodBeat.o(150701);
        return true;
      }
      ac.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
    }
    AppMethodBeat.o(150701);
    return false;
  }
  
  private int oX(int paramInt)
  {
    AppMethodBeat.i(150703);
    ac.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.hIK != null) {
      this.hIK.aFh();
    }
    AppMethodBeat.o(150703);
    return -1;
  }
  
  public static void qh(long paramLong)
  {
    hIU = paramLong;
  }
  
  public final void aFk()
  {
    AppMethodBeat.i(150705);
    ac.i(this.TAG, "send img from system");
    this.gdn = true;
    AppMethodBeat.o(150705);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150702);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150689);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alg("SendImgSpeeder");
        AppMethodBeat.o(150689);
      }
    }, 100L);
    if (this.gdf < 0L)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 204L, 1L, false);
      ac.e(this.TAG, "doScene invalid imgLocalId:" + this.gdf);
      i = oX(-1);
      AppMethodBeat.o(150702);
      return i;
    }
    if (this.cZc == null)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 203L, 1L, false);
      ac.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.gdf) });
      i.oV((int)this.hIm);
      i = oX(-2);
      AppMethodBeat.o(150702);
      return i;
    }
    this.callback = paramg;
    prepareDispatcher(parame);
    dni localdni = (dni)this.rr.hvr.hvw;
    e locale = aFi();
    paramg = o.aFx().oS((int)locale.dcd);
    if (paramg != null)
    {
      if (paramg.status == -1)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 202L, 1L, false);
        ac.e(this.TAG, "doScene hd img info is null or error.");
        i = oX(-3);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else if ((locale == null) || (locale.status == -1))
    {
      ac.e(this.TAG, "doScene img info is null or error.");
      i = oX(-4);
      AppMethodBeat.o(150702);
      return i;
    }
    Object localObject;
    if (a.a.Xf().so(this.cZc.field_talker))
    {
      localdni.DPY = a.a.Xf().o(this.cZc);
      ac.i(this.TAG, "upload img msg source %s", new Object[] { localdni.DPY });
      paramg = o.aFx().p(locale.hGM, "", "");
      localObject = o.aFx().p(locale.hGO, "", "");
      if (!bs.isNullOrNil(locale.hGN)) {
        o.aFx().p(locale.hGN, "", "");
      }
      if ((com.tencent.mm.vfs.i.aSp(paramg) <= 0L) || (com.tencent.mm.vfs.i.aSp((String)localObject) <= 0L))
      {
        ac.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.gdf), Long.valueOf(com.tencent.mm.vfs.i.aSp(paramg)), Long.valueOf(com.tencent.mm.vfs.i.aSp((String)localObject)), paramg, localObject });
        i = oX(-5);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else
    {
      if (bs.isNullOrNil(this.hIT))
      {
        paramg = com.tencent.mm.vfs.i.aKe(this.hIR);
        localObject = v.iuG;
        this.hIT = v.FG(paramg);
      }
      if (!bs.isNullOrNil(this.hIT)) {}
      for (paramg = bk.yv(this.hIT);; paramg = bk.TG())
      {
        if (((paramg != null) && (!paramg.equals(this.cZc.eul))) || ((paramg == null) && (!bs.isNullOrNil(this.cZc.eul))))
        {
          this.cZc.qf(paramg);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.cZc.field_msgId, this.cZc);
        }
        localdni.DPY = this.cZc.eul;
        break;
      }
    }
    if ((localdni.FUT == null) || (bs.isNullOrNil(localdni.FUT.FEm)))
    {
      if (bs.isNullOrNil(this.hIq))
      {
        ac.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.cZc.field_createTime), this.cZc.field_talker, Long.valueOf(this.cZc.field_msgId), Long.valueOf(this.gdf), Integer.valueOf(this.hGP) });
        this.hIq = com.tencent.mm.an.c.a("upimg", this.cZc.field_createTime, this.cZc.field_talker, this.cZc.field_msgId + "_" + this.gdf + "_" + this.hGP);
      }
      localdni.FUT = new crm().aJV(this.hIq);
      bo localbo = this.cZc;
      localbo.eSi = this.hIq;
      localbo.etL = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bs.eWj();
      this.startOffset = locale.offset;
      if (this.hGP != 1) {
        break label974;
      }
    }
    label974:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.fPn = i;
      ac.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", new Object[] { paramg, localObject, locale.hGM });
      if (!a(locale, 0)) {
        break;
      }
      ac.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localdni.FUT.FEm });
      AppMethodBeat.o(150702);
      return 0;
    }
    ac.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
    if ((com.tencent.mm.m.g.ZY().getInt("UploadMsgImgType", 0) == 1) && (this.hGP == 0))
    {
      locale.Ci(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Xx(locale.hGM));
      localObject = o.aFx().p(locale.hGR, "", "");
      i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fi(paramg, (String)localObject);
      if (i != 0) {
        break label1207;
      }
      locale.oO(1);
      locale.oL((int)com.tencent.mm.vfs.i.aSp((String)localObject));
    }
    for (;;)
    {
      ac.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.gdf), localObject, Integer.valueOf(i), Integer.valueOf(locale.hux) });
      i = locale.hGW;
      if (i < securityLimitCount()) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 201L, 1L, false);
      ac.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
      i.oV((int)this.hIm);
      i = oX(-6);
      AppMethodBeat.o(150702);
      return i;
      label1207:
      locale.oO(0);
    }
    locale.oK(i + 1);
    locale.drx = 512;
    o.aFx().a(Long.valueOf(this.gdf), locale);
    int j = locale.hux - locale.offset;
    i = j;
    if (j > this.hIJ) {
      i = this.hIJ;
    }
    com.tencent.mm.vfs.i.aSp(paramg);
    if (locale.hGS == 1) {}
    for (paramg = o.aFx().p(locale.hGR, "", "");; paramg = o.aFx().p(locale.hGM, "", ""))
    {
      paramg = com.tencent.mm.vfs.i.aU(paramg, locale.offset, i);
      if ((paramg != null) && (paramg.length > 0)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 199L, 1L, false);
      ac.e(this.TAG, "doScene, file read buf error.");
      i = oX(-8);
      AppMethodBeat.o(150702);
      return i;
    }
    localdni.vTJ = paramg.length;
    localdni.vTH = locale.hux;
    localdni.vTI = locale.offset;
    localdni.vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
    localdni.Flw = locale.hGS;
    if (this.hIp != null) {
      this.hIp.aIy();
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      ac.e(this.TAG, "doScene netId error");
      i.oV((int)this.hIm);
      i = oX(-9);
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
  
  public final void oW(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(150697);
    if (this.cZc == null)
    {
      ac.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.hGV), Integer.valueOf(paramInt) });
      AppMethodBeat.o(150697);
      return;
    }
    if (this.hIN)
    {
      if (this.cZc.eSg == 0)
      {
        boolean bool = o.aFx().a(this.cZc, this.hIt, paramInt);
        bo localbo = this.cZc;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localbo.kh(paramInt);
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.hGV, this.cZc);
          AppMethodBeat.o(150697);
          return;
        }
      }
    }
    else {
      o.aFx().a(this.cZc.field_imgPath, com.tencent.mm.cc.a.getDensity(ai.getContext()), true);
    }
    AppMethodBeat.o(150697);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150704);
    ac.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.hIq);
    paramq = (dnj)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.EhF);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      ac.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 198L, 1L, false);
      i.oV((int)this.hIm);
      i.oU((int)this.hIm);
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.fPn), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.hIK != null) {
        this.hIK.aFh();
      }
      AppMethodBeat.o(150704);
      return;
    }
    this.hIJ = paramq.vTJ;
    if (this.hIJ > 16384) {
      this.hIJ = 16384;
    }
    paramString = aFi();
    ac.v(this.TAG, "onGYNetEnd localId:" + this.gdf + "  totalLen:" + paramString.hux + " offSet:" + paramString.offset);
    if ((paramq.vTI < 0) || ((paramq.vTI > paramString.hux) && (paramString.hux > 0)))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 197L, 1L, false);
      ac.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + paramq.vTI + " img totalLen = " + paramString.hux);
      i.oV((int)this.hIm);
      i.oU((int)this.hIm);
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.fPn), Integer.valueOf(0) });
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.hIK != null) {
        this.hIK.aFh();
      }
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramq.vTI < paramString.offset) || ((f.b(paramString)) && (this.hIJ <= 0)))
    {
      ac.e(this.TAG, "onGYNetEnd invalid data startPos = " + paramq.vTI + " totalLen = " + paramString.hux + " off:" + paramString.offset);
      i.oV((int)this.hIm);
      i.oU((int)this.hIm);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.hIK != null) {
        this.hIK.aFh();
      }
      AppMethodBeat.o(150704);
      return;
    }
    ac.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + paramq.vTI);
    if ((a(paramString, paramq.vTI, paramq.vTQ, paramq.CreateTime, null, paramq.DPY)) && (doScene(dispatcher(), this.callback) < 0))
    {
      i.oU((int)this.hIm);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.hIK != null) {
        this.hIK.aFh();
      }
    }
    AppMethodBeat.o(150704);
  }
  
  public final int securityLimitCount()
  {
    if (this.hGP == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public static abstract interface a
  {
    public abstract void aFh();
  }
  
  public final class b
  {
    public l.a hIZ;
    
    public b(l.a parama)
    {
      this.hIZ = parama;
    }
    
    final void aFh()
    {
      AppMethodBeat.i(150691);
      if (l.b(l.this) == l.c(l.this)) {}
      for (Object localObject = l.d(l.this);; localObject = l.e(l.this))
      {
        if (((e)localObject).hGZ == 1)
        {
          com.tencent.mm.plugin.report.service.g.MI(23);
          com.tencent.mm.plugin.report.service.g.MI(21);
        }
        ac.i(l.f(l.this), "UploadEndWrapper onUploadEnd %s done", new Object[] { l.h(l.d(l.this)) });
        if (o.aFx().a(Long.valueOf(l.c(l.this)), l.d(l.this)) < 0)
        {
          ac.e(l.f(l.this), "update db failed local id:" + l.c(l.this) + " server id:" + l.d(l.this).dpl);
          i.oV((int)l.b(l.this));
          i.oU((int)l.b(l.this));
          l.g(l.this).onSceneEnd(3, -1, "", l.this);
        }
        if (l.c(l.this) != l.b(l.this))
        {
          ac.i(l.f(l.this), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { l.h(l.e(l.this)) });
          o.aFx().a(Long.valueOf(l.b(l.this)), l.e(l.this));
        }
        if ((!com.tencent.mm.sdk.a.b.eUk()) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
          break;
        }
        localObject = o.aFx().aFf();
        if (localObject == null) {
          break;
        }
        int i = 0;
        while (i < ((List)localObject).size())
        {
          ac.i(l.f(l.this), "UploadEndWrapper onUploadEnd duminfo %s %s", new Object[] { Integer.valueOf(i), l.h((e)((List)localObject).get(i)) });
          i += 1;
        }
      }
      l.a(l.this, l.c(l.this));
      if (l.b(l.this) != l.c(l.this)) {
        l.a(l.this, l.b(l.this));
      }
      if (this.hIZ != null) {
        this.hIZ.aFh();
      }
      l.this.oW(l.h(l.this));
      l.i(l.this);
      AppMethodBeat.o(150691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.l
 * JD-Core Version:    0.7.0.1
 */