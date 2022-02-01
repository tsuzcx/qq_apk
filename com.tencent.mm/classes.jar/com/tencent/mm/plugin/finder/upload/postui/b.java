package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.widget.post.a;
import com.tencent.mm.pluginsdk.location.LocationView;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locationView", "Lcom/tencent/mm/pluginsdk/location/LocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/LocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "intent", "Landroid/content/Intent;", "isLoading", "", "()Z", "setLoading", "(Z)V", "getLocationView", "()Lcom/tencent/mm/pluginsdk/location/LocationView;", "getPoiTipsLayout", "()Landroid/view/View;", "getPoiTipsTv", "()Landroid/widget/TextView;", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "canPost", "hidePoiTips", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "setDefaultState", "setLoadingState", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "city", "lbsLife", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"})
public final class b
{
  private final String TAG;
  public final MMActivity activity;
  public Intent intent;
  public boolean isLoading;
  final int jWt;
  public Bundle rOl;
  public alt rOp;
  public final LocationView rOq;
  public final View rOr;
  private final TextView rOs;
  
  public b(MMActivity paramMMActivity, LocationView paramLocationView, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(203550);
    this.activity = paramMMActivity;
    this.rOq = paramLocationView;
    this.rOr = paramView;
    this.rOs = paramTextView;
    this.jWt = paramInt;
    this.TAG = "Finder.FinderLocationWidget";
    AppMethodBeat.o(203550);
  }
  
  private void cCJ()
  {
    AppMethodBeat.i(203549);
    this.rOr.setVisibility(8);
    AppMethodBeat.o(203549);
  }
  
  public final void cCI()
  {
    AppMethodBeat.i(203548);
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      k.aVY("intent");
    }
    if (!((Intent)localObject1).getBooleanExtra("saveLocation", false))
    {
      ac.i(this.TAG, "refreshLocationView no location data, return");
      AppMethodBeat.o(203548);
      return;
    }
    this.isLoading = false;
    cCJ();
    localObject1 = new alt();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      k.aVY("intent");
    }
    ((alt)localObject1).gPy = bs.bG(((Intent)localObject2).getStringExtra("get_poi_name"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aVY("intent");
    }
    ((alt)localObject1).exW = bs.bG(((Intent)localObject2).getStringExtra("get_city"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aVY("intent");
    }
    ((alt)localObject1).dmL = ((Intent)localObject2).getFloatExtra("get_lat", -85.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aVY("intent");
    }
    ((alt)localObject1).doB = ((Intent)localObject2).getFloatExtra("get_lng", -1000.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aVY("intent");
    }
    ((alt)localObject1).yAV = bs.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_address"));
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aVY("intent");
    }
    ((alt)localObject1).EFm = bs.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_classify_id"));
    this.rOp = ((alt)localObject1);
    Object localObject3 = this.rOp;
    if (localObject3 != null)
    {
      localObject1 = this.rOl;
      if (localObject1 == null) {
        k.aVY("postData");
      }
      localObject2 = a.sid;
      ((Bundle)localObject1).putByteArray(a.cGu(), ((alt)localObject3).toByteArray());
      if ((!bs.isNullOrNil(((alt)localObject3).gPy)) || (!bs.isNullOrNil(((alt)localObject3).exW)))
      {
        LocationView localLocationView = this.rOq;
        localObject2 = ((alt)localObject3).exW;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((alt)localObject3).gPy;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localLocationView.kT((String)localObject1, (String)localObject2);
        AppMethodBeat.o(203548);
        return;
      }
      this.rOq.eKq();
      AppMethodBeat.o(203548);
      return;
    }
    AppMethodBeat.o(203548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.b
 * JD-Core Version:    0.7.0.1
 */