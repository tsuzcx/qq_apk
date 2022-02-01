package com.tencent.mm.plugin.appbrand.openmaterial;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "isValid", "", "Landroid/content/Context;", "notifyChangeFixed", "", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final void a(f paramf, Context paramContext)
  {
    AppMethodBeat.i(323552);
    s.u(paramf, "<this>");
    s.u(paramContext, "context");
    if (eZ(paramContext)) {
      try
      {
        paramf.ihf();
        AppMethodBeat.o(323552);
        return;
      }
      catch (Exception paramf)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.OpenMaterial.Commons", (Throwable)paramf, "notifyChangeFixed, fail", new Object[0]);
        AppMethodBeat.o(323552);
        return;
      }
    }
    Log.e("MicroMsg.AppBrand.OpenMaterial.Commons", "notifyChangeFixed, context is invalid, why?");
    AppMethodBeat.o(323552);
  }
  
  public static final boolean eZ(Context paramContext)
  {
    AppMethodBeat.i(323546);
    s.u(paramContext, "<this>");
    if (((paramContext instanceof Activity)) && ((((Activity)paramContext).isFinishing()) || (((Activity)paramContext).isDestroyed())))
    {
      AppMethodBeat.o(323546);
      return false;
    }
    AppMethodBeat.o(323546);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.d
 * JD-Core Version:    0.7.0.1
 */