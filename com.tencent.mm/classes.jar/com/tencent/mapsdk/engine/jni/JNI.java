package com.tencent.mapsdk.engine.jni;

import android.graphics.Rect;
import com.tencent.map.lib.JNIInterface;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.CityTrafficInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.mapsdk.internal.bp;
import com.tencent.mapsdk.internal.kh;
import com.tencent.mapsdk.internal.nr;
import com.tencent.mapsdk.internal.nv;
import com.tencent.mapsdk.internal.nw;
import com.tencent.mapsdk.internal.oa;
import com.tencent.mapsdk.internal.ob;
import com.tencent.mapsdk.internal.oc;
import com.tencent.mapsdk.internal.od;
import com.tencent.mapsdk.internal.oe;
import com.tencent.mapsdk.internal.of;
import com.tencent.mapsdk.internal.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.util.ArrayList;
import java.util.List;

public class JNI
{
  private JNICallback mCallback;
  private JNIInterface mJNIInterface;
  
  public static void nativeEndProfile()
  {
    try
    {
      AppMethodBeat.i(221098);
      JNIInterface.nativeEndProfile();
      AppMethodBeat.o(221098);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void nativeStartProfile()
  {
    try
    {
      AppMethodBeat.i(221093);
      JNIInterface.nativeStartProfile();
      AppMethodBeat.o(221093);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int addLineText(long paramLong, GeoPoint[] paramArrayOfGeoPoint, PolylineOptions.Text paramText)
  {
    AppMethodBeat.i(222276);
    int i = this.mJNIInterface.addLineText(paramLong, paramArrayOfGeoPoint, paramText);
    AppMethodBeat.o(222276);
    return i;
  }
  
  public boolean checkMapLoadFinishedTask(long paramLong, int paramInt)
  {
    AppMethodBeat.i(222262);
    boolean bool = this.mJNIInterface.checkMapLoadFinishedTask(paramLong, paramInt);
    AppMethodBeat.o(222262);
    return bool;
  }
  
  public void destory()
  {
    AppMethodBeat.i(221117);
    this.mCallback.destory();
    this.mCallback = null;
    this.mJNIInterface = null;
    AppMethodBeat.o(221117);
  }
  
  public VectorHeatAggregationUnit getAggregationUnit(long paramLong1, long paramLong2, LatLng paramLatLng)
  {
    AppMethodBeat.i(222213);
    paramLatLng = this.mJNIInterface.nativeGetAggregationUnit(paramLong1, paramLong2, paramLatLng);
    AppMethodBeat.o(222213);
    return paramLatLng;
  }
  
  public int getIndoorOutlineZoom(long paramLong, String paramString)
  {
    AppMethodBeat.i(222247);
    int i = this.mJNIInterface.getIndoorOutlineZoom(paramLong, paramString);
    AppMethodBeat.o(222247);
    return i;
  }
  
  public String getMapEngineRenderStatus(long paramLong)
  {
    AppMethodBeat.i(222254);
    String str = this.mJNIInterface.getMapEngineRenderStatus(paramLong);
    AppMethodBeat.o(222254);
    return str;
  }
  
  public void initCallback(nr paramnr, w paramw, nw paramnw, nv paramnv, oe paramoe, oa paramoa, od paramod, bp parambp, of paramof, oc paramoc)
  {
    AppMethodBeat.i(221104);
    this.mCallback = new JNICallback(paramnr, paramw, paramnw, paramnv, paramoe, paramoa, paramod, parambp, paramof, paramoc);
    this.mJNIInterface = new JNIInterface(this.mCallback);
    AppMethodBeat.o(221104);
  }
  
  public long nativeAddAggregatioinOverlay(long paramLong, AggregationOverlayInfo paramAggregationOverlayInfo)
  {
    AppMethodBeat.i(222114);
    paramLong = this.mJNIInterface.nativeAddAggregationOverlay(paramLong, paramAggregationOverlayInfo);
    AppMethodBeat.o(222114);
    return paramLong;
  }
  
  public long nativeAddArcLineOverlay(long paramLong, ArcLineOverlayInfo paramArcLineOverlayInfo)
  {
    AppMethodBeat.i(222142);
    paramLong = this.mJNIInterface.nativeAddArcLineOverlay(paramLong, paramArcLineOverlayInfo);
    AppMethodBeat.o(222142);
    return paramLong;
  }
  
  public int nativeAddCircle(long paramLong, CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(221347);
    int i = this.mJNIInterface.nativeAddCircle(paramLong, paramCircleInfo);
    AppMethodBeat.o(221347);
    return i;
  }
  
  public long nativeAddGroundOverlay(long paramLong, GroundOverlayInfo paramGroundOverlayInfo)
  {
    AppMethodBeat.i(222191);
    paramLong = this.mJNIInterface.nativeAddGroundOverlay(paramLong, paramGroundOverlayInfo);
    AppMethodBeat.o(222191);
    return paramLong;
  }
  
  public long nativeAddHeatmapOverlay(long paramLong, HeatmapInfo paramHeatmapInfo)
  {
    AppMethodBeat.i(222129);
    paramLong = this.mJNIInterface.nativeAddHeatmapOverlay(paramLong, paramHeatmapInfo);
    AppMethodBeat.o(222129);
    return paramLong;
  }
  
  public long nativeAddIntersectionOverlay(long paramLong, IntersectionOverlayInfo paramIntersectionOverlayInfo)
  {
    AppMethodBeat.i(222221);
    paramLong = this.mJNIInterface.nativeAddIntersectionOverlay(paramLong, paramIntersectionOverlayInfo);
    AppMethodBeat.o(222221);
    return paramLong;
  }
  
  public int nativeAddMarker(long paramLong, String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221504);
    paramInt1 = this.mJNIInterface.nativeAddMarker(paramLong, paramString, paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, paramInt2);
    AppMethodBeat.o(221504);
    return paramInt1;
  }
  
  public long nativeAddMarker2(long paramLong, MarkerInfo paramMarkerInfo)
  {
    AppMethodBeat.i(222081);
    paramLong = this.mJNIInterface.nativeAddMarker2(paramLong, paramMarkerInfo);
    AppMethodBeat.o(222081);
    return paramLong;
  }
  
  public int nativeAddMaskLayer(long paramLong, MaskLayer paramMaskLayer)
  {
    AppMethodBeat.i(221361);
    int i = this.mJNIInterface.nativeAddMaskLayer(paramLong, paramMaskLayer);
    AppMethodBeat.o(221361);
    return i;
  }
  
  public int nativeAddPolygon(long paramLong, PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(221342);
    int i = this.mJNIInterface.nativeAddPolygon(paramLong, paramPolygonInfo);
    AppMethodBeat.o(221342);
    return i;
  }
  
  public void nativeAddRouteNameSegments(long paramLong, byte[][] paramArrayOfByte, int paramInt1, GeoPoint[] paramArrayOfGeoPoint, int paramInt2)
  {
    AppMethodBeat.i(221917);
    this.mJNIInterface.nativeAddRouteNameSegments(paramLong, paramArrayOfByte, paramInt1, paramArrayOfGeoPoint, paramInt2);
    AppMethodBeat.o(221917);
  }
  
  public long nativeAddScatterOverlay(long paramLong, ScatterPlotInfo paramScatterPlotInfo)
  {
    AppMethodBeat.i(222164);
    paramLong = this.mJNIInterface.nativeAddScatterPlotOverlay(paramLong, paramScatterPlotInfo);
    AppMethodBeat.o(222164);
    return paramLong;
  }
  
  public int nativeAddTileOverlay(long paramLong, TileOverlayCallback paramTileOverlayCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(221841);
    int i = this.mJNIInterface.nativeAddTileOverlay(paramLong, paramTileOverlayCallback, paramBoolean);
    AppMethodBeat.o(221841);
    return i;
  }
  
  public long nativeAddTrailOverlay(long paramLong, TrailOverlayInfo paramTrailOverlayInfo)
  {
    AppMethodBeat.i(222175);
    paramLong = this.mJNIInterface.nativeAddTrailOverlay(paramLong, paramTrailOverlayInfo);
    AppMethodBeat.o(222175);
    return paramLong;
  }
  
  public void nativeBringElementAbove(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221895);
    this.mJNIInterface.nativeBringElementAbove(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221895);
  }
  
  public void nativeBringElementBelow(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221904);
    this.mJNIInterface.nativeBringElementBelow(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221904);
  }
  
  public void nativeCheckTrafficBlockCache(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(221323);
    this.mJNIInterface.nativeCheckTrafficBlockCache(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(221323);
  }
  
  public void nativeCheckTrafficBlockCacheForReplay(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(221328);
    this.mJNIInterface.nativeCheckTrafficBlockCacheForReplay(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(221328);
  }
  
  public int nativeClearCache(long paramLong)
  {
    AppMethodBeat.i(221272);
    int i = this.mJNIInterface.nativeClearCache(paramLong);
    AppMethodBeat.o(221272);
    return i;
  }
  
  public void nativeClearDownloadURLCache(long paramLong)
  {
    AppMethodBeat.i(221245);
    this.mJNIInterface.nativeClearDownloadURLCache(paramLong);
    AppMethodBeat.o(221245);
  }
  
  public void nativeClearRouteNameSegments(long paramLong)
  {
    AppMethodBeat.i(221923);
    this.mJNIInterface.nativeClearRouteNameSegments(paramLong);
    AppMethodBeat.o(221923);
  }
  
  public AnnocationTextResult nativeCreateAnnotationTextBitmap(long paramLong, AnnocationText paramAnnocationText)
  {
    AppMethodBeat.i(221912);
    paramAnnocationText = this.mJNIInterface.nativeCreateAnnotationText(paramLong, paramAnnocationText);
    AppMethodBeat.o(221912);
    return paramAnnocationText;
  }
  
  public int nativeCreateOrUpdateLine(long paramLong, int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, GeoPoint[] paramArrayOfGeoPoint, String paramString, float paramFloat1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat2, boolean paramBoolean5, int[] paramArrayOfInt3, int[] paramArrayOfInt4, float paramFloat3, int[] paramArrayOfInt5, float paramFloat4, int paramInt3, boolean paramBoolean6)
  {
    AppMethodBeat.i(221407);
    kh.b("TDZ", "create or update line = " + paramInt1 + " p:" + paramArrayOfGeoPoint.length + " w:" + paramFloat1 + " v:" + paramBoolean6 + " a:" + paramFloat4 + " bw:" + paramFloat3);
    paramInt1 = this.mJNIInterface.nativeCreateOrUpdateLine(paramLong, paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfGeoPoint, paramString, paramFloat1, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (int)paramFloat2, paramBoolean5, paramArrayOfInt3, paramArrayOfInt4, paramFloat3, paramArrayOfInt5, paramFloat4, paramInt3, paramBoolean6);
    AppMethodBeat.o(221407);
    return paramInt1;
  }
  
  public void nativeDeleteCircle(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221350);
    this.mJNIInterface.nativeDeleteCircle(paramLong, paramInt);
    AppMethodBeat.o(221350);
  }
  
  public void nativeDeleteIcons(long paramLong, int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(221523);
    this.mJNIInterface.nativeDeleteIcons(paramLong, paramArrayOfInt, paramInt);
    AppMethodBeat.o(221523);
  }
  
  public void nativeDeleteLine(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(221463);
    this.mJNIInterface.nativeDeleteLine(paramLong1, paramLong2, paramBoolean);
    AppMethodBeat.o(221463);
  }
  
  public void nativeDeletePolygon(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221356);
    this.mJNIInterface.nativeDeletePolygon(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221356);
  }
  
  public void nativeDestroyEngine(long paramLong)
  {
    AppMethodBeat.i(221165);
    this.mJNIInterface.nativeDestroyEngine(paramLong);
    AppMethodBeat.o(221165);
  }
  
  public boolean nativeDrawFrame(long paramLong)
  {
    AppMethodBeat.i(221203);
    boolean bool = this.mJNIInterface.nativeDrawFrame(paramLong);
    AppMethodBeat.o(221203);
    return bool;
  }
  
  public void nativeEnableBaseMap(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(222027);
    this.mJNIInterface.nativeEnableBaseMap(paramLong, paramBoolean);
    AppMethodBeat.o(222027);
  }
  
  public void nativeEnableBuilding(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(222035);
    this.mJNIInterface.nativeEnableBuilding(paramLong, paramBoolean);
    AppMethodBeat.o(222035);
  }
  
  public void nativeEnablePOI(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(222019);
    this.mJNIInterface.nativeEnablePOI(paramLong, paramBoolean);
    AppMethodBeat.o(222019);
  }
  
  public int[] nativeFetchLackedTrafficBlocks(long paramLong)
  {
    AppMethodBeat.i(221332);
    int[] arrayOfInt = this.mJNIInterface.nativeFetchLackedTrafficBlocks(paramLong);
    AppMethodBeat.o(221332);
    return arrayOfInt;
  }
  
  public void nativeFromScreenLocation(long paramLong, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(221371);
    this.mJNIInterface.nativeFromScreenLocation(paramLong, paramArrayOfByte, paramFloat1, paramFloat2, paramArrayOfDouble);
    AppMethodBeat.o(221371);
  }
  
  public float[] nativeGLProjectMatrix()
  {
    AppMethodBeat.i(221126);
    float[] arrayOfFloat = this.mJNIInterface.nativeGLProjectMatrix();
    AppMethodBeat.o(221126);
    return arrayOfFloat;
  }
  
  public double[] nativeGLViewMatrix()
  {
    AppMethodBeat.i(221130);
    double[] arrayOfDouble = this.mJNIInterface.nativeGLViewMatrix();
    AppMethodBeat.o(221130);
    return arrayOfDouble;
  }
  
  public float nativeGLViewScaleRatio()
  {
    AppMethodBeat.i(221138);
    float f = this.mJNIInterface.nativeGLViewScaleRatio();
    AppMethodBeat.o(221138);
    return f;
  }
  
  public int[] nativeGLViewport()
  {
    AppMethodBeat.i(221149);
    int[] arrayOfInt = this.mJNIInterface.nativeGLViewport();
    AppMethodBeat.o(221149);
    return arrayOfInt;
  }
  
  public boolean nativeGenerateTextures(long paramLong)
  {
    AppMethodBeat.i(221179);
    boolean bool = this.mJNIInterface.nativeGenerateTextures(paramLong);
    AppMethodBeat.o(221179);
    return bool;
  }
  
  public String nativeGetActiveIndoorBuildingGUID(long paramLong)
  {
    AppMethodBeat.i(221590);
    String str = this.mJNIInterface.nativeGetActiveIndoorBuildingGUID(paramLong);
    AppMethodBeat.o(221590);
    return str;
  }
  
  public boolean nativeGetAndResetDirty(long paramLong)
  {
    AppMethodBeat.i(222157);
    boolean bool = this.mJNIInterface.nativeGetAndResetDirty(paramLong);
    AppMethodBeat.o(222157);
    return bool;
  }
  
  public String nativeGetBlockRouteInfo(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221974);
    String str = this.mJNIInterface.nativeGetBlockRouteInfo(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221974);
    return str;
  }
  
