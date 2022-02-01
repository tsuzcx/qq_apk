package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginPasswordUI";
  private x isp;
  
  public LoginPasswordUI()
  {
    AppMethodBeat.i(169130);
    this.isp = new x();
    AppMethodBeat.o(169130);
  }
  
  protected final void aJQ()
  {
    AppMethodBeat.i(128183);
    super.aJQ();
    if ((isFinishing()) || (getWindow() == null))
    {
      ad.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128183);
      return;
    }
    this.ird.ije = this.irx.getText().toString();
    if (this.ird.account.equals(""))
    {
      h.j(this, 2131764665, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    if (this.ird.ije.equals(""))
    {
      h.j(this, 2131764658, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    hideVKB();
    this.isp.b(this, new Runnable()
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
    if (this.irW)
    {
      AppMethodBeat.o(128182);
      return;
    }
    this.imi = 2;
    this.irT.setVisibility(0);
    this.iry.setVisibility(0);
    this.irx.setTypeface(Typeface.DEFAULT);
    this.irx.setTransformationMethod(new PasswordTransformationMethod());
    this.irx.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128176);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginPasswordUI.this.aJQ();
          AppMethodBeat.o(128176);
          return true;
        }
        AppMethodBeat.o(128176);
        return false;
      }
    });
    this.irx.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128177);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginPasswordUI.this.aJQ();
          AppMethodBeat.o(128177);
          return true;
        }
        AppMethodBeat.o(128177);
        return false;
      }
    });
    this.irx.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128178);
        if (LoginPasswordUI.this.irx.getText().toString().length() > 0)
        {
          LoginPasswordUI.this.iry.setEnabled(true);
          AppMethodBeat.o(128178);
          return;
        }
        LoginPasswordUI.this.iry.setEnabled(false);
        AppMethodBeat.o(128178);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.irx.getText().toString().length() > 0) {
      this.iry.setEnabled(true);
    }
    for (;;)
    {
      this.iry.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128179);
          LoginPasswordUI.this.aJQ();
          AppMethodBeat.o(128179);
        }
      });
      this.ipj = getIntent().getStringExtra("auth_ticket");
      if (!bt.isNullOrNil(this.ipj))
      {
        this.irw.setText(bt.nullAsNil(f.aJV()));
        this.irx.setText(bt.nullAsNil(f.aJW()));
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128180);
            LoginPasswordUI.this.aJQ();
            AppMethodBeat.o(128180);
          }
        }, 500L);
      }
      AppMethodBeat.o(128182);
      return;
      this.iry.setEnabled(false);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169131);
    this.isp.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI
 * JD-Core Version:    0.7.0.1
 */