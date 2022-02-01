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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.base.a.b;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import com.tencent.mm.view.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/base/MediaPlayBanner;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "adapter", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "dataObserver", "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "Lcom/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1;", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "indicator", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/IMediaBannerIndicator;", "setIndicator", "(Lcom/tencent/mm/view/IMediaBannerIndicator;)V", "", "isAutoPlay", "()Z", "setAutoPlay", "(Z)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "", "playLoopDurationMs", "getPlayLoopDurationMs", "()J", "setPlayLoopDurationMs", "(J)V", "recyclerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getRecyclerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "getChildViewAt", "Landroid/view/View;", "position", "onAttachedToWindow", "", "onDetachedFromWindow", "pauseLoopPlay", "pauseDuration", "selectViewAt", "isAuto", "smoothScrollTo", "startLoopPlay", "duration", "stopLoopPlay", "Companion", "IPageChangeCallback", "plugin-finder_release"})
public class MediaPlayBanner
  extends FrameLayout
{
  public static final d Bec;
  private LinearLayoutManager Arh;
  private float BdV;
  final RecyclerHorizontalViewPager BdW;
  private long BdX;
  private int BdY;
  private h BdZ;
  private MediaBanner.c Bea;
  private final e Beb;
  private final MMHandler handler;
  private boolean isAutoPlay;
  private RecyclerView.a<b> jMq;
  
  static
  {
    AppMethodBeat.i(277080);
    Bec = new d((byte)0);
    AppMethodBeat.o(277080);
  }
  
  public MediaPlayBanner(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(277077);
    this.BdV = 60.0F;
    getContext();
    paramContext = new LinearLayoutManager()
    {
      public final int b(RecyclerView.s paramAnonymouss)
      {
        return 1;
      }
      
      public final void smoothScrollToPosition(RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss, int paramAnonymousInt)
      {
        AppMethodBeat.i(270397);
        paramAnonymousRecyclerView = new a(this, this.Bed.getContext());
        paramAnonymousRecyclerView.cV(paramAnonymousInt);
        startSmoothScroll((RecyclerView.r)paramAnonymousRecyclerView);
        AppMethodBeat.o(270397);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
      public static final class a
        extends androidx.recyclerview.widget.p
      {
        a(Context paramContext)
        {
          super();
        }
        
        public final float a(DisplayMetrics paramDisplayMetrics)
        {
          AppMethodBeat.i(291906);
          kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
          float f = this.Bef.Bed.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
          AppMethodBeat.o(291906);
          return f;
        }
      }
    };
    paramContext.setOrientation(0);
    this.Arh = ((LinearLayoutManager)paramContext);
    paramContext = getContext();
    kotlin.g.b.p.j(paramContext, "context");
    paramContext = new RecyclerHorizontalViewPager(paramContext);
    paramContext.setPageChangeListener((RecyclerHorizontalViewPager.b)new a(this));
    paramContext.setLayoutManager((RecyclerView.LayoutManager)this.Arh);
    addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.BdW = paramContext;
    this.BdX = 2500L;
    this.Beb = new e(this);
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new f(this));
    AppMethodBeat.o(277077);
  }
  
  public MediaPlayBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(277078);
    this.BdV = 60.0F;
    getContext();
    paramContext = new LinearLayoutManager()
    {
      public final int b(RecyclerView.s paramAnonymouss)
      {
        return 1;
      }
      
      public final void smoothScrollToPosition(RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss, int paramAnonymousInt)
      {
        AppMethodBeat.i(270397);
        paramAnonymousRecyclerView = new a(this, this.Bed.getContext());
        paramAnonymousRecyclerView.cV(paramAnonymousInt);
        startSmoothScroll((RecyclerView.r)paramAnonymousRecyclerView);
        AppMethodBeat.o(270397);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
      public static final class a
        extends androidx.recyclerview.widget.p
      {
        a(Context paramContext)
        {
          super();
        }
        
        public final float a(DisplayMetrics paramDisplayMetrics)
        {
          AppMethodBeat.i(291906);
          kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
          float f = this.Bef.Bed.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
          AppMethodBeat.o(291906);
          return f;
        }
      }
    };
    paramContext.setOrientation(0);
    this.Arh = ((LinearLayoutManager)paramContext);
    paramContext = getContext();
    kotlin.g.b.p.j(paramContext, "context");
    paramContext = new RecyclerHorizontalViewPager(paramContext);
    paramContext.setPageChangeListener((RecyclerHorizontalViewPager.b)new b(this));
    paramContext.setLayoutManager((RecyclerView.LayoutManager)this.Arh);
    addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.BdW = paramContext;
    this.BdX = 2500L;
    this.Beb = new e(this);
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new f(this));
    AppMethodBeat.o(277078);
  }
  
  public MediaPlayBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(277079);
    this.BdV = 60.0F;
    getContext();
    paramContext = new LinearLayoutManager()
    {
      public final int b(RecyclerView.s paramAnonymouss)
      {
        return 1;
      }
      
      public final void smoothScrollToPosition(RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss, int paramAnonymousInt)
      {
        AppMethodBeat.i(270397);
        paramAnonymousRecyclerView = new a(this, this.Bed.getContext());
        paramAnonymousRecyclerView.cV(paramAnonymousInt);
        startSmoothScroll((RecyclerView.r)paramAnonymousRecyclerView);
        AppMethodBeat.o(270397);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
      public static final class a
        extends androidx.recyclerview.widget.p
      {
        a(Context paramContext)
        {
          super();
        }
        
        public final float a(DisplayMetrics paramDisplayMetrics)
        {
          AppMethodBeat.i(291906);
          kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
          float f = this.Bef.Bed.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
          AppMethodBeat.o(291906);
          return f;
        }
      }
    };
    paramContext.setOrientation(0);
    this.Arh = ((LinearLayoutManager)paramContext);
    paramContext = getContext();
    kotlin.g.b.p.j(paramContext, "context");
    paramContext = new RecyclerHorizontalViewPager(paramContext);
    paramContext.setPageChangeListener((RecyclerHorizontalViewPager.b)new c(this));
    paramContext.setLayoutManager((RecyclerView.LayoutManager)this.Arh);
    addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.BdW = paramContext;
    this.BdX = 2500L;
    this.Beb = new e(this);
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new f(this));
    AppMethodBeat.o(277079);
  }
  
  private void Nz(long paramLong)
  {
    AppMethodBeat.i(277072);
    if (this.isAutoPlay)
    {
      this.handler.removeMessages(1);
      Message localMessage = this.handler.obtainMessage(1, Long.valueOf(paramLong));
      this.handler.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(277072);
  }
  
  private void eiY()
  {
    AppMethodBeat.i(277074);
    this.handler.removeMessages(1);
    AppMethodBeat.o(277074);
  }
  
  public final void ay(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(277070);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.BdW;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aFh(), "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    this.BdW.g(paramInt, true, paramBoolean);
    AppMethodBeat.o(277070);
  }
  
  public final RecyclerView.a<b> getAdapter()
  {
    return this.jMq;
  }
  
  public final int getFocusPosition()
  {
    return this.BdY;
  }
  
  public final h getIndicator()
  {
    return this.BdZ;
  }
  
  public final LinearLayoutManager getLayoutManager()
  {
    return this.Arh;
  }
  
  public final MediaBanner.c getPageChangeCallback()
  {
    return this.Bea;
  }
  
  public final long getPlayLoopDurationMs()
  {
    return this.BdX;
  }
  
  public final RecyclerHorizontalViewPager getRecyclerView()
  {
    return this.BdW;
  }
  
  public final float getSmoothScrollerSpeed()
  {
    return this.BdV;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(277075);
    super.onAttachedToWindow();
    if (this.isAutoPlay) {
      a(this);
    }
    AppMethodBeat.o(277075);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(277076);
    super.onDetachedFromWindow();
    eiY();
    AppMethodBeat.o(277076);
  }
  
  public final void setAdapter(RecyclerView.a<b> parama)
  {
    AppMethodBeat.i(277067);
    this.jMq = parama;
    this.BdW.setAdapter(this.jMq);
    try
    {
      parama = this.jMq;
      if (parama != null) {
        parama.b((RecyclerView.c)this.Beb);
      }
    }
    catch (Throwable parama)
    {
      label42:
      break label42;
    }
    parama = this.jMq;
    if (parama != null)
    {
      parama.a((RecyclerView.c)this.Beb);
      AppMethodBeat.o(277067);
      return;
    }
    AppMethodBeat.o(277067);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(277068);
    this.isAutoPlay = paramBoolean;
    if (paramBoolean)
    {
      a(this);
      AppMethodBeat.o(277068);
      return;
    }
    eiY();
    AppMethodBeat.o(277068);
  }
  
  public final void setFocusPosition(int paramInt)
  {
    this.BdY = paramInt;
  }
  
  public final void setIndicator(h paramh)
  {
    this.BdZ = paramh;
  }
  
  public final void setLayoutManager(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(277066);
    kotlin.g.b.p.k(paramLinearLayoutManager, "value");
    this.Arh = paramLinearLayoutManager;
    this.BdW.setLayoutManager((RecyclerView.LayoutManager)paramLinearLayoutManager);
    AppMethodBeat.o(277066);
  }
  
  public final void setPageChangeCallback(MediaBanner.c paramc)
  {
    this.Bea = paramc;
  }
  
  public final void setPlayLoopDurationMs(long paramLong)
  {
    AppMethodBeat.i(277069);
    this.BdX = paramLong;
    Nz(paramLong);
    AppMethodBeat.o(277069);
  }
  
  public final void setSmoothScrollerSpeed(float paramFloat)
  {
    this.BdV = paramFloat;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$recyclerView$1$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class a
    implements RecyclerHorizontalViewPager.b
  {
    a(MediaPlayBanner paramMediaPlayBanner) {}
    
    public final void al(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(263227);
      this.Bed.setFocusPosition(paramInt);
      Object localObject = this.Bed.getIndicator();
      if (localObject != null) {
        ((h)localObject).setCurrentIndex(paramInt);
      }
      localObject = this.Bed.getPageChangeCallback();
      if (localObject != null)
      {
        ((MediaBanner.c)localObject).g(paramInt, paramBoolean, false);
        AppMethodBeat.o(263227);
        return;
      }
      AppMethodBeat.o(263227);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$recyclerView$1$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class b
    implements RecyclerHorizontalViewPager.b
  {
    b(MediaPlayBanner paramMediaPlayBanner) {}
    
    public final void al(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(224458);
      this.Bed.setFocusPosition(paramInt);
      Object localObject = this.Bed.getIndicator();
      if (localObject != null) {
        ((h)localObject).setCurrentIndex(paramInt);
      }
      localObject = this.Bed.getPageChangeCallback();
      if (localObject != null)
      {
        ((MediaBanner.c)localObject).g(paramInt, paramBoolean, false);
        AppMethodBeat.o(224458);
        return;
      }
      AppMethodBeat.o(224458);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$recyclerView$1$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class c
    implements RecyclerHorizontalViewPager.b
  {
    c(MediaPlayBanner paramMediaPlayBanner) {}
    
    public final void al(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(264762);
      this.Bed.setFocusPosition(paramInt);
      Object localObject = this.Bed.getIndicator();
      if (localObject != null) {
        ((h)localObject).setCurrentIndex(paramInt);
      }
      localObject = this.Bed.getPageChangeCallback();
      if (localObject != null)
      {
        ((MediaBanner.c)localObject).g(paramInt, paramBoolean, false);
        AppMethodBeat.o(264762);
        return;
      }
      AppMethodBeat.o(264762);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/base/MediaPlayBanner$Companion;", "", "()V", "DEFAULT_LOOP_INTERVAL", "", "DEFAULT_LOOP_PAUSE_INTERVAL", "SCROLL_TO_NEXT_WHAT", "", "TAG", "", "plugin-finder_release"})
  public static final class d {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(286910);
      super.onChanged();
      Object localObject1 = this.Bed.getAdapter();
      if (localObject1 != null)
      {
        Object localObject2 = this.Bed.getIndicator();
        if (localObject2 != null) {
          ((h)localObject2).setCount(((RecyclerView.a)localObject1).getItemCount());
        }
        localObject1 = this.Bed.getIndicator();
        if (localObject1 != null) {}
        for (int i = ((h)localObject1).getCount();; i = 0)
        {
          if (i > 0)
          {
            localObject1 = this.Bed.getRecyclerView();
            localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerHorizontalViewPager)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(286910);
          return;
        }
      }
      AppMethodBeat.o(286910);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286911);
      super.onItemRangeInserted(paramInt1, paramInt2);
      RecyclerView.a locala = this.Bed.getAdapter();
      if (locala != null)
      {
        h localh = this.Bed.getIndicator();
        if (localh != null)
        {
          localh.setCount(locala.getItemCount());
          AppMethodBeat.o(286911);
          return;
        }
        AppMethodBeat.o(286911);
        return;
      }
      AppMethodBeat.o(286911);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286912);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      RecyclerView.a locala = this.Bed.getAdapter();
      if (locala != null)
      {
        h localh = this.Bed.getIndicator();
        if (localh != null)
        {
          localh.setCount(locala.getItemCount());
          AppMethodBeat.o(286912);
          return;
        }
        AppMethodBeat.o(286912);
        return;
      }
      AppMethodBeat.o(286912);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class f
    implements MMHandler.Callback
  {
    f(MediaPlayBanner paramMediaPlayBanner) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      int j = 0;
      AppMethodBeat.i(291535);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(291535);
        return true;
        Object localObject = this.Bed.getAdapter();
        label55:
        int k;
        if (localObject != null)
        {
          i = ((RecyclerView.a)localObject).getItemCount();
          if (i <= 1) {
            break label120;
          }
          k = this.Bed.getFocusPosition() + 1;
          localObject = this.Bed.getAdapter();
          if (localObject == null) {
            break label122;
          }
        }
        label120:
        label122:
        for (int i = ((RecyclerView.a)localObject).getItemCount();; i = 0)
        {
          if (k >= i) {
            break label127;
          }
          this.Bed.ay(k, true);
          MediaPlayBanner.a(this.Bed);
          break;
          i = 0;
          break label55;
          break;
        }
        label127:
        localObject = this.Bed.getAdapter();
        i = j;
        if (localObject != null) {
          i = ((RecyclerView.a)localObject).getItemCount();
        }
        if (k != i) {
          continue;
        }
        final RecyclerView.a locala = this.Bed.getAdapter();
        if (!(locala instanceof com.tencent.mm.ui.base.a.a)) {
          continue;
        }
        try
        {
          locala.b((RecyclerView.c)MediaPlayBanner.b(this.Bed));
          label187:
          ((com.tencent.mm.ui.base.a.a)locala).auA(((com.tencent.mm.ui.base.a.a)locala).getItemCount());
          this.Bed.getRecyclerView().setItemAnimator(null);
          MediaPlayBanner.a(this.Bed, k);
          localObject = paramMessage.obj;
          paramMessage = (Message)localObject;
          if (!(localObject instanceof Long)) {
            paramMessage = null;
          }
          paramMessage = (Long)paramMessage;
          if (paramMessage != null) {}
          for (long l = paramMessage.longValue();; l = 2500L)
          {
            this.Bed.postDelayed((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(272757);
                ((com.tencent.mm.ui.base.a.a)locala).removeItem(((com.tencent.mm.ui.base.a.a)locala).getItemCount() - 1);
                locala.a((RecyclerView.c)MediaPlayBanner.b(this.Bee.Bed));
                MediaPlayBanner localMediaPlayBanner = this.Bee.Bed;
                RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = localMediaPlayBanner.BdW;
                com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aFh(), "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
                localRecyclerHorizontalViewPager.scrollToPosition(((Integer)locala.sf(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/plugin/finder/view/base/MediaPlayBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
                localMediaPlayBanner.BdW.g(0, true, true);
                MediaPlayBanner.a(this.Bee.Bed);
                AppMethodBeat.o(272757);
              }
            }, l / 5L);
            break;
          }
        }
        catch (Exception localException)
        {
          break label187;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/base/MediaPlayBanner$layoutManager$1$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
  public static final class layoutManager$1$a
    extends androidx.recyclerview.widget.p
  {
    layoutManager$1$a(Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(291906);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = this.Bef.Bed.getSmoothScrollerSpeed() / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(291906);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.base.MediaPlayBanner
 * JD-Core Version:    0.7.0.1
 */