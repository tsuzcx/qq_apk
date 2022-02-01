package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cu;
import com.tencent.mm.autogen.a.cu.b;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.message.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class bo
  extends br
{
  protected final int C(Intent paramIntent)
  {
    return 1023;
  }
  
  public final void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(43998);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(443L, 2L, 1L, false);
    super.C(paramContext, paramIntent);
    AppMethodBeat.o(43998);
  }
  
  protected final void b(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(43999);
    if (!paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(443L, 3L, 1L, false);
      if (Build.VERSION.SDK_INT >= 26)
      {
        String str = c.fC(IntentUtil.getStringExtra(paramIntent, "id"), q.getAndroidId());
        if (!m.Hh(str))
        {
          Log.e("MiroMsg.WxaLauncherShortcutEntry", "jump to Wxa with androidId decode failed, username %s invalid , try to decode with imei", new Object[] { str });
          if (m.Hh(c.aid(IntentUtil.getStringExtra(paramIntent, "id"))))
          {
            c(paramContext, paramIntent, false);
            AppMethodBeat.o(43999);
            return;
          }
          Toast.makeText(paramContext, paramContext.getString(ba.i.wxa_launch_shortcut_fail), 1).show();
        }
      }
    }
    AppMethodBeat.o(43999);
  }
  
  protected final void c(final Context paramContext, Intent paramIntent, final boolean paramBoolean)
  {
    AppMethodBeat.i(44000);
    super.c(paramContext, paramIntent, paramBoolean);
    if (paramBoolean) {}
    final int i;
    final WxaAttributes localWxaAttributes;
    for (String str = c.fC(IntentUtil.getStringExtra(paramIntent, "id"), q.getAndroidId());; str = c.aid(IntentUtil.getStringExtra(paramIntent, "id")))
    {
      i = IntentUtil.getIntExtra(paramIntent, "ext_info_1", 0);
      localObject1 = IntentUtil.getStringExtra(paramIntent, "digest");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label247;
      }
      try
      {
        localWxaAttributes = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(str);
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
    if (!((String)localObject1).equals(g.getMessageDigest(((String)localObject2 + localWxaAttributes.field_roundedSquareIconURL + localWxaAttributes.field_brandIconURL + localWxaAttributes.field_bigHeadURL).getBytes())))
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
          com.tencent.mm.kernel.h.baC();
          int i = com.tencent.mm.kernel.b.getUin();
          Object localObject = localWxaAttributes.field_roundedSquareIconURL;
          String str1 = localWxaAttributes.field_brandIconURL;
          String str2 = localWxaAttributes.field_bigHeadURL;
          String str3 = localWxaAttributes.field_nickname;
          String str4 = localWxaAttributes.field_appId;
          String str5 = localWxaAttributes.field_username;
          localObject = new ab.a(i, new String[] { localObject, str1, str2 }, str3, str4, str5);
          ab.a(paramContext, (ab.a)localObject, i, paramBoolean);
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
        localObject1 = new cu();
        ((cu)localObject1).hCE.username = str;
        ((cu)localObject1).publish();
        if (((cu)localObject1).hCF.eqg != null) {
          break;
        }
        Log.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[] { str });
      }
    }
    if (TextUtils.isEmpty(((cu)localObject1).hCF.nickname)) {}
    for (Object localObject1 = str;; localObject1 = ((cu)localObject1).hCF.nickname)
    {
      localObject2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", (String)localObject1);
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      com.tencent.mm.plugin.base.model.b.G(paramContext, (Intent)localObject2);
      Log.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[] { str });
      break;
    }
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bo
 * JD-Core Version:    0.7.0.1
 */