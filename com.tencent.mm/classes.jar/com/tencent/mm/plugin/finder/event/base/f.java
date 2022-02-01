package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
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
import kotlin.g.b.k;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "PostDelayTime", "", "getPostDelayTime", "()J", "TAG", "", "adapterDataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "config", "Landroid/view/ViewConfiguration;", "currentStats", "", "getCurrentStats", "()I", "setCurrentStats", "(I)V", "dataChangeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getDataChangeHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "isOpenTPPlayerScroll", "", "()Z", "last5Index", "getLast5Index", "setLast5Index", "last5Offset", "", "getLast5Offset", "()[I", "setLast5Offset", "([I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sessionScrollOffset", "getSessionScrollOffset", "setSessionScrollOffset", "sumOffset", "getSumOffset", "setSumOffset", "visible", "visibleRunnable", "Ljava/lang/Runnable;", "getVisibleRunnable", "()Ljava/lang/Runnable;", "calculateVariance", "", "array", "average", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "newState", "getBehavior", "handleEvent", "handleOnScrollStateChanged", "", "handleOnScrolled", "dx", "dy", "onBindRecyclerView", "onInvisible", "onVisible", "publish", "plugin-finder-base_release"})
public abstract class f
  extends e<RecyclerView.l>
{
  final String TAG = "Finder.FinderFeedFlowEventSubscriber";
  RecyclerView jLl;
  public int sCr;
  private int sCs;
  private boolean visible;
  private final ViewConfiguration xqN;
  protected Rect xqO;
  final int xqP;
  final boolean xqQ;
  int xqR;
  int xqS;
  int xqT;
  int xqU;
  int[] xqV;
  final long xqW;
  public final RecyclerView.c xqX;
  private final Runnable xqY;
  final MMHandler xqZ;
  
  public f(c paramc)
  {
    super(paramc);
    paramc = ViewConfiguration.get(MMApplicationContext.getContext());
    p.j(paramc, "ViewConfiguration.get(MM…tionContext.getContext())");
    this.xqN = paramc;
    this.xqO = new Rect();
    this.sCr = 2147483647;
    this.sCs = 2147483647;
    this.xqP = this.xqN.getScaledTouchSlop();
    paramc = h.ag(com.tencent.mm.plugin.thumbplayer.a.a.class);
    p.j(paramc, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.xqQ = ((com.tencent.mm.plugin.thumbplayer.a.a)paramc).isOpenTPPlayerScroll();
    this.xqV = new int[5];
    this.xqW = 500L;
    this.xqX = ((RecyclerView.c)new a(this));
    this.xqY = ((Runnable)new f(this));
    this.xqZ = ((MMHandler)new b(this, Looper.getMainLooper()));
  }
  
  public final void Mg(int paramInt)
  {
    this.sCs = paramInt;
  }
  
  public b Mh(int paramInt)
  {
    return new b();
  }
  
  public final int dqm()
  {
    return this.sCs;
  }
  
  public final RecyclerView.l dqn()
  {
    return (RecyclerView.l)new c(this);
  }
  
  public final void e(RecyclerView paramRecyclerView, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    String str = this.TAG;
    Object localObject = Looper.getMainLooper();
    p.j(localObject, "Looper.getMainLooper()");
    if (p.h(((Looper)localObject).getThread(), Thread.currentThread()))
    {
      long l = SystemClock.uptimeMillis();
      localObject = f(paramRecyclerView, paramInt);
      l = SystemClock.uptimeMillis() - l;
      if (l >= 50L) {
        Log.w(str, "[checkUICost] ".concat(String.valueOf("what are you doing? guy! This operation is so slow in ui thread.[" + l + "ms]")));
      }
    }
    for (;;)
    {
      paramRecyclerView.post((Runnable)new e(this, (b)localObject));
      return;
      localObject = f(paramRecyclerView, paramInt);
    }
  }
  
  public b f(RecyclerView paramRecyclerView, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    return Mh(paramInt);
  }
  
  public final void k(final RecyclerView paramRecyclerView)
  {
    p.k(paramRecyclerView, "recyclerView");
    this.jLl = paramRecyclerView;
    paramRecyclerView.a(dqn());
    paramRecyclerView.a((RecyclerView.i)new d(this, paramRecyclerView));
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof WxRecyclerAdapter))) {
      paramRecyclerView.a(this.xqX);
    }
  }
  
  public void onInvisible()
  {
    this.visible = false;
    MMHandlerThread.removeRunnable(this.xqY);
    this.xqZ.removeMessages(0);
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView != null) {
      e(localRecyclerView, 10);
    }
    Log.i(this.TAG, "onInvisible " + this.sCr + ' ' + this.sCs);
  }
  
  public final void onVisible()
  {
    Log.i(this.TAG, "onVisible " + this.sCr + ' ' + this.sCs);
    this.visible = true;
    this.sCr = 2147483647;
    this.sCs = 2147483647;
    MMHandlerThread.postToMainThreadDelayed(this.xqY, 200L);
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView != null) {
      e(localRecyclerView, 7);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$adapterDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder-base_release"})
  public static final class a
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(258081);
      Log.d(this.xra.TAG, "onChanged");
      this.xra.xqZ.removeMessages(0);
      this.xra.xqZ.sendEmptyMessageDelayed(0, this.xra.xqW);
      AppMethodBeat.o(258081);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(258077);
      Log.d(this.xra.TAG, "onItemRangeChanged " + paramInt1 + ' ' + paramInt2);
      this.xra.xqZ.removeMessages(0);
      this.xra.xqZ.sendEmptyMessageDelayed(1, this.xra.xqW);
      AppMethodBeat.o(258077);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(258078);
      Log.d(this.xra.TAG, "onItemRangeInserted " + paramInt1 + ' ' + paramInt2);
      this.xra.xqZ.removeMessages(0);
      this.xra.xqZ.sendEmptyMessageDelayed(0, this.xra.xqW);
      AppMethodBeat.o(258078);
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(258079);
      Log.d(this.xra.TAG, "onItemRangeMoved " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3);
      this.xra.xqZ.removeMessages(0);
      this.xra.xqZ.sendEmptyMessageDelayed(0, this.xra.xqW);
      AppMethodBeat.o(258079);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(258080);
      Log.d(this.xra.TAG, "onItemRangeRemoved " + paramInt1 + ' ' + paramInt2);
      this.xra.xqZ.removeMessages(0);
      this.xra.xqZ.sendEmptyMessageDelayed(0, this.xra.xqW);
      AppMethodBeat.o(258080);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$dataChangeHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder-base_release"})
  public static final class b
    extends MMHandler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(262247);
      if (paramMessage != null)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          AppMethodBeat.o(262247);
          return;
          paramMessage = this.xra.jLl;
          if (paramMessage != null)
          {
            this.xra.e(paramMessage, 5);
            AppMethodBeat.o(262247);
            return;
          }
          AppMethodBeat.o(262247);
          return;
          paramMessage = this.xra.jLl;
        } while (paramMessage == null);
        this.xra.e(paramMessage, 9);
        AppMethodBeat.o(262247);
        return;
      }
      AppMethodBeat.o(262247);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder-base_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(259709);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      localObject = this.xra;
      if (((f)localObject).xqO.isEmpty()) {
        paramRecyclerView.getGlobalVisibleRect(((f)localObject).xqO);
      }
      if (((f)localObject).xqR != paramInt)
      {
        ((f)localObject).xqS = ((f)localObject).xqR;
        ((f)localObject).xqR = paramInt;
      }
      ((f)localObject).e(paramRecyclerView, paramInt);
      if (((f)localObject).xqR == 0)
      {
        ((f)localObject).xqV = new int[5];
        ((f)localObject).xqU = 0;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(259709);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(259712);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject1 = this.xra;
      Object localObject2;
      if (((f)localObject1).xqQ)
      {
        localObject2 = paramRecyclerView.getLayoutManager();
        if (localObject2 != null)
        {
          if (!((RecyclerView.LayoutManager)localObject2).canScrollHorizontally()) {
            break label198;
          }
          paramInt1 = Math.abs(paramInt1);
          ((f)localObject1).xqT += paramInt1;
          ((f)localObject1).xqV[localObject1.xqU] = paramInt1;
          ((f)localObject1).xqU = ((((f)localObject1).xqU + 1) % ((f)localObject1).xqV.length);
          if (((f)localObject1).xqR != 1) {
            break label203;
          }
          if (((f)localObject1).xqT > ((f)localObject1).xqP * 5)
          {
            ((f)localObject1).e(paramRecyclerView, 3);
            ((f)localObject1).xqT = 0;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(259712);
        return;
        label198:
        paramInt1 = paramInt2;
        break;
        label203:
        if (((f)localObject1).xqR == 2)
        {
          localObject2 = ((f)localObject1).xqV;
          p.k(localObject2, "$this$average");
          double d1 = 0.0D;
          paramInt2 = 0;
          int i = localObject2.length;
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            d1 += localObject2[paramInt1];
            paramInt2 += 1;
            paramInt1 += 1;
          }
          if (paramInt2 == 0) {
            localObject2 = k.aaBn;
          }
          double d2;
          for (d1 = k.iCj();; d1 /= paramInt2)
          {
            localObject2 = ((f)localObject1).xqV;
            d2 = 0.0D;
            paramInt2 = localObject2.length;
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              d2 += Math.pow(localObject2[paramInt1] - d1, 2.0D);
              paramInt1 += 1;
            }
          }
          d2 /= localObject2.length;
          if ((d1 < 50.0D) && (d2 < 50.0D) && (((f)localObject1).xqT > ((f)localObject1).xqP * 5))
          {
            Log.i(((f)localObject1).TAG, "publish LOW_SPEED_FLING");
            ((f)localObject1).e(paramRecyclerView, 8);
            ((f)localObject1).xqT = 0;
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder-base_release"})
  public static final class d
    implements RecyclerView.i
  {
    private boolean isFirst = true;
    
    d(RecyclerView paramRecyclerView) {}
    
    public final void aT(View paramView)
    {
      AppMethodBeat.i(263116);
      p.k(paramView, "view");
      if (this.isFirst)
      {
        this.isFirst = false;
        paramRecyclerView.post((Runnable)new a(this));
      }
      AppMethodBeat.o(263116);
    }
    
    public final void aU(View paramView)
    {
      AppMethodBeat.i(263114);
      p.k(paramView, "view");
      AppMethodBeat.o(263114);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(259147);
        this.xrb.xra.dqn().onScrollStateChanged(this.xrb.xmk, 4);
        AppMethodBeat.o(259147);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(f paramf, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(259923);
      this.xra.c(this.xrc);
      AppMethodBeat.o(259923);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(259106);
      RecyclerView localRecyclerView = this.xra.jLl;
      if (localRecyclerView != null)
      {
        this.xra.e(localRecyclerView, 5);
        AppMethodBeat.o(259106);
        return;
      }
      AppMethodBeat.o(259106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f
 * JD-Core Version:    0.7.0.1
 */