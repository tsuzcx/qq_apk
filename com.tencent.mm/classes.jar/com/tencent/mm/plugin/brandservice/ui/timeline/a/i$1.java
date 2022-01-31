package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;

final class i$1
  implements e.a
{
  i$1(i parami, q paramq, int paramInt) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(14268);
    this.jYz.jXG.setVisibility(0);
    if ((this.jMz.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.aZX())) {
      this.jYz.jXy.setImageResource(2130838314);
    }
    for (;;)
    {
      this.jYz.jXV.jVJ.m(this.jMz.field_msgId, this.lU);
      AppMethodBeat.o(14268);
      return;
      this.jYz.jXy.setImageResource(2130838315);
    }
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.i.1
 * JD-Core Version:    0.7.0.1
 */