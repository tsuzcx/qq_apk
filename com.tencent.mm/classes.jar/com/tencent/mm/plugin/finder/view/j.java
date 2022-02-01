package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.finder.feed.model.g.b;
import com.tencent.mm.plugin.i.a.ab;
import com.tencent.mm.plugin.i.a.ab.a;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeader;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "headerView", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "getHeaderView", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "setHeaderView", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;)V", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "stateListener", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "getStateListener", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "setStateListener", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;)V", "checkVisibility", "", "genSnsHeader", "Landroid/view/View;", "getRecyclerView", "refresh", "release", "setListener", "listener", "plugin-finder_release"})
public final class j
  implements ab
{
  private final String TAG;
  private final Activity dKq;
  private FinderSnsHeaderView woF;
  private k woG;
  ab.a woH;
  
  public j(Activity paramActivity)
  {
    AppMethodBeat.i(254914);
    this.dKq = paramActivity;
    this.TAG = "Finder.FinderSnsHeader";
    AppMethodBeat.o(254914);
  }
  
  public final void a(ab.a parama)
  {
    AppMethodBeat.i(254911);
    this.woH = parama;
    parama = this.woF;
    if (parama != null) {
      parama.setOnInterceptListener((b)new a(this));
    }
    parama = this.woF;
    if (parama != null)
    {
      parama.setVisibilityChangedListener((b)new b(this));
      AppMethodBeat.o(254911);
      return;
    }
    AppMethodBeat.o(254911);
  }
  
  public final View dHb()
  {
    AppMethodBeat.i(254909);
    release();
    Object localObject1 = new FinderSnsHeaderView((Context)this.dKq);
    k localk = new k(this.dKq, (com.tencent.mm.view.j)((FinderSnsHeaderView)localObject1).getViewCallback());
    p.h(localk, "presenter");
    ((FinderSnsHeaderView)localObject1).woG = localk;
    LayoutInflater.from(((FinderSnsHeaderView)localObject1).getContext()).inflate(2131494634, (ViewGroup)localObject1, true);
    Object localObject2 = ((FinderSnsHeaderView)localObject1).findViewById(2131299227);
    p.g(localObject2, "findViewById(R.id.content_view)");
    ((FinderSnsHeaderView)localObject1).contentView = ((View)localObject2);
    localObject2 = ((FinderSnsHeaderView)localObject1).contentView;
    if (localObject2 == null) {
      p.btv("contentView");
    }
    localObject2 = ((View)localObject2).findViewById(2131301492);
    p.g(localObject2, "contentView.findViewById…sns_header_recycler_view)");
    ((FinderSnsHeaderView)localObject1).woN = ((HorizontalRecyclerView)localObject2);
    localObject2 = new WxRecyclerAdapter((f)new FinderSnsHeaderView.a((FinderSnsHeaderView)localObject1), localk.kgc, false);
    ((com.tencent.mm.view.recyclerview.g)localObject2).RqP = ((g.c)new FinderSnsHeaderView.c((WxRecyclerAdapter)localObject2, (FinderSnsHeaderView)localObject1, localk));
    Object localObject3 = ((FinderSnsHeaderView)localObject1).woN;
    if (localObject3 == null) {
      p.btv("recyclerView");
    }
    ((HorizontalRecyclerView)localObject3).setAdapter((RecyclerView.a)localObject2);
    localObject2 = ((FinderSnsHeaderView)localObject1).woN;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    ((HorizontalRecyclerView)localObject2).b(((FinderSnsHeaderView)localObject1).getItemDecoration());
    ((FinderSnsHeaderView)localObject1).getContext();
    ((FinderSnsHeaderView)localObject1).vKp = new LinearLayoutManager(0, false);
    localObject2 = ((FinderSnsHeaderView)localObject1).woN;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    localObject3 = ((FinderSnsHeaderView)localObject1).vKp;
    if (localObject3 == null) {
      p.btv("layoutManager");
    }
    ((HorizontalRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject3);
    localObject2 = ((FinderSnsHeaderView)localObject1).woN;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    ((HorizontalRecyclerView)localObject2).a((RecyclerView.l)new FinderSnsHeaderView.d(localk));
    localObject2 = ((FinderSnsHeaderView)localObject1).woN;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    ((HorizontalRecyclerView)localObject2).a((RecyclerView.l)((FinderSnsHeaderView)localObject1).woR);
    localObject2 = ((FinderSnsHeaderView)localObject1).findViewById(2131298744);
    p.g(localObject2, "findViewById(R.id.clear_btn)");
    ((FinderSnsHeaderView)localObject1).woP = ((View)localObject2);
    ((FinderSnsHeaderView)localObject1).dHe();
    localObject2 = localk.woJ;
    com.tencent.mm.kernel.g.azz().a(6847, (i)localObject2);
    ((com.tencent.mm.plugin.finder.feed.model.g)localObject2).kgc.addAll((Collection)com.tencent.mm.plugin.finder.feed.model.g.tXm);
    com.tencent.mm.plugin.finder.feed.model.g.tXm = ((com.tencent.mm.plugin.finder.feed.model.g)localObject2).kgc;
    ((com.tencent.mm.plugin.finder.feed.model.g)localObject2).tXl.onChanged();
    ((com.tencent.mm.plugin.finder.feed.model.g)localObject2).tXk.alive();
    localk.woK.alive();
    this.woF = ((FinderSnsHeaderView)localObject1);
    this.woG = localk;
    localObject1 = (View)localObject1;
    AppMethodBeat.o(254909);
    return localObject1;
  }
  
  public final View dHc()
  {
    AppMethodBeat.i(254912);
    Object localObject = this.woF;
    if (localObject != null) {}
    for (localObject = ((FinderSnsHeaderView)localObject).getRecyclerView();; localObject = null)
    {
      localObject = (View)localObject;
      AppMethodBeat.o(254912);
      return localObject;
    }
  }
  
  public final void dHd()
  {
    AppMethodBeat.i(254913);
    FinderSnsHeaderView localFinderSnsHeaderView = this.woF;
    if (localFinderSnsHeaderView != null)
    {
      localFinderSnsHeaderView.dHd();
      AppMethodBeat.o(254913);
      return;
    }
    AppMethodBeat.o(254913);
  }
  
  public final void release()
  {
    AppMethodBeat.i(254910);
    k localk = this.woG;
    if (localk != null)
    {
      localk.release();
      AppMethodBeat.o(254910);
      return;
    }
    AppMethodBeat.o(254910);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Boolean, x>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements b<Integer, x>
  {
    b(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.j
 * JD-Core Version:    0.7.0.1
 */