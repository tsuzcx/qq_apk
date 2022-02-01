package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends LinearLayout
{
  private ViewGroup gEG;
  private ImageView kAX;
  private LinearLayout lDt;
  private TextView lDu;
  private ViewGroup lDv;
  private Context mContext;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(187718);
    LayoutInflater.from(paramContext).inflate(2131496161, this);
    this.mContext = paramContext;
    this.lDt = ((LinearLayout)findViewById(2131298736));
    paramContext = this.lDt;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramContext.setOrientation(i);
      this.lDu = ((TextView)findViewById(2131298996));
      this.kAX = ((ImageView)findViewById(2131300874));
      this.gEG = ((ViewGroup)findViewById(2131304239));
      this.lDv = ((ViewGroup)findViewById(2131307197));
      AppMethodBeat.o(187718);
      return;
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(187719);
    this.lDt.addView(paramView);
    AppMethodBeat.o(187719);
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(187720);
    if (paramBoolean)
    {
      this.gEG.setBackground(this.mContext.getDrawable(2131234844));
      AppMethodBeat.o(187720);
      return;
    }
    this.gEG.setBackground(null);
    AppMethodBeat.o(187720);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(187721);
    if (paramc == null)
    {
      this.lDu.setText(null);
      this.kAX.setImageDrawable(null);
      this.lDv.setVisibility(8);
      AppMethodBeat.o(187721);
      return;
    }
    this.lDu.setText(paramc.lDw);
    this.kAX.setImageResource(a.tZ(paramc.mState));
    this.lDv.setVisibility(0);
    AppMethodBeat.o(187721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */