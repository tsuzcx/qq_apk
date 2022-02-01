package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.ak.w;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelstat.r;
import com.tencent.mm.modelstat.r.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.f.d.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.database.SQLiteException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class n
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static boolean DEBUG = true;
  private static long ieC;
  private String TAG;
  public String cUB;
  private com.tencent.mm.ak.f callback;
  private bv dlw;
  private float dzE;
  private int glf;
  private boolean gzE;
  private long gzw;
  private int gzx;
  private g gzy;
  private int icr;
  private long icx;
  private final com.tencent.mm.ak.g idS;
  public long idT;
  private com.tencent.mm.modelstat.h idW;
  private String idX;
  private String ieA;
  private d.a ieB;
  private int iea;
  private com.tencent.mm.i.g.a ieg;
  private String iem;
  private String ien;
  private boolean ieo;
  private g iep;
  private int ieq;
  public a ier;
  private String ies;
  public String iet;
  public boolean ieu;
  private float iev;
  private String iew;
  private String iex;
  public String iey;
  private boolean iez;
  private final com.tencent.mm.ak.b rr;
  private int scene;
  private int startOffset;
  private long startTime;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150698);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iem = "";
    this.ien = "";
    this.ieo = true;
    this.ieq = 16384;
    this.icr = 0;
    this.dlw = null;
    this.idW = null;
    this.idX = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.glf = 0;
    this.ier = new a(null);
    this.iez = false;
    this.ieB = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(218722);
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.pB((int)n.b(n.this));
        k.pA((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEZ();
        }
        AppMethodBeat.o(218722);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(218723);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218723);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(218723);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(218721);
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gmb, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iTe) });
        long l1 = paramAnonymousa.iTe;
        long l2 = bu.fpO();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gmb;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nZM;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIX().o(localg.ico, "", "");
        Object localObject2 = q.aIX().o(localg.icp, "", "");
        locald.field_thumbimgLength = ((int)o.aZR(q.aIX().o(localg.icq, "", "")));
        locald.field_midimgLength = ((int)o.aZR((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iTe;
        com.tencent.mm.an.f.aHa();
        locald.field_filecrc = com.tencent.mm.an.a.Fm((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.FK((String)localObject2);
        if ((localObject1 != null) && (!bu.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bu.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.FI((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).FI((String)localObject1);
            }
            localObject1 = c.aIt();
            ((c)localObject1).gzx = n.q(n.this);
            ((c)localObject1).ibY = ((dtw)n.p(n.this).hQD.hQJ);
            ((c)localObject1).ibZ = localg;
            ((c)localObject1).gmb = paramAnonymousa.Fdq;
            ((c)localObject1).gzD = locald;
            ((c)localObject1).ica = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(218720);
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.pB((int)n.b(n.this));
                  k.pA((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEZ();
                  }
                  AppMethodBeat.o(218720);
                  return;
                }
                n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(218720);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJO().execute();
            AppMethodBeat.o(218721);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bx.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.icr == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bu.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ieg = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(218727);
        com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(218727);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bu.fpO();
            i = com.tencent.mm.an.c.cC(ak.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.FX(paramAnonymousd.fKX))
          {
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLH();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.an.f.aGZ().Fr(n.n(n.this));
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajU().aw(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(218724);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pp(0);
                n.m(n.this).qN(bl.BQ(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dtw)n.p(n.this).hQD.hQJ;
                if (localObject == null) {
                  com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(218724);
                  return;
                  ((dtw)localObject).HZu = new cxn().aQV(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(218727);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(218725);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(218725);
                }
              });
              AppMethodBeat.o(218727);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bu.cF(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dtx();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bu.fpO();
          i = com.tencent.mm.an.c.cC(ak.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.j(paramAnonymousc).aLH();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLH();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
            continue;
            paramAnonymousc = n.FX(paramAnonymousd.fKX);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
        if (localg.doj == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.FK(paramAnonymousString);
          if ((paramAnonymousc == null) || (bu.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bu.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XY())
              {
                if (!bu.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.FI((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).FI((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIt();
                paramAnonymousString.gzx = n.q(n.this);
                paramAnonymousString.ibY = ((dtw)n.p(n.this).hQD.hQJ);
                paramAnonymousString.ibZ = localg;
                paramAnonymousString.gmb = n.z(n.this);
                paramAnonymousString.gzD = paramAnonymousd;
                paramAnonymousString.ica = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(218726);
                    new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
                    com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.pB((int)n.b(n.this));
                      k.pA((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEZ();
                      }
                      AppMethodBeat.o(218726);
                      return;
                    }
                    n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(218726);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJO().execute();
                break;
                paramAnonymousInt = localg.doj;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bx.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.icr == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
              paramAnonymousString = new dtx();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xrk != 0L) {}
                for (l1 = paramAnonymousString.xrk;; l1 = paramAnonymousInt)
                {
                  com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hPI, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.FNL))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEZ();
                    }
                  }
                  AppMethodBeat.o(218727);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xri;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEZ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(218728);
        Object localObject1 = (dtw)n.p(n.this).hQD.hQJ;
        sb localsb = new sb();
        localsb.GgV = ((dtw)localObject1).HZu.HId;
        localsb.uvG = ((dtw)localObject1).FNG.HId;
        localsb.uvF = ((dtw)localObject1).FNH.HId;
        localsb.GgW = ((dtw)localObject1).HZB;
        localsb.GgX = ((dtw)localObject1).HZC;
        localsb.Scene = n.A(n.this);
        localsb.GgZ = n.B(n.this);
        localsb.Gha = n.C(n.this);
        localsb.Ghb = n.D(n.this);
        localsb.FNL = ((dtw)localObject1).FNL;
        localsb.Ghg = n.z(n.this);
        localsb.ikm = ((dtw)localObject1).ikm;
        localsb.FKQ = ((dtw)localObject1).FKQ;
        localsb.FKS = ((dtw)localObject1).FKS;
        localsb.FKR = ((dtw)localObject1).FKR;
        localsb.Ghk = ((dtw)localObject1).Ghk;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIX().o(((g)localObject1).ico, "", "");
        com.tencent.mm.an.f.aHa();
        localsb.Ghi = com.tencent.mm.an.a.Fm((String)localObject2);
        localsb.Ghj = ((g)localObject1).ics;
        int i;
        label342:
        String str;
        if (localsb.Ghj <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localsb.Ghj = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localsb.ucK = 2;
            if (localsb.Ghj == 3) {
              localsb.ucK = 4;
            }
            com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localsb.GgW), Integer.valueOf(localsb.GgX), localsb.FNL, localsb.uvF, localsb.Ghg, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).ico, localObject2, Integer.valueOf(localsb.Ghi), Integer.valueOf(localsb.Ghj), Integer.valueOf(localsb.ucK) });
            paramAnonymousString = new com.tencent.mm.ak.b.a();
            paramAnonymousString.hQF = localsb;
            paramAnonymousString.hQG = new dtx();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hQH = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDS();
            localObject2 = n.F(n.this).aFs();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aFm()))
        {
          com.tencent.mm.sdk.platformtools.ae.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aFm())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mR(1), ((com.tencent.mm.network.c)localObject2).aFl(), ((com.tencent.mm.network.c)localObject2).aFn(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localsb.GgV });
          AppMethodBeat.o(218728);
          return;
          i = 1;
          break;
          localsb.ucK = 1;
          break label342;
          localsb.ucK = 3;
          break label342;
          localsb.ucK = 5;
          break label342;
        }
        label744:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
        return;
        label776:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218729);
        PInt localPInt = new PInt();
        sc localsc = new sc();
        try
        {
          paramAnonymousArrayOfByte = w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajQ().gDv.hRo.aFs().mR(1), localPInt, localsc);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsc.Ghg, localsc.FSC, localsc.GgV });
          n.c(n.this, localsc.Ghg);
          ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(localsc.Ghl);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsc.Ghl) });
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(218729);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(218729);
        }
        return null;
      }
    };
    this.gzE = false;
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bu.fpN() });
    this.idT = paramInt1;
    this.gzw = paramInt1;
    this.icr = paramInt2;
    Object localObject1 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject1).hQF = new dtw();
    ((com.tencent.mm.ak.b.a)localObject1).hQG = new dtx();
    ((com.tencent.mm.ak.b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((com.tencent.mm.ak.b.a)localObject1).funcId = 110;
    ((com.tencent.mm.ak.b.a)localObject1).hQH = 9;
    ((com.tencent.mm.ak.b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((com.tencent.mm.ak.b.a)localObject1).aDS();
    this.idS = null;
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FROM B SERVICE:" + this.idT);
    if (!k.pz((int)this.idT))
    {
      this.idT = -1L;
      AppMethodBeat.o(150698);
      return;
    }
    localObject1 = q.aIX().c(Long.valueOf(this.idT));
    this.icx = ((g)localObject1).icx;
    if (paramInt2 == 1)
    {
      this.gzw = ((g)localObject1).icz;
      localObject1 = q.aIX().c(Long.valueOf(this.gzw));
    }
    for (;;)
    {
      Object localObject2 = q.aIX().py((int)((g)localObject1).doE);
      if (localObject2 != null) {
        this.icx = ((g)localObject2).icx;
      }
      this.dlw = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.icx);
      if ((this.dlw != null) && (this.dlw.field_msgId != this.icx))
      {
        com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.icx) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 206L, 1L, false);
        this.dlw = null;
        AppMethodBeat.o(150698);
        return;
      }
      if (this.dlw != null)
      {
        localObject2 = (dtw)this.rr.hQD.hQJ;
        ((dtw)localObject2).FNG = new cxn().aQV(com.tencent.mm.model.v.aAC());
        ((dtw)localObject2).FNH = new cxn().aQV(this.dlw.field_talker);
        ((dtw)localObject2).xsC = ((g)localObject1).offset;
        ((dtw)localObject2).xsB = ((g)localObject1).hPI;
        ((dtw)localObject2).urJ = this.dlw.getType();
        ((dtw)localObject2).GUb = paramInt2;
        if (!com.tencent.mm.network.ae.cR(ak.getContext())) {
          break label880;
        }
      }
      label880:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dtw)localObject2).GqB = paramInt1;
        ((dtw)localObject2).HPi = ((g)localObject1).doj;
        ((dtw)localObject2).Ghj = ((g)localObject1).ics;
        ((dtw)localObject2).Ghj = ((g)localObject1).ics;
        ((dtw)localObject2).HZB = this.dlw.fmp;
        ((dtw)localObject2).HZC = this.dlw.fmo;
        a locala = h.FK(this.dlw.field_content);
        if ((locala != null) && (!bu.isNullOrNil(locala.appId)))
        {
          this.gzx = ((g)localObject1).doj;
          ((dtw)localObject2).ikm = locala.appId;
          ((dtw)localObject2).FKQ = locala.mediaTagName;
          ((dtw)localObject2).FKS = locala.messageAction;
          ((dtw)localObject2).FKR = locala.messageExt;
          this.ies = this.dlw.field_content;
        }
        if (((s)com.tencent.mm.kernel.g.ad(s.class)).ifAddTicketByActionFlag(this.dlw.field_talker)) {
          ((dtw)localObject2).Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(this.dlw.field_talker);
        }
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dtw)localObject2).HZB), Integer.valueOf(((dtw)localObject2).HZC) });
        com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((g)localObject1).doj), Integer.valueOf(((dtw)localObject2).Ghj) });
        if (((g)localObject1).offset == 0) {
          this.idW = new com.tencent.mm.modelstat.h(getType(), true, ((g)localObject1).hPI);
        }
        AppMethodBeat.o(150698);
        return;
      }
    }
  }
  
  public n(int paramInt1, int paramInt2, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(218735);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iem = "";
    this.ien = "";
    this.ieo = true;
    this.ieq = 16384;
    this.icr = 0;
    this.dlw = null;
    this.idW = null;
    this.idX = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.glf = 0;
    this.ier = new a(null);
    this.iez = false;
    this.ieB = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(218722);
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.pB((int)n.b(n.this));
        k.pA((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEZ();
        }
        AppMethodBeat.o(218722);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(218723);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218723);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(218723);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(218721);
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gmb, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iTe) });
        long l1 = paramAnonymousa.iTe;
        long l2 = bu.fpO();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gmb;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nZM;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIX().o(localg.ico, "", "");
        Object localObject2 = q.aIX().o(localg.icp, "", "");
        locald.field_thumbimgLength = ((int)o.aZR(q.aIX().o(localg.icq, "", "")));
        locald.field_midimgLength = ((int)o.aZR((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iTe;
        com.tencent.mm.an.f.aHa();
        locald.field_filecrc = com.tencent.mm.an.a.Fm((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.FK((String)localObject2);
        if ((localObject1 != null) && (!bu.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bu.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.FI((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).FI((String)localObject1);
            }
            localObject1 = c.aIt();
            ((c)localObject1).gzx = n.q(n.this);
            ((c)localObject1).ibY = ((dtw)n.p(n.this).hQD.hQJ);
            ((c)localObject1).ibZ = localg;
            ((c)localObject1).gmb = paramAnonymousa.Fdq;
            ((c)localObject1).gzD = locald;
            ((c)localObject1).ica = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(218720);
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.pB((int)n.b(n.this));
                  k.pA((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEZ();
                  }
                  AppMethodBeat.o(218720);
                  return;
                }
                n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(218720);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJO().execute();
            AppMethodBeat.o(218721);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bx.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.icr == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bu.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ieg = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(218727);
        com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(218727);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bu.fpO();
            i = com.tencent.mm.an.c.cC(ak.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.FX(paramAnonymousd.fKX))
          {
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLH();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.an.f.aGZ().Fr(n.n(n.this));
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajU().aw(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(218724);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pp(0);
                n.m(n.this).qN(bl.BQ(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dtw)n.p(n.this).hQD.hQJ;
                if (localObject == null) {
                  com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(218724);
                  return;
                  ((dtw)localObject).HZu = new cxn().aQV(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(218727);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(218725);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(218725);
                }
              });
              AppMethodBeat.o(218727);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bu.cF(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dtx();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bu.fpO();
          i = com.tencent.mm.an.c.cC(ak.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.j(paramAnonymousc).aLH();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLH();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
            continue;
            paramAnonymousc = n.FX(paramAnonymousd.fKX);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
        if (localg.doj == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.FK(paramAnonymousString);
          if ((paramAnonymousc == null) || (bu.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bu.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XY())
              {
                if (!bu.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.FI((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).FI((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIt();
                paramAnonymousString.gzx = n.q(n.this);
                paramAnonymousString.ibY = ((dtw)n.p(n.this).hQD.hQJ);
                paramAnonymousString.ibZ = localg;
                paramAnonymousString.gmb = n.z(n.this);
                paramAnonymousString.gzD = paramAnonymousd;
                paramAnonymousString.ica = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(218726);
                    new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
                    com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.pB((int)n.b(n.this));
                      k.pA((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEZ();
                      }
                      AppMethodBeat.o(218726);
                      return;
                    }
                    n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(218726);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJO().execute();
                break;
                paramAnonymousInt = localg.doj;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bx.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.icr == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
              paramAnonymousString = new dtx();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xrk != 0L) {}
                for (l1 = paramAnonymousString.xrk;; l1 = paramAnonymousInt)
                {
                  com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hPI, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.FNL))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEZ();
                    }
                  }
                  AppMethodBeat.o(218727);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xri;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEZ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(218728);
        Object localObject1 = (dtw)n.p(n.this).hQD.hQJ;
        sb localsb = new sb();
        localsb.GgV = ((dtw)localObject1).HZu.HId;
        localsb.uvG = ((dtw)localObject1).FNG.HId;
        localsb.uvF = ((dtw)localObject1).FNH.HId;
        localsb.GgW = ((dtw)localObject1).HZB;
        localsb.GgX = ((dtw)localObject1).HZC;
        localsb.Scene = n.A(n.this);
        localsb.GgZ = n.B(n.this);
        localsb.Gha = n.C(n.this);
        localsb.Ghb = n.D(n.this);
        localsb.FNL = ((dtw)localObject1).FNL;
        localsb.Ghg = n.z(n.this);
        localsb.ikm = ((dtw)localObject1).ikm;
        localsb.FKQ = ((dtw)localObject1).FKQ;
        localsb.FKS = ((dtw)localObject1).FKS;
        localsb.FKR = ((dtw)localObject1).FKR;
        localsb.Ghk = ((dtw)localObject1).Ghk;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIX().o(((g)localObject1).ico, "", "");
        com.tencent.mm.an.f.aHa();
        localsb.Ghi = com.tencent.mm.an.a.Fm((String)localObject2);
        localsb.Ghj = ((g)localObject1).ics;
        int i;
        label342:
        String str;
        if (localsb.Ghj <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localsb.Ghj = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localsb.ucK = 2;
            if (localsb.Ghj == 3) {
              localsb.ucK = 4;
            }
            com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localsb.GgW), Integer.valueOf(localsb.GgX), localsb.FNL, localsb.uvF, localsb.Ghg, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).ico, localObject2, Integer.valueOf(localsb.Ghi), Integer.valueOf(localsb.Ghj), Integer.valueOf(localsb.ucK) });
            paramAnonymousString = new com.tencent.mm.ak.b.a();
            paramAnonymousString.hQF = localsb;
            paramAnonymousString.hQG = new dtx();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hQH = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDS();
            localObject2 = n.F(n.this).aFs();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aFm()))
        {
          com.tencent.mm.sdk.platformtools.ae.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aFm())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mR(1), ((com.tencent.mm.network.c)localObject2).aFl(), ((com.tencent.mm.network.c)localObject2).aFn(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localsb.GgV });
          AppMethodBeat.o(218728);
          return;
          i = 1;
          break;
          localsb.ucK = 1;
          break label342;
          localsb.ucK = 3;
          break label342;
          localsb.ucK = 5;
          break label342;
        }
        label744:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
        return;
        label776:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218729);
        PInt localPInt = new PInt();
        sc localsc = new sc();
        try
        {
          paramAnonymousArrayOfByte = w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajQ().gDv.hRo.aFs().mR(1), localPInt, localsc);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsc.Ghg, localsc.FSC, localsc.GgV });
          n.c(n.this, localsc.Ghg);
          ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(localsc.Ghl);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsc.Ghl) });
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(218729);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(218729);
        }
        return null;
      }
    };
    this.gzE = false;
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramg, bu.fpN() });
    this.idT = paramInt1;
    this.gzw = paramInt1;
    this.icr = paramInt2;
    paramg = new com.tencent.mm.ak.b.a();
    paramg.hQF = new dtw();
    paramg.hQG = new dtx();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    paramg.funcId = 110;
    paramg.hQH = 9;
    paramg.respCmdId = 1000000009;
    this.rr = paramg.aDS();
    this.idS = null;
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FROM C SERVICE:" + this.idT);
    if (!k.pz((int)this.idT))
    {
      this.idT = -1L;
      AppMethodBeat.o(218735);
      return;
    }
    paramg = q.aIX().c(Long.valueOf(this.idT));
    this.icx = paramg.icx;
    paramg.setStatus(0);
    paramg.qM(0L);
    paramg.setOffset(0);
    q.aIX().a((int)this.gzw, paramg);
    if (paramInt2 == 1)
    {
      this.gzw = paramg.icz;
      paramg = q.aIX().c(Long.valueOf(this.gzw));
    }
    for (;;)
    {
      this.dlw = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.icx);
      Object localObject;
      if (this.dlw != null)
      {
        this.dlw.setStatus(1);
        localObject = paramg.icq;
        if ((localObject == null) || (!((String)localObject).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label789;
        }
        this.dlw.uj((String)localObject);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.icx, this.dlw);
        localObject = (dtw)this.rr.hQD.hQJ;
        ((dtw)localObject).FNG = new cxn().aQV(com.tencent.mm.model.v.aAC());
        ((dtw)localObject).FNH = new cxn().aQV(this.dlw.field_talker);
        ((dtw)localObject).xsC = paramg.offset;
        ((dtw)localObject).xsB = paramg.hPI;
        ((dtw)localObject).urJ = this.dlw.getType();
        ((dtw)localObject).GUb = paramInt2;
        if (!com.tencent.mm.network.ae.cR(ak.getContext())) {
          break label819;
        }
      }
      label789:
      label819:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dtw)localObject).GqB = paramInt1;
        ((dtw)localObject).HPi = paramg.doj;
        ((dtw)localObject).Ghj = paramg.ics;
        ((dtw)localObject).HZB = this.dlw.fmp;
        ((dtw)localObject).HZC = this.dlw.fmo;
        if (((s)com.tencent.mm.kernel.g.ad(s.class)).ifAddTicketByActionFlag(this.dlw.field_talker)) {
          ((dtw)localObject).Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(this.dlw.field_talker);
        }
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dtw)localObject).HZB), Integer.valueOf(((dtw)localObject).HZC) });
        com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramg.doj), Integer.valueOf(((dtw)localObject).Ghj) });
        if (paramg.offset == 0) {
          this.idW = new com.tencent.mm.modelstat.h(getType(), true, paramg.hPI);
        }
        AppMethodBeat.o(218735);
        return;
        this.dlw.uj("THUMBNAIL://" + paramg.doE);
        break;
      }
    }
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ak.g paramg)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, 0, "", "");
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ak.g paramg, int paramInt3, com.tencent.mm.ak.k paramk, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, "", "", true, paramInt4);
    AppMethodBeat.i(218732);
    this.ier = new a(paramk);
    AppMethodBeat.o(218732);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ak.g paramg, int paramInt3, String paramString4, String paramString5)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, false, -1);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ak.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, 0L, null);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.ak.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, long paramLong, String paramString6)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, paramLong, paramString6);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.ak.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2, int paramInt5, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, String paramString6)
  {
    AppMethodBeat.i(218733);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iem = "";
    this.ien = "";
    this.ieo = true;
    this.ieq = 16384;
    this.icr = 0;
    this.dlw = null;
    this.idW = null;
    this.idX = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.glf = 0;
    this.ier = new a(null);
    this.iez = false;
    this.ieB = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(218722);
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.pB((int)n.b(n.this));
        k.pA((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEZ();
        }
        AppMethodBeat.o(218722);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(218723);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218723);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(218723);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(218721);
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gmb, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iTe) });
        long l1 = paramAnonymousa.iTe;
        long l2 = bu.fpO();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gmb;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nZM;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIX().o(localg.ico, "", "");
        Object localObject2 = q.aIX().o(localg.icp, "", "");
        locald.field_thumbimgLength = ((int)o.aZR(q.aIX().o(localg.icq, "", "")));
        locald.field_midimgLength = ((int)o.aZR((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iTe;
        com.tencent.mm.an.f.aHa();
        locald.field_filecrc = com.tencent.mm.an.a.Fm((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.FK((String)localObject2);
        if ((localObject1 != null) && (!bu.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bu.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.FI((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).FI((String)localObject1);
            }
            localObject1 = c.aIt();
            ((c)localObject1).gzx = n.q(n.this);
            ((c)localObject1).ibY = ((dtw)n.p(n.this).hQD.hQJ);
            ((c)localObject1).ibZ = localg;
            ((c)localObject1).gmb = paramAnonymousa.Fdq;
            ((c)localObject1).gzD = locald;
            ((c)localObject1).ica = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(218720);
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.pB((int)n.b(n.this));
                  k.pA((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEZ();
                  }
                  AppMethodBeat.o(218720);
                  return;
                }
                n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(218720);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJO().execute();
            AppMethodBeat.o(218721);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bx.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.icr == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bu.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ieg = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(218727);
        com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(218727);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bu.fpO();
            i = com.tencent.mm.an.c.cC(ak.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.FX(paramAnonymousd.fKX))
          {
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLH();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.an.f.aGZ().Fr(n.n(n.this));
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajU().aw(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(218724);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pp(0);
                n.m(n.this).qN(bl.BQ(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dtw)n.p(n.this).hQD.hQJ;
                if (localObject == null) {
                  com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(218724);
                  return;
                  ((dtw)localObject).HZu = new cxn().aQV(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(218727);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(218725);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(218725);
                }
              });
              AppMethodBeat.o(218727);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bu.cF(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dtx();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bu.fpO();
          i = com.tencent.mm.an.c.cC(ak.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.j(paramAnonymousc).aLH();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLH();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
            continue;
            paramAnonymousc = n.FX(paramAnonymousd.fKX);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
        if (localg.doj == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.FK(paramAnonymousString);
          if ((paramAnonymousc == null) || (bu.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bu.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XY())
              {
                if (!bu.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.FI((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).FI((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIt();
                paramAnonymousString.gzx = n.q(n.this);
                paramAnonymousString.ibY = ((dtw)n.p(n.this).hQD.hQJ);
                paramAnonymousString.ibZ = localg;
                paramAnonymousString.gmb = n.z(n.this);
                paramAnonymousString.gzD = paramAnonymousd;
                paramAnonymousString.ica = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(218726);
                    new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
                    com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.pB((int)n.b(n.this));
                      k.pA((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEZ();
                      }
                      AppMethodBeat.o(218726);
                      return;
                    }
                    n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(218726);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJO().execute();
                break;
                paramAnonymousInt = localg.doj;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bx.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.icr == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
              paramAnonymousString = new dtx();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xrk != 0L) {}
                for (l1 = paramAnonymousString.xrk;; l1 = paramAnonymousInt)
                {
                  com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hPI, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.FNL))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEZ();
                    }
                  }
                  AppMethodBeat.o(218727);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xri;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEZ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(218728);
        Object localObject1 = (dtw)n.p(n.this).hQD.hQJ;
        sb localsb = new sb();
        localsb.GgV = ((dtw)localObject1).HZu.HId;
        localsb.uvG = ((dtw)localObject1).FNG.HId;
        localsb.uvF = ((dtw)localObject1).FNH.HId;
        localsb.GgW = ((dtw)localObject1).HZB;
        localsb.GgX = ((dtw)localObject1).HZC;
        localsb.Scene = n.A(n.this);
        localsb.GgZ = n.B(n.this);
        localsb.Gha = n.C(n.this);
        localsb.Ghb = n.D(n.this);
        localsb.FNL = ((dtw)localObject1).FNL;
        localsb.Ghg = n.z(n.this);
        localsb.ikm = ((dtw)localObject1).ikm;
        localsb.FKQ = ((dtw)localObject1).FKQ;
        localsb.FKS = ((dtw)localObject1).FKS;
        localsb.FKR = ((dtw)localObject1).FKR;
        localsb.Ghk = ((dtw)localObject1).Ghk;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIX().o(((g)localObject1).ico, "", "");
        com.tencent.mm.an.f.aHa();
        localsb.Ghi = com.tencent.mm.an.a.Fm((String)localObject2);
        localsb.Ghj = ((g)localObject1).ics;
        int i;
        label342:
        String str;
        if (localsb.Ghj <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localsb.Ghj = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localsb.ucK = 2;
            if (localsb.Ghj == 3) {
              localsb.ucK = 4;
            }
            com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localsb.GgW), Integer.valueOf(localsb.GgX), localsb.FNL, localsb.uvF, localsb.Ghg, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).ico, localObject2, Integer.valueOf(localsb.Ghi), Integer.valueOf(localsb.Ghj), Integer.valueOf(localsb.ucK) });
            paramAnonymousString = new com.tencent.mm.ak.b.a();
            paramAnonymousString.hQF = localsb;
            paramAnonymousString.hQG = new dtx();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hQH = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDS();
            localObject2 = n.F(n.this).aFs();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aFm()))
        {
          com.tencent.mm.sdk.platformtools.ae.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aFm())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mR(1), ((com.tencent.mm.network.c)localObject2).aFl(), ((com.tencent.mm.network.c)localObject2).aFn(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localsb.GgV });
          AppMethodBeat.o(218728);
          return;
          i = 1;
          break;
          localsb.ucK = 1;
          break label342;
          localsb.ucK = 3;
          break label342;
          localsb.ucK = 5;
          break label342;
        }
        label744:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
        return;
        label776:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218729);
        PInt localPInt = new PInt();
        sc localsc = new sc();
        try
        {
          paramAnonymousArrayOfByte = w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajQ().gDv.hRo.aFs().mR(1), localPInt, localsc);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsc.Ghg, localsc.FSC, localsc.GgV });
          n.c(n.this, localsc.Ghg);
          ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(localsc.Ghl);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsc.Ghl) });
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(218729);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(218729);
        }
        return null;
      }
    };
    this.gzE = false;
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramg, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), bu.fpN(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.ieu = paramBoolean1;
    this.iea = paramInt4;
    this.idS = paramg;
    this.icr = paramInt2;
    this.scene = paramInt5;
    this.dzE = paramFloat2;
    this.iev = paramFloat1;
    this.gzx = paramInt1;
    this.iey = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.ies = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong1 > 0L)
    {
      paramString5 = q.aIX().c(Long.valueOf(paramLong1));
      paramString5 = q.aIX().o(paramString5.ict, "", "");
    }
    if (paramLong2 > 0L) {
      this.ieA = bn.BV(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramLong2).eNd);
    }
    try
    {
      for (;;)
      {
        this.idT = q.aIX().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
        this.gzw = this.idT;
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.idT);
        if ((!paramBoolean2) || ((this.idT >= 0L) && (k.pz((int)this.idT)))) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "insert to img storage failed id:" + this.idT);
        this.icx = -1L;
        this.rr = null;
        AppMethodBeat.o(218733);
        return;
        if (!bu.isNullOrNil(paramString6)) {
          this.ieA = paramString6;
        }
      }
    }
    catch (SQLiteException paramString6)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 182L, 1L, false);
        if (!paramString6.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        q.aIX().aIE();
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "fallback to insert");
        this.idT = q.aIX().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
      }
      AppMethodBeat.o(218733);
      throw paramString6;
    }
    if (this.idT >= 0L)
    {
      paramBoolean1 = true;
      Assert.assertTrue(paramBoolean1);
      paramString3 = new com.tencent.mm.ak.b.a();
      paramString3.hQF = new dtw();
      paramString3.hQG = new dtx();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.hQH = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.aDS();
      this.cUB = paramString2;
      this.dlw = new bv();
      this.dlw.setType(x.Bc(paramString2));
      this.dlw.ui(paramString2);
      this.dlw.kt(1);
      this.dlw.setStatus(1);
      this.dlw.uj(localPString.value);
      this.dlw.kD(localPInt1.value);
      this.dlw.kE(localPInt2.value);
      this.dlw.qN(bl.BQ(this.dlw.field_talker));
      this.dlw.setContent(paramString4);
      a.a.ZP().n(this.dlw);
    }
    label1640:
    label1646:
    label1651:
    for (;;)
    {
      try
      {
        this.icx = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().c(this.dlw, true);
        if (this.icx >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.icx);
          paramString3 = aII();
          paramString3.sq((int)this.icx);
          q.aIX().a(Long.valueOf(this.idT), paramString3);
          if (paramInt2 != 1) {
            break label1651;
          }
          this.gzw = paramString3.icz;
          paramString3 = aIH();
          paramString3.pq((int)o.aZR(q.aIX().o(paramString3.ico, "", "")));
          q.aIX().a(Long.valueOf(this.gzw), paramString3);
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gzw + " img len = " + paramString3.hPI);
          paramString5 = (dtw)this.rr.hQD.hQJ;
          paramString5.FNG = new cxn().aQV(paramString1);
          paramString5.FNH = new cxn().aQV(paramString2);
          paramString5.xsC = paramString3.offset;
          paramString5.xsB = paramString3.hPI;
          paramString5.urJ = this.dlw.getType();
          paramString5.GUb = paramInt2;
          if (!com.tencent.mm.network.ae.cR(ak.getContext())) {
            break label1640;
          }
          paramInt3 = 1;
          paramString5.GqB = paramInt3;
          paramString5.HPi = paramString3.doj;
          paramString5.Ghj = paramString3.ics;
          paramString5.HZB = localPInt2.value;
          paramString5.HZC = localPInt1.value;
          paramString1 = h.FK(paramString4);
          if ((paramString1 != null) && (!bu.isNullOrNil(paramString1.appId)))
          {
            paramString5.ikm = paramString1.appId;
            paramString5.FKQ = paramString1.mediaTagName;
            paramString5.FKS = paramString1.messageAction;
            paramString5.FKR = paramString1.messageExt;
          }
          if (((s)com.tencent.mm.kernel.g.ad(s.class)).ifAddTicketByActionFlag(paramString2)) {
            paramString5.Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(paramString2);
          }
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.HZB), Integer.valueOf(paramString5.HZC) });
          if (paramString5.Ghj == 0)
          {
            if (paramInt1 != 4) {
              break label1646;
            }
            paramInt1 = 2;
            paramString5.Ghj = paramInt1;
          }
          com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.doj), Integer.valueOf(paramString5.Ghj) });
          if (paramString3.offset == 0) {
            this.idW = new com.tencent.mm.modelstat.h(getType(), true, paramString3.hPI);
          }
          paramLong1 = System.currentTimeMillis();
          pC(paramInt2);
          com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong1) });
          if (paramg != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150681);
                paramg.a(this.iei, this.iej, n.this);
                AppMethodBeat.o(150681);
              }
            });
          }
          AppMethodBeat.o(218733);
          return;
          paramBoolean1 = false;
        }
      }
      catch (SQLiteException paramString3)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 182L, 1L, false);
        if (paramString3.toString().contains("UNIQUE constraint failed"))
        {
          com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "fallback to insert");
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().doT();
          this.icx = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().c(this.dlw, true);
          continue;
        }
        AppMethodBeat.o(218733);
        throw paramString3;
      }
      paramBoolean1 = false;
      continue;
      paramInt3 = 2;
      continue;
      paramInt1 = 1;
    }
  }
  
  public n(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.ak.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(218734);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.iem = "";
    this.ien = "";
    this.ieo = true;
    this.ieq = 16384;
    this.icr = 0;
    this.dlw = null;
    this.idW = null;
    this.idX = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.glf = 0;
    this.ier = new a(null);
    this.iez = false;
    this.ieB = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(218722);
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.pB((int)n.b(n.this));
        k.pA((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEZ();
        }
        AppMethodBeat.o(218722);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(218723);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218723);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(218723);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(218721);
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gmb, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iTe) });
        long l1 = paramAnonymousa.iTe;
        long l2 = bu.fpO();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gmb;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nZM;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIX().o(localg.ico, "", "");
        Object localObject2 = q.aIX().o(localg.icp, "", "");
        locald.field_thumbimgLength = ((int)o.aZR(q.aIX().o(localg.icq, "", "")));
        locald.field_midimgLength = ((int)o.aZR((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iTe;
        com.tencent.mm.an.f.aHa();
        locald.field_filecrc = com.tencent.mm.an.a.Fm((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.FK((String)localObject2);
        if ((localObject1 != null) && (!bu.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bu.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.FI((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).FI((String)localObject1);
            }
            localObject1 = c.aIt();
            ((c)localObject1).gzx = n.q(n.this);
            ((c)localObject1).ibY = ((dtw)n.p(n.this).hQD.hQJ);
            ((c)localObject1).ibZ = localg;
            ((c)localObject1).gmb = paramAnonymousa.Fdq;
            ((c)localObject1).gzD = locald;
            ((c)localObject1).ica = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(218720);
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.pB((int)n.b(n.this));
                  k.pA((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEZ();
                  }
                  AppMethodBeat.o(218720);
                  return;
                }
                n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(218720);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJO().execute();
            AppMethodBeat.o(218721);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bx.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.icr == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bu.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bu.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ieg = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(218727);
        com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(218727);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bu.fpO();
            i = com.tencent.mm.an.c.cC(ak.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.FX(paramAnonymousd.fKX))
          {
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLH();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.doE != n.c(n.this)))
        {
          com.tencent.mm.an.f.aGZ().Fr(n.n(n.this));
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEZ();
          }
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(218727);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajU().aw(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(218724);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pp(0);
                n.m(n.this).qN(bl.BQ(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.an.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dtw)n.p(n.this).hQD.hQJ;
                if (localObject == null) {
                  com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(218724);
                  return;
                  ((dtw)localObject).HZu = new cxn().aQV(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(218727);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(218725);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(218725);
                }
              });
              AppMethodBeat.o(218727);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bu.cF(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dtx();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bu.fpO();
          i = com.tencent.mm.an.c.cC(ak.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.j(paramAnonymousc).aLH();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLH();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEZ();
            }
            AppMethodBeat.o(218727);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousc) });
            continue;
            paramAnonymousc = n.FX(paramAnonymousd.fKX);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
        if (localg.doj == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.FK(paramAnonymousString);
          if ((paramAnonymousc == null) || (bu.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
        {
          if (bu.isNullOrNil(paramAnonymousString))
          {
            paramAnonymousString = "<msg><img aeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
            paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + paramAnonymousd.field_aesKey + "\" cdnthumblength=\"" + paramAnonymousd.field_thumbimgLength + "\" ";
            paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
            if (paramAnonymousd.field_midimgLength == 0)
            {
              l1 = paramAnonymousd.field_fileLength;
              label1606:
              paramAnonymousString = l1 + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>";
              com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XY())
              {
                if (!bu.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                com.tencent.mm.sdk.platformtools.ae.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.FI((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).FI((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIt();
                paramAnonymousString.gzx = n.q(n.this);
                paramAnonymousString.ibY = ((dtw)n.p(n.this).hQD.hQJ);
                paramAnonymousString.ibZ = localg;
                paramAnonymousString.gmb = n.z(n.this);
                paramAnonymousString.gzD = paramAnonymousd;
                paramAnonymousString.ica = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(218726);
                    new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
                    com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.pB((int)n.b(n.this));
                      k.pA((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEZ();
                      }
                      AppMethodBeat.o(218726);
                      return;
                    }
                    n.a(n.this, localg, localg.hPI, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(218726);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJO().execute();
                break;
                paramAnonymousInt = localg.doj;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bx.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.icr == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bu.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bu.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.FX(paramAnonymousd.fKX) })).aLH();
              paramAnonymousString = new dtx();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xrk != 0L) {}
                for (l1 = paramAnonymousString.xrk;; l1 = paramAnonymousInt)
                {
                  com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hPI, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.FNL))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEZ();
                    }
                  }
                  AppMethodBeat.o(218727);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xri;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "exception:%s", new Object[] { bu.o(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEZ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(218728);
        Object localObject1 = (dtw)n.p(n.this).hQD.hQJ;
        sb localsb = new sb();
        localsb.GgV = ((dtw)localObject1).HZu.HId;
        localsb.uvG = ((dtw)localObject1).FNG.HId;
        localsb.uvF = ((dtw)localObject1).FNH.HId;
        localsb.GgW = ((dtw)localObject1).HZB;
        localsb.GgX = ((dtw)localObject1).HZC;
        localsb.Scene = n.A(n.this);
        localsb.GgZ = n.B(n.this);
        localsb.Gha = n.C(n.this);
        localsb.Ghb = n.D(n.this);
        localsb.FNL = ((dtw)localObject1).FNL;
        localsb.Ghg = n.z(n.this);
        localsb.ikm = ((dtw)localObject1).ikm;
        localsb.FKQ = ((dtw)localObject1).FKQ;
        localsb.FKS = ((dtw)localObject1).FKS;
        localsb.FKR = ((dtw)localObject1).FKR;
        localsb.Ghk = ((dtw)localObject1).Ghk;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIX().o(((g)localObject1).ico, "", "");
        com.tencent.mm.an.f.aHa();
        localsb.Ghi = com.tencent.mm.an.a.Fm((String)localObject2);
        localsb.Ghj = ((g)localObject1).ics;
        int i;
        label342:
        String str;
        if (localsb.Ghj <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localsb.Ghj = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localsb.ucK = 2;
            if (localsb.Ghj == 3) {
              localsb.ucK = 4;
            }
            com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localsb.GgW), Integer.valueOf(localsb.GgX), localsb.FNL, localsb.uvF, localsb.Ghg, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).ico, localObject2, Integer.valueOf(localsb.Ghi), Integer.valueOf(localsb.Ghj), Integer.valueOf(localsb.ucK) });
            paramAnonymousString = new com.tencent.mm.ak.b.a();
            paramAnonymousString.hQF = localsb;
            paramAnonymousString.hQG = new dtx();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hQH = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDS();
            localObject2 = n.F(n.this).aFs();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aFm()))
        {
          com.tencent.mm.sdk.platformtools.ae.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aFm())) {
            break label776;
          }
          if (!com.tencent.mm.ak.u.a(((com.tencent.mm.network.c)localObject2).mR(1), ((com.tencent.mm.network.c)localObject2).aFl(), ((com.tencent.mm.network.c)localObject2).aFn(), ((com.tencent.mm.ak.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          com.tencent.mm.sdk.platformtools.ae.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localsb.GgV });
          AppMethodBeat.o(218728);
          return;
          i = 1;
          break;
          localsb.ucK = 1;
          break label342;
          localsb.ucK = 3;
          break label342;
          localsb.ucK = 5;
          break label342;
        }
        label744:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
        return;
        label776:
        com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localsb.GgV });
        AppMethodBeat.o(218728);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218729);
        PInt localPInt = new PInt();
        sc localsc = new sc();
        try
        {
          paramAnonymousArrayOfByte = w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajQ().gDv.hRo.aFs().mR(1), localPInt, localsc);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsc.Ghg, localsc.FSC, localsc.GgV });
          n.c(n.this, localsc.Ghg);
          ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(localsc.Ghl);
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsc.Ghl) });
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(218729);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(218729);
        }
        return null;
      }
    };
    this.gzE = false;
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramg, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), bu.fpN() });
    this.ieu = paramBoolean1;
    this.iea = paramInt4;
    this.idS = paramg;
    this.icr = paramInt2;
    this.gzx = paramInt1;
    this.iey = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.ies = paramString4;
    this.idT = paramLong;
    this.gzw = this.idT;
    paramString3 = aII();
    this.dlw = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramString3.icx);
    this.icx = this.dlw.field_msgId;
    localPInt.value = this.dlw.fmp;
    paramString5.value = this.dlw.fmo;
    if (paramInt2 == 1)
    {
      this.gzw = paramString3.icz;
      this.gzy = null;
      paramString3 = aIH();
    }
    for (;;)
    {
      if ((this.dlw.field_talker != null) && (!this.dlw.field_talker.equals(paramString2)))
      {
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.dlw.field_talker });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.dlw.field_talker;; paramString4 = paramString2)
      {
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.dlw.field_msgId);
        com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.idT);
        if ((paramBoolean2) && ((this.idT < 0L) || (!k.pz((int)this.idT))))
        {
          com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "insert to img storage failed id:" + this.idT);
          this.icx = -1L;
          this.rr = null;
          AppMethodBeat.o(218734);
          return;
        }
        if (this.idT >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          paramString2 = new com.tencent.mm.ak.b.a();
          paramString2.hQF = new dtw();
          paramString2.hQG = new dtx();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.hQH = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.aDS();
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gzw + " img len = " + paramString3.hPI);
          paramString2 = (dtw)this.rr.hQD.hQJ;
          paramString2.FNG = new cxn().aQV(paramString1);
          paramString2.FNH = new cxn().aQV(paramString4);
          paramString2.xsC = paramString3.offset;
          paramString2.xsB = paramString3.hPI;
          paramString2.urJ = this.dlw.getType();
          paramString2.GUb = paramInt2;
          if (!com.tencent.mm.network.ae.cR(ak.getContext())) {
            break label1112;
          }
          paramInt2 = 1;
          label856:
          paramString2.GqB = paramInt2;
          paramString2.HPi = paramString3.doj;
          paramString2.Ghj = paramString3.ics;
          paramString2.HZB = localPInt.value;
          paramString2.HZC = paramString5.value;
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.HZB), Integer.valueOf(paramString2.HZC) });
          if (paramString2.Ghj == 0) {
            if (paramInt1 != 4) {
              break label1118;
            }
          }
        }
        label1112:
        label1118:
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString2.Ghj = paramInt1;
          if (((s)com.tencent.mm.kernel.g.ad(s.class)).ifAddTicketByActionFlag(paramString4)) {
            paramString2.Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(paramString4);
          }
          com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.doj), Integer.valueOf(paramString2.Ghj) });
          if (paramString3.offset == 0) {
            this.idW = new com.tencent.mm.modelstat.h(getType(), true, paramString3.hPI);
          }
          if (paramg != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150682);
                paramg.a(this.iei, this.iej, n.this);
                AppMethodBeat.o(150682);
              }
            });
          }
          AppMethodBeat.o(218734);
          return;
          paramBoolean1 = false;
          break;
          paramInt2 = 2;
          break label856;
        }
      }
    }
  }
  
  public static String FX(String paramString)
  {
    AppMethodBeat.i(150708);
    try
    {
      boolean bool = bu.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150708);
        return paramString;
      }
      Object localObject = paramString.split(",");
      if ((localObject != null) && (localObject.length > 19))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = ieC;
        ieC = -1L;
        localObject[19] = l;
        localObject = bu.m(bu.U((String[])localObject), ",");
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
    String str3 = this.dlw.field_talker;
    if (x.Ba(str3))
    {
      com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { str3 });
      AppMethodBeat.o(150700);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.f.b.fcW())
    {
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(150700);
      return false;
    }
    com.tencent.mm.an.f.aGZ();
    if ((!com.tencent.mm.an.b.pd(1)) && (bu.isNullOrNil(paramg.icA)))
    {
      localObject = this.TAG;
      com.tencent.mm.an.f.aGZ();
      com.tencent.mm.sdk.platformtools.ae.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.pd(1)), paramg.icA });
      AppMethodBeat.o(150700);
      return false;
    }
    if (bu.isNullOrNil(this.idX))
    {
      com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gzw) });
      AppMethodBeat.o(150700);
      return false;
    }
    String str2 = q.aIX().o(paramg.ico, "", "");
    String str1 = q.aIX().o(paramg.icp, "", "");
    String str4 = q.aIX().o(paramg.icq, "", "");
    Object localObject = q.aIX().o(paramg.ict, "", "");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLl = "task_NetSceneUploadMsgImg";
    localg.fLm = this.ieg;
    localg.field_mediaId = this.idX;
    localg.field_fileType = this.glf;
    localg.field_talker = str3;
    int i;
    boolean bool1;
    if (x.wb(str3))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.fKA;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      if (an.aUx(this.dlw.field_talker)) {
        break label1009;
      }
      bool1 = true;
      label351:
      localg.field_sendmsg_viacdn = bool1;
      if ((an.aUx(this.dlw.field_talker)) || (!this.ieo)) {
        break label1015;
      }
      bool1 = true;
      label381:
      localg.field_enable_hitcheck = bool1;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "field_sendmsg_viacdn=%s talker=%s", new Object[] { Boolean.valueOf(localg.field_sendmsg_viacdn), str3 });
      if (paramInt != -5103237) {
        break label1021;
      }
      this.idX = com.tencent.mm.an.c.a("upimgjpg", this.dlw.field_createTime, str3, this.dlw.field_msgId + "_" + this.gzw + "_" + this.icr);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.idX;
      this.iez = false;
      if (!this.iez)
      {
        bool1 = com.tencent.mm.sdk.platformtools.u.aRH(str4);
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", new Object[] { Boolean.valueOf(bool1) });
      }
      if ((localg.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) && (bu.isNullOrNil(localg.field_midimgpath)))
      {
        com.tencent.mm.an.f.aGZ();
        if (com.tencent.mm.an.b.pd(256))
        {
          com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = bx.M(this.ies, "msg");
      if (localObject == null) {
        break label1378;
      }
      if (this.icr == 1) {
        break label1329;
      }
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"));
      localg.field_midFileLength = bu.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      label707:
      localg.field_aesKey = ((String)((Map)localObject).get(".msg.img.$aeskey"));
    }
    for (;;)
    {
      if ((bu.isNullOrNil(localg.field_aesKey)) || ("null".equalsIgnoreCase(localg.field_aesKey)))
      {
        com.tencent.mm.an.f.aHa();
        localg.field_aesKey = com.tencent.mm.an.a.aGP();
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(paramg.doj), localg.field_fileId });
      this.iem = localg.field_fileId;
      this.ien = localg.field_aesKey;
      com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.iex = null;
      if (com.tencent.mm.an.f.aGZ().f(localg)) {
        break label1402;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 205L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.idX });
      this.idX = "";
      AppMethodBeat.o(150700);
      return false;
      i = 0;
      break;
      label1009:
      bool1 = false;
      break label351;
      label1015:
      bool1 = false;
      break label381;
      label1021:
      boolean bool2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).chc();
      boolean bool3;
      if ((this.gzx == 4) && (o.fB((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV(str1);
        bool3 = bo(str1, str3);
        if (!bool2) {
          break label1303;
        }
        label1086:
        localg.field_fullpath = ((String)localObject);
        localg.field_thumbpath = str4;
        if (!bool3) {
          break label1310;
        }
        localObject = str3;
        label1109:
        localg.field_midimgpath = ((String)localObject);
        if ((!bool2) && (!bool3)) {
          break label1317;
        }
        bool1 = true;
        label1129:
        this.iez = bool1;
        localObject = this.TAG;
        if (localg.field_fileType != com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) {
          break label1323;
        }
      }
      label1303:
      label1310:
      label1317:
      label1323:
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.ae.d((String)localObject, "hevc upload full size %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        break;
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV(str2);
        bool1 = com.tencent.mm.sdk.platformtools.u.aRI(str2).equals(".png");
        if ((this.icr == 0) && (!bool1) && (bo(str2, str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          paramg.FJ(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV(paramg.ico));
          bool2 = bool1;
          localObject = str3;
          break;
        }
        localObject = str2;
        break label1086;
        localObject = str1;
        break label1109;
        bool1 = false;
        break label1129;
      }
      label1329:
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"));
      localg.field_midFileLength = bu.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      break label707;
      label1378:
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.icA });
    }
    label1402:
    if (bu.nullAsNil(paramg.icA).length() <= 0)
    {
      paramg.FI("CDNINFO_SEND");
      paramg.dEu = 4096;
    }
    AppMethodBeat.o(150700);
    return true;
  }
  
  private boolean a(g paramg, int paramInt1, long paramLong, int paramInt2, com.tencent.mm.i.d paramd, String paramString)
  {
    AppMethodBeat.i(169189);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.idX, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(ac.iRI), Long.valueOf(this.idT), Long.valueOf(this.gzw) });
    long l = paramLong;
    if (10007 == ac.iRH)
    {
      l = paramLong;
      if (ac.iRI != 0)
      {
        l = ac.iRI;
        ac.iRI = 0;
      }
    }
    b(paramg.doE, paramInt1, paramg.hPI);
    paramg.setOffset(paramInt1);
    paramg.qM(l);
    g localg;
    if (h.b(paramg))
    {
      if (this.idT == this.gzw) {
        break label498;
      }
      localg = q.aIX().c(Long.valueOf(this.idT));
      localg.qM(l);
      localg.pq(paramg.hPI);
      localg.setOffset(paramg.hPI);
      q.aIX().a(Long.valueOf(this.idT), localg);
    }
    while (h.b(paramg))
    {
      if (bu.isNullOrNil(this.idX)) {
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.glf), Integer.valueOf(paramg.hPI - this.startOffset) });
      }
      this.dlw.setStatus(2);
      this.dlw.qM(l);
      this.dlw.tk(paramString);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.icx, this.dlw);
      if (r.iuk != null) {
        r.iuk.q(this.dlw);
      }
      if (this.idW != null) {
        this.idW.sB(0L);
      }
      if (u.ifJ != null) {
        u.ifJ.a(this.gzw, this.dlw, this.rr, this.gzx, this.gzE, paramd);
      }
      if (this.ier != null) {
        this.ier.aEZ();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      k.pA((int)this.idT);
      AppMethodBeat.o(169189);
      return false;
      label498:
      localg = q.aIX().c(Long.valueOf(paramg.doE));
      localg.qM(l);
      localg.pq(paramg.hPI);
      localg.setOffset(paramg.hPI);
      q.aIX().a(Long.valueOf(localg.doE), localg);
    }
    AppMethodBeat.o(169189);
    return true;
  }
  
  private g aIH()
  {
    AppMethodBeat.i(150692);
    if (this.gzy == null) {
      this.gzy = q.aIX().c(Long.valueOf(this.gzw));
    }
    g localg = this.gzy;
    AppMethodBeat.o(150692);
    return localg;
  }
  
  private g aII()
  {
    AppMethodBeat.i(150693);
    if (this.iep == null) {
      this.iep = q.aIX().c(Long.valueOf(this.idT));
    }
    g localg = this.iep;
    AppMethodBeat.o(150693);
    return localg;
  }
  
  private void b(final long paramLong, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150707);
    if (this.idS != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(218730);
          p localp = p.aIL();
          long l1 = paramLong;
          long l2 = paramInt1;
          long l3 = this.ieI;
          if (localp.ieL.containsKey(Long.valueOf(l1))) {}
          for (p.d locald = (p.d)localp.ieL.get(Long.valueOf(l1));; locald = new p.d())
          {
            locald.offset = l3;
            locald.dzX = l2;
            localp.ieL.put(Long.valueOf(l1), locald);
            n.G(n.this).a(this.ieI, paramInt1, n.this);
            AppMethodBeat.o(218730);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(150707);
  }
  
  private boolean bo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150701);
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).chc())
    {
      AppMethodBeat.o(150701);
      return false;
    }
    if (o.aZR(paramString1) > 0L)
    {
      if (o.aZR(paramString2) > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.dD(944, 9);
        o.deleteFile(paramString2);
      }
      if (!o.fB(paramString2)) {
        o.aZV(paramString2);
      }
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fw(paramString1, paramString2) == 0)
      {
        AppMethodBeat.o(150701);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
    }
    AppMethodBeat.o(150701);
    return false;
  }
  
  private int pD(int paramInt)
  {
    AppMethodBeat.i(150703);
    com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.ier != null) {
      this.ier.aEZ();
    }
    AppMethodBeat.o(150703);
    return -1;
  }
  
  public static void st(long paramLong)
  {
    ieC = paramLong;
  }
  
  public final bv aIJ()
  {
    AppMethodBeat.i(218731);
    if (this.dlw == null) {
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "msg is null. %s", new Object[] { bu.fpN() });
    }
    bv localbv = this.dlw;
    AppMethodBeat.o(218731);
    return localbv;
  }
  
  public final void aIK()
  {
    AppMethodBeat.i(150705);
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "send img from system");
    this.gzE = true;
    AppMethodBeat.o(150705);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(150702);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150690);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aqY("SendImgSpeeder");
        AppMethodBeat.o(150690);
      }
    }, 100L);
    if (this.gzw < 0L)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 204L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene invalid imgLocalId:" + this.gzw);
      i = pD(-1);
      AppMethodBeat.o(150702);
      return i;
    }
    if (this.dlw == null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 203L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.gzw) });
      k.pB((int)this.idT);
      i = pD(-2);
      AppMethodBeat.o(150702);
      return i;
    }
    this.callback = paramf;
    prepareDispatcher(parame);
    dtw localdtw = (dtw)this.rr.hQD.hQJ;
    g localg = aIH();
    paramf = q.aIX().py((int)localg.doE);
    if (paramf != null)
    {
      if (paramf.status == -1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 202L, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene hd img info is null or error.");
        i = pD(-3);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else if ((localg == null) || (localg.status == -1))
    {
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene img info is null or error.");
      i = pD(-4);
      AppMethodBeat.o(150702);
      return i;
    }
    String str1;
    if (a.a.ZP().vz(this.dlw.field_talker))
    {
      localdtw.FNL = a.a.ZP().o(this.dlw);
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "upload img msg source %s", new Object[] { localdtw.FNL });
      str1 = q.aIX().o(localg.ico, "", "");
      paramf = q.aIX().o(localg.icq, "", "");
      if (!bu.isNullOrNil(localg.icp)) {
        q.aIX().o(localg.icp, "", "");
      }
      if ((o.aZR(str1) <= 0L) || (o.aZR(paramf) <= 0L))
      {
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.gzw), Long.valueOf(o.aZR(str1)), Long.valueOf(o.aZR(paramf)), str1, paramf });
        i = pD(-5);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else
    {
      if (bu.isNullOrNil(this.ieA))
      {
        paramf = o.aRh(this.iey);
        localObject = com.tencent.mm.platformtools.v.iQD;
        this.ieA = com.tencent.mm.platformtools.v.Ju(paramf);
      }
      if (!bu.isNullOrNil(this.ieA)) {}
      for (paramf = bn.BW(this.ieA);; paramf = bn.We())
      {
        if (((paramf != null) && (!paramf.equals(this.dlw.eNd))) || ((paramf == null) && (!bu.isNullOrNil(this.dlw.eNd))))
        {
          this.dlw.tk(paramf);
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.dlw.field_msgId, this.dlw);
        }
        localdtw.FNL = this.dlw.eNd;
        break;
      }
    }
    if ((localdtw.HZu == null) || (bu.isNullOrNil(localdtw.HZu.HId)))
    {
      if (bu.isNullOrNil(this.idX))
      {
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.dlw.field_createTime), this.dlw.field_talker, Long.valueOf(this.dlw.field_msgId), Long.valueOf(this.gzw), Integer.valueOf(this.icr) });
        this.idX = com.tencent.mm.an.c.a("upimg", this.dlw.field_createTime, this.dlw.field_talker, this.dlw.field_msgId + "_" + this.gzw + "_" + this.icr);
      }
      localdtw.HZu = new cxn().aQV(this.idX);
      paramf = this.dlw;
      paramf.fmu = this.idX;
      paramf.eMD = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bu.fpO();
      this.startOffset = localg.offset;
      if (this.icr != 1) {
        break label940;
      }
    }
    label940:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.glf = i;
      if (!a(localg, 0)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localdtw.HZu.HId });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (an.aUx(this.cUB))
    {
      com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "just return without using cdn for byp. %s", new Object[] { this.cUB });
      k.pB((int)this.idT);
      i = pD(-99);
      AppMethodBeat.o(150702);
      return i;
    }
    if (com.tencent.mm.n.g.acL().getInt("UploadMsgImgType", 0) == 1) {}
    for (boolean bool1 = true; x.Ba(this.dlw.field_talker); bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "cdntra not use parallel-upload user:%s", new Object[] { this.dlw.field_talker });
      i = 0;
      if (i == 0) {
        break label1489;
      }
      com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { localdtw.HZu.HId });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOZ, 1)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label1148;
      }
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "NOT ALLOW USE PARALLEL UPLOAD IMG");
      i = 0;
      break;
    }
    label1148:
    Object localObject = q.aIX().o(localg.ico, "", "");
    String str2 = q.aIX().o(localg.icq, "", "");
    paramf = q.aIX().o(localg.icp, "", "");
    boolean bool2 = bu.isNullOrNil(paramf);
    if (bool2) {
      paramf = (com.tencent.mm.ak.f)localObject;
    }
    for (;;)
    {
      String str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV(paramf);
      String str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV((String)localObject);
      com.tencent.mm.pluginsdk.f.d locald = new com.tencent.mm.pluginsdk.f.d();
      locald.icx = this.icx;
      locald.Fdc = this.ieB;
      locald.scene = 1;
      locald.fileType = 2;
      if (!bool2) {
        locald.fileType = 1;
      }
      String str5;
      if ((bool1) && (this.icr == 0))
      {
        localg.FJ(str4);
        str5 = q.aIX().o(localg.ict, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fw((String)localObject, str5);
        if (i != 0) {
          break label1480;
        }
        localg.pt(1);
        localg.pq((int)o.aZR(str5));
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.gzw), str5, Integer.valueOf(i), Integer.valueOf(localg.hPI) });
        locald.thumbPath = str2;
        locald.icp = paramf;
        locald.Fde = str3;
        locald.hgD = ((String)localObject);
        locald.Fdd = str4;
        paramf = new com.tencent.mm.pluginsdk.f.c();
        paramf.FcZ = bool1;
        paramf.a(locald);
        i = 1;
        break;
        label1480:
        localg.pt(0);
      }
      label1489:
      if ((bool1) && (this.icr == 0))
      {
        localg.FJ(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abV(localg.ico));
        paramf = q.aIX().o(localg.ict, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fw(str1, paramf);
        if (i != 0) {
          break label1693;
        }
        localg.pt(1);
        localg.pq((int)o.aZR(paramf));
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.gzw), paramf, Integer.valueOf(i), Integer.valueOf(localg.hPI) });
        i = localg.icy;
        if (i < securityLimitCount()) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 201L, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
        k.pB((int)this.idT);
        i = pD(-6);
        AppMethodBeat.o(150702);
        return i;
        label1693:
        localg.pt(0);
      }
      localg.pp(i + 1);
      localg.dEu = 512;
      q.aIX().a(Long.valueOf(this.gzw), localg);
      int j = localg.hPI - localg.offset;
      i = j;
      if (j > this.ieq) {
        i = this.ieq;
      }
      o.aZR(str1);
      if (localg.icu == 1) {}
      for (paramf = q.aIX().o(localg.ict, "", "");; paramf = q.aIX().o(localg.ico, "", ""))
      {
        paramf = o.bb(paramf, localg.offset, i);
        if ((paramf != null) && (paramf.length > 0)) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 199L, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene, file read buf error.");
        i = pD(-8);
        AppMethodBeat.o(150702);
        return i;
      }
      localdtw.xsD = paramf.length;
      localdtw.xsB = localg.hPI;
      localdtw.xsC = localg.offset;
      localdtw.xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
      localdtw.HoG = localg.icu;
      if (this.idW != null) {
        this.idW.aMf();
      }
      i = dispatch(parame, this.rr, this);
      if (i < 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "doScene netId error");
        k.pB((int)this.idT);
        i = pD(-9);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150704);
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.idX);
    paramq = (dtx)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(paramq.Ghl);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bu.isNullOrNil(this.idX)))
    {
      com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 198L, 1L, false);
      k.pB((int)this.idT);
      k.pA((int)this.idT);
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.glf), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.ier != null) {
        this.ier.aEZ();
      }
      AppMethodBeat.o(150704);
      return;
    }
    this.ieq = paramq.xsD;
    if (this.ieq > 16384) {
      this.ieq = 16384;
    }
    paramString = aIH();
    com.tencent.mm.sdk.platformtools.ae.v(this.TAG, "onGYNetEnd localId:" + this.gzw + "  totalLen:" + paramString.hPI + " offSet:" + paramString.offset);
    if ((paramq.xsC < 0) || ((paramq.xsC > paramString.hPI) && (paramString.hPI > 0)))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 197L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + paramq.xsC + " img totalLen = " + paramString.hPI);
      k.pB((int)this.idT);
      k.pA((int)this.idT);
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.glf), Integer.valueOf(0) });
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.ier != null) {
        this.ier.aEZ();
      }
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramq.xsC < paramString.offset) || ((h.b(paramString)) && (this.ieq <= 0)))
    {
      com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "onGYNetEnd invalid data startPos = " + paramq.xsC + " totalLen = " + paramString.hPI + " off:" + paramString.offset);
      k.pB((int)this.idT);
      k.pA((int)this.idT);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.ier != null) {
        this.ier.aEZ();
      }
      AppMethodBeat.o(150704);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + paramq.xsC);
    if ((a(paramString, paramq.xsC, paramq.xrk, paramq.CreateTime, null, paramq.FNL)) && (doScene(dispatcher(), this.callback) < 0))
    {
      k.pA((int)this.idT);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.ier != null) {
        this.ier.aEZ();
      }
    }
    AppMethodBeat.o(150704);
  }
  
  public final void pC(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(150697);
    if (this.dlw == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.icx), Integer.valueOf(paramInt) });
      AppMethodBeat.o(150697);
      return;
    }
    if (this.ieu)
    {
      if (this.dlw.fms == 0)
      {
        boolean bool = q.aIX().a(this.dlw, this.iea, paramInt);
        bv localbv = this.dlw;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localbv.kG(paramInt);
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.icx, this.dlw);
          AppMethodBeat.o(150697);
          return;
        }
      }
    }
    else {
      q.aIX().a(this.dlw.field_imgPath, com.tencent.mm.cb.a.getDensity(ak.getContext()), true);
    }
    AppMethodBeat.o(150697);
  }
  
  public final int securityLimitCount()
  {
    if (this.icr == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public final class a
  {
    public com.tencent.mm.ak.k ieJ;
    
    public a(com.tencent.mm.ak.k paramk)
    {
      this.ieJ = paramk;
    }
    
    final void aEZ()
    {
      AppMethodBeat.i(150691);
      if (n.b(n.this) == n.c(n.this)) {}
      for (Object localObject = n.d(n.this);; localObject = n.e(n.this))
      {
        if (((g)localObject).icB == 1)
        {
          com.tencent.mm.plugin.report.service.f.OQ(23);
          com.tencent.mm.plugin.report.service.f.OQ(21);
        }
        com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "UploadEndWrapper onUploadEnd %s done", new Object[] { n.e(n.d(n.this)) });
        if (q.aIX().a(Long.valueOf(n.c(n.this)), n.d(n.this)) < 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e(n.f(n.this), "update db failed local id:" + n.c(n.this) + " server id:" + n.d(n.this).dCd);
          k.pB((int)n.b(n.this));
          k.pA((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -1, "", n.this);
        }
        if (n.c(n.this) != n.b(n.this))
        {
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { n.e(n.e(n.this)) });
          q.aIX().a(Long.valueOf(n.b(n.this)), n.e(n.this));
        }
        if ((!com.tencent.mm.sdk.a.b.fnF()) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)) {
          break;
        }
        localObject = q.aIX().aIF();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          com.tencent.mm.sdk.platformtools.ae.i(n.f(n.this), "UploadEndWrapper onUploadEnd duminfo %s %s", new Object[] { Integer.valueOf(i), n.e((g)((List)localObject).get(i)) });
          i += 1;
        }
      }
      n.a(n.this, n.c(n.this));
      if (n.b(n.this) != n.c(n.this)) {
        n.a(n.this, n.b(n.this));
      }
      if (this.ieJ != null) {
        this.ieJ.aEZ();
      }
      n.this.pC(n.h(n.this));
      n.i(n.this);
      AppMethodBeat.o(150691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.n
 * JD-Core Version:    0.7.0.1
 */