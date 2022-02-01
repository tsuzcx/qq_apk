package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class av
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
      str2 = c.eu(x.getStringExtra(paramIntent, "id"), q.getAndroidId());
      str1 = c.eu(x.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());
      i = x.getIntExtra(paramIntent, "ext_info_1", 0);
      ut localut = new ut();
      localut.dxt.appId = str1;
      localut.dxt.userName = str2;
      localut.dxt.dxw = i;
      localut.dxt.scene = z(paramIntent);
      localut.dxt.dxz = true;
      localut.dxt.context = paramContext;
      localut.dxt.dxA = false;
      com.tencent.mm.sdk.b.a.GpY.l(localut);
      if (!localut.dxu.dxL) {
        break label182;
      }
      ac.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[] { str2 });
    }
    label182:
    do
    {
      return;
      str2 = c.SY(x.getStringExtra(paramIntent, "id"));
      str1 = c.SY(x.getStringExtra(paramIntent, "ext_info"));
      break;
      if (i == 1)
      {
        Toast.makeText(paramContext, 2131755370, 0).show();
        return;
      }
    } while (i != 2);
    Toast.makeText(paramContext, 2131755531, 0).show();
  }
  
  protected boolean b(Intent paramIntent, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = c.eu(x.getStringExtra(paramIntent, "id"), q.getAndroidId());
    }
    String str2;
    int i;
    for (String str1 = c.eu(x.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());; str1 = c.SY(x.getStringExtra(paramIntent, "ext_info")))
    {
      str2 = x.getStringExtra(paramIntent, "token");
      i = x.getIntExtra(paramIntent, "ext_info_1", 0);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break;
      }
      ac.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
      return false;
      localObject = c.SY(x.getStringExtra(paramIntent, "id"));
    }
    if (!m.vC((String)localObject))
    {
      ac.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[] { localObject });
      e.wTc.idkeyStat(647L, 1L, 1L, false);
      return false;
    }
    paramIntent = new StringBuilder();
    g.agP();
    if (!str2.equals(c.ev(str1, com.tencent.mm.kernel.a.getUin())))
    {
      paramIntent = ai.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (paramIntent == null)
      {
        ac.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
        return false;
      }
      localObject = paramIntent.getStringSet("uin_set", new HashSet());
      if ((localObject == null) || (((Set)localObject).isEmpty()))
      {
        ac.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
        return false;
      }
      paramIntent = new HashSet();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramIntent.add(c.ev(str1, (String)((Iterator)localObject).next()));
      }
      if (!paramIntent.contains(str2))
      {
        ac.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[] { str2 });
        return false;
      }
    }
    if ((!b.eUk()) && (i == 1))
    {
      ac.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.av
 * JD-Core Version:    0.7.0.1
 */