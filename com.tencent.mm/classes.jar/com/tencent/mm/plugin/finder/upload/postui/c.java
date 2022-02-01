package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.b.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locationView", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/ILocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "hasSet", "", "getHasSet", "()Z", "setHasSet", "(Z)V", "intent", "Landroid/content/Intent;", "isLoading", "setLoading", "getLocationView", "()Lcom/tencent/mm/pluginsdk/location/ILocationView;", "getPoiTipsLayout", "()Landroid/view/View;", "getPoiTipsTv", "()Landroid/widget/TextView;", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "canPost", "hidePoiTips", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "city", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "longitude", "", "latitude", "setDefaultState", "setLoadingState", "setPoi", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "lbsLife", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"})
public final class c
{
  public boolean ACA;
  public final b ACB;
  private final View ACC;
  private final TextView ACD;
  private Bundle ACv;
  public bdm ACz;
  private final String TAG;
  final MMActivity activity;
  public Intent intent;
  public boolean isLoading;
  final int osC;
  
  public c(MMActivity paramMMActivity, b paramb, View paramView, TextView paramTextView)
  {
    AppMethodBeat.i(290440);
    this.activity = paramMMActivity;
    this.ACB = paramb;
    this.ACC = paramView;
    this.ACD = paramTextView;
    this.osC = 20000;
    this.TAG = "Finder.FinderLocationWidget";
    AppMethodBeat.o(290440);
  }
  
  private void ecI()
  {
    AppMethodBeat.i(290438);
    View localView = this.ACC;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(290438);
      return;
    }
    AppMethodBeat.o(290438);
  }
  
  private final void ecJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(290439);
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = this.ACz;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((bdm)localObject1).SOz;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localJSONObject.put("poiClassifyId", localObject1);
    localObject1 = this.ACz;
    if (localObject1 != null)
    {
      localObject1 = Float.valueOf(((bdm)localObject1).longitude);
      localJSONObject.put("longitude", localObject1);
      localObject1 = this.ACz;
      if (localObject1 == null) {
        break label181;
      }
      localObject1 = Float.valueOf(((bdm)localObject1).latitude);
      label91:
      localJSONObject.put("latitude", localObject1);
      localObject1 = this.ACz;
      if (localObject1 == null) {
        break label189;
      }
    }
    label181:
    label189:
    for (localObject1 = ((bdm)localObject1).city;; localObject1 = null)
    {
      localJSONObject.put("city", Util.nullAs((String)localObject1, ""));
      localObject3 = this.ACz;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((bdm)localObject3).KFu;
      }
      localJSONObject.put("poiname", Util.nullAs((String)localObject1, ""));
      localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
      com.tencent.mm.plugin.finder.live.report.k.aR(localJSONObject);
      AppMethodBeat.o(290439);
      return;
      localObject1 = Float.valueOf(0.0F);
      break;
      localObject1 = Float.valueOf(0.0F);
      break label91;
    }
  }
  
  public final void a(String paramString, cqf paramcqf)
  {
    AppMethodBeat.i(290435);
    p.k(paramcqf, "lbsLife");
    if (!this.isLoading)
    {
      AppMethodBeat.o(290435);
      return;
    }
    this.ACA = true;
    if (Util.isNullOrNil(paramString))
    {
      this.ACB.dFd();
      paramString = com.tencent.mm.plugin.finder.report.k.zWs;
      com.tencent.mm.plugin.finder.report.k.a(0, this.ACz);
      AppMethodBeat.o(290435);
      return;
    }
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      p.bGy("intent");
    }
    ((Intent)localObject1).putExtra("saveLocation", true);
    localObject1 = this.intent;
    if (localObject1 == null) {
      p.bGy("intent");
    }
    ((Intent)localObject1).putExtra("get_poi_name", "");
    localObject1 = this.intent;
    if (localObject1 == null) {
      p.bGy("intent");
    }
    ((Intent)localObject1).putExtra("get_city", Util.nullAsNil(paramString));
    localObject1 = g.Xox;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((Intent)localObject2).putExtra("get_lat", ((Number)((o)localObject1).My).floatValue());
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((Intent)localObject2).putExtra("get_lng", ((Number)((o)localObject1).Mx).floatValue());
    localObject1 = this.intent;
    if (localObject1 == null) {
      p.bGy("intent");
    }
    ((Intent)localObject1).putExtra("get_poi_classify_type", paramcqf.rWu);
    paramcqf = this.intent;
    if (paramcqf == null) {
      p.bGy("intent");
    }
    paramcqf.putExtra("get_poi_classify_id", "");
    ecH();
    paramcqf = this.ACz;
    if (paramcqf != null)
    {
      localObject1 = this.ACv;
      if (localObject1 == null) {
        p.bGy("postData");
      }
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.BsS;
      ((Bundle)localObject1).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.emq(), paramcqf.toByteArray());
    }
    this.ACB.setSuggestView(paramString);
    paramString = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.a(1, this.ACz);
    AppMethodBeat.o(290435);
  }
  
  public final void ax(Intent paramIntent)
  {
    AppMethodBeat.i(290437);
    p.k(paramIntent, "i");
    Intent localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("saveLocation", true);
    localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("get_poi_name", Util.nullAs(paramIntent.getStringExtra("get_poi_name"), ""));
    localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("get_city", Util.nullAs(paramIntent.getStringExtra("get_city"), ""));
    localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("get_lat", paramIntent.getFloatExtra("get_lat", -85.0F));
    localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("get_lng", paramIntent.getFloatExtra("get_lng", -1000.0F));
    localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("get_poi_address", Util.nullAsNil(paramIntent.getStringExtra("get_poi_address")));
    localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("get_poi_classify_id", Util.nullAsNil(paramIntent.getStringExtra("get_poi_classify_id")));
    AppMethodBeat.o(290437);
  }
  
  public final void c(final Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(290433);
    p.k(paramIntent, "intent");
    p.k(paramBundle, "postData");
    this.intent = paramIntent;
    this.ACv = paramBundle;
    paramBundle = this.ACC;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    this.ACB.setLocationName(this.activity.getString(b.j.finder_location_tip));
    this.ACB.setOnClickLocationListener((b.a)new a(this, paramIntent));
    ecH();
    AppMethodBeat.o(290433);
  }
  
  public final void dFd()
  {
    AppMethodBeat.i(290436);
    this.isLoading = false;
    this.ACA = true;
    this.ACB.dFd();
    AppMethodBeat.o(290436);
  }
  
  public final void ecH()
  {
    AppMethodBeat.i(290434);
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      p.bGy("intent");
    }
    if (!((Intent)localObject1).getBooleanExtra("saveLocation", false))
    {
      Log.i(this.TAG, "refreshLocationView no location data, return");
      AppMethodBeat.o(290434);
      return;
    }
    this.isLoading = false;
    ecI();
    localObject1 = new bdm();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((bdm)localObject1).poiName = Util.nullAs(((Intent)localObject2).getStringExtra("get_poi_name"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((bdm)localObject1).city = Util.nullAs(((Intent)localObject2).getStringExtra("get_city"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((bdm)localObject1).latitude = ((Intent)localObject2).getFloatExtra("get_lat", -85.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((bdm)localObject1).longitude = ((Intent)localObject2).getFloatExtra("get_lng", -1000.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((bdm)localObject1).KFu = Util.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_address"));
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bGy("intent");
    }
    ((bdm)localObject1).SOz = Util.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_classify_id"));
    localObject2 = g.Xox;
    g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class);
    if (!com.tencent.mm.plugin.finder.viewmodel.a.ejZ()) {
      ((bdm)localObject1).source = 1;
    }
    this.ACz = ((bdm)localObject1);
    Object localObject3 = this.ACz;
    if (localObject3 != null)
    {
      localObject1 = this.ACv;
      if (localObject1 == null) {
        p.bGy("postData");
      }
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.BsS;
      ((Bundle)localObject1).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.emq(), ((bdm)localObject3).toByteArray());
      if ((Util.isNullOrNil(((bdm)localObject3).poiName)) && (Util.isNullOrNil(((bdm)localObject3).city))) {
        break label378;
      }
      b localb = this.ACB;
      localObject2 = ((bdm)localObject3).city;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((bdm)localObject3).poiName;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localb.hd((String)localObject1, (String)localObject2);
    }
    for (;;)
    {
      ecJ();
      AppMethodBeat.o(290434);
      return;
      label378:
      this.ACB.dFd();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClickLocationView"})
  static final class a
    implements b.a
  {
    a(c paramc, Intent paramIntent) {}
    
    public final void ecK()
    {
      float f2 = 0.0F;
      AppMethodBeat.i(292154);
      Intent localIntent = new Intent();
      localIntent.putExtra("near_life_scene", 6);
      Object localObject = this.ACE.ACz;
      if (localObject != null) {}
      for (float f1 = ((bdm)localObject).latitude;; f1 = 0.0F)
      {
        localIntent.putExtra("get_lat", f1);
        localObject = this.ACE.ACz;
        f1 = f2;
        if (localObject != null) {
          f1 = ((bdm)localObject).longitude;
        }
        localIntent.putExtra("get_lng", f1);
        localObject = this.ACE.ACz;
        String str;
        if (localObject != null)
        {
          str = ((bdm)localObject).SOz;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_poi_classify_id", (String)localObject);
        localObject = this.ACE.ACz;
        if (localObject != null)
        {
          str = ((bdm)localObject).city;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_city", (String)localObject);
        localIntent.putExtra("is_force_dark_mode", paramIntent.getBooleanExtra("is_force_dark_mode", false));
        localIntent.putExtra("is_force_dark_mode", paramIntent.getBooleanExtra("is_force_dark_mode", false));
        localIntent.putExtra("can_show_create_poi_tips", paramIntent.getBooleanExtra("can_show_create_poi_tips", true));
        localIntent.putExtra("show_city", paramIntent.getBooleanExtra("show_city", true));
        localIntent.putExtra("poi_show_none", paramIntent.getBooleanExtra("poi_show_none", true));
        com.tencent.mm.by.c.b((Context)this.ACE.activity, "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, this.ACE.osC);
        AppMethodBeat.o(292154);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.c
 * JD-Core Version:    0.7.0.1
 */