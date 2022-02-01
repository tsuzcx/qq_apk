package com.tencent.mm.plugin.finder.live;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView.b;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "()V", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "hasPreload", "", "liveDataLoader", "Lcom/tencent/mm/plugin/finder/live/IFinderLiveDataLoader;", "viewcall", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "canFlingUp", "canLoadMore", "checkPreloadLive", "", "curPos", "", "dataSize", "getLiveData", "isEnableNestedScroll", "loadDataImpl", "loadType", "checkPullType", "pullType", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "onDetach", "onLoadMoreResult", "oriDataSize", "incrementSize", "onPreloadResult", "preloadData", "newPos", "Companion", "plugin-finder_release"})
public final class j
  implements c.a
{
  private static final boolean xVR;
  public static final a xVS;
  private FinderLiveViewCallback xVO;
  private m xVP;
  private boolean xVQ;
  
  static
  {
    AppMethodBeat.i(271889);
    xVS = new a((byte)0);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ino().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      xVR = bool;
      AppMethodBeat.o(271889);
      return;
    }
  }
  
  private final boolean f(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(271878);
    Object localObject1 = ah.yhC;
    localObject1 = ah.dwh();
    if (localObject1 != null) {}
    for (localObject1 = ((g)localObject1).xVT;; localObject1 = null)
    {
      localObject3 = ah.yhC;
      localObject3 = ah.dzj();
      if ((localObject1 == null) || (localObject3 == null)) {
        break label213;
      }
      if ((!paramBoolean) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1).yeH == paramInt2)) {
        break;
      }
      Log.i("FinderLivePresenter", "preloadDataImpl loadType:" + paramInt1 + ", pullType:" + paramInt2 + ", pullMoreType:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1).yeH);
      AppMethodBeat.o(271878);
      return false;
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1).xbk = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
    localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId;
    p.k(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1).nonceId = ((String)localObject2);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1).sessionBuffer = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).sessionBuffer;
    localObject2 = this.xVP;
    if (localObject2 != null) {
      ((m)localObject2).a(paramInt1, (com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject1);
    }
    AppMethodBeat.o(271878);
    return true;
    label213:
    Object localObject3 = new StringBuilder("preloadDataImpl loaderParams:");
    localObject1 = ah.yhC;
    g localg = ah.dwh();
    localObject1 = localObject2;
    if (localg != null) {
      localObject1 = localg.xVT;
    }
    localObject1 = ((StringBuilder)localObject3).append(localObject1).append(",curLiveRoomData:");
    localObject2 = ah.yhC;
    Log.i("FinderLivePresenter", ah.dzj());
    AppMethodBeat.o(271878);
    return false;
  }
  
  private final void gD(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(271880);
    Object localObject = this.xVP;
    int k;
    int i;
    if ((localObject == null) || (((m)localObject).dwk() != true))
    {
      localObject = d.xUS;
      k = d.dwl();
      if (!BuildInfo.IS_FLAVOR_PURPLE)
      {
        i = k;
        if (!BuildInfo.DEBUG) {}
      }
      else
      {
        i = k + 1;
      }
      k = paramInt2 - paramInt1;
      if (k >= 0) {
        break label97;
      }
    }
    for (paramInt1 = 0;; paramInt1 = j)
    {
      if ((paramInt1 != 0) && (dwf())) {
        f(3, false, 0);
      }
      AppMethodBeat.o(271880);
      return;
      label97:
      if (i <= k) {
        break;
      }
      Log.i("FinderLiveDataLoader", "needPreload curPos:" + paramInt1 + ", listSize:" + paramInt2 + '!');
    }
  }
  
  public final void a(int paramInt1, g paramg, int paramInt2)
  {
    AppMethodBeat.i(271883);
    FinderLiveViewCallback localFinderLiveViewCallback = this.xVO;
    if (localFinderLiveViewCallback != null)
    {
      Object localObject;
      int i;
      label48:
      boolean bool2;
      if (paramg != null)
      {
        localObject = Integer.valueOf(paramg.getCurPos());
        if (paramg == null) {
          break label317;
        }
        paramg = paramg.zeA;
        if (paramg == null) {
          break label317;
        }
        i = paramg.size();
        Log.i("Finder.LiveViewCallback", "onPreloadResult pullType:" + paramInt1 + " increment size:" + paramInt2 + ", dataSize:" + i + ", cur position:" + localObject);
        if (paramInt1 == 3)
        {
          localFinderLiveViewCallback.dwJ();
          paramg = (kotlin.g.a.m)FinderLiveViewCallback.g.xWn;
          boolean bool1 = localFinderLiveViewCallback.activity.isFinishing();
          bool1 = localFinderLiveViewCallback.activity.isDestroyed() | bool1;
          localObject = localFinderLiveViewCallback.xVZ;
          if (localObject == null) {
            break label323;
          }
          paramInt1 = ((FinderLiveLayoutManager)localObject).kL();
          label161:
          paramInt1 += 1;
          localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          bool2 = com.tencent.mm.plugin.finder.live.utils.a.aA((Context)localFinderLiveViewCallback.activity);
          if ((!bool1) && (paramInt1 >= 0)) {
            break label328;
          }
          label192:
          if (paramg != null) {
            paramg.invoke(Boolean.FALSE, Integer.valueOf(paramInt1));
          }
          label210:
          localObject = new StringBuilder("notifyItemRangeChange isFinish:").append(bool1).append(", nextPosition:").append(paramInt1).append(", size:").append(i).append(", isPortrait:").append(bool2).append(", scrollState:");
          paramg = localFinderLiveViewCallback.xVZ;
          if (paramg == null) {
            break label383;
          }
        }
      }
      label317:
      label323:
      label328:
      label383:
      for (paramg = Integer.valueOf(paramg.bFP);; paramg = null)
      {
        Log.i("Finder.LiveViewCallback", paramg);
        localFinderLiveViewCallback.MV(i);
        AppMethodBeat.o(271883);
        return;
        localObject = null;
        break;
        i = 0;
        break label48;
        paramInt1 = -1;
        break label161;
        if ((i <= paramInt1) || (!bool2)) {
          break label192;
        }
        localObject = localFinderLiveViewCallback.xVY.getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).aE(paramInt1, i);
        }
        if (paramg == null) {
          break label210;
        }
        paramg.invoke(Boolean.TRUE, Integer.valueOf(paramInt1));
        break label210;
      }
    }
    AppMethodBeat.o(271883);
  }
  
  public final void a(int paramInt1, g paramg, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    int j = -1;
    int i = 0;
    AppMethodBeat.i(271884);
    FinderLiveViewCallback localFinderLiveViewCallback = this.xVO;
    if (localFinderLiveViewCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("onLoadMoreResult pullType:").append(paramInt1).append(" increment size:").append(paramInt3).append(", oriDataSize:").append(paramInt2).append(", init position:");
      Object localObject;
      if (paramg != null)
      {
        localObject = Integer.valueOf(paramg.getCurPos());
        Log.i("Finder.LiveViewCallback", localObject);
        if (paramInt3 > 0) {
          break label380;
        }
        localObject = localFinderLiveViewCallback.xWg.azn(b.f.finder_live_load_more_root);
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.loading_progress);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        localObject = localFinderLiveViewCallback.xWg.azn(b.f.finder_live_load_more_root);
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.load_finish);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
        label182:
        if ((paramInt3 > 0) && (paramg != null) && (paramg.zeA != null))
        {
          paramg = localFinderLiveViewCallback.xVZ;
          if (paramg == null) {
            break label408;
          }
          paramInt1 = paramg.kJ();
          label213:
          paramg = localFinderLiveViewCallback.xVY.getAdapter();
          if (paramg != null) {
            paramg.aG(paramInt1 + 1, paramInt3);
          }
        }
        paramg = new RefreshLoadMoreLayout.c(-1);
        paramg.YNG = paramInt3;
        if (paramInt3 <= 0) {
          break label413;
        }
        bool1 = true;
        label258:
        paramg.YNF = bool1;
        if (paramg.YNF) {
          break label419;
        }
      }
      label408:
      label413:
      label419:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramg.mCI = bool1;
        localFinderLiveViewCallback.xWg.onPreFinishLoadMoreSmooth(paramg);
        if (paramg.YNF)
        {
          paramg = localFinderLiveViewCallback.xVZ;
          paramInt1 = j;
          if (paramg != null) {
            paramInt1 = paramg.kJ();
          }
          paramInt2 = paramInt1 + 1;
          paramg = localFinderLiveViewCallback.xVY.getAdapter();
          paramInt1 = i;
          if (paramg != null) {
            paramInt1 = paramg.getItemCount();
          }
          if (paramInt2 < paramInt1) {
            localFinderLiveViewCallback.xVY.post((Runnable)new FinderLiveViewCallback.f(localFinderLiveViewCallback, paramInt2));
          }
        }
        AppMethodBeat.o(271884);
        return;
        localObject = null;
        break;
        label380:
        localObject = localFinderLiveViewCallback.xWg.azn(b.f.finder_live_load_more_root);
        if (localObject == null) {
          break label182;
        }
        ((View)localObject).setVisibility(8);
        break label182;
        paramInt1 = -1;
        break label213;
        bool1 = false;
        break label258;
      }
    }
    AppMethodBeat.o(271884);
  }
  
  public final void a(c.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(271885);
    p.k(paramb, "callback");
    if (!(paramb instanceof FinderLiveViewCallback)) {
      paramb = null;
    }
    for (;;)
    {
      this.xVO = ((FinderLiveViewCallback)paramb);
      FinderLiveViewCallback localFinderLiveViewCallback = this.xVO;
      Object localObject1;
      label270:
      int i;
      int j;
      if (localFinderLiveViewCallback != null)
      {
        paramb = ah.yhC;
        localObject1 = ah.dwh();
        paramb = (c.b)localObject1;
        if (localObject1 == null) {
          paramb = new g();
        }
        p.k(paramb, "data");
        localObject1 = localFinderLiveViewCallback.xUN;
        if (localObject1 == null) {
          break label646;
        }
        localObject1 = Boolean.valueOf(((c.a)localObject1).dwf());
        c.a locala = localFinderLiveViewCallback.xUN;
        if (locala != null) {
          localObject2 = Boolean.valueOf(locala.dwg());
        }
        Log.i("Finder.LiveViewCallback", "load more setting,canLoadMore:" + localObject1 + ",canFlingUp:" + localObject2 + " enablePreloadRvFeed:" + xVR);
        if ((!(p.h(localObject1, Boolean.TRUE) ^ true)) || (!(p.h(localObject2, Boolean.TRUE) ^ true))) {
          break label652;
        }
        localFinderLiveViewCallback.xWg.setEnableRefresh(false);
        localFinderLiveViewCallback.xWg.setEnableLoadMore(false);
        localFinderLiveViewCallback.dwJ();
        localObject1 = localFinderLiveViewCallback.activity.getIntent().getByteArrayExtra("KEY_MULTI_TASK_INFO");
        localObject2 = ah.yhC;
        localObject2 = ah.dzg();
        if (localObject2 == null) {
          break label715;
        }
        localObject1 = new com.tencent.mm.plugin.finder.live.view.e((Activity)localFinderLiveViewCallback.activity, (com.tencent.mm.plugin.finder.live.view.e)localObject2);
        localFinderLiveViewCallback.xWd = ((com.tencent.mm.plugin.finder.live.view.e)localObject1);
        localObject1 = ah.yhC;
        localObject1 = localFinderLiveViewCallback.xWd;
        if (localObject1 == null) {
          p.bGy("multiTaskManager");
        }
        ah.a((com.tencent.mm.plugin.finder.live.view.e)localObject1);
        localObject1 = localFinderLiveViewCallback.xVY.getContext();
        p.j(localObject1, "recyclerView.context");
        localFinderLiveViewCallback.xVZ = new FinderLiveLayoutManager((Context)localObject1, 1);
        localObject1 = localFinderLiveViewCallback.xVZ;
        if (localObject1 != null)
        {
          ((FinderLiveLayoutManager)localObject1).yUA = ((q)new FinderLiveViewCallback.c((FinderLiveLayoutManager)localObject1, localFinderLiveViewCallback));
          ((FinderLiveLayoutManager)localObject1).yUB = ((kotlin.g.a.a)new FinderLiveViewCallback.d(localFinderLiveViewCallback));
        }
        localObject1 = localFinderLiveViewCallback.xVY;
        ((FinderLiveRecyclerView)localObject1).setHasFixedSize(true);
        ((FinderLiveRecyclerView)localObject1).setAdapter((RecyclerView.a)new b(localFinderLiveViewCallback.fragment, paramb, localFinderLiveViewCallback.xUG, localFinderLiveViewCallback.xUJ, localFinderLiveViewCallback, localFinderLiveViewCallback.reportObj));
        ((FinderLiveRecyclerView)localObject1).a((LinearLayoutManager)localFinderLiveViewCallback.xVZ);
        ((FinderLiveRecyclerView)localObject1).setPageChangeListener((FinderRecyclerView.b)new FinderLiveViewCallback.e(localFinderLiveViewCallback, paramb));
        localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
        if (((Number)com.tencent.c.a.a.a.a.a.ilG().aSr()).intValue() != 0)
        {
          localObject1 = aj.AGc;
          if (!aj.ees()) {}
        }
        else
        {
          localFinderLiveViewCallback.xVX.a((RecyclerView)localFinderLiveViewCallback.xVY);
        }
        localObject1 = localFinderLiveViewCallback.xVW;
        if (localObject1 != null) {
          ((h)localObject1).a((k)localFinderLiveViewCallback);
        }
        i = paramb.zeA.size();
        j = paramb.getCurPos();
        if (j >= 0) {
          break label737;
        }
      }
      for (;;)
      {
        this.xVP = ((m)new d());
        paramb = this.xVP;
        if (paramb != null) {
          paramb.a((c.a)this);
        }
        paramb = this.xVO;
        if (paramb == null) {
          break label840;
        }
        paramb = paramb.xWg;
        if (paramb == null) {
          break label840;
        }
        localObject1 = this.xVP;
        if (localObject1 == null) {
          break label833;
        }
        localObject1 = ((m)localObject1).dwi();
        if (localObject1 == null) {
          break label833;
        }
        ((FinderLiveRelatedLoader)localObject1).register((com.tencent.mm.view.j)paramb);
        AppMethodBeat.o(271885);
        return;
        label646:
        localObject1 = null;
        break;
        label652:
        boolean bool1;
        if (localObject1 != null)
        {
          bool1 = ((Boolean)localObject1).booleanValue();
          label664:
          if (localObject2 == null) {
            break label709;
          }
        }
        label709:
        for (boolean bool2 = ((Boolean)localObject2).booleanValue();; bool2 = false)
        {
          localFinderLiveViewCallback.xWg.setActionCallback((RefreshLoadMoreLayout.a)new FinderLiveViewCallback.h(localFinderLiveViewCallback, bool1, bool2));
          break;
          bool1 = false;
          break label664;
        }
        label715:
        localObject1 = new com.tencent.mm.plugin.finder.live.view.e((Activity)localFinderLiveViewCallback.activity, (byte[])localObject1);
        break label270;
        label737:
        if (i > j)
        {
          localObject1 = localFinderLiveViewCallback.xVY;
          paramb = com.tencent.mm.hellhoundlib.b.c.a(paramb.getCurPos(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramb.aFh(), "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "initView", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;)V", "Undefined", "scrollToPosition", "(I)V");
          ((FinderLiveRecyclerView)localObject1).scrollToPosition(((Integer)paramb.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/live/FinderLiveViewCallback", "initView", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;)V", "Undefined", "scrollToPosition", "(I)V");
        }
      }
      label833:
      AppMethodBeat.o(271885);
      return;
      label840:
      AppMethodBeat.o(271885);
      return;
    }
  }
  
  public final boolean czZ()
  {
    AppMethodBeat.i(271882);
    boolean bool = f(2, false, 0);
    AppMethodBeat.o(271882);
    return bool;
  }
  
  public final boolean dwe()
  {
    AppMethodBeat.i(271875);
    if (!this.xVQ)
    {
      Object localObject = ah.yhC;
      localObject = ah.dwh();
      if (localObject != null)
      {
        localObject = ((g)localObject).xVT;
        if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject).yeH == 1))
        {
          StringBuilder localStringBuilder = new StringBuilder("canLoadMore isLoading:");
          localObject = this.xVP;
          if (localObject != null) {}
          for (localObject = Boolean.valueOf(((m)localObject).dwj());; localObject = null)
          {
            Log.i("FinderLivePresenter", localObject + " hasPreload:" + this.xVQ);
            AppMethodBeat.o(271875);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(271875);
    return true;
  }
  
  public final boolean dwf()
  {
    AppMethodBeat.i(271876);
    Object localObject = ah.yhC;
    localObject = ah.dwh();
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.viewmodel.data.j localj = ((g)localObject).xVT;
      if ((localj == null) || (localj.fEH != 2))
      {
        localj = ((g)localObject).xVT;
        if ((localj == null) || (localj.fEH != 2))
        {
          localj = ((g)localObject).xVT;
          if ((localj == null) || (localj.fEH != 1001))
          {
            localObject = ((g)localObject).xVT;
            if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject).yeH != 1)) {
              break label96;
            }
          }
        }
      }
      AppMethodBeat.o(271876);
      return true;
      label96:
      AppMethodBeat.o(271876);
      return false;
    }
    AppMethodBeat.o(271876);
    return false;
  }
  
  public final boolean dwg()
  {
    AppMethodBeat.i(271877);
    Object localObject = ah.yhC;
    localObject = ah.dwh();
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.viewmodel.data.j localj = ((g)localObject).xVT;
      if ((localj == null) || (localj.fEH != 3))
      {
        localj = ((g)localObject).xVT;
        if ((localj == null) || (localj.fEH != 1))
        {
          localj = ((g)localObject).xVT;
          if ((localj == null) || (localj.fEH != 2))
          {
            localObject = ((g)localObject).xVT;
            if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject).fEH != 1010)) {
              break label96;
            }
          }
        }
      }
      AppMethodBeat.o(271877);
      return true;
      label96:
      AppMethodBeat.o(271877);
      return false;
    }
    AppMethodBeat.o(271877);
    return false;
  }
  
  public final g dwh()
  {
    AppMethodBeat.i(271874);
    Object localObject = ah.yhC;
    localObject = ah.dwh();
    AppMethodBeat.o(271874);
    return localObject;
  }
  
  public final boolean gC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271881);
    Log.i("FinderLivePresenter", "preloadData");
    if (this.xVQ)
    {
      Log.w("FinderLivePresenter", "return for hasPreload");
      gD(paramInt1, paramInt2);
      AppMethodBeat.o(271881);
      return false;
    }
    if (paramInt1 != 0)
    {
      Log.w("FinderLivePresenter", "return for newPos:".concat(String.valueOf(paramInt1)));
      gD(paramInt1, paramInt2);
      AppMethodBeat.o(271881);
      return false;
    }
    this.xVQ = true;
    boolean bool = f(3, true, 1);
    AppMethodBeat.o(271881);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(271887);
    Object localObject1 = this.xVO;
    if (localObject1 != null)
    {
      localObject1 = ((FinderLiveViewCallback)localObject1).xWg;
      if (localObject1 != null)
      {
        Object localObject2 = this.xVP;
        if (localObject2 != null)
        {
          localObject2 = ((m)localObject2).dwi();
          if (localObject2 != null) {
            ((FinderLiveRelatedLoader)localObject2).unregister((com.tencent.mm.view.j)localObject1);
          }
        }
      }
    }
    this.xVO = null;
    localObject1 = this.xVP;
    if (localObject1 != null)
    {
      ((m)localObject1).onDetach();
      AppMethodBeat.o(271887);
      return;
    }
    AppMethodBeat.o(271887);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$Companion;", "", "()V", "ENABLE_PRELOAD_RVFEED", "", "getENABLE_PRELOAD_RVFEED", "()Z", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.j
 * JD-Core Version:    0.7.0.1
 */