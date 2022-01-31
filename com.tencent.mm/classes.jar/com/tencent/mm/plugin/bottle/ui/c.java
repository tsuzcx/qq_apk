package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.text.Html;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class c
{
  private MMActivity bER;
  private f dnn;
  
  public c(MMActivity paramMMActivity, f paramf)
  {
    this.bER = paramMMActivity;
    this.dnn = paramf;
    paramMMActivity = (ChoicePreference)this.dnn.add("settings_sex");
    paramMMActivity.vcc = new c.1(this);
    paramMMActivity.setTitle(Html.fromHtml(this.bER.getString(R.l.settings_sex) + "<font color='red'>*</font>"));
    ((KeyValuePreference)this.dnn.add("settings_district")).setTitle(Html.fromHtml(this.bER.getString(R.l.settings_district) + "<font color='red'>*</font>"));
  }
  
  public static void awT()
  {
    bn localbn = bn.Id();
    au.Hx();
    com.tencent.mm.model.c.Fv().b(new i.a(1, bn.a(localbn)));
    a.eUS.tk();
  }
  
  public final boolean awU()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("persist_signature", false);
    a.eUR.c(localIntent, this.bER);
    return true;
  }
  
  public final boolean awV()
  {
    a.eUR.b(new Intent(), this.bER);
    return true;
  }
  
  public final void update()
  {
    au.Hx();
    int i = bk.a((Integer)com.tencent.mm.model.c.Dz().get(12290, null), 0);
    Object localObject1 = (ChoicePreference)this.dnn.add("settings_sex");
    switch (i)
    {
    default: 
      ((ChoicePreference)localObject1).setValue("unknown");
    }
    for (;;)
    {
      Object localObject2 = bn.Id();
      localObject1 = ((bn)localObject2).getProvince();
      localObject2 = ((bn)localObject2).getCity();
      this.dnn.add("settings_district").setSummary(r.gX((String)localObject1) + " " + (String)localObject2);
      KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.dnn.add("settings_signature");
      localKeyValuePreference.vcS = false;
      au.Hx();
      localObject2 = bk.pm((String)com.tencent.mm.model.c.Dz().get(12291, null));
      MMActivity localMMActivity = this.bER;
      localObject1 = localObject2;
      if (((String)localObject2).length() <= 0) {
        localObject1 = this.bER.getString(R.l.settings_signature_empty);
      }
      localKeyValuePreference.setSummary(j.b(localMMActivity, (CharSequence)localObject1));
      this.dnn.notifyDataSetChanged();
      return;
      ((ChoicePreference)localObject1).setValue("male");
      continue;
      ((ChoicePreference)localObject1).setValue("female");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.c
 * JD-Core Version:    0.7.0.1
 */