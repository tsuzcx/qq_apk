package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
public final class d$a
{
  public static String Gm(int paramInt)
  {
    AppMethodBeat.i(159);
    if (paramInt == 0)
    {
      AppMethodBeat.o(159);
      return "";
    }
    Object localObject = ae.SYK;
    localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(159);
    return localObject;
  }
  
  public static int anl(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(160);
    p.h(paramString, "stringColor");
    if (n.J(paramString, "#", false))
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(160);
      return i;
    }
    try
    {
      int j = Integer.parseInt(paramString, kotlin.n.a.avR(16));
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
  
  public static String cIJ()
  {
    AppMethodBeat.i(155);
    Object localObject = new StringBuilder();
    com.tencent.mm.emoji.e.a locala = com.tencent.mm.emoji.e.a.hdT;
    localObject = com.tencent.mm.emoji.e.a.awu() + "capture_emoji/";
    s.boN((String)localObject);
    AppMethodBeat.o(155);
    return localObject;
  }
  
  public static String cIK()
  {
    AppMethodBeat.i(156);
    String str = cIJ() + "video_" + Util.nowMilliSecond();
    AppMethodBeat.o(156);
    return str;
  }
  
  public static String cIL()
  {
    AppMethodBeat.i(157);
    String str = cIJ() + "temp_thumb" + Util.nowMilliSecond();
    AppMethodBeat.o(157);
    return str;
  }
  
  public static boolean cIM()
  {
    AppMethodBeat.i(158);
    String str = LocaleUtil.getApplicationLanguage();
    if (str == null) {}
    do
    {
      for (;;)
      {
        AppMethodBeat.o(158);
        return true;
        switch (str.hashCode())
        {
        }
      }
    } while (!str.equals("zh_HK"));
    for (;;)
    {
      AppMethodBeat.o(158);
      return false;
      if (!str.equals("zh_TW")) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.d.a
 * JD-Core Version:    0.7.0.1
 */