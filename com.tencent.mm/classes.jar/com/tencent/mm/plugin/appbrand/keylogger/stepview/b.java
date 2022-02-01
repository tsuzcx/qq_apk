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
  private ViewGroup gHn;
  private ImageView kEm;
  private LinearLayout lHS;
  private TextView lHT;
  private ViewGroup lHU;
  private Context mContext;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(201285);
    LayoutInflater.from(paramContext).inflate(2131496161, this);
    this.mContext = paramContext;
    this.lHS = ((LinearLayout)findViewById(2131298736));
    paramContext = this.lHS;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramContext.setOrientation(i);
      this.lHT = ((TextView)findViewById(2131298996));
      this.kEm = ((ImageView)findViewById(2131300874));
      this.gHn = ((ViewGroup)findViewById(2131304239));
      this.lHU = ((ViewGroup)findViewById(2131307197));
      AppMethodBeat.o(201285);
      return;
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(201286);
    this.lHS.addView(paramView);
    AppMethodBeat.o(201286);
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(201287);
    if (paramBoolean)
    {
      this.gHn.setBackground(this.mContext.getDrawable(2131234844));
      AppMethodBeat.o(201287);
      return;
    }
    this.gHn.setBackground(null);
    AppMethodBeat.o(201287);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(201288);
    if (paramc == null)
    {
      this.lHT.setText(null);
      this.kEm.setImageDrawable(null);
      this.lHU.setVisibility(8);
      AppMethodBeat.o(201288);
      return;
    }
    this.lHT.setText(paramc.lHV);
    this.kEm.setImageResource(a.uf(paramc.mState));
    this.lHU.setVisibility(0);
    AppMethodBeat.o(201288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */