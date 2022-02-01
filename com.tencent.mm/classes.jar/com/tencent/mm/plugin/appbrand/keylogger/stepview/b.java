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
  private ViewGroup gkW;
  private ImageView kgj;
  private LinearLayout lgv;
  private TextView lgw;
  private ViewGroup lgx;
  private Context mContext;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(201046);
    LayoutInflater.from(paramContext).inflate(2131496161, this);
    this.mContext = paramContext;
    this.lgv = ((LinearLayout)findViewById(2131298736));
    paramContext = this.lgv;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramContext.setOrientation(i);
      this.lgw = ((TextView)findViewById(2131298996));
      this.kgj = ((ImageView)findViewById(2131300874));
      this.gkW = ((ViewGroup)findViewById(2131304239));
      this.lgx = ((ViewGroup)findViewById(2131307197));
      AppMethodBeat.o(201046);
      return;
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(201047);
    this.lgv.addView(paramView);
    AppMethodBeat.o(201047);
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(201048);
    if (paramBoolean)
    {
      this.gkW.setBackground(this.mContext.getDrawable(2131234844));
      AppMethodBeat.o(201048);
      return;
    }
    this.gkW.setBackground(null);
    AppMethodBeat.o(201048);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(201049);
    if (paramc == null)
    {
      this.lgw.setText(null);
      this.kgj.setImageDrawable(null);
      this.lgx.setVisibility(8);
      AppMethodBeat.o(201049);
      return;
    }
    this.lgw.setText(paramc.lgy);
    this.kgj.setImageResource(a.tw(paramc.mState));
    this.lgx.setVisibility(0);
    AppMethodBeat.o(201049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */