package com.tencent.mm.plugin.ball.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.d.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public f vkT;
  private e vkU;
  
  public b(f paramf, e parame)
  {
    this.vkT = paramf;
    this.vkU = parame;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(106281);
    Log.i("MicroMsg.FloatBallFadeInController", "stop FloatIndicatorController");
    this.vkT.a(null);
    AppMethodBeat.o(106281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.b
 * JD-Core Version:    0.7.0.1
 */