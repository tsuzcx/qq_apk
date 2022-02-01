package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnTrafficEventClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.List;

public final class z
{
  public static final int a = 0;
  public ai b;
  public TencentMap.SnapshotReadyCallback c;
  public Handler d;
  
  public z(ai paramai)
  {
    AppMethodBeat.i(223133);
    this.b = null;
    this.c = null;
    this.d = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(221818);
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 0))
        {
          if (z.this.c != null)
          {
            paramAnonymousMessage = (Bitmap)paramAnonymousMessage.obj;
            z.this.c.onSnapshotReady(paramAnonymousMessage);
          }
          z.this.c = null;
        }
        AppMethodBeat.o(221818);
      }
    };
    this.b = paramai;
    AppMethodBeat.o(223133);
  }
  
  private float a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(223188);
    if (this.b == null)
    {
      AppMethodBeat.o(223188);
      return -1.0F;
    }
    float f = this.b.a(paramLatLng1, paramLatLng2);
    AppMethodBeat.o(223188);
    return f;
  }
  
  private CameraPosition a(List<eq> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(223411);
    if (this.b == null)
    {
      AppMethodBeat.o(223411);
      return null;
    }
    paramList = this.b.a(paramList, paramList1, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(223411);
    return paramList;
  }
  
  private CustomLayer a(CustomLayerOptions paramCustomLayerOptions)
  {
    AppMethodBeat.i(223646);
    if (this.b == null)
    {
      AppMethodBeat.o(223646);
      return null;
    }
    paramCustomLayerOptions = this.b.a(paramCustomLayerOptions);
    AppMethodBeat.o(223646);
    return paramCustomLayerOptions;
  }
  
  private TileOverlay a(TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(223640);
    if (this.b == null)
    {
      AppMethodBeat.o(223640);
      return null;
    }
    paramTileOverlayOptions = this.b.a(paramTileOverlayOptions);
    AppMethodBeat.o(223640);
    return paramTileOverlayOptions;
  }
  
  private String a(LatLng paramLatLng)
  {
    AppMethodBeat.i(223361);
    if (this.b == null)
    {
      AppMethodBeat.o(223361);
      return null;
    }
    paramLatLng = this.b.a(paramLatLng);
    AppMethodBeat.o(223361);
    return paramLatLng;
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(223422);
    if (this.b == null)
    {
      AppMethodBeat.o(223422);
      return;
    }
    this.b.a(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(223422);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(223160);
    if (this.b == null)
    {
      AppMethodBeat.o(223160);
      return;
    }
    this.b.d(paramInt);
    AppMethodBeat.o(223160);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223399);
    if (this.b == null)
    {
      AppMethodBeat.o(223399);
      return;
    }
    this.b.a(paramInt1, paramInt2);
    AppMethodBeat.o(223399);
  }
  
  private void a(Handler paramHandler, Bitmap.Config paramConfig, int paramInt)
  {
    AppMethodBeat.i(223343);
    if (this.b == null)
    {
      AppMethodBeat.o(223343);
      return;
    }
    this.b.a(paramHandler, paramConfig, paramInt);
    AppMethodBeat.o(223343);
  }
  
  private void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    AppMethodBeat.i(223287);
    if (this.b == null)
    {
      AppMethodBeat.o(223287);
      return;
    }
    this.b.a(paramOnCameraChangeListener);
    AppMethodBeat.o(223287);
  }
  
  private void a(TencentMap.OnCompassClickedListener paramOnCompassClickedListener)
  {
    AppMethodBeat.i(223443);
    if (this.b != null) {
      this.b.a(paramOnCompassClickedListener);
    }
    AppMethodBeat.o(223443);
  }
  
  private void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(223509);
    if (this.b == null)
    {
      AppMethodBeat.o(223509);
      return;
    }
    this.b.a(paramOnIndoorStateChangeListener);
    AppMethodBeat.o(223509);
  }
  
  private void a(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(223500);
    if (this.b == null)
    {
      AppMethodBeat.o(223500);
      return;
    }
    this.b.a(paramOnInfoWindowClickListener);
    AppMethodBeat.o(223500);
  }
  
  private void a(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(223268);
    if (this.b == null)
    {
      AppMethodBeat.o(223268);
      return;
    }
    this.b.a(paramOnMapClickListener);
    AppMethodBeat.o(223268);
  }
  
  private void a(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    AppMethodBeat.i(223452);
    if (this.b != null) {
      this.b.a(paramOnMapLoadedCallback);
    }
    AppMethodBeat.o(223452);
  }
  
  private void a(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(223277);
    if (this.b == null)
    {
      AppMethodBeat.o(223277);
      return;
    }
    this.b.a(paramOnMapLongClickListener);
    AppMethodBeat.o(223277);
  }
  
  private void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(223562);
    if (this.b == null)
    {
      AppMethodBeat.o(223562);
      return;
    }
    this.b.a(paramOnMapPoiClickListener);
    AppMethodBeat.o(223562);
  }
  
  private void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(223493);
    if (this.b == null)
    {
      AppMethodBeat.o(223493);
      return;
    }
    this.b.a(paramOnMarkerClickListener);
    AppMethodBeat.o(223493);
  }
  
  private void a(TencentMap.OnTrafficEventClickListener paramOnTrafficEventClickListener)
  {
    AppMethodBeat.i(223668);
    if (this.b == null)
    {
      AppMethodBeat.o(223668);
      return;
    }
    this.b.a(paramOnTrafficEventClickListener);
    AppMethodBeat.o(223668);
  }
  
  private void a(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig, int paramInt)
  {
    AppMethodBeat.i(223354);
    if ((this.b == null) || (paramSnapshotReadyCallback == null))
    {
      AppMethodBeat.o(223354);
      return;
    }
    this.c = paramSnapshotReadyCallback;
    paramSnapshotReadyCallback = this.d;
    if (this.b != null) {
      this.b.a(paramSnapshotReadyCallback, paramConfig, paramInt);
    }
    AppMethodBeat.o(223354);
  }
  
  private void a(Language paramLanguage)
  {
    AppMethodBeat.i(223474);
    if (this.b != null) {
      this.b.a(paramLanguage);
    }
    AppMethodBeat.o(223474);
  }
  
  private void a(LatLngBounds paramLatLngBounds, int paramInt)
  {
    AppMethodBeat.i(223661);
    if (this.b == null)
    {
      AppMethodBeat.o(223661);
      return;
    }
    this.b.a(paramLatLngBounds, paramInt);
    AppMethodBeat.o(223661);
  }
  
  private void a(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(223367);
    if (this.b == null)
    {
      AppMethodBeat.o(223367);
      return;
    }
    this.b.a(paramTencentMapGestureListener);
    AppMethodBeat.o(223367);
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(223569);
    if (this.b == null)
    {
      AppMethodBeat.o(223569);
      return;
    }
    this.b.a(paramString);
    AppMethodBeat.o(223569);
  }
  
  private void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223591);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(223591);
      return;
    }
    this.b.a(paramString1, paramString2);
    AppMethodBeat.o(223591);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(223242);
    if (this.b == null)
    {
      AppMethodBeat.o(223242);
      return;
    }
    this.b.a(paramBoolean);
    AppMethodBeat.o(223242);
  }
  
  private int b(String paramString)
  {
    AppMethodBeat.i(223623);
    if ((this.b != null) && (!gz.a(paramString)))
    {
      int i = this.b.b(paramString);
      AppMethodBeat.o(223623);
      return i;
    }
    AppMethodBeat.o(223623);
    return -1;
  }
  
  @Deprecated
  private String b(LatLng paramLatLng)
  {
    AppMethodBeat.i(223553);
    if (this.b != null)
    {
      IndoorBuilding localIndoorBuilding = this.b.u();
      if (localIndoorBuilding != null)
      {
        if ((localIndoorBuilding.getBuildingLatLng() != null) && (paramLatLng != null))
        {
          paramLatLng.latitude = localIndoorBuilding.getBuildingLatLng().latitude;
          paramLatLng.longitude = localIndoorBuilding.getBuildingLatLng().longitude;
        }
        paramLatLng = localIndoorBuilding.getBuildingName();
        AppMethodBeat.o(223553);
        return paramLatLng;
      }
    }
    AppMethodBeat.o(223553);
    return null;
  }
  
  private void b(int paramInt)
  {
    AppMethodBeat.i(223168);
    if (this.b == null)
    {
      AppMethodBeat.o(223168);
      return;
    }
    this.b.e(paramInt);
    AppMethodBeat.o(223168);
  }
  
  private void b(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    AppMethodBeat.i(223463);
    if (this.b != null) {
      this.b.b(paramOnMapLoadedCallback);
    }
    AppMethodBeat.o(223463);
  }
  
  private void b(Language paramLanguage)
  {
    AppMethodBeat.i(223616);
    if (this.b != null) {
      this.b.b(paramLanguage);
    }
    AppMethodBeat.o(223616);
  }
  
  private void b(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(223374);
    if (this.b == null)
    {
      AppMethodBeat.o(223374);
      return;
    }
    this.b.b(paramTencentMapGestureListener);
    AppMethodBeat.o(223374);
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(223384);
    if (this.b == null)
    {
      AppMethodBeat.o(223384);
      return;
    }
    this.b.b(paramBoolean);
    AppMethodBeat.o(223384);
  }
  
  private void c()
  {
    if (this.b != null) {
      this.b = null;
    }
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(223205);
    if (this.b == null)
    {
      AppMethodBeat.o(223205);
      return;
    }
    this.b.f(paramInt);
    AppMethodBeat.o(223205);
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(223519);
    if (this.b != null) {
      this.b.c(paramBoolean);
    }
    AppMethodBeat.o(223519);
  }
  
  private float d()
  {
    AppMethodBeat.i(223151);
    if (this.b == null)
    {
      AppMethodBeat.o(223151);
      return -1.0F;
    }
    float f = this.b.b();
    AppMethodBeat.o(223151);
    return f;
  }
  
  private void d(int paramInt)
  {
    AppMethodBeat.i(223224);
    if (this.b == null)
    {
      AppMethodBeat.o(223224);
      return;
    }
    this.b.a(paramInt);
    AppMethodBeat.o(223224);
  }
  
  private void d(boolean paramBoolean)
  {
    AppMethodBeat.i(223576);
    if (this.b == null)
    {
      AppMethodBeat.o(223576);
      return;
    }
    this.b.e(paramBoolean);
    AppMethodBeat.o(223576);
  }
  
  private float e()
  {
    AppMethodBeat.i(223163);
    if (this.b == null)
    {
      AppMethodBeat.o(223163);
      return -1.0F;
    }
    float f = this.b.c();
    AppMethodBeat.o(223163);
    return f;
  }
  
  private void e(int paramInt)
  {
    AppMethodBeat.i(223389);
    if (this.b == null)
    {
      AppMethodBeat.o(223389);
      return;
    }
    this.b.b(paramInt);
    AppMethodBeat.o(223389);
  }
  
  private void e(boolean paramBoolean)
  {
    AppMethodBeat.i(223598);
    if (this.b == null)
    {
      AppMethodBeat.o(223598);
      return;
    }
    this.b.f(paramBoolean);
    AppMethodBeat.o(223598);
  }
  
  private void f()
  {
    if (this.b == null) {}
  }
  
  private void f(int paramInt)
  {
    AppMethodBeat.i(223527);
    if (this.b != null) {
      this.b.c(paramInt);
    }
    AppMethodBeat.o(223527);
  }
  
  private void f(boolean paramBoolean)
  {
    AppMethodBeat.i(223606);
    if (this.b != null) {
      this.b.g(paramBoolean);
    }
    AppMethodBeat.o(223606);
  }
  
  private void g()
  {
    AppMethodBeat.i(223195);
    if (this.b == null)
    {
      AppMethodBeat.o(223195);
      return;
    }
    this.b.d();
    AppMethodBeat.o(223195);
  }
  
  private void g(boolean paramBoolean)
  {
    AppMethodBeat.i(223613);
    if (this.b != null) {
      this.b.h(paramBoolean);
    }
    AppMethodBeat.o(223613);
  }
  
  private int h()
  {
    AppMethodBeat.i(223212);
    if (this.b == null)
    {
      AppMethodBeat.o(223212);
      return 1000;
    }
    int i = this.b.A();
    AppMethodBeat.o(223212);
    return i;
  }
  
  private void h(boolean paramBoolean)
  {
    AppMethodBeat.i(223652);
    if (this.b == null)
    {
      AppMethodBeat.o(223652);
      return;
    }
    this.b.i(paramBoolean);
    AppMethodBeat.o(223652);
  }
  
  private int i()
  {
    AppMethodBeat.i(223231);
    if (this.b == null)
    {
      AppMethodBeat.o(223231);
      return -1;
    }
    int i = this.b.f();
    AppMethodBeat.o(223231);
    return i;
  }
  
  private boolean j()
  {
    AppMethodBeat.i(223252);
    if (this.b == null)
    {
      AppMethodBeat.o(223252);
      return false;
    }
    boolean bool = this.b.h();
    AppMethodBeat.o(223252);
    return bool;
  }
  
  private void k()
  {
    if (this.b == null) {}
  }
  
  private void l()
  {
    AppMethodBeat.i(223299);
    if (this.b == null)
    {
      AppMethodBeat.o(223299);
      return;
    }
    this.b.j();
    AppMethodBeat.o(223299);
  }
  
  private void m()
  {
    if (this.b == null) {}
  }
  
  private void n()
  {
    if (this.b == null) {}
  }
  
  private void o()
  {
    AppMethodBeat.i(223326);
    if (this.b == null)
    {
      AppMethodBeat.o(223326);
      return;
    }
    this.b.n();
    AppMethodBeat.o(223326);
  }
  
  private void p()
  {
    AppMethodBeat.i(223335);
    if (this.b == null)
    {
      AppMethodBeat.o(223335);
      return;
    }
    this.b.m();
    AppMethodBeat.o(223335);
  }
  
  private String q()
  {
    AppMethodBeat.i(223432);
    if (this.b == null)
    {
      AppMethodBeat.o(223432);
      return "";
    }
    String str = this.b.o();
    AppMethodBeat.o(223432);
    return str;
  }
  
  private Language r()
  {
    AppMethodBeat.i(223484);
    if (this.b != null)
    {
      localLanguage = this.b.p();
      AppMethodBeat.o(223484);
      return localLanguage;
    }
    Language localLanguage = Language.zh;
    AppMethodBeat.o(223484);
    return localLanguage;
  }
  
  private int s()
  {
    AppMethodBeat.i(223533);
    if (this.b != null)
    {
      int i = this.b.r();
      AppMethodBeat.o(223533);
      return i;
    }
    AppMethodBeat.o(223533);
    return -1;
  }
  
  private String[] t()
  {
    AppMethodBeat.i(223542);
    if (this.b != null)
    {
      String[] arrayOfString = this.b.s();
      AppMethodBeat.o(223542);
      return arrayOfString;
    }
    AppMethodBeat.o(223542);
    return null;
  }
  
  private boolean u()
  {
    AppMethodBeat.i(223583);
    if (this.b == null)
    {
      AppMethodBeat.o(223583);
      return false;
    }
    boolean bool = this.b.w();
    AppMethodBeat.o(223583);
    return bool;
  }
  
  private String v()
  {
    AppMethodBeat.i(223633);
    if (this.b == null)
    {
      AppMethodBeat.o(223633);
      return null;
    }
    String str = this.b.z();
    AppMethodBeat.o(223633);
    return str;
  }
  
  public final int a(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(223697);
    if (this.b == null)
    {
      AppMethodBeat.o(223697);
      return -2147483648;
    }
    int i = this.b.a(paramCameraUpdate);
    AppMethodBeat.o(223697);
    return i;
  }
  
  public final int a(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(223704);
    if (this.b == null)
    {
      AppMethodBeat.o(223704);
      return -2147483648;
    }
    int i = this.b.a(paramCameraUpdate, paramLong, paramCancelableCallback);
    AppMethodBeat.o(223704);
    return i;
  }
  
  public final CameraPosition a()
  {
    AppMethodBeat.i(223687);
    if (this.b == null)
    {
      AppMethodBeat.o(223687);
      return null;
    }
    CameraPosition localCameraPosition = this.b.a();
    AppMethodBeat.o(223687);
    return localCameraPosition;
  }
  
  public final boolean b()
  {
    AppMethodBeat.i(223713);
    if (this.b != null)
    {
      boolean bool = this.b.x();
      AppMethodBeat.o(223713);
      return bool;
    }
    AppMethodBeat.o(223713);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.z
 * JD-Core Version:    0.7.0.1
 */