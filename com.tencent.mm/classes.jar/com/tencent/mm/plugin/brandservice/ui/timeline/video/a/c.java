package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoPreviewReport;", "", "()V", "TAG", "", "absolutePosition", "", "getAbsolutePosition", "()I", "setAbsolutePosition", "(I)V", "autoPlayId", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "bizUin", "", "getBizUin", "()J", "setBizUin", "(J)V", "bufferDuration", "getBufferDuration", "setBufferDuration", "eventType", "getEventType", "setEventType", "idx", "getIdx", "setIdx", "msgId", "getMsgId", "setMsgId", "playDuration", "getPlayDuration", "setPlayDuration", "sessionId", "getSessionId", "setSessionId", "vid", "getVid", "setVid", "videoDuration", "getVideoDuration", "setVideoDuration", "buildUrl", "", "url", "report", "EVENT", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static int hBm;
  private static int hQm;
  private static int idx;
  private static long msgId;
  private static long playDuration;
  private static String vXM;
  public static final c vYt;
  private static long vYu;
  private static int vYv;
  private static long vYw;
  private static long vYx;
  private static String vid;
  
  static
  {
    AppMethodBeat.i(302115);
    vYt = new c();
    vid = "";
    vXM = "";
    AppMethodBeat.o(302115);
  }
  
  public static void HU(int paramInt)
  {
    vYv = paramInt;
  }
  
  public static void HV(int paramInt)
  {
    hBm = paramInt;
  }
  
  public static void HW(int paramInt)
  {
    hQm = paramInt;
  }
  
  public static void akc(String paramString)
  {
    vXM = paramString;
  }
  
  public static void akd(String paramString)
  {
    AppMethodBeat.i(302100);
    vYu = 0L;
    idx = 0;
    msgId = 0L;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(302100);
      return;
    }
    try
    {
      paramString = Uri.parse(paramString);
      Object localObject = paramString.getQueryParameter("__biz");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode((String)localObject, 0);
        s.s(localObject, "byte");
        vYu = Util.getLong(new String((byte[])localObject, d.UTF_8), 0L);
      }
      idx = Util.getInt(paramString.getQueryParameter("idx"), 0);
      msgId = Util.getLong(paramString.getQueryParameter("mid"), 0L);
      AppMethodBeat.o(302100);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(302100);
    }
  }
  
  public static long dhN()
  {
    return playDuration;
  }
  
  public static void kp(long paramLong)
  {
    playDuration = paramLong;
  }
  
  public static void kq(long paramLong)
  {
    vYw = paramLong;
  }
  
  public static void kr(long paramLong)
  {
    vYx = paramLong;
  }
  
  public static void report()
  {
    int i = 2;
    AppMethodBeat.i(302110);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (;;)
    {
      h localh = h.OAn;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(vYu);
      localStringBuilder.append(",");
      localStringBuilder.append(vid);
      localStringBuilder.append(",");
      localStringBuilder.append(msgId);
      localStringBuilder.append(",");
      localStringBuilder.append(idx);
      localStringBuilder.append(",");
      localStringBuilder.append(vYv);
      localStringBuilder.append(",");
      localStringBuilder.append(hBm);
      localStringBuilder.append(",");
      localStringBuilder.append(vXM);
      localStringBuilder.append(",");
      localStringBuilder.append(hQm);
      localStringBuilder.append(",");
      localStringBuilder.append(playDuration);
      localStringBuilder.append(",");
      localStringBuilder.append(vYw);
      localStringBuilder.append(",");
      localStringBuilder.append(vYx);
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      ah localah = ah.aiuX;
      localh.kvStat(21001, localStringBuilder.toString());
      AppMethodBeat.o(302110);
      return;
      if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        i = 5;
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        i = 4;
      } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        i = 3;
      } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
        i = 6;
      } else if (g.isFreeSimCard()) {
        i = 1;
      }
    }
  }
  
  public static void setVid(String paramString)
  {
    vid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c
 * JD-Core Version:    0.7.0.1
 */