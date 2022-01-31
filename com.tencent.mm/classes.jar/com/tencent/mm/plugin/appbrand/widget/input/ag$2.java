package com.tencent.mm.plugin.appbrand.widget.input;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;
import com.tencent.mm.sdk.platformtools.ab;

final class ag$2
  implements Runnable
{
  ag$2(ag paramag) {}
  
  public final void run()
  {
    AppMethodBeat.i(123836);
    if (!this.jog.jod)
    {
      AppMethodBeat.o(123836);
      return;
    }
    d.f localf = d.cr(this.jog.jnZ);
    if ((this.jog.job == null) || (Math.abs(this.jog.job.x - localf.x) > 1.0F) || (Math.abs(this.jog.job.y - localf.y) > 1.0F))
    {
      ab.v(this.jog.TAG, "check long press timeout, but view has moved.");
      AppMethodBeat.o(123836);
      return;
    }
    if (this.jog.joc == null)
    {
      AppMethodBeat.o(123836);
      return;
    }
    this.jog.jod = false;
    this.jog.jnZ.removeCallbacks(this.jog.joe);
    AppMethodBeat.o(123836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag.2
 * JD-Core Version:    0.7.0.1
 */