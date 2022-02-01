package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.a;
import com.tencent.luggage.a.b;
import com.tencent.luggage.a.e;
import com.tencent.luggage.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class VerticalStepView
  extends LinearLayout
  implements VerticalStepViewIndicator.a
{
  private RelativeLayout pQD;
  public VerticalStepViewIndicator pQE;
  public List<c> pQF;
  private int pQG;
  private int pQH;
  private int pQI;
  private int pyF;
  private TextView rR;
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208121);
    this.pQH = a.w(getContext(), a.b.uncompleted_text_color);
    this.pQI = a.w(getContext(), 17170443);
    this.pyF = 14;
    paramContext = LayoutInflater.from(getContext()).inflate(a.f.widget_vertical_stepsview, this);
    this.pQE = ((VerticalStepViewIndicator)paramContext.findViewById(a.e.steps_indicator));
    this.pQE.setOnDrawListener(this);
    this.pQD = ((RelativeLayout)paramContext.findViewById(a.e.rl_text_container));
    AppMethodBeat.o(208121);
  }
  
  public final void bZu()
  {
    AppMethodBeat.i(208124);
    if (this.pQD != null)
    {
      this.pQD.removeAllViews();
      List localList = this.pQE.getCircleCenterPointPositionList();
      if ((this.pQF != null) && (localList != null) && (localList.size() > 0))
      {
        int i = 0;
        if (i < this.pQF.size())
        {
          this.rR = new TextView(getContext());
          this.rR.setTextSize(2, this.pyF);
          this.rR.setText(((c)this.pQF.get(i)).pQC);
          this.rR.setY(((Float)localList.get(i)).floatValue() - this.pQE.getCircleRadius() / 2.0F);
          this.rR.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.pQG)
          {
            this.rR.setTypeface(null, 1);
            this.rR.setTextColor(this.pQI);
          }
          for (;;)
          {
            this.pQD.addView(this.rR);
            i += 1;
            break;
            this.rR.setTextColor(this.pQH);
          }
        }
      }
    }
    AppMethodBeat.o(208124);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208122);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(208122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */