package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.n.n;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiCaptureConstants";
  private static boolean pnq;
  private static int pnr;
  private static int pns;
  private static int pnt;
  private static float pnu;
  private static int pnv;
  public static final a pnw;
  
  static
  {
    AppMethodBeat.i(161);
    pnw = new a((byte)0);
    TAG = "MicroMsg.EmojiCaptureConstants";
    pnq = true;
    pnr = 5;
    pns = 640;
    pnt = 9;
    pnu = pns * 0.0666667F;
    pnv = 320;
    AppMethodBeat.o(161);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
  public static final class a
  {
    public static String BH(int paramInt)
    {
      AppMethodBeat.i(159);
      if (paramInt == 0)
      {
        AppMethodBeat.o(159);
        return "";
      }
      Object localObject = z.KUT;
      localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
      k.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(159);
      return localObject;
    }
    
    public static int YF(String paramString)
    {
      AppMethodBeat.i(160);
      k.h(paramString, "stringColor");
      if (n.nb(paramString, "#"))
      {
        i = Color.parseColor(paramString);
        AppMethodBeat.o(160);
        return i;
      }
      try
      {
        i = Integer.parseInt(paramString, d.n.a.aiX(16));
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
    
    public static String ceO()
    {
      AppMethodBeat.i(155);
      Object localObject = new StringBuilder();
      com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.fWM;
      localObject = com.tencent.mm.emoji.d.a.adK() + "capture_emoji/";
      i.aSh((String)localObject);
      AppMethodBeat.o(155);
      return localObject;
    }
    
    public static String ceP()
    {
      AppMethodBeat.i(156);
      String str = ceO() + "video_" + bs.eWj();
      AppMethodBeat.o(156);
      return str;
    }
    
    public static String ceQ()
    {
      AppMethodBeat.i(157);
      String str = ceO() + "temp_thumb" + bs.eWj();
      AppMethodBeat.o(157);
      return str;
    }
    
    public static boolean ceR()
    {
      AppMethodBeat.i(158);
      String str = ab.eUO();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.d
 * JD-Core Version:    0.7.0.1
 */