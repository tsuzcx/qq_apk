package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "isDestroy", "", "isIgnoreDefaultPoiRequest", "locationWidget", "Lcom/tencent/mm/plugin/finder/api/IFinderLocationWidget;", "getLocationWidget", "()Lcom/tencent/mm/plugin/finder/api/IFinderLocationWidget;", "setLocationWidget", "(Lcom/tencent/mm/plugin/finder/api/IFinderLocationWidget;)V", "getRoot", "()Landroid/view/View;", "getLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "initLocation", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "requestLocationLikeByUser", "setIsCanSelectNone", "isCanSelectNone", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  implements a.a
{
  public static final aw.a EsP;
  public com.tencent.mm.plugin.finder.api.h EsQ;
  public boolean EsR;
  private boolean EsS;
  final MMActivity activity;
  private final View lBX;
  
  static
  {
    AppMethodBeat.i(361487);
    EsP = new aw.a((byte)0);
    AppMethodBeat.o(361487);
  }
  
  public aw(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(361471);
    this.activity = paramMMActivity;
    this.lBX = paramView;
    this.activity.getIntent().putExtra("saveLocation", false);
    this.activity.getIntent().putExtra("is_force_dark_mode", true);
    this.activity.getIntent().putExtra("show_city", false);
    this.activity.getIntent().putExtra("poi_show_none", true);
    this.activity.getIntent().putExtra("can_show_create_poi_tips", false);
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF.co(com.tencent.mm.plugin.finder.api.h.class);
    paramView = (com.tencent.mm.plugin.finder.api.h)paramMMActivity;
    MMActivity localMMActivity = this.activity;
    View localView = this.lBX.findViewById(p.e.post_location_view);
    s.s(localView, "root.findViewById<Finder…(R.id.post_location_view)");
    paramView.a(localMMActivity, (b)localView, null, null);
    paramView = ah.aiuX;
    this.EsQ = ((com.tencent.mm.plugin.finder.api.h)paramMMActivity);
    paramMMActivity = this.EsQ;
    paramView = this.activity.getIntent();
    s.s(paramView, "activity.intent");
    paramMMActivity.c(paramView, new Bundle());
    this.EsQ.dUk().setIconColor(this.lBX.getContext().getResources().getColor(p.b.White));
    this.EsQ.dUk().setTextColor(this.lBX.getContext().getResources().getColor(p.b.White));
    this.EsQ.dUk().setDefaultStateIconColor(this.lBX.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
    this.EsQ.dUk().setDefaultStateTextColor(this.lBX.getContext().getResources().getColor(p.b.White));
    this.EsQ.dUk().setDefaultLoadingPBarColor(this.lBX.getContext().getResources().getColor(p.b.White));
    this.EsQ.dUk().setDefaultLoadingTipColor(this.lBX.getContext().getResources().getColor(p.b.White));
    this.EsQ.dUk().Px(p.g.finder_live_icon_location_loading);
    d.B((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(361471);
  }
  
  private static final void a(aw paramaw, dha paramdha, String paramString, List paramList)
  {
    Object localObject = null;
    AppMethodBeat.i(361479);
    s.u(paramaw, "this$0");
    s.u(paramdha, "$lbsLocation");
    if ((paramaw.EsR) || (paramList == null))
    {
      AppMethodBeat.o(361479);
      return;
    }
    paramList = (dgz)p.oL(paramList);
    if (paramList != null)
    {
      Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser ready to save: " + paramString + ' ' + paramList.hAP + ' ' + paramList.MpI + " long=" + paramdha.ZaG + " lat=" + paramdha.ZaH);
      paramaw.EsS = true;
      paramaw.EsQ.a(paramString, paramList, paramdha.ZaG, paramdha.ZaH);
      paramaw.EsQ.dUo();
      paramdha = paramaw.EsQ.getLocation();
      if (paramdha != null) {
        break label217;
      }
      paramdha = null;
      if (Util.isNullOrNil(paramdha))
      {
        paramdha = paramaw.EsQ.getLocation();
        if (paramdha != null) {
          break label225;
        }
      }
    }
    label217:
    label225:
    for (paramdha = localObject;; paramdha = paramdha.city)
    {
      if (Util.isNullOrNil(paramdha)) {
        paramaw.EsQ.dUl();
      }
      AppMethodBeat.o(361479);
      return;
      paramdha = paramdha.poiName;
      break;
    }
  }
  
  public final void eBo()
  {
    dha localdha = null;
    AppMethodBeat.i(361517);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    if (!((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).dUi())
    {
      Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser no permission");
      AppMethodBeat.o(361517);
      return;
    }
    localObject = this.EsQ.getLocation();
    if (localObject == null)
    {
      localObject = null;
      if (Util.isNullOrNil((String)localObject))
      {
        localObject = this.EsQ.getLocation();
        if (localObject != null) {
          break label121;
        }
      }
    }
    label121:
    for (localObject = localdha;; localObject = ((boi)localObject).city)
    {
      if (Util.isNullOrNil((String)localObject)) {
        break label129;
      }
      Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser poi exist");
      AppMethodBeat.o(361517);
      return;
      localObject = ((boi)localObject).poiName;
      break;
    }
    label129:
    Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser begin");
    localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).dUh();
    localdha = new dha();
    localdha.ZaG = ((Number)((r)localObject).bsC).floatValue();
    localdha.ZaH = ((Number)((r)localObject).bsD).floatValue();
    localdha.Zyo = 0;
    localdha.Zyl = 1;
    ((com.tencent.mm.pluginsdk.location.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.location.a.class)).a(localdha, new aw..ExternalSyntheticLambda0(this, localdha));
    AppMethodBeat.o(361517);
  }
  
  public final boi getLocation()
  {
    AppMethodBeat.i(361537);
    Object localObject1 = this.EsQ.getLocation();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      if (!((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).dUi())
      {
        Log.i("Finder.FinderLivePostLocationWidget", "getLocation no permission");
        AppMethodBeat.o(361537);
        return null;
      }
      localObject1 = new boi();
      Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = ((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).dUh();
      ((boi)localObject1).latitude = ((Number)((r)localObject2).bsD).floatValue();
      ((boi)localObject1).longitude = ((Number)((r)localObject2).bsC).floatValue();
      AppMethodBeat.o(361537);
      return localObject1;
    }
    AppMethodBeat.o(361537);
    return localObject1;
  }
  
  public final void onGetLbsLifes(String paramString, List<dgz> paramList)
  {
    AppMethodBeat.i(361529);
    if ((this.EsR) || (this.EsS))
    {
      Log.i("Finder.FinderLivePostLocationWidget", "#onGetLbsLifes isDestroy=" + this.EsR + " ignore=" + this.EsS);
      AppMethodBeat.o(361529);
      return;
    }
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = com.tencent.mm.plugin.finder.live.viewmodel.k.DYB;
      Log.i(com.tencent.mm.plugin.finder.live.viewmodel.k.access$getTAG$cp(), "get lbsLife success");
      this.EsQ.a(paramString, (dgz)p.oK(paramList));
      this.EsQ.dUm();
      AppMethodBeat.o(361529);
      return;
    }
    paramString = com.tencent.mm.plugin.finder.live.viewmodel.k.DYB;
    Log.i(com.tencent.mm.plugin.finder.live.viewmodel.k.access$getTAG$cp(), "get lbsLife fail");
    this.EsQ.dUm();
    AppMethodBeat.o(361529);
  }
  
  public final void sE(boolean paramBoolean)
  {
    AppMethodBeat.i(361507);
    Log.i("Finder.FinderLivePostLocationWidget", s.X("#setIsCanSelectNone isCanSelectNone=", Boolean.valueOf(paramBoolean)));
    this.activity.getIntent().putExtra("poi_show_none", paramBoolean);
    AppMethodBeat.o(361507);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(aw paramaw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.aw
 * JD-Core Version:    0.7.0.1
 */