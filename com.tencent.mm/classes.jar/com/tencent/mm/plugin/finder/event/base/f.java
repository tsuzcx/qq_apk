package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "PostDelayTime", "", "getPostDelayTime", "()J", "TAG", "", "adapterDataObserver", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "config", "Landroid/view/ViewConfiguration;", "currentStats", "", "getCurrentStats", "()I", "setCurrentStats", "(I)V", "dataChangeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getDataChangeHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "isOpenTPPlayerScroll", "", "()Z", "last5Index", "getLast5Index", "setLast5Index", "last5Offset", "", "getLast5Offset", "()[I", "setLast5Offset", "([I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sessionScrollOffset", "getSessionScrollOffset", "setSessionScrollOffset", "sumOffset", "getSumOffset", "setSumOffset", "visible", "visibleRunnable", "Ljava/lang/Runnable;", "getVisibleRunnable", "()Ljava/lang/Runnable;", "calculateVariance", "", "array", "average", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "newState", "getBehavior", "handleEvent", "onBindRecyclerView", "", "onInvisible", "onVisible", "publish", "plugin-finder_release"})
public abstract class f
  extends e<RecyclerView.l>
{
  final String TAG = "Finder.FinderFeedFlowEventSubscriber";
  RecyclerView hak;
  public int ptb;
  protected int ptc;
  private final ViewConfiguration tIe;
  protected Rect tIf;
  final int tIg;
  final boolean tIh;
  int tIi;
  int tIj;
  int tIk;
  int tIl;
  int[] tIm;
  final long tIn;
  public final RecyclerView.c tIo;
  private final Runnable tIp;
  final MMHandler tIq;
  private boolean visible;
  
  public f(c paramc)
  {
    super(paramc);
    paramc = ViewConfiguration.get(MMApplicationContext.getContext());
    p.g(paramc, "ViewConfiguration.get(MM…tionContext.getContext())");
    this.tIe = paramc;
    this.tIf = new Rect();
    this.ptb = 2147483647;
    this.ptc = 2147483647;
    this.tIg = this.tIe.getScaledTouchSlop();
    paramc = g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
    p.g(paramc, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.tIh = ((com.tencent.mm.plugin.thumbplayer.a.a)paramc).isOpenTPPlayerScroll();
    this.tIm = new int[5];
    this.tIn = 500L;
    this.tIo = ((RecyclerView.c)new a(this));
    this.tIp = ((Runnable)new f(this));
    this.tIq = ((MMHandler)new b(this, Looper.getMainLooper()));
  }
  
  public b It(int paramInt)
  {
    return new b();
  }
  
  public final RecyclerView.l dap()
  {
    return (RecyclerView.l)new c(this);
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    String str = this.TAG;
    Object localObject = Looper.getMainLooper();
    p.g(localObject, "Looper.getMainLooper()");
    if (p.j(((Looper)localObject).getThread(), Thread.currentThread()))
    {
      long l = SystemClock.uptimeMillis();
      localObject = g(paramRecyclerView, paramInt);
      l = SystemClock.uptimeMillis() - l;
      if (l >= 50L) {
        Log.w(str, "[checkUICost] ".concat(String.valueOf("what are you doing? guy! This operation is so slow in ui thread.[" + l + "ms]")));
      }
    }
    for (;;)
    {
      paramRecyclerView.post((Runnable)new e(this, (b)localObject));
      return;
      localObject = g(paramRecyclerView, paramInt);
    }
  }
  
  public b g(RecyclerView paramRecyclerView, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    return It(paramInt);
  }
  
  public final void m(final RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    this.hak = paramRecyclerView;
    paramRecyclerView.a(dap());
    paramRecyclerView.a((RecyclerView.i)new d(this, paramRecyclerView));
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof WxRecyclerAdapter))) {
      paramRecyclerView.a(this.tIo);
    }
  }
  
  public void onInvisible()
  {
    this.visible = false;
    MMHandlerThread.removeRunnable(this.tIp);
    this.tIq.removeMessages(0);
    RecyclerView localRecyclerView = this.hak;
    if (localRecyclerView != null) {
      f(localRecyclerView, 10);
    }
    Log.i(this.TAG, "onInvisible " + this.ptb + ' ' + this.ptc);
  }
  
  public final void onVisible()
  {
    Log.i(this.TAG, "onVisible " + this.ptb + ' ' + this.ptc);
    this.visible = true;
    this.ptb = 2147483647;
    this.ptc = 2147483647;
    MMHandlerThread.postToMainThreadDelayed(this.tIp, 200L);
    RecyclerView localRecyclerView = this.hak;
    if (localRecyclerView != null) {
      f(localRecyclerView, 7);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$adapterDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(243454);
      Log.d(this.tIr.TAG, "onChanged");
      this.tIr.tIq.removeMessages(0);
      this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
      AppMethodBeat.o(243454);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243450);
      Log.d(this.tIr.TAG, "onItemRangeChanged " + paramInt1 + ' ' + paramInt2);
      this.tIr.tIq.removeMessages(0);
      this.tIr.tIq.sendEmptyMessageDelayed(1, this.tIr.tIn);
      AppMethodBeat.o(243450);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243451);
      Log.d(this.tIr.TAG, "onItemRangeInserted " + paramInt1 + ' ' + paramInt2);
      this.tIr.tIq.removeMessages(0);
      this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
      AppMethodBeat.o(243451);
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(243452);
      Log.d(this.tIr.TAG, "onItemRangeMoved " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3);
      this.tIr.tIq.removeMessages(0);
      this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
      AppMethodBeat.o(243452);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243453);
      Log.d(this.tIr.TAG, "onItemRangeRemoved " + paramInt1 + ' ' + paramInt2);
      this.tIr.tIq.removeMessages(0);
      this.tIr.tIq.sendEmptyMessageDelayed(0, this.tIr.tIn);
      AppMethodBeat.o(243453);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$dataChangeHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class b
    extends MMHandler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(243455);
      if (paramMessage != null)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          AppMethodBeat.o(243455);
          return;
          paramMessage = this.tIr.hak;
          if (paramMessage != null)
          {
            this.tIr.f(paramMessage, 5);
            AppMethodBeat.o(243455);
            return;
          }
          AppMethodBeat.o(243455);
          return;
          paramMessage = this.tIr.hak;
        } while (paramMessage == null);
        this.tIr.f(paramMessage, 9);
        AppMethodBeat.o(243455);
        return;
      }
      AppMethodBeat.o(243455);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243456);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (this.tIr.tIf.isEmpty()) {
        paramRecyclerView.getGlobalVisibleRect(this.tIr.tIf);
      }
      if (this.tIr.tIi != paramInt)
      {
        this.tIr.tIj = this.tIr.tIi;
        this.tIr.tIi = paramInt;
      }
      this.tIr.f(paramRecyclerView, paramInt);
      if (this.tIr.tIi == 0)
      {
        paramRecyclerView = this.tIr;
        localObject = new int[5];
        p.h(localObject, "<set-?>");
        paramRecyclerView.tIm = ((int[])localObject);
        this.tIr.tIl = 0;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(243456);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243457);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (this.tIr.tIh)
      {
        localObject = paramRecyclerView.getLayoutManager();
        if (localObject != null)
        {
          if (!((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
            break label220;
          }
          paramInt1 = Math.abs(paramInt1);
          localObject = this.tIr;
          ((f)localObject).tIk += paramInt1;
          this.tIr.tIm[this.tIr.tIl] = paramInt1;
          this.tIr.tIl = ((this.tIr.tIl + 1) % this.tIr.tIm.length);
          if (this.tIr.tIi != 1) {
            break label225;
          }
          if (this.tIr.tIk > this.tIr.tIg * 5)
          {
            this.tIr.f(paramRecyclerView, 3);
            this.tIr.tIk = 0;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(243457);
        return;
        label220:
        paramInt1 = paramInt2;
        break;
        label225:
        if (this.tIr.tIi == 2)
        {
          localObject = this.tIr.tIm;
          p.h(localObject, "$this$average");
          double d1 = 0.0D;
          paramInt2 = 0;
          int i = localObject.length;
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            d1 += localObject[paramInt1];
            paramInt2 += 1;
            paramInt1 += 1;
          }
          if (paramInt2 == 0) {
            localObject = k.SYw;
          }
          double d2;
          for (d1 = k.hxY();; d1 /= paramInt2)
          {
            localObject = this.tIr.tIm;
            d2 = 0.0D;
            paramInt2 = localObject.length;
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              d2 += Math.pow(localObject[paramInt1] - d1, 2.0D);
              paramInt1 += 1;
            }
          }
          d2 /= localObject.length;
          if ((d1 < 50.0D) && (d2 < 50.0D) && (this.tIr.tIk > this.tIr.tIg * 5))
          {
            Log.i(this.tIr.TAG, "publish LOW_SPEED_FLING");
            this.tIr.f(paramRecyclerView, 8);
            this.tIr.tIk = 0;
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
  public static final class d
    implements RecyclerView.i
  {
    private boolean isFirst = true;
    
    d(RecyclerView paramRecyclerView) {}
    
    public final void bD(View paramView)
    {
      AppMethodBeat.i(243460);
      p.h(paramView, "view");
      if (this.isFirst)
      {
        this.isFirst = false;
        paramRecyclerView.post((Runnable)new a(this));
      }
      AppMethodBeat.o(243460);
    }
    
    public final void bE(View paramView)
    {
      AppMethodBeat.i(243459);
      p.h(paramView, "view");
      AppMethodBeat.o(243459);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(243458);
        this.tIs.tIr.dap().onScrollStateChanged(this.tIs.tDJ, 4);
        AppMethodBeat.o(243458);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(f paramf, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(243461);
      this.tIr.c(this.tIt);
      AppMethodBeat.o(243461);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(243462);
      RecyclerView localRecyclerView = this.tIr.hak;
      if (localRecyclerView != null)
      {
        this.tIr.f(localRecyclerView, 5);
        AppMethodBeat.o(243462);
        return;
      }
      AppMethodBeat.o(243462);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f
 * JD-Core Version:    0.7.0.1
 */