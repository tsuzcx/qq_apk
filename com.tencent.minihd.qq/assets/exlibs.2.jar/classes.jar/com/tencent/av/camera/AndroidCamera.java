package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.qav.log.AVLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

@TargetApi(9)
public class AndroidCamera
{
  private static final int BACK_CAMERA = 2;
  private static final int DEFAULT_FRAME_RATE = 15000;
  private static final int FRONT_CAMERA = 1;
  public static int PREVIEW_FORMAT = 17;
  public static int PREVIEW_HEIGHT = 0;
  public static int PREVIEW_WIDTH = 0;
  private static final String TAG = "AndroidCamera";
  public static boolean isCameraOpened = false;
  private static boolean isCameraOpening = false;
  private CameraInformation Info = new CameraInformation();
  private int mBackCameraAngle = 0;
  private CameraPreviewCallback mCallback = null;
  protected Camera mCamera = null;
  protected int mCameraId;
  private int mCameraNum;
  protected Context mContext = null;
  private int mCurCamera;
  private int mCurFrameRate = 15000;
  protected Display mDisplay = null;
  private int mFrontCameraAngle = 0;
  public boolean mSupportLandscape = false;
  private boolean mbIsTablet = false;
  private int nInFPS;
  private Camera.PreviewCallback previewCallback = new Camera.PreviewCallback()
  {
    public void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
    {
      int k = AndroidCamera.this.getOrientation();
      int j = AndroidCamera.this.getSysRotation() * 90;
      if (AndroidCamera.this.mSupportLandscape) {
        j = 0;
      }
      int i = 0;
      int n;
      label128:
      label163:
      int i1;
      int m;
      int i2;
      label234:
      long l;
      if (AndroidCamera.this.mCurCamera == 1)
      {
        i = (360 - (j + k) % 360) % 360;
        n = AndroidCamera.this.getRotation();
        j = n + i;
        if ((k != 270) && (k != 90)) {
          break label379;
        }
        i = j;
        if (n % 180 == 0)
        {
          i = j;
          if (AndroidCamera.this.mCurCamera == 1) {
            i = j + 180;
          }
        }
        if (AndroidCamera.this.mCurCamera != 1) {
          break label506;
        }
        if (AndroidCamera.this.mFrontCameraAngle <= 0) {
          break label484;
        }
        i += 360 - AndroidCamera.this.mFrontCameraAngle;
        i1 = i % 360 / 90;
        if (AndroidCamera.this.mCallback != null)
        {
          k = AndroidCamera.PREVIEW_WIDTH;
          m = AndroidCamera.PREVIEW_HEIGHT;
          i2 = paramAnonymousArrayOfByte.length;
          i = k;
          j = m;
          if (i2 != k * m * 3 / 2)
          {
            if (i2 != 460800) {
              break label551;
            }
            i = 640;
            j = 480;
          }
          paramAnonymousCamera = AndroidCamera.this.mCallback;
          l = AndroidCamera.this.nInFPS;
          if (AndroidCamera.this.mCurCamera != 1) {
            break label596;
          }
        }
      }
      label551:
      label596:
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousCamera.onPreviewData(paramAnonymousArrayOfByte, i, j, i1, n, l, bool);
        if ((AndroidCamera.this.supportUserBuffer) && (AndroidCamera.this.mCamera != null) && (paramAnonymousArrayOfByte != null))
        {
          byte[] arrayOfByte = FrameBufMgr.getInstance().getFrameBufByState(0);
          paramAnonymousCamera = arrayOfByte;
          if (arrayOfByte == null) {
            paramAnonymousCamera = paramAnonymousArrayOfByte;
          }
          if (paramAnonymousCamera != null) {
            FrameBufMgr.getInstance().setFrameBufState(paramAnonymousCamera, 1);
          }
          AndroidCamera.this.mCamera.addCallbackBuffer(paramAnonymousCamera);
        }
        return;
        if (AndroidCamera.this.mCurCamera != 2) {
          break;
        }
        i = (k - j + 360) % 360;
        break;
        label379:
        if (k != 0)
        {
          i = j;
          if (k != 180) {
            break label128;
          }
        }
        if ((n == 90) || (n == 270))
        {
          i = j;
          if (AndroidCamera.this.mCurCamera != 1) {
            break label128;
          }
          i = j;
          if (AndroidCamera.this.mbIsTablet) {
            break label128;
          }
          i = j + 180;
          break label128;
        }
        i = j;
        if (AndroidCamera.this.mCurCamera != 1) {
          break label128;
        }
        i = j;
        if (!AndroidCamera.this.mbIsTablet) {
          break label128;
        }
        i = j + 180;
        break label128;
        label484:
        i += AndroidCamera.this.getRemoteAngleForFrontCamera(n, AndroidCamera.this.mSupportLandscape);
        break label163;
        label506:
        if (AndroidCamera.this.mBackCameraAngle > 0)
        {
          i += AndroidCamera.this.mBackCameraAngle;
          break label163;
        }
        i += AndroidCamera.this.getRemoteAngleForBackCamera(n, AndroidCamera.this.mSupportLandscape);
        break label163;
        if (i2 == 1382400)
        {
          i = 1280;
          j = 720;
          break label234;
        }
        i = k;
        j = m;
        if (i2 != 115200) {
          break label234;
        }
        i = 320;
        j = 240;
        break label234;
      }
    }
  };
  public boolean supportUserBuffer = true;
  
  static
  {
    PREVIEW_WIDTH = 640;
    PREVIEW_HEIGHT = 480;
  }
  
  public AndroidCamera(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT < 16)
    {
      PREVIEW_WIDTH = 320;
      PREVIEW_HEIGHT = 240;
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (Math.max(paramContext.widthPixels, paramContext.heightPixels) <= 1280)
    {
      PREVIEW_WIDTH = 320;
      PREVIEW_HEIGHT = 240;
    }
  }
  
  private boolean allocateFrame(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      FrameBufMgr.getInstance().init(paramInt);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        AVLog.e("AndroidCamera", "allocateFrame fail.", localThrowable);
      }
    }
  }
  
  private void findBackCameraId()
  {
    this.mCameraId = 0;
    try
    {
      if (this.mCameraNum == 0) {
        this.mCameraNum = getNumberOfCamera();
      }
      if (this.mCameraNum > 0)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        int i = 0;
        for (;;)
        {
          if (i < this.mCameraNum)
          {
            Camera.getCameraInfo(i, localCameraInfo);
            int j = localCameraInfo.facing;
            if (j == 0) {}
            try
            {
              this.mCameraId = i;
              i += 1;
            }
            catch (RuntimeException localRuntimeException)
            {
              for (;;)
              {
                this.mCameraId = 0;
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCamera", "findBackCameraId fail.", localException);
    }
  }
  
  private int getPreviewBufferSize(int paramInt)
  {
    float f = ImageFormat.getBitsPerPixel(paramInt) * 1.0F / 8.0F;
    return (int)(PREVIEW_HEIGHT * PREVIEW_WIDTH * f);
  }
  
  private int getSysRotation()
  {
    try
    {
      int i = this.mDisplay.getRotation();
      return i;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCamera", "getSysRotation fail.", localException);
    }
    return 0;
  }
  
  private void reviseFormat()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if ((str1.equalsIgnoreCase("meizu")) && (str2.equalsIgnoreCase("meizu_m9"))) {
      PREVIEW_FORMAT = 18;
    }
    while ((!str1.equalsIgnoreCase("ZTE")) || (!str2.equalsIgnoreCase("ZTE-T U880"))) {
      return;
    }
    PREVIEW_FORMAT = 100;
  }
  
  private void setPreviewCallback()
  {
    if ((this.supportUserBuffer) && (GetCameraParams() != null))
    {
      if (allocateFrame(getPreviewBufferSize(GetCameraParams().getPreviewFormat())))
      {
        int k = 0;
        int i = 0;
        for (;;)
        {
          int j;
          if (i < FrameBufMgr.getInstance().getFrameBufCnt())
          {
            byte[] arrayOfByte = FrameBufMgr.getInstance().getFrameBufByState(0);
            j = k;
            if (arrayOfByte != null)
            {
              FrameBufMgr.getInstance().setFrameBufState(arrayOfByte, 1);
              this.mCamera.addCallbackBuffer(arrayOfByte);
              k += 1;
              j = k;
              if (k < 2) {}
            }
          }
          else
          {
            this.mCamera.setPreviewCallbackWithBuffer(this.previewCallback);
            return;
          }
          i += 1;
          k = j;
        }
      }
      this.mCamera.setPreviewCallback(this.previewCallback);
      return;
    }
    this.mCamera.setPreviewCallback(this.previewCallback);
  }
  
  private int setPreviewFormat(Camera.Parameters paramParameters)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        localList = (List)paramParameters.getClass().getMethod("getSupportedPreviewFormats", new Class[0]).invoke(paramParameters, (Object[])null);
        i = j;
        if (localList != null)
        {
          bool = localList.contains(Integer.valueOf(17));
          if (!bool) {
            continue;
          }
          i = 17;
        }
      }
      catch (Exception localException)
      {
        List localList;
        boolean bool;
        AVLog.e("AndroidCamera", "setPreviewFormat fail.", localException);
        int i = j;
        continue;
        paramParameters.setPreviewFormat(17);
      }
      if (i == 0) {
        continue;
      }
      paramParameters.setPreviewFormat(i);
      return i;
      if (localList.contains(Integer.valueOf(16)))
      {
        i = 16;
      }
      else if (localList.contains(Integer.valueOf(20)))
      {
        i = 20;
      }
      else if (localList.contains(Integer.valueOf(842094169)))
      {
        i = 842094169;
      }
      else if (localList.contains(Integer.valueOf(4)))
      {
        i = 4;
      }
      else if (localList.contains(Integer.valueOf(17)))
      {
        i = 17;
      }
      else if (localList.contains(Integer.valueOf(16)))
      {
        i = 16;
      }
      else if (localList.contains(Integer.valueOf(3)))
      {
        i = 3;
      }
      else if (localList.contains(Integer.valueOf(2)))
      {
        i = 2;
      }
      else if (localList.contains(Integer.valueOf(4)))
      {
        i = 4;
      }
      else if (localList.contains(Integer.valueOf(100)))
      {
        i = 100;
      }
      else if (localList.contains(Integer.valueOf(101)))
      {
        i = 101;
      }
      else if (localList.contains(Integer.valueOf(102)))
      {
        i = 102;
      }
      else if (localList.contains(Integer.valueOf(103)))
      {
        i = 103;
      }
      else
      {
        bool = localList.contains(Integer.valueOf(104));
        i = j;
        if (bool) {
          i = 104;
        }
      }
    }
    return 17;
  }
  
  private void setPreviewRate(Camera.Parameters paramParameters, int paramInt)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = (int[])((List)localObject2).get(0);
      paramInt = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        int i = Math.abs(localObject2[0] - this.mCurFrameRate) + Math.abs(localObject2[1] - this.mCurFrameRate);
        if (paramInt > i)
        {
          paramInt = i;
          localObject1 = localObject2;
        }
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
    }
  }
  
  private void setPreviewRate(Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    this.mCurFrameRate = paramInt2;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = (int[])((List)localObject2).get(0);
      paramInt1 = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        paramInt2 = Math.abs(localObject2[0] - this.mCurFrameRate) + Math.abs(localObject2[1] - this.mCurFrameRate);
        if (paramInt1 > paramInt2)
        {
          paramInt1 = paramInt2;
          localObject1 = localObject2;
        }
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
    }
  }
  
  private void setPreviewSize(int paramInt1, int paramInt2, Camera.Parameters paramParameters)
  {
    try
    {
      localObject = paramParameters.getClass().getMethod("getSupportedPreviewSizes", new Class[0]);
      if (localObject != null)
      {
        localObject = (List)((Method)localObject).invoke(paramParameters, (Object[])null);
        if (localObject != null)
        {
          localObject = getOptimalEqualPreviewSize((List)localObject, paramInt1, paramInt2);
          if (localObject != null)
          {
            PREVIEW_WIDTH = ((Camera.Size)localObject).width;
            PREVIEW_HEIGHT = ((Camera.Size)localObject).height;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String str;
        AVLog.e("AndroidCamera", "setPreviewSize fail.", localException);
      }
    }
    localObject = Build.MANUFACTURER;
    str = Build.MODEL;
    if (((((String)localObject).equalsIgnoreCase("samsung")) && (str.equalsIgnoreCase("GT-I9003"))) || ((((String)localObject).equalsIgnoreCase("samsung")) && (str.equalsIgnoreCase("GT-I9220"))) || ((((String)localObject).equalsIgnoreCase("samsung")) && (str.equalsIgnoreCase("GT-I7000"))))
    {
      PREVIEW_WIDTH = 320;
      PREVIEW_HEIGHT = 240;
    }
    paramParameters.setPreviewSize(PREVIEW_WIDTH, PREVIEW_HEIGHT);
  }
  
  public Camera.Parameters GetCameraParams()
  {
    try
    {
      Camera.Parameters localParameters = this.mCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCamera", "GetCameraParams", localException);
    }
    return null;
  }
  
  public boolean closeCamera(long paramLong)
  {
    try
    {
      if (this.mCamera != null)
      {
        if (isCameraOpened)
        {
          this.mCamera.setPreviewCallback(null);
          this.mCamera.stopPreview();
          this.mCamera.release();
        }
        releasePreviewFrameBuffer();
        this.mCamera = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.e("AndroidCamera", "closeCamera fail.", localException);
      }
    }
    finally {}
    isCameraOpened = false;
    return true;
  }
  
  protected CameraInformation getCameraDisplayOrientation(int paramInt, Camera paramCamera)
  {
    paramCamera = new CameraInformation();
    for (;;)
    {
      try
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, localCameraInfo);
        paramCamera.facing = localCameraInfo.facing;
        paramCamera.orientation = localCameraInfo.orientation;
        if (this.mDisplay == null)
        {
          paramCamera.rotation = -1;
          return paramCamera;
        }
        paramInt = getSysRotation();
        switch (paramInt)
        {
        }
      }
      catch (Exception localException)
      {
        paramCamera.rotation = 0;
        continue;
        paramCamera.rotation = 90;
        continue;
        paramCamera.rotation = 180;
        continue;
        paramCamera.rotation = 270;
        continue;
      }
      AVLog.d("AndroidCamera", String.format("getCameraDisplayOrientation tempInfo=%s", new Object[] { paramCamera }));
      return paramCamera;
      paramCamera.rotation = 0;
    }
  }
  
  public int getCameraNum()
  {
    return getNumberOfCamera();
  }
  
  protected Camera getFrontCamera()
  {
    return openFrontFacingCamera();
  }
  
  protected int getNumberOfCamera()
  {
    try
    {
      int i = Camera.getNumberOfCameras();
      return i;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCamera", "getNumberOfCamera fail.", localException);
    }
    return 1;
  }
  
  protected Camera.Size getOptimalEqualPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Camera.Size localSize1 = null;
    Iterator localIterator = paramList.iterator();
    Camera.Size localSize2;
    while (localIterator.hasNext())
    {
      localSize2 = (Camera.Size)localIterator.next();
      if ((localSize2.width == paramInt1) && (localSize2.height == paramInt2)) {
        return localSize2;
      }
    }
    if ((paramInt1 == 320) && (paramInt2 == 240))
    {
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localSize2 = (Camera.Size)localIterator.next();
        if ((localSize2.width == 640) && (localSize2.height == 480)) {
          return localSize2;
        }
      }
    }
    if (0 == 0) {
      localSize1 = getOptimalPreviewSize(paramList, PREVIEW_WIDTH, PREVIEW_HEIGHT);
    }
    return localSize1;
  }
  
  protected Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject1 = null;
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Camera.Size)localIterator.next();
        if ((Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.05D) && (Math.abs(((Camera.Size)localObject2).height - paramInt2) < d1))
        {
          localObject1 = localObject2;
          d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt2) < d1)
      {
        localObject1 = paramList;
        d1 = Math.abs(paramList.height - paramInt2);
      }
    }
  }
  
  public int getOrientation()
  {
    if (this.Info.orientation == -1)
    {
      if (this.mCurCamera == 1) {
        return 270;
      }
      if (this.mCurCamera == 2) {
        return 90;
      }
    }
    return this.Info.orientation;
  }
  
  int getPreviewAngleForBackCamera(boolean paramBoolean)
  {
    if (paramBoolean) {
      return ConfigSystemImpl.getLandscapeAngleForCamera(this.mContext, false, true, (byte)0, false) * 90;
    }
    return ConfigSystemImpl.getAngleForCamera(this.mContext, false, true, (byte)0, false) * 90;
  }
  
  int getPreviewAngleForFrontCamera(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 360 - ConfigSystemImpl.getLandscapeAngleForCamera(this.mContext, true, true, (byte)0, false) * 90;
    }
    return 360 - ConfigSystemImpl.getAngleForCamera(this.mContext, true, true, (byte)0, false) * 90;
  }
  
  int getRemoteAngleForBackCamera(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.getLandscapeAngleForCamera(this.mContext, false, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return ConfigSystemImpl.getAngleForCamera(this.mContext, false, false, b, false) * 90;
  }
  
  int getRemoteAngleForFrontCamera(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.getLandscapeAngleForCamera(this.mContext, true, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return ConfigSystemImpl.getAngleForCamera(this.mContext, true, false, b, false) * 90;
  }
  
  public int getRotation()
  {
    if (this.Info.rotation == -1) {
      return 0;
    }
    return this.Info.rotation;
  }
  
  public int getUserCameraAngle(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.mFrontCameraAngle;
    }
    return this.mBackCameraAngle;
  }
  
  public Camera getmCamera()
  {
    return this.mCamera;
  }
  
  public boolean isCameraOpened()
  {
    return isCameraOpened;
  }
  
  public boolean isCameraOpening()
  {
    return isCameraOpening;
  }
  
  public boolean isFrontCamera()
  {
    if (this.mCurCamera == 0) {}
    while (this.mCurCamera == 1) {
      return true;
    }
    return false;
  }
  
  protected boolean openBackCamera()
  {
    boolean bool = isCameraOpened;
    try
    {
      isCameraOpening = true;
      this.mCamera = Camera.open();
      if (this.mCamera != null)
      {
        this.mCurCamera = 2;
        isCameraOpened = true;
        isCameraOpening = false;
        findBackCameraId();
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        isCameraOpened = false;
        if (this.mCamera != null)
        {
          this.mCamera.release();
          this.mCamera = null;
        }
      }
      isCameraOpening = false;
    }
    return false;
  }
  
  @TargetApi(11)
  public boolean openCamera(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (isCameraOpened)
        {
          bool1 = true;
          isCameraOpened = bool1;
          return bool1;
        }
        if (this.mContext == null)
        {
          bool1 = false;
          continue;
        }
        if (this.mCurCamera == 0)
        {
          if ((!openFrontCamera()) && (!openBackCamera()))
          {
            bool1 = false;
            continue;
          }
          if (this.mCamera == null)
          {
            bool1 = false;
            continue;
          }
          setCameraPara(PREVIEW_WIDTH, PREVIEW_HEIGHT);
          bool1 = true;
          if (bool1) {
            break label168;
          }
          this.mCurCamera = 0;
          continue;
        }
        switch (this.mCurCamera)
        {
        }
      }
      finally {}
      if (openFrontCamera())
      {
        setCameraPara(PREVIEW_WIDTH, PREVIEW_HEIGHT);
        bool1 = true;
        continue;
        if (openBackCamera())
        {
          setCameraPara(PREVIEW_WIDTH, PREVIEW_HEIGHT);
          bool1 = true;
          continue;
          label168:
          boolean bool2;
          try
          {
            setPreviewCallback();
            this.mCamera.setPreviewTexture(paramSurfaceTexture);
            this.mCamera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            bool2 = false;
            bool1 = bool2;
          }
          if (this.mCamera != null)
          {
            this.mCamera.release();
            this.mCamera = null;
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  protected boolean openFrontCamera()
  {
    isCameraOpening = true;
    this.mCamera = getFrontCamera();
    if (this.mCamera == null)
    {
      isCameraOpened = false;
      isCameraOpening = false;
      return false;
    }
    if (this.mCameraNum == 0) {
      this.mCameraNum = 2;
    }
    this.mCurCamera = 1;
    isCameraOpened = true;
    isCameraOpening = false;
    return true;
  }
  
  protected Camera openFrontFacingCamera()
  {
    Camera.CameraInfo localCameraInfo = null;
    localObject2 = null;
    Camera localCamera = null;
    this.mCameraId = 0;
    Object localObject1 = localCameraInfo;
    try
    {
      if (this.mCameraNum == 0)
      {
        localObject1 = localCameraInfo;
        this.mCameraNum = getNumberOfCamera();
      }
      localObject1 = localCameraInfo;
      if (this.mCameraNum > 0)
      {
        localObject1 = localCameraInfo;
        localCameraInfo = new Camera.CameraInfo();
        int i = 0;
        for (;;)
        {
          localObject1 = localCamera;
          localObject2 = localCamera;
          if (i < this.mCameraNum)
          {
            localObject1 = localCamera;
            Camera.getCameraInfo(i, localCameraInfo);
            localObject1 = localCamera;
            int j = localCameraInfo.facing;
            if (j == 1) {}
            try
            {
              localCamera = Camera.open(i);
              this.mCameraId = i;
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localObject2 = null;
                localCamera = null;
                localObject1 = localObject2;
                this.mCameraId = 0;
                localObject1 = localObject2;
                AVLog.e("AndroidCamera", "openFrontFacingCamera fail.", localException2);
              }
            }
          }
        }
      }
      return localObject2;
    }
    catch (Exception localException1)
    {
      AVLog.w("AndroidCamera", "openFrontFacingCamera fail.", localException1);
      localObject2 = localObject1;
    }
  }
  
  public void releasePreviewFrameBuffer()
  {
    FrameBufMgr.getInstance().clear();
  }
  
  public boolean reopenCamera(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    try
    {
      boolean bool1;
      if (this.mCameraNum >= 1)
      {
        Camera localCamera = this.mCamera;
        if (localCamera != null) {}
      }
      else
      {
        bool1 = false;
        return bool1;
      }
      int i;
      if (paramInt1 != -1)
      {
        i = paramInt1;
        paramInt1 = paramInt2;
        if (paramInt2 != -1) {}
      }
      else
      {
        i = PREVIEW_WIDTH;
        paramInt1 = PREVIEW_HEIGHT;
      }
      closeCamera(paramLong);
      switch (this.mCurCamera)
      {
      }
      for (;;)
      {
        for (;;)
        {
          bool1 = bool2;
          if (!bool2) {
            break;
          }
          PREVIEW_WIDTH = i;
          PREVIEW_HEIGHT = paramInt1;
          try
          {
            setPreviewCallback();
            if (paramSurfaceTexture != null) {
              this.mCamera.setPreviewTexture(paramSurfaceTexture);
            }
            this.mCamera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            bool1 = false;
          }
        }
        if (openBackCamera())
        {
          setCameraPara(i, paramInt1);
          bool2 = true;
          continue;
          if (openFrontCamera())
          {
            setCameraPara(i, paramInt1);
            bool2 = true;
            continue;
            break;
          }
        }
      }
    }
    finally {}
  }
  
  public void resetCamera()
  {
    this.mCurCamera = 0;
  }
  
  public void setCameraAngleFix(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.mFrontCameraAngle = (paramInt % 360);
      return;
    }
    this.mBackCameraAngle = (paramInt % 360);
  }
  
  protected boolean setCameraDisplayOrientation(int paramInt, Camera paramCamera)
  {
    CameraInformation localCameraInformation = getCameraDisplayOrientation(paramInt, paramCamera);
    if (localCameraInformation.facing == 1)
    {
      paramInt = (360 - (getOrientation() + getRotation()) % 360) % 360;
      if (localCameraInformation.facing != 1) {
        break label111;
      }
    }
    label111:
    for (paramInt = (getPreviewAngleForFrontCamera(this.mSupportLandscape) + paramInt) % 360;; paramInt = (getPreviewAngleForBackCamera(this.mSupportLandscape) + paramInt) % 360)
    {
      setDisplayOrientation(paramCamera, paramInt);
      this.Info.facing = localCameraInformation.facing;
      this.Info.orientation = localCameraInformation.orientation;
      return true;
      paramInt = (getOrientation() - getRotation() + 360) % 360;
      break;
    }
  }
  
  public void setCameraNextTime(boolean paramBoolean)
  {
    resetCamera();
  }
  
  public void setCameraPara(int paramInt)
    throws RuntimeException
  {
    if (this.mCamera == null) {}
    for (;;)
    {
      return;
      synchronized (this.Info)
      {
        setCameraDisplayOrientation(this.mCameraId, this.mCamera);
        ??? = null;
        try
        {
          localObject2 = this.mCamera.getParameters();
          ??? = localObject2;
        }
        catch (Exception localException1)
        {
          try
          {
            this.mCamera.setParameters((Camera.Parameters)???);
            Object localObject2 = ((Camera.Parameters)???).getPreviewSize();
            if (localObject2 == null) {
              break label98;
            }
            PREVIEW_WIDTH = ((Camera.Size)localObject2).width;
            PREVIEW_HEIGHT = ((Camera.Size)localObject2).height;
            PREVIEW_FORMAT = ((Camera.Parameters)???).getPreviewFormat();
            localObject2 = new int[2];
            ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject2);
            this.nInFPS = ((localObject2[0] + localObject2[1]) / 2 / 1000);
            reviseFormat();
            return;
            localObject3 = finally;
            throw localObject3;
            localException1 = localException1;
            AVLog.e("AndroidCamera", "setCameraPara fail.", localException1);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              AVLog.e("AndroidCamera", "setCameraPara fail.", localException2);
            }
          }
        }
        if (??? == null) {
          continue;
        }
        setPreviewRate((Camera.Parameters)???, setPreviewFormat((Camera.Parameters)???), paramInt);
        ((Camera.Parameters)???).set("Rotation", 180);
      }
    }
  }
  
  protected void setCameraPara(int paramInt1, int paramInt2)
    throws RuntimeException
  {
    if (this.mCamera == null) {}
    for (;;)
    {
      return;
      synchronized (this.Info)
      {
        setCameraDisplayOrientation(this.mCameraId, this.mCamera);
        ??? = null;
        try
        {
          localObject2 = this.mCamera.getParameters();
          ??? = localObject2;
        }
        catch (Exception localException1)
        {
          try
          {
            this.mCamera.setParameters((Camera.Parameters)???);
            Object localObject2 = ((Camera.Parameters)???).getPreviewSize();
            paramInt1 = ((Camera.Parameters)???).getPreviewFormat();
            PREVIEW_WIDTH = ((Camera.Size)localObject2).width;
            PREVIEW_HEIGHT = ((Camera.Size)localObject2).height;
            PREVIEW_FORMAT = paramInt1;
            localObject2 = new int[2];
            ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject2);
            this.nInFPS = ((localObject2[0] + localObject2[1]) / 2 / 1000);
            reviseFormat();
            return;
            localObject3 = finally;
            throw localObject3;
            localException1 = localException1;
            AVLog.e("AndroidCamera", "setCameraPara fail.", localException1);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              AVLog.e("AndroidCamera", "setCameraPara fail.", localException2);
            }
          }
        }
        if (??? == null) {
          continue;
        }
        setPreviewRate((Camera.Parameters)???, setPreviewFormat((Camera.Parameters)???));
        setPreviewSize(paramInt1, paramInt2, (Camera.Parameters)???);
        ((Camera.Parameters)???).set("Rotation", 180);
      }
    }
  }
  
  public void setCameraPreviewCallback(CameraPreviewCallback paramCameraPreviewCallback)
  {
    this.mCallback = paramCameraPreviewCallback;
  }
  
  protected void setDisplayOrientation(Camera paramCamera, int paramInt)
  {
    AVLog.d("AndroidCamera", String.format("setDisplayOrientation degree=%s", new Object[] { Integer.valueOf(paramInt) }));
    try
    {
      paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE }).invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramCamera)
    {
      AVLog.e("AndroidCamera", "setDisplayOrientation fail.", paramCamera);
    }
  }
  
  public void setRotation(int paramInt)
  {
    this.Info.rotation = (paramInt % 360);
  }
  
  /* Error */
  public boolean switchCamera(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 6
    //   5: aload_0
    //   6: getfield 194	com/tencent/av/camera/AndroidCamera:mCameraNum	I
    //   9: iconst_1
    //   10: if_icmplt +14 -> 24
    //   13: aload_0
    //   14: getfield 81	com/tencent/av/camera/AndroidCamera:mCamera	Landroid/hardware/Camera;
    //   17: astore 7
    //   19: aload 7
    //   21: ifnonnull +11 -> 32
    //   24: iconst_0
    //   25: istore 5
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 5
    //   31: ireturn
    //   32: aload_0
    //   33: lload_1
    //   34: invokevirtual 513	com/tencent/av/camera/AndroidCamera:closeCamera	(J)Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 155	com/tencent/av/camera/AndroidCamera:mCurCamera	I
    //   42: istore 4
    //   44: iload 4
    //   46: tableswitch	default:+22 -> 68, 1:+56->102, 2:+79->125
    //   69: iconst_3
    //   70: istore 5
    //   72: iload 6
    //   74: ifeq -47 -> 27
    //   77: aload_0
    //   78: invokespecial 488	com/tencent/av/camera/AndroidCamera:setPreviewCallback	()V
    //   81: aload_0
    //   82: getfield 81	com/tencent/av/camera/AndroidCamera:mCamera	Landroid/hardware/Camera;
    //   85: aload_3
    //   86: invokevirtual 492	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   89: aload_0
    //   90: getfield 81	com/tencent/av/camera/AndroidCamera:mCamera	Landroid/hardware/Camera;
    //   93: invokevirtual 495	android/hardware/Camera:startPreview	()V
    //   96: iconst_1
    //   97: istore 5
    //   99: goto -72 -> 27
    //   102: aload_0
    //   103: invokevirtual 483	com/tencent/av/camera/AndroidCamera:openBackCamera	()Z
    //   106: ifeq -38 -> 68
    //   109: aload_0
    //   110: getstatic 66	com/tencent/av/camera/AndroidCamera:PREVIEW_WIDTH	I
    //   113: getstatic 68	com/tencent/av/camera/AndroidCamera:PREVIEW_HEIGHT	I
    //   116: invokevirtual 486	com/tencent/av/camera/AndroidCamera:setCameraPara	(II)V
    //   119: iconst_1
    //   120: istore 6
    //   122: goto -54 -> 68
    //   125: aload_0
    //   126: invokevirtual 481	com/tencent/av/camera/AndroidCamera:openFrontCamera	()Z
    //   129: ifeq -61 -> 68
    //   132: aload_0
    //   133: getstatic 66	com/tencent/av/camera/AndroidCamera:PREVIEW_WIDTH	I
    //   136: getstatic 68	com/tencent/av/camera/AndroidCamera:PREVIEW_HEIGHT	I
    //   139: invokevirtual 486	com/tencent/av/camera/AndroidCamera:setCameraPara	(II)V
    //   142: iconst_1
    //   143: istore 6
    //   145: goto -77 -> 68
    //   148: astore_3
    //   149: iconst_0
    //   150: istore 5
    //   152: goto -125 -> 27
    //   155: astore_3
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_3
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	AndroidCamera
    //   0	160	1	paramLong	long
    //   0	160	3	paramSurfaceTexture	SurfaceTexture
    //   42	3	4	i	int
    //   25	126	5	bool1	boolean
    //   3	141	6	bool2	boolean
    //   17	3	7	localCamera	Camera
    // Exception table:
    //   from	to	target	type
    //   77	96	148	java/lang/Exception
    //   5	19	155	finally
    //   32	44	155	finally
    //   77	96	155	finally
    //   102	119	155	finally
    //   125	142	155	finally
  }
  
  public class CameraInformation
  {
    int facing;
    int orientation = -1;
    int rotation = -1;
    
    public CameraInformation() {}
    
    public String toString()
    {
      return "CameraInformation{facing=" + this.facing + ", orientation=" + this.orientation + ", rotation=" + this.rotation + '}';
    }
  }
  
  public static abstract interface CameraPreviewCallback
  {
    public abstract void onPreviewData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean);
  }
  
  public static abstract interface RotationAngle
  {
    public static final int _0 = 0;
    public static final int _180 = 180;
    public static final int _270 = 270;
    public static final int _90 = 90;
    public static final int unset = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.camera.AndroidCamera
 * JD-Core Version:    0.7.0.1
 */