package com.tencent.mm.plugin.flash;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.k;
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
import com.tencent.ytcommon.a.a;
import org.json.JSONObject;

public final class b
{
  public static final String Hig;
  
  static
  {
    AppMethodBeat.i(264490);
    Hig = k.dOX() + '/' + "fdv_";
    if (PluginFace.isEnabled())
    {
      e.tryLoadLibrary("FacePro");
      e.tryLoadLibrary("YTCommon");
      e.tryLoadLibrary("YTFaceTrackPro2");
      e.tryLoadLibrary("YTAGReflectLiveCheck");
      e.tryLoadLibrary("YTPoseDetect");
      e.tryLoadLibrary("opencv_world");
      e.tryLoadLibrary("YTLipReader");
    }
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(264490);
  }
  
  public b()
  {
    AppMethodBeat.i(264440);
    int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbl, 1);
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
        AppMethodBeat.i(264609);
        Log.i("MicroMsg.YTLog", "%s:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        AppMethodBeat.o(264609);
      }
    });
    AppMethodBeat.o(264440);
  }
  
  public static boolean a(Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(264459);
    int i = YTCameraSetting.initCamera(MMApplicationContext.getContext(), paramCamera, paramInt);
    Log.i("MicroMsg.FaceFlashManager", "YTCameraSetting  initCamera result:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(264459);
      return false;
    }
    YtSDKKitFramework.YtSDKPlatformContext localYtSDKPlatformContext = YtSDKKitFramework.getInstance().getPlatformContext();
    localYtSDKPlatformContext.currentCamera = paramCamera;
    localYtSDKPlatformContext.currentCameraId = paramInt;
    localYtSDKPlatformContext.currentRotateState = YTCameraSetting.getRotate(MMApplicationContext.getContext(), paramInt, 1);
    localYtSDKPlatformContext.currentAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(264459);
    return true;
  }
  
  public static boolean a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    AppMethodBeat.i(264468);
    JSONObject localJSONObject = com.tencent.mm.plugin.flash.a.c.a(paramYtSDKKitFrameworkWorkMode);
    if (localJSONObject == null)
    {
      AppMethodBeat.o(264468);
      return false;
    }
    int i = YtSDKKitFramework.getInstance().init(YtSDKKitFramework.getInstance().getPlatformContext(), localJSONObject, paramYtSDKKitFrameworkWorkMode, YtSDKKitConfigHelper.getPipleStateNames(paramYtSDKKitFrameworkWorkMode), paramIYtSDKKitFrameworkEventListener);
    Log.i("MicroMsg.FaceFlashManager", "YtSDKKitFramework init ret:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.i("MicroMsg.FaceFlashManagerError", "YtSDKKitFramework init error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(264468);
      return false;
    }
    AppMethodBeat.o(264468);
    return true;
  }
  
  public static boolean fut()
  {
    AppMethodBeat.i(264450);
    int i = a.dv(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2");
    Log.i("MicroMsg.FaceFlashManager", "YTCommonInterface  initAuth result:%s", new Object[] { Integer.valueOf(i) });
    if (i != 0)
    {
      Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(264450);
      return false;
    }
    AppMethodBeat.o(264450);
    return true;
  }
  
  public static void fuu()
  {
    AppMethodBeat.i(264481);
    Log.i("MicroMsg.FaceFlashManager", "releaseYTSdk");
    YtSDKKitFramework.getInstance().deInit();
    AppMethodBeat.o(264481);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(264475);
    YtSDKKitFramework.getInstance().reset();
    AppMethodBeat.o(264475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b
 * JD-Core Version:    0.7.0.1
 */