package com.tencent.mm.plugin.appbrand.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Map;

public enum a
{
  static
  {
    AppMethodBeat.i(174716);
    jYt = new a("INSTANCE");
    jYu = new a[] { jYt };
    AppMethodBeat.o(174716);
  }
  
  private a() {}
  
  public static Intent I(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(21061);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.setClass(paramContext, AppBrandSearchUI.class);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("title", paramContext.getString(2131755430));
    localIntent.putExtra("searchbar_tips", paramContext.getString(2131755430));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", paramInt);
    Object localObject = com.tencent.mm.plugin.websearch.b.a.aY(paramInt, true);
    String str = b.aDR();
    ((Map)localObject).put("WASessionId", str);
    ((Map)localObject).put("sessionId", str);
    ((Map)localObject).put("subSessionId", str);
    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.b.a.be((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localObject = g.ajR().ajA();
    if (paramInt == 52)
    {
      localObject = ((aj)localObject).get(am.a.ISj, null);
      if (!(localObject instanceof String)) {
        break label339;
      }
      localObject = (String)localObject;
      localIntent.putExtra("key_search_input_hint", (String)localObject);
      if ((paramContext instanceof Activity)) {
        break label345;
      }
    }
    label339:
    label345:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_alpha_in", bool);
      localIntent.putExtra("key_preload_biz", 5);
      AppMethodBeat.o(21061);
      return localIntent;
      localObject = ((aj)localObject).get(am.a.ISh, null);
      if ((localObject != null) && ((localObject instanceof String)))
      {
        localObject = (String)localObject;
        break;
      }
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.a
 * JD-Core Version:    0.7.0.1
 */