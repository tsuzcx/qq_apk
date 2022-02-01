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
  private int sDK;
  private TextView sQ;
  private RelativeLayout sVc;
  public VerticalStepViewIndicator sVd;
  public List<c> sVe;
  private int sVf;
  private int sVg;
  private int sVh;
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(319471);
    this.sVg = a.w(getContext(), a.b.uncompleted_text_color);
    this.sVh = a.w(getContext(), 17170443);
    this.sDK = 14;
    paramContext = LayoutInflater.from(getContext()).inflate(a.f.widget_vertical_stepsview, this);
    this.sVd = ((VerticalStepViewIndicator)paramContext.findViewById(a.e.steps_indicator));
    this.sVd.setOnDrawListener(this);
    this.sVc = ((RelativeLayout)paramContext.findViewById(a.e.rl_text_container));
    AppMethodBeat.o(319471);
  }
  
  public final void czF()
  {
    AppMethodBeat.i(319489);
    if (this.sVc != null)
    {
      this.sVc.removeAllViews();
      List localList = this.sVd.getCircleCenterPointPositionList();
      if ((this.sVe != null) && (localList != null) && (localList.size() > 0))
      {
        int i = 0;
        if (i < this.sVe.size())
        {
          this.sQ = new TextView(getContext());
          this.sQ.setTextSize(2, this.sDK);
          this.sQ.setText(((c)this.sVe.get(i)).sVb);
          this.sQ.setY(((Float)localList.get(i)).floatValue() - this.sVd.getCircleRadius() / 2.0F);
          this.sQ.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.sVf)
          {
            this.sQ.setTypeface(null, 1);
            this.sQ.setTextColor(this.sVh);
          }
          for (;;)
          {
            this.sVc.addView(this.sQ);
            i += 1;
            break;
            this.sQ.setTextColor(this.sVg);
          }
        }
      }
    }
    AppMethodBeat.o(319489);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(319478);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(319478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */