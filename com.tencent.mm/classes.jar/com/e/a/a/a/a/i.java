package com.e.a.a.a.a;

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
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i
  implements com.tencent.tencentmap.mapsdk.map.TencentMap
{
  private HashMap<Integer, e> KIW;
  List<com.tencent.tencentmap.mapsdk.maps.model.Marker> KIX;
  private boolean KIY;
  private TencentMapGestureListener KIZ;
  private com.tencent.tencentmap.mapsdk.maps.TencentMap mTencentMap;
  
  public i(com.tencent.tencentmap.mapsdk.maps.TencentMap paramTencentMap)
  {
    AppMethodBeat.i(205969);
    this.KIW = new HashMap();
    this.KIX = new ArrayList();
    this.KIY = false;
    this.mTencentMap = paramTencentMap;
    AppMethodBeat.o(205969);
  }
  
  public final Circle addCircle(com.tencent.mapsdk.raster.model.CircleOptions paramCircleOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.CircleOptions localCircleOptions = null;
    AppMethodBeat.i(205972);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205972);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(205972);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCircleOptions == null) {}
    for (paramCircleOptions = localCircleOptions;; paramCircleOptions = localCircleOptions)
    {
      paramCircleOptions = new b(localTencentMap.addCircle(paramCircleOptions));
      AppMethodBeat.o(205972);
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
    AppMethodBeat.i(206026);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206026);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramCustomLayerOptions == null) {}
    for (paramCustomLayerOptions = localObject;; paramCustomLayerOptions = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(paramCustomLayerOptions.getLayerId()))
    {
      paramCustomLayerOptions = new c(localTencentMap.addCustomLayer(paramCustomLayerOptions));
      AppMethodBeat.o(206026);
      return paramCustomLayerOptions;
    }
  }
  
  public final com.tencent.mapsdk.raster.model.Marker addMarker(com.tencent.mapsdk.raster.model.MarkerOptions paramMarkerOptions)
  {
    com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions localMarkerOptions = null;
    AppMethodBeat.i(205973);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205973);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(205973);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramMarkerOptions == null) {}
    do
    {
      paramMarkerOptions = new e(this, localTencentMap.addMarker(localMarkerOptions));
      this.KIW.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
      AppMethodBeat.o(205973);
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
  
  public final Polygon addPolygon(com.tencent.mapsdk.raster.model.PolygonOptions paramPolygonOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(205975);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205975);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(205975);
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
      AppMethodBeat.o(205975);
      return paramPolygonOptions;
      com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions localPolygonOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
      List localList = l.iH(paramPolygonOptions.getPoints());
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
    AppMethodBeat.i(205974);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205974);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(205974);
      return null;
    }
    paramPolylineOptions = new f(this.mTencentMap.addPolyline(l.a(paramPolylineOptions)));
    AppMethodBeat.o(205974);
    return paramPolylineOptions;
  }
  
  public final TileOverlay addTileOverlay(com.tencent.mapsdk.raster.model.TileOverlayOptions paramTileOverlayOptions)
  {
    Object localObject = null;
    com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions localTileOverlayOptions = null;
    AppMethodBeat.i(206021);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206021);
      return null;
    }
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(206021);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramTileOverlayOptions == null)
    {
      paramTileOverlayOptions = localTileOverlayOptions;
      paramTileOverlayOptions = new k(localTencentMap.addTileOverlay(paramTileOverlayOptions));
      AppMethodBeat.o(206021);
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
    AppMethodBeat.i(205987);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205987);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(205987);
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(205988);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205988);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.animateCamera(l.a(paramCameraUpdate, this.mTencentMap), paramLong, new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(205959);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onCancel();
          }
          AppMethodBeat.o(205959);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(205958);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onFinish();
          }
          AppMethodBeat.o(205958);
        }
      });
    }
    AppMethodBeat.o(205988);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(205976);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205976);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)));
    }
    AppMethodBeat.o(205976);
  }
  
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(205978);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205978);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), paramLong, new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(205957);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(205957);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(205956);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(205956);
      }
    });
    AppMethodBeat.o(205978);
  }
  
  @Deprecated
  public final void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, final Runnable paramRunnable)
  {
    AppMethodBeat.i(205977);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205977);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.animateCamera(CameraUpdateFactory.newLatLng(l.c(paramLatLng)), new TencentMap.CancelableCallback()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(205937);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(205937);
        }
        
        public final void onFinish()
        {
          AppMethodBeat.i(205936);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(205936);
        }
      });
    }
    AppMethodBeat.o(205977);
  }
  
  public final void clearAllOverlays()
  {
    AppMethodBeat.i(205979);
    if (this.mTencentMap != null) {
      this.mTencentMap.clear();
    }
    AppMethodBeat.o(205979);
  }
  
  public final boolean clearCache()
  {
    return false;
  }
  
  public final void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(206015);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206015);
      return;
    }
    this.mTencentMap.enableMultipleInfowindow(paramBoolean);
    AppMethodBeat.o(206015);
  }
  
  public final String getActivedIndoorBuilding(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(206012);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206012);
      return null;
    }
    paramLatLng = this.mTencentMap.getActivedIndoorBuilding(l.c(paramLatLng));
    AppMethodBeat.o(206012);
    return paramLatLng;
  }
  
  public final String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(206013);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206013);
      return null;
    }
    String[] arrayOfString = this.mTencentMap.getActivedIndoorFloorNames();
    AppMethodBeat.o(206013);
    return arrayOfString;
  }
  
  public final com.tencent.mapsdk.raster.model.CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(206019);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206019);
      return null;
    }
    com.tencent.mapsdk.raster.model.CameraPosition localCameraPosition = l.a(this.mTencentMap.getCameraPosition());
    AppMethodBeat.o(206019);
    return localCameraPosition;
  }
  
  public final String getDebugError()
  {
    AppMethodBeat.i(206020);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206020);
      return null;
    }
    String str = this.mTencentMap.getDebugError();
    AppMethodBeat.o(206020);
    return str;
  }
  
  public final int getIndoorFloorId()
  {
    AppMethodBeat.i(206014);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206014);
      return 0;
    }
    int i = this.mTencentMap.getIndoorFloorId();
    AppMethodBeat.o(206014);
    return i;
  }
  
  public final com.tencent.mapsdk.raster.model.LatLng getMapCenter()
  {
    AppMethodBeat.i(205980);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205980);
      return null;
    }
    this.mTencentMap.getCameraPosition();
    com.tencent.mapsdk.raster.model.LatLng localLatLng = l.a(this.mTencentMap.getCameraPosition().target);
    AppMethodBeat.o(205980);
    return localLatLng;
  }
  
  public final int getMapType()
  {
    AppMethodBeat.i(206024);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206024);
      return 1000;
    }
    int i = this.mTencentMap.getMapType();
    AppMethodBeat.o(206024);
    return i;
  }
  
  public final int getMaxZoomLevel()
  {
    AppMethodBeat.i(205982);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205982);
      return 19;
    }
    int i = (int)this.mTencentMap.getMaxZoomLevel();
    AppMethodBeat.o(205982);
    return i;
  }
  
  public final int getMinZoomLevel()
  {
    AppMethodBeat.i(205983);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205983);
      return 4;
    }
    int i = (int)this.mTencentMap.getMinZoomLevel();
    AppMethodBeat.o(205983);
    return i;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(206025);
    h localh = new h(this.mTencentMap);
    AppMethodBeat.o(206025);
    return localh;
  }
  
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(206028);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206028);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(205954);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(205954);
      }
    });
    AppMethodBeat.o(206028);
  }
  
  @Deprecated
  public final void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(206029);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206029);
      return;
    }
    this.mTencentMap.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public final void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(205955);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(205955);
      }
    });
    AppMethodBeat.o(206029);
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(205984);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205984);
      return null;
    }
    String str = this.mTencentMap.getVersion();
    AppMethodBeat.o(205984);
    return str;
  }
  
  public final int getZoomLevel()
  {
    AppMethodBeat.i(205981);
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null))
    {
      AppMethodBeat.o(205981);
      return -1;
    }
    int i = (int)this.mTencentMap.getCameraPosition().zoom;
    AppMethodBeat.o(205981);
    return i;
  }
  
  public final boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public final boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(206035);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206035);
      return false;
    }
    boolean bool = this.mTencentMap.isHandDrawMapEnable();
    AppMethodBeat.o(206035);
    return bool;
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.KIY;
  }
  
  public final boolean isTrafficEnabled()
  {
    AppMethodBeat.i(206031);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206031);
      return false;
    }
    boolean bool = this.mTencentMap.isTrafficEnabled();
    AppMethodBeat.o(206031);
    return bool;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(205986);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205986);
      return;
    }
    if (paramCameraUpdate != null) {
      this.mTencentMap.moveCamera(l.a(paramCameraUpdate, this.mTencentMap));
    }
    AppMethodBeat.o(205986);
  }
  
  public final void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(206017);
    this.mTencentMap.removeTencentMapGestureListener(this.KIZ);
    AppMethodBeat.o(206017);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205989);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205989);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2));
    AppMethodBeat.o(205989);
  }
  
  public final void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(205990);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205990);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), new TencentMap.CancelableCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(205961);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(205961);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(205960);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(205960);
      }
    });
    AppMethodBeat.o(205990);
  }
  
  public final void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(206032);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206032);
      return;
    }
    this.mTencentMap.setBuildingEnable(paramBoolean);
    AppMethodBeat.o(206032);
  }
  
  public final void setCenter(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(205970);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205970);
      return;
    }
    if (paramLatLng != null) {
      this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(205970);
  }
  
  @Deprecated
  public final void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.mTencentMap == null) {}
  }
  
  public final void setForeignLanguage(com.tencent.mapsdk.raster.model.Language paramLanguage)
  {
    AppMethodBeat.i(206018);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206018);
      return;
    }
    com.tencent.tencentmap.mapsdk.maps.TencentMap localTencentMap = this.mTencentMap;
    if (paramLanguage != null) {}
    switch (l.3.KJs[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
    }
    for (;;)
    {
      localTencentMap.setForeignLanguage(paramLanguage);
      AppMethodBeat.o(206018);
      return;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      continue;
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
    }
  }
  
  public final void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(206034);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206034);
      return;
    }
    this.mTencentMap.setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(206034);
  }
  
  public final void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206008);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206008);
      return;
    }
    this.mTencentMap.setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(206008);
  }
  
  public final void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(206009);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206009);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramInt);
    AppMethodBeat.o(206009);
  }
  
  public final void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206010);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206010);
      return;
    }
    this.mTencentMap.setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(206010);
  }
  
  public final void setIndoorMaskColor(int paramInt)
  {
    AppMethodBeat.i(206011);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206011);
      return;
    }
    this.mTencentMap.setIndoorMaskColor(paramInt);
    AppMethodBeat.o(206011);
  }
  
  public final void setInfoWindowAdapter(final com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(205997);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205997);
      return;
    }
    this.mTencentMap.setInfoWindowAdapter(new com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter()
    {
      public final View getInfoContents(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        return null;
      }
      
      public final View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(205962);
        if (paramInfoWindowAdapter != null)
        {
          paramAnonymousMarker = paramInfoWindowAdapter.getInfoWindow(i.a(i.this, paramAnonymousMarker));
          AppMethodBeat.o(205962);
          return paramAnonymousMarker;
        }
        AppMethodBeat.o(205962);
        return null;
      }
    });
    AppMethodBeat.o(205997);
  }
  
  public final void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206033);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206033);
      return;
    }
    this.mTencentMap.setCameraCenterProportion(paramFloat1, paramFloat2, false);
    this.mTencentMap.getUiSettings().setGestureScaleByMapCenter(true);
    AppMethodBeat.o(206033);
  }
  
  public final void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(206006);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206006);
      return;
    }
    this.mTencentMap.setMapStyle(paramInt);
    AppMethodBeat.o(206006);
  }
  
  public final void setMapType(int paramInt)
  {
    AppMethodBeat.i(206023);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206023);
      return;
    }
    this.mTencentMap.setMapType(paramInt);
    AppMethodBeat.o(206023);
  }
  
  public final void setMaxZoomLevel(int paramInt)
  {
    AppMethodBeat.i(206036);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206036);
      return;
    }
    this.mTencentMap.setMaxZoomLevel(paramInt);
    AppMethodBeat.o(206036);
  }
  
  public final void setMinZoomLevel(int paramInt)
  {
    AppMethodBeat.i(206037);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206037);
      return;
    }
    this.mTencentMap.setMinZoomLevel(paramInt);
    AppMethodBeat.o(206037);
  }
  
  public final void setOnIndoorStateChangeListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(206007);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206007);
      return;
    }
    this.mTencentMap.setOnIndoorStateChangeListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener()
    {
      public final boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(205945);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(205945);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingDeactivated();
        AppMethodBeat.o(205945);
        return bool;
      }
      
      public final boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(205943);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(205943);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        AppMethodBeat.o(205943);
        return bool;
      }
      
      public final boolean onIndoorLevelActivated(com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(205944);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(205944);
          return false;
        }
        com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener localOnIndoorStateChangeListener = paramOnIndoorStateChangeListener;
        if (paramAnonymousIndoorBuilding == null) {
          paramAnonymousIndoorBuilding = null;
        }
        for (;;)
        {
          boolean bool = localOnIndoorStateChangeListener.onIndoorLevelActivated(paramAnonymousIndoorBuilding);
          AppMethodBeat.o(205944);
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
    AppMethodBeat.o(206007);
  }
  
  public final void setOnInfoWindowClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(206000);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206000);
      return;
    }
    this.mTencentMap.setOnInfoWindowClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener()
    {
      public final void onInfoWindowClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(205967);
        paramOnInfoWindowClickListener.onInfoWindowClick(i.a(i.this, paramAnonymousMarker));
        AppMethodBeat.o(205967);
      }
      
      public final void onInfoWindowClickLocation(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
    });
    AppMethodBeat.o(206000);
  }
  
  public final void setOnMapCameraChangeListener(final TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(206002);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206002);
      return;
    }
    this.mTencentMap.setOnCameraChangeListener(new TencentMap.OnCameraChangeListener()
    {
      public final void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(205938);
        if (paramOnMapCameraChangeListener != null) {
          paramOnMapCameraChangeListener.onCameraChange(l.a(paramAnonymousCameraPosition));
        }
        AppMethodBeat.o(205938);
      }
      
      public final void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(205939);
        if (paramOnMapCameraChangeListener != null) {
          paramOnMapCameraChangeListener.onCameraChangeFinish(l.a(paramAnonymousCameraPosition));
        }
        AppMethodBeat.o(205939);
      }
    });
    AppMethodBeat.o(206002);
  }
  
  public final void setOnMapClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(206003);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206003);
      return;
    }
    this.mTencentMap.setOnMapClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener()
    {
      public final void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramAnonymousLatLng)
      {
        AppMethodBeat.i(205940);
        if (paramOnMapClickListener != null) {
          paramOnMapClickListener.onMapClick(l.a(paramAnonymousLatLng));
        }
        AppMethodBeat.o(205940);
      }
    });
    AppMethodBeat.o(206003);
  }
  
  public final void setOnMapLoadedListener(final TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(205999);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205999);
      return;
    }
    this.mTencentMap.setOnMapLoadedCallback(new TencentMap.OnMapLoadedCallback()
    {
      public final void onMapLoaded()
      {
        AppMethodBeat.i(205966);
        if (paramOnMapLoadedListener != null) {
          paramOnMapLoadedListener.onMapLoaded();
        }
        AppMethodBeat.o(205966);
      }
    });
    AppMethodBeat.o(205999);
  }
  
  public final void setOnMapLongClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(206004);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206004);
      return;
    }
    this.mTencentMap.setOnMapLongClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener()
    {
      public final void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramAnonymousLatLng)
      {
        AppMethodBeat.i(205941);
        if (paramOnMapLongClickListener != null) {
          paramOnMapLongClickListener.onMapLongClick(l.a(paramAnonymousLatLng));
        }
        AppMethodBeat.o(205941);
      }
    });
    AppMethodBeat.o(206004);
  }
  
  public final void setOnMapPoiClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(206005);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206005);
      return;
    }
    this.mTencentMap.setOnMapPoiClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener()
    {
      public final void onClicked(com.tencent.tencentmap.mapsdk.maps.model.MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(205942);
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
          AppMethodBeat.o(205942);
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
    AppMethodBeat.o(206005);
  }
  
  public final void setOnMarkerClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(206001);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206001);
      return;
    }
    this.mTencentMap.setOnMarkerClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener()
    {
      public final boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(205968);
        if (paramOnMarkerClickListener != null)
        {
          boolean bool = paramOnMarkerClickListener.onMarkerClick(i.a(i.this, paramAnonymousMarker));
          AppMethodBeat.o(205968);
          return bool;
        }
        AppMethodBeat.o(205968);
        return false;
      }
    });
    AppMethodBeat.o(206001);
  }
  
  public final void setOnMarkerDraggedListener(final TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(205998);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205998);
      return;
    }
    this.mTencentMap.setOnMarkerDragListener(new TencentMap.OnMarkerDragListener()
    {
      public final void onMarkerDrag(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(205964);
        if (paramOnMarkerDraggedListener != null) {
          paramOnMarkerDraggedListener.onMarkerDrag(i.a(i.this, paramAnonymousMarker));
        }
        AppMethodBeat.o(205964);
      }
      
      public final void onMarkerDragEnd(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(205965);
        if (paramOnMarkerDraggedListener != null) {
          paramOnMarkerDraggedListener.onMarkerDragEnd(i.a(i.this, paramAnonymousMarker));
        }
        AppMethodBeat.o(205965);
      }
      
      public final void onMarkerDragStart(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(205963);
        if (paramOnMarkerDraggedListener != null) {
          paramOnMarkerDraggedListener.onMarkerDragStart(i.a(i.this, paramAnonymousMarker));
        }
        AppMethodBeat.o(205963);
      }
    });
    AppMethodBeat.o(205998);
  }
  
  public final void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206022);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206022);
      return;
    }
    this.mTencentMap.setPoisEnabled(paramBoolean);
    AppMethodBeat.o(206022);
  }
  
  public final void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(205985);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205985);
      return;
    }
    this.KIY = paramBoolean;
    this.mTencentMap.setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(205985);
  }
  
  public final void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(206016);
    if ((this.mTencentMap == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(206016);
      return;
    }
    if (this.KIZ != null) {
      this.mTencentMap.removeTencentMapGestureListener(this.KIZ);
    }
    this.KIZ = new TencentMapGestureListener()
    {
      public final boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205946);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205946);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDoubleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205946);
        return bool;
      }
      
      public final boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205951);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205951);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDown(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205951);
        return bool;
      }
      
      public final boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205948);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205948);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onFling(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205948);
        return bool;
      }
      
      public final boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205950);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205950);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onLongPress(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205950);
        return bool;
      }
      
      public final void onMapStable()
      {
        AppMethodBeat.i(205953);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205953);
          return;
        }
        paramTencentMapGestureListener.onMapStable();
        AppMethodBeat.o(205953);
      }
      
      public final boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205949);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205949);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onScroll(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205949);
        return bool;
      }
      
      public final boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205947);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205947);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onSingleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205947);
        return bool;
      }
      
      public final boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(205952);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(205952);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onUp(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(205952);
        return bool;
      }
    };
    this.mTencentMap.setTencentMapGestureListener(this.KIZ);
    AppMethodBeat.o(206016);
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206030);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206030);
      return;
    }
    this.mTencentMap.setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(206030);
  }
  
  public final void setZoom(int paramInt)
  {
    AppMethodBeat.i(205971);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205971);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomTo(paramInt));
    AppMethodBeat.o(205971);
  }
  
  public final void stopAnimation()
  {
    AppMethodBeat.i(206027);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(206027);
      return;
    }
    this.mTencentMap.stopAnimation();
    AppMethodBeat.o(206027);
  }
  
  public final void zoomIn()
  {
    AppMethodBeat.i(205991);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205991);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomIn());
    AppMethodBeat.o(205991);
  }
  
  public final void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205992);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205992);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(205992);
  }
  
  public final void zoomOut()
  {
    AppMethodBeat.i(205993);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205993);
      return;
    }
    this.mTencentMap.animateCamera(CameraUpdateFactory.zoomOut());
    AppMethodBeat.o(205993);
  }
  
  public final void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205994);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205994);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(205994);
  }
  
  public final void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(205996);
    zoomToSpan(new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(205996);
  }
  
  public final void zoomToSpan(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(205995);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(205995);
      return;
    }
    this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(l.c(paramLatLng1), l.c(paramLatLng2)), 0));
    AppMethodBeat.o(205995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */