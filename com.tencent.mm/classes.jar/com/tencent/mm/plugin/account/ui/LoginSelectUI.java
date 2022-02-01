package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class LoginSelectUI
  extends MMPreference
{
  public int getHeaderResourceId()
  {
    return r.g.login_select_header;
  }
  
  public int getResourceId()
  {
    return r.k.login_select_pref;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213891);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(r.c.BG_2));
    setBackGroundColorResource(r.c.white);
    if (getListView() != null)
    {
      getListView().setBackgroundColor(getContext().getResources().getColor(r.c.BG_2));
      paramBundle = (LinearLayout.LayoutParams)getListView().getLayoutParams();
      paramBundle.width = aw.aZ(getContext(), r.d.Edge_50A);
      paramBundle.gravity = 1;
      getListView().setLayoutParams(paramBundle);
    }
    AppMethodBeat.o(213891);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(213892);
    paramf = paramPreference.mKey;
    if (paramf.equals("phone_and_pad"))
    {
      c.ad(this, "login_exdevice", ".ui.LoginAsExDeviceUI");
      overridePendingTransition(r.a.push_down_in, r.a.anim_not_change);
      h.IzE.PJ(1L);
    }
    for (;;)
    {
      AppMethodBeat.o(213892);
      return false;
      if (paramf.equals("only_pad"))
      {
        paramf = new Intent(this, MobileInputUI.class);
        paramf.putExtra("mobile_input_purpose", 1);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.IzE.PJ(0L);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSelectUI
 * JD-Core Version:    0.7.0.1
 */