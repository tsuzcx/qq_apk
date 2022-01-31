package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;

public final class e$a
{
  final e aUk;
  final Handler handler;
  
  public e$a(Handler paramHandler, e parame)
  {
    if (parame != null) {}
    for (paramHandler = (Handler)a.E(paramHandler);; paramHandler = null)
    {
      this.handler = paramHandler;
      this.aUk = parame;
      return;
    }
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if (this.aUk != null) {
      this.handler.post(new e.a.5(this, paramInt1, paramInt2, paramInt3, paramFloat));
    }
  }
  
  public final void c(Surface paramSurface)
  {
    if (this.aUk != null) {
      this.handler.post(new e.a.6(this, paramSurface));
    }
  }
  
  public final void e(d paramd)
  {
    if (this.aUk != null) {
      this.handler.post(new e.a.7(this, paramd));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.e.a
 * JD-Core Version:    0.7.0.1
 */