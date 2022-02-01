package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI
  extends MMWizardActivity
{
  private Button kEt;
  private ImageView mRU;
  private TextView mSl;
  private TextView mSn;
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_status;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109883);
    this.mRU = ((ImageView)findViewById(a.e.bind_m_contact_status_state_icon));
    this.mSl = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state_title));
    this.mSn = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state));
    this.kEt = ((Button)findViewById(a.e.bind_m_contact_status_ok_btn));
    if (l.byi() == l.a.mWk)
    {
      this.mRU.setImageResource(a.h.mobile_binded_icon);
      String str2 = (String)h.aHG().aHp().b(6, null);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        str1 = (String)h.aHG().aHp().b(4097, null);
      }
      this.mSn.setText(getString(a.i.bind_mcontact_status_bind_ok));
      this.mSl.setText(getString(a.i.bind_mcontact_verify_mobile, new Object[] { str1 }));
    }
    for (;;)
    {
      this.kEt.setOnClickListener(new BindMContactStatusUI.1(this));
      AppMethodBeat.o(109883);
      return;
      this.mRU.setImageResource(a.h.mobile_unbind_icon);
      this.mSn.setText(a.i.bind_mcontact_unbind_ok);
      this.mSl.setText(a.i.bind_mcontact_unbind_ok);
      this.mSn.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109882);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_title_setting);
    initView();
    AppMethodBeat.o(109882);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109884);
    if (paramInt == 4)
    {
      atX(1);
      AppMethodBeat.o(109884);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109884);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI
 * JD-Core Version:    0.7.0.1
 */