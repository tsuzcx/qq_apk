package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class VerticalStepView
  extends LinearLayout
  implements VerticalStepViewIndicator.a
{
  private TextView Wf;
  private RelativeLayout lHW;
  public VerticalStepViewIndicator lHX;
  public List<c> lHY;
  private int lHZ;
  private int lIa;
  private int lIb;
  private int mTextSize;
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201291);
    this.lIa = b.n(getContext(), 2131101194);
    this.lIb = b.n(getContext(), 17170443);
    this.mTextSize = 14;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496163, this);
    this.lHX = ((VerticalStepViewIndicator)paramContext.findViewById(2131307251));
    this.lHX.setOnDrawListener(this);
    this.lHW = ((RelativeLayout)paramContext.findViewById(2131307238));
    AppMethodBeat.o(201291);
  }
  
  public final void brr()
  {
    AppMethodBeat.i(201293);
    if (this.lHW != null)
    {
      this.lHW.removeAllViews();
      List localList = this.lHX.getCircleCenterPointPositionList();
      if ((this.lHY != null) && (localList != null) && (localList.size() > 0))
      {
        int i = 0;
        if (i < this.lHY.size())
        {
          this.Wf = new TextView(getContext());
          this.Wf.setTextSize(2, this.mTextSize);
          this.Wf.setText(((c)this.lHY.get(i)).lHV);
          this.Wf.setY(((Float)localList.get(i)).floatValue() - this.lHX.getCircleRadius() / 2.0F);
          this.Wf.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.lHZ)
          {
            this.Wf.setTypeface(null, 1);
            this.Wf.setTextColor(this.lIb);
          }
          for (;;)
          {
            this.lHW.addView(this.Wf);
            i += 1;
            break;
            this.Wf.setTextColor(this.lIa);
          }
        }
      }
    }
    AppMethodBeat.o(201293);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201292);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(201292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */