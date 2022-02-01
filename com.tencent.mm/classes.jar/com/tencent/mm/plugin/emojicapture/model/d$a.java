package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.f.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.a;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  public static String KR(int paramInt)
  {
    AppMethodBeat.i(159);
    if (paramInt == 0)
    {
      AppMethodBeat.o(159);
      return "";
    }
    Object localObject = am.aixg;
    localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(159);
    return localObject;
  }
  
  public static int apj(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(160);
    s.u(paramString, "stringColor");
    if (n.U(paramString, "#", false))
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(160);
      return i;
    }
    try
    {
      int j = Integer.parseInt(paramString, a.aMy(16));
      i = j & 0xFFFFFFFF | 0xFF000000;
    }
    catch (Exception paramString)
    {
      label54:
      break label54;
    }
    AppMethodBeat.o(160);
    return i;
  }
  
  public static String dDI()
  {
    AppMethodBeat.i(155);
    Object localObject = c.moq;
    localObject = s.X(c.aWB(), "capture_emoji/");
    y.bDX((String)localObject);
    AppMethodBeat.o(155);
    return localObject;
  }
  
  public static String dDJ()
  {
    AppMethodBeat.i(156);
    String str = dDI() + "video_" + Util.nowMilliSecond();
    AppMethodBeat.o(156);
    return str;
  }
  
  public static String dDK()
  {
    AppMethodBeat.i(157);
    String str = dDI() + "temp_thumb" + Util.nowMilliSecond();
    AppMethodBeat.o(157);
    return str;
  }
  
  public static boolean dDL()
  {
    AppMethodBeat.i(158);
    String str = LocaleUtil.getApplicationLanguage();
    if (s.p(str, "zh_TW")) {}
    for (boolean bool = true; bool; bool = s.p(str, "zh_HK"))
    {
      AppMethodBeat.o(158);
      return false;
    }
    AppMethodBeat.o(158);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.d.a
 * JD-Core Version:    0.7.0.1
 */