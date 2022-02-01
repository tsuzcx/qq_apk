package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView xeA;
  private CollectRadioBtnView xeB;
  private MMSpinnerDatePicker xeC;
  private TextView xeD;
  private TextView xeE;
  private int xeF;
  private CollectRadioBtnView xez;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64198);
    this.xeF = 0;
    init(paramContext);
    AppMethodBeat.o(64198);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64199);
    this.xeF = 0;
    init(paramContext);
    AppMethodBeat.o(64199);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64200);
    this.xeF = 0;
    init(paramContext);
    AppMethodBeat.o(64200);
  }
  
  private void dsN()
  {
    AppMethodBeat.i(64203);
    if (this.xeF == 2)
    {
      this.xez.setRadioSrc(a.h.radio_on);
      this.xeA.setRadioSrc(a.h.radio_off);
      this.xeB.setRadioSrc(a.h.radio_off);
    }
    for (;;)
    {
      this.xeC.setPickerMode(this.xeF);
      AppMethodBeat.o(64203);
      return;
      if (this.xeF == 1)
      {
        this.xez.setRadioSrc(a.h.radio_off);
        this.xeA.setRadioSrc(a.h.radio_on);
        this.xeB.setRadioSrc(a.h.radio_off);
      }
      else
      {
        this.xez.setRadioSrc(a.h.radio_off);
        this.xeA.setRadioSrc(a.h.radio_off);
        this.xeB.setRadioSrc(a.h.radio_on);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64201);
    paramContext = af.mU(paramContext).inflate(a.g.collect_bill_datepicker_dialog_view, this);
    this.xez = ((CollectRadioBtnView)paramContext.findViewById(a.f.year_btn));
    this.xeA = ((CollectRadioBtnView)paramContext.findViewById(a.f.month_btn));
    this.xeB = ((CollectRadioBtnView)paramContext.findViewById(a.f.day_btn));
    this.xeD = ((TextView)paramContext.findViewById(a.f.confirm_btn));
    this.xeE = ((TextView)paramContext.findViewById(a.f.cancel_btn));
    this.xez.setOnClickListener(this);
    this.xeA.setOnClickListener(this);
    this.xeB.setOnClickListener(this);
    this.xez.setTitleText("年");
    this.xeA.setTitleText("月");
    this.xeB.setTitleText("日");
    this.xeC = ((MMSpinnerDatePicker)paramContext.findViewById(a.f.datepicker));
    this.xeC.aEn(a.c.transparent);
    this.xeC.setTextSize(a.d.NormalTextSize);
    AppMethodBeat.o(64201);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(64210);
    int i = this.xeC.getPickerMode();
    AppMethodBeat.o(64210);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(64209);
    int i = this.xeC.getDayOfMonth();
    AppMethodBeat.o(64209);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(64208);
    int i = this.xeC.getMonth();
    AppMethodBeat.o(64208);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(64207);
    int i = this.xeC.getYear();
    AppMethodBeat.o(64207);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(64202);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i = paramView.getId();
    if (i == a.f.year_btn) {
      this.xeF = 2;
    }
    for (;;)
    {
      dsN();
      a.a(this, "com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(64202);
      return;
      if (i == a.f.month_btn) {
        this.xeF = 1;
      } else if (i == a.f.day_btn) {
        this.xeF = 0;
      } else {
        Log.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(64204);
    this.xeF = paramInt;
    dsN();
    AppMethodBeat.o(64204);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64206);
    this.xeE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64206);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64205);
    this.xeD.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */