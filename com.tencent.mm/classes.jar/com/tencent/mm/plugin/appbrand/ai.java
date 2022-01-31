package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.g.a.bx.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class ai
  extends al
{
  protected final int A(Intent paramIntent)
  {
    return 1023;
  }
  
  protected final void a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(143050);
    if (!paramBoolean)
    {
      h.qsU.idkeyStat(443L, 3L, 1L, false);
      if (Build.VERSION.SDK_INT >= 26)
      {
        String str = c.dd(w.n(paramIntent, "id"), q.getAndroidId());
        if (!l.na(str))
        {
          ab.e("MiroMsg.WxaLauncherShortcutEntry", "jump to Wxa with androidId decode failed, username %s invalid , try to decode with imei", new Object[] { str });
          if (l.na(c.decrypt(w.n(paramIntent, "id"))))
          {
            b(paramContext, paramIntent, false);
            AppMethodBeat.o(143050);
            return;
          }
          Toast.makeText(paramContext, paramContext.getString(2131306050), 1).show();
        }
      }
    }
    AppMethodBeat.o(143050);
  }
  
  protected final void b(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(143051);
    super.b(paramContext, paramIntent, paramBoolean);
    if (paramBoolean) {}
    int i;
    WxaAttributes localWxaAttributes;
    for (String str = c.dd(w.n(paramIntent, "id"), q.getAndroidId());; str = c.decrypt(w.n(paramIntent, "id")))
    {
      i = w.a(paramIntent, "ext_info_1", 0);
      localObject1 = w.n(paramIntent, "digest");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label247;
      }
      try
      {
        localWxaAttributes = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(str);
        if (localWxaAttributes != null) {
          break;
        }
        ab.e("MiroMsg.WxaLauncherShortcutEntry", "no such WeApp(%s)", new Object[] { str });
        AppMethodBeat.o(143051);
        return;
      }
      catch (NullPointerException paramContext)
      {
        ab.e("MiroMsg.WxaLauncherShortcutEntry", "query attrs with username[%s], e=%s", new Object[] { str, paramContext });
        AppMethodBeat.o(143051);
        return;
      }
    }
    Object localObject2 = localWxaAttributes.field_nickname;
    if (!((String)localObject1).equals(com.tencent.mm.a.g.w(((String)localObject2 + localWxaAttributes.field_roundedSquareIconURL + localWxaAttributes.field_brandIconURL + localWxaAttributes.field_bigHeadURL).getBytes())))
    {
      ab.i("MiroMsg.WxaLauncherShortcutEntry", "update shortcut for wxa(%s)", new Object[] { str });
      if (paramContext != null) {
        break label270;
      }
      ab.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.al.p(new ai.1(this, localWxaAttributes, paramContext, i, paramBoolean), 1000L);
      label247:
      paramIntent.putExtra("type", 0);
      paramIntent.putExtra("id", "");
      AppMethodBeat.o(143051);
      return;
      label270:
      if (paramIntent == null)
      {
        ab.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
      }
      else
      {
        localObject1 = new bx();
        ((bx)localObject1).cpl.username = str;
        a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        if (((bx)localObject1).cpm.bDK != null) {
          break;
        }
        ab.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[] { str });
      }
    }
    if (TextUtils.isEmpty(((bx)localObject1).cpm.nickname)) {}
    for (Object localObject1 = str;; localObject1 = ((bx)localObject1).cpm.nickname)
    {
      localObject2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      com.tencent.mm.plugin.base.model.b.q(paramContext, (Intent)localObject2);
      ab.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { str });
      break;
    }
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void l(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(129167);
    h.qsU.idkeyStat(443L, 2L, 1L, false);
    super.l(paramContext, paramIntent);
    AppMethodBeat.o(129167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai
 * JD-Core Version:    0.7.0.1
 */