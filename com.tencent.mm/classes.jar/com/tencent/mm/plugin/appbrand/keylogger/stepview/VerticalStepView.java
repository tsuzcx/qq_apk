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
  private TextView Tu;
  private RelativeLayout kFg;
  public VerticalStepViewIndicator kFh;
  public List<c> kFi;
  private int kFj;
  private int kFk;
  private int kFl;
  private int mTextSize;
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194897);
    this.kFk = b.n(getContext(), 2131101194);
    this.kFl = b.n(getContext(), 17170443);
    this.mTextSize = 14;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496163, this);
    this.kFh = ((VerticalStepViewIndicator)paramContext.findViewById(2131307251));
    this.kFh.setOnDrawListener(this);
    this.kFg = ((RelativeLayout)paramContext.findViewById(2131307238));
    AppMethodBeat.o(194897);
  }
  
  public final void bgc()
  {
    AppMethodBeat.i(194899);
    if (this.kFg != null)
    {
      this.kFg.removeAllViews();
      List localList = this.kFh.getCircleCenterPointPositionList();
      if ((this.kFi != null) && (localList != null) && (localList.size() > 0))
      {
        int i = 0;
        if (i < this.kFi.size())
        {
          this.Tu = new TextView(getContext());
          this.Tu.setTextSize(2, this.mTextSize);
          this.Tu.setText(((c)this.kFi.get(i)).kFf);
          this.Tu.setY(((Float)localList.get(i)).floatValue() - this.kFh.getCircleRadius() / 2.0F);
          this.Tu.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.kFj)
          {
            this.Tu.setTypeface(null, 1);
            this.Tu.setTextColor(this.kFl);
          }
          for (;;)
          {
            this.kFg.addView(this.Tu);
            i += 1;
            break;
            this.Tu.setTextColor(this.kFk);
          }
        }
      }
    }
    AppMethodBeat.o(194899);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194898);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(194898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */