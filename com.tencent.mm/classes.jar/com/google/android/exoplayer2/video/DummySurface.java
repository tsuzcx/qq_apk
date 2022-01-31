package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;

@TargetApi(17)
public final class DummySurface
  extends Surface
{
  private static boolean aTc;
  private static boolean aTd;
  public final boolean aFK;
  private final DummySurface.a aTe;
  private boolean aTf;
  
  private DummySurface(DummySurface.a parama, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.aTe = parama;
    this.aFK = paramBoolean;
  }
  
  public static boolean Z(Context paramContext)
  {
    boolean bool1 = true;
    for (;;)
    {
      int i;
      try
      {
        if (!aTd)
        {
          if (t.SDK_INT < 24) {
            continue;
          }
          String str = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
          if (str == null) {
            break label133;
          }
          if (!str.contains("EGL_EXT_protected_content"))
          {
            break label133;
            aTc = bool1;
            aTd = true;
          }
        }
        else
        {
          bool1 = aTc;
          return bool1;
        }
        if ((t.SDK_INT == 24) && ("samsung".equals(t.MANUFACTURER)))
        {
          i = 0;
        }
        else
        {
          if (t.SDK_INT < 26)
          {
            boolean bool2 = paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
            if (!bool2)
            {
              i = 0;
              break label135;
            }
          }
          i = 1;
          break label135;
          bool1 = false;
          continue;
          i = 0;
        }
      }
      finally {}
      label133:
      label135:
      if (i == 0) {}
    }
  }
  
  public static DummySurface h(Context paramContext, boolean paramBoolean)
  {
    if (t.SDK_INT < 17) {
      throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
    if ((!paramBoolean) || (Z(paramContext))) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      return new DummySurface.a().aD(paramBoolean);
    }
  }
  
  public final void release()
  {
    super.release();
    synchronized (this.aTe)
    {
      if (!this.aTf)
      {
        this.aTe.handler.sendEmptyMessage(3);
        this.aTf = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface
 * JD-Core Version:    0.7.0.1
 */