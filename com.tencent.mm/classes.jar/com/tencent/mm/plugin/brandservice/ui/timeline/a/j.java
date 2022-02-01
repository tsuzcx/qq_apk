package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;

public class j
  extends n
{
  public LinearLayout nBY;
  public LinearLayout nBZ;
  
  public final void a(View paramView, c paramc)
  {
    AppMethodBeat.i(5999);
    super.a(paramView, paramc);
    AppMethodBeat.o(5999);
  }
  
  public final void bKj()
  {
    AppMethodBeat.i(6000);
    if (this.nBh == null)
    {
      AppMethodBeat.o(6000);
      return;
    }
    this.fuY = ((ImageView)this.nBh.findViewById(2131297008));
    this.nBF = ((TextView)this.nBh.findViewById(2131302860));
    this.nCP = this.nBh.findViewById(2131297371);
    this.fAz = ((TextView)this.nBh.findViewById(2131305822));
    this.nCO = this.nBh.findViewById(2131297276);
    this.nBY = ((LinearLayout)this.nBh.findViewById(2131297356));
    this.nBZ = ((LinearLayout)this.nBh.findViewById(2131297346));
    AppMethodBeat.o(6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.j
 * JD-Core Version:    0.7.0.1
 */