package com.tencent.mm.plugin.ball.ui;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public com.tencent.mm.plugin.ball.a.f mEA;
  com.tencent.mm.plugin.ball.d.f mEB;
  float mER;
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, com.tencent.mm.plugin.ball.d.f paramf1)
  {
    this.mEA = paramf;
    this.mEB = paramf1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106281);
    ad.i("MicroMsg.FloatBallFadeInController", "stop FloatIndicatorController");
    this.mEA.a(null);
    AppMethodBeat.o(106281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.b
 * JD-Core Version:    0.7.0.1
 */