package com.tencent.mm.live.view.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$b
  implements View.OnClickListener
{
  public static final b kMc;
  
  static
  {
    AppMethodBeat.i(196769);
    kMc = new b();
    AppMethodBeat.o(196769);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196766);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(196766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b.b
 * JD-Core Version:    0.7.0.1
 */