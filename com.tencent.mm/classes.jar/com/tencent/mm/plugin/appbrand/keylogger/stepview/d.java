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
  private ImageView kgj;
  private TextView lgw;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(201050);
    LayoutInflater.from(paramContext).inflate(2131496160, this);
    this.lgw = ((TextView)findViewById(2131298996));
    this.kgj = ((ImageView)findViewById(2131300874));
    AppMethodBeat.o(201050);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(201051);
    if (paramc == null)
    {
      this.lgw.setText(null);
      this.kgj.setImageDrawable(null);
      AppMethodBeat.o(201051);
      return;
    }
    this.lgw.setText(paramc.lgy);
    this.kgj.setImageResource(a.tw(paramc.mState));
    AppMethodBeat.o(201051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */