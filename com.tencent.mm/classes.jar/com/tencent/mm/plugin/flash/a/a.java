package com.tencent.mm.plugin.flash.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final String BAI;
  
  static
  {
    AppMethodBeat.i(190546);
    BAI = p.dim() + '/' + "fdv_";
    AppMethodBeat.o(190546);
  }
  
  public static JSONObject a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode)
  {
    AppMethodBeat.i(190541);
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
          localJSONObject.put("resource_download_path", p.dim() + "/");
          str3 = str1;
          localJSONObject.put("video_path", BAI + Util.currentTicks() + ".mp4");
          str3 = str1;
          Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(190541);
          return localJSONObject;
          str3 = str1;
          str1 = ((b)h.ae(b.class)).a(b.a.vKN, "");
          continue;
          str3 = str1;
          str1 = ((b)h.ae(b.class)).a(b.a.vKO, "");
          continue;
          str3 = str1;
          str1 = ((b)h.ae(b.class)).a(b.a.vKP, "");
          continue;
          str3 = str1;
          str1 = ((b)h.ae(b.class)).a(b.a.vKQ, "");
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
          paramYtSDKKitFrameworkWorkMode.put("resource_download_path", p.dim() + "/");
          paramYtSDKKitFrameworkWorkMode.put("video_path", BAI + Util.currentTicks() + ".mp4");
          Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", new Object[] { paramYtSDKKitFrameworkWorkMode.toString() });
          AppMethodBeat.o(190541);
          return paramYtSDKKitFrameworkWorkMode;
        }
        catch (JSONException paramYtSDKKitFrameworkWorkMode)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerConfig", paramYtSDKKitFrameworkWorkMode, "par config error. config:%s", new Object[] { str2 });
          AppMethodBeat.o(190541);
          return null;
        }
      }
    }
  }
  
  public static int epA()
  {
    AppMethodBeat.i(190528);
    int i = ((b)h.ae(b.class)).a(b.a.vKR, 1500);
    Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceWaitingTimeMs %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(190528);
    return i;
  }
  
  public static int epB()
  {
    AppMethodBeat.i(190532);
    int i = ((b)h.ae(b.class)).a(b.a.vKS, 1000);
    Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceReadNumberTimeInterval %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(190532);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.a.a
 * JD-Core Version:    0.7.0.1
 */