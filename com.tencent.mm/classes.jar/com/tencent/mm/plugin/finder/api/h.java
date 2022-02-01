package com.tencent.mm.plugin.finder.api;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/IFinderLocationWidget;", "Lcom/tencent/mm/ui/component/ApiInstance;", "Lcom/tencent/mm/plugin/finder/api/IFinderPostWidget;", "getLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getLocationView", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "init", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "locView", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "refreshLocationView", "saveLocationData", "i", "Landroid/content/Intent;", "city", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "longitude", "", "latitude", "setDefaultState", "setLoadingState", "setLocation", "location", "trySuggestLocation", "lbsLife", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
  extends i, com.tencent.mm.ui.component.b
{
  public abstract void a(MMActivity paramMMActivity, com.tencent.mm.pluginsdk.location.b paramb, View paramView, TextView paramTextView);
  
  public abstract void a(String paramString, dgz paramdgz);
  
  public abstract void a(String paramString, dgz paramdgz, float paramFloat1, float paramFloat2);
  
  public abstract void ar(Intent paramIntent);
  
  public abstract com.tencent.mm.pluginsdk.location.b dUk();
  
  public abstract void dUl();
  
  public abstract void dUm();
  
  public abstract void dUn();
  
  public abstract void dUo();
  
  public abstract boi getLocation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.h
 * JD-Core Version:    0.7.0.1
 */