package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "IFactory", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface v
{
  public abstract aj cHR();
  
  public abstract String getName();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "", "create", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract v a(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.v
 * JD-Core Version:    0.7.0.1
 */