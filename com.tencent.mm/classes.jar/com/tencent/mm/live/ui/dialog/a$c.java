package com.tencent.mm.live.ui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$c
  implements View.OnClickListener
{
  a$c(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190595);
    if (this.gGa.isShowing()) {
      this.gGa.cancel();
    }
    AppMethodBeat.o(190595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a.c
 * JD-Core Version:    0.7.0.1
 */