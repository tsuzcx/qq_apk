package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "PostDelayTime", "", "getPostDelayTime", "()J", "TAG", "", "adapterDataObserver", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "config", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "getConfig", "()Landroid/view/ViewConfiguration;", "currentStats", "", "getCurrentStats", "()I", "setCurrentStats", "(I)V", "dataChangeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getDataChangeHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "isOpenTPPlayerScroll", "", "()Z", "last5Index", "getLast5Index", "setLast5Index", "last5Offset", "", "getLast5Offset", "()[I", "setLast5Offset", "([I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sessionScrollOffset", "getSessionScrollOffset", "setSessionScrollOffset", "sumOffset", "getSumOffset", "setSumOffset", "visible", "calculateVariance", "", "array", "average", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "newState", "getBehavior", "handleEvent", "onBindRecyclerView", "", "onInvisible", "onVisible", "publish", "plugin-finder_release"})
public abstract class f
  extends e<RecyclerView.m>
{
  final String TAG = "Finder.FinderFeedFlowEventSubscriber";
  RecyclerView gpr;
  public int ohB = 2147483647;
  protected int ohC = 2147483647;
  private final ViewConfiguration rZm = ViewConfiguration.get(ak.getContext());
  protected Rect rZn;
  final int rZo;
  final boolean rZp;
  int rZq;
  int rZr;
  int rZs;
  int rZt;
  int[] rZu;
  final long rZv;
  public final RecyclerView.c rZw;
  final aq rZx;
  private boolean visible;
  
  public f(c paramc)
  {
    super(paramc);
    paramc = this.rZm;
    p.g(paramc, "config");
    this.rZo = paramc.getScaledTouchSlop();
    paramc = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    p.g(paramc, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.rZp = ((com.tencent.mm.plugin.thumbplayer.a.a)paramc).isOpenTPPlayerScroll();
    this.rZu = new int[5];
    this.rZv = 500L;
    this.rZw = ((RecyclerView.c)new a(this));
    this.rZx = ((aq)new b(this, Looper.getMainLooper()));
  }
  
  public b Ez(int paramInt)
  {
    return new b();
  }
  
  public final RecyclerView.m cBd()
  {
    return (RecyclerView.m)new c(this);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    paramRecyclerView.post((Runnable)new e(this, h(paramRecyclerView, paramInt)));
  }
  
  public b h(RecyclerView paramRecyclerView, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    return Ez(paramInt);
  }
  
  public void onInvisible()
  {
    this.visible = false;
    this.rZx.removeMessages(0);
    ae.i(this.TAG, "onInvisible " + this.ohB + ' ' + this.ohC);
  }
  
  public final void onVisible()
  {
    ae.i(this.TAG, "onVisible " + this.ohB + ' ' + this.ohC);
    this.visible = true;
    this.ohB = 2147483647;
    this.ohC = 2147483647;
    RecyclerView localRecyclerView = this.gpr;
    if (localRecyclerView != null) {
      g(localRecyclerView, 7);
    }
  }
  
  public final void s(final RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    this.gpr = paramRecyclerView;
    paramRecyclerView.a(cBd());
    paramRecyclerView.a((RecyclerView.j)new d(this, paramRecyclerView));
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof WxRecyclerAdapter))) {
      paramRecyclerView.a(this.rZw);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$adapterDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.c
  {
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201998);
      ae.d(this.rZy.TAG, "onItemRangeChanged " + paramInt1 + ' ' + paramInt2);
      this.rZy.rZx.removeMessages(0);
      this.rZy.rZx.sendEmptyMessageDelayed(1, this.rZy.rZv);
      AppMethodBeat.o(201998);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201999);
      ae.d(this.rZy.TAG, "onItemRangeInserted " + paramInt1 + ' ' + paramInt2);
      this.rZy.rZx.removeMessages(0);
      this.rZy.rZx.sendEmptyMessageDelayed(0, this.rZy.rZv);
      AppMethodBeat.o(201999);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202001);
      ae.d(this.rZy.TAG, "onItemRangeRemoved " + paramInt1 + ' ' + paramInt2);
      this.rZy.rZx.removeMessages(0);
      this.rZy.rZx.sendEmptyMessageDelayed(0, this.rZy.rZv);
      AppMethodBeat.o(202001);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(202000);
      ae.d(this.rZy.TAG, "onItemRangeMoved " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3);
      this.rZy.rZx.removeMessages(0);
      this.rZy.rZx.sendEmptyMessageDelayed(0, this.rZy.rZv);
      AppMethodBeat.o(202000);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(202002);
      ae.d(this.rZy.TAG, "onChanged");
      this.rZy.rZx.removeMessages(0);
      this.rZy.rZx.sendEmptyMessageDelayed(0, this.rZy.rZv);
      AppMethodBeat.o(202002);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$dataChangeHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class b
    extends aq
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(202003);
      if (paramMessage != null)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          AppMethodBeat.o(202003);
          return;
          paramMessage = this.rZy.gpr;
          if (paramMessage != null)
          {
            this.rZy.g(paramMessage, 5);
            AppMethodBeat.o(202003);
            return;
          }
          AppMethodBeat.o(202003);
          return;
          paramMessage = this.rZy.gpr;
        } while (paramMessage == null);
        this.rZy.g(paramMessage, 9);
        AppMethodBeat.o(202003);
        return;
      }
      AppMethodBeat.o(202003);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202005);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (this.rZy.rZp)
      {
        localObject = paramRecyclerView.getLayoutManager();
        if (localObject != null)
        {
          if (!((RecyclerView.i)localObject).kc()) {
            break label232;
          }
          paramInt1 = Math.abs(paramInt1);
          localObject = this.rZy;
          ((f)localObject).rZs += paramInt1;
          this.rZy.rZu[this.rZy.rZt] = paramInt1;
          this.rZy.rZt = ((this.rZy.rZt + 1) % this.rZy.rZu.length);
          if (this.rZy.rZq != 1) {
            break label237;
          }
          if (this.rZy.rZs > this.rZy.rZo * 5)
          {
            ae.i(this.rZy.TAG, "publish DRAGGING_DISTANCE");
            this.rZy.g(paramRecyclerView, 3);
            this.rZy.rZs = 0;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(202005);
        return;
        label232:
        paramInt1 = paramInt2;
        break;
        label237:
        if (this.rZy.rZq == 2)
        {
          localObject = this.rZy.rZu;
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
            localObject = k.NiO;
          }
          double d2;
          for (d1 = k.gkz();; d1 /= paramInt2)
          {
            localObject = this.rZy.rZu;
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
          if ((d1 < 50.0D) && (d2 < 50.0D) && (this.rZy.rZs > this.rZy.rZo * 5))
          {
            ae.i(this.rZy.TAG, "publish LOW_SPEED_FLING");
            this.rZy.g(paramRecyclerView, 8);
            this.rZy.rZs = 0;
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202004);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (this.rZy.rZn == null)
      {
        localObject = this.rZy;
        Rect localRect = new Rect();
        paramRecyclerView.getGlobalVisibleRect(localRect);
        ((f)localObject).rZn = localRect;
      }
      if (this.rZy.rZq != paramInt)
      {
        this.rZy.rZr = this.rZy.rZq;
        this.rZy.rZq = paramInt;
      }
      this.rZy.g(paramRecyclerView, paramInt);
      if (this.rZy.rZq == 0)
      {
        paramRecyclerView = this.rZy;
        localObject = new int[5];
        p.h(localObject, "<set-?>");
        paramRecyclerView.rZu = ((int[])localObject);
        this.rZy.rZt = 0;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(202004);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
  public static final class d
    implements RecyclerView.j
  {
    private boolean isFirst = true;
    
    d(RecyclerView paramRecyclerView) {}
    
    public final void bQ(View paramView)
    {
      AppMethodBeat.i(202008);
      p.h(paramView, "view");
      if (this.isFirst)
      {
        this.isFirst = false;
        paramRecyclerView.post((Runnable)new a(this));
      }
      AppMethodBeat.o(202008);
    }
    
    public final void bR(View paramView)
    {
      AppMethodBeat.i(202007);
      p.h(paramView, "view");
      AppMethodBeat.o(202007);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(202006);
        this.rZz.rZy.cBd().b(this.rZz.rWI, 4);
        AppMethodBeat.o(202006);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(f paramf, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(202009);
      this.rZy.c(this.rZA);
      AppMethodBeat.o(202009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f
 * JD-Core Version:    0.7.0.1
 */