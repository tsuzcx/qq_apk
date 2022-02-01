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
  private int lDA;
  private int lDB;
  private int lDC;
  private RelativeLayout lDx;
  public VerticalStepViewIndicator lDy;
  public List<c> lDz;
  private int mTextSize;
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187724);
    this.lDB = b.n(getContext(), 2131101194);
    this.lDC = b.n(getContext(), 17170443);
    this.mTextSize = 14;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496163, this);
    this.lDy = ((VerticalStepViewIndicator)paramContext.findViewById(2131307251));
    this.lDy.setOnDrawListener(this);
    this.lDx = ((RelativeLayout)paramContext.findViewById(2131307238));
    AppMethodBeat.o(187724);
  }
  
  public final void bqH()
  {
    AppMethodBeat.i(187726);
    if (this.lDx != null)
    {
      this.lDx.removeAllViews();
      List localList = this.lDy.getCircleCenterPointPositionList();
      if ((this.lDz != null) && (localList != null) && (localList.size() > 0))
      {
        int i = 0;
        if (i < this.lDz.size())
        {
          this.Wf = new TextView(getContext());
          this.Wf.setTextSize(2, this.mTextSize);
          this.Wf.setText(((c)this.lDz.get(i)).lDw);
          this.Wf.setY(((Float)localList.get(i)).floatValue() - this.lDy.getCircleRadius() / 2.0F);
          this.Wf.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.lDA)
          {
            this.Wf.setTypeface(null, 1);
            this.Wf.setTextColor(this.lDC);
          }
          for (;;)
          {
            this.lDx.addView(this.Wf);
            i += 1;
            break;
            this.Wf.setTextColor(this.lDB);
          }
        }
      }
    }
    AppMethodBeat.o(187726);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187725);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(187725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */