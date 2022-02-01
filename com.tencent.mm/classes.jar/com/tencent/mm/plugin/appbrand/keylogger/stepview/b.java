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
  private ViewGroup ggq;
  private ImageView jFL;
  private LinearLayout kFc;
  private TextView kFd;
  private ViewGroup kFe;
  private Context mContext;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(194891);
    LayoutInflater.from(paramContext).inflate(2131496161, this);
    this.mContext = paramContext;
    this.kFc = ((LinearLayout)findViewById(2131298736));
    paramContext = this.kFc;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramContext.setOrientation(i);
      this.kFd = ((TextView)findViewById(2131298996));
      this.jFL = ((ImageView)findViewById(2131300874));
      this.ggq = ((ViewGroup)findViewById(2131304239));
      this.kFe = ((ViewGroup)findViewById(2131307197));
      AppMethodBeat.o(194891);
      return;
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(194892);
    this.kFc.addView(paramView);
    AppMethodBeat.o(194892);
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(194893);
    if (paramBoolean)
    {
      this.ggq.setBackground(this.mContext.getDrawable(2131234844));
      AppMethodBeat.o(194893);
      return;
    }
    this.ggq.setBackground(null);
    AppMethodBeat.o(194893);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(194894);
    if (paramc == null)
    {
      this.kFd.setText(null);
      this.jFL.setImageDrawable(null);
      this.kFe.setVisibility(8);
      AppMethodBeat.o(194894);
      return;
    }
    this.kFd.setText(paramc.kFf);
    this.jFL.setImageResource(a.sF(paramc.mState));
    this.kFe.setVisibility(0);
    AppMethodBeat.o(194894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */