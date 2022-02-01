package com.tencent.mm.plugin.finder.live.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.FinderLiveListPlayViewRecycler.attach.1;
import com.tencent.mm.plugin.finder.live.FinderLivePlayBaseView;
import com.tencent.mm.plugin.finder.live.e;
import com.tencent.mm.plugin.finder.live.e.c;
import com.tencent.mm.plugin.finder.live.f;
import com.tencent.mm.plugin.finder.live.n;
import com.tencent.mm.plugin.finder.live.o;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.r;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveListAutoPlayManager;", "Lcom/tencent/mm/plugin/finder/live/IFinderLiveListAutoPlayManager;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "selector", "Lcom/tencent/mm/plugin/finder/live/IFinderLivePlayViewSelector;", "selectorResult", "com/tencent/mm/plugin/finder/live/model/FinderLiveListAutoPlayManager$selectorResult$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveListAutoPlayManager$selectorResult$1;", "createLivePlayView", "Lcom/tencent/mm/plugin/finder/live/FinderLivePlayBaseView;", "container", "Landroid/view/ViewGroup;", "getLivePlayView", "getOrCreateLivePlayView", "onCleared", "", "pause", "tabType", "", "pauseAllLivePlay", "print", "msg", "", "resume", "resumeAllLivePlay", "select", "dataSet", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "stopAll", "stopAllLivePlay", "(Ljava/lang/Integer;)V", "Companion", "plugin-finder_release"})
public final class v
  extends UIComponent
  implements n
{
  public static final a ygt;
  private WxRecyclerView xUj;
  private com.tencent.mm.plugin.finder.live.p ygr;
  private b ygs;
  
  static
  {
    AppMethodBeat.i(275858);
    ygt = new a((byte)0);
    AppMethodBeat.o(275858);
  }
  
  public v(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(275857);
    this.ygr = ((com.tencent.mm.plugin.finder.live.p)new f());
    this.ygs = new b(this);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = (e)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(e.class);
    kotlin.g.b.p.k(paramAppCompatActivity, "activity");
    if (((e)localObject).xUY == 0)
    {
      ((e)localObject).isReleased = false;
      if (Build.VERSION.SDK_INT >= 23)
      {
        ((e)localObject).xUX = ((e)localObject).xUV.size();
        Looper localLooper = Looper.getMainLooper();
        kotlin.g.b.p.j(localLooper, "Looper.getMainLooper()");
        localLooper.getQueue().addIdleHandler((MessageQueue.IdleHandler)new e.c((e)localObject));
      }
    }
    if (((e)localObject).xUZ.add(Integer.valueOf(paramAppCompatActivity.hashCode())))
    {
      ((e)localObject).xUY += 1;
      paramAppCompatActivity.getLifecycle().a((k)new FinderLiveListPlayViewRecycler.attach.1((e)localObject, paramAppCompatActivity));
    }
    Log.i("FinderLiveListAutoPlayManager", "init:" + hashCode());
    AppMethodBeat.o(275857);
  }
  
  private final void aex(String paramString)
  {
    AppMethodBeat.i(275856);
    Log.i("FinderLiveListAutoPlayManager", hashCode() + ',' + paramString);
    AppMethodBeat.o(275856);
  }
  
  private final void n(Integer paramInteger)
  {
    Object localObject3 = null;
    com.tencent.mm.ui.component.g localg = null;
    AppMethodBeat.i(275853);
    Object localObject1 = this.xUj;
    if (localObject1 != null) {}
    for (localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        localObject2 = null;
      }
      localObject2 = (LinearLayoutManager)localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new StringBuilder("stopAllLivePlay tabType:").append(paramInteger).append(", recyclerView:");
      localObject2 = this.xUj;
      paramInteger = localg;
      if (localObject2 != null) {
        paramInteger = Integer.valueOf(((WxRecyclerView)localObject2).hashCode());
      }
      aex(paramInteger + ", layoutManager is null!");
      AppMethodBeat.o(275853);
      return;
    }
    localObject1 = this.xUj;
    int i;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((WxRecyclerView)localObject1).getAdapter();
      if (localObject1 != null)
      {
        i = ((RecyclerView.a)localObject1).getItemCount();
        j = 0;
        label163:
        if (j >= i) {
          break label296;
        }
        localObject1 = ((LinearLayoutManager)localObject2).findViewByPosition(j);
        if (localObject1 == null) {
          break label239;
        }
        localObject1 = (ViewGroup)((View)localObject1).findViewById(b.f.live_player_container);
        label194:
        if (localObject1 != null) {
          break label245;
        }
        Log.e("FinderLiveListAutoPlayManager", "stopAllLivePlay pos:" + j + " view is null!");
      }
    }
    for (;;)
    {
      j += 1;
      break label163;
      i = 0;
      break;
      label239:
      localObject1 = null;
      break label194;
      label245:
      localObject1 = r((ViewGroup)localObject1);
      if (localObject1 != null)
      {
        ((FinderLivePlayBaseView)localObject1).stop();
        ((FinderLivePlayBaseView)localObject1).release();
        localg = com.tencent.mm.ui.component.g.Xox;
        ((e)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(e.class)).a((o)localObject1);
      }
    }
    label296:
    localObject1 = new StringBuilder("stopAllLivePlay tabType:").append(paramInteger).append(", recyclerView:");
    Object localObject2 = this.xUj;
    paramInteger = localObject3;
    if (localObject2 != null) {
      paramInteger = Integer.valueOf(((WxRecyclerView)localObject2).hashCode());
    }
    aex(paramInteger + '!');
    AppMethodBeat.o(275853);
  }
  
  private static FinderLivePlayBaseView r(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275849);
    paramViewGroup = (FinderLivePlayBaseView)paramViewGroup.findViewWithTag("live-list-preview-view-tag");
    AppMethodBeat.o(275849);
    return paramViewGroup;
  }
  
  public final void MW(int paramInt)
  {
    int j = 0;
    WxRecyclerView localWxRecyclerView1 = null;
    WxRecyclerView localWxRecyclerView2 = null;
    AppMethodBeat.i(275850);
    Object localObject1 = this.xUj;
    if (localObject1 != null) {}
    for (localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        localObject2 = null;
      }
      localObject2 = (LinearLayoutManager)localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject2 = new StringBuilder("resumeAllLivePlay tabType:").append(paramInt).append(", recyclerView:");
      localWxRecyclerView1 = this.xUj;
      localObject1 = localWxRecyclerView2;
      if (localWxRecyclerView1 != null) {
        localObject1 = Integer.valueOf(localWxRecyclerView1.hashCode());
      }
      aex(localObject1 + ", layoutManager is null!");
      AppMethodBeat.o(275850);
      return;
    }
    localObject1 = this.xUj;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((WxRecyclerView)localObject1).getAdapter();
      if (localObject1 != null)
      {
        i = ((RecyclerView.a)localObject1).getItemCount();
        if (j >= i) {
          break label270;
        }
        localObject1 = ((LinearLayoutManager)localObject2).findViewByPosition(j);
        if (localObject1 == null) {
          break label244;
        }
        localObject1 = (ViewGroup)((View)localObject1).findViewById(b.f.live_player_container);
        label199:
        if (localObject1 != null) {
          break label250;
        }
        Log.e("FinderLiveListAutoPlayManager", "resumeAllLivePlay pos:" + j + " view is null!");
      }
    }
    for (;;)
    {
      j += 1;
      break;
      i = 0;
      break;
      label244:
      localObject1 = null;
      break label199;
      label250:
      localObject1 = r((ViewGroup)localObject1);
      if (localObject1 != null) {
        ((FinderLivePlayBaseView)localObject1).resume();
      }
    }
    label270:
    Object localObject2 = new StringBuilder("resumeAllLivePlay tabType:").append(paramInt).append(", recyclerView:");
    localWxRecyclerView2 = this.xUj;
    localObject1 = localWxRecyclerView1;
    if (localWxRecyclerView2 != null) {
      localObject1 = Integer.valueOf(localWxRecyclerView2.hashCode());
    }
    aex(localObject1 + '!');
    AppMethodBeat.o(275850);
  }
  
  public final void MX(int paramInt)
  {
    int j = 0;
    WxRecyclerView localWxRecyclerView1 = null;
    WxRecyclerView localWxRecyclerView2 = null;
    AppMethodBeat.i(275851);
    Object localObject1 = this.xUj;
    if (localObject1 != null) {}
    for (localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        localObject2 = null;
      }
      localObject2 = (LinearLayoutManager)localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject2 = new StringBuilder("pauseAllLivePlay tabType:").append(paramInt).append(", recyclerView:");
      localWxRecyclerView1 = this.xUj;
      localObject1 = localWxRecyclerView2;
      if (localWxRecyclerView1 != null) {
        localObject1 = Integer.valueOf(localWxRecyclerView1.hashCode());
      }
      aex(localObject1 + ", layoutManager is null!");
      AppMethodBeat.o(275851);
      return;
    }
    localObject1 = this.xUj;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((WxRecyclerView)localObject1).getAdapter();
      if (localObject1 != null)
      {
        i = ((RecyclerView.a)localObject1).getItemCount();
        if (j >= i) {
          break label270;
        }
        localObject1 = ((LinearLayoutManager)localObject2).findViewByPosition(j);
        if (localObject1 == null) {
          break label244;
        }
        localObject1 = (ViewGroup)((View)localObject1).findViewById(b.f.live_player_container);
        label199:
        if (localObject1 != null) {
          break label250;
        }
        Log.e("FinderLiveListAutoPlayManager", "pauseAllLivePlay pos:" + j + " view is null!");
      }
    }
    for (;;)
    {
      j += 1;
      break;
      i = 0;
      break;
      label244:
      localObject1 = null;
      break label199;
      label250:
      localObject1 = r((ViewGroup)localObject1);
      if (localObject1 != null) {
        ((FinderLivePlayBaseView)localObject1).pause();
      }
    }
    label270:
    Object localObject2 = new StringBuilder("pauseAllLivePlay tabType:").append(paramInt).append(", recyclerView:");
    localWxRecyclerView2 = this.xUj;
    localObject1 = localWxRecyclerView1;
    if (localWxRecyclerView2 != null) {
      localObject1 = Integer.valueOf(localWxRecyclerView2.hashCode());
    }
    aex(localObject1 + '!');
    AppMethodBeat.o(275851);
  }
  
  public final void MY(int paramInt)
  {
    AppMethodBeat.i(275852);
    n(Integer.valueOf(paramInt));
    AppMethodBeat.o(275852);
  }
  
  public final void a(int paramInt, WxRecyclerView paramWxRecyclerView, bu parambu)
  {
    AppMethodBeat.i(275848);
    kotlin.g.b.p.k(paramWxRecyclerView, "recyclerView");
    kotlin.g.b.p.k(parambu, "dataSet");
    aex("select tabType:" + paramInt + ", recyclerView:" + paramWxRecyclerView.hashCode() + ",dataSet:" + parambu);
    this.xUj = paramWxRecyclerView;
    this.ygr.a(paramWxRecyclerView, parambu, (com.tencent.mm.plugin.finder.live.x)this.ygs);
    this.ygr.dwn();
    AppMethodBeat.o(275848);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(275855);
    super.onCleared();
    StringBuilder localStringBuilder = new StringBuilder("onCleared recyclerView:");
    Object localObject = this.xUj;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((WxRecyclerView)localObject).hashCode());; localObject = null)
    {
      aex(localObject + '!');
      a(this);
      AppMethodBeat.o(275855);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveListAutoPlayManager$Companion;", "", "()V", "LIVE_LIST_PREVIEW_VIEW_TAG", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveListAutoPlayManager$selectorResult$1", "Lcom/tencent/mm/plugin/finder/live/SelectorResult;", "", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "selectResule", "", "selectViewList", "", "Lkotlin/Triple;", "unSelectResult", "unSelectViewList", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.finder.live.x<Integer, ViewGroup, y>
  {
    public final void eh(List<? extends r<Integer, ? extends ViewGroup, y>> paramList)
    {
      AppMethodBeat.i(234775);
      kotlin.g.b.p.k(paramList, "selectViewList");
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        r localr = (r)paramList.next();
        if (localr != null)
        {
          y localy = (y)localr.aazK;
          if (localy != null)
          {
            Object localObject = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
            if (com.tencent.mm.plugin.finder.live.view.convert.a.i(localy.zAF) == 2) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label114;
              }
              Log.i("FinderLiveListAutoPlayManager", localy + " is Finish!");
              break;
            }
            label114:
            localObject = localy.zAF.liveInfo;
            if (localObject != null) {}
            for (i = (int)((bac)localObject).SEj;; i = 0)
            {
              if (!d.dr(i, 256)) {
                break label179;
              }
              Log.i("FinderLiveListAutoPlayManager", localy + " is audio live!");
              break;
            }
            label179:
            localObject = v.s((ViewGroup)localr.My);
            ((FinderLivePlayBaseView)localObject).a(new com.tencent.mm.plugin.finder.live.g("pos:" + ((Number)localr.Mx).intValue(), localy.zAF), (kotlin.g.a.a)new a((FinderLivePlayBaseView)localObject));
          }
        }
      }
      AppMethodBeat.o(234775);
    }
    
    public final void ei(List<? extends r<Integer, ? extends ViewGroup, y>> paramList)
    {
      AppMethodBeat.i(234777);
      kotlin.g.b.p.k(paramList, "unSelectViewList");
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject = (r)paramList.next();
        if (localObject != null)
        {
          localObject = v.t((ViewGroup)((r)localObject).My);
          if (localObject != null) {
            ((FinderLivePlayBaseView)localObject).stop();
          }
        }
      }
      AppMethodBeat.o(234777);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(FinderLivePlayBaseView paramFinderLivePlayBaseView)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.v
 * JD-Core Version:    0.7.0.1
 */