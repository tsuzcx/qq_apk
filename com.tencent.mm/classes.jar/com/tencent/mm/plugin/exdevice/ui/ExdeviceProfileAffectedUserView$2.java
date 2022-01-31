package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.base.MMHorList;

final class ExdeviceProfileAffectedUserView$2
  implements View.OnClickListener
{
  ExdeviceProfileAffectedUserView$2(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20010);
    paramView = r.Zn();
    if ((paramView != null) && (paramView.equals(ExdeviceProfileAffectedUserView.a(this.lNC))))
    {
      paramView = ExdeviceProfileAffectedUserView.b(this.lNC);
      if (ExdeviceProfileAffectedUserView.b(this.lNC).getVisibility() != 0) {
        break label64;
      }
    }
    label64:
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(20010);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.2
 * JD-Core Version:    0.7.0.1
 */