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
  private ImageView jFL;
  private TextView kFd;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194895);
    LayoutInflater.from(paramContext).inflate(2131496160, this);
    this.kFd = ((TextView)findViewById(2131298996));
    this.jFL = ((ImageView)findViewById(2131300874));
    AppMethodBeat.o(194895);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(194896);
    if (paramc == null)
    {
      this.kFd.setText(null);
      this.jFL.setImageDrawable(null);
      AppMethodBeat.o(194896);
      return;
    }
    this.kFd.setText(paramc.kFf);
    this.jFL.setImageResource(a.sF(paramc.mState));
    AppMethodBeat.o(194896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */