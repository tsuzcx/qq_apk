package com.tencent.mm.plugin.appbrand.openmaterial.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"BOTTOM_SHEET_ACTION_ATTACH_OPEN", "", "BOTTOM_SHEET_ACTION_CLICK_APP_BRAND", "BOTTOM_SHEET_ACTION_CLICK_MORE", "BOTTOM_SHEET_ACTION_EXPOSE_LIST_PAGE_ENTRANCE", "BOTTOM_SHEET_ACTION_OPEN_LIST_PAGE_DIRECTLY", "BOTTOM_SHEET_ACTION_SHOW_ENHANCE", "BOTTOM_SHEET_SCENE_ATTACH", "BOTTOM_SHEET_SCENE_IMAGE", "BOTTOM_SHEET_SCENE_VIDEO", "BOTTOM_SHEET_SCENE_WEB_VIEW", "EXPOSURE_SCENE_BOTTOM_SHEET", "EXPOSURE_SCENE_LIST_PAGE", "TAG", "", "OnBottomSheetShow", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "plugin-appbrand-integration_release"})
public final class c
{
  public static final a b(b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(277416);
    p.k(paramb, "scene");
    p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
    paramb = new a(paramb, paramAppBrandOpenMaterialCollection);
    paramb.cda();
    AppMethodBeat.o(277416);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.b.c
 * JD-Core Version:    0.7.0.1
 */