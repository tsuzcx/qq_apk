package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.t;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  String TAG;
  com.tencent.mm.ai.f callback;
  bi cmQ;
  private long cpO;
  long eDv;
  private int fDP;
  final com.tencent.mm.ai.g fFj;
  public final long fFk;
  private long fFl;
  private int fFm;
  private com.tencent.mm.modelstat.h fFn;
  String fFo;
  int fFp;
  private String fFq;
  public String fFr;
  int fFs;
  public boolean fFt;
  private int fFu;
  private String fFv;
  private int fFw;
  boolean fFx;
  private g.a fFy;
  int fsd;
  private final com.tencent.mm.ai.b rr;
  private int startOffset;
  long startTime;
  private int token;
  
  public k(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.ai.g paramg)
  {
    this(paramLong1, paramLong2, paramInt, paramg, -1);
  }
  
  public k(long paramLong1, long paramLong2, int paramInt1, com.tencent.mm.ai.g paramg, int paramInt2)
  {
    AppMethodBeat.i(78313);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.fFl = -1L;
    this.fFn = null;
    this.cpO = -1L;
    this.cmQ = null;
    this.fFo = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fFp = 0;
    this.fFq = "";
    this.fFr = "";
    this.fsd = 0;
    this.fFs = -1;
    this.fFt = false;
    this.fFu = -1;
    this.fFv = null;
    this.fFw = 0;
    this.token = -1;
    this.fFx = false;
    this.fFy = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78311);
        if (paramAnonymousInt == -21006)
        {
          ab.i(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { k.this.fFo });
          AppMethodBeat.o(78311);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          i.lz((int)k.this.fFk);
          i.ly((int)k.this.fFk);
          l1 = k.this.startTime;
          l2 = bo.aoy();
          i = com.tencent.mm.al.c.cb(ah.getContext());
          j = k.this.fFp;
          k = k.this.fsd;
          if (paramAnonymousd == null)
          {
            paramAnonymousString = "";
            if (paramAnonymousd != null) {
              break label304;
            }
          }
          label304:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.edb)
          {
            paramAnonymousString = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.f(paramAnonymousString).ake();
            new com.tencent.mm.g.b.a.d(paramAnonymousString).ake();
            k.this.callback.onSceneEnd(3, paramAnonymousInt, "", k.this);
            AppMethodBeat.o(78311);
            return 0;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break;
          }
        }
        e locale = o.ahC().b(Long.valueOf(k.this.eDv));
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == k.this.fsd)
          {
            ab.d(k.this.TAG, "cdntra ignore progress 100%");
            AppMethodBeat.o(78311);
            return 0;
          }
          k.this.fFx = true;
          if (!k.this.fFt) {
            k.this.fFt = paramAnonymousc.field_mtlnotify;
          }
          ab.i(k.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { k.this.fFo, Integer.valueOf(paramAnonymousc.field_finishedLength), Integer.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(k.this.fFt) });
          k.a(k.this, locale, k.this.fsd, locale.offset, paramAnonymousc.field_finishedLength - locale.offset);
          AppMethodBeat.o(78311);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label962;
          }
          i.ly((int)k.this.fFk);
          ab.e(k.this.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          k.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", k.this);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = k.this.startTime;
          l2 = bo.aoy();
          i = com.tencent.mm.al.c.cb(ah.getContext());
          j = k.this.fFp;
          k = k.this.fsd;
          if (paramAnonymousd != null) {
            break label1335;
          }
          paramAnonymousString = "";
          label625:
          if (paramAnonymousd != null) {
            break label1344;
          }
          paramAnonymousc = "";
          label633:
          new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).ake();
          if (paramAnonymousd.field_retCode != 0)
          {
            paramAnonymousInt = paramAnonymousd.field_retCode;
            l1 = k.this.startTime;
            l2 = bo.aoy();
            i = com.tencent.mm.al.c.cb(ah.getContext());
            j = k.this.fFp;
            k = k.this.fsd;
            if (paramAnonymousd != null) {
              break label1353;
            }
            paramAnonymousString = "";
            label821:
            if (paramAnonymousd != null) {
              break label1362;
            }
          }
        }
        label962:
        label1353:
        label1362:
        for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.edb)
        {
          new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).ake();
          AppMethodBeat.o(78311);
          return 0;
          ab.i(k.this.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
          if (locale.fDP == 1)
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 26L, locale.fsd, false);
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 27L, 1L, false);
            paramAnonymousc = com.tencent.mm.plugin.report.service.h.qsU;
            if (k.this.cmQ != null)
            {
              paramAnonymousString = k.this.cmQ.field_talker;
              if (!t.lA(paramAnonymousString)) {
                break label1191;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymousc.idkeyStat(198L, l1, 1L, false);
              if (paramAnonymousd.field_convert2baseline)
              {
                ab.i(k.this.TAG, "cdntra need convert2baseline. file:%s", new Object[] { k.this.fFr });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(k.this.fFr, 60);
                ab.i(k.this.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!k.this.fFx) {
                break label1297;
              }
              k.a(k.this, locale, locale.offset, locale.offset, 0);
              break;
              paramAnonymousString = "";
              break label1056;
            }
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 21L, locale.fsd, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(198L, 22L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.qsU;
          if (k.this.cmQ != null)
          {
            paramAnonymousString = k.this.cmQ.field_talker;
            label1257:
            if (!t.lA(paramAnonymousString)) {
              break label1289;
            }
          }
          for (l1 = 24L;; l1 = 23L)
          {
            paramAnonymousc.idkeyStat(198L, l1, 1L, false);
            break;
            paramAnonymousString = "";
            break label1257;
          }
          k.a(k.this, locale, k.this.fsd, locale.offset, k.this.fsd - locale.offset);
          break;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label625;
          paramAnonymousc = paramAnonymousd.edb;
          break label633;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label821;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] l(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    boolean bool;
    e locale;
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramg != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fFj = paramg;
      this.fDP = paramInt1;
      this.fFk = paramLong1;
      this.fFl = paramLong1;
      this.eDv = paramLong1;
      this.cpO = paramLong2;
      this.fFu = paramInt2;
      locale = o.ahC().b(Long.valueOf(this.eDv));
      if (paramInt1 != 1) {
        break label590;
      }
      this.eDv = locale.fDW;
      locale = o.ahC().b(Long.valueOf(this.eDv));
    }
    label590:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.eDv + "]");
      Object localObject = new b.a();
      ((b.a)localObject).fsX = new amo();
      ((b.a)localObject).fsY = new amp();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((b.a)localObject).funcId = 109;
      ((b.a)localObject).reqCmdId = 10;
      ((b.a)localObject).respCmdId = 1000000010;
      this.rr = ((b.a)localObject).ado();
      localObject = (amo)this.rr.fsV.fta;
      this.cmQ = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(paramLong2);
      ((amo)localObject).pIy = locale.offset;
      ((amo)localObject).pIx = locale.fsd;
      ab.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(locale.offset), Integer.valueOf(locale.fsd), bo.dtY() });
      ((amo)localObject).pIG = this.cmQ.field_msgSvrId;
      ((amo)localObject).woP = new bwc().aoF(this.cmQ.field_talker);
      ((amo)localObject).woQ = new bwc().aoF((String)com.tencent.mm.kernel.g.RL().Ru().get(2, null));
      ((amo)localObject).xdn = paramInt1;
      if (locale.offset == 0) {
        this.fFn = new com.tencent.mm.modelstat.h(getType(), false, locale.fsd);
      }
      this.fFm = 8192;
      if (paramg != null) {
        al.d(new k.1(this, paramg, locale.offset, locale.fsd));
      }
      AppMethodBeat.o(78313);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean a(e parame, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78317);
    parame.lq(paramInt1);
    parame.setOffset(paramInt2 + paramInt3);
    this.fFm = paramInt3;
    if (paramArrayOfByte != null) {
      com.tencent.mm.vfs.e.a(this.fFr, paramArrayOfByte, paramArrayOfByte.length);
    }
    ab.d(this.TAG, "onGYNetEnd : offset = " + parame.offset + " totalLen = " + parame.fsd + " stack:[%s]", new Object[] { bo.dtY() });
    boolean bool1;
    String str2;
    com.tencent.mm.vfs.b localb;
    boolean bool2;
    if (parame.ahg())
    {
      paramArrayOfByte = r.apa(this.fFr);
      bool1 = r.aoX(this.fFr);
      str2 = this.fFr + "_hevc";
      localb = new com.tencent.mm.vfs.b(this.fFr);
      bool2 = r.aoZ(this.fFr);
      if (!bool2) {
        break label975;
      }
      localb.p(new com.tencent.mm.vfs.b(str2));
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str2, this.fFr) != 0)
      {
        ab.w(this.TAG, "download hevc decode failed");
        bool1 = false;
        ab.d(this.TAG, "hevc download is hevc %b", new Object[] { Boolean.TRUE });
      }
    }
    label407:
    label975:
    for (;;)
    {
      String str1;
      String str4;
      if (bool1)
      {
        String str3 = this.fFq + paramArrayOfByte;
        str1 = o.ahC().q(this.fFq, null, paramArrayOfByte);
        ab.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.fFq, this.fFr, str1 });
        paramArrayOfByte = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).Kf(str3);
        str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).Kf(str1);
        if (bool2)
        {
          new com.tencent.mm.vfs.b(str2).p(new com.tencent.mm.vfs.b(str4));
          localb.p(new com.tencent.mm.vfs.b(str1));
          parame.sW(str3);
          parame.ta(paramArrayOfByte);
          parame.sV(f.tc(str1));
          parame.lu(this.fDP);
        }
      }
      for (paramArrayOfByte = str1;; paramArrayOfByte = null)
      {
        if (o.ahC().a(Long.valueOf(this.eDv), parame) >= 0) {
          break label603;
        }
        ab.e(this.TAG, "onGYNetEnd : update img fail");
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(78317);
        return false;
        paramArrayOfByte = r.apa(this.fFr);
        break;
        if (com.tencent.mm.vfs.e.avI(str4) > 0L)
        {
          com.tencent.mm.vfs.e.deleteFile(str4);
          com.tencent.mm.plugin.report.service.h.qsU.cT(944, 10);
        }
        localb.p(new com.tencent.mm.vfs.b(str1));
        break label407;
        if (this.fDP == 1)
        {
          paramArrayOfByte = o.ahC().b(Long.valueOf(this.fFl));
          paramArrayOfByte.lr(0);
          o.ahC().a(Long.valueOf(this.fFl), paramArrayOfByte);
        }
        localb.delete();
      }
      label603:
      if (this.fFj != null) {
        al.d(new k.3(this, parame));
      }
      ab.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(parame.ahg()), this.fFo });
      if (parame.ahg())
      {
        if (bo.isNullOrNil(this.fFo)) {
          com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fFp), Integer.valueOf(paramInt1 - this.startOffset) });
        }
        bool1 = false;
        if (this.fFs > 0) {
          bool1 = o.ahC().a(paramArrayOfByte, parame.fDO, this.fFs, 1, this.cmQ.dGS, this.cmQ.dGT);
        }
        if (bool1)
        {
          parame.ahi();
          ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.cmQ.field_msgId, this.cmQ);
        }
        o.ahC().a(Long.valueOf(this.eDv), parame);
        ab.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.fFr, paramArrayOfByte, parame.fDM, this.fFv });
        if (this.fFn != null) {
          this.fFn.hc(parame.fsd);
        }
        if ((!bo.isNullOrNil(this.fFv)) && (this.fFw > 0))
        {
          com.tencent.mm.plugin.i.b.bIA();
          com.tencent.mm.plugin.i.b.YH().y(this.fFv, this.fFw, paramArrayOfByte);
        }
        this.callback.onSceneEnd(0, 0, "", this);
        AppMethodBeat.o(78317);
        return false;
      }
      AppMethodBeat.o(78317);
      return true;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(78314);
    if ((!bo.isNullOrNil(this.fFo)) && (com.tencent.mm.al.f.afO() != null))
    {
      ab.d(this.TAG, "cancel recv task");
      com.tencent.mm.al.f.afO().sJ(this.fFo);
    }
    super.cancel();
    AppMethodBeat.o(78314);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(78315);
    this.callback = paramf;
    amo localamo = (amo)this.rr.fsV.fta;
    e locale = o.ahC().b(Long.valueOf(this.eDv));
    if (locale.fDL == 0L)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 195L, 1L, false);
      ab.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.eDv), locale });
      AppMethodBeat.o(78315);
      return -1;
    }
    if (locale.status != 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 194L, 1L, false);
      ab.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(locale.fDL), Integer.valueOf(locale.status) });
      AppMethodBeat.o(78315);
      return -1;
    }
    paramf = locale.fDM;
    if (paramf.startsWith("SERVERID://"))
    {
      this.fFq = com.tencent.mm.a.g.w(locale.fDM.getBytes());
      this.fFr = o.ahC().q(this.fFq, null, ".temp");
      locale.sW(this.fFq + ".temp");
      o.ahC().a(Long.valueOf(this.eDv), locale);
      ab.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(locale.fDL), Integer.valueOf(this.fDP), Integer.valueOf(locale.offset), Integer.valueOf(locale.fsd), paramf, this.fFq, this.fFr });
      if (this.startTime == 0L)
      {
        this.startTime = bo.aoy();
        this.startOffset = locale.offset;
        if (this.fDP != 1) {
          break label458;
        }
        i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        label378:
        this.fFp = i;
      }
      if (!bo.isNullOrNil(locale.fDX)) {
        break label465;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label1772;
      }
      ab.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.fFo });
      AppMethodBeat.o(78315);
      return 0;
      this.fFq = locale.fDM;
      this.fFr = o.ahC().q(this.fFq, null, "");
      break;
      label458:
      i = com.tencent.mm.i.a.MediaType_IMAGE;
      break label378;
      label465:
      Map localMap = br.F(locale.fDX, "msg");
      if (localMap == null)
      {
        ab.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { locale.fDX });
        i = 0;
      }
      else
      {
        this.fsd = 0;
        String str1;
        if (this.fDP != 1)
        {
          str1 = (String)localMap.get(".msg.img.$cdnmidimgurl");
          this.fsd = bo.getInt((String)localMap.get(".msg.img.$length"), 0);
          label559:
          if (this.fDP == 1) {
            break label729;
          }
          str2 = (String)localMap.get(".msg.img.$tpurl");
          paramf = str2;
          if (bo.isNullOrNil(str2)) {
            break label779;
          }
          this.fsd = bo.getInt((String)localMap.get(".msg.img.$tplength"), 0);
          paramf = str2;
        }
        label779:
        for (;;)
        {
          ab.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.fDP), Integer.valueOf(this.fsd), str1, paramf });
          if ((!bo.isNullOrNil(str1)) || (!bo.isNullOrNil(paramf))) {
            break label782;
          }
          ab.e(this.TAG, "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          str1 = (String)localMap.get(".msg.img.$cdnbigimgurl");
          this.fsd = bo.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
          break label559;
          label729:
          str2 = (String)localMap.get(".msg.img.$tphdurl");
          paramf = str2;
          if (!bo.isNullOrNil(str2))
          {
            this.fsd = bo.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
            paramf = str2;
          }
        }
        label782:
        String str2 = (String)localMap.get(".msg.img.$aeskey");
        if (bo.isNullOrNil(str2))
        {
          ab.e(this.TAG, "cdntra get aes key failed.");
          i = 0;
        }
        else
        {
          this.fFo = com.tencent.mm.al.c.a("downimg", locale.fDT, this.cmQ.field_talker, this.cmQ.field_msgId);
          if (bo.isNullOrNil(this.fFo))
          {
            ab.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.eDv) });
            i = 0;
          }
          else
          {
            Object localObject1 = (String)localMap.get(".msg.img.$md5");
            if ((bo.isNullOrNil(paramf)) && (!bo.isNullOrNil((String)localObject1)) && ((bo.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.fDP == 1)))
            {
              com.tencent.mm.plugin.i.b.bIA();
              String str3 = com.tencent.mm.plugin.i.b.YH().eG((String)localObject1, this.fsd);
              i = (int)com.tencent.mm.vfs.e.avI(str3);
              int j = this.fsd - i;
              String str4 = this.TAG;
              int k = this.fsd;
              Object localObject2 = localMap.get(".msg.img.$cdnbigimgurl");
              if (this.fDP == 1)
              {
                bool = true;
                label1027:
                ab.i(str4, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), localObject1, localObject2, Boolean.valueOf(bool), Integer.valueOf(i), str3, Integer.valueOf(j), this.fFr });
                if (bo.isNullOrNil(str3)) {
                  break label1340;
                }
                if ((j < 0) || (j > 16)) {
                  break label1354;
                }
                bool = false;
                if (!bo.isEqual(str3, this.fFr)) {
                  if (com.tencent.mm.vfs.e.C(str3, this.fFr) < 0L) {
                    break label1334;
                  }
                }
              }
              label1334:
              for (boolean bool = true;; bool = false)
              {
                ab.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str3, this.fFr, Boolean.valueOf(bool) });
                a(locale, this.fsd, this.fsd, 0, null);
                if (this.cmQ != null) {
                  ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(new h.c(this.cmQ.field_talker, "update", this.cmQ));
                }
                com.tencent.mm.plugin.report.service.h.qsU.e(13267, new Object[] { str1, Long.valueOf(this.cmQ.field_msgSvrId), localObject1, Long.valueOf(this.cmQ.field_createTime / 1000L), this.cmQ.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
                i = 1;
                break;
                bool = false;
                break label1027;
              }
              label1340:
              this.fFv = ((String)localObject1);
              this.fFw = this.fsd;
            }
            label1354:
            localObject1 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject1).field_mediaId = this.fFo;
            ((com.tencent.mm.i.g)localObject1).field_fullpath = this.fFr;
            ((com.tencent.mm.i.g)localObject1).field_fileType = this.fFp;
            ((com.tencent.mm.i.g)localObject1).field_totalLen = this.fsd;
            ((com.tencent.mm.i.g)localObject1).field_aesKey = str2;
            ((com.tencent.mm.i.g)localObject1).field_fileId = str1;
            ((com.tencent.mm.i.g)localObject1).field_priority = com.tencent.mm.i.a.ecF;
            ((com.tencent.mm.i.g)localObject1).edp = this.fFy;
            if (t.lA(this.cmQ.field_talker))
            {
              i = 1;
              label1445:
              ((com.tencent.mm.i.g)localObject1).field_chattype = i;
              if (!((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).bkg()) {
                break label1743;
              }
              i = 2;
              label1470:
              ((com.tencent.mm.i.g)localObject1).expectImageFormat = i;
              if (!bo.isNullOrNil(paramf))
              {
                str1 = (String)localMap.get(".msg.img.$tpauthkey");
                ((com.tencent.mm.i.g)localObject1).field_fileType = 19;
                ((com.tencent.mm.i.g)localObject1).field_authKey = str1;
                ((com.tencent.mm.i.g)localObject1).eds = paramf;
                ((com.tencent.mm.i.g)localObject1).field_fileId = "";
              }
              ab.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.cmQ.field_msgId, Boolean.valueOf(com.tencent.mm.al.f.afO().fyQ.contains("image_" + this.cmQ.field_msgId)) });
              if (!com.tencent.mm.al.f.afO().fyQ.contains("image_" + this.cmQ.field_msgId)) {
                break label1748;
              }
              com.tencent.mm.al.f.afO().fyQ.remove("image_" + this.cmQ.field_msgId);
            }
            label1743:
            label1748:
            for (((com.tencent.mm.i.g)localObject1).field_autostart = true;; ((com.tencent.mm.i.g)localObject1).field_autostart = false)
            {
              if (com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject1, this.fFu)) {
                break label1757;
              }
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 196L, 1L, false);
              ab.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.fFo });
              this.fFo = "";
              i = 0;
              break;
              i = 0;
              break label1445;
              i = 1;
              break label1470;
            }
            label1757:
            ab.i(this.TAG, "add recv task");
            i = 1;
          }
        }
      }
    }
    label1772:
    ab.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.fFo });
    locale.sZ("");
    locale.bsY = 4096;
    o.ahC().a(Long.valueOf(this.eDv), locale);
    localamo.pIy = locale.offset;
    localamo.pIz = this.fFm;
    localamo.pIx = locale.fsd;
    if (this.fFn != null) {
      this.fFn.akD();
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78315);
    return i;
  }
  
  public final int getType()
  {
    return 109;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78316);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.fFo });
      AppMethodBeat.o(78316);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fFp), Integer.valueOf(this.fsd - this.startOffset) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78316);
      return;
    }
    paramString = (amp)((com.tencent.mm.ai.b)paramq).fsW.fta;
    paramq = o.ahC().b(Long.valueOf(this.eDv));
    paramInt1 = 0;
    if (paramString.pIz <= 0)
    {
      ab.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.fFp), Integer.valueOf(this.fsd - this.startOffset) });
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(78316);
      return;
      if ((paramString.pIA == null) || (paramString.pIz != paramString.pIA.getILen()))
      {
        ab.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.pIy < 0) || (paramString.pIy + paramString.pIz > paramString.pIx))
      {
        ab.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.pIy != paramq.offset)
      {
        ab.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.pIx <= 0)
      {
        ab.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(paramq, paramString.pIx, paramString.pIy, paramString.pIz, paramString.pIA.getBuffer().pW)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(78316);
  }
  
  public final int securityLimitCount()
  {
    if (this.fDP == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.k
 * JD-Core Version:    0.7.0.1
 */