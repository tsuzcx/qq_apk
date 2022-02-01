package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class m
  extends n
  implements com.tencent.mm.network.k
{
  String TAG;
  com.tencent.mm.al.f callback;
  bu dku;
  int giN;
  long gwP;
  private boolean hMG;
  int hMP;
  private int hZz;
  final com.tencent.mm.al.g iaZ;
  public final long iba;
  private long ibb;
  private int ibc;
  private com.tencent.mm.modelstat.h ibd;
  String ibe;
  private String ibf;
  public String ibg;
  int ibh;
  public boolean ibi;
  private int ibj;
  private String ibk;
  private int ibl;
  boolean ibm;
  private g.a ibn;
  private long msgId;
  private final com.tencent.mm.al.b rr;
  private int startOffset;
  long startTime;
  private int token;
  
  public m(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.al.g paramg)
  {
    this(paramLong1, paramLong2, paramInt, paramg, -1);
  }
  
  public m(long paramLong1, long paramLong2, int paramInt1, final com.tencent.mm.al.g paramg, int paramInt2)
  {
    AppMethodBeat.i(150673);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.ibb = -1L;
    this.ibd = null;
    this.msgId = -1L;
    this.dku = null;
    this.ibe = "";
    this.startTime = 0L;
    this.startOffset = -1;
    this.giN = 0;
    this.hMG = true;
    this.ibf = "";
    this.ibg = "";
    this.hMP = 0;
    this.ibh = -1;
    this.ibi = false;
    this.ibj = -1;
    this.ibk = null;
    this.ibl = 0;
    this.token = -1;
    this.ibm = false;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150671);
        if (paramAnonymousInt == -21006)
        {
          ad.i(m.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { m.this.ibe });
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
          k.py((int)m.this.iba);
          k.pw((int)m.this.iba);
          l1 = m.this.startTime;
          l2 = com.tencent.mm.sdk.platformtools.bt.flT();
          i = com.tencent.mm.ao.c.cA(aj.getContext());
          j = m.this.giN;
          k = m.this.hMP;
          if (paramAnonymousd == null)
          {
            paramAnonymousString = "";
            if (paramAnonymousd != null) {
              break label304;
            }
          }
          label304:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fIT)
          {
            paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc });
            new j(paramAnonymousString).aLk();
            new com.tencent.mm.g.b.a.h(paramAnonymousString).aLk();
            m.this.callback.onSceneEnd(3, paramAnonymousInt, "", m.this);
            AppMethodBeat.o(150671);
            return 0;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break;
          }
        }
        g localg = q.aIF().c(Long.valueOf(m.this.gwP));
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == m.this.hMP)
          {
            ad.d(m.this.TAG, "cdntra ignore progress 100%");
            AppMethodBeat.o(150671);
            return 0;
          }
          m.this.ibm = true;
          if (!m.this.ibi) {
            m.this.ibi = paramAnonymousc.field_mtlnotify;
          }
          ad.i(m.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { m.this.ibe, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(m.this.ibi) });
          m.a(m.this, localg, m.this.hMP, localg.offset, (int)paramAnonymousc.field_finishedLength - localg.offset);
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label965;
          }
          k.pw((int)m.this.iba);
          ad.e(m.this.TAG, "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          m.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", m.this);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = m.this.startTime;
          l2 = com.tencent.mm.sdk.platformtools.bt.flT();
          i = com.tencent.mm.ao.c.cA(aj.getContext());
          j = m.this.giN;
          k = m.this.hMP;
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
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLk();
          if (paramAnonymousd.field_retCode != 0)
          {
            paramAnonymousInt = paramAnonymousd.field_retCode;
            l1 = m.this.startTime;
            l2 = com.tencent.mm.sdk.platformtools.bt.flT();
            i = com.tencent.mm.ao.c.cA(aj.getContext());
            j = m.this.giN;
            k = m.this.hMP;
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
        for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fIT)
        {
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLk();
          AppMethodBeat.o(150671);
          return 0;
          ad.i(m.this.TAG, "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
          if (localg.hZz == 1)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 26L, localg.hMP, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 27L, 1L, false);
            paramAnonymousc = com.tencent.mm.plugin.report.service.g.yhR;
            if (m.this.dku != null)
            {
              paramAnonymousString = m.this.dku.field_talker;
              if (!w.vF(paramAnonymousString)) {
                break label1194;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymousc.idkeyStat(198L, l1, 1L, false);
              if (paramAnonymousd.field_convert2baseline)
              {
                ad.i(m.this.TAG, "cdntra need convert2baseline. file:%s", new Object[] { m.this.ibg });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(m.this.ibg, 60);
                ad.i(m.this.TAG, "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!m.this.ibm) {
                break label1300;
              }
              m.a(m.this, localg, localg.offset, localg.offset, 0);
              break;
              paramAnonymousString = "";
              break label1059;
            }
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 21L, localg.hMP, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 22L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.g.yhR;
          if (m.this.dku != null)
          {
            paramAnonymousString = m.this.dku.field_talker;
            label1260:
            if (!w.vF(paramAnonymousString)) {
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
          m.a(m.this, localg, m.this.hMP, localg.offset, m.this.hMP - localg.offset);
          break;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label628;
          paramAnonymousc = paramAnonymousd.fIT;
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
    g localg;
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramg != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.iaZ = paramg;
      this.hZz = paramInt1;
      this.iba = paramLong1;
      this.ibb = paramLong1;
      this.gwP = paramLong1;
      this.msgId = paramLong2;
      this.ibj = paramInt2;
      localg = q.aIF().c(Long.valueOf(this.gwP));
      if (paramInt1 != 1) {
        break label595;
      }
      this.gwP = localg.hZH;
      localg = q.aIF().c(Long.valueOf(this.gwP));
    }
    label595:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.gwP + "]");
      Object localObject = new b.a();
      ((b.a)localObject).hNM = new bej();
      ((b.a)localObject).hNN = new bek();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((b.a)localObject).funcId = 109;
      ((b.a)localObject).hNO = 10;
      ((b.a)localObject).respCmdId = 1000000010;
      this.rr = ((b.a)localObject).aDC();
      localObject = (bej)this.rr.hNK.hNQ;
      this.dku = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramLong2);
      ((bej)localObject).xcL = localg.offset;
      ((bej)localObject).xcK = localg.hMP;
      ad.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(localg.offset), Integer.valueOf(localg.hMP), com.tencent.mm.sdk.platformtools.bt.flS() });
      ((bej)localObject).xbt = this.dku.field_msgSvrId;
      ((bej)localObject).Fvi = new cwt().aPy(this.dku.field_talker);
      ((bej)localObject).Fvj = new cwt().aPy((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null));
      ((bej)localObject).GAB = paramInt1;
      if (localg.offset == 0) {
        this.ibd = new com.tencent.mm.modelstat.h(getType(), false, localg.hMP);
      }
      this.ibc = 8192;
      if (paramg != null) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150670);
            paramg.a(this.ibp, this.ibq, m.this);
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
  
  private boolean a(final g paramg, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150678);
    paramg.pn(paramInt1);
    paramg.setOffset(paramInt2 + paramInt3);
    this.ibc = paramInt3;
    if (paramArrayOfByte != null) {
      com.tencent.mm.vfs.i.e(this.ibg, paramArrayOfByte, paramArrayOfByte.length);
    }
    ad.d(this.TAG, "onGYNetEnd : offset = " + paramg.offset + " totalLen = " + paramg.hMP + " stack:[%s]", new Object[] { com.tencent.mm.sdk.platformtools.bt.flS() });
    String str2 = null;
    paramArrayOfByte = str2;
    String str1;
    boolean bool1;
    String str3;
    com.tencent.mm.vfs.e locale;
    String str4;
    if (paramg.aIi())
    {
      str1 = t.aQl(this.ibg);
      bool1 = t.aQi(this.ibg);
      str3 = this.ibg + "_hevc";
      locale = new com.tencent.mm.vfs.e(this.ibg);
      boolean bool2 = t.aQk(this.ibg);
      paramArrayOfByte = str1;
      if (!bool2) {
        break label563;
      }
      if (this.hMG) {
        break label453;
      }
      ad.e(this.TAG, "sceneEndproc: download jpg get hevc");
      bool1 = false;
      paramArrayOfByte = str1;
      if (!bool1) {
        break label611;
      }
      str2 = this.ibf + paramArrayOfByte;
      str1 = q.aIF().o(this.ibf, null, paramArrayOfByte);
      ad.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.ibf, this.ibg, str1 });
      paramArrayOfByte = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(str2);
      str4 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(str1);
      if (!bool2) {
        break label566;
      }
      new com.tencent.mm.vfs.e(str3).ag(new com.tencent.mm.vfs.e(str4));
      locale.ag(new com.tencent.mm.vfs.e(str1));
      label371:
      paramg.Fd(str2);
      paramg.Fh(paramArrayOfByte);
      paramg.Fc(h.Fj(str1));
      paramg.ps(this.hZz);
    }
    for (paramArrayOfByte = str1;; paramArrayOfByte = str2)
    {
      if (q.aIF().a(Long.valueOf(this.gwP), paramg) >= 0) {
        break label669;
      }
      ad.e(this.TAG, "onGYNetEnd : update img fail");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150678);
      return false;
      label453:
      locale.ag(new com.tencent.mm.vfs.e(str3));
      if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str3, this.ibg) != 0)
      {
        ad.w(this.TAG, "download hevc decode failed");
        this.hMG = false;
        com.tencent.mm.vfs.i.deleteFile(str3);
        com.tencent.mm.vfs.i.deleteFile(this.ibg);
        d(paramg);
        AppMethodBeat.o(150678);
        return false;
      }
      paramArrayOfByte = t.aQl(this.ibg);
      ad.i(this.TAG, "hevc download is hevc %b", new Object[] { Boolean.TRUE });
      label563:
      break;
      label566:
      if (com.tencent.mm.vfs.i.aYo(str4) > 0L)
      {
        com.tencent.mm.vfs.i.deleteFile(str4);
        com.tencent.mm.plugin.report.service.g.yhR.dD(944, 10);
      }
      locale.ag(new com.tencent.mm.vfs.e(str1));
      break label371;
      label611:
      if (this.hZz == 1)
      {
        paramArrayOfByte = q.aIF().c(Long.valueOf(this.ibb));
        paramArrayOfByte.po(0);
        q.aIF().a(Long.valueOf(this.ibb), paramArrayOfByte);
      }
      locale.delete();
    }
    label669:
    if (this.iaZ != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150672);
          m.this.iaZ.a(paramg.offset, paramg.hMP, m.this);
          AppMethodBeat.o(150672);
        }
      });
    }
    ad.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(paramg.aIi()), this.ibe });
    if (paramg.aIi())
    {
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.ibe)) {
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.giN), Integer.valueOf(paramInt1 - this.startOffset) });
      }
      bool1 = false;
      if (this.ibh > 0) {
        bool1 = q.aIF().a(paramArrayOfByte, paramg.hZy, this.ibh, 1, this.dku.fkr, this.dku.fks);
      }
      if (bool1)
      {
        paramg.aIk();
        ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.dku.field_msgId, this.dku);
      }
      q.aIF().a(Long.valueOf(this.gwP), paramg);
      ad.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.ibg, paramArrayOfByte, paramg.hZw, this.ibk });
      if (this.ibd != null) {
        this.ibd.so(paramg.hMP);
      }
      if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.ibk)) && (this.ibl > 0))
      {
        com.tencent.mm.plugin.image.c.dcR();
        com.tencent.mm.plugin.image.c.azx().E(this.ibk, this.ibl, paramArrayOfByte);
      }
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(150678);
      return false;
    }
    AppMethodBeat.o(150678);
    return true;
  }
  
  private boolean d(g paramg)
  {
    AppMethodBeat.i(150674);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramg.hZI))
    {
      AppMethodBeat.o(150674);
      return false;
    }
    Map localMap = bw.M(paramg.hZI, "msg");
    if (localMap == null)
    {
      ad.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.hZI });
      AppMethodBeat.o(150674);
      return false;
    }
    this.hMP = 0;
    String str2;
    String str1;
    if (this.hZz != 1)
    {
      str2 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      this.hMP = com.tencent.mm.sdk.platformtools.bt.getInt((String)localMap.get(".msg.img.$length"), 0);
      if (this.hZz == 1) {
        break label296;
      }
      str3 = (String)localMap.get(".msg.img.$tpurl");
      str1 = str3;
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str3)) {
        break label348;
      }
      this.hMP = com.tencent.mm.sdk.platformtools.bt.getInt((String)localMap.get(".msg.img.$tplength"), 0);
      str1 = str3;
    }
    label296:
    label348:
    for (;;)
    {
      ad.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.hZz), Integer.valueOf(this.hMP), str2, str1 });
      if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str2)) || (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str1))) {
        break label351;
      }
      ad.e(this.TAG, "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(150674);
      return false;
      str2 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      this.hMP = com.tencent.mm.sdk.platformtools.bt.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
      break;
      str3 = (String)localMap.get(".msg.img.$tphdurl");
      str1 = str3;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str3))
      {
        this.hMP = com.tencent.mm.sdk.platformtools.bt.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
        str1 = str3;
      }
    }
    label351:
    String str3 = (String)localMap.get(".msg.img.$aeskey");
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str3))
    {
      ad.e(this.TAG, "cdntra get aes key failed.");
      AppMethodBeat.o(150674);
      return false;
    }
    this.ibe = com.tencent.mm.ao.c.a("downimg", paramg.hZE, this.dku.field_talker, this.dku.field_msgId);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.ibe))
    {
      ad.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.gwP) });
      AppMethodBeat.o(150674);
      return false;
    }
    String str4 = (String)localMap.get(".msg.img.$md5");
    int i;
    boolean bool;
    if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str1)) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str4)) && ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.hZz == 1)))
    {
      com.tencent.mm.plugin.image.c.dcR();
      String str5 = com.tencent.mm.plugin.image.c.azx().gq(str4, this.hMP);
      i = (int)com.tencent.mm.vfs.i.aYo(str5);
      int j = this.hMP - i;
      String str6 = this.TAG;
      int k = this.hMP;
      Object localObject = localMap.get(".msg.img.$cdnbigimgurl");
      if (this.hZz == 1)
      {
        bool = true;
        ad.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str4, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str5, Integer.valueOf(j), this.ibg });
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str5)) {
          break label913;
        }
        if ((j < 0) || (j > 16)) {
          break label927;
        }
        bool = false;
        if (!com.tencent.mm.sdk.platformtools.bt.lQ(str5, this.ibg)) {
          if (com.tencent.mm.vfs.i.mz(str5, this.ibg) < 0L) {
            break label907;
          }
        }
      }
      label907:
      for (bool = true;; bool = false)
      {
        ad.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str5, this.ibg, Boolean.valueOf(bool) });
        a(paramg, this.hMP, this.hMP, 0, null);
        if (this.dku != null) {
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(this.dku.field_talker, "update", this.dku));
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(13267, new Object[] { str2, Long.valueOf(this.dku.field_msgSvrId), str4, Long.valueOf(this.dku.field_createTime / 1000L), this.dku.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
        AppMethodBeat.o(150674);
        return true;
        bool = false;
        break;
      }
      label913:
      this.ibk = str4;
      this.ibl = this.hMP;
    }
    label927:
    if ((this.hMG) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).cfN()))
    {
      bool = true;
      ad.i(this.TAG, "checkUseCdn: %s, %s", new Object[] { Boolean.valueOf(this.hMG), Boolean.valueOf(bool) });
      paramg = new com.tencent.mm.i.g();
      if (!bool) {
        break label1364;
      }
      paramg.fJi = "task_NetSceneGetMsgImg_1";
      paramg.field_mediaId = this.ibe;
      label1014:
      paramg.field_fullpath = this.ibg;
      paramg.field_fileType = this.giN;
      paramg.field_totalLen = this.hMP;
      paramg.field_aesKey = str3;
      paramg.field_fileId = str2;
      paramg.field_priority = com.tencent.mm.i.a.fIw;
      paramg.fJj = this.ibn;
      if (!w.vF(this.dku.field_talker)) {
        break label1401;
      }
      i = 1;
      label1080:
      paramg.field_chattype = i;
      if (!bool) {
        break label1406;
      }
      i = 2;
      label1092:
      paramg.expectImageFormat = i;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str1))
      {
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        paramg.field_fileType = 19;
        paramg.field_authKey = str2;
        paramg.fJm = str1;
        paramg.field_fileId = "";
      }
      ad.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.dku.field_msgId, Boolean.valueOf(com.tencent.mm.ao.f.aGI().hTO.contains("image_" + this.dku.field_msgId)) });
      if (!com.tencent.mm.ao.f.aGI().hTO.contains("image_" + this.dku.field_msgId)) {
        break label1411;
      }
      com.tencent.mm.ao.f.aGI().hTO.remove("image_" + this.dku.field_msgId);
    }
    label1411:
    for (paramg.field_autostart = true;; paramg.field_autostart = false)
    {
      if (com.tencent.mm.ao.f.aGI().b(paramg, this.ibj)) {
        break label1419;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 196L, 1L, false);
      ad.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.ibe });
      this.ibe = "";
      AppMethodBeat.o(150674);
      return false;
      bool = false;
      break;
      label1364:
      paramg.fJi = "task_NetSceneGetMsgImg_2";
      paramg.field_mediaId = (this.ibe + "_hevc");
      break label1014;
      label1401:
      i = 0;
      break label1080;
      label1406:
      i = 1;
      break label1092;
    }
    label1419:
    ad.i(this.TAG, "add recv task");
    AppMethodBeat.o(150674);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150675);
    if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.ibe)) && (com.tencent.mm.ao.f.aGI() != null))
    {
      ad.d(this.TAG, "cancel recv task");
      com.tencent.mm.ao.f.aGI().EQ(this.ibe);
    }
    super.cancel();
    AppMethodBeat.o(150675);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(150676);
    this.callback = paramf;
    paramf = (bej)this.rr.hNK.hNQ;
    g localg = q.aIF().c(Long.valueOf(this.gwP));
    if (localg.dnz == 0L)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 195L, 1L, false);
      ad.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.gwP), localg });
      AppMethodBeat.o(150676);
      return -1;
    }
    if (localg.status != 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 194L, 1L, false);
      ad.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(localg.dnz), Integer.valueOf(localg.status) });
      AppMethodBeat.o(150676);
      return -1;
    }
    String str = localg.hZw;
    if (str.startsWith("SERVERID://"))
    {
      this.ibf = com.tencent.mm.b.g.getMessageDigest(localg.hZw.getBytes());
      this.ibg = q.aIF().o(this.ibf, null, ".temp");
      localg.Fd(this.ibf + ".temp");
      q.aIF().a(Long.valueOf(this.gwP), localg);
      ad.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(localg.dnz), Integer.valueOf(this.hZz), Integer.valueOf(localg.offset), Integer.valueOf(localg.hMP), str, this.ibf, this.ibg });
      if (this.startTime == 0L)
      {
        this.startTime = com.tencent.mm.sdk.platformtools.bt.flT();
        this.startOffset = localg.offset;
        if (this.hZz != 1) {
          break label452;
        }
      }
    }
    label452:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.giN = i;
      if (!d(localg)) {
        break label459;
      }
      ad.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.ibe });
      AppMethodBeat.o(150676);
      return 0;
      this.ibf = localg.hZw;
      this.ibg = q.aIF().o(this.ibf, null, "");
      break;
    }
    label459:
    ad.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.ibe });
    localg.Fg("");
    localg.dDp = 4096;
    q.aIF().a(Long.valueOf(this.gwP), localg);
    paramf.xcL = localg.offset;
    paramf.xcM = this.ibc;
    paramf.xcK = localg.hMP;
    if (this.ibd != null) {
      this.ibd.aLI();
    }
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150676);
    return i;
  }
  
  public final int getType()
  {
    return 109;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150677);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.ibe)))
    {
      ad.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.ibe });
      AppMethodBeat.o(150677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.giN), Integer.valueOf(this.hMP - this.startOffset) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150677);
      return;
    }
    paramString = (bek)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    paramq = q.aIF().c(Long.valueOf(this.gwP));
    paramInt1 = 0;
    if (paramString.xcM <= 0)
    {
      ad.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.giN), Integer.valueOf(this.hMP - this.startOffset) });
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(150677);
      return;
      if ((paramString.xcN == null) || (paramString.xcM != paramString.xcN.getILen()))
      {
        ad.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.xcL < 0) || (paramString.xcL + paramString.xcM > paramString.xcK))
      {
        ad.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.xcL != paramq.offset)
      {
        ad.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.xcK <= 0)
      {
        ad.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(paramq, paramString.xcK, paramString.xcL, paramString.xcM, paramString.xcN.getBuffer().zr)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(150677);
  }
  
  public final int securityLimitCount()
  {
    if (this.hZz == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.m
 * JD-Core Version:    0.7.0.1
 */