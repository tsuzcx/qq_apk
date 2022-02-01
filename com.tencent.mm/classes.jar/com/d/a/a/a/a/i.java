package com.d.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
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
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
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
  private HashMap<Integer, e> SJQ;
  List<com.tencent.tencentmap.mapsdk.maps.model.Marker> SJR;
  private boolean SJS;
  private TencentMapGestureListener SJT;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter SJU;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter> SJV;
  private TencentMap.OnMarkerDraggedListener SJW;
  List<TencentMap.OnMarkerDraggedListener> SJX;
  private TencentMap.OnMapLoadedListener SJY;
  List<TencentMap.OnMapLoadedListener> SJZ;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener SKa;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener> SKb;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener SKc;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener> SKd;
  private TencentMap.OnMapCameraChangeListener SKe;
  List<TencentMap.OnMapCameraChangeListener> SKf;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener SKg;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener> SKh;
  private com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener SKi;
  List<com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener> SKj;
  private com.tencent.tencentmap.mapsdk.maps.TencentMap mTencentMap;
  
  public i(com.tencent.tencentmap.mapsdk.maps.TencentMap paramTencentMap)
  {
    AppMethodBeat.i(217416);
    this.SJQ = new HashMap();
    this.SJR = new ArrayList();
    this.SJS = false;
    this.mTencentMap = paramTencentMap;
    this.mTencentMap.setInfoWindowAdapter(this);
    this.mTencentMap.setOnMarkerDragListener(this);
    this.mTencentMap.setOnMapLoadedCallback(this);
    this.mTencentMap.setOnInfoWindowClickListener(this);
    this.mTencentMap.setOnMarkerClickListener(this);
    this.mTencentMap.setOnCameraChangeListener(this);
    this.mTencentMap.setOnMapClickListener(this);
    this.mTencentMap.setOnMapLongClickListener(this);
    AppMethodBeat.o(217416);
  }
  
  private e a(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217447);
    if (paramMarker == null)
    {
      AppMethodBeat.o(217447);
      return null;
    }
    paramMarker = (e)this.SJQ.get(Integer.valueOf(paramMarker.getId().hashCode()));
    AppMethodBeat.o(217447);
    return paramMarker;
  }
  
  public final Circle addCircle(com.tencent.mapsdk.raster.model.CircleOptions paramCircleOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.CircleOptions localCircleOptions = null;
    AppMethodBeat.i(217419);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217419);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(217419);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCircleOptions == null) {}
    for (paramCircleOptions = localCircleOptions;; paramCircleOptions = localCircleOptions)
    {
      paramCircleOptions = new b(localTencentMap.addCircle(paramCircleOptions));
      AppMethodBeat.o(217419);
      return paramCircleOptions;
      localCircleOptions = new com.tencent.tencentmap.mapsdk.maps.model.CircleOptions();
      com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng = l.c(paramCircleOptions.getCenter());
      if (localLatLng != null) {
        localCircleOptions.center(localLatLng);
      }
      localCircleOptions.center(l.c(paramCircleOptions.getCenter())).fillColor(paramCircleOptions.getFillColor()).radius(paramCircleOptions.getRadius()).strokeColor(paramCircleOptions.getStrokeColor()).strokeWidth(paramCircleOptions.getStrokeWidth()).visible(paramCircleOptions.isVisible()).zIndex((int)paramCircleOptions.getZIndex()).level(paramCircleOptions.getLevel());
    }
  }
  
  public final CustomLayer addCustomLayer(com.tencent.mapsdk.raster.model.CustomLayerOptions paramCustomLayerOptions)
  {
    Object localObject = null;
    AppMethodBeat.i(217490);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217490);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCustomLayerOptions == null) {}
    for (paramCustomLayerOptions = localObject;; paramCustomLayerOptions = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(paramCustomLayerOptions.getLayerId()))
    {
      paramCustomLayerOptions = new c(localTencentMap.addCustomLayer(paramCustomLayerOptions));
      AppMethodBeat.o(217490);
      return paramCustomLayerOptions;
    }
  }
  
  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    AppMethodBeat.i(217513);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217513);
      return null;
    }
    if (paramGroundOverlayOptions == null)
    {
      AppMethodBeat.o(217513);
      return null;
    }
    paramGroundOverlayOptions = this.mTencentMap.addGroundOverlay(paramGroundOverlayOptions);
    AppMethodBeat.o(217513);
    return paramGroundOverlayOptions;
  }
  
  public final void addInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(217445);
    if (paramInfoWindowAdapter == null)
    {
      AppMethodBeat.o(217445);
      return;
    }
    if (this.SJV == null) {
      this.SJV = new LinkedList();
    }
    this.SJV.add(paramInfoWindowAdapter);
    AppMethodBeat.o(217445);
  }
  
  public final com.tencent.mapsdk.raster.model.Marker addMarker(com.tencent.mapsdk.raster.model.MarkerOptions paramMarkerOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions localMarkerOptions = null;
    AppMethodBeat.i(217420);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217420);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(217420);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramMarkerOptions == null) {}
    do
    {
      paramMarkerOptions = new e(this, localTencentMap.addMarker(localMarkerOptions));
      this.SJQ.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
      AppMethodBeat.o(217420);
      return paramMarkerOptions;
      localObject = l.c(paramMarkerOptions.getPosition());
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
      break;
    }
  }
  
  public final void addOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(217455);
    if (paramOnInfoWindowClickListener == null)
    {
      AppMethodBeat.o(217455);
      return;
    }
    if (this.SKb == null) {
      this.SKb = new LinkedList();
    }
    this.SKb.add(paramOnInfoWindowClickListener);
    AppMethodBeat.o(217455);
  }
  
  public final void addOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(217461);
    if (paramOnMapCameraChangeListener == null)
    {
      AppMethodBeat.o(217461);
      return;
    }
    if (this.SKf == null) {
      this.SKf = new LinkedList();
    }
    this.SKf.add(paramOnMapCameraChangeListener);
    AppMethodBeat.o(217461);
  }
  
  public final void addOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(217464);
    if (paramOnMapClickListener == null)
    {
      AppMethodBeat.o(217464);
      return;
    }
    if (this.SKh == null) {
      this.SKh = new LinkedList();
    }
    this.SKh.add(paramOnMapClickListener);
    AppMethodBeat.o(217464);
  }
  
  public final void addOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(217452);
    if (paramOnMapLoadedListener == null)
    {
      AppMethodBeat.o(217452);
      return;
    }
    if (this.SJZ == null) {
      this.SJZ = new LinkedList();
    }
    this.SJZ.add(paramOnMapLoadedListener);
    AppMethodBeat.o(217452);
  }
  
  public final void addOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(217467);
    if (paramOnMapLongClickListener == null)
    {
      AppMethodBeat.o(217467);
      return;
    }
    if (this.SKj == null) {
      this.SKj = new LinkedList();
    }
    this.SKj.add(paramOnMapLongClickListener);
    AppMethodBeat.o(217467);
  }
  
  public final void addOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(217458);
    if (paramOnMarkerClickListener == null)
    {
      AppMethodBeat.o(217458);
      return;
    }
    if (this.SKd == null) {
      this.SKd = new LinkedList();
    }
    this.SKd.add(paramOnMarkerClickListener);
    AppMethodBeat.o(217458);
  }
  
  public final void addOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(217449);
    if (paramOnMarkerDraggedListener == null)
    {
      AppMethodBeat.o(217449);
      return;
    }
    if (this.SJX == null) {
      this.SJX = new LinkedList();
    }
    this.SJX.add(paramOnMarkerDraggedListener);
    AppMethodBeat.o(217449);
  }
  
  public final Polygon addPolygon(com.tencent.mapsdk.raster.model.PolygonOptions paramPolygonOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(217422);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217422);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(217422);
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
      AppMethodBeat.o(217422);
      return paramPolygonOptions;
      com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions localPolygonOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
      List localList = l.kl(paramPolygonOptions.getPoints());
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 2)
        {
          localPolygonOptions.addAll(localList);
          localPolygonOptions.visible(paramPolygonOptions.isVisible()).zIndex((int)paramPolygonOptions.getZIndex()).level(paramPolygonOptions.getLevel()).strokeWidth(paramPolygonOptions.getStrokeWidth()).strokeColor(paramPolygonOptions.getStrokeColor()).fillColor(paramPolygonOptions.getFillColor());
          localObject1 = localPolygonOptions;
        }
      }
    }
  }
  
  public final Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(217421);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217421);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(217421);
      return null;
    }
    paramPolylineOptions = new f(this.mTencentMap.addPolyline(l.a(paramPolylineOptions)));
    AppMethodBeat.o(217421);
    return paramPolylineOptions;
  }
  
  public final TileOverlay addTileOverlay(com.tencent.mapsdk.raster.model.TileOverlayOptions paramTileOverlayOptions)
  {
    Object localObject = null;
    com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions localTileOverlayOptions = null;
    AppMethodBeat.i(217485);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217485);
      return null;
    }
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(217485);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramTileOverlayOptions == null)
    {
      paramTileOverlayOptions = localTileOverlayOptions;
      paramTileOverlayOptions = new k(localTencentMap.addTileOverlay(paramTileOverlayOptions));
      AppMethodBeat.o(217485);
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
  
  public final void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(217434);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217434);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(217434);
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(217435);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217435);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap), paramLong, new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(217399);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onCancel();
          }
          AppMethodBeat.o(217399);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(217398);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onFinish();
          }
          AppMethodBeat.o(217398);
        }
      });
    }
    AppMethodBeat.o(217435);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(217423);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217423);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)));
    }
    AppMethodBeat.o(217423);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(217425);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217425);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), paramLong, new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(217397);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(217397);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(217396);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(217396);
      }
    });
    AppMethodBeat.o(217425);
  }
  
  @Deprecated
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, final Runnable paramRunnable)
  {
    AppMethodBeat.i(217424);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217424);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(217395);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(217395);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(217394);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(217394);
        }
      });
    }
    AppMethodBeat.o(217424);
  }
  
  public final void clearAllOverlays()
  {
    AppMethodBeat.i(217426);
    if (this.mTencentMap != null) {
      this.mTencentMap.clear();
    }
    AppMethodBeat.o(217426);
  }
  
  public final boolean clearCache()
  {
    return false;
  }
  
  public final void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(217479);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217479);
      return;
    }
    this.mTencentMap.enableMultipleInfowindow(paramBoolean);
    AppMethodBeat.o(217479);
  }
  
  public final String getActivedIndoorBuilding(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(217476);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217476);
      return null;
    }
    paramLatLng = this.mTencentMap.getActivedIndoorBuilding(l.c(paramLatLng));
    AppMethodBeat.o(217476);
    return paramLatLng;
  }
  
  public final String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(217477);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217477);
      return null;
    }
    String[] arrayOfString = this.mTencentMap.getActivedIndoorFloorNames();
    AppMethodBeat.o(217477);
    return arrayOfString;
  }
  
  public final com.tencent.mapsdk.raster.model.CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(217483);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217483);
      return null;
    }
    com.tencent.mapsdk.raster.model.CameraPosition localCameraPosition = l.a(this.mTencentMap.getCameraPosition());
    AppMethodBeat.o(217483);
    return localCameraPosition;
  }
  
  public final String getDebugError()
  {
    AppMethodBeat.i(217484);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217484);
      return null;
    }
    String str = this.mTencentMap.getDebugError();
    AppMethodBeat.o(217484);
    return str;
  }
  
  public final int getIndoorFloorId()
  {
    AppMethodBeat.i(217478);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217478);
      return 0;
    }
    int i = this.mTencentMap.getIndoorFloorId();
    AppMethodBeat.o(217478);
    return i;
  }
  
  public final View getInfoContents(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    return null;
  }
  
  public final View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217500);
    e locale = a(paramMarker);
    paramMarker = null;
    View localView = null;
    if (this.SJV != null)
    {
      Iterator localIterator = this.SJV.iterator();
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
    AppMethodBeat.o(217500);
    return paramMarker;
  }
  
  public final com.tencent.mapsdk.raster.model.LatLng getMapCenter()
  {
    AppMethodBeat.i(217427);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217427);
      return null;
    }
    this.mTencentMap.getCameraPosition();
    com.tencent.mapsdk.raster.model.LatLng localLatLng = l.a(this.mTencentMap.getCameraPosition().target);
    AppMethodBeat.o(217427);
    return localLatLng;
  }
  
  public final int getMapType()
  {
    AppMethodBeat.i(217488);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217488);
      return 1000;
    }
    int i = this.mTencentMap.getMapType();
    AppMethodBeat.o(217488);
    return i;
  }
  
  public final int getMaxZoomLevel()
  {
    AppMethodBeat.i(217429);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217429);
      return 19;
    }
    int i = (int)this.mTencentMap.getMaxZoomLevel();
    AppMethodBeat.o(217429);
    return i;
  }
  
  public final int getMinZoomLevel()
  {
    AppMethodBeat.i(217430);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217430);
      return 4;
    }
    int i = (int)this.mTencentMap.getMinZoomLevel();
    AppMethodBeat.o(217430);
    return i;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(217489);
    h localh = new h(this.mTencentMap);
    AppMethodBeat.o(217489);
    return localh;
  }
  
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(217492);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217492);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(217414);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(217414);
      }
    });
    AppMethodBeat.o(217492);
  }
  
  @Deprecated
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(217493);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217493);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(217415);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(217415);
      }
    });
    AppMethodBeat.o(217493);
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(217431);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217431);
      return null;
    }
    String str = this.mTencentMap.getVersion();
    AppMethodBeat.o(217431);
    return str;
  }
  
  public final int getZoomLevel()
  {
    AppMethodBeat.i(217428);
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null))
    {
      AppMethodBeat.o(217428);
      return -1;
    }
    int i = (int)this.mTencentMap.getCameraPosition().zoom;
    AppMethodBeat.o(217428);
    return i;
  }
  
  public final boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public final boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(217499);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217499);
      return false;
    }
    boolean bool = this.mTencentMap.isHandDrawMapEnable();
    AppMethodBeat.o(217499);
    return bool;
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.SJS;
  }
  
  public final boolean isTrafficEnabled()
  {
    AppMethodBeat.i(217495);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217495);
      return false;
    }
    boolean bool = this.mTencentMap.isTrafficEnabled();
    AppMethodBeat.o(217495);
    return bool;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(217433);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217433);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.moveCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(217433);
  }
  
  public final void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(217501);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.SKf != null)
    {
      Iterator localIterator = this.SKf.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChange(paramCameraPosition);
      }
    }
    AppMethodBeat.o(217501);
  }
  
  public final void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(217502);
    paramCameraPosition = l.a(paramCameraPosition);
    if (this.SKf != null)
    {
      Iterator localIterator = this.SKf.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapCameraChangeListener)localIterator.next()).onCameraChangeFinish(paramCameraPosition);
      }
    }
    AppMethodBeat.o(217502);
  }
  
  public final void onInfoWindowClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217503);
    paramMarker = a(paramMarker);
    if (this.SKb != null)
    {
      Iterator localIterator = this.SKb.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener)localIterator.next()).onInfoWindowClick(paramMarker);
      }
    }
    AppMethodBeat.o(217503);
  }
  
  public final void onInfoWindowClickLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(217504);
    paramLatLng = l.a(paramLatLng);
    if (this.SKh != null)
    {
      Iterator localIterator = this.SKh.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener)localIterator.next()).onMapClick(paramLatLng);
      }
    }
    AppMethodBeat.o(217504);
  }
  
  public final void onMapLoaded()
  {
    AppMethodBeat.i(217505);
    if (this.SJZ != null)
    {
      Iterator localIterator = this.SJZ.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMapLoadedListener)localIterator.next()).onMapLoaded();
      }
    }
    AppMethodBeat.o(217505);
  }
  
  public final void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(217506);
    paramLatLng = l.a(paramLatLng);
    if (this.SKj != null)
    {
      Iterator localIterator = this.SKj.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener)localIterator.next()).onMapLongClick(paramLatLng);
      }
    }
    AppMethodBeat.o(217506);
  }
  
  public final boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217507);
    paramMarker = a(paramMarker);
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.SKd != null)
    {
      Iterator localIterator = this.SKd.iterator();
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
    AppMethodBeat.o(217507);
    return bool1;
  }
  
  public final void onMarkerDrag(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217509);
    paramMarker = a(paramMarker);
    if (this.SJX != null)
    {
      Iterator localIterator = this.SJX.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDrag(paramMarker);
      }
    }
    AppMethodBeat.o(217509);
  }
  
  public final void onMarkerDragEnd(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217510);
    paramMarker = a(paramMarker);
    if (this.SJX != null)
    {
      Iterator localIterator = this.SJX.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragEnd(paramMarker);
      }
    }
    AppMethodBeat.o(217510);
  }
  
  public final void onMarkerDragStart(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217508);
    paramMarker = a(paramMarker);
    if (this.SJX != null)
    {
      Iterator localIterator = this.SJX.iterator();
      while (localIterator.hasNext()) {
        ((TencentMap.OnMarkerDraggedListener)localIterator.next()).onMarkerDragStart(paramMarker);
      }
    }
    AppMethodBeat.o(217508);
  }
  
  public final void remmoveOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(217456);
    if ((paramOnInfoWindowClickListener == null) || (this.SKb == null))
    {
      AppMethodBeat.o(217456);
      return;
    }
    this.SKb.remove(paramOnInfoWindowClickListener);
    AppMethodBeat.o(217456);
  }
  
  public final void removeInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(217446);
    if ((paramInfoWindowAdapter == null) || (this.SJV == null))
    {
      AppMethodBeat.o(217446);
      return;
    }
    this.SJV.remove(paramInfoWindowAdapter);
    AppMethodBeat.o(217446);
  }
  
  public final void removeOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(217462);
    if ((paramOnMapCameraChangeListener == null) || (this.SKf == null))
    {
      AppMethodBeat.o(217462);
      return;
    }
    this.SKf.remove(paramOnMapCameraChangeListener);
    AppMethodBeat.o(217462);
  }
  
  public final void removeOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(217465);
    if ((paramOnMapClickListener == null) || (this.SKh == null))
    {
      AppMethodBeat.o(217465);
      return;
    }
    this.SKh.remove(paramOnMapClickListener);
    AppMethodBeat.o(217465);
  }
  
  public final void removeOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(217453);
    if ((paramOnMapLoadedListener == null) || (this.SJZ == null))
    {
      AppMethodBeat.o(217453);
      return;
    }
    this.SJZ.remove(paramOnMapLoadedListener);
    AppMethodBeat.o(217453);
  }
  
  public final void removeOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(217468);
    if ((paramOnMapLongClickListener == null) || (this.SKj == null))
    {
      AppMethodBeat.o(217468);
      return;
    }
    this.SKj.remove(paramOnMapLongClickListener);
    AppMethodBeat.o(217468);
  }
  
  public final void removeOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(217459);
    if ((paramOnMarkerClickListener == null) || (this.SKd == null))
    {
      AppMethodBeat.o(217459);
      return;
    }
    this.SKd.remove(paramOnMarkerClickListener);
    AppMethodBeat.o(217459);
  }
  
  public final void removeOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(217450);
    if ((paramOnMarkerDraggedListener == null) || (this.SJX == null))
    {
      AppMethodBeat.o(217450);
      return;
    }
    this.SJX.remove(paramOnMarkerDraggedListener);
    AppMethodBeat.o(217450);
  }
  
  public final void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(217481);
    this.mTencentMap.removeTencentMapGestureListener(this.SJT);
    AppMethodBeat.o(217481);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217436);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217436);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2));
    AppMethodBeat.o(217436);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(217437);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217437);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(217401);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(217401);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(217400);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(217400);
      }
    });
    AppMethodBeat.o(217437);
  }
  
  public final void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(217496);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217496);
      return;
    }
    this.mTencentMap.setBuildingEnable(paramBoolean);
    AppMethodBeat.o(217496);
  }
  
  public final void setBuilding3dEffectEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(217515);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217515);
      return;
    }
    this.mTencentMap.setBuilding3dEffectEnable(paramBoolean);
    AppMethodBeat.o(217515);
  }
  
  public final void setCenter(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(217417);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217417);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(217417);
  }
  
  @Deprecated
  public final void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.mTencentMap == null) {}
  }
  
  public final void setForeignLanguage(com.tencent.mapsdk.raster.model.Language paramLanguage)
  {
    AppMethodBeat.i(217482);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217482);
      return;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramLanguage != null) {}
    switch (l.3.SKu[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
    }
    for (;;)
    {
      localTencentMap.setForeignLanguage(paramLanguage);
      AppMethodBeat.o(217482);
      return;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      continue;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
    }
  }
  
  public final void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(217498);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217498);
      return;
    }
    this.mTencentMap.setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(217498);
  }
  
  public final void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217472);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217472);
      return;
    }
    this.mTencentMap.setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(217472);
  }
  
  public final void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(217473);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217473);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramInt);
    AppMethodBeat.o(217473);
  }
  
  public final void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217474);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217474);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(217474);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(217475);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217475);
      return;
    }
    this.mTencentMap.setIndoorMaskColor(paramInt);
    AppMethodBeat.o(217475);
  }
  
  public final void setInfoWindowAdapter(com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(217444);
    if ((paramInfoWindowAdapter == null) && (this.SJU != null)) {
      removeInfoWindowAdapter(this.SJU);
    }
    this.SJU = paramInfoWindowAdapter;
    addInfoWindowAdapter(this.SJU);
    AppMethodBeat.o(217444);
  }
  
  public final void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217497);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217497);
      return;
    }
    this.mTencentMap.setCameraCenterProportion(paramFloat1, paramFloat2, false);
    this.mTencentMap.getUiSettings().setGestureScaleByMapCenter(true);
    AppMethodBeat.o(217497);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(217470);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217470);
      return;
    }
    this.mTencentMap.setMapStyle(paramInt);
    AppMethodBeat.o(217470);
  }
  
  public final void setMapType(int paramInt)
  {
    AppMethodBeat.i(217487);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217487);
      return;
    }
    this.mTencentMap.setMapType(paramInt);
    AppMethodBeat.o(217487);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(217511);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217511);
      return;
    }
    this.mTencentMap.setMaxZoomLevel(paramInt);
    AppMethodBeat.o(217511);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(217512);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217512);
      return;
    }
    this.mTencentMap.setMinZoomLevel(paramInt);
    AppMethodBeat.o(217512);
  }
  
  public final void setOnIndoorStateChangeListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(217471);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217471);
      return;
    }
    this.mTencentMap.setOnIndoorStateChangeListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener()
    {
      public final boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(217405);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(217405);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingDeactivated();
        AppMethodBeat.o(217405);
        return bool;
      }
      
      public final boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(217403);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(217403);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        AppMethodBeat.o(217403);
        return bool;
      }
      
      public final boolean onIndoorLevelActivated(com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(217404);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(217404);
          return false;
        }
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener localOnIndoorStateChangeListener = paramOnIndoorStateChangeListener;
        if (paramAnonymousIndoorBuilding == null) {
          paramAnonymousIndoorBuilding = null;
        }
        for (;;)
        {
          boolean bool = localOnIndoorStateChangeListener.onIndoorLevelActivated(paramAnonymousIndoorBuilding);
          AppMethodBeat.o(217404);
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
    AppMethodBeat.o(217471);
  }
  
  public final void setOnInfoWindowClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(217454);
    if ((paramOnInfoWindowClickListener == null) && (this.SKa != null)) {
      remmoveOnInfoWindowClickListener(this.SKa);
    }
    this.SKa = paramOnInfoWindowClickListener;
    addOnInfoWindowClickListener(this.SKa);
    AppMethodBeat.o(217454);
  }
  
  public final void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(217460);
    if ((paramOnMapCameraChangeListener == null) && (this.SKe != null)) {
      removeOnMapCameraChangeListener(this.SKe);
    }
    this.SKe = paramOnMapCameraChangeListener;
    addOnMapCameraChangeListener(this.SKe);
    AppMethodBeat.o(217460);
  }
  
  public final void setOnMapClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(217463);
    if ((paramOnMapClickListener == null) && (this.SKg != null)) {
      removeOnMapClickListener(this.SKg);
    }
    this.SKg = paramOnMapClickListener;
    addOnMapClickListener(this.SKg);
    AppMethodBeat.o(217463);
  }
  
  public final void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(217451);
    if ((paramOnMapLoadedListener == null) && (this.SJY != null)) {
      removeOnMapLoadedListener(this.SJY);
    }
    this.SJY = paramOnMapLoadedListener;
    addOnMapLoadedListener(this.SJY);
    AppMethodBeat.o(217451);
  }
  
  public final void setOnMapLongClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(217466);
    if ((paramOnMapLongClickListener == null) && (this.SKi != null)) {
      removeOnMapLongClickListener(this.SKi);
    }
    this.SKi = paramOnMapLongClickListener;
    addOnMapLongClickListener(this.SKi);
    AppMethodBeat.o(217466);
  }
  
  public final void setOnMapPoiClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(217469);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217469);
      return;
    }
    this.mTencentMap.setOnMapPoiClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener()
    {
      public final void onClicked(com.tencent.tencentmap.mapsdk.maps.model.MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(217402);
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
          AppMethodBeat.o(217402);
          return;
          label36:
          if ((paramAnonymousMapPoi instanceof com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi))
          {
            paramAnonymousMapPoi = (com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi)paramAnonymousMapPoi;
            paramAnonymousMapPoi = new com.tencent.mapsdk.raster.model.IndoorMapPoi(paramAnonymousMapPoi.getName(), l.a(paramAnonymousMapPoi.getPosition()), paramAnonymousMapPoi.getBuildingId(), paramAnonymousMapPoi.getBuildingName(), paramAnonymousMapPoi.getFloorName());
          }
          else
          {
            paramAnonymousMapPoi = new com.tencent.mapsdk.raster.model.MapPoi(paramAnonymousMapPoi.getName(), l.a(paramAnonymousMapPoi.getPosition()));
          }
        }
      }
    });
    AppMethodBeat.o(217469);
  }
  
  public final void setOnMarkerClickListener(com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(217457);
    if ((paramOnMarkerClickListener == null) && (this.SKc != null)) {
      removeOnMarkerClickListener(this.SKc);
    }
    this.SKc = paramOnMarkerClickListener;
    addOnMarkerClickListener(this.SKc);
    AppMethodBeat.o(217457);
  }
  
  public final void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(217448);
    if ((paramOnMarkerDraggedListener == null) && (this.SJW != null)) {
      removeOnMarkerDraggedListener(this.SJW);
    }
    this.SJW = paramOnMarkerDraggedListener;
    addOnMarkerDraggedListener(this.SJW);
    AppMethodBeat.o(217448);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217486);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217486);
      return;
    }
    this.mTencentMap.setPoisEnabled(paramBoolean);
    AppMethodBeat.o(217486);
  }
  
  public final void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217432);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217432);
      return;
    }
    this.SJS = paramBoolean;
    this.mTencentMap.setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(217432);
  }
  
  public final void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(217480);
    if ((this.mTencentMap == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(217480);
      return;
    }
    if (this.SJT != null) {
      this.mTencentMap.removeTencentMapGestureListener(this.SJT);
    }
    this.SJT = new TencentMapGestureListener()
    {
      public final boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(217406);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217406);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDoubleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(217406);
        return bool;
      }
      
      public final boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(217411);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217411);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDown(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(217411);
        return bool;
      }
      
      public final boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(217408);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217408);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onFling(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(217408);
        return bool;
      }
      
      public final boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(217410);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217410);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onLongPress(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(217410);
        return bool;
      }
      
      public final void onMapStable()
      {
        AppMethodBeat.i(217413);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217413);
          return;
        }
        paramTencentMapGestureListener.onMapStable();
        AppMethodBeat.o(217413);
      }
      
      public final boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(217409);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217409);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onScroll(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(217409);
        return bool;
      }
      
      public final boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(217407);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217407);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onSingleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(217407);
        return bool;
      }
      
      public final boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(217412);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(217412);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onUp(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(217412);
        return bool;
      }
    };
    this.mTencentMap.setTencentMapGestureListener(this.SJT);
    AppMethodBeat.o(217480);
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217494);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217494);
      return;
    }
    this.mTencentMap.setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(217494);
  }
  
  public final void setZoom(int paramInt)
  {
    AppMethodBeat.i(217418);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217418);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomTo(paramInt));
    AppMethodBeat.o(217418);
  }
  
  public final void showBuilding(boolean paramBoolean)
  {
    AppMethodBeat.i(217514);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217514);
      return;
    }
    this.mTencentMap.showBuilding(paramBoolean);
    AppMethodBeat.o(217514);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(217491);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217491);
      return;
    }
    this.mTencentMap.stopAnimation();
    AppMethodBeat.o(217491);
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(217438);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217438);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomIn());
    AppMethodBeat.o(217438);
  }
  
  public final void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217439);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217439);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(217439);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(217440);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217440);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomOut());
    AppMethodBeat.o(217440);
  }
  
  public final void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217441);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217441);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(217441);
  }
  
  public final void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(217443);
    zoomToSpan(new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(217443);
  }
  
  public final void zoomToSpan(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(217442);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(217442);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(l.c(paramLatLng1), l.c(paramLatLng2)), 0));
    AppMethodBeat.o(217442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */