package com.tencent.av.opengl.texture;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.glrender.GLCanvas;
import com.tencent.av.opengl.glrender.GLId;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.GlStringParser;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.utils.SoLoadUtil;
import com.tencent.qav.log.AVLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class YUVTexture
  extends BasicTexture
{
  public static final int MSG_FLUSH = 1;
  public static final int MSG_RENDER = 0;
  public static final int MSG_RESET = 2;
  public static final int MSG_SHOW = 3;
  private static final String TAG = "YUVTexture";
  public static float[] colormatrix = { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  public static float[] colormatrixYuv = { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  private static boolean sSoLoaded = false;
  private boolean isBind = true;
  private int mAngle = 0;
  private float mBrightness = 1.2F;
  private Context mContext;
  private float mContrast = 1.93F;
  private EventHandler mEventHandler;
  private GLRenderListener mListener;
  private int mNativeContext = 0;
  private GlStringParser mStringParser = null;
  private int mYuvFormat = 0;
  protected int yuvFormat = 0;
  
  public YUVTexture(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public YUVTexture(Context paramContext, int paramInt)
  {
    super(null, 0);
    this.mContext = paramContext;
    this.mTextureProgramId = 1;
    if (!sSoLoaded) {}
    try
    {
      SoLoadUtil.loadNativeLibrary(paramContext, "xplatform");
      sSoLoaded = true;
      Looper localLooper1 = Looper.myLooper();
      if (localLooper1 != null) {
        this.mEventHandler = new EventHandler(localLooper1);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          if (sSoLoaded)
          {
            Init(Utils.getGLVersion(paramContext), new WeakReference(this), paramInt);
            AVLog.d("YUVTexture", "YUVTexture init  ok ");
          }
          return;
        }
        catch (Exception paramContext)
        {
          Looper localLooper2;
          AVLog.e("YUVTexture", "YUVTexture init fail.", paramContext);
        }
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
        AVLog.d("YUVTexture", "xplatform loadLibrary failed ", localUnsatisfiedLinkError);
        localUnsatisfiedLinkError.printStackTrace();
        continue;
        localLooper2 = Looper.getMainLooper();
        if (localLooper2 != null) {
          this.mEventHandler = new EventHandler(localLooper2);
        } else {
          this.mEventHandler = null;
        }
      }
    }
  }
  
  private void notifyUpdateUI(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.mEventHandler != null)
    {
      paramObject = this.mEventHandler.obtainMessage(paramInt1, 0, 0, paramObject);
      if (paramInt2 == 0) {
        this.mEventHandler.sendMessage(paramObject);
      }
    }
    else
    {
      return;
    }
    this.mEventHandler.sendMessageDelayed(paramObject, paramInt2);
  }
  
  static void onNativeNotify(Object paramObject1, int paramInt, Object paramObject2)
  {
    paramObject1 = (YUVTexture)((WeakReference)paramObject1).get();
    if (paramObject1 != null)
    {
      if (paramInt != 0) {
        break label27;
      }
      paramObject1.notifyUpdateUI(0, 0, paramObject2);
    }
    label27:
    do
    {
      return;
      if (paramInt == 2)
      {
        paramObject1.notifyUpdateUI(2, 0, paramObject2);
        return;
      }
      if (paramInt == 1)
      {
        paramObject1.notifyUpdateUI(1, 0, paramObject2);
        return;
      }
    } while (paramInt != 3);
    paramObject1.notifyUpdateUI(3, 0, paramObject2);
  }
  
  private native int uploadContent(int[] paramArrayOfInt);
  
  native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  native void Uninit();
  
  public native boolean addYUVFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public native boolean addYuvFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native boolean canRender();
  
  public native void flush(boolean paramBoolean);
  
  public float getBrightness()
  {
    return this.mBrightness;
  }
  
  native byte[] getCaptureFrameTexture();
  
  public float getContrast()
  {
    return this.mContrast;
  }
  
  native byte[] getFaceFeature();
  
  public int getFormatType()
  {
    return 1;
  }
  
  native int getFrameCount();
  
  native int getFrameIndex();
  
  native byte[] getFrameTexture();
  
  public native int getImgAngle();
  
  public int getImgAngleEx()
  {
    if (this.isBind) {}
    try
    {
      this.mAngle = getImgAngle();
      return this.mAngle;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public native int getImgHeight();
  
  public native int getImgWidth();
  
  public byte[] getLastFaceFeature()
  {
    return getFaceFeature();
  }
  
  public int getLastYuvFormat()
  {
    return this.mYuvFormat;
  }
  
  public byte[] getLastYuvFrame()
  {
    return getFrameTexture();
  }
  
  public byte[] getLastYuvFrameCapture()
  {
    return getCaptureFrameTexture();
  }
  
  public int getLastYuvFrameCaptureHeight()
  {
    return getcaptureFrameHeight();
  }
  
  public int getLastYuvFrameCaptureWidth()
  {
    return getcaptureFrameWidth();
  }
  
  public int getTarget()
  {
    return 3553;
  }
  
  native int getcaptureFrameHeight();
  
  native int getcaptureFrameWidth();
  
  /* Error */
  public int initTexture(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 3553
    //   3: iload_2
    //   4: invokestatic 247	android/opengl/GLES20:glBindTexture	(II)V
    //   7: sipush 3553
    //   10: sipush 10241
    //   13: ldc 248
    //   15: invokestatic 252	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   18: sipush 3553
    //   21: sipush 10240
    //   24: ldc 253
    //   26: invokestatic 252	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   29: sipush 3553
    //   32: sipush 10242
    //   35: ldc 254
    //   37: invokestatic 252	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   40: sipush 3553
    //   43: sipush 10243
    //   46: ldc 254
    //   48: invokestatic 252	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   51: aload_0
    //   52: getfield 94	com/tencent/av/opengl/texture/YUVTexture:mContext	Landroid/content/Context;
    //   55: invokevirtual 260	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: iload_1
    //   59: invokevirtual 266	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 272	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   67: astore 4
    //   69: aload_3
    //   70: invokevirtual 277	java/io/InputStream:close	()V
    //   73: aload 4
    //   75: ifnull +37 -> 112
    //   78: sipush 3553
    //   81: iconst_0
    //   82: aload 4
    //   84: iconst_0
    //   85: invokestatic 283	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   88: aload 4
    //   90: invokevirtual 288	android/graphics/Bitmap:recycle	()V
    //   93: iload_2
    //   94: ireturn
    //   95: astore 4
    //   97: aload_3
    //   98: invokevirtual 277	java/io/InputStream:close	()V
    //   101: iconst_m1
    //   102: ireturn
    //   103: astore 4
    //   105: aload_3
    //   106: invokevirtual 277	java/io/InputStream:close	()V
    //   109: aload 4
    //   111: athrow
    //   112: iconst_m1
    //   113: ireturn
    //   114: astore_3
    //   115: goto -42 -> 73
    //   118: astore_3
    //   119: goto -18 -> 101
    //   122: astore_3
    //   123: goto -14 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	YUVTexture
    //   0	126	1	paramInt1	int
    //   0	126	2	paramInt2	int
    //   62	44	3	localInputStream	java.io.InputStream
    //   114	1	3	localIOException1	java.io.IOException
    //   118	1	3	localIOException2	java.io.IOException
    //   122	1	3	localIOException3	java.io.IOException
    //   67	22	4	localBitmap	android.graphics.Bitmap
    //   95	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   103	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   63	69	95	java/lang/OutOfMemoryError
    //   63	69	103	finally
    //   69	73	114	java/io/IOException
    //   97	101	118	java/io/IOException
    //   105	109	122	java/io/IOException
  }
  
  public boolean isBind()
  {
    return this.isBind;
  }
  
  public boolean isOpaque()
  {
    return true;
  }
  
  public boolean onBind(GLCanvas paramGLCanvas)
  {
    if (!isLoaded())
    {
      if (this.mId == null) {
        this.mId = new int[3];
      }
      int i = 0;
      while (i < this.mId.length)
      {
        this.mId[i] = paramGLCanvas.getGLId().generateTexture();
        i += 1;
      }
    }
    paramGLCanvas = getTextureProgram();
    if (this.isBind)
    {
      processFaceFeature();
      this.mYuvFormat = uploadContent(this.mId);
    }
    GLES20.glUniform1i(paramGLCanvas.getParameters()[10].handle, this.mYuvFormat);
    this.mState = 1;
    return true;
  }
  
  public native void onPause();
  
  public native void onResume();
  
  public ShaderParameter[] prepareTexture(GLCanvas paramGLCanvas)
  {
    TextureProgram localTextureProgram = getTextureProgram();
    paramGLCanvas = super.prepareTexture(paramGLCanvas);
    try
    {
      GLES20.glUniform1f(localTextureProgram.getParameters()[7].handle, getImgWidth());
      GLES20.glUniform1f(localTextureProgram.getParameters()[8].handle, getImgHeight());
      GLES20.glUniformMatrix4fv(localTextureProgram.getParameters()[9].handle, 1, false, colormatrix, 0);
      return paramGLCanvas;
    }
    catch (Exception localException) {}
    return paramGLCanvas;
  }
  
  public void processFaceFeature()
  {
    if (this.mListener != null)
    {
      byte[] arrayOfByte = getFaceFeature();
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        this.mListener.onFaceFeatureUpdate(arrayOfByte);
      }
    }
  }
  
  public void setGLRenderListener(GLRenderListener paramGLRenderListener)
  {
    this.mListener = paramGLRenderListener;
  }
  
  public void setIsBind(boolean paramBoolean)
  {
    this.isBind = paramBoolean;
  }
  
  public native boolean updateCurFrame();
  
  private class EventHandler
    extends Handler
  {
    public EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (YUVTexture.this.mListener == null);
            YUVTexture.this.mListener.onRenderFrame();
            return;
          } while (YUVTexture.this.mListener == null);
          YUVTexture.this.mListener.onRenderReset();
          return;
        } while (YUVTexture.this.mListener == null);
        YUVTexture.this.mListener.onRenderFlush();
        return;
      } while (YUVTexture.this.mListener == null);
      if (YUVTexture.this.mStringParser == null) {
        YUVTexture.access$102(YUVTexture.this, new GlStringParser('=', ';'));
      }
      paramMessage = (String)paramMessage.obj;
      YUVTexture.this.mStringParser.unflatten(paramMessage);
      int i = YUVTexture.this.mStringParser.getInt("width");
      int j = YUVTexture.this.mStringParser.getInt("height");
      int k = YUVTexture.this.mStringParser.getInt("angle");
      int m = YUVTexture.this.mStringParser.getInt("rotation", -1);
      YUVTexture.this.mListener.onRenderInfoNotify(i, j, k, m);
    }
  }
  
  public static abstract interface GLRenderListener
  {
    public abstract void onFaceFeatureUpdate(byte[] paramArrayOfByte);
    
    public abstract void onRenderFlush();
    
    public abstract void onRenderFrame();
    
    public abstract void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onRenderReset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YUVTexture
 * JD-Core Version:    0.7.0.1
 */