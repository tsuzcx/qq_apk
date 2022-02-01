package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatUserAuthorizedHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IUserAuthorizedHelper;", "()V", "isUserAuthorized", "", "plugin-appbrand-integration_release"})
public final class ae
  implements ad
{
  public final boolean aXM()
  {
    AppMethodBeat.i(180718);
    if ((!i.ETy) || (!aj.getContext().getSharedPreferences(aj.eFD(), 0).getBoolean("gprs_alert", true)))
    {
      AppMethodBeat.o(180718);
      return true;
    }
    AppMethodBeat.o(180718);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ae
 * JD-Core Version:    0.7.0.1
 */