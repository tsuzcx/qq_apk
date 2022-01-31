package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView iMg;
  private CollectRadioBtnView iMh;
  private CollectRadioBtnView iMi;
  private MMSpinnerDatePicker iMj;
  private TextView iMk;
  private TextView iMl;
  private int iMm = 0;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void aFq()
  {
    if (this.iMm == 2)
    {
      this.iMg.setRadioSrc(a.h.radio_on);
      this.iMh.setRadioSrc(a.h.radio_off);
      this.iMi.setRadioSrc(a.h.radio_off);
    }
    for (;;)
    {
      this.iMj.setPickerMode(this.iMm);
      return;
      if (this.iMm == 1)
      {
        this.iMg.setRadioSrc(a.h.radio_off);
        this.iMh.setRadioSrc(a.h.radio_on);
        this.iMi.setRadioSrc(a.h.radio_off);
      }
      else
      {
        this.iMg.setRadioSrc(a.h.radio_off);
        this.iMh.setRadioSrc(a.h.radio_off);
        this.iMi.setRadioSrc(a.h.radio_on);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    paramContext = com.tencent.mm.ui.y.gt(paramContext).inflate(a.g.collect_bill_datepicker_dialog_view, this);
    this.iMg = ((CollectRadioBtnView)paramContext.findViewById(a.f.year_btn));
    this.iMh = ((CollectRadioBtnView)paramContext.findViewById(a.f.month_btn));
    this.iMi = ((CollectRadioBtnView)paramContext.findViewById(a.f.day_btn));
    this.iMk = ((TextView)paramContext.findViewById(a.f.confirm_btn));
    this.iMl = ((TextView)paramContext.findViewById(a.f.cancel_btn));
    this.iMg.setOnClickListener(this);
    this.iMh.setOnClickListener(this);
    this.iMi.setOnClickListener(this);
    this.iMg.setTitleText("年");
    this.iMh.setTitleText("月");
    this.iMi.setTitleText("日");
    this.iMj = ((MMSpinnerDatePicker)paramContext.findViewById(a.f.datepicker));
    this.iMj.Il(a.c.transparent);
    this.iMj.setTextSize(a.d.NormalTextSize);
  }
  
  public int getDatePickerMode()
  {
    return this.iMj.getPickerMode();
  }
  
  public int getDayOfMonth()
  {
    return this.iMj.getDayOfMonth();
  }
  
  public int getMonth()
  {
    return this.iMj.getMonth();
  }
  
  public int getYear()
  {
    return this.iMj.getYear();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == a.f.year_btn) {
      this.iMm = 2;
    }
    for (;;)
    {
      aFq();
      return;
      if (i == a.f.month_btn) {
        this.iMm = 1;
      } else if (i == a.f.day_btn) {
        this.iMm = 0;
      } else {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    this.iMm = paramInt;
    aFq();
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.iMl.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.iMk.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */