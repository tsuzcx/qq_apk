package com.tencent.mm.plugin.finder.replay.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.a.b;
import com.tencent.mm.plugin.finder.live.model.av;
import com.tencent.mm.plugin.finder.live.model.aw;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.live.view.mini.FinderMiniWindowFloatLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.replay.k.a;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView;", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI;", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveMiniView;", "context", "Landroid/content/Context;", "clickCallback", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;)V", "value", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "business", "getBusiness", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setBusiness", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getClickCallback", "()Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "getContext", "()Landroid/content/Context;", "miniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getMiniManager", "()Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "miniManager$delegate", "Lkotlin/Lazy;", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "getMiniWindowClickListener", "()Landroid/view/View$OnClickListener;", "miniWindowClickListener$delegate", "miniWindowCloseClickListener", "getMiniWindowCloseClickListener", "miniWindowCloseClickListener$delegate", "replayMiniView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "getReplayMiniView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "replayMiniView$delegate", "seiProcessViewCallbackProxy", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackMiniProxy;", "getSeiProcessViewCallbackProxy", "()Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackMiniProxy;", "seiProcessViewCallbackProxy$delegate", "addViewToWindow", "", "size", "Landroid/graphics/Point;", "liveId", "", "isAnchor", "", "generateType", "", "opType", "getMiniLayout", "Landroid/widget/FrameLayout;", "onFirstFrameUpdate", "onVideoPlay", "offset", "onVideoPlayEnded", "source", "onVideoPlayOverTime", "onVideoPlayPause", "onVideoSizeChange", "width", "height", "refreshMiniWindow", "release", "removeViewFromWindow", "setRenderView", "view", "Landroid/view/View;", "setupMiniView", "anchorUsername", "", "coverUrl", "updateMiniWindow", "sourceType", "micData", "Lorg/json/JSONObject;", "checkDiff", "updatePlayProgress", "total", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements d, f
{
  public static final a FmY;
  private final kotlin.j Fkm;
  final f.a FmZ;
  private com.tencent.mm.plugin.finder.live.model.context.a Fna;
  private final kotlin.j Fnb;
  private final kotlin.j Fnc;
  private final kotlin.j Fnd;
  private final kotlin.j Fne;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(332893);
    FmY = new a((byte)0);
    AppMethodBeat.o(332893);
  }
  
  public b(Context paramContext, f.a parama)
  {
    AppMethodBeat.i(332857);
    this.context = paramContext;
    this.FmZ = parama;
    this.Fnb = kotlin.k.cm((kotlin.g.a.a)b.Fnf);
    this.Fnc = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Fnd = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Fne = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Fkm = kotlin.k.cm((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(332857);
  }
  
  private final FinderLiveMiniView eMb()
  {
    AppMethodBeat.i(332862);
    FinderLiveMiniView localFinderLiveMiniView = (FinderLiveMiniView)this.Fnc.getValue();
    AppMethodBeat.o(332862);
    return localFinderLiveMiniView;
  }
  
  private final av eMc()
  {
    AppMethodBeat.i(332871);
    av localav = (av)this.Fkm.getValue();
    AppMethodBeat.o(332871);
    return localav;
  }
  
  public final void RM(int paramInt)
  {
    AppMethodBeat.i(332912);
    eMb().setState(0);
    AppMethodBeat.o(332912);
  }
  
  public final void RN(int paramInt)
  {
    AppMethodBeat.i(332929);
    eMb().setState(4);
    AppMethodBeat.o(332929);
  }
  
  public final void RO(int paramInt)
  {
    AppMethodBeat.i(332934);
    eMb().setState(8);
    AppMethodBeat.o(332934);
  }
  
  public final void a(Point paramPoint, long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(332949);
    s.u(paramPoint, "size");
    com.tencent.mm.plugin.finder.replay.k.Fky.eLF().a((aw)eMc());
    eMa().a(paramPoint, paramLong, paramBoolean, paramInt, 12);
    AppMethodBeat.o(332949);
  }
  
  public final void b(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(332971);
    Object localObject2 = new StringBuilder("updateMiniWindow:");
    Object localObject1 = this.Fna;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Log.i("FinderLiveReplayMiniView", localObject1 + ",sourceType:" + paramInt + '!');
      localObject1 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      com.tencent.mm.plugin.finder.live.view.mini.d.PI(paramInt);
      localObject1 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      com.tencent.mm.plugin.finder.live.view.mini.d.bd(paramJSONObject);
      if ((paramInt != 3) || (paramJSONObject != null)) {
        break;
      }
      AppMethodBeat.o(332971);
      return;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Long.valueOf(((bip)localObject1).liveId);
        }
      }
    }
    localObject1 = eMb();
    localObject2 = this.Fna;
    if ((localObject1 != null) && (localObject2 != null))
    {
      Object localObject3 = com.tencent.mm.live.core.d.a.mWH;
      localObject3 = com.tencent.mm.live.core.d.a.em(((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(e.class)).videoWidth, ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(e.class)).videoHeight);
      Object localObject4 = com.tencent.mm.live.core.mini.a.mUD;
      localObject4 = a.b.mUF;
      a.b.bfP().b((Point)localObject3);
      ((com.tencent.mm.plugin.finder.live.view.mini.d)((FinderLiveMiniView)localObject1).getMultiAreaLayout().getAdapter()).a(paramBoolean, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, paramInt, paramJSONObject);
    }
    AppMethodBeat.o(332971);
  }
  
  public final void bfQ()
  {
    AppMethodBeat.i(332955);
    eMa().bfQ();
    com.tencent.mm.plugin.finder.replay.k.Fky.eLF().b((aw)eMc());
    AppMethodBeat.o(332955);
  }
  
  public final void eLu() {}
  
  public final void eLx() {}
  
  public final void eLy() {}
  
  public final com.tencent.mm.live.core.mini.b eMa()
  {
    AppMethodBeat.i(332906);
    com.tencent.mm.live.core.mini.b localb = (com.tencent.mm.live.core.mini.b)this.Fnb.getValue();
    AppMethodBeat.o(332906);
    return localb;
  }
  
  public final void elR()
  {
    Object localObject2 = null;
    AppMethodBeat.i(332980);
    Object localObject3 = new StringBuilder("refreshMiniWindow:");
    Object localObject1 = this.Fna;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(",lastSourceType:");
      localObject3 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      Log.i("FinderLiveReplayMiniView", com.tencent.mm.plugin.finder.live.view.mini.d.ewh() + '!');
      localObject1 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      if (com.tencent.mm.plugin.finder.live.view.mini.d.ewh() != 2) {
        break label264;
      }
      localObject1 = this.Fna;
      if (localObject1 != null) {
        break label173;
      }
      i = 0;
      label92:
      if (i <= 3) {
        break label264;
      }
      localObject1 = this.Fna;
      if (localObject1 != null) {
        break label217;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Log.e("FinderLiveReplayMiniView", s.X("refreshMiniWindow error,AUDIENCE source type but audienceLinkMicUserList size:", localObject1));
      AppMethodBeat.o(332980);
      return;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
      label173:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 == null)
      {
        i = 0;
        break label92;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efw;
      if (localObject1 == null)
      {
        i = 0;
        break label92;
      }
      i = ((List)localObject1).size();
      break label92;
      label217:
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject3).Efw;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Integer.valueOf(((List)localObject3).size());
        }
      }
    }
    label264:
    localObject2 = eMb();
    localObject1 = this.Fna;
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = (com.tencent.mm.plugin.finder.live.view.mini.d)((FinderLiveMiniView)localObject2).getMultiAreaLayout().getAdapter();
      localObject3 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      i = com.tencent.mm.plugin.finder.live.view.mini.d.ewh();
      localObject3 = com.tencent.mm.plugin.finder.live.view.mini.d.DVM;
      ((com.tencent.mm.plugin.finder.live.view.mini.d)localObject2).a(false, (com.tencent.mm.plugin.finder.live.model.context.a)localObject1, i, com.tencent.mm.plugin.finder.live.view.mini.d.ewi());
    }
    AppMethodBeat.o(332980);
  }
  
  public final void ia(int paramInt1, int paramInt2) {}
  
  public final void ia(String paramString1, String paramString2)
  {
    AppMethodBeat.i(332942);
    boolean bool = eMb().hU(paramString1, paramString2);
    Log.i("FinderLiveReplayMiniView", s.X("setupMiniView haveSetup:", Boolean.valueOf(bool)));
    if (!bool)
    {
      eMb().x(paramString1, paramString2, false);
      eMa().b((AbsLiveMiniView)eMb());
    }
    AppMethodBeat.o(332942);
  }
  
  public final void release()
  {
    AppMethodBeat.i(332987);
    StringBuilder localStringBuilder = new StringBuilder("release:");
    Object localObject = this.Fna;
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      Log.i("FinderLiveReplayMiniView", localObject + '!');
      bfQ();
      x(null);
      AppMethodBeat.o(332987);
      return;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).liveInfo;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = Long.valueOf(((bip)localObject).liveId);
        }
      }
    }
  }
  
  public final void x(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(332898);
    Object localObject;
    if (parama == null) {
      localObject = null;
    }
    for (;;)
    {
      Log.i("FinderLiveReplayMiniView", s.X("set business:", localObject));
      this.Fna = parama;
      AppMethodBeat.o(332898);
      return;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).liveInfo;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = Long.valueOf(((bip)localObject).liveId);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.live.core.mini.b>
  {
    public static final b Fnf;
    
    static
    {
      AppMethodBeat.i(332801);
      Fnf = new b();
      AppMethodBeat.o(332801);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View$OnClickListener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View.OnClickListener>
  {
    c(b paramb)
    {
      super();
    }
    
    private static final void a(b paramb, View paramView)
    {
      AppMethodBeat.i(332793);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView$miniWindowClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      paramb.FmZ.eLH();
      paramb.bfQ();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView$miniWindowClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332793);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View$OnClickListener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View.OnClickListener>
  {
    d(b paramb)
    {
      super();
    }
    
    private static final void a(b paramb, View paramView)
    {
      AppMethodBeat.i(332794);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView$miniWindowCloseClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      paramb.FmZ.eqV();
      paramb.bfQ();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView$miniWindowCloseClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332794);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<FinderLiveMiniView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackMiniProxy;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<av>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.widget.b
 * JD-Core Version:    0.7.0.1
 */