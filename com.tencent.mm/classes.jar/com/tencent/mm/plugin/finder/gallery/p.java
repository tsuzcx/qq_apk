package com.tencent.mm.plugin.finder.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.fh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;I)V", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getTabType", "()I", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getDescStringID", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class p
  extends c.b
{
  private final b Bnx;
  private final int hJx;
  
  public p(MMActivity paramMMActivity, b paramb, int paramInt)
  {
    super(paramMMActivity, 0, 0, false);
    AppMethodBeat.i(334239);
    this.Bnx = paramb;
    this.hJx = paramInt;
    AppMethodBeat.o(334239);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(334288);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramInt -= ((i)parama).agOb.size();
    Object localObject;
    long l;
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      parama = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(334288);
        return;
      }
      paramView = FinderGalleryFragment.BuG;
      Log.i(FinderGalleryFragment.access$getTAG$cp(), "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt + ", field_localFlag:" + ((BaseFinderFeed)parama).feedObject.field_localFlag);
      if (!((BaseFinderFeed)parama).feedObject.isPostFinish())
      {
        if ((((BaseFinderFeed)parama).feedObject.isPostFailed()) && (((BaseFinderFeed)parama).feedObject.isPostFailedCanRetry()))
        {
          ((c)h.az(c.class)).finderPostManager().fy(((BaseFinderFeed)parama).feedObject);
          AppMethodBeat.o(334288);
          return;
        }
        if (!((BaseFinderFeed)parama).feedObject.isPostFailed())
        {
          aa.dc((Context)this.lzt, this.lzt.getString(e.h.finder_posting_select_tips));
          AppMethodBeat.o(334288);
        }
      }
      else
      {
        if (!this.Bnx.egx()) {
          break label494;
        }
        paramView = new Intent();
        BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, paramView, paramInt, null, 4, null);
        localObject = o.Bvl;
        o.a(paramView, this.Bnx.But.mUU, this.Bnx.But.Buq, this.hJx);
        localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.f((Activity)this.lzt, paramView, this.Bnx.egy());
        paramView = f.BuT;
        l = parama.bZA();
        if (((BaseFinderFeed)parama).feedObject.getMediaType() != 2) {
          break label561;
        }
        paramInt = 1;
        label382:
        paramView = new fh();
        paramView.pO(f.sessionId);
        paramView.iGT = f.BuU;
        paramView.iFe = 2L;
        if (paramInt == 0) {
          break label566;
        }
      }
    }
    label561:
    label566:
    for (parama = "pic_feed";; parama = "vid_feed")
    {
      paramView.pP(parama);
      paramView.iGV = f.BuV;
      paramView.pQ("{\"feedid\":\"" + d.hF(l) + "\"}");
      paramView.pR(String.valueOf(cn.bDw()));
      paramView.bMH();
      f.a((com.tencent.mm.plugin.report.a)paramView);
      AppMethodBeat.o(334288);
      return;
      label494:
      paramView = this.Bnx;
      localObject = (MMActivity)this.lzt;
      paramInt = this.hJx;
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parama;
      List localList = ebL().ALH.getListOfType(BaseFinderFeed.class);
      ebL().ALH.getLastBuffer();
      paramView.a((MMActivity)localObject, paramInt, localBaseFinderFeed, localList);
      break;
      paramInt = 0;
      break label382;
    }
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(334250);
    s.u(paramArrayList, "data");
    super.ae(paramArrayList);
    if (this.Bnx.egw())
    {
      paramArrayList = (TextView)findViewById(e.e.empty_tip);
      if (paramArrayList != null) {
        paramArrayList.setTextColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_3));
      }
      paramArrayList = (TextView)findViewById(e.e.retry_tip);
      if (paramArrayList != null) {
        paramArrayList.setTextColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_3));
      }
      paramArrayList = (TextView)findViewById(e.e.load_more_footer_tip_tv);
      if (paramArrayList != null) {
        paramArrayList.setTextColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_3));
      }
    }
    AppMethodBeat.o(334250);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(334325);
    s.u(paramd, "reason");
    AppMethodBeat.o(334325);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(334333);
    s.u(paramd, "reason");
    AppMethodBeat.o(334333);
    return null;
  }
  
  public final void dUO() {}
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.lzt;
  }
  
  public final boolean ebG()
  {
    return true;
  }
  
  public final boolean ebM()
  {
    return this.hJx == 5;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(334293);
    s.u(paramContext, "context");
    paramContext = this.Bnx.aq(paramContext, this.hJx);
    AppMethodBeat.o(334293);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(334309);
    View localView = findViewById(e.e.empty_view);
    if ((localView instanceof View))
    {
      AppMethodBeat.o(334309);
      return localView;
    }
    AppMethodBeat.o(334309);
    return null;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(334303);
    RecyclerView.h localh = this.Bnx.Ot(this.hJx);
    AppMethodBeat.o(334303);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.p
 * JD-Core Version:    0.7.0.1
 */