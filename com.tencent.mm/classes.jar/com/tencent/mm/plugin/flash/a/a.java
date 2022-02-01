package com.tencent.mm.plugin.flash.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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
  private static final String wHI;
  
  static
  {
    AppMethodBeat.i(186611);
    wHI = p.cTh() + '/' + "fdv_";
    AppMethodBeat.o(186611);
  }
  
  public static JSONObject a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode)
  {
    AppMethodBeat.i(186610);
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
          localJSONObject.put("resource_download_path", p.cTh() + "/");
          str3 = str1;
          localJSONObject.put("video_path", wHI + Util.currentTicks() + ".mp4");
          str3 = str1;
          Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", new Object[] { localJSONObject.toString() });
          AppMethodBeat.o(186610);
          return localJSONObject;
          str3 = str1;
          str1 = ((b)g.af(b.class)).a(b.a.scz, "");
          continue;
          str3 = str1;
          str1 = ((b)g.af(b.class)).a(b.a.scA, "");
          continue;
          str3 = str1;
          str1 = ((b)g.af(b.class)).a(b.a.scB, "");
          continue;
          str3 = str1;
          str1 = ((b)g.af(b.class)).a(b.a.scC, "");
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
          paramYtSDKKitFrameworkWorkMode.put("resource_download_path", p.cTh() + "/");
          paramYtSDKKitFrameworkWorkMode.put("video_path", wHI + Util.currentTicks() + ".mp4");
          Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", new Object[] { paramYtSDKKitFrameworkWorkMode.toString() });
          AppMethodBeat.o(186610);
          return paramYtSDKKitFrameworkWorkMode;
        }
        catch (JSONException paramYtSDKKitFrameworkWorkMode)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerConfig", paramYtSDKKitFrameworkWorkMode, "par config error. config:%s", new Object[] { str2 });
          AppMethodBeat.o(186610);
          return null;
        }
      }
    }
  }
  
  public static int dKW()
  {
    AppMethodBeat.i(186607);
    int i = ((b)g.af(b.class)).a(b.a.scD, 1500);
    Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceWaitingTimeMs %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(186607);
    return i;
  }
  
  public static int dKX()
  {
    AppMethodBeat.i(186608);
    int i = ((b)g.af(b.class)).a(b.a.scE, 1000);
    Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceReadNumberTimeInterval %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(186608);
    return i;
  }
  
  public static int dKY()
  {
    AppMethodBeat.i(186609);
    int i = ((b)g.af(b.class)).a(b.a.scF, 1000);
    Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceReadNumberTimeInterval %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(186609);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.a.a
 * JD-Core Version:    0.7.0.1
 */