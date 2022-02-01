package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginSmsUI";
  private x iSu;
  
  public LoginSmsUI()
  {
    AppMethodBeat.i(169135);
    this.iSu = new x();
    AppMethodBeat.o(169135);
  }
  
  protected final void aQH()
  {
    AppMethodBeat.i(128197);
    super.aQH();
    if ((isFinishing()) || (getWindow() == null))
    {
      ac.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128197);
      return;
    }
    if (!bs.isNullOrNil(this.iRN))
    {
      this.iRj.account = this.iRN;
      hideVKB();
      this.iSu.b(this, new Runnable()
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
    if (this.iSb)
    {
      AppMethodBeat.o(128196);
      return;
    }
    this.iMo = 3;
    if ((!bs.aLH(this.iRS).booleanValue()) && (bs.aLH(this.iRN).booleanValue())) {
      this.iRB.setText(GG(this.iRN));
    }
    this.iRZ.setVisibility(0);
    this.iRZ.setInputType(3);
    this.iRZ.setSendSmsBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128191);
        LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.iRN);
        AppMethodBeat.o(128191);
      }
    });
    this.iRZ.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128192);
        if (LoginSmsUI.this.iRZ.getText().toString().length() > 0)
        {
          LoginSmsUI.this.iRD.setEnabled(true);
          AppMethodBeat.o(128192);
          return;
        }
        LoginSmsUI.this.iRD.setEnabled(false);
        AppMethodBeat.o(128192);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.iRZ.getText().toString().length() > 0) {
      this.iRD.setEnabled(true);
    }
    for (;;)
    {
      this.iRD.setVisibility(0);
      this.iRD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128193);
          LoginSmsUI.this.aQH();
          AppMethodBeat.o(128193);
        }
      });
      AppMethodBeat.o(128196);
      return;
      this.iRD.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128200);
    super.onDestroy();
    this.iRZ.reset();
    AppMethodBeat.o(128200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128198);
    super.onResume();
    g.agi().a(145, this);
    AppMethodBeat.o(128198);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128199);
    super.onStop();
    g.agi().b(145, this);
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