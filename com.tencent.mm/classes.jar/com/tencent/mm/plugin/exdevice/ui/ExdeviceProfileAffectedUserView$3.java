package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceProfileAffectedUserView$3
  implements View.OnClickListener
{
  ExdeviceProfileAffectedUserView$3(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20011);
    ExdeviceProfileAffectedUserView.c(this.lNC).performClick();
    AppMethodBeat.o(20011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.3
 * JD-Core Version:    0.7.0.1
 */