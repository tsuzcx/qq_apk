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
  private TextView jVn;
  private ImageView lIM;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(221334);
    LayoutInflater.from(paramContext).inflate(2131496820, this);
    this.jVn = ((TextView)findViewById(2131299495));
    this.lIM = ((ImageView)findViewById(2131302468));
    AppMethodBeat.o(221334);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(221335);
    if (paramc == null)
    {
      this.jVn.setText(null);
      this.lIM.setImageDrawable(null);
      AppMethodBeat.o(221335);
      return;
    }
    this.jVn.setText(paramc.mPJ);
    this.lIM.setImageResource(a.ye(paramc.mState));
    AppMethodBeat.o(221335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.d
 * JD-Core Version:    0.7.0.1
 */