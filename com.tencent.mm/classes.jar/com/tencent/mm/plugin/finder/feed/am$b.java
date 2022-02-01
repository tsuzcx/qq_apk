package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "onItemDelete", "showEmptyView", "plugin-finder_release"})
public final class am$b
  extends c.b
{
  private final String TAG;
  
  public am$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, false);
    AppMethodBeat.i(287222);
    this.TAG = "Finder.FinderSnsPostUIContract.ViewCallback";
    AppMethodBeat.o(287222);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(287219);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    paramInt -= ((h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dsG().xnX.getSize()))
    {
      bu localbu = (bu)dsG().xnX.getDataListJustForAdapter().get(paramInt);
      if (!(localbu instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(287219);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)localbu).feedObject.getId() + ", pos:" + paramInt);
      if (((BaseFinderFeed)localbu).feedObject.isPostFinish())
      {
        ac.a.a(ac.AEJ, (AppCompatActivity)this.iXq, (BaseFinderFeed)localbu, 5, 0, 20);
        paramView = this.iXq;
        parama = paramView;
        if (!(paramView instanceof FinderSnsGridFeedUI)) {
          parama = null;
        }
        parama = (FinderSnsGridFeedUI)parama;
        if (parama != null) {
          parama.xSA = true;
        }
        parama = u.zXM;
        parama = g.Xox;
        paramView = ((aj)g.b((AppCompatActivity)this.iXq).i(aj.class)).sessionId;
        parama = paramView;
        if (paramView == null) {
          parama = "";
        }
        u.a(parama, 3, null, false, false, ((BaseFinderFeed)localbu).feedObject.getId(), 28);
        AppMethodBeat.o(287219);
        return;
      }
      w.makeText((Context)this.iXq, b.j.finder_feed_share_sns_toast_text, 0).show();
    }
    AppMethodBeat.o(287219);
  }
  
  public final void bTY()
  {
    AppMethodBeat.i(287215);
    super.bTY();
    final View localView = getEmptyView();
    if (localView != null) {}
    for (localView = localView.findViewById(b.f.empty_layout); localView != null; localView = null)
    {
      localView.setVisibility(0);
      localView.findViewById(b.f.empty_button).setOnClickListener((View.OnClickListener)new a(this, localView));
      localView = this.iXq.findViewById(b.f.action_bar_middle_title);
      p.j(localView, "context.findViewById<Vie….action_bar_middle_title)");
      localView.setVisibility(8);
      AppMethodBeat.o(287215);
      return;
    }
    AppMethodBeat.o(287215);
  }
  
  public final void dsL() {}
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(287217);
    p.k(paramContext, "context");
    paramContext = dsI().eW(paramContext);
    AppMethodBeat.o(287217);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(287220);
    p.k(paramc, "reason");
    AppMethodBeat.o(287220);
    return "";
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(287221);
    p.k(paramc, "reason");
    AppMethodBeat.o(287221);
    return "";
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(287214);
    View localView = this.iXq.findViewById(b.f.empty_view);
    AppMethodBeat.o(287214);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(287213);
    RecyclerView.h localh = dsI().getItemDecoration();
    AppMethodBeat.o(287213);
    return localh;
  }
  
  public final void o(i parami)
  {
    AppMethodBeat.i(287218);
    p.k(parami, "holder");
    Object localObject = parami.RD(b.f.finder_avatar);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parami.RD(b.f.finder_nickname);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parami.RD(b.f.auth_icon);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = parami.RD(b.f.finder_like_container);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)parami.RD(b.f.finder_desc);
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8))
    {
      parami = parami.RD(b.f.finder_media_bottom);
      if (parami != null)
      {
        parami.setVisibility(8);
        AppMethodBeat.o(287218);
        return;
      }
      AppMethodBeat.o(287218);
      return;
    }
    localObject = parami.RD(b.f.finder_media_bottom);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      Context localContext = parami.getContext();
      p.j(localContext, "holder.context");
      ((View)localObject).setBackgroundColor(localContext.getResources().getColor(b.c.Dark_2));
    }
    parami = (TextView)parami.RD(b.f.finder_desc);
    if (parami != null)
    {
      parami.setTextColor(-1);
      AppMethodBeat.o(287218);
      return;
    }
    AppMethodBeat.o(287218);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(am.b paramb, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234543);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = this.xBE.iXq;
      paramView = (View)localObject;
      if (!(localObject instanceof FinderSnsGridFeedUI)) {
        paramView = null;
      }
      paramView = (FinderSnsGridFeedUI)paramView;
      if (paramView != null) {
        paramView.oC(true);
      }
      a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.am.b
 * JD-Core Version:    0.7.0.1
 */