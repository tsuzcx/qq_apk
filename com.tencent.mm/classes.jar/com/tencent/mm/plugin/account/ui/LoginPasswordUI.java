package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.normsg.a.c;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.k;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG = "MicroMsg.LoginPasswordUI";
  private String hYq;
  private com.tencent.mm.platformtools.u qbk;
  
  public LoginPasswordUI()
  {
    AppMethodBeat.i(169130);
    this.hYq = "";
    this.qbk = new com.tencent.mm.platformtools.u();
    AppMethodBeat.o(169130);
  }
  
  protected final void bXX()
  {
    AppMethodBeat.i(128183);
    super.bXX();
    if ((isFinishing()) || (getWindow() == null))
    {
      Log.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128183);
      return;
    }
    this.pZh.pRx = this.qaR.getText().toString();
    if (this.pZh.account.equals(""))
    {
      k.s(this, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128183);
      return;
    }
    if (this.pZh.pRx.equals(""))
    {
      k.s(this, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128183);
      return;
    }
    hideVKB();
    this.qbk.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305042);
        LoginPasswordUI.b(LoginPasswordUI.this);
        AppMethodBeat.o(305042);
      }
    });
    AppMethodBeat.o(128183);
  }
  
  public void initView()
  {
    AppMethodBeat.i(304909);
    super.initView();
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_errType", 0);
      int j = getIntent().getIntExtra("key_errCode", 0);
      Object localObject = getIntent().getStringExtra("key_errMsg");
      Log.i(TAG, "initView,errType %d,errCode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (a.fc(i, j))
      {
        localObject = com.tencent.mm.broadcast.a.CH((String)localObject);
        if (localObject != null) {
          ((com.tencent.mm.broadcast.a)localObject).a(this, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
          });
        }
      }
    }
    AppMethodBeat.o(304909);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128182);
    super.onCreate(paramBundle);
    if (this.pZu)
    {
      AppMethodBeat.o(128182);
      return;
    }
    this.loginType = 2;
    this.qaX.setVisibility(0);
    this.qaS.setVisibility(0);
    this.qaR.setTypeface(Typeface.DEFAULT);
    this.qaR.setTransformationMethod(new PasswordTransformationMethod());
    this.qaR.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128176);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginPasswordUI.this.bXX();
          AppMethodBeat.o(128176);
          return true;
        }
        AppMethodBeat.o(128176);
        return false;
      }
    });
    this.qaR.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128177);
        b localb = new b();
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginPasswordUI.this.bXX();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128177);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(128177);
        return false;
      }
    });
    this.qaR.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128178);
        if (LoginPasswordUI.this.qaR.getText().toString().length() > 0) {
          LoginPasswordUI.this.qaS.setEnabled(true);
        }
        AppMethodBeat.o(128178);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.qaR.getText().toString().length() > 0) {
      this.qaS.setEnabled(true);
    }
    paramBundle = new boolean[1];
    paramBundle[0] = 0;
    this.qaS.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(305076);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(305076);
          return false;
          paramBundle[0] = true;
          LoginPasswordUI.a(LoginPasswordUI.this, c.aeT(2));
          d.MtP.aJ("ce_login_id", "<LoginByID>", LoginPasswordUI.a(LoginPasswordUI.this));
          continue;
          d.MtP.a("ce_login_id", paramAnonymousMotionEvent);
          d.MtP.aQm("ce_login_id");
        }
      }
    });
    this.qaS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305049);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginPasswordUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramBundle[0] != 0) {
          paramBundle[0] = false;
        }
        for (;;)
        {
          LoginPasswordUI.this.bXX();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305049);
          return;
          LoginPasswordUI.a(LoginPasswordUI.this, c.aeT(2));
          d.MtP.aJ("ce_login_id", "<LoginByID>", LoginPasswordUI.a(LoginPasswordUI.this));
          paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
          d.MtP.a("ce_login_id", paramAnonymousView);
          d.MtP.aQm("ce_login_id");
        }
      }
    });
    this.pYt = getIntent().getStringExtra("auth_ticket");
    if (!Util.isNullOrNil(this.pYt))
    {
      this.pZa.setText(Util.nullAsNil(f.bYd()));
      this.qaR.setText(Util.nullAsNil(f.bYe()));
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(169128);
          LoginPasswordUI.this.bXX();
          AppMethodBeat.o(169128);
        }
      }, 500L);
    }
    AppMethodBeat.o(128182);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169131);
    this.qbk.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI
 * JD-Core Version:    0.7.0.1
 */