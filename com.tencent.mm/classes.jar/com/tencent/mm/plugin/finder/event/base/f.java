package com.tencent.mm.plugin.finder.event.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "PostDelayTime", "", "getPostDelayTime", "()J", "TAG", "", "adapterDataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "config", "Landroid/view/ViewConfiguration;", "currentStats", "", "getCurrentStats", "()I", "setCurrentStats", "(I)V", "dataChangeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getDataChangeHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "draggingDistance", "getDraggingDistance", "setDraggingDistance", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "heightPixels", "isOpenTPPlayerScroll", "", "()Z", "last5Index", "getLast5Index", "setLast5Index", "last5Offset", "", "getLast5Offset", "()[I", "setLast5Offset", "([I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sessionScrollOffset", "getSessionScrollOffset", "setSessionScrollOffset", "sumOffset", "getSumOffset", "setSumOffset", "visible", "visibleRunnable", "Ljava/lang/Runnable;", "getVisibleRunnable", "()Ljava/lang/Runnable;", "calculateVariance", "", "array", "average", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "newState", "getBehavior", "handleEvent", "handleOnScrollStateChanged", "", "handleOnScrolled", "dx", "dy", "onBindRecyclerView", "onInvisible", "onVisible", "publish", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
  extends e<RecyclerView.l>
{
  private final ViewConfiguration ANX;
  private final int ANY;
  private Rect ANZ;
  private final boolean AOa;
  private int AOb;
  private int AOc;
  private int AOd;
  private int AOe;
  private int[] AOf;
  private int AOg;
  final long AOh;
  public final RecyclerView.c AOi;
  private final Runnable AOj;
  final MMHandler AOk;
  final String TAG = "Finder.FinderFeedFlowEventSubscriber";
  RecyclerView mkw;
  private final int rfr;
  public int vIj;
  private int vIk;
  private boolean visible;
  
  public f(c paramc)
  {
    super(paramc);
    paramc = ViewConfiguration.get(MMApplicationContext.getContext());
    s.s(paramc, "get(MMApplicationContext.getContext())");
    this.ANX = paramc;
    this.ANY = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
    this.ANZ = new Rect();
    this.vIj = 2147483647;
    this.vIk = 2147483647;
    this.rfr = this.ANX.getScaledTouchSlop();
    this.AOa = ((com.tencent.mm.plugin.thumbplayer.a.a)h.az(com.tencent.mm.plugin.thumbplayer.a.a.class)).isOpenTPPlayerScroll();
    this.AOf = new int[5];
    this.AOh = 500L;
    this.AOi = ((RecyclerView.c)new a(this));
    this.AOj = new f..ExternalSyntheticLambda0(this);
    this.AOk = ((MMHandler)new b(this, Looper.getMainLooper()));
  }
  
  private static double a(int[] paramArrayOfInt, double paramDouble)
  {
    double d = 0.0D;
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      d += Math.pow(paramArrayOfInt[i] - paramDouble, 2.0D);
      i += 1;
    }
    return d / paramArrayOfInt.length;
  }
  
  private static final void a(f paramf)
  {
    s.u(paramf, "this$0");
    RecyclerView localRecyclerView = paramf.mkw;
    if (localRecyclerView != null)
    {
      paramf.g(localRecyclerView, 7);
      paramf.g(localRecyclerView, 5);
    }
  }
  
  private static final void a(f paramf, b paramb)
  {
    s.u(paramf, "this$0");
    s.u(paramb, "$event");
    paramf.c(paramb);
  }
  
  public final void Nl(int paramInt)
  {
    this.vIk = paramInt;
  }
  
  public b Nm(int paramInt)
  {
    return new b();
  }
  
  public final int dYI()
  {
    return this.vIk;
  }
  
  public final RecyclerView.l dYJ()
  {
    return (RecyclerView.l)new c(this);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt)
  {
    s.u(paramRecyclerView, "recyclerView");
    String str = this.TAG;
    b localb2;
    if (s.p(Looper.getMainLooper().getThread(), Thread.currentThread()))
    {
      long l = SystemClock.uptimeMillis();
      localb2 = h(paramRecyclerView, paramInt);
      l = SystemClock.uptimeMillis() - l;
      localb1 = localb2;
      if (l >= 50L) {
        Log.w(str, s.X("[checkUICost] ", "what are you doing? guy! This operation is so slow in ui thread.[" + l + "ms]"));
      }
    }
    for (b localb1 = localb2;; localb1 = h(paramRecyclerView, paramInt))
    {
      paramRecyclerView.post(new f..ExternalSyntheticLambda1(this, localb1));
      return;
    }
  }
  
  public final Rect getGlobalVisibleRect()
  {
    return this.ANZ;
  }
  
  public b h(RecyclerView paramRecyclerView, int paramInt)
  {
    s.u(paramRecyclerView, "recyclerView");
    return Nm(paramInt);
  }
  
  public final void o(RecyclerView paramRecyclerView)
  {
    s.u(paramRecyclerView, "recyclerView");
    this.mkw = paramRecyclerView;
    paramRecyclerView.a(dYJ());
    paramRecyclerView.a((RecyclerView.i)new d(paramRecyclerView, this));
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof WxRecyclerAdapter))) {
      paramRecyclerView.a(this.AOi);
    }
  }
  
  public void onInvisible()
  {
    this.visible = false;
    MMHandlerThread.removeRunnable(this.AOj);
    this.AOk.removeMessages(0);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      g(localRecyclerView, 10);
    }
    Log.i(this.TAG, "onInvisible " + this.vIj + ' ' + this.vIk);
  }
  
  public final void onVisible()
  {
    Log.i(this.TAG, "onVisible " + this.vIj + ' ' + this.vIk);
    this.visible = true;
    this.vIj = 2147483647;
    this.vIk = 2147483647;
    MMHandlerThread.postToMainThreadDelayed(this.AOj, 200L);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      g(localRecyclerView, 7);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$adapterDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.c
  {
    a(f paramf) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(330391);
      Log.d(this.AOl.TAG, "onChanged");
      this.AOl.AOk.removeMessages(0);
      this.AOl.AOk.sendEmptyMessageDelayed(0, this.AOl.AOh);
      AppMethodBeat.o(330391);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(330360);
      Log.d(this.AOl.TAG, "onItemRangeChanged " + paramInt1 + ' ' + paramInt2);
      this.AOl.AOk.removeMessages(0);
      this.AOl.AOk.sendEmptyMessageDelayed(1, this.AOl.AOh);
      AppMethodBeat.o(330360);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(330366);
      Log.d(this.AOl.TAG, "onItemRangeInserted " + paramInt1 + ' ' + paramInt2);
      this.AOl.AOk.removeMessages(0);
      this.AOl.AOk.sendEmptyMessageDelayed(0, this.AOl.AOh);
      AppMethodBeat.o(330366);
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(330374);
      Log.d(this.AOl.TAG, "onItemRangeMoved " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3);
      this.AOl.AOk.removeMessages(0);
      this.AOl.AOk.sendEmptyMessageDelayed(0, this.AOl.AOh);
      AppMethodBeat.o(330374);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(330382);
      Log.d(this.AOl.TAG, "onItemRangeRemoved " + paramInt1 + ' ' + paramInt2);
      this.AOl.AOk.removeMessages(0);
      this.AOl.AOk.sendEmptyMessageDelayed(0, this.AOl.AOh);
      AppMethodBeat.o(330382);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$dataChangeHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(f paramf, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(330352);
      f localf;
      if (paramMessage != null)
      {
        localf = this.AOl;
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(330352);
        return;
        paramMessage = localf.mkw;
        if (paramMessage != null)
        {
          localf.g(paramMessage, 5);
          AppMethodBeat.o(330352);
          return;
          paramMessage = localf.mkw;
          if (paramMessage != null) {
            localf.g(paramMessage, 9);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(f paramf) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(330344);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      f.a(this.AOl, paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(330344);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(330349);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      f.a(this.AOl, paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(330349);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements RecyclerView.i
  {
    private boolean isFirst = true;
    
    d(RecyclerView paramRecyclerView, f paramf) {}
    
    private static final void a(f paramf, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(330353);
      s.u(paramf, "this$0");
      s.u(paramRecyclerView, "$recyclerView");
      paramf.dYJ().onScrollStateChanged(paramRecyclerView, 4);
      AppMethodBeat.o(330353);
    }
    
    public final void bm(View paramView)
    {
      AppMethodBeat.i(330372);
      s.u(paramView, "view");
      if (this.isFirst)
      {
        this.isFirst = false;
        this.AJl.post(new f.d..ExternalSyntheticLambda0(jdField_this, this.AJl));
      }
      AppMethodBeat.o(330372);
    }
    
    public final void bn(View paramView)
    {
      AppMethodBeat.i(330363);
      s.u(paramView, "view");
      AppMethodBeat.o(330363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f
 * JD-Core Version:    0.7.0.1
 */