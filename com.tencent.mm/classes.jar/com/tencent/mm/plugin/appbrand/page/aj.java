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

public final class aj
  extends RelativeLayout
{
  ImageView kgj;
  TextView kgk;
  TextView lDL;
  Button lDM;
  ImageView lDN;
  
  public aj(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(180353);
    paramContext = LayoutInflater.from(paramContext).inflate(2131493062, this);
    this.kgj = ((ImageView)paramContext.findViewById(2131300874));
    this.kgk = ((TextView)paramContext.findViewById(2131302654));
    this.lDL = ((TextView)paramContext.findViewById(2131298942));
    this.lDM = ((Button)paramContext.findViewById(2131297574));
    this.lDN = ((ImageView)paramContext.findViewById(2131307218));
    AppMethodBeat.o(180353);
  }
  
  public final void setJumpBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(180354);
    this.lDM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(180354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */