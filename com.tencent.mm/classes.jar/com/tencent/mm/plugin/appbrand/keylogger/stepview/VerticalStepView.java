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
  private TextView Up;
  public VerticalStepViewIndicator lgA;
  public List<c> lgB;
  private int lgC;
  private int lgD;
  private int lgE;
  private RelativeLayout lgz;
  private int mTextSize;
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201052);
    this.lgD = b.n(getContext(), 2131101194);
    this.lgE = b.n(getContext(), 17170443);
    this.mTextSize = 14;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496163, this);
    this.lgA = ((VerticalStepViewIndicator)paramContext.findViewById(2131307251));
    this.lgA.setOnDrawListener(this);
    this.lgz = ((RelativeLayout)paramContext.findViewById(2131307238));
    AppMethodBeat.o(201052);
  }
  
  public final void bmW()
  {
    AppMethodBeat.i(201054);
    if (this.lgz != null)
    {
      this.lgz.removeAllViews();
      List localList = this.lgA.getCircleCenterPointPositionList();
      if ((this.lgB != null) && (localList != null) && (localList.size() > 0))
      {
        int i = 0;
        if (i < this.lgB.size())
        {
          this.Up = new TextView(getContext());
          this.Up.setTextSize(2, this.mTextSize);
          this.Up.setText(((c)this.lgB.get(i)).lgy);
          this.Up.setY(((Float)localList.get(i)).floatValue() - this.lgA.getCircleRadius() / 2.0F);
          this.Up.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.lgC)
          {
            this.Up.setTypeface(null, 1);
            this.Up.setTextColor(this.lgE);
          }
          for (;;)
          {
            this.lgz.addView(this.Up);
            i += 1;
            break;
            this.Up.setTextColor(this.lgD);
          }
        }
      }
    }
    AppMethodBeat.o(201054);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201053);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(201053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */