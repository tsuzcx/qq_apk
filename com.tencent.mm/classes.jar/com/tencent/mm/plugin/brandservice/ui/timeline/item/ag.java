package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;

public class ag
  extends aj
{
  public LinearLayout pwA;
  public LinearLayout pwz;
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(5999);
    super.a(paramView, paramb);
    AppMethodBeat.o(5999);
  }
  
  public final void cne()
  {
    AppMethodBeat.i(6000);
    if (this.puO == null)
    {
      AppMethodBeat.o(6000);
      return;
    }
    this.gvv = ((ImageView)this.puO.findViewById(2131297134));
    this.pvG = ((TextView)this.puO.findViewById(2131305433));
    this.pxG = this.puO.findViewById(2131297589);
    this.timeTV = ((TextView)this.puO.findViewById(2131309101));
    this.pxF = this.puO.findViewById(2131297433);
    this.pwz = ((LinearLayout)this.puO.findViewById(2131297567));
    this.pwA = ((LinearLayout)this.puO.findViewById(2131297557));
    AppMethodBeat.o(6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ag
 * JD-Core Version:    0.7.0.1
 */