package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class n
  extends c
{
  public ImageView iTH;
  public ImageView jXx;
  public View jYA;
  public TextView jYO;
  public View jYP;
  
  public final void a(int paramInt, com.tencent.mm.af.q paramq)
  {
    AppMethodBeat.i(152649);
    super.a(paramInt, paramq);
    if ((this.jXI != null) && (this.jXI.getVisibility() == 0))
    {
      if (com.tencent.mm.cb.a.dr(this.mContext) >= 1.125F)
      {
        this.jXI.setMaxLines(1);
        AppMethodBeat.o(152649);
        return;
      }
      this.jXI.setMaxLines(2);
    }
    AppMethodBeat.o(152649);
  }
  
  public final void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(152648);
    super.a(paramInt1, paramq, paramq1, paramInt2, paramp);
    this.mCount = paramInt1;
    this.jXN = false;
    this.jXH.setVisibility(8);
    paramq1.ywB = d.GO(paramq1.field_talker);
    Q(this.jYA, com.tencent.mm.plugin.brandservice.ui.timeline.a.jVu);
    Object localObject = l.kq(paramq.fjN);
    float f;
    label301:
    boolean bool;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jYO.setVisibility(0);
      this.jYO.setText((CharSequence)localObject);
      this.jYO.setTextColor(this.mContext.getResources().getColor(2131690208));
      this.jYO.setShadowLayer(10.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131689485));
      this.jXx.setVisibility(0);
      this.jXI.setTextColor(this.mContext.getResources().getColor(2131690208));
      this.jXM.setBackgroundResource(2130839676);
      this.jXA.setTextColor(this.mContext.getResources().getColor(2131690208));
      paramInt1 = (int)(com.tencent.mm.plugin.brandservice.ui.timeline.a.jVu * 1.777778F);
      this.jXV.jVJ.a(paramq.fjJ, this.jXx, paramInt1, com.tencent.mm.plugin.brandservice.ui.timeline.a.jVu, new n.1(this, paramq1, paramInt2), false);
      a(this.mCount, paramq);
      if (this.jXI.getVisibility() != 0) {
        break label456;
      }
      this.jXI.measure(com.tencent.mm.cb.a.gw(this.mContext) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48), 0);
      paramInt1 = this.jYA.getLayoutParams().height - this.jXI.getMeasuredHeight() - com.tencent.mm.plugin.brandservice.ui.timeline.a.jVD;
      f = 0.56F;
      if (this.jYP != null) {
        ((RelativeLayout.LayoutParams)this.jYP.getLayoutParams()).topMargin = ((int)(f * paramInt1 - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48) / 2));
      }
      a(this, paramq1, paramq);
      localObject = this.jXV;
      View localView = this.jXW;
      if (this.mCount <= 1) {
        break label474;
      }
      bool = true;
      label371:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a)localObject).a(paramq, paramq1, paramInt2, paramp, localView, bool, 0);
      if (this.mCount != 1) {
        break label480;
      }
      this.jXW.setBackgroundResource(2130837960);
      this.jXW.setPadding(this.jXW.getPaddingLeft(), 0, this.jXW.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.a.jVw);
    }
    for (;;)
    {
      this.jXH.setBackgroundResource(2130837957);
      AppMethodBeat.o(152648);
      return;
      this.jYO.setVisibility(8);
      break;
      label456:
      paramInt1 = this.jYA.getLayoutParams().height;
      f = 0.5F;
      break label301;
      label474:
      bool = false;
      break label371;
      label480:
      this.jXW.setBackgroundResource(2130837966);
      this.jXW.setPadding(this.jXW.getPaddingLeft(), 0, this.jXW.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14276);
    super.a(paramView, parama);
    if (this.jXr != null)
    {
      AppMethodBeat.o(14276);
      return;
    }
    parama = (ViewStub)paramView.findViewById(2131821879);
    if (parama == null)
    {
      AppMethodBeat.o(14276);
      return;
    }
    parama.inflate();
    this.jXr = paramView.findViewById(2131821935);
    this.jXW = paramView.findViewById(2131821936);
    aWY();
    this.jXx = ((ImageView)this.jXr.findViewById(2131821438));
    this.iTH = ((ImageView)this.jXr.findViewById(2131821939));
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131821212));
    this.jYO = ((TextView)this.jXr.findViewById(2131821940));
    this.jYA = this.jXr.findViewById(2131821937);
    this.jXH = ((ImageView)this.jXr.findViewById(2131821909));
    this.jYP = this.jXr.findViewById(2131821938);
    this.jXM = ((LinearLayout)this.jXr.findViewById(2131821908));
    this.jXJ = ((LinearLayout)this.jXr.findViewById(2131821941));
    this.jXK = ((MMNeat7extView)this.jXr.findViewById(2131821911));
    this.jXL = ((MMNeat7extView)this.jXr.findViewById(2131821912));
    AppMethodBeat.o(14276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.n
 * JD-Core Version:    0.7.0.1
 */