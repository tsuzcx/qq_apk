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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;
import com.tencent.mm.ui.z;

public class DatePickerDialogView
  extends LinearLayout
  implements View.OnClickListener
{
  private CollectRadioBtnView pgj;
  private CollectRadioBtnView pgk;
  private CollectRadioBtnView pgl;
  private MMSpinnerDatePicker pgm;
  private TextView pgn;
  private TextView pgo;
  private int pgp;
  
  public DatePickerDialogView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64198);
    this.pgp = 0;
    init(paramContext);
    AppMethodBeat.o(64198);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64199);
    this.pgp = 0;
    init(paramContext);
    AppMethodBeat.o(64199);
  }
  
  public DatePickerDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64200);
    this.pgp = 0;
    init(paramContext);
    AppMethodBeat.o(64200);
  }
  
  private void cbA()
  {
    AppMethodBeat.i(64203);
    if (this.pgp == 2)
    {
      this.pgj.setRadioSrc(2131691078);
      this.pgk.setRadioSrc(2131691077);
      this.pgl.setRadioSrc(2131691077);
    }
    for (;;)
    {
      this.pgm.setPickerMode(this.pgp);
      AppMethodBeat.o(64203);
      return;
      if (this.pgp == 1)
      {
        this.pgj.setRadioSrc(2131691077);
        this.pgk.setRadioSrc(2131691078);
        this.pgl.setRadioSrc(2131691077);
      }
      else
      {
        this.pgj.setRadioSrc(2131691077);
        this.pgk.setRadioSrc(2131691077);
        this.pgl.setRadioSrc(2131691078);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64201);
    paramContext = z.jO(paramContext).inflate(2131493551, this);
    this.pgj = ((CollectRadioBtnView)paramContext.findViewById(2131307139));
    this.pgk = ((CollectRadioBtnView)paramContext.findViewById(2131302451));
    this.pgl = ((CollectRadioBtnView)paramContext.findViewById(2131298936));
    this.pgn = ((TextView)paramContext.findViewById(2131298556));
    this.pgo = ((TextView)paramContext.findViewById(2131297690));
    this.pgj.setOnClickListener(this);
    this.pgk.setOnClickListener(this);
    this.pgl.setOnClickListener(this);
    this.pgj.setTitleText("年");
    this.pgk.setTitleText("月");
    this.pgl.setTitleText("日");
    this.pgm = ((MMSpinnerDatePicker)paramContext.findViewById(2131298934));
    this.pgm.fLu();
    this.pgm.setTextSize(2131165517);
    AppMethodBeat.o(64201);
  }
  
  public int getDatePickerMode()
  {
    AppMethodBeat.i(64210);
    int i = this.pgm.getPickerMode();
    AppMethodBeat.o(64210);
    return i;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(64209);
    int i = this.pgm.getDayOfMonth();
    AppMethodBeat.o(64209);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(64208);
    int i = this.pgm.getMonth();
    AppMethodBeat.o(64208);
    return i;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(64207);
    int i = this.pgm.getYear();
    AppMethodBeat.o(64207);
    return i;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(64202);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    int i = paramView.getId();
    if (i == 2131307139) {
      this.pgp = 2;
    }
    for (;;)
    {
      cbA();
      a.a(this, "com/tencent/mm/plugin/collect/ui/DatePickerDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(64202);
      return;
      if (i == 2131302451) {
        this.pgp = 1;
      } else if (i == 2131298936) {
        this.pgp = 0;
      } else {
        ad.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[] { paramView.getClass().toString() });
      }
    }
  }
  
  public void setDatePickerMode(int paramInt)
  {
    AppMethodBeat.i(64204);
    this.pgp = paramInt;
    cbA();
    AppMethodBeat.o(64204);
  }
  
  public void setOnCancelBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64206);
    this.pgo.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64206);
  }
  
  public void setOnOkBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64205);
    this.pgn.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(64205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.DatePickerDialogView
 * JD-Core Version:    0.7.0.1
 */