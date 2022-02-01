package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.w;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  String TAG;
  com.tencent.mm.al.g callback;
  bl dbD;
  int fLB;
  long fYz;
  private boolean gTP;
  int gTY;
  private int hgm;
  final com.tencent.mm.al.h hhI;
  public final long hhJ;
  private long hhK;
  private int hhL;
  private com.tencent.mm.modelstat.h hhM;
  String hhN;
  private String hhO;
  public String hhP;
  int hhQ;
  public boolean hhR;
  private int hhS;
  private String hhT;
  private int hhU;
  boolean hhV;
  private g.a hhW;
  private long msgId;
  private final com.tencent.mm.al.b rr;
  private int startOffset;
  long startTime;
  private int token;
  
  public k(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.al.h paramh)
  {
    this(paramLong1, paramLong2, paramInt, paramh, -1);
  }
  
  public k(long paramLong1, long paramLong2, int paramInt1, final com.tencent.mm.al.h paramh, int paramInt2)
  {
    AppMethodBeat.i(150673);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.hhK = -1L;
    this.hhM = null;
    this.msgId = -1L;
    this.dbD = null;
    this.hhN = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.fLB = 0;
    this.gTP = true;
    this.hhO = "";
    this.hhP = "";
    this.gTY = 0;
    this.hhQ = -1;
    this.hhR = false;
    this.hhS = -1;
    this.hhT = null;
    this.hhU = 0;
    this.token = -1;
    this.hhV = false;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150671);
        if (paramAnonymousInt == -21006)
        {
          ad.i(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { k.this.hhN });
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
          i.oh((int)k.this.hhJ);
          i.og((int)k.this.hhJ);
          l1 = k.this.startTime;
          l2 = bt.eGO();
          i = com.tencent.mm.ao.c.cu(aj.getContext());
          j = k.this.fLB;
          k = k.this.gTY;
          if (paramAnonymousd == null)
          {
            paramAnonymousString = "";
            if (paramAnonymousd != null) {
              break label304;
            }
          }
          label304:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fns)
          {
            paramAnonymousString = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc });
            new com.tencent.mm.g.b.a.h(paramAnonymousString).aBj();
            new com.tencent.mm.g.b.a.f(paramAnonymousString).aBj();
            k.this.callback.onSceneEnd(3, paramAnonymousInt, "", k.this);
            AppMethodBeat.o(150671);
            return 0;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break;
          }
        }
        e locale = o.ayF().b(Long.valueOf(k.this.fYz));
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == k.this.gTY)
          {
            ad.d(k.this.TAG, "cdntra ignore progress 100%");
            AppMethodBeat.o(150671);
            return 0;
          }
          k.this.hhV = true;
          if (!k.this.hhR) {
            k.this.hhR = paramAnonymousc.field_mtlnotify;
          }
          ad.i(k.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { k.this.hhN, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(k.this.hhR) });
          k.a(k.this, locale, k.this.gTY, locale.offset, (int)paramAnonymousc.field_finishedLength - locale.offset);
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label965;
          }
          i.og((int)k.this.hhJ);
          ad.e(k.this.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          k.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", k.this);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = k.this.startTime;
          l2 = bt.eGO();
          i = com.tencent.mm.ao.c.cu(aj.getContext());
          j = k.this.fLB;
          k = k.this.gTY;
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
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aBj();
          if (paramAnonymousd.field_retCode != 0)
          {
            paramAnonymousInt = paramAnonymousd.field_retCode;
            l1 = k.this.startTime;
            l2 = bt.eGO();
            i = com.tencent.mm.ao.c.cu(aj.getContext());
            j = k.this.fLB;
            k = k.this.gTY;
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
        for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fns)
        {
          new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aBj();
          AppMethodBeat.o(150671);
          return 0;
          ad.i(k.this.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
          if (locale.hgm == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 26L, locale.gTY, false);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 27L, 1L, false);
            paramAnonymousc = com.tencent.mm.plugin.report.service.h.vKh;
            if (k.this.dbD != null)
            {
              paramAnonymousString = k.this.dbD.field_talker;
              if (!w.pF(paramAnonymousString)) {
                break label1194;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymousc.idkeyStat(198L, l1, 1L, false);
              if (paramAnonymousd.field_convert2baseline)
              {
                ad.i(k.this.TAG, "cdntra need convert2baseline. file:%s", new Object[] { k.this.hhP });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(k.this.hhP, 60);
                ad.i(k.this.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!k.this.hhV) {
                break label1300;
              }
              k.a(k.this, locale, locale.offset, locale.offset, 0);
              break;
              paramAnonymousString = "";
              break label1059;
            }
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 21L, locale.gTY, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 22L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.vKh;
          if (k.this.dbD != null)
          {
            paramAnonymousString = k.this.dbD.field_talker;
            label1260:
            if (!w.pF(paramAnonymousString)) {
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
          k.a(k.this, locale, k.this.gTY, locale.offset, k.this.gTY - locale.offset);
          break;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label628;
          paramAnonymousc = paramAnonymousd.fns;
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
      this.hhI = paramh;
      this.hgm = paramInt1;
      this.hhJ = paramLong1;
      this.hhK = paramLong1;
      this.fYz = paramLong1;
      this.msgId = paramLong2;
      this.hhS = paramInt2;
      locale = o.ayF().b(Long.valueOf(this.fYz));
      if (paramInt1 != 1) {
        break label595;
      }
      this.fYz = locale.hgu;
      locale = o.ayF().b(Long.valueOf(this.fYz));
    }
    label595:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.fYz + "]");
      Object localObject = new b.a();
      ((b.a)localObject).gUU = new awn();
      ((b.a)localObject).gUV = new awo();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((b.a)localObject).funcId = 109;
      ((b.a)localObject).reqCmdId = 10;
      ((b.a)localObject).respCmdId = 1000000010;
      this.rr = ((b.a)localObject).atI();
      localObject = (awn)this.rr.gUS.gUX;
      this.dbD = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong2);
      ((awn)localObject).uKR = locale.offset;
      ((awn)localObject).uKQ = locale.gTY;
      ad.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(locale.offset), Integer.valueOf(locale.gTY), bt.eGN() });
      ((awn)localObject).uKZ = this.dbD.field_msgSvrId;
      ((awn)localObject).Cxx = new cmf().aEE(this.dbD.field_talker);
      ((awn)localObject).Cxy = new cmf().aEE((String)com.tencent.mm.kernel.g.afB().afk().get(2, null));
      ((awn)localObject).DvO = paramInt1;
      if (locale.offset == 0) {
        this.hhM = new com.tencent.mm.modelstat.h(getType(), false, locale.gTY);
      }
      this.hhL = 8192;
      if (paramh != null) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150670);
            paramh.a(this.hhY, this.hhZ, k.this);
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
    parame.nX(paramInt1);
    parame.setOffset(paramInt2 + paramInt3);
    this.hhL = paramInt3;
    if (paramArrayOfByte != null) {
      com.tencent.mm.vfs.i.e(this.hhP, paramArrayOfByte, paramArrayOfByte.length);
    }
    ad.d(this.TAG, "onGYNetEnd : offset = " + parame.offset + " totalLen = " + parame.gTY + " stack:[%s]", new Object[] { bt.eGN() });
    String str2 = null;
    paramArrayOfByte = str2;
    String str1;
    boolean bool1;
    String str3;
    com.tencent.mm.vfs.e locale;
    String str4;
    if (parame.ayh())
    {
      str1 = t.aFo(this.hhP);
      bool1 = t.aFl(this.hhP);
      str3 = this.hhP + "_hevc";
      locale = new com.tencent.mm.vfs.e(this.hhP);
      boolean bool2 = t.aFn(this.hhP);
      paramArrayOfByte = str1;
      if (!bool2) {
        break label563;
      }
      if (this.gTP) {
        break label453;
      }
      ad.e(this.TAG, "sceneEndproc: download jpg get hevc");
      bool1 = false;
      paramArrayOfByte = str1;
      if (!bool1) {
        break label611;
      }
      str2 = this.hhO + paramArrayOfByte;
      str1 = o.ayF().p(this.hhO, null, paramArrayOfByte);
      ad.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.hhO, this.hhP, str1 });
      paramArrayOfByte = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Tl(str2);
      str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Tl(str1);
      if (!bool2) {
        break label566;
      }
      new com.tencent.mm.vfs.e(str3).af(new com.tencent.mm.vfs.e(str4));
      locale.af(new com.tencent.mm.vfs.e(str1));
      label371:
      parame.xZ(str2);
      parame.yd(paramArrayOfByte);
      parame.xY(f.yf(str1));
      parame.oc(this.hgm);
    }
    for (paramArrayOfByte = str1;; paramArrayOfByte = str2)
    {
      if (o.ayF().a(Long.valueOf(this.fYz), parame) >= 0) {
        break label669;
      }
      ad.e(this.TAG, "onGYNetEnd : update img fail");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150678);
      return false;
      label453:
      locale.af(new com.tencent.mm.vfs.e(str3));
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str3, this.hhP) != 0)
      {
        ad.w(this.TAG, "download hevc decode failed");
        this.gTP = false;
        com.tencent.mm.vfs.i.deleteFile(str3);
        com.tencent.mm.vfs.i.deleteFile(this.hhP);
        g(parame);
        AppMethodBeat.o(150678);
        return false;
      }
      paramArrayOfByte = t.aFo(this.hhP);
      ad.i(this.TAG, "hevc download is hevc %b", new Object[] { Boolean.TRUE });
      label563:
      break;
      label566:
      if (com.tencent.mm.vfs.i.aMN(str4) > 0L)
      {
        com.tencent.mm.vfs.i.deleteFile(str4);
        com.tencent.mm.plugin.report.service.h.vKh.dB(944, 10);
      }
      locale.af(new com.tencent.mm.vfs.e(str1));
      break label371;
      label611:
      if (this.hgm == 1)
      {
        paramArrayOfByte = o.ayF().b(Long.valueOf(this.hhK));
        paramArrayOfByte.nY(0);
        o.ayF().a(Long.valueOf(this.hhK), paramArrayOfByte);
      }
      locale.delete();
    }
    label669:
    if (this.hhI != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150672);
          k.this.hhI.a(parame.offset, parame.gTY, k.this);
          AppMethodBeat.o(150672);
        }
      });
    }
    ad.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(parame.ayh()), this.hhN });
    if (parame.ayh())
    {
      if (bt.isNullOrNil(this.hhN)) {
        com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.fLB), Integer.valueOf(paramInt1 - this.startOffset) });
      }
      bool1 = false;
      if (this.hhQ > 0) {
        bool1 = o.ayF().a(paramArrayOfByte, parame.hgl, this.hhQ, 1, this.dbD.eOU, this.dbD.eOV);
      }
      if (bool1)
      {
        parame.ayj();
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.dbD.field_msgId, this.dbD);
      }
      o.ayF().a(Long.valueOf(this.fYz), parame);
      ad.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.hhP, paramArrayOfByte, parame.hgj, this.hhT });
      if (this.hhM != null) {
        this.hhM.mB(parame.gTY);
      }
      if ((!bt.isNullOrNil(this.hhT)) && (this.hhU > 0))
      {
        com.tencent.mm.plugin.image.c.cGv();
        com.tencent.mm.plugin.image.c.apT().E(this.hhT, this.hhU, paramArrayOfByte);
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
    if (bt.isNullOrNil(parame.hgv))
    {
      AppMethodBeat.o(150674);
      return false;
    }
    Map localMap = bw.K(parame.hgv, "msg");
    if (localMap == null)
    {
      ad.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { parame.hgv });
      AppMethodBeat.o(150674);
      return false;
    }
    this.gTY = 0;
    String str2;
    String str1;
    if (this.hgm != 1)
    {
      str2 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      this.gTY = bt.getInt((String)localMap.get(".msg.img.$length"), 0);
      if (this.hgm == 1) {
        break label296;
      }
      str3 = (String)localMap.get(".msg.img.$tpurl");
      str1 = str3;
      if (bt.isNullOrNil(str3)) {
        break label348;
      }
      this.gTY = bt.getInt((String)localMap.get(".msg.img.$tplength"), 0);
      str1 = str3;
    }
    label296:
    label348:
    for (;;)
    {
      ad.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.hgm), Integer.valueOf(this.gTY), str2, str1 });
      if ((!bt.isNullOrNil(str2)) || (!bt.isNullOrNil(str1))) {
        break label351;
      }
      ad.e(this.TAG, "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(150674);
      return false;
      str2 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      this.gTY = bt.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
      break;
      str3 = (String)localMap.get(".msg.img.$tphdurl");
      str1 = str3;
      if (!bt.isNullOrNil(str3))
      {
        this.gTY = bt.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
        str1 = str3;
      }
    }
    label351:
    String str3 = (String)localMap.get(".msg.img.$aeskey");
    if (bt.isNullOrNil(str3))
    {
      ad.e(this.TAG, "cdntra get aes key failed.");
      AppMethodBeat.o(150674);
      return false;
    }
    this.hhN = com.tencent.mm.ao.c.a("downimg", parame.hgr, this.dbD.field_talker, this.dbD.field_msgId);
    if (bt.isNullOrNil(this.hhN))
    {
      ad.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.fYz) });
      AppMethodBeat.o(150674);
      return false;
    }
    String str4 = (String)localMap.get(".msg.img.$md5");
    int i;
    boolean bool;
    if ((bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str4)) && ((bt.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.hgm == 1)))
    {
      com.tencent.mm.plugin.image.c.cGv();
      String str5 = com.tencent.mm.plugin.image.c.apT().fP(str4, this.gTY);
      i = (int)com.tencent.mm.vfs.i.aMN(str5);
      int j = this.gTY - i;
      String str6 = this.TAG;
      int k = this.gTY;
      Object localObject = localMap.get(".msg.img.$cdnbigimgurl");
      if (this.hgm == 1)
      {
        bool = true;
        ad.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str4, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str5, Integer.valueOf(j), this.hhP });
        if (bt.isNullOrNil(str5)) {
          break label913;
        }
        if ((j < 0) || (j > 16)) {
          break label927;
        }
        bool = false;
        if (!bt.kU(str5, this.hhP)) {
          if (com.tencent.mm.vfs.i.lC(str5, this.hhP) < 0L) {
            break label907;
          }
        }
      }
      label907:
      for (bool = true;; bool = false)
      {
        ad.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str5, this.hhP, Boolean.valueOf(bool) });
        a(parame, this.gTY, this.gTY, 0, null);
        if (this.dbD != null) {
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(this.dbD.field_talker, "update", this.dbD));
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(13267, new Object[] { str2, Long.valueOf(this.dbD.field_msgSvrId), str4, Long.valueOf(this.dbD.field_createTime / 1000L), this.dbD.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
        AppMethodBeat.o(150674);
        return true;
        bool = false;
        break;
      }
      label913:
      this.hhT = str4;
      this.hhU = this.gTY;
    }
    label927:
    if ((this.gTP) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).bTV()))
    {
      bool = true;
      ad.i(this.TAG, "checkUseCdn: %s, %s", new Object[] { Boolean.valueOf(this.gTP), Boolean.valueOf(bool) });
      parame = new com.tencent.mm.i.g();
      if (!bool) {
        break label1357;
      }
      parame.field_mediaId = this.hhN;
      label1007:
      parame.field_fullpath = this.hhP;
      parame.field_fileType = this.fLB;
      parame.field_totalLen = this.gTY;
      parame.field_aesKey = str3;
      parame.field_fileId = str2;
      parame.field_priority = com.tencent.mm.i.a.fmV;
      parame.fnH = this.hhW;
      if (!w.pF(this.dbD.field_talker)) {
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
      if (!bt.isNullOrNil(str1))
      {
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        parame.field_fileType = 19;
        parame.field_authKey = str2;
        parame.fnK = str1;
        parame.field_fileId = "";
      }
      ad.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.dbD.field_msgId, Boolean.valueOf(com.tencent.mm.ao.f.awL().haO.contains("image_" + this.dbD.field_msgId)) });
      if (!com.tencent.mm.ao.f.awL().haO.contains("image_" + this.dbD.field_msgId)) {
        break label1397;
      }
      com.tencent.mm.ao.f.awL().haO.remove("image_" + this.dbD.field_msgId);
    }
    label1357:
    label1387:
    label1392:
    label1397:
    for (parame.field_autostart = true;; parame.field_autostart = false)
    {
      if (com.tencent.mm.ao.f.awL().b(parame, this.hhS)) {
        break label1405;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 196L, 1L, false);
      ad.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.hhN });
      this.hhN = "";
      AppMethodBeat.o(150674);
      return false;
      bool = false;
      break;
      parame.field_mediaId = (this.hhN + "_hevc");
      break label1007;
      i = 0;
      break label1073;
      i = 1;
      break label1085;
    }
    label1405:
    ad.i(this.TAG, "add recv task");
    AppMethodBeat.o(150674);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150675);
    if ((!bt.isNullOrNil(this.hhN)) && (com.tencent.mm.ao.f.awL() != null))
    {
      ad.d(this.TAG, "cancel recv task");
      com.tencent.mm.ao.f.awL().xL(this.hhN);
    }
    super.cancel();
    AppMethodBeat.o(150675);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150676);
    this.callback = paramg;
    paramg = (awn)this.rr.gUS.gUX;
    e locale = o.ayF().b(Long.valueOf(this.fYz));
    if (locale.deI == 0L)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 195L, 1L, false);
      ad.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.fYz), locale });
      AppMethodBeat.o(150676);
      return -1;
    }
    if (locale.status != 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 194L, 1L, false);
      ad.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(locale.deI), Integer.valueOf(locale.status) });
      AppMethodBeat.o(150676);
      return -1;
    }
    String str = locale.hgj;
    if (str.startsWith("SERVERID://"))
    {
      this.hhO = com.tencent.mm.b.g.getMessageDigest(locale.hgj.getBytes());
      this.hhP = o.ayF().p(this.hhO, null, ".temp");
      locale.xZ(this.hhO + ".temp");
      o.ayF().a(Long.valueOf(this.fYz), locale);
      ad.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(locale.deI), Integer.valueOf(this.hgm), Integer.valueOf(locale.offset), Integer.valueOf(locale.gTY), str, this.hhO, this.hhP });
      if (this.startTime == 0L)
      {
        this.startTime = bt.eGO();
        this.startOffset = locale.offset;
        if (this.hgm != 1) {
          break label452;
        }
      }
    }
    label452:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.fLB = i;
      if (!g(locale)) {
        break label459;
      }
      ad.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.hhN });
      AppMethodBeat.o(150676);
      return 0;
      this.hhO = locale.hgj;
      this.hhP = o.ayF().p(this.hhO, null, "");
      break;
    }
    label459:
    ad.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.hhN });
    locale.yc("");
    locale.dtM = 4096;
    o.ayF().a(Long.valueOf(this.fYz), locale);
    paramg.uKR = locale.offset;
    paramg.uKS = this.hhL;
    paramg.uKQ = locale.gTY;
    if (this.hhM != null) {
      this.hhM.aBI();
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
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      AppMethodBeat.o(150677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.fLB), Integer.valueOf(this.gTY - this.startOffset) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150677);
      return;
    }
    paramString = (awo)((com.tencent.mm.al.b)paramq).gUT.gUX;
    paramq = o.ayF().b(Long.valueOf(this.fYz));
    paramInt1 = 0;
    if (paramString.uKS <= 0)
    {
      ad.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.fLB), Integer.valueOf(this.gTY - this.startOffset) });
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(150677);
      return;
      if ((paramString.uKT == null) || (paramString.uKS != paramString.uKT.getILen()))
      {
        ad.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.uKR < 0) || (paramString.uKR + paramString.uKS > paramString.uKQ))
      {
        ad.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.uKR != paramq.offset)
      {
        ad.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.uKQ <= 0)
      {
        ad.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(paramq, paramString.uKQ, paramString.uKR, paramString.uKS, paramString.uKT.getBuffer().wA)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(150677);
  }
  
  public final int securityLimitCount()
  {
    if (this.hgm == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.k
 * JD-Core Version:    0.7.0.1
 */