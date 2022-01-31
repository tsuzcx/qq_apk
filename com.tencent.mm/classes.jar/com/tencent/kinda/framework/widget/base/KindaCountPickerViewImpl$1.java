package com.tencent.kinda.framework.widget.base;

import android.widget.EditText;
import com.tencent.kinda.gen.KCountPickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class KindaCountPickerViewImpl$1
  implements b.a
{
  KindaCountPickerViewImpl$1(KindaCountPickerViewImpl paramKindaCountPickerViewImpl, b paramb) {}
  
  public void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(144759);
    if (paramBoolean)
    {
      KindaCountPickerViewImpl.access$002(this.this$0, this.val$optionPicker.dPp());
      KindaCountPickerViewImpl.access$100(this.this$0).setText(paramObject1.toString());
      KindaCountPickerViewImpl.access$200(this.this$0).onSelect(String.valueOf(KindaCountPickerViewImpl.access$000(this.this$0)));
    }
    this.val$optionPicker.hide();
    AppMethodBeat.o(144759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCountPickerViewImpl.1
 * JD-Core Version:    0.7.0.1
 */