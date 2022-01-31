package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.TimerTask;

public final class c$a
  extends TimerTask
{
  private float progress = 50.0F;
  
  public c$a(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(132944);
    if (this.progress >= 100.0F)
    {
      cancel();
      AppMethodBeat.o(132944);
      return;
    }
    this.progress += 0.33F;
    al.d(new c.a.1(this));
    AppMethodBeat.o(132944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.a
 * JD-Core Version:    0.7.0.1
 */