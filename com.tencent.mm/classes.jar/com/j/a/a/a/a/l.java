package com.j.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.k.b;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.SegmentText;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text.Builder;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l
{
  public static com.tencent.mapsdk.raster.model.CameraPosition a(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(207105);
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(207105);
      return null;
    }
    paramCameraPosition = new com.tencent.mapsdk.raster.model.CameraPosition(d(paramCameraPosition.target), paramCameraPosition.zoom, paramCameraPosition.tilt, paramCameraPosition.bearing);
    AppMethodBeat.o(207105);
    return paramCameraPosition;
  }
  
  static com.tencent.tencentmap.mapsdk.maps.CameraUpdate a(com.tencent.tencentmap.mapsdk.map.CameraUpdate paramCameraUpdate, TencentMap paramTencentMap)
  {
    AppMethodBeat.i(207188);
    if ((paramCameraUpdate == null) || (paramCameraUpdate.getParams() == null))
    {
      AppMethodBeat.o(207188);
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
      AppMethodBeat.o(207188);
      return null;
    case 6: 
      paramCameraUpdate = CameraUpdateFactory.newCameraPosition(a(localCameraParameter.newCameraPosition));
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
    case 7: 
      paramCameraUpdate = CameraUpdateFactory.newLatLng(d(localCameraParameter.newLatLng));
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
    case 9: 
      paramCameraUpdate = CameraUpdateFactory.newLatLngBounds(a(localCameraParameter.newLatLngBounds_bounds), localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(207188);
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
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.newLatLngZoom(d(localCameraParameter.newLatLngZoom_latlng), localCameraParameter.newLatLngZoom_zoom);
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.scrollBy(localCameraParameter.scrollBy_xPixel, localCameraParameter.scrollBy_yPixel);
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomBy(localCameraParameter.zoomBy_Point_amount, localCameraParameter.zoomBy_Point_focus);
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomBy(localCameraParameter.zoomBy_amount);
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomIn();
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomOut();
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      float f;
      if (localCameraParameter.zoomTo_zoom < paramTencentMap.getMinZoomLevel()) {
        f = paramTencentMap.getMinZoomLevel();
      }
      for (;;)
      {
        paramCameraUpdate = CameraUpdateFactory.zoomTo(f);
        AppMethodBeat.o(207188);
        return paramCameraUpdate;
        if (localCameraParameter.zoomTo_zoom > paramTencentMap.getMaxZoomLevel()) {
          f = paramTencentMap.getMaxZoomLevel();
        } else {
          f = localCameraParameter.zoomTo_zoom;
        }
      }
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsWithMapCenter(a(localCameraParameter.newLatLngBounds_bounds), d(localCameraParameter.newLatLng), localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(207188);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsRect(a(localCameraParameter.newLatLngBounds_dimension_bounds), localCameraParameter.newLatLngBoundsRects_padLeft, localCameraParameter.newLatLngBoundsRects_padRight, localCameraParameter.newLatLngBoundsRects_padTop, localCameraParameter.newLatLngBoundsRects_padBom);
      AppMethodBeat.o(207188);
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
    AppMethodBeat.i(207089);
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(207089);
      return null;
    }
    paramCameraPosition = new com.tencent.tencentmap.mapsdk.maps.model.CameraPosition(d(paramCameraPosition.getTarget()), paramCameraPosition.getZoom(), paramCameraPosition.getSkew(), paramCameraPosition.getBearing());
    AppMethodBeat.o(207089);
    return paramCameraPosition;
  }
  
  static com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo a(com.tencent.mapsdk.raster.model.IndoorInfo paramIndoorInfo)
  {
    AppMethodBeat.i(207200);
    if (paramIndoorInfo == null)
    {
      AppMethodBeat.o(207200);
      return null;
    }
    paramIndoorInfo = new com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo(paramIndoorInfo.getBuildingId(), paramIndoorInfo.getFloorName());
    AppMethodBeat.o(207200);
    return paramIndoorInfo;
  }
  
  private static com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds a(com.tencent.mapsdk.raster.model.LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(207121);
    if ((paramLatLngBounds == null) || (paramLatLngBounds.getNortheast() == null) || (paramLatLngBounds.getSouthwest() == null))
    {
      AppMethodBeat.o(207121);
      return null;
    }
    paramLatLngBounds = new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLngBounds.getSouthwest().getLatitude(), paramLatLngBounds.getSouthwest().getLongitude()), new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLngBounds.getNortheast().getLatitude(), paramLatLngBounds.getNortheast().getLongitude()));
    AppMethodBeat.o(207121);
    return paramLatLngBounds;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions a(com.tencent.mapsdk.raster.model.PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(207167);
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(207167);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions localPolylineOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions();
    Object localObject1 = oD(paramPolylineOptions.getPoints());
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      AppMethodBeat.o(207167);
      return null;
    }
    localPolylineOptions.addAll((Iterable)localObject1);
    float f = paramPolylineOptions.getWidth();
    localPolylineOptions.zIndex((int)paramPolylineOptions.getZIndex()).level(paramPolylineOptions.getLevel()).width(f).visible(paramPolylineOptions.isVisible()).color(paramPolylineOptions.getColor()).borderColor(paramPolylineOptions.getEdgeColor()).borderWidth(paramPolylineOptions.getEdgeWidth()).lineType(paramPolylineOptions.getLineType()).eraseColor(paramPolylineOptions.getEraseColor()).indoorInfo(a(paramPolylineOptions.getIndoorInfo())).lineCap(paramPolylineOptions.lineCap()).gradient(paramPolylineOptions.isGradientEnable());
    if (paramPolylineOptions.getColorTexture() != null) {
      localPolylineOptions.colorTexture(BitmapDescriptorFactory.fromBitmap(paramPolylineOptions.getColorTexture().getBitmap()));
    }
    if (paramPolylineOptions.getArrowTexture() != null)
    {
      localPolylineOptions.arrow(true);
      localPolylineOptions.arrowSpacing((int)paramPolylineOptions.getArrowGap());
      localObject1 = new Matrix();
      ((Matrix)localObject1).postRotate(-90.0F);
    }
    try
    {
      Object localObject2 = paramPolylineOptions.getArrowTexture().getBitmap();
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), true);
      localPolylineOptions.arrowTexture(BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, true)));
      label268:
      if (paramPolylineOptions.isDottedLine())
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(Integer.valueOf((int)(3.0F * paramPolylineOptions.getWidth())));
        ((List)localObject1).add(Integer.valueOf((int)paramPolylineOptions.getWidth()));
        localPolylineOptions.pattern((List)localObject1);
      }
      if (paramPolylineOptions.getColors() != null) {
        localPolylineOptions.colors(paramPolylineOptions.getColors()[0], paramPolylineOptions.getColors()[1]);
      }
      if ((paramPolylineOptions.getTextStyle() != null) && (paramPolylineOptions.getSegmentTexts() != null) && (paramPolylineOptions.getSegmentTexts().size() > 0))
      {
        localObject1 = paramPolylineOptions.getTextStyle();
        localObject2 = new ArrayList();
        paramPolylineOptions = paramPolylineOptions.getSegmentTexts().iterator();
        while (paramPolylineOptions.hasNext())
        {
          b.k.a locala = (b.k.a)paramPolylineOptions.next();
          ((List)localObject2).add(new PolylineOptions.SegmentText(locala.startIndex, locala.endIndex, locala.name));
        }
        paramPolylineOptions = new PolylineOptions.Text.Builder((List)localObject2);
        paramPolylineOptions.color(((b.k.b)localObject1).textColor).size(((b.k.b)localObject1).fontSize).strokeColor(((b.k.b)localObject1).strokeColor);
        localPolylineOptions.text(paramPolylineOptions.build());
      }
      AppMethodBeat.o(207167);
      return localPolylineOptions;
    }
    catch (Exception localException)
    {
      break label268;
    }
  }
  
  public static com.tencent.mapsdk.raster.model.LatLng d(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207049);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(207049);
      return null;
    }
    paramLatLng = new com.tencent.mapsdk.raster.model.LatLng(paramLatLng.latitude, paramLatLng.longitude);
    AppMethodBeat.o(207049);
    return paramLatLng;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.LatLng d(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207040);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(207040);
      return null;
    }
    paramLatLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude());
    AppMethodBeat.o(207040);
    return paramLatLng;
  }
  
  public static List<com.tencent.mapsdk.raster.model.LatLng> oC(List<com.tencent.tencentmap.mapsdk.maps.model.LatLng> paramList)
  {
    AppMethodBeat.i(207062);
    if (paramList == null)
    {
      AppMethodBeat.o(207062);
      return null;
    }
    paramList = (com.tencent.tencentmap.mapsdk.maps.model.LatLng[])paramList.toArray(new com.tencent.tencentmap.mapsdk.maps.model.LatLng[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(d(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(207062);
    return localArrayList;
  }
  
  public static List<com.tencent.tencentmap.mapsdk.maps.model.LatLng> oD(List<com.tencent.mapsdk.raster.model.LatLng> paramList)
  {
    AppMethodBeat.i(207073);
    if (paramList == null)
    {
      AppMethodBeat.o(207073);
      return null;
    }
    paramList = (com.tencent.mapsdk.raster.model.LatLng[])paramList.toArray(new com.tencent.mapsdk.raster.model.LatLng[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(d(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(207073);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */