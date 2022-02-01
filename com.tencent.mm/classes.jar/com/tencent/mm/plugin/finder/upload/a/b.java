package com.tencent.mm.plugin.finder.upload.a;

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
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locationView", "Lcom/tencent/mm/pluginsdk/location/LocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/LocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "intent", "Landroid/content/Intent;", "isLoading", "", "()Z", "setLoading", "(Z)V", "getLocationView", "()Lcom/tencent/mm/pluginsdk/location/LocationView;", "getPoiTipsLayout", "()Landroid/view/View;", "getPoiTipsTv", "()Landroid/widget/TextView;", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "canPost", "hidePoiTips", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "setDefaultState", "setLoadingState", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "city", "lbsLife", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"})
public final class b
{
  public Bundle Lau;
  public ajq Law;
  public final LocationView Lax;
  public final View Lay;
  private final TextView Laz;
  private final String TAG;
  public final MMActivity activity;
  public Intent intent;
  public boolean isLoading;
  final int jvX;
  
  public b(MMActivity paramMMActivity, LocationView paramLocationView, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(199574);
    this.activity = paramMMActivity;
    this.Lax = paramLocationView;
    this.Lay = paramView;
    this.Laz = paramTextView;
    this.jvX = paramInt;
    this.TAG = "Finder.FinderLocationWidget";
    AppMethodBeat.o(199574);
  }
  
  private void fVN()
  {
    AppMethodBeat.i(199573);
    this.Lay.setVisibility(8);
    AppMethodBeat.o(199573);
  }
  
  public final void fVM()
  {
    AppMethodBeat.i(199572);
    Object localObject1 = this.intent;
    if (localObject1 == null) {
      k.aPZ("intent");
    }
    if (!((Intent)localObject1).getBooleanExtra("saveLocation", false))
    {
      ad.i(this.TAG, "refreshLocationView no location data, return");
      AppMethodBeat.o(199572);
      return;
    }
    this.isLoading = false;
    fVN();
    localObject1 = new ajq();
    Object localObject2 = this.intent;
    if (localObject2 == null) {
      k.aPZ("intent");
    }
    ((ajq)localObject1).goQ = bt.by(((Intent)localObject2).getStringExtra("get_poi_name"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aPZ("intent");
    }
    ((ajq)localObject1).evA = bt.by(((Intent)localObject2).getStringExtra("get_city"), "");
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aPZ("intent");
    }
    ((ajq)localObject1).dpb = ((Intent)localObject2).getFloatExtra("get_lat", -85.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aPZ("intent");
    }
    ((ajq)localObject1).dqQ = ((Intent)localObject2).getFloatExtra("get_lng", -1000.0F);
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aPZ("intent");
    }
    ((ajq)localObject1).xoe = bt.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_address"));
    localObject2 = this.intent;
    if (localObject2 == null) {
      k.aPZ("intent");
    }
    ((ajq)localObject1).DlE = bt.nullAsNil(((Intent)localObject2).getStringExtra("get_poi_classify_id"));
    this.Law = ((ajq)localObject1);
    Object localObject3 = this.Law;
    if (localObject3 != null)
    {
      localObject1 = this.Lau;
      if (localObject1 == null) {
        k.aPZ("postData");
      }
      localObject2 = a.qZZ;
      ((Bundle)localObject1).putByteArray(a.ctq(), ((ajq)localObject3).toByteArray());
      if ((!bt.isNullOrNil(((ajq)localObject3).goQ)) || (!bt.isNullOrNil(((ajq)localObject3).evA)))
      {
        LocationView localLocationView = this.Lax;
        localObject2 = ((ajq)localObject3).evA;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((ajq)localObject3).goQ;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localLocationView.mX((String)localObject1, (String)localObject2);
        AppMethodBeat.o(199572);
        return;
      }
      this.Lax.fZF();
      AppMethodBeat.o(199572);
      return;
    }
    AppMethodBeat.o(199572);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onClickLocationView"})
  public static final class a
    implements LocationView.a
  {
    public a(b paramb) {}
    
    public final void crt()
    {
      float f2 = 0.0F;
      AppMethodBeat.i(199571);
      Intent localIntent = new Intent();
      localIntent.putExtra("near_life_scene", 6);
      ajq localajq = this.LaA.Law;
      if (localajq != null) {}
      for (float f1 = localajq.dpb;; f1 = 0.0F)
      {
        localIntent.putExtra("get_lat", f1);
        localajq = this.LaA.Law;
        f1 = f2;
        if (localajq != null) {
          f1 = localajq.dqQ;
        }
        localIntent.putExtra("get_lng", f1);
        d.b((Context)this.LaA.activity, "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, this.LaA.jvX);
        AppMethodBeat.o(199571);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a.b
 * JD-Core Version:    0.7.0.1
 */