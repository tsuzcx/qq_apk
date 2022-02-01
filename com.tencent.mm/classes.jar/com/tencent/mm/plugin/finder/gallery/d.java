package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "", "enableGalleryTimelinePage", "", "forceDarkMode", "genCgiParams", "Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getRequestCode", "getTabFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "defaultSelected", "getTabTitle", "", "isFinderGalleryNewStyle", "onActivityResult", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "resultCode", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSeach", "onFinish", "staggeredItemDecoration", "staggeredLayoutManager", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends b
{
  public d(a parama)
  {
    super(parama);
    AppMethodBeat.i(334314);
    AppMethodBeat.o(334314);
  }
  
  public static boolean egz()
  {
    AppMethodBeat.i(334326);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYk().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(334326);
      return true;
    }
    AppMethodBeat.o(334326);
    return false;
  }
  
  public com.tencent.mm.view.recyclerview.g Os(int paramInt)
  {
    AppMethodBeat.i(334367);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a(this);
    AppMethodBeat.o(334367);
    return localg;
  }
  
  public RecyclerView.h Ot(int paramInt)
  {
    AppMethodBeat.i(334386);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(334386);
    return localh;
  }
  
  public void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b.b paramb)
  {
    AppMethodBeat.i(334425);
    s.u(paramMMActivity, "activity");
    s.u(paramb, "curActivity");
    AppMethodBeat.o(334425);
  }
  
  public void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(334416);
    s.u(paramMMActivity, "activity");
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramList, "dataList");
    AppMethodBeat.o(334416);
  }
  
  public final String ap(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(334345);
    s.u(paramContext, "context");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(334345);
      return "";
    case 1: 
      paramContext = paramContext.getString(e.h.finder_tab_follow);
      s.s(paramContext, "context.getString(R.string.finder_tab_follow)");
      AppMethodBeat.o(334345);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(e.h.finder_gallery_tab_machine);
      s.s(paramContext, "context.getString(R.stri…nder_gallery_tab_machine)");
      AppMethodBeat.o(334345);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(e.h.finder_feed_like_tip);
      s.s(paramContext, "context.getString(R.string.finder_feed_like_tip)");
      AppMethodBeat.o(334345);
      return paramContext;
    case 3: 
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0) {}
      for (paramContext = paramContext.getString(e.h.finder_fav_icon_text);; paramContext = paramContext.getString(e.h.finder_fav_icon_text2))
      {
        s.s(paramContext, "{\n                if (Fi…          }\n            }");
        AppMethodBeat.o(334345);
        return paramContext;
      }
    }
    paramContext = paramContext.getString(e.h.finder_my_post);
    s.s(paramContext, "context.getString(R.string.finder_my_post)");
    AppMethodBeat.o(334345);
    return paramContext;
  }
  
  public RecyclerView.LayoutManager aq(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(334377);
    s.u(paramContext, "context");
    paramContext = new FinderStaggeredGridLayoutManager(2, 1);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(334377);
    return paramContext;
  }
  
  public final MMFinderFragment c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(334358);
    s.u(paramContext, "context");
    switch (paramInt)
    {
    default: 
      s.checkNotNull(null);
      paramContext = new kotlin.f();
      AppMethodBeat.o(334358);
      throw paramContext;
    }
    paramContext = (MMFinderFragment)new FinderGalleryFragment((b)this, paramInt, paramBoolean);
    AppMethodBeat.o(334358);
    return paramContext;
  }
  
  public boolean egw()
  {
    return false;
  }
  
  public boolean egx()
  {
    return false;
  }
  
  public int egy()
  {
    return -1;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(d paramd) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(334346);
      switch (paramInt)
      {
      default: 
        localObject = av.GiL;
        av.eY("FinderStaggeredConfig", paramInt);
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(334346);
        return localObject;
      case 4: 
      case 9: 
        localObject = (com.tencent.mm.view.recyclerview.f)new a(this.BuF);
        AppMethodBeat.o(334346);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.f)new b(this.BuF);
      AppMethodBeat.o(334346);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends ah
    {
      a(d paramd) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(334176);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        if (this.BuF.egw())
        {
          paramList = n.Bvk;
          n.y(paramj);
        }
        paramList = (TextView)paramj.UH(e.e.finder_desc);
        Object localObject1;
        if (paramList != null)
        {
          if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
            break label270;
          }
          paramList.setVisibility(0);
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eYb().bmg()).intValue() != 1) {
            break label256;
          }
          localObject1 = k.FxZ;
          paramInt1 = k.ePd();
          localObject1 = MMApplicationContext.getContext();
          Object localObject2 = k.FxZ;
          localObject2 = paramBaseFinderFeed.feedObject.getDescription();
          TextPaint localTextPaint = paramList.getPaint();
          s.s(localTextPaint, "paint");
          paramList.setText((CharSequence)p.d((Context)localObject1, (CharSequence)k.a((String)localObject2, localTextPaint, paramInt1), 0.0F));
        }
        for (;;)
        {
          paramList = (ImageView)paramj.UH(e.e.finder_avatar);
          localObject1 = (TextView)paramj.UH(e.e.finder_nickname);
          paramList.setClickable(false);
          paramList.setEnabled(false);
          ((TextView)localObject1).setClickable(false);
          ((TextView)localObject1).setEnabled(false);
          paramList = com.tencent.mm.plugin.finder.gallery.convert.b.Bvm;
          paramj = paramj.caK;
          s.s(paramj, "holder.itemView");
          com.tencent.mm.plugin.finder.gallery.convert.b.a(paramj, paramBaseFinderFeed, true, this.BuF.egw());
          AppMethodBeat.o(334176);
          return;
          label256:
          localObject1 = k.FxZ;
          paramInt1 = k.ePd() / 2;
          break;
          label270:
          paramList.setVisibility(8);
          paramList.setText((CharSequence)"");
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends u
    {
      b(d paramd) {}
      
      public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(334149);
        s.u(paramj, "holder");
        s.u(paramBaseFinderFeed, "item");
        super.a(paramj, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
        if (this.BuF.egw())
        {
          paramList = n.Bvk;
          n.z(paramj);
        }
        paramList = (ImageView)paramj.UH(e.e.finder_avatar);
        TextView localTextView = (TextView)paramj.UH(e.e.finder_nickname);
        paramList.setClickable(false);
        paramList.setEnabled(false);
        localTextView.setClickable(false);
        localTextView.setEnabled(false);
        paramList = com.tencent.mm.plugin.finder.gallery.convert.b.Bvm;
        paramj = paramj.caK;
        s.s(paramj, "holder.itemView");
        com.tencent.mm.plugin.finder.gallery.convert.b.a(paramj, paramBaseFinderFeed, true, this.BuF.egw());
        AppMethodBeat.o(334149);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig$staggeredItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(334356);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      int i = (int)paramView.getContext().getResources().getDimension(e.c.Edge_0_5_A);
      int j = (int)paramView.getContext().getResources().getDimension(e.c.finder_0_25_A);
      paramRecyclerView = paramView.getLayoutParams();
      if (paramRecyclerView == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(334356);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB)
      {
        paramRect.left = 0;
        paramRect.right = 0;
        paramRect.bottom = 0;
        paramRect.top = 0;
        AppMethodBeat.o(334356);
        return;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        AppMethodBeat.o(334356);
        throw paramRect;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)paramView).Lh() % 2 == 0)
      {
        paramRect.left = i;
        paramRect.right = j;
        paramRect.bottom = j;
        paramRect.top = j;
        AppMethodBeat.o(334356);
        return;
      }
      paramRect.left = j;
      paramRect.right = i;
      paramRect.bottom = j;
      paramRect.top = j;
      AppMethodBeat.o(334356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.d
 * JD-Core Version:    0.7.0.1
 */