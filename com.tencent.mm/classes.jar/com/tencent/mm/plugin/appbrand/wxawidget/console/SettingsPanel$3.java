package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

final class SettingsPanel$3
  implements View.OnClickListener
{
  SettingsPanel$3(SettingsPanel paramSettingsPanel) {}
  
  public final void onClick(View paramView)
  {
    paramView = new ArrayList();
    paramView.add("MHADrawableView");
    paramView.add("MTextureView");
    paramView.add("MSurfaceView");
    paramView.add("MCanvasView");
    paramView.add("MDrawableView");
    paramView = new b(this.hEJ.getContext(), paramView);
    paramView.IC(((Integer)SettingsPanel.b(this.hEJ).getTag()).intValue());
    paramView.wov = new SettingsPanel.3.1(this, paramView);
    paramView.IB(a.fromDPToPix(this.hEJ.getContext(), 288));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.3
 * JD-Core Version:    0.7.0.1
 */