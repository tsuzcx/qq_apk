package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.plugin.sport.ui.SportChartView.a;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class ExdeviceProfileUI$22
  implements MMSwitchBtn.a
{
  ExdeviceProfileUI$22(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(20047);
    if (ExdeviceProfileUI.F(this.lOl) != null)
    {
      if (!paramBoolean) {
        break label57;
      }
      ExdeviceProfileUI.G(this.lOl).a(SportChartView.a.sqx);
    }
    for (;;)
    {
      ExdeviceProfileUI.G(this.lOl).dz(ExdeviceProfileUI.F(this.lOl));
      AppMethodBeat.o(20047);
      return;
      label57:
      ExdeviceProfileUI.G(this.lOl).a(SportChartView.a.sqw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.22
 * JD-Core Version:    0.7.0.1
 */