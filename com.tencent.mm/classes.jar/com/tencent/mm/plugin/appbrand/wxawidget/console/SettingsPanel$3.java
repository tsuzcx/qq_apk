package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

final class SettingsPanel$3
  implements View.OnClickListener
{
  SettingsPanel$3(SettingsPanel paramSettingsPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11191);
    paramView = new ArrayList();
    paramView.add("MHADrawableView");
    paramView.add("MTextureView");
    paramView.add("MSurfaceView");
    paramView.add("MCanvasView");
    paramView.add("MDrawableView");
    paramView = new b(this.jxW.getContext(), paramView);
    paramView.Rw(((Integer)SettingsPanel.b(this.jxW).getTag()).intValue());
    paramView.AIW = new SettingsPanel.3.1(this, paramView);
    paramView.Rv(a.fromDPToPix(this.jxW.getContext(), 288));
    paramView.show();
    AppMethodBeat.o(11191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.3
 * JD-Core Version:    0.7.0.1
 */