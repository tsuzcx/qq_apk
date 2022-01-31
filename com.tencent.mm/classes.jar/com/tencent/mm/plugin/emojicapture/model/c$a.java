package com.tencent.mm.plugin.emojicapture.model;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.l.m;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.vfs.e;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
public final class c$a
{
  public static int Ln(String paramString)
  {
    AppMethodBeat.i(2580);
    j.q(paramString, "stringColor");
    if (m.jw(paramString, "#"))
    {
      i = Color.parseColor(paramString);
      AppMethodBeat.o(2580);
      return i;
    }
    try
    {
      i = Integer.parseInt(paramString, a.l.a.We(16));
      i &= 0xFFFFFFFF;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i = 0;
      }
    }
    AppMethodBeat.o(2580);
    return i;
  }
  
  public static String bnR()
  {
    AppMethodBeat.i(2578);
    String str = b.YP() + "capture_emoji/";
    e.um(str);
    AppMethodBeat.o(2578);
    return str;
  }
  
  public static String uF(int paramInt)
  {
    AppMethodBeat.i(2579);
    if (paramInt == 0)
    {
      AppMethodBeat.o(2579);
      return "";
    }
    Object localObject = a.f.b.y.BNt;
    localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
    j.p(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(2579);
    return localObject;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  public static final class a
    extends k
    implements a.f.a.a<a.y>
  {
    public static final a ltv;
    
    static
    {
      AppMethodBeat.i(2577);
      ltv = new a();
      AppMethodBeat.o(2577);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.a
 * JD-Core Version:    0.7.0.1
 */