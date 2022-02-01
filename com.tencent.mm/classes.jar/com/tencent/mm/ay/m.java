package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class m
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  private String TAG;
  private com.tencent.mm.an.i callback;
  private ca fvt;
  private int jGU;
  private long jXT;
  private int kPS;
  private boolean lAM;
  private int lAW;
  private int lNK;
  private final j lPi;
  public final long lPj;
  private long lPk;
  private int lPl;
  private com.tencent.mm.modelstat.g lPm;
  private String lPn;
  private int lPo;
  private String lPp;
  public String lPq;
  int lPr;
  public boolean lPs;
  private int lPt;
  private String lPu;
  private int lPv;
  private boolean lPw;
  private g.a lPx;
  private long msgId;
  private final com.tencent.mm.an.d rr;
  private long startTime;
  
  public m(long paramLong1, long paramLong2, int paramInt, j paramj)
  {
    this(paramLong1, paramLong2, paramInt, paramj, -1);
  }
  
  public m(long paramLong1, long paramLong2, int paramInt1, final j paramj, int paramInt2)
  {
    AppMethodBeat.i(150673);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.lPk = -1L;
    this.lPm = null;
    this.msgId = -1L;
    this.fvt = null;
    this.lPn = "";
    this.startTime = 0L;
    this.lPo = -1;
    this.jGU = 0;
    this.lAM = true;
    this.lPp = "";
    this.lPq = "";
    this.lAW = 0;
    this.lPr = -1;
    this.lPs = false;
    this.lPt = -1;
    this.lPu = null;
    this.lPv = 0;
    this.kPS = -1;
    this.lPw = false;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150671);
        if (paramAnonymousInt == -21006)
        {
          Log.i(m.a(m.this), "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { m.b(m.this) });
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
          k.wp((int)m.c(m.this));
          k.wo((int)m.c(m.this));
          l1 = m.d(m.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
          j = m.e(m.this);
          k = m.f(m.this);
          if (paramAnonymousd == null)
          {
            paramAnonymousString = "";
            if (paramAnonymousd != null) {
              break label304;
            }
          }
          label304:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.iUs)
          {
            paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc });
            new ae(paramAnonymousString).bpa();
            new ac(paramAnonymousString).bpa();
            m.g(m.this).onSceneEnd(3, paramAnonymousInt, "", m.this);
            AppMethodBeat.o(150671);
            return 0;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break;
          }
        }
        g localg = q.bmh().b(Long.valueOf(m.h(m.this)));
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == m.f(m.this))
          {
            Log.d(m.a(m.this), "cdntra ignore progress 100%");
            AppMethodBeat.o(150671);
            return 0;
          }
          m.i(m.this);
          if (!m.j(m.this)) {
            m.a(m.this, paramAnonymousc.field_mtlnotify);
          }
          Log.i(m.a(m.this), "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { m.b(m.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(m.j(m.this)) });
          m.a(m.this, localg, m.f(m.this), localg.offset, (int)paramAnonymousc.field_finishedLength - localg.offset);
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label966;
          }
          k.wo((int)m.c(m.this));
          Log.e(m.a(m.this), "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
          m.g(m.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", m.this);
          paramAnonymousInt = paramAnonymousd.field_retCode;
          l1 = m.d(m.this);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
          j = m.e(m.this);
          k = m.f(m.this);
          if (paramAnonymousd != null) {
            break label1340;
          }
          paramAnonymousString = "";
          label629:
          if (paramAnonymousd != null) {
            break label1349;
          }
          paramAnonymousc = "";
          label637:
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bpa();
          if (paramAnonymousd.field_retCode != 0)
          {
            paramAnonymousInt = paramAnonymousd.field_retCode;
            l1 = m.d(m.this);
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
            j = m.e(m.this);
            k = m.f(m.this);
            if (paramAnonymousd != null) {
              break label1358;
            }
            paramAnonymousString = "";
            label825:
            if (paramAnonymousd != null) {
              break label1367;
            }
          }
        }
        label966:
        label1358:
        label1367:
        for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.iUs)
        {
          new ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bpa();
          AppMethodBeat.o(150671);
          return 0;
          Log.i(m.a(m.this), "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
          if (localg.lNK == 1)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 26L, localg.lAW, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 27L, 1L, false);
            paramAnonymousc = com.tencent.mm.plugin.report.service.h.IzE;
            if (m.k(m.this) != null)
            {
              paramAnonymousString = m.k(m.this).field_talker;
              if (!ab.Lj(paramAnonymousString)) {
                break label1196;
              }
            }
            for (l1 = 29L;; l1 = 28L)
            {
              paramAnonymousc.idkeyStat(198L, l1, 1L, false);
              if (paramAnonymousd.field_convert2baseline)
              {
                Log.i(m.a(m.this), "cdntra need convert2baseline. file:%s", new Object[] { m.l(m.this) });
                paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(m.l(m.this), 60);
                Log.i(m.a(m.this), "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              }
              if (!m.m(m.this)) {
                break label1302;
              }
              m.a(m.this, localg, localg.offset, localg.offset, 0);
              break;
              paramAnonymousString = "";
              break label1060;
            }
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 21L, localg.lAW, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 22L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.IzE;
          if (m.k(m.this) != null)
          {
            paramAnonymousString = m.k(m.this).field_talker;
            label1262:
            if (!ab.Lj(paramAnonymousString)) {
              break label1294;
            }
          }
          for (l1 = 24L;; l1 = 23L)
          {
            paramAnonymousc.idkeyStat(198L, l1, 1L, false);
            break;
            paramAnonymousString = "";
            break label1262;
          }
          m.a(m.this, localg, m.f(m.this), localg.offset, m.f(m.this) - localg.offset);
          break;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label629;
          paramAnonymousc = paramAnonymousd.iUs;
          break label637;
          paramAnonymousString = paramAnonymousd.field_transInfo;
          break label825;
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
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramj != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.lPi = paramj;
      this.lNK = paramInt1;
      this.lPj = paramLong1;
      this.lPk = paramLong1;
      this.jXT = paramLong1;
      this.msgId = paramLong2;
      this.lPt = paramInt2;
      localg = q.bmh().b(Long.valueOf(this.jXT));
      if (paramInt1 != 1) {
        break label595;
      }
      this.jXT = localg.lNR;
      localg = q.bmh().b(Long.valueOf(this.jXT));
    }
    label595:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.jXT + "]");
      Object localObject = new d.a();
      ((d.a)localObject).lBU = new byp();
      ((d.a)localObject).lBV = new byq();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((d.a)localObject).funcId = 109;
      ((d.a)localObject).lBW = 10;
      ((d.a)localObject).respCmdId = 1000000010;
      this.rr = ((d.a)localObject).bgN();
      localObject = (byp)d.b.b(this.rr.lBR);
      this.fvt = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong2);
      ((byp)localObject).Hna = localg.offset;
      ((byp)localObject).HmZ = localg.lAW;
      Log.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(localg.offset), Integer.valueOf(localg.lAW), Util.getStack() });
      ((byp)localObject).HlH = this.fvt.field_msgSvrId;
      ((byp)localObject).RID = new eaf().btQ(this.fvt.field_talker);
      ((byp)localObject).RIE = new eaf().btQ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null));
      ((byp)localObject).ThK = paramInt1;
      if (localg.offset == 0) {
        this.lPm = new com.tencent.mm.modelstat.g(getType(), false, localg.lAW);
      }
      this.lPl = 8192;
      if (paramj != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150670);
            paramj.a(this.lPz, this.lPA, m.this);
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
    paramg.wf(paramInt1);
    paramg.we(paramInt2 + paramInt3);
    this.lPl = paramInt3;
    if (paramArrayOfByte != null) {
      u.F(this.lPq, paramArrayOfByte);
    }
    Log.d(this.TAG, "onGYNetEnd : offset = " + paramg.offset + " totalLen = " + paramg.lAW + " stack:[%s]", new Object[] { Util.getStack() });
    String str1 = null;
    paramArrayOfByte = str1;
    boolean bool1;
    com.tencent.mm.vfs.q localq;
    if (paramg.blJ())
    {
      paramArrayOfByte = ImgUtil.identifyImgType(this.lPq);
      bool1 = ImgUtil.isImgFile(this.lPq);
      localq = new com.tencent.mm.vfs.q(this.lPq);
      if (ImgUtil.isWXGF(this.lPq))
      {
        Log.i(this.TAG, "hevc download is hevc %s", new Object[] { Boolean.valueOf(bool1) });
        str2 = u.n(this.lPq, false);
        str2 = str2 + "_temp";
        paramInt2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(this.lPq, str2);
        paramInt3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFv, 1);
        Log.i(this.TAG, "convert jpg: %s path %s, config %s", new Object[] { Integer.valueOf(paramInt2), str2, Integer.valueOf(paramInt3) });
        if (paramInt2 != 0) {
          bool1 = false;
        }
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          this.lAM = false;
          u.deleteFile(this.lPq);
          d.b.b(this.rr.lBR);
          d(paramg);
          AppMethodBeat.o(150678);
          return false;
          paramArrayOfByte = ImgUtil.identifyImgType(str2);
          if (paramInt3 == 1)
          {
            u.oo(str2, this.lPq);
          }
          else
          {
            String str3 = q.bmh().r(this.lPp, null, paramArrayOfByte);
            str3 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR(str3);
            u.oo(this.lPq, str3);
            u.oo(str2, this.lPq);
            paramg.VR(str3);
          }
        }
      }
      boolean bool2 = bool1;
      if (!bool2) {
        break label600;
      }
      String str2 = this.lPp + paramArrayOfByte;
      str1 = q.bmh().r(this.lPp, null, paramArrayOfByte);
      Log.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.lPp, this.lPq, str1 });
      localq.aj(new com.tencent.mm.vfs.q(str1));
      paramg.VN(str2);
      paramg.VM(h.VT(str1));
      paramg.wk(this.lNK);
    }
    for (paramArrayOfByte = str1; q.bmh().a(Long.valueOf(this.jXT), paramg) < 0; paramArrayOfByte = str1)
    {
      Log.e(this.TAG, "onGYNetEnd : update img fail");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150678);
      return false;
      label600:
      if (this.lNK == 1)
      {
        paramArrayOfByte = q.bmh().b(Long.valueOf(this.lPk));
        paramArrayOfByte.wg(0);
        q.bmh().a(Long.valueOf(this.lPk), paramArrayOfByte);
      }
      localq.cFq();
    }
    if (this.lPi != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150672);
          m.n(m.this).a(paramg.offset, paramg.lAW, m.this);
          AppMethodBeat.o(150672);
        }
      });
    }
    Log.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(paramg.blJ()), this.lPn });
    if (paramg.blJ())
    {
      if (Util.isNullOrNil(this.lPn)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.jGU), Integer.valueOf(paramInt1 - this.lPo) });
      }
      bool1 = false;
      if (this.lPr > 0) {
        bool1 = q.bmh().a(paramArrayOfByte, paramg.lNJ, this.lPr, 1, this.fvt.ili, this.fvt.ilj);
      }
      if (bool1)
      {
        paramg.blM();
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.fvt.field_msgId, this.fvt);
      }
      q.bmh().a(Long.valueOf(this.jXT), paramg);
      Log.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.lPq, paramArrayOfByte, paramg.lNH, this.lPu });
      if (this.lPm != null) {
        this.lPm.GP(paramg.lAW);
      }
      if ((!Util.isNullOrNil(this.lPu)) && (this.lPv > 0))
      {
        com.tencent.mm.plugin.image.c.eIA();
        com.tencent.mm.plugin.image.c.bbT().U(this.lPu, this.lPv, paramArrayOfByte);
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
    if (Util.isNullOrNil(paramg.lNS))
    {
      AppMethodBeat.o(150674);
      return false;
    }
    Map localMap = XmlParser.parseXml(paramg.lNS, "msg", null);
    if (localMap == null)
    {
      Log.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramg.lNS });
      AppMethodBeat.o(150674);
      return false;
    }
    this.lAW = 0;
    String str2;
    String str1;
    if (this.lNK != 1)
    {
      str2 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      this.lAW = Util.getInt((String)localMap.get(".msg.img.$length"), 0);
      if (this.lNK == 1) {
        break label297;
      }
      str3 = (String)localMap.get(".msg.img.$tpurl");
      str1 = str3;
      if (Util.isNullOrNil(str3)) {
        break label349;
      }
      this.lAW = Util.getInt((String)localMap.get(".msg.img.$tplength"), 0);
      str1 = str3;
    }
    label297:
    label349:
    for (;;)
    {
      Log.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.lNK), Integer.valueOf(this.lAW), str2, str1 });
      if ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil(str1))) {
        break label352;
      }
      Log.e(this.TAG, "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(150674);
      return false;
      str2 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      this.lAW = Util.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
      break;
      str3 = (String)localMap.get(".msg.img.$tphdurl");
      str1 = str3;
      if (!Util.isNullOrNil(str3))
      {
        this.lAW = Util.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
        str1 = str3;
      }
    }
    label352:
    String str3 = (String)localMap.get(".msg.img.$aeskey");
    if (Util.isNullOrNil(str3))
    {
      Log.e(this.TAG, "cdntra get aes key failed.");
      AppMethodBeat.o(150674);
      return false;
    }
    this.lPn = com.tencent.mm.aq.c.a("downimg", paramg.createTime, this.fvt.field_talker, this.fvt.field_msgId);
    if (Util.isNullOrNil(this.lPn))
    {
      Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.jXT) });
      AppMethodBeat.o(150674);
      return false;
    }
    String str4 = (String)localMap.get(".msg.img.$md5");
    int i;
    boolean bool;
    if ((Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str4)) && ((Util.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.lNK == 1)))
    {
      com.tencent.mm.plugin.image.c.eIA();
      String str5 = com.tencent.mm.plugin.image.c.bbT().hA(str4, this.lAW);
      i = (int)u.bBQ(str5);
      int j = this.lAW - i;
      String str6 = this.TAG;
      int k = this.lAW;
      Object localObject = localMap.get(".msg.img.$cdnbigimgurl");
      if (this.lNK == 1)
      {
        bool = true;
        Log.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str4, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str5, Integer.valueOf(j), this.lPq });
        if (Util.isNullOrNil(str5)) {
          break label914;
        }
        if ((j < 0) || (j > 16)) {
          break label928;
        }
        bool = false;
        if (!Util.isEqual(str5, this.lPq)) {
          if (u.on(str5, this.lPq) < 0L) {
            break label908;
          }
        }
      }
      label908:
      for (bool = true;; bool = false)
      {
        Log.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str5, this.lPq, Boolean.valueOf(bool) });
        a(paramg, this.lAW, this.lAW, 0, null);
        if (this.fvt != null) {
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(this.fvt.field_talker, "update", this.fvt));
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(13267, new Object[] { str2, Long.valueOf(this.fvt.field_msgSvrId), str4, Long.valueOf(this.fvt.field_createTime / 1000L), this.fvt.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
        AppMethodBeat.o(150674);
        return true;
        bool = false;
        break;
      }
      label914:
      this.lPu = str4;
      this.lPv = this.lAW;
    }
    label928:
    if ((this.lAM) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).cTu()))
    {
      bool = true;
      Log.i(this.TAG, "checkUseCdn: %s, %s", new Object[] { Boolean.valueOf(this.lAM), Boolean.valueOf(bool) });
      paramg = new com.tencent.mm.i.g();
      if (!bool) {
        break label1365;
      }
      paramg.taskName = "task_NetSceneGetMsgImg_1";
      paramg.field_mediaId = this.lPn;
      label1015:
      paramg.field_fullpath = this.lPq;
      paramg.field_fileType = this.jGU;
      paramg.field_totalLen = this.lAW;
      paramg.field_aesKey = str3;
      paramg.field_fileId = str2;
      paramg.field_priority = com.tencent.mm.i.a.iTU;
      paramg.iUG = this.lPx;
      if (!ab.Lj(this.fvt.field_talker)) {
        break label1402;
      }
      i = 1;
      label1081:
      paramg.field_chattype = i;
      if (!bool) {
        break label1407;
      }
      i = 2;
      label1093:
      paramg.expectImageFormat = i;
      if (!Util.isNullOrNil(str1))
      {
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        paramg.field_fileType = 19;
        paramg.field_authKey = str2;
        paramg.iUJ = str1;
        paramg.field_fileId = "";
      }
      Log.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.fvt.field_msgId, Boolean.valueOf(com.tencent.mm.aq.f.bkg().lHW.contains("image_" + this.fvt.field_msgId)) });
      if (!com.tencent.mm.aq.f.bkg().lHW.contains("image_" + this.fvt.field_msgId)) {
        break label1412;
      }
      com.tencent.mm.aq.f.bkg().lHW.remove("image_" + this.fvt.field_msgId);
    }
    label1412:
    for (paramg.field_autostart = true;; paramg.field_autostart = false)
    {
      if (com.tencent.mm.aq.f.bkg().b(paramg, this.lPt)) {
        break label1420;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 196L, 1L, false);
      Log.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.lPn });
      this.lPn = "";
      AppMethodBeat.o(150674);
      return false;
      bool = false;
      break;
      label1365:
      paramg.taskName = "task_NetSceneGetMsgImg_2";
      paramg.field_mediaId = (this.lPn + "_hevc");
      break label1015;
      label1402:
      i = 0;
      break label1081;
      label1407:
      i = 1;
      break label1093;
    }
    label1420:
    Log.i(this.TAG, "add recv task");
    AppMethodBeat.o(150674);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150675);
    if ((!Util.isNullOrNil(this.lPn)) && (com.tencent.mm.aq.f.bkg() != null))
    {
      Log.d(this.TAG, "cancel recv task");
      com.tencent.mm.aq.f.bkg().Vz(this.lPn);
    }
    super.cancel();
    AppMethodBeat.o(150675);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(150676);
    this.callback = parami;
    parami = (byp)d.b.b(this.rr.lBR);
    g localg = q.bmh().b(Long.valueOf(this.jXT));
    if (localg.localId == 0L)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 195L, 1L, false);
      Log.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.jXT), localg });
      AppMethodBeat.o(150676);
      return -1;
    }
    if (localg.status != 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 194L, 1L, false);
      Log.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(localg.localId), Integer.valueOf(localg.status) });
      AppMethodBeat.o(150676);
      return -1;
    }
    String str = localg.lNH;
    if (str.startsWith("SERVERID://"))
    {
      this.lPp = com.tencent.mm.b.g.getMessageDigest(localg.lNH.getBytes());
      this.lPq = q.bmh().r(this.lPp, null, ".temp");
      localg.VN(this.lPp + ".temp");
      q.bmh().a(Long.valueOf(this.jXT), localg);
      Log.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(localg.localId), Integer.valueOf(this.lNK), Integer.valueOf(localg.offset), Integer.valueOf(localg.lAW), str, this.lPp, this.lPq });
      if (this.startTime == 0L)
      {
        this.startTime = Util.nowMilliSecond();
        this.lPo = localg.offset;
        if (this.lNK != 1) {
          break label452;
        }
      }
    }
    label452:
    for (int i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;; i = com.tencent.mm.i.a.MediaType_IMAGE)
    {
      this.jGU = i;
      if (!d(localg)) {
        break label459;
      }
      Log.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.lPn });
      AppMethodBeat.o(150676);
      return 0;
      this.lPp = localg.lNH;
      this.lPq = q.bmh().r(this.lPp, null, "");
      break;
    }
    label459:
    Log.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.lPn });
    localg.VQ("");
    localg.cUP = 4096;
    q.bmh().a(Long.valueOf(this.jXT), localg);
    parami.Hna = localg.offset;
    parami.Hnb = this.lPl;
    parami.HmZ = localg.lAW;
    if (this.lPm != null) {
      this.lPm.bpw();
    }
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150676);
    return i;
  }
  
  public final int getType()
  {
    return 109;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150677);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      AppMethodBeat.o(150677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 193L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.jGU), Integer.valueOf(this.lAW - this.lPo) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150677);
      return;
    }
    paramString = (byq)d.c.b(((com.tencent.mm.an.d)params).lBS);
    params = q.bmh().b(Long.valueOf(this.jXT));
    paramInt1 = 0;
    if (paramString.Hnb <= 0)
    {
      Log.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 192L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.jGU), Integer.valueOf(this.lAW - this.lPo) });
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(150677);
      return;
      if ((paramString.Hnc == null) || (paramString.Hnb != paramString.Hnc.Ufv))
      {
        Log.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.Hna < 0) || (paramString.Hna + paramString.Hnb > paramString.HmZ))
      {
        Log.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.Hna != params.offset)
      {
        Log.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.HmZ <= 0)
      {
        Log.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(params, paramString.HmZ, paramString.Hna, paramString.Hnb, paramString.Hnc.Tkb.UH)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(150677);
  }
  
  public final int securityLimitCount()
  {
    if (this.lNK == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.m
 * JD-Core Version:    0.7.0.1
 */