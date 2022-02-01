package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import org.apache.commons.b.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$Companion;", "", "()V", "TAG", "", "convertToDialogItem", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "scope", "data", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "plugin-appbrand-integration_release"})
public final class p$b
{
  public static List<h.a> a(String paramString, MMCarLicensePlateInfo paramMMCarLicensePlateInfo)
  {
    AppMethodBeat.i(280126);
    p.k(paramString, "scope");
    p.k(paramMMCarLicensePlateInfo, "data");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)paramMMCarLicensePlateInfo.sXr;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (String)localObject2;
      localArrayList.add(new h.a(1, g.bh((String)localObject2, 0, 2) + "·" + g.bh((String)localObject2, 2, ((String)localObject2).length()), "", paramString, null, p.h(paramMMCarLicensePlateInfo.sXs, localObject2), "", i));
      i += 1;
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(280126);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.p.b
 * JD-Core Version:    0.7.0.1
 */