package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bd;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class LoginSelectUI
  extends MMPreference
{
  private f screen;
  
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
    AppMethodBeat.i(305237);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(r.c.BG_2));
    setNavigationbarColor(getContext().getResources().getColor(r.c.BG_2));
    setBackGroundColorResource(r.c.white);
    if (getListView() != null)
    {
      getListView().setBackgroundColor(getContext().getResources().getColor(r.c.BG_2));
      paramBundle = (LinearLayout.LayoutParams)getListView().getLayoutParams();
      paramBundle.width = bd.bs(getContext(), r.d.Edge_50A);
      paramBundle.gravity = 1;
      getListView().setLayoutParams(paramBundle);
    }
    this.screen = getPreferenceScreen();
    if (aw.ato())
    {
      this.screen.bAi("phone_and_pad").setTitle(getResources().getString(r.j.fold_login_as_pad));
      this.screen.bAi("only_pad").setTitle(getResources().getString(r.j.fold_login_as_phone));
    }
    setBackBtn(new LoginSelectUI.1(this));
    AppMethodBeat.o(305237);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(305240);
    paramf = paramPreference.mKey;
    if (paramf.equals("phone_and_pad"))
    {
      com.tencent.mm.br.c.ai(this, "login_exdevice", ".ui.LoginAsExDeviceUI");
      overridePendingTransition(r.a.push_down_in, r.a.anim_not_change);
      h.OAn.tJ(1L);
    }
    for (;;)
    {
      AppMethodBeat.o(305240);
      return false;
      if (paramf.equals("only_pad"))
      {
        paramf = new Intent(this, MobileInputUI.class);
        paramf.putExtra("mobile_input_purpose", 1);
        paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.OAn.tJ(0L);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSelectUI
 * JD-Core Version:    0.7.0.1
 */