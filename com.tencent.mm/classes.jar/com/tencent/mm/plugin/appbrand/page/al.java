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

public final class al
  extends RelativeLayout
{
  TextView jVh;
  ImageView lIM;
  TextView nsb;
  Button nsc;
  ImageView nsd;
  
  public al(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(180353);
    paramContext = LayoutInflater.from(paramContext).inflate(2131493101, this);
    this.lIM = ((ImageView)paramContext.findViewById(2131302468));
    this.jVh = ((TextView)paramContext.findViewById(2131305208));
    this.nsb = ((TextView)paramContext.findViewById(2131299432));
    this.nsc = ((Button)paramContext.findViewById(2131297813));
    this.nsd = ((ImageView)paramContext.findViewById(2131305698));
    AppMethodBeat.o(180353);
  }
  
  public final void setJumpBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(180354);
    this.nsc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(180354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al
 * JD-Core Version:    0.7.0.1
 */