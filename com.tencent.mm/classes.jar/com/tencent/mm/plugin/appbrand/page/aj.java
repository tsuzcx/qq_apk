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
  ImageView kAX;
  TextView kAY;
  TextView mdo;
  Button mdp;
  ImageView mdq;
  
  public aj(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(180353);
    paramContext = LayoutInflater.from(paramContext).inflate(2131493062, this);
    this.kAX = ((ImageView)paramContext.findViewById(2131300874));
    this.kAY = ((TextView)paramContext.findViewById(2131302654));
    this.mdo = ((TextView)paramContext.findViewById(2131298942));
    this.mdp = ((Button)paramContext.findViewById(2131297574));
    this.mdq = ((ImageView)paramContext.findViewById(2131307218));
    AppMethodBeat.o(180353);
  }
  
  public final void setJumpBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(180354);
    this.mdp.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(180354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */