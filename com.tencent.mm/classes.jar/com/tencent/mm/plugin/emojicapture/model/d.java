package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiCaptureConstants";
  private static boolean uUa;
  private static int uUb;
  private static int uUc;
  private static int uUd;
  private static float uUe;
  private static int uUf;
  public static final a uUg;
  
  static
  {
    AppMethodBeat.i(161);
    uUg = new a((byte)0);
    TAG = "MicroMsg.EmojiCaptureConstants";
    uUa = true;
    uUb = 5;
    uUc = 640;
    uUd = 9;
    uUe = uUc * 0.0666667F;
    uUf = 320;
    AppMethodBeat.o(161);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
  public static final class a
  {
    public static String JT(int paramInt)
    {
      AppMethodBeat.i(159);
      if (paramInt == 0)
      {
        AppMethodBeat.o(159);
        return "";
      }
      Object localObject = af.aaBG;
      localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
      p.j(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(159);
      return localObject;
    }
    
    public static int avj(String paramString)
    {
      int i = 0;
      AppMethodBeat.i(160);
      p.k(paramString, "stringColor");
      if (n.M(paramString, "#", false))
      {
        i = Color.parseColor(paramString);
        AppMethodBeat.o(160);
        return i;
      }
      try
      {
        int j = Integer.parseInt(paramString, kotlin.n.a.aFL(16));
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
    
    public static String cXs()
    {
      AppMethodBeat.i(155);
      Object localObject = new StringBuilder();
      com.tencent.mm.emoji.e.a locala = com.tencent.mm.emoji.e.a.jPz;
      localObject = com.tencent.mm.emoji.e.a.aDC() + "capture_emoji/";
      u.bBD((String)localObject);
      AppMethodBeat.o(155);
      return localObject;
    }
    
    public static String cXt()
    {
      AppMethodBeat.i(156);
      String str = cXs() + "video_" + Util.nowMilliSecond();
      AppMethodBeat.o(156);
      return str;
    }
    
    public static String cXu()
    {
      AppMethodBeat.i(157);
      String str = cXs() + "temp_thumb" + Util.nowMilliSecond();
      AppMethodBeat.o(157);
      return str;
    }
    
    public static boolean cXv()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.d
 * JD-Core Version:    0.7.0.1
 */