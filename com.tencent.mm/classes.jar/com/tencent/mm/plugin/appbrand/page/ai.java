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

public final class ai
  extends RelativeLayout
{
  ImageView kEm;
  TextView kEn;
  TextView mhG;
  Button mhH;
  ImageView mhI;
  
  public ai(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(180353);
    paramContext = LayoutInflater.from(paramContext).inflate(2131493062, this);
    this.kEm = ((ImageView)paramContext.findViewById(2131300874));
    this.kEn = ((TextView)paramContext.findViewById(2131302654));
    this.mhG = ((TextView)paramContext.findViewById(2131298942));
    this.mhH = ((Button)paramContext.findViewById(2131297574));
    this.mhI = ((ImageView)paramContext.findViewById(2131307218));
    AppMethodBeat.o(180353);
  }
  
  public final void setJumpBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(180354);
    this.mhH.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(180354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ai
 * JD-Core Version:    0.7.0.1
 */