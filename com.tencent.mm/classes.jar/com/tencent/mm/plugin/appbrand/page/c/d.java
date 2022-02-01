package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "luggage-wxa-app_release"})
public abstract interface d<T extends AppBrandRuntime>
{
  public abstract boolean a(T paramT, String paramString, Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.d
 * JD-Core Version:    0.7.0.1
 */