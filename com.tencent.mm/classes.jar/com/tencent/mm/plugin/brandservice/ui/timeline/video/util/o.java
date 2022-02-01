package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoPreviewReport;", "", "()V", "TAG", "", "absolutePosition", "", "getAbsolutePosition", "()I", "setAbsolutePosition", "(I)V", "autoPlayId", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "bizUin", "", "getBizUin", "()J", "setBizUin", "(J)V", "bufferDuration", "getBufferDuration", "setBufferDuration", "eventType", "getEventType", "setEventType", "idx", "getIdx", "setIdx", "msgId", "getMsgId", "setMsgId", "playDuration", "getPlayDuration", "setPlayDuration", "sessionId", "getSessionId", "setSessionId", "vid", "getVid", "setVid", "videoDuration", "getVideoDuration", "setVideoDuration", "buildUrl", "", "url", "report", "EVENT", "plugin-brandservice_release"})
public final class o
{
  private static int dEb;
  private static int dRq;
  private static int idx;
  private static long msgId;
  private static String pJD;
  private static long pLO;
  private static int pLP;
  private static long pLQ;
  private static long pLR;
  public static final o pLS;
  private static long playDuration;
  private static String vid;
  
  static
  {
    AppMethodBeat.i(195991);
    pLS = new o();
    vid = "";
    pJD = "";
    AppMethodBeat.o(195991);
  }
  
  public static void BO(long paramLong)
  {
    playDuration = paramLong;
  }
  
  public static void BP(long paramLong)
  {
    pLQ = paramLong;
  }
  
  public static void BQ(long paramLong)
  {
    pLR = paramLong;
  }
  
  public static void DT(int paramInt)
  {
    pLP = paramInt;
  }
  
  public static void DU(int paramInt)
  {
    dEb = paramInt;
  }
  
  public static void aiU(String paramString)
  {
    pJD = paramString;
  }
  
  public static void aiV(String paramString)
  {
    AppMethodBeat.i(195989);
    pLO = 0L;
    idx = 0;
    msgId = 0L;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195989);
      return;
    }
    try
    {
      paramString = Uri.parse(paramString);
      Object localObject = paramString.getQueryParameter("__biz");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode((String)localObject, 0);
        p.g(localObject, "byte");
        pLO = Util.getLong(new String((byte[])localObject, d.UTF_8), 0L);
      }
      idx = Util.getInt(paramString.getQueryParameter("idx"), 0);
      msgId = Util.getLong(paramString.getQueryParameter("mid"), 0L);
      AppMethodBeat.o(195989);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(195989);
    }
  }
  
  public static long crc()
  {
    return playDuration;
  }
  
  public static void report()
  {
    int i = 2;
    AppMethodBeat.i(195990);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(pLO);
      localStringBuilder.append(",");
      localStringBuilder.append(vid);
      localStringBuilder.append(",");
      localStringBuilder.append(msgId);
      localStringBuilder.append(",");
      localStringBuilder.append(idx);
      localStringBuilder.append(",");
      localStringBuilder.append(pLP);
      localStringBuilder.append(",");
      localStringBuilder.append(dEb);
      localStringBuilder.append(",");
      localStringBuilder.append(pJD);
      localStringBuilder.append(",");
      localStringBuilder.append(dRq);
      localStringBuilder.append(",");
      localStringBuilder.append(playDuration);
      localStringBuilder.append(",");
      localStringBuilder.append(pLQ);
      localStringBuilder.append(",");
      localStringBuilder.append(pLR);
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localh.kvStat(21001, localStringBuilder.toString());
      AppMethodBeat.o(195990);
      return;
      if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        i = 5;
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        i = 4;
      } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        i = 3;
      } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
        i = 6;
      } else if (com.tencent.mm.plugin.topstory.a.h.isFreeSimCard()) {
        i = 1;
      }
    }
  }
  
  public static void setEventType(int paramInt)
  {
    dRq = paramInt;
  }
  
  public static void setVid(String paramString)
  {
    vid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o
 * JD-Core Version:    0.7.0.1
 */