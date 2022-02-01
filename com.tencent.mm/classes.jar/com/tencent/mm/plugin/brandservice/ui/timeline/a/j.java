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
  public LinearLayout mZA;
  public LinearLayout mZB;
  
  public final void a(View paramView, c paramc)
  {
    AppMethodBeat.i(5999);
    super.a(paramView, paramc);
    AppMethodBeat.o(5999);
  }
  
  public final void bDa()
  {
    AppMethodBeat.i(6000);
    if (this.mYI == null)
    {
      AppMethodBeat.o(6000);
      return;
    }
    this.frr = ((ImageView)this.mYI.findViewById(2131297008));
    this.mZh = ((TextView)this.mYI.findViewById(2131302860));
    this.nar = this.mYI.findViewById(2131297371);
    this.fwS = ((TextView)this.mYI.findViewById(2131305822));
    this.naq = this.mYI.findViewById(2131297276);
    this.mZA = ((LinearLayout)this.mYI.findViewById(2131297356));
    this.mZB = ((LinearLayout)this.mYI.findViewById(2131297346));
    AppMethodBeat.o(6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.j
 * JD-Core Version:    0.7.0.1
 */