package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.KOptionPicker;
import com.tencent.kinda.gen.Option;
import com.tencent.kinda.gen.VoidBoolOptionCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

public class MMKOptionsPicker
  implements KOptionPicker
{
  private b optionPicker;
  
  public void hide()
  {
    AppMethodBeat.i(144938);
    if (this.optionPicker != null) {
      this.optionPicker.hide();
    }
    AppMethodBeat.o(144938);
  }
  
  public void showImpl(ArrayList<Option> paramArrayList, VoidBoolOptionCallback paramVoidBoolOptionCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKOptionsPicker
 * JD-Core Version:    0.7.0.1
 */