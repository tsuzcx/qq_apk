package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.upload.postui.c;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "isDestroy", "", "isIgnoreDefaultPoiRequest", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "getLocationWidget", "()Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "setLocationWidget", "(Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;)V", "getRoot", "()Landroid/view/View;", "getLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "initLocation", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "requestLocationLikeByUser", "setIsCanSelectNone", "isCanSelectNone", "Companion", "plugin-finder_release"})
public final class ah
  implements a.a
{
  public static final a zqq;
  final MMActivity activity;
  private final View jac;
  public c yOK;
  public boolean zqo;
  private boolean zqp;
  
  static
  {
    AppMethodBeat.i(273818);
    zqq = new a((byte)0);
    AppMethodBeat.o(273818);
  }
  
  public ah(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(273817);
    this.activity = paramMMActivity;
    this.jac = paramView;
    this.activity.getIntent().putExtra("saveLocation", false);
    this.activity.getIntent().putExtra("is_force_dark_mode", true);
    this.activity.getIntent().putExtra("show_city", false);
    this.activity.getIntent().putExtra("poi_show_none", true);
    this.activity.getIntent().putExtra("can_show_create_poi_tips", false);
    paramMMActivity = this.activity;
    paramView = this.jac.findViewById(b.f.post_location_view);
    p.j(paramView, "root.findViewById<Finder…(R.id.post_location_view)");
    this.yOK = new c(paramMMActivity, (b)paramView, null, null);
    paramMMActivity = this.yOK;
    paramView = this.activity.getIntent();
    p.j(paramView, "activity.intent");
    paramMMActivity.c(paramView, new Bundle());
    paramMMActivity = this.yOK.ACB;
    paramView = this.jac.getContext();
    p.j(paramView, "root.context");
    paramMMActivity.setIconColor(paramView.getResources().getColor(b.c.White));
    paramMMActivity = this.yOK.ACB;
    paramView = this.jac.getContext();
    p.j(paramView, "root.context");
    paramMMActivity.setTextColor(paramView.getResources().getColor(b.c.White));
    paramMMActivity = this.yOK.ACB;
    paramView = this.jac.getContext();
    p.j(paramView, "root.context");
    paramMMActivity.setDefaultStateIconColor(paramView.getResources().getColor(b.c.BW_100_Alpha_0_8));
    paramMMActivity = this.yOK.ACB;
    paramView = this.jac.getContext();
    p.j(paramView, "root.context");
    paramMMActivity.setDefaultStateTextColor(paramView.getResources().getColor(b.c.White));
    paramMMActivity = this.yOK.ACB;
    paramView = this.jac.getContext();
    p.j(paramView, "root.context");
    paramMMActivity.setDefaultLoadingPBarColor(paramView.getResources().getColor(b.c.White));
    paramMMActivity = this.yOK.ACB;
    paramView = this.jac.getContext();
    p.j(paramView, "root.context");
    paramMMActivity.setDefaultLoadingTipColor(paramView.getResources().getColor(b.c.White));
    this.yOK.ACB.NM(b.i.finder_live_icon_location_loading);
    d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(273817);
  }
  
  public final void dIA()
  {
    final cqg localcqg = null;
    AppMethodBeat.i(273814);
    Object localObject = g.Xox;
    g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class);
    if (!com.tencent.mm.plugin.finder.viewmodel.a.ejZ())
    {
      Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser no permission");
      AppMethodBeat.o(273814);
      return;
    }
    localObject = this.yOK.ACz;
    if (localObject != null) {}
    for (localObject = ((bdm)localObject).poiName;; localObject = null)
    {
      if (Util.isNullOrNil((String)localObject))
      {
        bdm localbdm = this.yOK.ACz;
        localObject = localcqg;
        if (localbdm != null) {
          localObject = localbdm.city;
        }
        if (Util.isNullOrNil((String)localObject)) {
          break;
        }
      }
      Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser poi exist");
      AppMethodBeat.o(273814);
      return;
    }
    Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser begin");
    localObject = g.Xox;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    localcqg = new cqg();
    localcqg.ScO = ((Number)((o)localObject).Mx).floatValue();
    localcqg.ScP = ((Number)((o)localObject).My).floatValue();
    localcqg.Sxw = 0;
    localcqg.Sxt = 1;
    ((com.tencent.mm.pluginsdk.location.a)h.ae(com.tencent.mm.pluginsdk.location.a.class)).a(localcqg, (a.a)new c(this, localcqg));
    AppMethodBeat.o(273814);
  }
  
  public final bdm getLocation()
  {
    AppMethodBeat.i(273816);
    Object localObject2 = this.yOK.ACz;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new bdm();
      localObject2 = g.Xox;
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
      ((bdm)localObject1).latitude = ((Number)((o)localObject2).My).floatValue();
      ((bdm)localObject1).longitude = ((Number)((o)localObject2).Mx).floatValue();
    }
    AppMethodBeat.o(273816);
    return localObject1;
  }
  
  public final void pK(boolean paramBoolean)
  {
    AppMethodBeat.i(273811);
    Log.i("Finder.FinderLivePostLocationWidget", "#setIsCanSelectNone isCanSelectNone=".concat(String.valueOf(paramBoolean)));
    this.activity.getIntent().putExtra("poi_show_none", paramBoolean);
    AppMethodBeat.o(273811);
  }
  
  public final void t(String paramString, List<cqf> paramList)
  {
    AppMethodBeat.i(273815);
    if ((this.zqo) || (this.zqp))
    {
      Log.i("Finder.FinderLivePostLocationWidget", "#onGetLbsLifes isDestroy=" + this.zqo + " ignore=" + this.zqp);
      AppMethodBeat.o(273815);
      return;
    }
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = i.zcP;
      Log.i(i.access$getTAG$cp(), "get lbsLife success");
      this.yOK.a(paramString, (cqf)j.lo(paramList));
      this.yOK.dFd();
      AppMethodBeat.o(273815);
      return;
    }
    paramString = i.zcP;
    Log.i(i.access$getTAG$cp(), "get lbsLife fail");
    this.yOK.dFd();
    AppMethodBeat.o(273815);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget$Companion;", "", "()V", "REQUEST_CODE_PICK_LOCATION", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "argCity", "", "kotlin.jvm.PlatformType", "argLife", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "", "onGetLbsLifes"})
  static final class c
    implements a.a
  {
    c(ah paramah, cqg paramcqg) {}
    
    public final void t(String paramString, List<cqf> paramList)
    {
      AppMethodBeat.i(269498);
      if ((ah.a(this.zqr)) || (paramList == null))
      {
        AppMethodBeat.o(269498);
        return;
      }
      paramList = (cqf)j.lp(paramList);
      if (paramList != null)
      {
        Log.i("Finder.FinderLivePostLocationWidget", "#requestLocationLikeByUser ready to save: " + paramString + ' ' + paramList.fwr + ' ' + paramList.GtI + ' ' + "long=" + localcqg.ScO + " lat=" + localcqg.ScP);
        ah.b(this.zqr);
        c localc = this.zqr.yOK;
        float f1 = localcqg.ScO;
        float f2 = localcqg.ScP;
        p.k(paramList, "i");
        Intent localIntent = localc.intent;
        if (localIntent == null) {
          p.bGy("intent");
        }
        localIntent.putExtra("saveLocation", true);
        localIntent = localc.intent;
        if (localIntent == null) {
          p.bGy("intent");
        }
        localIntent.putExtra("get_poi_name", Util.nullAs(paramList.fwr, ""));
        localIntent = localc.intent;
        if (localIntent == null) {
          p.bGy("intent");
        }
        localIntent.putExtra("get_city", Util.nullAs(paramString, ""));
        paramString = localc.intent;
        if (paramString == null) {
          p.bGy("intent");
        }
        paramString.putExtra("get_lat", f2);
        paramString = localc.intent;
        if (paramString == null) {
          p.bGy("intent");
        }
        paramString.putExtra("get_lng", f1);
        localIntent = localc.intent;
        if (localIntent == null) {
          p.bGy("intent");
        }
        paramString = paramList.GtN;
        if (paramString != null)
        {
          paramString = (eaf)j.lp((List)paramString);
          if (paramString != null)
          {
            paramString = paramString.toString();
            localIntent.putExtra("get_poi_address", Util.nullAsNil(paramString));
            paramString = localc.intent;
            if (paramString == null) {
              p.bGy("intent");
            }
            paramString.putExtra("get_poi_classify_id", Util.nullAsNil(paramList.GtI));
            this.zqr.yOK.ecH();
            paramString = this.zqr.yOK.ACz;
            if (paramString == null) {
              break label467;
            }
            paramString = paramString.poiName;
            label411:
            if (Util.isNullOrNil(paramString))
            {
              paramString = this.zqr.yOK.ACz;
              if (paramString == null) {
                break label472;
              }
            }
          }
        }
        label467:
        label472:
        for (paramString = paramString.city;; paramString = null)
        {
          if (Util.isNullOrNil(paramString)) {
            this.zqr.yOK.ACz = null;
          }
          AppMethodBeat.o(269498);
          return;
          paramString = null;
          break;
          paramString = null;
          break label411;
        }
      }
      AppMethodBeat.o(269498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ah
 * JD-Core Version:    0.7.0.1
 */