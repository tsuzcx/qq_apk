package com.tencent.map.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.sheet.SheetManager;
import com.tencent.map.tools.sheet.SheetManager.Options;
import com.tencent.map.tools.sheet.SheetManager.Options.AdapterType;
import com.tencent.map.tools.sheet.SheetManager.UncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public final class a
  extends SheetManager.UncaughtListener
{
  public final SheetManager.Options a;
  public final Context b;
  
  public a(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(Thread.getDefaultUncaughtExceptionHandler());
    AppMethodBeat.i(235653);
    this.b = paramContext.getApplicationContext();
    String str = "";
    int i;
    if (TextUtils.isEmpty(paramTencentMapOptions.getMapKey()))
    {
      try
      {
        Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
        paramTencentMapOptions = str;
        if (localBundle != null) {
          paramTencentMapOptions = localBundle.getString("TencentMapSDK");
        }
      }
      catch (Exception paramTencentMapOptions)
      {
        for (;;)
        {
          label123:
          paramTencentMapOptions = "";
        }
      }
      if ((paramContext == null) || (Util.findClass("com.tencent.bugly.crashreport.CrashReport", getClass().getClassLoader()) == null)) {
        break label223;
      }
      paramContext = paramContext.getSharedPreferences("BuglySdkInfos", 0).edit();
      paramContext.putString("4025282fa3", "4.4.1.1_73a770d");
      paramContext.apply();
      i = 1;
      paramContext = new SheetManager.Options().setAdapterType(SheetManager.Options.AdapterType.LOC_SHEET).setSheetEnable(true).setSheetProjectName("tms").setSoLibName("txmapengine").setVersion("4.4.1").setVersionCode("1").setSdkRepo("73a770d").setFlavor("wechatSearchSheetok").setCatchCrashEnable(false).setAppKey(paramTencentMapOptions);
      if (i != 0) {
        break label228;
      }
    }
    for (;;)
    {
      this.a = paramContext.setCoreLogOn(bool).setCoreLogReportUrl("https://analytics.map.qq.com/tr?mllc").setUncaughtListener(this);
      AppMethodBeat.o(235653);
      return;
      paramTencentMapOptions = paramTencentMapOptions.getMapKey();
      break;
      label223:
      i = 0;
      break label123;
      label228:
      bool = false;
    }
  }
  
  public final BaseMapView.MapViewProxy a(ViewGroup paramViewGroup, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(235655);
    Object localObject = SheetManager.getInstance().findSheet("com.tencent.mapsdk.core.MapDelegateFactoryImpl");
    localObject = SheetManager.getInstance().newSheetIns((Class)localObject, new Object[0]);
    SheetManager localSheetManager = SheetManager.getInstance();
    Context localContext = this.b;
    paramViewGroup = (BaseMapView.MapViewProxy)localSheetManager.callSheetMth(localObject, "createDelegate", new Class[] { Context.class, TencentMapOptions.class, ViewGroup.class }, new Object[] { localContext, paramTencentMapOptions, paramViewGroup });
    AppMethodBeat.o(235655);
    return paramViewGroup;
  }
  
  public final boolean onModuleSDKCrashed(Throwable paramThrowable)
  {
    AppMethodBeat.i(235657);
    Class localClass = SheetManager.getInstance().findSheet("com.tencent.mapsdk.core.utils.log.TraceUtil");
    SheetManager.getInstance().callSheetStaMth(localClass, "reportCrash", new Class[] { Throwable.class }, new Object[] { paramThrowable });
    AppMethodBeat.o(235657);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.internal.a
 * JD-Core Version:    0.7.0.1
 */