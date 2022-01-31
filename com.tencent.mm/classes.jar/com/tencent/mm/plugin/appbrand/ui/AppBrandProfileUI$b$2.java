package com.tencent.mm.plugin.appbrand.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class AppBrandProfileUI$b$2
  implements Runnable
{
  AppBrandProfileUI$b$2(AppBrandProfileUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(133052);
    if ((this.iOu.iOr != null) && (this.iOu.iOr.get() != null))
    {
      AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)this.iOu.iOr.get();
      if (AppBrandProfileUI.o(localAppBrandProfileUI))
      {
        Toast.makeText(localAppBrandProfileUI, 2131296803, 0).show();
        AppBrandProfileUI.a(localAppBrandProfileUI, 17, 2);
        AppMethodBeat.o(133052);
        return;
      }
      Toast.makeText(localAppBrandProfileUI, 2131296800, 0).show();
      AppBrandProfileUI.a(localAppBrandProfileUI, 18, 2);
    }
    AppMethodBeat.o(133052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.b.2
 * JD-Core Version:    0.7.0.1
 */