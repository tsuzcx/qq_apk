package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/api/IFinderLocationWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locView", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/ILocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "()V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "hasSet", "", "getHasSet", "()Z", "setHasSet", "(Z)V", "intent", "Landroid/content/Intent;", "isLoading", "setLoading", "getLocView", "()Lcom/tencent/mm/pluginsdk/location/ILocationView;", "setLocView", "(Lcom/tencent/mm/pluginsdk/location/ILocationView;)V", "getPoiTipsLayout", "()Landroid/view/View;", "setPoiTipsLayout", "(Landroid/view/View;)V", "getPoiTipsTv", "()Landroid/widget/TextView;", "setPoiTipsTv", "(Landroid/widget/TextView;)V", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "setReqCode", "(I)V", "canPost", "getLocation", "getLocationView", "hidePoiTips", "", "init", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "city", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "longitude", "", "latitude", "setDefaultState", "setLoadingState", "setLocation", "location", "setPoi", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "lbsLife", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements com.tencent.mm.plugin.finder.api.h
{
  public com.tencent.mm.pluginsdk.location.b GfD;
  private View GfE;
  private TextView GfF;
  private boi GfG;
  private boolean GfH;
  private Bundle Gfy;
  private final String TAG = "Finder.FinderLocationWidget";
  public MMActivity activity;
  private Intent intent;
  private boolean isLoading;
  private int rwy;
  
  private static final void a(f paramf, Intent paramIntent)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(342900);
    s.u(paramf, "this$0");
    s.u(paramIntent, "$intent");
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 6);
    Object localObject = paramf.GfG;
    float f1;
    if (localObject == null)
    {
      f1 = 0.0F;
      localIntent.putExtra("get_lat", f1);
      localObject = paramf.GfG;
      if (localObject != null) {
        break label248;
      }
      f1 = f2;
      label73:
      localIntent.putExtra("get_lng", f1);
      localObject = paramf.GfG;
      if (localObject != null) {
        break label257;
      }
      localObject = "";
      label97:
      localIntent.putExtra("get_poi_classify_id", (String)localObject);
      localObject = paramf.GfG;
      if (localObject != null) {
        break label280;
      }
      localObject = "";
    }
    for (;;)
    {
      localIntent.putExtra("get_city", (String)localObject);
      localIntent.putExtra("is_force_dark_mode", paramIntent.getBooleanExtra("is_force_dark_mode", false));
      localIntent.putExtra("is_force_dark_mode", paramIntent.getBooleanExtra("is_force_dark_mode", false));
      localIntent.putExtra("can_show_create_poi_tips", paramIntent.getBooleanExtra("can_show_create_poi_tips", true));
      localIntent.putExtra("show_city", paramIntent.getBooleanExtra("show_city", true));
      localIntent.putExtra("poi_show_none", paramIntent.getBooleanExtra("poi_show_none", true));
      c.b((Context)paramf.getActivity(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, paramf.rwy);
      l.kK(5, 10);
      AppMethodBeat.o(342900);
      return;
      f1 = ((boi)localObject).latitude;
      break;
      label248:
      f1 = ((boi)localObject).longitude;
      break label73;
      label257:
      String str = ((boi)localObject).ZWG;
      localObject = str;
      if (str != null) {
        break label97;
      }
      localObject = "";
      break label97;
      label280:
      str = ((boi)localObject).city;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  private com.tencent.mm.pluginsdk.location.b feH()
  {
    AppMethodBeat.i(342869);
    com.tencent.mm.pluginsdk.location.b localb = this.GfD;
    if (localb != null)
    {
      AppMethodBeat.o(342869);
      return localb;
    }
    s.bIx("locView");
    AppMethodBeat.o(342869);
    return null;
  }
  
  private void feI()
  {
    AppMethodBeat.i(342880);
    View localView = this.GfE;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(342880);
  }
  
  private final void feJ()
  {
    Object localObject2 = null;
    float f2 = 0.0F;
    AppMethodBeat.i(342890);
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = this.GfG;
    float f1;
    if (localObject1 == null)
    {
      localObject1 = "";
      localJSONObject.put("poiClassifyId", localObject1);
      localObject1 = this.GfG;
      if (localObject1 != null) {
        break label180;
      }
      f1 = 0.0F;
      label51:
      localJSONObject.put("longitude", Float.valueOf(f1));
      localObject1 = this.GfG;
      if (localObject1 != null) {
        break label188;
      }
      f1 = f2;
      label74:
      localJSONObject.put("latitude", Float.valueOf(f1));
      localObject1 = this.GfG;
      if (localObject1 != null) {
        break label196;
      }
      localObject1 = null;
      label97:
      localJSONObject.put("city", Util.nullAs((String)localObject1, ""));
      localObject1 = this.GfG;
      if (localObject1 != null) {
        break label204;
      }
    }
    label180:
    label188:
    label196:
    label204:
    for (localObject1 = localObject2;; localObject1 = ((boi)localObject1).ReU)
    {
      localJSONObject.put("poiname", Util.nullAs((String)localObject1, ""));
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).bc(localJSONObject);
      AppMethodBeat.o(342890);
      return;
      String str = ((boi)localObject1).ZWG;
      localObject1 = str;
      if (str != null) {
        break;
      }
      localObject1 = "";
      break;
      f1 = ((boi)localObject1).longitude;
      break label51;
      f1 = ((boi)localObject1).latitude;
      break label74;
      localObject1 = ((boi)localObject1).city;
      break label97;
    }
  }
  
  private MMActivity getActivity()
  {
    AppMethodBeat.i(342859);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity != null)
    {
      AppMethodBeat.o(342859);
      return localMMActivity;
    }
    s.bIx("activity");
    AppMethodBeat.o(342859);
    return null;
  }
  
  public final void a(MMActivity paramMMActivity, com.tencent.mm.pluginsdk.location.b paramb, View paramView, TextView paramTextView)
  {
    AppMethodBeat.i(342914);
    s.u(paramMMActivity, "activity");
    s.u(paramb, "locView");
    s.u(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    s.u(paramb, "<set-?>");
    this.GfD = paramb;
    this.GfE = paramView;
    this.GfF = paramTextView;
    this.rwy = 20000;
    AppMethodBeat.o(342914);
  }
  
  public final void a(String paramString, dgz paramdgz)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342951);
    s.u(paramdgz, "lbsLife");
    if (!this.isLoading)
    {
      AppMethodBeat.o(342951);
      return;
    }
    this.GfH = true;
    if (Util.isNullOrNil(paramString))
    {
      feH().dUm();
      paramString = v.FrN;
      v.a(0, this.GfG);
      AppMethodBeat.o(342951);
      return;
    }
    Object localObject3 = this.intent;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("saveLocation", true);
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("get_poi_name", "");
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("get_city", Util.nullAsNil(paramString));
    localObject1 = k.aeZF;
    localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    localObject1 = this.intent;
    if (localObject1 == null)
    {
      s.bIx("intent");
      localObject1 = null;
      ((Intent)localObject1).putExtra("get_lat", ((Number)((r)localObject3).bsD).floatValue());
      localObject1 = this.intent;
      if (localObject1 != null) {
        break label396;
      }
      s.bIx("intent");
      localObject1 = null;
      label242:
      ((Intent)localObject1).putExtra("get_lng", ((Number)((r)localObject3).bsC).floatValue());
      localObject3 = this.intent;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("intent");
        localObject1 = null;
      }
      ((Intent)localObject1).putExtra("get_poi_classify_type", paramdgz.vhJ);
      localObject1 = this.intent;
      paramdgz = (dgz)localObject1;
      if (localObject1 == null)
      {
        s.bIx("intent");
        paramdgz = null;
      }
      paramdgz.putExtra("get_poi_classify_id", "");
      dUo();
      localObject1 = this.GfG;
      if (localObject1 != null)
      {
        paramdgz = this.Gfy;
        if (paramdgz != null) {
          break label399;
        }
        s.bIx("postData");
        paramdgz = localObject2;
      }
    }
    label396:
    label399:
    for (;;)
    {
      paramdgz.putByteArray("post_location", ((boi)localObject1).toByteArray());
      feH().setSuggestView(paramString);
      paramString = v.FrN;
      v.a(1, this.GfG);
      AppMethodBeat.o(342951);
      return;
      break;
      break label242;
    }
  }
  
  public final void a(String paramString, dgz paramdgz, float paramFloat1, float paramFloat2)
  {
    Object localObject = null;
    AppMethodBeat.i(342962);
    s.u(paramdgz, "i");
    Intent localIntent2 = this.intent;
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      s.bIx("intent");
      localIntent1 = null;
    }
    localIntent1.putExtra("saveLocation", true);
    localIntent2 = this.intent;
    localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      s.bIx("intent");
      localIntent1 = null;
    }
    localIntent1.putExtra("get_poi_name", Util.nullAs(paramdgz.hAP, ""));
    localIntent2 = this.intent;
    localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      s.bIx("intent");
      localIntent1 = null;
    }
    localIntent1.putExtra("get_city", Util.nullAs(paramString, ""));
    localIntent1 = this.intent;
    paramString = localIntent1;
    if (localIntent1 == null)
    {
      s.bIx("intent");
      paramString = null;
    }
    paramString.putExtra("get_lat", paramFloat2);
    localIntent1 = this.intent;
    paramString = localIntent1;
    if (localIntent1 == null)
    {
      s.bIx("intent");
      paramString = null;
    }
    paramString.putExtra("get_lng", paramFloat1);
    localIntent1 = this.intent;
    if (localIntent1 == null)
    {
      s.bIx("intent");
      localIntent1 = null;
      paramString = paramdgz.MpN;
      if (paramString != null) {
        break label277;
      }
      paramString = null;
      label222:
      localIntent1.putExtra("get_poi_address", Util.nullAsNil(paramString));
      paramString = this.intent;
      if (paramString != null) {
        break label305;
      }
      s.bIx("intent");
      paramString = localObject;
    }
    label277:
    label305:
    for (;;)
    {
      paramString.putExtra("get_poi_classify_id", Util.nullAsNil(paramdgz.MpI));
      AppMethodBeat.o(342962);
      return;
      break;
      paramString = (etl)p.oL((List)paramString);
      if (paramString == null)
      {
        paramString = null;
        break label222;
      }
      paramString = paramString.toString();
      break label222;
    }
  }
  
  public final void ar(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342959);
    s.u(paramIntent, "i");
    Intent localIntent = this.intent;
    Object localObject1 = localIntent;
    if (localIntent == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("saveLocation", true);
    localIntent = this.intent;
    localObject1 = localIntent;
    if (localIntent == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("get_poi_name", Util.nullAs(paramIntent.getStringExtra("get_poi_name"), ""));
    localIntent = this.intent;
    localObject1 = localIntent;
    if (localIntent == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("get_city", Util.nullAs(paramIntent.getStringExtra("get_city"), ""));
    localIntent = this.intent;
    localObject1 = localIntent;
    if (localIntent == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("get_lat", paramIntent.getFloatExtra("get_lat", -85.0F));
    localIntent = this.intent;
    localObject1 = localIntent;
    if (localIntent == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("get_lng", paramIntent.getFloatExtra("get_lng", -1000.0F));
    localIntent = this.intent;
    localObject1 = localIntent;
    if (localIntent == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("get_poi_address", Util.nullAsNil(paramIntent.getStringExtra("get_poi_address")));
    localObject1 = this.intent;
    if (localObject1 == null)
    {
      s.bIx("intent");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("get_poi_classify_id", Util.nullAsNil(paramIntent.getStringExtra("get_poi_classify_id")));
      AppMethodBeat.o(342959);
      return;
    }
  }
  
  public final void c(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(342922);
    s.u(paramIntent, "intent");
    s.u(paramBundle, "postData");
    this.intent = paramIntent;
    this.Gfy = paramBundle;
    paramBundle = this.GfE;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    feH().setLocationName(getActivity().getString(e.h.finder_location_tip));
    feH().setOnClickLocationListener(new f..ExternalSyntheticLambda0(this, paramIntent));
    dUo();
    AppMethodBeat.o(342922);
  }
  
  public final com.tencent.mm.pluginsdk.location.b dUk()
  {
    AppMethodBeat.i(342932);
    com.tencent.mm.pluginsdk.location.b localb = feH();
    AppMethodBeat.o(342932);
    return localb;
  }
  
  public final void dUl()
  {
    this.GfG = null;
  }
  
  public final void dUm()
  {
    AppMethodBeat.i(342953);
    this.isLoading = false;
    this.GfH = true;
    feH().dUm();
    AppMethodBeat.o(342953);
  }
  
  public final void dUn()
  {
    AppMethodBeat.i(342954);
    if (this.GfH)
    {
      AppMethodBeat.o(342954);
      return;
    }
    this.isLoading = true;
    feH().dUn();
    AppMethodBeat.o(342954);
  }
  
  public final void dUo()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342942);
    Object localObject3 = this.intent;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    if (!((Intent)localObject1).getBooleanExtra("saveLocation", false))
    {
      Log.i(this.TAG, "refreshLocationView no location data, return");
      AppMethodBeat.o(342942);
      return;
    }
    this.isLoading = false;
    feI();
    Object localObject4 = new boi();
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((boi)localObject4).poiName = Util.nullAs(((Intent)localObject1).getStringExtra("get_poi_name"), "");
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((boi)localObject4).city = Util.nullAs(((Intent)localObject1).getStringExtra("get_city"), "");
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((boi)localObject4).latitude = ((Intent)localObject1).getFloatExtra("get_lat", -85.0F);
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((boi)localObject4).longitude = ((Intent)localObject1).getFloatExtra("get_lng", -1000.0F);
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((boi)localObject4).ReU = Util.nullAsNil(((Intent)localObject1).getStringExtra("get_poi_address"));
    localObject3 = this.intent;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((boi)localObject4).ZWG = Util.nullAsNil(((Intent)localObject1).getStringExtra("get_poi_classify_id"));
    localObject1 = k.aeZF;
    if (!((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUi()) {
      ((boi)localObject4).source = 1;
    }
    localObject1 = ah.aiuX;
    this.GfG = ((boi)localObject4);
    localObject3 = this.GfG;
    if (localObject3 != null)
    {
      localObject1 = this.Gfy;
      if (localObject1 != null) {
        break label429;
      }
      s.bIx("postData");
      localObject1 = localObject2;
      ((Bundle)localObject1).putByteArray("post_location", ((boi)localObject3).toByteArray());
      if ((Util.isNullOrNil(((boi)localObject3).poiName)) && (Util.isNullOrNil(((boi)localObject3).city))) {
        break label432;
      }
      localObject4 = feH();
      localObject2 = ((boi)localObject3).city;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((boi)localObject3).poiName;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((com.tencent.mm.pluginsdk.location.b)localObject4).hT((String)localObject1, (String)localObject2);
    }
    for (;;)
    {
      feJ();
      AppMethodBeat.o(342942);
      return;
      label429:
      break;
      label432:
      feH().dUm();
    }
  }
  
  public final boi getLocation()
  {
    return this.GfG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.f
 * JD-Core Version:    0.7.0.1
 */