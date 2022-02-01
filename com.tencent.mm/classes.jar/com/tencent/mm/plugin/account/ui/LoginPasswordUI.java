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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginPasswordUI";
  private x jow;
  
  public LoginPasswordUI()
  {
    AppMethodBeat.i(169130);
    this.jow = new x();
    AppMethodBeat.o(169130);
  }
  
  protected final void aUs()
  {
    AppMethodBeat.i(128183);
    super.aUs();
    if ((isFinishing()) || (getWindow() == null))
    {
      ae.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128183);
      return;
    }
    this.jnl.jfn = this.jnE.getText().toString();
    if (this.jnl.account.equals(""))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    if (this.jnl.jfn.equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    hideVKB();
    this.jow.b(this, new Runnable()
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
    if (this.jod)
    {
      AppMethodBeat.o(128182);
      return;
    }
    this.jir = 2;
    this.joa.setVisibility(0);
    this.jnF.setVisibility(0);
    this.jnE.setTypeface(Typeface.DEFAULT);
    this.jnE.setTransformationMethod(new PasswordTransformationMethod());
    this.jnE.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128176);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginPasswordUI.this.aUs();
          AppMethodBeat.o(128176);
          return true;
        }
        AppMethodBeat.o(128176);
        return false;
      }
    });
    this.jnE.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128177);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginPasswordUI.this.aUs();
          a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128177);
          return true;
        }
        a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(128177);
        return false;
      }
    });
    this.jnE.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128178);
        if (LoginPasswordUI.this.jnE.getText().toString().length() > 0)
        {
          LoginPasswordUI.this.jnF.setEnabled(true);
          AppMethodBeat.o(128178);
          return;
        }
        LoginPasswordUI.this.jnF.setEnabled(false);
        AppMethodBeat.o(128178);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.jnE.getText().toString().length() > 0) {
      this.jnF.setEnabled(true);
    }
    for (;;)
    {
      this.jnF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128179);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/account/ui/LoginPasswordUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          LoginPasswordUI.this.aUs();
          a.a(this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128179);
        }
      });
      this.jlr = getIntent().getStringExtra("auth_ticket");
      if (!bu.isNullOrNil(this.jlr))
      {
        this.jnD.setText(bu.nullAsNil(f.aUx()));
        this.jnE.setText(bu.nullAsNil(f.aUy()));
        new aq().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128180);
            LoginPasswordUI.this.aUs();
            AppMethodBeat.o(128180);
          }
        }, 500L);
      }
      AppMethodBeat.o(128182);
      return;
      this.jnF.setEnabled(false);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169131);
    this.jow.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI
 * JD-Core Version:    0.7.0.1
 */