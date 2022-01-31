package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class n$1
  implements e.a
{
  n$1(n paramn, q paramq, int paramInt) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(14275);
    this.jYQ.jXN = true;
    this.jYQ.jXA.setTextColor(-419430401);
    if (this.jYQ.jXH != null) {
      this.jYQ.jXH.setVisibility(0);
    }
    if (this.jYQ.mCount > 1) {
      this.jYQ.jXI.setTextColor(this.jYQ.mContext.getResources().getColor(2131690709));
    }
    if (this.jYQ.jXO > 0) {
      this.jYQ.jXM.setBackgroundResource(2130837982);
    }
    this.jYQ.jYO.setTextColor(this.jYQ.mContext.getResources().getColor(2131690709));
    this.jYQ.jXV.jVJ.m(this.jMz.field_msgId, this.lU);
    AppMethodBeat.o(14275);
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.n.1
 * JD-Core Version:    0.7.0.1
 */