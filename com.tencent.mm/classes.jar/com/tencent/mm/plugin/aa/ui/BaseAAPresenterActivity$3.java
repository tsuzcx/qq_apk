package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseAAPresenterActivity$3
  implements View.OnClickListener
{
  BaseAAPresenterActivity$3(BaseAAPresenterActivity paramBaseAAPresenterActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40779);
    this.gqc.hideTenpayKB();
    AppMethodBeat.o(40779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.3
 * JD-Core Version:    0.7.0.1
 */