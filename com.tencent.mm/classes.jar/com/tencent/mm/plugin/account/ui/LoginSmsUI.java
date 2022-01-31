package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginSmsUI";
  
  protected final void arq()
  {
    AppMethodBeat.i(125021);
    super.arq();
    if ((isFinishing()) || (getWindow() == null))
    {
      ab.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(125021);
      return;
    }
    if (!bo.isNullOrNil(this.gDW))
    {
      this.gDU.account = this.gDW;
      hideVKB();
      arr();
      final a locala = new a(this.gDW, 17, this.gEj.getText().toString().trim(), 0, "");
      g.Rc().a(locala, 0);
      getString(2131297087);
      this.eeN = h.b(this, getString(2131301149), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(125019);
          g.Rc().a(locala);
          AppMethodBeat.o(125019);
        }
      });
    }
    AppMethodBeat.o(125021);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125020);
    super.onCreate(paramBundle);
    if (this.gEm)
    {
      AppMethodBeat.o(125020);
      return;
    }
    this.gyZ = 3;
    if ((!bo.aqe(this.gEc).booleanValue()) && (bo.aqe(this.gDW).booleanValue())) {
      this.gDJ.setText(xw(this.gDW));
    }
    this.gEj.setVisibility(0);
    this.gEj.setInputType(3);
    this.gEj.setSendSmsBtnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125015);
        h.a(LoginSmsUI.this, LoginSmsUI.this.getString(2131302462) + LoginSmsUI.this.gDW, LoginSmsUI.this.getString(2131302463), LoginSmsUI.this.getString(2131297018), LoginSmsUI.this.getString(2131296888), false, new LoginSmsUI.1.1(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(125014);
            LoginSmsUI.this.gEj.reset();
            AppMethodBeat.o(125014);
          }
        });
        AppMethodBeat.o(125015);
      }
    });
    this.gEj.addTextChangedListener(new LoginSmsUI.2(this));
    if (this.gEj.getText().toString().length() > 0) {
      this.gDL.setEnabled(true);
    }
    for (;;)
    {
      this.gDL.setVisibility(0);
      this.gDL.setOnClickListener(new LoginSmsUI.3(this));
      AppMethodBeat.o(125020);
      return;
      this.gDL.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125024);
    super.onDestroy();
    this.gEj.reset();
    AppMethodBeat.o(125024);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125022);
    super.onResume();
    g.Rc().a(145, this);
    AppMethodBeat.o(125022);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(125023);
    super.onStop();
    g.Rc().b(145, this);
    AppMethodBeat.o(125023);
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