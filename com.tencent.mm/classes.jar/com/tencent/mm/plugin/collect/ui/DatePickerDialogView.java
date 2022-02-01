package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;
import com.tencent.mm.ui.y;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView nZt;
  private CollectRadioBtnView nZu;
  private CollectRadioBtnView nZv;
  private MMSpinnerDatePicker nZw;
  private TextView nZx;
  private TextView nZy;
  private int nZz;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64198);
    this.nZz = 0;
    init(paramContext);
    AppMethodBeat.o(64198);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64199);
    this.nZz = 0;
    init(paramContext);
    AppMethodBeat.o(64199);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64200);
    this.nZz = 0;
    init(paramContext);
    AppMethodBeat.o(64200);
  }
  
  private void bPH()
  {
    AppMethodBeat.i(64203);
    if (this.nZz == 2)
    {
      this.nZt.setRadioSrc(2131691078);
      this.nZu.setRadioSrc(2131691077);
      this.nZv.setRadioSrc(2131691077);
    }
    for (;;)
    {
      this.nZw.setPickerMode(this.nZz);
      AppMethodBeat.o(64203);
      return;
      if (this.nZz == 1)
      {
        this.nZt.setRadioSrc(2131691077);
        this.nZu.setRadioSrc(2131691078);
        this.nZv.setRadioSrc(2131691077);
      }
      else
      {
        this.nZt.setRadioSrc(2131691077);
        this.nZu.setRadioSrc(2131691077);
        this.nZv.setRadioSrc(2131691078);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64201);
    paramContext = y.js(paramContext).inflate(2131493551, this);
    this.nZt = ((CollectRadioBtnView)paramContext.findViewById(2131307139));
    this.nZu = ((CollectRadioBtnView)paramContext.findViewById(2131302451));
    this.nZv = ((CollectRadioBtnView)paramContext.findViewById(2131298936));
    this.nZx = ((TextView)paramContext.findViewById(2131298556));
    this.nZy = ((TextView)paramContext.findViewById(2131297690));
    this.nZt.setOnClickListener(this);
    this.nZu.setOnClickListener(this);
    this.nZv.setOnClickListener(this);
    this.nZt.setTitleText("年");
    this.nZu.setTitleText("月");
    this.nZv.setTitleText("日");
    this.nZw = ((MMSpinnerDatePicker)paramContext.findViewById(2131298934));
    this.nZw.feM();
    this.nZw.setTextSize(2131165517);
    AppMethodBeat.o(64201);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(64210);
    int i = this.nZw.getPickerMode();
    AppMethodBeat.o(64210);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(64209);
    int i = this.nZw.getDayOfMonth();
    AppMethodBeat.o(64209);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(64208);
    int i = this.nZw.getMonth();
    AppMethodBeat.o(64208);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(64207);
    int i = this.nZw.getYear();
    AppMethodBeat.o(64207);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(64202);
    int i = paramView.getId();
    if (i == 2131307139) {
      this.nZz = 2;
    }
    for (;;)
    {
      bPH();
      AppMethodBeat.o(64202);
      return;
      if (i == 2131302451) {
        this.nZz = 1;
      } else if (i == 2131298936) {
        this.nZz = 0;
      } else {
        ad.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(64204);
    this.nZz = paramInt;
    bPH();
    AppMethodBeat.o(64204);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64206);
    this.nZy.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64206);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64205);
    this.nZx.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */