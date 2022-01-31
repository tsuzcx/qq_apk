package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import java.util.ArrayList;

final class SettingsPanel$4
  implements View.OnClickListener
{
  SettingsPanel$4(SettingsPanel paramSettingsPanel) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(11193);
    paramView = new ArrayList();
    paramView.add("Normal");
    paramView.add("Minimal-json");
    paramView = new b(this.jxW.getContext(), paramView);
    paramView.Rw(((Integer)SettingsPanel.c(this.jxW).getTag()).intValue());
    paramView.AIW = new b.a()
    {
      public final void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(141929);
        paramView.hide();
        if (paramAnonymousBoolean) {
          SettingsPanel.c(SettingsPanel.4.this.jxW).setText((CharSequence)paramAnonymousObject1);
        }
        SettingsPanel.b(SettingsPanel.4.this.jxW, paramView.dPp());
        AppMethodBeat.o(141929);
      }
    };
    paramView.Rv(a.fromDPToPix(this.jxW.getContext(), 288));
    paramView.show();
    AppMethodBeat.o(11193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.4
 * JD-Core Version:    0.7.0.1
 */