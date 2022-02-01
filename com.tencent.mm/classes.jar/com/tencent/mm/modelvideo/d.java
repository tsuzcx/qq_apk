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
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ak.g callback;
  String fileName;
  String hIq;
  String hIw;
  int hIx;
  private g.a hIz;
  boolean hYM;
  boolean hYN;
  s hYO;
  com.tencent.mm.i.h hYP;
  int hYQ;
  private boolean hYR;
  boolean hYS;
  long hYT;
  private au htR;
  int hux;
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
    this.hYO = null;
    this.hIq = "";
    this.startOffset = 0;
    this.startTime = 0L;
    this.hux = 0;
    this.retCode = 0;
    this.hYQ = com.tencent.mm.i.a.MediaType_VIDEO;
    this.hYR = false;
    this.hYS = true;
    this.hIw = null;
    this.hIx = 0;
    this.hYT = 0L;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126824);
        if (paramAnonymousInt == -21006)
        {
          ac.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { d.this.aJp(), d.this.hIq });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.Ea(d.this.fileName);
          paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(d.this.hYQ), Integer.valueOf(d.this.hux), "" });
          new com.tencent.mm.g.b.a.h(paramAnonymousString).aHZ();
          new com.tencent.mm.g.b.a.f(paramAnonymousString).aHZ();
          d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
          AppMethodBeat.o(126824);
          return 0;
        }
        d.this.hYO = u.Ej(d.this.fileName);
        if ((d.this.hYO == null) || (d.this.hYO.status == 113))
        {
          if (d.this.hYO == null) {}
          for (int i = -1;; i = d.this.hYO.status)
          {
            ac.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { d.this.aJp(), Integer.valueOf(i) });
            d.this.Fb();
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == d.this.hux)
          {
            ac.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            AppMethodBeat.o(126824);
            return 0;
          }
          if ((d.this.hYO.iaE > paramAnonymousc.field_finishedLength) && (!d.this.hYM))
          {
            ac.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { d.this.aJp(), Integer.valueOf(d.this.hYO.iaE), Long.valueOf(paramAnonymousc.field_finishedLength) });
            u.Ea(d.this.fileName);
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
          paramAnonymousInt = 1024;
          d.this.hYO.iaH = bs.aNx();
          if (d.this.hYO.iaE < paramAnonymousc.field_finishedLength)
          {
            d.this.hYO.iaE = ((int)paramAnonymousc.field_finishedLength);
            paramAnonymousInt = 1040;
          }
          d.this.hYO.drx = paramAnonymousInt;
          u.f(d.this.hYO);
          ac.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { d.this.aJp(), d.this.hIq, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ac.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { d.this.aJp(), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(bs.eWj() - d.this.hYT) });
          paramAnonymousString = d.this;
          paramAnonymousc = d.this.hYP;
          if ((paramAnonymousc != null) && (paramAnonymousd != null)) {
            break label1155;
          }
          ac.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
          if (paramAnonymousd.field_retCode == 0) {
            break label1249;
          }
          u.Ea(d.this.fileName);
          if (d.this.hYM) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 13L, 1L, false);
          }
          if (d.this.hYN) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 252L, 1L, false);
          }
          d.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", d.this);
        }
        for (;;)
        {
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(d.this.hYQ), Integer.valueOf(d.this.hux), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          if (paramAnonymousd.field_retCode != 0) {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(d.this.hYQ), Integer.valueOf(d.this.hux), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
          }
          a.a(d.this.hYO, 1);
          d.this.hYP = null;
          AppMethodBeat.o(126824);
          return 0;
          label1155:
          if (paramAnonymousc.field_smallVideoFlag == 1)
          {
            ac.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
            break;
          }
          if ((paramAnonymousc == null) || (paramAnonymousd == null)) {
            break;
          }
          ac.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[] { paramAnonymousString.aJp(), Long.valueOf(paramAnonymousd.field_recvedBytes), Long.valueOf(paramAnonymousd.field_startTime), Long.valueOf(paramAnonymousd.field_endTime) });
          o.aJz();
          com.tencent.mm.an.e.a(null, paramAnonymousd, paramAnonymousc, true);
          break;
          label1249:
          if (d.this.hYM) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 12L, 1L, false);
          }
          if (d.this.hYN) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 137L, 1L, false);
          }
          d.this.pI((int)paramAnonymousd.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.htR = new au(new au.a()
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
      this.hYM = paramBoolean;
      ac.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { aJp(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(126829);
      return;
    }
  }
  
  private boolean aJo()
  {
    AppMethodBeat.i(126830);
    ac.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { aJp(), this.hYO.aJK() });
    Object localObject4 = bv.L(this.hYO.aJK(), "msg");
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 214L, 1L, false);
      ac.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aJp() });
      AppMethodBeat.o(126830);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 213L, 1L, false);
      ac.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { aJp() });
      AppMethodBeat.o(126830);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.hux = bs.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.hIq = com.tencent.mm.an.c.a("downvideo", this.hYO.createTime, this.hYO.getUser(), this.hYO.getFileName());
    if (bs.isNullOrNil(this.hIq))
    {
      ac.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { aJp(), this.hYO.getFileName() });
      AppMethodBeat.o(126830);
      return false;
    }
    if ((!this.hYM) && (this.hux < 1048576) && (this.hYO != null) && (this.hYO.dnl > 0))
    {
      this.hYM = true;
      ac.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { aJp(), Boolean.valueOf(this.hYM) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.aJy();
    localObject3 = t.DV(this.fileName) + ".tmp";
    this.hYP = new com.tencent.mm.i.h();
    this.hYP.filename = this.hYO.getFileName();
    this.hYP.fru = ((String)localObject2);
    this.hYP.frv = this.hux;
    this.hYP.frw = 0;
    this.hYP.dng = this.hYO.aJH();
    this.hYP.frx = this.hYO.getUser();
    com.tencent.mm.i.h localh = this.hYP;
    int i;
    label640:
    label805:
    label842:
    int k;
    if (w.sQ(this.hYO.getUser()))
    {
      i = com.tencent.mm.model.q.wb(this.hYO.getUser());
      localh.dni = i;
      this.hYP.field_mediaId = this.hIq;
      this.hYP.field_fullpath = ((String)localObject3);
      this.hYP.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      this.hYP.field_totalLen = this.hux;
      this.hYP.field_aesKey = ((String)localObject5);
      this.hYP.field_fileId = str1;
      this.hYP.field_priority = com.tencent.mm.i.a.fqp;
      this.hYP.frb = this.hIz;
      this.hYP.field_wxmsgparam = str2;
      localObject5 = this.hYP;
      if (!w.sQ(this.hYO.getUser())) {
        break label1665;
      }
      i = 1;
      ((com.tencent.mm.i.h)localObject5).field_chattype = i;
      this.hYP.fry = this.hYO.fry;
      if (!bs.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.hYP.field_fileId = "";
        this.hYP.field_fileType = 19;
        this.hYP.field_authKey = ((String)localObject4);
        this.hYP.fre = ((String)localObject1);
      }
      localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(this.hYO.getUser(), this.hYO.dpl);
      this.hYP.frA = ((dy)localObject4).field_createTime;
      this.hYP.dpl = ((dy)localObject4).field_msgSvrId;
      localObject1 = bi.yr(((dy)localObject4).eul);
      localObject5 = this.hYP;
      if (localObject1 == null) {
        break label1670;
      }
      i = ((bi.b)localObject1).hoM;
      ((com.tencent.mm.i.h)localObject5).frB = i;
      if (this.hYO.getUser().equals(((dy)localObject4).field_talker))
      {
        localObject5 = this.hYP;
        if (localObject1 != null) {
          break label1675;
        }
        i = 0;
        ((com.tencent.mm.i.h)localObject5).field_limitrate = i;
      }
      ac.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { aJp(), Integer.valueOf(this.hYP.field_limitrate), this.hYO.getFileName() });
      if (!com.tencent.mm.an.f.aDD().hBp.contains("video_" + this.hYO.iaJ)) {
        break label1687;
      }
      com.tencent.mm.an.f.aDD().hBp.remove("video_" + this.hYO.iaJ);
      this.hYP.field_autostart = true;
      label966:
      if (3 == this.hYO.iaP) {
        this.hYP.field_smallVideoFlag = 1;
      }
      if ((bs.isNullOrNil((String)localObject2)) || (this.hYM)) {
        break label1718;
      }
      localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI().fT((String)localObject2, this.hux);
      j = (int)i.aSp((String)localObject1);
      k = this.hux - j;
      o.aJy();
      localObject5 = t.DV(this.fileName);
      int m = (int)i.aSp((String)localObject5);
      if (m > 0)
      {
        ac.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { aJp() });
        bool = i.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI();
        int n = this.hux;
        i = 0;
        if (!bs.isNullOrNil((String)localObject2)) {
          i = ((bn)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = u.Ej(this.fileName);
        ((s)localObject1).iaE = 0;
        ((s)localObject1).drx = 16;
        u.f((s)localObject1);
        ac.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { aJp(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      ac.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { aJp(), Integer.valueOf(this.hux), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (bs.isNullOrNil((String)localObject1)) {
        break label1704;
      }
      if ((k < 0) || (k > 16)) {
        break label1718;
      }
      ac.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { aJp(), localObject1, localObject3 });
      i.lZ((String)localObject1, (String)localObject3);
      pI(this.hux);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(new h.c(((dy)localObject4).field_talker, "update", (bo)localObject4));
      localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
      long l1 = this.hYO.dpl;
      long l2 = this.hYO.createTime;
      localObject3 = this.hYO.getUser();
      if (3 == this.hYO.iaP) {
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
      this.mediaId = this.hYP.field_mediaId;
      this.hYT = bs.eWj();
      if (this.hYO.videoFormat != 2) {
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
      this.hYN = bool;
      ac.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { aJp(), Boolean.valueOf(this.hYN), Boolean.valueOf(this.hYM) });
      if (this.hYM) {
        break label1968;
      }
      if (com.tencent.mm.an.f.aDD().b(this.hYP, -1)) {
        break label1729;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 212L, 1L, false);
      ac.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { aJp() });
      this.hIq = "";
      AppMethodBeat.o(126830);
      return false;
      i = 0;
      break;
      i = 0;
      break label640;
      i = 0;
      break label805;
      i = ((bi.b)localObject1).hoK / 8;
      break label842;
      this.hYP.field_autostart = false;
      break label966;
      i = 62;
      break label1451;
      this.hIw = ((String)localObject2);
      this.hIx = this.hux;
      i = 0;
      break label1512;
    }
    label1729:
    if (this.hYN) {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 135L, 1L, false);
    }
    label1750:
    if (this.hYO.iaN != 1)
    {
      this.hYO.iaN = 1;
      this.hYO.drx = 524288;
      u.f(this.hYO);
    }
    if (3 != this.hYO.iaP)
    {
      localObject1 = this.hYO.getUser();
      if (!bs.isNullOrNil((String)localObject1)) {
        if (!w.sQ((String)localObject1)) {
          break label2141;
        }
      }
    }
    label1968:
    label2141:
    for (int j = com.tencent.mm.model.q.wb((String)localObject1);; j = 0) {
      for (;;)
      {
        try
        {
          localObject2 = ((ConnectivityManager)ai.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          i = ((NetworkInfo)localObject2).getSubtype();
          k = ((NetworkInfo)localObject2).getType();
          if (k != 1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", new Object[] { bs.m(localException) });
          i = 0;
          continue;
        }
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.hux + "," + i;
        ac.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { aJp(), localObject1 });
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(126830);
        return true;
        this.hYS = false;
        localObject1 = this.hYP;
        o.aJy();
        ((com.tencent.mm.i.h)localObject1).field_fullpath = t.DV(this.fileName);
        if (this.hYN)
        {
          this.hYP.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 251L, 1L, false);
        }
        o.aJz().a(this.hYP, false);
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
  
  final boolean Fb()
  {
    boolean bool = false;
    AppMethodBeat.i(126828);
    if (!bs.isNullOrNil(this.mediaId))
    {
      if (!this.hYM) {
        break label71;
      }
      ac.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { aJp() });
      o.aJz().k(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.hYR = true;
      AppMethodBeat.o(126828);
      return bool;
      label71:
      ac.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { aJp() });
      com.tencent.mm.an.f.aDD().BR(this.mediaId);
    }
  }
  
  final String aJp()
  {
    AppMethodBeat.i(126837);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126837);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126827);
    Fb();
    super.cancel();
    AppMethodBeat.o(126827);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    int i = 1;
    AppMethodBeat.i(126832);
    this.callback = paramg;
    this.hYO = u.Ej(this.fileName);
    if (this.hYO == null)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.hYO != null) && (3 == this.hYO.iaP)) {
      this.hYQ = com.tencent.mm.i.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bs.eWj();
      this.startOffset = this.hYO.iaE;
    }
    if (aJo())
    {
      ac.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126832);
      return 0;
    }
    if (this.hYO.status != 112)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.hYO.status + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    ac.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "]  filesize:" + this.hYO.iaE + " file:" + this.hYO.hux + " netTimes:" + this.hYO.iaK);
    if (!u.DZ(this.fileName))
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.hYO.iaK + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if (this.hYO.dpl <= 0L)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.hYO.dpl + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.hYO.iaE < 0) || (this.hYO.hux <= this.hYO.iaE) || (this.hYO.hux <= 0))
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.hYO.iaE + " total:" + this.hYO.hux + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    paramg = new b.a();
    paramg.hvt = new ade();
    paramg.hvu = new adf();
    paramg.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    paramg.funcId = 150;
    paramg.reqCmdId = 40;
    paramg.respCmdId = 1000000040;
    this.rr = paramg.aAz();
    paramg = (ade)this.rr.hvr.hvw;
    paramg.vTQ = this.hYO.dpl;
    paramg.vTI = this.hYO.iaE;
    paramg.vTH = this.hYO.hux;
    if (ae.cS(ai.getContext())) {}
    for (;;)
    {
      paramg.EvT = i;
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
    if (this.hYR)
    {
      ac.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      ac.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      AppMethodBeat.o(126836);
      return;
    }
    paramArrayOfByte = (adf)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    paramq = (ade)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    this.hYO = u.Ej(this.fileName);
    if (this.hYO == null)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.hYO.status == 113)
    {
      ac.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.hYO.status != 112)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hYO.status + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 208L, 1L, false);
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.hYQ), Integer.valueOf(this.hux - this.startOffset) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 207L, 1L, false);
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      this.hYO.status = 113;
      u.f(this.hYO);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (bs.cv(paramArrayOfByte.vTK.getBuffer().xy))
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.vTI != paramq.vTI)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.vTI + " reqStartPos:" + paramq.vTI + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.vTH != paramq.vTH)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.vTH + " reqTotal:" + paramq.vTH + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramq.vTH < paramArrayOfByte.vTI)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.vTH + " respStartPos:" + paramq.vTI + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.vTQ != paramq.vTQ)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.vTQ + " reqMsgId:" + paramq.vTQ + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    ac.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.vTK.getILen() + " reqStartPos:" + paramq.vTI + " totallen:" + paramq.vTH + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
    o.aJy();
    int j = t.a(t.DV(this.fileName), paramq.vTI, paramArrayOfByte.vTK.getBuffer().toByteArray());
    if (j < 0)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (j > this.hYO.hux)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.hYO.hux + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    paramq = this.fileName;
    paramArrayOfByte = u.Ej(paramq);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.YG() + " getinfo failed: " + paramq);
      paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
    }
    while (paramInt1 < 0)
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
      paramArrayOfByte.iaE = j;
      paramArrayOfByte.iaH = bs.aNx();
      paramArrayOfByte.drx = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.hux > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.hux)
        {
          u.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.drx |= 0x100;
          ac.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.hux + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.iaK);
          paramInt1 = 1;
        }
      }
      ac.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.f.YG() + " file:" + paramq + " newsize:" + j + " total:" + paramArrayOfByte.hux + " status:" + paramArrayOfByte.status);
      if (!u.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(ai.getContext())), Integer.valueOf(this.hYQ), Integer.valueOf(this.hux - this.startOffset) });
      a.a(this.hYO, 1);
      ac.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.hYR)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    this.htR.au(0L, 0L);
    AppMethodBeat.o(126836);
  }
  
  final void pI(final int paramInt)
  {
    AppMethodBeat.i(126831);
    Object localObject;
    if (this.hYS)
    {
      localObject = new StringBuilder();
      o.aJy();
      localObject = new com.tencent.mm.vfs.e(t.DV(this.fileName) + ".tmp");
      o.aJy();
    }
    for (final boolean bool = ((com.tencent.mm.vfs.e)localObject).ae(new com.tencent.mm.vfs.e(t.DV(this.fileName)));; bool = true)
    {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126825);
          Object localObject1 = bv.L(d.this.hYO.aJK(), "msg");
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = o.aJy();
            o.aJy();
            ((t)localObject2).r(t.DV(d.this.fileName), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          }
          boolean bool1 = false;
          if (bool)
          {
            boolean bool2 = u.ar(d.this.fileName, paramInt);
            bool1 = bool2;
            if (d.this.hYN)
            {
              u.Ep(d.this.fileName);
              ac.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
              bool1 = bool2;
            }
            ac.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { d.this.aJp(), d.this.fileName, Long.valueOf(d.this.hYO.dpl), d.this.hYO.aJH(), d.this.hYO.getUser(), Boolean.valueOf(bool1), d.this.hIw, Integer.valueOf(d.this.hIx), Boolean.valueOf(bool), Boolean.valueOf(d.this.hYS) });
            if ((!bs.isNullOrNil(d.this.hIw)) && (d.this.hIx > 0))
            {
              localObject1 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI();
              localObject2 = d.this.hIw;
              int i = d.this.hIx;
              o.aJy();
              ((bn)localObject1).D((String)localObject2, i, t.DV(d.this.fileName));
            }
            if (d.this.hYO.iaP != 3) {
              break label545;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 38L, d.this.hYO.hux, false);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 40L, d.this.hYO.hpy, false);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 41L, 1L, false);
            localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
            if (!w.sQ(d.this.hYO.getUser())) {
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
            if (d.this.hYN)
            {
              u.Ea(d.this.fileName);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 138L, 1L, false);
              break;
            }
            bool1 = u.ar(d.this.fileName, paramInt);
            break;
          }
          label545:
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 31L, d.this.hYO.hux, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 33L, d.this.hYO.hpy, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 34L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
          if (w.sQ(d.this.hYO.getUser())) {}
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
      o.aJy();
      i.deleteFile(t.DV(this.fileName) + ".tmp");
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
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126834);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(126833);
    paramq = (ade)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    if ((paramq.vTQ <= 0L) || (paramq.vTI < 0) || (paramq.vTH <= 0) || (paramq.vTH <= paramq.vTI))
    {
      ac.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.hYO.dpl + "," + this.hYO.aJH() + "," + this.hYO.getUser() + "] ");
      u.Ea(this.fileName);
      paramq = n.b.hwb;
      AppMethodBeat.o(126833);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(126833);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 211L, 1L, false);
    u.Ea(this.fileName);
    AppMethodBeat.o(126835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */