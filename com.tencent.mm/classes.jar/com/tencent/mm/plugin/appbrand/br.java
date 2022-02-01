package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.m;
import com.tencent.mm.plugin.an.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class br
  extends a
{
  protected abstract int C(Intent paramIntent);
  
  public void C(Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    for (boolean bool = true; !b(paramIntent, bool); bool = false)
    {
      b(paramContext, paramIntent, false);
      return;
    }
    b(paramContext, paramIntent, true);
    c(paramContext, paramIntent, bool);
  }
  
  protected void b(Context paramContext, Intent paramIntent, boolean paramBoolean) {}
  
  protected boolean b(Intent paramIntent, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = c.fC(IntentUtil.getStringExtra(paramIntent, "id"), q.getAndroidId());
    }
    String str2;
    int i;
    for (String str1 = c.fC(IntentUtil.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());; str1 = c.aid(IntentUtil.getStringExtra(paramIntent, "ext_info")))
    {
      str2 = IntentUtil.getStringExtra(paramIntent, "token");
      i = IntentUtil.getIntExtra(paramIntent, "ext_info_1", 0);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break;
      }
      Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
      return false;
      localObject = c.aid(IntentUtil.getStringExtra(paramIntent, "id"));
    }
    if (!m.Hh((String)localObject))
    {
      Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[] { localObject });
      f.Ozc.idkeyStat(647L, 1L, 1L, false);
      return false;
    }
    paramIntent = new StringBuilder();
    h.baC();
    if (!str2.equals(c.fD(str1, b.getUin())))
    {
      paramIntent = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (paramIntent == null)
      {
        Log.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
        return false;
      }
      localObject = paramIntent.getStringSet("uin_set", new HashSet());
      if ((localObject == null) || (((Set)localObject).isEmpty()))
      {
        Log.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
        return false;
      }
      paramIntent = new HashSet();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramIntent.add(c.fD(str1, (String)((Iterator)localObject).next()));
      }
      if (!paramIntent.contains(str2))
      {
        Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[] { str2 });
        return false;
      }
    }
    if ((!CrashReportFactory.hasDebuger()) && (i == 1))
    {
      Log.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
      return false;
    }
    return true;
  }
  
  protected void c(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str1;
    int i;
    if (paramBoolean)
    {
      str2 = c.fC(IntentUtil.getStringExtra(paramIntent, "id"), q.getAndroidId());
      str1 = c.fC(IntentUtil.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());
      i = IntentUtil.getIntExtra(paramIntent, "ext_info_1", 0);
      zp localzp = new zp();
      localzp.icM.appId = str1;
      localzp.icM.userName = str2;
      localzp.icM.icP = i;
      localzp.icM.scene = C(paramIntent);
      localzp.icM.icT = true;
      localzp.icM.context = paramContext;
      localzp.icM.icU = false;
      localzp.publish();
      if (!localzp.icN.idi) {
        break label179;
      }
      Log.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[] { str2 });
    }
    label179:
    do
    {
      return;
      str2 = c.aid(IntentUtil.getStringExtra(paramIntent, "id"));
      str1 = c.aid(IntentUtil.getStringExtra(paramIntent, "ext_info"));
      break;
      if (i == 1)
      {
        Toast.makeText(paramContext, ba.i.app_brand_debug_app_from_share_card_can_not_open, 0).show();
        return;
      }
    } while (i != 2);
    Toast.makeText(paramContext, ba.i.app_brand_not_beta_pkg, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.br
 * JD-Core Version:    0.7.0.1
 */