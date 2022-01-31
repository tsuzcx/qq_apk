package com.tencent.kinda.framework.widget.base;

import android.widget.EditText;
import com.tencent.kinda.gen.KDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import java.util.Locale;

class KDatePickerViewImpl$1
  implements a.a
{
  KDatePickerViewImpl$1(KDatePickerViewImpl paramKDatePickerViewImpl) {}
  
  public void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(144686);
    KDatePickerViewImpl.access$000(this.this$0).hide();
    if (paramBoolean)
    {
      ab.d("KDatePickerViewImpl", "执行了onDateChanged，year：" + paramInt1 + "，month：" + paramInt2 + "，day：" + paramInt3 + "，hasSetResult：" + paramBoolean);
      String str = String.format(Locale.CHINA, "%04d%02d%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      KDatePickerViewImpl.access$100(this.this$0).setText(str);
      KDatePickerViewImpl.access$200(this.this$0).onSelect(str);
      KDatePickerViewImpl.access$302(this.this$0, paramInt1);
      KDatePickerViewImpl.access$402(this.this$0, paramInt2);
      KDatePickerViewImpl.access$502(this.this$0, paramInt3);
    }
    KDatePickerViewImpl.access$600(this.this$0);
    AppMethodBeat.o(144686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KDatePickerViewImpl.1
 * JD-Core Version:    0.7.0.1
 */