package com.tencent.mm.plugin.label.ui;

import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k;

final class ContactLabelUI$13
  implements Runnable
{
  ContactLabelUI$13(ContactLabelUI paramContactLabelUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(232085);
    ContactLabelUI.g(this.EeV).nlz.performClick();
    ContactLabelUI.g(this.EeV).nlz.requestFocus();
    ContactLabelUI.g(this.EeV).nlz.setSelection(ContactLabelUI.g(this.EeV).nlz.getText().length());
    ((InputMethodManager)this.EeV.getContext().getSystemService("input_method")).showSoftInput(ContactLabelUI.g(this.EeV).nlz, 0);
    AppMethodBeat.o(232085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.13
 * JD-Core Version:    0.7.0.1
 */