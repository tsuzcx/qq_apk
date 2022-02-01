package com.tencent.mm.plugin.finder.replay;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.ag;
import com.tencent.mm.plugin.finder.live.plugin.bv;
import com.tencent.mm.plugin.finder.live.plugin.cd;
import com.tencent.mm.plugin.finder.live.plugin.cg;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadKt;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayDecorateUIC;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayStateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "closePlugin", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayClosePlugin;", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "commonInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "miniviewPlugin", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMiniViewPlugin;", "moreActionPlugin", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMoreActionPlugin;", "orientationPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin;", "payPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveChargePayPlugin;", "screenClearPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin;", "titlePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "activate", "", "checkFinderObject", "forRestar", "", "deactivate", "initPlugins", "onBindData", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "onMessageCallback", "onSlowMessageCallback", "onStatusChanged", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "resetCommentMsg", "updateChargeStatus", "GetFeedDetailCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends l
{
  private com.tencent.mm.plugin.finder.live.plugin.ah DcS;
  private com.tencent.mm.plugin.finder.live.plugin.aj EiR;
  private bv Ekl;
  private cd Fkb;
  private cg Fkc;
  private com.tencent.mm.plugin.finder.replay.plugin.c Fkd;
  private com.tencent.mm.plugin.finder.replay.plugin.b Fke;
  private com.tencent.mm.plugin.finder.replay.plugin.a Fkf;
  ag Fkg;
  final String TAG;
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(332680);
    this.TAG = "FinderLiveReplayDecorateUIC";
    AppMethodBeat.o(332680);
  }
  
  public final void c(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    AppMethodBeat.i(332775);
    s.u(parama, "baseRouter");
    super.c(parama);
    com.tencent.mm.plugin.finder.live.view.a locala = this.FkM;
    if (locala != null)
    {
      Object localObject = (cd)locala.getPlugin(cd.class);
      parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
      if (localObject == null)
      {
        parama = locala.findViewById(p.e.BUB);
        s.s(parama, "it.findViewById(R.id.finder_replay_title_ui_root)");
        parama = new cd((ViewGroup)parama, (com.tencent.mm.live.b.b)locala);
      }
      this.Fkb = parama;
      parama = (cg)locala.getPlugin(cg.class);
      if (parama == null)
      {
        parama = (ViewGroup)locala.findViewById(p.e.BUC);
        s.s(parama, "orientationRoot");
        localObject = parama.findViewById(p.e.CbT);
        s.s(localObject, "orientationRoot.findView…id.video_orientation_btn)");
        parama = new cg(parama, (ImageView)localObject, parama, (com.tencent.mm.live.b.b)locala);
        this.Fkc = parama;
        localObject = (com.tencent.mm.plugin.finder.replay.plugin.c)locala.getPlugin(com.tencent.mm.plugin.finder.replay.plugin.c.class);
        parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
        if (localObject == null)
        {
          parama = locala.findViewById(p.e.BUA);
          s.s(parama, "it.findViewById(R.id.fin…play_more_action_ui_root)");
          parama = new com.tencent.mm.plugin.finder.replay.plugin.c((ViewGroup)parama, (com.tencent.mm.live.b.b)locala);
        }
        this.Fkd = parama;
        localObject = (com.tencent.mm.plugin.finder.replay.plugin.b)locala.getPlugin(com.tencent.mm.plugin.finder.replay.plugin.b.class);
        parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
        if (localObject == null)
        {
          parama = locala.findViewById(p.e.BUE);
          s.s(parama, "it.findViewById(R.id.fin…itor_mini_window_ui_root)");
          parama = new com.tencent.mm.plugin.finder.replay.plugin.b((ViewGroup)parama, (com.tencent.mm.live.b.b)locala);
        }
        this.Fke = parama;
        localObject = (com.tencent.mm.plugin.finder.replay.plugin.a)locala.getPlugin(com.tencent.mm.plugin.finder.replay.plugin.a.class);
        parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
        if (localObject == null)
        {
          parama = locala.findViewById(p.e.BUD);
          s.s(parama, "it.findViewById(R.id.fin…ay_visitor_close_ui_root)");
          parama = new com.tencent.mm.plugin.finder.replay.plugin.a((ViewGroup)parama, (com.tencent.mm.live.b.b)locala);
        }
        this.Fkf = parama;
        localObject = (com.tencent.mm.plugin.finder.live.plugin.aj)locala.getPlugin(com.tencent.mm.plugin.finder.live.plugin.aj.class);
        parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
        if (localObject == null)
        {
          parama = locala.findViewById(p.e.BUy);
          s.s(parama, "it.findViewById(R.id.fin…play_common_info_ui_root)");
          parama = new com.tencent.mm.plugin.finder.live.plugin.aj((ViewGroup)parama, (com.tencent.mm.live.b.b)locala);
        }
        this.EiR = parama;
        localObject = (com.tencent.mm.plugin.finder.live.plugin.ah)locala.getPlugin(com.tencent.mm.plugin.finder.live.plugin.ah.class);
        parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
        if (localObject == null)
        {
          parama = locala.findViewById(p.e.BUx);
          s.s(parama, "it.findViewById(R.id.fin…r_replay_comment_ui_root)");
          parama = new com.tencent.mm.plugin.finder.live.plugin.ah((ViewGroup)parama, (com.tencent.mm.live.b.b)locala);
        }
        this.DcS = parama;
        localObject = (ag)locala.getPlugin(ag.class);
        parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
        if (localObject == null)
        {
          parama = locala.findViewById(p.e.BUz);
          s.s(parama, "it.findViewById(R.id.fin…_replay_live_pay_ui_root)");
          parama = new ag((ViewGroup)parama, (com.tencent.mm.live.b.b)locala, (byte)0);
        }
        this.Fkg = parama;
        localObject = (bv)locala.getPlugin(bv.class);
        parama = (com.tencent.mm.plugin.finder.live.view.a)localObject;
        if (localObject == null)
        {
          parama = locala.findViewById(p.e.BRX);
          s.s(parama, "it.findViewById(R.id.fin…r_live_replay_clear_view)");
          parama = new bv((ViewGroup)parama, (com.tencent.mm.live.b.b)locala);
        }
        this.Ekl = parama;
        if (!locala.isLandscape()) {
          break label634;
        }
        parama = this.Fkc;
        if (parama != null) {
          parama.tO(0);
        }
        parama = locala.findViewById(p.e.live_shadow_down);
        if (parama == null) {
          break label649;
        }
        parama = parama.getLayoutParams();
        if (parama == null) {
          break label649;
        }
        if (locala.findViewById(p.e.live_shadow_down) == null) {
          break label655;
        }
      }
    }
    label649:
    label655:
    for (int i = locala.findViewById(p.e.live_shadow_down).getMeasuredHeight();; i = 0)
    {
      if (i > 0) {}
      for (;;)
      {
        parama.height = i;
        AppMethodBeat.o(332775);
        return;
        break;
        i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_13A);
      }
      label634:
      parama = this.Fkc;
      if (parama != null) {
        parama.tO(8);
      }
      AppMethodBeat.o(332775);
      return;
    }
  }
  
  public final void deactivate() {}
  
  public final void eBc()
  {
    AppMethodBeat.i(332832);
    tu(false);
    Object localObject1 = this.Fkb;
    if (localObject1 != null) {
      cd.a((cd)localObject1, null, false, 3);
    }
    localObject1 = this.EiR;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.plugin.aj)localObject1).CYI = false;
    }
    if (((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmM != 3)
    {
      localObject1 = this.Fkc;
      if (localObject1 != null) {
        if (!((e)business(e.class)).eyC())
        {
          Object localObject2 = aw.Gjk;
          if (!aw.bgV()) {
            break label117;
          }
          localObject2 = com.tencent.d.a.a.a.a.a.ahiX;
          if (!com.tencent.d.a.a.a.a.a.jTH()) {
            break label117;
          }
        }
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      ((cg)localObject1).rK(bool);
      AppMethodBeat.o(332832);
      return;
    }
  }
  
  public final void eLw()
  {
    AppMethodBeat.i(332820);
    ThreadKt.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(332820);
  }
  
  final void tu(boolean paramBoolean)
  {
    AppMethodBeat.i(332796);
    bui localbui = new bui();
    Object localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = com.tencent.mm.plugin.finder.live.model.aj.egD();
    int i;
    label55:
    com.tencent.mm.plugin.h localh;
    MMActivity localMMActivity;
    long l;
    if (localObject == null)
    {
      i = 0;
      localbui.hLK = i;
      localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject = com.tencent.mm.plugin.finder.live.model.aj.egD();
      if (localObject != null) {
        break label220;
      }
      i = 0;
      localbui.AJo = i;
      localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject, "service(IFinderCommonService::class.java)");
      localh = (com.tencent.mm.plugin.h)localObject;
      localMMActivity = (MMActivity)this.CCa;
      l = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).ecI();
      localObject = ((e)((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).business(e.class)).Eco;
      if (localObject != null) {
        break label246;
      }
      localObject = "";
    }
    for (;;)
    {
      h.a.a(localh, localMMActivity, l, (String)localObject, "", true, null, false, null, localbui, 0, (kotlin.g.a.b)new a(new WeakReference(this), this.TAG, paramBoolean), 49024);
      AppMethodBeat.o(332796);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((j)localObject).AJo;
      break;
      label220:
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).Bwy;
      if (localObject == null)
      {
        i = 0;
        break label55;
      }
      i = ((j)localObject).AJo;
      break label55;
      label246:
      String str = ((FinderObject)localObject).objectNonceId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayDecorateUIC$GetFeedDetailCallback;", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "", "rReplayUIC", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayDecorateUIC;", "tag", "", "forRestar", "", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Z)V", "getForRestar", "()Z", "getTag", "()Ljava/lang/String;", "invoke", "result", "parseFinderObject", "replayUIC", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements kotlin.g.a.b<b.a<ayl>, kotlin.ah>
  {
    private final WeakReference<g> Fkh;
    private final boolean Fki;
    private final String tag;
    
    public a(WeakReference<g> paramWeakReference, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(332478);
      this.Fkh = paramWeakReference;
      this.tag = paramString;
      this.Fki = paramBoolean;
      AppMethodBeat.o(332478);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<String>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.g
 * JD-Core Version:    0.7.0.1
 */