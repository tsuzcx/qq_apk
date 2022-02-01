package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.a;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelcdntran.e;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cc;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class n
  extends p
  implements m
{
  private String TAG;
  private com.tencent.mm.am.h callback;
  private cc hzO;
  private int mgx;
  private long msgId;
  private long mxN;
  private int nrw;
  private int oGu;
  private final com.tencent.mm.am.i oHS;
  public long oHT;
  private long oHU;
  private int oHV;
  private com.tencent.mm.modelstat.g oHW;
  private String oHX;
  private int oHY;
  private String oHZ;
  public String oIa;
  int oIb;
  public boolean oIc;
  private int oId;
  private String oIe;
  private int oIf;
  private final com.tencent.mm.modelcdntran.c<e> oIg;
  private g.a osH;
  private boolean osn;
  private int osy;
  private final com.tencent.mm.am.c rr;
  private long startTime;
  
  public n(long paramLong1, long paramLong2, int paramInt, com.tencent.mm.am.i parami)
  {
    this(paramLong1, paramLong2, paramInt, parami, -1);
  }
  
  public n(long paramLong1, long paramLong2, int paramInt1, final com.tencent.mm.am.i parami, int paramInt2)
  {
    AppMethodBeat.i(150673);
    this.TAG = "MicroMsg.NetSceneGetMsgImg";
    this.oHU = -1L;
    this.oHW = null;
    this.msgId = -1L;
    this.hzO = null;
    this.oHX = "";
    this.startTime = 0L;
    this.oHY = -1;
    this.mgx = 0;
    this.osn = true;
    this.oHZ = "";
    this.oIa = "";
    this.osy = 0;
    this.oIb = -1;
    this.oIc = false;
    this.oId = -1;
    this.oIe = null;
    this.oIf = 0;
    this.nrw = -1;
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(150671);
        if (paramAnonymousInt == -21006)
        {
          Log.i(n.a(n.this), "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { n.b(n.this) });
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          l.wu((int)n.c(n.this));
          l.wt((int)n.c(n.this));
          n.d(n.this).onSceneEnd(3, paramAnonymousInt, "", n.this);
          AppMethodBeat.o(150671);
          return 0;
        }
        h localh = r.bKa().b(Long.valueOf(n.e(n.this)));
        if (paramAnonymousc != null)
        {
          if ((n.f(n.this) == 0) && (paramAnonymousc.field_toltalLength > 0L))
          {
            n.a(n.this, Long.valueOf(paramAnonymousc.field_toltalLength).intValue());
            Log.w(n.a(n.this), "modify totallen:%d", new Object[] { Integer.valueOf(n.f(n.this)) });
          }
          if (paramAnonymousc.field_finishedLength == n.f(n.this))
          {
            Log.d(n.a(n.this), "cdntra ignore progress 100%");
            AppMethodBeat.o(150671);
            return 0;
          }
          if (!n.g(n.this)) {
            n.a(n.this, paramAnonymousc.field_mtlnotify);
          }
          Log.i(n.a(n.this), "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[] { n.b(n.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), Boolean.valueOf(n.g(n.this)) });
          n.a(n.this, localh, n.f(n.this), localh.offset, (int)paramAnonymousc.field_finishedLength - localh.offset);
          AppMethodBeat.o(150671);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            l.wt((int)n.c(n.this));
            Log.e(n.a(n.this), "cdntra sceneResult.retCode :%d", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode) });
            n.d(n.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", n.this);
          }
        }
        else
        {
          AppMethodBeat.o(150671);
          return 0;
        }
        Log.i(n.a(n.this), "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
        if ((n.f(n.this) == 0) && (paramAnonymousd.field_fileLength > 0L))
        {
          n.a(n.this, Long.valueOf(paramAnonymousd.field_fileLength).intValue());
          Log.w(n.a(n.this), "modify totallen:%d", new Object[] { Integer.valueOf(n.f(n.this)) });
        }
        Log.i(n.a(n.this), "cdntra getimg ok. need convert:%b", new Object[] { Boolean.valueOf(paramAnonymousd.field_convert2baseline) });
        if (localh.oGu == 1)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 26L, localh.osy, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 27L, 1L, false);
          paramAnonymousc = com.tencent.mm.plugin.report.service.h.OAn;
          if (n.h(n.this) != null)
          {
            paramAnonymousString = n.h(n.this).field_talker;
            label615:
            if (!au.bwE(paramAnonymousString)) {
              break label754;
            }
          }
          label754:
          for (l = 29L;; l = 28L)
          {
            paramAnonymousc.idkeyStat(198L, l, 1L, false);
            if (paramAnonymousd.field_convert2baseline)
            {
              Log.i(n.a(n.this), "cdntra need convert2baseline. file:%s", new Object[] { n.i(n.this) });
              paramAnonymousBoolean = MMNativeJpeg.Convert2Baseline(n.i(n.this), 60);
              Log.i(n.a(n.this), "convert result:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            }
            n.a(n.this, localh, n.f(n.this), localh.offset, n.f(n.this) - localh.offset);
            break;
            paramAnonymousString = "";
            break label615;
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 21L, localh.osy, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 22L, 1L, false);
        paramAnonymousc = com.tencent.mm.plugin.report.service.h.OAn;
        if (n.h(n.this) != null)
        {
          paramAnonymousString = n.h(n.this).field_talker;
          label820:
          if (!au.bwE(paramAnonymousString)) {
            break label852;
          }
        }
        label852:
        for (long l = 24L;; l = 23L)
        {
          paramAnonymousc.idkeyStat(198L, l, 1L, false);
          break;
          paramAnonymousString = "";
          break label820;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.oIg = new n..ExternalSyntheticLambda0(this);
    boolean bool;
    h localh;
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (parami != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.oHS = parami;
      this.oGu = paramInt1;
      this.oHT = paramLong1;
      this.oHU = paramLong1;
      this.mxN = paramLong1;
      this.msgId = paramLong2;
      this.oId = paramInt2;
      localh = r.bKa().b(Long.valueOf(this.mxN));
      if (paramInt1 != 1) {
        break label600;
      }
      this.mxN = localh.oGB;
      localh = r.bKa().b(Long.valueOf(this.mxN));
    }
    label600:
    for (;;)
    {
      this.TAG = (this.TAG + "[" + this.mxN + "]");
      Object localObject = new com.tencent.mm.am.c.a();
      ((com.tencent.mm.am.c.a)localObject).otE = new cns();
      ((com.tencent.mm.am.c.a)localObject).otF = new cnt();
      ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/micromsg-bin/getmsgimg";
      ((com.tencent.mm.am.c.a)localObject).funcId = 109;
      ((com.tencent.mm.am.c.a)localObject).otG = 10;
      ((com.tencent.mm.am.c.a)localObject).respCmdId = 1000000010;
      this.rr = ((com.tencent.mm.am.c.a)localObject).bEF();
      localObject = (cns)c.b.b(this.rr.otB);
      this.hzO = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramLong2);
      ((cns)localObject).NkO = localh.offset;
      ((cns)localObject).NkN = localh.osy;
      Log.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", new Object[] { Integer.valueOf(localh.offset), Integer.valueOf(localh.osy), Util.getStack() });
      ((cns)localObject).Njv = this.hzO.field_msgSvrId;
      ((cns)localObject).YFE = new etl().btH(this.hzO.field_talker);
      ((cns)localObject).YFF = new etl().btH((String)com.tencent.mm.kernel.h.baE().ban().d(2, null));
      ((cns)localObject).aava = paramInt1;
      if (localh.offset == 0) {
        this.oHW = new com.tencent.mm.modelstat.g(getType(), false, localh.osy);
      }
      this.oHV = 8192;
      if (parami != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150670);
            parami.a(this.oIi, this.oIj, n.this);
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
  
  private boolean a(h paramh, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150678);
    paramh.wk(paramInt1);
    paramh.wj(paramInt2 + paramInt3);
    this.oHV = paramInt3;
    if (paramArrayOfByte != null) {
      y.e(this.oIa, paramArrayOfByte, paramArrayOfByte.length);
    }
    Log.i(this.TAG, "onGYNetEnd : offset = " + paramh.offset + " totalLen = " + paramh.osy);
    String str1 = null;
    paramArrayOfByte = str1;
    boolean bool1;
    u localu;
    if (paramh.bJD())
    {
      paramArrayOfByte = ImgUtil.identifyImgType(this.oIa);
      bool1 = ImgUtil.isImgFile(this.oIa);
      localu = new u(this.oIa);
      if (ImgUtil.isWXGF(this.oIa))
      {
        Log.i(this.TAG, "hevc download is hevc %s", new Object[] { Boolean.valueOf(bool1) });
        str2 = y.n(this.oIa, false);
        str2 = str2 + "_temp";
        paramInt1 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).nativeWxam2Pic(this.oIa, str2);
        paramInt2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yUT, 1);
        Log.i(this.TAG, "convert jpg: %s path %s, config %s", new Object[] { Integer.valueOf(paramInt1), str2, Integer.valueOf(paramInt2) });
        if (paramInt1 != 0) {
          bool1 = false;
        }
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          this.osn = false;
          y.deleteFile(this.oIa);
          c.b.b(this.rr.otB);
          d(paramh);
          AppMethodBeat.o(150678);
          return false;
          paramArrayOfByte = ImgUtil.identifyImgType(str2);
          if (paramInt2 == 1)
          {
            y.qn(str2, this.oIa);
          }
          else
          {
            String str3 = r.bKa().v(this.oHZ, null, paramArrayOfByte);
            str3 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(str3);
            y.qn(this.oIa, str3);
            y.qn(str2, this.oIa);
            paramh.NU(str3);
          }
        }
      }
      boolean bool2 = bool1;
      if (!bool2) {
        break label584;
      }
      String str2 = this.oHZ + paramArrayOfByte;
      str1 = r.bKa().v(this.oHZ, null, paramArrayOfByte);
      Log.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", new Object[] { paramArrayOfByte, this.oHZ, this.oIa, str1 });
      localu.am(new u(str1));
      paramh.NQ(str2);
      paramh.NP(i.NV(str1));
      paramh.wp(this.oGu);
    }
    for (paramArrayOfByte = str1; r.bKa().a(Long.valueOf(this.mxN), paramh) < 0; paramArrayOfByte = str1)
    {
      Log.e(this.TAG, "onGYNetEnd : update img fail");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150678);
      return false;
      label584:
      if (this.oGu == 1)
      {
        paramArrayOfByte = r.bKa().b(Long.valueOf(this.oHU));
        paramArrayOfByte.wl(0);
        r.bKa().a(Long.valueOf(this.oHU), paramArrayOfByte);
      }
      localu.diJ();
    }
    if (this.oHS != null) {
      com.tencent.threadpool.h.ahAA.bk(new n..ExternalSyntheticLambda1(this, paramh));
    }
    Log.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", new Object[] { Boolean.valueOf(paramh.bJD()), this.oHX });
    if (paramh.bJD())
    {
      bool1 = false;
      if (this.oIb > 0) {
        bool1 = r.bKa().a(paramArrayOfByte, paramh.oGt, this.oIb, 1, this.hzO.kLh, this.hzO.kLi);
      }
      if (bool1)
      {
        paramh.bJF();
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.hzO.field_msgId, this.hzO);
      }
      r.bKa().a(Long.valueOf(this.mxN), paramh);
      Log.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", new Object[] { this.oIa, paramArrayOfByte, paramh.oGr, this.oIe });
      if (this.oHW != null) {
        this.oHW.ja(paramh.osy);
      }
      if ((!Util.isNullOrNil(this.oIe)) && (this.oIf > 0))
      {
        com.tencent.mm.plugin.image.c.fQB();
        com.tencent.mm.plugin.image.c.bzI().W(this.oIe, this.oIf, paramArrayOfByte);
      }
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(150678);
      return false;
    }
    AppMethodBeat.o(150678);
    return true;
  }
  
  private boolean d(h paramh)
  {
    AppMethodBeat.i(150674);
    if (Util.isNullOrNil(paramh.oGC))
    {
      AppMethodBeat.o(150674);
      return false;
    }
    Map localMap = XmlParser.parseXml(paramh.oGC, "msg", null);
    if (localMap == null)
    {
      Log.e(this.TAG, "parse cdnInfo failed. [%s]", new Object[] { paramh.oGC });
      AppMethodBeat.o(150674);
      return false;
    }
    Log.i(this.TAG, "img cdn info %s", new Object[] { paramh.oGC });
    this.osy = 0;
    String str2;
    String str1;
    if (this.oGu != 1)
    {
      str2 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      this.osy = Util.getInt((String)localMap.get(".msg.img.$length"), 0);
      if (this.oGu == 1) {
        break label353;
      }
      str3 = (String)localMap.get(".msg.img.$tpurl");
      str1 = str3;
      if (Util.isNullOrNil(str3)) {
        break label405;
      }
      this.osy = Util.getInt((String)localMap.get(".msg.img.$tplength"), 0);
      str1 = str3;
    }
    int i;
    label405:
    for (;;)
    {
      i = Util.getInt((String)localMap.get(".msg.img.$hevc_mid_size"), 0);
      if ((this.osy <= 1) && (i >= 0)) {
        this.osy = i;
      }
      Log.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", new Object[] { Integer.valueOf(this.oGu), Integer.valueOf(this.osy), str2, str1 });
      if ((!Util.isNullOrNil(str2)) || (!Util.isNullOrNil(str1))) {
        break label408;
      }
      Log.e(this.TAG, "cdntra get cdnUrlfailed.");
      AppMethodBeat.o(150674);
      return false;
      str2 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      this.osy = Util.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
      break;
      label353:
      str3 = (String)localMap.get(".msg.img.$tphdurl");
      str1 = str3;
      if (!Util.isNullOrNil(str3))
      {
        this.osy = Util.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
        str1 = str3;
      }
    }
    label408:
    String str3 = (String)localMap.get(".msg.img.$aeskey");
    if (Util.isNullOrNil(str3))
    {
      Log.e(this.TAG, "cdntra get aes key failed.");
      AppMethodBeat.o(150674);
      return false;
    }
    this.oHX = com.tencent.mm.modelcdntran.h.a("downimg", paramh.createTime, this.hzO.field_talker, this.hzO.field_msgId);
    if (Util.isNullOrNil(this.oHX))
    {
      Log.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(this.mxN) });
      AppMethodBeat.o(150674);
      return false;
    }
    String str4 = (String)localMap.get(".msg.img.$md5");
    boolean bool;
    if ((Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str4)) && ((Util.isNullOrNil((String)localMap.get(".msg.img.$cdnbigimgurl"))) || (this.oGu == 1)))
    {
      com.tencent.mm.plugin.image.c.fQB();
      String str5 = com.tencent.mm.plugin.image.c.bzI().iI(str4, this.osy);
      i = (int)y.bEl(str5);
      int j = this.osy - i;
      String str6 = this.TAG;
      int k = this.osy;
      Object localObject = localMap.get(".msg.img.$cdnbigimgurl");
      if (this.oGu == 1)
      {
        bool = true;
        Log.i(str6, "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s", new Object[] { Integer.valueOf(k), str4, localObject, Boolean.valueOf(bool), Integer.valueOf(i), str5, Integer.valueOf(j), this.oIa });
        if (Util.isNullOrNil(str5)) {
          break label971;
        }
        if ((j < 0) || (j > 16)) {
          break label985;
        }
        bool = false;
        if (!Util.isEqual(str5, this.oIa)) {
          if (y.O(str5, this.oIa, false) < 0L) {
            break label965;
          }
        }
      }
      label965:
      for (bool = true;; bool = false)
      {
        Log.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", new Object[] { str5, this.oIa, Boolean.valueOf(bool) });
        a(paramh, this.osy, this.osy, 0, null);
        if (this.hzO != null) {
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(new i.c(this.hzO.field_talker, "update", this.hzO));
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(13267, new Object[] { str2, Long.valueOf(this.hzO.field_msgSvrId), str4, Long.valueOf(this.hzO.getCreateTime() / 1000L), this.hzO.field_talker, Integer.valueOf(3), Integer.valueOf(i) });
        AppMethodBeat.o(150674);
        return true;
        bool = false;
        break;
      }
      label971:
      this.oIe = str4;
      this.oIf = this.osy;
    }
    label985:
    if ((this.osn) && (((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).dxP()))
    {
      bool = true;
      Log.i(this.TAG, "checkUseCdn: %s, %s", new Object[] { Boolean.valueOf(this.osn), Boolean.valueOf(bool) });
      paramh = new com.tencent.mm.g.g();
      if (!bool) {
        break label1437;
      }
      paramh.taskName = "task_NetSceneGetMsgImg_1";
      paramh.field_mediaId = this.oHX;
      paramh.field_fullpath = this.oIa;
      paramh.field_fileType = this.mgx;
      paramh.field_totalLen = this.osy;
      paramh.field_aesKey = str3;
      paramh.field_fileId = str2;
      paramh.field_priority = a.lvZ;
      if (!au.bwE(this.hzO.field_talker)) {
        break label1474;
      }
      i = 1;
      label1130:
      paramh.field_chattype = i;
      if (!bool) {
        break label1479;
      }
      i = 2;
      label1142:
      paramh.expectImageFormat = i;
      if (!Util.isNullOrNil(str1))
      {
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        paramh.field_fileType = 19;
        paramh.field_authKey = str2;
        paramh.lwO = str1;
        paramh.field_fileId = "";
      }
      Log.i(this.TAG, "cdnautostart %s %b", new Object[] { "image_" + this.hzO.field_msgId, Boolean.valueOf(k.bHW().oAv.contains("image_" + this.hzO.field_msgId)) });
      if (!k.bHW().oAv.contains("image_" + this.hzO.field_msgId)) {
        break label1484;
      }
      k.bHW().oAv.remove("image_" + this.hzO.field_msgId);
    }
    label1072:
    label1474:
    label1479:
    label1484:
    for (paramh.field_autostart = true;; paramh.field_autostart = false)
    {
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yUV, b.a.agqC, 0) != 1) {
        break label1492;
      }
      if (com.tencent.mm.modelcdntran.b.a(paramh, this.oIg, null) != null) {
        break label1563;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 196L, 1L, false);
      Log.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.oHX });
      this.oHX = "";
      AppMethodBeat.o(150674);
      return false;
      bool = false;
      break;
      paramh.taskName = "task_NetSceneGetMsgImg_2";
      paramh.field_mediaId = (this.oHX + "_hevc");
      break label1072;
      i = 0;
      break label1130;
      i = 1;
      break label1142;
    }
    label1437:
    label1492:
    paramh.lwL = this.osH;
    if (!k.bHW().b(paramh, this.oId))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 196L, 1L, false);
      Log.e(this.TAG, "addRecvTask failed :%s", new Object[] { this.oHX });
      this.oHX = "";
      AppMethodBeat.o(150674);
      return false;
    }
    label1563:
    Log.i(this.TAG, "add recv task");
    AppMethodBeat.o(150674);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150675);
    if ((!Util.isNullOrNil(this.oHX)) && (k.bHW() != null))
    {
      Log.d(this.TAG, "cancel recv task");
      k.bHW().Nz(this.oHX);
    }
    super.cancel();
    AppMethodBeat.o(150675);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150676);
    this.callback = paramh;
    paramh = (cns)c.b.b(this.rr.otB);
    h localh = r.bKa().b(Long.valueOf(this.mxN));
    if ((localh == null) || (localh.localId == 0L))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 195L, 1L, false);
      Log.e(this.TAG, "doScene id:%d  img:%s", new Object[] { Long.valueOf(this.mxN), localh });
      AppMethodBeat.o(150676);
      return -1;
    }
    if (localh.status != 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 194L, 1L, false);
      Log.e(this.TAG, "doSceneError, id:%d, status:%d", new Object[] { Long.valueOf(localh.localId), Integer.valueOf(localh.status) });
      AppMethodBeat.o(150676);
      return -1;
    }
    String str = localh.oGr;
    if (str.startsWith("SERVERID://"))
    {
      this.oHZ = com.tencent.mm.b.g.getMessageDigest(localh.oGr.getBytes());
      this.oIa = r.bKa().v(this.oHZ, null, ".temp");
      localh.NQ(this.oHZ + ".temp");
      r.bKa().a(Long.valueOf(this.mxN), localh);
      Log.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", new Object[] { Long.valueOf(localh.localId), Integer.valueOf(this.oGu), Integer.valueOf(localh.offset), Integer.valueOf(localh.osy), str, this.oHZ, this.oIa });
      if (this.startTime == 0L)
      {
        this.startTime = Util.nowMilliSecond();
        this.oHY = localh.offset;
        if (this.oGu != 1) {
          break label454;
        }
      }
    }
    label454:
    for (int i = a.MediaType_FULLSIZEIMAGE;; i = a.MediaType_IMAGE)
    {
      this.mgx = i;
      if (!d(localh)) {
        break label461;
      }
      Log.d(this.TAG, "cdntra this img use cdn : %s", new Object[] { this.oHX });
      AppMethodBeat.o(150676);
      return 0;
      this.oHZ = localh.oGr;
      this.oIa = r.bKa().v(this.oHZ, null, "");
      break;
    }
    label461:
    Log.d(this.TAG, "cdntra this img NOT USE CDN: %s", new Object[] { this.oHX });
    localh.NT("");
    localh.eQp = 4096;
    r.bKa().a(Long.valueOf(this.mxN), localh);
    paramh.NkO = localh.offset;
    paramh.NkP = this.oHV;
    paramh.NkN = localh.osy;
    if (this.oHW != null) {
      this.oHW.bNd();
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
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      AppMethodBeat.o(150677);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 193L, 1L, false);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150677);
      return;
    }
    paramString = (cnt)c.c.b(((com.tencent.mm.am.c)params).otC);
    params = r.bKa().b(Long.valueOf(this.mxN));
    paramInt1 = 0;
    if (paramString.NkP <= 0)
    {
      Log.e(this.TAG, "flood control, malformed data_len");
      paramInt1 = -1;
    }
    while (paramInt1 != 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 192L, 1L, false);
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(150677);
      return;
      if ((paramString.NkQ == null) || (paramString.NkP != paramString.NkQ.abwJ))
      {
        Log.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
        paramInt1 = -1;
      }
      else if ((paramString.NkO < 0) || (paramString.NkO + paramString.NkP > paramString.NkN))
      {
        Log.e(this.TAG, "flood control, malformed start pos");
        paramInt1 = -1;
      }
      else if (paramString.NkO != params.offset)
      {
        Log.e(this.TAG, "flood control, malformed start_pos");
        paramInt1 = -1;
      }
      else if (paramString.NkN <= 0)
      {
        Log.e(this.TAG, "flood control, malformed total_len");
        paramInt1 = -1;
      }
    }
    if ((a(params, paramString.NkN, paramString.NkO, paramString.NkP, paramString.NkQ.aaxD.Op)) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(150677);
  }
  
  public final int securityLimitCount()
  {
    if (this.oGu == 0) {
      return 100;
    }
    return 1280;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.n
 * JD-Core Version:    0.7.0.1
 */