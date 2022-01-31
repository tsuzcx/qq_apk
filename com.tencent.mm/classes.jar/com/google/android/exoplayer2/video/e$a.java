package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  final e bcH;
  final Handler handler;
  
  public e$a(Handler paramHandler, e parame)
  {
    AppMethodBeat.i(96043);
    if (parame != null) {}
    for (paramHandler = (Handler)a.checkNotNull(paramHandler);; paramHandler = null)
    {
      this.handler = paramHandler;
      this.bcH = parame;
      AppMethodBeat.o(96043);
      return;
    }
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(96045);
    if (this.bcH != null) {
      this.handler.post(new e.a.5(this, paramInt1, paramInt2, paramInt3, paramFloat));
    }
    AppMethodBeat.o(96045);
  }
  
  public final void d(Surface paramSurface)
  {
    AppMethodBeat.i(96046);
    if (this.bcH != null) {
      this.handler.post(new e.a.6(this, paramSurface));
    }
    AppMethodBeat.o(96046);
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(96047);
    if (this.bcH != null) {
      this.handler.post(new e.a.7(this, paramd));
    }
    AppMethodBeat.o(96047);
  }
  
  public final void l(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96044);
    if (this.bcH != null) {
      this.handler.post(new e.a.4(this, paramInt, paramLong));
    }
    AppMethodBeat.o(96044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.e.a
 * JD-Core Version:    0.7.0.1
 */