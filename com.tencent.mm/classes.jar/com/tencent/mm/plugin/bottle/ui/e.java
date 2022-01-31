package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

public final class e
  implements com.tencent.mm.pluginsdk.b.a, m.b
{
  private boolean bIU;
  final Context context;
  private f dnn;
  private ad dnp;
  private final Map<String, Preference> flG = new HashMap();
  private int status;
  
  public e(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void awY()
  {
    int i = 1;
    this.status = q.Gn();
    boolean bool;
    if ((q.Gu() & 0x40) == 0)
    {
      bool = true;
      this.bIU = bool;
      this.dnn.removeAll();
      if (this.flG.containsKey("contact_info_header_helper"))
      {
        HelperHeaderPreference localHelperHeaderPreference = (HelperHeaderPreference)this.flG.get("contact_info_header_helper");
        this.dnn.a(localHelperHeaderPreference);
        localHelperHeaderPreference = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
        localHelperHeaderPreference.al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(R.l.contact_info_floatbottle_tip));
        if (!this.bIU) {
          break label329;
        }
        label126:
        localHelperHeaderPreference.ov(i);
      }
      if (this.flG.containsKey("contact_info_floatbottle_hide_cat")) {
        this.dnn.a((Preference)this.flG.get("contact_info_floatbottle_hide_cat"));
      }
      if (!this.bIU) {
        break label334;
      }
      if (this.flG.containsKey("contact_info_goto_floatbottle")) {
        this.dnn.a((Preference)this.flG.get("contact_info_goto_floatbottle"));
      }
      if (this.flG.containsKey("contact_info_floatbottle_clear_data")) {
        this.dnn.a((Preference)this.flG.get("contact_info_floatbottle_clear_data"));
      }
      if (this.flG.containsKey("contact_info_floatbottle_hide_cat2")) {
        this.dnn.a((Preference)this.flG.get("contact_info_floatbottle_hide_cat2"));
      }
      if (this.flG.containsKey("contact_info_floatbottle_uninstall")) {
        this.dnn.a((Preference)this.flG.get("contact_info_floatbottle_uninstall"));
      }
    }
    label329:
    label334:
    while (!this.flG.containsKey("contact_info_floatbottle_install"))
    {
      return;
      bool = false;
      break;
      i = 0;
      break label126;
    }
    this.dnn.a((Preference)this.flG.get("contact_info_floatbottle_install"));
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new e.3(paramBoolean);
      new Timer().schedule(new e.4(paramContext, (ah)localObject), 1500L);
      return;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
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
      Assert.assertTrue(s.hr(paramad.field_username));
      au.Hx();
      c.Dz().a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      paramf.addPreferencesFromResource(R.o.contact_info_pref_floatbottle);
      paramad = paramf.add("contact_info_header_helper");
      if (paramad != null) {
        this.flG.put("contact_info_header_helper", paramad);
      }
      paramad = paramf.add("contact_info_goto_floatbottle");
      if (paramad != null) {
        this.flG.put("contact_info_goto_floatbottle", paramad);
      }
      paramad = (PreferenceCategory)paramf.add("contact_info_floatbottle_hide_cat");
      if (paramad != null) {
        this.flG.put("contact_info_floatbottle_hide_cat", paramad);
      }
      paramad = paramf.add("contact_info_floatbottle_clear_data");
      if (paramad != null) {
        this.flG.put("contact_info_floatbottle_clear_data", paramad);
      }
      paramad = (PreferenceCategory)paramf.add("contact_info_floatbottle_hide_cat2");
      if (paramad != null) {
        this.flG.put("contact_info_floatbottle_hide_cat2", paramad);
      }
      paramad = (PreferenceCategory)paramf.add("contact_info_floatbottle_hide_cat3");
      if (paramad != null) {
        this.flG.put("contact_info_floatbottle_hide_cat3", paramad);
      }
      paramad = paramf.add("contact_info_floatbottle_install");
      if (paramad != null) {
        this.flG.put("contact_info_floatbottle_install", paramad);
      }
      paramf = paramf.add("contact_info_floatbottle_uninstall");
      if (paramf != null) {
        this.flG.put("contact_info_floatbottle_uninstall", paramf);
      }
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    com.tencent.mm.plugin.bottle.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetFloatBottle", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_goto_floatbottle"))
    {
      paramString = bn.Id();
      if ((bk.a(Integer.valueOf(paramString.sex), 0) <= 0) || (bk.bl(paramString.getProvince()))) {
        this.context.startActivity(new Intent(this.context, BottleWizardStep1.class));
      }
      for (;;)
      {
        return true;
        this.context.startActivity(new Intent(this.context, BottleBeachUI.class));
      }
    }
    if (paramString.equals("contact_info_floatbottle_clear_data"))
    {
      h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new e.1(this), null);
      return true;
    }
    if (paramString.equals("contact_info_floatbottle_install"))
    {
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_floatbottle_uninstall"))
    {
      h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new e.2(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetFloatBottle", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.e
 * JD-Core Version:    0.7.0.1
 */