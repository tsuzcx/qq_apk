package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ag$1
  implements Runnable
{
  ag$1(ag paramag) {}
  
  public final void run()
  {
    AppMethodBeat.i(123835);
    this.jog.jod = true;
    ab.v(this.jog.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
    this.jog.jnZ.postDelayed(this.jog.jof, ViewConfiguration.getLongPressTimeout());
    AppMethodBeat.o(123835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ag.1
 * JD-Core Version:    0.7.0.1
 */