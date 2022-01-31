package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.plugin.sport.ui.SportChartView.a;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class ExdeviceProfileUI$22
  implements MMSwitchBtn.a
{
  ExdeviceProfileUI$22(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    if (ExdeviceProfileUI.F(this.jEM) != null)
    {
      if (!paramBoolean) {
        break label45;
      }
      ExdeviceProfileUI.G(this.jEM).a(SportChartView.a.puh);
    }
    for (;;)
    {
      ExdeviceProfileUI.G(this.jEM).cN(ExdeviceProfileUI.F(this.jEM));
      return;
      label45:
      ExdeviceProfileUI.G(this.jEM).a(SportChartView.a.pug);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.22
 * JD-Core Version:    0.7.0.1
 */