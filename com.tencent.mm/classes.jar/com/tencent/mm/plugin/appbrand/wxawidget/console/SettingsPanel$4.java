package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
    paramView = new ArrayList();
    paramView.add("Normal");
    paramView.add("Minimal-json");
    paramView = new b(this.hEJ.getContext(), paramView);
    paramView.IC(((Integer)SettingsPanel.c(this.hEJ).getTag()).intValue());
    paramView.wov = new b.a()
    {
      public final void f(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        paramView.hide();
        if (paramAnonymousBoolean) {
          SettingsPanel.c(SettingsPanel.4.this.hEJ).setText((CharSequence)paramAnonymousObject);
        }
        SettingsPanel.b(SettingsPanel.4.this.hEJ, paramView.cKk());
      }
    };
    paramView.IB(a.fromDPToPix(this.hEJ.getContext(), 288));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.4
 * JD-Core Version:    0.7.0.1
 */