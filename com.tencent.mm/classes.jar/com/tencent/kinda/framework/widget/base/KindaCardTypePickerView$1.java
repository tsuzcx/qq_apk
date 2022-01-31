package com.tencent.kinda.framework.widget.base;

import android.widget.EditText;
import com.tencent.kinda.gen.KCardTypePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class KindaCardTypePickerView$1
  implements b.a
{
  KindaCardTypePickerView$1(KindaCardTypePickerView paramKindaCardTypePickerView) {}
  
  public void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(144750);
    KindaCardTypePickerView.access$000(this.this$0).hide();
    if (paramBoolean)
    {
      paramObject1 = (String)paramObject1;
      KindaCardTypePickerView.access$100(this.this$0).setText(paramObject1);
      KindaCardTypePickerView.access$202(this.this$0, KindaCardTypePickerView.access$000(this.this$0).dPp());
      KindaCardTypePickerView.access$300(this.this$0).onSelect(KindaCardTypePickerView.access$000(this.this$0).dPp());
    }
    AppMethodBeat.o(144750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCardTypePickerView.1
 * JD-Core Version:    0.7.0.1
 */