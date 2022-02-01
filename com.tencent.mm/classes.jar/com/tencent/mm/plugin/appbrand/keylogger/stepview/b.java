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
  private LinearLayout mContainer;
  private Context mContext;
  private ViewGroup mGv;
  private TextView pJi;
  private ImageView rIe;
  private ViewGroup sVa;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(319463);
    LayoutInflater.from(paramContext).inflate(a.f.view_step_group, this);
    this.mContext = paramContext;
    this.mContainer = ((LinearLayout)findViewById(a.e.container));
    paramContext = this.mContainer;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramContext.setOrientation(i);
      this.pJi = ((TextView)findViewById(a.e.desc));
      this.rIe = ((ImageView)findViewById(a.e.icon));
      this.mGv = ((ViewGroup)findViewById(a.e.root));
      this.sVa = ((ViewGroup)findViewById(a.e.group_desc));
      AppMethodBeat.o(319463);
      return;
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(319472);
    this.mContainer.addView(paramView);
    AppMethodBeat.o(319472);
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(319479);
    if (paramBoolean)
    {
      this.mGv.setBackground(this.mContext.getDrawable(a.d.step_diagram_border));
      AppMethodBeat.o(319479);
      return;
    }
    this.mGv.setBackground(null);
    AppMethodBeat.o(319479);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(319487);
    if (paramc == null)
    {
      this.pJi.setText(null);
      this.rIe.setImageDrawable(null);
      this.sVa.setVisibility(8);
      AppMethodBeat.o(319487);
      return;
    }
    this.pJi.setText(paramc.sVb);
    this.rIe.setImageResource(a.BS(paramc.mState));
    this.sVa.setVisibility(0);
    AppMethodBeat.o(319487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */