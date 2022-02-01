package com.tencent.mm.plugin.appbrand.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;

public enum a
{
  static
  {
    AppMethodBeat.i(174716);
    nVA = new a("INSTANCE");
    nVB = new a[] { nVA };
    AppMethodBeat.o(174716);
  }
  
  private a() {}
  
  public static Intent P(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(21061);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.setClass(paramContext, AppBrandSearchUI.class);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("title", paramContext.getString(au.i.app_brand_fts_search_wxapp));
    localIntent.putExtra("searchbar_tips", paramContext.getString(au.i.app_brand_fts_search_wxapp));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", paramInt);
    Object localObject = com.tencent.mm.plugin.websearch.c.a.bC(paramInt, true);
    String str = b.bgL();
    ((Map)localObject).put("WASessionId", str);
    ((Map)localObject).put("sessionId", str);
    ((Map)localObject).put("subSessionId", str);
    localIntent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.c.a.aX((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localObject = h.aHG().aHp();
    if (paramInt == 52)
    {
      localObject = ((ao)localObject).get(ar.a.Von, null);
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
      localObject = ((ao)localObject).get(ar.a.Vol, null);
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