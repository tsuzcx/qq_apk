package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.EditText;
import com.tencent.kinda.framework.app.UIPageFragmentActivity;
import com.tencent.kinda.gen.DatePickerType;
import com.tencent.kinda.gen.KDatePickerView;
import com.tencent.kinda.gen.KDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;

public class KindaDatePickerView
  extends MMKView<EditText>
  implements KDatePickerView
{
  private UIPageFragmentActivity activity;
  KDatePickerViewOnSelectCallback callback;
  private a datePicker;
  private int mDay = -1;
  private TenpaySecureEditText mEditText;
  private int mMonthOfYear = -1;
  private String mSelected;
  private DatePickerType mType = DatePickerType.BIRTH_DAY;
  private int mYear = -1;
  
  public TenpaySecureEditText createView(Context paramContext)
  {
    AppMethodBeat.i(144766);
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
    AppMethodBeat.o(144766);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144768);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(144768);
    return bool;
  }
  
  public DatePickerType getType()
  {
    return this.mType;
  }
  
  public String getValue()
  {
    AppMethodBeat.i(144770);
    String str = this.mEditText.get3DesEncrptData();
    AppMethodBeat.o(144770);
    return str;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144767);
    if (paramBoolean)
    {
      this.activity.hideVKB();
      this.activity.hideTenpayKB();
      this.datePicker = new a(this.activity);
      a locala = this.datePicker;
      if (this.mType == DatePickerType.BIRTH_DAY) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        locala.am(true, paramBoolean);
        this.datePicker.AIQ = new KindaDatePickerView.1(this);
        this.datePicker.aA(this.mYear, this.mMonthOfYear + 1, 1);
        this.datePicker.show();
        AppMethodBeat.o(144767);
        return;
      }
    }
    if (this.datePicker != null) {
      this.datePicker.hide();
    }
    AppMethodBeat.o(144767);
  }
  
  public void setOnSelectCallback(KDatePickerViewOnSelectCallback paramKDatePickerViewOnSelectCallback)
  {
    this.callback = paramKDatePickerViewOnSelectCallback;
  }
  
  public void setType(DatePickerType paramDatePickerType)
  {
    this.mType = paramDatePickerType;
  }
  
  public void setValue(String paramString)
  {
    AppMethodBeat.i(144769);
    paramString = new DecimalFormat("00");
    this.mEditText.setText(paramString.format(this.mDay) + paramString.format(this.mMonthOfYear + 1) + paramString.format(this.mYear).substring(2));
    AppMethodBeat.o(144769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaDatePickerView
 * JD-Core Version:    0.7.0.1
 */