package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.KDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;

class KindaDatePickerView$1
  implements a.a
{
  KindaDatePickerView$1(KindaDatePickerView paramKindaDatePickerView) {}
  
  public void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(144765);
    KindaDatePickerView.access$000(this.this$0).hide();
    if (paramBoolean)
    {
      Object localObject = KindaDatePickerView.access$000(this.this$0).dPo();
      if (bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(144765);
        return;
      }
      String[] arrayOfString = ((String)localObject).split("-");
      if (arrayOfString.length < 2)
      {
        AppMethodBeat.o(144765);
        return;
      }
      ab.d("base_MMKView", "result: %s", new Object[] { localObject });
      KindaDatePickerView.access$102(this.this$0, bo.apV(arrayOfString[0]));
      KindaDatePickerView.access$202(this.this$0, bo.apV(arrayOfString[1]) - 1);
      KindaDatePickerView.access$302(this.this$0, bo.apV(arrayOfString[2]));
      ab.d("base_MMKView", "year: %s, month: %s, day: %s", new Object[] { Integer.valueOf(KindaDatePickerView.access$100(this.this$0)), Integer.valueOf(KindaDatePickerView.access$200(this.this$0)), Integer.valueOf(KindaDatePickerView.access$300(this.this$0)) });
      localObject = new DecimalFormat("00");
      KindaDatePickerView.access$400(this.this$0).setText(((DecimalFormat)localObject).format(KindaDatePickerView.access$300(this.this$0)) + ((DecimalFormat)localObject).format(KindaDatePickerView.access$200(this.this$0) + 1) + ((DecimalFormat)localObject).format(KindaDatePickerView.access$100(this.this$0)).substring(2));
      KindaDatePickerView.access$502(this.this$0, ((DecimalFormat)localObject).format(KindaDatePickerView.access$300(this.this$0)) + ((DecimalFormat)localObject).format(KindaDatePickerView.access$200(this.this$0) + 1) + ((DecimalFormat)localObject).format(KindaDatePickerView.access$100(this.this$0)).substring(2));
      this.this$0.callback.onSelect(KindaDatePickerView.access$500(this.this$0));
    }
    AppMethodBeat.o(144765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaDatePickerView.1
 * JD-Core Version:    0.7.0.1
 */