package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView kSR;
  private CollectRadioBtnView kSS;
  private CollectRadioBtnView kST;
  private MMSpinnerDatePicker kSU;
  private TextView kSV;
  private TextView kSW;
  private int kSX;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41334);
    this.kSX = 0;
    init(paramContext);
    AppMethodBeat.o(41334);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41335);
    this.kSX = 0;
    init(paramContext);
    AppMethodBeat.o(41335);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41336);
    this.kSX = 0;
    init(paramContext);
    AppMethodBeat.o(41336);
  }
  
  private void biF()
  {
    AppMethodBeat.i(41339);
    if (this.kSX == 2)
    {
      this.kSR.setRadioSrc(2131231906);
      this.kSS.setRadioSrc(2131231905);
      this.kST.setRadioSrc(2131231905);
    }
    for (;;)
    {
      this.kSU.setPickerMode(this.kSX);
      AppMethodBeat.o(41339);
      return;
      if (this.kSX == 1)
      {
        this.kSR.setRadioSrc(2131231905);
        this.kSS.setRadioSrc(2131231906);
        this.kST.setRadioSrc(2131231905);
      }
      else
      {
        this.kSR.setRadioSrc(2131231905);
        this.kSS.setRadioSrc(2131231905);
        this.kST.setRadioSrc(2131231906);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(41337);
    paramContext = w.hM(paramContext).inflate(2130969169, this);
    this.kSR = ((CollectRadioBtnView)paramContext.findViewById(2131822888));
    this.kSS = ((CollectRadioBtnView)paramContext.findViewById(2131822889));
    this.kST = ((CollectRadioBtnView)paramContext.findViewById(2131822890));
    this.kSV = ((TextView)paramContext.findViewById(2131821015));
    this.kSW = ((TextView)paramContext.findViewById(2131822887));
    this.kSR.setOnClickListener(this);
    this.kSS.setOnClickListener(this);
    this.kST.setOnClickListener(this);
    this.kSR.setTitleText("年");
    this.kSS.setTitleText("月");
    this.kST.setTitleText("日");
    this.kSU = ((MMSpinnerDatePicker)paramContext.findViewById(2131822891));
    this.kSU.dOG();
    this.kSU.setTextSize(2131427809);
    AppMethodBeat.o(41337);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(41346);
    int i = this.kSU.getPickerMode();
    AppMethodBeat.o(41346);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(41345);
    int i = this.kSU.getDayOfMonth();
    AppMethodBeat.o(41345);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(41344);
    int i = this.kSU.getMonth();
    AppMethodBeat.o(41344);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(41343);
    int i = this.kSU.getYear();
    AppMethodBeat.o(41343);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41338);
    int i = paramView.getId();
    if (i == 2131822888) {
      this.kSX = 2;
    }
    for (;;)
    {
      biF();
      AppMethodBeat.o(41338);
      return;
      if (i == 2131822889) {
        this.kSX = 1;
      } else if (i == 2131822890) {
        this.kSX = 0;
      } else {
        ab.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(41340);
    this.kSX = paramInt;
    biF();
    AppMethodBeat.o(41340);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(41342);
    this.kSW.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(41342);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(41341);
    this.kSV.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(41341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */