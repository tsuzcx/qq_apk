package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$12
  implements View.OnClickListener
{
  c$12(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113607);
    c.a(this.ogD, c.access$1600(), c.o(this.ogD).lxQ, false);
    this.ogD.hideVKB();
    this.ogD.activity.finish();
    AppMethodBeat.o(113607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.12
 * JD-Core Version:    0.7.0.1
 */