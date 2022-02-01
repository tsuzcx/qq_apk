package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.d.a.a.a.b.a.b;
import com.tencent.d.a.a.a.b.a.b.a;
import com.tencent.d.a.a.a.b.a.c;
import com.tencent.d.a.a.a.b.a.c.a;
import com.tencent.d.a.a.a.b.a.d;
import com.tencent.d.a.a.a.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubblePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$Presenter;", "viewRoot", "Landroid/view/View;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/View;Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "ignoreOnceMiniAppPreloadWhenOnResume", "", "infoResp", "Lcom/tencent/mm/protocal/protobuf/GameWelfareInfo;", "isMiniAppPreload", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveGameWelfareTaskBubbleContract$ViewCallback;)V", "closeMiniApp", "", "goToH5", "h5", "", "onAttach", "callback", "onDetach", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "preloadMiniApp", "reloadData", "requestToPreloadMiniAppOnResume", "switchViewToHide", "switchViewToReceivableMode", "info", "Lcom/tencent/mm/protocal/protobuf/GameWelfareMediaInfo;", "forceLoadPag", "switchViewToTaskMode", "taskInfo", "", "Lcom/tencent/mm/protocal/protobuf/GameWelfareTaskInfo;", "updateBubbleInfo", "data", "fromReload", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  implements w.a
{
  public static final x.a Cyn;
  private final View CvT;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final com.tencent.mm.plugin.finder.live.plugin.b Cyo;
  w.b Cyp;
  private ccd Cyq;
  private boolean Cyr;
  private boolean Cys;
  private final Context context;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(352960);
    Cyn = new x.a((byte)0);
    AppMethodBeat.o(352960);
  }
  
  public x(View paramView, Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(352875);
    this.CvT = paramView;
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    this.Cyo = paramb1;
    AppMethodBeat.o(352875);
  }
  
  private final boolean eig()
  {
    AppMethodBeat.i(352886);
    Object localObject1 = this.Cyq;
    label45:
    cch localcch;
    if (localObject1 != null)
    {
      localObject1 = ((ccd)localObject1).aalz;
      if (localObject1 != null)
      {
        i = ((cce)localObject1).jump_type;
        localObject2 = a.b.ahmG;
        if (i != a.b.a.jUW()) {
          break label102;
        }
        i = 1;
        if (i == 0) {
          break label107;
        }
        if (localObject1 != null)
        {
          localcch = ((cce)localObject1).aalC;
          if (localcch != null)
          {
            localObject1 = (CharSequence)localcch.appid;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label112;
            }
          }
        }
      }
    }
    label102:
    label107:
    label112:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label117;
      }
      Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#preloadMiniApp appid is null, preload return");
      AppMethodBeat.o(352886);
      return false;
      i = 0;
      break;
      localObject1 = null;
      break label45;
    }
    label117:
    localObject1 = as.CAX;
    Context localContext = this.context;
    Object localObject2 = localcch.appid;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = localcch.path;
    localObject2 = str;
    if (str == null) {
      localObject2 = "";
    }
    as.a(localContext, (String)localObject1, (String)localObject2, localcch.version, localcch.ZIZ);
    AppMethodBeat.o(352886);
    return true;
  }
  
  private final void eih()
  {
    AppMethodBeat.i(352897);
    w.b localb = this.Cyp;
    if (localb != null) {
      localb.eif();
    }
    localb = this.Cyp;
    if (localb != null) {
      localb.eie();
    }
    AppMethodBeat.o(352897);
  }
  
  private final void go(List<? extends ccg> paramList)
  {
    AppMethodBeat.i(352908);
    w.b localb = this.Cyp;
    if (localb != null) {
      localb.eie();
    }
    localb = this.Cyp;
    if (localb != null) {
      localb.gn(paramList);
    }
    AppMethodBeat.o(352908);
  }
  
  public final void a(ccd paramccd, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(352978);
    Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#updateBubbleInfo");
    if (paramccd == null)
    {
      this.Cyq = null;
      eih();
      Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#updateBubbleInfo data is null, return");
      AppMethodBeat.o(352978);
      return;
    }
    Object localObject = this.Cyq;
    if (localObject == null) {}
    for (long l = 0L; l > paramccd.aaly; l = ((ccd)localObject).aaly)
    {
      Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#updateBubbleInfo out of queue, return");
      AppMethodBeat.o(352978);
      return;
    }
    this.Cyq = paramccd;
    paramccd = this.Cyq;
    int j;
    if (paramccd != null)
    {
      j = paramccd.aalw;
      localObject = a.d.ahmQ;
      if (j != a.d.a.jVc())
      {
        eih();
        Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#updateBubbleInfo welfare_type not LUCK_BAG, return");
        AppMethodBeat.o(352978);
        return;
      }
      j = paramccd.aalx;
      paramccd = a.c.ahmK;
      if (j == a.c.a.jUY())
      {
        eih();
        Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#updateBubbleInfo welfare_status is HIDE, return");
        AppMethodBeat.o(352978);
        return;
      }
    }
    paramccd = this.Cyq;
    if (paramccd != null)
    {
      j = paramccd.aalx;
      localObject = a.c.ahmK;
      if (j != a.c.a.jUZ()) {
        break label279;
      }
      paramccd = paramccd.aalB;
      if (paramccd != null)
      {
        if (((Collection)paramccd).isEmpty()) {
          break label269;
        }
        if (i == 0) {
          break label274;
        }
        label235:
        if (paramccd != null) {
          go((List)paramccd);
        }
      }
    }
    for (;;)
    {
      if (!this.Cyr) {
        this.Cyr = eig();
      }
      AppMethodBeat.o(352978);
      return;
      label269:
      i = 0;
      break;
      label274:
      paramccd = null;
      break label235;
      label279:
      localObject = a.c.ahmK;
      if (j == a.c.a.jVb())
      {
        paramccd = paramccd.aalB;
        if (paramccd != null)
        {
          if (!((Collection)paramccd).isEmpty())
          {
            i = 1;
            label315:
            if (i == 0) {
              break label339;
            }
          }
          for (;;)
          {
            if (paramccd == null) {
              break label342;
            }
            go((List)paramccd);
            break;
            i = 0;
            break label315;
            label339:
            paramccd = null;
          }
        }
      }
      else
      {
        label342:
        localObject = a.c.ahmK;
        if (j == a.c.a.jVa())
        {
          paramccd = paramccd.aalA;
          if (paramccd != null)
          {
            localObject = this.Cyp;
            if (localObject != null) {
              ((w.b)localObject).eif();
            }
            localObject = this.Cyp;
            if (localObject != null) {
              ((w.b)localObject).a(paramccd, paramBoolean);
            }
          }
        }
        else
        {
          eih();
        }
      }
    }
  }
  
  public final void c(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(353030);
    if (paramBundle == null)
    {
      paramBundle = null;
      if (s.p(paramBundle, "PORTRAIT_ACTION_FinderLiveGameWelfareTaskBubblePresenter")) {
        if (!(paramObject instanceof Bundle)) {
          break label132;
        }
      }
    }
    label132:
    for (paramBundle = (Bundle)paramObject;; paramBundle = null)
    {
      if ((paramBundle != null) && (paramBundle.getBoolean("PORTRAIT_ACTION_BUNDLE_OPEN_MINI_APP", false))) {
        try
        {
          paramBundle = paramBundle.getByteArray("PORTRAIT_ACTION_BUNDLE_GAME_WELFARE_INFO");
          if (paramBundle != null)
          {
            paramBundle = new cch().parseFrom(paramBundle);
            if (paramBundle != null) {
              break label137;
            }
            paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GameWelfareWxaJumpInfo");
            AppMethodBeat.o(353030);
            throw paramBundle;
          }
        }
        catch (Exception paramBundle)
        {
          Log.e("FinderLiveGameWelfareTaskBubblePresenter", s.X("onPortraitAction-openMiniApp", paramBundle.getLocalizedMessage()));
        }
      }
      AppMethodBeat.o(353030);
      return;
      paramBundle = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      break;
    }
    label137:
    cch localcch = (cch)paramBundle;
    paramBundle = (CharSequence)localcch.appid;
    if (paramBundle != null) {
      if (paramBundle.length() != 0) {
        break label265;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#onPortraitAction-openMiniApp appid is null, return");
        AppMethodBeat.o(353030);
        return;
      }
      paramBundle = as.CAX;
      Context localContext = this.context;
      paramObject = localcch.appid;
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
      String str = localcch.path;
      paramObject = str;
      if (str == null) {
        paramObject = "";
      }
      as.a(localContext, paramBundle, paramObject, localcch.version, localcch.ZIZ, null);
      this.Cys = true;
      AppMethodBeat.o(353030);
      return;
      int i = 1;
      continue;
      label265:
      i = 0;
    }
  }
  
  public final void eia()
  {
    AppMethodBeat.i(352987);
    a(this.Cyq, true);
    AppMethodBeat.o(352987);
  }
  
  public final void eib()
  {
    AppMethodBeat.i(352995);
    Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#requestToPreloadMiniAppOnResume");
    if (this.Cys)
    {
      this.Cys = false;
      AppMethodBeat.o(352995);
      return;
    }
    eig();
    AppMethodBeat.o(352995);
  }
  
  public final void eic()
  {
    AppMethodBeat.i(353010);
    Object localObject1 = this.Cyq;
    if (localObject1 != null)
    {
      localObject1 = ((ccd)localObject1).aalz;
      if (localObject1 != null)
      {
        localObject1 = ((cce)localObject1).aalC;
        if (localObject1 != null)
        {
          Object localObject2 = (CharSequence)((cch)localObject1).appid;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
          for (int i = 1; i != 0; i = 0)
          {
            Log.i("FinderLiveGameWelfareTaskBubblePresenter", "#preloadMiniApp appid is null, preload return");
            AppMethodBeat.o(353010);
            return;
          }
          t localt = (t)h.ax(t.class);
          localObject2 = ((cch)localObject1).appid;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localt.M("", (String)localObject1, -1);
        }
      }
    }
    AppMethodBeat.o(353010);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(353015);
    eih();
    this.Cyr = false;
    AppMethodBeat.o(353015);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(x paramx)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Boolean, ah>
    {
      a(x paramx)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.x
 * JD-Core Version:    0.7.0.1
 */