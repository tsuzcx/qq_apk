package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.pluginsdk.location.b.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderLiveLocationView$a
  implements View.OnClickListener
{
  FinderLiveLocationView$a(FinderLiveLocationView paramFinderLiveLocationView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(279012);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = h.aHG();
    p.j(paramView, "MMKernel.storage()");
    localObject = paramView.aHp().get(274436);
    paramView = (View)localObject;
    if (!(localObject instanceof String)) {
      paramView = null;
    }
    if (com.tencent.mm.az.b.WF((String)paramView))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this.yVb.getContext(), "android.permission.ACCESS_FINE_LOCATION"))
      {
        paramView = h.aHG();
        p.j(paramView, "MMKernel.storage()");
        localObject = paramView.aHp().get(ar.a.VvE, Boolean.FALSE);
        paramView = (View)localObject;
        if (!(localObject instanceof Boolean)) {
          paramView = null;
        }
        if (p.h((Boolean)paramView, Boolean.TRUE))
        {
          paramView = this.yVb;
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.getResources().getString(b.j.location_use_scene_gdpr_url));
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("neverGetA8Key", false);
          ((Intent)localObject).putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.RBc);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.RAX);
          c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279012);
          return;
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this.yVb.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64);
        }
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.yVb.getContext(), "android.permission.ACCESS_FINE_LOCATION", 64, "", "");
      Log.i(this.yVb.getTAG(), "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279012);
        return;
      }
    }
    paramView = this.yVb.yUZ;
    if (paramView != null) {
      paramView.ecK();
    }
    a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLocationView$init$itemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLocationView.a
 * JD-Core Version:    0.7.0.1
 */