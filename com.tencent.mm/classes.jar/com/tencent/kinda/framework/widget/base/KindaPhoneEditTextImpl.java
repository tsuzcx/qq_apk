package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KPhoneEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.formview.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaPhoneEditTextImpl
  extends MMKEditText
  implements KPhoneEditText
{
  private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(144772);
    LinearLayout localLinearLayout = super.createView(paramContext);
    if ((paramContext instanceof BaseFrActivity)) {
      ((BaseFrActivity)paramContext).setEditFocusListener(this.editText, 0, false);
    }
    AppMethodBeat.o(144772);
    return localLinearLayout;
  }
  
  public ClearButtonMode getClearButtonMode()
  {
    return this.clearButtonMode;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144776);
    boolean bool = this.editText.isFocused();
    AppMethodBeat.o(144776);
    return bool;
  }
  
  public String getText()
  {
    AppMethodBeat.i(144774);
    ab.d("base_MMKView", "KindaPhoneEditTextImpl getText ");
    Object localObject = this.editText.getText();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(144774);
      return localObject;
    }
    AppMethodBeat.o(144774);
    return null;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144775);
    if (paramBoolean)
    {
      this.editText.requestFocus();
      AppMethodBeat.o(144775);
      return;
    }
    this.editText.clearFocus();
    AppMethodBeat.o(144775);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(144773);
    ab.d("base_MMKView", "KindaPhoneEditTextImpl setText ".concat(String.valueOf(paramString)));
    if (paramString != null) {
      this.editText.setText(paramString);
    }
    AppMethodBeat.o(144773);
  }
  
  public void showTip(String paramString)
  {
    AppMethodBeat.i(144777);
    b.a(this.mBaseFrActivity, 2130971233, 2131304963);
    AppMethodBeat.o(144777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPhoneEditTextImpl
 * JD-Core Version:    0.7.0.1
 */