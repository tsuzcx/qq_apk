package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.a.e;
import com.tencent.luggage.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends LinearLayout
{
  private TextView pJi;
  private ImageView rIe;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(319461);
    LayoutInflater.from(paramContext).inflate(a.f.view_step, this);
    this.pJi = ((TextView)findViewById(a.e.desc));
    this.rIe = ((ImageView)findViewById(a.e.icon));
    AppMethodBeat.o(319461);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(319465);
    if (paramc == null)
    {
      this.pJi.setText(null);
      this.rIe.setImageDrawable(null);
      AppMethodBeat.o(319465);
      return;
    }
    this.pJi.setText(paramc.sVb);
    this.rIe.setImageResource(a.BS(paramc.mState));
    AppMethodBeat.o(319465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */