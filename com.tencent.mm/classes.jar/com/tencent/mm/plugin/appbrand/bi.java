package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ag.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class bi
  extends com.tencent.mm.plugin.x.a
{
  protected void a(Context paramContext, Intent paramIntent, boolean paramBoolean) {}
  
  protected void b(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str1;
    int i;
    if (paramBoolean)
    {
      str2 = c.eX(IntentUtil.getStringExtra(paramIntent, "id"), q.getAndroidId());
      str1 = c.eX(IntentUtil.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());
      i = IntentUtil.getIntExtra(paramIntent, "ext_info_1", 0);
      wq localwq = new wq();
      localwq.ecI.appId = str1;
      localwq.ecI.userName = str2;
      localwq.ecI.ecL = i;
      localwq.ecI.scene = z(paramIntent);
      localwq.ecI.ecP = true;
      localwq.ecI.context = paramContext;
      localwq.ecI.ecQ = false;
      EventCenter.instance.publish(localwq);
      if (!localwq.ecJ.edc) {
        break label182;
      }
      Log.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[] { str2 });
    }
    label182:
    do
    {
      return;
      str2 = c.ahb(IntentUtil.getStringExtra(paramIntent, "id"));
      str1 = c.ahb(IntentUtil.getStringExtra(paramIntent, "ext_info"));
      break;
      if (i == 1)
      {
        Toast.makeText(paramContext, 2131755408, 0).show();
        return;
      }
    } while (i != 2);
    Toast.makeText(paramContext, 2131755569, 0).show();
  }
  
  protected boolean b(Intent paramIntent, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = c.eX(IntentUtil.getStringExtra(paramIntent, "id"), q.getAndroidId());
    }
    String str2;
    int i;
    for (String str1 = c.eX(IntentUtil.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());; str1 = c.ahb(IntentUtil.getStringExtra(paramIntent, "ext_info")))
    {
      str2 = IntentUtil.getStringExtra(paramIntent, "token");
      i = IntentUtil.getIntExtra(paramIntent, "ext_info_1", 0);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break;
      }
      Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
      return false;
      localObject = c.ahb(IntentUtil.getStringExtra(paramIntent, "id"));
    }
    if (!m.HF((String)localObject))
    {
      Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[] { localObject });
      e.Cxv.idkeyStat(647L, 1L, 1L, false);
      return false;
    }
    paramIntent = new StringBuilder();
    g.aAf();
    if (!str2.equals(c.eY(str1, com.tencent.mm.kernel.a.getUin())))
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
        paramIntent.add(c.eY(str1, (String)((Iterator)localObject).next()));
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
  
  public void k(Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    for (boolean bool = true; !b(paramIntent, bool); bool = false)
    {
      a(paramContext, paramIntent, false);
      return;
    }
    a(paramContext, paramIntent, true);
    b(paramContext, paramIntent, bool);
  }
  
  protected abstract int z(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bi
 * JD-Core Version:    0.7.0.1
 */