package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.finder.widget.post.a;
import com.tencent.mm.pluginsdk.location.LocationView;
import com.tencent.mm.pluginsdk.location.LocationView.a;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locationView", "Lcom/tencent/mm/pluginsdk/location/LocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/LocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "hasSet", "", "getHasSet", "()Z", "setHasSet", "(Z)V", "intent", "Landroid/content/Intent;", "isLoading", "setLoading", "getLocationView", "()Lcom/tencent/mm/pluginsdk/location/LocationView;", "getPoiTipsLayout", "()Landroid/view/View;", "getPoiTipsTv", "()Landroid/widget/TextView;", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "canPost", "hidePoiTips", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "setDefaultState", "setLoadingState", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "city", "lbsLife", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"})
public final class b
{
  private final String TAG;
  public final MMActivity activity;
  public Intent intent;
  public boolean isLoading;
  final int kqK;
  private final TextView sKA;
  public Bundle sKs;
  public aoy sKw;
  public boolean sKx;
  public final LocationView sKy;
  public final View sKz;
  
  public b(MMActivity paramMMActivity, LocationView paramLocationView, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(204393);
    this.activity = paramMMActivity;
    this.sKy = paramLocationView;
    this.sKz = paramView;
    this.sKA = paramTextView;
    this.kqK = paramInt;
    this.TAG = "Finder.FinderLocationWidget";
    AppMethodBeat.o(204393);
  }
  
  private void cKX()
  {
    AppMethodBeat.i(204392);
    this.sKz.setVisibility(8);
    AppMethodBeat.o(204392);
  }
  
  public final void cKW()
  {
    AppMethodBeat.i(204391);
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      p.bcb("intent");
    }
    if (!((Intent)localObject1).getBooleanExtra("saveLocation", false))
    {
      ad.i(this.TAG, "refreshLocationView no location data, return");
      AppMethodBeat.o(204391);
      return;
    }
    this.isLoading = false;
    cKX();
    localObject1 = new aoy();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      p.bcb("intent");
    }
    ((aoy)localObject1).jDf = bt.bI(((Intent)localObject2).getStringExtra("get_poi_name"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bcb("intent");
    }
    ((aoy)localObject1).ePv = bt.bI(((Intent)localObject2).getStringExtra("get_city"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bcb("intent");
    }
    ((aoy)localObject1).dyz = ((Intent)localObject2).getFloatExtra("get_lat", -85.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bcb("intent");
    }
    ((aoy)localObject1).dAp = ((Intent)localObject2).getFloatExtra("get_lng", -1000.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bcb("intent");
    }
    ((aoy)localObject1).zSk = bt.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_address"));
    localObject2 = this.intent;
    if (localObject2 == null) {
      p.bcb("intent");
    }
    ((aoy)localObject1).Gnu = bt.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_classify_id"));
    this.sKw = ((aoy)localObject1);
    Object localObject3 = this.sKw;
    if (localObject3 != null)
    {
      localObject1 = this.sKs;
      if (localObject1 == null) {
        p.bcb("postData");
      }
      localObject2 = a.tez;
      ((Bundle)localObject1).putByteArray(a.cOH(), ((aoy)localObject3).toByteArray());
      if ((!bt.isNullOrNil(((aoy)localObject3).jDf)) || (!bt.isNullOrNil(((aoy)localObject3).ePv)))
      {
        LocationView localLocationView = this.sKy;
        localObject2 = ((aoy)localObject3).ePv;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((aoy)localObject3).jDf;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localLocationView.lq((String)localObject1, (String)localObject2);
        AppMethodBeat.o(204391);
        return;
      }
      this.sKy.eZe();
      AppMethodBeat.o(204391);
      return;
    }
    AppMethodBeat.o(204391);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClickLocationView"})
  public static final class a
    implements LocationView.a
  {
    public a(b paramb) {}
    
    public final void cKY()
    {
      float f2 = 0.0F;
      AppMethodBeat.i(204390);
      Intent localIntent = new Intent();
      localIntent.putExtra("near_life_scene", 6);
      Object localObject = this.sKB.sKw;
      if (localObject != null) {}
      for (float f1 = ((aoy)localObject).dyz;; f1 = 0.0F)
      {
        localIntent.putExtra("get_lat", f1);
        localObject = this.sKB.sKw;
        f1 = f2;
        if (localObject != null) {
          f1 = ((aoy)localObject).dAp;
        }
        localIntent.putExtra("get_lng", f1);
        localObject = this.sKB.sKw;
        String str;
        if (localObject != null)
        {
          str = ((aoy)localObject).Gnu;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_poi_classify_id", (String)localObject);
        localObject = this.sKB.sKw;
        if (localObject != null)
        {
          str = ((aoy)localObject).ePv;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localIntent.putExtra("get_city", (String)localObject);
        d.b((Context)this.sKB.activity, "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, this.sKB.kqK);
        AppMethodBeat.o(204390);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.b
 * JD-Core Version:    0.7.0.1
 */