package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatUserAuthorizedHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IUserAuthorizedHelper;", "()V", "isUserAuthorized", "", "plugin-appbrand-integration_release"})
public final class af
  implements ad
{
  public final boolean beJ()
  {
    AppMethodBeat.i(180718);
    if ((!i.GqL) || (!ai.getContext().getSharedPreferences(ai.eUX(), 0).getBoolean("gprs_alert", true)))
    {
      AppMethodBeat.o(180718);
      return true;
    }
    AppMethodBeat.o(180718);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af
 * JD-Core Version:    0.7.0.1
 */