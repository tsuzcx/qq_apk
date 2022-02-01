package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapNavi;
import com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.List;

public final class rs
  extends VectorMap
  implements TencentMapNavi
{
  public rs(mk parammk)
  {
    super(parammk);
  }
  
  public final IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions paramIntersectionOverlayOptions)
  {
    AppMethodBeat.i(223900);
    paramIntersectionOverlayOptions = getMapPro().addIntersectionEnlargeOverlay(paramIntersectionOverlayOptions);
    AppMethodBeat.o(223900);
    return paramIntersectionOverlayOptions;
  }
  
  public final void addSegmentsWithRouteName(List<MapRouteSection> paramList, List<LatLng> paramList1)
  {
    AppMethodBeat.i(223848);
    getMapPro().addSegmentsWithRouteName(paramList, paramList1);
    AppMethodBeat.o(223848);
  }
  
  public final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(223726);
    getMapPro().animateToNaviPosition(paramLatLng, paramFloat1, paramFloat2);
    AppMethodBeat.o(223726);
  }
  
  public final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(223733);
    getMapPro().animateToNaviPosition(paramLatLng, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(223733);
  }
  
  public final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    AppMethodBeat.i(223743);
    getMapPro().animateToNaviPosition(paramLatLng, paramFloat1, paramFloat2, paramFloat3, paramBoolean);
    AppMethodBeat.o(223743);
  }
  
  public final void animateToNaviPosition2(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    AppMethodBeat.i(223753);
    getMapPro().animateToNaviPosition2(paramLatLng, paramFloat1, paramFloat2, paramFloat3, paramBoolean);
    AppMethodBeat.o(223753);
  }
  
  public final float calNaviLevel(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(223765);
    paramFloat = getMapPro().calNaviLevel(paramLatLngBounds, paramFloat, paramInt, paramBoolean);
    AppMethodBeat.o(223765);
    return paramFloat;
  }
  
  public final float calNaviLevel2(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(223774);
    paramFloat1 = getMapPro().calNaviLevel2(paramLatLng1, paramLatLng2, paramFloat1, paramFloat2, paramInt, paramBoolean);
    AppMethodBeat.o(223774);
    return paramFloat1;
  }
  
  public final float calNaviLevel3(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(223784);
    paramFloat = getMapPro().calNaviLevel3(paramLatLng1, paramLatLng2, paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    AppMethodBeat.o(223784);
    return paramFloat;
  }
  
  public final CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback)
  {
    AppMethodBeat.i(223831);
    paramList = getMapPro().calculateZoomToSpanLevelAsync(paramList, paramList1, paramInt1, paramInt2, paramInt3, paramInt4, paramAsyncOperateCallback);
    AppMethodBeat.o(223831);
    return paramList;
  }
  
  public final void clearRouteNameSegments()
  {
    AppMethodBeat.i(223812);
    getMapPro().clearRouteNameSegments();
    AppMethodBeat.o(223812);
  }
  
  public final boolean isNaviStateEnabled()
  {
    AppMethodBeat.i(223876);
    boolean bool = getMapPro().isNaviStateEnabled();
    AppMethodBeat.o(223876);
    return bool;
  }
  
  public final void moveToNavPosition(CameraUpdate paramCameraUpdate, LatLng paramLatLng)
  {
    AppMethodBeat.i(223818);
    getMapPro().moveToNavPosition(paramCameraUpdate, paramLatLng);
    AppMethodBeat.o(223818);
  }
  
  public final void setNavCenter(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223858);
    getMapPro().setNavCenter(paramInt1, paramInt2);
    AppMethodBeat.o(223858);
  }
  
  public final void setNaviFixingProportion(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(223794);
    getMapPro().setNaviFixingProportion(paramFloat1, paramFloat2);
    AppMethodBeat.o(223794);
  }
  
  public final void setNaviFixingProportion2D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(223803);
    getMapPro().setNaviFixingProportion2D(paramFloat1, paramFloat2);
    AppMethodBeat.o(223803);
  }
  
  public final void setNaviStateEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223865);
    getMapPro().setNaviStateEnabled(paramBoolean);
    AppMethodBeat.o(223865);
  }
  
  public final void setOptionalResourcePath(String paramString)
  {
    AppMethodBeat.i(223887);
    getMapPro().setOptionalResourcePath(paramString);
    AppMethodBeat.o(223887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rs
 * JD-Core Version:    0.7.0.1
 */