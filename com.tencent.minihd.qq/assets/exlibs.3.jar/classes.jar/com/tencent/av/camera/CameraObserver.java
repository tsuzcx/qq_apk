package com.tencent.av.camera;

import com.tencent.qav.log.AVLog;
import com.tencent.qav.observer.FilterableObserver;

public class CameraObserver
  extends FilterableObserver
{
  public static final int CAMERA_CLOSE_AFTER = 4;
  public static final int CAMERA_CLOSE_BEFORE = 3;
  public static final int CAMERA_OPEN_AFTER = 2;
  public static final int CAMERA_OPEN_BEFORE = 1;
  public static final int CAMERA_SWITCH_AFTER = 6;
  public static final int CAMERA_SWITCH_BEFORE = 5;
  public static final int CAMERA_SWITCH_FIRST_FRAME = 7;
  private static final String TAG = "CameraObserver";
  
  public void onAfterCloseCamera(boolean paramBoolean) {}
  
  public void onAfterSwitchCamera(boolean paramBoolean) {}
  
  public void onAfterSwitchFirstFrame() {}
  
  public void onBeforeCloseCamera() {}
  
  public void onBeforeSwitchCamera() {}
  
  public void onCameraOpenAfter(boolean paramBoolean) {}
  
  public void onCameraOpenBefore(boolean paramBoolean) {}
  
  public void update(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      AVLog.w("CameraObserver", "update handle not define type.");
      return;
    case 1: 
      onCameraOpenBefore(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    case 2: 
      onCameraOpenAfter(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    case 3: 
      onBeforeCloseCamera();
      return;
    case 4: 
      onAfterCloseCamera(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    case 5: 
      onBeforeSwitchCamera();
      return;
    case 6: 
      onAfterSwitchCamera(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    }
    onAfterSwitchFirstFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.camera.CameraObserver
 * JD-Core Version:    0.7.0.1
 */