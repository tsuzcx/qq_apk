package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.a.d;
import com.tencent.luggage.a.e;
import com.tencent.luggage.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends LinearLayout
{
  private ViewGroup kfX;
  private Context mContext;
  private TextView mMA;
  private ImageView oFa;
  private LinearLayout pQA;
  private ViewGroup pQB;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(208996);
    LayoutInflater.from(paramContext).inflate(a.f.view_step_group, this);
    this.mContext = paramContext;
    this.pQA = ((LinearLayout)findViewById(a.e.container));
    paramContext = this.pQA;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramContext.setOrientation(i);
      this.mMA = ((TextView)findViewById(a.e.desc));
      this.oFa = ((ImageView)findViewById(a.e.icon));
      this.kfX = ((ViewGroup)findViewById(a.e.root));
      this.pQB = ((ViewGroup)findViewById(a.e.group_desc));
      AppMethodBeat.o(208996);
      return;
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(208997);
    this.pQA.addView(paramView);
    AppMethodBeat.o(208997);
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(208998);
    if (paramBoolean)
    {
      this.kfX.setBackground(this.mContext.getDrawable(a.d.step_diagram_border));
      AppMethodBeat.o(208998);
      return;
    }
    this.kfX.setBackground(null);
    AppMethodBeat.o(208998);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(209000);
    if (paramc == null)
    {
      this.mMA.setText(null);
      this.oFa.setImageDrawable(null);
      this.pQB.setVisibility(8);
      AppMethodBeat.o(209000);
      return;
    }
    this.mMA.setText(paramc.pQC);
    this.oFa.setImageResource(a.BE(paramc.mState));
    this.pQB.setVisibility(0);
    AppMethodBeat.o(209000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */