package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.aq.e;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.v;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class h
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  String fileName;
  private int lAW;
  private MTimerHandler lAo;
  private String lPn;
  private int lPo;
  private String lPu;
  private int lPv;
  private g.a lPx;
  private String mediaId;
  private boolean mfP;
  private boolean mfQ;
  private w mfR;
  private com.tencent.mm.i.h mfS;
  private int mfT;
  private boolean mfU;
  private boolean mfV;
  private long mfW;
  int retCode;
  private com.tencent.mm.an.d rr;
  private long startTime;
  
  public h(String paramString)
  {
    this(paramString, false);
  }
  
  public h(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126829);
    this.mfR = null;
    this.lPn = "";
    this.lPo = 0;
    this.startTime = 0L;
    this.lAW = 0;
    this.retCode = 0;
    this.mfT = com.tencent.mm.i.a.MediaType_VIDEO;
    this.mfU = false;
    this.mfV = true;
    this.lPu = null;
    this.lPv = 0;
    this.mfW = 0L;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126824);
        if (paramAnonymousInt == -21006)
        {
          Log.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { h.a(h.this), h.b(h.this) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          y.Yb(h.c(h.this));
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(h.d(h.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(h.e(h.this)), Integer.valueOf(h.f(h.this)), "" });
          new ae(paramAnonymousString).bpa();
          new ac(paramAnonymousString).bpa();
          h.g(h.this).onSceneEnd(3, paramAnonymousInt, "", h.this);
          AppMethodBeat.o(126824);
          return 0;
        }
        h.a(h.this, y.Yk(h.c(h.this)));
        if ((h.h(h.this) == null) || (h.h(h.this).status == 113))
        {
          if (h.h(h.this) == null) {}
          for (int i = -1;; i = h.h(h.this).status)
          {
            Log.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { h.a(h.this), Integer.valueOf(i) });
            h.i(h.this);
            h.g(h.this).onSceneEnd(3, paramAnonymousInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), h.this);
            AppMethodBeat.o(126824);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == h.f(h.this))
          {
            Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            AppMethodBeat.o(126824);
            return 0;
          }
          if ((h.h(h.this).mhM > paramAnonymousc.field_finishedLength) && (!h.j(h.this)))
          {
            Log.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { h.a(h.this), Integer.valueOf(h.h(h.this).mhM), Long.valueOf(paramAnonymousc.field_finishedLength) });
            y.Yb(h.c(h.this));
            h.g(h.this).onSceneEnd(3, paramAnonymousInt, "", h.this);
            AppMethodBeat.o(126824);
            return 0;
          }
          paramAnonymousInt = 1024;
          h.h(h.this).mhP = Util.nowSecond();
          if (h.h(h.this).mhM < paramAnonymousc.field_finishedLength)
          {
            h.h(h.this).mhM = ((int)paramAnonymousc.field_finishedLength);
            paramAnonymousInt = 1040;
          }
          h.h(h.this).cUP = paramAnonymousInt;
          y.f(h.h(h.this));
          Log.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { h.a(h.this), h.b(h.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { h.a(h.this), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(Util.nowMilliSecond() - h.k(h.this)) });
          h.a(h.this, h.l(h.this), paramAnonymousd);
          if (paramAnonymousd.field_retCode == 0) {
            break label1143;
          }
          y.Yb(h.c(h.this));
          if (h.j(h.this)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 13L, 1L, false);
          }
          if (h.m(h.this)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 252L, 1L, false);
          }
          h.g(h.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", h.this);
        }
        for (;;)
        {
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(h.d(h.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(h.e(h.this)), Integer.valueOf(h.f(h.this)), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          if (paramAnonymousd.field_retCode != 0) {
            new ac(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(h.d(h.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(h.e(h.this)), Integer.valueOf(h.f(h.this)), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
          }
          a.a(h.h(h.this), 1);
          h.n(h.this);
          AppMethodBeat.o(126824);
          return 0;
          label1143:
          if (h.j(h.this)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 12L, 1L, false);
          }
          if (h.m(h.this)) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 137L, 1L, false);
          }
          h.a(h.this, (int)paramAnonymousd.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126826);
        if (h.this.doScene(h.r(h.this), h.g(h.this)) == -1) {
          h.g(h.this).onSceneEnd(3, -1, "doScene failed", h.this);
        }
        AppMethodBeat.o(126826);
        return false;
      }
    }, false);
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.fileName = paramString;
      this.mfP = paramBoolean;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { bqr(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(126829);
      return;
    }
  }
  
  private boolean TV()
  {
    boolean bool = false;
    AppMethodBeat.i(126828);
    if (!Util.isNullOrNil(this.mediaId))
    {
      if (!this.mfP) {
        break label68;
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { bqr() });
      s.bqC().l(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.mfU = true;
      AppMethodBeat.o(126828);
      return bool;
      label68:
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { bqr() });
      com.tencent.mm.aq.f.bkg().Vz(this.mediaId);
    }
  }
  
  private boolean bqq()
  {
    AppMethodBeat.i(126830);
    Log.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { bqr(), this.mfR.bqO() });
    Object localObject4 = XmlParser.parseXml(this.mfR.bqO(), "msg", null);
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 214L, 1L, false);
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { bqr() });
      AppMethodBeat.o(126830);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 213L, 1L, false);
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { bqr() });
      AppMethodBeat.o(126830);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.lAW = Util.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.lPn = com.tencent.mm.aq.c.a("downvideo", this.mfR.createTime, this.mfR.bqM(), this.mfR.getFileName());
    if (Util.isNullOrNil(this.lPn))
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bqr(), this.mfR.getFileName() });
      AppMethodBeat.o(126830);
      return false;
    }
    if ((!this.mfP) && (this.lAW < 1048576) && (this.mfR != null) && (this.mfR.fLn > 0))
    {
      this.mfP = true;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { bqr(), Boolean.valueOf(this.mfP) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    s.bqB();
    localObject3 = x.XT(this.fileName) + ".tmp";
    this.mfS = new com.tencent.mm.i.h();
    this.mfS.taskName = "task_NetSceneDownloadVideo";
    this.mfS.filename = this.mfR.getFileName();
    this.mfS.iVb = ((String)localObject2);
    this.mfS.iVc = this.lAW;
    this.mfS.iVd = 0;
    this.mfS.fLi = this.mfR.bqK();
    this.mfS.iVe = this.mfR.bqM();
    com.tencent.mm.i.h localh = this.mfS;
    int i;
    label663:
    label828:
    label865:
    int k;
    if (ab.Lj(this.mfR.bqM()))
    {
      i = v.Pu(this.mfR.bqM());
      localh.fLk = i;
      this.mfS.field_mediaId = this.lPn;
      this.mfS.field_fullpath = ((String)localObject3);
      this.mfS.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      this.mfS.field_totalLen = this.lAW;
      this.mfS.field_aesKey = ((String)localObject5);
      this.mfS.field_fileId = str1;
      this.mfS.field_priority = com.tencent.mm.i.a.iTU;
      this.mfS.iUG = this.lPx;
      this.mfS.field_wxmsgparam = str2;
      localObject5 = this.mfS;
      if (!ab.Lj(this.mfR.bqM())) {
        break label1688;
      }
      i = 1;
      ((com.tencent.mm.i.h)localObject5).field_chattype = i;
      this.mfS.iVf = this.mfR.iVf;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.mfS.field_fileId = "";
        this.mfS.field_fileType = 19;
        this.mfS.field_authKey = ((String)localObject4);
        this.mfS.iUJ = ((String)localObject1);
      }
      localObject4 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(this.mfR.bqM(), this.mfR.fNu);
      this.mfS.iVh = ((et)localObject4).field_createTime;
      this.mfS.fNu = ((et)localObject4).field_msgSvrId;
      localObject1 = bq.RR(((et)localObject4).hxy);
      localObject5 = this.mfS;
      if (localObject1 == null) {
        break label1693;
      }
      i = ((bq.b)localObject1).luI;
      ((com.tencent.mm.i.h)localObject5).iVi = i;
      if (this.mfR.bqM().equals(((et)localObject4).field_talker))
      {
        localObject5 = this.mfS;
        if (localObject1 != null) {
          break label1698;
        }
        i = 0;
        ((com.tencent.mm.i.h)localObject5).field_limitrate = i;
      }
      Log.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { bqr(), Integer.valueOf(this.mfS.field_limitrate), this.mfR.getFileName() });
      if (!com.tencent.mm.aq.f.bkg().lHW.contains("video_" + this.mfR.mhR)) {
        break label1710;
      }
      com.tencent.mm.aq.f.bkg().lHW.remove("video_" + this.mfR.mhR);
      this.mfS.field_autostart = true;
      label989:
      if (3 == this.mfR.mhX) {
        this.mfS.field_smallVideoFlag = 1;
      }
      if ((Util.isNullOrNil((String)localObject2)) || (this.mfP)) {
        break label1741;
      }
      localObject1 = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT().hA((String)localObject2, this.lAW);
      j = (int)u.bBQ((String)localObject1);
      k = this.lAW - j;
      s.bqB();
      localObject5 = x.XT(this.fileName);
      int m = (int)u.bBQ((String)localObject5);
      if (m > 0)
      {
        Log.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { bqr() });
        bool = u.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT();
        int n = this.lAW;
        i = 0;
        if (!Util.isNullOrNil((String)localObject2)) {
          i = ((bz)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = y.Yk(this.fileName);
        ((w)localObject1).mhM = 0;
        ((w)localObject1).cUP = 16;
        y.f((w)localObject1);
        Log.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { bqr(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { bqr(), Integer.valueOf(this.lAW), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (Util.isNullOrNil((String)localObject1)) {
        break label1727;
      }
      if ((k < 0) || (k > 16)) {
        break label1741;
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { bqr(), localObject1, localObject3 });
      u.on((String)localObject1, (String)localObject3);
      xc(this.lAW);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(((et)localObject4).field_talker, "update", (ca)localObject4));
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      long l1 = this.mfR.fNu;
      long l2 = this.mfR.createTime;
      localObject3 = this.mfR.bqM();
      if (3 == this.mfR.mhX) {
        break label1721;
      }
      i = 43;
      label1474:
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(13267, new Object[] { str1, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1535:
      if (i != 0) {
        break label1773;
      }
      this.mediaId = this.mfS.field_mediaId;
      this.mfW = Util.nowMilliSecond();
      if (this.mfR.videoFormat != 2) {
        break label1746;
      }
    }
    label1688:
    label1693:
    label1698:
    label1710:
    label1721:
    label1727:
    label1741:
    label1746:
    for (boolean bool = true;; bool = false)
    {
      this.mfQ = bool;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { bqr(), Boolean.valueOf(this.mfQ), Boolean.valueOf(this.mfP) });
      if (this.mfP) {
        break label1991;
      }
      if (com.tencent.mm.aq.f.bkg().b(this.mfS, -1)) {
        break label1752;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 212L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { bqr() });
      this.lPn = "";
      AppMethodBeat.o(126830);
      return false;
      i = 0;
      break;
      i = 0;
      break label663;
      i = 0;
      break label828;
      i = ((bq.b)localObject1).luG / 8;
      break label865;
      this.mfS.field_autostart = false;
      break label989;
      i = 62;
      break label1474;
      this.lPu = ((String)localObject2);
      this.lPv = this.lAW;
      i = 0;
      break label1535;
    }
    label1752:
    if (this.mfQ) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 135L, 1L, false);
    }
    label1773:
    if (this.mfR.mhV != 1)
    {
      this.mfR.mhV = 1;
      this.mfR.cUP = 524288;
      y.f(this.mfR);
    }
    if (3 != this.mfR.mhX)
    {
      localObject1 = this.mfR.bqM();
      if (!Util.isNullOrNil((String)localObject1)) {
        if (!ab.Lj((String)localObject1)) {
          break label2164;
        }
      }
    }
    label1991:
    label2164:
    for (int j = v.Pu((String)localObject1);; j = 0) {
      for (;;)
      {
        try
        {
          localObject2 = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          i = ((NetworkInfo)localObject2).getSubtype();
          k = ((NetworkInfo)localObject2).getType();
          if (k != 1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { Util.stackTraceToString(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.lAW + "," + i;
        Log.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { bqr(), localObject1 });
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(126830);
        return true;
        this.mfV = false;
        localObject1 = this.mfS;
        s.bqB();
        ((com.tencent.mm.i.h)localObject1).field_fullpath = x.XT(this.fileName);
        if (this.mfQ)
        {
          this.mfS.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 251L, 1L, false);
        }
        s.bqC().a(this.mfS, false);
        break;
        if ((i == 13) || (i == 15) || (i == 14)) {
          i = 4;
        } else if ((i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 12)) {
          i = 3;
        } else if ((i == 1) || (i == 2)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
  }
  
  private String bqr()
  {
    AppMethodBeat.i(126837);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126837);
    return str;
  }
  
  private void xc(final int paramInt)
  {
    AppMethodBeat.i(126831);
    Object localObject;
    if (this.mfV)
    {
      localObject = new StringBuilder();
      s.bqB();
      localObject = x.XT(this.fileName) + ".tmp";
      s.bqB();
    }
    for (final boolean bool = u.oo((String)localObject, x.XT(this.fileName));; bool = true)
    {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126825);
          Object localObject1 = XmlParser.parseXml(h.h(h.this).bqO(), "msg", null);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = s.bqB();
            s.bqB();
            ((x)localObject2).t(x.XT(h.c(h.this)), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          }
          boolean bool1 = false;
          if (bool)
          {
            boolean bool2 = y.aQ(h.c(h.this), paramInt);
            bool1 = bool2;
            if (h.m(h.this))
            {
              y.Yp(h.c(h.this));
              Log.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
              bool1 = bool2;
            }
            Log.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { h.a(h.this), h.c(h.this), Long.valueOf(h.h(h.this).fNu), h.h(h.this).bqK(), h.h(h.this).bqM(), Boolean.valueOf(bool1), h.o(h.this), Integer.valueOf(h.p(h.this)), Boolean.valueOf(bool), Boolean.valueOf(h.q(h.this)) });
            if ((!Util.isNullOrNil(h.o(h.this))) && (h.p(h.this) > 0))
            {
              localObject1 = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT();
              localObject2 = h.o(h.this);
              int i = h.p(h.this);
              s.bqB();
              ((bz)localObject1).U((String)localObject2, i, x.XT(h.c(h.this)));
            }
            if (h.h(h.this).mhX != 3) {
              break label546;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 38L, h.h(h.this).lAW, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 40L, h.h(h.this).lvw, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 41L, 1L, false);
            localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
            if (!ab.Lj(h.h(h.this).bqM())) {
              break label538;
            }
          }
          label538:
          for (long l = 43L;; l = 42L)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(198L, l, 1L, false);
            h.g(h.this).onSceneEnd(0, 0, "", h.this);
            AppMethodBeat.o(126825);
            return;
            if (h.m(h.this))
            {
              y.Yb(h.c(h.this));
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 138L, 1L, false);
              break;
            }
            bool1 = y.aQ(h.c(h.this), paramInt);
            break;
          }
          label546:
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 31L, h.h(h.this).lAW, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 33L, h.h(h.this).lvw, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(198L, 34L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
          if (ab.Lj(h.h(h.this).bqM())) {}
          for (l = 36L;; l = 35L)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(198L, l, 1L, false);
            break;
          }
        }
      });
      AppMethodBeat.o(126831);
      return;
      localObject = new StringBuilder();
      s.bqB();
      u.deleteFile(x.XT(this.fileName) + ".tmp");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126827);
    TV();
    super.cancel();
    AppMethodBeat.o(126827);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    int i = 1;
    AppMethodBeat.i(126832);
    this.callback = parami;
    this.mfR = y.Yk(this.fileName);
    if (this.mfR == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.mfR != null) && (3 == this.mfR.mhX)) {
      this.mfT = com.tencent.mm.i.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.lPo = this.mfR.mhM;
    }
    if (bqq())
    {
      Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126832);
      return 0;
    }
    if (this.mfR.status != 112)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.mfR.status + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    Log.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "]  filesize:" + this.mfR.mhM + " file:" + this.mfR.lAW + " netTimes:" + this.mfR.mhS);
    if (!y.Ya(this.fileName))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.mfR.mhS + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if (this.mfR.fNu <= 0L)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.mfR.fNu + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.mfR.mhM < 0) || (this.mfR.lAW <= this.mfR.mhM) || (this.mfR.lAW <= 0))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.mfR.mhM + " total:" + this.mfR.lAW + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    parami = new d.a();
    parami.lBU = new aig();
    parami.lBV = new aih();
    parami.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    parami.funcId = 150;
    parami.lBW = 40;
    parami.respCmdId = 1000000040;
    this.rr = parami.bgN();
    parami = (aig)d.b.b(this.rr.lBR);
    parami.HlH = this.mfR.fNu;
    parami.Hna = this.mfR.mhM;
    parami.HmZ = this.mfR.lAW;
    if (ag.dj(MMApplicationContext.getContext())) {}
    for (;;)
    {
      parami.SsZ = i;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(126832);
      return i;
      i = 2;
    }
  }
  
  public final int getType()
  {
    return 150;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126836);
    if (this.mfU)
    {
      Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      AppMethodBeat.o(126836);
      return;
    }
    paramArrayOfByte = (aih)d.c.b(((com.tencent.mm.an.d)params).lBS);
    params = (aig)d.b.b(((com.tencent.mm.an.d)params).lBR);
    this.mfR = y.Yk(this.fileName);
    if (this.mfR == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.mfR.status == 113)
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.mfR.status != 112)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.mfR.status + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 208L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.mfT), Integer.valueOf(this.lAW - this.lPo) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 207L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      this.mfR.status = 113;
      y.f(this.mfR);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (Util.isNullOrNil(paramArrayOfByte.Hnc.Tkb.UH))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.Hna != params.Hna)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.Hna + " reqStartPos:" + params.Hna + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.HmZ != params.HmZ)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.HmZ + " reqTotal:" + params.HmZ + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (params.HmZ < paramArrayOfByte.Hna)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.HmZ + " respStartPos:" + params.Hna + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.HlH != params.HlH)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.HlH + " reqMsgId:" + params.HlH + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.Hnc.Ufv + " reqStartPos:" + params.Hna + " totallen:" + params.HmZ + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
    s.bqB();
    int j = x.a(x.XT(this.fileName), params.Hna, paramArrayOfByte.Hnc.Tkb.toByteArray());
    if (j < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (j > this.mfR.lAW)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.mfR.lAW + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    params = this.fileName;
    paramArrayOfByte = y.Yk(params);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.avD() + " getinfo failed: " + params);
      paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
    }
    while (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
      paramArrayOfByte.mhM = j;
      paramArrayOfByte.mhP = Util.nowSecond();
      paramArrayOfByte.cUP = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.lAW > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.lAW)
        {
          y.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.cUP |= 0x100;
          Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + params + " newsize:" + j + " total:" + paramArrayOfByte.lAW + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.mhS);
          paramInt1 = 1;
        }
      }
      Log.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.f.avD() + " file:" + params + " newsize:" + j + " total:" + paramArrayOfByte.lAW + " status:" + paramArrayOfByte.status);
      if (!y.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(this.mfT), Integer.valueOf(this.lAW - this.lPo) });
      a.a(this.mfR, 1);
      Log.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.mfU)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    this.lAo.startTimer(0L);
    AppMethodBeat.o(126836);
  }
  
  public final int securityLimitCount()
  {
    return 2500;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(126834);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126834);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(126833);
    params = (aig)d.b.b(((com.tencent.mm.an.d)params).lBR);
    if ((params.HlH <= 0L) || (params.Hna < 0) || (params.HmZ <= 0) || (params.HmZ <= params.Hna))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.mfR.fNu + "," + this.mfR.bqK() + "," + this.mfR.bqM() + "] ");
      y.Yb(this.fileName);
      params = q.b.lCy;
      AppMethodBeat.o(126833);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(126833);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 211L, 1L, false);
    y.Yb(this.fileName);
    AppMethodBeat.o(126835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */