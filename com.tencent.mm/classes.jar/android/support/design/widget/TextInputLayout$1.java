package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

final class TextInputLayout$1
  implements TextWatcher
{
  TextInputLayout$1(TextInputLayout paramTextInputLayout) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    TextInputLayout localTextInputLayout = this.mT;
    if (!TextInputLayout.a(this.mT)) {}
    for (boolean bool = true;; bool = false)
    {
      localTextInputLayout.d(bool, false);
      if (this.mT.mv) {
        this.mT.Q(paramEditable.length());
      }
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout.1
 * JD-Core Version:    0.7.0.1
 */