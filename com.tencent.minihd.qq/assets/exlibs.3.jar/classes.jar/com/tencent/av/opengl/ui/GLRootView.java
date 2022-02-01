package com.tencent.av.opengl.ui;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.av.opengl.glrender.GLCanvas;
import com.tencent.av.opengl.glrender.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.UploadedTexture;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.qav.log.AVLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static final int FLAG_INITIALIZED = 1;
  private static final int FLAG_NEED_LAYOUT = 2;
  private static final String TAG = "GLRootView";
  private GLCanvas mCanvas;
  protected GLView mContentView;
  private boolean mFirstDraw = true;
  private int mFlags = 2;
  private boolean mFreeze;
  private final Condition mFreezeCondition = this.mRenderLock.newCondition();
  private boolean mInDownState = false;
  private final int mIntervalMs = 20;
  private boolean mIsSmallScreen = false;
  private long mLastRenderTime = 0L;
  private int mPendingCount = 0;
  private final ReentrantLock mRenderLock = new ReentrantLock();
  private volatile boolean mRenderRequested = false;
  private Runnable mRequestRenderOnAnimationFrame = new Runnable()
  {
    public void run()
    {
      GLRootView.this.requestRender();
    }
  };
  
  public GLRootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GLRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    this.mFlags |= 0x1;
    setBackgroundDrawable(null);
    setEGLContextClientVersion(Utils.getGLVersion(paramContext));
    setRenderer(this);
  }
  
  private void layoutContentPane()
  {
    this.mFlags &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    if ((this.mContentView != null) && (i != 0) && (j != 0)) {
      this.mContentView.layout(0, 0, i, j);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1)) {
      this.mInDownState = false;
    }
    do
    {
      this.mRenderLock.lock();
      boolean bool1 = bool2;
      try
      {
        if (this.mContentView != null)
        {
          bool1 = bool2;
          if (this.mContentView.dispatchTouchEvent(paramMotionEvent)) {
            bool1 = true;
          }
        }
        if ((i == 0) && (bool1)) {
          this.mInDownState = true;
        }
        return bool1;
      }
      finally
      {
        this.mRenderLock.unlock();
      }
    } while ((this.mInDownState) || (i == 0));
    return false;
  }
  
  /* Error */
  protected void finalize()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: invokestatic 149	com/tencent/av/opengl/program/TextureProgramFactory:clear	()V
    //   3: aload_0
    //   4: invokevirtual 152	com/tencent/av/opengl/ui/GLRootView:unfreeze	()V
    //   7: aload_0
    //   8: invokespecial 154	android/opengl/GLSurfaceView:finalize	()V
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: invokevirtual 152	com/tencent/av/opengl/ui/GLRootView:unfreeze	()V
    //   17: aload_0
    //   18: invokespecial 154	android/opengl/GLSurfaceView:finalize	()V
    //   21: return
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 152	com/tencent/av/opengl/ui/GLRootView:unfreeze	()V
    //   27: aload_0
    //   28: invokespecial 154	android/opengl/GLSurfaceView:finalize	()V
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	GLRootView
    //   12	1	1	localException	Exception
    //   22	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	3	12	java/lang/Exception
    //   0	3	22	finally
  }
  
  public void freeze()
  {
    this.mRenderLock.lock();
    this.mFreeze = true;
    this.mRenderLock.unlock();
  }
  
  public void lockRenderThread()
  {
    this.mRenderLock.lock();
  }
  
  protected void onDetachedFromWindow()
  {
    unfreeze();
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    
    if (this.mIsSmallScreen) {}
    for (float f = 0.0F;; f = 1.0F)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, f);
      GLES20.glClear(16640);
      this.mRenderLock.lock();
      while (this.mFreeze) {
        this.mFreezeCondition.awaitUninterruptibly();
      }
    }
    label89:
    try
    {
      if (this.mPendingCount > 0) {
        this.mPendingCount -= 1;
      }
    }
    finally {}
    try
    {
      onDrawFrameLocked(paramGL10);
    }
    catch (Exception paramGL10)
    {
      this.mRenderRequested = false;
      this.mRenderLock.unlock();
      break label89;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
    if ((this.mFirstDraw) && (this.mContentView != null))
    {
      this.mFirstDraw = false;
      this.mContentView.onFirstDraw();
    }
    this.mLastRenderTime = SystemClock.elapsedRealtime();
  }
  
  protected void onDrawFrameLocked(GL10 paramGL10)
  {
    this.mCanvas.deleteRecycledResources();
    UploadedTexture.resetUploadLimit();
    this.mRenderRequested = false;
    if ((this.mFlags & 0x2) != 0) {
      layoutContentPane();
    }
    if (this.mContentView != null) {
      this.mContentView.render(this.mCanvas);
    }
    for (;;)
    {
      if (UploadedTexture.uploadLimitReached()) {
        requestRender();
      }
      return;
      this.mCanvas.clearBuffer();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      requestLayoutContentPane();
    }
  }
  
  public void onPause()
  {
    unfreeze();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mRenderRequested = false;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AVLog.i("GLRootView", "onSurfaceChanged: " + paramInt1 + "x" + paramInt2 + ", gl10: " + paramGL10.toString());
    Process.setThreadPriority(-4);
    this.mCanvas.setSize(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.mRenderLock.lock();
    try
    {
      this.mCanvas = new GLES20Canvas();
      BasicTexture.invalidateAllTextures();
      this.mRenderLock.unlock();
      TextureProgramFactory.clear();
      setRenderMode(0);
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  public void requestLayoutContentPane()
  {
    this.mRenderLock.lock();
    try
    {
      if (this.mContentView != null)
      {
        i = this.mFlags;
        if ((i & 0x2) == 0) {}
      }
      else
      {
        return;
      }
      int i = this.mFlags;
      if ((i & 0x1) == 0) {
        return;
      }
      this.mFlags |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  public void requestRender()
  {
    if (this.mRenderRequested) {
      return;
    }
    this.mRenderRequested = true;
    long l = SystemClock.elapsedRealtime() - this.mLastRenderTime;
    if ((l > 0L) && (l < 20L))
    {
      try
      {
        if (this.mPendingCount >= 2) {
          return;
        }
      }
      finally {}
      this.mPendingCount += 1;
      super.postDelayed(this.mRequestRenderOnAnimationFrame, 20L - l);
      return;
    }
    post(this.mRequestRenderOnAnimationFrame);
  }
  
  public void setContentPane(GLView paramGLView)
  {
    if (this.mContentView == paramGLView) {}
    do
    {
      return;
      if (this.mContentView != null)
      {
        if (this.mInDownState)
        {
          long l = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.mContentView.dispatchTouchEvent(localMotionEvent);
          localMotionEvent.recycle();
          this.mInDownState = false;
        }
        this.mContentView.detachFromRoot();
        BasicTexture.yieldAllTextures();
      }
      this.mContentView = paramGLView;
    } while (paramGLView == null);
    paramGLView.attachToRoot(this);
    requestLayoutContentPane();
  }
  
  public void setSmallScreen(boolean paramBoolean)
  {
    this.mIsSmallScreen = paramBoolean;
    if (this.mIsSmallScreen)
    {
      setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      getHolder().setFormat(-3);
      return;
    }
    if (Utils.USE_888_PIXEL_FORMAT)
    {
      setEGLConfigChooser(8, 8, 8, 0, 0, 0);
      getHolder().setFormat(3);
      return;
    }
    setEGLConfigChooser(5, 6, 5, 0, 0, 0);
    getHolder().setFormat(4);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    unfreeze();
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    unfreeze();
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    unfreeze();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  public void unfreeze()
  {
    this.mRenderLock.lock();
    this.mFreeze = false;
    this.mFreezeCondition.signalAll();
    this.mRenderLock.unlock();
  }
  
  public void unlockRenderThread()
  {
    this.mRenderLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */