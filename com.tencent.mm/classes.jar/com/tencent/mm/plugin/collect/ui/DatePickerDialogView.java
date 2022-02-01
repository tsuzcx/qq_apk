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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView qCh;
  private CollectRadioBtnView qCi;
  private CollectRadioBtnView qCj;
  private MMSpinnerDatePicker qCk;
  private TextView qCl;
  private TextView qCm;
  private int qCn;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64198);
    this.qCn = 0;
    init(paramContext);
    AppMethodBeat.o(64198);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64199);
    this.qCn = 0;
    init(paramContext);
    AppMethodBeat.o(64199);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64200);
    this.qCn = 0;
    init(paramContext);
    AppMethodBeat.o(64200);
  }
  
  private void cAH()
  {
    AppMethodBeat.i(64203);
    if (this.qCn == 2)
    {
      this.qCh.setRadioSrc(2131691380);
      this.qCi.setRadioSrc(2131691379);
      this.qCj.setRadioSrc(2131691379);
    }
    for (;;)
    {
      this.qCk.setPickerMode(this.qCn);
      AppMethodBeat.o(64203);
      return;
      if (this.qCn == 1)
      {
        this.qCh.setRadioSrc(2131691379);
        this.qCi.setRadioSrc(2131691380);
        this.qCj.setRadioSrc(2131691379);
      }
      else
      {
        this.qCh.setRadioSrc(2131691379);
        this.qCi.setRadioSrc(2131691379);
        this.qCj.setRadioSrc(2131691380);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64201);
    paramContext = aa.jQ(paramContext).inflate(2131493663, this);
    this.qCh = ((CollectRadioBtnView)paramContext.findViewById(2131310680));
    this.qCi = ((CollectRadioBtnView)paramContext.findViewById(2131304854));
    this.qCj = ((CollectRadioBtnView)paramContext.findViewById(2131299422));
    this.qCl = ((TextView)paramContext.findViewById(2131298990));
    this.qCm = ((TextView)paramContext.findViewById(2131297963));
    this.qCh.setOnClickListener(this);
    this.qCi.setOnClickListener(this);
    this.qCj.setOnClickListener(this);
    this.qCh.setTitleText("年");
    this.qCi.setTitleText("月");
    this.qCj.setTitleText("日");
    this.qCk = ((MMSpinnerDatePicker)paramContext.findViewById(2131299420));
    this.qCk.gYR();
    this.qCk.setTextSize(2131165535);
    AppMethodBeat.o(64201);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(64210);
    int i = this.qCk.getPickerMode();
    AppMethodBeat.o(64210);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(64209);
    int i = this.qCk.getDayOfMonth();
    AppMethodBeat.o(64209);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(64208);
    int i = this.qCk.getMonth();
    AppMethodBeat.o(64208);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(64207);
    int i = this.qCk.getYear();
    AppMethodBeat.o(64207);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(64202);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    int i = paramView.getId();
    if (i == 2131310680) {
      this.qCn = 2;
    }
    for (;;)
    {
      cAH();
      a.a(this, "com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(64202);
      return;
      if (i == 2131304854) {
        this.qCn = 1;
      } else if (i == 2131299422) {
        this.qCn = 0;
      } else {
        Log.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(64204);
    this.qCn = paramInt;
    cAH();
    AppMethodBeat.o(64204);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64206);
    this.qCm.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64206);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64205);
    this.qCl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */