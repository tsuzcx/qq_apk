package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.c;
import com.tencent.mm.plugin.finder.viewmodel.c.b;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isNoShowGuide", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "runnable", "Ljava/lang/Runnable;", "showGuideFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkFirstFeed", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "checkGuideConfig", "onCheckShowGuide", "isSliceNoShowLoadingRefresh", "onDestroy", "setRecyclerView", "setShowGuideFeed", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends UIComponent
{
  public static final a GQw;
  public boolean GQx;
  private BaseFinderFeed GQy;
  private final Runnable hPJ;
  private final MMHandler mRi;
  private RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(338856);
    GQw = new a((byte)0);
    AppMethodBeat.o(338856);
  }
  
  public ac(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338799);
    this.hPJ = new ac..ExternalSyntheticLambda0(this);
    this.mRi = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(338799);
  }
  
  public ac(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338790);
    this.hPJ = new ac..ExternalSyntheticLambda0(this);
    this.mRi = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(338790);
  }
  
  public static void F(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(338811);
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).Jv() == 1)) {
      h.baE().ban().set(at.a.acZE, Boolean.TRUE);
    }
    AppMethodBeat.o(338811);
  }
  
  private static final void b(ac paramac)
  {
    Object localObject2 = null;
    AppMethodBeat.i(338826);
    s.u(paramac, "this$0");
    Object localObject1 = paramac.mkw;
    int i;
    RecyclerView localRecyclerView;
    if (localObject1 == null)
    {
      i = 0;
      Log.i("Finder.FullFeedGuideUIC", s.X("[videoComplete] count=", Integer.valueOf(i)));
      if (i > 0)
      {
        localRecyclerView = paramac.mkw;
        label130:
        if (localRecyclerView != null)
        {
          localObject1 = localRecyclerView.getLayoutManager();
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label198;
          }
          localObject1 = (LinearLayoutManager)localObject1;
          label71:
          if (localObject1 != null)
          {
            i = ((LinearLayoutManager)localObject1).Jv();
            localObject1 = localRecyclerView.getAdapter();
            if ((i >= 0) && ((localObject1 instanceof WxRecyclerAdapter)) && (paramac.GQy != null))
            {
              localObject1 = (com.tencent.mm.view.recyclerview.a)p.ae((List)((WxRecyclerAdapter)localObject1).data, i + 1);
              if (localObject1 != null) {
                break label203;
              }
              localObject1 = null;
              paramac = paramac.GQy;
              if (paramac != null) {
                break label216;
              }
            }
          }
        }
      }
    }
    label198:
    label203:
    label216:
    for (paramac = localObject2;; paramac = Long.valueOf(paramac.bZA()))
    {
      if (s.p(localObject1, paramac)) {
        localRecyclerView.br(0, (int)localRecyclerView.getContext().getResources().getDimension(e.c.Edge_15A));
      }
      AppMethodBeat.o(338826);
      return;
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      i = ((RecyclerView.a)localObject1).getItemCount();
      break;
      localObject1 = null;
      break label71;
      localObject1 = Long.valueOf(((com.tencent.mm.view.recyclerview.a)localObject1).bZA());
      break label130;
    }
  }
  
  public final void l(cc paramcc)
  {
    AppMethodBeat.i(338877);
    Object localObject1 = k.aeZF;
    localObject1 = ((as)k.nq((Context)getContext()).q(as.class)).fou();
    Object localObject2 = k.aeZF;
    if (((c)k.cn(PluginFinder.class).q(c.class)).j((bui)localObject1).scene != 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("Finder.FullFeedGuideUIC", "isUseNewGuide");
      AppMethodBeat.o(338877);
      return;
    }
    if (this.GQx)
    {
      Log.w("Finder.FullFeedGuideUIC", "first video media type placeholder no show guide");
      AppMethodBeat.o(338877);
      return;
    }
    boolean bool1;
    boolean bool2;
    if (!h.baE().ban().getBoolean(at.a.acZE, false))
    {
      bool1 = true;
      i = h.baE().ban().getInt(at.a.acZF, 0);
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label359;
      }
      bool2 = false;
      label160:
      Log.i("Finder.FullFeedGuideUIC", "setShowGuideFeed isFirst:" + bool1 + ",liveListIsVisible:" + bool2);
      if ((bool1) && (!bool2) && ((paramcc instanceof BaseFinderFeed)) && (i < 3))
      {
        ((BaseFinderFeed)paramcc).isShowGuideTips = 1;
        this.GQy = ((BaseFinderFeed)paramcc);
        localObject1 = k.aeZF;
        ((ah)k.d(getActivity()).q(ah.class)).GRZ = false;
        localObject1 = k.aeZF;
        ((com.tencent.mm.plugin.finder.share.a)k.nq((Context)getContext()).q(com.tencent.mm.plugin.finder.share.a.class)).FzM = true;
        localObject1 = this.mkw;
        if (localObject1 != null) {
          break label374;
        }
        localObject1 = null;
        label297:
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          break label384;
        }
      }
    }
    label384:
    for (localObject1 = (WxRecyclerAdapter)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((WxRecyclerAdapter)localObject1).AQ(((BaseFinderFeed)paramcc).bZA());
      }
      h.baE().ban().set(at.a.acZF, Integer.valueOf(i + 1));
      AppMethodBeat.o(338877);
      return;
      bool1 = false;
      break;
      label359:
      localObject2 = av.GiL;
      bool2 = av.D((RecyclerView)localObject1);
      break label160;
      label374:
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      break label297;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338905);
    super.onDestroy();
    BaseFinderFeed localBaseFinderFeed = this.GQy;
    if (localBaseFinderFeed != null) {
      localBaseFinderFeed.isShowGuideTips = -1;
    }
    this.mRi.removeCallbacksAndMessages(null);
    AppMethodBeat.o(338905);
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(338883);
    this.mkw = paramRecyclerView;
    if (paramRecyclerView != null) {
      paramRecyclerView.a((RecyclerView.l)new b(this));
    }
    AppMethodBeat.o(338883);
  }
  
  public final void vn(boolean paramBoolean)
  {
    boolean bool4 = true;
    AppMethodBeat.i(338897);
    boolean bool1;
    Object localObject1;
    boolean bool2;
    label41:
    Object localObject2;
    boolean bool3;
    label104:
    int i;
    if (!h.baE().ban().getBoolean(at.a.acZE, false))
    {
      bool1 = true;
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label289;
      }
      bool2 = false;
      localObject1 = k.aeZF;
      localObject1 = ((as)k.nq((Context)getContext()).q(as.class)).fou();
      localObject2 = k.aeZF;
      if (((c)k.cn(PluginFinder.class).q(c.class)).j((bui)localObject1).scene == 0) {
        break label304;
      }
      bool3 = true;
      i = h.baE().ban().getInt(at.a.acZF, 0);
      if (!this.GQx) {
        this.GQx = paramBoolean;
      }
      if (this.GQx)
      {
        localObject1 = this.GQy;
        if (localObject1 != null) {
          ((BaseFinderFeed)localObject1).isShowGuideTips = -1;
        }
      }
      localObject1 = new StringBuilder("[onCheckShowGuide] isUseNewGuide=").append(bool3).append(" isFirst=").append(bool1).append(", liveListIsVisible:").append(bool2).append(",recyclerView is null:");
      if (this.mkw != null) {
        break label310;
      }
    }
    label289:
    label304:
    label310:
    for (paramBoolean = bool4;; paramBoolean = false)
    {
      Log.i("Finder.FullFeedGuideUIC", paramBoolean);
      if ((bool1) && (!bool2) && (!bool3) && (!this.GQx))
      {
        this.mRi.postUIDelayed(this.hPJ, 2000L);
        if (i >= 3) {
          h.baE().ban().set(at.a.acZE, Boolean.TRUE);
        }
      }
      AppMethodBeat.o(338897);
      return;
      bool1 = false;
      break;
      localObject2 = av.GiL;
      bool2 = av.D((RecyclerView)localObject1);
      break label41;
      bool3 = false;
      break label104;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isShouldDismiss", "", "()Z", "setShouldDismiss", "(Z)V", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    private boolean GQz;
    private float offset = 100.0F;
    private View view;
    
    b(ac paramac) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(337574);
      Object localObject1 = new b();
      ((b)localObject1).cH(paramRecyclerView);
      ((b)localObject1).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((b)localObject1).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      int i;
      if (paramInt == 0) {
        if ((this.view == null) && (!ac.c(this.GQA)) && (ac.d(this.GQA) != null))
        {
          localObject1 = paramRecyclerView.getAdapter();
          if ((localObject1 instanceof WxRecyclerAdapter))
          {
            localObject1 = (WxRecyclerAdapter)localObject1;
            if (localObject1 == null) {
              break label293;
            }
            Object localObject2 = (List)((WxRecyclerAdapter)localObject1).data;
            if (localObject2 == null) {
              break label293;
            }
            localObject1 = this.GQA;
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            label147:
            if (!((Iterator)localObject2).hasNext()) {
              break label293;
            }
            long l = ((com.tencent.mm.view.recyclerview.a)((Iterator)localObject2).next()).bZA();
            BaseFinderFeed localBaseFinderFeed = ac.d((ac)localObject1);
            if ((localBaseFinderFeed == null) || (l != localBaseFinderFeed.bZA())) {
              break label280;
            }
            j = 1;
            label200:
            if (j == 0) {
              break label286;
            }
            label205:
            if (i >= 0)
            {
              paramRecyclerView = paramRecyclerView.fU(i);
              if (paramRecyclerView != null) {
                break label298;
              }
              paramRecyclerView = null;
              label221:
              this.view = paramRecyclerView;
              paramRecyclerView = this.view;
              if (paramRecyclerView != null) {
                paramRecyclerView.setVisibility(0);
              }
            }
          }
        }
      }
      for (;;)
      {
        if (paramInt == 1) {
          ac.e(this.GQA).removeCallbacksAndMessages(null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(337574);
        return;
        localObject1 = null;
        break;
        label280:
        j = 0;
        break label200;
        label286:
        i += 1;
        break label147;
        label293:
        i = -1;
        break label205;
        label298:
        paramRecyclerView = paramRecyclerView.caK;
        if (paramRecyclerView == null)
        {
          paramRecyclerView = null;
          break label221;
        }
        paramRecyclerView = paramRecyclerView.findViewById(e.e.guide_layout_parent);
        break label221;
        if (this.GQz)
        {
          localObject1 = ac.d(this.GQA);
          i = j;
          if (localObject1 != null)
          {
            i = j;
            if (((BaseFinderFeed)localObject1).isShowGuideTips == 1) {
              i = 1;
            }
          }
          if (i != 0)
          {
            localObject1 = this.view;
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(8);
            }
            ac.F(paramRecyclerView);
          }
          paramRecyclerView = ac.d(this.GQA);
          if (paramRecyclerView != null)
          {
            paramRecyclerView.isShowGuideTips = -1;
            continue;
            if ((this.view != null) && (paramInt == 1)) {
              this.GQz = true;
            }
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(337581);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.view;
      if (paramRecyclerView != null)
      {
        this.offset -= paramInt2 / 5.0F;
        this.offset = androidx.core.b.a.g(this.offset, 0.0F, 100.0F);
        paramRecyclerView.setAlpha(this.offset / 100.0F);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(337581);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ac
 * JD-Core Version:    0.7.0.1
 */