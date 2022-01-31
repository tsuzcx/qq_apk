package com.tencent.map.lib.gl;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.mapstructure.AnnocationText;
import com.tencent.map.lib.mapstructure.AnnocationTextResult;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.CityTrafficInfo;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hi;
import com.tencent.tencentmap.mapsdk.maps.a.it;
import java.util.ArrayList;

public class JNI
{
  public static final String LIB_NAME = "txmapengine";
  private JNICallback a;
  
  public static synchronized native void nativeEndProfile();
  
  public static synchronized native void nativeStartProfile();
  
  public Object callback(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98021);
    paramString = this.a.a(paramInt1, paramInt2, paramString, paramArrayOfByte);
    AppMethodBeat.o(98021);
    return paramString;
  }
  
  public int callbackGetGLContext()
  {
    AppMethodBeat.i(98022);
    int i = this.a.c();
    AppMethodBeat.o(98022);
    return i;
  }
  
  public native boolean checkMapLoadFinishedTask(long paramLong, int paramInt);
  
  public void destory()
  {
    AppMethodBeat.i(98014);
    this.a.a();
    this.a = null;
    AppMethodBeat.o(98014);
  }
  
  public native int getIndoorOutlineZoom(long paramLong, String paramString);
  
  public native String getMapEngineRenderStatus(long paramLong);
  
  public void initCallback(it paramit, JNICallback.a parama, JNICallback.h paramh, JNICallback.e parame, JNICallback.g paramg, hi paramhi, JNICallback.i parami, long paramLong)
  {
    AppMethodBeat.i(147024);
    this.a = new JNICallback(paramit, parama, paramh, parame, paramg, paramhi, parami);
    nativeSetCallback(paramLong);
    AppMethodBeat.o(147024);
  }
  
  public native int nativeAddCircle(long paramLong, CircleInfo paramCircleInfo);
  
  public native int nativeAddHeatTileOverlay(long paramLong, int paramInt, boolean paramBoolean);
  
  public native int nativeAddMarker(long paramLong, String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2);
  
  public native int nativeAddMaskLayer(long paramLong, MaskLayer paramMaskLayer);
  
  public native int nativeAddPolygon(long paramLong, Polygon2D paramPolygon2D);
  
  public native void nativeAddRouteNameSegments(long paramLong, byte[][] paramArrayOfByte, int paramInt1, GeoPoint[] paramArrayOfGeoPoint, int paramInt2);
  
  public native void nativeAddVIPAnnotationTexts(long paramLong, String paramString1, int paramInt, String paramString2, GeoPoint paramGeoPoint);
  
  public native void nativeBringElementAbove(long paramLong, int paramInt1, int paramInt2);
  
  public native void nativeBringElementBelow(long paramLong, int paramInt1, int paramInt2);
  
  public native void nativeCheckTrafficBlockCache(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native void nativeCheckTrafficBlockCacheForReplay(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int nativeClearCache(long paramLong);
  
  public native void nativeClearDownloadURLCache(long paramLong);
  
  public native void nativeClearRouteNameSegments(long paramLong);
  
  public native void nativeClearVIPAnnotationTexts(long paramLong);
  
  public native AnnocationTextResult nativeCreateAnnotationTextBitmap(long paramLong, AnnocationText paramAnnocationText);
  
  public native int nativeCreateLine(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, GeoPoint[] paramArrayOfGeoPoint, String paramString, float paramFloat1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2, boolean paramBoolean5, int[] paramArrayOfInt3, int[] paramArrayOfInt4, float paramFloat2, int[] paramArrayOfInt5, float paramFloat3, int paramInt3);
  
  public native void nativeDeleteCircle(long paramLong, int paramInt);
  
  public native void nativeDeleteIcons(long paramLong, int[] paramArrayOfInt, int paramInt);
  
  public native void nativeDeleteLine(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public native void nativeDeletePolygon(long paramLong, int paramInt1, int paramInt2);
  
  public native void nativeDestroyEngine(long paramLong);
  
  public native boolean nativeDrawFrame(long paramLong);
  
  public native void nativeEnablePOI(long paramLong, boolean paramBoolean);
  
  public native void nativeEnableVectorMap(long paramLong, boolean paramBoolean);
  
  public native int[] nativeFetchLackedTrafficBlocks(long paramLong);
  
  public native void nativeFromScreenLocation(long paramLong, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, double[] paramArrayOfDouble);
  
  public native boolean nativeGenerateTextures(long paramLong);
  
  public native String nativeGetActiveIndoorBuildingGUID(long paramLong);
  
  public native String nativeGetBlockRouteInfo(long paramLong, int paramInt1, int paramInt2);
  
  public native void nativeGetCenterMapPoint(long paramLong, GeoPoint paramGeoPoint);
  
  public native byte[] nativeGetCityName(long paramLong, GeoPoint paramGeoPoint);
  
  public native String nativeGetCurIndoorName(long paramLong, GeoPoint paramGeoPoint);
  
  public native String nativeGetDataEngineVersion(long paramLong);
  
  public native boolean nativeGetHeatTileRenderEnabled(long paramLong);
  
  public native Rect nativeGetIndoorBound(long paramLong);
  
  public native int nativeGetIndoorCurrentFloorId(long paramLong);
  
  public native String[] nativeGetIndoorFloorNames(long paramLong);
  
  public native int nativeGetLanguage(long paramLong);
  
  public native String nativeGetMapEngineVersion(long paramLong);
  
  public native int nativeGetMapMode(long paramLong);
  
  public native ArrayList nativeGetPoisInScreen(long paramLong);
  
  public native float nativeGetRotate(long paramLong);
  
  public native double nativeGetScale(long paramLong);
  
  public native int nativeGetScaleLevel(long paramLong);
  
  public native float nativeGetSkew(long paramLong);
  
  public native double nativeGetTargetScale(long paramLong, Rect paramRect1, Rect paramRect2);
  
  public native boolean nativeGetTrafficCityInfo(long paramLong, String paramString, CityTrafficInfo paramCityTrafficInfo);
  
  public native boolean nativeHasStreetRoad(long paramLong, String paramString);
  
  public native void nativeHideCompass(long paramLong);
  
  public native void nativeHideIcons(long paramLong, int[] paramArrayOfInt, int paramInt);
  
  public native void nativeHideStreetRoad(long paramLong);
  
  public native void nativeHideTraffic(long paramLong);
  
  public native void nativeIndoorBuildingEnabled(long paramLong, boolean paramBoolean);
  
  public native long nativeInitEngine(String paramString1, String paramString2, String paramString3, float paramFloat1, int paramInt1, float paramFloat2, int[] paramArrayOfInt, boolean paramBoolean, int paramInt2);
  
  public native int nativeIsCityHasTraffic(long paramLong, String paramString);
  
  @Deprecated
  public native boolean nativeIsMapDrawFinished(long paramLong);
  
  public native void nativeLineClearPoint(long paramLong1, long paramLong2, GeoPoint paramGeoPoint, int paramInt);
  
  public native void nativeLineInsertPoint(long paramLong1, long paramLong2, GeoPoint paramGeoPoint, int paramInt);
  
  public native void nativeLoadBlockRouteCityList(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
  
  public native void nativeLockEngine(long paramLong);
  
  public native void nativeMapLoadKMLFile(long paramLong, String paramString);
  
  public native void nativeMoveBy(long paramLong, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public native boolean nativeNeedDispaly(long paramLong);
  
  public native boolean nativeNeedRedraw(long paramLong);
  
  public native byte[] nativeOnTap(long paramLong, float paramFloat1, float paramFloat2);
  
  public native boolean nativeOnTapLine(long paramLong, float paramFloat1, float paramFloat2);
  
  public native int nativeQueryCityCodeList(long paramLong, Rect paramRect, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public native int nativeRefreshTrafficData(long paramLong, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public native void nativeReleaseEngineResource(long paramLong, boolean paramBoolean);
  
  public native void nativeReloadHeatTileOverlay(long paramLong, int paramInt);
  
  public native void nativeRemoveHeatTileOverlay(long paramLong, int paramInt);
  
  public native void nativeRemoveMaskLayer(long paramLong, int paramInt);
  
  public native void nativeResetEnginePath(long paramLong, String paramString1, String paramString2, String paramString3);
  
  public native void nativeSetBlockRouteVisible(long paramLong, boolean paramBoolean);
  
  public native void nativeSetBuilding3DEffect(long paramLong, boolean paramBoolean);
  
  public native void nativeSetBuildingToSpecificFloor(long paramLong, String paramString1, String paramString2);
  
  public native void nativeSetCallback(long paramLong);
  
  public native void nativeSetCenter(long paramLong, GeoPoint paramGeoPoint, boolean paramBoolean);
  
  public native void nativeSetCenterMapPointAndScaleLevel(long paramLong, GeoPoint paramGeoPoint, int paramInt, boolean paramBoolean);
  
  public native void nativeSetCompassMarkerHidden(long paramLong, boolean paramBoolean);
  
  public native void nativeSetCompassMarkerImage(long paramLong, String paramString);
  
  public native void nativeSetCompassPosition(long paramLong, int paramInt1, int paramInt2);
  
  public native void nativeSetCompassVisible(long paramLong, boolean paramBoolean);
  
  public native void nativeSetDrawCap(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public native void nativeSetFlagOfZoomToSpanForLocation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native void nativeSetHeatTileRenderEnabled(long paramLong, boolean paramBoolean);
  
  public native void nativeSetIndoorActiveScreenArea(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native void nativeSetIndoorBuildingPickEnabled(long paramLong, boolean paramBoolean);
  
  public native void nativeSetIndoorFloor(long paramLong, int paramInt);
  
  public native void nativeSetIndoorMaskColor(long paramLong, int paramInt);
  
  public native void nativeSetLanguage(long paramLong, int paramInt);
  
  public native void nativeSetLineArrowSpacing(long paramLong, int paramInt, float paramFloat);
  
  public native void nativeSetLineDirectionArrowTextureName(long paramLong1, long paramLong2, String paramString);
  
  public native void nativeSetLineDrawArrow(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public native void nativeSetLineFootPrintSpacing(long paramLong, int paramInt, float paramFloat);
  
  public native void nativeSetLineSelected(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public native void nativeSetLocationCircleColor(long paramLong, int paramInt);
  
  public native void nativeSetLocationCircleHidden(long paramLong, boolean paramBoolean);
  
  public native void nativeSetLocationFollow(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  public native void nativeSetLocationHeading(long paramLong, float paramFloat);
  
  public native void nativeSetLocationInfo(long paramLong, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public native void nativeSetLocationMarkerHidden(long paramLong, boolean paramBoolean);
  
  public native void nativeSetLocationMarkerImage(long paramLong, String paramString);
  
  public native void nativeSetMapMode(long paramLong, int paramInt, boolean paramBoolean);
  
  public native void nativeSetMapParam(long paramLong, byte[] paramArrayOfByte);
  
  public native void nativeSetMaxScaleLevel(long paramLong, int paramInt);
  
  public native void nativeSetMinScaleLevel(long paramLong, int paramInt);
  
  public native void nativeSetNeedDisplay(long paramLong, boolean paramBoolean);
  
  public native void nativeSetPriority(long paramLong, int paramInt, float paramFloat);
  
  public native void nativeSetRotate(long paramLong, float paramFloat, boolean paramBoolean);
  
  public native void nativeSetSatelliteEnabled(long paramLong, boolean paramBoolean);
  
  public native void nativeSetScale(long paramLong, double paramDouble, boolean paramBoolean);
  
  public native void nativeSetScaleLevel(long paramLong, int paramInt, boolean paramBoolean);
  
  public native void nativeSetScreenCenterOffset(long paramLong, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public native void nativeSetServerHost(long paramLong, String paramString);
  
  public native void nativeSetShowIndoorBuildingWhiteList(long paramLong, String[] paramArrayOfString);
  
  public native void nativeSetSkew(long paramLong, float paramFloat, boolean paramBoolean);
  
  public native void nativeSetTileOverlayDataLevelRange(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeSetTrafficColor(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void nativeSetTurnArrow(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public native void nativeSetTurnArrowStyle(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public native void nativeSetViewport(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void nativeShowStreetRoad(long paramLong);
  
  public native void nativeShowTraffic(long paramLong);
  
  public native void nativeToScreenLocation(long paramLong, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, float[] paramArrayOfFloat);
  
  public native void nativeUnlockEngine(long paramLong);
  
  public native void nativeUpdateCircle(long paramLong, int paramInt, CircleInfo paramCircleInfo);
  
  public native void nativeUpdateFrame(long paramLong, double paramDouble);
  
  public native void nativeUpdateMapResource(long paramLong, String paramString);
  
  public native void nativeUpdateMarkerInfo(long paramLong, int paramInt1, String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2, int paramInt3);
  
  public native void nativeUpdateMaskLayer(long paramLong, int paramInt1, int paramInt2);
  
  public native void nativeUpdatePolygon(long paramLong, int paramInt1, int paramInt2, Polygon2D paramPolygon2D);
  
  public native void nativeWriteMapDataBlock(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  public native void nativeZoomIn(long paramLong, float paramFloat1, float paramFloat2);
  
  public native void nativeZoomOut(long paramLong);
  
  public native void nativeZoomToSpan(long paramLong, Rect paramRect1, Rect paramRect2, boolean paramBoolean);
  
  public native void nativeZoomToSpanForNavigation(long paramLong, GeoPoint paramGeoPoint, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public void onMapLoaded()
  {
    AppMethodBeat.i(147027);
    this.a.b();
    AppMethodBeat.o(147027);
  }
  
  public void setHandDrawTileLoadCallback(JNICallback.b paramb)
  {
    AppMethodBeat.i(98017);
    if (this.a != null) {
      this.a.a(paramb);
    }
    AppMethodBeat.o(98017);
  }
  
  public void setHandDrawTileWriteCallback(JNICallback.c paramc)
  {
    AppMethodBeat.i(98018);
    if (this.a != null) {
      this.a.a(paramc);
    }
    AppMethodBeat.o(98018);
  }
  
  public void setHeatTileLoadCallback(JNICallback.d paramd)
  {
    AppMethodBeat.i(98015);
    if (this.a != null) {
      this.a.a(paramd);
    }
    AppMethodBeat.o(98015);
  }
  
  public void setMapCallbackGetGLContext(JNICallback.f paramf)
  {
    AppMethodBeat.i(98020);
    if (this.a != null) {
      this.a.a(paramf);
    }
    AppMethodBeat.o(98020);
  }
  
  public void setTileWriteCallback(JNICallback.l paraml)
  {
    AppMethodBeat.i(147026);
    if (this.a != null) {
      this.a.a(paraml);
    }
    AppMethodBeat.o(147026);
  }
  
  public void setWorldTileLoadCallback(JNICallback.k paramk)
  {
    AppMethodBeat.i(147025);
    if (this.a != null) {
      this.a.a(paramk);
    }
    AppMethodBeat.o(147025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.gl.JNI
 * JD-Core Version:    0.7.0.1
 */