package com.tencent.luggage.game.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(130705);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/luggage/game/widget/input/WAGameInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (a.a(this.eow) != null) {
      a.a(this.eow).onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/widget/input/WAGameInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(130705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a.1
 * JD-Core Version:    0.7.0.1
 */