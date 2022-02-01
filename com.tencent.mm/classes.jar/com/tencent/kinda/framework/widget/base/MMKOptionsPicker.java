package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.KOptionPicker;
import com.tencent.kinda.gen.Option;
import com.tencent.kinda.gen.VoidBoolOptionCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;

public class MMKOptionsPicker
  implements KOptionPicker
{
  private c optionPicker;
  
  public void hide()
  {
    AppMethodBeat.i(19094);
    if (this.optionPicker != null) {
      this.optionPicker.hide();
    }
    AppMethodBeat.o(19094);
  }
  
  public void showImpl(ArrayList<Option> paramArrayList, VoidBoolOptionCallback paramVoidBoolOptionCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKOptionsPicker
 * JD-Core Version:    0.7.0.1
 */