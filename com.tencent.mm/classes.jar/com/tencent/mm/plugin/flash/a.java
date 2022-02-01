package com.tencent.mm.plugin.flash;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
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
import com.tencent.ytcommon.util.YTCommonInterface;
import org.json.JSONObject;

public final class a
{
  public static final String wHI;
  
  static
  {
    AppMethodBeat.i(186477);
    wHI = p.cTh() + '/' + "fdv_";
    if (PluginFace.isEnabled())
    {
      com.tencent.mm.plugin.expansions.a.aoa("FacePro");
      com.tencent.mm.plugin.expansions.a.aoa("YTCommon");
      com.tencent.mm.plugin.expansions.a.aoa("YTFaceTrackPro2");
      com.tencent.mm.plugin.expansions.a.aoa("YTAGReflectLiveCheck");
      com.tencent.mm.plugin.expansions.a.aoa("YTPoseDetect");
      com.tencent.mm.plugin.expansions.a.aoa("opencv_world");
      com.tencent.mm.plugin.expansions.a.aoa("YTLipReader");
    }
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(186477);
  }
  
  public a()
  {
    AppMethodBeat.i(186471);
    int j = ((b)g.af(b.class)).a(b.a.scx, 4);
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
        AppMethodBeat.i(186470);
        Log.i("MicroMsg.YTLog", "%s:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(186470);
      }
    });
    AppMethodBeat.o(186471);
  }
  
  public static boolean a(Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(186473);
    int i = YTCameraSetting.initCamera(MMApplicationContext.getContext(), paramCamera, paramInt);
    Log.i("MicroMsg.FaceFlashManager", "YTCameraSetting  initCamera result:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(186473);
      return false;
    }
    YtSDKKitFramework.YtSDKPlatformContext localYtSDKPlatformContext = YtSDKKitFramework.getInstance().getPlatformContext();
    localYtSDKPlatformContext.currentCamera = paramCamera;
    localYtSDKPlatformContext.currentCameraId = paramInt;
    localYtSDKPlatformContext.currentRotateState = YTCameraSetting.getRotate(MMApplicationContext.getContext(), paramInt, 1);
    localYtSDKPlatformContext.currentAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(186473);
    return true;
  }
  
  public static boolean a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    AppMethodBeat.i(186474);
    JSONObject localJSONObject = com.tencent.mm.plugin.flash.a.a.a(paramYtSDKKitFrameworkWorkMode);
    if (localJSONObject == null)
    {
      AppMethodBeat.o(186474);
      return false;
    }
    int i = YtSDKKitFramework.getInstance().init(YtSDKKitFramework.getInstance().getPlatformContext(), localJSONObject, paramYtSDKKitFrameworkWorkMode, YtSDKKitConfigHelper.getPipleStateNames(paramYtSDKKitFrameworkWorkMode), paramIYtSDKKitFrameworkEventListener);
    Log.i("MicroMsg.FaceFlashManager", "YtSDKKitFramework init ret:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.i("MicroMsg.FaceFlashManagerError", "YtSDKKitFramework init error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(186474);
      return false;
    }
    AppMethodBeat.o(186474);
    return true;
  }
  
  public static boolean dKR()
  {
    AppMethodBeat.i(186472);
    int i = YTCommonInterface.initAuth(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
    Log.i("MicroMsg.FaceFlashManager", "YTCommonInterface  initAuth result:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(186472);
      return false;
    }
    AppMethodBeat.o(186472);
    return true;
  }
  
  public static void dKS()
  {
    AppMethodBeat.i(186476);
    Log.i("MicroMsg.FaceFlashManager", "releaseYTSdk");
    YtSDKKitFramework.getInstance().deInit();
    AppMethodBeat.o(186476);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(186475);
    YtSDKKitFramework.getInstance().reset();
    AppMethodBeat.o(186475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.a
 * JD-Core Version:    0.7.0.1
 */