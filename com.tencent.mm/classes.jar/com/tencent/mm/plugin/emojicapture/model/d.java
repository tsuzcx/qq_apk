package com.tencent.mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiCaptureConstants";
  private static boolean pQQ;
  private static int pQR;
  private static int pQS;
  private static int pQT;
  private static float pQU;
  private static int pQV;
  public static final a pQW;
  
  static
  {
    AppMethodBeat.i(161);
    pQW = new a((byte)0);
    TAG = "MicroMsg.EmojiCaptureConstants";
    pQQ = true;
    pQR = 5;
    pQS = 640;
    pQT = 9;
    pQU = pQS * 0.0666667F;
    pQV = 320;
    AppMethodBeat.o(161);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecommendCount", "getRecommendCount", "setRecommendCount", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
  public static final class a
  {
    public static String Cp(int paramInt)
    {
      AppMethodBeat.i(159);
      if (paramInt == 0)
      {
        AppMethodBeat.o(159);
        return "";
      }
      Object localObject = ad.MLZ;
      localObject = String.format("%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(159);
      return localObject;
    }
    
    public static int acl(String paramString)
    {
      AppMethodBeat.i(160);
      p.h(paramString, "stringColor");
      if (n.nz(paramString, "#"))
      {
        i = Color.parseColor(paramString);
        AppMethodBeat.o(160);
        return i;
      }
      try
      {
        i = Integer.parseInt(paramString, d.n.a.aly(16));
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
    
    public static String cjr()
    {
      AppMethodBeat.i(155);
      Object localObject = new StringBuilder();
      com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.gqn;
      localObject = com.tencent.mm.emoji.d.a.agq() + "capture_emoji/";
      i.aYg((String)localObject);
      AppMethodBeat.o(155);
      return localObject;
    }
    
    public static String cjs()
    {
      AppMethodBeat.i(156);
      String str = cjr() + "video_" + bt.flT();
      AppMethodBeat.o(156);
      return str;
    }
    
    public static String cjt()
    {
      AppMethodBeat.i(157);
      String str = cjr() + "temp_thumb" + bt.flT();
      AppMethodBeat.o(157);
      return str;
    }
    
    public static boolean cju()
    {
      AppMethodBeat.i(158);
      String str = ac.fks();
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