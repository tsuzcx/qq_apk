package com.tencent.mm.plugin.appbrand.widget.input;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KeyboardHeightProvider$3
  implements p
{
  KeyboardHeightProvider$3(ap paramap) {}
  
  @z(Ho=j.a.ON_PAUSE)
  void onPaused()
  {
    AppMethodBeat.i(324425);
    this.uJq.close();
    AppMethodBeat.o(324425);
  }
  
  @z(Ho=j.a.ON_RESUME)
  void onResumed()
  {
    AppMethodBeat.i(324420);
    this.uJq.start();
    AppMethodBeat.o(324420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.KeyboardHeightProvider.3
 * JD-Core Version:    0.7.0.1
 */