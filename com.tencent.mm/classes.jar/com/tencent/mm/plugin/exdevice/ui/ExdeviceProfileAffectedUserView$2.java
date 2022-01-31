package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.base.MMHorList;

final class ExdeviceProfileAffectedUserView$2
  implements View.OnClickListener
{
  ExdeviceProfileAffectedUserView$2(ExdeviceProfileAffectedUserView paramExdeviceProfileAffectedUserView) {}
  
  public final void onClick(View paramView)
  {
    paramView = q.Gj();
    if ((paramView != null) && (paramView.equals(ExdeviceProfileAffectedUserView.a(this.jEe))))
    {
      paramView = ExdeviceProfileAffectedUserView.b(this.jEe);
      if (ExdeviceProfileAffectedUserView.b(this.jEe).getVisibility() != 0) {
        break label52;
      }
    }
    label52:
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.2
 * JD-Core Version:    0.7.0.1
 */