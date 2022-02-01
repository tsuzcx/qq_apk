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
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView ubh;
  private CollectRadioBtnView ubi;
  private CollectRadioBtnView ubj;
  private MMSpinnerDatePicker ubk;
  private TextView ubl;
  private TextView ubm;
  private int ubn;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64198);
    this.ubn = 0;
    init(paramContext);
    AppMethodBeat.o(64198);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64199);
    this.ubn = 0;
    init(paramContext);
    AppMethodBeat.o(64199);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64200);
    this.ubn = 0;
    init(paramContext);
    AppMethodBeat.o(64200);
  }
  
  private void cPh()
  {
    AppMethodBeat.i(64203);
    if (this.ubn == 2)
    {
      this.ubh.setRadioSrc(a.h.radio_on);
      this.ubi.setRadioSrc(a.h.radio_off);
      this.ubj.setRadioSrc(a.h.radio_off);
    }
    for (;;)
    {
      this.ubk.setPickerMode(this.ubn);
      AppMethodBeat.o(64203);
      return;
      if (this.ubn == 1)
      {
        this.ubh.setRadioSrc(a.h.radio_off);
        this.ubi.setRadioSrc(a.h.radio_on);
        this.ubj.setRadioSrc(a.h.radio_off);
      }
      else
      {
        this.ubh.setRadioSrc(a.h.radio_off);
        this.ubi.setRadioSrc(a.h.radio_off);
        this.ubj.setRadioSrc(a.h.radio_on);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64201);
    paramContext = ad.kS(paramContext).inflate(a.g.collect_bill_datepicker_dialog_view, this);
    this.ubh = ((CollectRadioBtnView)paramContext.findViewById(a.f.year_btn));
    this.ubi = ((CollectRadioBtnView)paramContext.findViewById(a.f.month_btn));
    this.ubj = ((CollectRadioBtnView)paramContext.findViewById(a.f.day_btn));
    this.ubl = ((TextView)paramContext.findViewById(a.f.confirm_btn));
    this.ubm = ((TextView)paramContext.findViewById(a.f.cancel_btn));
    this.ubh.setOnClickListener(this);
    this.ubi.setOnClickListener(this);
    this.ubj.setOnClickListener(this);
    this.ubh.setTitleText("年");
    this.ubi.setTitleText("月");
    this.ubj.setTitleText("日");
    this.ubk = ((MMSpinnerDatePicker)paramContext.findViewById(a.f.datepicker));
    this.ubk.axD(a.c.transparent);
    this.ubk.setTextSize(a.d.NormalTextSize);
    AppMethodBeat.o(64201);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(64210);
    int i = this.ubk.getPickerMode();
    AppMethodBeat.o(64210);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(64209);
    int i = this.ubk.getDayOfMonth();
    AppMethodBeat.o(64209);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(64208);
    int i = this.ubk.getMonth();
    AppMethodBeat.o(64208);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(64207);
    int i = this.ubk.getYear();
    AppMethodBeat.o(64207);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(64202);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i = paramView.getId();
    if (i == a.f.year_btn) {
      this.ubn = 2;
    }
    for (;;)
    {
      cPh();
      a.a(this, "com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(64202);
      return;
      if (i == a.f.month_btn) {
        this.ubn = 1;
      } else if (i == a.f.day_btn) {
        this.ubn = 0;
      } else {
        Log.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(64204);
    this.ubn = paramInt;
    cPh();
    AppMethodBeat.o(64204);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64206);
    this.ubm.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64206);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64205);
    this.ubl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */