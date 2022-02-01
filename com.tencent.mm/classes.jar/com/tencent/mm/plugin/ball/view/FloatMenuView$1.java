package com.tencent.mm.plugin.ball.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FloatMenuView$1
  implements View.OnClickListener
{
  FloatMenuView$1(FloatMenuView paramFloatMenuView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106484);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/ball/view/FloatMenuView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    FloatMenuView.a(this.nMn);
    a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(106484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView.1
 * JD-Core Version:    0.7.0.1
 */