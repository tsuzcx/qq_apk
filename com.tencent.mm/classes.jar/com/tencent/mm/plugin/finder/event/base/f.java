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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "PostDelayTime", "", "getPostDelayTime", "()J", "TAG", "", "adapterDataObserver", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "config", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "getConfig", "()Landroid/view/ViewConfiguration;", "currentStats", "", "getCurrentStats", "()I", "setCurrentStats", "(I)V", "dataChangeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getDataChangeHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "isOpenTPPlayerScroll", "", "()Z", "last5Index", "getLast5Index", "setLast5Index", "last5Offset", "", "getLast5Offset", "()[I", "setLast5Offset", "([I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sessionScrollOffset", "getSessionScrollOffset", "setSessionScrollOffset", "sumOffset", "getSumOffset", "setSumOffset", "visible", "calculateVariance", "", "array", "average", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "newState", "getBehavior", "handleEvent", "onBindRecyclerView", "", "onInvisible", "onVisible", "publish", "plugin-finder_release"})
public abstract class f
  extends e<RecyclerView.m>
{
  final String TAG = "Finder.FinderFeedFlowEventSubscriber";
  RecyclerView gmV;
  public int obN = 2147483647;
  protected int obO = 2147483647;
  private final ViewConfiguration rQK = ViewConfiguration.get(aj.getContext());
  protected Rect rQL;
  final int rQM;
  final boolean rQN;
  int rQO;
  int rQP;
  int rQQ;
  int rQR;
  int[] rQS;
  final long rQT;
  public final RecyclerView.c rQU;
  final ap rQV;
  private boolean visible;
  
  public f(c paramc)
  {
    super(paramc);
    paramc = this.rQK;
    p.g(paramc, "config");
    this.rQM = paramc.getScaledTouchSlop();
    paramc = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    p.g(paramc, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.rQN = ((com.tencent.mm.plugin.thumbplayer.a.a)paramc).isOpenTPPlayerScroll();
    this.rQS = new int[5];
    this.rQT = 500L;
    this.rQU = ((RecyclerView.c)new a(this));
    this.rQV = ((ap)new b(this, Looper.getMainLooper()));
  }
  
  public b Em(int paramInt)
  {
    return new b();
  }
  
  public final RecyclerView.m czz()
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
    return Em(paramInt);
  }
  
  public void onInvisible()
  {
    this.visible = false;
    this.rQV.removeMessages(0);
    ad.i(this.TAG, "onInvisible " + this.obN + ' ' + this.obO);
  }
  
  public final void onVisible()
  {
    ad.i(this.TAG, "onVisible " + this.obN + ' ' + this.obO);
    this.visible = true;
    this.obN = 2147483647;
    this.obO = 2147483647;
    RecyclerView localRecyclerView = this.gmV;
    if (localRecyclerView != null) {
      g(localRecyclerView, 7);
    }
  }
  
  public final void s(final RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    this.gmV = paramRecyclerView;
    paramRecyclerView.a(czz());
    paramRecyclerView.a((RecyclerView.j)new d(this, paramRecyclerView));
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof WxRecyclerAdapter))) {
      paramRecyclerView.a(this.rQU);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$adapterDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.c
  {
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201551);
      ad.d(this.rQW.TAG, "onItemRangeChanged " + paramInt1 + ' ' + paramInt2);
      this.rQW.rQV.removeMessages(0);
      this.rQW.rQV.sendEmptyMessageDelayed(1, this.rQW.rQT);
      AppMethodBeat.o(201551);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201552);
      ad.d(this.rQW.TAG, "onItemRangeInserted " + paramInt1 + ' ' + paramInt2);
      this.rQW.rQV.removeMessages(0);
      this.rQW.rQV.sendEmptyMessageDelayed(0, this.rQW.rQT);
      AppMethodBeat.o(201552);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201554);
      ad.d(this.rQW.TAG, "onItemRangeRemoved " + paramInt1 + ' ' + paramInt2);
      this.rQW.rQV.removeMessages(0);
      this.rQW.rQV.sendEmptyMessageDelayed(0, this.rQW.rQT);
      AppMethodBeat.o(201554);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(201553);
      ad.d(this.rQW.TAG, "onItemRangeMoved " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3);
      this.rQW.rQV.removeMessages(0);
      this.rQW.rQV.sendEmptyMessageDelayed(0, this.rQW.rQT);
      AppMethodBeat.o(201553);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(201555);
      ad.d(this.rQW.TAG, "onChanged");
      this.rQW.rQV.removeMessages(0);
      this.rQW.rQV.sendEmptyMessageDelayed(0, this.rQW.rQT);
      AppMethodBeat.o(201555);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$dataChangeHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class b
    extends ap
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(201556);
      if (paramMessage != null)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          AppMethodBeat.o(201556);
          return;
          paramMessage = this.rQW.gmV;
          if (paramMessage != null)
          {
            this.rQW.g(paramMessage, 5);
            AppMethodBeat.o(201556);
            return;
          }
          AppMethodBeat.o(201556);
          return;
          paramMessage = this.rQW.gmV;
        } while (paramMessage == null);
        this.rQW.g(paramMessage, 9);
        AppMethodBeat.o(201556);
        return;
      }
      AppMethodBeat.o(201556);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201558);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (this.rQW.rQN)
      {
        localObject = paramRecyclerView.getLayoutManager();
        if (localObject != null)
        {
          if (!((RecyclerView.i)localObject).kc()) {
            break label232;
          }
          paramInt1 = Math.abs(paramInt1);
          localObject = this.rQW;
          ((f)localObject).rQQ += paramInt1;
          this.rQW.rQS[this.rQW.rQR] = paramInt1;
          this.rQW.rQR = ((this.rQW.rQR + 1) % this.rQW.rQS.length);
          if (this.rQW.rQO != 1) {
            break label237;
          }
          if (this.rQW.rQQ > this.rQW.rQM * 5)
          {
            ad.i(this.rQW.TAG, "publish DRAGGING_DISTANCE");
            this.rQW.g(paramRecyclerView, 3);
            this.rQW.rQQ = 0;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(201558);
        return;
        label232:
        paramInt1 = paramInt2;
        break;
        label237:
        if (this.rQW.rQO == 2)
        {
          localObject = this.rQW.rQS;
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
            localObject = k.MLL;
          }
          double d2;
          for (d1 = k.gfX();; d1 /= paramInt2)
          {
            localObject = this.rQW.rQS;
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
          if ((d1 < 50.0D) && (d2 < 50.0D) && (this.rQW.rQQ > this.rQW.rQM * 5))
          {
            ad.i(this.rQW.TAG, "publish LOW_SPEED_FLING");
            this.rQW.g(paramRecyclerView, 8);
            this.rQW.rQQ = 0;
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(201557);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if (this.rQW.rQL == null)
      {
        localObject = this.rQW;
        Rect localRect = new Rect();
        paramRecyclerView.getGlobalVisibleRect(localRect);
        ((f)localObject).rQL = localRect;
      }
      if (this.rQW.rQO != paramInt)
      {
        this.rQW.rQP = this.rQW.rQO;
        this.rQW.rQO = paramInt;
      }
      this.rQW.g(paramRecyclerView, paramInt);
      if (this.rQW.rQO == 0)
      {
        paramRecyclerView = this.rQW;
        localObject = new int[5];
        p.h(localObject, "<set-?>");
        paramRecyclerView.rQS = ((int[])localObject);
        this.rQW.rQR = 0;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$getBehavior$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(201557);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$onBindRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnChildAttachStateChangeListener;", "isFirst", "", "()Z", "setFirst", "(Z)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "plugin-finder_release"})
  public static final class d
    implements RecyclerView.j
  {
    private boolean isFirst = true;
    
    d(RecyclerView paramRecyclerView) {}
    
    public final void bQ(View paramView)
    {
      AppMethodBeat.i(201561);
      p.h(paramView, "view");
      if (this.isFirst)
      {
        this.isFirst = false;
        paramRecyclerView.post((Runnable)new a(this));
      }
      AppMethodBeat.o(201561);
    }
    
    public final void bR(View paramView)
    {
      AppMethodBeat.i(201560);
      p.h(paramView, "view");
      AppMethodBeat.o(201560);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(201559);
        this.rQX.rQW.czz().b(this.rQX.rOk, 4);
        AppMethodBeat.o(201559);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(f paramf, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(201562);
      this.rQW.c(this.rQY);
      AppMethodBeat.o(201562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f
 * JD-Core Version:    0.7.0.1
 */