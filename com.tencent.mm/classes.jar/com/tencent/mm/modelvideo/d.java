package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ak.f callback;
  String fileName;
  int hPI;
  private aw hPc;
  String idX;
  String ied;
  int iee;
  private g.a ieg;
  boolean ivc;
  boolean ivd;
  s ive;
  com.tencent.mm.i.h ivf;
  int ivg;
  private boolean ivh;
  boolean ivi;
  long ivj;
  private String mediaId;
  int retCode;
  private com.tencent.mm.ak.b rr;
  private int startOffset;
  long startTime;
  
  public d(String paramString)
  {
    this(paramString, false);
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126829);
    this.ive = null;
    this.idX = "";
    this.startOffset = 0;
    this.startTime = 0L;
    this.hPI = 0;
    this.retCode = 0;
    this.ivg = com.tencent.mm.i.a.MediaType_VIDEO;
    this.ivh = false;
    this.ivi = true;
    this.ied = null;
    this.iee = 0;
    this.ivj = 0L;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126824);
        if (paramAnonymousInt == -21006)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { d.this.aMX(), d.this.idX });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.HR(d.this.fileName);
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(d.this.ivg), Integer.valueOf(d.this.hPI), "" });
          new j(paramAnonymousString).aLH();
          new com.tencent.mm.g.b.a.h(paramAnonymousString).aLH();
          d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
          AppMethodBeat.o(126824);
          return 0;
        }
        d.this.ive = u.Ia(d.this.fileName);
        if ((d.this.ive == null) || (d.this.ive.status == 113))
        {
          if (d.this.ive == null) {}
          for (int i = -1;; i = d.this.ive.status)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { d.this.aMX(), Integer.valueOf(i) });
            d.this.GB();
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == d.this.hPI)
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            AppMethodBeat.o(126824);
            return 0;
          }
          if ((d.this.ive.iwU > paramAnonymousc.field_finishedLength) && (!d.this.ivc))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { d.this.aMX(), Integer.valueOf(d.this.ive.iwU), Long.valueOf(paramAnonymousc.field_finishedLength) });
            u.HR(d.this.fileName);
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
          paramAnonymousInt = 1024;
          d.this.ive.iwX = com.tencent.mm.sdk.platformtools.bu.aRi();
          if (d.this.ive.iwU < paramAnonymousc.field_finishedLength)
          {
            d.this.ive.iwU = ((int)paramAnonymousc.field_finishedLength);
            paramAnonymousInt = 1040;
          }
          d.this.ive.dEu = paramAnonymousInt;
          u.f(d.this.ive);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { d.this.aMX(), d.this.idX, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { d.this.aMX(), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO() - d.this.ivj) });
          paramAnonymousString = d.this;
          paramAnonymousc = d.this.ivf;
          if ((paramAnonymousc != null) && (paramAnonymousd != null)) {
            break label1155;
          }
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
          if (paramAnonymousd.field_retCode == 0) {
            break label1249;
          }
          u.HR(d.this.fileName);
          if (d.this.ivc) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 13L, 1L, false);
          }
          if (d.this.ivd) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 252L, 1L, false);
          }
          d.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", d.this);
        }
        for (;;)
        {
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(d.this.ivg), Integer.valueOf(d.this.hPI), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(d.this.ivg), Integer.valueOf(d.this.hPI), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
          }
          a.a(d.this.ive, 1);
          d.this.ivf = null;
          AppMethodBeat.o(126824);
          return 0;
          label1155:
          if (paramAnonymousc.field_smallVideoFlag == 1)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
            break;
          }
          if ((paramAnonymousc == null) || (paramAnonymousd == null)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[] { paramAnonymousString.aMX(), Long.valueOf(paramAnonymousd.field_recvedBytes), Long.valueOf(paramAnonymousd.field_startTime), Long.valueOf(paramAnonymousd.field_endTime) });
          o.aNi();
          com.tencent.mm.an.e.a(null, paramAnonymousd, paramAnonymousc, true);
          break;
          label1249:
          if (d.this.ivc) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 12L, 1L, false);
          }
          if (d.this.ivd) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 137L, 1L, false);
          }
          d.this.qn((int)paramAnonymousd.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.hPc = new aw(new aw.a()
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
      this.ivc = paramBoolean;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { aMX(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(126829);
      return;
    }
  }
  
  private boolean aMW()
  {
    AppMethodBeat.i(126830);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { aMX(), this.ive.aNt() });
    Object localObject4 = bx.M(this.ive.aNt(), "msg");
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 214L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aMX() });
      AppMethodBeat.o(126830);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str1)) && (com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 213L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aMX() });
      AppMethodBeat.o(126830);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.hPI = com.tencent.mm.sdk.platformtools.bu.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.idX = com.tencent.mm.an.c.a("downvideo", this.ive.createTime, this.ive.getUser(), this.ive.getFileName());
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.idX))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { aMX(), this.ive.getFileName() });
      AppMethodBeat.o(126830);
      return false;
    }
    if ((!this.ivc) && (this.hPI < 1048576) && (this.ive != null) && (this.ive.dAe > 0))
    {
      this.ivc = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { aMX(), Boolean.valueOf(this.ivc) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.aNh();
    localObject3 = t.HJ(this.fileName) + ".tmp";
    this.ivf = new com.tencent.mm.i.h();
    this.ivf.fLl = "task_NetSceneDownloadVideo";
    this.ivf.filename = this.ive.getFileName();
    this.ivf.fLG = ((String)localObject2);
    this.ivf.fLH = this.hPI;
    this.ivf.fLI = 0;
    this.ivf.dzZ = this.ive.aNq();
    this.ivf.fLJ = this.ive.getUser();
    com.tencent.mm.i.h localh = this.ivf;
    int i;
    label650:
    label815:
    label852:
    int k;
    if (x.wb(this.ive.getUser()))
    {
      i = r.zC(this.ive.getUser());
      localh.dAb = i;
      this.ivf.field_mediaId = this.idX;
      this.ivf.field_fullpath = ((String)localObject3);
      this.ivf.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      this.ivf.field_totalLen = this.hPI;
      this.ivf.field_aesKey = ((String)localObject5);
      this.ivf.field_fileId = str1;
      this.ivf.field_priority = com.tencent.mm.i.a.fKA;
      this.ivf.fLm = this.ieg;
      this.ivf.field_wxmsgparam = str2;
      localObject5 = this.ivf;
      if (!x.wb(this.ive.getUser())) {
        break label1675;
      }
      i = 1;
      ((com.tencent.mm.i.h)localObject5).field_chattype = i;
      this.ivf.fLK = this.ive.fLK;
      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.ivf.field_fileId = "";
        this.ivf.field_fileType = 19;
        this.ivf.field_authKey = ((String)localObject4);
        this.ivf.fLp = ((String)localObject1);
      }
      localObject4 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(this.ive.getUser(), this.ive.dCd);
      this.ivf.fLM = ((ei)localObject4).field_createTime;
      this.ivf.dCd = ((ei)localObject4).field_msgSvrId;
      localObject1 = bl.BS(((ei)localObject4).eNd);
      localObject5 = this.ivf;
      if (localObject1 == null) {
        break label1680;
      }
      i = ((bl.b)localObject1).hJW;
      ((com.tencent.mm.i.h)localObject5).fLN = i;
      if (this.ive.getUser().equals(((ei)localObject4).field_talker))
      {
        localObject5 = this.ivf;
        if (localObject1 != null) {
          break label1685;
        }
        i = 0;
        ((com.tencent.mm.i.h)localObject5).field_limitrate = i;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { aMX(), Integer.valueOf(this.ivf.field_limitrate), this.ive.getFileName() });
      if (!com.tencent.mm.an.f.aGZ().hWG.contains("video_" + this.ive.iwZ)) {
        break label1697;
      }
      com.tencent.mm.an.f.aGZ().hWG.remove("video_" + this.ive.iwZ);
      this.ivf.field_autostart = true;
      label976:
      if (3 == this.ive.ixf) {
        this.ivf.field_smallVideoFlag = 1;
      }
      if ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject2)) || (this.ivc)) {
        break label1728;
      }
      localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN().gz((String)localObject2, this.hPI);
      j = (int)com.tencent.mm.vfs.o.aZR((String)localObject1);
      k = this.hPI - j;
      o.aNh();
      localObject5 = t.HJ(this.fileName);
      int m = (int)com.tencent.mm.vfs.o.aZR((String)localObject5);
      if (m > 0)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { aMX() });
        bool = com.tencent.mm.vfs.o.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN();
        int n = this.hPI;
        i = 0;
        if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject2)) {
          i = ((com.tencent.mm.storage.bu)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = u.Ia(this.fileName);
        ((s)localObject1).iwU = 0;
        ((s)localObject1).dEu = 16;
        u.f((s)localObject1);
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { aMX(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { aMX(), Integer.valueOf(this.hPI), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject1)) {
        break label1714;
      }
      if ((k < 0) || (k > 16)) {
        break label1728;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { aMX(), localObject1, localObject3 });
      com.tencent.mm.vfs.o.mF((String)localObject1, (String)localObject3);
      qn(this.hPI);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(((ei)localObject4).field_talker, "update", (bv)localObject4));
      localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
      long l1 = this.ive.dCd;
      long l2 = this.ive.createTime;
      localObject3 = this.ive.getUser();
      if (3 == this.ive.ixf) {
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
      this.mediaId = this.ivf.field_mediaId;
      this.ivj = com.tencent.mm.sdk.platformtools.bu.fpO();
      if (this.ive.videoFormat != 2) {
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
      this.ivd = bool;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { aMX(), Boolean.valueOf(this.ivd), Boolean.valueOf(this.ivc) });
      if (this.ivc) {
        break label1978;
      }
      if (com.tencent.mm.an.f.aGZ().b(this.ivf, -1)) {
        break label1739;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 212L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { aMX() });
      this.idX = "";
      AppMethodBeat.o(126830);
      return false;
      i = 0;
      break;
      i = 0;
      break label650;
      i = 0;
      break label815;
      i = ((bl.b)localObject1).hJU / 8;
      break label852;
      this.ivf.field_autostart = false;
      break label976;
      i = 62;
      break label1461;
      this.ied = ((String)localObject2);
      this.iee = this.hPI;
      i = 0;
      break label1522;
    }
    label1739:
    if (this.ivd) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 135L, 1L, false);
    }
    label1760:
    if (this.ive.ixd != 1)
    {
      this.ive.ixd = 1;
      this.ive.dEu = 524288;
      u.f(this.ive);
    }
    if (3 != this.ive.ixf)
    {
      localObject1 = this.ive.getUser();
      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject1)) {
        if (!x.wb((String)localObject1)) {
          break label2151;
        }
      }
    }
    label1978:
    label2151:
    for (int j = r.zC((String)localObject1);; j = 0) {
      for (;;)
      {
        try
        {
          localObject2 = ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          i = ((NetworkInfo)localObject2).getSubtype();
          k = ((NetworkInfo)localObject2).getType();
          if (k != 1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { com.tencent.mm.sdk.platformtools.bu.o(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.hPI + "," + i;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { aMX(), localObject1 });
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(126830);
        return true;
        this.ivi = false;
        localObject1 = this.ivf;
        o.aNh();
        ((com.tencent.mm.i.h)localObject1).field_fullpath = t.HJ(this.fileName);
        if (this.ivd)
        {
          this.ivf.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 251L, 1L, false);
        }
        o.aNi().a(this.ivf, false);
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
  
  final boolean GB()
  {
    boolean bool = false;
    AppMethodBeat.i(126828);
    if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.mediaId))
    {
      if (!this.ivc) {
        break label71;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { aMX() });
      o.aNi().m(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.ivh = true;
      AppMethodBeat.o(126828);
      return bool;
      label71:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { aMX() });
      com.tencent.mm.an.f.aGZ().Fs(this.mediaId);
    }
  }
  
  final String aMX()
  {
    AppMethodBeat.i(126837);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126837);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126827);
    GB();
    super.cancel();
    AppMethodBeat.o(126827);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    int i = 1;
    AppMethodBeat.i(126832);
    this.callback = paramf;
    this.ive = u.Ia(this.fileName);
    if (this.ive == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.ive != null) && (3 == this.ive.ixf)) {
      this.ivg = com.tencent.mm.i.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = com.tencent.mm.sdk.platformtools.bu.fpO();
      this.startOffset = this.ive.iwU;
    }
    if (aMW())
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126832);
      return 0;
    }
    if (this.ive.status != 112)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.ive.status + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "]  filesize:" + this.ive.iwU + " file:" + this.ive.hPI + " netTimes:" + this.ive.ixa);
    if (!u.HQ(this.fileName))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.ive.ixa + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if (this.ive.dCd <= 0L)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.ive.dCd + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.ive.iwU < 0) || (this.ive.hPI <= this.ive.iwU) || (this.ive.hPI <= 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.ive.iwU + " total:" + this.ive.hPI + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    paramf = new b.a();
    paramf.hQF = new afo();
    paramf.hQG = new afp();
    paramf.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    paramf.funcId = 150;
    paramf.hQH = 40;
    paramf.respCmdId = 1000000040;
    this.rr = paramf.aDS();
    paramf = (afo)this.rr.hQD.hQJ;
    paramf.xrk = this.ive.dCd;
    paramf.xsC = this.ive.iwU;
    paramf.xsB = this.ive.hPI;
    if (com.tencent.mm.network.ae.cR(ak.getContext())) {}
    for (;;)
    {
      paramf.GvW = i;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126836);
    if (this.ivh)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(this.idX)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      AppMethodBeat.o(126836);
      return;
    }
    paramArrayOfByte = (afp)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    paramq = (afo)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    this.ive = u.Ia(this.fileName);
    if (this.ive == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.ive.status == 113)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.ive.status != 112)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.ive.status + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 208L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.ivg), Integer.valueOf(this.hPI - this.startOffset) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 207L, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      this.ive.status = 113;
      u.f(this.ive);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.bu.cF(paramArrayOfByte.xsE.getBuffer().zr))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.xsC != paramq.xsC)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.xsC + " reqStartPos:" + paramq.xsC + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.xsB != paramq.xsB)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.xsB + " reqTotal:" + paramq.xsB + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramq.xsB < paramArrayOfByte.xsC)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.xsB + " respStartPos:" + paramq.xsC + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.xrk != paramq.xrk)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.xrk + " reqMsgId:" + paramq.xrk + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.xsE.getILen() + " reqStartPos:" + paramq.xsC + " totallen:" + paramq.xsB + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
    o.aNh();
    int j = t.a(t.HJ(this.fileName), paramq.xsC, paramArrayOfByte.xsE.getBuffer().toByteArray());
    if (j < 0)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (j > this.ive.hPI)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.ive.hPI + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    paramq = this.fileName;
    paramArrayOfByte = u.Ia(paramq);
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.abr() + " getinfo failed: " + paramq);
      paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
    }
    while (paramInt1 < 0)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
      paramArrayOfByte.iwU = j;
      paramArrayOfByte.iwX = com.tencent.mm.sdk.platformtools.bu.aRi();
      paramArrayOfByte.dEu = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.hPI > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.hPI)
        {
          u.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.dEu |= 0x100;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.hPI + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.ixa);
          paramInt1 = 1;
        }
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.f.abr() + " file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.hPI + " status:" + paramArrayOfByte.status);
      if (!u.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(this.ivg), Integer.valueOf(this.hPI - this.startOffset) });
      a.a(this.ive, 1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.ivh)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    this.hPc.ay(0L, 0L);
    AppMethodBeat.o(126836);
  }
  
  final void qn(final int paramInt)
  {
    AppMethodBeat.i(126831);
    Object localObject;
    if (this.ivi)
    {
      localObject = new StringBuilder();
      o.aNh();
      localObject = new com.tencent.mm.vfs.k(t.HJ(this.fileName) + ".tmp");
      o.aNh();
    }
    for (final boolean bool = ((com.tencent.mm.vfs.k)localObject).ag(new com.tencent.mm.vfs.k(t.HJ(this.fileName)));; bool = true)
    {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126825);
          Object localObject1 = bx.M(d.this.ive.aNt(), "msg");
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = o.aNh();
            o.aNh();
            ((t)localObject2).q(t.HJ(d.this.fileName), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          }
          boolean bool1 = false;
          if (bool)
          {
            boolean bool2 = u.au(d.this.fileName, paramInt);
            bool1 = bool2;
            if (d.this.ivd)
            {
              u.Ig(d.this.fileName);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
              bool1 = bool2;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { d.this.aMX(), d.this.fileName, Long.valueOf(d.this.ive.dCd), d.this.ive.aNq(), d.this.ive.getUser(), Boolean.valueOf(bool1), d.this.ied, Integer.valueOf(d.this.iee), Boolean.valueOf(bool), Boolean.valueOf(d.this.ivi) });
            if ((!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(d.this.ied)) && (d.this.iee > 0))
            {
              localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN();
              localObject2 = d.this.ied;
              int i = d.this.iee;
              o.aNh();
              ((com.tencent.mm.storage.bu)localObject1).G((String)localObject2, i, t.HJ(d.this.fileName));
            }
            if (d.this.ive.ixf != 3) {
              break label545;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 38L, d.this.ive.hPI, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 40L, d.this.ive.hKI, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 41L, 1L, false);
            localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
            if (!x.wb(d.this.ive.getUser())) {
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
            if (d.this.ivd)
            {
              u.HR(d.this.fileName);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 138L, 1L, false);
              break;
            }
            bool1 = u.au(d.this.fileName, paramInt);
            break;
          }
          label545:
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 31L, d.this.ive.hPI, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 33L, d.this.ive.hKI, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 34L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
          if (x.wb(d.this.ive.getUser())) {}
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
      o.aNh();
      com.tencent.mm.vfs.o.deleteFile(t.HJ(this.fileName) + ".tmp");
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
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126834);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(126833);
    paramq = (afo)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    if ((paramq.xrk <= 0L) || (paramq.xsC < 0) || (paramq.xsB <= 0) || (paramq.xsB <= paramq.xsC))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.ive.dCd + "," + this.ive.aNq() + "," + this.ive.getUser() + "] ");
      u.HR(this.fileName);
      paramq = n.b.hRj;
      AppMethodBeat.o(126833);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(126833);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 211L, 1L, false);
    u.HR(this.fileName);
    AppMethodBeat.o(126835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */