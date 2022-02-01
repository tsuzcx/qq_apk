package com.j.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.mapsdk.raster.model.UrlTileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i
  implements com.tencent.tencentmap.mapsdk.map.TencentMap, com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter, TencentMap.OnCameraChangeListener, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener, TencentMap.OnMapLoadedCallback, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener, com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener, TencentMap.OnMarkerDragListener
{
  private TencentMapGestureListener airA;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter airB;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter> airC;
  private TencentMap.OnMarkerDraggedListener airD;
  List<TencentMap.OnMarkerDraggedListener> airE;
  private TencentMap.OnMapLoadedListener airF;
  List<TencentMap.OnMapLoadedListener> airG;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener airH;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener> airI;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener airJ;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener> airK;
  private TencentMap.OnMapCameraChangeListener airL;
  List<TencentMap.OnMapCameraChangeListener> airM;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener airN;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener> airO;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener airP;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener> airQ;
  private HashMap<Integer, e> airx;
  List<com.tencent.tencentmap.mapsdk.maps.model.Marker> airy;
  private boolean airz;
  private com.tencent.tencentmap.mapsdk.maps.TencentMap mTencentMap;
  
  public i(com.tencent.tencentmap.mapsdk.maps.TencentMap paramTencentMap)
  {
    AppMethodBeat.i(207050);
    this.airx = new HashMap();
    this.airy = new ArrayList();
    this.airz = false;
    this.mTencentMap = paramTencentMap;
    this.mTencentMap.setInfoWindowAdapter(this);
    this.mTencentMap.setOnMarkerDragListener(this);
    this.mTencentMap.setOnMapLoadedCallback(this);
    this.mTencentMap.setOnInfoWindowClickListener(this);
    this.mTencentMap.setOnMarkerClickListener(this);
    this.mTencentMap.setOnCameraChangeListener(this);
    this.mTencentMap.setOnMapClickListener(this);
    this.mTencentMap.setOnMapLongClickListener(this);
    AppMethodBeat.o(207050);
  }
  
  private e a(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207061);
    if (paramMarker == null)
    {
      AppMethodBeat.o(207061);
      return null;
    }
    paramMarker = (e)this.airx.get(Integer.valueOf(paramMarker.getId().hashCode()));
    AppMethodBeat.o(207061);
    return paramMarker;
  }
  
  public final Arc addArc(ArcOptions paramArcOptions)
  {
    AppMethodBeat.i(207679);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207679);
      return null;
    }
    if (paramArcOptions == null)
    {
      AppMethodBeat.o(207679);
      return null;
    }
    paramArcOptions = this.mTencentMap.addArc(paramArcOptions);
    AppMethodBeat.o(207679);
    return paramArcOptions;
  }
  
  public final Circle addCircle(com.tencent.mapsdk.raster.model.CircleOptions paramCircleOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.CircleOptions localCircleOptions = null;
    AppMethodBeat.i(207099);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207099);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(207099);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCircleOptions == null) {}
    for (paramCircleOptions = localCircleOptions;; paramCircleOptions = localCircleOptions)
    {
      paramCircleOptions = new b(localTencentMap.addCircle(paramCircleOptions));
      AppMethodBeat.o(207099);
      return paramCircleOptions;
      localCircleOptions = new com.tencent.tencentmap.mapsdk.maps.model.CircleOptions();
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng = l.d(paramCircleOptions.getCenter());
      if (localLatLng != null) {
        localCircleOptions.center(localLatLng);
      }
      localCircleOptions.center(l.d(paramCircleOptions.getCenter())).fillColor(paramCircleOptions.getFillColor()).radius(paramCircleOptions.getRadius()).strokeColor(paramCircleOptions.getStrokeColor()).strokeWidth(paramCircleOptions.getStrokeWidth()).visible(paramCircleOptions.isVisible()).zIndex((int)paramCircleOptions.getZIndex()).level(paramCircleOptions.getLevel());
    }
  }
  
  public final CustomLayer addCustomLayer(com.tencent.mapsdk.raster.model.CustomLayerOptions paramCustomLayerOptions)
  {
    Object localObject = null;
    AppMethodBeat.i(207552);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207552);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCustomLayerOptions == null) {}
    for (paramCustomLayerOptions = localObject;; paramCustomLayerOptions = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(paramCustomLayerOptions.getLayerId()))
    {
      paramCustomLayerOptions = new c(localTencentMap.addCustomLayer(paramCustomLayerOptions));
      AppMethodBeat.o(207552);
      return paramCustomLayerOptions;
    }
  }
  
  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    AppMethodBeat.i(207657);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207657);
      return null;
    }
    if (paramGroundOverlayOptions == null)
    {
      AppMethodBeat.o(207657);
      return null;
    }
    paramGroundOverlayOptions = this.mTencentMap.addGroundOverlay(paramGroundOverlayOptions);
    AppMethodBeat.o(207657);
    return paramGroundOverlayOptions;
  }
  
  public final void addInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(207363);
    if (paramInfoWindowAdapter == null)
    {
      AppMethodBeat.o(207363);
      return;
    }
    if (this.airC == null) {
      this.airC = new LinkedList();
    }
    this.airC.add(paramInfoWindowAdapter);
    AppMethodBeat.o(207363);
  }
  
  public final com.tencent.mapsdk.raster.model.Marker addMarker(com.tencent.mapsdk.raster.model.MarkerOptions paramMarkerOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions localMarkerOptions = null;
    AppMethodBeat.i(207123);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207123);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(207123);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramMarkerOptions == null) {}
    do
    {
      paramMarkerOptions = new e(this, localTencentMap.addMarker(localMarkerOptions));
      this.airx.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
      AppMethodBeat.o(207123);
      return paramMarkerOptions;
      localObject = l.d(paramMarkerOptions.getPosition());
    } while (localObject == null);
    localMarkerOptions = new com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions((com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject);
    Object localObject = localMarkerOptions.alpha(paramMarkerOptions.getAlpha()).visible(paramMarkerOptions.isVisible()).draggable(paramMarkerOptions.isDraggable()).anchor(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV()).rotation(paramMarkerOptions.getRotation()).indoorInfo(l.a(paramMarkerOptions.getIndoorInfo())).zIndex(paramMarkerOptions.getZIndex()).level(paramMarkerOptions.getLevel()).flat(paramMarkerOptions.isFlat());
    if (paramMarkerOptions.isFlat() != paramMarkerOptions.isClockwise()) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).clockwise(bool).infoWindowOffset(paramMarkerOptions.getInfoWindowOffsetX(), paramMarkerOptions.getInfowindowOffsetY()).contentDescription(paramMarkerOptions.getContentDescription());
      if (paramMarkerOptions.getIcon() != null) {
        localMarkerOptions.icon(BitmapDescriptorFactory.fromBitmap(paramMarkerOptions.getIcon().getBitmap()));
      }
      if (paramMarkerOptions.getMarkerView() != null) {
        localMarkerOptions.icon(BitmapDescriptorFactory.fromView(paramMarkerOptions.getMarkerView()));
      }
      if (paramMarkerOptions.getSnippet() != null) {
        localMarkerOptions.snippet(paramMarkerOptions.getSnippet());
      }
      if (paramMarkerOptions.getTitle() != null) {
        localMarkerOptions.title(paramMarkerOptions.getTitle());
      }
      if (paramMarkerOptions.getTag() != null) {
        localMarkerOptions.tag(paramMarkerOptions.getTag());
      }
      if (paramMarkerOptions.getCollisions() != null) {
        localMarkerOptions.collisionBy(paramMarkerOptions.getCollisions());
      }
      break;
    }
  }
  
  public final void addOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(207398);
    if (paramOnInfoWindowClickListener == null)
    {
      AppMethodBeat.o(207398);
      return;
    }
    if (this.airI == null) {
      this.airI = new LinkedList();
    }
    this.airI.add(paramOnInfoWindowClickListener);
    AppMethodBeat.o(207398);
  }
  
  public final void addOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(207410);
    if (paramOnMapCameraChangeListener == null)
    {
      AppMethodBeat.o(207410);
      return;
    }
    if (this.airM == null) {
      this.airM = new LinkedList();
    }
    this.airM.add(paramOnMapCameraChangeListener);
    AppMethodBeat.o(207410);
  }
  
  public final void addOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(207416);
    if (paramOnMapClickListener == null)
    {
      AppMethodBeat.o(207416);
      return;
    }
    if (this.airO == null) {
      this.airO = new LinkedList();
    }
    this.airO.add(paramOnMapClickListener);
    AppMethodBeat.o(207416);
  }
  
  public final void addOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(207392);
    if (paramOnMapLoadedListener == null)
    {
      AppMethodBeat.o(207392);
      return;
    }
    if (this.airG == null) {
      this.airG = new LinkedList();
    }
    this.airG.add(paramOnMapLoadedListener);
    AppMethodBeat.o(207392);
  }
  
  public final void addOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(207423);
    if (paramOnMapLongClickListener == null)
    {
      AppMethodBeat.o(207423);
      return;
    }
    if (this.airQ == null) {
      this.airQ = new LinkedList();
    }
    this.airQ.add(paramOnMapLongClickListener);
    AppMethodBeat.o(207423);
  }
  
  public final void addOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(207403);
    if (paramOnMarkerClickListener == null)
    {
      AppMethodBeat.o(207403);
      return;
    }
    if (this.airK == null) {
      this.airK = new LinkedList();
    }
    this.airK.add(paramOnMarkerClickListener);
    AppMethodBeat.o(207403);
  }
  
  public final void addOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(207379);
    if (paramOnMarkerDraggedListener == null)
    {
      AppMethodBeat.o(207379);
      return;
    }
    if (this.airE == null) {
      this.airE = new LinkedList();
    }
    this.airE.add(paramOnMarkerDraggedListener);
    AppMethodBeat.o(207379);
  }
  
  public final Polygon addPolygon(com.tencent.mapsdk.raster.model.PolygonOptions paramPolygonOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(207146);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207146);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(207146);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    Object localObject1;
    if (paramPolygonOptions == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      paramPolygonOptions = new g(localTencentMap.addPolygon(localObject1));
      AppMethodBeat.o(207146);
      return paramPolygonOptions;
      com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions localPolygonOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
      List localList = l.oD(paramPolygonOptions.getPoints());
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 2)
        {
          localPolygonOptions.addAll(localList);
          localPolygonOptions.visible(paramPolygonOptions.isVisible()).zIndex((int)paramPolygonOptions.getZIndex()).level(paramPolygonOptions.getLevel()).strokeWidth(paramPolygonOptions.getStrokeWidth()).strokeColor(paramPolygonOptions.getStrokeColor()).fillColor(paramPolygonOptions.getFillColor());
          if (paramPolygonOptions.getPattern() != null) {
            localPolygonOptions.pattern(paramPolygonOptions.getPattern());
          }
          localObject1 = localPolygonOptions;
        }
      }
    }
  }
  
  public final Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(207133);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207133);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(207133);
      return null;
    }
    paramPolylineOptions = new f(this.mTencentMap.addPolyline(l.a(paramPolylineOptions)));
    AppMethodBeat.o(207133);
    return paramPolylineOptions;
  }
  
  public final TileOverlay addTileOverlay(com.tencent.mapsdk.raster.model.TileOverlayOptions paramTileOverlayOptions)
  {
    Object localObject = null;
    com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions localTileOverlayOptions = null;
    AppMethodBeat.i(207520);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207520);
      return null;
    }
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(207520);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramTileOverlayOptions == null)
    {
      paramTileOverlayOptions = localTileOverlayOptions;
      paramTileOverlayOptions = new k(localTencentMap.addTileOverlay(paramTileOverlayOptions));
      AppMethodBeat.o(207520);
      return paramTileOverlayOptions;
    }
    localTileOverlayOptions = new com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions();
    com.tencent.mapsdk.raster.model.TileProvider localTileProvider = paramTileOverlayOptions.getTileProvider();
    if (localTileProvider == null) {}
    for (;;)
    {
      paramTileOverlayOptions = localTileOverlayOptions.tileProvider((com.tencent.tencentmap.mapsdk.maps.model.TileProvider)localObject).diskCacheDir(paramTileOverlayOptions.getDiskCacheDir()).versionInfo(paramTileOverlayOptions.getVersionInfo()).zIndex(paramTileOverlayOptions.getZIndex()).betterQuality(paramTileOverlayOptions.isBetterQuality());
      break;
      if ((localTileProvider instanceof UrlTileProvider)) {
        localObject = new l.1(((UrlTileProvider)localTileProvider).mWidth, ((UrlTileProvider)localTileProvider).mHeight, localTileProvider);
      } else {
        localObject = new l.2(localTileProvider);
      }
    }
  }
  
  public final VisualLayer addVisualLayer(VisualLayerOptions paramVisualLayerOptions)
  {
    AppMethodBeat.i(207669);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207669);
      return null;
    }
    if (paramVisualLayerOptions == null)
    {
      AppMethodBeat.o(207669);
      return null;
    }
    paramVisualLayerOptions = this.mTencentMap.addVisualLayer(paramVisualLayerOptions);
    AppMethodBeat.o(207669);
    return paramVisualLayerOptions;
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(207270);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207270);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(207270);
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(207280);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207280);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap), paramLong, new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(206992);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onCancel();
          }
          AppMethodBeat.o(206992);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(206982);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onFinish();
          }
          AppMethodBeat.o(206982);
        }
      });
    }
    AppMethodBeat.o(207280);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207155);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207155);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.d(paramLatLng)));
    }
    AppMethodBeat.o(207155);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(207186);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207186);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.d(paramLatLng)), paramLong, new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(206991);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(206991);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(206983);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(206983);
      }
    });
    AppMethodBeat.o(207186);
  }
  
  @Deprecated
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, final Runnable paramRunnable)
  {
    AppMethodBeat.i(207172);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207172);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.d(paramLatLng)), new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(206995);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(206995);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(206988);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(206988);
        }
      });
    }
    AppMethodBeat.o(207172);
  }
  
  public final void clearAllOverlays()
  {
    AppMethodBeat.i(207197);
    if (this.mTencentMap != null) {
      this.mTencentMap.clear();
    }
    AppMethodBeat.o(207197);
  }
  
  public final boolean clearCache()
  {
    return false;
  }
  
  public final void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(207473);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207473);
      return;
    }
    this.mTencentMap.enableMultipleInfowindow(paramBoolean);
    AppMethodBeat.o(207473);
  }
  
  public final String getActivedIndoorBuilding(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207454);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207454);
      return null;
    }
    paramLatLng = this.mTencentMap.getActivedIndoorBuilding(l.d(paramLatLng));
    AppMethodBeat.o(207454);
    return paramLatLng;
  }
  
  public final String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(207458);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207458);
      return null;
    }
    String[] arrayOfString = this.mTencentMap.getActivedIndoorFloorNames();
    AppMethodBeat.o(207458);
    return arrayOfString;
  }
  
  public final com.tencent.mapsdk.raster.model.CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(207500);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207500);
      return null;
    }
    com.tencent.mapsdk.raster.model.CameraPosition localCameraPosition = l.a(this.mTencentMap.getCameraPosition());
    AppMethodBeat.o(207500);
    return localCameraPosition;
  }
  
  public final String getDebugError()
  {
    AppMethodBeat.i(207508);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207508);
      return null;
    }
    String str = this.mTencentMap.getDebugError();
    AppMethodBeat.o(207508);
    return str;
  }
  
  public final int getIndoorFloorId()
  {
    AppMethodBeat.i(207464);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207464);
      return 0;
    }
    int i = this.mTencentMap.getIndoorFloorId();
    AppMethodBeat.o(207464);
    return i;
  }
  
  public final View getInfoContents(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    return null;
  }
  
  public final View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207606);
    e locale = a(paramMarker);
    paramMarker = null;
    View localView = null;
    if (this.airC != null)
    {
      Iterator localIterator = this.airC.iterator();
      paramMarker = localView;
      while (localIterator.hasNext())
      {
        localView = ((com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter)localIterator.next()).getInfoWindow(locale);
        paramMarker = localView;
        if (localView != null) {
          paramMarker = localView;
        }
      }
    }
    AppMethodBeat.o(207606);
    return paramMarker;
  }
  
  public final com.tencent.mapsdk.raster.model.LatLng getMapCenter()
  {
    AppMethodBeat.i(207213);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207213);
      return null;
    }
    this.mTencentMap.getCameraPosition();
    com.tencent.mapsdk.raster.model.LatLng localLatLng = l.d(this.mTencentMap.getCameraPosition().target);
    AppMethodBeat.o(207213);
    return localLatLng;
  }
  
  public final int getMapType()
  {
    AppMethodBeat.i(207538);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207538);
      return 1000;
    }
    int i = this.mTencentMap.getMapType();
    AppMethodBeat.o(207538);
    return i;
  }
  
  public final int getMaxZoomLevel()
  {
    AppMethodBeat.i(207227);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207227);
      return 19;
    }
    int i = (int)this.mTencentMap.getMaxZoomLevel();
    AppMethodBeat.o(207227);
    return i;
  }
  
  public final int getMinZoomLevel()
  {
    AppMethodBeat.i(207234);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207234);
      return 4;
    }
    int i = (int)this.mTencentMap.getMinZoomLevel();
    AppMethodBeat.o(207234);
    return i;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(207544);
    h localh = new h(this.mTencentMap);
    AppMethodBeat.o(207544);
    return localh;
  }
  
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(207561);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207561);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(206997);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(206997);
      }
    });
    AppMethodBeat.o(207561);
  }
  
  @Deprecated
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(207567);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207567);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(206993);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(206993);
      }
    });
    AppMethodBeat.o(207567);
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(207238);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207238);
      return null;
    }
    String str = this.mTencentMap.getVersion();
    AppMethodBeat.o(207238);
    return str;
  }
  
  public final int getZoomLevel()
  {
    AppMethodBeat.i(207221);
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null))
    {
      AppMethodBeat.o(207221);
      return -1;
    }
    int i = (int)this.mTencentMap.getCameraPosition().zoom;
    AppMethodBeat.o(207221);
    return i;
  }
  
  public final boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public final boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(207604);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207604);
      return false;
    }
    boolean bool = this.mTencentMap.isHandDrawMapEnable();
    AppMethodBeat.o(207604);
    return bool;
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.airz;
  }
  
  public final boolean isTrafficEnabled()
  {
    AppMethodBeat.i(207579);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207579);
      return false;
    }
    boolean bool = this.mTencentMap.isTrafficEnabled();
    AppMethodBeat.o(207579);
    return bool;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(207264);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207264);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.moveCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(207264);
  }
  
  public final void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(207610);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.airM != null)
    {
      Iterator localIterator = this.airM.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChange(paramCameraPosition);
      }
    }
    AppMethodBeat.o(207610);
  }
  
  public final void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(207614);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.airM != null)
    {
      Iterator localIterator = this.airM.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChangeFinish(paramCameraPosition);
      }
    }
    AppMethodBeat.o(207614);
  }
  
  public final void onInfoWindowClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207617);
    paramMarker = a(paramMarker);
    if (this.airI != null)
    {
      Iterator localIterator = this.airI.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener)localIterator.next()).onInfoWindowClick(paramMarker);
      }
    }
    AppMethodBeat.o(207617);
  }
  
  public final void onInfoWindowClickLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207619);
    paramLatLng = l.d(paramLatLng);
    if (this.airO != null)
    {
      Iterator localIterator = this.airO.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener)localIterator.next()).onMapClick(paramLatLng);
      }
    }
    AppMethodBeat.o(207619);
  }
  
  public final void onMapLoaded()
  {
    AppMethodBeat.i(207621);
    if (this.airG != null)
    {
      Iterator localIterator = this.airG.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapLoadedListener)localIterator.next()).onMapLoaded();
      }
    }
    AppMethodBeat.o(207621);
  }
  
  public final void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207623);
    paramLatLng = l.d(paramLatLng);
    if (this.airQ != null)
    {
      Iterator localIterator = this.airQ.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener)localIterator.next()).onMapLongClick(paramLatLng);
      }
    }
    AppMethodBeat.o(207623);
  }
  
  public final boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207625);
    paramMarker = a(paramMarker);
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.airK != null)
    {
      Iterator localIterator = this.airK.iterator();
      bool1 = bool2;
      while (localIterator.hasNext())
      {
        bool2 = ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener)localIterator.next()).onMarkerClick(paramMarker);
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(207625);
    return bool1;
  }
  
  public final void onMarkerDrag(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207635);
    paramMarker = a(paramMarker);
    if (this.airE != null)
    {
      Iterator localIterator = this.airE.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDrag(paramMarker);
      }
    }
    AppMethodBeat.o(207635);
  }
  
  public final void onMarkerDragEnd(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207640);
    paramMarker = a(paramMarker);
    if (this.airE != null)
    {
      Iterator localIterator = this.airE.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragEnd(paramMarker);
      }
    }
    AppMethodBeat.o(207640);
  }
  
  public final void onMarkerDragStart(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207627);
    paramMarker = a(paramMarker);
    if (this.airE != null)
    {
      Iterator localIterator = this.airE.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragStart(paramMarker);
      }
    }
    AppMethodBeat.o(207627);
  }
  
  public final void remmoveOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(207400);
    if ((paramOnInfoWindowClickListener == null) || (this.airI == null))
    {
      AppMethodBeat.o(207400);
      return;
    }
    this.airI.remove(paramOnInfoWindowClickListener);
    AppMethodBeat.o(207400);
  }
  
  public final void removeInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(207368);
    if ((paramInfoWindowAdapter == null) || (this.airC == null))
    {
      AppMethodBeat.o(207368);
      return;
    }
    this.airC.remove(paramInfoWindowAdapter);
    AppMethodBeat.o(207368);
  }
  
  public final void removeOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(207412);
    if ((paramOnMapCameraChangeListener == null) || (this.airM == null))
    {
      AppMethodBeat.o(207412);
      return;
    }
    this.airM.remove(paramOnMapCameraChangeListener);
    AppMethodBeat.o(207412);
  }
  
  public final void removeOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(207417);
    if ((paramOnMapClickListener == null) || (this.airO == null))
    {
      AppMethodBeat.o(207417);
      return;
    }
    this.airO.remove(paramOnMapClickListener);
    AppMethodBeat.o(207417);
  }
  
  public final void removeOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(207394);
    if ((paramOnMapLoadedListener == null) || (this.airG == null))
    {
      AppMethodBeat.o(207394);
      return;
    }
    this.airG.remove(paramOnMapLoadedListener);
    AppMethodBeat.o(207394);
  }
  
  public final void removeOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(207425);
    if ((paramOnMapLongClickListener == null) || (this.airQ == null))
    {
      AppMethodBeat.o(207425);
      return;
    }
    this.airQ.remove(paramOnMapLongClickListener);
    AppMethodBeat.o(207425);
  }
  
  public final void removeOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(207406);
    if ((paramOnMarkerClickListener == null) || (this.airK == null))
    {
      AppMethodBeat.o(207406);
      return;
    }
    this.airK.remove(paramOnMarkerClickListener);
    AppMethodBeat.o(207406);
  }
  
  public final void removeOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(207385);
    if ((paramOnMarkerDraggedListener == null) || (this.airE == null))
    {
      AppMethodBeat.o(207385);
      return;
    }
    this.airE.remove(paramOnMarkerDraggedListener);
    AppMethodBeat.o(207385);
  }
  
  public final void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(207486);
    this.mTencentMap.removeTencentMapGestureListener(this.airA);
    AppMethodBeat.o(207486);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(207286);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207286);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2));
    AppMethodBeat.o(207286);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(207291);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207291);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(206984);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(206984);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(206980);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(206980);
      }
    });
    AppMethodBeat.o(207291);
  }
  
  public final void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(207588);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207588);
      return;
    }
    this.mTencentMap.setBuildingEnable(paramBoolean);
    AppMethodBeat.o(207588);
  }
  
  public final void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(207665);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207665);
      return;
    }
    this.mTencentMap.setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(207665);
  }
  
  public final void setCenter(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(207070);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207070);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(207070);
  }
  
  @Deprecated
  public final void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.mTencentMap == null) {}
  }
  
  public final void setForeignLanguage(com.tencent.mapsdk.raster.model.Language paramLanguage)
  {
    AppMethodBeat.i(207494);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207494);
      return;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramLanguage != null) {}
    switch (l.3.aisb[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
    }
    for (;;)
    {
      localTencentMap.setForeignLanguage(paramLanguage);
      AppMethodBeat.o(207494);
      return;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      continue;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
    }
  }
  
  public final void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(207598);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207598);
      return;
    }
    this.mTencentMap.setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(207598);
  }
  
  public final void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207432);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207432);
      return;
    }
    this.mTencentMap.setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(207432);
  }
  
  public final void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(207435);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207435);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramInt);
    AppMethodBeat.o(207435);
  }
  
  public final void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207439);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207439);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(207439);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(207444);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207444);
      return;
    }
    this.mTencentMap.setIndoorMaskColor(paramInt);
    AppMethodBeat.o(207444);
  }
  
  public final void setInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(207359);
    if ((paramInfoWindowAdapter == null) && (this.airB != null)) {
      removeInfoWindowAdapter(this.airB);
    }
    this.airB = paramInfoWindowAdapter;
    addInfoWindowAdapter(this.airB);
    AppMethodBeat.o(207359);
  }
  
  public final void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(207592);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207592);
      return;
    }
    this.mTencentMap.setCameraCenterProportion(paramFloat1, paramFloat2, false);
    this.mTencentMap.getUiSettings().setGestureScaleByMapCenter(true);
    AppMethodBeat.o(207592);
  }
  
  public final void setMapBoundary(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(207673);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207673);
      return;
    }
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(207673);
      return;
    }
    this.mTencentMap.setRestrictBounds(paramLatLngBounds, RestrictBoundsFitMode.FIT_WIDTH);
    AppMethodBeat.o(207673);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(207427);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207427);
      return;
    }
    this.mTencentMap.setMapStyle(paramInt);
    AppMethodBeat.o(207427);
  }
  
  public final void setMapType(int paramInt)
  {
    AppMethodBeat.i(207531);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207531);
      return;
    }
    this.mTencentMap.setMapType(paramInt);
    AppMethodBeat.o(207531);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(207642);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207642);
      return;
    }
    this.mTencentMap.setMaxZoomLevel(paramInt);
    AppMethodBeat.o(207642);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(207651);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207651);
      return;
    }
    this.mTencentMap.setMinZoomLevel(paramInt);
    AppMethodBeat.o(207651);
  }
  
  public final void setOnIndoorStateChangeListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(207429);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207429);
      return;
    }
    this.mTencentMap.setOnIndoorStateChangeListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener()
    {
      public final boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(207014);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(207014);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingDeactivated();
        AppMethodBeat.o(207014);
        return bool;
      }
      
      public final boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(206999);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(206999);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        AppMethodBeat.o(206999);
        return bool;
      }
      
      public final boolean onIndoorLevelActivated(com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(207009);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(207009);
          return false;
        }
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener localOnIndoorStateChangeListener = paramOnIndoorStateChangeListener;
        if (paramAnonymousIndoorBuilding == null) {
          paramAnonymousIndoorBuilding = null;
        }
        for (;;)
        {
          boolean bool = localOnIndoorStateChangeListener.onIndoorLevelActivated(paramAnonymousIndoorBuilding);
          AppMethodBeat.o(207009);
          return bool;
          Object localObject = paramAnonymousIndoorBuilding.getLevels();
          if (localObject == null)
          {
            localObject = null;
            if (localObject == null) {
              paramAnonymousIndoorBuilding = null;
            }
          }
          else
          {
            localObject = new CopyOnWriteArrayList((Collection)localObject);
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = ((List)localObject).iterator();
            for (;;)
            {
              localObject = localArrayList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = (com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel)localIterator.next();
              if (localObject == null)
              {
                localObject = null;
                break;
              }
              localArrayList.add(new com.tencent.mapsdk.raster.model.IndoorLevel(((com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel)localObject).getName()));
            }
          }
          paramAnonymousIndoorBuilding = new com.tencent.mapsdk.raster.model.IndoorBuilding(paramAnonymousIndoorBuilding.getBuidlingId(), paramAnonymousIndoorBuilding.getBuildingName(), (List)localObject, paramAnonymousIndoorBuilding.getActiveLevelIndex());
        }
      }
    });
    AppMethodBeat.o(207429);
  }
  
  public final void setOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(207395);
    if ((paramOnInfoWindowClickListener == null) && (this.airH != null)) {
      remmoveOnInfoWindowClickListener(this.airH);
    }
    this.airH = paramOnInfoWindowClickListener;
    addOnInfoWindowClickListener(this.airH);
    AppMethodBeat.o(207395);
  }
  
  public final void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(207408);
    if ((paramOnMapCameraChangeListener == null) && (this.airL != null)) {
      removeOnMapCameraChangeListener(this.airL);
    }
    this.airL = paramOnMapCameraChangeListener;
    addOnMapCameraChangeListener(this.airL);
    AppMethodBeat.o(207408);
  }
  
  public final void setOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(207414);
    if ((paramOnMapClickListener == null) && (this.airN != null)) {
      removeOnMapClickListener(this.airN);
    }
    this.airN = paramOnMapClickListener;
    addOnMapClickListener(this.airN);
    AppMethodBeat.o(207414);
  }
  
  public final void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(207389);
    if ((paramOnMapLoadedListener == null) && (this.airF != null)) {
      removeOnMapLoadedListener(this.airF);
    }
    this.airF = paramOnMapLoadedListener;
    addOnMapLoadedListener(this.airF);
    AppMethodBeat.o(207389);
  }
  
  public final void setOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(207418);
    if ((paramOnMapLongClickListener == null) && (this.airP != null)) {
      removeOnMapLongClickListener(this.airP);
    }
    this.airP = paramOnMapLongClickListener;
    addOnMapLongClickListener(this.airP);
    AppMethodBeat.o(207418);
  }
  
  public final void setOnMapPoiClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(207426);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207426);
      return;
    }
    this.mTencentMap.setOnMapPoiClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener()
    {
      public final void onClicked(com.tencent.tencentmap.mapsdk.maps.model.MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(207006);
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener localOnMapPoiClickListener;
        if (paramOnMapPoiClickListener != null)
        {
          localOnMapPoiClickListener = paramOnMapPoiClickListener;
          if (paramAnonymousMapPoi != null) {
            break label36;
          }
          paramAnonymousMapPoi = null;
        }
        for (;;)
        {
          localOnMapPoiClickListener.onClicked(paramAnonymousMapPoi);
          AppMethodBeat.o(207006);
          return;
          label36:
          if ((paramAnonymousMapPoi instanceof com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi))
          {
            paramAnonymousMapPoi = (com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi)paramAnonymousMapPoi;
            paramAnonymousMapPoi = new com.tencent.mapsdk.raster.model.IndoorMapPoi(paramAnonymousMapPoi.getName(), l.d(paramAnonymousMapPoi.getPosition()), paramAnonymousMapPoi.getBuildingId(), paramAnonymousMapPoi.getBuildingName(), paramAnonymousMapPoi.getFloorName());
          }
          else
          {
            paramAnonymousMapPoi = new com.tencent.mapsdk.raster.model.MapPoi(paramAnonymousMapPoi.getName(), l.d(paramAnonymousMapPoi.getPosition()));
          }
        }
      }
    });
    AppMethodBeat.o(207426);
  }
  
  public final void setOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(207402);
    if ((paramOnMarkerClickListener == null) && (this.airJ != null)) {
      removeOnMarkerClickListener(this.airJ);
    }
    this.airJ = paramOnMarkerClickListener;
    addOnMarkerClickListener(this.airJ);
    AppMethodBeat.o(207402);
  }
  
  public final void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(207372);
    if ((paramOnMarkerDraggedListener == null) && (this.airD != null)) {
      removeOnMarkerDraggedListener(this.airD);
    }
    this.airD = paramOnMarkerDraggedListener;
    addOnMarkerDraggedListener(this.airD);
    AppMethodBeat.o(207372);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207525);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207525);
      return;
    }
    this.mTencentMap.setPoisEnabled(paramBoolean);
    AppMethodBeat.o(207525);
  }
  
  public final void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207257);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207257);
      return;
    }
    this.airz = paramBoolean;
    this.mTencentMap.setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(207257);
  }
  
  public final void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(207480);
    if ((this.mTencentMap == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(207480);
      return;
    }
    if (this.airA != null) {
      this.mTencentMap.removeTencentMapGestureListener(this.airA);
    }
    this.airA = new TencentMapGestureListener()
    {
      public final boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207021);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207021);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDoubleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(207021);
        return bool;
      }
      
      public final boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207082);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207082);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDown(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(207082);
        return bool;
      }
      
      public final boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207045);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207045);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onFling(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(207045);
        return bool;
      }
      
      public final boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207068);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207068);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onLongPress(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(207068);
        return bool;
      }
      
      public final void onMapStable()
      {
        AppMethodBeat.i(207119);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207119);
          return;
        }
        paramTencentMapGestureListener.onMapStable();
        AppMethodBeat.o(207119);
      }
      
      public final boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207059);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207059);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onScroll(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(207059);
        return bool;
      }
      
      public final boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207033);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207033);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onSingleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(207033);
        return bool;
      }
      
      public final boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207103);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(207103);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onUp(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(207103);
        return bool;
      }
    };
    this.mTencentMap.setTencentMapGestureListener(this.airA);
    AppMethodBeat.o(207480);
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207574);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207574);
      return;
    }
    this.mTencentMap.setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(207574);
  }
  
  public final void setZoom(int paramInt)
  {
    AppMethodBeat.i(207080);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207080);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomTo(paramInt));
    AppMethodBeat.o(207080);
  }
  
  public final void showBuilding(boolean paramBoolean)
  {
    AppMethodBeat.i(207661);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207661);
      return;
    }
    this.mTencentMap.showBuilding(paramBoolean);
    AppMethodBeat.o(207661);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(207558);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207558);
      return;
    }
    this.mTencentMap.stopAnimation();
    AppMethodBeat.o(207558);
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(207298);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207298);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomIn());
    AppMethodBeat.o(207298);
  }
  
  public final void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207309);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207309);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(207309);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(207318);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207318);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomOut());
    AppMethodBeat.o(207318);
  }
  
  public final void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207323);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207323);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(207323);
  }
  
  public final void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(207350);
    zoomToSpan(new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(207350);
  }
  
  public final void zoomToSpan(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(207329);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(207329);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(l.d(paramLatLng1), l.d(paramLatLng2)), 0));
    AppMethodBeat.o(207329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */