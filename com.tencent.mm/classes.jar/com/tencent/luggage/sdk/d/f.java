package com.tencent.luggage.sdk.d;

import android.content.res.Configuration;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.mm.plugin.appbrand.config.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "", "init", "", "initConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "luggage-wechat-full-sdk_release"})
public abstract interface f<C extends AppBrandInitConfigLU>
{
  public abstract void a(C paramC);
  
  public abstract void a(b paramb);
  
  public abstract void b(C paramC);
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.f
 * JD-Core Version:    0.7.0.1
 */