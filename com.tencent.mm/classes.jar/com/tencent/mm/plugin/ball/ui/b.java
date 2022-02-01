package com.tencent.mm.plugin.ball.ui;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.d.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public f oXA;
  e oXB;
  float oXQ;
  
  public b(f paramf, e parame)
  {
    this.oXA = paramf;
    this.oXB = parame;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106281);
    Log.i("MicroMsg.FloatBallFadeInController", "stop FloatIndicatorController");
    this.oXA.a(null);
    AppMethodBeat.o(106281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.b
 * JD-Core Version:    0.7.0.1
 */