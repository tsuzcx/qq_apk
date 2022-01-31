package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddUI$onCreate$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-appbrand-integration_release"})
public final class PhoneNumberAddUI$c
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(134818);
    paramCharSequence = this.iDB.iDz;
    if (paramCharSequence != null)
    {
      Object localObject = this.iDB.iDw;
      if (localObject != null)
      {
        localObject = ((MMFormVerifyCodeInputView)localObject).getText();
        if ((localObject != null) && (((Editable)localObject).length() == 0)) {}
      }
      else
      {
        localObject = this.iDB.iDx;
        if (localObject != null)
        {
          localObject = ((MMFormInputView)localObject).getText();
          if ((localObject != null) && (((Editable)localObject).length() == 0)) {
            break label104;
          }
        }
      }
      label104:
      for (boolean bool = true;; bool = false)
      {
        paramCharSequence.setEnabled(bool);
        AppMethodBeat.o(134818);
        return;
      }
    }
    AppMethodBeat.o(134818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.c
 * JD-Core Version:    0.7.0.1
 */