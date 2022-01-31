package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class l
  extends c
{
  public ImageView jXx;
  public RelativeLayout jYK;
  
  public final void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(152646);
    super.a(paramInt1, paramq, paramq1, paramInt2, paramp);
    this.mCount = paramInt1;
    this.jXN = false;
    this.jXH.setVisibility(8);
    dd(this.jYK);
    dd(this.jXx);
    this.jXx.setVisibility(0);
    this.jXI.setTextColor(this.mContext.getResources().getColor(2131690208));
    this.jXM.setBackgroundResource(2130839676);
    this.jXA.setTextColor(this.mContext.getResources().getColor(2131690208));
    int i = com.tencent.mm.cb.a.gw(this.mContext);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.a.jVx;
    this.jXV.jVJ.a(paramq.fjJ, this.jXx, i - j, com.tencent.mm.plugin.brandservice.ui.timeline.a.jVt, new l.1(this, paramq, paramq1, paramInt2), b(paramq));
    a(this.mCount, paramq);
    label234:
    com.tencent.mm.plugin.brandservice.ui.timeline.a locala;
    View localView;
    if (b(this.mCount, paramq))
    {
      this.jXW.setPadding(this.jXW.getPaddingLeft(), 0, this.jXW.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.a.jVw);
      if (!b(paramq)) {
        break label310;
      }
      this.jXH.setBackgroundResource(2130837955);
      this.jXW.setBackgroundResource(2130837960);
      a(this, paramq1, paramq);
      locala = this.jXV;
      localView = this.jXW;
      if (paramInt1 <= 1) {
        break label354;
      }
    }
    label310:
    label354:
    for (boolean bool = true;; bool = false)
    {
      locala.a(paramq, paramq1, paramInt2, paramp, localView, bool, 0);
      AppMethodBeat.o(152646);
      return;
      this.jXW.setPadding(this.jXW.getPaddingLeft(), 0, this.jXW.getPaddingRight(), 0);
      break;
      this.jXH.setBackgroundResource(2130837957);
      if (b(this.mCount, paramq))
      {
        this.jXW.setBackgroundResource(2130837960);
        break label234;
      }
      this.jXW.setBackgroundResource(2130837966);
      break label234;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14273);
    super.a(paramView, parama);
    if (this.jXr != null)
    {
      AppMethodBeat.o(14273);
      return;
    }
    parama = (ViewStub)paramView.findViewById(2131821878);
    if (parama == null)
    {
      AppMethodBeat.o(14273);
      return;
    }
    parama.inflate();
    this.jXr = paramView.findViewById(2131821905);
    this.jXW = paramView.findViewById(2131821906);
    aWY();
    this.jXx = ((ImageView)this.jXr.findViewById(2131821891));
    this.jYK = ((RelativeLayout)this.jXr.findViewById(2131821907));
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821212));
    this.jXG = ((ImageView)this.jXr.findViewById(2131821917));
    this.jXH = ((ImageView)this.jXr.findViewById(2131821909));
    this.jXM = ((LinearLayout)this.jXr.findViewById(2131821908));
    this.jXJ = ((LinearLayout)this.jXr.findViewById(2131821910));
    this.jXK = ((MMNeat7extView)this.jXr.findViewById(2131821911));
    this.jXL = ((MMNeat7extView)this.jXr.findViewById(2131821912));
    AppMethodBeat.o(14273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.l
 * JD-Core Version:    0.7.0.1
 */