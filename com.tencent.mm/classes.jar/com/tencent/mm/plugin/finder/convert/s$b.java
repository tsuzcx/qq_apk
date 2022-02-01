package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.v.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class s$b
  implements Runnable
{
  s$b(ViewGroup paramViewGroup, v.f paramf1, v.f paramf2) {}
  
  public final void run()
  {
    AppMethodBeat.i(201303);
    this.gFR.removeView((View)this.rbC.KUQ);
    ((FrameLayout)this.rbD.KUQ).getLayoutParams().height = -2;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 48;
    ((FrameLayout)this.rbD.KUQ).addView((View)this.rbC.KUQ, (ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(201303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.s.b
 * JD-Core Version:    0.7.0.1
 */