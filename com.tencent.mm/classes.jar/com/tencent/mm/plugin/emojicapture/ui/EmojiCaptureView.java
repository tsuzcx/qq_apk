package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.mm.plugin.emojicapture.ui.a.e;
import com.tencent.mm.sdk.platformtools.y;

public final class EmojiCaptureView
  extends GLSurfaceView
{
  private final String TAG = "MicroMsg.EmojiCaptureView";
  private final e jog;
  
  public EmojiCaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setZOrderOnTop(true);
    setEGLContextFactory((GLSurfaceView.EGLContextFactory)new b());
    setEGLConfigChooser((GLSurfaceView.EGLConfigChooser)new a());
    getHolder().setFormat(1);
    this.jog = new e();
    setRenderer((GLSurfaceView.Renderer)this.jog);
    setRenderMode(0);
    y.i(this.TAG, "EmojiCaptureView init finish");
  }
  
  public final e getRenderer()
  {
    return this.jog;
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    y.i(this.TAG, "surfaceChanged");
    queueEvent((Runnable)new EmojiCaptureView.a(this));
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceCreated(paramSurfaceHolder);
    y.i(this.TAG, "surfaceCreated");
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    y.i(this.TAG, "surfaceDestroyed");
    queueEvent((Runnable)new EmojiCaptureView.b(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureView
 * JD-Core Version:    0.7.0.1
 */