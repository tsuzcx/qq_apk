package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.convert.an;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "", "forceDarkMode", "", "genCgiParams", "Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getTabFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "defaultSelected", "getTabTitle", "", "onActivityResult", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "resultCode", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSeach", "staggeredItemDecoration", "staggeredLayoutManager", "plugin-finder_release"})
public class d
  extends b
{
  public d(a parama)
  {
    super(parama);
    AppMethodBeat.i(278485);
    AppMethodBeat.o(278485);
  }
  
  public void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b.b paramb)
  {
    AppMethodBeat.i(278484);
    p.k(paramMMActivity, "activity");
    p.k(paramb, "curActivity");
    AppMethodBeat.o(278484);
  }
  
  public void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(278483);
    p.k(paramMMActivity, "activity");
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramList, "dataList");
    AppMethodBeat.o(278483);
  }
  
  public final String ag(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(278477);
    p.k(paramContext, "context");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(278477);
      return "";
    case 1: 
      paramContext = paramContext.getString(b.j.finder_tab_follow);
      p.j(paramContext, "context.getString(R.string.finder_tab_follow)");
      AppMethodBeat.o(278477);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(b.j.finder_gallery_tab_machine);
      p.j(paramContext, "context.getString(R.stri…nder_gallery_tab_machine)");
      AppMethodBeat.o(278477);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(b.j.finder_feed_like_tip);
      p.j(paramContext, "context.getString(R.string.finder_feed_like_tip)");
      AppMethodBeat.o(278477);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(b.j.finder_fav_icon_text);
      p.j(paramContext, "context.getString(R.string.finder_fav_icon_text)");
      AppMethodBeat.o(278477);
      return paramContext;
    }
    paramContext = paramContext.getString(b.j.finder_my_post);
    p.j(paramContext, "context.getString(R.string.finder_my_post)");
    AppMethodBeat.o(278477);
    return paramContext;
  }
  
  public final MMFinderFragment c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(278478);
    p.k(paramContext, "context");
    switch (paramInt)
    {
    default: 
      p.iCn();
      AppMethodBeat.o(278478);
      return null;
    }
    paramContext = (MMFinderFragment)new FinderGalleryFragment((b)this, paramInt, paramBoolean);
    AppMethodBeat.o(278478);
    return paramContext;
  }
  
  public com.tencent.mm.view.recyclerview.f dwa()
  {
    AppMethodBeat.i(278479);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(278479);
    return localf;
  }
  
  public boolean dwb()
  {
    return false;
  }
  
  public RecyclerView.h dwc()
  {
    AppMethodBeat.i(278481);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(278481);
    return localh;
  }
  
  public RecyclerView.LayoutManager ft(Context paramContext)
  {
    AppMethodBeat.i(278480);
    p.k(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(2);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(278480);
    return paramContext;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(278558);
      switch (paramInt)
      {
      default: 
        localObject = aj.AGc;
        aj.em("FinderStaggeredConfig", paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(278558);
        return localObject;
      case 4: 
      case 9: 
        localObject = (e)new a(this);
        AppMethodBeat.o(278558);
        return localObject;
      }
      Object localObject = (e)new b(this);
      AppMethodBeat.o(278558);
      return localObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class a
      extends an
    {
      public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(238700);
        p.k(parami, "holder");
        p.k(paramBaseFinderFeed, "item");
        super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = com.tencent.mm.plugin.finder.gallery.convert.b.xUn;
        parami = parami.amk;
        p.j(parami, "holder.itemView");
        com.tencent.mm.plugin.finder.gallery.convert.b.a(parami, paramBaseFinderFeed, true, this.xTL.xTK.dwb());
        AppMethodBeat.o(238700);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
    public static final class b
      extends w
    {
      public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(264835);
        p.k(parami, "holder");
        p.k(paramBaseFinderFeed, "item");
        super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        paramList = com.tencent.mm.plugin.finder.gallery.convert.b.xUn;
        parami = parami.amk;
        p.j(parami, "holder.itemView");
        com.tencent.mm.plugin.finder.gallery.convert.b.a(parami, paramBaseFinderFeed, true, this.xTL.xTK.dwb());
        AppMethodBeat.o(264835);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$staggeredItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(289352);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int i = (int)paramRecyclerView.getResources().getDimension(b.d.Edge_0_5_A);
      paramRecyclerView = paramView.getContext();
      p.j(paramRecyclerView, "view.context");
      int j = (int)paramRecyclerView.getResources().getDimension(b.d.finder_0_25_A);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(289352);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).mF())
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(289352);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(289352);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).kv() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(289352);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(289352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.d
 * JD-Core Version:    0.7.0.1
 */