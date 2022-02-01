package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginPasswordUI";
  private x iSu;
  
  public LoginPasswordUI()
  {
    AppMethodBeat.i(169130);
    this.iSu = new x();
    AppMethodBeat.o(169130);
  }
  
  protected final void aQH()
  {
    AppMethodBeat.i(128183);
    super.aQH();
    if ((isFinishing()) || (getWindow() == null))
    {
      ac.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128183);
      return;
    }
    this.iRj.iJl = this.iRC.getText().toString();
    if (this.iRj.account.equals(""))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    if (this.iRj.iJl.equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    hideVKB();
    this.iSu.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169128);
        LoginPasswordUI.a(LoginPasswordUI.this);
        AppMethodBeat.o(169128);
      }
    });
    AppMethodBeat.o(128183);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128182);
    super.onCreate(paramBundle);
    if (this.iSb)
    {
      AppMethodBeat.o(128182);
      return;
    }
    this.iMo = 2;
    this.iRY.setVisibility(0);
    this.iRD.setVisibility(0);
    this.iRC.setTypeface(Typeface.DEFAULT);
    this.iRC.setTransformationMethod(new PasswordTransformationMethod());
    this.iRC.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128176);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginPasswordUI.this.aQH();
          AppMethodBeat.o(128176);
          return true;
        }
        AppMethodBeat.o(128176);
        return false;
      }
    });
    this.iRC.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128177);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginPasswordUI.this.aQH();
          AppMethodBeat.o(128177);
          return true;
        }
        AppMethodBeat.o(128177);
        return false;
      }
    });
    this.iRC.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128178);
        if (LoginPasswordUI.this.iRC.getText().toString().length() > 0)
        {
          LoginPasswordUI.this.iRD.setEnabled(true);
          AppMethodBeat.o(128178);
          return;
        }
        LoginPasswordUI.this.iRD.setEnabled(false);
        AppMethodBeat.o(128178);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.iRC.getText().toString().length() > 0) {
      this.iRD.setEnabled(true);
    }
    for (;;)
    {
      this.iRD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128179);
          LoginPasswordUI.this.aQH();
          AppMethodBeat.o(128179);
        }
      });
      this.iPp = getIntent().getStringExtra("auth_ticket");
      if (!bs.isNullOrNil(this.iPp))
      {
        this.iRB.setText(bs.nullAsNil(f.aQM()));
        this.iRC.setText(bs.nullAsNil(f.aQN()));
        new ao().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128180);
            LoginPasswordUI.this.aQH();
            AppMethodBeat.o(128180);
          }
        }, 500L);
      }
      AppMethodBeat.o(128182);
      return;
      this.iRD.setEnabled(false);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169131);
    this.iSu.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI
 * JD-Core Version:    0.7.0.1
 */