package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.DatePickerType;
import com.tencent.kinda.gen.KDatePickerView;
import com.tencent.kinda.gen.KDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class KDatePickerViewImpl
  extends MMKView
  implements KDatePickerView
{
  private static final String TAG = "KDatePickerViewImpl";
  private KDatePickerViewOnSelectCallback mCallback;
  private a mDatePicker;
  private a.a mDatePickerResultListener;
  private int mDay;
  private EditText mEditText;
  private int mMonth;
  private int mYear;
  
  public KDatePickerViewImpl()
  {
    AppMethodBeat.i(144687);
    this.mDatePickerResultListener = new KDatePickerViewImpl.1(this);
    AppMethodBeat.o(144687);
  }
  
  private void buildDatePicker()
  {
    AppMethodBeat.i(144694);
    this.mDatePicker = new a(KindaContext.getTopOrUIPageFragmentActivity());
    this.mDatePicker.am(true, true);
    this.mDatePicker.aA(this.mYear, this.mMonth, this.mDay);
    this.mDatePicker.AIQ = this.mDatePickerResultListener;
    AppMethodBeat.o(144694);
  }
  
  private void initDatePickerData()
  {
    AppMethodBeat.i(144693);
    Object localObject = new Date();
    localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format((Date)localObject).split("-");
    this.mYear = bo.apV(localObject[0]);
    this.mMonth = bo.apV(localObject[1]);
    this.mDay = bo.apV(localObject[2]);
    AppMethodBeat.o(144693);
  }
  
  public View createView(Context paramContext)
  {
    AppMethodBeat.i(144688);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setTextColor(paramContext.getResources().getColor(2131690796));
    this.mEditText.setHint(2131304972);
    this.mEditText.setBackground(null);
    this.mEditText.setFocusable(false);
    initDatePickerData();
    buildDatePicker();
    paramContext = this.mEditText;
    AppMethodBeat.o(144688);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144690);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(144690);
    return bool;
  }
  
  public DatePickerType getType()
  {
    return null;
  }
  
  public String getValue()
  {
    AppMethodBeat.i(144692);
    String str = this.mEditText.getText().toString();
    AppMethodBeat.o(144692);
    return str;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144689);
    ab.d("KDatePickerViewImpl", "setFocus，focus：".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      this.mDatePicker.aA(this.mYear, this.mMonth, this.mDay);
      this.mDatePicker.show();
    }
    AppMethodBeat.o(144689);
  }
  
  public void setOnSelectCallback(KDatePickerViewOnSelectCallback paramKDatePickerViewOnSelectCallback)
  {
    this.mCallback = paramKDatePickerViewOnSelectCallback;
  }
  
  public void setType(DatePickerType paramDatePickerType) {}
  
  public void setValue(String paramString)
  {
    AppMethodBeat.i(144691);
    this.mEditText.setText(paramString);
    AppMethodBeat.o(144691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KDatePickerViewImpl
 * JD-Core Version:    0.7.0.1
 */