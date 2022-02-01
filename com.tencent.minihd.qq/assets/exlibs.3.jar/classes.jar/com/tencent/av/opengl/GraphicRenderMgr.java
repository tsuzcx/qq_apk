package com.tencent.av.opengl;

import android.content.Context;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.utils.SoLoadUtil;
import com.tencent.qav.QavSDK;
import com.tencent.qav.log.AVLog;
import java.nio.ByteBuffer;

public class GraphicRenderMgr
{
  private static final String TAG = "GraphicRenderMgr";
  private static final Object sAutoFocusCallbackLock = new Object();
  private static volatile GraphicRenderMgr sGraphicRenderMgr;
  public static boolean sSoLoaded = false;
  public int decoderPtrRef = 0;
  private FocusDetectCallback mAutoFocusCallback = null;
  
  private GraphicRenderMgr()
  {
    loadSo();
  }
  
  public static native int checkhwyuv(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public static GraphicRenderMgr getInstance()
  {
    if (sGraphicRenderMgr == null) {}
    try
    {
      if (sGraphicRenderMgr == null) {
        sGraphicRenderMgr = new GraphicRenderMgr();
      }
      return sGraphicRenderMgr;
    }
    finally {}
  }
  
  private boolean loadSo()
  {
    if (!sSoLoaded) {}
    try
    {
      Context localContext = QavSDK.getInstance().getContext();
      SoLoadUtil.loadNativeLibrary(localContext, "c++_shared");
      SoLoadUtil.loadNativeLibrary(localContext, "xplatform");
      SoLoadUtil.loadNativeLibrary(localContext, "stlport_shared");
      SoLoadUtil.loadNativeLibrary(localContext, "SDKCommon");
      SoLoadUtil.loadNativeLibrary(localContext, "qav_graphics");
      sSoLoaded = true;
      return sSoLoaded;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.w("GraphicRenderMgr", "loadSo fail.", localException);
      }
    }
  }
  
  public static native void nativeConvertNV21ToI420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void nativeConvertRGBA2NV21(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native int sendCameraFrame2Native(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, byte[] paramArrayOfByte2, int paramInt6, int paramInt7);
  
  public native void clearCameraFrames();
  
  public native String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  public native void flushGlRender(String paramString);
  
  public native int getBeautyConfig();
  
  public native int getRecvDecoderFrameFunctionptr();
  
  public native void nativeRotatePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeScalePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void onFocusDetectResult(boolean paramBoolean)
  {
    AVLog.d("GraphicRenderMgr", "onFocusDetectResult:" + paramBoolean);
    if (this.mAutoFocusCallback != null) {
      this.mAutoFocusCallback.onFocusDetectResult(paramBoolean);
    }
  }
  
  public native void onUinChanged(String paramString1, String paramString2);
  
  public int sendCameraFrame(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, boolean paramBoolean, float[] paramArrayOfFloat, byte[] paramArrayOfByte2, int paramInt6, int paramInt7)
  {
    if ((!paramBoolean) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3)) {
      return sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramBoolean, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfByte2, paramInt6, paramInt7);
    }
    return sendCameraFrame2Native(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramBoolean, 0.0F, 0.0F, 0.0F, paramArrayOfByte2, paramInt6, paramInt7);
  }
  
  public native void setAccountUin(String paramString);
  
  public native void setBeautyConfig(int paramInt);
  
  public native void setBeautyFlag(int paramInt);
  
  public void setBeautyOrFaceConfig(int paramInt1, int paramInt2)
  {
    int i = 0;
    try
    {
      int j = getBeautyConfig();
      i = j;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          setBeautyConfig(paramInt1 + paramInt2 * 100);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          localUnsatisfiedLinkError2.printStackTrace();
          return;
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        localUnsatisfiedLinkError1.printStackTrace();
      }
    }
    if (paramInt2 == 0)
    {
      paramInt2 = i / 100;
      paramInt1 = Math.min(paramInt1, 99);
    }
    while (paramInt2 != 1) {}
    try
    {
      setBeautyConfig(paramInt1 * 100 + i % 100);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
    {
      localUnsatisfiedLinkError3.printStackTrace();
    }
  }
  
  public native void setFocusConfig(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);
  
  public void setFocusDetectCallback(FocusDetectCallback paramFocusDetectCallback)
  {
    synchronized (sAutoFocusCallbackLock)
    {
      this.mAutoFocusCallback = paramFocusDetectCallback;
      return;
    }
  }
  
  public native void setGlRender(String paramString, YUVTexture paramYUVTexture);
  
  public native void setIsFocusing(boolean paramBoolean);
  
  public native void setLowlightAndVideoDenoiseInfo(int[] paramArrayOfInt);
  
  public native void setProcessEncodeFrameFunctionPtr(int paramInt);
  
  public native boolean setYuvFrame(String paramString, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static abstract interface FocusDetectCallback
  {
    public abstract void onFocusDetectResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.GraphicRenderMgr
 * JD-Core Version:    0.7.0.1
 */