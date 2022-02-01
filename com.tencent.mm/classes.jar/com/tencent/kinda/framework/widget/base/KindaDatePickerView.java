package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DatePickerType;
import com.tencent.kinda.gen.KDate;
import com.tencent.kinda.gen.KDatePickerView;
import com.tencent.kinda.gen.KDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class KindaDatePickerView
  extends MMKView<View>
  implements KDatePickerView
{
  private static final String TAG = "KindaDatePickerView";
  private UIPageFragmentActivity activity;
  private KDatePickerViewOnSelectCallback callback;
  private b datePicker;
  private boolean isLongTerm = false;
  private Calendar mCalendar;
  private int mDay = -1;
  private TenpaySecureEditText mEditText;
  private int mMonthOfYear = -1;
  private String mShowResult = "";
  private DatePickerType mType = DatePickerType.BIRTH_DAY;
  private int mYear = -1;
  
  private Calendar calendar()
  {
    AppMethodBeat.i(214474);
    if (this.mCalendar == null) {
      this.mCalendar = Calendar.getInstance();
    }
    Calendar localCalendar = this.mCalendar;
    AppMethodBeat.o(214474);
    return localCalendar;
  }
  
  private String getEncString()
  {
    AppMethodBeat.i(18912);
    if ((this.isLongTerm) && (this.mYear == 9999)) {
      str = String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.mYear), Integer.valueOf(this.mMonthOfYear), Integer.valueOf(this.mDay) });
    }
    for (String str = this.mEditText.get3DesEncrptData(str);; str = this.mEditText.get3DesEncrptData(str))
    {
      AppMethodBeat.o(18912);
      return str;
      str = this.mShowResult.replaceAll("/", "");
    }
  }
  
  private void initDatePicker()
  {
    AppMethodBeat.i(18910);
    if (this.activity == null)
    {
      Log.e("KindaDatePickerView", "activity is null!");
      AppMethodBeat.o(18910);
      return;
    }
    this.datePicker = new b(this.activity);
    AppMethodBeat.o(18910);
  }
  
  private void initDatePickerData()
  {
    AppMethodBeat.i(18909);
    Object localObject = new Date();
    localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format((Date)localObject).split("-");
    this.mYear = Util.safeParseInt(localObject[0]);
    this.mMonthOfYear = Util.safeParseInt(localObject[1]);
    this.mDay = Util.safeParseInt(localObject[2]);
    AppMethodBeat.o(18909);
  }
  
  private void setMinAndMaxDate(DatePickerType paramDatePickerType)
  {
    AppMethodBeat.i(18911);
    if (this.datePicker == null)
    {
      AppMethodBeat.o(18911);
      return;
    }
    if (paramDatePickerType == DatePickerType.BIRTH_DAY)
    {
      this.datePicker.aY(1900, 1, 1);
      paramDatePickerType = new Date();
      paramDatePickerType = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(paramDatePickerType).split("-");
      if (paramDatePickerType.length >= 3) {
        this.datePicker.aZ(Util.safeParseInt(paramDatePickerType[0]), Util.safeParseInt(paramDatePickerType[1]), Util.safeParseInt(paramDatePickerType[2]));
      }
      AppMethodBeat.o(18911);
      return;
    }
    if (paramDatePickerType == DatePickerType.IDENTITY_VALID_DATE)
    {
      paramDatePickerType = new Date();
      paramDatePickerType = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(paramDatePickerType).split("-");
      if (paramDatePickerType.length >= 3)
      {
        this.datePicker.aY(Util.safeParseInt(paramDatePickerType[0]), Util.safeParseInt(paramDatePickerType[1]), Util.safeParseInt(paramDatePickerType[2]));
        this.datePicker.aZ(Util.safeParseInt(paramDatePickerType[0]) + 100, 12, 31);
      }
      if (this.isLongTerm) {
        this.datePicker.setLongTermYear(true);
      }
      AppMethodBeat.o(18911);
      return;
    }
    if (paramDatePickerType == DatePickerType.IDENTITY_EFFECT_DATE)
    {
      paramDatePickerType = new Date();
      paramDatePickerType = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(paramDatePickerType).split("-");
      if (paramDatePickerType.length >= 3)
      {
        this.datePicker.aZ(Util.safeParseInt(paramDatePickerType[0]), Util.safeParseInt(paramDatePickerType[1]), Util.safeParseInt(paramDatePickerType[2]));
        int j = Util.safeParseInt(paramDatePickerType[0]) - 100;
        int i = j;
        if (j <= 0) {
          i = 1;
        }
        this.datePicker.aY(i, 1, 1);
      }
    }
    AppMethodBeat.o(18911);
  }
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(214468);
    this.mEditText = new TenpaySecureEditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0F));
    this.mEditText.setPadding(0, 0, 0, 0);
    this.mEditText.setTextColor(paramContext.getResources().getColor(2131101347));
    if ((paramContext instanceof UIPageFragmentActivity)) {
      this.activity = ((UIPageFragmentActivity)paramContext);
    }
    initDatePickerData();
    initDatePicker();
    paramContext = new LayoutWrapper(paramContext, this.mEditText);
    AppMethodBeat.o(214468);
    return paramContext;
  }
  
  public KDate currentDate()
  {
    AppMethodBeat.i(214473);
    Object localObject = calendar();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    localObject = new KDate(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
    AppMethodBeat.o(214473);
    return localObject;
  }
  
  public boolean getCanBeLongTerm()
  {
    return this.isLongTerm;
  }
  
  public KDate getEndDate()
  {
    return null;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18906);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(18906);
    return bool;
  }
  
  public KDate getSelectedDate()
  {
    AppMethodBeat.i(214470);
    KDate localKDate = new KDate(this.mYear, this.mMonthOfYear, this.mDay);
    AppMethodBeat.o(214470);
    return localKDate;
  }
  
  public KDate getStartDate()
  {
    return null;
  }
  
  public DatePickerType getType()
  {
    return this.mType;
  }
  
  public String getValue()
  {
    AppMethodBeat.i(18908);
    String str = getEncString();
    AppMethodBeat.o(18908);
    return str;
  }
  
  public void setCanBeLongTerm(boolean paramBoolean)
  {
    AppMethodBeat.i(214469);
    this.isLongTerm = paramBoolean;
    this.datePicker.setLongTermYear(paramBoolean);
    AppMethodBeat.o(214469);
  }
  
  public void setEndDate(KDate paramKDate) {}
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18905);
    if (paramBoolean)
    {
      if (this.activity == null)
      {
        Log.e("KindaDatePickerView", "activity is null!");
        AppMethodBeat.o(18905);
        return;
      }
      this.activity.hideVKB();
      this.activity.hideTenpayKB();
      this.datePicker = new b(this.activity);
      setMinAndMaxDate(this.mType);
      this.datePicker.bg(true, true);
      this.datePicker.QSU = new b.a()
      {
        public void onResult(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(18902);
          KindaDatePickerView.this.datePicker.hide();
          KindaDatePickerView.access$102(KindaDatePickerView.this, paramAnonymousInt1);
          KindaDatePickerView.access$202(KindaDatePickerView.this, paramAnonymousInt2);
          KindaDatePickerView.access$302(KindaDatePickerView.this, paramAnonymousInt3);
          Log.d("KindaDatePickerView", "onDateChanged，year：" + paramAnonymousInt1 + "，month：" + paramAnonymousInt2 + "，day：" + paramAnonymousInt3 + "，hasSetResult：" + paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            if ((!KindaDatePickerView.this.isLongTerm) || (paramAnonymousInt1 != 1)) {
              break label200;
            }
            KindaDatePickerView.access$102(KindaDatePickerView.this, 9999);
            KindaDatePickerView.access$202(KindaDatePickerView.this, 12);
            KindaDatePickerView.access$302(KindaDatePickerView.this, 31);
            KindaDatePickerView.access$502(KindaDatePickerView.this, MMApplicationContext.getContext().getString(2131768510));
          }
          for (;;)
          {
            KindaDatePickerView.this.mEditText.setText(KindaDatePickerView.this.mShowResult);
            KindaDatePickerView.this.callback.onSelect(KindaDatePickerView.access$700(KindaDatePickerView.this));
            AppMethodBeat.o(18902);
            return;
            label200:
            KindaDatePickerView.access$502(KindaDatePickerView.this, String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) }));
          }
        }
      };
      if (this.mYear == 9999)
      {
        Log.i("KindaDatePickerView", "init long term");
        this.datePicker.aX(1, 1, 1);
      }
      for (;;)
      {
        this.datePicker.show();
        AppMethodBeat.o(18905);
        return;
        this.datePicker.aX(this.mYear, this.mMonthOfYear, this.mDay);
      }
    }
    if (this.datePicker != null) {
      this.datePicker.hide();
    }
    AppMethodBeat.o(18905);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(170116);
    if (this.mEditText != null) {
      this.mEditText.setHint(paramString);
    }
    AppMethodBeat.o(170116);
  }
  
  public void setOnSelectCallback(KDatePickerViewOnSelectCallback paramKDatePickerViewOnSelectCallback)
  {
    this.callback = paramKDatePickerViewOnSelectCallback;
  }
  
  public void setOriginDate(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(18904);
    this.mYear = paramInt1;
    this.mMonthOfYear = paramInt2;
    this.mDay = paramInt3;
    if ((this.isLongTerm) && (paramInt1 == 9999))
    {
      this.mShowResult = MMApplicationContext.getContext().getString(2131768510);
      this.mEditText.setText(this.mShowResult);
      AppMethodBeat.o(18904);
      return;
    }
    this.mShowResult = String.format("%04d/%02d/%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mEditText.setText(this.mShowResult);
    AppMethodBeat.o(18904);
  }
  
  public void setStartDate(KDate paramKDate) {}
  
  public void setType(DatePickerType paramDatePickerType)
  {
    AppMethodBeat.i(18907);
    this.mType = paramDatePickerType;
    if (paramDatePickerType == DatePickerType.BIRTH_DAY) {
      this.mEditText.setHint(2131767607);
    }
    for (;;)
    {
      setMinAndMaxDate(paramDatePickerType);
      AppMethodBeat.o(18907);
      return;
      if (paramDatePickerType == DatePickerType.IDENTITY_VALID_DATE) {
        this.mEditText.setHint(2131767552);
      }
    }
  }
  
  public void setValue(String paramString) {}
  
  public long timeForDate(KDate paramKDate)
  {
    AppMethodBeat.i(214471);
    if (paramKDate != null)
    {
      Calendar localCalendar = calendar();
      localCalendar.clear();
      localCalendar.set(paramKDate.mYear, paramKDate.mMonth - 1, paramKDate.mDay);
      long l = localCalendar.getTimeInMillis();
      AppMethodBeat.o(214471);
      return l;
    }
    AppMethodBeat.o(214471);
    return 0L;
  }
  
  public int yearOfNow()
  {
    AppMethodBeat.i(214472);
    Calendar localCalendar = calendar();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = localCalendar.get(1);
    AppMethodBeat.o(214472);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaDatePickerView
 * JD-Core Version:    0.7.0.1
 */