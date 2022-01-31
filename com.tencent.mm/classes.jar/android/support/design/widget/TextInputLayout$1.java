package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

final class TextInputLayout$1
  implements TextWatcher
{
  TextInputLayout$1(TextInputLayout paramTextInputLayout) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    TextInputLayout localTextInputLayout = this.lY;
    if (!TextInputLayout.a(this.lY)) {}
    for (boolean bool = true;; bool = false)
    {
      localTextInputLayout.d(bool, false);
      if (this.lY.lA) {
        this.lY.S(paramEditable.length());
      }
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout.1
 * JD-Core Version:    0.7.0.1
 */