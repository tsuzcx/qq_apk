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
  private TextView Ws;
  private int mAk;
  private RelativeLayout mPK;
  public VerticalStepViewIndicator mPL;
  public List<c> mPM;
  private int mPN;
  private int mPO;
  private int mPP;
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(221336);
    this.mPO = b.n(getContext(), 2131101299);
    this.mPP = b.n(getContext(), 17170443);
    this.mAk = 14;
    paramContext = LayoutInflater.from(getContext()).inflate(2131497103, this);
    this.mPL = ((VerticalStepViewIndicator)paramContext.findViewById(2131308417));
    this.mPL.setOnDrawListener(this);
    this.mPK = ((RelativeLayout)paramContext.findViewById(2131307121));
    AppMethodBeat.o(221336);
  }
  
  public final void bNc()
  {
    AppMethodBeat.i(221338);
    if (this.mPK != null)
    {
      this.mPK.removeAllViews();
      List localList = this.mPL.getCircleCenterPointPositionList();
      if ((this.mPM != null) && (localList != null) && (localList.size() > 0))
      {
        int i = 0;
        if (i < this.mPM.size())
        {
          this.Ws = new TextView(getContext());
          this.Ws.setTextSize(2, this.mAk);
          this.Ws.setText(((c)this.mPM.get(i)).mPJ);
          this.Ws.setY(((Float)localList.get(i)).floatValue() - this.mPL.getCircleRadius() / 2.0F);
          this.Ws.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.mPN)
          {
            this.Ws.setTypeface(null, 1);
            this.Ws.setTextColor(this.mPP);
          }
          for (;;)
          {
            this.mPK.addView(this.Ws);
            i += 1;
            break;
            this.Ws.setTextColor(this.mPO);
          }
        }
      }
    }
    AppMethodBeat.o(221338);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221337);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(221337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */