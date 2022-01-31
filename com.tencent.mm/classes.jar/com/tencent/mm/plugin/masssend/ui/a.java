package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, m.b
{
  Context context;
  private f dnn;
  private ad dnp;
  private Map<String, Preference> flG = new HashMap();
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void adg()
  {
    b localb = com.tencent.mm.plugin.masssend.a.h.bhd();
    if (localb.dXo.gk("massendinfo", "delete from massendinfo")) {
      localb.doNotify();
    }
    au.Hx();
    c.FB().abu("masssendapp");
  }
  
  private void awY()
  {
    boolean bool3 = true;
    Object localObject;
    int i;
    label65:
    boolean bool2;
    if ((q.Gu() & 0x10000) == 0)
    {
      bool1 = true;
      localObject = (HelperHeaderPreference)this.dnn.add("contact_info_masssend_header_helper");
      ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(R.l.contact_info_masssend_tip));
      if (!bool1) {
        break label156;
      }
      i = 1;
      ((HelperHeaderPreference)localObject).ov(i);
      this.dnn.bJ("contact_info_masssend_install", bool1);
      localObject = this.dnn;
      if (bool1) {
        break label161;
      }
      bool2 = true;
      label95:
      ((f)localObject).bJ("contact_info_masssend_view", bool2);
      localObject = this.dnn;
      if (bool1) {
        break label166;
      }
      bool2 = true;
      label117:
      ((f)localObject).bJ("contact_info_masssend_clear_data", bool2);
      localObject = this.dnn;
      if (bool1) {
        break label171;
      }
    }
    label156:
    label161:
    label166:
    label171:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      ((f)localObject).bJ("contact_info_masssend_uninstall", bool1);
      return;
      bool1 = false;
      break;
      i = 0;
      break label65;
      bool2 = false;
      break label95;
      bool2 = false;
      break label117;
    }
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new a.3(paramBoolean);
      new Timer().schedule(new a.4(paramContext, (ah)localObject), 1500L);
      return;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    awY();
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(s.hu(paramad.field_username));
      au.Hx();
      c.Dz().a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      paramf.addPreferencesFromResource(R.o.contact_info_pref_masssend);
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    com.tencent.mm.plugin.masssend.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_masssend_view"))
    {
      paramString = new Intent(this.context, MassSendHistoryUI.class);
      this.context.startActivity(paramString);
      return true;
    }
    if (paramString.equals("contact_info_masssend_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new a.1(this), null);
      return true;
    }
    if (paramString.equals("contact_info_masssend_install"))
    {
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_masssend_uninstall"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new a.2(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a
 * JD-Core Version:    0.7.0.1
 */