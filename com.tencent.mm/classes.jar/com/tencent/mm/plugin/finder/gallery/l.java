package com.tencent.mm.plugin.finder.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTextStateConfig;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryDefaultConfig;", "data", "Lcom/tencent/mm/plugin/finder/gallery/ConfigData;", "(Lcom/tencent/mm/plugin/finder/gallery/ConfigData;)V", "lastSelectFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLastSelectFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setLastSelectFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "tabType", "", "dealPreviewResult", "", "requestCode", "resultCode", "activity", "Lcom/tencent/mm/ui/MMActivity;", "inSearch", "forceDarkMode", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "onActivityResult", "", "Landroid/content/Intent;", "curActivity", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig$UI;", "onFeedSelected", "feed", "dataList", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "fromSearch", "plugin-finder_release"})
public final class l
  extends d
{
  private BaseFinderFeed xUb;
  
  public l(a parama)
  {
    super(parama);
    AppMethodBeat.i(290776);
    AppMethodBeat.o(290776);
  }
  
  private final boolean a(int paramInt1, int paramInt2, MMActivity paramMMActivity, boolean paramBoolean)
  {
    long l = 0L;
    AppMethodBeat.i(290772);
    BaseFinderFeed localBaseFinderFeed = this.xUb;
    if ((paramInt1 == 10001) && (paramInt2 == -1) && (localBaseFinderFeed != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("SELECT_OBJECT", localBaseFinderFeed.feedObject.getFeedObject().toByteArray());
      paramMMActivity.setResult(-1, localIntent);
      paramMMActivity.finish();
      if (!paramBoolean)
      {
        paramMMActivity = f.xUa;
        f.Lc(localBaseFinderFeed.mf());
      }
      for (;;)
      {
        AppMethodBeat.o(290772);
        return true;
        paramMMActivity = f.xUa;
        f.Le(localBaseFinderFeed.mf());
      }
    }
    if (paramInt1 == 10001)
    {
      if (paramBoolean) {
        break label152;
      }
      paramMMActivity = f.xUa;
      paramMMActivity = this.xUb;
      if (paramMMActivity != null) {
        l = paramMMActivity.mf();
      }
      f.Ld(l);
    }
    for (;;)
    {
      AppMethodBeat.o(290772);
      return false;
      label152:
      paramMMActivity = f.xUa;
      paramMMActivity = this.xUb;
      if (paramMMActivity != null) {
        l = paramMMActivity.mf();
      }
      f.Lf(l);
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent, b.b paramb)
  {
    AppMethodBeat.i(290771);
    p.k(paramMMActivity, "activity");
    p.k(paramb, "curActivity");
    switch (m.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(290771);
      return;
      if ((!a(paramInt1, paramInt2, paramMMActivity, false)) && (paramInt1 == 20000) && (paramInt2 == -1))
      {
        paramMMActivity.setResult(-1, paramIntent);
        paramMMActivity.finish();
        AppMethodBeat.o(290771);
        return;
        a(paramInt1, paramInt2, paramMMActivity, true);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt, BaseFinderFeed paramBaseFinderFeed, List<? extends BaseFinderFeed> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(290770);
    p.k(paramMMActivity, "activity");
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramList, "dataList");
    this.xUb = paramBaseFinderFeed;
    paramList = new Intent();
    paramList.putExtra("SELECT_OBJECT", paramBaseFinderFeed.feedObject.getFeedObject().toByteArray());
    ((com.tencent.mm.plugin.textstatus.a.l)h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).m((Activity)paramMMActivity, paramList);
    AppMethodBeat.o(290770);
  }
  
  public final com.tencent.mm.view.recyclerview.f dwa()
  {
    AppMethodBeat.i(290773);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a();
    AppMethodBeat.o(290773);
    return localf;
  }
  
  public final boolean dwb()
  {
    return true;
  }
  
  public final RecyclerView.h dwc()
  {
    AppMethodBeat.i(290775);
    RecyclerView.h localh = (RecyclerView.h)new b();
    AppMethodBeat.o(290775);
    return localh;
  }
  
  public final RecyclerView.LayoutManager ft(Context paramContext)
  {
    AppMethodBeat.i(290774);
    p.k(paramContext, "context");
    paramContext = new GridLayoutManager(3);
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(290774);
    return paramContext;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTextStateConfig$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(278201);
      switch (paramInt)
      {
      default: 
        localObject = aj.AGc;
        aj.em("FinderStaggeredConfig", paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(278201);
        return localObject;
      case 4: 
      case 9: 
        localObject = (e)new com.tencent.mm.plugin.finder.gallery.convert.a();
        AppMethodBeat.o(278201);
        return localObject;
      }
      Object localObject = (e)new com.tencent.mm.plugin.finder.gallery.convert.a();
      AppMethodBeat.o(278201);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryTextStateConfig$getItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(285106);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      paramRecyclerView = paramView.getLayoutParams();
      paramView = paramRecyclerView;
      if (!(paramRecyclerView instanceof GridLayoutManager.LayoutParams)) {
        paramView = null;
      }
      paramView = (GridLayoutManager.LayoutParams)paramView;
      if (paramView != null)
      {
        if (paramView.kv() % 3 == 1)
        {
          paramRect.left = 1;
          paramRect.right = 1;
        }
        paramRect.bottom = 1;
        paramRect.top = 0;
        AppMethodBeat.o(285106);
        return;
      }
      AppMethodBeat.o(285106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.l
 * JD-Core Version:    0.7.0.1
 */