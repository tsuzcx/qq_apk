package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cf.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.z;

public final class au
  extends ax
{
  protected final void a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(43999);
    if (!paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(443L, 3L, 1L, false);
      if (Build.VERSION.SDK_INT >= 26)
      {
        String str = c.eG(z.getStringExtra(paramIntent, "id"), q.getAndroidId());
        if (!m.zd(str))
        {
          ae.e("MiroMsg.WxaLauncherShortcutEntry", "jump to Wxa with androidId decode failed, username %s invalid , try to decode with imei", new Object[] { str });
          if (m.zd(c.Xh(z.getStringExtra(paramIntent, "id"))))
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
    for (String str = c.eG(z.getStringExtra(paramIntent, "id"), q.getAndroidId());; str = c.Xh(z.getStringExtra(paramIntent, "id")))
    {
      i = z.getIntExtra(paramIntent, "ext_info_1", 0);
      localObject1 = z.getStringExtra(paramIntent, "digest");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label247;
      }
      try
      {
        localWxaAttributes = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(str);
        if (localWxaAttributes != null) {
          break;
        }
        ae.e("MiroMsg.WxaLauncherShortcutEntry", "no such WeApp(%s)", new Object[] { str });
        AppMethodBeat.o(44000);
        return;
      }
      catch (NullPointerException paramContext)
      {
        ae.e("MiroMsg.WxaLauncherShortcutEntry", "query attrs with username[%s], e=%s", new Object[] { str, paramContext });
        AppMethodBeat.o(44000);
        return;
      }
    }
    Object localObject2 = localWxaAttributes.field_nickname;
    if (!((String)localObject1).equals(com.tencent.mm.b.g.getMessageDigest(((String)localObject2 + localWxaAttributes.field_roundedSquareIconURL + localWxaAttributes.field_brandIconURL + localWxaAttributes.field_bigHeadURL).getBytes())))
    {
      ae.i("MiroMsg.WxaLauncherShortcutEntry", "update shortcut for wxa(%s)", new Object[] { str });
      if (paramContext != null) {
        break label270;
      }
      ae.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
    }
    for (;;)
    {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43997);
          com.tencent.mm.kernel.g.ajP();
          int i = com.tencent.mm.kernel.a.getUin();
          Object localObject = localWxaAttributes.field_roundedSquareIconURL;
          String str1 = localWxaAttributes.field_brandIconURL;
          String str2 = localWxaAttributes.field_bigHeadURL;
          String str3 = localWxaAttributes.field_nickname;
          String str4 = localWxaAttributes.field_appId;
          String str5 = localWxaAttributes.field_username;
          localObject = new u.a(i, new String[] { localObject, str1, str2 }, str3, str4, str5);
          u.a(paramContext, (u.a)localObject, i, paramBoolean);
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
        ae.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
      }
      else
      {
        localObject1 = new cf();
        ((cf)localObject1).doc.username = str;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        if (((cf)localObject1).dod.cni != null) {
          break;
        }
        ae.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[] { str });
      }
    }
    if (TextUtils.isEmpty(((cf)localObject1).dod.nickname)) {}
    for (Object localObject1 = str;; localObject1 = ((cf)localObject1).dod.nickname)
    {
      localObject2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      com.tencent.mm.plugin.base.model.b.q(paramContext, (Intent)localObject2);
      ae.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { str });
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
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(443L, 2L, 1L, false);
    super.k(paramContext, paramIntent);
    AppMethodBeat.o(43998);
  }
  
  protected final int z(Intent paramIntent)
  {
    return 1023;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.au
 * JD-Core Version:    0.7.0.1
 */