package com.tencent.mm.plugin.finder.event.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.m;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "TAG", "", "config", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "getConfig", "()Landroid/view/ViewConfiguration;", "globalVisibleRect", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "()Landroid/graphics/Rect;", "setGlobalVisibleRect", "(Landroid/graphics/Rect;)V", "lastFirstVisibleItemPosition", "", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "(I)V", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "newState", "getNewState", "setNewState", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "createEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "getBehavior", "handleEvent", "onBindRecyclerView", "", "onInvisible", "onVisible", "publish", "plugin-finder_release"})
public abstract class e
  extends g<RecyclerView.m>
{
  private final ViewConfiguration KMb = ViewConfiguration.get(aj.getContext());
  protected Rect KMc;
  final int KMd;
  int KMe;
  private final String TAG = "Finder.FinderFeedFlowEventSubscriber";
  private RecyclerView fPw;
  public int mYh = 2147483647;
  protected int mYi = 2147483647;
  int qsD;
  int qsI;
  
  public e(d paramd)
  {
    super(paramd);
    paramd = this.KMb;
    k.g(paramd, "config");
    this.KMd = paramd.getScaledTouchSlop();
  }
  
  public c ahd(int paramInt)
  {
    return new c();
  }
  
  public final RecyclerView.m fSD()
  {
    return (RecyclerView.m)new e.a(this);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt)
  {
    k.h(paramRecyclerView, "recyclerView");
    paramRecyclerView.post((Runnable)new e.c(this, h(paramRecyclerView, paramInt)));
  }
  
  public c h(RecyclerView paramRecyclerView, int paramInt)
  {
    k.h(paramRecyclerView, "recyclerView");
    return ahd(paramInt);
  }
  
  public void onInvisible()
  {
    this.mYh = 2147483647;
    this.mYi = 2147483647;
  }
  
  public final void onVisible()
  {
    RecyclerView localRecyclerView = this.fPw;
    if (localRecyclerView != null) {
      g(localRecyclerView, 7);
    }
  }
  
  public final void v(RecyclerView paramRecyclerView)
  {
    k.h(paramRecyclerView, "recyclerView");
    this.fPw = paramRecyclerView;
    paramRecyclerView.a(fSD());
    paramRecyclerView.a((RecyclerView.j)new e.b(this, paramRecyclerView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.e
 * JD-Core Version:    0.7.0.1
 */