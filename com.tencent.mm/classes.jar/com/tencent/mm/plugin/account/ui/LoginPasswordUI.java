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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
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
  private x jlC;
  
  public LoginPasswordUI()
  {
    AppMethodBeat.i(169130);
    this.jlC = new x();
    AppMethodBeat.o(169130);
  }
  
  protected final void aTT()
  {
    AppMethodBeat.i(128183);
    super.aTT();
    if ((isFinishing()) || (getWindow() == null))
    {
      ad.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128183);
      return;
    }
    this.jkr.jcu = this.jkK.getText().toString();
    if (this.jkr.account.equals(""))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    if (this.jkr.jcu.equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128183);
      return;
    }
    hideVKB();
    this.jlC.b(this, new Runnable()
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
    if (this.jlj)
    {
      AppMethodBeat.o(128182);
      return;
    }
    this.jfy = 2;
    this.jlg.setVisibility(0);
    this.jkL.setVisibility(0);
    this.jkK.setTypeface(Typeface.DEFAULT);
    this.jkK.setTransformationMethod(new PasswordTransformationMethod());
    this.jkK.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128176);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginPasswordUI.this.aTT();
          AppMethodBeat.o(128176);
          return true;
        }
        AppMethodBeat.o(128176);
        return false;
      }
    });
    this.jkK.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128177);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginPasswordUI.this.aTT();
          a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128177);
          return true;
        }
        a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(128177);
        return false;
      }
    });
    this.jkK.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128178);
        if (LoginPasswordUI.this.jkK.getText().toString().length() > 0)
        {
          LoginPasswordUI.this.jkL.setEnabled(true);
          AppMethodBeat.o(128178);
          return;
        }
        LoginPasswordUI.this.jkL.setEnabled(false);
        AppMethodBeat.o(128178);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.jkK.getText().toString().length() > 0) {
      this.jkL.setEnabled(true);
    }
    for (;;)
    {
      this.jkL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128179);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/account/ui/LoginPasswordUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          LoginPasswordUI.this.aTT();
          a.a(this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128179);
        }
      });
      this.jiy = getIntent().getStringExtra("auth_ticket");
      if (!bt.isNullOrNil(this.jiy))
      {
        this.jkJ.setText(bt.nullAsNil(f.aTY()));
        this.jkK.setText(bt.nullAsNil(f.aTZ()));
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128180);
            LoginPasswordUI.this.aTT();
            AppMethodBeat.o(128180);
          }
        }, 500L);
      }
      AppMethodBeat.o(128182);
      return;
      this.jkL.setEnabled(false);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169131);
    this.jlC.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
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