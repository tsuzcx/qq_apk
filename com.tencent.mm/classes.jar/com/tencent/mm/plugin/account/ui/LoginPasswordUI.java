package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginPasswordUI";
  
  protected final void arq()
  {
    AppMethodBeat.i(125005);
    super.arq();
    if ((isFinishing()) || (getWindow() == null))
    {
      ab.e(TAG, "LoginHistoryUI is finishing");
      AppMethodBeat.o(125005);
      return;
    }
    this.gDU.gwh = this.gDK.getText().toString();
    if (this.gDU.account.equals(""))
    {
      h.h(this, 2131304504, 2131301135);
      AppMethodBeat.o(125005);
      return;
    }
    if (this.gDU.gwh.equals(""))
    {
      h.h(this, 2131304500, 2131301135);
      AppMethodBeat.o(125005);
      return;
    }
    hideVKB();
    arr();
    s locals = new s(this.gDU.account, this.gDU.gwh, this.gBP, 0);
    g.Rc().a(locals, 0);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131301149), true, new LoginPasswordUI.6(this, locals));
    AppMethodBeat.o(125005);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125004);
    super.onCreate(paramBundle);
    if (this.gEm)
    {
      AppMethodBeat.o(125004);
      return;
    }
    this.gyZ = 2;
    this.gEi.setVisibility(0);
    this.gDL.setVisibility(0);
    this.gDK.setTypeface(Typeface.DEFAULT);
    this.gDK.setTransformationMethod(new PasswordTransformationMethod());
    this.gDK.setOnEditorActionListener(new LoginPasswordUI.1(this));
    this.gDK.setOnKeyListener(new LoginPasswordUI.2(this));
    this.gDK.addTextChangedListener(new LoginPasswordUI.3(this));
    if (this.gDK.getText().toString().length() > 0) {
      this.gDL.setEnabled(true);
    }
    for (;;)
    {
      this.gDL.setOnClickListener(new LoginPasswordUI.4(this));
      this.gBP = getIntent().getStringExtra("auth_ticket");
      if (!bo.isNullOrNil(this.gBP))
      {
        this.gDJ.setText(bo.nullAsNil(f.arv()));
        this.gDK.setText(bo.nullAsNil(f.arw()));
        new ak().postDelayed(new LoginPasswordUI.5(this), 500L);
      }
      AppMethodBeat.o(125004);
      return;
      this.gDL.setEnabled(false);
    }
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