package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.KValidDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;

class KindaValidDatePickerView$1
  implements a.a
{
  KindaValidDatePickerView$1(KindaValidDatePickerView paramKindaValidDatePickerView) {}
  
  public void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(144825);
    KindaValidDatePickerView.access$000(this.this$0).hide();
    if (paramBoolean)
    {
      Object localObject = KindaValidDatePickerView.access$000(this.this$0).dPo();
      if (bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(144825);
        return;
      }
      String[] arrayOfString = ((String)localObject).split("-");
      if (arrayOfString.length < 2)
      {
        AppMethodBeat.o(144825);
        return;
      }
      ab.d("base_MMKView", "result: %s", new Object[] { localObject });
      KindaValidDatePickerView.access$102(this.this$0, bo.apV(arrayOfString[0]));
      KindaValidDatePickerView.access$202(this.this$0, bo.apV(arrayOfString[1]) - 1);
      ab.d("base_MMKView", "year: %s, month: %s", new Object[] { Integer.valueOf(KindaValidDatePickerView.access$100(this.this$0)), Integer.valueOf(KindaValidDatePickerView.access$200(this.this$0)) });
      localObject = new DecimalFormat("00");
      KindaValidDatePickerView.access$300(this.this$0).setText(((DecimalFormat)localObject).format(KindaValidDatePickerView.access$200(this.this$0) + 1) + ((DecimalFormat)localObject).format(KindaValidDatePickerView.access$100(this.this$0)).substring(2));
      KindaValidDatePickerView.access$402(this.this$0, ((DecimalFormat)localObject).format(KindaValidDatePickerView.access$200(this.this$0) + 1) + ((DecimalFormat)localObject).format(KindaValidDatePickerView.access$100(this.this$0)).substring(2));
      this.this$0.callback.onSelect(KindaValidDatePickerView.access$400(this.this$0));
    }
    AppMethodBeat.o(144825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaValidDatePickerView.1
 * JD-Core Version:    0.7.0.1
 */