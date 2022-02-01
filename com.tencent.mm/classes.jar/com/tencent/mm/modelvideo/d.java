package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.an.e;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.v;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahw;
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
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class d
  extends q
  implements m
{
  com.tencent.mm.ak.i callback;
  String fileName;
  int iKP;
  private MTimerHandler iKj;
  String iYT;
  String iYZ;
  int iZa;
  private g.a iZc;
  boolean jqo;
  boolean jqp;
  s jqq;
  com.tencent.mm.i.h jqr;
  int jqs;
  private boolean jqt;
  boolean jqu;
  long jqv;
  private String mediaId;
  int retCode;
  private com.tencent.mm.ak.d rr;
  private int startOffset;
  long startTime;
  
  public d(String paramString)
  {
    this(paramString, false);
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126829);
    this.jqq = null;
    this.iYT = "";
    this.startOffset = 0;
    this.startTime = 0L;
    this.iKP = 0;
    this.retCode = 0;
    this.jqs = com.tencent.mm.i.a.MediaType_VIDEO;
    this.jqt = false;
    this.jqu = true;
    this.iYZ = null;
    this.iZa = 0;
    this.jqv = 0L;
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126824);
        if (paramAnonymousInt == -21006)
        {
          Log.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { d.this.bgZ(), d.this.iYT });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          u.QE(d.this.fileName);
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.this.jqs), Integer.valueOf(d.this.iKP), "" });
          new y(paramAnonymousString).bfK();
          new w(paramAnonymousString).bfK();
          d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
          AppMethodBeat.o(126824);
          return 0;
        }
        d.this.jqq = u.QN(d.this.fileName);
        if ((d.this.jqq == null) || (d.this.jqq.status == 113))
        {
          if (d.this.jqq == null) {}
          for (int i = -1;; i = d.this.jqq.status)
          {
            Log.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { d.this.bgZ(), Integer.valueOf(i) });
            d.this.Qt();
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == d.this.iKP)
          {
            Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            AppMethodBeat.o(126824);
            return 0;
          }
          if ((d.this.jqq.jsj > paramAnonymousc.field_finishedLength) && (!d.this.jqo))
          {
            Log.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { d.this.bgZ(), Integer.valueOf(d.this.jqq.jsj), Long.valueOf(paramAnonymousc.field_finishedLength) });
            u.QE(d.this.fileName);
            d.this.callback.onSceneEnd(3, paramAnonymousInt, "", d.this);
            AppMethodBeat.o(126824);
            return 0;
          }
          paramAnonymousInt = 1024;
          d.this.jqq.jsm = Util.nowSecond();
          if (d.this.jqq.jsj < paramAnonymousc.field_finishedLength)
          {
            d.this.jqq.jsj = ((int)paramAnonymousc.field_finishedLength);
            paramAnonymousInt = 1040;
          }
          d.this.jqq.cSx = paramAnonymousInt;
          u.f(d.this.jqq);
          Log.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { d.this.bgZ(), d.this.iYT, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { d.this.bgZ(), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(Util.nowMilliSecond() - d.this.jqv) });
          paramAnonymousString = d.this;
          paramAnonymousc = d.this.jqr;
          if ((paramAnonymousc != null) && (paramAnonymousd != null)) {
            break label1155;
          }
          Log.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
          if (paramAnonymousd.field_retCode == 0) {
            break label1249;
          }
          u.QE(d.this.fileName);
          if (d.this.jqo) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 13L, 1L, false);
          }
          if (d.this.jqp) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 252L, 1L, false);
          }
          d.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", d.this);
        }
        for (;;)
        {
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.this.jqs), Integer.valueOf(d.this.iKP), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          if (paramAnonymousd.field_retCode != 0) {
            new w(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(d.this.jqs), Integer.valueOf(d.this.iKP), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
          }
          a.a(d.this.jqq, 1);
          d.this.jqr = null;
          AppMethodBeat.o(126824);
          return 0;
          label1155:
          if (paramAnonymousc.field_smallVideoFlag == 1)
          {
            Log.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
            break;
          }
          if ((paramAnonymousc == null) || (paramAnonymousd == null)) {
            break;
          }
          Log.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", new Object[] { paramAnonymousString.bgZ(), Long.valueOf(paramAnonymousd.field_recvedBytes), Long.valueOf(paramAnonymousd.field_startTime), Long.valueOf(paramAnonymousd.field_endTime) });
          o.bhk();
          e.a(null, paramAnonymousd, paramAnonymousc, true);
          break;
          label1249:
          if (d.this.jqo) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 12L, 1L, false);
          }
          if (d.this.jqp) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 137L, 1L, false);
          }
          d.this.ud((int)paramAnonymousd.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
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
      this.jqo = paramBoolean;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { bgZ(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(126829);
      return;
    }
  }
  
  private boolean bgY()
  {
    AppMethodBeat.i(126830);
    Log.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { bgZ(), this.jqq.bhv() });
    Object localObject4 = XmlParser.parseXml(this.jqq.bhv(), "msg", null);
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 214L, 1L, false);
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { bgZ() });
      AppMethodBeat.o(126830);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 213L, 1L, false);
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { bgZ() });
      AppMethodBeat.o(126830);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.iKP = Util.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.iYT = com.tencent.mm.an.c.a("downvideo", this.jqq.createTime, this.jqq.getUser(), this.jqq.getFileName());
    if (Util.isNullOrNil(this.iYT))
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bgZ(), this.jqq.getFileName() });
      AppMethodBeat.o(126830);
      return false;
    }
    if ((!this.jqo) && (this.iKP < 1048576) && (this.jqq != null) && (this.jqq.dRQ > 0))
    {
      this.jqo = true;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { bgZ(), Boolean.valueOf(this.jqo) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    o.bhj();
    localObject3 = t.Qw(this.fileName) + ".tmp";
    this.jqr = new com.tencent.mm.i.h();
    this.jqr.taskName = "task_NetSceneDownloadVideo";
    this.jqr.filename = this.jqq.getFileName();
    this.jqr.gqS = ((String)localObject2);
    this.jqr.gqT = this.iKP;
    this.jqr.gqU = 0;
    this.jqr.dRL = this.jqq.bhs();
    this.jqr.gqV = this.jqq.getUser();
    com.tencent.mm.i.h localh = this.jqr;
    int i;
    label651:
    label816:
    label853:
    int k;
    if (ab.Eq(this.jqq.getUser()))
    {
      i = v.Ie(this.jqq.getUser());
      localh.dRN = i;
      this.jqr.field_mediaId = this.iYT;
      this.jqr.field_fullpath = ((String)localObject3);
      this.jqr.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      this.jqr.field_totalLen = this.iKP;
      this.jqr.field_aesKey = ((String)localObject5);
      this.jqr.field_fileId = str1;
      this.jqr.field_priority = com.tencent.mm.i.a.gpM;
      this.jqr.gqy = this.iZc;
      this.jqr.field_wxmsgparam = str2;
      localObject5 = this.jqr;
      if (!ab.Eq(this.jqq.getUser())) {
        break label1676;
      }
      i = 1;
      ((com.tencent.mm.i.h)localObject5).field_chattype = i;
      this.jqr.gqW = this.jqq.gqW;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.jqr.field_fileId = "";
        this.jqr.field_fileType = 19;
        this.jqr.field_authKey = ((String)localObject4);
        this.jqr.gqB = ((String)localObject1);
      }
      localObject4 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(this.jqq.getUser(), this.jqq.dTS);
      this.jqr.gqY = ((eo)localObject4).field_createTime;
      this.jqr.dTS = ((eo)localObject4).field_msgSvrId;
      localObject1 = bp.Ky(((eo)localObject4).fqK);
      localObject5 = this.jqr;
      if (localObject1 == null) {
        break label1681;
      }
      i = ((bp.b)localObject1).iEG;
      ((com.tencent.mm.i.h)localObject5).gqZ = i;
      if (this.jqq.getUser().equals(((eo)localObject4).field_talker))
      {
        localObject5 = this.jqr;
        if (localObject1 != null) {
          break label1686;
        }
        i = 0;
        ((com.tencent.mm.i.h)localObject5).field_limitrate = i;
      }
      Log.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { bgZ(), Integer.valueOf(this.jqr.field_limitrate), this.jqq.getFileName() });
      if (!com.tencent.mm.an.f.baQ().iRE.contains("video_" + this.jqq.jso)) {
        break label1698;
      }
      com.tencent.mm.an.f.baQ().iRE.remove("video_" + this.jqq.jso);
      this.jqr.field_autostart = true;
      label977:
      if (3 == this.jqq.jsu) {
        this.jqr.field_smallVideoFlag = 1;
      }
      if ((Util.isNullOrNil((String)localObject2)) || (this.jqo)) {
        break label1729;
      }
      localObject1 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().gS((String)localObject2, this.iKP);
      j = (int)com.tencent.mm.vfs.s.boW((String)localObject1);
      k = this.iKP - j;
      o.bhj();
      localObject5 = t.Qw(this.fileName);
      int m = (int)com.tencent.mm.vfs.s.boW((String)localObject5);
      if (m > 0)
      {
        Log.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { bgZ() });
        bool = com.tencent.mm.vfs.s.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV();
        int n = this.iKP;
        i = 0;
        if (!Util.isNullOrNil((String)localObject2)) {
          i = ((bz)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = u.QN(this.fileName);
        ((s)localObject1).jsj = 0;
        ((s)localObject1).cSx = 16;
        u.f((s)localObject1);
        Log.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { bgZ(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { bgZ(), Integer.valueOf(this.iKP), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (Util.isNullOrNil((String)localObject1)) {
        break label1715;
      }
      if ((k < 0) || (k > 16)) {
        break label1729;
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { bgZ(), localObject1, localObject3 });
      com.tencent.mm.vfs.s.nw((String)localObject1, (String)localObject3);
      ud(this.iKP);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(((eo)localObject4).field_talker, "update", (ca)localObject4));
      localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
      long l1 = this.jqq.dTS;
      long l2 = this.jqq.createTime;
      localObject3 = this.jqq.getUser();
      if (3 == this.jqq.jsu) {
        break label1709;
      }
      i = 43;
      label1462:
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(13267, new Object[] { str1, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1523:
      if (i != 0) {
        break label1761;
      }
      this.mediaId = this.jqr.field_mediaId;
      this.jqv = Util.nowMilliSecond();
      if (this.jqq.videoFormat != 2) {
        break label1734;
      }
    }
    label1676:
    label1681:
    label1686:
    label1698:
    label1709:
    label1715:
    label1729:
    label1734:
    for (boolean bool = true;; bool = false)
    {
      this.jqp = bool;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { bgZ(), Boolean.valueOf(this.jqp), Boolean.valueOf(this.jqo) });
      if (this.jqo) {
        break label1979;
      }
      if (com.tencent.mm.an.f.baQ().b(this.jqr, -1)) {
        break label1740;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 212L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { bgZ() });
      this.iYT = "";
      AppMethodBeat.o(126830);
      return false;
      i = 0;
      break;
      i = 0;
      break label651;
      i = 0;
      break label816;
      i = ((bp.b)localObject1).iEE / 8;
      break label853;
      this.jqr.field_autostart = false;
      break label977;
      i = 62;
      break label1462;
      this.iYZ = ((String)localObject2);
      this.iZa = this.iKP;
      i = 0;
      break label1523;
    }
    label1740:
    if (this.jqp) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 135L, 1L, false);
    }
    label1761:
    if (this.jqq.jss != 1)
    {
      this.jqq.jss = 1;
      this.jqq.cSx = 524288;
      u.f(this.jqq);
    }
    if (3 != this.jqq.jsu)
    {
      localObject1 = this.jqq.getUser();
      if (!Util.isNullOrNil((String)localObject1)) {
        if (!ab.Eq((String)localObject1)) {
          break label2152;
        }
      }
    }
    label1979:
    label2152:
    for (int j = v.Ie((String)localObject1);; j = 0) {
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
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.iKP + "," + i;
        Log.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { bgZ(), localObject1 });
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(126830);
        return true;
        this.jqu = false;
        localObject1 = this.jqr;
        o.bhj();
        ((com.tencent.mm.i.h)localObject1).field_fullpath = t.Qw(this.fileName);
        if (this.jqp)
        {
          this.jqr.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 251L, 1L, false);
        }
        o.bhk().a(this.jqr, false);
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
  
  final boolean Qt()
  {
    boolean bool = false;
    AppMethodBeat.i(126828);
    if (!Util.isNullOrNil(this.mediaId))
    {
      if (!this.jqo) {
        break label71;
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { bgZ() });
      o.bhk().m(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.jqt = true;
      AppMethodBeat.o(126828);
      return bool;
      label71:
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { bgZ() });
      com.tencent.mm.an.f.baQ().Oc(this.mediaId);
    }
  }
  
  final String bgZ()
  {
    AppMethodBeat.i(126837);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126837);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126827);
    Qt();
    super.cancel();
    AppMethodBeat.o(126827);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    int i = 1;
    AppMethodBeat.i(126832);
    this.callback = parami;
    this.jqq = u.QN(this.fileName);
    if (this.jqq == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.jqq != null) && (3 == this.jqq.jsu)) {
      this.jqs = com.tencent.mm.i.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.startOffset = this.jqq.jsj;
    }
    if (bgY())
    {
      Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126832);
      return 0;
    }
    if (this.jqq.status != 112)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.jqq.status + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "]");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    Log.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "]  filesize:" + this.jqq.jsj + " file:" + this.jqq.iKP + " netTimes:" + this.jqq.jsp);
    if (!u.QD(this.fileName))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.jqq.jsp + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if (this.jqq.dTS <= 0L)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.jqq.dTS + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.jqq.jsj < 0) || (this.jqq.iKP <= this.jqq.jsj) || (this.jqq.iKP <= 0))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.jqq.jsj + " total:" + this.jqq.iKP + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    parami = new d.a();
    parami.iLN = new ahv();
    parami.iLO = new ahw();
    parami.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    parami.funcId = 150;
    parami.iLP = 40;
    parami.respCmdId = 1000000040;
    this.rr = parami.aXF();
    parami = (ahv)this.rr.iLK.iLR;
    parami.Brn = this.jqq.dTS;
    parami.BsG = this.jqq.jsj;
    parami.BsF = this.jqq.iKP;
    if (ag.dm(MMApplicationContext.getContext())) {}
    for (;;)
    {
      parami.LrC = i;
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
    if (this.jqt)
    {
      Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.iYT)))
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.iYT });
      AppMethodBeat.o(126836);
      return;
    }
    paramArrayOfByte = (ahw)((com.tencent.mm.ak.d)params).iLL.iLR;
    params = (ahv)((com.tencent.mm.ak.d)params).iLK.iLR;
    this.jqq = u.QN(this.fileName);
    if (this.jqq == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.jqq.status == 113)
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.jqq.status != 112)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.jqq.status + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 208L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), Integer.valueOf(this.iKP - this.startOffset) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 207L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      this.jqq.status = 113;
      u.f(this.jqq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (Util.isNullOrNil(paramArrayOfByte.BsI.getBuffer().zy))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.BsG != params.BsG)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.BsG + " reqStartPos:" + params.BsG + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.BsF != params.BsF)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.BsF + " reqTotal:" + params.BsF + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (params.BsF < paramArrayOfByte.BsG)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.BsF + " respStartPos:" + params.BsG + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.Brn != params.Brn)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.Brn + " reqMsgId:" + params.Brn + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.BsI.getILen() + " reqStartPos:" + params.BsG + " totallen:" + params.BsF + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
    o.bhj();
    int j = t.a(t.Qw(this.fileName), params.BsG, paramArrayOfByte.BsI.getBuffer().toByteArray());
    if (j < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (j > this.jqq.iKP)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.jqq.iKP + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    params = this.fileName;
    paramArrayOfByte = u.QN(params);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + params);
      paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
    }
    while (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
      paramArrayOfByte.jsj = j;
      paramArrayOfByte.jsm = Util.nowSecond();
      paramArrayOfByte.cSx = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.iKP > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.iKP)
        {
          u.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.cSx |= 0x100;
          Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + params + " newsize:" + j + " total:" + paramArrayOfByte.iKP + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.jsp);
          paramInt1 = 1;
        }
      }
      Log.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.f.apq() + " file:" + params + " newsize:" + j + " total:" + paramArrayOfByte.iKP + " status:" + paramArrayOfByte.status);
      if (!u.f(paramArrayOfByte)) {
        paramInt1 = 0 - com.tencent.mm.compatible.util.f.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.jqs), Integer.valueOf(this.iKP - this.startOffset) });
      a.a(this.jqq, 1);
      Log.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.jqt)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    this.iKj.startTimer(0L);
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
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126834);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(126833);
    params = (ahv)((com.tencent.mm.ak.d)params).iLK.iLR;
    if ((params.Brn <= 0L) || (params.BsG < 0) || (params.BsF <= 0) || (params.BsF <= params.BsG))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.jqq.dTS + "," + this.jqq.bhs() + "," + this.jqq.getUser() + "] ");
      u.QE(this.fileName);
      params = q.b.iMr;
      AppMethodBeat.o(126833);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(126833);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 211L, 1L, false);
    u.QE(this.fileName);
    AppMethodBeat.o(126835);
  }
  
  final void ud(final int paramInt)
  {
    AppMethodBeat.i(126831);
    Object localObject;
    if (this.jqu)
    {
      localObject = new StringBuilder();
      o.bhj();
      localObject = new com.tencent.mm.vfs.o(t.Qw(this.fileName) + ".tmp");
      o.bhj();
    }
    for (final boolean bool = ((com.tencent.mm.vfs.o)localObject).am(new com.tencent.mm.vfs.o(t.Qw(this.fileName)));; bool = true)
    {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126825);
          Object localObject1 = XmlParser.parseXml(d.this.jqq.bhv(), "msg", null);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = o.bhj();
            o.bhj();
            ((t)localObject2).q(t.Qw(d.this.fileName), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          }
          boolean bool1 = false;
          if (bool)
          {
            boolean bool2 = u.ay(d.this.fileName, paramInt);
            bool1 = bool2;
            if (d.this.jqp)
            {
              u.QS(d.this.fileName);
              Log.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
              bool1 = bool2;
            }
            Log.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { d.this.bgZ(), d.this.fileName, Long.valueOf(d.this.jqq.dTS), d.this.jqq.bhs(), d.this.jqq.getUser(), Boolean.valueOf(bool1), d.this.iYZ, Integer.valueOf(d.this.iZa), Boolean.valueOf(bool), Boolean.valueOf(d.this.jqu) });
            if ((!Util.isNullOrNil(d.this.iYZ)) && (d.this.iZa > 0))
            {
              localObject1 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV();
              localObject2 = d.this.iYZ;
              int i = d.this.iZa;
              o.bhj();
              ((bz)localObject1).P((String)localObject2, i, t.Qw(d.this.fileName));
            }
            if (d.this.jqq.jsu != 3) {
              break label546;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 38L, d.this.jqq.iKP, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 40L, d.this.jqq.iFw, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 41L, 1L, false);
            localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
            if (!ab.Eq(d.this.jqq.getUser())) {
              break label538;
            }
          }
          label538:
          for (long l = 43L;; l = 42L)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(198L, l, 1L, false);
            d.this.callback.onSceneEnd(0, 0, "", d.this);
            AppMethodBeat.o(126825);
            return;
            if (d.this.jqp)
            {
              u.QE(d.this.fileName);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 138L, 1L, false);
              break;
            }
            bool1 = u.ay(d.this.fileName, paramInt);
            break;
          }
          label546:
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 31L, d.this.jqq.iKP, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 33L, d.this.jqq.iFw, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 34L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
          if (ab.Eq(d.this.jqq.getUser())) {}
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
      o.bhj();
      com.tencent.mm.vfs.s.deleteFile(t.Qw(this.fileName) + ".tmp");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */