package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113592);
    this.ofz.bMd();
    this.ofz.hideVKB();
    this.ofz.activity.finish();
    AppMethodBeat.o(113592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.4
 * JD-Core Version:    0.7.0.1
 */