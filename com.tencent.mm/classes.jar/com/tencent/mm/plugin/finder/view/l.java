package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.findersdk.a.ac;
import com.tencent.mm.plugin.findersdk.a.ac.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeader;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "headerView", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "getHeaderView", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "setHeaderView", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;)V", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "stateListener", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "getStateListener", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "setStateListener", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;)V", "checkVisibility", "", "genSnsHeader", "Landroid/view/View;", "getRecyclerView", "refresh", "release", "setListener", "listener", "plugin-finder_release"})
public final class l
  implements ac
{
  private FinderSnsHeaderView AZO;
  private m AZP;
  ac.a AZQ;
  private final String TAG;
  private final Activity fDf;
  
  public l(Activity paramActivity)
  {
    AppMethodBeat.i(231080);
    this.fDf = paramActivity;
    this.TAG = "Finder.FinderSnsHeader";
    AppMethodBeat.o(231080);
  }
  
  public final void a(ac.a parama)
  {
    AppMethodBeat.i(231075);
    this.AZQ = parama;
    parama = this.AZO;
    if (parama != null) {
      parama.setOnInterceptListener((b)new a(this));
    }
    parama = this.AZO;
    if (parama != null)
    {
      parama.setVisibilityChangedListener((b)new b(this));
      AppMethodBeat.o(231075);
      return;
    }
    AppMethodBeat.o(231075);
  }
  
  public final View ejc()
  {
    AppMethodBeat.i(231067);
    Log.i(this.TAG, "genSnsHeader");
    release();
    Object localObject1 = new FinderSnsHeaderView((Context)this.fDf);
    m localm = new m(this.fDf, (j)((FinderSnsHeaderView)localObject1).getViewCallback());
    p.k(localm, "presenter");
    ((FinderSnsHeaderView)localObject1).AZP = localm;
    LayoutInflater.from(((FinderSnsHeaderView)localObject1).getContext()).inflate(b.g.finder_sns_header_view, (ViewGroup)localObject1, true);
    Object localObject2 = ((FinderSnsHeaderView)localObject1).findViewById(b.f.content_view);
    p.j(localObject2, "findViewById(R.id.content_view)");
    ((FinderSnsHeaderView)localObject1).contentView = ((View)localObject2);
    localObject2 = ((FinderSnsHeaderView)localObject1).contentView;
    if (localObject2 == null) {
      p.bGy("contentView");
    }
    localObject2 = ((View)localObject2).findViewById(b.f.finder_sns_header_recycler_view);
    p.j(localObject2, "contentView.findViewById…sns_header_recycler_view)");
    ((FinderSnsHeaderView)localObject1).AZW = ((HorizontalRecyclerView)localObject2);
    localObject2 = new WxRecyclerAdapter((f)new FinderSnsHeaderView.a((FinderSnsHeaderView)localObject1), localm.mXB, false);
    ((com.tencent.mm.view.recyclerview.h)localObject2).YSn = ((h.c)new FinderSnsHeaderView.c((WxRecyclerAdapter)localObject2, (FinderSnsHeaderView)localObject1, localm));
    Object localObject3 = ((FinderSnsHeaderView)localObject1).AZW;
    if (localObject3 == null) {
      p.bGy("recyclerView");
    }
    ((HorizontalRecyclerView)localObject3).setAdapter((RecyclerView.a)localObject2);
    localObject2 = ((FinderSnsHeaderView)localObject1).AZW;
    if (localObject2 == null) {
      p.bGy("recyclerView");
    }
    ((HorizontalRecyclerView)localObject2).b(((FinderSnsHeaderView)localObject1).getItemDecoration());
    ((FinderSnsHeaderView)localObject1).getContext();
    ((FinderSnsHeaderView)localObject1).Arh = new LinearLayoutManager(0, false);
    localObject2 = ((FinderSnsHeaderView)localObject1).AZW;
    if (localObject2 == null) {
      p.bGy("recyclerView");
    }
    localObject3 = ((FinderSnsHeaderView)localObject1).Arh;
    if (localObject3 == null) {
      p.bGy("layoutManager");
    }
    ((HorizontalRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject3);
    localObject2 = ((FinderSnsHeaderView)localObject1).AZW;
    if (localObject2 == null) {
      p.bGy("recyclerView");
    }
    ((HorizontalRecyclerView)localObject2).a((RecyclerView.l)new FinderSnsHeaderView.d(localm));
    localObject2 = ((FinderSnsHeaderView)localObject1).AZW;
    if (localObject2 == null) {
      p.bGy("recyclerView");
    }
    ((HorizontalRecyclerView)localObject2).a((RecyclerView.l)((FinderSnsHeaderView)localObject1).Baa);
    localObject2 = ((FinderSnsHeaderView)localObject1).findViewById(b.f.clear_btn);
    p.j(localObject2, "findViewById(R.id.clear_btn)");
    ((FinderSnsHeaderView)localObject1).AZY = ((View)localObject2);
    ((FinderSnsHeaderView)localObject1).ejf();
    localObject2 = localm.AZS;
    com.tencent.mm.kernel.h.aGY().a(6847, (i)localObject2);
    ((com.tencent.mm.plugin.finder.feed.model.l)localObject2).mXB.addAll((Collection)com.tencent.mm.plugin.finder.feed.model.l.xJm);
    com.tencent.mm.plugin.finder.feed.model.l.xJm = ((com.tencent.mm.plugin.finder.feed.model.l)localObject2).mXB;
    ((com.tencent.mm.plugin.finder.feed.model.l)localObject2).xJl.onChanged();
    ((com.tencent.mm.plugin.finder.feed.model.l)localObject2).xJk.alive();
    localm.AZT.alive();
    this.AZO = ((FinderSnsHeaderView)localObject1);
    this.AZP = localm;
    localObject1 = (View)localObject1;
    AppMethodBeat.o(231067);
    return localObject1;
  }
  
  public final View ejd()
  {
    AppMethodBeat.i(231077);
    Object localObject = this.AZO;
    if (localObject != null) {}
    for (localObject = ((FinderSnsHeaderView)localObject).getRecyclerView();; localObject = null)
    {
      localObject = (View)localObject;
      AppMethodBeat.o(231077);
      return localObject;
    }
  }
  
  public final void eje()
  {
    AppMethodBeat.i(231079);
    FinderSnsHeaderView localFinderSnsHeaderView = this.AZO;
    if (localFinderSnsHeaderView != null)
    {
      localFinderSnsHeaderView.eje();
      AppMethodBeat.o(231079);
      return;
    }
    AppMethodBeat.o(231079);
  }
  
  public final void release()
  {
    AppMethodBeat.i(231071);
    Log.i(this.TAG, "release");
    Object localObject1 = this.AZP;
    if (localObject1 != null) {
      ((m)localObject1).release();
    }
    localObject1 = this.AZO;
    if (localObject1 != null)
    {
      localObject1 = ((FinderSnsHeaderView)localObject1).getRecyclerView();
      if (localObject1 != null) {
        ((HorizontalRecyclerView)localObject1).setAdapter(null);
      }
    }
    localObject1 = this.AZO;
    if (localObject1 != null) {}
    for (localObject1 = ((FinderSnsHeaderView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup)localObject2;
      if (localObject1 == null) {
        break;
      }
      ((ViewGroup)localObject1).removeView((View)this.AZO);
      AppMethodBeat.o(231071);
      return;
    }
    AppMethodBeat.o(231071);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Boolean, x>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements b<Integer, x>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.l
 * JD-Core Version:    0.7.0.1
 */