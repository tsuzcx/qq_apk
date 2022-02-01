package com.tencent.mm.plugin.flash;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtLogger.IYtLoggerListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import org.json.JSONObject;

public final class b
{
  public static final String BAI;
  
  static
  {
    AppMethodBeat.i(192328);
    BAI = p.dim() + '/' + "fdv_";
    if (PluginFace.isEnabled())
    {
      com.tencent.mm.plugin.expansions.a.avY("FacePro");
      com.tencent.mm.plugin.expansions.a.avY("YTCommon");
      com.tencent.mm.plugin.expansions.a.avY("YTFaceTrackPro2");
      com.tencent.mm.plugin.expansions.a.avY("YTAGReflectLiveCheck");
      com.tencent.mm.plugin.expansions.a.avY("YTPoseDetect");
      com.tencent.mm.plugin.expansions.a.avY("opencv_world");
      com.tencent.mm.plugin.expansions.a.avY("YTLipReader");
    }
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(192328);
  }
  
  public b()
  {
    AppMethodBeat.i(192292);
    int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKL, 4);
    int i;
    if (j >= 0)
    {
      i = j;
      if (j <= 5) {}
    }
    else
    {
      i = 2;
    }
    YtLogger.setLogLevel(i);
    Log.i("MicroMsg.FaceFlashManager", "choose sdk log level:%s", new Object[] { Integer.valueOf(i) });
    YtLogger.setLoggerListener(new YtLogger.IYtLoggerListener()
    {
      public final void log(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(195794);
        Log.i("MicroMsg.YTLog", "%s:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(195794);
      }
    });
    AppMethodBeat.o(192292);
  }
  
  public static boolean a(Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(192304);
    int i = YTCameraSetting.initCamera(MMApplicationContext.getContext(), paramCamera, paramInt);
    Log.i("MicroMsg.FaceFlashManager", "YTCameraSetting  initCamera result:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(192304);
      return false;
    }
    YtSDKKitFramework.YtSDKPlatformContext localYtSDKPlatformContext = YtSDKKitFramework.getInstance().getPlatformContext();
    localYtSDKPlatformContext.currentCamera = paramCamera;
    localYtSDKPlatformContext.currentCameraId = paramInt;
    localYtSDKPlatformContext.currentRotateState = YTCameraSetting.getRotate(MMApplicationContext.getContext(), paramInt, 1);
    localYtSDKPlatformContext.currentAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(192304);
    return true;
  }
  
  public static boolean a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    AppMethodBeat.i(192315);
    JSONObject localJSONObject = com.tencent.mm.plugin.flash.a.a.a(paramYtSDKKitFrameworkWorkMode);
    if (localJSONObject == null)
    {
      AppMethodBeat.o(192315);
      return false;
    }
    int i = YtSDKKitFramework.getInstance().init(YtSDKKitFramework.getInstance().getPlatformContext(), localJSONObject, paramYtSDKKitFrameworkWorkMode, YtSDKKitConfigHelper.getPipleStateNames(paramYtSDKKitFrameworkWorkMode), paramIYtSDKKitFrameworkEventListener);
    Log.i("MicroMsg.FaceFlashManager", "YtSDKKitFramework init ret:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.i("MicroMsg.FaceFlashManagerError", "YtSDKKitFramework init error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(192315);
      return false;
    }
    AppMethodBeat.o(192315);
    return true;
  }
  
  public static boolean epr()
  {
    AppMethodBeat.i(192295);
    int i = com.tencent.ytcommon.a.a.dm(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2");
    Log.i("MicroMsg.FaceFlashManager", "YTCommonInterface  initAuth result:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(192295);
      return false;
    }
    AppMethodBeat.o(192295);
    return true;
  }
  
  public static void eps()
  {
    AppMethodBeat.i(192322);
    Log.i("MicroMsg.FaceFlashManager", "releaseYTSdk");
    YtSDKKitFramework.getInstance().deInit();
    AppMethodBeat.o(192322);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(192319);
    YtSDKKitFramework.getInstance().reset();
    AppMethodBeat.o(192319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b
 * JD-Core Version:    0.7.0.1
 */