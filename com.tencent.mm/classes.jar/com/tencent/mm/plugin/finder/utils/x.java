package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI8;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil;", "", "()V", "TAG", "", "clearOldVersionRedDot", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "initEntrance", "entranceView", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "jumpCenterUI", "context", "Landroid/content/Context;", "plugin-finder_release"})
public final class x
{
  public static final x AEe;
  private static final String TAG = "Finder.FinderPosterCenterUtil";
  
  static
  {
    AppMethodBeat.i(276893);
    AEe = new x();
    TAG = "Finder.FinderPosterCenterUtil";
    AppMethodBeat.o(276893);
  }
  
  public static void a(ViewGroup paramViewGroup, androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(276890);
    p.k(paramViewGroup, "entranceView");
    p.k(paraml, "owner");
    paramViewGroup.setOnClickListener((View.OnClickListener)a.AEf);
    paramViewGroup = paramViewGroup.findViewById(b.f.creator_entrance_reddot_layout);
    p.j(paramViewGroup, "dotView");
    paramViewGroup.setVisibility(8);
    com.tencent.mm.plugin.finder.extension.reddot.h localh = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    localh = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.drn(), paraml, (s)new b(paramViewGroup));
    AppMethodBeat.o(276890);
  }
  
  public static void d(com.tencent.mm.plugin.finder.extension.reddot.f paramf)
  {
    AppMethodBeat.i(276892);
    p.k(paramf, "manager");
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VCh, Boolean.FALSE);
    if (localObject == null)
    {
      paramf = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(276892);
      throw paramf;
    }
    if (!((Boolean)localObject).booleanValue())
    {
      paramf.Mp(1000);
      localObject = kotlin.x.aazN;
      paramf.Mp(1019);
      paramf = kotlin.x.aazN;
      Log.i(TAG, "clearOldVersionRedDot " + localObject + ", " + paramf);
      paramf = com.tencent.mm.kernel.h.aHG();
      p.j(paramf, "MMKernel.storage()");
      paramf.aHp().set(ar.a.VCh, Boolean.TRUE);
    }
    AppMethodBeat.o(276892);
  }
  
  public static void fT(Context paramContext)
  {
    AppMethodBeat.i(276891);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    Object localObject = aj.Bnu;
    aj.a.a(paramContext, localIntent, 0L, 0, false);
    if (!(paramContext instanceof Activity)) {}
    for (localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, OccupyFinderUI8.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil", "jumpCenterUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil", "jumpCenterUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(276891);
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    public static final a AEf;
    
    static
    {
      AppMethodBeat.i(292060);
      AEf = new a();
      AppMethodBeat.o(292060);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(292058);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil$initEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = x.AEe;
      p.j(paramView, "it");
      paramView = paramView.getContext();
      p.j(paramView, "it.context");
      x.fT(paramView);
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramView).getRedDotManager().aBd("FinderPosterEntrance");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil$initEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292058);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class b<T>
    implements s<h.a>
  {
    b(View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.x
 * JD-Core Version:    0.7.0.1
 */