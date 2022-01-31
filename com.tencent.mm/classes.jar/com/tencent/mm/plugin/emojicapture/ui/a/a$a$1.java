package com.tencent.mm.plugin.emojicapture.ui.a;

import a.f.a.m;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$a$1
  implements View.OnClickListener
{
  a$a$1(a.a parama, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2933);
    int i = this.lxW.jN();
    paramView = this.lxW.lxV.uQ(i);
    if (paramView != null)
    {
      m localm = this.lxW.lxV.lxR;
      if (localm != null) {
        localm.h(Integer.valueOf(i), paramView);
      }
    }
    this.lxX.requestFocus();
    AppMethodBeat.o(2933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */