package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.o;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "viewTabType", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "isShowFeedExposure", "", "()Z", "setShowFeedExposure", "(Z)V", "getViewTabType", "()I", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$a
  extends ae.a
{
  final int Bvh;
  boolean Bvi;
  
  public m$a(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(334131);
    this.Bvh = paramInt;
    AppMethodBeat.o(334131);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    AppMethodBeat.i(334162);
    s.u(paramBaseFinderFeedLoader, "model");
    s.u(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    paramBaseFinderFeedLoader = this.ATo;
    if (paramBaseFinderFeedLoader == null) {}
    for (paramBaseFinderFeedLoader = null;; paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.getAdapter())
    {
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.agOS = ((o)new b(this));
      }
      AppMethodBeat.o(334162);
      return;
    }
  }
  
  public final void a(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(334152);
    s.u(paramd, "reason");
    super.a(paramd);
    if ((this.ATo instanceof m.b))
    {
      Object localObject = this.ATo;
      if (localObject == null)
      {
        paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.gallery.FinderGalleryTimelineContract.ViewCallback");
        AppMethodBeat.o(334152);
        throw paramd;
      }
      localObject = (m.b)localObject;
      s.u(paramd, "reason");
      if (paramd.agJu) {
        ((m.b)localObject).t(((b.b)localObject).ATx.getRecyclerView());
      }
    }
    AppMethodBeat.o(334152);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(334144);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(334144);
  }
  
  public final com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(334169);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a(this);
    AppMethodBeat.o(334169);
    return localg;
  }
  
  public final void requestRefresh() {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(m.a parama) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(334148);
      boolean bool;
      switch (paramInt)
      {
      default: 
        localObject1 = av.GiL;
        av.eY(this.Bvj.getTAG(), paramInt);
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(334148);
        return localObject1;
      case 9: 
        localObject1 = this.Bvj.AJn;
        localObject2 = (i)this.Bvj;
        bool = this.Bvj.ecb();
        int i = this.Bvj.hJx;
        Object localObject3 = as.GSQ;
        localObject3 = as.a.hu((Context)this.Bvj.lzt);
        if (localObject3 == null) {}
        for (paramInt = 0;; paramInt = ((as)localObject3).AJo)
        {
          localObject1 = (com.tencent.mm.view.recyclerview.f)new r((l)localObject1, (i)localObject2, bool, i, paramInt);
          AppMethodBeat.o(334148);
          return localObject1;
        }
      case 4: 
        localObject1 = this.Bvj.AJn;
        bool = this.Bvj.ecb();
        paramInt = this.Bvj.hJx;
        localObject1 = (com.tencent.mm.view.recyclerview.f)new a(this.Bvj, (l)localObject1, bool, paramInt);
        AppMethodBeat.o(334148);
        return localObject1;
      case 2: 
        bool = this.Bvj.ecb();
        paramInt = this.Bvj.hJx;
        localObject1 = (com.tencent.mm.view.recyclerview.f)new b(this.Bvj, bool, paramInt);
        AppMethodBeat.o(334148);
        return localObject1;
      }
      Object localObject1 = (i)this.Bvj;
      Object localObject2 = k.aeZF;
      localObject1 = (com.tencent.mm.view.recyclerview.f)new w((i)localObject1, ((as)k.d((AppCompatActivity)this.Bvj.lzt).q(as.class)).fou(), 0);
      AppMethodBeat.o(334148);
      return localObject1;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert;", "isOnlyShowDesc", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "position", "", "type", "isHotPatch", "payloads", "", "", "onDeepEnjoyMedia", "source", "onHafEnjoyMedia", "onTenSecEnjoy", "refreshFinderLivingStatusView", "refreshFollowState", "refreshFriendFollowCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends t
    {
      a(m.a parama, l paraml, boolean paramBoolean, int paramInt)
      {
        super((i)parama, paramBoolean, paramInt);
        AppMethodBeat.i(334200);
        AppMethodBeat.o(334200);
      }
      
      public final void a(j paramj, int paramInt1, int paramInt2, int paramInt3)
      {
        AppMethodBeat.i(334237);
        s.u(paramj, "holder");
        AppMethodBeat.o(334237);
      }
      
      public final void a(j paramj, ah paramah, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(334213);
        s.u(paramj, "holder");
        s.u(paramah, "item");
        super.a(paramj, paramah, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = n.Bvk;
        n.x(paramj);
        paramah = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Sp(paramah.feedObject.getDescription());
        ((NeatTextView)paramj.UH(e.e.text_content)).aZ((CharSequence)p.b((Context)this.Bvj.lzt, (CharSequence)paramah, paramj.context.getResources().getDimension(e.c.GroupTitleTextSize)));
        paramah = paramj.UH(e.e.finder_feed_item_of_news);
        if (paramah != null) {
          paramah.setVisibility(8);
        }
        paramah = paramj.UH(e.e.finder_feed_item_of_news_title);
        if (paramah != null) {
          paramah.setVisibility(8);
        }
        n(paramj);
        AppMethodBeat.o(334213);
      }
      
      public final void b(j paramj, int paramInt)
      {
        AppMethodBeat.i(334252);
        s.u(paramj, "holder");
        AppMethodBeat.o(334252);
      }
      
      public final boolean dXz()
      {
        return true;
      }
      
      public final void f(j paramj)
      {
        AppMethodBeat.i(334246);
        s.u(paramj, "holder");
        AppMethodBeat.o(334246);
      }
      
      public final void k(j paramj)
      {
        AppMethodBeat.i(334219);
        s.u(paramj, "holder");
        ((TextView)paramj.UH(e.e.full_friend_follow_count)).setVisibility(8);
        AppMethodBeat.o(334219);
      }
      
      public final void l(j paramj)
      {
        AppMethodBeat.i(334231);
        s.u(paramj, "holder");
        ((TextView)paramj.UH(e.e.little_follow_tv)).setVisibility(8);
        AppMethodBeat.o(334231);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert;", "isOnlyShowDesc", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "payloads", "", "", "onDeepEnjoyMedia", "source", "onHafEnjoyMedia", "onTenSecEnjoy", "refreshFinderLivingStatusView", "refreshFollowState", "refreshFriendFollowCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends q
    {
      b(m.a parama, boolean paramBoolean, int paramInt)
      {
        super(paramBoolean, paramInt);
        AppMethodBeat.i(334209);
        AppMethodBeat.o(334209);
      }
      
      private void a(j paramj, v paramv, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(334222);
        s.u(paramj, "holder");
        s.u(paramv, "item");
        super.a(paramj, (BaseFinderFeed)paramv, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = n.Bvk;
        n.x(paramj);
        paramv = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Sp(paramv.feedObject.getDescription());
        ((NeatTextView)paramj.UH(e.e.text_content)).aZ((CharSequence)p.b((Context)this.Bvj.lzt, (CharSequence)paramv, paramj.context.getResources().getDimension(e.c.GroupTitleTextSize)));
        paramv = paramj.UH(e.e.finder_feed_item_of_news);
        if (paramv != null) {
          paramv.setVisibility(8);
        }
        paramv = paramj.UH(e.e.finder_feed_item_of_news_title);
        if (paramv != null) {
          paramv.setVisibility(8);
        }
        n(paramj);
        AppMethodBeat.o(334222);
      }
      
      public final void a(j paramj, int paramInt1, int paramInt2, int paramInt3)
      {
        AppMethodBeat.i(334248);
        s.u(paramj, "holder");
        AppMethodBeat.o(334248);
      }
      
      public final void a(j paramj, v paramv)
      {
        AppMethodBeat.i(334268);
        s.u(paramj, "holder");
        s.u(paramv, "item");
        AppMethodBeat.o(334268);
      }
      
      public final void b(j paramj, int paramInt)
      {
        AppMethodBeat.i(334262);
        s.u(paramj, "holder");
        AppMethodBeat.o(334262);
      }
      
      public final boolean dXz()
      {
        return true;
      }
      
      public final void f(j paramj)
      {
        AppMethodBeat.i(334256);
        s.u(paramj, "holder");
        AppMethodBeat.o(334256);
      }
      
      public final void k(j paramj)
      {
        AppMethodBeat.i(334227);
        s.u(paramj, "holder");
        ((TextView)paramj.UH(e.e.full_friend_follow_count)).setVisibility(8);
        AppMethodBeat.o(334227);
      }
      
      public final void l(j paramj)
      {
        AppMethodBeat.i(334241);
        s.u(paramj, "holder");
        ((TextView)paramj.UH(e.e.little_follow_tv)).setVisibility(8);
        AppMethodBeat.o(334241);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter$onAttach$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "wxRVData", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements o
  {
    b(m.a parama) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(334141);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramm, "wxRVData");
      if ((paramm.state == 0) || (paramm.state == 8))
      {
        if (this.Bvj.Bvi)
        {
          paramm = (Iterable)paramm.agOB;
          paramRecyclerView = this.Bvj;
          paramm = paramm.iterator();
          while (paramm.hasNext())
          {
            a locala = ((com.tencent.mm.view.recyclerview.n)paramm.next()).agOG;
            if ((locala instanceof BaseFinderFeed))
            {
              f localf = f.BuT;
              f.R(locala.bZA(), paramRecyclerView.Bvh);
            }
          }
          AppMethodBeat.o(334141);
          return;
        }
        this.Bvj.Bvi = true;
      }
      AppMethodBeat.o(334141);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.m.a
 * JD-Core Version:    0.7.0.1
 */