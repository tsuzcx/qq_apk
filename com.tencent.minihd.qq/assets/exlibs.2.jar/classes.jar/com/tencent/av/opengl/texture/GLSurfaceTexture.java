package com.tencent.av.opengl.texture;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.av.opengl.glrender.GLCanvas;
import com.tencent.av.opengl.glrender.GLId;

public class GLSurfaceTexture
  extends BasicTexture
  implements SurfaceTexture.OnFrameAvailableListener
{
  private float[] mSTMatrix = new float[16];
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  
  private void releaseSurface()
  {
    if (this.mSurfaceTexture != null)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        this.mSurfaceTexture.release();
      }
      if (Build.VERSION.SDK_INT >= 11) {
        this.mSurfaceTexture.setOnFrameAvailableListener(null);
      }
      this.mSurfaceTexture = null;
    }
    if (this.mSurface != null)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
  }
  
  public void draw(GLCanvas paramGLCanvas, int paramInt1, int paramInt2)
  {
    if (this.mSurfaceTexture != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
      }
      paramGLCanvas.drawTexture(this, this.mSTMatrix, paramInt1, paramInt2, getSourceWidth(), getSourceHeight());
    }
  }
  
  public void draw(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mSurfaceTexture != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.mSurfaceTexture.updateTexImage();
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
      }
      paramGLCanvas.drawTexture(this, this.mSTMatrix, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public int getFormatType()
  {
    return 2;
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public int getTarget()
  {
    return 36197;
  }
  
  public boolean isFlippedVertically()
  {
    return true;
  }
  
  public boolean isOpaque()
  {
    return true;
  }
  
  public boolean onBind(GLCanvas paramGLCanvas)
  {
    if (this.mId == null)
    {
      this.mId = new int[1];
      this.mId[0] = paramGLCanvas.getGLId().generateTexture();
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.mSurfaceTexture = new SurfaceTexture(this.mId[0]);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
      }
      if (Build.VERSION.SDK_INT >= 14) {
        this.mSurface = new Surface(this.mSurfaceTexture);
      }
      this.mState = 1;
    }
    return isLoaded();
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public void recycle()
  {
    super.recycle();
    releaseSurface();
  }
  
  public void yield()
  {
    super.yield();
    releaseSurface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.texture.GLSurfaceTexture
 * JD-Core Version:    0.7.0.1
 */