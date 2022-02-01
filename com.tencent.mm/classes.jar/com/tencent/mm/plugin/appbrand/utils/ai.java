package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatUserAuthorizedHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IUserAuthorizedHelper;", "()V", "isUserAuthorized", "", "plugin-appbrand-integration_release"})
public final class ai
  implements ad
{
  public final boolean bin()
  {
    AppMethodBeat.i(180718);
    if ((!j.Icz) || (!aj.getContext().getSharedPreferences(aj.fkC(), 0).getBoolean("gprs_alert", true)))
    {
      AppMethodBeat.o(180718);
      return true;
    }
    AppMethodBeat.o(180718);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ai
 * JD-Core Version:    0.7.0.1
 */