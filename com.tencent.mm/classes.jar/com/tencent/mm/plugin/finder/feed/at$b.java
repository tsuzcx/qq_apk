package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "onItemDelete", "showEmptyView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at$b
  extends c.b
{
  private final String TAG;
  
  public at$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, false);
    AppMethodBeat.i(363052);
    this.TAG = "Finder.FinderSnsPostUIContract.ViewCallback";
    AppMethodBeat.o(363052);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(363059);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.lzt;
    if ((paramb instanceof FinderSnsGridFeedUI)) {}
    for (paramb = (FinderSnsGridFeedUI)paramb;; paramb = null)
    {
      if (paramb != null) {
        paramb.qf(true);
      }
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(363059);
      return;
    }
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(363121);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      cc localcc = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if (!(localcc instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(363121);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)localcc).feedObject.getId() + ", pos:" + paramInt);
      if (((BaseFinderFeed)localcc).feedObject.isPostFinish())
      {
        an.a.a(an.GhR, (AppCompatActivity)this.lzt, (BaseFinderFeed)localcc, 5, 0, 20);
        parama = this.lzt;
        if ((parama instanceof FinderSnsGridFeedUI)) {}
        for (parama = (FinderSnsGridFeedUI)parama;; parama = null)
        {
          if (parama != null) {
            parama.Bsb = true;
          }
          parama = ag.Ftp;
          parama = k.aeZF;
          paramView = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).sessionId;
          parama = paramView;
          if (paramView == null) {
            parama = "";
          }
          ag.a(parama, 3, null, false, false, ((BaseFinderFeed)localcc).feedObject.getId(), 28);
          AppMethodBeat.o(363121);
          return;
        }
      }
      aa.makeText((Context)this.lzt, e.h.finder_feed_share_sns_toast_text, 0).show();
    }
    AppMethodBeat.o(363121);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(363132);
    s.u(paramd, "reason");
    AppMethodBeat.o(363132);
    return "";
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(363140);
    s.u(paramd, "reason");
    AppMethodBeat.o(363140);
    return "";
  }
  
  public final void cul()
  {
    AppMethodBeat.i(363090);
    super.cul();
    View localView = getEmptyView();
    if (localView == null) {}
    for (localView = null;; localView = localView.findViewById(e.e.empty_layout))
    {
      if (localView != null)
      {
        localView.setVisibility(0);
        localView.findViewById(e.e.empty_button).setOnClickListener(new at.b..ExternalSyntheticLambda0(this));
        this.lzt.findViewById(e.e.action_bar_middle_title).setVisibility(8);
      }
      AppMethodBeat.o(363090);
      return;
    }
  }
  
  public final void dUO() {}
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(363099);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(363099);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(363081);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(363081);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(363072);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(363072);
    return localh;
  }
  
  public final void u(j paramj)
  {
    AppMethodBeat.i(363106);
    s.u(paramj, "holder");
    Object localObject = paramj.UH(e.e.finder_avatar);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramj.UH(e.e.finder_nickname);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramj.UH(e.e.auth_icon);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramj.UH(e.e.finder_like_container);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)paramj.UH(e.e.finder_desc);
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramj = paramj.UH(e.e.finder_media_bottom);
      if (paramj == null) {
        break label199;
      }
      paramj.setVisibility(8);
      AppMethodBeat.o(363106);
      return;
    }
    localObject = paramj.UH(e.e.finder_media_bottom);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).setBackgroundColor(paramj.context.getResources().getColor(e.b.Dark_2));
    }
    paramj = (TextView)paramj.UH(e.e.finder_desc);
    if (paramj != null) {
      paramj.setTextColor(-1);
    }
    label199:
    AppMethodBeat.o(363106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.at.b
 * JD-Core Version:    0.7.0.1
 */