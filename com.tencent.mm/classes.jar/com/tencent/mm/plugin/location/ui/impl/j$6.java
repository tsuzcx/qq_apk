package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$6
  implements View.OnClickListener
{
  j$6(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56151);
    this.sWY.cKe();
    this.sWY.hideVKB();
    this.sWY.activity.finish();
    AppMethodBeat.o(56151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.6
 * JD-Core Version:    0.7.0.1
 */