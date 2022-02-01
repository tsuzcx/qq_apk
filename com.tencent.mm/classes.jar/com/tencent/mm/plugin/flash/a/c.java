package com.tencent.mm.plugin.flash.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static final String Hig;
  
  static
  {
    AppMethodBeat.i(264703);
    Hig = k.dOX() + '/' + "fdv_";
    AppMethodBeat.o(264703);
  }
  
  public static JSONObject a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode)
  {
    AppMethodBeat.i(264698);
    String str1 = "";
    String str3 = str1;
    try
    {
      switch (1.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[paramYtSDKKitFrameworkWorkMode.ordinal()])
      {
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          str3 = str1;
          if (TextUtils.isEmpty(str1)) {
            break;
          }
          str3 = str1;
          JSONObject localJSONObject = new JSONObject(str1);
          str3 = str1;
          localJSONObject.put("resource_download_path", k.dOX() + "/");
          str3 = str1;
          localJSONObject.put("video_path", Hig + Util.currentTicks() + ".mp4");
          str3 = str1;
          Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(264698);
          return localJSONObject;
          str3 = str1;
          str1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbn, "");
          continue;
          str3 = str1;
          str1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbo, "");
          continue;
          str3 = str1;
          str1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbp, "");
          continue;
          str3 = str1;
          str1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbq, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerConfig", localException, "par config error. config:%s", new Object[] { str3 });
        String str2 = FileUtils.readAssetFile(MMApplicationContext.getContext(), "face_detect/configs/YtSDKSettings.json").toString();
        try
        {
          paramYtSDKKitFrameworkWorkMode = YtSDKKitConfigHelper.getSDKConfig(paramYtSDKKitFrameworkWorkMode, new JSONObject(str2).getJSONObject("sdk_settings"));
          paramYtSDKKitFrameworkWorkMode.put("resource_download_path", k.dOX() + "/");
          paramYtSDKKitFrameworkWorkMode.put("video_path", Hig + Util.currentTicks() + ".mp4");
          Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", new Object[] { paramYtSDKKitFrameworkWorkMode.toString() });
          AppMethodBeat.o(264698);
          return paramYtSDKKitFrameworkWorkMode;
        }
        catch (JSONException paramYtSDKKitFrameworkWorkMode)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerConfig", paramYtSDKKitFrameworkWorkMode, "par config error. config:%s", new Object[] { str2 });
          AppMethodBeat.o(264698);
          return null;
        }
      }
    }
  }
  
  public static int fuC()
  {
    AppMethodBeat.i(264679);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbr, 1500);
    Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceWaitingTimeMs %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(264679);
    return i;
  }
  
  public static int fuD()
  {
    AppMethodBeat.i(264685);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbs, 1000);
    Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceReadNumberTimeInterval %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(264685);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.a.c
 * JD-Core Version:    0.7.0.1
 */