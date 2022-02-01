package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.finder.widget.post.a;
import com.tencent.mm.pluginsdk.location.LocationView;
import com.tencent.mm.pluginsdk.location.LocationView.a;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locationView", "Lcom/tencent/mm/pluginsdk/location/LocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/LocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "hasSet", "", "getHasSet", "()Z", "setHasSet", "(Z)V", "intent", "Landroid/content/Intent;", "isLoading", "setLoading", "getLocationView", "()Lcom/tencent/mm/pluginsdk/location/LocationView;", "getPoiTipsLayout", "()Landroid/view/View;", "getPoiTipsTv", "()Landroid/widget/TextView;", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "canPost", "hidePoiTips", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "setDefaultState", "setLoadingState", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "city", "lbsLife", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"})
public final class b
{
  private final String TAG;
  public final MMActivity activity;
  public Intent intent;
  public boolean isLoading;
  final int ktZ;
  public Bundle sVF;
  public apl sVJ;
  public boolean sVK;
  public final LocationView sVL;
  public final View sVM;
  private final TextView sVN;
  
  public b(MMActivity paramMMActivity, LocationView paramLocationView, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(205011);
    this.activity = paramMMActivity;
    this.sVL = paramLocationView;
    this.sVM = paramView;
    this.sVN = paramTextView;
    this.ktZ = paramInt;
    this.TAG = "Finder.FinderLocationWidget";
    AppMethodBeat.o(205011);
  }
  
  private void cNB()
  {
    AppMethodBeat.i(205010);
    this.sVM.setVisibility(8);
    AppMethodBeat.o(205010);
  }
  
  public final void cNA()
  {
    AppMethodBeat.i(205009);
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      p.bdF("intent");
    }
    if (!((Intent)localObject1).getBooleanExtra("saveLocation", false))
    {
      ae.i(this.TAG, "refreshLocationView no location data, return");
      AppMethodBeat.o(205009);
      return;
    }
    this.isLoading = false;
    cNB();
    localObject1 = new apl();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      p.bdF("intent");
    }
    ((apl)localObject1).jGd = bu.bI(((Intent)localObject2).getStringExtra("get_poi_name"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bdF("intent");
    }
    ((apl)localObject1).eRg = bu.bI(((Intent)localObject2).getStringExtra("get_city"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bdF("intent");
    }
    ((apl)localObject1).dzE = ((Intent)localObject2).getFloatExtra("get_lat", -85.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bdF("intent");
    }
    ((apl)localObject1).dBu = ((Intent)localObject2).getFloatExtra("get_lng", -1000.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bdF("intent");
    }
    ((apl)localObject1).Ajr = bu.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_address"));
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bdF("intent");
    }
    ((apl)localObject1).GGA = bu.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_classify_id"));
    this.sVJ = ((apl)localObject1);
    Object localObject3 = this.sVJ;
    if (localObject3 != null)
    {
      localObject1 = this.sVF;
      if (localObject1 == null) {
        p.bdF("postData");
      }
      localObject2 = a.tps;
      ((Bundle)localObject1).putByteArray(a.cRm(), ((apl)localObject3).toByteArray());
      if ((!bu.isNullOrNil(((apl)localObject3).jGd)) || (!bu.isNullOrNil(((apl)localObject3).eRg)))
      {
        LocationView localLocationView = this.sVL;
        localObject2 = ((apl)localObject3).eRg;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((apl)localObject3).jGd;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localLocationView.lx((String)localObject1, (String)localObject2);
        AppMethodBeat.o(205009);
        return;
      }
      this.sVL.fcS();
      AppMethodBeat.o(205009);
      return;
    }
    AppMethodBeat.o(205009);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onClickLocationView"})
  public static final class a
    implements LocationView.a
  {
    public a(b paramb) {}
    
    public final void cNC()
    {
      float f2 = 0.0F;
      AppMethodBeat.i(205008);
      Intent localIntent = new Intent();
      localIntent.putExtra("near_life_scene", 6);
      Object localObject = this.sVO.sVJ;
      if (localObject != null) {}
      for (float f1 = ((apl)localObject).dzE;; f1 = 0.0F)
      {
        localIntent.putExtra("get_lat", f1);
        localObject = this.sVO.sVJ;
        f1 = f2;
        if (localObject != null) {
          f1 = ((apl)localObject).dBu;
        }
        localIntent.putExtra("get_lng", f1);
        localObject = this.sVO.sVJ;
        String str;
        if (localObject != null)
        {
          str = ((apl)localObject).GGA;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_poi_classify_id", (String)localObject);
        localObject = this.sVO.sVJ;
        if (localObject != null)
        {
          str = ((apl)localObject).eRg;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_city", (String)localObject);
        d.b((Context)this.sVO.activity, "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, this.sVO.ktZ);
        AppMethodBeat.o(205008);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.b
 * JD-Core Version:    0.7.0.1
 */