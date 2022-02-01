package com.tencent.av.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.thread.ThreadManager;

public class CameraUtils
  implements AndroidCamera.CameraPreviewCallback
{
  private static final String CAMERA_CFG = "cameracfg";
  private static final String TAG = "CameraUtils";
  private static volatile CameraUtils mInstance = null;
  private CloseCameraRunnable closeCamera = new CloseCameraRunnable();
  private VcCamera mCamera;
  private int mCameraNum;
  private boolean mCameraSwitchFirstFrame;
  private Context mContext;
  private SurfaceTexture mSurfaceTexture = new SurfaceTexture(0);
  private OpenCameraRunnable openCamera = new OpenCameraRunnable(null);
  private SwitchCameraRunnable switchCamera = new SwitchCameraRunnable();
  
  private CameraUtils(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mCamera = new VcCamera(this.mContext);
    this.mCamera.setCameraPreviewCallback(this);
    this.mCameraNum = this.mCamera.getCameraNum();
    if (this.mCameraNum > 0)
    {
      paramContext = this.mContext.getSharedPreferences("cameracfg", 0);
      int i = paramContext.getInt("frontCameraRotation", 0);
      int j = paramContext.getInt("backCameraRotation", 0);
      this.mCamera.setCameraAngleFix(true, i);
      this.mCamera.setCameraAngleFix(false, j);
    }
  }
  
  public static CameraUtils getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new CameraUtils(paramContext);
      }
      return mInstance;
    }
    finally {}
  }
  
  private void reopenCameraInSubThread(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.mCamera != null) {
      this.mCamera.reopenCamera(paramLong, this.mSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public Camera.Parameters GetCameraParams()
  {
    if (this.mCamera != null) {
      return this.mCamera.GetCameraParams();
    }
    return null;
  }
  
  public boolean closeCamera(long paramLong, boolean paramBoolean)
  {
    String str = "null";
    if (this.mCamera != null) {
      str = this.mCamera.isCameraOpened() + "";
    }
    AVLog.w("CameraUtils", "closeCamera, changeStatus[" + paramBoolean + "], isCameraOpened[" + str + "], openCamera[" + this.openCamera + "]");
    if ((this.mCamera != null) && (this.mCamera.isCameraOpened()))
    {
      this.closeCamera.seq = paramLong;
      this.closeCamera.setChangeStatus(paramBoolean);
      ThreadManager.executeOnSubThread(this.closeCamera);
      return true;
    }
    return false;
  }
  
  public int getCameraNum()
  {
    return this.mCameraNum;
  }
  
  public boolean isCameraOpened(long paramLong)
  {
    boolean bool = false;
    if (this.mCamera != null) {
      bool = this.mCamera.isCameraOpened();
    }
    AVLog.w("CameraUtils", "isCameraOpened, isCameraOpened[" + bool + "], seq[" + paramLong + "]");
    return bool;
  }
  
  public boolean isCameraOpening(long paramLong)
  {
    boolean bool1 = false;
    if (this.mCamera != null) {
      bool1 = this.mCamera.isCameraOpening();
    }
    StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpening[").append(bool1).append("], mCamera[");
    if (this.mCamera != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      AVLog.w("CameraUtils", bool2 + "], seq[" + paramLong + "]");
      return bool1;
    }
  }
  
  public boolean isFrontCamera()
  {
    boolean bool = false;
    if (this.mCamera != null) {
      bool = this.mCamera.isFrontCamera();
    }
    AVLog.w("CameraUtils", "isFrontCamera[" + bool + "], mCamera[" + this.mCamera + "]");
    return bool;
  }
  
  public void onPreviewData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    GraphicRenderMgr.getInstance().sendCameraFrame(paramArrayOfByte, AndroidCamera.PREVIEW_FORMAT, paramInt1, paramInt2, paramInt3, paramInt4, System.currentTimeMillis(), paramBoolean, null, null, 0, 0);
    FrameBufMgr.getInstance().setFrameBufState(paramArrayOfByte, 0);
    if (this.mCameraSwitchFirstFrame)
    {
      ObserverDispatcher.instance().notifyObservers(CameraObserver.class, 7, new Object[0]);
      this.mCameraSwitchFirstFrame = false;
    }
  }
  
  public void openCamera(long paramLong)
  {
    AVLog.w("CameraUtils", "openCamera, seq[" + paramLong + "], closeCamera[" + this.closeCamera + "], mCamera[" + this.mCamera + "]");
    this.openCamera.seq = paramLong;
    ThreadManager.executeOnSubThread(this.openCamera);
  }
  
  public void reopenCamera(String paramString, final long paramLong, int paramInt1, final int paramInt2)
  {
    ThreadManager.executeOnSubThread(new Runnable()
    {
      public void run()
      {
        CameraUtils.this.reopenCameraInSubThread(paramLong, paramInt2, this.val$h);
      }
    });
  }
  
  public void resetCamera()
  {
    this.mCamera.resetCamera();
  }
  
  public void rotateCamera()
  {
    if ((this.mCamera != null) && (this.mCameraNum > 0))
    {
      if ((this.mCameraNum == 1) || (!this.mCamera.isFrontCamera()))
      {
        i = this.mCamera.getUserCameraAngle(false);
        this.mCamera.setCameraAngleFix(false, i + 90);
      }
    }
    else {
      return;
    }
    int i = this.mCamera.getUserCameraAngle(true);
    this.mCamera.setCameraAngleFix(true, i + 90);
  }
  
  public void saveCameraAngle()
  {
    SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("cameracfg", 0).edit();
    int i = this.mCamera.getUserCameraAngle(true);
    int j = this.mCamera.getUserCameraAngle(false);
    localEditor.putInt("frontCameraRotation", i);
    localEditor.putInt("backCameraRotation", j);
    localEditor.commit();
  }
  
  public void setCameraUseBuffer(boolean paramBoolean)
  {
    if (this.mCamera != null) {
      this.mCamera.supportUserBuffer = paramBoolean;
    }
  }
  
  public boolean setCameraWithNewFps(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mCamera != null)
    {
      bool1 = bool2;
      if (this.mCamera.isCameraOpened())
      {
        this.mCamera.setCameraPara(paramInt);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void setRotation(int paramInt)
  {
    if (this.mCamera != null) {
      this.mCamera.setRotation(paramInt);
    }
  }
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    if (this.mCamera != null)
    {
      if (this.mCamera.mSupportLandscape != paramBoolean) {
        AVLog.w("CameraUtils", "setSupportLandscape, value[" + this.mCamera.mSupportLandscape + "->" + paramBoolean + "]");
      }
      this.mCamera.mSupportLandscape = paramBoolean;
    }
  }
  
  public void switchCamera(long paramLong)
  {
    if (this.mCamera.isCameraOpened())
    {
      this.switchCamera.seq = paramLong;
      ThreadManager.executeOnSubThread(this.switchCamera);
    }
  }
  
  class CloseCameraRunnable
    implements Runnable
  {
    private boolean mChangeStatus = true;
    public long seq = 0L;
    
    CloseCameraRunnable() {}
    
    public void run()
    {
      AVLog.w("CameraUtils", "closeCamera begin, mCamera[" + CameraUtils.this.mCamera + "], seq[" + this.seq + "]");
      ObserverDispatcher.instance().notifyObservers(CameraObserver.class, 3, new Object[0]);
      if (CameraUtils.this.mCamera != null) {
        CameraUtils.this.mCamera.closeCamera(this.seq);
      }
      ObserverDispatcher.instance().notifyObservers(CameraObserver.class, 4, new Object[] { Boolean.valueOf(true) });
      AVLog.w("CameraUtils", "closeCamera end, mCamera[" + CameraUtils.this.mCamera + "], seq[" + this.seq + "]");
    }
    
    public void setChangeStatus(boolean paramBoolean)
    {
      this.mChangeStatus = paramBoolean;
    }
    
    public String toString()
    {
      return this.seq + "";
    }
  }
  
  private class OpenCameraRunnable
    implements Runnable
  {
    boolean mOpening = false;
    long seq = 0L;
    
    private OpenCameraRunnable() {}
    
    public void run()
    {
      AVLog.w("CameraUtils", "openCamera begin, mOpening[" + this.mOpening + "], mCamera[" + CameraUtils.this.mCamera + "], seq[" + this.seq + "]");
      if (this.mOpening) {
        return;
      }
      this.mOpening = true;
      ObserverDispatcher.instance().notifyObservers(CameraObserver.class, 1, new Object[] { Boolean.valueOf(CameraUtils.this.mCamera.isCameraOpened()) });
      boolean bool = CameraUtils.this.mCamera.openCamera(CameraUtils.this.mSurfaceTexture);
      ObserverDispatcher.instance().notifyObservers(CameraObserver.class, 2, new Object[] { Boolean.valueOf(bool) });
      AVLog.w("CameraUtils", "openCamera end. result[" + bool + "], seq[" + this.seq + "]");
      this.mOpening = false;
    }
    
    public String toString()
    {
      return this.seq + "";
    }
  }
  
  class SwitchCameraRunnable
    implements Runnable
  {
    long seq = 0L;
    
    SwitchCameraRunnable() {}
    
    public void run()
    {
      AVLog.w("CameraUtils", "switchCamera begin, mCamera[" + CameraUtils.this.mCamera + "], seq[" + this.seq + "]");
      ObserverDispatcher.instance().notifyObservers(CameraObserver.class, 5, new Object[0]);
      boolean bool = false;
      if (CameraUtils.this.mCamera != null) {
        bool = CameraUtils.this.mCamera.switchCamera(this.seq, CameraUtils.this.mSurfaceTexture);
      }
      ObserverDispatcher.instance().notifyObservers(CameraObserver.class, 6, new Object[] { Boolean.valueOf(bool) });
      CameraUtils.access$402(CameraUtils.this, true);
      AVLog.w("CameraUtils", "switchCamera end, result[" + bool + "], mCamera[" + CameraUtils.this.mCamera + "], seq[" + this.seq + "]");
    }
    
    public String toString()
    {
      return this.seq + "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils
 * JD-Core Version:    0.7.0.1
 */