  public void nativeGetCenterMapPoint(long paramLong, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221717);
    this.mJNIInterface.nativeGetCenterMapPoint(paramLong, paramGeoPoint);
    AppMethodBeat.o(221717);
  }
  
  public byte[] nativeGetCityName(long paramLong, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221382);
    paramGeoPoint = this.mJNIInterface.nativeGetCityName(paramLong, paramGeoPoint);
    AppMethodBeat.o(221382);
    return paramGeoPoint;
  }
  
  public String nativeGetCurIndoorName(long paramLong, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221599);
    paramGeoPoint = this.mJNIInterface.nativeGetCurIndoorName(paramLong, paramGeoPoint);
    AppMethodBeat.o(221599);
    return paramGeoPoint;
  }
  
  public String nativeGetDataEngineVersion(long paramLong)
  {
    AppMethodBeat.i(222052);
    String str = this.mJNIInterface.nativeGetDataEngineVersion(paramLong);
    AppMethodBeat.o(222052);
    return str;
  }
  
  public int nativeGetEngineId(long paramLong)
  {
    AppMethodBeat.i(222094);
    int i = this.mJNIInterface.nativeGetEngineId(paramLong);
    AppMethodBeat.o(222094);
    return i;
  }
  
  public String nativeGetEngineLogInfo(long paramLong)
  {
    AppMethodBeat.i(222074);
    String str = this.mJNIInterface.nativeGetEngineLogInfo(paramLong);
    AppMethodBeat.o(222074);
    return str;
  }
  
  public Rect nativeGetIndoorBound(long paramLong)
  {
    AppMethodBeat.i(221612);
    Rect localRect = this.mJNIInterface.nativeGetIndoorBound(paramLong);
    AppMethodBeat.o(221612);
    return localRect;
  }
  
  public int nativeGetIndoorCurrentFloorId(long paramLong)
  {
    AppMethodBeat.i(221605);
    int i = this.mJNIInterface.nativeGetIndoorCurrentFloorId(paramLong);
    AppMethodBeat.o(221605);
    return i;
  }
  
  public String[] nativeGetIndoorFloorNames(long paramLong)
  {
    AppMethodBeat.i(221584);
    String[] arrayOfString = this.mJNIInterface.nativeGetIndoorFloorNames(paramLong);
    AppMethodBeat.o(221584);
    return arrayOfString;
  }
  
  public int nativeGetLanguage(long paramLong)
  {
    AppMethodBeat.i(221939);
    int i = this.mJNIInterface.nativeGetLanguage(paramLong);
    AppMethodBeat.o(221939);
    return i;
  }
  
  public String nativeGetMapEngineVersion(long paramLong)
  {
    AppMethodBeat.i(222046);
    String str = this.mJNIInterface.nativeGetDataEngineVersion(paramLong);
    AppMethodBeat.o(222046);
    return str;
  }
  
  public int nativeGetMapStyle(long paramLong)
  {
    AppMethodBeat.i(221834);
    int i = this.mJNIInterface.nativeGetMapStyle(paramLong);
    AppMethodBeat.o(221834);
    return i;
  }
  
  public ArrayList nativeGetPoisInScreen(long paramLong)
  {
    AppMethodBeat.i(222064);
    ArrayList localArrayList = this.mJNIInterface.nativeGetPoisInScreen(paramLong);
    AppMethodBeat.o(222064);
    return localArrayList;
  }
  
  public float nativeGetRotate(long paramLong)
  {
    AppMethodBeat.i(221827);
    float f = this.mJNIInterface.nativeGetRotate(paramLong);
    AppMethodBeat.o(221827);
    return f;
  }
  
  public double nativeGetScale(long paramLong)
  {
    AppMethodBeat.i(221732);
    double d = this.mJNIInterface.nativeGetScale(paramLong);
    AppMethodBeat.o(221732);
    return d;
  }
  
  public int nativeGetScaleLevel(long paramLong)
  {
    AppMethodBeat.i(221748);
    int i = this.mJNIInterface.nativeGetScaleLevel(paramLong);
    AppMethodBeat.o(221748);
    return i;
  }
  
  public float nativeGetSkew(long paramLong)
  {
    AppMethodBeat.i(221823);
    float f = this.mJNIInterface.nativeGetSkew(paramLong);
    AppMethodBeat.o(221823);
    return f;
  }
  
  public double nativeGetTargetScale(long paramLong, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(221559);
    double d = this.mJNIInterface.nativeGetTargetScale(paramLong, paramRect1, paramRect2);
    AppMethodBeat.o(221559);
    return d;
  }
  
  public boolean nativeGetTrafficCityInfo(long paramLong, String paramString, CityTrafficInfo paramCityTrafficInfo)
  {
    AppMethodBeat.i(221337);
    boolean bool = this.mJNIInterface.nativeGetTrafficCityInfo(paramLong, paramString, paramCityTrafficInfo);
    AppMethodBeat.o(221337);
    return bool;
  }
  
  public boolean nativeHasStreetRoad(long paramLong, String paramString)
  {
    AppMethodBeat.i(221283);
    boolean bool = this.mJNIInterface.nativeHasStreetRoad(paramLong, paramString);
    AppMethodBeat.o(221283);
    return bool;
  }
  
  public void nativeHideCompass(long paramLong)
  {
    AppMethodBeat.i(221278);
    this.mJNIInterface.nativeHideCompass(paramLong);
    AppMethodBeat.o(221278);
  }
  
  public void nativeHideIcons(long paramLong, int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(221530);
    this.mJNIInterface.nativeHideIcons(paramLong, paramArrayOfInt, paramInt);
    AppMethodBeat.o(221530);
  }
  
  public void nativeHideStreetRoad(long paramLong)
  {
    AppMethodBeat.i(221292);
    this.mJNIInterface.nativeHideStreetRoad(paramLong);
    AppMethodBeat.o(221292);
  }
  
  public void nativeHideTraffic(long paramLong)
  {
    AppMethodBeat.i(221309);
    this.mJNIInterface.nativeHideTraffic(paramLong);
    AppMethodBeat.o(221309);
  }
  
  public void nativeIndoorBuildingEnabled(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221568);
    this.mJNIInterface.nativeIndoorBuildingEnabled(paramLong, paramBoolean);
    AppMethodBeat.o(221568);
  }
  
  public long nativeInitEngine(String paramString1, String paramString2, String paramString3, float paramFloat1, int paramInt1, float paramFloat2, int[] paramArrayOfInt, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(221156);
    long l = this.mJNIInterface.nativeInitEngine(paramString1, paramString2, paramString3, paramFloat1, paramInt1, paramFloat2, paramArrayOfInt, paramBoolean, paramInt2);
    AppMethodBeat.o(221156);
    return l;
  }
  
  public int nativeIsCityHasTraffic(long paramLong, String paramString)
  {
    AppMethodBeat.i(221334);
    int i = this.mJNIInterface.nativeIsCityHasTraffic(paramLong, paramString);
    AppMethodBeat.o(221334);
    return i;
  }
  
  @Deprecated
  public boolean nativeIsMapDrawFinished(long paramLong)
  {
    AppMethodBeat.i(221269);
    boolean bool = this.mJNIInterface.nativeIsMapDrawFinished(paramLong);
    AppMethodBeat.o(221269);
    return bool;
  }
  
  public boolean nativeIsTileOverlayEnabled(long paramLong)
  {
    AppMethodBeat.i(221873);
    boolean bool = this.mJNIInterface.nativeIsTileOverlayEnabled(paramLong);
    AppMethodBeat.o(221873);
    return bool;
  }
  
  public void nativeLineClearPoint(long paramLong1, long paramLong2, GeoPoint paramGeoPoint, int paramInt)
  {
    AppMethodBeat.i(221440);
    this.mJNIInterface.nativeLineClearPoint(paramLong1, paramLong2, paramGeoPoint, paramInt);
    AppMethodBeat.o(221440);
  }
  
  public void nativeLineInsertPoint(long paramLong1, long paramLong2, GeoPoint paramGeoPoint, int paramInt)
  {
    AppMethodBeat.i(221433);
    this.mJNIInterface.nativeLineInsertPoint(paramLong1, paramLong2, paramGeoPoint, paramInt);
    AppMethodBeat.o(221433);
  }
  
  public void nativeLoadBlockRouteCityList(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(221951);
    this.mJNIInterface.nativeLoadBlockRouteCityList(paramLong, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    AppMethodBeat.o(221951);
  }
  
  public void nativeLockEngine(long paramLong)
  {
    AppMethodBeat.i(221252);
    this.mJNIInterface.nativeLockEngine(paramLong);
    AppMethodBeat.o(221252);
  }
  
  public void nativeMapLoadKMLFile(long paramLong, String paramString)
  {
    AppMethodBeat.i(221958);
    this.mJNIInterface.nativeMapLoadKMLFile(paramLong, paramString);
    AppMethodBeat.o(221958);
  }
  
  public void nativeMapSetSatelliteServerFullUrl(long paramLong, String paramString)
  {
    AppMethodBeat.i(222010);
    this.mJNIInterface.nativeMapSetSatelliteServerFullUrl(paramLong, paramString);
    AppMethodBeat.o(222010);
  }
  
  public void nativeMoveBy(long paramLong, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(221697);
    this.mJNIInterface.nativeMoveBy(paramLong, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(221697);
  }
  
  public boolean nativeNeedDispaly(long paramLong)
  {
    AppMethodBeat.i(221207);
    boolean bool = this.mJNIInterface.nativeNeedDispaly(paramLong);
    AppMethodBeat.o(221207);
    return bool;
  }
  
  public boolean nativeNeedRedraw(long paramLong)
  {
    AppMethodBeat.i(221223);
    boolean bool = this.mJNIInterface.nativeNeedRedraw(paramLong);
    AppMethodBeat.o(221223);
    return bool;
  }
  
  public byte[] nativeOnTap(long paramLong, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221230);
    byte[] arrayOfByte = this.mJNIInterface.nativeOnTap(paramLong, paramFloat1, paramFloat2);
    AppMethodBeat.o(221230);
    return arrayOfByte;
  }
  
  public boolean nativeOnTapLine(long paramLong, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221469);
    boolean bool = this.mJNIInterface.nativeOnTapLine(paramLong, paramFloat1, paramFloat2);
    AppMethodBeat.o(221469);
    return bool;
  }
  
  public int nativeQueryCityCodeList(long paramLong, Rect paramRect, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(221945);
    paramInt1 = this.mJNIInterface.nativeQueryCityCodeList(paramLong, paramRect, paramInt1, paramArrayOfInt, paramInt2);
    AppMethodBeat.o(221945);
    return paramInt1;
  }
  
  public int nativeRefreshTrafficData(long paramLong, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(221319);
    paramInt = this.mJNIInterface.nativeRefreshTrafficData(paramLong, paramArrayOfByte, paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(221319);
    return paramInt;
  }
  
  public void nativeReleaseEngineResource(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221980);
    this.mJNIInterface.nativeReleaseEngineResource(paramLong, paramBoolean);
    AppMethodBeat.o(221980);
  }
  
  public void nativeReloadTileOverlay(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221863);
    this.mJNIInterface.nativeReloadTileOverlay(paramLong, paramInt);
    AppMethodBeat.o(221863);
  }
  
  public void nativeRemoveEngineOverlay(long paramLong)
  {
    AppMethodBeat.i(222106);
    this.mJNIInterface.nativeRemoveEngineOverlay(paramLong);
    AppMethodBeat.o(222106);
  }
  
  public void nativeRemoveGLVisualizationOverlay(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(222208);
    this.mJNIInterface.nativeRemoveGLVisualizationOverlay(paramLong1, paramLong2);
    AppMethodBeat.o(222208);
  }
  
  public void nativeRemoveMaskLayer(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221367);
    this.mJNIInterface.nativeRemoveMaskLayer(paramLong, paramInt);
    AppMethodBeat.o(221367);
  }
  
  public void nativeRemovePolygon(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221344);
    this.mJNIInterface.nativeDeletePolygon(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221344);
  }
  
  public void nativeRemoveTileOverlay(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221857);
    this.mJNIInterface.nativeRemoveTileOverlay(paramLong, paramInt);
    AppMethodBeat.o(221857);
  }
  
  public void nativeResetEnginePath(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221170);
    this.mJNIInterface.nativeResetEnginePath(paramLong, paramString1, paramString2, paramString3);
    AppMethodBeat.o(221170);
  }
  
  public void nativeSetBlockRouteVisible(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221966);
    this.mJNIInterface.nativeSetBlockRouteVisible(paramLong, paramBoolean);
    AppMethodBeat.o(221966);
  }
  
  public void nativeSetBuilding3DEffect(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221340);
    this.mJNIInterface.nativeSetBuilding3DEffect(paramLong, paramBoolean);
    AppMethodBeat.o(221340);
  }
  
  public void nativeSetBuildingToSpecificFloor(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(222058);
    this.mJNIInterface.nativeSetBuildingToSpecificFloor(paramLong, paramString1, paramString2);
    AppMethodBeat.o(222058);
  }
  
  public void nativeSetCallback(long paramLong)
  {
    AppMethodBeat.i(221220);
    this.mJNIInterface.nativeSetCallback(paramLong);
    AppMethodBeat.o(221220);
  }
  
  public void nativeSetCenter(long paramLong, GeoPoint paramGeoPoint, boolean paramBoolean)
  {
    AppMethodBeat.i(221706);
    this.mJNIInterface.nativeSetCenter(paramLong, paramGeoPoint, paramBoolean);
    AppMethodBeat.o(221706);
  }
  
  public void nativeSetCenterMapPointAndScaleLevel(long paramLong, GeoPoint paramGeoPoint, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221711);
    this.mJNIInterface.nativeSetCenterMapPointAndScaleLevel(paramLong, paramGeoPoint, paramInt, paramBoolean);
    AppMethodBeat.o(221711);
  }
  
  public void nativeSetCompassImage(long paramLong, String paramString)
  {
    AppMethodBeat.i(221553);
    this.mJNIInterface.nativeSetCompassImage(paramLong, paramString);
    AppMethodBeat.o(221553);
  }
  
  public void nativeSetCompassPosition(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221548);
    this.mJNIInterface.nativeSetCompassPosition(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221548);
  }
  
  public void nativeSetCompassVisible(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221541);
    this.mJNIInterface.nativeSetCompassVisible(paramLong, paramBoolean);
    AppMethodBeat.o(221541);
  }
  
  public void nativeSetDrawCap(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(221477);
    this.mJNIInterface.nativeSetDrawCap(paramLong1, paramLong2, paramBoolean);
    AppMethodBeat.o(221477);
  }
  
  public void nativeSetFlagOfZoomToSpanForLocation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(221773);
    this.mJNIInterface.nativeSetFlagOfZoomToSpanForLocation(paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(221773);
  }
  
  public void nativeSetIconsHidden(long paramLong, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221536);
    this.mJNIInterface.nativeSetIconsHidden(paramLong, paramArrayOfInt, paramInt, paramBoolean);
    AppMethodBeat.o(221536);
  }
  
  public void nativeSetIndoorActiveScreenArea(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(221623);
    this.mJNIInterface.nativeSetIndoorActiveScreenArea(paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(221623);
  }
  
  public void nativeSetIndoorBuildingPickEnabled(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221632);
    this.mJNIInterface.nativeSetIndoorBuildingPickEnabled(paramLong, paramBoolean);
    AppMethodBeat.o(221632);
  }
  
  public void nativeSetIndoorBuildingStyle(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221576);
    kh.b("TDZ", "nativeSetIndoorBuildingStyle:".concat(String.valueOf(paramInt)));
    this.mJNIInterface.nativeSetIndoorBuildingStyle(paramLong, paramInt);
    AppMethodBeat.o(221576);
  }
  
  public void nativeSetIndoorConfigType(long paramLong, int paramInt)
  {
    AppMethodBeat.i(222303);
    this.mJNIInterface.nativeSetIndoorConfigType(paramLong, paramInt);
    AppMethodBeat.o(222303);
  }
  
  public void nativeSetIndoorFloor(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221581);
    this.mJNIInterface.nativeSetIndoorFloor(paramLong, paramInt);
    AppMethodBeat.o(221581);
  }
  
  public void nativeSetIndoorMaskColor(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221618);
    this.mJNIInterface.nativeSetIndoorMaskColor(paramLong, paramInt);
    AppMethodBeat.o(221618);
  }
  
  public void nativeSetLanguage(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221930);
    this.mJNIInterface.nativeSetLanguage(paramLong, paramInt);
    AppMethodBeat.o(221930);
  }
  
  public void nativeSetLineArrowSpacing(long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221991);
    this.mJNIInterface.nativeSetLineArrowSpacing(paramLong, paramInt, paramFloat);
    AppMethodBeat.o(221991);
  }
  
  public void nativeSetLineDirectionArrowTextureName(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(221427);
    this.mJNIInterface.nativeSetLineDirectionArrowTextureName(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(221427);
  }
  
  public void nativeSetLineDrawArrow(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(221449);
    this.mJNIInterface.nativeSetLineDrawArrow(paramLong1, paramLong2, paramBoolean);
    AppMethodBeat.o(221449);
  }
  
  public void nativeSetLineFootPrintSpacing(long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221998);
    this.mJNIInterface.nativeSetLineFootPrintSpacing(paramLong, paramInt, paramFloat);
    AppMethodBeat.o(221998);
  }
  
  public void nativeSetLineSelected(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(221457);
    this.mJNIInterface.nativeSetLineSelected(paramLong1, paramLong2, paramBoolean);
    AppMethodBeat.o(221457);
  }
  
  public void nativeSetLocationCircleColor(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221653);
    this.mJNIInterface.nativeSetLocationCircleColor(paramLong, paramInt);
    AppMethodBeat.o(221653);
  }
  
  public void nativeSetLocationCircleHidden(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221661);
    this.mJNIInterface.nativeSetLocationCircleHidden(paramLong, paramBoolean);
    AppMethodBeat.o(221661);
  }
  
  public void nativeSetLocationCompassMarkerHidden(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221688);
    this.mJNIInterface.nativeSetLocationCompassMarkerHidden(paramLong, paramBoolean);
    AppMethodBeat.o(221688);
  }
  
  public void nativeSetLocationCompassMarkerImage(long paramLong, String paramString)
  {
    AppMethodBeat.i(221680);
    this.mJNIInterface.nativeSetLocationCompassMarkerImage(paramLong, paramString);
    AppMethodBeat.o(221680);
  }
  
  public void nativeSetLocationFollow(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(221492);
    this.mJNIInterface.nativeSetLocationFollow(paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    AppMethodBeat.o(221492);
  }
  
  public void nativeSetLocationHeading(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(221497);
    this.mJNIInterface.nativeSetLocationHeading(paramLong, paramFloat);
    AppMethodBeat.o(221497);
  }
  
  public void nativeSetLocationInfo(long paramLong, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(221485);
    this.mJNIInterface.nativeSetLocationInfo(paramLong, paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(221485);
  }
  
  public void nativeSetLocationMarkerHidden(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221670);
    this.mJNIInterface.nativeSetLocationMarkerHidden(paramLong, paramBoolean);
    AppMethodBeat.o(221670);
  }
  
  public int nativeSetLocationMarkerImage(long paramLong, String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221645);
    int i = this.mJNIInterface.nativeSetLocationMarkerImage(paramLong, paramString, paramFloat1, paramFloat2);
    AppMethodBeat.o(221645);
    return i;
  }
  
  public void nativeSetMapFontSize(long paramLong, int paramInt)
  {
    AppMethodBeat.i(222317);
    this.mJNIInterface.nativeSetMapFontSize(paramLong, paramInt);
    AppMethodBeat.o(222317);
  }
  
  public void nativeSetMapParam(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221191);
    this.mJNIInterface.nativeSetMapParam(paramLong, paramArrayOfByte);
    AppMethodBeat.o(221191);
  }
  
  public void nativeSetMapStyle(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221814);
    this.mJNIInterface.nativeSetMapStyle(paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(221814);
  }
  
  public void nativeSetMarkerMainSubRelation(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222308);
    this.mJNIInterface.nativeSetMarkerMainSubRelation(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(222308);
  }
  
  public void nativeSetMarkerScaleLevelRange(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221753);
    this.mJNIInterface.nativeSetMarkerScaleLevelRange(paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(221753);
  }
  
  public void nativeSetMaxScaleLevel(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221789);
    this.mJNIInterface.nativeSetMaxScaleLevel(paramLong, paramInt);
    AppMethodBeat.o(221789);
  }
  
  public void nativeSetMinScaleLevel(long paramLong, int paramInt)
  {
    AppMethodBeat.i(221795);
    this.mJNIInterface.nativeSetMinScaleLevel(paramLong, paramInt);
    AppMethodBeat.o(221795);
  }
  
  public void nativeSetNeedDisplay(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221212);
    this.mJNIInterface.nativeSetNeedDisplay(paramLong, paramBoolean);
    AppMethodBeat.o(221212);
  }
  
  public void nativeSetPolygonHidden(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(221354);
    nativeSetIconsHidden(paramLong, new int[] { paramInt1, paramInt2 }, 2, paramBoolean);
    AppMethodBeat.o(221354);
  }
  
  public void nativeSetPriority(long paramLong, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(221396);
    this.mJNIInterface.nativeSetPriority(paramLong, paramInt, paramFloat);
    AppMethodBeat.o(221396);
  }
  
  public void nativeSetRotate(long paramLong, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(221803);
    this.mJNIInterface.nativeSetRotate(paramLong, paramFloat, paramBoolean);
    AppMethodBeat.o(221803);
  }
  
  public void nativeSetSatelliteEnabled(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221298);
    this.mJNIInterface.nativeSetSatelliteEnabled(paramLong, paramBoolean);
    AppMethodBeat.o(221298);
  }
  
  public void nativeSetScale(long paramLong, double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(221724);
    this.mJNIInterface.nativeSetScale(paramLong, paramDouble, paramBoolean);
    AppMethodBeat.o(221724);
  }
  
  public void nativeSetScaleLevel(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221743);
    this.mJNIInterface.nativeSetScaleLevel(paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(221743);
  }
  
  public void nativeSetScreenCenterOffset(long paramLong, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(221782);
    this.mJNIInterface.nativeSetScreenCenterOffset(paramLong, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(221782);
  }
  
  public void nativeSetServerHost(long paramLong, String paramString)
  {
    AppMethodBeat.i(222004);
    this.mJNIInterface.nativeSetServerHost(paramLong, paramString);
    AppMethodBeat.o(222004);
  }
  
  public void nativeSetShowIndoorBuildingWhiteList(long paramLong, String[] paramArrayOfString)
  {
    AppMethodBeat.i(221638);
    this.mJNIInterface.nativeSetShowIndoorBuildingWhiteList(paramLong, paramArrayOfString);
    AppMethodBeat.o(221638);
  }
  
  public void nativeSetSkew(long paramLong, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(221808);
    this.mJNIInterface.nativeSetSkew(paramLong, paramFloat, paramBoolean);
    AppMethodBeat.o(221808);
  }
  
  public void nativeSetTileOverlayDataLevelRange(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221887);
    this.mJNIInterface.nativeSetTileOverlayDataLevelRange(paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(221887);
  }
  
  public void nativeSetTileOverlayEnabled(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(221881);
    this.mJNIInterface.nativeSetTileOverlayEnabled(paramLong, paramBoolean);
    AppMethodBeat.o(221881);
  }
  
  public void nativeSetTileOverlayPriority(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221848);
    this.mJNIInterface.nativeSetTileOverlayPriority(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221848);
  }
  
  public void nativeSetTrafficColor(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(221314);
    this.mJNIInterface.nativeSetTrafficColor(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(221314);
  }
  
  public void nativeSetTurnArrow(long paramLong1, long paramLong2, List<GeoPoint> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221414);
    if (paramList != null)
    {
      paramList = (GeoPoint[])paramList.toArray(new GeoPoint[0]);
      this.mJNIInterface.nativeSetTurnArrow(paramLong1, paramLong2, paramList, paramInt1, paramInt2);
    }
    AppMethodBeat.o(221414);
  }
  
  public void nativeSetTurnArrowStyle(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221420);
    this.mJNIInterface.nativeSetTurnArrowStyle(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(221420);
  }
  
  public void nativeSetViewport(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(221185);
    this.mJNIInterface.nativeSetViewport(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(221185);
  }
  
  public void nativeShowStreetRoad(long paramLong)
  {
    AppMethodBeat.i(221287);
    this.mJNIInterface.nativeShowStreetRoad(paramLong);
    AppMethodBeat.o(221287);
  }
  
  public void nativeShowTraffic(long paramLong)
  {
    AppMethodBeat.i(221304);
    this.mJNIInterface.nativeShowTraffic(paramLong);
    AppMethodBeat.o(221304);
  }
  
  public void nativeToScreenLocation(long paramLong, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221377);
    this.mJNIInterface.nativeToScreenLocation(paramLong, paramArrayOfByte, paramDouble1, paramDouble2, paramArrayOfFloat);
    AppMethodBeat.o(221377);
  }
  
  public void nativeUnlockEngine(long paramLong)
  {
    AppMethodBeat.i(221258);
    this.mJNIInterface.nativeUnlockEngine(paramLong);
    AppMethodBeat.o(221258);
  }
  
  public void nativeUpdateAggregatioinOverlay(long paramLong1, long paramLong2, AggregationOverlayInfo paramAggregationOverlayInfo)
  {
    AppMethodBeat.i(222121);
    this.mJNIInterface.nativeUpdateAggregationOverlay(paramLong1, paramLong2, paramAggregationOverlayInfo);
    AppMethodBeat.o(222121);
  }
  
  public void nativeUpdateArcLineOverlay(long paramLong1, long paramLong2, ArcLineOverlayInfo paramArcLineOverlayInfo)
  {
    AppMethodBeat.i(222151);
    this.mJNIInterface.nativeUpdateArcLineOverlay(paramLong1, paramLong2, paramArcLineOverlayInfo);
    AppMethodBeat.o(222151);
  }
  
  public void nativeUpdateCircle(long paramLong, int paramInt, CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(221348);
    this.mJNIInterface.nativeUpdateCircle(paramLong, paramInt, paramCircleInfo);
    AppMethodBeat.o(221348);
  }
  
  public void nativeUpdateFrame(long paramLong, double paramDouble)
  {
    AppMethodBeat.i(221195);
    this.mJNIInterface.nativeUpdateFrame(paramLong, paramDouble);
    AppMethodBeat.o(221195);
  }
  
  public void nativeUpdateGroundOverlay(long paramLong1, long paramLong2, GroundOverlayInfo paramGroundOverlayInfo)
  {
    AppMethodBeat.i(222201);
    this.mJNIInterface.nativeUpdateGroundOverlay(paramLong1, paramLong2, paramGroundOverlayInfo);
    AppMethodBeat.o(222201);
  }
  
  public void nativeUpdateHeatmapOverlay(long paramLong1, long paramLong2, HeatmapInfo paramHeatmapInfo)
  {
    AppMethodBeat.i(222135);
    this.mJNIInterface.nativeUpdateHeatmapOverlay(paramLong1, paramLong2, paramHeatmapInfo);
    AppMethodBeat.o(222135);
  }
  
  public void nativeUpdateIntersectionOverlay(long paramLong, IntersectionOverlayInfo paramIntersectionOverlayInfo)
  {
    AppMethodBeat.i(222229);
    this.mJNIInterface.nativeUpdateIntersectionOverlay(paramLong, paramIntersectionOverlayInfo);
    AppMethodBeat.o(222229);
  }
  
  public void nativeUpdateMapResource(long paramLong, String paramString)
  {
    AppMethodBeat.i(221390);
    this.mJNIInterface.nativeUpdateMapResource(paramLong, paramString);
    AppMethodBeat.o(221390);
  }
  
  public void nativeUpdateMarker(long paramLong, MarkerInfo paramMarkerInfo)
  {
    AppMethodBeat.i(222103);
    this.mJNIInterface.nativeUpdateMarker(paramLong, paramMarkerInfo);
    AppMethodBeat.o(222103);
  }
  
  public void nativeUpdateMarkerInfo(long paramLong, int paramInt1, String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221515);
    this.mJNIInterface.nativeUpdateMarkerInfo(paramLong, paramInt1, paramString, paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt2, paramInt3);
    AppMethodBeat.o(221515);
  }
  
  public void nativeUpdateMaskLayer(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221365);
    this.mJNIInterface.nativeUpdateMaskLayer(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(221365);
  }
  
  public void nativeUpdatePolygon(long paramLong, int paramInt1, int paramInt2, PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(221352);
    this.mJNIInterface.nativeUpdatePolygon(paramLong, paramInt1, paramInt2, paramPolygonInfo);
    AppMethodBeat.o(221352);
  }
  
  public void nativeUpdateScatterPlotOverlay(long paramLong1, long paramLong2, ScatterPlotInfo paramScatterPlotInfo)
  {
    AppMethodBeat.i(222170);
    this.mJNIInterface.nativeUpdateScatterPlotOverlay(paramLong1, paramLong2, paramScatterPlotInfo);
    AppMethodBeat.o(222170);
  }
  
  public void nativeUpdateTrailOverlay(long paramLong1, long paramLong2, TrailOverlayInfo paramTrailOverlayInfo)
  {
    AppMethodBeat.i(222184);
    this.mJNIInterface.nativeUpdateTrailOverlay(paramLong1, paramLong2, paramTrailOverlayInfo);
    AppMethodBeat.o(222184);
  }
  
  public void nativeWriteMapDataBlock(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221237);
    this.mJNIInterface.nativeWriteMapDataBlock(paramLong, paramString, paramArrayOfByte);
    AppMethodBeat.o(221237);
  }
  
  public void nativeZoomIn(long paramLong, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221757);
    this.mJNIInterface.nativeZoomIn(paramLong, paramFloat1, paramFloat2);
    AppMethodBeat.o(221757);
  }
  
  public void nativeZoomOut(long paramLong)
  {
    AppMethodBeat.i(221764);
    this.mJNIInterface.nativeZoomOut(paramLong);
    AppMethodBeat.o(221764);
  }
  
  public void nativeZoomToSpan(long paramLong, Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    AppMethodBeat.i(221564);
    this.mJNIInterface.nativeZoomToSpan(paramLong, paramRect1, paramRect2, paramBoolean);
    AppMethodBeat.o(221564);
  }
  
  public void nativeZoomToSpanForNavigation(long paramLong, GeoPoint paramGeoPoint, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(221778);
    this.mJNIInterface.nativeZoomToSpanForNavigation(paramLong, paramGeoPoint, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(221778);
  }
  
  public void registerCallback(long paramLong)
  {
    AppMethodBeat.i(221111);
    nativeSetCallback(paramLong);
    AppMethodBeat.o(221111);
  }
  
  public void removeLineText(long paramLong, int paramInt)
  {
    AppMethodBeat.i(222286);
    this.mJNIInterface.removeLineText(paramLong, paramInt);
    AppMethodBeat.o(222286);
  }
  
  public void setLineTextStyle(long paramLong, int paramInt, PolylineOptions.Text paramText)
  {
    AppMethodBeat.i(222296);
    this.mJNIInterface.setLineTextStyle(paramLong, paramInt, paramText);
    AppMethodBeat.o(222296);
  }
  
  public void setMapCallbackGetGLContext(ob paramob)
  {
    AppMethodBeat.i(221121);
    if (this.mCallback != null) {
      this.mCallback.setMapCallbackGetGLContext(paramob);
    }
    AppMethodBeat.o(221121);
  }
  
  public void setRestrictBounds(long paramLong, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt)
  {
    AppMethodBeat.i(222270);
    this.mJNIInterface.setRestrictBounds(paramLong, paramArrayOfDouble1, paramArrayOfDouble2, paramInt);
    AppMethodBeat.o(222270);
  }
  
  public void setTrafficStyle(long paramLong, TrafficStyle paramTrafficStyle)
  {
    AppMethodBeat.i(222241);
    this.mJNIInterface.nativeSetTrafficStyle(paramLong, paramTrafficStyle);
    AppMethodBeat.o(222241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.engine.jni.JNI
 * JD-Core Version:    0.7.0.1
 */