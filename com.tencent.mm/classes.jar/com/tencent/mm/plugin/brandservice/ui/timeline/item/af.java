package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;

public class af
  extends ai
{
  public LinearLayout vLw;
  public LinearLayout vLx;
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(5999);
    super.a(paramView, paramb);
    AppMethodBeat.o(5999);
  }
  
  public final void ddU()
  {
    AppMethodBeat.i(6000);
    if (this.vJU == null)
    {
      AppMethodBeat.o(6000);
      return;
    }
    super.ddU();
    this.vLw = ((LinearLayout)this.vJU.findViewById(d.e.biz_time_line_new_tips_layout));
    this.vLx = ((LinearLayout)this.vJU.findViewById(d.e.biz_time_line_item_top));
    AppMethodBeat.o(6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.af
 * JD-Core Version:    0.7.0.1
 */