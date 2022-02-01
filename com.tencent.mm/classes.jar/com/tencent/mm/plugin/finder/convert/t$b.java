package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.y.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class t$b
  implements Runnable
{
  t$b(ViewGroup paramViewGroup, y.f paramf1, y.f paramf2) {}
  
  public final void run()
  {
    AppMethodBeat.i(201394);
    this.gZB.removeView((View)this.rOs.MLV);
    ((FrameLayout)this.rOt.MLV).getLayoutParams().height = -2;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 48;
    ((FrameLayout)this.rOt.MLV).addView((View)this.rOs.MLV, (ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(201394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t.b
 * JD-Core Version:    0.7.0.1
 */