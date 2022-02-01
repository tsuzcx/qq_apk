package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandActivityUtils;", "", "()V", "TAG", "", "hideVKB", "", "Landroid/app/Activity;", "showVKB", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b nRg;
  
  static
  {
    AppMethodBeat.i(175216);
    nRg = new b();
    AppMethodBeat.o(175216);
  }
  
  public static final void G(Activity paramActivity)
  {
    AppMethodBeat.i(175215);
    if (paramActivity != null)
    {
      if ((paramActivity instanceof MMActivity))
      {
        ((MMActivity)paramActivity).hideVKB();
        AppMethodBeat.o(175215);
        return;
      }
      if ((paramActivity instanceof ad))
      {
        ((ad)paramActivity).hideVKB();
        AppMethodBeat.o(175215);
        return;
      }
      Log.e("MicroMsg.AppBrandActivityUtils", "hideVKB not supported in " + paramActivity.getLocalClassName());
    }
    AppMethodBeat.o(175215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b
 * JD-Core Version:    0.7.0.1
 */