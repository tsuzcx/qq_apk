package com.tencent.mm.plugin.appbrand.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;

public enum a
{
  static
  {
    AppMethodBeat.i(174716);
    qVk = new a("INSTANCE");
    qVl = new a[] { qVk };
    AppMethodBeat.o(174716);
  }
  
  private a() {}
  
  public static Intent U(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(21061);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.setClass(paramContext, AppBrandSearchUI.class);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("title", paramContext.getString(ba.i.app_brand_fts_search_wxapp));
    localIntent.putExtra("searchbar_tips", paramContext.getString(ba.i.app_brand_fts_search_wxapp));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", paramInt);
    Object localObject = com.tencent.mm.plugin.websearch.d.a.ck(paramInt, true);
    String str = c.bED();
    ((Map)localObject).put("WASessionId", str);
    ((Map)localObject).put("sessionId", str);
    ((Map)localObject).put("subSessionId", str);
    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.d.a.bo((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localObject = h.baE().ban();
    if (paramInt == 52)
    {
      localObject = ((aq)localObject).get(at.a.acPJ, null);
      if (!(localObject instanceof String)) {
        break label341;
      }
      localObject = (String)localObject;
      localIntent.putExtra("key_search_input_hint", (String)localObject);
      if ((paramContext instanceof Activity)) {
        break label347;
      }
    }
    label341:
    label347:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_alpha_in", bool);
      localIntent.putExtra("key_preload_biz", 5);
      AppMethodBeat.o(21061);
      return localIntent;
      localObject = ((aq)localObject).get(at.a.acPH, null);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.a
 * JD-Core Version:    0.7.0.1
 */