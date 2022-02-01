package com.e.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public final class l
{
  public static com.tencent.mapsdk.raster.model.CameraPosition a(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(206068);
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(206068);
      return null;
    }
    paramCameraPosition = new com.tencent.mapsdk.raster.model.CameraPosition(a(paramCameraPosition.target), paramCameraPosition.zoom, paramCameraPosition.tilt, paramCameraPosition.bearing);
    AppMethodBeat.o(206068);
    return paramCameraPosition;
  }
  
  public static com.tencent.mapsdk.raster.model.LatLng a(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(206064);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(206064);
      return null;
    }
    paramLatLng = new com.tencent.mapsdk.raster.model.LatLng(paramLatLng.latitude, paramLatLng.longitude);
    AppMethodBeat.o(206064);
    return paramLatLng;
  }
  
  static com.tencent.tencentmap.mapsdk.maps.CameraUpdate a(com.tencent.tencentmap.mapsdk.map.CameraUpdate paramCameraUpdate, TencentMap paramTencentMap)
  {
    AppMethodBeat.i(206071);
    if ((paramCameraUpdate == null) || (paramCameraUpdate.getParams() == null))
    {
      AppMethodBeat.o(206071);
      return null;
    }
    CameraParameter localCameraParameter = paramCameraUpdate.getParams();
    int j;
    int i;
    int m;
    int k;
    switch (paramCameraUpdate.getParams().cameraUpdate_type)
    {
    default: 
      AppMethodBeat.o(206071);
      return null;
    case 6: 
      paramCameraUpdate = CameraUpdateFactory.newCameraPosition(a(localCameraParameter.newCameraPosition));
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
    case 7: 
      paramCameraUpdate = CameraUpdateFactory.newLatLng(c(localCameraParameter.newLatLng));
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
    case 9: 
      paramCameraUpdate = CameraUpdateFactory.newLatLngBounds(a(localCameraParameter.newLatLngBounds_bounds), localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
    case 10: 
      if ((paramTencentMap != null) && (paramTencentMap.getMapWidth() != 0) && (paramTencentMap.getMapWidth() != 0)) {
        if (localCameraParameter.newLatLngBounds_dimension_width < paramTencentMap.getMapWidth())
        {
          j = paramTencentMap.getMapWidth() / 2 - (localCameraParameter.newLatLngBounds_dimension_width / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
          i = j;
          if (localCameraParameter.newLatLngBounds_dimension_height < paramTencentMap.getMapHeight())
          {
            m = paramTencentMap.getMapHeight() / 2 - (localCameraParameter.newLatLngBounds_dimension_height / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
            k = m;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsRect(a(localCameraParameter.newLatLngBounds_dimension_bounds), i, j, m, k);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.newLatLngZoom(c(localCameraParameter.newLatLngZoom_latlng), localCameraParameter.newLatLngZoom_zoom);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.scrollBy(localCameraParameter.scrollBy_xPixel, localCameraParameter.scrollBy_yPixel);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomBy(localCameraParameter.zoomBy_Point_amount, localCameraParameter.zoomBy_Point_focus);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomBy(localCameraParameter.zoomBy_amount);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomIn();
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomOut();
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      float f;
      if (localCameraParameter.zoomTo_zoom < paramTencentMap.getMinZoomLevel()) {
        f = paramTencentMap.getMinZoomLevel();
      }
      for (;;)
      {
        paramCameraUpdate = CameraUpdateFactory.zoomTo(f);
        AppMethodBeat.o(206071);
        return paramCameraUpdate;
        if (localCameraParameter.zoomTo_zoom > paramTencentMap.getMaxZoomLevel()) {
          f = paramTencentMap.getMaxZoomLevel();
        } else {
          f = localCameraParameter.zoomTo_zoom;
        }
      }
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsWithMapCenter(a(localCameraParameter.newLatLngBounds_bounds), c(localCameraParameter.newLatLng), localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsRect(a(localCameraParameter.newLatLngBounds_dimension_bounds), localCameraParameter.newLatLngBoundsRects_padLeft, localCameraParameter.newLatLngBoundsRects_padRight, localCameraParameter.newLatLngBoundsRects_padTop, localCameraParameter.newLatLngBoundsRects_padBom);
      AppMethodBeat.o(206071);
      return paramCameraUpdate;
      k = 0;
      m = 0;
      continue;
      i = 0;
      j = 0;
      break;
      k = 0;
      i = 0;
      m = 0;
      j = 0;
    }
  }
  
  private static com.tencent.tencentmap.mapsdk.maps.model.CameraPosition a(com.tencent.mapsdk.raster.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(206067);
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(206067);
      return null;
    }
    paramCameraPosition = new com.tencent.tencentmap.mapsdk.maps.model.CameraPosition(c(paramCameraPosition.getTarget()), paramCameraPosition.getZoom(), paramCameraPosition.getSkew(), paramCameraPosition.getBearing());
    AppMethodBeat.o(206067);
    return paramCameraPosition;
  }
  
  static com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo a(com.tencent.mapsdk.raster.model.IndoorInfo paramIndoorInfo)
  {
    AppMethodBeat.i(206072);
    if (paramIndoorInfo == null)
    {
      AppMethodBeat.o(206072);
      return null;
    }
    paramIndoorInfo = new com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo(paramIndoorInfo.getBuildingId(), paramIndoorInfo.getFloorName());
    AppMethodBeat.o(206072);
    return paramIndoorInfo;
  }
  
  private static com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds a(com.tencent.mapsdk.raster.model.LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(206069);
    if ((paramLatLngBounds == null) || (paramLatLngBounds.getNortheast() == null) || (paramLatLngBounds.getSouthwest() == null))
    {
      AppMethodBeat.o(206069);
      return null;
    }
    paramLatLngBounds = new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLngBounds.getSouthwest().getLatitude(), paramLatLngBounds.getSouthwest().getLongitude()), new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLngBounds.getNortheast().getLatitude(), paramLatLngBounds.getNortheast().getLongitude()));
    AppMethodBeat.o(206069);
    return paramLatLngBounds;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions a(com.tencent.mapsdk.raster.model.PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(206070);
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(206070);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions localPolylineOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions();
    Object localObject = iH(paramPolylineOptions.getPoints());
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      AppMethodBeat.o(206070);
      return null;
    }
    localPolylineOptions.addAll((Iterable)localObject);
    float f = paramPolylineOptions.getWidth();
    localPolylineOptions.zIndex((int)paramPolylineOptions.getZIndex()).level(paramPolylineOptions.getLevel()).width(f).visible(paramPolylineOptions.isVisible()).color(paramPolylineOptions.getColor()).borderColor(paramPolylineOptions.getEdgeColor()).borderWidth(paramPolylineOptions.getEdgeWidth()).lineType(paramPolylineOptions.getLineType()).eraseColor(paramPolylineOptions.getEraseColor()).indoorInfo(a(paramPolylineOptions.getIndoorInfo()));
    if (paramPolylineOptions.getColorTexture() != null) {
      localPolylineOptions.colorTexture(BitmapDescriptorFactory.fromBitmap(paramPolylineOptions.getColorTexture().getBitmap()));
    }
    if (paramPolylineOptions.getArrowTexture() != null)
    {
      localPolylineOptions.arrow(true);
      localPolylineOptions.arrowSpacing((int)paramPolylineOptions.getArrowGap());
      localObject = new Matrix();
      ((Matrix)localObject).postRotate(-90.0F);
    }
    try
    {
      Bitmap localBitmap = paramPolylineOptions.getArrowTexture().getBitmap();
      localBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth(), localBitmap.getHeight(), true);
      localPolylineOptions.arrowTexture(BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true)));
      label254:
      if (paramPolylineOptions.isDottedLine())
      {
        localObject = new ArrayList();
        ((List)localObject).add(Integer.valueOf((int)(3.0F * paramPolylineOptions.getWidth())));
        ((List)localObject).add(Integer.valueOf((int)paramPolylineOptions.getWidth()));
        localPolylineOptions.pattern((List)localObject);
      }
      if (paramPolylineOptions.getColors() != null) {
        localPolylineOptions.colors(paramPolylineOptions.getColors()[0], paramPolylineOptions.getColors()[1]);
      }
      AppMethodBeat.o(206070);
      return localPolylineOptions;
    }
    catch (Exception localException)
    {
      break label254;
    }
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.LatLng c(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(206063);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(206063);
      return null;
    }
    paramLatLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude());
    AppMethodBeat.o(206063);
    return paramLatLng;
  }
  
  public static List<com.tencent.mapsdk.raster.model.LatLng> iG(List<com.tencent.tencentmap.mapsdk.maps.model.LatLng> paramList)
  {
    AppMethodBeat.i(206065);
    if (paramList == null)
    {
      AppMethodBeat.o(206065);
      return null;
    }
    paramList = (com.tencent.tencentmap.mapsdk.maps.model.LatLng[])paramList.toArray(new com.tencent.tencentmap.mapsdk.maps.model.LatLng[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(206065);
    return localArrayList;
  }
  
  public static List<com.tencent.tencentmap.mapsdk.maps.model.LatLng> iH(List<com.tencent.mapsdk.raster.model.LatLng> paramList)
  {
    AppMethodBeat.i(206066);
    if (paramList == null)
    {
      AppMethodBeat.o(206066);
      return null;
    }
    paramList = (com.tencent.mapsdk.raster.model.LatLng[])paramList.toArray(new com.tencent.mapsdk.raster.model.LatLng[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(c(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(206066);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */