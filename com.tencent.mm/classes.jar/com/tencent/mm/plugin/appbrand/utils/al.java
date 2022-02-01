package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.k;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatUserAuthorizedHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IUserAuthorizedHelper;", "()V", "isUserAuthorized", "", "plugin-appbrand-integration_release"})
public final class al
  implements ad
{
  public final boolean biW()
  {
    AppMethodBeat.i(180718);
    if ((!k.IwK) || (!ak.getContext().getSharedPreferences(ak.fow(), 0).getBoolean("gprs_alert", true)))
    {
      AppMethodBeat.o(180718);
      return true;
    }
    AppMethodBeat.o(180718);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.al
 * JD-Core Version:    0.7.0.1
 */