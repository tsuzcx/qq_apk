package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

final class PickPoi$1
  implements Runnable
{
  PickPoi$1(PickPoi paramPickPoi, View paramView, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(56080);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.val$view.getLayoutParams();
    localLayoutParams.bottomMargin = ((int)(PickPoi.a(this.uec).getHeight() / 2.0D + 0.5D) + ao.fromDPToPix(this.val$context, 20));
    this.val$view.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(56080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi.1
 * JD-Core Version:    0.7.0.1
 */