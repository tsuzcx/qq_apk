package com.tencent.mm.plugin.appbrand.widget.input;

import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KeyboardHeightProvider$3
  implements k
{
  KeyboardHeightProvider$3(ap paramap) {}
  
  @t(jl=h.a.ON_PAUSE)
  void onPaused()
  {
    AppMethodBeat.i(229649);
    this.rym.close();
    AppMethodBeat.o(229649);
  }
  
  @t(jl=h.a.ON_RESUME)
  void onResumed()
  {
    AppMethodBeat.i(229646);
    this.rym.start();
    AppMethodBeat.o(229646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.KeyboardHeightProvider.3
 * JD-Core Version:    0.7.0.1
 */