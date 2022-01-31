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
import com.tencent.mm.ui.widget.MMNeat7extView;

final class l$1
  implements e.a
{
  l$1(l paraml, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(14272);
    this.jYM.jXN = true;
    this.jYM.jXA.setTextColor(-419430401);
    if (this.jYM.jXH != null) {
      this.jYM.jXH.setVisibility(0);
    }
    if (!l.b(this.jYM.mCount, this.jYL))
    {
      this.jYM.jXI.setTextColor(this.jYM.mContext.getResources().getColor(2131690709));
      if (this.jYM.b(this.jYL)) {
        this.jYM.jXM.setBackgroundResource(2130837981);
      }
    }
    for (;;)
    {
      this.jYM.jXV.jVJ.m(this.jMz.field_msgId, this.lU);
      AppMethodBeat.o(14272);
      return;
      this.jYM.jXM.setBackgroundResource(2130837982);
      continue;
      if (this.jYM.jXO > 0) {
        this.jYM.jXM.setBackgroundResource(2130837982);
      }
    }
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.l.1
 * JD-Core Version:    0.7.0.1
 */