package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginSmsUI";
  private x jow;
  
  public LoginSmsUI()
  {
    AppMethodBeat.i(169135);
    this.jow = new x();
    AppMethodBeat.o(169135);
  }
  
  protected final void aUs()
  {
    AppMethodBeat.i(128197);
    super.aUs();
    if ((isFinishing()) || (getWindow() == null))
    {
      ae.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128197);
      return;
    }
    if (!bu.isNullOrNil(this.jnP))
    {
      this.jnl.account = this.jnP;
      hideVKB();
      this.jow.b(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(169133);
          LoginSmsUI.a(LoginSmsUI.this);
          AppMethodBeat.o(169133);
        }
      });
    }
    AppMethodBeat.o(128197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128196);
    super.onCreate(paramBundle);
    if (this.jod)
    {
      AppMethodBeat.o(128196);
      return;
    }
    this.jir = 3;
    if ((!bu.aSK(this.jnU).booleanValue()) && (bu.aSK(this.jnP).booleanValue())) {
      this.jnD.setText(Ku(this.jnP));
    }
    this.job.setVisibility(0);
    this.job.setInputType(3);
    this.job.setSendSmsBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128191);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.jnP);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128191);
      }
    });
    this.job.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128192);
        if (LoginSmsUI.this.job.getText().toString().length() > 0)
        {
          LoginSmsUI.this.jnF.setEnabled(true);
          AppMethodBeat.o(128192);
          return;
        }
        LoginSmsUI.this.jnF.setEnabled(false);
        AppMethodBeat.o(128192);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.job.getText().toString().length() > 0) {
      this.jnF.setEnabled(true);
    }
    for (;;)
    {
      this.jnF.setVisibility(0);
      this.jnF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128193);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          LoginSmsUI.this.aUs();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128193);
        }
      });
      AppMethodBeat.o(128196);
      return;
      this.jnF.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128200);
    super.onDestroy();
    this.job.reset();
    AppMethodBeat.o(128200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128198);
    super.onResume();
    g.ajj().a(145, this);
    AppMethodBeat.o(128198);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128199);
    super.onStop();
    g.ajj().b(145, this);
    AppMethodBeat.o(128199);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI
 * JD-Core Version:    0.7.0.1
 */