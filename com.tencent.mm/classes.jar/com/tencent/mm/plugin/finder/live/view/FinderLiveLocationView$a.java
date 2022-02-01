package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.b.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderLiveLocationView$a
  implements View.OnClickListener
{
  FinderLiveLocationView$a(FinderLiveLocationView paramFinderLiveLocationView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(247491);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    paramView = g.aAh();
    p.g(paramView, "MMKernel.storage()");
    paramView = paramView.azQ().get(274436);
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(247491);
      throw paramView;
    }
    if (com.tencent.mm.aw.b.Pi((String)paramView))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this.uzA.getContext(), "android.permission.ACCESS_FINE_LOCATION"))
      {
        paramView = g.aAh();
        p.g(paramView, "MMKernel.storage()");
        paramView = paramView.azQ().get(ar.a.Oho, Boolean.FALSE);
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(247491);
          throw paramView;
        }
        if (((Boolean)paramView).booleanValue())
        {
          paramView = this.uzA;
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.getResources().getString(2131762481));
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("neverGetA8Key", false);
          ((Intent)localObject).putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.Kzm);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.Kzg);
          c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247491);
          return;
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this.uzA.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
        }
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.uzA.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
      Log.i(this.uzA.getTAG(), "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247491);
        return;
      }
    }
    paramView = this.uzA.uzy;
    if (paramView != null) {
      paramView.dBx();
    }
    a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLocationView.a
 * JD-Core Version:    0.7.0.1
 */