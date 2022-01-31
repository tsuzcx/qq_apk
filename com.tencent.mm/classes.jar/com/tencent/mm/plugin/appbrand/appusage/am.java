package com.tencent.mm.plugin.appbrand.appusage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.a;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.r.g.a;
import com.tencent.mm.plugin.appbrand.r.g.b;
import com.tencent.mm.plugin.appbrand.r.g.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class am
  implements com.tencent.mm.plugin.appbrand.r.g
{
  public final void a(Context paramContext, g.c paramc, String paramString)
  {
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1054;
    localAppBrandStatObject.bFv = paramString;
    ((d)com.tencent.mm.kernel.g.r(d.class)).a(paramContext, paramc.username, null, paramc.fJy, paramc.cau, null, localAppBrandStatObject);
  }
  
  public final void a(Context paramContext, String paramString, g.a parama)
  {
    Intent localIntent = new Intent(paramContext, AppBrandLauncherUI.class);
    localIntent.putExtra("extra_enter_scene", 10);
    localIntent.putExtra("extra_enter_scene_note", paramString + ":" + parama.tag);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public final g.b adz()
  {
    Object localObject1 = new g.b();
    ((g.b)localObject1).items = new ArrayList(0);
    ((g.b)localObject1).haN = -1;
    ((g.b)localObject1).bQZ = "";
    if (!com.tencent.mm.kernel.g.DN().dJH) {}
    while (!i.acO()) {
      return localObject1;
    }
    Object localObject2 = x.adw();
    g.b localb = new g.b();
    int i;
    if (localObject2 == null)
    {
      localObject1 = null;
      localb.bQZ = ((String)localObject1);
      if (localObject2 != null) {
        break label284;
      }
      i = 0;
      label80:
      localb.haN = i;
      if (localObject2 != null) {
        break label293;
      }
      localObject1 = new am.1(this, com.tencent.mm.plugin.appbrand.app.e.aaZ().a(new String[] { "brandId", "versionType" }, 4, 0));
      i = 4;
    }
    for (;;)
    {
      localb.items = new ArrayList(i);
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Object[])((Iterator)localObject1).next();
        WxaAttributes localWxaAttributes = com.tencent.mm.plugin.appbrand.app.e.aaT().d((String)localObject2[0], new String[] { "nickname", "brandIconURL" });
        if (localWxaAttributes != null)
        {
          g.c localc = new g.c();
          localc.username = ((String)localObject2[0]);
          localc.fJy = ((Integer)localObject2[1]).intValue();
          localc.cau = ((Integer)localObject2[2]).intValue();
          localc.nickname = localWxaAttributes.field_nickname;
          localc.fJY = localWxaAttributes.field_brandIconURL;
          localb.items.add(localc);
        }
      }
      localObject1 = ((akd)localObject2).lsL;
      break;
      label284:
      i = ((akd)localObject2).tgI;
      break label80;
      label293:
      localObject1 = new am.2(this, (akd)localObject2);
      i = ((akd)localObject2).tgH.size();
      com.tencent.mm.sdk.f.e.post(new am.3(this, (akd)localObject2), "BatchSyncWxaAttrBySearchShowOut");
    }
    localObject1 = x.a.fJB;
    x.adv();
    return localb;
  }
  
  public final Intent cd(Context paramContext)
  {
    y.i("alvinluo", "buildIntentToSearchUI start: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    Intent localIntent = aa.bZt();
    localIntent.setClassName(paramContext, "com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI");
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("title", paramContext.getString(y.j.app_brand_fts_search_appbrand));
    localIntent.putExtra("searchbar_tips", paramContext.getString(y.j.app_brand_fts_search_appbrand));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", 201);
    Object localObject = aa.b(201, true, 64);
    String str = b.Jk();
    ((Map)localObject).put("WASessionId", str);
    localIntent.putExtra("rawUrl", aa.v((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uuO, null);
    if ((localObject != null) && ((localObject instanceof String)))
    {
      localObject = (String)localObject;
      localIntent.putExtra("key_search_input_hint", (String)localObject);
      if ((paramContext instanceof Activity)) {
        break label282;
      }
    }
    label282:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_alpha_in", bool);
      y.i("alvinluo", "buildIntentToSearchUI end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      return localIntent;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am
 * JD-Core Version:    0.7.0.1
 */