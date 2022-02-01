package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.n.n;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiCaptureConstants";
  private static boolean oJS;
  private static int oJT;
  private static int oJU;
  private static int oJV;
  private static float oJW;
  private static int oJX;
  public static final a oJY;
  
  static
  {
    AppMethodBeat.i(161);
    oJY = new a((byte)0);
    TAG = "MicroMsg.EmojiCaptureConstants";
    oJS = true;
    oJT = 5;
    oJU = 640;
    oJV = 9;
    oJW = oJU * 0.0666667F;
    oJX = 320;
    AppMethodBeat.o(161);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
  public static final class a
  {
    public static String AP(int paramInt)
    {
      AppMethodBeat.i(159);
      if (paramInt == 0)
      {
        AppMethodBeat.o(159);
        return "";
      }
      Object localObject = z.Jhz;
      localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(159);
      return localObject;
    }
    
    public static int Ut(String paramString)
    {
      AppMethodBeat.i(160);
      k.h(paramString, "stringColor");
      if (n.mA(paramString, "#"))
      {
        i = Color.parseColor(paramString);
        AppMethodBeat.o(160);
        return i;
      }
      try
      {
        i = Integer.parseInt(paramString, d.n.a.agb(16));
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
    
    public static String bXB()
    {
      AppMethodBeat.i(155);
      Object localObject = new StringBuilder();
      com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.fSR;
      localObject = com.tencent.mm.emoji.d.a.acE() + "capture_emoji/";
      i.aMF((String)localObject);
      AppMethodBeat.o(155);
      return localObject;
    }
    
    public static String bXC()
    {
      AppMethodBeat.i(156);
      String str = bXB() + "video_" + bt.eGO();
      AppMethodBeat.o(156);
      return str;
    }
    
    public static String bXD()
    {
      AppMethodBeat.i(157);
      String str = bXB() + "temp_thumb" + bt.eGO();
      AppMethodBeat.o(157);
      return str;
    }
    
    public static boolean bXE()
    {
      AppMethodBeat.i(158);
      String str = ac.eFu();
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