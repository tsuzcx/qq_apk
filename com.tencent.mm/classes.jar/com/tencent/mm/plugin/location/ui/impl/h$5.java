package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$5
  implements View.OnClickListener
{
  h$5(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113698);
    this.ohE.bMd();
    this.ohE.hideVKB();
    this.ohE.activity.finish();
    AppMethodBeat.o(113698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.5
 * JD-Core Version:    0.7.0.1
 */