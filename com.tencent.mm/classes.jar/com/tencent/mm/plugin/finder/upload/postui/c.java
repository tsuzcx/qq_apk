package com.tencent.mm.plugin.finder.upload.postui;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.pluginsdk.location.b.a;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locationView", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/ILocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "hasSet", "", "getHasSet", "()Z", "setHasSet", "(Z)V", "intent", "Landroid/content/Intent;", "isLoading", "setLoading", "getLocationView", "()Lcom/tencent/mm/pluginsdk/location/ILocationView;", "getPoiTipsLayout", "()Landroid/view/View;", "getPoiTipsTv", "()Landroid/widget/TextView;", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "canPost", "hidePoiTips", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "setDefaultState", "setLoadingState", "setPoi", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "city", "lbsLife", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"})
public final class c
{
  private final String TAG;
  final MMActivity activity;
  private Intent intent;
  private boolean isLoading;
  final int lxP;
  private Bundle vUI;
  public axt vUM;
  private boolean vUN;
  public final b vUO;
  private final View vUP;
  private final TextView vUQ;
  
  public c(MMActivity paramMMActivity, b paramb, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(253249);
    this.activity = paramMMActivity;
    this.vUO = paramb;
    this.vUP = paramView;
    this.vUQ = paramTextView;
    this.lxP = paramInt;
    this.TAG = "Finder.FinderLocationWidget";
    AppMethodBeat.o(253249);
  }
  
