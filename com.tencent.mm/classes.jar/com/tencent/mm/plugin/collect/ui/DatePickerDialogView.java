package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;
import com.tencent.mm.ui.z;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView oCO;
  private CollectRadioBtnView oCP;
  private CollectRadioBtnView oCQ;
  private MMSpinnerDatePicker oCR;
  private TextView oCS;
  private TextView oCT;
  private int oCU;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64198);
    this.oCU = 0;
    init(paramContext);
    AppMethodBeat.o(64198);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64199);
    this.oCU = 0;
    init(paramContext);
    AppMethodBeat.o(64199);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64200);
    this.oCU = 0;
    init(paramContext);
    AppMethodBeat.o(64200);
  }
  
  private void bWX()
  {
    AppMethodBeat.i(64203);
    if (this.oCU == 2)
    {
      this.oCO.setRadioSrc(2131691078);
      this.oCP.setRadioSrc(2131691077);
      this.oCQ.setRadioSrc(2131691077);
    }
    for (;;)
    {
      this.oCR.setPickerMode(this.oCU);
      AppMethodBeat.o(64203);
      return;
      if (this.oCU == 1)
      {
        this.oCO.setRadioSrc(2131691077);
        this.oCP.setRadioSrc(2131691078);
        this.oCQ.setRadioSrc(2131691077);
      }
      else
      {
        this.oCO.setRadioSrc(2131691077);
        this.oCP.setRadioSrc(2131691077);
        this.oCQ.setRadioSrc(2131691078);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64201);
    paramContext = z.jD(paramContext).inflate(2131493551, this);
    this.oCO = ((CollectRadioBtnView)paramContext.findViewById(2131307139));
    this.oCP = ((CollectRadioBtnView)paramContext.findViewById(2131302451));
    this.oCQ = ((CollectRadioBtnView)paramContext.findViewById(2131298936));
    this.oCS = ((TextView)paramContext.findViewById(2131298556));
    this.oCT = ((TextView)paramContext.findViewById(2131297690));
    this.oCO.setOnClickListener(this);
    this.oCP.setOnClickListener(this);
    this.oCQ.setOnClickListener(this);
    this.oCO.setTitleText("年");
    this.oCP.setTitleText("月");
    this.oCQ.setTitleText("日");
    this.oCR = ((MMSpinnerDatePicker)paramContext.findViewById(2131298934));
    this.oCR.fuH();
    this.oCR.setTextSize(2131165517);
    AppMethodBeat.o(64201);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(64210);
    int i = this.oCR.getPickerMode();
    AppMethodBeat.o(64210);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(64209);
    int i = this.oCR.getDayOfMonth();
    AppMethodBeat.o(64209);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(64208);
    int i = this.oCR.getMonth();
    AppMethodBeat.o(64208);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(64207);
    int i = this.oCR.getYear();
    AppMethodBeat.o(64207);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(64202);
    int i = paramView.getId();
    if (i == 2131307139) {
      this.oCU = 2;
    }
    for (;;)
    {
      bWX();
      AppMethodBeat.o(64202);
      return;
      if (i == 2131302451) {
        this.oCU = 1;
      } else if (i == 2131298936) {
        this.oCU = 0;
      } else {
        ac.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(64204);
    this.oCU = paramInt;
    bWX();
    AppMethodBeat.o(64204);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64206);
    this.oCT.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64206);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64205);
    this.oCS.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */