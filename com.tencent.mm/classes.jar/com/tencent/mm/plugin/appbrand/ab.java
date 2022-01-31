package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ae.i;
import com.tencent.mm.h.a.bu;
import com.tencent.mm.h.a.bu.b;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ab
  extends com.tencent.mm.plugin.af.a
{
  public final int getType()
  {
    return 1;
  }
  
  public final void j(Context paramContext, Intent paramIntent)
  {
    h.nFQ.a(443L, 2L, 1L, false);
    String str = com.tencent.mm.plugin.base.model.c.decrypt(t.j(paramIntent, "id"));
    Object localObject1 = com.tencent.mm.plugin.base.model.c.decrypt(t.j(paramIntent, "ext_info"));
    Object localObject2 = t.j(paramIntent, "token");
    int i = t.a(paramIntent, "ext_info_1", 0);
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      y.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        h.nFQ.a(443L, 3L, 1L, false);
      }
      return;
      if (!i.gr(str))
      {
        y.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[] { str });
        f.nEG.a(647L, 1L, 1L, false);
        i = 0;
      }
      else
      {
        localObject3 = new StringBuilder();
        com.tencent.mm.kernel.g.DN();
        if (!((String)localObject2).equals(com.tencent.mm.plugin.base.model.c.cm((String)localObject1, com.tencent.mm.kernel.a.CK())))
        {
          localObject3 = ae.getContext().getSharedPreferences("app_brand_global_sp", 0);
          if (localObject3 == null)
          {
            y.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
            i = 0;
            continue;
          }
          Object localObject4 = ((SharedPreferences)localObject3).getStringSet("uin_set", new HashSet());
          if ((localObject4 == null) || (((Set)localObject4).isEmpty()))
          {
            y.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
            i = 0;
            continue;
          }
          localObject3 = new HashSet();
          localObject4 = ((Set)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Set)localObject3).add(com.tencent.mm.plugin.base.model.c.cm((String)localObject1, (String)((Iterator)localObject4).next()));
          }
          if (!((Set)localObject3).contains(localObject2))
          {
            y.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[] { localObject2 });
            i = 0;
            continue;
          }
        }
        if ((com.tencent.mm.sdk.a.b.cqk()) || (i != 1)) {
          break;
        }
        y.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
        i = 0;
      }
    }
    localObject2 = new rc();
    ((rc)localObject2).caq.appId = ((String)localObject1);
    ((rc)localObject2).caq.userName = str;
    ((rc)localObject2).caq.cat = i;
    ((rc)localObject2).caq.scene = 1023;
    ((rc)localObject2).caq.cax = true;
    ((rc)localObject2).caq.context = paramContext;
    ((rc)localObject2).caq.cay = false;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    if (((rc)localObject2).car.caH) {
      y.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[] { str });
    }
    for (;;)
    {
      localObject1 = t.j(paramIntent, "digest");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label683;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(str);
      if (localObject2 != null) {
        break label575;
      }
      y.e("MiroMsg.WxaShortcutEntry", "no such WeApp(%s)", new Object[] { str });
      i = 1;
      break;
      if (i == 1) {
        Toast.makeText(paramContext, y.j.app_brand_debug_app_from_share_card_can_not_open, 0).show();
      } else if (i == 2) {
        Toast.makeText(paramContext, y.j.app_brand_not_beta_pkg, 0).show();
      }
    }
    label575:
    Object localObject3 = ((WxaAttributes)localObject2).field_nickname;
    if (!((String)localObject1).equals(com.tencent.mm.a.g.o(((String)localObject3 + ((WxaAttributes)localObject2).field_roundedSquareIconURL + ((WxaAttributes)localObject2).field_brandIconURL + ((WxaAttributes)localObject2).field_bigHeadURL).getBytes())))
    {
      y.i("MiroMsg.WxaShortcutEntry", "update shortcut for wxa(%s)", new Object[] { str });
      if (paramContext != null) {
        break label707;
      }
      y.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
    }
    for (;;)
    {
      ai.l(new ab.1(this, (WxaAttributes)localObject2, paramContext, i), 1000L);
      label683:
      paramIntent.putExtra("type", 0);
      paramIntent.putExtra("id", "");
      i = 1;
      break;
      label707:
      if (paramIntent == null)
      {
        y.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
      }
      else
      {
        localObject1 = new bu();
        ((bu)localObject1).bHU.username = str;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        if (((bu)localObject1).bHV.bHW != null) {
          break label783;
        }
        y.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[] { str });
      }
    }
    label783:
    if (TextUtils.isEmpty(((bu)localObject1).bHV.nickname)) {}
    for (localObject1 = str;; localObject1 = ((bu)localObject1).bHV.nickname)
    {
      localObject3 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      ((Intent)localObject3).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
      ((Intent)localObject3).putExtra("duplicate", false);
      ((Intent)localObject3).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      com.tencent.mm.plugin.base.model.b.o(paramContext, (Intent)localObject3);
      y.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { str });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab
 * JD-Core Version:    0.7.0.1
 */