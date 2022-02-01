package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderSnsHeaderLoader.feedUpdateListener.1;
import com.tencent.mm.plugin.finder.feed.model.l;
import com.tencent.mm.plugin.findersdk.a.bs;
import com.tencent.mm.plugin.findersdk.a.bs.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeader;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "headerView", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "getHeaderView", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "setHeaderView", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;)V", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "stateListener", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "getStateListener", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "setStateListener", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;)V", "checkVisibility", "", "genSnsHeader", "Landroid/view/View;", "getRecyclerView", "refresh", "release", "setListener", "listener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements bs
{
  private FinderSnsHeaderView GCl;
  private p GCm;
  bs.a GCn;
  private final String TAG;
  private final Activity hHU;
  
  public o(Activity paramActivity)
  {
    AppMethodBeat.i(344210);
    this.hHU = paramActivity;
    this.TAG = "Finder.FinderSnsHeader";
    AppMethodBeat.o(344210);
  }
  
  public final void a(bs.a parama)
  {
    AppMethodBeat.i(344241);
    this.GCn = parama;
    parama = this.GCl;
    if (parama != null) {
      parama.setOnInterceptListener((b)new a(this));
    }
    parama = this.GCl;
    if (parama != null) {
      parama.setVisibilityChangedListener((b)new b(this));
    }
    AppMethodBeat.o(344241);
  }
  
  public final View flh()
  {
    AppMethodBeat.i(344225);
    Log.i(this.TAG, "genSnsHeader");
    release();
    Object localObject1 = new FinderSnsHeaderView((Context)this.hHU);
    p localp = new p(this.hHU, (k)((FinderSnsHeaderView)localObject1).getViewCallback());
    kotlin.g.b.s.u(localp, "presenter");
    ((FinderSnsHeaderView)localObject1).setPresenter(localp);
    LayoutInflater.from(((FinderSnsHeaderView)localObject1).getContext()).inflate(e.f.finder_sns_header_view, (ViewGroup)localObject1, true);
    Object localObject2 = ((FinderSnsHeaderView)localObject1).findViewById(e.e.content_view);
    kotlin.g.b.s.s(localObject2, "findViewById(R.id.content_view)");
    ((FinderSnsHeaderView)localObject1).setContentView((View)localObject2);
    localObject2 = ((FinderSnsHeaderView)localObject1).getContentView().findViewById(e.e.finder_sns_header_recycler_view);
    kotlin.g.b.s.s(localObject2, "contentView.findViewById…sns_header_recycler_view)");
    ((FinderSnsHeaderView)localObject1).setRecyclerView((HorizontalRecyclerView)localObject2);
    localObject2 = new WxRecyclerAdapter((g)new FinderSnsHeaderView.a((FinderSnsHeaderView)localObject1), localp.pUj, false);
    ((i)localObject2).agOe = ((i.c)new FinderSnsHeaderView.c((WxRecyclerAdapter)localObject2, (FinderSnsHeaderView)localObject1, localp));
    ((FinderSnsHeaderView)localObject1).getRecyclerView().setAdapter((RecyclerView.a)localObject2);
    ((FinderSnsHeaderView)localObject1).getRecyclerView().a(((FinderSnsHeaderView)localObject1).getItemDecoration());
    ((FinderSnsHeaderView)localObject1).getContext();
    ((FinderSnsHeaderView)localObject1).setLayoutManager(new LinearLayoutManager(0, false));
    ((FinderSnsHeaderView)localObject1).getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)((FinderSnsHeaderView)localObject1).getLayoutManager());
    ((FinderSnsHeaderView)localObject1).getRecyclerView().a((RecyclerView.l)new FinderSnsHeaderView.d(localp));
    ((FinderSnsHeaderView)localObject1).getRecyclerView().a((RecyclerView.l)((FinderSnsHeaderView)localObject1).GCx);
    localObject2 = ((FinderSnsHeaderView)localObject1).findViewById(e.e.clear_btn);
    kotlin.g.b.s.s(localObject2, "findViewById(R.id.clear_btn)");
    ((FinderSnsHeaderView)localObject1).setClearBtn((View)localObject2);
    ((FinderSnsHeaderView)localObject1).flk();
    localObject2 = localp.GCp;
    com.tencent.mm.kernel.h.aZW().a(6847, (com.tencent.mm.am.h)localObject2);
    ((l)localObject2).pUj.addAll((Collection)l.BiX);
    l.BiX = ((l)localObject2).pUj;
    ((l)localObject2).BiU.onChanged();
    ((l)localObject2).BiW.alive();
    localp.GCq.alive();
    this.GCl = ((FinderSnsHeaderView)localObject1);
    this.GCm = localp;
    localObject1 = (View)localObject1;
    AppMethodBeat.o(344225);
    return localObject1;
  }
  
  public final View fli()
  {
    AppMethodBeat.i(344244);
    Object localObject = this.GCl;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FinderSnsHeaderView)localObject).getRecyclerView())
    {
      localObject = (View)localObject;
      AppMethodBeat.o(344244);
      return localObject;
    }
  }
  
  public final void flj()
  {
    AppMethodBeat.i(344251);
    FinderSnsHeaderView localFinderSnsHeaderView = this.GCl;
    if (localFinderSnsHeaderView != null) {
      localFinderSnsHeaderView.flj();
    }
    AppMethodBeat.o(344251);
  }
  
  public final void release()
  {
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(344234);
    Log.i(this.TAG, "release");
    Object localObject = this.GCm;
    if (localObject != null) {
      ((p)localObject).release();
    }
    localObject = this.GCl;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        ((HorizontalRecyclerView)localObject).setAdapter(null);
      }
      localObject = this.GCl;
      if (localObject != null) {
        break label104;
      }
    }
    label104:
    for (localObject = null;; localObject = ((FinderSnsHeaderView)localObject).getParent())
    {
      if ((localObject instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localObject;
      }
      if (localViewGroup != null) {
        localViewGroup.removeView((View)this.GCl);
      }
      AppMethodBeat.o(344234);
      return;
      localObject = ((FinderSnsHeaderView)localObject).getRecyclerView();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Boolean, ah>
  {
    a(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Integer, ah>
  {
    b(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.o
 * JD-Core Version:    0.7.0.1
 */