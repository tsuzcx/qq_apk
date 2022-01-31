package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.af.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class al
  extends com.tencent.mm.plugin.w.a
{
  protected abstract int A(Intent paramIntent);
  
  protected void a(Context paramContext, Intent paramIntent, boolean paramBoolean) {}
  
  protected void b(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str1;
    int i;
    if (paramBoolean)
    {
      str2 = c.dd(w.n(paramIntent, "id"), q.getAndroidId());
      str1 = c.dd(w.n(paramIntent, "ext_info"), q.getAndroidId());
      i = w.a(paramIntent, "ext_info_1", 0);
      so localso = new so();
      localso.cIQ.appId = str1;
      localso.cIQ.userName = str2;
      localso.cIQ.cIT = i;
      localso.cIQ.scene = A(paramIntent);
      localso.cIQ.cIW = true;
      localso.cIQ.context = paramContext;
      localso.cIQ.cIX = false;
      com.tencent.mm.sdk.b.a.ymk.l(localso);
      if (!localso.cIR.cJh) {
        break label182;
      }
      ab.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[] { str2 });
    }
    label182:
    do
    {
      return;
      str2 = c.decrypt(w.n(paramIntent, "id"));
      str1 = c.decrypt(w.n(paramIntent, "ext_info"));
      break;
      if (i == 1)
      {
        Toast.makeText(paramContext, 2131296604, 0).show();
        return;
      }
    } while (i != 2);
    Toast.makeText(paramContext, 2131296746, 0).show();
  }
  
  protected boolean b(Intent paramIntent, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = c.dd(w.n(paramIntent, "id"), q.getAndroidId());
    }
    String str2;
    int i;
    for (String str1 = c.dd(w.n(paramIntent, "ext_info"), q.getAndroidId());; str1 = c.decrypt(w.n(paramIntent, "ext_info")))
    {
      str2 = w.n(paramIntent, "token");
      i = w.a(paramIntent, "ext_info_1", 0);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break;
      }
      ab.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
      return false;
      localObject = c.decrypt(w.n(paramIntent, "id"));
    }
    if (!l.na((String)localObject))
    {
      ab.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[] { localObject });
      e.qrI.idkeyStat(647L, 1L, 1L, false);
      return false;
    }
    paramIntent = new StringBuilder();
    g.RJ();
    if (!str2.equals(c.de(str1, com.tencent.mm.kernel.a.getUin())))
    {
      paramIntent = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
      if (paramIntent == null)
      {
        ab.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
        return false;
      }
      localObject = paramIntent.getStringSet("uin_set", new HashSet());
      if ((localObject == null) || (((Set)localObject).isEmpty()))
      {
        ab.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
        return false;
      }
      paramIntent = new HashSet();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramIntent.add(c.de(str1, (String)((Iterator)localObject).next()));
      }
      if (!paramIntent.contains(str2))
      {
        ab.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[] { str2 });
        return false;
      }
    }
    if ((!b.dsf()) && (i == 1))
    {
      ab.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
      return false;
    }
    return true;
  }
  
  public void l(Context paramContext, Intent paramIntent)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.al
 * JD-Core Version:    0.7.0.1
 */