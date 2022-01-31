package com.tencent.mm.plugin.emojicapture.ui.a;

import a.d.a.a;
import a.n;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.sdk.platformtools.bk;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.xwalk.core.Log;

public final class e
  implements GLSurfaceView.Renderer
{
  private final String TAG = "MicroMsg.EmojiCaptureViewRenderer";
  public int fvY;
  public int fvZ;
  public int fwu;
  private int height;
  public f jrM = new f();
  public byte[] jrN;
  public boolean jrO;
  a<n> jrP;
  private int width;
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    if (this.jrO)
    {
      Log.i(this.TAG, "do clear frame");
      paramGL10 = b.jqU;
      b.a.aKZ();
      this.jrN = null;
      this.jrM.destroy();
      this.jrM = new f();
      this.jrM.cJ(this.width, this.height);
      this.jrO = false;
    }
    do
    {
      do
      {
        return;
      } while (this.jrN == null);
      this.jrM.aLb();
      bk.UZ();
      this.jrM.c(this.jrN, this.fvY, this.fvZ, this.fwu);
      paramGL10 = this.jrP;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Log.i(this.TAG, "onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    this.width = paramInt1;
    this.height = paramInt2;
    this.jrM.cJ(paramInt1, paramInt2);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Log.i(this.TAG, "onSurfaceCreated");
    paramGL10 = b.jqU;
    b.a.aKZ();
  }
  
  public final void onSurfaceDestroy()
  {
    this.jrM.destroy();
    this.jrN = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.e
 * JD-Core Version:    0.7.0.1
 */