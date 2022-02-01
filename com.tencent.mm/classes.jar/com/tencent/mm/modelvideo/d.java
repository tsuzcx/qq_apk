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
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends n
  implements k
{
  com.tencent.mm.al.f callback;
  String fileName;
  int hMP;
  private av hMj;
  String ibe;
  String ibk;
  int ibl;
  private g.a ibn;
  boolean isi;
  boolean isj;
  s isk;
  com.tencent.mm.i.h isl;
  int ism;
  private boolean isn;
  boolean iso;
  long isp;
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
    this.isk = null;
    this.ibe = "";
    this.startOffset = 0;
    this.startTime = 0L;
    this.hMP = 0;
    this.retCode = 0;
    this.ism = com.tencent.mm.i.a.MediaType_VIDEO;
    this.isn = false;
    this.iso = true;
    this.ibk = null;
    this.ibl = 0;
    this.isp = 0L;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126824);
        if (paramAnonymousInt == -21006)
        {
          ad.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { d.this.aMz(), d.this.ibe });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.Hp(d.this.fileName);
          paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(d.this.ism), Integer.valueOf(d.this.hMP), "" });
          new j(paramAnonymousString).aLk();
          new com.tencent.mm.g.b.a.h(paramAnonymousString).aLk();
          d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
          AppMethodBeat.o(126824);
          return 0;
        }
        d.this.isk = u.Hy(d.this.fileName);
        if ((d.this.isk == null) || (d.this.isk.status == 113))
        {
          if (d.this.isk == null) {}
          for (int i = -1;; i = d.this.isk.status)
          {
            ad.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { d.this.aMz(), Integer.valueOf(i) });
            d.this.Gv();
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == d.this.hMP)
          {
            ad.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            AppMethodBeat.o(126824);
            return 0;
          }
          if ((d.this.isk.iua > paramAnonymousc.field_finishedLength) && (!d.this.isi))
          {
            ad.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { d.this.aMz(), Integer.valueOf(d.this.isk.iua), Long.valueOf(paramAnonymousc.field_finishedLength) });
            u.Hp(d.this.fileName);
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
          paramAnonymousInt = 1024;
          d.this.isk.iud = com.tencent.mm.sdk.platformtools.bt.aQJ();
          if (d.this.isk.iua < paramAnonymousc.field_finishedLength)
          {
            d.this.isk.iua = ((int)paramAnonymousc.field_finishedLength);
            paramAnonymousInt = 1040;
          }
          d.this.isk.dDp = paramAnonymousInt;
          u.f(d.this.isk);
          ad.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { d.this.aMz(), d.this.ibe, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ad.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { d.this.aMz(), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT() - d.this.isp) });
          paramAnonymousString = d.this;
          paramAnonymousc = d.this.isl;
          if ((paramAnonymousc != null) && (paramAnonymousd != null)) {
            break label1155;
          }
          ad.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
          if (paramAnonymousd.field_retCode == 0) {
            break label1249;
          }
          u.Hp(d.this.fileName);
          if (d.this.isi) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 13L, 1L, false);
          }
          if (d.this.isj) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 252L, 1L, false);
          }
          d.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", d.this);
        }
        for (;;)
        {
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(d.this.ism), Integer.valueOf(d.this.hMP), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(d.this.ism), Integer.valueOf(d.this.hMP), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
          }
          a.a(d.this.isk, 1);
          d.this.isl = null;
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
          ad.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[] { paramAnonymousString.aMz(), Long.valueOf(paramAnonymousd.field_recvedBytes), Long.valueOf(paramAnonymousd.field_startTime), Long.valueOf(paramAnonymousd.field_endTime) });
          o.aMK();
          com.tencent.mm.ao.e.a(null, paramAnonymousd, paramAnonymousc, true);
          break;
          label1249:
          if (d.this.isi) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 12L, 1L, false);
          }
          if (d.this.isj) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 137L, 1L, false);
          }
          d.this.qk((int)paramAnonymousd.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.hMj = new av(new av.a()
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
      this.isi = paramBoolean;
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { aMz(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(126829);
      return;
    }
  }
  
  private boolean aMy()
  {
    AppMethodBeat.i(126830);
    ad.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { aMz(), this.isk.aMV() });
    Object localObject4 = bw.M(this.isk.aMV(), "msg");
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 214L, 1L, false);
      ad.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aMz() });
      AppMethodBeat.o(126830);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str1)) && (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 213L, 1L, false);
      ad.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aMz() });
      AppMethodBeat.o(126830);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.hMP = com.tencent.mm.sdk.platformtools.bt.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.ibe = com.tencent.mm.ao.c.a("downvideo", this.isk.createTime, this.isk.getUser(), this.isk.getFileName());
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.ibe))
    {
      ad.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { aMz(), this.isk.getFileName() });
      AppMethodBeat.o(126830);
      return false;
    }
    if ((!this.isi) && (this.hMP < 1048576) && (this.isk != null) && (this.isk.dyZ > 0))
    {
      this.isi = true;
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { aMz(), Boolean.valueOf(this.isi) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.aMJ();
    localObject3 = t.Hh(this.fileName) + ".tmp";
    this.isl = new com.tencent.mm.i.h();
    this.isl.fJi = "task_NetSceneDownloadVideo";
    this.isl.filename = this.isk.getFileName();
    this.isl.fJD = ((String)localObject2);
    this.isl.fJE = this.hMP;
    this.isl.fJF = 0;
    this.isl.dyU = this.isk.aMS();
    this.isl.fJG = this.isk.getUser();
    com.tencent.mm.i.h localh = this.isl;
    int i;
    label650:
    label815:
    label852:
    int k;
    if (w.vF(this.isk.getUser()))
    {
      i = com.tencent.mm.model.q.yS(this.isk.getUser());
      localh.dyW = i;
      this.isl.field_mediaId = this.ibe;
      this.isl.field_fullpath = ((String)localObject3);
      this.isl.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      this.isl.field_totalLen = this.hMP;
      this.isl.field_aesKey = ((String)localObject5);
      this.isl.field_fileId = str1;
      this.isl.field_priority = com.tencent.mm.i.a.fIw;
      this.isl.fJj = this.ibn;
      this.isl.field_wxmsgparam = str2;
      localObject5 = this.isl;
      if (!w.vF(this.isk.getUser())) {
        break label1675;
      }
      i = 1;
      ((com.tencent.mm.i.h)localObject5).field_chattype = i;
      this.isl.fJH = this.isk.fJH;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.isl.field_fileId = "";
        this.isl.field_fileType = 19;
        this.isl.field_authKey = ((String)localObject4);
        this.isl.fJm = ((String)localObject1);
      }
      localObject4 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(this.isk.getUser(), this.isk.dAY);
      this.isl.fJJ = ((ei)localObject4).field_createTime;
      this.isl.dAY = ((ei)localObject4).field_msgSvrId;
      localObject1 = bj.Bq(((ei)localObject4).eLs);
      localObject5 = this.isl;
      if (localObject1 == null) {
        break label1680;
      }
      i = ((bj.b)localObject1).hHe;
      ((com.tencent.mm.i.h)localObject5).fJK = i;
      if (this.isk.getUser().equals(((ei)localObject4).field_talker))
      {
        localObject5 = this.isl;
        if (localObject1 != null) {
          break label1685;
        }
        i = 0;
        ((com.tencent.mm.i.h)localObject5).field_limitrate = i;
      }
      ad.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { aMz(), Integer.valueOf(this.isl.field_limitrate), this.isk.getFileName() });
      if (!com.tencent.mm.ao.f.aGI().hTO.contains("video_" + this.isk.iuf)) {
        break label1697;
      }
      com.tencent.mm.ao.f.aGI().hTO.remove("video_" + this.isk.iuf);
      this.isl.field_autostart = true;
      label976:
      if (3 == this.isk.iul) {
        this.isl.field_smallVideoFlag = 1;
      }
      if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2)) || (this.isi)) {
        break label1728;
      }
      localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx().gq((String)localObject2, this.hMP);
      j = (int)com.tencent.mm.vfs.i.aYo((String)localObject1);
      k = this.hMP - j;
      o.aMJ();
      localObject5 = t.Hh(this.fileName);
      int m = (int)com.tencent.mm.vfs.i.aYo((String)localObject5);
      if (m > 0)
      {
        ad.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { aMz() });
        bool = com.tencent.mm.vfs.i.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx();
        int n = this.hMP;
        i = 0;
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2)) {
          i = ((com.tencent.mm.storage.bt)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = u.Hy(this.fileName);
        ((s)localObject1).iua = 0;
        ((s)localObject1).dDp = 16;
        u.f((s)localObject1);
        ad.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { aMz(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { aMz(), Integer.valueOf(this.hMP), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)) {
        break label1714;
      }
      if ((k < 0) || (k > 16)) {
        break label1728;
      }
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { aMz(), localObject1, localObject3 });
      com.tencent.mm.vfs.i.mz((String)localObject1, (String)localObject3);
      qk(this.hMP);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(((ei)localObject4).field_talker, "update", (bu)localObject4));
      localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
      long l1 = this.isk.dAY;
      long l2 = this.isk.createTime;
      localObject3 = this.isk.getUser();
      if (3 == this.isk.iul) {
        break label1708;
      }
      i = 43;
      label1461:
      ((com.tencent.mm.plugin.report.service.g)localObject1).f(13267, new Object[] { str1, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1522:
      if (i != 0) {
        break label1760;
      }
      this.mediaId = this.isl.field_mediaId;
      this.isp = com.tencent.mm.sdk.platformtools.bt.flT();
      if (this.isk.videoFormat != 2) {
        break label1733;
      }
    }
    label1675:
    label1680:
    label1685:
    label1697:
    label1708:
    label1714:
    label1728:
    label1733:
    for (boolean bool = true;; bool = false)
    {
      this.isj = bool;
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { aMz(), Boolean.valueOf(this.isj), Boolean.valueOf(this.isi) });
      if (this.isi) {
        break label1978;
      }
      if (com.tencent.mm.ao.f.aGI().b(this.isl, -1)) {
        break label1739;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 212L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { aMz() });
      this.ibe = "";
      AppMethodBeat.o(126830);
      return false;
      i = 0;
      break;
      i = 0;
      break label650;
      i = 0;
      break label815;
      i = ((bj.b)localObject1).hHc / 8;
      break label852;
      this.isl.field_autostart = false;
      break label976;
      i = 62;
      break label1461;
      this.ibk = ((String)localObject2);
      this.ibl = this.hMP;
      i = 0;
      break label1522;
    }
    label1739:
    if (this.isj) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 135L, 1L, false);
    }
    label1760:
    if (this.isk.iuj != 1)
    {
      this.isk.iuj = 1;
      this.isk.dDp = 524288;
      u.f(this.isk);
    }
    if (3 != this.isk.iul)
    {
      localObject1 = this.isk.getUser();
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1)) {
        if (!w.vF((String)localObject1)) {
          break label2151;
        }
      }
    }
    label1978:
    label2151:
    for (int j = com.tencent.mm.model.q.yS((String)localObject1);; j = 0) {
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
          ad.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { com.tencent.mm.sdk.platformtools.bt.n(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.hMP + "," + i;
        ad.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { aMz(), localObject1 });
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(126830);
        return true;
        this.iso = false;
        localObject1 = this.isl;
        o.aMJ();
        ((com.tencent.mm.i.h)localObject1).field_fullpath = t.Hh(this.fileName);
        if (this.isj)
        {
          this.isl.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 251L, 1L, false);
        }
        o.aMK().a(this.isl, false);
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
  
  final boolean Gv()
  {
    boolean bool = false;
    AppMethodBeat.i(126828);
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.mediaId))
    {
      if (!this.isi) {
        break label71;
      }
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { aMz() });
      o.aMK().m(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.isn = true;
      AppMethodBeat.o(126828);
      return bool;
      label71:
      ad.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { aMz() });
      com.tencent.mm.ao.f.aGI().EQ(this.mediaId);
    }
  }
  
  final String aMz()
  {
    AppMethodBeat.i(126837);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126837);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126827);
    Gv();
    super.cancel();
    AppMethodBeat.o(126827);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    int i = 1;
    AppMethodBeat.i(126832);
    this.callback = paramf;
    this.isk = u.Hy(this.fileName);
    if (this.isk == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.isk != null) && (3 == this.isk.iul)) {
      this.ism = com.tencent.mm.i.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = com.tencent.mm.sdk.platformtools.bt.flT();
      this.startOffset = this.isk.iua;
    }
    if (aMy())
    {
      ad.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126832);
      return 0;
    }
    if (this.isk.status != 112)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.isk.status + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    ad.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "]  filesize:" + this.isk.iua + " file:" + this.isk.hMP + " netTimes:" + this.isk.iug);
    if (!u.Ho(this.fileName))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.isk.iug + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if (this.isk.dAY <= 0L)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.isk.dAY + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.isk.iua < 0) || (this.isk.hMP <= this.isk.iua) || (this.isk.hMP <= 0))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.isk.iua + " total:" + this.isk.hMP + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    paramf = new b.a();
    paramf.hNM = new aff();
    paramf.hNN = new afg();
    paramf.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    paramf.funcId = 150;
    paramf.hNO = 40;
    paramf.respCmdId = 1000000040;
    this.rr = paramf.aDC();
    paramf = (aff)this.rr.hNK.hNQ;
    paramf.xbt = this.isk.dAY;
    paramf.xcL = this.isk.iua;
    paramf.xcK = this.isk.hMP;
    if (ae.cP(aj.getContext())) {}
    for (;;)
    {
      paramf.Gdp = i;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126836);
    if (this.isn)
    {
      ad.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.ibe)))
    {
      ad.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.ibe });
      AppMethodBeat.o(126836);
      return;
    }
    paramArrayOfByte = (afg)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    paramq = (aff)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    this.isk = u.Hy(this.fileName);
    if (this.isk == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.isk.status == 113)
    {
      ad.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.isk.status != 112)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.isk.status + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 208L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.ism), Integer.valueOf(this.hMP - this.startOffset) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 207L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      this.isk.status = 113;
      u.f(this.isk);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.bt.cC(paramArrayOfByte.xcN.getBuffer().zr))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.xcL != paramq.xcL)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.xcL + " reqStartPos:" + paramq.xcL + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.xcK != paramq.xcK)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.xcK + " reqTotal:" + paramq.xcK + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramq.xcK < paramArrayOfByte.xcL)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.xcK + " respStartPos:" + paramq.xcL + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.xbt != paramq.xbt)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.xbt + " reqMsgId:" + paramq.xbt + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    ad.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.xcN.getILen() + " reqStartPos:" + paramq.xcL + " totallen:" + paramq.xcK + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
    o.aMJ();
    int j = t.a(t.Hh(this.fileName), paramq.xcL, paramArrayOfByte.xcN.getBuffer().toByteArray());
    if (j < 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (j > this.isk.hMP)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.isk.hMP + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    paramq = this.fileName;
    paramArrayOfByte = u.Hy(paramq);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.abi() + " getinfo failed: " + paramq);
      paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
    }
    while (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
      paramArrayOfByte.iua = j;
      paramArrayOfByte.iud = com.tencent.mm.sdk.platformtools.bt.aQJ();
      paramArrayOfByte.dDp = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.hMP > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.hMP)
        {
          u.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.dDp |= 0x100;
          ad.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.hMP + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.iug);
          paramInt1 = 1;
        }
      }
      ad.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.f.abi() + " file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.hMP + " status:" + paramArrayOfByte.status);
      if (!u.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(this.ism), Integer.valueOf(this.hMP - this.startOffset) });
      a.a(this.isk, 1);
      ad.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.isn)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    this.hMj.az(0L, 0L);
    AppMethodBeat.o(126836);
  }
  
  final void qk(final int paramInt)
  {
    AppMethodBeat.i(126831);
    Object localObject;
    if (this.iso)
    {
      localObject = new StringBuilder();
      o.aMJ();
      localObject = new com.tencent.mm.vfs.e(t.Hh(this.fileName) + ".tmp");
      o.aMJ();
    }
    for (final boolean bool = ((com.tencent.mm.vfs.e)localObject).ag(new com.tencent.mm.vfs.e(t.Hh(this.fileName)));; bool = true)
    {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126825);
          Object localObject1 = bw.M(d.this.isk.aMV(), "msg");
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = o.aMJ();
            o.aMJ();
            ((t)localObject2).q(t.Hh(d.this.fileName), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          }
          boolean bool1 = false;
          if (bool)
          {
            boolean bool2 = u.at(d.this.fileName, paramInt);
            bool1 = bool2;
            if (d.this.isj)
            {
              u.HE(d.this.fileName);
              ad.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
              bool1 = bool2;
            }
            ad.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { d.this.aMz(), d.this.fileName, Long.valueOf(d.this.isk.dAY), d.this.isk.aMS(), d.this.isk.getUser(), Boolean.valueOf(bool1), d.this.ibk, Integer.valueOf(d.this.ibl), Boolean.valueOf(bool), Boolean.valueOf(d.this.iso) });
            if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(d.this.ibk)) && (d.this.ibl > 0))
            {
              localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx();
              localObject2 = d.this.ibk;
              int i = d.this.ibl;
              o.aMJ();
              ((com.tencent.mm.storage.bt)localObject1).E((String)localObject2, i, t.Hh(d.this.fileName));
            }
            if (d.this.isk.iul != 3) {
              break label545;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 38L, d.this.isk.hMP, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 40L, d.this.isk.hHQ, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 41L, 1L, false);
            localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
            if (!w.vF(d.this.isk.getUser())) {
              break label537;
            }
          }
          label537:
          for (long l = 43L;; l = 42L)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject1).idkeyStat(198L, l, 1L, false);
            d.this.callback.onSceneEnd(0, 0, "", d.this);
            AppMethodBeat.o(126825);
            return;
            if (d.this.isj)
            {
              u.Hp(d.this.fileName);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 138L, 1L, false);
              break;
            }
            bool1 = u.at(d.this.fileName, paramInt);
            break;
          }
          label545:
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 31L, d.this.isk.hMP, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 33L, d.this.isk.hHQ, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 34L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
          if (w.vF(d.this.isk.getUser())) {}
          for (l = 36L;; l = 35L)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject1).idkeyStat(198L, l, 1L, false);
            break;
          }
        }
      });
      AppMethodBeat.o(126831);
      return;
      localObject = new StringBuilder();
      o.aMJ();
      com.tencent.mm.vfs.i.deleteFile(t.Hh(this.fileName) + ".tmp");
    }
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
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126834);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(126833);
    paramq = (aff)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    if ((paramq.xbt <= 0L) || (paramq.xcL < 0) || (paramq.xcK <= 0) || (paramq.xcK <= paramq.xcL))
    {
      ad.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.isk.dAY + "," + this.isk.aMS() + "," + this.isk.getUser() + "] ");
      u.Hp(this.fileName);
      paramq = n.b.hOq;
      AppMethodBeat.o(126833);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(126833);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 211L, 1L, false);
    u.Hp(this.fileName);
    AppMethodBeat.o(126835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */