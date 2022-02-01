package com.tencent.av.camera;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.GraphicRenderMgr.FocusDetectCallback;
import com.tencent.qav.log.AVLog;
import java.util.List;

public class VcCamera
  extends AndroidCamera
  implements GraphicRenderMgr.FocusDetectCallback
{
  private static final String TAG = "VcCamera";
  private Camera.AutoFocusCallback mAutoFocusCallback = new Camera.AutoFocusCallback()
  {
    public void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
    {
      GraphicRenderMgr.getInstance().setIsFocusing(false);
    }
  };
  
  public VcCamera(Context paramContext)
  {
    super(paramContext);
  }
  
  private void enableAutoFocus(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (paramParameters == null) {}
    List localList;
    do
    {
      return;
      localList = paramParameters.getSupportedFocusModes();
    } while (localList == null);
    if (0 != 0)
    {
      userSelfDevFocusMode(paramBoolean, localList);
      return;
    }
    userSystemFocusMode(paramBoolean, localList, paramParameters);
  }
  
  private void userSelfDevFocusMode(boolean paramBoolean, List<String> paramList)
  {
    if (!paramList.contains("auto")) {
      return;
    }
    if (paramBoolean)
    {
      GraphicRenderMgr.getInstance().setFocusDetectCallback(this);
      GraphicRenderMgr.getInstance().setFocusConfig(true, SystemClock.elapsedRealtime(), 111, 3000);
      return;
    }
    GraphicRenderMgr.getInstance().setFocusDetectCallback(null);
    GraphicRenderMgr.getInstance().setFocusConfig(false, SystemClock.elapsedRealtime(), 111, 3000);
  }
  
  private void userSystemFocusMode(boolean paramBoolean, List<String> paramList, Camera.Parameters paramParameters)
  {
    if ((paramBoolean) && (Integer.parseInt(Build.VERSION.SDK) >= 9) && (paramList.contains("continuous-video"))) {
      paramParameters.setFocusMode("continuous-video");
    }
    try
    {
      this.mCamera.setParameters(paramParameters);
      return;
    }
    catch (Exception paramList) {}
  }
  
  public boolean closeCamera(long paramLong)
  {
    try
    {
      boolean bool = isCameraOpened;
      Object localObject1;
      if (bool) {
        localObject1 = null;
      }
      try
      {
        Camera.Parameters localParameters = this.mCamera.getParameters();
        localObject1 = localParameters;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AVLog.e("VcCamera", "closeCamera", localException);
        }
      }
      enableAutoFocus(localObject1, false);
      bool = super.closeCamera(paramLong);
      return bool;
    }
    finally {}
  }
  
  public int getCameraDisplayRotation()
  {
    return getCameraDisplayOrientation(this.mCameraId, this.mCamera).rotation;
  }
  
  public void onFocusDetectResult(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.mCamera == null)) {
      return;
    }
    GraphicRenderMgr.getInstance().setIsFocusing(true);
    this.mCamera.autoFocus(this.mAutoFocusCallback);
  }
  
  protected void setCameraPara(int paramInt1, int paramInt2)
  {
    super.setCameraPara(paramInt1, paramInt2);
    if (this.mCamera != null)
    {
      Object localObject = null;
      try
      {
        Camera.Parameters localParameters = this.mCamera.getParameters();
        localObject = localParameters;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AVLog.d("VcCamera", "setCameraPara exception", localException);
        }
        AVLog.w("VcCamera", "setCameraPara, parameters[null]");
        return;
      }
      if (localObject != null)
      {
        enableAutoFocus(localObject, true);
        return;
      }
    }
    AVLog.w("VcCamera", "setCameraPara, camera[false]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.camera.VcCamera
 * JD-Core Version:    0.7.0.1
 */