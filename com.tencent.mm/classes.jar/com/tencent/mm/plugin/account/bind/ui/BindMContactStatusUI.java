package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI
  extends MMWizardActivity
{
  public static String pOU = "intent_back_launcherui";
  private Button nhC;
  private ImageView pOB;
  private TextView pOS;
  private TextView pOT;
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_status;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109883);
    this.pOB = ((ImageView)findViewById(a.e.bind_m_contact_status_state_icon));
    this.pOS = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state_title));
    this.pOT = ((TextView)findViewById(a.e.bind_m_contact_status_bind_state));
    this.nhC = ((Button)findViewById(a.e.bind_m_contact_status_ok_btn));
    if (i.bWW() == i.a.pSQ)
    {
      this.pOB.setImageResource(a.h.mobile_binded_icon);
      String str2 = (String)h.baE().ban().d(6, null);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        str1 = (String)h.baE().ban().d(4097, null);
      }
      this.pOT.setText(getString(a.i.bind_mcontact_status_bind_ok));
      this.pOS.setText(getString(a.i.bind_mcontact_verify_mobile, new Object[] { str1 }));
    }
    for (;;)
    {
      this.nhC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109881);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (BindMContactStatusUI.this.getIntent().getBooleanExtra(BindMContactStatusUI.pOU, false))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.addFlags(67108864);
            com.tencent.mm.plugin.account.sdk.a.pFn.n(paramAnonymousView, BindMContactStatusUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109881);
            return;
          }
          BindMContactStatusUI.a(BindMContactStatusUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109881);
        }
      });
      AppMethodBeat.o(109883);
      return;
      this.pOB.setImageResource(a.h.mobile_unbind_icon);
      this.pOT.setText(a.i.bind_mcontact_unbind_ok);
      this.pOS.setText(a.i.bind_mcontact_unbind_ok);
      this.pOT.setVisibility(8);
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
      if (getIntent().getBooleanExtra(pOU, false))
      {
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.account.sdk.a.pFn.n(paramKeyEvent, this);
        AppMethodBeat.o(109884);
        return true;
      }
      aAp(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI
 * JD-Core Version:    0.7.0.1
 */