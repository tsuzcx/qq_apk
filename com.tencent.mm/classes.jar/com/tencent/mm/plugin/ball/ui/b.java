package com.tencent.mm.plugin.ball.ui;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public com.tencent.mm.plugin.ball.a.f ngF;
  com.tencent.mm.plugin.ball.d.f ngG;
  float ngW;
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.ball.d.f paramf1)
  {
    this.ngF = paramf;
    this.ngG = paramf1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106281);
    ac.i("MicroMsg.FloatBallFadeInController", "stop FloatIndicatorController");
    this.ngF.a(null);
    AppMethodBeat.o(106281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.b
 * JD-Core Version:    0.7.0.1
 */