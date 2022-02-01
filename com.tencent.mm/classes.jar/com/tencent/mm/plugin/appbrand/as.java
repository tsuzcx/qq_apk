package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cc.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

public final class as
  extends av
{
  protected final void a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(43999);
    if (!paramBoolean)
    {
      h.vKh.idkeyStat(443L, 3L, 1L, false);
      if (Build.VERSION.SDK_INT >= 26)
      {
        String str = c.ei(y.getStringExtra(paramIntent, "id"), q.getAndroidId());
        if (!com.tencent.mm.ai.m.rz(str))
        {
          ad.e("MiroMsg.WxaLauncherShortcutEntry", "jump to Wxa with androidId decode failed, username %s invalid , try to decode with imei", new Object[] { str });
          if (com.tencent.mm.ai.m.rz(c.OO(y.getStringExtra(paramIntent, "id"))))
          {
            b(paramContext, paramIntent, false);
            AppMethodBeat.o(43999);
            return;
          }
          Toast.makeText(paramContext, paramContext.getString(2131766299), 1).show();
        }
      }
    }
    AppMethodBeat.o(43999);
  }
  
  protected final void b(final Context paramContext, Intent paramIntent, final boolean paramBoolean)
  {
    AppMethodBeat.i(44000);
    super.b(paramContext, paramIntent, paramBoolean);
    if (paramBoolean) {}
    final int i;
    final WxaAttributes localWxaAttributes;
    for (String str = c.ei(y.getStringExtra(paramIntent, "id"), q.getAndroidId());; str = c.OO(y.getStringExtra(paramIntent, "id")))
    {
      i = y.getIntExtra(paramIntent, "ext_info_1", 0);
      localObject1 = y.getStringExtra(paramIntent, "digest");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label247;
      }
      try
      {
        localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(str);
        if (localWxaAttributes != null) {
          break;
        }
        ad.e("MiroMsg.WxaLauncherShortcutEntry", "no such WeApp(%s)", new Object[] { str });
        AppMethodBeat.o(44000);
        return;
      }
      catch (NullPointerException paramContext)
      {
        ad.e("MiroMsg.WxaLauncherShortcutEntry", "query attrs with username[%s], e=%s", new Object[] { str, paramContext });
        AppMethodBeat.o(44000);
        return;
      }
    }
    Object localObject2 = localWxaAttributes.field_nickname;
    if (!((String)localObject1).equals(com.tencent.mm.b.g.getMessageDigest(((String)localObject2 + localWxaAttributes.field_roundedSquareIconURL + localWxaAttributes.field_brandIconURL + localWxaAttributes.field_bigHeadURL).getBytes())))
    {
      ad.i("MiroMsg.WxaLauncherShortcutEntry", "update shortcut for wxa(%s)", new Object[] { str });
      if (paramContext != null) {
        break label270;
      }
      ad.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
    }
    for (;;)
    {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43997);
          com.tencent.mm.kernel.g.afz();
          int i = com.tencent.mm.kernel.a.getUin();
          Object localObject = localWxaAttributes.field_roundedSquareIconURL;
          String str1 = localWxaAttributes.field_brandIconURL;
          String str2 = localWxaAttributes.field_bigHeadURL;
          String str3 = localWxaAttributes.field_nickname;
          String str4 = localWxaAttributes.field_appId;
          String str5 = localWxaAttributes.field_username;
          localObject = new t.a(i, new String[] { localObject, str1, str2 }, str3, str4, str5);
          t.a(paramContext, (t.a)localObject, i, paramBoolean);
          AppMethodBeat.o(43997);
        }
      }, 1000L);
      label247:
      paramIntent.putExtra("type", 0);
      paramIntent.putExtra("id", "");
      AppMethodBeat.o(44000);
      return;
      label270:
      if (paramIntent == null)
      {
        ad.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
      }
      else
      {
        localObject1 = new cc();
        ((cc)localObject1).dei.username = str;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        if (((cc)localObject1).dej.cfS != null) {
          break;
        }
        ad.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[] { str });
      }
    }
    if (TextUtils.isEmpty(((cc)localObject1).dej.nickname)) {}
    for (Object localObject1 = str;; localObject1 = ((cc)localObject1).dej.nickname)
    {
      localObject2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      com.tencent.mm.plugin.base.model.b.q(paramContext, (Intent)localObject2);
      ad.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { str });
      break;
    }
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void k(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(43998);
    h.vKh.idkeyStat(443L, 2L, 1L, false);
    super.k(paramContext, paramIntent);
    AppMethodBeat.o(43998);
  }
  
  protected final int z(Intent paramIntent)
  {
    return 1023;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.as
 * JD-Core Version:    0.7.0.1
 */