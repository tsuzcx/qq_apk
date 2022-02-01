package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.EditText;
import com.tencent.kinda.gen.KValidDatePickerView;
import com.tencent.kinda.gen.KValidDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class KindaValidDatePickerView
  extends MMKView<EditText>
  implements KValidDatePickerView
{
  private UIPageFragmentActivity activity;
  KValidDatePickerViewOnSelectCallback callback;
  private b datePicker;
  private TenpaySecureEditText mEditText;
  private int mMonthOfYear = -1;
  private String mSelected;
  private int mYear = -1;
  
  public TenpaySecureEditText createView(Context paramContext)
  {
    AppMethodBeat.i(18975);
    this.mEditText = new TenpaySecureEditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setIsValidThru(true);
    this.mEditText.setHint(2131765114);
    this.mEditText.setPadding(0, 0, 0, 0);
    this.mEditText.setTextSize(16.0F);
    if ((paramContext instanceof UIPageFragmentActivity)) {
      this.activity = ((UIPageFragmentActivity)paramContext);
    }
    paramContext = this.mEditText;
    AppMethodBeat.o(18975);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18977);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(18977);
    return bool;
  }
  
  public String getText()
  {
    return this.mSelected;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18976);
    if (paramBoolean)
    {
      this.activity.hideVKB();
      this.activity.hideTenpayKB();
      this.datePicker = new b(this.activity);
      this.datePicker.aP(true, false);
      this.datePicker.Jjn = new b.a()
      {
        public void onResult(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(18974);
          KindaValidDatePickerView.this.datePicker.hide();
          if (paramAnonymousBoolean)
          {
            Object localObject = KindaValidDatePickerView.this.datePicker.fvX();
            if (bs.isNullOrNil((String)localObject))
            {
              AppMethodBeat.o(18974);
              return;
            }
            String[] arrayOfString = ((String)localObject).split("-");
            if (arrayOfString.length < 2)
            {
              AppMethodBeat.o(18974);
              return;
            }
            ac.d("base_MMKView", "result: %s", new Object[] { localObject });
            KindaValidDatePickerView.access$102(KindaValidDatePickerView.this, bs.aLy(arrayOfString[0]));
            KindaValidDatePickerView.access$202(KindaValidDatePickerView.this, bs.aLy(arrayOfString[1]) - 1);
            ac.d("base_MMKView", "year: %s, month: %s", new Object[] { Integer.valueOf(KindaValidDatePickerView.this.mYear), Integer.valueOf(KindaValidDatePickerView.this.mMonthOfYear) });
            localObject = new DecimalFormat("00");
            KindaValidDatePickerView.this.mEditText.setText(((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mMonthOfYear + 1) + ((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mYear).substring(2));
            KindaValidDatePickerView.access$402(KindaValidDatePickerView.this, ((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mYear).substring(2) + ((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mMonthOfYear + 1));
            KindaValidDatePickerView.this.callback.onSelect(KindaValidDatePickerView.this.mSelected);
          }
          AppMethodBeat.o(18974);
        }
      };
      Object localObject = new Date();
      localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format((Date)localObject).split("-");
      if (localObject.length >= 3)
      {
        this.datePicker.aP(bs.aLy(localObject[0]), bs.aLy(localObject[1]), bs.aLy(localObject[2]));
        this.datePicker.aQ(bs.aLy(localObject[0]) + 30, 12, 31);
      }
      for (;;)
      {
        this.datePicker.aO(this.mYear, this.mMonthOfYear + 1, 1);
        this.datePicker.show();
        AppMethodBeat.o(18976);
        return;
        this.datePicker.aP(bs.aLy(localObject[0]), 1, 1);
        this.datePicker.aQ(bs.aLy(localObject[0]) + 30, 12, 31);
      }
    }
    if (this.datePicker != null) {
      this.datePicker.hide();
    }
    AppMethodBeat.o(18976);
  }
  
  public void setOnSelectCallback(KValidDatePickerViewOnSelectCallback paramKValidDatePickerViewOnSelectCallback)
  {
    this.callback = paramKValidDatePickerViewOnSelectCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaValidDatePickerView
 * JD-Core Version:    0.7.0.1
 */