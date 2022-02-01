package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatUserAuthorizedHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IUserAuthorizedHelper;", "()V", "isUserAuthorized", "", "plugin-appbrand-integration_release"})
public final class al
  implements ai
{
  public final boolean bEm()
  {
    AppMethodBeat.i(180718);
    if ((!ChannelUtil.shouldShowGprsAlert) || (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)))
    {
      AppMethodBeat.o(180718);
      return true;
    }
    AppMethodBeat.o(180718);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.al
 * JD-Core Version:    0.7.0.1
 */