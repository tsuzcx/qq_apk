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
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginSmsUI";
  private x jlC;
  
  public LoginSmsUI()
  {
    AppMethodBeat.i(169135);
    this.jlC = new x();
    AppMethodBeat.o(169135);
  }
  
  protected final void aTT()
  {
    AppMethodBeat.i(128197);
    super.aTT();
    if ((isFinishing()) || (getWindow() == null))
    {
      ad.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128197);
      return;
    }
    if (!bt.isNullOrNil(this.jkV))
    {
      this.jkr.account = this.jkV;
      hideVKB();
      this.jlC.b(this, new Runnable()
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
    if (this.jlj)
    {
      AppMethodBeat.o(128196);
      return;
    }
    this.jfy = 3;
    if ((!bt.aRn(this.jla).booleanValue()) && (bt.aRn(this.jkV).booleanValue())) {
      this.jkJ.setText(JV(this.jkV));
    }
    this.jlh.setVisibility(0);
    this.jlh.setInputType(3);
    this.jlh.setSendSmsBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128191);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.jkV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128191);
      }
    });
    this.jlh.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128192);
        if (LoginSmsUI.this.jlh.getText().toString().length() > 0)
        {
          LoginSmsUI.this.jkL.setEnabled(true);
          AppMethodBeat.o(128192);
          return;
        }
        LoginSmsUI.this.jkL.setEnabled(false);
        AppMethodBeat.o(128192);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.jlh.getText().toString().length() > 0) {
      this.jkL.setEnabled(true);
    }
    for (;;)
    {
      this.jkL.setVisibility(0);
      this.jkL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128193);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          LoginSmsUI.this.aTT();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128193);
        }
      });
      AppMethodBeat.o(128196);
      return;
      this.jkL.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128200);
    super.onDestroy();
    this.jlh.reset();
    AppMethodBeat.o(128200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128198);
    super.onResume();
    g.aiU().a(145, this);
    AppMethodBeat.o(128198);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128199);
    super.onStop();
    g.aiU().b(145, this);
    AppMethodBeat.o(128199);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI
 * JD-Core Version:    0.7.0.1
 */