package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class aj$b
  implements Runnable
{
  aj$b(ViewGroup paramViewGroup, aa.f paramf1, aa.f paramf2) {}
  
  public final void run()
  {
    AppMethodBeat.i(272395);
    this.kJH.removeView((View)this.xmw.aaBC);
    ((FrameLayout)this.xmx.aaBC).getLayoutParams().height = -2;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 48;
    ((FrameLayout)this.xmx.aaBC).addView((View)this.xmw.aaBC, (ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(272395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aj.b
 * JD-Core Version:    0.7.0.1
 */