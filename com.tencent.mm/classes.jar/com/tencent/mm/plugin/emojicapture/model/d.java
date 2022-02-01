package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiCaptureConstants";
  private static int pXA;
  public static final a pXB;
  private static boolean pXv;
  private static int pXw;
  private static int pXx;
  private static int pXy;
  private static float pXz;
  
  static
  {
    AppMethodBeat.i(161);
    pXB = new a((byte)0);
    TAG = "MicroMsg.EmojiCaptureConstants";
    pXv = true;
    pXw = 5;
    pXx = 640;
    pXy = 9;
    pXz = pXx * 0.0666667F;
    pXA = 320;
    AppMethodBeat.o(161);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
  public static final class a
  {
    public static String CB(int paramInt)
    {
      AppMethodBeat.i(159);
      if (paramInt == 0)
      {
        AppMethodBeat.o(159);
        return "";
      }
      Object localObject = d.g.b.ad.Njc;
      localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(159);
      return localObject;
    }
    
    public static int adc(String paramString)
    {
      AppMethodBeat.i(160);
      p.h(paramString, "stringColor");
      if (n.nF(paramString, "#"))
      {
        i = Color.parseColor(paramString);
        AppMethodBeat.o(160);
        return i;
      }
      try
      {
        i = Integer.parseInt(paramString, d.n.a.ami(16));
        i = i & 0xFFFFFFFF | 0xFF000000;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          i = 0;
        }
      }
      AppMethodBeat.o(160);
      return i;
    }
    
    public static String ckH()
    {
      AppMethodBeat.i(155);
      Object localObject = new StringBuilder();
      com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.gsI;
      localObject = com.tencent.mm.emoji.d.a.agE() + "capture_emoji/";
      o.aZI((String)localObject);
      AppMethodBeat.o(155);
      return localObject;
    }
    
    public static String ckI()
    {
      AppMethodBeat.i(156);
      String str = ckH() + "video_" + bu.fpO();
      AppMethodBeat.o(156);
      return str;
    }
    
    public static String ckJ()
    {
      AppMethodBeat.i(157);
      String str = ckH() + "temp_thumb" + bu.fpO();
      AppMethodBeat.o(157);
      return str;
    }
    
    public static boolean ckK()
    {
      AppMethodBeat.i(158);
      String str = com.tencent.mm.sdk.platformtools.ad.fom();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.d
 * JD-Core Version:    0.7.0.1
 */