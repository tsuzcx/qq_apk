package com.tencent.av.opengl.utils;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.qav.log.AVLog;

public class Utils
{
  public static final boolean AT_LEAST_16;
  public static final boolean CAN_START_PREVIEW_IN_JPEG_CALLBACK;
  public static final boolean ENABLE_PHOTO_EDITOR;
  public static final boolean HAS_ACTION_BAR;
  public static final boolean HAS_ANNOUNCE_FOR_ACCESSIBILITY;
  public static final boolean HAS_AUTO_FOCUS_MOVE_CALLBACK;
  public static final boolean HAS_CAMERA_FOCUS_AREA;
  public static final boolean HAS_CAMERA_HDR;
  public static final boolean HAS_CAMERA_METERING_AREA;
  public static final boolean HAS_CANCELLATION_SIGNAL;
  public static final boolean HAS_DISPLAY_LISTENER;
  public static final boolean HAS_EFFECTS_RECORDING = false;
  public static final boolean HAS_EFFECTS_RECORDING_CONTEXT_INPUT;
  public static final boolean HAS_FACE_DETECTION;
  public static final boolean HAS_GET_CAMERA_DISABLED;
  public static final boolean HAS_GET_SUPPORTED_VIDEO_SIZE;
  public static final boolean HAS_GLES20_REQUIRED;
  public static final boolean HAS_INTENT_EXTRA_LOCAL_ONLY;
  public static final boolean HAS_MEDIA_ACTION_SOUND;
  public static final boolean HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT;
  public static final boolean HAS_MEDIA_MUXER;
  public static final boolean HAS_MEDIA_PROVIDER_FILES_TABLE;
  public static final boolean HAS_MOTION_EVENT_TRANSFORM;
  public static final boolean HAS_MTP;
  public static final boolean HAS_OBJECT_ANIMATION;
  public static final boolean HAS_OPTIONS_IN_MUTABLE;
  public static final boolean HAS_ORIENTATION_LOCK;
  public static final boolean HAS_POST_ON_ANIMATION;
  public static final boolean HAS_RELEASE_SURFACE_TEXTURE;
  public static final boolean HAS_REMOTE_VIEWS_SERVICE;
  public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_FACTORY;
  public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER;
  public static final boolean HAS_ROTATION_ANIMATION;
  public static final boolean HAS_SET_BEAM_PUSH_URIS;
  public static final boolean HAS_SET_DEFALT_BUFFER_SIZE;
  public static final boolean HAS_SET_ICON_ATTRIBUTE;
  public static final boolean HAS_SET_SYSTEM_UI_VISIBILITY;
  public static final boolean HAS_SURFACE_TEXTURE;
  public static final boolean HAS_SURFACE_TEXTURE_RECORDING;
  public static final boolean HAS_TIME_LAPSE_RECORDING;
  public static final boolean HAS_VIEW_PROPERTY_ANIMATOR;
  public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION;
  public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE;
  public static final boolean HAS_VIEW_TRANSFORM_PROPERTIES;
  public static final boolean HAS_ZOOM_WHEN_RECORDING;
  private static final String TAG = "Utils";
  public static final boolean USE_888_PIXEL_FORMAT;
  
