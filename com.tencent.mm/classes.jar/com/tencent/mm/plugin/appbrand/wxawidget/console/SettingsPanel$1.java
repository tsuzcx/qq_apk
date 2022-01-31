package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.cg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;

final class SettingsPanel$1
  implements View.OnClickListener
{
  SettingsPanel$1(SettingsPanel paramSettingsPanel) {}
  
  public final void onClick(View paramView)
  {
    ((e)g.r(e.class)).Jm().restart();
    a.e(new SettingsPanel.1.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.1
 * JD-Core Version:    0.7.0.1
 */