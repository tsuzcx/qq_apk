package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.d;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoPreviewReport;", "", "()V", "TAG", "", "absolutePosition", "", "getAbsolutePosition", "()I", "setAbsolutePosition", "(I)V", "autoPlayId", "getAutoPlayId", "()Ljava/lang/String;", "setAutoPlayId", "(Ljava/lang/String;)V", "bizUin", "", "getBizUin", "()J", "setBizUin", "(J)V", "bufferDuration", "getBufferDuration", "setBufferDuration", "eventType", "getEventType", "setEventType", "idx", "getIdx", "setIdx", "msgId", "getMsgId", "setMsgId", "playDuration", "getPlayDuration", "setPlayDuration", "sessionId", "getSessionId", "setSessionId", "vid", "getVid", "setVid", "videoDuration", "getVideoDuration", "setVideoDuration", "buildUrl", "", "url", "report", "EVENT", "plugin-brandservice_release"})
public final class o
{
  private static int dmM;
  private static int dzC;
  private static String hCa;
  private static int idx;
  private static long msgId;
  private static String owa;
  private static long oyk;
  private static int oyl;
  private static long oym;
  private static long oyn;
  public static final o oyo;
  private static long playDuration;
  
  static
  {
    AppMethodBeat.i(209168);
    oyo = new o();
    hCa = "";
    owa = "";
    AppMethodBeat.o(209168);
  }
  
  public static void Ao(int paramInt)
  {
    oyl = paramInt;
  }
  
  public static void Ap(int paramInt)
  {
    dmM = paramInt;
  }
  
  public static void YO(String paramString)
  {
    hCa = paramString;
  }
  
  public static void YP(String paramString)
  {
    owa = paramString;
  }
  
  public static void YQ(String paramString)
  {
    AppMethodBeat.i(209166);
    oyk = 0L;
    idx = 0;
    msgId = 0L;
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209166);
      return;
    }
    try
    {
      paramString = Uri.parse(paramString);
      Object localObject = paramString.getQueryParameter("__biz");
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode((String)localObject, 0);
        p.g(localObject, "byte");
        oyk = bu.getLong(new String((byte[])localObject, d.UTF_8), 0L);
      }
      idx = bu.getInt(paramString.getQueryParameter("idx"), 0);
      msgId = bu.getLong(paramString.getQueryParameter("mid"), 0L);
      AppMethodBeat.o(209166);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(209166);
    }
  }
  
  public static long bTr()
  {
    return playDuration;
  }
  
  public static void report()
  {
    int i = 2;
    AppMethodBeat.i(209167);
    if (az.isWifi(ak.getContext())) {}
    for (;;)
    {
      g localg = g.yxI;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(oyk);
      localStringBuilder.append(",");
      localStringBuilder.append(hCa);
      localStringBuilder.append(",");
      localStringBuilder.append(msgId);
      localStringBuilder.append(",");
      localStringBuilder.append(idx);
      localStringBuilder.append(",");
      localStringBuilder.append(oyl);
      localStringBuilder.append(",");
      localStringBuilder.append(dmM);
      localStringBuilder.append(",");
      localStringBuilder.append(owa);
      localStringBuilder.append(",");
      localStringBuilder.append(dzC);
      localStringBuilder.append(",");
      localStringBuilder.append(playDuration);
      localStringBuilder.append(",");
      localStringBuilder.append(oym);
      localStringBuilder.append(",");
      localStringBuilder.append(oyn);
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localg.kvStat(21001, localStringBuilder.toString());
      AppMethodBeat.o(209167);
      return;
      if (az.is2G(ak.getContext())) {
        i = 5;
      } else if (az.is3G(ak.getContext())) {
        i = 4;
      } else if (az.is4G(ak.getContext())) {
        i = 3;
      } else if (az.is5G(ak.getContext())) {
        i = 6;
      } else if (h.esu()) {
        i = 1;
      }
    }
  }
  
  public static void setEventType(int paramInt)
  {
    dzC = paramInt;
  }
  
  public static void tJ(long paramLong)
  {
    playDuration = paramLong;
  }
  
  public static void tK(long paramLong)
  {
    oym = paramLong;
  }
  
  public static void tL(long paramLong)
  {
    oyn = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o
 * JD-Core Version:    0.7.0.1
 */