  static
  {
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = true;
      AT_LEAST_16 = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label705;
      }
      bool1 = true;
      label26:
      USE_888_PIXEL_FORMAT = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label710;
      }
      bool1 = true;
      label40:
      ENABLE_PHOTO_EDITOR = bool1;
      HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE = hasField(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
      HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION = hasField(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION");
      HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = hasField(MediaStore.MediaColumns.class, "WIDTH");
      if (Build.VERSION.SDK_INT < 16) {
        break label715;
      }
      bool1 = true;
      label84:
      HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label720;
      }
      bool1 = true;
      label98:
      HAS_REUSING_BITMAP_IN_BITMAP_FACTORY = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label725;
      }
      bool1 = true;
      label112:
      HAS_SET_BEAM_PUSH_URIS = bool1;
      HAS_SET_DEFALT_BUFFER_SIZE = hasMethod("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
      HAS_RELEASE_SURFACE_TEXTURE = hasMethod("android.graphics.SurfaceTexture", "release", new Class[0]);
      if (Build.VERSION.SDK_INT < 11) {
        break label730;
      }
      bool1 = true;
      label166:
      HAS_SURFACE_TEXTURE = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label735;
      }
      bool1 = true;
      label180:
      HAS_MTP = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label740;
      }
      bool1 = true;
      label194:
      HAS_AUTO_FOCUS_MOVE_CALLBACK = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label745;
      }
      bool1 = true;
      label208:
      HAS_REMOTE_VIEWS_SERVICE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label750;
      }
      bool1 = true;
      label222:
      HAS_INTENT_EXTRA_LOCAL_ONLY = bool1;
      HAS_SET_SYSTEM_UI_VISIBILITY = hasMethod(View.class, "setSystemUiVisibility", new Class[] { Integer.TYPE });
      bool1 = false;
    }
    try
    {
      if ((!hasMethod(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) || (!hasMethod(Camera.class, "startFaceDetection", new Class[0])) || (!hasMethod(Camera.class, "stopFaceDetection", new Class[0]))) {
        break label755;
      }
      boolean bool3 = hasMethod(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
      if (!bool3) {
        break label755;
      }
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      label316:
      break label316;
    }
    HAS_FACE_DETECTION = bool1;
    HAS_GET_CAMERA_DISABLED = hasMethod(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = true;
      label349:
      HAS_MEDIA_ACTION_SOUND = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label765;
      }
      bool1 = true;
      label363:
      HAS_TIME_LAPSE_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label770;
      }
      bool1 = true;
      label377:
      HAS_ZOOM_WHEN_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label775;
      }
      bool1 = true;
      label391:
      HAS_CAMERA_FOCUS_AREA = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label780;
      }
      bool1 = true;
      label405:
      HAS_CAMERA_METERING_AREA = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label785;
      }
      bool1 = true;
      label419:
      HAS_MOTION_EVENT_TRANSFORM = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label790;
      }
      bool1 = true;
      label433:
      HAS_EFFECTS_RECORDING_CONTEXT_INPUT = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label795;
      }
      bool1 = true;
      label447:
      HAS_GET_SUPPORTED_VIDEO_SIZE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label800;
      }
      bool1 = true;
      label461:
      HAS_SET_ICON_ATTRIBUTE = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label805;
      }
      bool1 = true;
      label475:
      HAS_MEDIA_PROVIDER_FILES_TABLE = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label810;
      }
      bool1 = true;
      label489:
      HAS_SURFACE_TEXTURE_RECORDING = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label815;
      }
      bool1 = true;
      label503:
      HAS_ACTION_BAR = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label820;
      }
      bool1 = true;
      label517:
      HAS_VIEW_TRANSFORM_PROPERTIES = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label825;
      }
      bool1 = true;
      label531:
      HAS_CAMERA_HDR = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label830;
      }
      bool1 = true;
      label545:
      HAS_OPTIONS_IN_MUTABLE = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label835;
      }
      bool1 = true;
      label559:
      CAN_START_PREVIEW_IN_JPEG_CALLBACK = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label840;
      }
      bool1 = true;
      label573:
      HAS_VIEW_PROPERTY_ANIMATOR = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label845;
      }
      bool1 = true;
      label587:
      HAS_POST_ON_ANIMATION = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label850;
      }
      bool1 = true;
      label601:
      HAS_ANNOUNCE_FOR_ACCESSIBILITY = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label855;
      }
      bool1 = true;
      label615:
      HAS_OBJECT_ANIMATION = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label860;
      }
      bool1 = true;
      label629:
      HAS_GLES20_REQUIRED = bool1;
      HAS_ROTATION_ANIMATION = hasField(WindowManager.LayoutParams.class, "rotationAnimation");
      if (Build.VERSION.SDK_INT < 18) {
        break label865;
      }
      bool1 = true;
      label653:
      HAS_ORIENTATION_LOCK = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label870;
      }
      bool1 = true;
      label667:
      HAS_CANCELLATION_SIGNAL = bool1;
      if (Build.VERSION.SDK_INT < 18) {
        break label875;
      }
      bool1 = true;
      label681:
      HAS_MEDIA_MUXER = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label880;
      }
    }
    label705:
    label710:
    label715:
    label720:
    label725:
    label730:
    label735:
    label740:
    label745:
    label750:
    label880:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      HAS_DISPLAY_LISTENER = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
      bool1 = false;
      break label40;
      bool1 = false;
      break label84;
      bool1 = false;
      break label98;
      bool1 = false;
      break label112;
      bool1 = false;
      break label166;
      bool1 = false;
      break label180;
      bool1 = false;
      break label194;
      bool1 = false;
      break label208;
      bool1 = false;
      break label222;
      label755:
      bool1 = false;
      break label316;
      bool1 = false;
      break label349;
      label765:
      bool1 = false;
      break label363;
      bool1 = false;
      break label377;
      bool1 = false;
      break label391;
      bool1 = false;
      break label405;
      bool1 = false;
      break label419;
      bool1 = false;
      break label433;
      bool1 = false;
      break label447;
      bool1 = false;
      break label461;
      bool1 = false;
      break label475;
      bool1 = false;
      break label489;
      bool1 = false;
      break label503;
      bool1 = false;
      break label517;
      bool1 = false;
      break label531;
      bool1 = false;
      break label545;
      bool1 = false;
      break label559;
      bool1 = false;
      break label573;
      bool1 = false;
      break label587;
      bool1 = false;
      break label601;
      bool1 = false;
      break label615;
      bool1 = false;
      break label629;
      bool1 = false;
      break label653;
      bool1 = false;
      break label667;
      bool1 = false;
      break label681;
    }
  }
  
  public static int checkError()
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      AVLog.d("Utils", "checkError error = " + i);
    }
    return i;
  }
  
  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static long clamp(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 > paramLong3) {
      return paramLong3;
    }
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {}
      while (!paramObject1.equals(paramObject2)) {
        return false;
      }
    }
    return true;
  }
  
  public static int getGLVersion(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
      if (paramContext == null) {
        return 1;
      }
      int i = paramContext.reqGlEsVersion;
      if (i >= 131072) {
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 1;
  }
  
  private static boolean hasField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass.getDeclaredField(paramString);
      return true;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  private static boolean hasMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass) {}
    return false;
  }
  
  private static boolean hasMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static boolean isOpaque(int paramInt)
  {
    return paramInt >>> 24 == 255;
  }
  
  public static abstract interface VERSION_CODES
  {
    public static final int GINGERBREAD = 9;
    public static final int GINGERBREAD_MR1 = 10;
    public static final int HONEYCOMB = 11;
    public static final int HONEYCOMB_MR1 = 12;
    public static final int HONEYCOMB_MR2 = 13;
    public static final int ICE_CREAM_SANDWICH = 14;
    public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    public static final int JELLY_BEAN = 16;
    public static final int JELLY_BEAN_MR1 = 17;
    public static final int JELLY_BEAN_MR2 = 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.utils.Utils
 * JD-Core Version:    0.7.0.1
 */