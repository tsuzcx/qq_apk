package com.tencent.mm.plugin.ball.ui;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public com.tencent.mm.plugin.ball.a.f nHb;
  com.tencent.mm.plugin.ball.d.f nHc;
  float nHs;
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.ball.d.f paramf1)
  {
    this.nHb = paramf;
    this.nHc = paramf1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106281);
    ad.i("MicroMsg.FloatBallFadeInController", "stop FloatIndicatorController");
    this.nHb.a(null);
    AppMethodBeat.o(106281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.b
 * JD-Core Version:    0.7.0.1
 */