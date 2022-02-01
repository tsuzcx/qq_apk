package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.w;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  String TAG;
  bo cZc;
  com.tencent.mm.ak.g callback;
  int fPn;
  long gdf;
  private int hGP;
  final com.tencent.mm.ak.h hIl;
  public final long hIm;
  private long hIn;
  private int hIo;
  private com.tencent.mm.modelstat.h hIp;
  String hIq;
  private String hIr;
  public String hIs;
  int hIt;
  public boolean hIu;
  private int hIv;
  private String hIw;
  private int hIx;
  boolean hIy;
  private g.a hIz;
  private boolean huo;
  int hux;
  private long msgId;
  private final com.tencent.mm.ak.b rr;
  private int startOffset;
  long startTime;
  private int token;
  
  public k(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.ak.h paramh)
  {
    this(paramLong1, paramLong2, paramInt, paramh, -1);
  }
  
  public k(long paramLong1, long paramLong2, int paramInt1, final com.tencent.mm.ak.h paramh, int paramInt2)
  {
    AppMethodBeat.i(150673);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.hIn = -1L;
    this.hIp = null;
    this.msgId = -1L;
    this.cZc = null;
    this.hIq = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fPn = 0;
    this.huo = true;
    this.hIr = "";
    this.hIs = "";
    this.hux = 0;
    this.hIt = -1;
    this.hIu = false;
    this.hIv = -1;
    this.hIw = null;
    this.hIx = 0;
    this.token = -1;
    this.hIy = false;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150671);
        if (paramAnonymousInt == -21006)
        {
          ac.i(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { k.this.hIq });
          AppMethodBeat.o(150671);
          return 0;
        }
        long l1;
        long l2;
        int i;
        int j;
        int k;
        if (paramAnonymousInt != 0)
        {
          i.oV((int)k.this.hIm);
          i.oU((int)k.this.hIm);
          l1 = k.this.startTime;
          l2 = bs.eWj();
          i = com.tencent.mm.an.c.cD(ai.getContext());
          j = k.this.fPn;
          k = k.this.hux;
          if (paramAnonymousd == null)
          {
            paramAnonymousString = "";
            if (paramAnonymousd != null) {
              break label304;
            }
          }
          label304:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fqM)
          {
            paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousString).aHZ();
            new com.tencent.mm.g.b.a.f(paramAnonymousString).aHZ();
            k.this.callback.onSceneEnd(3, paramAnonymousInt, "", k.this);
            AppMethodBeat.o(150671);
            return 0;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break;
          }
        }
        e locale = o.aFx().c(Long.valueOf(k.this.gdf));
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == k.this.hux)
          {
            ac.d(k.this.TAG, "cdntra ignore progress 100%");
            AppMethodBeat.o(150671);
            return 0;
          }
          k.this.hIy = true;
          if (!k.this.hIu) {
            k.this.hIu = paramAnonymousc.field_mtlnotify;
          }
          ac.i(k.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { k.this.hIq, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(k.this.hIu) });
          k.a(k.this, locale, k.this.hux, locale.offset, (int)paramAnonymousc.field_finishedLength - locale.offset);
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label965;
          }
          i.oU((int)k.this.hIm);
          ac.e(k.this.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          k.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", k.this);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = k.this.startTime;
          l2 = bs.eWj();
          i = com.tencent.mm.an.c.cD(ai.getContext());
          j = k.this.fPn;
          k = k.this.hux;
          if (paramAnonymousd != null) {
            break label1338;
          }
          paramAnonymousString = "";
          label628:
          if (paramAnonymousd != null) {
            break label1347;
          }
          paramAnonymousc = "";
          label636:
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aHZ();
          if (paramAnonymousd.field_retCode != 0)
          {
            paramAnonymousInt = paramAnonymousd.field_retCode;
            l1 = k.this.startTime;
            l2 = bs.eWj();
            i = com.tencent.mm.an.c.cD(ai.getContext());
            j = k.this.fPn;
            k = k.this.hux;
            if (paramAnonymousd != null) {
              break label1356;
            }
            paramAnonymousString = "";
            label824:
            if (paramAnonymousd != null) {
              break label1365;
            }
          }
        }
        label965:
        label1356:
        label1365:
        for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fqM)
        {
          new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aHZ();
          AppMethodBeat.o(150671);
          return 0;
          ac.i(k.this.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
          if (locale.hGP == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 26L, locale.hux, false);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 27L, 1L, false);
            paramAnonymousc = com.tencent.mm.plugin.report.service.h.wUl;
            if (k.this.cZc != null)
            {
              paramAnonymousString = k.this.cZc.field_talker;
              if (!w.sQ(paramAnonymousString)) {
                break label1194;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymousc.idkeyStat(198L, l1, 1L, false);
              if (paramAnonymousd.field_convert2baseline)
              {
                ac.i(k.this.TAG, "cdntra need convert2baseline. file:%s", new Object[] { k.this.hIs });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(k.this.hIs, 60);
                ac.i(k.this.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!k.this.hIy) {
                break label1300;
              }
              k.a(k.this, locale, locale.offset, locale.offset, 0);
              break;
              paramAnonymousString = "";
              break label1059;
            }
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 21L, locale.hux, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 22L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.wUl;
          if (k.this.cZc != null)
          {
            paramAnonymousString = k.this.cZc.field_talker;
            label1260:
            if (!w.sQ(paramAnonymousString)) {
              break label1292;
            }
          }
          for (l1 = 24L;; l1 = 23L)
          {
            paramAnonymousc.idkeyStat(198L, l1, 1L, false);
            break;
            paramAnonymousString = "";
            break label1260;
          }
          k.a(k.this, locale, k.this.hux, locale.offset, k.this.hux - locale.offset);
          break;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label628;
          paramAnonymousc = paramAnonymousd.fqM;
          break label636;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label824;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    boolean bool;
    e locale;
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramh != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.hIl = paramh;
      this.hGP = paramInt1;
      this.hIm = paramLong1;
      this.hIn = paramLong1;
      this.gdf = paramLong1;
      this.msgId = paramLong2;
      this.hIv = paramInt2;
      locale = o.aFx().c(Long.valueOf(this.gdf));
      if (paramInt1 != 1) {
        break label595;
      }
      this.gdf = locale.hGX;
      locale = o.aFx().c(Long.valueOf(this.gdf));
    }
    label595:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.gdf + "]");
      Object localObject = new b.a();
      ((b.a)localObject).hvt = new baf();
      ((b.a)localObject).hvu = new bag();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((b.a)localObject).funcId = 109;
      ((b.a)localObject).reqCmdId = 10;
      ((b.a)localObject).respCmdId = 1000000010;
      this.rr = ((b.a)localObject).aAz();
      localObject = (baf)this.rr.hvr.hvw;
      this.cZc = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong2);
      ((baf)localObject).vTI = locale.offset;
      ((baf)localObject).vTH = locale.hux;
      ac.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(locale.offset), Integer.valueOf(locale.hux), bs.eWi() });
      ((baf)localObject).vTQ = this.cZc.field_msgSvrId;
      ((baf)localObject).DPT = new crm().aJV(this.cZc.field_talker);
      ((baf)localObject).DPU = new crm().aJV((String)com.tencent.mm.kernel.g.agR().agA().get(2, null));
      ((baf)localObject).ERj = paramInt1;
      if (locale.offset == 0) {
        this.hIp = new com.tencent.mm.modelstat.h(getType(), false, locale.hux);
      }
      this.hIo = 8192;
      if (paramh != null) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150670);
            paramh.a(this.hIB, this.hIC, k.this);
            AppMethodBeat.o(150670);
          }
        });
      }
      AppMethodBeat.o(150673);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean a(final e parame, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150678);
    parame.oL(paramInt1);
    parame.setOffset(paramInt2 + paramInt3);
    this.hIo = paramInt3;
    if (paramArrayOfByte != null) {
      com.tencent.mm.vfs.i.e(this.hIs, paramArrayOfByte, paramArrayOfByte.length);
    }
    ac.d(this.TAG, "onGYNetEnd : offset = " + parame.offset + " totalLen = " + parame.hux + " stack:[%s]", new Object[] { bs.eWi() });
    String str2 = null;
    paramArrayOfByte = str2;
    String str1;
    boolean bool1;
    String str3;
    com.tencent.mm.vfs.e locale;
    String str4;
    if (parame.aEZ())
    {
      str1 = s.aKF(this.hIs);
      bool1 = s.aKC(this.hIs);
      str3 = this.hIs + "_hevc";
      locale = new com.tencent.mm.vfs.e(this.hIs);
      boolean bool2 = s.aKE(this.hIs);
      paramArrayOfByte = str1;
      if (!bool2) {
        break label563;
      }
      if (this.huo) {
        break label453;
      }
      ac.e(this.TAG, "sceneEndproc: download jpg get hevc");
      bool1 = false;
      paramArrayOfByte = str1;
      if (!bool1) {
        break label611;
      }
      str2 = this.hIr + paramArrayOfByte;
      str1 = o.aFx().p(this.hIr, null, paramArrayOfByte);
      ac.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.hIr, this.hIs, str1 });
      paramArrayOfByte = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Xx(str2);
      str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Xx(str1);
      if (!bool2) {
        break label566;
      }
      new com.tencent.mm.vfs.e(str3).ae(new com.tencent.mm.vfs.e(str4));
      locale.ae(new com.tencent.mm.vfs.e(str1));
      label371:
      parame.Ce(str2);
      parame.Ci(paramArrayOfByte);
      parame.Cd(f.Ck(str1));
      parame.oQ(this.hGP);
    }
    for (paramArrayOfByte = str1;; paramArrayOfByte = str2)
    {
      if (o.aFx().a(Long.valueOf(this.gdf), parame) >= 0) {
        break label669;
      }
      ac.e(this.TAG, "onGYNetEnd : update img fail");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150678);
      return false;
      label453:
      locale.ae(new com.tencent.mm.vfs.e(str3));
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str3, this.hIs) != 0)
      {
        ac.w(this.TAG, "download hevc decode failed");
        this.huo = false;
        com.tencent.mm.vfs.i.deleteFile(str3);
        com.tencent.mm.vfs.i.deleteFile(this.hIs);
        g(parame);
        AppMethodBeat.o(150678);
        return false;
      }
      paramArrayOfByte = s.aKF(this.hIs);
      ac.i(this.TAG, "hevc download is hevc %b", new Object[] { Boolean.TRUE });
      label563:
      break;
      label566:
      if (com.tencent.mm.vfs.i.aSp(str4) > 0L)
      {
        com.tencent.mm.vfs.i.deleteFile(str4);
        com.tencent.mm.plugin.report.service.h.wUl.dB(944, 10);
      }
      locale.ae(new com.tencent.mm.vfs.e(str1));
      break label371;
      label611:
      if (this.hGP == 1)
      {
        paramArrayOfByte = o.aFx().c(Long.valueOf(this.hIn));
        paramArrayOfByte.oM(0);
        o.aFx().a(Long.valueOf(this.hIn), paramArrayOfByte);
      }
      locale.delete();
    }
    label669:
    if (this.hIl != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150672);
          k.this.hIl.a(parame.offset, parame.hux, k.this);
          AppMethodBeat.o(150672);
        }
      });
    }
    ac.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(parame.aEZ()), this.hIq });
    if (parame.aEZ())
    {
      if (bs.isNullOrNil(this.hIq)) {
        com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.fPn), Integer.valueOf(paramInt1 - this.startOffset) });
      }
      bool1 = false;
      if (this.hIt > 0) {
        bool1 = o.aFx().a(paramArrayOfByte, parame.hGO, this.hIt, 1, this.cZc.eSc, this.cZc.eSd);
      }
      if (bool1)
      {
        parame.aFb();
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.cZc.field_msgId, this.cZc);
      }
      o.aFx().a(Long.valueOf(this.gdf), parame);
      ac.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.hIs, paramArrayOfByte, parame.hGM, this.hIw });
      if (this.hIp != null) {
        this.hIp.qp(parame.hux);
      }
      if ((!bs.isNullOrNil(this.hIw)) && (this.hIx > 0))
      {
        com.tencent.mm.plugin.image.c.cTF();
        com.tencent.mm.plugin.image.c.awI().D(this.hIw, this.hIx, paramArrayOfByte);
      }
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(150678);
      return false;
    }
    AppMethodBeat.o(150678);
    return true;
  }
  
  private boolean g(e parame)
  {
    AppMethodBeat.i(150674);
    if (bs.isNullOrNil(parame.hGY))
    {
      AppMethodBeat.o(150674);
      return false;
    }
    Map localMap = bv.L(parame.hGY, "msg");
    if (localMap == null)
    {
      ac.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { parame.hGY });
      AppMethodBeat.o(150674);
      return false;
    }
    this.hux = 0;
    String str2;
    String str1;
    if (this.hGP != 1)
    {
      str2 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      this.hux = bs.getInt((String)localMap.get(".msg.img.$length"), 0);
      if (this.hGP == 1) {
        break label296;
      }
      str3 = (String)localMap.get(".msg.img.$tpurl");
      str1 = str3;
      if (bs.isNullOrNil(str3)) {
        break label348;
      }
      this.hux = bs.getInt((String)localMap.get(".msg.img.$tplength"), 0);
      str1 = str3;
    }
    label296:
    label348:
    for (;;)
    {
      ac.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.hGP), Integer.valueOf(this.hux), str2, str1 });
      if ((!bs.isNullOrNil(str2)) || (!bs.isNullOrNil(str1))) {
        break label351;
      }
      ac.e(this.TAG, "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(150674);
      return false;
      str2 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      this.hux = bs.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
      break;
      str3 = (String)localMap.get(".msg.img.$tphdurl");
      str1 = str3;
      if (!bs.isNullOrNil(str3))
      {
        this.hux = bs.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
        str1 = str3;
      }
    }
    label351:
    String str3 = (String)localMap.get(".msg.img.$aeskey");
    if (bs.isNullOrNil(str3))
    {
      ac.e(this.TAG, "cdntra get aes key failed.");
      AppMethodBeat.o(150674);
      return false;
    }
    this.hIq = com.tencent.mm.an.c.a("downimg", parame.hGU, this.cZc.field_talker, this.cZc.field_msgId);
    if (bs.isNullOrNil(this.hIq))
    {
      ac.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gdf) });
      AppMethodBeat.o(150674);
      return false;
    }
    String str4 = (String)localMap.get(".msg.img.$md5");
    int i;
    boolean bool;
    if ((bs.isNullOrNil(str1)) && (!bs.isNullOrNil(str4)) && ((bs.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.hGP == 1)))
    {
      com.tencent.mm.plugin.image.c.cTF();
      String str5 = com.tencent.mm.plugin.image.c.awI().fT(str4, this.hux);
      i = (int)com.tencent.mm.vfs.i.aSp(str5);
      int j = this.hux - i;
      String str6 = this.TAG;
      int k = this.hux;
      Object localObject = localMap.get(".msg.img.$cdnbigimgurl");
      if (this.hGP == 1)
      {
        bool = true;
        ac.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str4, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str5, Integer.valueOf(j), this.hIs });
        if (bs.isNullOrNil(str5)) {
          break label913;
        }
        if ((j < 0) || (j > 16)) {
          break label927;
        }
        bool = false;
        if (!bs.lr(str5, this.hIs)) {
          if (com.tencent.mm.vfs.i.lZ(str5, this.hIs) < 0L) {
            break label907;
          }
        }
      }
      label907:
      for (bool = true;; bool = false)
      {
        ac.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str5, this.hIs, Boolean.valueOf(bool) });
        a(parame, this.hux, this.hux, 0, null);
        if (this.cZc != null) {
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(this.cZc.field_talker, "update", this.cZc));
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(13267, new Object[] { str2, Long.valueOf(this.cZc.field_msgSvrId), str4, Long.valueOf(this.cZc.field_createTime / 1000L), this.cZc.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
        AppMethodBeat.o(150674);
        return true;
        bool = false;
        break;
      }
      label913:
      this.hIw = str4;
      this.hIx = this.hux;
    }
    label927:
    if ((this.huo) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cbj()))
    {
      bool = true;
      ac.i(this.TAG, "checkUseCdn: %s, %s", new Object[] { Boolean.valueOf(this.huo), Boolean.valueOf(bool) });
      parame = new com.tencent.mm.i.g();
      if (!bool) {
        break label1357;
      }
      parame.field_mediaId = this.hIq;
      label1007:
      parame.field_fullpath = this.hIs;
      parame.field_fileType = this.fPn;
      parame.field_totalLen = this.hux;
      parame.field_aesKey = str3;
      parame.field_fileId = str2;
      parame.field_priority = com.tencent.mm.i.a.fqp;
      parame.frb = this.hIz;
      if (!w.sQ(this.cZc.field_talker)) {
        break label1387;
      }
      i = 1;
      label1073:
      parame.field_chattype = i;
      if (!bool) {
        break label1392;
      }
      i = 2;
      label1085:
      parame.expectImageFormat = i;
      if (!bs.isNullOrNil(str1))
      {
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        parame.field_fileType = 19;
        parame.field_authKey = str2;
        parame.fre = str1;
        parame.field_fileId = "";
      }
      ac.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.cZc.field_msgId, Boolean.valueOf(com.tencent.mm.an.f.aDD().hBp.contains("image_" + this.cZc.field_msgId)) });
      if (!com.tencent.mm.an.f.aDD().hBp.contains("image_" + this.cZc.field_msgId)) {
        break label1397;
      }
      com.tencent.mm.an.f.aDD().hBp.remove("image_" + this.cZc.field_msgId);
    }
    label1357:
    label1387:
    label1392:
    label1397:
    for (parame.field_autostart = true;; parame.field_autostart = false)
    {
      if (com.tencent.mm.an.f.aDD().b(parame, this.hIv)) {
        break label1405;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 196L, 1L, false);
      ac.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.hIq });
      this.hIq = "";
      AppMethodBeat.o(150674);
      return false;
      bool = false;
      break;
      parame.field_mediaId = (this.hIq + "_hevc");
      break label1007;
      i = 0;
      break label1073;
      i = 1;
      break label1085;
    }
    label1405:
    ac.i(this.TAG, "add recv task");
    AppMethodBeat.o(150674);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150675);
    if ((!bs.isNullOrNil(this.hIq)) && (com.tencent.mm.an.f.aDD() != null))
    {
      ac.d(this.TAG, "cancel recv task");
      com.tencent.mm.an.f.aDD().BR(this.hIq);
    }
    super.cancel();
    AppMethodBeat.o(150675);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150676);
    this.callback = paramg;
    paramg = (baf)this.rr.hvr.hvw;
    e locale = o.aFx().c(Long.valueOf(this.gdf));
    if (locale.dcd == 0L)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 195L, 1L, false);
      ac.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.gdf), locale });
      AppMethodBeat.o(150676);
      return -1;
    }
    if (locale.status != 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 194L, 1L, false);
      ac.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(locale.dcd), Integer.valueOf(locale.status) });
      AppMethodBeat.o(150676);
      return -1;
    }
    String str = locale.hGM;
    if (str.startsWith("SERVERID://"))
    {
      this.hIr = com.tencent.mm.b.g.getMessageDigest(locale.hGM.getBytes());
      this.hIs = o.aFx().p(this.hIr, null, ".temp");
      locale.Ce(this.hIr + ".temp");
      o.aFx().a(Long.valueOf(this.gdf), locale);
      ac.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(locale.dcd), Integer.valueOf(this.hGP), Integer.valueOf(locale.offset), Integer.valueOf(locale.hux), str, this.hIr, this.hIs });
      if (this.startTime == 0L)
      {
        this.startTime = bs.eWj();
        this.startOffset = locale.offset;
        if (this.hGP != 1) {
          break label452;
        }
      }
    }
    label452:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.fPn = i;
      if (!g(locale)) {
        break label459;
      }
      ac.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.hIq });
      AppMethodBeat.o(150676);
      return 0;
      this.hIr = locale.hGM;
      this.hIs = o.aFx().p(this.hIr, null, "");
      break;
    }
    label459:
    ac.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.hIq });
    locale.Ch("");
    locale.drx = 4096;
    o.aFx().a(Long.valueOf(this.gdf), locale);
    paramg.vTI = locale.offset;
    paramg.vTJ = this.hIo;
    paramg.vTH = locale.hux;
    if (this.hIp != null) {
      this.hIp.aIy();
    }
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150676);
    return i;
  }
  
  public final int getType()
  {
    return 109;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150677);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      ac.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      AppMethodBeat.o(150677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.fPn), Integer.valueOf(this.hux - this.startOffset) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150677);
      return;
    }
    paramString = (bag)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    paramq = o.aFx().c(Long.valueOf(this.gdf));
    paramInt1 = 0;
    if (paramString.vTJ <= 0)
    {
      ac.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.fPn), Integer.valueOf(this.hux - this.startOffset) });
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(150677);
      return;
      if ((paramString.vTK == null) || (paramString.vTJ != paramString.vTK.getILen()))
      {
        ac.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.vTI < 0) || (paramString.vTI + paramString.vTJ > paramString.vTH))
      {
        ac.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.vTI != paramq.offset)
      {
        ac.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.vTH <= 0)
      {
        ac.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(paramq, paramString.vTH, paramString.vTI, paramString.vTJ, paramString.vTK.getBuffer().xy)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(150677);
  }
  
  public final int securityLimitCount()
  {
    if (this.hGP == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.k
 * JD-Core Version:    0.7.0.1
 */