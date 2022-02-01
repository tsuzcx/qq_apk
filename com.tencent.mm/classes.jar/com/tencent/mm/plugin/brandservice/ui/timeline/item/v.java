package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;

public class v
  extends z
{
  public LinearLayout oeH;
  public LinearLayout oeI;
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(5999);
    super.a(paramView, paramb);
    AppMethodBeat.o(5999);
  }
  
  public final void bOL()
  {
    AppMethodBeat.i(6000);
    if (this.odh == null)
    {
      AppMethodBeat.o(6000);
      return;
    }
    this.fOf = ((ImageView)this.odh.findViewById(2131297008));
    this.odU = ((TextView)this.odh.findViewById(2131302860));
    this.ofo = this.odh.findViewById(2131297371);
    this.fTP = ((TextView)this.odh.findViewById(2131305822));
    this.ofn = this.odh.findViewById(2131297276);
    this.oeH = ((LinearLayout)this.odh.findViewById(2131297356));
    this.oeI = ((LinearLayout)this.odh.findViewById(2131297346));
    AppMethodBeat.o(6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.v
 * JD-Core Version:    0.7.0.1
 */