package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$7
  implements View.OnFocusChangeListener
{
  c$7(c paramc) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(113601);
    if (paramBoolean) {
      this.ogD.showVKB();
    }
    AppMethodBeat.o(113601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.7
 * JD-Core Version:    0.7.0.1
 */