package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends LinearLayout
{
  private ImageView kEm;
  private TextView lHT;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(201289);
    LayoutInflater.from(paramContext).inflate(2131496160, this);
    this.lHT = ((TextView)findViewById(2131298996));
    this.kEm = ((ImageView)findViewById(2131300874));
    AppMethodBeat.o(201289);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(201290);
    if (paramc == null)
    {
      this.lHT.setText(null);
      this.kEm.setImageDrawable(null);
      AppMethodBeat.o(201290);
      return;
    }
    this.lHT.setText(paramc.lHV);
    this.kEm.setImageResource(a.uf(paramc.mState));
    AppMethodBeat.o(201290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */