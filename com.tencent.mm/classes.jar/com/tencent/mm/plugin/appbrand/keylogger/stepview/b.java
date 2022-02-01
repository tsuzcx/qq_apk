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
  private ViewGroup hub;
  private TextView jVn;
  private ImageView lIM;
  private Context mContext;
  private LinearLayout mPH;
  private ViewGroup mPI;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(221330);
    LayoutInflater.from(paramContext).inflate(2131496821, this);
    this.mContext = paramContext;
    this.mPH = ((LinearLayout)findViewById(2131299174));
    paramContext = this.mPH;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramContext.setOrientation(i);
      this.jVn = ((TextView)findViewById(2131299495));
      this.lIM = ((ImageView)findViewById(2131302468));
      this.hub = ((ViewGroup)findViewById(2131307157));
      this.mPI = ((ViewGroup)findViewById(2131302190));
      AppMethodBeat.o(221330);
      return;
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(221331);
    this.mPH.addView(paramView);
    AppMethodBeat.o(221331);
  }
  
  public final void setHasBorder(boolean paramBoolean)
  {
    AppMethodBeat.i(221332);
    if (paramBoolean)
    {
      this.hub.setBackground(this.mContext.getDrawable(2131235051));
      AppMethodBeat.o(221332);
      return;
    }
    this.hub.setBackground(null);
    AppMethodBeat.o(221332);
  }
  
  public final void setStep(c paramc)
  {
    AppMethodBeat.i(221333);
    if (paramc == null)
    {
      this.jVn.setText(null);
      this.lIM.setImageDrawable(null);
      this.mPI.setVisibility(8);
      AppMethodBeat.o(221333);
      return;
    }
    this.jVn.setText(paramc.mPJ);
    this.lIM.setImageResource(a.ye(paramc.mState));
    this.mPI.setVisibility(0);
    AppMethodBeat.o(221333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.b
 * JD-Core Version:    0.7.0.1
 */