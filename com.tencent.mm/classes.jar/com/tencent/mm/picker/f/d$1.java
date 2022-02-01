package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.c;

final class d$1
  implements b
{
  d$1(d paramd) {}
  
  public final void onItemSelected(int paramInt)
  {
    AppMethodBeat.i(175360);
    if (this.pzC.pyH != null) {
      this.pzC.pyH.xX(this.pzC.pzz.getCurrentItem());
    }
    AppMethodBeat.o(175360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.picker.f.d.1
 * JD-Core Version:    0.7.0.1
 */