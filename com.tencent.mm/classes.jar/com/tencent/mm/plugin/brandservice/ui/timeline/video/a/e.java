package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoPreviewReport;", "", "()V", "TAG", "", "absolutePosition", "", "getAbsolutePosition", "()I", "setAbsolutePosition", "(I)V", "autoPlayId", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "bizUin", "", "getBizUin", "()J", "setBizUin", "(J)V", "bufferDuration", "getBufferDuration", "setBufferDuration", "eventType", "getEventType", "setEventType", "idx", "getIdx", "setIdx", "msgId", "getMsgId", "setMsgId", "playDuration", "getPlayDuration", "setPlayDuration", "sessionId", "getSessionId", "setSessionId", "vid", "getVid", "setVid", "videoDuration", "getVideoDuration", "setVideoDuration", "buildUrl", "", "url", "report", "EVENT", "plugin-brandservice_release"})
public final class e
{
  private static int fKG;
  private static int fwM;
  private static int idx;
  private static long msgId;
  private static long playDuration;
  private static String sSr;
  private static long sTe;
  private static int sTf;
  private static long sTg;
  private static long sTh;
  public static final e sTi;
  private static String vid;
  
  static
  {
    AppMethodBeat.i(266484);
    sTi = new e();
    vid = "";
    sSr = "";
    AppMethodBeat.o(266484);
  }
  
  public static void HX(long paramLong)
  {
    playDuration = paramLong;
  }
  
  public static void HY(long paramLong)
  {
    sTg = paramLong;
  }
  
  public static void HZ(long paramLong)
  {
    sTh = paramLong;
  }
  
  public static void Hs(int paramInt)
  {
    sTf = paramInt;
  }
  
  public static void Ht(int paramInt)
  {
    fwM = paramInt;
  }
  
  public static void Hu(int paramInt)
  {
    fKG = paramInt;
  }
  
  public static void aqD(String paramString)
  {
    sSr = paramString;
  }
  
  public static void aqE(String paramString)
  {
    AppMethodBeat.i(266481);
    sTe = 0L;
    idx = 0;
    msgId = 0L;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(266481);
      return;
    }
    try
    {
      paramString = Uri.parse(paramString);
      Object localObject = paramString.getQueryParameter("__biz");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode((String)localObject, 0);
        p.j(localObject, "byte");
        sTe = Util.getLong(new String((byte[])localObject, d.UTF_8), 0L);
      }
      idx = Util.getInt(paramString.getQueryParameter("idx"), 0);
      msgId = Util.getLong(paramString.getQueryParameter("mid"), 0L);
      AppMethodBeat.o(266481);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(266481);
    }
  }
  
  public static long cEl()
  {
    return playDuration;
  }
  
  public static void report()
  {
    int i = 2;
    AppMethodBeat.i(266482);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(sTe);
      localStringBuilder.append(",");
      localStringBuilder.append(vid);
      localStringBuilder.append(",");
      localStringBuilder.append(msgId);
      localStringBuilder.append(",");
      localStringBuilder.append(idx);
      localStringBuilder.append(",");
      localStringBuilder.append(sTf);
      localStringBuilder.append(",");
      localStringBuilder.append(fwM);
      localStringBuilder.append(",");
      localStringBuilder.append(sSr);
      localStringBuilder.append(",");
      localStringBuilder.append(fKG);
      localStringBuilder.append(",");
      localStringBuilder.append(playDuration);
      localStringBuilder.append(",");
      localStringBuilder.append(sTg);
      localStringBuilder.append(",");
      localStringBuilder.append(sTh);
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localh.kvStat(21001, localStringBuilder.toString());
      AppMethodBeat.o(266482);
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
  
  public static void setVid(String paramString)
  {
    vid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e
 * JD-Core Version:    0.7.0.1
 */