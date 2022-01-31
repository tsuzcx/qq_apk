package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WidgetConsoleUI$2
  implements Runnable
{
  WidgetConsoleUI$2(WidgetConsoleUI paramWidgetConsoleUI, String paramString) {}
  
  public final void run()
  {
    this.fXs.setMMTitle(String.format("%s%s", new Object[] { this.fXs.getString(b.e.wxa_widget_console), this.fXt }));
    Toast.makeText(this.fXs.mController.uMN, String.format("%s%s", new Object[] { this.fXs.id, this.fXt }), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI.2
 * JD-Core Version:    0.7.0.1
 */