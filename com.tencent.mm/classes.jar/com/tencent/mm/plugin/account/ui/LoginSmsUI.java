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
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginSmsUI";
  private x kmF;
  
  public LoginSmsUI()
  {
    AppMethodBeat.i(169135);
    this.kmF = new x();
    AppMethodBeat.o(169135);
  }
  
  protected final void bpf()
  {
    AppMethodBeat.i(128197);
    super.bpf();
    if ((isFinishing()) || (getWindow() == null))
    {
      Log.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128197);
      return;
    }
    if (!Util.isNullOrNil(this.klX))
    {
      this.klt.account = this.klX;
      hideVKB();
      this.kmF.b(this, new Runnable()
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
    if (this.kmm)
    {
      AppMethodBeat.o(128196);
      return;
    }
    this.loginType = 3;
    if ((!Util.isPhoneNumber(this.kmc).booleanValue()) && (Util.isPhoneNumber(this.klX).booleanValue())) {
      this.klL.setText(Ts(this.klX));
    }
    this.kmk.setVisibility(0);
    this.kmk.setInputType(3);
    this.kmk.setSendSmsBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128191);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.klX);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128191);
      }
    });
    this.kmk.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128192);
        if (LoginSmsUI.this.kmk.getText().toString().length() > 0)
        {
          LoginSmsUI.this.klN.setEnabled(true);
          AppMethodBeat.o(128192);
          return;
        }
        LoginSmsUI.this.klN.setEnabled(false);
        AppMethodBeat.o(128192);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.kmk.getText().toString().length() > 0) {
      this.klN.setEnabled(true);
    }
    for (;;)
    {
      this.klN.setVisibility(0);
      this.klN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128193);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          LoginSmsUI.this.bpf();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128193);
        }
      });
      AppMethodBeat.o(128196);
      return;
      this.klN.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128200);
    super.onDestroy();
    this.kmk.reset();
    AppMethodBeat.o(128200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128198);
    super.onResume();
    g.azz().a(145, this);
    AppMethodBeat.o(128198);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128199);
    super.onStop();
    g.azz().b(145, this);
    AppMethodBeat.o(128199);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI
 * JD-Core Version:    0.7.0.1
 */