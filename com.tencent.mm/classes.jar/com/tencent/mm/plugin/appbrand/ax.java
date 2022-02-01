package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class ax
  extends com.tencent.mm.plugin.y.a
{
  protected void a(Context paramContext, Intent paramIntent, boolean paramBoolean) {}
  
  protected void b(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str1;
    int i;
    if (paramBoolean)
    {
      str2 = c.eG(z.getStringExtra(paramIntent, "id"), q.getAndroidId());
      str1 = c.eG(z.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());
      i = z.getIntExtra(paramIntent, "ext_info_1", 0);
      vq localvq = new vq();
      localvq.dKT.appId = str1;
      localvq.dKT.userName = str2;
      localvq.dKT.dKW = i;
      localvq.dKT.scene = z(paramIntent);
      localvq.dKT.dLa = true;
      localvq.dKT.context = paramContext;
      localvq.dKT.dLb = false;
      com.tencent.mm.sdk.b.a.IvT.l(localvq);
      if (!localvq.dKU.dLn) {
        break label182;
      }
      ae.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[] { str2 });
    }
    label182:
    do
    {
      return;
      str2 = c.Xh(z.getStringExtra(paramIntent, "id"));
      str1 = c.Xh(z.getStringExtra(paramIntent, "ext_info"));
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
      localObject = c.eG(z.getStringExtra(paramIntent, "id"), q.getAndroidId());
    }
    String str2;
    int i;
    for (String str1 = c.eG(z.getStringExtra(paramIntent, "ext_info"), q.getAndroidId());; str1 = c.Xh(z.getStringExtra(paramIntent, "ext_info")))
    {
      str2 = z.getStringExtra(paramIntent, "token");
      i = z.getIntExtra(paramIntent, "ext_info_1", 0);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break;
      }
      ae.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
      return false;
      localObject = c.Xh(z.getStringExtra(paramIntent, "id"));
    }
    if (!m.zd((String)localObject))
    {
      ae.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[] { localObject });
      e.ywz.idkeyStat(647L, 1L, 1L, false);
      return false;
    }
    paramIntent = new StringBuilder();
    g.ajP();
    if (!str2.equals(c.eH(str1, com.tencent.mm.kernel.a.getUin())))
    {
      paramIntent = ak.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (paramIntent == null)
      {
        ae.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
        return false;
      }
      localObject = paramIntent.getStringSet("uin_set", new HashSet());
      if ((localObject == null) || (((Set)localObject).isEmpty()))
      {
        ae.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
        return false;
      }
      paramIntent = new HashSet();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramIntent.add(c.eH(str1, (String)((Iterator)localObject).next()));
      }
      if (!paramIntent.contains(str2))
      {
        ae.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[] { str2 });
        return false;
      }
    }
    if ((!b.fnF()) && (i == 1))
    {
      ae.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ax
 * JD-Core Version:    0.7.0.1
 */