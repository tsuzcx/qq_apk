package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private ad contact;
  Context context;
  private Map<String, Preference> gCY;
  private f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(22758);
    this.gCY = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(22758);
  }
  
  private void bkc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(22762);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_masssend_header_helper");
    ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298661));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).sb(i);
      this.screen.cl("contact_info_masssend_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label164;
      }
      bool1 = true;
      label96:
      ((f)localObject).cl("contact_info_masssend_view", bool1);
      localObject = this.screen;
      if (bool3) {
        break label169;
      }
      bool1 = true;
      label119:
      ((f)localObject).cl("contact_info_masssend_clear_data", bool1);
      localObject = this.screen;
      if (bool3) {
        break label174;
      }
    }
    label164:
    label169:
    label174:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cl("contact_info_masssend_uninstall", bool1);
      AppMethodBeat.o(22762);
      return;
      i = 0;
      break;
      bool1 = false;
      break label96;
      bool1 = false;
      break label119;
    }
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(22764);
    b localb = com.tencent.mm.plugin.masssend.a.h.bPc();
    if (localb.fnw.execSQL("massendinfo", "delete from massendinfo")) {
      localb.doNotify();
    }
    aw.aaz();
    c.YF().arF("masssendapp");
    AppMethodBeat.o(22764);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(22760);
    if ((r.Zy() & 0x10000) == 0)
    {
      AppMethodBeat.o(22760);
      return true;
    }
    AppMethodBeat.o(22760);
    return false;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(22763);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new a.3(paramBoolean);
      new Timer().schedule(new a.4(paramContext, (ak)localObject), 1500L);
      AppMethodBeat.o(22763);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(22759);
    ab.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(22759);
      return false;
    }
    if (paramString.equals("contact_info_masssend_view"))
    {
      paramString = new Intent(this.context, MassSendHistoryUI.class);
      this.context.startActivity(paramString);
      AppMethodBeat.o(22759);
      return true;
    }
    if (paramString.equals("contact_info_masssend_clear_data"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131298571), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.1(this), null);
      AppMethodBeat.o(22759);
      return true;
    }
    if (paramString.equals("contact_info_masssend_install"))
    {
      u(this.context, true);
      AppMethodBeat.o(22759);
      return true;
    }
    if (paramString.equals("contact_info_masssend_uninstall"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.2(this), null);
      AppMethodBeat.o(22759);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(22759);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(22766);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    aw.aaz();
    if ((paramn != c.Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(22766);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(22766);
      return;
    }
    bkc();
    AppMethodBeat.o(22766);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(22761);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.od(paramad.field_username));
      aw.aaz();
      c.Ru().a(this);
      this.contact = paramad;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131165211);
      bkc();
      AppMethodBeat.o(22761);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(22765);
    aw.aaz();
    c.Ru().b(this);
    com.tencent.mm.plugin.masssend.a.gmP.BO();
    AppMethodBeat.o(22765);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a
 * JD-Core Version:    0.7.0.1
 */