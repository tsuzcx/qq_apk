package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class LoginSelectUI
  extends MMPreference
{
  public int getHeaderResourceId()
  {
    return 2131495319;
  }
  
  public int getResourceId()
  {
    return 2132017232;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196871);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131099650));
    setBackGroundColorResource(2131101424);
    if (getListView() != null)
    {
      getListView().setBackgroundColor(getContext().getResources().getColor(2131099650));
      paramBundle = (LinearLayout.LayoutParams)getListView().getLayoutParams();
      paramBundle.width = at.aH(getContext(), 2131165305);
      paramBundle.gravity = 1;
      getListView().setLayoutParams(paramBundle);
    }
    AppMethodBeat.o(196871);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(196872);
    paramf = paramPreference.mKey;
    if (paramf.equals("phone_and_pad"))
    {
      c.V(this, "login_exdevice", ".ui.LoginAsExDeviceUI");
      overridePendingTransition(2130772129, 2130771986);
      h.CyF.Ip(1L);
    }
    for (;;)
    {
      AppMethodBeat.o(196872);
      return false;
      if (paramf.equals("only_pad"))
      {
        paramf = new Intent(this, MobileInputUI.class);
        paramf.putExtra("mobile_input_purpose", 1);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSelectUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h.CyF.Ip(0L);
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