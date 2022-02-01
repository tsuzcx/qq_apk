package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderPosterCenterUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil;", "", "()V", "TAG", "", "clearOldVersionRedDot", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "initEntrance", "entranceView", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "jumpCenterUI", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final ae Ghi;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333556);
    Ghi = new ae();
    TAG = "Finder.FinderPosterCenterUtil";
    AppMethodBeat.o(333556);
  }
  
  private static final void a(View paramView, l.a parama)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(333544);
    if ((parama != null) && (parama.hBY == true)) {
      if (i == 0) {
        break label43;
      }
    }
    label43:
    for (i = j;; i = 4)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(333544);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(ViewGroup paramViewGroup, q paramq)
  {
    AppMethodBeat.i(333502);
    s.u(paramViewGroup, "entranceView");
    s.u(paramq, "owner");
    paramViewGroup.setOnClickListener(ae..ExternalSyntheticLambda0.INSTANCE);
    paramViewGroup = paramViewGroup.findViewById(e.e.creator_entrance_reddot_layout);
    paramViewGroup.setVisibility(4);
    l locall = l.ARA;
    d.a((LiveData)l.eab(), paramq, new ae..ExternalSyntheticLambda1(paramViewGroup));
    AppMethodBeat.o(333502);
  }
  
  public static void d(i parami)
  {
    AppMethodBeat.i(333514);
    s.u(parami, "manager");
    Object localObject = h.baE().ban().get(at.a.adeK, Boolean.FALSE);
    if (localObject == null)
    {
      parami = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(333514);
      throw parami;
    }
    if (!((Boolean)localObject).booleanValue())
    {
      parami.Nv(1000);
      localObject = ah.aiuX;
      parami.Nv(1019);
      parami = ah.aiuX;
      Log.i(TAG, "clearOldVersionRedDot " + localObject + ", " + parami);
      h.baE().ban().set(at.a.adeK, Boolean.TRUE);
    }
    AppMethodBeat.o(333514);
  }
  
  private static final void gP(View paramView)
  {
    AppMethodBeat.i(333531);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    localObject2 = paramView.getContext();
    s.s(localObject2, "it.context");
    s.u(localObject2, "context");
    localObject1 = new Intent();
    paramView = as.GSQ;
    as.a.a((Context)localObject2, (Intent)localObject1, 0L, null, 0, 0, false);
    if (!(localObject2 instanceof Activity)) {}
    for (paramView = (View)localObject1;; paramView = null)
    {
      if (paramView != null) {
        paramView.addFlags(268435456);
      }
      ((Intent)localObject1).setClass((Context)localObject2, FinderPosterCenterUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramView.aYi(), "com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil", "jumpCenterUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil", "jumpCenterUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("FinderPosterEntrance");
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("CreatorCenter");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/utils/FinderPosterCenterUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(333531);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ae
 * JD-Core Version:    0.7.0.1
 */