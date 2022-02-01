package com.tencent.map.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.sheet.SheetManager;
import com.tencent.map.tools.sheet.SheetManager.Options;
import com.tencent.map.tools.sheet.SheetManager.Options.AdapterType;
import com.tencent.map.tools.sheet.SheetManager.UncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public final class a
{
  public SheetManager.Options a;
  public Context b;
  
  public a(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(186133);
    this.b = paramContext.getApplicationContext();
    str = "";
    if (TextUtils.isEmpty(paramTencentMapOptions.getMapKey())) {}
    for (;;)
    {
      try
      {
        paramTencentMapOptions = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
        paramContext = str;
        if (paramTencentMapOptions != null) {
          paramContext = paramTencentMapOptions.getString("TencentMapSDK");
        }
      }
      catch (Exception paramContext)
      {
        paramContext = str;
        continue;
      }
      this.a = new SheetManager.Options().setAdapterType(SheetManager.Options.AdapterType.LOC_SHEET).setSheetEnable(true).setSheetProjectName("tms").setSoLibName("txmapengine").setVersion("4.3.3").setVersionCode("5").setFlavor("wechatSearchSheetok").setCoreLogReportUrl("https://analytics.map.qq.com/tr?mllc").setAppKey(paramContext).setCoreLogOn(true).setUncaughtListener(new SheetManager.UncaughtListener(Thread.getDefaultUncaughtExceptionHandler())
      {
        public final boolean onModuleSDKCrashed(Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(180720);
          paramAnonymousThrowable.getMessage();
          AppMethodBeat.o(180720);
          return false;
        }
      });
      AppMethodBeat.o(186133);
      return;
      paramContext = paramTencentMapOptions.getMapKey();
    }
  }
  
  public final BaseMapView.MapViewProxy a(ViewGroup paramViewGroup, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(186134);
    Object localObject = SheetManager.getInstance().findSheet("com.tencent.mapsdk.core.MapDelegateFactoryImpl");
    localObject = SheetManager.getInstance().newSheetIns((Class)localObject, new Object[0]);
    SheetManager localSheetManager = SheetManager.getInstance();
    Context localContext = this.b;
    paramViewGroup = (BaseMapView.MapViewProxy)localSheetManager.callSheetMth(localObject, "createDelegate", new Class[] { Context.class, TencentMapOptions.class, ViewGroup.class }, new Object[] { localContext, paramTencentMapOptions, paramViewGroup });
    AppMethodBeat.o(186134);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.internal.a
 * JD-Core Version:    0.7.0.1
 */