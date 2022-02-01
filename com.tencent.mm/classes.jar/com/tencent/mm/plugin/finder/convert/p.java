package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ae;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFoldedFeed;", "()V", "foldedController", "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1;", "getLayoutId", "", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpPos", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class p
  extends e<ae>
{
  public static final a tCs;
  private final b tCr;
  
  static
  {
    AppMethodBeat.i(242955);
    tCs = new a((byte)0);
    AppMethodBeat.o(242955);
  }
  
  public p()
  {
    AppMethodBeat.i(242954);
    this.tCr = new b(this);
    AppMethodBeat.o(242954);
  }
  
  private static void a(Context paramContext, FinderItem paramFinderItem, int paramInt)
  {
    AppMethodBeat.i(242952);
    List localList = paramFinderItem.getFoldedFeedList();
    int i;
    Object localObject;
    if (!Util.isNullOrNil(localList))
    {
      i = android.support.v4.b.a.clamp(paramInt, 0, localList.size() - 1);
      Log.i("Finder.FeedFullFoldedConvert", "[jumpFoldedUI] item " + paramFinderItem + " jumpPos " + paramInt);
      localObject = FinderFoldedScrollLayout.wmQ;
      FinderFoldedScrollLayout.Gw(((BaseFinderFeed)localList.get(i)).lT());
      localObject = FinderFoldedScrollLayout.wmQ;
      FinderFoldedScrollLayout.Gx(cl.aWA());
      localObject = new Intent();
      ((Intent)localObject).putExtra("FEED_ID", paramFinderItem.getId());
      ((Intent)localObject).putExtra("FEED_NONCE_ID", paramFinderItem.getObjectNonceId());
      ((Intent)localObject).putExtra("NICKNAME", paramFinderItem.getNickName());
      ((Intent)localObject).putExtra("FOLED_TYPE", 2);
      paramFinderItem = FinderReporterUIC.wzC;
      paramFinderItem = FinderReporterUIC.a.fH(paramContext);
      if (paramFinderItem == null) {
        break label215;
      }
    }
    label215:
    for (paramInt = paramFinderItem.tCE;; paramInt = 0)
    {
      ((Intent)localObject).putExtra("IS_FULL_SCREEN", y.a(y.vXH, 0, paramInt, 1));
      paramFinderItem = y.vXH;
      y.a(i, localList, null, (Intent)localObject);
      paramFinderItem = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.V(paramContext, (Intent)localObject);
      AppMethodBeat.o(242952);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(242950);
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramh, "holder");
    paramRecyclerView.getContext();
    Object localObject = new GridLayoutManager(3);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)paramh.Mn(2131301822);
    kotlin.g.b.p.g(localWxRecyclerView, "ry");
    localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localWxRecyclerView.b((RecyclerView.h)new d());
    localObject = com.tencent.mm.ui.component.a.PRN;
    paramRecyclerView = paramRecyclerView.getContext();
    kotlin.g.b.p.g(paramRecyclerView, "recyclerView.context");
    localWxRecyclerView.setRecycledViewPool(((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.ko(paramRecyclerView).get(FinderRecyclerViewPool.class)).wuB);
    paramRecyclerView = new ArrayList();
    localWxRecyclerView.setTag(paramRecyclerView);
    localWxRecyclerView.setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new e(this), paramRecyclerView, true));
    paramInt = au.getStatusBarHeight(paramh.getContext());
    int i = au.eu(paramh.getContext());
    paramRecyclerView = paramh.Mn(2131309232);
    kotlin.g.b.p.g(paramRecyclerView, "holder.getView<View>(R.id.title_layout)");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(242950);
      throw paramRecyclerView;
    }
    ((LinearLayout.LayoutParams)paramRecyclerView).topMargin = (paramInt + i);
    AppMethodBeat.o(242950);
  }
  
  public final int getLayoutId()
  {
    return 2131494334;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class b
    implements FinderFoldedScrollLayout.b
  {
    public final ConstraintLayout.LayoutParams cZE()
    {
      return null;
    }
    
    public final boolean cZF()
    {
      return false;
    }
    
    public final int cZG()
    {
      return 0;
    }
    
    public final void h(h paramh)
    {
      AppMethodBeat.i(242945);
      kotlin.g.b.p.h(paramh, "holder");
      Object localObject = paramh.getRecyclerView().getTag(2131301822);
      if (localObject == null)
      {
        paramh = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.storage.FinderItem");
        AppMethodBeat.o(242945);
        throw paramh;
      }
      localObject = (FinderItem)localObject;
      Context localContext = paramh.getContext();
      kotlin.g.b.p.g(localContext, "holder.context");
      p.b(localContext, (FinderItem)localObject, paramh.lR());
      AppMethodBeat.o(242945);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(p paramp, h paramh, ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242946);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.qhp.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      p.a(paramView, this.tCu.feedObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242946);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "space", "", "getSpace", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.h
  {
    private final int tCv;
    
    d()
    {
      AppMethodBeat.i(242948);
      this.tCv = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8.0F);
      AppMethodBeat.o(242948);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(242947);
      kotlin.g.b.p.h(paramRect, "outRect");
      kotlin.g.b.p.h(paramView, "view");
      kotlin.g.b.p.h(paramRecyclerView, "parent");
      kotlin.g.b.p.h(params, "state");
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      params = paramView.getLayoutParams();
      if (params == null)
      {
        paramRect = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager.LayoutParams");
        AppMethodBeat.o(242947);
        throw paramRect;
      }
      params = (GridLayoutManager.LayoutParams)params;
      int i = RecyclerView.bw(paramView);
      if (paramRecyclerView == null) {
        kotlin.g.b.p.hyc();
      }
      int j = paramRecyclerView.ki();
      if (paramRecyclerView.kf().ac(i, j) == 0) {
        paramRect.top = this.tCv;
      }
      paramRect.bottom = this.tCv;
      if (params.kk() == j)
      {
        paramRect.left = this.tCv;
        paramRect.right = this.tCv;
        AppMethodBeat.o(242947);
        return;
      }
      paramRect.left = ((int)((j - params.kj()) / j * this.tCv));
      paramRect.right = ((int)(1.0F * this.tCv * (j + 1) / j - paramRect.left));
      AppMethodBeat.o(242947);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class e
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(242949);
      e locale = (e)new an((FinderFoldedScrollLayout.b)p.a(this.tCt));
      AppMethodBeat.o(242949);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.p
 * JD-Core Version:    0.7.0.1
 */