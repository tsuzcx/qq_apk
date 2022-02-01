package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelstat.r.a;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.f.d.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.wcdb.database.SQLiteException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class n
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static boolean DEBUG = true;
  private static long ibJ;
  private String TAG;
  private com.tencent.mm.al.f callback;
  public String dHz;
  private bu dku;
  private float dyz;
  private int giN;
  private long gwP;
  private int gwQ;
  private g gwR;
  private boolean gwX;
  private long hZF;
  private int hZz;
  private final com.tencent.mm.al.g iaZ;
  public String ibA;
  public boolean ibB;
  private float ibC;
  private String ibD;
  private String ibE;
  public String ibF;
  private boolean ibG;
  private String ibH;
  private d.a ibI;
  public long iba;
  private com.tencent.mm.modelstat.h ibd;
  private String ibe;
  private int ibh;
  private com.tencent.mm.i.g.a ibn;
  private String ibt;
  private String ibu;
  private boolean ibv;
  private g ibw;
  private int ibx;
  public a iby;
  private String ibz;
  private final com.tencent.mm.al.b rr;
  private int scene;
  private int startOffset;
  private long startTime;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150698);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.ibt = "";
    this.ibu = "";
    this.ibv = true;
    this.ibx = 16384;
    this.hZz = 0;
    this.dku = null;
    this.ibd = null;
    this.ibe = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.giN = 0;
    this.iby = new a(null);
    this.ibG = false;
    this.ibI = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(195271);
        ad.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.py((int)n.b(n.this));
        k.pw((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEJ();
        }
        AppMethodBeat.o(195271);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(195272);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          ad.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195272);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(195272);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(195270);
        ad.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gjI, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iQl) });
        long l1 = paramAnonymousa.iQl;
        long l2 = bt.flT();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gjI;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nUg;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIF().o(localg.hZw, "", "");
        Object localObject2 = q.aIF().o(localg.hZx, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.i.aYo(q.aIF().o(localg.hZy, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.i.aYo((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iQl;
        com.tencent.mm.ao.f.aGJ();
        locald.field_filecrc = com.tencent.mm.ao.a.EK((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Fi((String)localObject2);
        if ((localObject1 != null) && (!bt.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bt.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.Fg((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Fg((String)localObject1);
            }
            localObject1 = c.aIc();
            ((c)localObject1).gwQ = n.q(n.this);
            ((c)localObject1).hZg = ((dsz)n.p(n.this).hNK.hNQ);
            ((c)localObject1).hZh = localg;
            ((c)localObject1).gjI = paramAnonymousa.EKS;
            ((c)localObject1).gwW = locald;
            ((c)localObject1).hZi = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(195269);
                ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.py((int)n.b(n.this));
                  k.pw((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEJ();
                  }
                  AppMethodBeat.o(195269);
                  return;
                }
                n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(195269);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJv().execute();
            AppMethodBeat.o(195270);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bw.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.hZz == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bt.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ibn = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195276);
        ad.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(195276);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bt.flT();
            i = com.tencent.mm.ao.c.cA(aj.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Fv(paramAnonymousd.fIT))
          {
            new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLk();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          com.tencent.mm.ao.f.aGI().EP(n.n(n.this));
          ad.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajF().ay(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(195273);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pm(0);
                n.m(n.this).qA(bj.Bo(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.ao.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dsz)n.p(n.this).hNK.hNQ;
                if (localObject == null) {
                  ad.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(195273);
                  return;
                  ((dsz)localObject).HFH = new cwt().aPy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(195276);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(195274);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(195274);
                }
              });
              AppMethodBeat.o(195276);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cC(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dta();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bt.flT();
          i = com.tencent.mm.ao.c.cA(aj.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new j(paramAnonymousc).aLk();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLk();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
            continue;
            paramAnonymousc = n.Fv(paramAnonymousd.fIT);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        ad.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yhR;
        if (localg.dnh == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Fi(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
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
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XO())
              {
                if (!bt.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                ad.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.Fg((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Fg((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIc();
                paramAnonymousString.gwQ = n.q(n.this);
                paramAnonymousString.hZg = ((dsz)n.p(n.this).hNK.hNQ);
                paramAnonymousString.hZh = localg;
                paramAnonymousString.gjI = n.z(n.this);
                paramAnonymousString.gwW = paramAnonymousd;
                paramAnonymousString.hZi = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(195275);
                    new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
                    ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.py((int)n.b(n.this));
                      k.pw((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEJ();
                      }
                      AppMethodBeat.o(195275);
                      return;
                    }
                    n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(195275);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJv().execute();
                break;
                paramAnonymousInt = localg.dnh;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.hZz == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
              paramAnonymousString = new dta();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xbt != 0L) {}
                for (l1 = paramAnonymousString.xbt;; l1 = paramAnonymousInt)
                {
                  ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hMP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.Fvn))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEJ();
                    }
                  }
                  AppMethodBeat.o(195276);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xbr;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEJ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(195277);
        Object localObject1 = (dsz)n.p(n.this).hNK.hNQ;
        rz localrz = new rz();
        localrz.FOw = ((dsz)localObject1).HFH.HoB;
        localrz.ukj = ((dsz)localObject1).Fvi.HoB;
        localrz.uki = ((dsz)localObject1).Fvj.HoB;
        localrz.FOx = ((dsz)localObject1).HFO;
        localrz.FOy = ((dsz)localObject1).HFP;
        localrz.Scene = n.A(n.this);
        localrz.FOA = n.B(n.this);
        localrz.FOB = n.C(n.this);
        localrz.FOC = n.D(n.this);
        localrz.Fvn = ((dsz)localObject1).Fvn;
        localrz.FOH = n.z(n.this);
        localrz.iht = ((dsz)localObject1).iht;
        localrz.Fss = ((dsz)localObject1).Fss;
        localrz.Fsu = ((dsz)localObject1).Fsu;
        localrz.Fst = ((dsz)localObject1).Fst;
        localrz.FOL = ((dsz)localObject1).FOL;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIF().o(((g)localObject1).hZw, "", "");
        com.tencent.mm.ao.f.aGJ();
        localrz.FOJ = com.tencent.mm.ao.a.EK((String)localObject2);
        localrz.FOK = ((g)localObject1).hZA;
        int i;
        label342:
        String str;
        if (localrz.FOK <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localrz.FOK = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localrz.tRT = 2;
            if (localrz.FOK == 3) {
              localrz.tRT = 4;
            }
            ad.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localrz.FOx), Integer.valueOf(localrz.FOy), localrz.Fvn, localrz.uki, localrz.FOH, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).hZw, localObject2, Integer.valueOf(localrz.FOJ), Integer.valueOf(localrz.FOK), Integer.valueOf(localrz.tRT) });
            paramAnonymousString = new com.tencent.mm.al.b.a();
            paramAnonymousString.hNM = localrz;
            paramAnonymousString.hNN = new dta();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hNO = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDC();
            localObject2 = n.F(n.this).aFc();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aEW()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aEW())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mO(1), ((com.tencent.mm.network.c)localObject2).aEV(), ((com.tencent.mm.network.c)localObject2).aEX(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localrz.FOw });
          AppMethodBeat.o(195277);
          return;
          i = 1;
          break;
          localrz.tRT = 1;
          break label342;
          localrz.tRT = 3;
          break label342;
          localrz.tRT = 5;
          break label342;
        }
        label744:
        ad.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
        return;
        label776:
        ad.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(195278);
        PInt localPInt = new PInt();
        sa localsa = new sa();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajB().gAO.hOv.aFc().mO(1), localPInt, localsa);
          ad.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsa.FOH, localsa.FAe, localsa.FOw });
          n.c(n.this, localsa.FOH);
          ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).setEnSendMsgActionFlag(localsa.FOM);
          ad.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsa.FOM) });
          ad.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(195278);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(195278);
        }
        return null;
      }
    };
    this.gwX = false;
    ad.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bt.flS() });
    this.iba = paramInt1;
    this.gwP = paramInt1;
    this.hZz = paramInt2;
    Object localObject1 = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject1).hNM = new dsz();
    ((com.tencent.mm.al.b.a)localObject1).hNN = new dta();
    ((com.tencent.mm.al.b.a)localObject1).uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    ((com.tencent.mm.al.b.a)localObject1).funcId = 110;
    ((com.tencent.mm.al.b.a)localObject1).hNO = 9;
    ((com.tencent.mm.al.b.a)localObject1).respCmdId = 1000000009;
    this.rr = ((com.tencent.mm.al.b.a)localObject1).aDC();
    this.iaZ = null;
    ad.d(this.TAG, "FROM B SERVICE:" + this.iba);
    if (!k.pv((int)this.iba))
    {
      this.iba = -1L;
      AppMethodBeat.o(150698);
      return;
    }
    localObject1 = q.aIF().c(Long.valueOf(this.iba));
    this.hZF = ((g)localObject1).hZF;
    if (paramInt2 == 1)
    {
      this.gwP = ((g)localObject1).hZH;
      localObject1 = q.aIF().c(Long.valueOf(this.gwP));
    }
    for (;;)
    {
      Object localObject2 = q.aIF().pu((int)((g)localObject1).dnz);
      if (localObject2 != null) {
        this.hZF = ((g)localObject2).hZF;
      }
      this.dku = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.hZF);
      if ((this.dku != null) && (this.dku.field_msgId != this.hZF))
      {
        ad.w(this.TAG, "init get msg by id failed:%d", new Object[] { Long.valueOf(this.hZF) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 206L, 1L, false);
        this.dku = null;
        AppMethodBeat.o(150698);
        return;
      }
      if (this.dku != null)
      {
        localObject2 = (dsz)this.rr.hNK.hNQ;
        ((dsz)localObject2).Fvi = new cwt().aPy(com.tencent.mm.model.u.aAm());
        ((dsz)localObject2).Fvj = new cwt().aPy(this.dku.field_talker);
        ((dsz)localObject2).xcL = ((g)localObject1).offset;
        ((dsz)localObject2).xcK = ((g)localObject1).hMP;
        ((dsz)localObject2).ugm = this.dku.getType();
        ((dsz)localObject2).GAB = paramInt2;
        if (!ae.cP(aj.getContext())) {
          break label880;
        }
      }
      label880:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dsz)localObject2).FYc = paramInt1;
        ((dsz)localObject2).HvF = ((g)localObject1).dnh;
        ((dsz)localObject2).FOK = ((g)localObject1).hZA;
        ((dsz)localObject2).FOK = ((g)localObject1).hZA;
        ((dsz)localObject2).HFO = this.dku.fks;
        ((dsz)localObject2).HFP = this.dku.fkr;
        a locala = h.Fi(this.dku.field_content);
        if ((locala != null) && (!bt.isNullOrNil(locala.appId)))
        {
          this.gwQ = ((g)localObject1).dnh;
          ((dsz)localObject2).iht = locala.appId;
          ((dsz)localObject2).Fss = locala.mediaTagName;
          ((dsz)localObject2).Fsu = locala.messageAction;
          ((dsz)localObject2).Fst = locala.messageExt;
          this.ibz = this.dku.field_content;
        }
        if (((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).ifAddTicketByActionFlag(this.dku.field_talker)) {
          ((dsz)localObject2).FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(this.dku.field_talker);
        }
        ad.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dsz)localObject2).HFO), Integer.valueOf(((dsz)localObject2).HFP) });
        ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(((g)localObject1).dnh), Integer.valueOf(((dsz)localObject2).FOK) });
        if (((g)localObject1).offset == 0) {
          this.ibd = new com.tencent.mm.modelstat.h(getType(), true, ((g)localObject1).hMP);
        }
        AppMethodBeat.o(150698);
        return;
      }
    }
  }
  
  public n(int paramInt1, int paramInt2, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(195284);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.ibt = "";
    this.ibu = "";
    this.ibv = true;
    this.ibx = 16384;
    this.hZz = 0;
    this.dku = null;
    this.ibd = null;
    this.ibe = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.giN = 0;
    this.iby = new a(null);
    this.ibG = false;
    this.ibI = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(195271);
        ad.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.py((int)n.b(n.this));
        k.pw((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEJ();
        }
        AppMethodBeat.o(195271);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(195272);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          ad.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195272);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(195272);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(195270);
        ad.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gjI, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iQl) });
        long l1 = paramAnonymousa.iQl;
        long l2 = bt.flT();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gjI;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nUg;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIF().o(localg.hZw, "", "");
        Object localObject2 = q.aIF().o(localg.hZx, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.i.aYo(q.aIF().o(localg.hZy, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.i.aYo((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iQl;
        com.tencent.mm.ao.f.aGJ();
        locald.field_filecrc = com.tencent.mm.ao.a.EK((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Fi((String)localObject2);
        if ((localObject1 != null) && (!bt.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bt.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.Fg((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Fg((String)localObject1);
            }
            localObject1 = c.aIc();
            ((c)localObject1).gwQ = n.q(n.this);
            ((c)localObject1).hZg = ((dsz)n.p(n.this).hNK.hNQ);
            ((c)localObject1).hZh = localg;
            ((c)localObject1).gjI = paramAnonymousa.EKS;
            ((c)localObject1).gwW = locald;
            ((c)localObject1).hZi = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(195269);
                ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.py((int)n.b(n.this));
                  k.pw((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEJ();
                  }
                  AppMethodBeat.o(195269);
                  return;
                }
                n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(195269);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJv().execute();
            AppMethodBeat.o(195270);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bw.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.hZz == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bt.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ibn = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195276);
        ad.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(195276);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bt.flT();
            i = com.tencent.mm.ao.c.cA(aj.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Fv(paramAnonymousd.fIT))
          {
            new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLk();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          com.tencent.mm.ao.f.aGI().EP(n.n(n.this));
          ad.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajF().ay(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(195273);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pm(0);
                n.m(n.this).qA(bj.Bo(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.ao.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dsz)n.p(n.this).hNK.hNQ;
                if (localObject == null) {
                  ad.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(195273);
                  return;
                  ((dsz)localObject).HFH = new cwt().aPy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(195276);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(195274);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(195274);
                }
              });
              AppMethodBeat.o(195276);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cC(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dta();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bt.flT();
          i = com.tencent.mm.ao.c.cA(aj.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new j(paramAnonymousc).aLk();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLk();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
            continue;
            paramAnonymousc = n.Fv(paramAnonymousd.fIT);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        ad.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yhR;
        if (localg.dnh == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Fi(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
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
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XO())
              {
                if (!bt.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                ad.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.Fg((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Fg((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIc();
                paramAnonymousString.gwQ = n.q(n.this);
                paramAnonymousString.hZg = ((dsz)n.p(n.this).hNK.hNQ);
                paramAnonymousString.hZh = localg;
                paramAnonymousString.gjI = n.z(n.this);
                paramAnonymousString.gwW = paramAnonymousd;
                paramAnonymousString.hZi = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(195275);
                    new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
                    ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.py((int)n.b(n.this));
                      k.pw((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEJ();
                      }
                      AppMethodBeat.o(195275);
                      return;
                    }
                    n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(195275);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJv().execute();
                break;
                paramAnonymousInt = localg.dnh;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.hZz == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
              paramAnonymousString = new dta();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xbt != 0L) {}
                for (l1 = paramAnonymousString.xbt;; l1 = paramAnonymousInt)
                {
                  ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hMP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.Fvn))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEJ();
                    }
                  }
                  AppMethodBeat.o(195276);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xbr;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEJ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(195277);
        Object localObject1 = (dsz)n.p(n.this).hNK.hNQ;
        rz localrz = new rz();
        localrz.FOw = ((dsz)localObject1).HFH.HoB;
        localrz.ukj = ((dsz)localObject1).Fvi.HoB;
        localrz.uki = ((dsz)localObject1).Fvj.HoB;
        localrz.FOx = ((dsz)localObject1).HFO;
        localrz.FOy = ((dsz)localObject1).HFP;
        localrz.Scene = n.A(n.this);
        localrz.FOA = n.B(n.this);
        localrz.FOB = n.C(n.this);
        localrz.FOC = n.D(n.this);
        localrz.Fvn = ((dsz)localObject1).Fvn;
        localrz.FOH = n.z(n.this);
        localrz.iht = ((dsz)localObject1).iht;
        localrz.Fss = ((dsz)localObject1).Fss;
        localrz.Fsu = ((dsz)localObject1).Fsu;
        localrz.Fst = ((dsz)localObject1).Fst;
        localrz.FOL = ((dsz)localObject1).FOL;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIF().o(((g)localObject1).hZw, "", "");
        com.tencent.mm.ao.f.aGJ();
        localrz.FOJ = com.tencent.mm.ao.a.EK((String)localObject2);
        localrz.FOK = ((g)localObject1).hZA;
        int i;
        label342:
        String str;
        if (localrz.FOK <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localrz.FOK = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localrz.tRT = 2;
            if (localrz.FOK == 3) {
              localrz.tRT = 4;
            }
            ad.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localrz.FOx), Integer.valueOf(localrz.FOy), localrz.Fvn, localrz.uki, localrz.FOH, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).hZw, localObject2, Integer.valueOf(localrz.FOJ), Integer.valueOf(localrz.FOK), Integer.valueOf(localrz.tRT) });
            paramAnonymousString = new com.tencent.mm.al.b.a();
            paramAnonymousString.hNM = localrz;
            paramAnonymousString.hNN = new dta();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hNO = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDC();
            localObject2 = n.F(n.this).aFc();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aEW()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aEW())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mO(1), ((com.tencent.mm.network.c)localObject2).aEV(), ((com.tencent.mm.network.c)localObject2).aEX(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localrz.FOw });
          AppMethodBeat.o(195277);
          return;
          i = 1;
          break;
          localrz.tRT = 1;
          break label342;
          localrz.tRT = 3;
          break label342;
          localrz.tRT = 5;
          break label342;
        }
        label744:
        ad.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
        return;
        label776:
        ad.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(195278);
        PInt localPInt = new PInt();
        sa localsa = new sa();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajB().gAO.hOv.aFc().mO(1), localPInt, localsa);
          ad.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsa.FOH, localsa.FAe, localsa.FOw });
          n.c(n.this, localsa.FOH);
          ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).setEnSendMsgActionFlag(localsa.FOM);
          ad.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsa.FOM) });
          ad.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(195278);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(195278);
        }
        return null;
      }
    };
    this.gwX = false;
    ad.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramg, bt.flS() });
    this.iba = paramInt1;
    this.gwP = paramInt1;
    this.hZz = paramInt2;
    paramg = new com.tencent.mm.al.b.a();
    paramg.hNM = new dsz();
    paramg.hNN = new dta();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
    paramg.funcId = 110;
    paramg.hNO = 9;
    paramg.respCmdId = 1000000009;
    this.rr = paramg.aDC();
    this.iaZ = null;
    ad.d(this.TAG, "FROM C SERVICE:" + this.iba);
    if (!k.pv((int)this.iba))
    {
      this.iba = -1L;
      AppMethodBeat.o(195284);
      return;
    }
    paramg = q.aIF().c(Long.valueOf(this.iba));
    this.hZF = paramg.hZF;
    paramg.setStatus(0);
    paramg.qz(0L);
    paramg.setOffset(0);
    q.aIF().a((int)this.gwP, paramg);
    if (paramInt2 == 1)
    {
      this.gwP = paramg.hZH;
      paramg = q.aIF().c(Long.valueOf(this.gwP));
    }
    for (;;)
    {
      this.dku = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.hZF);
      Object localObject;
      if (this.dku != null)
      {
        this.dku.setStatus(1);
        localObject = paramg.hZy;
        if ((localObject == null) || (!((String)localObject).startsWith("THUMBNAIL_DIRPATH://"))) {
          break label789;
        }
        this.dku.tO((String)localObject);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.hZF, this.dku);
        localObject = (dsz)this.rr.hNK.hNQ;
        ((dsz)localObject).Fvi = new cwt().aPy(com.tencent.mm.model.u.aAm());
        ((dsz)localObject).Fvj = new cwt().aPy(this.dku.field_talker);
        ((dsz)localObject).xcL = paramg.offset;
        ((dsz)localObject).xcK = paramg.hMP;
        ((dsz)localObject).ugm = this.dku.getType();
        ((dsz)localObject).GAB = paramInt2;
        if (!ae.cP(aj.getContext())) {
          break label819;
        }
      }
      label789:
      label819:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        ((dsz)localObject).FYc = paramInt1;
        ((dsz)localObject).HvF = paramg.dnh;
        ((dsz)localObject).FOK = paramg.hZA;
        ((dsz)localObject).HFO = this.dku.fks;
        ((dsz)localObject).HFP = this.dku.fkr;
        if (((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).ifAddTicketByActionFlag(this.dku.field_talker)) {
          ((dsz)localObject).FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(this.dku.field_talker);
        }
        ad.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(((dsz)localObject).HFO), Integer.valueOf(((dsz)localObject).HFP) });
        ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramg.dnh), Integer.valueOf(((dsz)localObject).FOK) });
        if (paramg.offset == 0) {
          this.ibd = new com.tencent.mm.modelstat.h(getType(), true, paramg.hMP);
        }
        AppMethodBeat.o(195284);
        return;
        this.dku.tO("THUMBNAIL://" + paramg.dnz);
        break;
      }
    }
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.al.g paramg)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, 0, "", "");
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.al.g paramg, int paramInt3, com.tencent.mm.al.k paramk, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, "", "", true, paramInt4);
    AppMethodBeat.i(195281);
    this.iby = new a(paramk);
    AppMethodBeat.o(195281);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.al.g paramg, int paramInt3, String paramString4, String paramString5)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, false, -1);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.al.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, 0L, null);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, com.tencent.mm.al.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4, long paramLong, String paramString6)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramg, paramInt3, paramString4, paramString5, paramBoolean, paramInt4, true, 0, -1000.0F, -1000.0F, -1L, paramLong, paramString6);
  }
  
  public n(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.al.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2, int paramInt5, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, String paramString6)
  {
    AppMethodBeat.i(195282);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.ibt = "";
    this.ibu = "";
    this.ibv = true;
    this.ibx = 16384;
    this.hZz = 0;
    this.dku = null;
    this.ibd = null;
    this.ibe = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.giN = 0;
    this.iby = new a(null);
    this.ibG = false;
    this.ibI = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(195271);
        ad.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.py((int)n.b(n.this));
        k.pw((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEJ();
        }
        AppMethodBeat.o(195271);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(195272);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          ad.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195272);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(195272);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(195270);
        ad.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gjI, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iQl) });
        long l1 = paramAnonymousa.iQl;
        long l2 = bt.flT();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gjI;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nUg;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIF().o(localg.hZw, "", "");
        Object localObject2 = q.aIF().o(localg.hZx, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.i.aYo(q.aIF().o(localg.hZy, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.i.aYo((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iQl;
        com.tencent.mm.ao.f.aGJ();
        locald.field_filecrc = com.tencent.mm.ao.a.EK((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Fi((String)localObject2);
        if ((localObject1 != null) && (!bt.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bt.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.Fg((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Fg((String)localObject1);
            }
            localObject1 = c.aIc();
            ((c)localObject1).gwQ = n.q(n.this);
            ((c)localObject1).hZg = ((dsz)n.p(n.this).hNK.hNQ);
            ((c)localObject1).hZh = localg;
            ((c)localObject1).gjI = paramAnonymousa.EKS;
            ((c)localObject1).gwW = locald;
            ((c)localObject1).hZi = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(195269);
                ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.py((int)n.b(n.this));
                  k.pw((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEJ();
                  }
                  AppMethodBeat.o(195269);
                  return;
                }
                n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(195269);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJv().execute();
            AppMethodBeat.o(195270);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bw.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.hZz == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bt.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ibn = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195276);
        ad.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(195276);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bt.flT();
            i = com.tencent.mm.ao.c.cA(aj.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Fv(paramAnonymousd.fIT))
          {
            new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLk();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          com.tencent.mm.ao.f.aGI().EP(n.n(n.this));
          ad.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajF().ay(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(195273);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pm(0);
                n.m(n.this).qA(bj.Bo(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.ao.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dsz)n.p(n.this).hNK.hNQ;
                if (localObject == null) {
                  ad.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(195273);
                  return;
                  ((dsz)localObject).HFH = new cwt().aPy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(195276);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(195274);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(195274);
                }
              });
              AppMethodBeat.o(195276);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cC(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dta();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bt.flT();
          i = com.tencent.mm.ao.c.cA(aj.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new j(paramAnonymousc).aLk();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLk();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
            continue;
            paramAnonymousc = n.Fv(paramAnonymousd.fIT);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        ad.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yhR;
        if (localg.dnh == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Fi(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
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
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XO())
              {
                if (!bt.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                ad.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.Fg((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Fg((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIc();
                paramAnonymousString.gwQ = n.q(n.this);
                paramAnonymousString.hZg = ((dsz)n.p(n.this).hNK.hNQ);
                paramAnonymousString.hZh = localg;
                paramAnonymousString.gjI = n.z(n.this);
                paramAnonymousString.gwW = paramAnonymousd;
                paramAnonymousString.hZi = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(195275);
                    new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
                    ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.py((int)n.b(n.this));
                      k.pw((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEJ();
                      }
                      AppMethodBeat.o(195275);
                      return;
                    }
                    n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(195275);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJv().execute();
                break;
                paramAnonymousInt = localg.dnh;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.hZz == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
              paramAnonymousString = new dta();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xbt != 0L) {}
                for (l1 = paramAnonymousString.xbt;; l1 = paramAnonymousInt)
                {
                  ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hMP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.Fvn))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEJ();
                    }
                  }
                  AppMethodBeat.o(195276);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xbr;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEJ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(195277);
        Object localObject1 = (dsz)n.p(n.this).hNK.hNQ;
        rz localrz = new rz();
        localrz.FOw = ((dsz)localObject1).HFH.HoB;
        localrz.ukj = ((dsz)localObject1).Fvi.HoB;
        localrz.uki = ((dsz)localObject1).Fvj.HoB;
        localrz.FOx = ((dsz)localObject1).HFO;
        localrz.FOy = ((dsz)localObject1).HFP;
        localrz.Scene = n.A(n.this);
        localrz.FOA = n.B(n.this);
        localrz.FOB = n.C(n.this);
        localrz.FOC = n.D(n.this);
        localrz.Fvn = ((dsz)localObject1).Fvn;
        localrz.FOH = n.z(n.this);
        localrz.iht = ((dsz)localObject1).iht;
        localrz.Fss = ((dsz)localObject1).Fss;
        localrz.Fsu = ((dsz)localObject1).Fsu;
        localrz.Fst = ((dsz)localObject1).Fst;
        localrz.FOL = ((dsz)localObject1).FOL;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIF().o(((g)localObject1).hZw, "", "");
        com.tencent.mm.ao.f.aGJ();
        localrz.FOJ = com.tencent.mm.ao.a.EK((String)localObject2);
        localrz.FOK = ((g)localObject1).hZA;
        int i;
        label342:
        String str;
        if (localrz.FOK <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localrz.FOK = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localrz.tRT = 2;
            if (localrz.FOK == 3) {
              localrz.tRT = 4;
            }
            ad.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localrz.FOx), Integer.valueOf(localrz.FOy), localrz.Fvn, localrz.uki, localrz.FOH, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).hZw, localObject2, Integer.valueOf(localrz.FOJ), Integer.valueOf(localrz.FOK), Integer.valueOf(localrz.tRT) });
            paramAnonymousString = new com.tencent.mm.al.b.a();
            paramAnonymousString.hNM = localrz;
            paramAnonymousString.hNN = new dta();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hNO = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDC();
            localObject2 = n.F(n.this).aFc();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aEW()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aEW())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mO(1), ((com.tencent.mm.network.c)localObject2).aEV(), ((com.tencent.mm.network.c)localObject2).aEX(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localrz.FOw });
          AppMethodBeat.o(195277);
          return;
          i = 1;
          break;
          localrz.tRT = 1;
          break label342;
          localrz.tRT = 3;
          break label342;
          localrz.tRT = 5;
          break label342;
        }
        label744:
        ad.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
        return;
        label776:
        ad.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(195278);
        PInt localPInt = new PInt();
        sa localsa = new sa();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajB().gAO.hOv.aFc().mO(1), localPInt, localsa);
          ad.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsa.FOH, localsa.FAe, localsa.FOw });
          n.c(n.this, localsa.FOH);
          ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).setEnSendMsgActionFlag(localsa.FOM);
          ad.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsa.FOM) });
          ad.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(195278);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(195278);
        }
        return null;
      }
    };
    this.gwX = false;
    ad.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramg, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), bt.flS(), Integer.valueOf(paramInt5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.ibB = paramBoolean1;
    this.ibh = paramInt4;
    this.iaZ = paramg;
    this.hZz = paramInt2;
    this.scene = paramInt5;
    this.dyz = paramFloat2;
    this.ibC = paramFloat1;
    this.gwQ = paramInt1;
    this.ibF = paramString3;
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    this.ibz = paramString4;
    localPString.value = paramString5;
    paramString5 = null;
    if (paramLong1 > 0L)
    {
      paramString5 = q.aIF().c(Long.valueOf(paramLong1));
      paramString5 = q.aIF().o(paramString5.hZB, "", "");
    }
    if (paramLong2 > 0L) {
      this.ibH = bl.Bt(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramLong2).eLs);
    }
    try
    {
      for (;;)
      {
        this.iba = q.aIF().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
        this.gwP = this.iba;
        ad.i(this.TAG, "FROM A UI :" + paramString2 + " " + this.iba);
        if ((!paramBoolean2) || ((this.iba >= 0L) && (k.pv((int)this.iba)))) {
          break;
        }
        ad.e(this.TAG, "insert to img storage failed id:" + this.iba);
        this.hZF = -1L;
        this.rr = null;
        AppMethodBeat.o(195282);
        return;
        if (!bt.isNullOrNil(paramString6)) {
          this.ibH = paramString6;
        }
      }
    }
    catch (SQLiteException paramString6)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 182L, 1L, false);
        if (!paramString6.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        q.aIF().aIm();
        ad.e(this.TAG, "fallback to insert");
        this.iba = q.aIF().a(paramString2, paramString3, paramString5, paramInt2, paramInt1, paramInt3, localPString, localPInt1, localPInt2);
      }
      AppMethodBeat.o(195282);
      throw paramString6;
    }
    if (this.iba >= 0L)
    {
      paramBoolean1 = true;
      Assert.assertTrue(paramBoolean1);
      paramString3 = new com.tencent.mm.al.b.a();
      paramString3.hNM = new dsz();
      paramString3.hNN = new dta();
      paramString3.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
      paramString3.funcId = 110;
      paramString3.hNO = 9;
      paramString3.respCmdId = 1000000009;
      this.rr = paramString3.aDC();
      this.dHz = paramString2;
      this.dku = new bu();
      this.dku.setType(com.tencent.mm.model.w.As(paramString2));
      this.dku.tN(paramString2);
      this.dku.kr(1);
      this.dku.setStatus(1);
      this.dku.tO(localPString.value);
      this.dku.kB(localPInt1.value);
      this.dku.kC(localPInt2.value);
      this.dku.qA(bj.Bo(this.dku.field_talker));
      this.dku.setContent(paramString4);
      a.a.ZG().n(this.dku);
    }
    label1640:
    label1646:
    label1651:
    for (;;)
    {
      try
      {
        this.hZF = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().c(this.dku, true);
        if (this.hZF >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          ad.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hZF);
          paramString3 = aIq();
          paramString3.sd((int)this.hZF);
          q.aIF().a(Long.valueOf(this.iba), paramString3);
          if (paramInt2 != 1) {
            break label1651;
          }
          this.gwP = paramString3.hZH;
          paramString3 = aIp();
          paramString3.pn((int)com.tencent.mm.vfs.i.aYo(q.aIF().o(paramString3.hZw, "", "")));
          q.aIF().a(Long.valueOf(this.gwP), paramString3);
          ad.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gwP + " img len = " + paramString3.hMP);
          paramString5 = (dsz)this.rr.hNK.hNQ;
          paramString5.Fvi = new cwt().aPy(paramString1);
          paramString5.Fvj = new cwt().aPy(paramString2);
          paramString5.xcL = paramString3.offset;
          paramString5.xcK = paramString3.hMP;
          paramString5.ugm = this.dku.getType();
          paramString5.GAB = paramInt2;
          if (!ae.cP(aj.getContext())) {
            break label1640;
          }
          paramInt3 = 1;
          paramString5.FYc = paramInt3;
          paramString5.HvF = paramString3.dnh;
          paramString5.FOK = paramString3.hZA;
          paramString5.HFO = localPInt2.value;
          paramString5.HFP = localPInt1.value;
          paramString1 = h.Fi(paramString4);
          if ((paramString1 != null) && (!bt.isNullOrNil(paramString1.appId)))
          {
            paramString5.iht = paramString1.appId;
            paramString5.Fss = paramString1.mediaTagName;
            paramString5.Fsu = paramString1.messageAction;
            paramString5.Fst = paramString1.messageExt;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).ifAddTicketByActionFlag(paramString2)) {
            paramString5.FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(paramString2);
          }
          ad.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString5.HFO), Integer.valueOf(paramString5.HFP) });
          if (paramString5.FOK == 0)
          {
            if (paramInt1 != 4) {
              break label1646;
            }
            paramInt1 = 2;
            paramString5.FOK = paramInt1;
          }
          ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.dnh), Integer.valueOf(paramString5.FOK) });
          if (paramString3.offset == 0) {
            this.ibd = new com.tencent.mm.modelstat.h(getType(), true, paramString3.hMP);
          }
          paramLong1 = System.currentTimeMillis();
          pz(paramInt2);
          ad.d(this.TAG, "hy: create HDThumb using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong1) });
          if (paramg != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150681);
                paramg.a(this.ibp, this.ibq, n.this);
                AppMethodBeat.o(150681);
              }
            });
          }
          AppMethodBeat.o(195282);
          return;
          paramBoolean1 = false;
        }
      }
      catch (SQLiteException paramString3)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 182L, 1L, false);
        if (paramString3.toString().contains("UNIQUE constraint failed"))
        {
          ad.e(this.TAG, "fallback to insert");
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().dlU();
          this.hZF = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().c(this.dku, true);
          continue;
        }
        AppMethodBeat.o(195282);
        throw paramString3;
      }
      paramBoolean1 = false;
      continue;
      paramInt3 = 2;
      continue;
      paramInt1 = 1;
    }
  }
  
  public n(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, final com.tencent.mm.al.g paramg, int paramInt3, String paramString4, String paramString5, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(195283);
    this.TAG = "MicroMsg.NetSceneUploadMsgImg";
    this.ibt = "";
    this.ibu = "";
    this.ibv = true;
    this.ibx = 16384;
    this.hZz = 0;
    this.dku = null;
    this.ibd = null;
    this.ibe = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.giN = 0;
    this.iby = new a(null);
    this.ibG = false;
    this.ibI = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(195271);
        ad.e(n.f(n.this), "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        k.py((int)n.b(n.this));
        k.pw((int)n.b(n.this));
        n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
        if (n.o(n.this) != null) {
          n.o(n.this).aEJ();
        }
        AppMethodBeat.o(195271);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(195272);
        g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          ad.e(n.f(n.this), "onUploadFailure, getImg fail, progress:%s, finishedLen:%s", new Object[] { Float.valueOf(paramAnonymousFloat), Long.valueOf(paramAnonymousLong) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -5, "", n.this);
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195272);
          return;
        }
        n.a(n.this, localg, (int)paramAnonymousLong, 0L, 0, null, null);
        AppMethodBeat.o(195272);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(195270);
        ad.i(n.f(n.this), "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gjI, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iQl) });
        long l1 = paramAnonymousa.iQl;
        long l2 = bt.flT();
        long l3 = n.j(n.this);
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(l2), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(l1), Long.valueOf(l1 / (l2 - l3)), Integer.valueOf(1) });
        final com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gjI;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nUg;
        final g localg = n.d(n.this);
        Object localObject1 = q.aIF().o(localg.hZw, "", "");
        Object localObject2 = q.aIF().o(localg.hZx, "", "");
        locald.field_thumbimgLength = ((int)com.tencent.mm.vfs.i.aYo(q.aIF().o(localg.hZy, "", "")));
        locald.field_midimgLength = ((int)com.tencent.mm.vfs.i.aYo((String)localObject2));
        locald.field_fileLength = paramAnonymousa.iQl;
        com.tencent.mm.ao.f.aGJ();
        locald.field_filecrc = com.tencent.mm.ao.a.EK((String)localObject1);
        localObject2 = n.l(n.this);
        localObject1 = h.Fi((String)localObject2);
        if ((localObject1 != null) && (!bt.isNullOrNil(((a)localObject1).appId))) {}
        for (localObject1 = h.d(((a)localObject1).appId, ((a)localObject1).mediaTagName, ((a)localObject1).messageExt, ((a)localObject1).messageAction);; localObject1 = "")
        {
          if (bt.isNullOrNil((String)localObject2))
          {
            localObject2 = "<msg><img aeskey=\"" + locald.field_aesKey + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + locald.field_fileId + "\" ";
            localObject2 = (String)localObject2 + "cdnthumburl=\"" + locald.field_fileId + "\" cdnthumbaeskey=\"" + locald.field_aesKey + "\" cdnthumblength=\"" + locald.field_thumbimgLength + "\" ";
            localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
            if (locald.field_midimgLength == 0)
            {
              l1 = locald.field_fileLength;
              localObject1 = l1 + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>";
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { localObject1 });
            }
          }
          for (;;)
          {
            localg.Fg((String)localObject1);
            n.a(n.this, (String)localObject1);
            if (n.b(n.this) != n.c(n.this)) {
              n.e(n.this).Fg((String)localObject1);
            }
            localObject1 = c.aIc();
            ((c)localObject1).gwQ = n.q(n.this);
            ((c)localObject1).hZg = ((dsz)n.p(n.this).hNK.hNQ);
            ((c)localObject1).hZh = localg;
            ((c)localObject1).gjI = paramAnonymousa.EKS;
            ((c)localObject1).gwW = locald;
            ((c)localObject1).hZi = new o.a()
            {
              public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
              {
                AppMethodBeat.i(195269);
                ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                {
                  k.py((int)n.b(n.this));
                  k.pw((int)n.b(n.this));
                  n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                  if (n.o(n.this) != null) {
                    n.o(n.this).aEJ();
                  }
                  AppMethodBeat.o(195269);
                  return;
                }
                n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, locald, paramAnonymous2String);
                AppMethodBeat.o(195269);
              }
            };
            ((o.e)localObject1).toUser = n.m(n.this).field_talker;
            ((o.e)localObject1).aJv().execute();
            AppMethodBeat.o(195270);
            return;
            l1 = locald.field_midimgLength;
            break;
            Map localMap = bw.M((String)localObject2, "msg");
            if (localMap != null)
            {
              if (localg.hZz == 0)
              {
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + locald.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
                localObject2 = new StringBuilder().append((String)localObject2).append("length=\"");
                if (locald.field_midimgLength == 0) {
                  l1 = locald.field_fileLength;
                }
              }
              label1030:
              for (localObject1 = l1 + "\" hdlength=\"" + bt.bI((String)localMap.get(".msg.img.$hdlength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\"/>" + (String)localObject1 + "</msg>";; localObject1 = (String)localObject2 + "length=\"" + (String)localMap.get(".msg.img.$length") + "\" hdlength=\"" + locald.field_fileLength + "\"/>" + (String)localObject1 + "</msg>")
              {
                ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { localObject1 });
                break;
                l1 = locald.field_midimgLength;
                break label1030;
                localObject2 = "<msg><img aeskey=\"" + bt.bI((String)localMap.get(".msg.img.$aeskey"), locald.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnmidimgurl"), locald.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnbigimgurl"), locald.field_fileId) + "\" ";
                localObject2 = (String)localObject2 + "cdnthumburl=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumburl"), locald.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)localMap.get(".msg.img.$cdnthumbaeskey"), locald.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)localMap.get(".msg.img.cdnthumblength"), new StringBuilder().append(locald.field_thumbimgLength).toString()) + "\" ";
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    };
    this.ibn = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195276);
        ad.d(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.w(n.f(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(195276);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        long l3;
        if (paramAnonymousInt != 0)
        {
          ad.e(n.f(n.this), "cdntra cdnCallback clientid:%s startRet:%d", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousInt) });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          if (paramAnonymousd != null)
          {
            l1 = n.j(n.this);
            l2 = bt.flT();
            i = com.tencent.mm.ao.c.cA(aj.getContext());
            j = n.k(n.this);
            l3 = paramAnonymousd.field_fileLength;
            paramAnonymousc = paramAnonymousd.field_transInfo;
            if (paramAnonymousd != null) {
              break label417;
            }
          }
          label417:
          for (paramAnonymousString = "";; paramAnonymousString = n.Fv(paramAnonymousd.fIT))
          {
            new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), paramAnonymousc, "", "", "", "", "", "", "", paramAnonymousString })).aLk();
            n.g(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        final g localg = n.d(n.this);
        if ((localg == null) || (localg.dnz != n.c(n.this)))
        {
          com.tencent.mm.ao.f.aGI().EP(n.n(n.this));
          ad.e(n.f(n.this), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[] { Long.valueOf(n.c(n.this)), n.n(n.this) });
          if (n.o(n.this) != null) {
            n.o(n.this).aEJ();
          }
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          n.a(n.this, localg, (int)paramAnonymousc.field_finishedLength, 0L, 0, paramAnonymousd, null);
          AppMethodBeat.o(195276);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i(n.f(n.this), "dkupimg sceneResult:%s", new Object[] { paramAnonymousd });
          if (paramAnonymousd.field_retCode == 0) {
            break label1308;
          }
          ad.e(n.f(n.this), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          if (paramAnonymousd.field_retCode == -21111)
          {
            ad.w(n.f(n.this), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[] { n.n(n.this), Boolean.valueOf(n.r(n.this)) });
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajF().ay(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(195273);
                n.s(n.this);
                n.t(n.this);
                n.u(n.this);
                Object localObject = n.d(n.this);
                ((g)localObject).pm(0);
                n.m(n.this).qA(bj.Bo(n.m(n.this).field_talker));
                n.b(n.this, com.tencent.mm.ao.c.a("upimg", n.m(n.this).field_createTime, n.m(n.this).field_talker, n.m(n.this).field_msgId + "_" + n.c(n.this) + "_" + n.h(n.this)));
                boolean bool = n.a(n.this, (g)localObject, 0, 0L, 0, paramAnonymousd, null);
                localObject = (dsz)n.p(n.this).hNK.hNQ;
                if (localObject == null) {
                  ad.w(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                }
                for (;;)
                {
                  ad.i(n.f(n.this), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[] { Boolean.valueOf(n.r(n.this)), Boolean.valueOf(bool), n.n(n.this), Long.valueOf(n.m(n.this).field_createTime) });
                  n.this.doScene(n.v(n.this), n.g(n.this));
                  AppMethodBeat.o(195273);
                  return;
                  ((dsz)localObject).HFH = new cwt().aPy(n.n(n.this));
                }
              }
            });
            AppMethodBeat.o(195276);
            return 0;
          }
          if (paramAnonymousd.field_retCode == -5103237)
          {
            ad.w(n.f(n.this), "upload hevc failed try jpg, %s", new Object[] { Boolean.valueOf(n.w(n.this)) });
            if (n.w(n.this))
            {
              com.tencent.mm.kernel.g.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(195274);
                  n.a(n.this, n.d(n.this));
                  AppMethodBeat.o(195274);
                }
              });
              AppMethodBeat.o(195276);
              return 0;
            }
          }
          paramAnonymousString = null;
          if (!bt.cC(paramAnonymousd.field_sKeyrespbuf)) {
            paramAnonymousString = new dta();
          }
        }
        Object localObject;
        try
        {
          paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
          ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = n.j(n.this);
          l2 = bt.flT();
          i = com.tencent.mm.ao.c.cA(aj.getContext());
          j = n.k(n.this);
          l3 = paramAnonymousd.field_fileLength;
          localObject = paramAnonymousd.field_transInfo;
          if (paramAnonymousd == null)
          {
            paramAnonymousc = "";
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l3), localObject, "", "", "", "", "", "", "", paramAnonymousc });
            new j(paramAnonymousc).aLk();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLk();
            if ((paramAnonymousString == null) || (paramAnonymousString.BaseResponse.Ret == 0)) {
              break label1281;
            }
            n.g(n.this).onSceneEnd(4, paramAnonymousString.BaseResponse.Ret, paramAnonymousString.BaseResponse.ErrMsg.toString(), n.this);
            if (n.o(n.this) != null) {
              n.o(n.this).aEJ();
            }
            AppMethodBeat.o(195276);
            return 0;
          }
        }
        catch (IOException paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
          }
        }
        catch (f.a.a.b paramAnonymousc)
        {
          for (;;)
          {
            paramAnonymousString = null;
            ad.e(n.f(n.this), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[] { paramAnonymousc });
            ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousc) });
            continue;
            paramAnonymousc = n.Fv(paramAnonymousd.fIT);
            continue;
            label1281:
            n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        label1308:
        ad.i(n.f(n.this), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousd.field_needSendMsgField) });
        paramAnonymousString = com.tencent.mm.plugin.report.service.g.yhR;
        if (localg.dnh == 0)
        {
          paramAnonymousInt = 3;
          label1361:
          paramAnonymousString.f(13230, new Object[] { Integer.valueOf(paramAnonymousInt), n.x(n.this), Integer.valueOf(paramAnonymousd.field_UploadHitCacheType) });
          paramAnonymousString = n.l(n.this);
          paramAnonymousc = h.Fi(paramAnonymousString);
          if ((paramAnonymousc == null) || (bt.isNullOrNil(paramAnonymousc.appId))) {
            break label3140;
          }
        }
        label2725:
        label3137:
        label3140:
        for (paramAnonymousc = h.d(paramAnonymousc.appId, paramAnonymousc.mediaTagName, paramAnonymousc.messageExt, paramAnonymousc.messageAction);; paramAnonymousc = "")
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
              ad.i(n.f(n.this), "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousString });
            }
          }
          for (;;)
          {
            for (;;)
            {
              localObject = paramAnonymousString;
              if (paramAnonymousd.XO())
              {
                if (!bt.isNullOrNil(n.y(n.this))) {
                  break label2553;
                }
                ad.w(n.f(n.this), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
              }
              for (localObject = paramAnonymousString;; localObject = paramAnonymousString + "length=\"" + paramAnonymousd.field_midimgLength + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
              {
                localg.Fg((String)localObject);
                n.a(n.this, (String)localObject);
                if (n.b(n.this) != n.c(n.this)) {
                  n.e(n.this).Fg((String)localObject);
                }
                if (!paramAnonymousd.field_needSendMsgField) {
                  break label2725;
                }
                paramAnonymousString = c.aIc();
                paramAnonymousString.gwQ = n.q(n.this);
                paramAnonymousString.hZg = ((dsz)n.p(n.this).hNK.hNQ);
                paramAnonymousString.hZh = localg;
                paramAnonymousString.gjI = n.z(n.this);
                paramAnonymousString.gwW = paramAnonymousd;
                paramAnonymousString.hZi = new o.a()
                {
                  public final void a(long paramAnonymous2Long, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(195275);
                    new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
                    ad.i(n.f(n.this), "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", new Object[] { n.n(n.this), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) });
                    if ((paramAnonymous2Int2 != 0) || (paramAnonymous2Int3 != 0))
                    {
                      k.py((int)n.b(n.this));
                      k.pw((int)n.b(n.this));
                      n.g(n.this).onSceneEnd(paramAnonymous2Int2, paramAnonymous2Int3, "", n.this);
                      if (n.o(n.this) != null) {
                        n.o(n.this).aEJ();
                      }
                      AppMethodBeat.o(195275);
                      return;
                    }
                    n.a(n.this, localg, localg.hMP, paramAnonymous2Long, paramAnonymous2Int1, paramAnonymousd, paramAnonymous2String);
                    AppMethodBeat.o(195275);
                  }
                };
                paramAnonymousString.toUser = n.m(n.this).field_talker;
                paramAnonymousString.aJv().execute();
                break;
                paramAnonymousInt = localg.dnh;
                break label1361;
                l1 = paramAnonymousd.field_midimgLength;
                break label1606;
                localObject = bw.M(paramAnonymousString, "msg");
                if (localObject == null) {
                  break label3137;
                }
                if (localg.hZz == 0)
                {
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                  paramAnonymousString = new StringBuilder().append(paramAnonymousString).append("length=\"");
                  if (paramAnonymousd.field_midimgLength == 0) {
                    l1 = paramAnonymousd.field_fileLength;
                  }
                }
                label2151:
                for (paramAnonymousString = l1 + "\" hdlength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$hdlength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\"/>" + paramAnonymousc + "</msg>";; paramAnonymousString = paramAnonymousString + "length=\"" + (String)((Map)localObject).get(".msg.img.$length") + "\" hdlength=\"" + paramAnonymousd.field_fileLength + "\"/>" + paramAnonymousc + "</msg>")
                {
                  ad.i(n.f(n.this), "cdn callback rebuild cdnInfo:%s", new Object[] { paramAnonymousString });
                  break;
                  l1 = paramAnonymousd.field_midimgLength;
                  break label2151;
                  paramAnonymousString = "<msg><img aeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$aeskey"), paramAnonymousd.field_aesKey) + "\" cdnmidimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"), paramAnonymousd.field_fileId) + "\" cdnbigimgurl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnbigimgurl"), paramAnonymousd.field_fileId) + "\" ";
                  paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumburl"), paramAnonymousd.field_fileId) + "\" cdnthumbaeskey=\"" + bt.bI((String)((Map)localObject).get(".msg.img.$cdnthumbaeskey"), paramAnonymousd.field_aesKey) + "\" cdnthumblength=\"" + bt.bI((String)((Map)localObject).get(".msg.img.cdnthumblength"), new StringBuilder().append(paramAnonymousd.field_thumbimgLength).toString()) + "\" ";
                }
                label2553:
                paramAnonymousString = "<msg><img aeskey=\"" + n.y(n.this) + "\" cdnmidimgurl=\"" + paramAnonymousd.field_fileId + "\" cdnbigimgurl=\"" + paramAnonymousd.field_fileId + "\" ";
                paramAnonymousString = paramAnonymousString + "cdnthumburl=\"" + paramAnonymousd.field_fileId + "\" cdnthumbaeskey=\"" + n.y(n.this) + "\" ";
              }
              new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(n.j(n.this)), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(n.k(n.this)), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", n.Fv(paramAnonymousd.fIT) })).aLk();
              paramAnonymousString = new dta();
              try
              {
                paramAnonymousString.parseFrom(paramAnonymousd.field_sKeyrespbuf);
                if (paramAnonymousString.xbt != 0L) {}
                for (l1 = paramAnonymousString.xbt;; l1 = paramAnonymousInt)
                {
                  ad.d(n.f(n.this), "parse skeyrespbuf: ret:%d,msg:%s", new Object[] { Integer.valueOf(paramAnonymousString.BaseResponse.Ret), paramAnonymousString.BaseResponse.ErrMsg.toString() });
                  if (n.a(n.this, localg, localg.hMP, l1, paramAnonymousString.CreateTime, paramAnonymousd, paramAnonymousString.Fvn))
                  {
                    n.g(n.this).onSceneEnd(0, 0, "", n.this);
                    if (n.o(n.this) != null) {
                      n.o(n.this).aEJ();
                    }
                  }
                  AppMethodBeat.o(195276);
                  return 0;
                  paramAnonymousInt = paramAnonymousString.xbr;
                }
                if (n.o(n.this) == null) {
                  break;
                }
              }
              catch (IOException paramAnonymousString)
              {
                ad.e(n.f(n.this), "UploadMsgImgResponse parse fail: %s", new Object[] { paramAnonymousString });
                ad.e(n.f(n.this), "exception:%s", new Object[] { bt.n(paramAnonymousString) });
                n.g(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
              }
            }
            n.o(n.this).aEJ();
            break;
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(195277);
        Object localObject1 = (dsz)n.p(n.this).hNK.hNQ;
        rz localrz = new rz();
        localrz.FOw = ((dsz)localObject1).HFH.HoB;
        localrz.ukj = ((dsz)localObject1).Fvi.HoB;
        localrz.uki = ((dsz)localObject1).Fvj.HoB;
        localrz.FOx = ((dsz)localObject1).HFO;
        localrz.FOy = ((dsz)localObject1).HFP;
        localrz.Scene = n.A(n.this);
        localrz.FOA = n.B(n.this);
        localrz.FOB = n.C(n.this);
        localrz.FOC = n.D(n.this);
        localrz.Fvn = ((dsz)localObject1).Fvn;
        localrz.FOH = n.z(n.this);
        localrz.iht = ((dsz)localObject1).iht;
        localrz.Fss = ((dsz)localObject1).Fss;
        localrz.Fsu = ((dsz)localObject1).Fsu;
        localrz.Fst = ((dsz)localObject1).Fst;
        localrz.FOL = ((dsz)localObject1).FOL;
        localObject1 = n.d(n.this);
        Object localObject2 = q.aIF().o(((g)localObject1).hZw, "", "");
        com.tencent.mm.ao.f.aGJ();
        localrz.FOJ = com.tencent.mm.ao.a.EK((String)localObject2);
        localrz.FOK = ((g)localObject1).hZA;
        int i;
        label342:
        String str;
        if (localrz.FOK <= 0)
        {
          if (n.q(n.this) == 4)
          {
            i = 2;
            localrz.FOK = i;
          }
        }
        else {
          switch (n.q(n.this))
          {
          case 3: 
          case 5: 
          default: 
            localrz.tRT = 2;
            if (localrz.FOK == 3) {
              localrz.tRT = 4;
            }
            ad.i(n.f(n.this), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[] { paramAnonymousString, Integer.valueOf(localrz.FOx), Integer.valueOf(localrz.FOy), localrz.Fvn, localrz.uki, localrz.FOH, Long.valueOf(n.c(n.this)), Long.valueOf(n.E(n.this)), ((g)localObject1).hZw, localObject2, Integer.valueOf(localrz.FOJ), Integer.valueOf(localrz.FOK), Integer.valueOf(localrz.tRT) });
            paramAnonymousString = new com.tencent.mm.al.b.a();
            paramAnonymousString.hNM = localrz;
            paramAnonymousString.hNN = new dta();
            paramAnonymousString.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
            paramAnonymousString.funcId = 625;
            paramAnonymousString.hNO = 9;
            paramAnonymousString.respCmdId = 1000000009;
            localObject1 = paramAnonymousString.aDC();
            localObject2 = n.F(n.this).aFc();
            str = n.f(n.this);
            if (localObject2 != null) {
              break;
            }
          }
        }
        for (paramAnonymousString = "acc == null";; paramAnonymousString = Boolean.valueOf(((com.tencent.mm.network.c)localObject2).aEW()))
        {
          ad.i(str, "getCdnAuthInfo login:%s", new Object[] { paramAnonymousString });
          if ((localObject2 == null) || (!((com.tencent.mm.network.c)localObject2).aEW())) {
            break label776;
          }
          if (!com.tencent.mm.al.u.a(((com.tencent.mm.network.c)localObject2).mO(1), ((com.tencent.mm.network.c)localObject2).aEV(), ((com.tencent.mm.network.c)localObject2).aEX(), ((com.tencent.mm.al.b)localObject1).getReqObj(), paramAnonymousByteArrayOutputStream, ((com.tencent.mm.network.c)localObject2).isForeground())) {
            break label744;
          }
          ad.d(n.f(n.this), "getCdnAuthInfo successed.clientimgid:%s", new Object[] { localrz.FOw });
          AppMethodBeat.o(195277);
          return;
          i = 1;
          break;
          localrz.tRT = 1;
          break label342;
          localrz.tRT = 3;
          break label342;
          localrz.tRT = 5;
          break label342;
        }
        label744:
        ad.e(n.f(n.this), "getCdnAuthInfo failed. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
        return;
        label776:
        ad.e(n.f(n.this), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[] { localrz.FOw });
        AppMethodBeat.o(195277);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(195278);
        PInt localPInt = new PInt();
        sa localsa = new sa();
        try
        {
          paramAnonymousArrayOfByte = com.tencent.mm.al.w.a(paramAnonymousArrayOfByte, com.tencent.mm.kernel.g.ajB().gAO.hOv.aFc().mO(1), localPInt, localsa);
          ad.i(n.f(n.this), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[] { localsa.FOH, localsa.FAe, localsa.FOw });
          n.c(n.this, localsa.FOH);
          ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).setEnSendMsgActionFlag(localsa.FOM);
          ad.i(n.f(n.this), "prepareResponse.ActionFlag:%s", new Object[] { Integer.valueOf(localsa.FOM) });
          ad.i(n.f(n.this), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[] { paramAnonymousString, Integer.valueOf(localPInt.value) });
          AppMethodBeat.o(195278);
          return paramAnonymousArrayOfByte;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e(n.f(n.this), "decodePrepareResponse Exception:%s", new Object[] { paramAnonymousString });
          n.c(n.this, null);
          AppMethodBeat.o(195278);
        }
        return null;
      }
    };
    this.gwX = false;
    ad.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, Integer.valueOf(paramInt2), paramg, Integer.valueOf(paramInt3), paramString4, paramString5, Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean2), bt.flS() });
    this.ibB = paramBoolean1;
    this.ibh = paramInt4;
    this.iaZ = paramg;
    this.hZz = paramInt2;
    this.gwQ = paramInt1;
    this.ibF = paramString3;
    paramString5 = new PInt();
    PInt localPInt = new PInt();
    this.ibz = paramString4;
    this.iba = paramLong;
    this.gwP = this.iba;
    paramString3 = aIq();
    this.dku = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramString3.hZF);
    this.hZF = this.dku.field_msgId;
    localPInt.value = this.dku.fks;
    paramString5.value = this.dku.fkr;
    if (paramInt2 == 1)
    {
      this.gwP = paramString3.hZH;
      this.gwR = null;
      paramString3 = aIp();
    }
    for (;;)
    {
      if ((this.dku.field_talker != null) && (!this.dku.field_talker.equals(paramString2)))
      {
        ad.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString2, this.dku.field_talker });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(594L, 4L, 1L, true);
      }
      for (paramString4 = this.dku.field_talker;; paramString4 = paramString2)
      {
        ad.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.dku.field_msgId);
        ad.d(this.TAG, "FROM A UI :" + paramString2 + "   msg:" + paramString4 + this.iba);
        if ((paramBoolean2) && ((this.iba < 0L) || (!k.pv((int)this.iba))))
        {
          ad.e(this.TAG, "insert to img storage failed id:" + this.iba);
          this.hZF = -1L;
          this.rr = null;
          AppMethodBeat.o(195283);
          return;
        }
        if (this.iba >= 0L)
        {
          paramBoolean1 = true;
          Assert.assertTrue(paramBoolean1);
          paramString2 = new com.tencent.mm.al.b.a();
          paramString2.hNM = new dsz();
          paramString2.hNN = new dta();
          paramString2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
          paramString2.funcId = 110;
          paramString2.hNO = 9;
          paramString2.respCmdId = 1000000009;
          this.rr = paramString2.aDC();
          ad.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gwP + " img len = " + paramString3.hMP);
          paramString2 = (dsz)this.rr.hNK.hNQ;
          paramString2.Fvi = new cwt().aPy(paramString1);
          paramString2.Fvj = new cwt().aPy(paramString4);
          paramString2.xcL = paramString3.offset;
          paramString2.xcK = paramString3.hMP;
          paramString2.ugm = this.dku.getType();
          paramString2.GAB = paramInt2;
          if (!ae.cP(aj.getContext())) {
            break label1112;
          }
          paramInt2 = 1;
          label856:
          paramString2.FYc = paramInt2;
          paramString2.HvF = paramString3.dnh;
          paramString2.FOK = paramString3.hZA;
          paramString2.HFO = localPInt.value;
          paramString2.HFP = paramString5.value;
          ad.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[] { Integer.valueOf(paramString2.HFO), Integer.valueOf(paramString2.HFP) });
          if (paramString2.FOK == 0) {
            if (paramInt1 != 4) {
              break label1118;
            }
          }
        }
        label1112:
        label1118:
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString2.FOK = paramInt1;
          if (((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).ifAddTicketByActionFlag(paramString4)) {
            paramString2.FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(paramString4);
          }
          ad.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[] { Integer.valueOf(paramString3.dnh), Integer.valueOf(paramString2.FOK) });
          if (paramString3.offset == 0) {
            this.ibd = new com.tencent.mm.modelstat.h(getType(), true, paramString3.hMP);
          }
          if (paramg != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150682);
                paramg.a(this.ibp, this.ibq, n.this);
                AppMethodBeat.o(150682);
              }
            });
          }
          AppMethodBeat.o(195283);
          return;
          paramBoolean1 = false;
          break;
          paramInt2 = 2;
          break label856;
        }
      }
    }
  }
  
  public static String Fv(String paramString)
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
        long l = ibJ;
        ibJ = -1L;
        localObject[19] = l;
        localObject = bt.m(bt.U((String[])localObject), ",");
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
    String str3 = this.dku.field_talker;
    if (com.tencent.mm.model.w.Aq(str3))
    {
      ad.w(this.TAG, "cdntra not use cdn user:%s", new Object[] { str3 });
      AppMethodBeat.o(150700);
      return false;
    }
    if (!com.tencent.mm.pluginsdk.f.b.eZi())
    {
      ad.i(this.TAG, "isAllow2UseCdnWithXLab = false");
      AppMethodBeat.o(150700);
      return false;
    }
    com.tencent.mm.ao.f.aGI();
    if ((!com.tencent.mm.ao.b.pa(1)) && (bt.isNullOrNil(paramg.hZI)))
    {
      localObject = this.TAG;
      com.tencent.mm.ao.f.aGI();
      ad.w((String)localObject, "cdntra not use cdn flag:%b getCdnInfo:%s", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.pa(1)), paramg.hZI });
      AppMethodBeat.o(150700);
      return false;
    }
    if (bt.isNullOrNil(this.ibe))
    {
      ad.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gwP) });
      AppMethodBeat.o(150700);
      return false;
    }
    String str2 = q.aIF().o(paramg.hZw, "", "");
    String str1 = q.aIF().o(paramg.hZx, "", "");
    String str4 = q.aIF().o(paramg.hZy, "", "");
    Object localObject = q.aIF().o(paramg.hZB, "", "");
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJi = "task_NetSceneUploadMsgImg";
    localg.fJj = this.ibn;
    localg.field_mediaId = this.ibe;
    localg.field_fileType = this.giN;
    localg.field_talker = str3;
    int i;
    boolean bool1;
    if (com.tencent.mm.model.w.vF(str3))
    {
      i = 1;
      localg.field_chattype = i;
      localg.field_priority = com.tencent.mm.i.a.fIw;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      if (am.ail(this.dku.field_talker)) {
        break label1009;
      }
      bool1 = true;
      label351:
      localg.field_sendmsg_viacdn = bool1;
      if ((am.ail(this.dku.field_talker)) || (!this.ibv)) {
        break label1015;
      }
      bool1 = true;
      label381:
      localg.field_enable_hitcheck = bool1;
      localg.field_force_aeskeycdn = false;
      localg.field_trysafecdn = true;
      ad.i(this.TAG, "field_sendmsg_viacdn=%s talker=%s", new Object[] { Boolean.valueOf(localg.field_sendmsg_viacdn), str3 });
      if (paramInt != -5103237) {
        break label1021;
      }
      this.ibe = com.tencent.mm.ao.c.a("upimgjpg", this.dku.field_createTime, str3, this.dku.field_msgId + "_" + this.gwP + "_" + this.hZz);
      localg.field_fullpath = str2;
      localg.field_thumbpath = str4;
      localg.field_midimgpath = str1;
      localg.lastError = paramInt;
      localg.field_mediaId = this.ibe;
      this.ibG = false;
      if (!this.ibG)
      {
        bool1 = t.aQk(str4);
        ad.i(this.TAG, "checkUseCdn: use jpg, thumbIsHevc %s", new Object[] { Boolean.valueOf(bool1) });
      }
      if ((localg.field_fileType == com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE) && (bt.isNullOrNil(localg.field_midimgpath)))
      {
        com.tencent.mm.ao.f.aGI();
        if (com.tencent.mm.ao.b.pa(256))
        {
          ad.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
          localg.field_force_aeskeycdn = true;
          localg.field_trysafecdn = false;
        }
      }
      localObject = bw.M(this.ibz, "msg");
      if (localObject == null) {
        break label1378;
      }
      if (this.hZz == 1) {
        break label1329;
      }
      localg.field_fileId = ((String)((Map)localObject).get(".msg.img.$cdnmidimgurl"));
      localg.field_midFileLength = bt.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      label707:
      localg.field_aesKey = ((String)((Map)localObject).get(".msg.img.$aeskey"));
    }
    for (;;)
    {
      if ((bt.isNullOrNil(localg.field_aesKey)) || ("null".equalsIgnoreCase(localg.field_aesKey)))
      {
        com.tencent.mm.ao.f.aGJ();
        localg.field_aesKey = com.tencent.mm.ao.a.aGz();
        ad.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[] { localg.field_aesKey });
      }
      ad.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[] { Integer.valueOf(paramg.dnh), localg.field_fileId });
      this.ibt = localg.field_fileId;
      this.ibu = localg.field_aesKey;
      ad.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[] { Boolean.valueOf(localg.field_enable_hitcheck), Integer.valueOf(localg.field_fileType), localg.field_midimgpath, localg.field_fullpath, localg.field_aesKey, localg.field_fileId, Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn) });
      this.ibE = null;
      if (com.tencent.mm.ao.f.aGI().f(localg)) {
        break label1402;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 205L, 1L, false);
      ad.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.ibe });
      this.ibe = "";
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
      boolean bool2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cfM();
      boolean bool3;
      if ((this.gwQ == 4) && (com.tencent.mm.vfs.i.fv((String)localObject)))
      {
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(str1);
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
        this.ibG = bool1;
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
        ad.d((String)localObject, "hevc upload full size %b, use hevc %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        break;
        str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(str2);
        bool1 = t.aQl(str2).equals(".png");
        if ((this.hZz == 0) && (!bool1) && (bo(str2, str3))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          localObject = str3;
          if (!bool1) {
            break;
          }
          paramg.Fh(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(paramg.hZw));
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
      localg.field_midFileLength = bt.getInt((String)((Map)localObject).get(".msg.img.$length"), 0);
      localg.field_totalLen = 0;
      break label707;
      label1378:
      ad.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.hZI });
    }
    label1402:
    if (bt.nullAsNil(paramg.hZI).length() <= 0)
    {
      paramg.Fg("CDNINFO_SEND");
      paramg.dDp = 4096;
    }
    AppMethodBeat.o(150700);
    return true;
  }
  
  private boolean a(g paramg, int paramInt1, long paramLong, int paramInt2, com.tencent.mm.i.d paramd, String paramString)
  {
    AppMethodBeat.i(169189);
    ad.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[] { this.ibe, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    ad.i(this.TAG, "dkmsgid  set svrmsgid %d -> %d  oriImgLocalId %s imgLocalId %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(ac.iOO), Long.valueOf(this.iba), Long.valueOf(this.gwP) });
    long l = paramLong;
    if (10007 == ac.iON)
    {
      l = paramLong;
      if (ac.iOO != 0)
      {
        l = ac.iOO;
        ac.iOO = 0;
      }
    }
    b(paramg.dnz, paramInt1, paramg.hMP);
    paramg.setOffset(paramInt1);
    paramg.qz(l);
    g localg;
    if (h.b(paramg))
    {
      if (this.iba == this.gwP) {
        break label498;
      }
      localg = q.aIF().c(Long.valueOf(this.iba));
      localg.qz(l);
      localg.pn(paramg.hMP);
      localg.setOffset(paramg.hMP);
      q.aIF().a(Long.valueOf(this.iba), localg);
    }
    while (h.b(paramg))
    {
      if (bt.isNullOrNil(this.ibe)) {
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.giN), Integer.valueOf(paramg.hMP - this.startOffset) });
      }
      this.dku.setStatus(2);
      this.dku.qz(l);
      this.dku.sP(paramString);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.hZF, this.dku);
      if (com.tencent.mm.modelstat.r.irp != null) {
        com.tencent.mm.modelstat.r.irp.q(this.dku);
      }
      if (this.ibd != null) {
        this.ibd.so(0L);
      }
      if (u.icQ != null) {
        u.icQ.a(this.gwP, this.dku, this.rr, this.gwQ, this.gwX, paramd);
      }
      if (this.iby != null) {
        this.iby.aEJ();
      }
      this.callback.onSceneEnd(0, 0, "", this);
      k.pw((int)this.iba);
      AppMethodBeat.o(169189);
      return false;
      label498:
      localg = q.aIF().c(Long.valueOf(paramg.dnz));
      localg.qz(l);
      localg.pn(paramg.hMP);
      localg.setOffset(paramg.hMP);
      q.aIF().a(Long.valueOf(localg.dnz), localg);
    }
    AppMethodBeat.o(169189);
    return true;
  }
  
  private g aIp()
  {
    AppMethodBeat.i(150692);
    if (this.gwR == null) {
      this.gwR = q.aIF().c(Long.valueOf(this.gwP));
    }
    g localg = this.gwR;
    AppMethodBeat.o(150692);
    return localg;
  }
  
  private g aIq()
  {
    AppMethodBeat.i(150693);
    if (this.ibw == null) {
      this.ibw = q.aIF().c(Long.valueOf(this.iba));
    }
    g localg = this.ibw;
    AppMethodBeat.o(150693);
    return localg;
  }
  
  private void b(final long paramLong, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150707);
    if (this.iaZ != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195279);
          p localp = p.aIt();
          long l1 = paramLong;
          long l2 = paramInt1;
          long l3 = this.ibP;
          if (localp.ibS.containsKey(Long.valueOf(l1))) {}
          for (p.d locald = (p.d)localp.ibS.get(Long.valueOf(l1));; locald = new p.d())
          {
            locald.offset = l3;
            locald.dyS = l2;
            localp.ibS.put(Long.valueOf(l1), locald);
            n.G(n.this).a(this.ibP, paramInt1, n.this);
            AppMethodBeat.o(195279);
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
    if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cfM())
    {
      AppMethodBeat.o(150701);
      return false;
    }
    if (com.tencent.mm.vfs.i.aYo(paramString1) > 0L)
    {
      if (com.tencent.mm.vfs.i.aYo(paramString2) > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(944, 9);
        com.tencent.mm.vfs.i.deleteFile(paramString2);
      }
      if (!com.tencent.mm.vfs.i.fv(paramString2)) {
        com.tencent.mm.vfs.i.aYs(paramString2);
      }
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fs(paramString1, paramString2) == 0)
      {
        AppMethodBeat.o(150701);
        return true;
      }
      ad.w(this.TAG, "file to hevc failed %s", new Object[] { paramString1 });
    }
    AppMethodBeat.o(150701);
    return false;
  }
  
  private int pA(int paramInt)
  {
    AppMethodBeat.i(150703);
    ad.e(this.TAG, "do Scene error code : " + paramInt + " hashcode : " + hashCode());
    if (this.iby != null) {
      this.iby.aEJ();
    }
    AppMethodBeat.o(150703);
    return -1;
  }
  
  public static void sg(long paramLong)
  {
    ibJ = paramLong;
  }
  
  public final bu aIr()
  {
    AppMethodBeat.i(195280);
    if (this.dku == null) {
      ad.e(this.TAG, "msg is null. %s", new Object[] { bt.flS() });
    }
    bu localbu = this.dku;
    AppMethodBeat.o(195280);
    return localbu;
  }
  
  public final void aIs()
  {
    AppMethodBeat.i(150705);
    ad.i(this.TAG, "send img from system");
    this.gwX = true;
    AppMethodBeat.o(150705);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(150702);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150690);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().apT("SendImgSpeeder");
        AppMethodBeat.o(150690);
      }
    }, 100L);
    if (this.gwP < 0L)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 204L, 1L, false);
      ad.e(this.TAG, "doScene invalid imgLocalId:" + this.gwP);
      i = pA(-1);
      AppMethodBeat.o(150702);
      return i;
    }
    if (this.dku == null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 203L, 1L, false);
      ad.e(this.TAG, "doScene msg is null imgid:%d", new Object[] { Long.valueOf(this.gwP) });
      k.py((int)this.iba);
      i = pA(-2);
      AppMethodBeat.o(150702);
      return i;
    }
    this.callback = paramf;
    prepareDispatcher(parame);
    dsz localdsz = (dsz)this.rr.hNK.hNQ;
    g localg = aIp();
    paramf = q.aIF().pu((int)localg.dnz);
    if (paramf != null)
    {
      if (paramf.status == -1)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 202L, 1L, false);
        ad.e(this.TAG, "doScene hd img info is null or error.");
        i = pA(-3);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else if ((localg == null) || (localg.status == -1))
    {
      ad.e(this.TAG, "doScene img info is null or error.");
      i = pA(-4);
      AppMethodBeat.o(150702);
      return i;
    }
    String str1;
    if (a.a.ZG().vd(this.dku.field_talker))
    {
      localdsz.Fvn = a.a.ZG().o(this.dku);
      ad.i(this.TAG, "upload img msg source %s", new Object[] { localdsz.Fvn });
      str1 = q.aIF().o(localg.hZw, "", "");
      paramf = q.aIF().o(localg.hZy, "", "");
      if (!bt.isNullOrNil(localg.hZx)) {
        q.aIF().o(localg.hZx, "", "");
      }
      if ((com.tencent.mm.vfs.i.aYo(str1) <= 0L) || (com.tencent.mm.vfs.i.aYo(paramf) <= 0L))
      {
        ad.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[] { Long.valueOf(this.gwP), Long.valueOf(com.tencent.mm.vfs.i.aYo(str1)), Long.valueOf(com.tencent.mm.vfs.i.aYo(paramf)), str1, paramf });
        i = pA(-5);
        AppMethodBeat.o(150702);
        return i;
      }
    }
    else
    {
      if (bt.isNullOrNil(this.ibH))
      {
        paramf = com.tencent.mm.vfs.i.aPK(this.ibF);
        localObject = v.iNJ;
        this.ibH = v.IV(paramf);
      }
      if (!bt.isNullOrNil(this.ibH)) {}
      for (paramf = bl.Bu(this.ibH);; paramf = bl.VW())
      {
        if (((paramf != null) && (!paramf.equals(this.dku.eLs))) || ((paramf == null) && (!bt.isNullOrNil(this.dku.eLs))))
        {
          this.dku.sP(paramf);
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.dku.field_msgId, this.dku);
        }
        localdsz.Fvn = this.dku.eLs;
        break;
      }
    }
    if ((localdsz.HFH == null) || (bt.isNullOrNil(localdsz.HFH.HoB)))
    {
      if (bt.isNullOrNil(this.ibe))
      {
        ad.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[] { Long.valueOf(this.dku.field_createTime), this.dku.field_talker, Long.valueOf(this.dku.field_msgId), Long.valueOf(this.gwP), Integer.valueOf(this.hZz) });
        this.ibe = com.tencent.mm.ao.c.a("upimg", this.dku.field_createTime, this.dku.field_talker, this.dku.field_msgId + "_" + this.gwP + "_" + this.hZz);
      }
      localdsz.HFH = new cwt().aPy(this.ibe);
      paramf = this.dku;
      paramf.fkx = this.ibe;
      paramf.eKU = true;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.flT();
      this.startOffset = localg.offset;
      if (this.hZz != 1) {
        break label940;
      }
    }
    label940:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.giN = i;
      if (!a(localg, 0)) {
        break;
      }
      ad.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { localdsz.HFH.HoB });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (am.ail(this.dHz))
    {
      ad.w(this.TAG, "just return without using cdn for finder. %s", new Object[] { this.dHz });
      k.py((int)this.iba);
      i = pA(-99);
      AppMethodBeat.o(150702);
      return i;
    }
    if (com.tencent.mm.n.g.acA().getInt("UploadMsgImgType", 0) == 1) {}
    for (boolean bool1 = true; com.tencent.mm.model.w.Aq(this.dku.field_talker); bool1 = false)
    {
      ad.w(this.TAG, "cdntra not use parallel-upload user:%s", new Object[] { this.dku.field_talker });
      i = 0;
      if (i == 0) {
        break label1489;
      }
      ad.d(this.TAG, "cdntra use parallel-upload return -1 for onGYNetEnd clientid:%s", new Object[] { localdsz.HFH.HoB });
      AppMethodBeat.o(150702);
      return 0;
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHt, 1)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label1148;
      }
      ad.i(this.TAG, "NOT ALLOW USE PARALLEL UPLOAD IMG");
      i = 0;
      break;
    }
    label1148:
    Object localObject = q.aIF().o(localg.hZw, "", "");
    String str2 = q.aIF().o(localg.hZy, "", "");
    paramf = q.aIF().o(localg.hZx, "", "");
    boolean bool2 = bt.isNullOrNil(paramf);
    if (bool2) {
      paramf = (com.tencent.mm.al.f)localObject;
    }
    for (;;)
    {
      String str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(paramf);
      String str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe((String)localObject);
      com.tencent.mm.pluginsdk.f.d locald = new com.tencent.mm.pluginsdk.f.d();
      locald.hZF = this.hZF;
      locald.EKE = this.ibI;
      locald.scene = 1;
      locald.fileType = 2;
      if (!bool2) {
        locald.fileType = 1;
      }
      String str5;
      if ((bool1) && (this.hZz == 0))
      {
        localg.Fh(str4);
        str5 = q.aIF().o(localg.hZB, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fs((String)localObject, str5);
        if (i != 0) {
          break label1480;
        }
        localg.pq(1);
        localg.pn((int)com.tencent.mm.vfs.i.aYo(str5));
      }
      for (;;)
      {
        ad.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.gwP), str5, Integer.valueOf(i), Integer.valueOf(localg.hMP) });
        locald.thumbPath = str2;
        locald.hZx = paramf;
        locald.EKG = str3;
        locald.hdP = ((String)localObject);
        locald.EKF = str4;
        paramf = new com.tencent.mm.pluginsdk.f.c();
        paramf.EKB = bool1;
        paramf.a(locald);
        i = 1;
        break;
        label1480:
        localg.pq(0);
      }
      label1489:
      if ((bool1) && (this.hZz == 0))
      {
        localg.Fh(((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(localg.hZw));
        paramf = q.aIF().o(localg.hZB, "", "");
        i = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).fs(str1, paramf);
        if (i != 0) {
          break label1693;
        }
        localg.pq(1);
        localg.pn((int)com.tencent.mm.vfs.i.aYo(paramf));
      }
      for (;;)
      {
        ad.i(this.TAG, "upload c2c cgi img use wxa %s %s %s %s", new Object[] { Long.valueOf(this.gwP), paramf, Integer.valueOf(i), Integer.valueOf(localg.hMP) });
        i = localg.hZG;
        if (i < securityLimitCount()) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 201L, 1L, false);
        ad.e(this.TAG, "doScene limit net time:".concat(String.valueOf(i)));
        k.py((int)this.iba);
        i = pA(-6);
        AppMethodBeat.o(150702);
        return i;
        label1693:
        localg.pq(0);
      }
      localg.pm(i + 1);
      localg.dDp = 512;
      q.aIF().a(Long.valueOf(this.gwP), localg);
      int j = localg.hMP - localg.offset;
      i = j;
      if (j > this.ibx) {
        i = this.ibx;
      }
      com.tencent.mm.vfs.i.aYo(str1);
      if (localg.hZC == 1) {}
      for (paramf = q.aIF().o(localg.hZB, "", "");; paramf = q.aIF().o(localg.hZw, "", ""))
      {
        paramf = com.tencent.mm.vfs.i.aY(paramf, localg.offset, i);
        if ((paramf != null) && (paramf.length > 0)) {
          break;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 199L, 1L, false);
        ad.e(this.TAG, "doScene, file read buf error.");
        i = pA(-8);
        AppMethodBeat.o(150702);
        return i;
      }
      localdsz.xcM = paramf.length;
      localdsz.xcK = localg.hMP;
      localdsz.xcL = localg.offset;
      localdsz.xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
      localdsz.GVf = localg.hZC;
      if (this.ibd != null) {
        this.ibd.aLI();
      }
      i = dispatch(parame, this.rr, this);
      if (i < 0)
      {
        ad.e(this.TAG, "doScene netId error");
        k.py((int)this.iba);
        i = pA(-9);
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
    ad.i(this.TAG, "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.ibe);
    paramq = (dta)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).setEnSendMsgActionFlag(paramq.FOM);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.ibe)))
    {
      ad.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.ibe });
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e(this.TAG, "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 198L, 1L, false);
      k.py((int)this.iba);
      k.pw((int)this.iba);
      com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.giN), Integer.valueOf(0) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.iby != null) {
        this.iby.aEJ();
      }
      AppMethodBeat.o(150704);
      return;
    }
    this.ibx = paramq.xcM;
    if (this.ibx > 16384) {
      this.ibx = 16384;
    }
    paramString = aIp();
    ad.v(this.TAG, "onGYNetEnd localId:" + this.gwP + "  totalLen:" + paramString.hMP + " offSet:" + paramString.offset);
    if ((paramq.xcL < 0) || ((paramq.xcL > paramString.hMP) && (paramString.hMP > 0)))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 197L, 1L, false);
      ad.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + paramq.xcL + " img totalLen = " + paramString.hMP);
      k.py((int)this.iba);
      k.pw((int)this.iba);
      com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.giN), Integer.valueOf(0) });
      this.callback.onSceneEnd(4, -2, "", this);
      if (this.iby != null) {
        this.iby.aEJ();
      }
      AppMethodBeat.o(150704);
      return;
    }
    if ((paramq.xcL < paramString.offset) || ((h.b(paramString)) && (this.ibx <= 0)))
    {
      ad.e(this.TAG, "onGYNetEnd invalid data startPos = " + paramq.xcL + " totalLen = " + paramString.hMP + " off:" + paramString.offset);
      k.py((int)this.iba);
      k.pw((int)this.iba);
      this.callback.onSceneEnd(4, -1, "", this);
      if (this.iby != null) {
        this.iby.aEJ();
      }
      AppMethodBeat.o(150704);
      return;
    }
    ad.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + paramq.xcL);
    if ((a(paramString, paramq.xcL, paramq.xbt, paramq.CreateTime, null, paramq.Fvn)) && (doScene(dispatcher(), this.callback) < 0))
    {
      k.pw((int)this.iba);
      this.callback.onSceneEnd(3, -1, "", this);
      if (this.iby != null) {
        this.iby.aEJ();
      }
    }
    AppMethodBeat.o(150704);
  }
  
  public final void pz(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(150697);
    if (this.dku == null)
    {
      ad.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[] { Long.valueOf(this.hZF), Integer.valueOf(paramInt) });
      AppMethodBeat.o(150697);
      return;
    }
    if (this.ibB)
    {
      if (this.dku.fkv == 0)
      {
        boolean bool = q.aIF().a(this.dku, this.ibh, paramInt);
        bu localbu = this.dku;
        if (bool) {}
        for (paramInt = i;; paramInt = 0)
        {
          localbu.kE(paramInt);
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.hZF, this.dku);
          AppMethodBeat.o(150697);
          return;
        }
      }
    }
    else {
      q.aIF().a(this.dku.field_imgPath, com.tencent.mm.cc.a.getDensity(aj.getContext()), true);
    }
    AppMethodBeat.o(150697);
  }
  
  public final int securityLimitCount()
  {
    if (this.hZz == 0) {
      return 100;
    }
    return 1350;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
  
  public final class a
  {
    public com.tencent.mm.al.k ibQ;
    
    public a(com.tencent.mm.al.k paramk)
    {
      this.ibQ = paramk;
    }
    
    final void aEJ()
    {
      AppMethodBeat.i(150691);
      if (n.b(n.this) == n.c(n.this)) {}
      for (Object localObject = n.d(n.this);; localObject = n.e(n.this))
      {
        if (((g)localObject).hZJ == 1)
        {
          com.tencent.mm.plugin.report.service.f.Ok(23);
          com.tencent.mm.plugin.report.service.f.Ok(21);
        }
        ad.i(n.f(n.this), "UploadEndWrapper onUploadEnd %s done", new Object[] { n.e(n.d(n.this)) });
        if (q.aIF().a(Long.valueOf(n.c(n.this)), n.d(n.this)) < 0)
        {
          ad.e(n.f(n.this), "update db failed local id:" + n.c(n.this) + " server id:" + n.d(n.this).dAY);
          k.py((int)n.b(n.this));
          k.pw((int)n.b(n.this));
          n.g(n.this).onSceneEnd(3, -1, "", n.this);
        }
        if (n.c(n.this) != n.b(n.this))
        {
          ad.i(n.f(n.this), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { n.e(n.e(n.this)) });
          q.aIF().a(Long.valueOf(n.b(n.this)), n.e(n.this));
        }
        if ((!com.tencent.mm.sdk.a.b.fjN()) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
          break;
        }
        localObject = q.aIF().aIn();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          ad.i(n.f(n.this), "UploadEndWrapper onUploadEnd duminfo %s %s", new Object[] { Integer.valueOf(i), n.e((g)((List)localObject).get(i)) });
          i += 1;
        }
      }
      n.a(n.this, n.c(n.this));
      if (n.b(n.this) != n.c(n.this)) {
        n.a(n.this, n.b(n.this));
      }
      if (this.ibQ != null) {
        this.ibQ.aEJ();
      }
      n.this.pz(n.h(n.this));
      n.i(n.this);
      AppMethodBeat.o(150691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.n
 * JD-Core Version:    0.7.0.1
 */