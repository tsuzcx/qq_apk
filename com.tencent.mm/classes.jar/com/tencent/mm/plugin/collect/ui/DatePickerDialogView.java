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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;
import com.tencent.mm.ui.z;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView pmP;
  private CollectRadioBtnView pmQ;
  private CollectRadioBtnView pmR;
  private MMSpinnerDatePicker pmS;
  private TextView pmT;
  private TextView pmU;
  private int pmV;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64198);
    this.pmV = 0;
    init(paramContext);
    AppMethodBeat.o(64198);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64199);
    this.pmV = 0;
    init(paramContext);
    AppMethodBeat.o(64199);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64200);
    this.pmV = 0;
    init(paramContext);
    AppMethodBeat.o(64200);
  }
  
  private void ccP()
  {
    AppMethodBeat.i(64203);
    if (this.pmV == 2)
    {
      this.pmP.setRadioSrc(2131691078);
      this.pmQ.setRadioSrc(2131691077);
      this.pmR.setRadioSrc(2131691077);
    }
    for (;;)
    {
      this.pmS.setPickerMode(this.pmV);
      AppMethodBeat.o(64203);
      return;
      if (this.pmV == 1)
      {
        this.pmP.setRadioSrc(2131691077);
        this.pmQ.setRadioSrc(2131691078);
        this.pmR.setRadioSrc(2131691077);
      }
      else
      {
        this.pmP.setRadioSrc(2131691077);
        this.pmQ.setRadioSrc(2131691077);
        this.pmR.setRadioSrc(2131691078);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64201);
    paramContext = z.jV(paramContext).inflate(2131493551, this);
    this.pmP = ((CollectRadioBtnView)paramContext.findViewById(2131307139));
    this.pmQ = ((CollectRadioBtnView)paramContext.findViewById(2131302451));
    this.pmR = ((CollectRadioBtnView)paramContext.findViewById(2131298936));
    this.pmT = ((TextView)paramContext.findViewById(2131298556));
    this.pmU = ((TextView)paramContext.findViewById(2131297690));
    this.pmP.setOnClickListener(this);
    this.pmQ.setOnClickListener(this);
    this.pmR.setOnClickListener(this);
    this.pmP.setTitleText("年");
    this.pmQ.setTitleText("月");
    this.pmR.setTitleText("日");
    this.pmS = ((MMSpinnerDatePicker)paramContext.findViewById(2131298934));
    this.pmS.fPO();
    this.pmS.setTextSize(2131165517);
    AppMethodBeat.o(64201);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(64210);
    int i = this.pmS.getPickerMode();
    AppMethodBeat.o(64210);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(64209);
    int i = this.pmS.getDayOfMonth();
    AppMethodBeat.o(64209);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(64208);
    int i = this.pmS.getMonth();
    AppMethodBeat.o(64208);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(64207);
    int i = this.pmS.getYear();
    AppMethodBeat.o(64207);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(64202);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    int i = paramView.getId();
    if (i == 2131307139) {
      this.pmV = 2;
    }
    for (;;)
    {
      ccP();
      a.a(this, "com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(64202);
      return;
      if (i == 2131302451) {
        this.pmV = 1;
      } else if (i == 2131298936) {
        this.pmV = 0;
      } else {
        ae.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(64204);
    this.pmV = paramInt;
    ccP();
    AppMethodBeat.o(64204);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64206);
    this.pmU.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64206);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64205);
    this.pmT.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */