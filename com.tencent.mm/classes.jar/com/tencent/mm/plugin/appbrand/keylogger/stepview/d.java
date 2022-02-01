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
  private TextView mMA;
  private ImageView oFa;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(208501);
    LayoutInflater.from(paramContext).inflate(a.f.view_step, this);
    this.mMA = ((TextView)findViewById(a.e.desc));
    this.oFa = ((ImageView)findViewById(a.e.icon));
    AppMethodBeat.o(208501);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(208502);
    if (paramc == null)
    {
      this.mMA.setText(null);
      this.oFa.setImageDrawable(null);
      AppMethodBeat.o(208502);
      return;
    }
    this.mMA.setText(paramc.pQC);
    this.oFa.setImageResource(a.BE(paramc.mState));
    AppMethodBeat.o(208502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */