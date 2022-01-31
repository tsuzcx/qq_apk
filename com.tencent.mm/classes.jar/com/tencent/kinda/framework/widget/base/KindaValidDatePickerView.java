package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.EditText;
import com.tencent.kinda.framework.app.UIPageFragmentActivity;
import com.tencent.kinda.gen.KValidDatePickerView;
import com.tencent.kinda.gen.KValidDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.a;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class KindaValidDatePickerView
  extends MMKView<EditText>
  implements KValidDatePickerView
{
  private UIPageFragmentActivity activity;
  KValidDatePickerViewOnSelectCallback callback;
  private a datePicker;
  private TenpaySecureEditText mEditText;
  private int mMonthOfYear = -1;
  private String mSelected;
  private int mYear = -1;
  
  public TenpaySecureEditText createView(Context paramContext)
  {
    AppMethodBeat.i(144826);
    this.mEditText = new TenpaySecureEditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setIsValidThru(true);
    this.mEditText.setHint(2131304922);
    if ((paramContext instanceof UIPageFragmentActivity)) {
      this.activity = ((UIPageFragmentActivity)paramContext);
    }
    paramContext = this.mEditText;
    AppMethodBeat.o(144826);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144828);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(144828);
    return bool;
  }
  
  public String getText()
  {
    return this.mSelected;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144827);
    if (paramBoolean)
    {
      this.activity.hideVKB();
      this.activity.hideTenpayKB();
      this.datePicker = new a(this.activity);
      this.datePicker.am(true, false);
      this.datePicker.AIQ = new KindaValidDatePickerView.1(this);
      this.datePicker.aA(this.mYear, this.mMonthOfYear + 1, 1);
      this.datePicker.show();
      AppMethodBeat.o(144827);
      return;
    }
    if (this.datePicker != null) {
      this.datePicker.hide();
    }
    AppMethodBeat.o(144827);
  }
  
  public void setOnSelectCallback(KValidDatePickerViewOnSelectCallback paramKValidDatePickerViewOnSelectCallback)
  {
    this.callback = paramKValidDatePickerViewOnSelectCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaValidDatePickerView
 * JD-Core Version:    0.7.0.1
 */