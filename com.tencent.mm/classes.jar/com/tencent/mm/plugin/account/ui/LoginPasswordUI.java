package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.normsg.a.c;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginPasswordUI";
  private String fSt;
  private x nex;
  
  public LoginPasswordUI()
  {
    AppMethodBeat.i(169130);
    this.fSt = "";
    this.nex = new x();
    AppMethodBeat.o(169130);
  }
  
  protected final void bzr()
  {
    AppMethodBeat.i(128183);
    super.bzr();
    if ((isFinishing()) || (getWindow() == null))
    {
      Log.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(128183);
      return;
    }
    this.ndj.mUQ = this.ndD.getText().toString();
    if (this.ndj.account.equals(""))
    {
      com.tencent.mm.ui.base.h.p(this, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128183);
      return;
    }
    if (this.ndj.mUQ.equals(""))
    {
      com.tencent.mm.ui.base.h.p(this, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128183);
      return;
    }
    hideVKB();
    this.nex.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215573);
        LoginPasswordUI.b(LoginPasswordUI.this);
        AppMethodBeat.o(215573);
      }
    });
    AppMethodBeat.o(128183);
  }
  
  public void initView()
  {
    AppMethodBeat.i(214437);
    super.initView();
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_errType", 0);
      int j = getIntent().getIntExtra("key_errCode", 0);
      Object localObject = getIntent().getStringExtra("key_errMsg");
      Log.i(TAG, "initView,errType %d,errCode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (a.ei(i, j))
      {
        localObject = com.tencent.mm.h.a.Kb((String)localObject);
        if (localObject != null) {
          ((com.tencent.mm.h.a)localObject).a(this, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
          });
        }
      }
    }
    AppMethodBeat.o(214437);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128182);
    super.onCreate(paramBundle);
    if (this.ned)
    {
      AppMethodBeat.o(128182);
      return;
    }
    this.loginType = 2;
    this.nea.setVisibility(0);
    this.ndE.setVisibility(0);
    this.ndD.setTypeface(Typeface.DEFAULT);
    this.ndD.setTransformationMethod(new PasswordTransformationMethod());
    this.ndD.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128176);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginPasswordUI.this.bzr();
          AppMethodBeat.o(128176);
          return true;
        }
        AppMethodBeat.o(128176);
        return false;
      }
    });
    this.ndD.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128177);
        b localb = new b();
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginPasswordUI.this.bzr();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128177);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(128177);
        return false;
      }
    });
    this.ndD.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128178);
        if (LoginPasswordUI.this.ndD.getText().toString().length() > 0)
        {
          LoginPasswordUI.this.ndE.setEnabled(true);
          AppMethodBeat.o(128178);
          return;
        }
        LoginPasswordUI.this.ndE.setEnabled(false);
        AppMethodBeat.o(128178);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.ndD.getText().toString().length() > 0) {
      this.ndE.setEnabled(true);
    }
    for (;;)
    {
      paramBundle = new boolean[1];
      paramBundle[0] = 0;
      this.ndE.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(221345);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(221345);
            return false;
            paramBundle[0] = true;
            LoginPasswordUI.a(LoginPasswordUI.this, c.aaA(2));
            d.GxJ.av("ce_login_id", "<LoginByID>", LoginPasswordUI.a(LoginPasswordUI.this));
            continue;
            d.GxJ.a("ce_login_id", paramAnonymousMotionEvent);
            d.GxJ.aTm("ce_login_id");
          }
        }
      });
      this.ndE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214280);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginPasswordUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (paramBundle[0] != 0) {
            paramBundle[0] = false;
          }
          for (;;)
          {
            LoginPasswordUI.this.bzr();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(214280);
            return;
            LoginPasswordUI.a(LoginPasswordUI.this, c.aaA(2));
            d.GxJ.av("ce_login_id", "<LoginByID>", LoginPasswordUI.a(LoginPasswordUI.this));
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            d.GxJ.a("ce_login_id", paramAnonymousView);
            d.GxJ.aTm("ce_login_id");
          }
        }
      });
      this.nbl = getIntent().getStringExtra("auth_ticket");
      if (!Util.isNullOrNil(this.nbl))
      {
        this.ndC.setText(Util.nullAsNil(g.bzw()));
        this.ndD.setText(Util.nullAsNil(g.bzx()));
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169128);
            LoginPasswordUI.this.bzr();
            AppMethodBeat.o(169128);
          }
        }, 500L);
      }
      AppMethodBeat.o(128182);
      return;
      this.ndE.setEnabled(false);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169131);
    this.nex.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI
 * JD-Core Version:    0.7.0.1
 */