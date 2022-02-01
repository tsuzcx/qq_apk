package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.model.i;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.i;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkAnchorView.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBattlePanelWidget;", "", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "actionBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "actionDesc", "actionTv", "Landroid/widget/TextView;", "avatar", "Landroid/widget/ImageView;", "closeMicBtn", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "loadingBar", "Landroid/widget/ProgressBar;", "onAnchorApplyListListener", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;", "getOnAnchorApplyListListener", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;", "setOnAnchorApplyListListener", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkAnchorView$IOnAnchorApplyListListener;)V", "tipTv", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "fillBattlePanel", "", "getVisible", "", "hideBattlePanel", "onBattleActionFail", "actionType", "onBattleActionSucc", "showBattlePanel", "showProgressBar", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s.a Ent;
  private static final int Enx = 0;
  private static final int Eny;
  private static final int Enz;
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  public FinderLiveApplyLinkAnchorView.b DLa;
  private final View Enu;
  private final View Env;
  private final View Enw;
  private final String TAG;
  private final ImageView avatar;
  public final ViewGroup mJe;
  public final ProgressBar njj;
  private final TextView nmm;
  private final TextView pls;
  
  static
  {
    AppMethodBeat.i(362232);
    Ent = new s.a((byte)0);
    Eny = 1;
    Enz = 2;
    AppMethodBeat.o(362232);
  }
  
  public s(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(362176);
    this.mJe = paramViewGroup;
    this.TAG = "Finder.FinderLiveBattlePanelWidget";
    this.avatar = ((ImageView)this.mJe.findViewById(p.e.BGY));
    this.pls = ((TextView)this.mJe.findViewById(p.e.BHq));
    this.Enu = this.mJe.findViewById(p.e.BHc);
    this.Env = this.mJe.findViewById(p.e.BHd);
    this.nmm = ((TextView)this.mJe.findViewById(p.e.BHf));
    this.Enw = this.mJe.findViewById(p.e.BHg);
    this.njj = ((ProgressBar)this.mJe.findViewById(p.e.BHe));
    this.Enw.setOnClickListener(new s..ExternalSyntheticLambda0(this));
    this.Enu.setOnClickListener(new s..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(362176);
  }
  
  private static final void a(s params, View paramView)
  {
    AppMethodBeat.i(362189);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(params);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveBattlePanelWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(params, "this$0");
    params = params.DLa;
    if (params != null) {
      params.epk();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveBattlePanelWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362189);
  }
  
  private static final void b(s params, View paramView)
  {
    q.c localc2 = null;
    q.c localc1 = null;
    AppMethodBeat.i(362207);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(params);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveBattlePanelWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(params, "this$0");
    localObject1 = params.TAG;
    paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)params.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    if (paramView == null)
    {
      paramView = null;
      Log.i((String)localObject1, kotlin.g.b.s.X("curBattleStatus:", paramView));
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)params.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (paramView != null) {
        break label188;
      }
      paramView = null;
      label112:
      if (paramView != null) {
        break label213;
      }
      label116:
      if (paramView != null) {
        break label346;
      }
    }
    label188:
    label213:
    label346:
    while (paramView.intValue() != 1)
    {
      paramView = params.DLa;
      if (paramView != null) {
        paramView.epl();
      }
      params.eAg();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveBattlePanelWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362207);
      return;
      paramView = paramView.EfK;
      if (paramView == null)
      {
        paramView = null;
        break;
      }
      paramView = Integer.valueOf(paramView.CEW);
      break;
      paramView = paramView.EfK;
      if (paramView == null)
      {
        paramView = null;
        break label112;
      }
      paramView = Integer.valueOf(paramView.CEW);
      break label112;
      if (paramView.intValue() != 0) {
        break label116;
      }
      paramView = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
      com.tencent.mm.plugin.finder.live.model.mic.b.eni();
      paramView = params.DLa;
      if (paramView != null) {
        paramView.epn();
      }
      params.eAg();
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localc2 = q.c.DrF;
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).putOpt("type", Integer.valueOf(q.i.DsI.type));
      params = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)params.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (params == null) {
        params = localc1;
      }
      for (;;)
      {
        ((JSONObject)localObject1).putOpt("result", params);
        params = ah.aiuX;
        paramView.a(localc2, ((JSONObject)localObject1).toString());
        break;
        localObject2 = params.EfK;
        params = localc1;
        if (localObject2 != null) {
          params = ((i)localObject2).CES;
        }
      }
    }
    paramView = params.DLa;
    if (paramView != null) {
      paramView.epm();
    }
    paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
    localc1 = q.c.DrF;
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).putOpt("type", Integer.valueOf(q.i.DsH.type));
    params = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)params.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    if (params == null) {
      params = localc2;
    }
    for (;;)
    {
      ((JSONObject)localObject1).putOpt("result", params);
      params = ah.aiuX;
      paramView.a(localc1, ((JSONObject)localObject1).toString());
      break;
      localObject2 = params.EfK;
      params = localc2;
      if (localObject2 != null) {
        params = ((i)localObject2).CES;
      }
    }
  }
  
  private final <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(362183);
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.CvU;
    if (locala == null)
    {
      AppMethodBeat.o(362183);
      return null;
    }
    paramClass = locala.business(paramClass);
    AppMethodBeat.o(362183);
    return paramClass;
  }
  
  public final void eAg()
  {
    AppMethodBeat.i(362255);
    this.njj.setVisibility(0);
    this.Env.setVisibility(8);
    this.Enu.setVisibility(8);
    AppMethodBeat.o(362255);
  }
  
  public final void eAh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(362272);
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("fillBattlePanel: curLinkMicUser:");
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", enableBattleSwitch:");
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 != null) {
        break label371;
      }
      localObject1 = localObject2;
      label72:
      Log.i((String)localObject3, localObject1);
      if (this.njj.getVisibility() != 0)
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efv;
          if (localObject1 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
            if (localObject2 == null) {
              break label382;
            }
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).EfK;
            if ((localObject2 == null) || (((i)localObject2).CEW != 0)) {
              break label382;
            }
            i = 1;
            label151:
            if (i == 0) {
              break label387;
            }
            this.nmm.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.CiM));
            this.nmm.setTextColor(this.mJe.getContext().getResources().getColor(p.b.Red));
            this.Env.setVisibility(8);
            this.Enu.setVisibility(0);
            label221:
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
            if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).EfJ != true)) {
              break label671;
            }
          }
        }
      }
    }
    label387:
    label531:
    label671:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.Env.setVisibility(8);
        this.Enu.setVisibility(8);
      }
      this.pls.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.CiN, new Object[] { ((h)localObject1).nickname }));
      localObject2 = p.ExI;
      localObject2 = p.eCp();
      localObject1 = new com.tencent.mm.plugin.finder.loader.b(((h)localObject1).headUrl);
      localObject3 = this.avatar;
      kotlin.g.b.s.s(localObject3, "avatar");
      localObject4 = p.ExI;
      ((d)localObject2).a(localObject1, (ImageView)localObject3, p.a(p.a.ExM));
      AppMethodBeat.o(362272);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).Efv;
      break;
      label371:
      localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).EfJ);
      break label72;
      label382:
      i = 0;
      break label151;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).EfK;
        if ((localObject2 == null) || (((i)localObject2).CEW != 1)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label498;
        }
        this.nmm.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.finder_live_battle_panel_accept));
        this.nmm.setTextColor(this.mJe.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
        this.Env.setVisibility(8);
        this.Enu.setVisibility(0);
        break;
      }
      label498:
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).EfK;
        if ((localObject2 != null) && (((i)localObject2).CEW == 2))
        {
          i = 1;
          if (i == 0)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
            if (localObject2 == null) {
              break label597;
            }
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject2).EfK;
            if ((localObject2 == null) || (((i)localObject2).CEW != 3)) {
              break label597;
            }
          }
        }
      }
      label597:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label602;
        }
        this.Env.setVisibility(0);
        this.Enu.setVisibility(8);
        break;
        i = 0;
        break label531;
      }
      label602:
      this.nmm.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.CiL));
      this.nmm.setTextColor(this.mJe.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
      this.Env.setVisibility(8);
      this.Enu.setVisibility(0);
      break label221;
    }
  }
  
  public final void evb()
  {
    AppMethodBeat.i(362278);
    this.mJe.setVisibility(0);
    eAh();
    com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
    q.c localc = q.c.DrF;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("type", Integer.valueOf(q.i.DsE.type));
    ah localah = ah.aiuX;
    localj.a(localc, localJSONObject.toString());
    AppMethodBeat.o(362278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.s
 * JD-Core Version:    0.7.0.1
 */