  private void dBv()
  {
    AppMethodBeat.i(253247);
    View localView = this.vUP;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(253247);
      return;
    }
    AppMethodBeat.o(253247);
  }
  
  private final void dBw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(253248);
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = this.vUM;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((axt)localObject1).LIb;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localJSONObject.put("poiClassifyId", localObject1);
    localObject1 = this.vUM;
    if (localObject1 != null)
    {
      localObject1 = Float.valueOf(((axt)localObject1).dTj);
      localJSONObject.put("longitude", localObject1);
      localObject1 = this.vUM;
      if (localObject1 == null) {
        break label181;
      }
      localObject1 = Float.valueOf(((axt)localObject1).latitude);
      label91:
      localJSONObject.put("latitude", localObject1);
      localObject1 = this.vUM;
      if (localObject1 == null) {
        break label189;
      }
    }
    label181:
    label189:
    for (localObject1 = ((axt)localObject1).fuK;; localObject1 = null)
    {
      localJSONObject.put("city", Util.nullAs((String)localObject1, ""));
      localObject3 = this.vUM;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((axt)localObject3).ErZ;
      }
      localJSONObject.put("poiname", Util.nullAs((String)localObject1, ""));
      localObject1 = k.vkd;
      k.aM(localJSONObject);
      AppMethodBeat.o(253248);
      return;
      localObject1 = Float.valueOf(0.0F);
      break;
      localObject1 = Float.valueOf(0.0F);
      break label91;
    }
  }
  
  public final void a(String paramString, chj paramchj)
  {
    AppMethodBeat.i(253243);
    p.h(paramchj, "lbsLife");
    if (!this.isLoading)
    {
      AppMethodBeat.o(253243);
      return;
    }
    this.vUN = true;
    if (Util.isNullOrNil(paramString))
    {
      this.vUO.diy();
      paramString = i.vfo;
      i.a(0, this.vUM);
      AppMethodBeat.o(253243);
      return;
    }
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      p.btv("intent");
    }
    ((Intent)localObject1).putExtra("saveLocation", true);
    localObject1 = this.intent;
    if (localObject1 == null) {
      p.btv("intent");
    }
    ((Intent)localObject1).putExtra("get_poi_name", "");
    localObject1 = this.intent;
    if (localObject1 == null) {
      p.btv("intent");
    }
    ((Intent)localObject1).putExtra("get_city", Util.nullAsNil(paramString));
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject1 = FinderGlobalLocationVM.dHP();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((Intent)localObject2).putExtra("get_lat", ((Number)((o)localObject1).second).floatValue());
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((Intent)localObject2).putExtra("get_lng", ((Number)((o)localObject1).first).floatValue());
    localObject1 = this.intent;
    if (localObject1 == null) {
      p.btv("intent");
    }
    ((Intent)localObject1).putExtra("get_poi_classify_type", paramchj.oUv);
    paramchj = this.intent;
    if (paramchj == null) {
      p.btv("intent");
    }
    paramchj.putExtra("get_poi_classify_id", "");
    dBu();
    paramchj = this.vUM;
    if (paramchj != null)
    {
      localObject1 = this.vUI;
      if (localObject1 == null) {
        p.btv("postData");
      }
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
      ((Bundle)localObject1).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.dIY(), paramchj.toByteArray());
    }
    this.vUO.setSuggestView(paramString);
    paramString = i.vfo;
    i.a(1, this.vUM);
    AppMethodBeat.o(253243);
  }
  
  public final void ar(Intent paramIntent)
  {
    AppMethodBeat.i(253246);
    p.h(paramIntent, "i");
    Intent localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("saveLocation", true);
    localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("get_poi_name", Util.nullAs(paramIntent.getStringExtra("get_poi_name"), ""));
    localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("get_city", Util.nullAs(paramIntent.getStringExtra("get_city"), ""));
    localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("get_lat", paramIntent.getFloatExtra("get_lat", -85.0F));
    localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("get_lng", paramIntent.getFloatExtra("get_lng", -1000.0F));
    localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("get_poi_address", Util.nullAsNil(paramIntent.getStringExtra("get_poi_address")));
    localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("get_poi_classify_id", Util.nullAsNil(paramIntent.getStringExtra("get_poi_classify_id")));
    AppMethodBeat.o(253246);
  }
  
  public final void c(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(253241);
    p.h(paramIntent, "intent");
    p.h(paramBundle, "postData");
    this.intent = paramIntent;
    this.vUI = paramBundle;
    paramIntent = this.vUP;
    if (paramIntent != null) {
      paramIntent.setVisibility(8);
    }
    this.vUO.setLocationName(this.activity.getString(2131760241));
    this.vUO.setOnClickLocationListener((b.a)new a(this));
    dBu();
    AppMethodBeat.o(253241);
  }
  
  public final void dBu()
  {
    AppMethodBeat.i(253242);
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      p.btv("intent");
    }
    if (!((Intent)localObject1).getBooleanExtra("saveLocation", false))
    {
      Log.i(this.TAG, "refreshLocationView no location data, return");
      AppMethodBeat.o(253242);
      return;
    }
    this.isLoading = false;
    dBv();
    localObject1 = new axt();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((axt)localObject1).kHV = Util.nullAs(((Intent)localObject2).getStringExtra("get_poi_name"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((axt)localObject1).fuK = Util.nullAs(((Intent)localObject2).getStringExtra("get_city"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((axt)localObject1).latitude = ((Intent)localObject2).getFloatExtra("get_lat", -85.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((axt)localObject1).dTj = ((Intent)localObject2).getFloatExtra("get_lng", -1000.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((axt)localObject1).ErZ = Util.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_address"));
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.btv("intent");
    }
    ((axt)localObject1).LIb = Util.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_classify_id"));
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    if (!FinderGlobalLocationVM.dHO()) {
      ((axt)localObject1).source = 1;
    }
    this.vUM = ((axt)localObject1);
    Object localObject3 = this.vUM;
    if (localObject3 != null)
    {
      localObject1 = this.vUI;
      if (localObject1 == null) {
        p.btv("postData");
      }
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
      ((Bundle)localObject1).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.dIY(), ((axt)localObject3).toByteArray());
      if ((Util.isNullOrNil(((axt)localObject3).kHV)) && (Util.isNullOrNil(((axt)localObject3).fuK))) {
        break label379;
      }
      b localb = this.vUO;
      localObject2 = ((axt)localObject3).fuK;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((axt)localObject3).kHV;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localb.gM((String)localObject1, (String)localObject2);
    }
    for (;;)
    {
      dBw();
      AppMethodBeat.o(253242);
      return;
      label379:
      this.vUO.diy();
    }
  }
  
  public final void dix()
  {
    AppMethodBeat.i(253245);
    if (this.vUN)
    {
      AppMethodBeat.o(253245);
      return;
    }
    this.isLoading = true;
    this.vUO.dix();
    AppMethodBeat.o(253245);
  }
  
  public final void diy()
  {
    AppMethodBeat.i(253244);
    this.isLoading = false;
    this.vUN = true;
    this.vUO.diy();
    AppMethodBeat.o(253244);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClickLocationView"})
  static final class a
    implements b.a
  {
    a(c paramc) {}
    
    public final void dBx()
    {
      float f2 = 0.0F;
      AppMethodBeat.i(253240);
      Intent localIntent = new Intent();
      localIntent.putExtra("near_life_scene", 6);
      Object localObject = this.vUR.vUM;
      if (localObject != null) {}
      for (float f1 = ((axt)localObject).latitude;; f1 = 0.0F)
      {
        localIntent.putExtra("get_lat", f1);
        localObject = this.vUR.vUM;
        f1 = f2;
        if (localObject != null) {
          f1 = ((axt)localObject).dTj;
        }
        localIntent.putExtra("get_lng", f1);
        localObject = this.vUR.vUM;
        String str;
        if (localObject != null)
        {
          str = ((axt)localObject).LIb;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_poi_classify_id", (String)localObject);
        localObject = this.vUR.vUM;
        if (localObject != null)
        {
          str = ((axt)localObject).fuK;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_city", (String)localObject);
        com.tencent.mm.br.c.b((Context)this.vUR.activity, "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, this.vUR.lxP);
        AppMethodBeat.o(253240);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.c
 * JD-Core Version:    0.7.0.1
 */