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
  private ImageView kAX;
  private TextView lDu;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(187722);
    LayoutInflater.from(paramContext).inflate(2131496160, this);
    this.lDu = ((TextView)findViewById(2131298996));
    this.kAX = ((ImageView)findViewById(2131300874));
    AppMethodBeat.o(187722);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(187723);
    if (paramc == null)
    {
      this.lDu.setText(null);
      this.kAX.setImageDrawable(null);
      AppMethodBeat.o(187723);
      return;
    }
    this.lDu.setText(paramc.lDw);
    this.kAX.setImageResource(a.tZ(paramc.mState));
    AppMethodBeat.o(187723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */