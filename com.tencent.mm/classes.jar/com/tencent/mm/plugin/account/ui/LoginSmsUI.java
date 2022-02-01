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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginSmsUI";
  private x isp;
  
  public LoginSmsUI()
  {
    AppMethodBeat.i(169135);
    this.isp = new x();
    AppMethodBeat.o(169135);
  }
  
  protected final void aJQ()
  {
    AppMethodBeat.i(128197);
    super.aJQ();
    if ((isFinishing()) || (getWindow() == null))
    {
      ad.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128197);
      return;
    }
    if (!bt.isNullOrNil(this.irI))
    {
      this.ird.account = this.irI;
      hideVKB();
      this.isp.b(this, new Runnable()
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
    if (this.irW)
    {
      AppMethodBeat.o(128196);
      return;
    }
    this.imi = 3;
    if ((!bt.aGq(this.irN).booleanValue()) && (bt.aGq(this.irI).booleanValue())) {
      this.irw.setText(CD(this.irI));
    }
    this.irU.setVisibility(0);
    this.irU.setInputType(3);
    this.irU.setSendSmsBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128191);
        LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.irI);
        AppMethodBeat.o(128191);
      }
    });
    this.irU.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128192);
        if (LoginSmsUI.this.irU.getText().toString().length() > 0)
        {
          LoginSmsUI.this.iry.setEnabled(true);
          AppMethodBeat.o(128192);
          return;
        }
        LoginSmsUI.this.iry.setEnabled(false);
        AppMethodBeat.o(128192);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.irU.getText().toString().length() > 0) {
      this.iry.setEnabled(true);
    }
    for (;;)
    {
      this.iry.setVisibility(0);
      this.iry.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128193);
          LoginSmsUI.this.aJQ();
          AppMethodBeat.o(128193);
        }
      });
      AppMethodBeat.o(128196);
      return;
      this.iry.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128200);
    super.onDestroy();
    this.irU.reset();
    AppMethodBeat.o(128200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128198);
    super.onResume();
    g.aeS().a(145, this);
    AppMethodBeat.o(128198);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128199);
    super.onStop();
    g.aeS().b(145, this);
    AppMethodBeat.o(128199);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI
 * JD-Core Version:    0.7.0.1
 */