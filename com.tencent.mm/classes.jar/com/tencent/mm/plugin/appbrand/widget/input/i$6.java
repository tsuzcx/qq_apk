package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class i$6
  implements w.d
{
  i$6(i parami) {}
  
  public final boolean FO(String paramString)
  {
    AppMethodBeat.i(141606);
    if (this.jlw.jll != null)
    {
      if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramString)) {
        break label119;
      }
      paramString = this.jlw.jll;
      if (paramString.jmV == null) {
        break label86;
      }
      if (!bo.aa(paramString.getEditableText())) {
        paramString.jmV.deleteSurroundingText(paramString.getEditableText().length(), paramString.getEditableText().length() - 1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(141606);
      return true;
      label86:
      paramString.dispatchKeyEvent(new KeyEvent(0, 67));
      paramString.dispatchKeyEvent(new KeyEvent(1, 67));
    }
    label119:
    y localy = this.jlw.jll;
    f.aQD();
    if (localy.getEditableText() == null) {
      localy.setText(paramString, TextView.BufferType.EDITABLE);
    }
    for (;;)
    {
      localy.setSelection(localy.getEditableText().length());
      break;
      localy.getEditableText().append(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.6
 * JD-Core Version:    0.7.0.1
 */