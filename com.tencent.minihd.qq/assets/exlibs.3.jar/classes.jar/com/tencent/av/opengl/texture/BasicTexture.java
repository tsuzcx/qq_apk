package com.tencent.av.opengl.texture;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.av.opengl.glrender.GLCanvas;
import com.tencent.av.opengl.glrender.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.qav.log.AVLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class BasicTexture
{
  public static final int FORMAT_RGB = 0;
  public static final int FORMAT_SURFACE = 2;
  public static final int FORMAT_YUV = 1;
  private static final int MAX_TEXTURE_SIZE = 4096;
  protected static final int STATE_ERROR = -1;
  protected static final int STATE_LOADED = 1;
  protected static final int STATE_UNLOADED = 0;
  private static final String TAG = "BasicTexture";
  protected static final int UNSPECIFIED = -1;
  private static WeakHashMap<BasicTexture, Object> sAllTextures = new WeakHashMap();
  private static ThreadLocal<Class<BasicTexture>> sInFinalizer = new ThreadLocal();
  protected GLCanvas mCanvasRef = null;
  protected int mHeight = -1;
  protected int[] mId;
  protected int mLeft = 0;
  protected int mState;
  protected int mTextureHeight;
  protected int mTextureProgramId;
  protected int mTextureWidth;
  protected int mTop = 0;
  protected int mWidth = -1;
  protected int viewHeight;
  protected int viewWidth;
  
  protected BasicTexture()
  {
    this(null, 0);
  }
  
  protected BasicTexture(GLCanvas arg1, int paramInt)
  {
    setAssociatedCanvas(???);
    this.mState = paramInt;
    this.mTextureProgramId = 0;
    synchronized (sAllTextures)
    {
      sAllTextures.put(this, null);
      return;
    }
  }
  
  private void freeResource()
  {
    GLCanvas localGLCanvas = this.mCanvasRef;
    if ((localGLCanvas != null) && (this.mId != null))
    {
      localGLCanvas.unloadTexture(this);
      this.mId = null;
    }
    this.mState = 0;
    setAssociatedCanvas(null);
  }
  
  public static boolean inFinalizer()
  {
    return sInFinalizer.get() != null;
  }
  
  public static void invalidateAllTextures()
  {
    synchronized (sAllTextures)
    {
      Iterator localIterator = sAllTextures.keySet().iterator();
      if (localIterator.hasNext())
      {
        BasicTexture localBasicTexture = (BasicTexture)localIterator.next();
        localBasicTexture.mState = 0;
        localBasicTexture.setAssociatedCanvas(null);
      }
    }
  }
  
  public static void yieldAllTextures()
  {
    synchronized (sAllTextures)
    {
      Iterator localIterator = sAllTextures.keySet().iterator();
      if (localIterator.hasNext()) {
        ((BasicTexture)localIterator.next()).yield();
      }
    }
  }
  
  public void draw(GLCanvas paramGLCanvas, int paramInt1, int paramInt2)
  {
    paramGLCanvas.drawTexture(this, paramInt1, paramInt2, getSourceWidth(), getSourceHeight());
  }
  
  public void draw(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramGLCanvas.drawTexture(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      sInFinalizer.set(BasicTexture.class);
      recycle();
      sInFinalizer.set(null);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getFormatType()
  {
    return 0;
  }
  
  public int[] getId()
  {
    return this.mId;
  }
  
  public byte[] getLastYuvFrame()
  {
    return null;
  }
  
  public byte[] getLastYuvFrameCapture()
  {
    return null;
  }
  
  public int getLastYuvFrameCaptureHeight()
  {
    return 0;
  }
  
  public int getLastYuvFrameCaptureWidth()
  {
    return 0;
  }
  
  public Rect getSourceBounds()
  {
    return new Rect(this.mLeft, this.mTop, this.mLeft + this.mWidth, this.mTop + this.mHeight);
  }
  
  public int getSourceHeight()
  {
    return this.mHeight;
  }
  
  public int getSourceLeft()
  {
    return this.mLeft;
  }
  
  public int getSourceTop()
  {
    return this.mTop;
  }
  
  public int getSourceWidth()
  {
    return this.mWidth;
  }
  
  public abstract int getTarget();
  
  public int getTextureHeight()
  {
    return this.mTextureHeight;
  }
  
  TextureProgram getTextureProgram()
  {
    return TextureProgramFactory.make(this.mTextureProgramId);
  }
  
  public int getTextureWidth()
  {
    return this.mTextureWidth;
  }
  
  public int getViewHeight()
  {
    return this.viewHeight;
  }
  
  public int getViewWidth()
  {
    return this.viewWidth;
  }
  
  public boolean isFlippedVertically()
  {
    return false;
  }
  
  public boolean isLoaded()
  {
    return this.mState == 1;
  }
  
  public abstract boolean isOpaque();
  
  public abstract boolean onBind(GLCanvas paramGLCanvas);
  
  public ShaderParameter[] prepareTexture(GLCanvas paramGLCanvas)
  {
    TextureProgram localTextureProgram = getTextureProgram();
    GLES20.glUseProgram(localTextureProgram.getId());
    Utils.checkError();
    if ((!isOpaque()) || (paramGLCanvas.getAlpha() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      GLES20Canvas.enableBlending(bool);
      onBind(paramGLCanvas);
      int[] arrayOfInt = getId();
      int i = 0;
      while (i < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + i);
        Utils.checkError();
        GLES20.glBindTexture(getTarget(), arrayOfInt[i]);
        Utils.checkError();
        GLES20.glUniform1i(localTextureProgram.getParameters()[(i + 4)].handle, i);
        Utils.checkError();
        i += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.getParameters()[2].handle, paramGLCanvas.getAlpha());
    Utils.checkError();
    return localTextureProgram.getParameters();
  }
  
  public void recycle()
  {
    freeResource();
  }
  
  protected void setAssociatedCanvas(GLCanvas paramGLCanvas)
  {
    this.mCanvasRef = paramGLCanvas;
  }
  
  public void setSourceBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  public void setSourceLeft(int paramInt)
  {
    this.mLeft = paramInt;
  }
  
  public void setSourceSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void setSourceTop(int paramInt)
  {
    this.mTop = paramInt;
  }
  
  public void setTextureSize(int paramInt1, int paramInt2)
  {
    this.mTextureWidth = paramInt1;
    this.mTextureHeight = paramInt2;
    if ((this.mTextureWidth > 4096) || (this.mTextureHeight > 4096)) {
      AVLog.w("BasicTexture", String.format("texture is too large: %d x %d", new Object[] { Integer.valueOf(this.mTextureWidth), Integer.valueOf(this.mTextureHeight) }), new Exception());
    }
    if (this.mWidth == -1)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
  }
  
  public void setViewHeight(int paramInt)
  {
    this.viewHeight = paramInt;
  }
  
  public void setViewWidth(int paramInt)
  {
    this.viewWidth = paramInt;
  }
  
  public void yield()
  {
    freeResource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BasicTexture
 * JD-Core Version:    0.7.0.1
 */