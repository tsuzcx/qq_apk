package com.tencent.mm.plugin.appbrand.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.compat.a.a.a;
import com.tencent.mm.plugin.appbrand.u.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class a
  implements com.tencent.mm.plugin.appbrand.compat.a.a
{
  public final void Q(Context paramContext, String paramString)
  {
    paramString = new Intent(paramContext, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", paramString);
    paramString.putExtra("title", paramContext.getString(R.l.app_brand_nearby_list_title));
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramString, 3);
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  public final void R(Context paramContext, String paramString)
  {
    paramString = new Intent(paramContext, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", paramString);
    paramString.putExtra("title", paramContext.getString(R.l.app_brand_launcher_head_wxagame));
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramString, 4);
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  public final void a(g.a parama, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    l.a(parama, paramString1, paramString2, paramString3, null, paramArrayOfByte);
  }
  
  public final void a(a.a parama)
  {
    b.a locala = new b.a();
    locala.ecH = new amv();
    locala.ecI = new amw();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
    locala.ecG = 1926;
    locala.ecJ = 0;
    locala.ecK = 0;
    w.a(locala.Kt(), new a.1(this, parama), true);
  }
  
  public final View c(Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(R.i.layout_appbrand_share_page_preview_footer, paramViewGroup, false);
  }
  
  public final Intent cd(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.setClass(paramContext, AppBrandSearchUI.class);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("title", paramContext.getString(R.l.app_brand_fts_search_wxapp));
    localIntent.putExtra("searchbar_tips", paramContext.getString(R.l.app_brand_fts_search_wxapp));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", 201);
    Object localObject = r.b(201, true, 64);
    String str = b.Jk();
    ((Map)localObject).put("WASessionId", str);
    ((Map)localObject).put("sessionId", str);
    ((Map)localObject).put("subSessionId", str);
    localIntent.putExtra("rawUrl", r.v((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localObject = g.DP().Dz().get(ac.a.uuO, null);
    if ((localObject != null) && ((localObject instanceof String)))
    {
      localObject = (String)localObject;
      localIntent.putExtra("key_search_input_hint", (String)localObject);
      if ((paramContext instanceof Activity)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_alpha_in", bool);
      return localIntent;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.compat.a
 * JD-Core Version:    0.7.0.1
 */