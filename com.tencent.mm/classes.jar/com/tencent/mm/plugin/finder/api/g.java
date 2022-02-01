package com.tencent.mm.plugin.finder.api;

import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.c;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/IFinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/ApiUIC;", "checkLocationPermissionWithoutRequest", "", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "requestLocation", "isIgnoreConfig", "requestLocationPermissionWithAlert", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
  extends c
{
  public abstract r<Float, Float> dUh();
  
  public abstract boolean dUi();
  
  public abstract long dUj();
  
  public abstract void h(MMActivity paramMMActivity);
  
  public abstract boolean pH(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.g
 * JD-Core Version:    0.7.0.1
 */