package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI
  extends MMWizardActivity
{
  private TextView fbM;
  private TextView fbN;
  private Button fbO;
  private ImageView fbt;
  
  protected final int getLayoutId()
  {
    return a.f.bindmcontact_status;
  }
  
  protected final void initView()
  {
    this.fbt = ((ImageView)findViewById(a.e.bind_m_contact_status_state_icon));
    this.fbM = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state_title));
    this.fbN = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state));
    this.fbO = ((Button)findViewById(a.e.bind_m_contact_status_ok_btn));
    if (l.WP() == l.a.ffT)
    {
      this.fbt.setImageResource(a.h.mobile_binded_icon);
      String str2 = (String)g.DP().Dz().get(6, null);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        str1 = (String)g.DP().Dz().get(4097, null);
      }
      this.fbN.setText(getString(a.i.bind_mcontact_status_bind_ok));
      this.fbM.setText(getString(a.i.bind_mcontact_verify_mobile, new Object[] { str1 }));
    }
    for (;;)
    {
      this.fbO.setOnClickListener(new BindMContactStatusUI.1(this));
      return;
      this.fbt.setImageResource(a.h.mobile_unbind_icon);
      this.fbN.setText(a.i.bind_mcontact_unbind_ok);
      this.fbM.setText(a.i.bind_mcontact_unbind_ok);
      this.fbN.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_title_setting);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI
 * JD-Core Version:    0.7.0.1
 */