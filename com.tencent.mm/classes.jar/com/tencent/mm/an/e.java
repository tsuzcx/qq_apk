package com.tencent.mm.an;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.oq.a;
import com.tencent.mm.g.b.a.gp;
import com.tencent.mm.g.b.a.iq;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.b.a.lg;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e
  implements com.tencent.mm.ak.i, a.a
{
  MMHandler hAk;
  Map<String, com.tencent.mm.i.h> iRA;
  Queue<String> iRy;
  Map<String, com.tencent.mm.i.h> iRz;
  Map<String, com.tencent.mm.i.h> iSl;
  Map<String, com.tencent.mm.i.d> iSm;
  private final MMHandler mainHandler;
  
  public e()
  {
    AppMethodBeat.i(126721);
    this.iRy = new LinkedList();
    this.iRz = new HashMap();
    this.iRA = new HashMap();
    this.iSl = new HashMap();
    this.iSm = new HashMap();
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.hAk = new MMHandler(Looper.getMainLooper());
    com.tencent.mm.kernel.g.azz().a(379, this);
    AppMethodBeat.o(126721);
  }
  
  public static com.tencent.mm.i.h Oe(String paramString)
  {
    AppMethodBeat.i(126737);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126737);
      return null;
    }
    com.tencent.mm.modelvideo.s locals = u.QN(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject1 = XmlParser.parseXml(locals.bhv(), "msg", null);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    int j = Util.getInt((String)((Map)localObject1).get(".msg.videomsg.$length"), 0);
    String str1 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
    String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
    String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
    String str4 = c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
    if (Util.isNullOrNil(str4))
    {
      Log.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
      AppMethodBeat.o(126737);
      return null;
    }
    o.bhj();
    String str5 = com.tencent.mm.modelvideo.t.Qw(paramString);
    localObject1 = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject1).taskName = "task_OnlineVideoService_1";
    ((com.tencent.mm.i.h)localObject1).filename = paramString;
    ((com.tencent.mm.i.h)localObject1).gqS = str1;
    ((com.tencent.mm.i.h)localObject1).gqT = j;
    ((com.tencent.mm.i.h)localObject1).gqU = 1;
    ((com.tencent.mm.i.h)localObject1).dRL = locals.bhs();
    ((com.tencent.mm.i.h)localObject1).gqV = locals.getUser();
    if (ab.Eq(locals.getUser()))
    {
      i = v.Ie(locals.getUser());
      ((com.tencent.mm.i.h)localObject1).dRN = i;
      ((com.tencent.mm.i.h)localObject1).field_mediaId = str4;
      ((com.tencent.mm.i.h)localObject1).field_fullpath = str5;
      ((com.tencent.mm.i.h)localObject1).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      ((com.tencent.mm.i.h)localObject1).field_totalLen = j;
      ((com.tencent.mm.i.h)localObject1).field_aesKey = str2;
      ((com.tencent.mm.i.h)localObject1).field_fileId = ((String)localObject2);
      ((com.tencent.mm.i.h)localObject1).field_priority = com.tencent.mm.i.a.gpM;
      ((com.tencent.mm.i.h)localObject1).field_wxmsgparam = str3;
      if (!ab.Eq(locals.getUser())) {
        break label525;
      }
      i = 1;
      label375:
      ((com.tencent.mm.i.h)localObject1).field_chattype = i;
      ((com.tencent.mm.i.h)localObject1).gqW = locals.gqW;
      paramString = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(locals.getUser(), locals.dTS);
      localObject2 = com.tencent.mm.model.bp.Ky(paramString.fqK);
      ((com.tencent.mm.i.h)localObject1).gqz = 0;
      ((com.tencent.mm.i.h)localObject1).gqA = 0;
      ((com.tencent.mm.i.h)localObject1).gqY = paramString.field_createTime;
      ((com.tencent.mm.i.h)localObject1).dTS = paramString.field_msgSvrId;
      if (localObject2 == null) {
        break label530;
      }
    }
    label525:
    label530:
    for (int i = ((bp.b)localObject2).iEG;; i = 0)
    {
      ((com.tencent.mm.i.h)localObject1).gqZ = i;
      if (((com.tencent.mm.i.h)localObject1).gqz > 0) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 36L, 1L, false);
      }
      ((com.tencent.mm.i.h)localObject1).field_autostart = false;
      ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.e.a(1, locals);
      AppMethodBeat.o(126737);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label375;
    }
  }
  
  public static com.tencent.mm.i.h a(com.tencent.mm.storage.bp parambp, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(240836);
    if (parambp == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(240836);
      return null;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(240836);
      return null;
    }
    Object localObject = u.QN(paramString3);
    if (localObject == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(240836);
      return null;
    }
    String str1 = c.a("snsvideo", parambp.hXs, "sns", paramString1);
    if (Util.isNullOrNil(str1))
    {
      Log.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(240836);
      return null;
    }
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.taskName = "task_OnlineVideoService_2";
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str1;
    localh.gqP = 2;
    localh.gqU = paramInt;
    localh.gqW = ((com.tencent.mm.modelvideo.s)localObject).gqW;
    if (parambp == null) {
      paramString3 = "";
    }
    for (;;)
    {
      str1 = "https://" + WeChatHosts.domainString(2131761749) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
      int i = com.tencent.mm.protocal.d.KyO;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAf();
      String str2 = p.getString(com.tencent.mm.kernel.a.getUin());
      int j = NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext());
      int k = NetStatusUtil.getStrength(MMApplicationContext.getContext());
      label286:
      long l1;
      boolean bool;
      if (!Util.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format(str1, new Object[] { Integer.valueOf(i), str2, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        Log.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { localObject, Long.valueOf(l2), Integer.valueOf(parambp.hXs) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a(parambp, localh.url, l1, (String)localObject);
      }
      for (;;)
      {
        try
        {
          localh.host = new URL(localh.url).getHost();
          localObject = new ArrayList();
          com.tencent.mm.network.d.b(bool, (List)localObject, localh.host);
          localh.gqr = new String[((List)localObject).size()];
          ((List)localObject).toArray(localh.gqr);
          if (Util.secondsToNow(parambp.hXs) <= l1) {
            break label817;
          }
          bool = true;
          localh.isColdSnsData = bool;
          localh.signalQuality = NetStatusUtil.getStrength(MMApplicationContext.getContext());
          localh.snsScene = paramString3;
          localh.concurrentCount = 5;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOj, false))
          {
            if (!paramBoolean) {
              break label823;
            }
            localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.j(paramInt, paramString2, paramString1);
          }
          AppMethodBeat.o(240836);
          return localh;
        }
        catch (Exception parambp)
        {
          Log.printErrStackTrace("MicroMsg.OnlineVideoService", parambp, "check can sns online video error taskInfo %s", new Object[] { localh });
          AppMethodBeat.o(240836);
          return null;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oqm))
        {
          paramString3 = "album_friend";
          break;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oqn))
        {
          paramString3 = "album_self";
          break;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oqo))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oqp))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oqq))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oqr))
        {
          paramString3 = "comment";
          break;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oql))
        {
          paramString3 = "timeline";
          break;
        }
        if (parambp.equals(com.tencent.mm.storage.bp.Oqu))
        {
          paramString3 = "snssight";
          break;
        }
        if (!parambp.equals(com.tencent.mm.storage.bp.Oqw)) {
          break label837;
        }
        paramString3 = "storysight";
        break;
        localObject = "";
        break label286;
        label817:
        bool = false;
        continue;
        label823:
        localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.K(paramInt, paramString2);
      }
      label837:
      paramString3 = "";
    }
  }
  
  static void a(com.tencent.mm.modelvideo.s params, int paramInt, String paramString)
  {
    AppMethodBeat.i(126735);
    Log.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (params != null)
    {
      u.ay(params.getFileName(), paramInt);
      i(paramInt, paramString, params.getFileName());
    }
    AppMethodBeat.o(126735);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(126743);
    int j = 0;
    paramString = u.QN(paramString);
    if (paramString != null) {
      j = paramString.dRQ;
    }
    for (int k = paramString.iKP;; k = 0)
    {
      if (paramInt <= 0)
      {
        i = 1;
        paramPInt1.value = j;
        paramPInt2.value = i;
        Log.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(126743);
        return;
      }
      int m = (int)(paramInt / 100.0F * k);
      if (j < m) {}
      for (int i = 2;; i = 3)
      {
        Log.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
        break;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(126744);
    mk localmk = new mk();
    localmk.dRK.dRL = paramString1;
    localmk.dRK.dRM = paramString2;
    localmk.dRK.dRN = paramInt1;
    localmk.dRK.fileId = paramString3;
    localmk.dRK.netType = paramInt2;
    localmk.dRK.startTime = paramLong1;
    localmk.dRK.endTime = paramLong2;
    localmk.dRK.path = paramString4;
    localmk.dRK.dRO = paramArrayOfString;
    localmk.dRK.dRP = paramString5;
    localmk.dRK.dRQ = paramInt3;
    localmk.dRK.dRR = paramInt4;
    localmk.dRK.dRS = paramString6;
    EventCenter.instance.publish(localmk);
    AppMethodBeat.o(126744);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.i.d paramd, com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126742);
    if ((paramh == null) || (paramd == null))
    {
      Log.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(126742);
      return;
    }
    if ((!paramh.alO()) && (!paramh.alQ()) && (!paramh.alS()))
    {
      AppMethodBeat.o(126742);
      return;
    }
    String str2 = paramd.field_clientIP;
    int i4;
    label146:
    label167:
    boolean bool1;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    int i15;
    int i16;
    int i6;
    int i5;
    int i2;
    int j;
    int i3;
    int m;
    int i;
    int n;
    int i1;
    if (paramd.field_isCrossNet)
    {
      i4 = 1;
      Log.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str2, Integer.valueOf(i4) });
      if (paramd.field_videoFormat == 2) {
        u.QQ(paramh.filename);
      }
      if (!Util.isNullOrNil(str2)) {
        break label1526;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1543;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 47L, 1L, false);
      bool1 = paramh.alQ();
      bool2 = paramh.alS();
      localObject1 = new PInt();
      localObject2 = new PInt();
      ((PInt)localObject2).value = 0;
      ((PInt)localObject1).value = 0;
      u.a(paramh.field_fullpath, (PInt)localObject1, (PInt)localObject2);
      i15 = ((PInt)localObject1).value * 1000;
      i16 = ((PInt)localObject2).value;
      i6 = 0;
      i5 = 0;
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 6)) {
        break label2802;
      }
      i2 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      j = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      m = ((Integer)paramArrayOfObject[3]).intValue();
      i = ((Integer)paramArrayOfObject[4]).intValue();
      n = ((Integer)paramArrayOfObject[5]).intValue();
      i1 = ((Integer)paramArrayOfObject[6]).intValue();
      if ((bool2) || (bool1) || (paramArrayOfObject.length <= 10)) {
        break label2794;
      }
      i6 = ((Integer)paramArrayOfObject[7]).intValue();
      localObject1 = (String)paramArrayOfObject[8];
      i5 = ((Long)paramArrayOfObject[9]).intValue();
    }
    for (;;)
    {
      int i7 = paramh.gqW;
      int k = i7;
      label412:
      int i17;
      String str1;
      PInt localPInt2;
      StringBuffer localStringBuffer;
      if (i7 <= 0)
      {
        if (bool1) {
          k = 10;
        }
      }
      else
      {
        i17 = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
        str1 = paramd.alM();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.gqZ);
        localStringBuffer = new StringBuffer();
        if (!bool1) {
          break label1567;
        }
        localStringBuffer.append(paramh.field_fileId).append(",").append(paramh.field_aesKey).append(",");
        label502:
        localStringBuffer.append(paramd.field_fileLength).append(",").append(i15).append(",");
        localStringBuffer.append(paramd.field_recvedBytes).append(",");
        localStringBuffer.append(i2 + ",").append(j + ",").append(i3 + ",");
        localStringBuffer.append(m + ",").append(i + ",");
        localStringBuffer.append(i17).append(",");
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_startTime).append(",");
        localStringBuffer.append(paramd.field_endTime).append(",");
        if (!bool1) {
          break label1614;
        }
        if (paramh.gqV == null) {
          break label1599;
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.gqV.getBytes());
        label755:
        localStringBuffer.append(localObject2).append(",");
        if (!ab.Eq(paramh.gqV)) {
          break label1608;
        }
        k = 1;
        label782:
        localStringBuffer.append(k).append(",");
        label796:
        localStringBuffer.append(paramd.field_retCode).append(",");
        localStringBuffer.append(paramd.field_enQueueTime).append(",");
        localStringBuffer.append(paramd.field_firstRequestCost).append(",");
        localStringBuffer.append(paramd.field_firstRequestSize).append(",");
        localStringBuffer.append(paramd.field_firstRequestDownloadSize).append(",");
        if (!paramd.field_firstRequestCompleted) {
          break label1646;
        }
        k = 1;
        label886:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_averageSpeed).append(",");
        localStringBuffer.append(paramd.field_averageConnectCost).append(",");
        localStringBuffer.append(paramd.field_firstConnectCost).append(",");
        localStringBuffer.append(paramd.field_netConnectTimes).append(",");
        localStringBuffer.append(paramd.field_moovRequestTimes).append(",");
        localStringBuffer.append(paramd.field_moovCost).append(",");
        localStringBuffer.append(paramd.field_moovSize).append(",");
        if (!paramd.field_moovCompleted) {
          break label1652;
        }
        k = 1;
        label1022:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_moovFailReason).append(",");
        localStringBuffer.append(n).append(",");
        localStringBuffer.append(i1).append(",");
        if (!bool1) {
          break label1658;
        }
        localStringBuffer.append(i16).append(",");
        localStringBuffer.append(str1).append(",");
        if (!bool1) {
          break label1717;
        }
        localStringBuffer.append(paramh.gqY).append(",");
        localStringBuffer.append(paramh.dTS).append(",");
        localStringBuffer.append(paramh.gqz).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1182:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.gra).append(",");
        localStringBuffer.append(localPInt1.value).append(",");
        localStringBuffer.append(localPInt2.value).append(",");
        localStringBuffer.append(paramd.transportProtocol).append(",");
        localStringBuffer.append(paramd.transportProtocolError);
        if (!bool1) {
          break label1739;
        }
        k = 13570;
        label1296:
        if (bool2) {
          k = 13570;
        }
        localObject2 = localStringBuffer.toString();
        Log.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(k), localObject2 });
        if (!bool1) {
          break label1747;
        }
        new gp((String)localObject2).bfK();
        label1356:
        if (paramBoolean) {
          a(paramh.dRL, paramh.gqV, paramh.dRN, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.dRS);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label2777;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = u.QN(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramArrayOfObject.jso);
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
        }
        AppMethodBeat.o(126742);
        return;
        i4 = 0;
        break;
        label1526:
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 46L, 1L, false);
        break label146;
        label1543:
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 48L, 1L, false);
        break label167;
        k = 31;
        break label412;
        label1567:
        localStringBuffer.append(paramh.url).append(",").append(paramh.gqX).append(",");
        break label502;
        label1599:
        localObject2 = Integer.valueOf(0);
        break label755;
        label1608:
        k = 0;
        break label782;
        label1614:
        localStringBuffer.append(0).append(",");
        localStringBuffer.append(paramd.field_httpStatusCode).append(",");
        break label796;
        label1646:
        k = 0;
        break label886;
        label1652:
        k = 0;
        break label1022;
        label1658:
        localStringBuffer.append(i16).append(",");
        if (paramh.gqV != null) {}
        for (localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.gqV.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1717:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.aTR(paramh.dRS)).append(",");
        break label1182;
        label1739:
        k = 13790;
        break label1296;
        label1747:
        if (bool2)
        {
          int i9 = 0;
          int i10 = 0;
          localObject2 = "";
          long l2 = 0L;
          int i11 = 0;
          int i12 = 0;
          int i13 = 0;
          int i14 = 0;
          long l1 = l2;
          int i8 = i14;
          i7 = i13;
          i6 = i12;
          i5 = i11;
          localObject1 = localObject2;
          i4 = i10;
          k = i9;
          if (paramArrayOfObject != null)
          {
            l1 = l2;
            i8 = i14;
            i7 = i13;
            i6 = i12;
            i5 = i11;
            localObject1 = localObject2;
            i4 = i10;
            k = i9;
            if (paramArrayOfObject.length >= 11)
            {
              k = Util.getInt(paramArrayOfObject[7].toString(), 0);
              Util.getInt(paramArrayOfObject[8].toString(), 0);
              i4 = Util.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i5 = Util.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = Util.getLong(paramArrayOfObject[13].toString(), 0L);
              i6 = Util.getInt(paramArrayOfObject[14].toString(), 0);
              i7 = Util.getInt(paramArrayOfObject[15].toString(), 0);
              i8 = Util.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new lg();
          localObject1 = paramArrayOfObject.ys((String)localObject1);
          ((lg)localObject1).eXO = i5;
          ((lg)localObject1).eXP = i7;
          ((lg)localObject1).eXQ = i6;
          ((lg)localObject1).eoV = i15;
          ((lg)localObject1).eXR = (i2 / 1000);
          ((lg)localObject1).eKd = j;
          ((lg)localObject1).eKe = i3;
          ((lg)localObject1).eGw = m;
          ((lg)localObject1).eGx = i;
          ((lg)localObject1).eXS = 0L;
          ((lg)localObject1).eKy = n;
          ((lg)localObject1).eXT = i1;
          localObject1 = ((lg)localObject1).yt("");
          ((lg)localObject1).eoW = (i16 * 1000);
          localObject1 = ((lg)localObject1).yu(paramh.field_requestVideoFormat);
          ((lg)localObject1).elK = paramd.field_fileLength;
          ((lg)localObject1).eXW = paramd.field_recvedBytes;
          ((lg)localObject1).eKh = paramd.field_startTime;
          ((lg)localObject1).eKi = paramd.field_endTime;
          ((lg)localObject1).eXX = paramd.field_retCode;
          ((lg)localObject1).eXY = paramd.field_enQueueTime;
          ((lg)localObject1).eXZ = paramd.field_moovRequestTimes;
          ((lg)localObject1).eYa = paramd.field_moovCost;
          ((lg)localObject1).eKv = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            ((lg)localObject1).eYb = l2;
            ((lg)localObject1).eYc = paramd.field_moovFailReason;
            ((lg)localObject1).eYd = paramd.field_firstConnectCost;
            ((lg)localObject1).eYe = paramd.field_firstRequestCost;
            ((lg)localObject1).eYf = paramd.field_firstRequestSize;
            ((lg)localObject1).eYg = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2664;
            }
            l2 = 1L;
            label2287:
            ((lg)localObject1).eYh = l2;
            ((lg)localObject1).eYi = paramd.field_averageSpeed;
            ((lg)localObject1).eYj = paramd.field_averageConnectCost;
            ((lg)localObject1).eKs = paramd.field_netConnectTimes;
            localObject1 = ((lg)localObject1).yv(paramd.alM()).yw(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2670;
            }
          }
          label2664:
          label2670:
          for (l2 = 1L;; l2 = 0L)
          {
            ((lg)localObject1).eYl = l2;
            ((lg)localObject1).eKG = paramh.gra;
            ((lg)localObject1).eYm = i4;
            ((lg)localObject1).elI = i17;
            ((lg)localObject1).eYn = l1;
            ((lg)localObject1).epd = k;
            ((lg)localObject1).eYo = i8;
            ((lg)localObject1).eKH = paramd.transportProtocol;
            ((lg)localObject1).eKI = paramd.transportProtocolError;
            ((lg)localObject1).eKJ = paramd.traceId;
            Log.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.eYn) });
            if (System.currentTimeMillis() - paramArrayOfObject.eYn > 500L) {
              paramArrayOfObject.bfK();
            }
            if (!bool2) {
              break;
            }
            paramArrayOfObject = new jh();
            localObject1 = com.tencent.mm.plugin.sight.base.e.aNx(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.eoV = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
              paramArrayOfObject.eoW = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate;
              paramArrayOfObject.eoX = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate;
              paramArrayOfObject.eoY = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
              paramArrayOfObject.eoZ = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
              paramArrayOfObject.epa = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
              paramArrayOfObject.epc = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel;
            }
            paramArrayOfObject.eoU = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.wK(paramh.url);
            f.baR();
            paramArrayOfObject = paramArrayOfObject.wL(a.NX(paramh.field_fullpath));
            paramArrayOfObject.eoS = paramd.field_startTime;
            paramArrayOfObject.eoT = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.wM(str1);
            paramArrayOfObject.epd = k;
            paramArrayOfObject.epe = localPInt2.value;
            paramArrayOfObject.bfK();
            break;
            l2 = 0L;
            break label2220;
            l2 = 0L;
            break label2287;
          }
        }
        label2220:
        paramArrayOfObject = new iq((String)localObject2);
        paramArrayOfObject.ePx = i5;
        paramArrayOfObject.wp((String)localObject1);
        paramArrayOfObject.ePv = i6;
        paramArrayOfObject.eKJ = paramd.traceId;
        Log.d("13790", "report 13790 value: " + paramArrayOfObject.abV());
        Log.d("13790", "trace id  " + (paramd.traceId & 0xFFFFFFFF));
        paramArrayOfObject.bfK();
        break label1356;
        label2777:
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 133L, 1L, false);
      }
      label2794:
      localObject1 = "";
      continue;
      label2802:
      localObject1 = "";
      m = 0;
      i = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      j = 0;
      i3 = 0;
    }
  }
  
  private static boolean a(com.tencent.mm.storage.bp parambp, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(126739);
    if (paramString1 == null)
    {
      AppMethodBeat.o(126739);
      return false;
    }
    try
    {
      paramString1 = new URL(paramString1);
      if (parambp == null)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      if (paramString2 == null)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      int i = paramString2.indexOf(paramString1.getHost());
      if (i == -1)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      i = parambp.hXs;
      if (i == 0)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      long l = Util.secondsToNow(parambp.hXs);
      if (l > paramLong)
      {
        AppMethodBeat.o(126739);
        return true;
      }
      AppMethodBeat.o(126739);
      return false;
    }
    catch (Exception parambp)
    {
      Log.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { parambp.getMessage() });
      AppMethodBeat.o(126739);
    }
    return false;
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126736);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126736);
      return false;
    }
    o.bhj();
    paramString2 = com.tencent.mm.modelvideo.t.Qw(paramString2);
    if ((Util.isNullOrNil(paramString1)) || (paramInt <= 0) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126736);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().P(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126736);
    return bool;
  }
  
  public static int r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126729);
    f.baR();
    int i = a.requestVideoData(paramString, paramInt1, paramInt2, 0);
    Log.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(126729);
    return i;
  }
  
  public static void s(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(126740);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(126740);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(17891, new Object[] { Integer.valueOf(paramArrayOfInt[6]), Integer.valueOf(paramArrayOfInt[8]), Integer.valueOf(paramArrayOfInt[9]), Integer.valueOf(paramArrayOfInt[7]), Integer.valueOf(paramArrayOfInt[10]), Integer.valueOf(paramArrayOfInt[11]), Integer.valueOf(paramArrayOfInt[12]), Integer.valueOf(paramArrayOfInt[13]), Integer.valueOf(paramArrayOfInt[14]), Integer.valueOf(paramArrayOfInt[15]), Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Integer.valueOf(paramArrayOfInt[2]), Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramArrayOfInt[4]), Integer.valueOf(paramArrayOfInt[5]), Integer.valueOf(paramArrayOfInt[16]), Integer.valueOf(paramArrayOfInt[17]), Integer.valueOf(paramArrayOfInt[18]), Integer.valueOf(paramArrayOfInt[19]), Integer.valueOf(paramArrayOfInt[20]), Integer.valueOf(paramArrayOfInt[21]), Integer.valueOf(paramArrayOfInt[22]), Integer.valueOf(paramArrayOfInt[23]), Integer.valueOf(paramArrayOfInt[24]), Integer.valueOf(paramArrayOfInt[25]), Integer.valueOf(paramArrayOfInt[26]), Integer.valueOf(paramArrayOfInt[27]), Integer.valueOf(paramArrayOfInt[28]), Integer.valueOf(paramArrayOfInt[29]), Integer.valueOf(paramArrayOfInt[30]), Integer.valueOf(paramArrayOfInt[31]), Integer.valueOf(paramArrayOfInt[32]), Integer.valueOf(paramArrayOfInt[33]) });
    AppMethodBeat.o(126740);
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(126734);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      AppMethodBeat.o(126734);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      Log.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      AppMethodBeat.o(126734);
      return -2;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169094);
        Object localObject = (com.tencent.mm.i.h)e.this.iRA.get(paramString);
        if (localObject == null)
        {
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).gre != null)
        {
          Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { paramString });
          if (paramc != null)
          {
            ((com.tencent.mm.i.h)localObject).gre.i(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
            AppMethodBeat.o(169094);
            return;
          }
          if (paramd != null)
          {
            Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
            ((com.tencent.mm.i.h)localObject).gre.a(paramString, paramd.field_retCode, paramd);
            e.this.iRA.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              e.this.iSl.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
              e.this.iSm.put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
            }
            AppMethodBeat.o(169094);
            return;
          }
          AppMethodBeat.o(169094);
          return;
        }
        com.tencent.mm.modelvideo.s locals = u.QN(((com.tencent.mm.i.h)localObject).filename);
        if (locals == null)
        {
          Log.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((com.tencent.mm.i.h)localObject).filename });
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).gqy != null)
        {
          ((com.tencent.mm.i.h)localObject).gqy.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.h)localObject).field_onlycheckexist);
          if (paramd != null) {
            e.this.iRA.remove(paramString);
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (paramc != null)
        {
          if (paramc.field_finishedLength == locals.iKP)
          {
            Log.i("MicroMsg.OnlineVideoService", "stream download finish.");
            AppMethodBeat.o(169094);
            return;
          }
          if ((locals.status != 130) && (locals.jsj > paramc.field_finishedLength))
          {
            Log.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(locals.jsj), Long.valueOf(paramc.field_finishedLength) });
            AppMethodBeat.o(169094);
            return;
          }
          Log.i("MicroMsg.OnlineVideoService", "callback progress info " + paramc.field_finishedLength);
          locals.jsm = Util.nowSecond();
          locals.jsj = ((int)paramc.field_finishedLength);
          locals.cSx = 1040;
          u.f(locals);
          localObject = new oq();
          ((oq)localObject).dUF.dKy = 5;
          ((oq)localObject).dUF.mediaId = paramString;
          ((oq)localObject).dUF.offset = ((int)paramc.field_finishedLength);
          ((oq)localObject).dUF.length = ((int)paramc.field_toltalLength);
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(169094);
          return;
        }
        int i;
        int j;
        if (paramd != null)
        {
          Log.i("MicroMsg.OnlineVideoService", "callback result info " + paramd.field_retCode + ", filesize:" + paramd.field_fileLength + ",recved:" + paramd.field_recvedBytes);
          if (paramd.field_retCode == 0) {
            break label1130;
          }
          if (paramd.field_retCode != -10012) {
            u.QE(locals.getFileName());
          }
          boolean bool = ((com.tencent.mm.i.h)localObject).alQ();
          i = paramd.field_retCode;
          j = ((com.tencent.mm.i.h)localObject).gqU;
          if (!bool) {
            break label1039;
          }
          if (j != 1) {
            break label950;
          }
          if (i != -5103059) {
            break label885;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 111L, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(101), Long.valueOf(Util.nowSecond()), Integer.valueOf(i) });
        }
        for (;;)
        {
          localObject = new oq();
          ((oq)localObject).dUF.dKy = 4;
          ((oq)localObject).dUF.mediaId = paramString;
          ((oq)localObject).dUF.offset = 0;
          ((oq)localObject).dUF.retCode = paramd.field_retCode;
          ((oq)localObject).dUF.length = ((int)paramd.field_fileLength);
          EventCenter.instance.publish((IEvent)localObject);
          e.this.iRA.remove(paramString);
          AppMethodBeat.o(169094);
          return;
          label885:
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 112L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 114L, 1L, false);
          break;
          label950:
          if (i == -5103059)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 116L, 1L, false);
            break;
          }
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 117L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 118L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 119L, 1L, false);
          break;
          label1039:
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 213L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 214L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(201), Long.valueOf(Util.nowSecond()), Integer.valueOf(i) });
            break;
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 215L, 1L, false);
          }
          label1130:
          e.a(locals, (int)paramd.field_fileLength, ((com.tencent.mm.i.h)localObject).gqS);
          e.this.iSl.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
          e.this.iSm.put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
        }
      }
    });
    if (this.iRA.get(paramString) != null)
    {
      AppMethodBeat.o(126734);
      return 1;
    }
    AppMethodBeat.o(126734);
    return 0;
  }
  
  public final boolean a(final com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126724);
    if (paramh == null)
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    if (Util.isNullOrNil(paramh.field_mediaId))
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    Log.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId + " delay : " + paramBoolean);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.ehd = false;
    if ((m(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126713);
          e.this.iRy.add(paramh.field_mediaId);
          e.this.iRz.put(paramh.field_mediaId, paramh);
          e.this.fD(false);
          AppMethodBeat.o(126713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126724);
      return true;
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126714);
          e.this.iRy.add(paramh.field_mediaId);
          e.this.iRz.put(paramh.field_mediaId, paramh);
          e.this.fD(false);
          AppMethodBeat.o(126714);
        }
      });
    }
  }
  
  public final boolean a(final String paramString, final e.a parama)
  {
    AppMethodBeat.i(169096);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!Util.isNullOrNil(paramString)) {
      if (!this.iRA.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126718);
          Object localObject1 = (com.tencent.mm.i.h)e.this.iRA.remove(paramString);
          Object localObject2;
          int i;
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.i.d();
            f.baR();
            i = a.c(((com.tencent.mm.i.h)localObject1).field_mediaId, (com.tencent.mm.i.d)localObject2);
            if (i == 0) {
              e.a(this.iSr, (com.tencent.mm.i.d)localObject2, (com.tencent.mm.i.h)localObject1, false);
            }
          }
          for (;;)
          {
            e.this.iRz.remove(paramString);
            if (parama != null) {
              parama.a((com.tencent.mm.i.h)localObject1, (com.tencent.mm.i.d)localObject2);
            }
            AppMethodBeat.o(126718);
            return;
            Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.h)localObject1).field_mediaId });
            continue;
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.iSl.remove(paramString);
            com.tencent.mm.i.d locald = (com.tencent.mm.i.d)e.this.iSm.remove(paramString);
            localObject1 = localh;
            localObject2 = locald;
            if (localh != null)
            {
              localObject1 = localh;
              localObject2 = locald;
              if (locald != null)
              {
                e.a(this.iSr, locald, localh, true);
                localObject1 = localh;
                localObject2 = locald;
              }
            }
          }
        }
      });
      Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskWithCallback mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(169096);
      return bool1;
      label90:
      f.baQ().Oc(paramString);
    }
  }
  
  public final int d(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(240833);
    this.mainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126719);
        Log.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString1 });
        if (Util.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(126719);
          return;
        }
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = true;
            AppMethodBeat.i(169095);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.iRA.get(e.10.this.LY);
            Object localObject = new StringBuilder("info=").append(localh).append(" mediaId=").append(e.10.this.LY).append(" info.videoCallback=");
            if ((localh != null) && (localh.gre == null)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              Log.w("MicroMsg.OnlineVideoService", bool1);
              if (localh == null) {
                break label507;
              }
              localh.gra = e.10.this.iSo;
              if (localh.gre == null) {
                break;
              }
              localh.gre.a(e.10.this.LY, e.10.this.iSo, e.10.this.iSp, e.10.this.iSt);
              AppMethodBeat.o(169095);
              return;
            }
            if (r.Ql(localh.field_fullpath))
            {
              Log.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.gqU);
              if (localh.gqU == 1)
              {
                e.r(localh.field_mediaId, 0, localh.field_totalLen);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 19L, 1L, false);
              }
              AppMethodBeat.o(169095);
              return;
            }
            localObject = new oq();
            ((oq)localObject).dUF.dKy = 1;
            ((oq)localObject).dUF.retCode = 0;
            ((oq)localObject).dUF.mediaId = e.10.this.LY;
            ((oq)localObject).dUF.offset = e.10.this.iSo;
            ((oq)localObject).dUF.length = e.10.this.iSp;
            ((oq)localObject).dUF.dUG = localh.gqR;
            oq.a locala = ((oq)localObject).dUF;
            if (localh.gqz > 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              locala.dUH = bool1;
              EventCenter.instance.publish((IEvent)localObject);
              localObject = u.QN(localh.filename);
              if (localObject == null) {
                break label507;
              }
              Log.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((com.tencent.mm.modelvideo.s)localObject).getFileName() + " status : " + ((com.tencent.mm.modelvideo.s)localObject).status);
              if (((com.tencent.mm.modelvideo.s)localObject).status != 130) {
                break;
              }
              AppMethodBeat.o(169095);
              return;
            }
            if (((com.tencent.mm.modelvideo.s)localObject).status != 122)
            {
              localObject = u.QN(localh.filename);
              if (localObject != null)
              {
                ((com.tencent.mm.modelvideo.s)localObject).status = 121;
                ((com.tencent.mm.modelvideo.s)localObject).cSx = 256;
                o.bhj().c((com.tencent.mm.modelvideo.s)localObject);
              }
              if (localh.gqU == 0)
              {
                Log.i("MicroMsg.OnlineVideoService", "stop download video");
                o.bho().bhG();
                o.bho().run();
              }
            }
            label507:
            AppMethodBeat.o(169095);
          }
        });
        AppMethodBeat.o(126719);
      }
    });
    if (this.iRA.containsKey(paramString1))
    {
      AppMethodBeat.o(240833);
      return 1;
    }
    AppMethodBeat.o(240833);
    return 0;
  }
  
  public final boolean e(final com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(126725);
    if (paramh == null)
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    if (Util.isNullOrNil(paramh.field_mediaId))
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    Log.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.ehd = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126715);
          e.this.hAk.removeCallbacksAndMessages(paramh.field_mediaId);
          e.this.iRy.add(paramh.field_mediaId);
          e.this.iRz.put(paramh.field_mediaId, paramh);
          e.this.fD(false);
          AppMethodBeat.o(126715);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126725);
      return true;
      this.hAk.removeCallbacksAndMessages(paramh.field_mediaId);
      this.iRy.add(paramh.field_mediaId);
      this.iRz.put(paramh.field_mediaId, paramh);
      fD(false);
    }
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(126730);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      AppMethodBeat.o(126730);
      return;
    }
    if ((!paramBoolean) && (f.baR().baH()))
    {
      com.tencent.mm.kernel.g.aAf();
      if (com.tencent.mm.kernel.a.azo())
      {
        Log.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        f.baQ().fD(paramBoolean);
        AppMethodBeat.o(126730);
        return;
      }
    }
    f.baQ().baI();
    while (!this.iRy.isEmpty())
    {
      Object localObject2 = (String)this.iRy.poll();
      Object localObject1 = (com.tencent.mm.i.h)this.iRz.remove(localObject2);
      if (localObject1 != null)
      {
        ((com.tencent.mm.i.h)localObject1).field_startTime = Util.nowMilliSecond();
        if (!((com.tencent.mm.i.h)localObject1).ehd)
        {
          if (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYD, Integer.valueOf(-1))).intValue() == 2) {
            Log.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          Object localObject3;
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label410;
            }
            localObject1 = new oq();
            ((oq)localObject1).dUF.dKy = 6;
            ((oq)localObject1).dUF.mediaId = ((String)localObject2);
            EventCenter.instance.publish((IEvent)localObject1);
            break;
            if (((com.tencent.mm.i.h)localObject1).alR()) {
              break label167;
            }
            localObject3 = ((com.tencent.mm.i.h)localObject1).gqS;
            i = ((com.tencent.mm.i.h)localObject1).gqT;
            Object localObject4 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().gS((String)localObject3, i);
            j = i - (int)com.tencent.mm.vfs.s.boW((String)localObject4);
            if ((Util.isNullOrNil((String)localObject4)) || (j < 0) || (j > 16)) {
              break label167;
            }
            Log.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject3, localObject4 });
            com.tencent.mm.vfs.s.nw((String)localObject4, ((com.tencent.mm.i.h)localObject1).field_fullpath);
            localObject4 = u.QN(((com.tencent.mm.i.h)localObject1).filename);
            a((com.tencent.mm.modelvideo.s)localObject4, i, (String)localObject3);
            localObject3 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(((com.tencent.mm.modelvideo.s)localObject4).jso);
            ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(new i.c(((eo)localObject3).field_talker, "update", (ca)localObject3));
          }
          label410:
          if (((com.tencent.mm.i.h)localObject1).alQ())
          {
            i = f.baR().a((com.tencent.mm.i.g)localObject1, ((com.tencent.mm.i.h)localObject1).gqU);
            label432:
            Log.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject1, Integer.valueOf(i) });
            if (i == 0) {
              break label1042;
            }
            Log.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((com.tencent.mm.i.h)localObject1).field_mediaId);
            paramBoolean = ((com.tencent.mm.i.h)localObject1).alQ();
            j = ((com.tencent.mm.i.h)localObject1).gqU;
            if (!paramBoolean) {
              break label952;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label887;
            }
            if (i != -21006) {
              break label846;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(100), Long.valueOf(Util.nowSecond()), "" });
            break;
            if (((com.tencent.mm.i.h)localObject1).alO())
            {
              ((com.tencent.mm.i.h)localObject1).connectionCount = 2;
              i = f.baR().a((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject1).alS())
            {
              ((com.tencent.mm.i.h)localObject1).connectionCount = 4;
              i = f.baR().b((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject1).alT())
            {
              i = f.baR().c((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject1).alP())
            {
              i = f.baR().d((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            localObject2 = f.baR();
            localObject3 = new CdnLogic.C2CDownloadRequest();
            ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = ((com.tencent.mm.i.h)localObject1).field_mediaId;
            ((CdnLogic.C2CDownloadRequest)localObject3).url = ((com.tencent.mm.i.h)localObject1).url;
            ((CdnLogic.C2CDownloadRequest)localObject3).referer = ((com.tencent.mm.i.h)localObject1).referer;
            ((CdnLogic.C2CDownloadRequest)localObject3).setSavePath(((com.tencent.mm.i.h)localObject1).field_fullpath);
            ((CdnLogic.C2CDownloadRequest)localObject3).fileSize = 0;
            ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 20210;
            ((CdnLogic.C2CDownloadRequest)localObject3).concurrentCount = 10;
            ((CdnLogic.C2CDownloadRequest)localObject3).preloadRatio = ((com.tencent.mm.i.h)localObject1).field_preloadRatio;
            ((CdnLogic.C2CDownloadRequest)localObject3).preloadMinSize = ((com.tencent.mm.i.h)localObject1).preloadMinSize;
            if ((ac.jOV) && (ac.jPa.length() > 0))
            {
              ((CdnLogic.C2CDownloadRequest)localObject3).debugIP = ac.jPa;
              Log.w("MicroMsg.CdnTransportEngine", "debugip " + ((CdnLogic.C2CDownloadRequest)localObject3).debugIP);
            }
            i = CdnLogic.startHttpVideoStreamingDownload((CdnLogic.C2CDownloadRequest)localObject3, (CdnLogic.VideoStreamingCallback)localObject2, (CdnLogic.DownloadCallback)localObject2, ((com.tencent.mm.i.h)localObject1).gqU);
            break label432;
            label846:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 102L, 1L, false);
              continue;
              label887:
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label952:
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(13836, new Object[] { Integer.valueOf(200), Long.valueOf(Util.nowSecond()), "" });
            break;
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 212L, 1L, false);
          }
          label1042:
          ((com.tencent.mm.i.h)localObject1).gqR = Util.nowMilliSecond();
          if (((com.tencent.mm.i.h)localObject1).alQ())
          {
            localObject2 = u.QN(((com.tencent.mm.i.h)localObject1).filename);
            if (localObject2 != null)
            {
              i = ((com.tencent.mm.modelvideo.s)localObject2).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((com.tencent.mm.modelvideo.s)localObject2).status = 120;
                ((com.tencent.mm.modelvideo.s)localObject2).cSx = 256;
                o.bhj().c((com.tencent.mm.modelvideo.s)localObject2);
              }
            }
          }
          this.iRA.put(((com.tencent.mm.i.h)localObject1).field_mediaId, localObject1);
        }
      }
    }
    AppMethodBeat.o(126730);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126728);
    if ((com.tencent.mm.i.h)this.iRA.get(paramString) == null)
    {
      Log.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(126728);
      return false;
    }
    f.baR();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    Log.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(126728);
    return bool;
  }
  
  public final boolean l(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126726);
    boolean bool;
    if (!Util.isNullOrNil(paramString)) {
      if (this.iRA.containsKey(paramString))
      {
        bool = true;
        if ((!bool) || (Looper.myLooper() == Looper.getMainLooper())) {
          break label121;
        }
        this.hAk.postAtTime(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126716);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.iRA.remove(paramString);
            com.tencent.mm.i.d locald;
            int i;
            if (localh != null)
            {
              locald = new com.tencent.mm.i.d();
              f.baR();
              i = a.c(localh.field_mediaId, locald);
              if (i == 0) {
                e.a(paramArrayOfObject, locald, localh, false);
              }
            }
            for (;;)
            {
              e.this.iRz.remove(paramString);
              AppMethodBeat.o(126716);
              return;
              Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
              continue;
              localh = (com.tencent.mm.i.h)e.this.iSl.remove(paramString);
              locald = (com.tencent.mm.i.d)e.this.iSm.remove(paramString);
              if ((localh != null) && (locald != null)) {
                e.a(paramArrayOfObject, locald, localh, true);
              }
            }
          }
        }, paramString, SystemClock.uptimeMillis());
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + paramString + " remove : " + bool);
      AppMethodBeat.o(126726);
      return bool;
      f.baQ().Oc(paramString);
      bool = false;
      break;
      label121:
      this.hAk.removeCallbacksAndMessages(paramString);
      com.tencent.mm.i.h localh = (com.tencent.mm.i.h)this.iRA.remove(paramString);
      com.tencent.mm.i.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.i.d();
        f.baR();
        i = a.c(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.iRz.remove(paramString);
        break;
        Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (com.tencent.mm.i.h)this.iSl.remove(paramString);
        locald = (com.tencent.mm.i.d)this.iSm.remove(paramString);
        if ((localh != null) && (locald != null)) {
          a(paramArrayOfObject, locald, localh, true);
        }
      }
      bool = false;
    }
  }
  
  public final boolean m(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126727);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!Util.isNullOrNil(paramString)) {
      if (!this.iRA.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126717);
          com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.iRA.remove(paramString);
          com.tencent.mm.i.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.i.d();
            f.baR();
            i = a.c(localh.field_mediaId, locald);
            if (i == 0) {
              e.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            e.this.iRz.remove(paramString);
            AppMethodBeat.o(126717);
            return;
            Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (com.tencent.mm.i.h)e.this.iSl.remove(paramString);
            locald = (com.tencent.mm.i.d)e.this.iSm.remove(paramString);
            if ((localh != null) && (locald != null)) {
              e.a(paramArrayOfObject, locald, localh, true);
            }
          }
        }
      });
      Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(126727);
      return bool1;
      label90:
      f.baQ().Oc(paramString);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(126723);
    if (paramq.getType() != 379)
    {
      AppMethodBeat.o(126723);
      return;
    }
    Log.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.aAf().azp()) {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126711);
          e.this.fD(true);
          AppMethodBeat.o(126711);
        }
      });
    }
    AppMethodBeat.o(126723);
  }
  
  public final int p(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(240834);
    Log.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(240834);
      return 0;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126720);
        Object localObject = (com.tencent.mm.i.h)e.this.iRA.get(paramString);
        if (localObject != null)
        {
          if (((com.tencent.mm.i.h)localObject).gre != null) {
            ((com.tencent.mm.i.h)localObject).gre.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new oq();
          ((oq)localObject).dUF.dKy = 2;
          ((oq)localObject).dUF.retCode = 0;
          ((oq)localObject).dUF.mediaId = paramString;
          ((oq)localObject).dUF.offset = paramInt1;
          ((oq)localObject).dUF.length = paramInt2;
          EventCenter.instance.publish((IEvent)localObject);
        }
        AppMethodBeat.o(126720);
      }
    });
    if (this.iRA.containsKey(paramString))
    {
      AppMethodBeat.o(240834);
      return 1;
    }
    AppMethodBeat.o(240834);
    return 0;
  }
  
  public final int q(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(240835);
    Log.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(240835);
      return 0;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126712);
        com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.iRA.get(paramString);
        if (localh != null)
        {
          oq localoq = new oq();
          localoq.dUF.dKy = 3;
          localoq.dUF.retCode = 0;
          localoq.dUF.mediaId = paramString;
          localoq.dUF.offset = paramInt1;
          localoq.dUF.length = paramInt2;
          EventCenter.instance.publish(localoq);
          if ((paramInt1 == 0) && (paramInt2 >= localh.gqT)) {
            e.a(u.QN(localh.filename), localh.gqT, localh.gqS);
          }
        }
        AppMethodBeat.o(126712);
      }
    });
    if (this.iRA.containsKey(paramString))
    {
      AppMethodBeat.o(240835);
      return 1;
    }
    AppMethodBeat.o(240835);
    return 0;
  }
  
  public final void release()
  {
    AppMethodBeat.i(126722);
    com.tencent.mm.kernel.g.azz().b(379, this);
    AppMethodBeat.o(126722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.an.e
 * JD-Core Version:    0.7.0.1
 */