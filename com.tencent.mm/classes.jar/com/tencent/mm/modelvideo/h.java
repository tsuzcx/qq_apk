package com.tencent.mm.modelvideo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.ah;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  String fileName;
  private String mediaId;
  private String oHX;
  private int oHY;
  private String oIe;
  private int oIf;
  private boolean oYL;
  private boolean oYM;
  private z oYN;
  private com.tencent.mm.g.h oYO;
  private int oYP;
  private boolean oYQ;
  private boolean oYR;
  private long oYS;
  private MTimerHandler orP;
  private g.a osH;
  private int osy;
  int retCode;
  private com.tencent.mm.am.c rr;
  private long startTime;
  
  public h(String paramString)
  {
    this(paramString, false);
  }
  
  public h(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126829);
    this.oYN = null;
    this.oHX = "";
    this.oHY = 0;
    this.startTime = 0L;
    this.osy = 0;
    this.retCode = 0;
    this.oYP = com.tencent.mm.g.a.MediaType_VIDEO;
    this.oYQ = false;
    this.oYR = true;
    this.oIe = null;
    this.oIf = 0;
    this.oYS = 0L;
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
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
          ab.Qf(h.c(h.this));
          h.d(h.this).onSceneEnd(3, paramAnonymousInt, "", h.this);
          AppMethodBeat.o(126824);
          return 0;
        }
        h.a(h.this, ab.Qo(h.c(h.this)));
        if ((h.e(h.this) == null) || (h.e(h.this).status == 113))
        {
          if (h.e(h.this) == null) {}
          for (int i = -1;; i = h.e(h.this).status)
          {
            Log.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", new Object[] { h.a(h.this), Integer.valueOf(i) });
            h.f(h.this);
            h.d(h.this).onSceneEnd(3, paramAnonymousInt, "upload video info is null or has paused, status".concat(String.valueOf(i)), h.this);
            AppMethodBeat.o(126824);
            return 0;
          }
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == h.g(h.this))
          {
            Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
            AppMethodBeat.o(126824);
            return 0;
          }
          if ((h.e(h.this).paX > paramAnonymousc.field_finishedLength) && (!h.h(h.this)))
          {
            Log.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", new Object[] { h.a(h.this), Integer.valueOf(h.e(h.this).paX), Long.valueOf(paramAnonymousc.field_finishedLength) });
            ab.Qf(h.c(h.this));
            h.d(h.this).onSceneEnd(3, paramAnonymousInt, "", h.this);
            AppMethodBeat.o(126824);
            return 0;
          }
          paramAnonymousInt = 1024;
          h.e(h.this).pba = Util.nowSecond();
          if (h.e(h.this).paX < paramAnonymousc.field_finishedLength)
          {
            h.e(h.this).paX = ((int)paramAnonymousc.field_finishedLength);
            paramAnonymousInt = 1040;
          }
          h.e(h.this).eQp = paramAnonymousInt;
          ab.f(h.e(h.this));
          Log.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", new Object[] { h.a(h.this), h.b(h.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          AppMethodBeat.o(126824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", new Object[] { h.a(h.this), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(Util.nowMilliSecond() - h.i(h.this)) });
          h.a(h.this, h.j(h.this), paramAnonymousd);
          if (paramAnonymousd.field_retCode == 0) {
            break label705;
          }
          ab.Qf(h.c(h.this));
          if (h.h(h.this)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 13L, 1L, false);
          }
          if (h.k(h.this)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 252L, 1L, false);
          }
          h.d(h.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", h.this);
        }
        for (;;)
        {
          a.a(h.e(h.this), 1);
          h.l(h.this);
          AppMethodBeat.o(126824);
          return 0;
          label705:
          if (h.h(h.this)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 12L, 1L, false);
          }
          if (h.k(h.this)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 137L, 1L, false);
          }
          h.a(h.this, (int)paramAnonymousd.field_fileLength);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126826);
        if (h.this.doScene(h.p(h.this), h.d(h.this)) == -1) {
          h.d(h.this).onSceneEnd(3, -1, "doScene failed", h.this);
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
      this.oYL = paramBoolean;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", new Object[] { bNX(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(126829);
      return;
    }
  }
  
  private boolean bNW()
  {
    AppMethodBeat.i(126830);
    Log.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", new Object[] { bNX(), this.oYN.bOu() });
    Object localObject4 = XmlParser.parseXml(this.oYN.bOu(), "msg", null);
    if (localObject4 == null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 214L, 1L, false);
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { bNX() });
      AppMethodBeat.o(126830);
      return false;
    }
    String str1 = (String)((Map)localObject4).get(".msg.videomsg.$cdnvideourl");
    Object localObject1 = (String)((Map)localObject4).get(".msg.videomsg.$tpvideourl");
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil((String)localObject1)))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 213L, 1L, false);
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", new Object[] { bNX() });
      AppMethodBeat.o(126830);
      return false;
    }
    Object localObject5 = (String)((Map)localObject4).get(".msg.videomsg.$aeskey");
    this.osy = Util.getInt((String)((Map)localObject4).get(".msg.videomsg.$length"), 0);
    String str2 = (String)((Map)localObject4).get(".msg.videomsg.$fileparam");
    this.oHX = com.tencent.mm.modelcdntran.h.a("downvideo", this.oYN.createTime, this.oYN.bOs(), this.oYN.getFileName());
    if (Util.isNullOrNil(this.oHX))
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", new Object[] { bNX(), this.oYN.getFileName() });
      AppMethodBeat.o(126830);
      return false;
    }
    if ((!this.oYL) && (this.osy < 1048576) && (this.oYN != null) && (this.oYN.hQV > 0))
    {
      this.oYL = true;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", new Object[] { bNX(), Boolean.valueOf(this.oYL) });
    }
    Object localObject2 = (String)((Map)localObject4).get(".msg.videomsg.$md5");
    Object localObject3 = new StringBuilder();
    v.bOh();
    localObject3 = aa.PX(this.fileName) + ".tmp";
    this.oYO = new com.tencent.mm.g.h();
    this.oYO.taskName = "task_NetSceneDownloadVideo";
    this.oYO.filename = this.oYN.getFileName();
    this.oYO.lxg = ((String)localObject2);
    this.oYO.lxh = this.osy;
    this.oYO.lxi = 0;
    this.oYO.hQQ = this.oYN.bOq();
    this.oYO.lxj = this.oYN.bOs();
    com.tencent.mm.g.h localh = this.oYO;
    int i;
    label659:
    label829:
    label866:
    int k;
    if (au.bwE(this.oYN.bOs()))
    {
      i = com.tencent.mm.model.v.getMembersCountByChatRoomName(this.oYN.bOs());
      localh.hQS = i;
      this.oYO.field_mediaId = this.oHX;
      this.oYO.field_fullpath = ((String)localObject3);
      this.oYO.field_fileType = com.tencent.mm.g.a.MediaType_VIDEO;
      this.oYO.field_totalLen = this.osy;
      this.oYO.field_aesKey = ((String)localObject5);
      this.oYO.field_fileId = str1;
      this.oYO.field_priority = com.tencent.mm.g.a.lvZ;
      this.oYO.lwL = this.osH;
      this.oYO.field_wxmsgparam = str2;
      localObject5 = this.oYO;
      if (!au.bwE(this.oYN.bOs())) {
        break label1695;
      }
      i = 1;
      ((com.tencent.mm.g.h)localObject5).field_chattype = i;
      this.oYO.lxk = this.oYN.lxk;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject4 = (String)((Map)localObject4).get(".msg.videomsg.$tpauthkey");
        this.oYO.field_fileId = "";
        this.oYO.field_fileType = 19;
        this.oYO.field_authKey = ((String)localObject4);
        this.oYO.lwO = ((String)localObject1);
      }
      localObject4 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(this.oYN.bOs(), this.oYN.hTh);
      if (localObject4 != null)
      {
        this.oYO.lxm = ((cc)localObject4).getCreateTime();
        this.oYO.hTh = ((fi)localObject4).field_msgSvrId;
        localObject1 = br.JP(((fi)localObject4).jUr);
        localObject5 = this.oYO;
        if (localObject1 == null) {
          break label1700;
        }
        i = ((br.b)localObject1).omg;
        ((com.tencent.mm.g.h)localObject5).lxn = i;
        if (this.oYN.bOs().equals(((fi)localObject4).field_talker))
        {
          localObject5 = this.oYO;
          if (localObject1 != null) {
            break label1705;
          }
          i = 0;
          ((com.tencent.mm.g.h)localObject5).field_limitrate = i;
        }
      }
      Log.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", new Object[] { bNX(), Integer.valueOf(this.oYO.field_limitrate), this.oYN.getFileName() });
      if (!k.bHW().oAv.contains("video_" + this.oYN.pbc)) {
        break label1717;
      }
      k.bHW().oAv.remove("video_" + this.oYN.pbc);
      this.oYO.field_autostart = true;
      label990:
      if (3 == this.oYN.pbi) {
        this.oYO.field_smallVideoFlag = 1;
      }
      if ((Util.isNullOrNil((String)localObject2)) || (this.oYL)) {
        break label1748;
      }
      localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI().iI((String)localObject2, this.osy);
      j = (int)y.bEl((String)localObject1);
      k = this.osy - j;
      v.bOh();
      localObject5 = aa.PX(this.fileName);
      int m = (int)y.bEl((String)localObject5);
      if (m > 0)
      {
        Log.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", new Object[] { bNX() });
        bool = y.deleteFile((String)localObject5);
        localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI();
        int n = this.osy;
        i = 0;
        if (!Util.isNullOrNil((String)localObject2)) {
          i = ((cb)localObject1).db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { localObject2, String.valueOf(n), "100" });
        }
        localObject1 = ab.Qo(this.fileName);
        ((z)localObject1).paX = 0;
        ((z)localObject1).eQp = 16;
        ab.f((z)localObject1);
        Log.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", new Object[] { bNX(), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i) });
        localObject1 = "";
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", new Object[] { bNX(), Integer.valueOf(this.osy), localObject2, Integer.valueOf(j), localObject1, Integer.valueOf(k), localObject3, Integer.valueOf(m) });
      if (Util.isNullOrNil((String)localObject1)) {
        break label1734;
      }
      if ((k < 0) || (k > 16)) {
        break label1748;
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", new Object[] { bNX(), localObject1, localObject3 });
      y.O((String)localObject1, (String)localObject3, false);
      xc(this.osy);
      if (localObject4 != null) {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(new i.c(((fi)localObject4).field_talker, "update", (cc)localObject4));
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      long l1 = this.oYN.hTh;
      long l2 = this.oYN.createTime;
      localObject3 = this.oYN.bOs();
      if (3 == this.oYN.pbi) {
        break label1728;
      }
      i = 43;
      label1481:
      ((com.tencent.mm.plugin.report.service.h)localObject1).b(13267, new Object[] { str1, Long.valueOf(l1), localObject2, Long.valueOf(l2), localObject3, Integer.valueOf(i), Integer.valueOf(j) });
      i = 1;
      label1542:
      if (i != 0) {
        break label1780;
      }
      this.mediaId = this.oYO.field_mediaId;
      this.oYS = Util.nowMilliSecond();
      if (this.oYN.videoFormat != 2) {
        break label1753;
      }
    }
    label1695:
    label1700:
    label1705:
    label1717:
    label1728:
    label1734:
    label1748:
    label1753:
    for (boolean bool = true;; bool = false)
    {
      this.oYM = bool;
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", new Object[] { bNX(), Boolean.valueOf(this.oYM), Boolean.valueOf(this.oYL) });
      if (this.oYL) {
        break label1998;
      }
      if (k.bHW().b(this.oYO, -1)) {
        break label1759;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 212L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", new Object[] { bNX() });
      this.oHX = "";
      AppMethodBeat.o(126830);
      return false;
      i = 0;
      break;
      i = 0;
      break label659;
      i = 0;
      break label829;
      i = ((br.b)localObject1).ome / 8;
      break label866;
      this.oYO.field_autostart = false;
      break label990;
      i = 62;
      break label1481;
      this.oIe = ((String)localObject2);
      this.oIf = this.osy;
      i = 0;
      break label1542;
    }
    label1759:
    if (this.oYM) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 135L, 1L, false);
    }
    label1780:
    if (this.oYN.pbg != 1)
    {
      this.oYN.pbg = 1;
      this.oYN.eQp = 524288;
      ab.f(this.oYN);
    }
    if (3 != this.oYN.pbi)
    {
      localObject1 = this.oYN.bOs();
      if (!Util.isNullOrNil((String)localObject1)) {
        if (!au.bwE((String)localObject1)) {
          break label2171;
        }
      }
    }
    label1998:
    label2171:
    for (int j = com.tencent.mm.model.v.getMembersCountByChatRoomName((String)localObject1);; j = 0) {
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
        localObject1 = (String)localObject1 + "," + j + "," + str1 + "," + this.osy + "," + i;
        Log.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", new Object[] { bNX(), localObject1 });
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(12024, (String)localObject1);
        AppMethodBeat.o(126830);
        return true;
        this.oYR = false;
        localObject1 = this.oYO;
        v.bOh();
        ((com.tencent.mm.g.h)localObject1).field_fullpath = aa.PX(this.fileName);
        if (this.oYM)
        {
          this.oYO.field_requestVideoFormat = 2;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 251L, 1L, false);
        }
        v.bOi().a(this.oYO, false);
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
  
  private String bNX()
  {
    AppMethodBeat.i(126837);
    String str = this.fileName + "_" + hashCode();
    AppMethodBeat.o(126837);
    return str;
  }
  
  private boolean stop()
  {
    boolean bool = false;
    AppMethodBeat.i(126828);
    if (!Util.isNullOrNil(this.mediaId))
    {
      if (!this.oYL) {
        break label71;
      }
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", new Object[] { bNX() });
      v.bOi().l(this.mediaId, null);
    }
    for (;;)
    {
      bool = true;
      this.oYQ = true;
      AppMethodBeat.o(126828);
      return bool;
      label71:
      Log.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", new Object[] { bNX() });
      k.bHW().Nz(this.mediaId);
    }
  }
  
  private void xc(final int paramInt)
  {
    AppMethodBeat.i(126831);
    Object localObject;
    if (this.oYR)
    {
      localObject = new StringBuilder();
      v.bOh();
      localObject = aa.PX(this.fileName) + ".tmp";
      v.bOh();
    }
    for (final boolean bool = y.qn((String)localObject, aa.PX(this.fileName));; bool = true)
    {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126825);
          Object localObject1 = XmlParser.parseXml(h.e(h.this).bOu(), "msg", null);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = v.bOh();
            v.bOh();
            ((aa)localObject2).x(aa.PX(h.c(h.this)), (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"), (String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
          }
          boolean bool1 = false;
          if (bool)
          {
            boolean bool2 = ab.be(h.c(h.this), paramInt);
            bool1 = bool2;
            if (h.k(h.this))
            {
              ab.Qt(h.c(h.this));
              Log.i("MicroMsg.NetSceneDownloadVideo", "sceneEndproc, isHadHevcLocalFile");
              bool1 = bool2;
            }
            Log.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[] { h.a(h.this), h.c(h.this), Long.valueOf(h.e(h.this).hTh), h.e(h.this).bOq(), h.e(h.this).bOs(), Boolean.valueOf(bool1), h.m(h.this), Integer.valueOf(h.n(h.this)), Boolean.valueOf(bool), Boolean.valueOf(h.o(h.this)) });
            if ((!Util.isNullOrNil(h.m(h.this))) && (h.n(h.this) > 0))
            {
              localObject1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI();
              localObject2 = h.m(h.this);
              int i = h.n(h.this);
              v.bOh();
              ((cb)localObject1).W((String)localObject2, i, aa.PX(h.c(h.this)));
            }
            if (h.e(h.this).pbi != 3) {
              break label546;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 38L, h.e(h.this).osy, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 40L, h.e(h.this).omT, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 41L, 1L, false);
            localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
            if (!au.bwE(h.e(h.this).bOs())) {
              break label538;
            }
          }
          label538:
          for (long l = 43L;; l = 42L)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(198L, l, 1L, false);
            h.d(h.this).onSceneEnd(0, 0, "", h.this);
            AppMethodBeat.o(126825);
            return;
            if (h.k(h.this))
            {
              ab.Qf(h.c(h.this));
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 138L, 1L, false);
              break;
            }
            bool1 = ab.be(h.c(h.this), paramInt);
            break;
          }
          label546:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 31L, h.e(h.this).osy, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 33L, h.e(h.this).omT, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 34L, 1L, false);
          localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
          if (au.bwE(h.e(h.this).bOs())) {}
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
      v.bOh();
      y.deleteFile(aa.PX(this.fileName) + ".tmp");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126827);
    stop();
    super.cancel();
    AppMethodBeat.o(126827);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    int i = 1;
    AppMethodBeat.i(126832);
    this.callback = paramh;
    this.oYN = ab.Qo(this.fileName);
    if (this.oYN == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.oYN != null) && (3 == this.oYN.pbi)) {
      this.oYP = com.tencent.mm.g.a.MediaType_TinyVideo;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.oHY = this.oYN.paX;
    }
    if (bNW())
    {
      Log.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[] { this.fileName });
      AppMethodBeat.o(126832);
      return 0;
    }
    if (this.oYN.status != 112)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.oYN.status + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "]");
      this.retCode = (0 - f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    Log.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "]  filesize:" + this.oYN.paX + " file:" + this.oYN.osy + " netTimes:" + this.oYN.pbd);
    if (!ab.Qe(this.fileName))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.oYN.pbd + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.retCode = (0 - f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if (this.oYN.hTh <= 0L)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.oYN.hTh + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.retCode = (0 - f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    if ((this.oYN.paX < 0) || (this.oYN.osy <= this.oYN.paX) || (this.oYN.osy <= 0))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.oYN.paX + " total:" + this.oYN.osy + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.retCode = (0 - f.getLine() - 10000);
      AppMethodBeat.o(126832);
      return -1;
    }
    paramh = new c.a();
    paramh.otE = new ala();
    paramh.otF = new alb();
    paramh.uri = "/cgi-bin/micromsg-bin/downloadvideo";
    paramh.funcId = 150;
    paramh.otG = 40;
    paramh.respCmdId = 1000000040;
    this.rr = paramh.bEF();
    paramh = (ala)c.b.b(this.rr.otB);
    paramh.Njv = this.oYN.hTh;
    paramh.NkO = this.oYN.paX;
    paramh.NkN = this.oYN.osy;
    if (ah.eb(MMApplicationContext.getContext())) {}
    for (;;)
    {
      paramh.Zsm = i;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126836);
    if (this.oYQ)
    {
      Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      AppMethodBeat.o(126836);
      return;
    }
    paramArrayOfByte = (alb)c.c.b(((com.tencent.mm.am.c)params).otC);
    params = (ala)c.b.b(((com.tencent.mm.am.c)params).otB);
    this.oYN = ab.Qo(this.fileName);
    if (this.oYN == null)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
      this.retCode = (0 - f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.oYN.status == 113)
    {
      Log.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.oYN.status != 112)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.oYN.status + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 208L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 207L, 1L, false);
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + paramInt2 + " errCode:" + paramInt3 + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      this.oYN.status = 113;
      ab.f(this.oYN);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (Util.isNullOrNil(paramArrayOfByte.NkQ.aaxD.Op))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.NkO != params.NkO)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + paramArrayOfByte.NkO + " reqStartPos:" + params.NkO + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.NkN != params.NkN)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.NkN + " reqTotal:" + params.NkN + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (params.NkN < paramArrayOfByte.NkO)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + paramArrayOfByte.NkN + " respStartPos:" + params.NkO + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (paramArrayOfByte.Njv != params.Njv)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + paramArrayOfByte.Njv + " reqMsgId:" + params.Njv + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    Log.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + paramArrayOfByte.NkQ.abwJ + " reqStartPos:" + params.NkO + " totallen:" + params.NkN + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
    v.bOh();
    int j = aa.a(aa.PX(this.fileName), params.NkO, paramArrayOfByte.NkQ.aaxD.toByteArray());
    if (j < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + j + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (j > this.oYN.osy)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + j + " totalLen:" + this.oYN.osy + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    params = this.fileName;
    paramArrayOfByte = ab.Qo(params);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.VideoLogic", "ERR:" + f.aPX() + " getinfo failed: " + params);
      paramInt1 = 0 - f.getLine();
    }
    while (paramInt1 < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + paramInt1 + " newOffset :" + j + " [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
      paramArrayOfByte.paX = j;
      paramArrayOfByte.pba = Util.nowSecond();
      paramArrayOfByte.eQp = 1040;
      int i = 0;
      paramInt1 = i;
      if (paramArrayOfByte.osy > 0)
      {
        paramInt1 = i;
        if (j >= paramArrayOfByte.osy)
        {
          ab.e(paramArrayOfByte);
          paramArrayOfByte.status = 199;
          paramArrayOfByte.eQp |= 0x100;
          Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + params + " newsize:" + j + " total:" + paramArrayOfByte.osy + " status:" + paramArrayOfByte.status + " netTimes:" + paramArrayOfByte.pbd);
          paramInt1 = 1;
        }
      }
      Log.d("MicroMsg.VideoLogic", "updateRecv " + f.aPX() + " file:" + params + " newsize:" + j + " total:" + paramArrayOfByte.osy + " status:" + paramArrayOfByte.status);
      if (!ab.f(paramArrayOfByte)) {
        paramInt1 = 0 - f.getLine();
      }
    }
    if (paramInt1 == 1)
    {
      a.a(this.oYN, 1);
      Log.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "]");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    if (this.oYQ)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(126836);
      return;
    }
    this.orP.startTimer(0L);
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
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 210L, 1L, false);
    }
    AppMethodBeat.o(126834);
    return bool;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(126833);
    params = (ala)c.b.b(((com.tencent.mm.am.c)params).otB);
    if ((params.Njv <= 0L) || (params.NkO < 0) || (params.NkN <= 0) || (params.NkN <= params.NkO))
    {
      Log.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.oYN.hTh + "," + this.oYN.bOq() + "," + this.oYN.bOs() + "] ");
      ab.Qf(this.fileName);
      params = p.b.oui;
      AppMethodBeat.o(126833);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(126833);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(126835);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 211L, 1L, false);
    ab.Qf(this.fileName);
    AppMethodBeat.o(126835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.h
 * JD-Core Version:    0.7.0.1
 */