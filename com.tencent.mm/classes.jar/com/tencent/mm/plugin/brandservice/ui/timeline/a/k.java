package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class k
  extends c
{
  public View jYA;
  public TextView jYC;
  View jYD;
  public ImageView jYE;
  public ImageView[] jYF;
  public View[] jYG;
  
  public k()
  {
    AppMethodBeat.i(152640);
    this.jYF = new ImageView[4];
    this.jYG = new View[4];
    AppMethodBeat.o(152640);
  }
  
  private boolean d(com.tencent.mm.af.q paramq)
  {
    AppMethodBeat.i(152643);
    if ((this.mCount == 1) && (bo.isNullOrNil(paramq.fjL)))
    {
      AppMethodBeat.o(152643);
      return true;
    }
    AppMethodBeat.o(152643);
    return false;
  }
  
  public final void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(152642);
    super.a(paramInt1, paramq, paramq1, paramInt2, paramp);
    this.mCount = paramInt1;
    this.jXN = false;
    this.jXH.setVisibility(8);
    c.Q(this.jYA, com.tencent.mm.plugin.brandservice.ui.timeline.a.jVu);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.jYG.length)
    {
      localObject1 = this.jYG[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label98;
        }
        if (paramInt1 == this.jYG.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label98:
        ((View)localObject1).setVisibility(0);
        this.jYF[0] = ((ImageView)((View)localObject1).findViewById(2131821922));
        this.jYF[1] = ((ImageView)((View)localObject1).findViewById(2131821923));
        this.jYF[2] = ((ImageView)((View)localObject1).findViewById(2131821924));
        this.jYF[3] = ((ImageView)((View)localObject1).findViewById(2131821925));
      }
    }
    this.jYD.setBackgroundResource(2130839676);
    Object localObject2;
    if ((this.mCount == 1) && (!bo.isNullOrNil(paramq.fjL)))
    {
      this.jXJ.setVisibility(0);
      this.jXL.af(paramq.fjL);
      bool = d(paramq);
      if (this.jYF.length > 0)
      {
        localObject1 = this.jYF[0];
        localObject2 = paramq.fjJ;
        if ((localObject1 != null) && (!bo.isNullOrNil((String)localObject2)))
        {
          paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.jVu;
          com.tencent.mm.cb.a.gw(this.mContext);
          com.tencent.mm.cb.a.getDensity(this.mContext);
          Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
          ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
          ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
          paramInt1 = localPoint.x;
          int i = localPoint.y;
          ((ImageView)localObject1).setVisibility(0);
          this.jYE.setImageResource(2131230993);
          this.jXV.jVJ.a((String)localObject2, (ImageView)localObject1, paramInt1, i, new k.1(this, bool, paramq1, paramInt2), bool);
        }
      }
      if (paramq.fjZ <= 1) {
        break label526;
      }
      this.jYC.setVisibility(0);
      this.jYC.setText(String.valueOf(paramq.fjZ));
      label411:
      if (this.mCount != 1) {
        break label563;
      }
      if (!bool) {
        break label538;
      }
      this.jXW.setBackgroundResource(2130839676);
      this.jXW.setPadding(0, 0, 0, 0);
      label444:
      if (!d(paramq)) {
        break label586;
      }
      this.jXH.setBackgroundResource(2130837955);
      label461:
      a(this, paramq1, paramq);
      localObject1 = this.jXV;
      localObject2 = this.jXW;
      if (this.mCount <= 1) {
        break label598;
      }
    }
    label526:
    label538:
    label563:
    label586:
    label598:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a)localObject1).a(paramq, paramq1, paramInt2, paramp, (View)localObject2, bool, 0);
      AppMethodBeat.o(152642);
      return;
      this.jXJ.setVisibility(8);
      break;
      this.jYC.setVisibility(8);
      break label411;
      this.jXW.setBackgroundResource(2130837960);
      this.jXW.setPadding(0, 0, 0, com.tencent.mm.plugin.brandservice.ui.timeline.a.jVw);
      break label444;
      this.jXW.setBackgroundResource(2130837966);
      this.jXW.setPadding(0, 0, 0, 0);
      break label444;
      this.jXH.setBackgroundResource(2130837957);
      break label461;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(152641);
    super.a(paramView, parama);
    if (this.jXr != null)
    {
      AppMethodBeat.o(152641);
      return;
    }
    parama = (ViewStub)paramView.findViewById(2131821881);
    if (parama == null)
    {
      AppMethodBeat.o(152641);
      return;
    }
    parama.inflate();
    this.jXr = paramView.findViewById(2131821918);
    this.jXW = paramView.findViewById(2131821919);
    this.jYG[0] = this.jXr.findViewById(2131821926);
    this.jYG[1] = this.jXr.findViewById(2131821927);
    this.jYG[2] = this.jXr.findViewById(2131821928);
    this.jYG[3] = this.jXr.findViewById(2131821929);
    aWY();
    this.jYC = ((TextView)this.jXr.findViewById(2131821894));
    this.jYE = ((ImageView)this.jXr.findViewById(2131821921));
    this.jXH = ((ImageView)this.jXr.findViewById(2131821909));
    this.jYA = this.jXr.findViewById(2131821920);
    this.jYD = this.jXr.findViewById(2131821930);
    this.jXJ = ((LinearLayout)this.jXr.findViewById(2131821931));
    this.jXL = ((MMNeat7extView)this.jXr.findViewById(2131821912));
    AppMethodBeat.o(152641);
  }
  
  public final void a(com.tencent.mm.storage.q paramq, com.tencent.mm.af.q paramq1, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152644);
    super.a(paramq, paramq1, paramView, paramTextView, paramInt);
    paramTextView.setTextColor(this.mContext.getResources().getColor(2131690709));
    AppMethodBeat.o(152644);
  }
  
  public final void dd(View paramView)
  {
    AppMethodBeat.i(156911);
    c.Q(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a.jVu);
    AppMethodBeat.o(156911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.k
 * JD-Core Version:    0.7.0.1
 */