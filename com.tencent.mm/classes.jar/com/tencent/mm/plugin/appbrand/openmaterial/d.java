package com.tencent.mm.plugin.appbrand.openmaterial;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "isValid", "", "Landroid/content/Context;", "notifyChangeFixed", "", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "plugin-appbrand-integration_release"})
public final class d
{
  public static final void a(e parame, Context paramContext)
  {
    AppMethodBeat.i(258369);
    p.h(parame, "$this$notifyChangeFixed");
    p.h(paramContext, "context");
    if (eg(paramContext)) {
      try
      {
        parame.fPw();
        AppMethodBeat.o(258369);
        return;
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.OpenMaterial.Commons", (Throwable)parame, "notifyChangeFixed, fail", new Object[0]);
        AppMethodBeat.o(258369);
        return;
      }
    }
    Log.e("MicroMsg.AppBrand.OpenMaterial.Commons", "notifyChangeFixed, context is invalid, why?");
    AppMethodBeat.o(258369);
  }
  
  public static final boolean eg(Context paramContext)
  {
    AppMethodBeat.i(229098);
    p.h(paramContext, "$this$isValid");
    if (((paramContext instanceof Activity)) && ((((Activity)paramContext).isFinishing()) || (((Activity)paramContext).isDestroyed())))
    {
      AppMethodBeat.o(229098);
      return false;
    }
    AppMethodBeat.o(229098);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.d
 * JD-Core Version:    0.7.0.1
 */