package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$5
  implements View.OnClickListener
{
  b$5(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149739);
    this.hJK.cancel();
    AppMethodBeat.o(149739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.5
 * JD-Core Version:    0.7.0.1
 */