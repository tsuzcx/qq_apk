package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.y.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class t$b
  implements Runnable
{
  t$b(ViewGroup paramViewGroup, y.f paramf1, y.f paramf2) {}
  
  public final void run()
  {
    AppMethodBeat.i(201832);
    this.hco.removeView((View)this.rWS.NiY);
    ((FrameLayout)this.rWT.NiY).getLayoutParams().height = -2;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 48;
    ((FrameLayout)this.rWT.NiY).addView((View)this.rWS.NiY, (ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(201832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t.b
 * JD-Core Version:    0.7.0.1
 */