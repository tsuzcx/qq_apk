package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.KPwdInputView;
import com.tencent.kinda.gen.KPwdInputViewOnEndEnterPasswordCallback;
import com.tencent.kinda.gen.KPwdInputViewOnPasswordChangeCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class KindaPwdInputViewImpl
  extends MMKView<EditHintPasswdView>
  implements KPwdInputView
{
  private KPwdInputViewOnPasswordChangeCallback pwdChangeCallback;
  private KPwdInputViewOnEndEnterPasswordCallback pwdEndCallback;
  private EditHintPasswdView pwdView;
  
  public EditHintPasswdView createView(Context paramContext)
  {
    AppMethodBeat.i(144790);
    this.pwdView = new EditHintPasswdView(paramContext);
    a.a(this.pwdView);
    this.pwdView.setBackgroundResource(2130838582);
    if ((paramContext instanceof BaseFrActivity)) {
      ((BaseFrActivity)paramContext).setEditFocusListener(this.pwdView, 0, false);
    }
    this.pwdView.setOnInputValidListener(new KindaPwdInputViewImpl.1(this));
    paramContext = this.pwdView;
    AppMethodBeat.o(144790);
    return paramContext;
  }
  
  public boolean getAutoRemarkKeyBoradType()
  {
    return false;
  }
  
  public boolean getChearInput()
  {
    return false;
  }
  
  public boolean getFocus()
  {
    return false;
  }
  
  public String getHashData()
  {
    return null;
  }
  
  public long getTextLength()
  {
    return 0L;
  }
  
  public void setAutoRemarkKeyBoradType(boolean paramBoolean) {}
  
  public void setChearInput(boolean paramBoolean)
  {
    AppMethodBeat.i(144792);
    if (paramBoolean) {
      this.pwdView.cfK();
    }
    AppMethodBeat.o(144792);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144791);
    if ((paramBoolean) && (this.pwdView.getVisibility() == 0) && (!this.pwdView.hasFocus())) {
      al.d(new KindaPwdInputViewImpl.2(this));
    }
    AppMethodBeat.o(144791);
  }
  
  public void setHashData(String paramString) {}
  
  public void setOnEndEnterPasswordCallback(KPwdInputViewOnEndEnterPasswordCallback paramKPwdInputViewOnEndEnterPasswordCallback)
  {
    if (paramKPwdInputViewOnEndEnterPasswordCallback != null) {
      this.pwdEndCallback = paramKPwdInputViewOnEndEnterPasswordCallback;
    }
  }
  
  public void setOnPasswordChangeCallback(KPwdInputViewOnPasswordChangeCallback paramKPwdInputViewOnPasswordChangeCallback)
  {
    if (paramKPwdInputViewOnPasswordChangeCallback != null) {
      this.pwdChangeCallback = paramKPwdInputViewOnPasswordChangeCallback;
    }
  }
  
  public void setTextLength(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPwdInputViewImpl
 * JD-Core Version:    0.7.0.1
 */