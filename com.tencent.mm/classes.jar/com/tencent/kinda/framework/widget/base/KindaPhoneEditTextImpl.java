package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.KPhoneEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.formview.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaPhoneEditTextImpl
  extends MMKEditText
  implements KPhoneEditText
{
  private ClearButtonMode clearButtonMode = ClearButtonMode.WHILEEDITING;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(18915);
    LinearLayout localLinearLayout = super.createView(paramContext);
    if ((paramContext instanceof BaseFrActivity))
    {
      setMaxLength(11);
      ((BaseFrActivity)paramContext).setEditFocusListener(this.editText, 0, false);
    }
    paramContext = this.editText.getLayoutParams();
    paramContext.height = -2;
    this.editText.setLayoutParams(paramContext);
    AppMethodBeat.o(18915);
    return localLinearLayout;
  }
  
  public ClearButtonMode getClearButtonMode()
  {
    return this.clearButtonMode;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18919);
    boolean bool = this.editText.isFocused();
    AppMethodBeat.o(18919);
    return bool;
  }
  
  public String getText()
  {
    AppMethodBeat.i(18917);
    ae.d("base_MMKView", "KindaPhoneEditTextImpl getText ");
    Object localObject = this.editText.getText();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(18917);
      return localObject;
    }
    AppMethodBeat.o(18917);
    return null;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18918);
    if (paramBoolean)
    {
      this.editText.requestFocus();
      AppMethodBeat.o(18918);
      return;
    }
    this.editText.clearFocus();
    AppMethodBeat.o(18918);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(18916);
    ae.d("base_MMKView", "KindaPhoneEditTextImpl setText ".concat(String.valueOf(paramString)));
    if ((paramString != null) && (!getText().equals(paramString)))
    {
      this.editText.setText(paramString);
      if (paramString.contains("+")) {
        this.editText.setSelection(paramString.length());
      }
    }
    AppMethodBeat.o(18916);
  }
  
  public void showTip(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18920);
    b.e(this.mBaseFrActivity, paramString2);
    AppMethodBeat.o(18920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPhoneEditTextImpl
 * JD-Core Version:    0.7.0.1
 */