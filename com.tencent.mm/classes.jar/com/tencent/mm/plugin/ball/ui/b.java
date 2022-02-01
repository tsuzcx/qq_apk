package com.tencent.mm.plugin.ball.ui;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.d.e;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public f nME;
  e nMF;
  float nMU;
  
  public b(f paramf, e parame)
  {
    this.nME = paramf;
    this.nMF = parame;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106281);
    ae.i("MicroMsg.FloatBallFadeInController", "stop FloatIndicatorController");
    this.nME.a(null);
    AppMethodBeat.o(106281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.b
 * JD-Core Version:    0.7.0.1
 */