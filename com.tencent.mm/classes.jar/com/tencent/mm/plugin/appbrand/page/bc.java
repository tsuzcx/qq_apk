package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "Lcom/tencent/luggage/base/ICustomize;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bc
  extends b
{
  public abstract <WIDGET extends View> WIDGET a(Class<WIDGET> paramClass, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bc
 * JD-Core Version:    0.7.0.1
 */