package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.al.g callback;
  String fileName;
  int gTY;
  private av gTs;
  String hhN;
  String hhT;
  int hhU;
  private g.a hhW;
  boolean hyl;
  boolean hym;
  s hyn;
  com.tencent.mm.i.h hyo;
  int hyp;
  private boolean hyq;
  boolean hyr;
  long hys;
  private String mediaId;
  int retCode;
  private com.tencent.mm.al.b rr;
  private int startOffset;
  long startTime;
  
  public d(String paramString)
  {
    this(paramString, false);
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126829);
    this.hyn = null;
    this.hhN = "";
    this.startOffset = 0;
    this.startTime = 0L;
    this.gTY = 0;
    this.retCode = 0;
    this.hyp = com.tencent.mm.i.a.MediaType_VIDEO;
    this.hyq = false;
    this.hyr = true;
    this.hhT = null;
    this.hhU = 0;
    this.hys = 0L;
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126824);
        if (paramAnonymousInt == -21006)
        {
          ad.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { d.this.aCy(), d.this.hhN });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.zV(d.this.fileName);
          paramAnonymousString = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(d.this.hyp), Integer.valueOf(d.this.gTY), "" });
          new com.tencent.mm.g.b.a.h(paramAnonymousString).aBj();
          new com.tencent.mm.g.b.a.f(paramAnonymousString).aBj();
          d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
          AppMethodBeat.o(126824);
          return 0;
        }
        d.this.hyn = u.Ae(d.this.fileName);
        if ((d.this.hyn == null) || (d.this.hyn.status == 113))
        {
          if (d.this.hyn == null) {}
          for (int i = -1;; i = d.this.hyn.status)
          {
            ad.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { d.this.aCy(), Integer.valueOf(i) });
            d.this.Ft();
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == d.this.gTY)
          {
            ad.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            AppMethodBeat.o(126824);
            return 0;
          }
          if ((d.this.hyn.hAd > paramAnonymousc.field_finishedLength) && (!d.this.hyl))
          {
            ad.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { d.this.aCy(), Integer.valueOf(d.this.hyn.hAd), Long.valueOf(paramAnonymousc.field_finishedLength) });
            u.zV(d.this.fileName);
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
          paramAnonymousInt = 1024;
          d.this.hyn.hAg = bt.aGK();
          if (d.this.hyn.hAd < paramAnonymousc.field_finishedLength)
          {
            d.this.hyn.hAd = ((int)paramAnonymousc.field_finishedLength);
            paramAnonymousInt = 1040;
          }
          d.this.hyn.dtM = paramAnonymousInt;
          u.f(d.this.hyn);
          ad.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { d.this.aCy(), d.this.hhN, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { d.this.aCy(), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(bt.eGO() - d.this.hys) });
          paramAnonymousString = d.this;
          paramAnonymousc = d.this.hyo;
          if ((paramAnonymousc != null) && (paramAnonymousd != null)) {
            break label1155;
          }
          ad.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
          if (paramAnonymousd.field_retCode == 0) {
            break label1249;
          }
          u.zV(d.this.fileName);
          if (d.this.hyl) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 13L, 1L, false);
          }
          if (d.this.hym) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 252L, 1L, false);
          }
          d.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", d.this);
        }
        for (;;)
        {
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(d.this.hyp), Integer.valueOf(d.this.gTY), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(d.this.hyp), Integer.valueOf(d.this.gTY), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
          }
          a.a(d.this.hyn, 1);
          d.this.hyo = null;
          AppMethodBeat.o(126824);
          return 0;
          label1155:
          if (paramAnonymousc.field_smallVideoFlag == 1)
          {
            ad.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
            break;
          }
          if ((paramAnonymousc == null) || (paramAnonymousd == null)) {
            break;
          }
          ad.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[] { paramAnonymousString.aCy(), Long.valueOf(paramAnonymousd.field_recvedBytes), Long.valueOf(paramAnonymousd.field_startTime), Long.valueOf(paramAnonymousd.field_endTime) });
          o.aCJ();
          com.tencent.mm.ao.e.a(null, paramAnonymousd, paramAnonymousc, true);
          break;
          label1249:
          if (d.this.hyl) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 12L, 1L, false);
          }
          if (d.this.hym) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 137L, 1L, false);
          }
          d.this.oT((int)paramAnonymousd.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126826);
        if (d.this.doScene(d.this.dispatcher(), d.this.callback) == -1) {
          d.this.callback.onSceneEnd(3, -1, "doScene failed", d.this);
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
      this.hyl = paramBoolean;
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { aCy(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(126829);
      return;
    }
  }
  
  private boolean aCx()
  {
    AppMethodBeat.i(126830);
    ad.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { aCy(), this.hyn.aCT() });
    Object localObject4 = bw.K(this.hyn.aCT(), "msg");
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 214L, 1L, false);
      ad.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aCy() });
      AppMethodBeat.o(126830);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 213L, 1L, false);
      ad.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aCy() });
      AppMethodBeat.o(126830);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.gTY = bt.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.hhN = com.tencent.mm.ao.c.a("downvideo", this.hyn.createTime, this.hyn.getUser(), this.hyn.getFileName());
    if (bt.isNullOrNil(this.hhN))
    {
      ad.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { aCy(), this.hyn.getFileName() });
      AppMethodBeat.o(126830);
      return false;
    }
    if ((!this.hyl) && (this.gTY < 1048576) && (this.hyn != null) && (this.hyn.dpA > 0))
    {
      this.hyl = true;
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { aCy(), Boolean.valueOf(this.hyl) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.aCI();
    localObject3 = t.zQ(this.fileName) + ".tmp";
    this.hyo = new com.tencent.mm.i.h();
    this.hyo.filename = this.hyn.getFileName();
    this.hyo.foa = ((String)localObject2);
    this.hyo.fob = this.gTY;
    this.hyo.foc = 0;
    this.hyo.dpv = this.hyn.aCQ();
    this.hyo.fod = this.hyn.getUser();
    com.tencent.mm.i.h localh = this.hyo;
    int i;
    label640:
    label805:
    label842:
    int k;
    if (w.pF(this.hyn.getUser()))
    {
      i = com.tencent.mm.model.q.rY(this.hyn.getUser());
      localh.dpx = i;
      this.hyo.field_mediaId = this.hhN;
      this.hyo.field_fullpath = ((String)localObject3);
      this.hyo.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      this.hyo.field_totalLen = this.gTY;
      this.hyo.field_aesKey = ((String)localObject5);
      this.hyo.field_fileId = str1;
      this.hyo.field_priority = com.tencent.mm.i.a.fmV;
      this.hyo.fnH = this.hhW;
      this.hyo.field_wxmsgparam = str2;
      localObject5 = this.hyo;
      if (!w.pF(this.hyn.getUser())) {
        break label1665;
      }
      i = 1;
      ((com.tencent.mm.i.h)localObject5).field_chattype = i;
      this.hyo.foe = this.hyn.foe;
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.hyo.field_fileId = "";
        this.hyo.field_fileType = 19;
        this.hyo.field_authKey = ((String)localObject4);
        this.hyo.fnK = ((String)localObject1);
      }
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(this.hyn.getUser(), this.hyn.drA);
      this.hyo.fog = ((du)localObject4).field_createTime;
      this.hyo.drA = ((du)localObject4).field_msgSvrId;
      localObject1 = bi.ul(((du)localObject4).esh);
      localObject5 = this.hyo;
      if (localObject1 == null) {
        break label1670;
      }
      i = ((bi.b)localObject1).gOm;
      ((com.tencent.mm.i.h)localObject5).foh = i;
      if (this.hyn.getUser().equals(((du)localObject4).field_talker))
      {
        localObject5 = this.hyo;
        if (localObject1 != null) {
          break label1675;
        }
        i = 0;
        ((com.tencent.mm.i.h)localObject5).field_limitrate = i;
      }
      ad.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { aCy(), Integer.valueOf(this.hyo.field_limitrate), this.hyn.getFileName() });
      if (!com.tencent.mm.ao.f.awL().haO.contains("video_" + this.hyn.hAi)) {
        break label1687;
      }
      com.tencent.mm.ao.f.awL().haO.remove("video_" + this.hyn.hAi);
      this.hyo.field_autostart = true;
      label966:
      if (3 == this.hyn.hAo) {
        this.hyo.field_smallVideoFlag = 1;
      }
      if ((bt.isNullOrNil((String)localObject2)) || (this.hyl)) {
        break label1718;
      }
      localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT().fP((String)localObject2, this.gTY);
      j = (int)i.aMN((String)localObject1);
      k = this.gTY - j;
      o.aCI();
      localObject5 = t.zQ(this.fileName);
      int m = (int)i.aMN((String)localObject5);
      if (m > 0)
      {
        ad.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { aCy() });
        bool = i.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT();
        int n = this.gTY;
        i = 0;
        if (!bt.isNullOrNil((String)localObject2)) {
          i = ((bk)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = u.Ae(this.fileName);
        ((s)localObject1).hAd = 0;
        ((s)localObject1).dtM = 16;
        u.f((s)localObject1);
        ad.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { aCy(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { aCy(), Integer.valueOf(this.gTY), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (bt.isNullOrNil((String)localObject1)) {
        break label1704;
      }
      if ((k < 0) || (k > 16)) {
        break label1718;
      }
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { aCy(), localObject1, localObject3 });
      i.lC((String)localObject1, (String)localObject3);
      oT(this.gTY);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(((du)localObject4).field_talker, "update", (bl)localObject4));
      localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
      long l1 = this.hyn.drA;
      long l2 = this.hyn.createTime;
      localObject3 = this.hyn.getUser();
      if (3 == this.hyn.hAo) {
        break label1698;
      }
      i = 43;
      label1451:
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(13267, new Object[] { str1, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1512:
      if (i != 0) {
        break label1750;
      }
      this.mediaId = this.hyo.field_mediaId;
      this.hys = bt.eGO();
      if (this.hyn.videoFormat != 2) {
        break label1723;
      }
    }
    label1665:
    label1670:
    label1675:
    label1687:
    label1698:
    label1704:
    label1718:
    label1723:
    for (boolean bool = true;; bool = false)
    {
      this.hym = bool;
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { aCy(), Boolean.valueOf(this.hym), Boolean.valueOf(this.hyl) });
      if (this.hyl) {
        break label1968;
      }
      if (com.tencent.mm.ao.f.awL().b(this.hyo, -1)) {
        break label1729;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 212L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { aCy() });
      this.hhN = "";
      AppMethodBeat.o(126830);
      return false;
      i = 0;
      break;
      i = 0;
      break label640;
      i = 0;
      break label805;
      i = ((bi.b)localObject1).gOk / 8;
      break label842;
      this.hyo.field_autostart = false;
      break label966;
      i = 62;
      break label1451;
      this.hhT = ((String)localObject2);
      this.hhU = this.gTY;
      i = 0;
      break label1512;
    }
    label1729:
    if (this.hym) {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 135L, 1L, false);
    }
    label1750:
    if (this.hyn.hAm != 1)
    {
      this.hyn.hAm = 1;
      this.hyn.dtM = 524288;
      u.f(this.hyn);
    }
    if (3 != this.hyn.hAo)
    {
      localObject1 = this.hyn.getUser();
      if (!bt.isNullOrNil((String)localObject1)) {
        if (!w.pF((String)localObject1)) {
          break label2141;
        }
      }
    }
    label1968:
    label2141:
    for (int j = com.tencent.mm.model.q.rY((String)localObject1);; j = 0) {
      for (;;)
      {
        try
        {
          localObject2 = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          i = ((NetworkInfo)localObject2).getSubtype();
          k = ((NetworkInfo)localObject2).getType();
          if (k != 1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { bt.m(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.gTY + "," + i;
        ad.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { aCy(), localObject1 });
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(126830);
        return true;
        this.hyr = false;
        localObject1 = this.hyo;
        o.aCI();
        ((com.tencent.mm.i.h)localObject1).field_fullpath = t.zQ(this.fileName);
        if (this.hym)
        {
          this.hyo.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 251L, 1L, false);
        }
        o.aCJ().a(this.hyo, false);
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
  
  final boolean Ft()
  {
    boolean bool = false;
    AppMethodBeat.i(126828);
    if (!bt.isNullOrNil(this.mediaId))
    {
      if (!this.hyl) {
        break label71;
      }
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { aCy() });
      o.aCJ().k(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.hyq = true;
      AppMethodBeat.o(126828);
      return bool;
      label71:
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { aCy() });
      com.tencent.mm.ao.f.awL().xL(this.mediaId);
    }
  }
  
  final String aCy()
  {
    AppMethodBeat.i(126837);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126837);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126827);
    Ft();
    super.cancel();
    AppMethodBeat.o(126827);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    int i = 1;
    AppMethodBeat.i(126832);
    this.callback = paramg;
    this.hyn = u.Ae(this.fileName);
    if (this.hyn == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.hyn != null) && (3 == this.hyn.hAo)) {
      this.hyp = com.tencent.mm.i.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.eGO();
      this.startOffset = this.hyn.hAd;
    }
    if (aCx())
    {
      ad.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126832);
      return 0;
    }
    if (this.hyn.status != 112)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.hyn.status + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    ad.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "]  filesize:" + this.hyn.hAd + " file:" + this.hyn.gTY + " netTimes:" + this.hyn.hAj);
    if (!u.zU(this.fileName))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.hyn.hAj + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if (this.hyn.drA <= 0L)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.hyn.drA + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.hyn.hAd < 0) || (this.hyn.gTY <= this.hyn.hAd) || (this.hyn.gTY <= 0))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.hyn.hAd + " total:" + this.hyn.gTY + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    paramg = new b.a();
    paramg.gUU = new acf();
    paramg.gUV = new acg();
    paramg.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    paramg.funcId = 150;
    paramg.reqCmdId = 40;
    paramg.respCmdId = 1000000040;
    this.rr = paramg.atI();
    paramg = (acf)this.rr.gUS.gUX;
    paramg.uKZ = this.hyn.drA;
    paramg.uKR = this.hyn.hAd;
    paramg.uKQ = this.hyn.gTY;
    if (ae.cJ(aj.getContext())) {}
    for (;;)
    {
      paramg.DcM = i;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(126832);
      return i;
      i = 2;
    }
  }
  
  public final int getType()
  {
    return 150;
  }
  
  final void oT(final int paramInt)
  {
    AppMethodBeat.i(126831);
    Object localObject;
    if (this.hyr)
    {
      localObject = new StringBuilder();
      o.aCI();
      localObject = new com.tencent.mm.vfs.e(t.zQ(this.fileName) + ".tmp");
      o.aCI();
    }
    for (final boolean bool = ((com.tencent.mm.vfs.e)localObject).af(new com.tencent.mm.vfs.e(t.zQ(this.fileName)));; bool = true)
    {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126825);
          Object localObject1 = bw.K(d.this.hyn.aCT(), "msg");
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = o.aCI();
            o.aCI();
            ((t)localObject2).r(t.zQ(d.this.fileName), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          }
          boolean bool1 = false;
          if (bool)
          {
            boolean bool2 = u.an(d.this.fileName, paramInt);
            bool1 = bool2;
            if (d.this.hym)
            {
              u.Ak(d.this.fileName);
              ad.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
              bool1 = bool2;
            }
            ad.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { d.this.aCy(), d.this.fileName, Long.valueOf(d.this.hyn.drA), d.this.hyn.aCQ(), d.this.hyn.getUser(), Boolean.valueOf(bool1), d.this.hhT, Integer.valueOf(d.this.hhU), Boolean.valueOf(bool), Boolean.valueOf(d.this.hyr) });
            if ((!bt.isNullOrNil(d.this.hhT)) && (d.this.hhU > 0))
            {
              localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT();
              localObject2 = d.this.hhT;
              int i = d.this.hhU;
              o.aCI();
              ((bk)localObject1).E((String)localObject2, i, t.zQ(d.this.fileName));
            }
            if (d.this.hyn.hAo != 3) {
              break label545;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 38L, d.this.hyn.gTY, false);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 40L, d.this.hyn.gOY, false);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 41L, 1L, false);
            localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
            if (!w.pF(d.this.hyn.getUser())) {
              break label537;
            }
          }
          label537:
          for (long l = 43L;; l = 42L)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(198L, l, 1L, false);
            d.this.callback.onSceneEnd(0, 0, "", d.this);
            AppMethodBeat.o(126825);
            return;
            if (d.this.hym)
            {
              u.zV(d.this.fileName);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 138L, 1L, false);
              break;
            }
            bool1 = u.an(d.this.fileName, paramInt);
            break;
          }
          label545:
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 31L, d.this.hyn.gTY, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 33L, d.this.hyn.gOY, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 34L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
          if (w.pF(d.this.hyn.getUser())) {}
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
      o.aCI();
      i.deleteFile(t.zQ(this.fileName) + ".tmp");
    }
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126836);
    if (this.hyq)
    {
      ad.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      AppMethodBeat.o(126836);
      return;
    }
    paramArrayOfByte = (acg)((com.tencent.mm.al.b)paramq).gUT.gUX;
    paramq = (acf)((com.tencent.mm.al.b)paramq).gUS.gUX;
    this.hyn = u.Ae(this.fileName);
    if (this.hyn == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.hyn.status == 113)
    {
      ad.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.hyn.status != 112)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hyn.status + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 208L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.hyp), Integer.valueOf(this.gTY - this.startOffset) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 207L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      this.hyn.status = 113;
      u.f(this.hyn);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (bt.cw(paramArrayOfByte.uKT.getBuffer().wA))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.uKR != paramq.uKR)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.uKR + " reqStartPos:" + paramq.uKR + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.uKQ != paramq.uKQ)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.uKQ + " reqTotal:" + paramq.uKQ + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramq.uKQ < paramArrayOfByte.uKR)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.uKQ + " respStartPos:" + paramq.uKR + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.uKZ != paramq.uKZ)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.uKZ + " reqMsgId:" + paramq.uKZ + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    ad.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.uKT.getILen() + " reqStartPos:" + paramq.uKR + " totallen:" + paramq.uKQ + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
    o.aCI();
    int j = t.a(t.zQ(this.fileName), paramq.uKR, paramArrayOfByte.uKT.getBuffer().toByteArray());
    if (j < 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (j > this.hyn.gTY)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.hyn.gTY + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    paramq = this.fileName;
    paramArrayOfByte = u.Ae(paramq);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.XJ() + " getinfo failed: " + paramq);
      paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
    }
    while (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
      paramArrayOfByte.hAd = j;
      paramArrayOfByte.hAg = bt.aGK();
      paramArrayOfByte.dtM = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.gTY > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.gTY)
        {
          u.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.dtM |= 0x100;
          ad.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.gTY + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.hAj);
          paramInt1 = 1;
        }
      }
      ad.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.f.XJ() + " file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.gTY + " status:" + paramArrayOfByte.status);
      if (!u.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.hyp), Integer.valueOf(this.gTY - this.startOffset) });
      a.a(this.hyn, 1);
      ad.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.hyq)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    this.gTs.av(0L, 0L);
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
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126834);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(126833);
    paramq = (acf)((com.tencent.mm.al.b)paramq).gUS.gUX;
    if ((paramq.uKZ <= 0L) || (paramq.uKR < 0) || (paramq.uKQ <= 0) || (paramq.uKQ <= paramq.uKR))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.hyn.drA + "," + this.hyn.aCQ() + "," + this.hyn.getUser() + "] ");
      u.zV(this.fileName);
      paramq = n.b.gVC;
      AppMethodBeat.o(126833);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(126833);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 211L, 1L, false);
    u.zV(this.fileName);
    AppMethodBeat.o(126835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */