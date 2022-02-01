package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class g$g
  implements DialogInterface.OnDismissListener
{
  g$g(g paramg) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(161189);
    if (g.f(this.pMR) != null)
    {
      paramDialogInterface = g.f(this.pMR);
      if (paramDialogInterface == null) {
        p.iCn();
      }
      if (!paramDialogInterface.isAlive())
      {
        paramDialogInterface = this.pMR;
        View localView = g.g(this.pMR);
        if (localView == null) {
          p.iCn();
        }
        g.a(paramDialogInterface, localView.getViewTreeObserver());
      }
      paramDialogInterface = g.f(this.pMR);
      if (paramDialogInterface == null) {
        p.iCn();
      }
      paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.pMR);
      g.a(this.pMR, null);
    }
    paramDialogInterface = this.pMR.pML;
    int i = ((Collection)this.pMR.pMO.pNN).size();
    paramDialogInterface.invoke(Integer.valueOf(((Collection)this.pMR.pMO.pNM).size() + i));
    AppMethodBeat.o(161189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.g.g
 * JD-Core Version:    0.7.0.1
 */