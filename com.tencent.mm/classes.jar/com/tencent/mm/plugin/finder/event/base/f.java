package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.m;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.thumbplayer.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "PostDelayTime", "", "getPostDelayTime", "()J", "TAG", "", "adapterDataObserver", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "config", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "getConfig", "()Landroid/view/ViewConfiguration;", "currentStats", "", "getCurrentStats", "()I", "setCurrentStats", "(I)V", "dataChangeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getDataChangeHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "isOpenTPPlayer", "", "()Z", "last5Index", "getLast5Index", "setLast5Index", "last5Offset", "", "getLast5Offset", "()[I", "setLast5Offset", "([I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sessionScrollOffset", "getSessionScrollOffset", "setSessionScrollOffset", "sumOffset", "getSumOffset", "setSumOffset", "visible", "calculateVariance", "", "array", "average", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "newState", "getBehavior", "handleEvent", "onBindRecyclerView", "", "onInvisible", "onVisible", "publish", "plugin-finder_release"})
public abstract class f
  extends e<RecyclerView.m>
{
  final String TAG = "Finder.FinderFeedFlowEventSubscriber";
  RecyclerView fTr;
  public int nAG = 2147483647;
  protected int nAH = 2147483647;
  private final ViewConfiguration rdo = ViewConfiguration.get(ai.getContext());
  protected Rect rdp;
  final int rdq;
  final boolean rdr;
  int rds;
  int rdt;
  int rdu;
  int rdv;
  int[] rdw;
  final long rdx;
  public final RecyclerView.c rdy;
  final ao rdz;
  private boolean visible;
  
  public f(c paramc)
  {
    super(paramc);
    paramc = this.rdo;
    k.g(paramc, "config");
    this.rdq = paramc.getScaledTouchSlop();
    paramc = g.ad(a.class);
    k.g(paramc, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.rdr = ((a)paramc).isOpenTPPlayer();
    this.rdw = new int[5];
    this.rdx = 500L;
    this.rdy = ((RecyclerView.c)new a(this));
    this.rdz = ((ao)new b(this, Looper.getMainLooper()));
  }
  
  public b Ds(int paramInt)
  {
    return new b();
  }
  
  public final RecyclerView.m ctt()
  {
    return (RecyclerView.m)new f.c(this);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt)
  {
    k.h(paramRecyclerView, "recyclerView");
    paramRecyclerView.post((Runnable)new f.e(this, h(paramRecyclerView, paramInt)));
  }
  
  public b h(RecyclerView paramRecyclerView, int paramInt)
  {
    k.h(paramRecyclerView, "recyclerView");
    return Ds(paramInt);
  }
  
  public void onInvisible()
  {
    this.visible = false;
    this.rdz.removeMessages(0);
    ac.i(this.TAG, "onInvisible " + this.nAG + ' ' + this.nAH);
  }
  
  public final void onVisible()
  {
    ac.i(this.TAG, "onVisible " + this.nAG + ' ' + this.nAH);
    this.visible = true;
    this.nAG = 2147483647;
    this.nAH = 2147483647;
    RecyclerView localRecyclerView = this.fTr;
    if (localRecyclerView != null) {
      g(localRecyclerView, 7);
    }
  }
  
  public final void s(RecyclerView paramRecyclerView)
  {
    k.h(paramRecyclerView, "recyclerView");
    this.fTr = paramRecyclerView;
    paramRecyclerView.a(ctt());
    paramRecyclerView.a((RecyclerView.j)new f.d(this, paramRecyclerView));
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof WxRecyclerAdapter))) {
      paramRecyclerView.a(this.rdy);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$adapterDataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.c
  {
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201410);
      ac.d(this.rdA.TAG, "onItemRangeChanged " + paramInt1 + ' ' + paramInt2);
      this.rdA.rdz.removeMessages(0);
      this.rdA.rdz.sendEmptyMessageDelayed(0, this.rdA.rdx);
      AppMethodBeat.o(201410);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201411);
      ac.d(this.rdA.TAG, "onItemRangeInserted " + paramInt1 + ' ' + paramInt2);
      this.rdA.rdz.removeMessages(0);
      this.rdA.rdz.sendEmptyMessageDelayed(0, this.rdA.rdx);
      AppMethodBeat.o(201411);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201413);
      ac.d(this.rdA.TAG, "onItemRangeRemoved " + paramInt1 + ' ' + paramInt2);
      this.rdA.rdz.removeMessages(0);
      this.rdA.rdz.sendEmptyMessageDelayed(0, this.rdA.rdx);
      AppMethodBeat.o(201413);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(201412);
      ac.d(this.rdA.TAG, "onItemRangeMoved " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3);
      this.rdA.rdz.removeMessages(0);
      this.rdA.rdz.sendEmptyMessageDelayed(0, this.rdA.rdx);
      AppMethodBeat.o(201412);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(201414);
      ac.d(this.rdA.TAG, "onChanged");
      this.rdA.rdz.removeMessages(0);
      this.rdA.rdz.sendEmptyMessageDelayed(0, this.rdA.rdx);
      AppMethodBeat.o(201414);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber$dataChangeHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class b
    extends ao
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(201415);
      if (paramMessage != null)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          AppMethodBeat.o(201415);
          return;
          paramMessage = this.rdA.fTr;
        } while (paramMessage == null);
        this.rdA.g(paramMessage, 5);
        AppMethodBeat.o(201415);
        return;
      }
      AppMethodBeat.o(201415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.f
 * JD-Core Version:    0.7.0.1
 */