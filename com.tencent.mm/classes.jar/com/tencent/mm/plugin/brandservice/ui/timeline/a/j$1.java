package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;

final class j$1
  implements e.a
{
  j$1(j paramj, q paramq, int paramInt) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(14270);
    this.jYB.jXG.setVisibility(0);
    this.jYB.jXA.setTextColor(this.jYB.mContext.getResources().getColor(2131690709));
    this.jYB.iTH.setBackgroundResource(2131230994);
    this.jYB.jXV.jVJ.m(this.jMz.field_msgId, this.lU);
    AppMethodBeat.o(14270);
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.j.1
 * JD-Core Version:    0.7.0.1
 */