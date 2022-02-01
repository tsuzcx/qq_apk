package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KValidDatePickerView;
import com.tencent.kinda.gen.KValidDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.wallet_core.c;
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
  private a datePicker;
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
    this.mEditText.setHint(R.string.wallet_card_date_hint);
    this.mEditText.setSingleLine(false);
    this.mEditText.setPadding(0, 0, 0, 0);
    float f = MMKViewUtil.getScaleSize(paramContext);
    this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(paramContext, f * 17.0F));
    this.mEditText.setAccessibilityDelegate(new c()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(226500);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousAccessibilityNodeInfo.setClassName(Button.class.getName());
        AppMethodBeat.o(226500);
      }
    });
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
      this.datePicker = new a(this.activity);
      this.datePicker.bP(true, false);
      this.datePicker.agjU = new a.a()
      {
        public void onResult(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(226505);
          KindaValidDatePickerView.this.datePicker.hide();
          if (paramAnonymousBoolean)
          {
            Object localObject = KindaValidDatePickerView.this.datePicker.jIy();
            if (Util.isNullOrNil((String)localObject))
            {
              AppMethodBeat.o(226505);
              return;
            }
            String[] arrayOfString = ((String)localObject).split("-");
            if (arrayOfString.length < 2)
            {
              AppMethodBeat.o(226505);
              return;
            }
            Log.d("base_MMKView", "result: %s", new Object[] { localObject });
            KindaValidDatePickerView.access$102(KindaValidDatePickerView.this, Util.safeParseInt(arrayOfString[0]));
            KindaValidDatePickerView.access$202(KindaValidDatePickerView.this, Util.safeParseInt(arrayOfString[1]) - 1);
            Log.d("base_MMKView", "year: %s, month: %s", new Object[] { Integer.valueOf(KindaValidDatePickerView.this.mYear), Integer.valueOf(KindaValidDatePickerView.this.mMonthOfYear) });
            localObject = new DecimalFormat("00");
            KindaValidDatePickerView.this.mEditText.setText(((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mMonthOfYear + 1) + ((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mYear).substring(2));
            KindaValidDatePickerView.access$402(KindaValidDatePickerView.this, ((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mYear).substring(2) + ((DecimalFormat)localObject).format(KindaValidDatePickerView.this.mMonthOfYear + 1));
            KindaValidDatePickerView.this.callback.onSelect(KindaValidDatePickerView.this.mSelected);
          }
          AppMethodBeat.o(226505);
        }
      };
      Object localObject = new Date();
      localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format((Date)localObject).split("-");
      if (localObject.length >= 3)
      {
        this.datePicker.bD(Util.safeParseInt(localObject[0]), Util.safeParseInt(localObject[1]), Util.safeParseInt(localObject[2]));
        this.datePicker.bE(Util.safeParseInt(localObject[0]) + 30, 12, 31);
      }
      for (;;)
      {
        this.datePicker.bC(this.mYear, this.mMonthOfYear + 1, 1);
        this.datePicker.show();
        AppMethodBeat.o(18976);
        return;
        this.datePicker.bD(Util.safeParseInt(localObject[0]), 1, 1);
        this.datePicker.bE(Util.safeParseInt(localObject[0]) + 30, 12, 31);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaValidDatePickerView
 * JD-Core Version:    0.7.0.1
 */