package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;

final class k$1
  implements e.a
{
  k$1(k paramk, boolean paramBoolean, q paramq, int paramInt) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(152639);
    this.jYJ.jXN = true;
    if (this.jYJ.jYE != null) {
      this.jYJ.jYE.setImageResource(2131230994);
    }
    if (this.jYJ.jXH != null) {
      this.jYJ.jXH.setVisibility(0);
    }
    View localView;
    if (this.jYJ.jYD != null)
    {
      localView = this.jYJ.jYD;
      if (!this.jYH) {
        break label151;
      }
    }
    label151:
    for (int i = 2130837981;; i = 2130837982)
    {
      localView.setBackgroundResource(i);
      if (this.jYI == 0)
      {
        this.jYJ.jXA.setTextColor(this.jYJ.mContext.getResources().getColor(2131690709));
        this.jYJ.jXV.jVJ.m(this.jMz.field_msgId, this.lU);
      }
      AppMethodBeat.o(152639);
      return;
    }
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.k.1
 * JD-Core Version:    0.7.0.1
 */