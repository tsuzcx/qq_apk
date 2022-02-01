package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;

public class ai
  extends al
{
  public LinearLayout sFV;
  public LinearLayout sFW;
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(5999);
    super.a(paramView, paramb);
    AppMethodBeat.o(5999);
  }
  
  public final void cAQ()
  {
    AppMethodBeat.i(6000);
    if (this.sEi == null)
    {
      AppMethodBeat.o(6000);
      return;
    }
    super.cAQ();
    this.sFV = ((LinearLayout)this.sEi.findViewById(d.e.sqY));
    this.sFW = ((LinearLayout)this.sEi.findViewById(d.e.sqO));
    AppMethodBeat.o(6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
 * JD-Core Version:    0.7.0.1
 */