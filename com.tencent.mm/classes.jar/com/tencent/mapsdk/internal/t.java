package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.map.tools.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public final class t
{
  public final Context a;
  
  public t(Context paramContext)
  {
    AppMethodBeat.i(224548);
    this.a = paramContext.getApplicationContext();
    AppMethodBeat.o(224548);
  }
  
  private void a(final ViewGroup paramViewGroup, final TencentMapOptions paramTencentMapOptions, final Callback<BaseMapView.MapViewProxy> paramCallback)
  {
    AppMethodBeat.i(224562);
    u localu = u.a();
    Context localContext = this.a;
    String str = a(paramTencentMapOptions);
    paramViewGroup = new Callback()
    {
      private void a()
      {
        AppMethodBeat.i(221587);
        BaseMapView.MapViewProxy localMapViewProxy = t.this.a(u.a().b, paramViewGroup, paramTencentMapOptions);
        if (paramCallback != null) {
          paramCallback.callback(localMapViewProxy);
        }
        AppMethodBeat.o(221587);
      }
    };
    new Thread(new u.4(localu, localContext, str, new Handler(Looper.getMainLooper()), paramViewGroup), "tms-plugin").start();
    AppMethodBeat.o(224562);
  }
  
  public final BaseMapView.MapViewProxy a(ViewGroup paramViewGroup, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(224592);
    u.a().a(this.a, a(paramTencentMapOptions));
    paramViewGroup = a(u.a().b, paramViewGroup, paramTencentMapOptions);
    AppMethodBeat.o(224592);
    return paramViewGroup;
  }
  
  final BaseMapView.MapViewProxy a(s params, ViewGroup paramViewGroup, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(224583);
    params = params.createDelegate(this.a, paramTencentMapOptions, paramViewGroup);
    AppMethodBeat.o(224583);
    return params;
  }
  
  public final String a(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(224602);
    String str = paramTencentMapOptions.getMapKey();
    paramTencentMapOptions = str;
    if (gz.a(str)) {
      paramTencentMapOptions = ha.a(this.a, "TencentMapSDK");
    }
    AppMethodBeat.o(224602);
    return paramTencentMapOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.t
 * JD-Core Version:    0.7.0.1
 */