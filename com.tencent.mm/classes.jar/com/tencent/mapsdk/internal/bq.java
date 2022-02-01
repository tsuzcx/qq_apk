package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider.Builder;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public abstract class bq
  extends bm
{
  public bq(Context paramContext, TencentMapOptions paramTencentMapOptions, bn parambn)
  {
    super(paramContext, paramTencentMapOptions, parambn);
  }
  
  public IAlphaAnimation createAlphaAnimation(float paramFloat1, float paramFloat2)
  {
    return new hc(paramFloat1, paramFloat2);
  }
  
  public IAnimationSet createAnimationSet(boolean paramBoolean)
  {
    return new he(paramBoolean);
  }
  
  public IEmergeAnimation createEmergeAnimation(LatLng paramLatLng)
  {
    return new hf(paramLatLng);
  }
  
  public HeatMapTileProvider createHeatMapTileProvider(HeatMapTileProvider.Builder paramBuilder)
  {
    return new bu(paramBuilder);
  }
  
  public IRotateAnimation createRotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return new hg(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
  }
  
  public IScaleAnimation createScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new hh(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public ITranslateAnimation createTranslateAnimation(LatLng paramLatLng)
  {
    return new hi(paramLatLng);
  }
  
  protected final void p() {}
  
  public final String x()
  {
    return "4.4.7.7";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bq
 * JD-Core Version:    0.7.0.1
 */