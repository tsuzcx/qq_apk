package com.tencent.mm.plugin.finder.view.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.a.b;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import com.tencent.mm.view.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/base/MediaPlayBanner;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "adapter", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "dataObserver", "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "Lcom/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1;", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "indicator", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/IMediaBannerIndicator;", "setIndicator", "(Lcom/tencent/mm/view/IMediaBannerIndicator;)V", "", "isAutoPlay", "()Z", "setAutoPlay", "(Z)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "", "playLoopDurationMs", "getPlayLoopDurationMs", "()J", "setPlayLoopDurationMs", "(J)V", "recyclerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getRecyclerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "getChildViewAt", "Landroid/view/View;", "position", "onAttachedToWindow", "", "onDetachedFromWindow", "pauseLoopPlay", "pauseDuration", "selectViewAt", "isAuto", "smoothScrollTo", "startLoopPlay", "duration", "stopLoopPlay", "Companion", "IPageChangeCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MediaPlayBanner
  extends FrameLayout
{
  public static final MediaPlayBanner.a GGw;
  private LinearLayoutManager AJH;
  private int GGA;
  private i GGB;
  private MediaBanner.c GGC;
  private final b GGD;
  private float GGx;
  private final RecyclerHorizontalViewPager GGy;
  private long GGz;
  private final MMHandler handler;
  private boolean isAutoPlay;
  private RecyclerView.a<b> mlt;
  
  static
  {
    AppMethodBeat.i(345824);
    GGw = new MediaPlayBanner.a((byte)0);
    AppMethodBeat.o(345824);
  }
  
  public MediaPlayBanner(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(345732);
    this.GGx = 60.0F;
    getContext();
    paramContext = new LinearLayoutManager()
    {
      public final int b(RecyclerView.s paramAnonymouss)
      {
        return 1;
      }
      
      public final void smoothScrollToPosition(RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss, int paramAnonymousInt)
      {
        AppMethodBeat.i(345728);
        paramAnonymousRecyclerView = this.GGE.getContext();
        paramAnonymousRecyclerView = new a(this.GGE, paramAnonymousRecyclerView);
        paramAnonymousRecyclerView.cag = paramAnonymousInt;
        startSmoothScroll((RecyclerView.r)paramAnonymousRecyclerView);
        AppMethodBeat.o(345728);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        extends o
      {
        a(MediaPlayBanner paramMediaPlayBanner, Context paramContext)
        {
          super();
        }
        
        public final float c(DisplayMetrics paramDisplayMetrics)
        {
          AppMethodBeat.i(345714);
          s.u(paramDisplayMetrics, "displayMetrics");
          float f = this.GGE.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
          AppMethodBeat.o(345714);
          return f;
        }
      }
    };
    paramContext.setOrientation(0);
    ah localah = ah.aiuX;
    this.AJH = ((LinearLayoutManager)paramContext);
    paramContext = getContext();
    s.s(paramContext, "context");
    paramContext = new RecyclerHorizontalViewPager(paramContext);
    paramContext.setPageChangeListener((RecyclerHorizontalViewPager.b)new c(this));
    paramContext.setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localah = ah.aiuX;
    this.GGy = paramContext;
    this.GGz = 2500L;
    this.GGD = new b(this);
    this.handler = new MMHandler(Looper.getMainLooper(), new MediaPlayBanner..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(345732);
  }
  
  public MediaPlayBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345738);
    this.GGx = 60.0F;
    getContext();
    paramContext = new LinearLayoutManager()
    {
      public final int b(RecyclerView.s paramAnonymouss)
      {
        return 1;
      }
      
      public final void smoothScrollToPosition(RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss, int paramAnonymousInt)
      {
        AppMethodBeat.i(345728);
        paramAnonymousRecyclerView = this.GGE.getContext();
        paramAnonymousRecyclerView = new a(this.GGE, paramAnonymousRecyclerView);
        paramAnonymousRecyclerView.cag = paramAnonymousInt;
        startSmoothScroll((RecyclerView.r)paramAnonymousRecyclerView);
        AppMethodBeat.o(345728);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        extends o
      {
        a(MediaPlayBanner paramMediaPlayBanner, Context paramContext)
        {
          super();
        }
        
        public final float c(DisplayMetrics paramDisplayMetrics)
        {
          AppMethodBeat.i(345714);
          s.u(paramDisplayMetrics, "displayMetrics");
          float f = this.GGE.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
          AppMethodBeat.o(345714);
          return f;
        }
      }
    };
    paramContext.setOrientation(0);
    paramAttributeSet = ah.aiuX;
    this.AJH = ((LinearLayoutManager)paramContext);
    paramContext = getContext();
    s.s(paramContext, "context");
    paramContext = new RecyclerHorizontalViewPager(paramContext);
    paramContext.setPageChangeListener((RecyclerHorizontalViewPager.b)new c(this));
    paramContext.setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = ah.aiuX;
    this.GGy = paramContext;
    this.GGz = 2500L;
    this.GGD = new b(this);
    this.handler = new MMHandler(Looper.getMainLooper(), new MediaPlayBanner..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(345738);
  }
  
  public MediaPlayBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345748);
    this.GGx = 60.0F;
    getContext();
    paramContext = new LinearLayoutManager()
    {
      public final int b(RecyclerView.s paramAnonymouss)
      {
        return 1;
      }
      
      public final void smoothScrollToPosition(RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss, int paramAnonymousInt)
      {
        AppMethodBeat.i(345728);
        paramAnonymousRecyclerView = this.GGE.getContext();
        paramAnonymousRecyclerView = new a(this.GGE, paramAnonymousRecyclerView);
        paramAnonymousRecyclerView.cag = paramAnonymousInt;
        startSmoothScroll((RecyclerView.r)paramAnonymousRecyclerView);
        AppMethodBeat.o(345728);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        extends o
      {
        a(MediaPlayBanner paramMediaPlayBanner, Context paramContext)
        {
          super();
        }
        
        public final float c(DisplayMetrics paramDisplayMetrics)
        {
          AppMethodBeat.i(345714);
          s.u(paramDisplayMetrics, "displayMetrics");
          float f = this.GGE.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
          AppMethodBeat.o(345714);
          return f;
        }
      }
    };
    paramContext.setOrientation(0);
    paramAttributeSet = ah.aiuX;
    this.AJH = ((LinearLayoutManager)paramContext);
    paramContext = getContext();
    s.s(paramContext, "context");
    paramContext = new RecyclerHorizontalViewPager(paramContext);
    paramContext.setPageChangeListener((RecyclerHorizontalViewPager.b)new c(this));
    paramContext.setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = ah.aiuX;
    this.GGy = paramContext;
    this.GGz = 2500L;
    this.GGD = new b(this);
    this.handler = new MMHandler(Looper.getMainLooper(), new MediaPlayBanner..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(345748);
  }
  
  private static final void a(RecyclerView.a parama, MediaPlayBanner paramMediaPlayBanner)
  {
    AppMethodBeat.i(345798);
    s.u(paramMediaPlayBanner, "this$0");
    ((com.tencent.mm.ui.base.a.a)parama).removeItem(((com.tencent.mm.ui.base.a.a)parama).getItemCount() - 1);
    ((com.tencent.mm.ui.base.a.a)parama).a((RecyclerView.c)paramMediaPlayBanner.GGD);
    parama = paramMediaPlayBanner.GGy;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(parama, locala.aYi(), "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    parama.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    paramMediaPlayBanner.GGy.g(0, true, true);
    a(paramMediaPlayBanner);
    AppMethodBeat.o(345798);
  }
  
  private static final boolean a(MediaPlayBanner paramMediaPlayBanner, Message paramMessage)
  {
    AppMethodBeat.i(345815);
    s.u(paramMediaPlayBanner, "this$0");
    s.u(paramMessage, "it");
    RecyclerView.a locala;
    int i;
    int j;
    if (paramMessage.what == 1)
    {
      locala = paramMediaPlayBanner.getAdapter();
      if (locala != null) {
        break label88;
      }
      i = 0;
      if (i > 1)
      {
        j = paramMediaPlayBanner.getFocusPosition() + 1;
        locala = paramMediaPlayBanner.getAdapter();
        if (locala != null) {
          break label97;
        }
        i = 0;
        label65:
        if (j >= i) {
          break label106;
        }
        paramMediaPlayBanner.aU(j, true);
        a(paramMediaPlayBanner);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(345815);
      return true;
      label88:
      i = locala.getItemCount();
      break;
      label97:
      i = locala.getItemCount();
      break label65;
      label106:
      locala = paramMediaPlayBanner.getAdapter();
      if (locala == null)
      {
        i = 0;
        label119:
        if (j != i) {
          continue;
        }
        locala = paramMediaPlayBanner.getAdapter();
        if (!(locala instanceof com.tencent.mm.ui.base.a.a)) {
          continue;
        }
      }
      try
      {
        ((com.tencent.mm.ui.base.a.a)locala).b((RecyclerView.c)paramMediaPlayBanner.GGD);
        label153:
        ((com.tencent.mm.ui.base.a.a)locala).aBb(((com.tencent.mm.ui.base.a.a)locala).getItemCount());
        paramMediaPlayBanner.getRecyclerView().setItemAnimator(null);
        paramMediaPlayBanner.aU(j, false);
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof Long))
        {
          paramMessage = (Long)paramMessage;
          label200:
          if (paramMessage != null) {
            break label247;
          }
        }
        label247:
        for (long l = 2500L;; l = paramMessage.longValue())
        {
          paramMediaPlayBanner.postDelayed(new MediaPlayBanner..ExternalSyntheticLambda1(locala, paramMediaPlayBanner), l / 5L);
          break;
          i = locala.getItemCount();
          break label119;
          paramMessage = null;
          break label200;
        }
      }
      catch (Exception localException)
      {
        break label153;
      }
    }
  }
  
  private void aU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(345755);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.GGy;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aYi(), "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    this.GGy.g(paramInt, true, paramBoolean);
    AppMethodBeat.o(345755);
  }
  
  private void flb()
  {
    AppMethodBeat.i(345784);
    this.handler.removeMessages(1);
    AppMethodBeat.o(345784);
  }
  
  private void rd(long paramLong)
  {
    AppMethodBeat.i(345764);
    if (this.isAutoPlay)
    {
      this.handler.removeMessages(1);
      Message localMessage = this.handler.obtainMessage(1, Long.valueOf(paramLong));
      this.handler.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(345764);
  }
  
  public final RecyclerView.a<b> getAdapter()
  {
    return this.mlt;
  }
  
  public final int getFocusPosition()
  {
    return this.GGA;
  }
  
  public final i getIndicator()
  {
    return this.GGB;
  }
  
  public final LinearLayoutManager getLayoutManager()
  {
    return this.AJH;
  }
  
  public final MediaBanner.c getPageChangeCallback()
  {
    return this.GGC;
  }
  
  public final long getPlayLoopDurationMs()
  {
    return this.GGz;
  }
  
  public final RecyclerHorizontalViewPager getRecyclerView()
  {
    return this.GGy;
  }
  
  public final float getSmoothScrollerSpeed()
  {
    return this.GGx;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(345963);
    super.onAttachedToWindow();
    if (this.isAutoPlay) {
      a(this);
    }
    AppMethodBeat.o(345963);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(345970);
    super.onDetachedFromWindow();
    flb();
    AppMethodBeat.o(345970);
  }
  
  public final void setAdapter(RecyclerView.a<b> parama)
  {
    AppMethodBeat.i(345898);
    this.mlt = parama;
    this.GGy.setAdapter(this.mlt);
    try
    {
      parama = this.mlt;
      if (parama != null) {
        parama.b((RecyclerView.c)this.GGD);
      }
    }
    finally
    {
      label42:
      break label42;
    }
    parama = this.mlt;
    if (parama != null) {
      parama.a((RecyclerView.c)this.GGD);
    }
    AppMethodBeat.o(345898);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(345908);
    this.isAutoPlay = paramBoolean;
    if (paramBoolean)
    {
      a(this);
      AppMethodBeat.o(345908);
      return;
    }
    flb();
    AppMethodBeat.o(345908);
  }
  
  public final void setFocusPosition(int paramInt)
  {
    this.GGA = paramInt;
  }
  
  public final void setIndicator(i parami)
  {
    this.GGB = parami;
  }
  
  public final void setLayoutManager(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(345870);
    s.u(paramLinearLayoutManager, "value");
    this.AJH = paramLinearLayoutManager;
    this.GGy.setLayoutManager((RecyclerView.LayoutManager)paramLinearLayoutManager);
    AppMethodBeat.o(345870);
  }
  
  public final void setPageChangeCallback(MediaBanner.c paramc)
  {
    this.GGC = paramc;
  }
  
  public final void setPlayLoopDurationMs(long paramLong)
  {
    AppMethodBeat.i(345920);
    this.GGz = paramLong;
    rd(paramLong);
    AppMethodBeat.o(345920);
  }
  
  public final void setSmoothScrollerSpeed(float paramFloat)
  {
    this.GGx = paramFloat;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.c
  {
    b(MediaPlayBanner paramMediaPlayBanner) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(345708);
      super.onChanged();
      Object localObject2 = this.GGE.getAdapter();
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = this.GGE;
        i locali = ((MediaPlayBanner)localObject1).getIndicator();
        if (locali != null) {
          locali.setCount(((RecyclerView.a)localObject2).getItemCount());
        }
        localObject2 = ((MediaPlayBanner)localObject1).getIndicator();
        if (localObject2 != null) {
          break label137;
        }
      }
      label137:
      for (int i = 0;; i = ((i)localObject2).getCount())
      {
        if (i > 0)
        {
          localObject1 = ((MediaPlayBanner)localObject1).getRecyclerView();
          localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerHorizontalViewPager)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(345708);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(345716);
      super.onItemRangeInserted(paramInt1, paramInt2);
      RecyclerView.a locala = this.GGE.getAdapter();
      if (locala != null)
      {
        i locali = this.GGE.getIndicator();
        if (locali != null) {
          locali.setCount(locala.getItemCount());
        }
      }
      AppMethodBeat.o(345716);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(345722);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      RecyclerView.a locala = this.GGE.getAdapter();
      if (locala != null)
      {
        i locali = this.GGE.getIndicator();
        if (locali != null) {
          locali.setCount(locala.getItemCount());
        }
      }
      AppMethodBeat.o(345722);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$recyclerView$1$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements RecyclerHorizontalViewPager.b
  {
    c(MediaPlayBanner paramMediaPlayBanner) {}
    
    public final void aE(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(345719);
      this.GGE.setFocusPosition(paramInt);
      Object localObject = this.GGE.getIndicator();
      if (localObject != null) {
        ((i)localObject).setCurrentIndex(paramInt);
      }
      localObject = this.GGE.getPageChangeCallback();
      if (localObject != null) {
        ((MediaBanner.c)localObject).g(paramInt, paramBoolean, false);
      }
      AppMethodBeat.o(345719);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class layoutManager$1$a
    extends o
  {
    layoutManager$1$a(MediaPlayBanner paramMediaPlayBanner, Context paramContext)
    {
      super();
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(345714);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = this.GGE.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(345714);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.base.MediaPlayBanner
 * JD-Core Version:    0.7.0.1
 */