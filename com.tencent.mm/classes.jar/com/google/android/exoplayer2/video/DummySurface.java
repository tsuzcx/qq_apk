package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
public final class DummySurface
  extends Surface
{
  private static boolean bHx;
  private static boolean bHy;
  private boolean bHA;
  private final DummySurface.a bHz;
  public final boolean btd;
  
  private DummySurface(DummySurface.a parama, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.bHz = parama;
    this.btd = paramBoolean;
  }
  
  public static boolean aj(Context paramContext)
  {
    boolean bool1 = true;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(93263);
        if (!bHy)
        {
          if (x.SDK_INT < 24) {
            continue;
          }
          String str = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
          if (str == null) {
            break label143;
          }
          if (!str.contains("EGL_EXT_protected_content"))
          {
            break label143;
            bHx = bool1;
            bHy = true;
          }
        }
        else
        {
          bool1 = bHx;
          AppMethodBeat.o(93263);
          return bool1;
        }
        if ((x.SDK_INT == 24) && ("samsung".equals(x.MANUFACTURER)))
        {
          i = 0;
        }
        else
        {
          if (x.SDK_INT < 26)
          {
            boolean bool2 = paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
            if (!bool2)
            {
              i = 0;
              break label145;
            }
          }
          i = 1;
          break label145;
          bool1 = false;
          continue;
          i = 0;
        }
      }
      finally {}
      label143:
      label145:
      if (i == 0) {}
    }
  }
  
  public static DummySurface j(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(93264);
    if (x.SDK_INT < 17)
    {
      paramContext = new UnsupportedOperationException("Unsupported prior to API level 17");
      AppMethodBeat.o(93264);
      throw paramContext;
    }
    if ((!paramBoolean) || (aj(paramContext))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      paramContext = new DummySurface.a().aY(paramBoolean);
      AppMethodBeat.o(93264);
      return paramContext;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(93265);
    super.release();
    synchronized (this.bHz)
    {
      if (!this.bHA)
      {
        this.bHz.handler.sendEmptyMessage(3);
        this.bHA = true;
      }
      AppMethodBeat.o(93265);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface
 * JD-Core Version:    0.7.0.1
 */