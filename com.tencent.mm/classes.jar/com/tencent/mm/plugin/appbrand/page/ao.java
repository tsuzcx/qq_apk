package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends RelativeLayout
{
  ImageView jFL;
  TextView jFM;
  TextView ldU;
  Button ldV;
  ImageView ldW;
  
  public ao(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(180353);
    paramContext = LayoutInflater.from(paramContext).inflate(2131493062, this);
    this.jFL = ((ImageView)paramContext.findViewById(2131300874));
    this.jFM = ((TextView)paramContext.findViewById(2131302654));
    this.ldU = ((TextView)paramContext.findViewById(2131298942));
    this.ldV = ((Button)paramContext.findViewById(2131297574));
    this.ldW = ((ImageView)paramContext.findViewById(2131307218));
    AppMethodBeat.o(180353);
  }
  
  public final void setJumpBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(180354);
    this.ldV.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(180354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ao
 * JD-Core Version:    0.7.0.1
 */