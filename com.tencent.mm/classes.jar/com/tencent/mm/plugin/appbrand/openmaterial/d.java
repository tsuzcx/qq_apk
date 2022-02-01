package com.tencent.mm.plugin.appbrand.openmaterial;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "isValid", "", "Landroid/content/Context;", "notifyChangeFixed", "", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "plugin-appbrand-integration_release"})
public final class d
{
  public static final void a(e parame, Context paramContext)
  {
    AppMethodBeat.i(281235);
    p.k(parame, "$this$notifyChangeFixed");
    p.k(paramContext, "context");
    if (ef(paramContext)) {
      try
      {
        parame.gIa();
        AppMethodBeat.o(281235);
        return;
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.OpenMaterial.Commons", (Throwable)parame, "notifyChangeFixed, fail", new Object[0]);
        AppMethodBeat.o(281235);
        return;
      }
    }
    Log.e("MicroMsg.AppBrand.OpenMaterial.Commons", "notifyChangeFixed, context is invalid, why?");
    AppMethodBeat.o(281235);
  }
  
  public static final boolean ef(Context paramContext)
  {
    AppMethodBeat.i(281232);
    p.k(paramContext, "$this$isValid");
    if (((paramContext instanceof Activity)) && ((((Activity)paramContext).isFinishing()) || (((Activity)paramContext).isDestroyed())))
    {
      AppMethodBeat.o(281232);
      return false;
    }
    AppMethodBeat.o(281232);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.d
 * JD-Core Version:    0.7.0.1
 */