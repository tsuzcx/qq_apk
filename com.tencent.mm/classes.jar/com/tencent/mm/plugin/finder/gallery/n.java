package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.dx;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;I)V", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getTabType", "()I", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getDescStringID", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public class n
  extends c.b
{
  private final int fEH;
  private final b xNB;
  
  public n(MMActivity paramMMActivity, b paramb, int paramInt)
  {
    super(paramMMActivity, 0, 0, false);
    AppMethodBeat.i(278919);
    this.xNB = paramb;
    this.fEH = paramInt;
    AppMethodBeat.o(278919);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(278907);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    paramInt -= ((h)parama).YSk.size();
    long l;
    if ((paramInt >= 0) && (paramInt < dsG().xnX.getSize()))
    {
      parama = (bu)dsG().xnX.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(278907);
        return;
      }
      paramView = FinderGalleryFragment.xTS;
      Log.i(FinderGalleryFragment.access$getTAG$cp(), "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt + ", field_localFlag:" + ((BaseFinderFeed)parama).feedObject.field_localFlag);
      if (!((BaseFinderFeed)parama).feedObject.isPostFinish())
      {
        if ((((BaseFinderFeed)parama).feedObject.isPostFailed()) && (((BaseFinderFeed)parama).feedObject.isPostFailedCanRetry()))
        {
          paramView = g.AAk;
          g.ecj().v(((BaseFinderFeed)parama).feedObject);
          AppMethodBeat.o(278907);
          return;
        }
        if (!((BaseFinderFeed)parama).feedObject.isPostFailed()) {
          w.cS((Context)this.iXq, this.iXq.getString(b.j.finder_posting_select_tips));
        }
        AppMethodBeat.o(278907);
        return;
      }
      paramView = this.xNB;
      Object localObject = (MMFragmentActivity)this.iXq;
      if (localObject == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(278907);
        throw parama;
      }
      localObject = (MMActivity)localObject;
      paramInt = this.fEH;
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parama;
      List localList = dsG().xnX.getListOfType(BaseFinderFeed.class);
      dsG().xnX.getLastBuffer();
      paramView.a((MMActivity)localObject, paramInt, localBaseFinderFeed, localList, false);
      paramView = f.xUa;
      l = parama.mf();
      paramInt = i;
      if (((BaseFinderFeed)parama).feedObject.getMediaType() == 2) {
        paramInt = 1;
      }
      paramView = new dx();
      paramView.qZ(f.sessionId);
      paramView.kd(f.xTY);
      paramView.ke(2L);
      if (paramInt == 0) {
        break label491;
      }
    }
    label491:
    for (parama = "pic_feed";; parama = "vid_feed")
    {
      paramView.ra(parama);
      paramView.kf(f.xTZ);
      paramView.rb("{\"feedid\":\"" + d.Fw(l) + "\"}");
      paramView.rc(String.valueOf(cm.bfE()));
      paramView.bpa();
      f.a((a)paramView);
      AppMethodBeat.o(278907);
      return;
    }
  }
  
  public final void ab(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(278905);
    p.k(paramArrayList, "data");
    super.ab(paramArrayList);
    if (this.xNB.dwb())
    {
      paramArrayList = (TextView)findViewById(b.f.empty_tip);
      if (paramArrayList != null) {
        paramArrayList.setTextColor(this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_3));
      }
      paramArrayList = (TextView)findViewById(b.f.retry_tip);
      if (paramArrayList != null) {
        paramArrayList.setTextColor(this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_3));
      }
      paramArrayList = (TextView)findViewById(b.f.load_more_footer_tip_tv);
      if (paramArrayList != null)
      {
        paramArrayList.setTextColor(this.iXq.getResources().getColor(b.c.BW_100_Alpha_0_3));
        AppMethodBeat.o(278905);
        return;
      }
    }
    AppMethodBeat.o(278905);
  }
  
  public final MMFragmentActivity dsB()
  {
    return (MMFragmentActivity)this.iXq;
  }
  
  public final boolean dsJ()
  {
    return this.fEH == 5;
  }
  
  public final void dsL() {}
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(278908);
    p.k(paramContext, "context");
    paramContext = this.xNB.ft(paramContext);
    AppMethodBeat.o(278908);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(278914);
    p.k(paramc, "reason");
    AppMethodBeat.o(278914);
    return null;
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(278916);
    p.k(paramc, "reason");
    AppMethodBeat.o(278916);
    return null;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(278911);
    View localView2 = findViewById(b.f.empty_view);
    View localView1 = localView2;
    if (!(localView2 instanceof View)) {
      localView1 = null;
    }
    AppMethodBeat.o(278911);
    return localView1;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(278909);
    RecyclerView.h localh = this.xNB.dwc();
    AppMethodBeat.o(278909);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.n
 * JD-Core Version:    0.7.0.1
 */