package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class bf
  extends bi
{
  protected final void a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(43999);
    if (!paramBoolean)
    {
      h.CyF.idkeyStat(443L, 3L, 1L, false);
      if (Build.VERSION.SDK_INT >= 26)
      {
        String str = c.eX(IntentUtil.getStringExtra(paramIntent, "id"), com.tencent.mm.compatible.deviceinfo.q.getAndroidId());
        if (!m.HF(str))
        {
          Log.e("MiroMsg.WxaLauncherShortcutEntry", "jump to Wxa with androidId decode failed, username %s invalid , try to decode with imei", new Object[] { str });
          if (m.HF(c.ahb(IntentUtil.getStringExtra(paramIntent, "id"))))
          {
            b(paramContext, paramIntent, false);
            AppMethodBeat.o(43999);
            return;
          }
          Toast.makeText(paramContext, paramContext.getString(2131768810), 1).show();
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
    for (String str = c.eX(IntentUtil.getStringExtra(paramIntent, "id"), com.tencent.mm.compatible.deviceinfo.q.getAndroidId());; str = c.ahb(IntentUtil.getStringExtra(paramIntent, "id")))
    {
      i = IntentUtil.getIntExtra(paramIntent, "ext_info_1", 0);
      localObject1 = IntentUtil.getStringExtra(paramIntent, "digest");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label247;
      }
      try
      {
        localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str);
        if (localWxaAttributes != null) {
          break;
        }
        Log.e("MiroMsg.WxaLauncherShortcutEntry", "no such WeApp(%s)", new Object[] { str });
        AppMethodBeat.o(44000);
        return;
      }
      catch (NullPointerException paramContext)
      {
        Log.e("MiroMsg.WxaLauncherShortcutEntry", "query attrs with username[%s], e=%s", new Object[] { str, paramContext });
        AppMethodBeat.o(44000);
        return;
      }
    }
    Object localObject2 = localWxaAttributes.field_nickname;
    if (!((String)localObject1).equals(com.tencent.mm.b.g.getMessageDigest(((String)localObject2 + localWxaAttributes.field_roundedSquareIconURL + localWxaAttributes.field_brandIconURL + localWxaAttributes.field_bigHeadURL).getBytes())))
    {
      Log.i("MiroMsg.WxaLauncherShortcutEntry", "update shortcut for wxa(%s)", new Object[] { str });
      if (paramContext != null) {
        break label270;
      }
      Log.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
    }
    for (;;)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43997);
          com.tencent.mm.kernel.g.aAf();
          int i = a.getUin();
          Object localObject = localWxaAttributes.field_roundedSquareIconURL;
          String str1 = localWxaAttributes.field_brandIconURL;
          String str2 = localWxaAttributes.field_bigHeadURL;
          String str3 = localWxaAttributes.field_nickname;
          String str4 = localWxaAttributes.field_appId;
          String str5 = localWxaAttributes.field_username;
          localObject = new v.a(i, new String[] { localObject, str1, str2 }, str3, str4, str5);
          v.a(paramContext, (v.a)localObject, i, paramBoolean);
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
        Log.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
      }
      else
      {
        localObject1 = new ch();
        ((ch)localObject1).dFr.username = str;
        EventCenter.instance.publish((IEvent)localObject1);
        if (((ch)localObject1).dFs.cze != null) {
          break;
        }
        Log.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[] { str });
      }
    }
    if (TextUtils.isEmpty(((ch)localObject1).dFs.nickname)) {}
    for (Object localObject1 = str;; localObject1 = ((ch)localObject1).dFs.nickname)
    {
      localObject2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      b.q(paramContext, (Intent)localObject2);
      Log.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { str });
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
    h.CyF.idkeyStat(443L, 2L, 1L, false);
    super.k(paramContext, paramIntent);
    AppMethodBeat.o(43998);
  }
  
  protected final int z(Intent paramIntent)
  {
    return 1023;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bf
 * JD-Core Version:    0.7.0.1
 */