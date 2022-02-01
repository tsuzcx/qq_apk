package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class at
  extends ak
{
  public ImageView sCR;
  public RelativeLayout sHY;
  
  public final void a(int paramInt1, final v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6058);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.sHc = false;
    this.sDf.setVisibility(8);
    dU(this.sHY);
    dU(this.sCR);
    this.sCR.setVisibility(0);
    this.sDe.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
    this.sDg.setBackgroundResource(d.d.mm_trans);
    this.sDl.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
    paramInt3 = this.sHf.sAc.getContentWidth();
    this.sHf.sAc.a(paramz.field_msgId, 0, paramv, paramv.lpK, this.sCR, paramInt3, b.sAo, false, new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6056);
        at.this.sHc = true;
        at.this.sDl.setTextColor(at.this.mContext.getResources().getColor(d.b.BW_100_Alpha_0_9));
        if (at.this.sDf != null) {
          at.this.sDf.setVisibility(0);
        }
        if (!at.a(at.this.mCount, paramv))
        {
          at.this.sDe.setTextColor(at.this.mContext.getResources().getColor(d.b.white_text_color));
          if (at.this.b(paramv)) {
            at.this.sDg.setBackgroundResource(d.d.spI);
          }
        }
        for (;;)
        {
          at.this.sHf.sAc.p(paramz.field_msgId, paramInt2);
          AppMethodBeat.o(6056);
          return;
          at.this.sDg.setBackgroundResource(d.d.dmA);
          continue;
          if (at.this.sHd > 0) {
            at.this.sDg.setBackgroundResource(d.d.dmA);
          }
        }
      }
      
      public final void onStart() {}
    }, b(paramv), this.sHe);
    a(this.mCount, paramv, paramz);
    label249:
    b localb;
    View localView;
    if (a(this.mCount, paramv))
    {
      this.sDd.setPadding(this.sDd.getPaddingLeft(), 0, this.sDd.getPaddingRight(), b.sAt);
      if (!b(paramv)) {
        break label334;
      }
      this.sDf.setBackgroundResource(d.d.spA);
      this.sDd.setBackgroundResource(d.d.spE);
      if (!a(paramInt1, paramv)) {
        a(this, paramz, paramv);
      }
      localb = this.sHf;
      localView = this.sDd;
      if (paramInt1 <= 1) {
        break label381;
      }
    }
    label334:
    label381:
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramv, paramz, paramInt2, paramu, localView, bool, 0);
      AppMethodBeat.o(6058);
      return;
      this.sDd.setPadding(this.sDd.getPaddingLeft(), 0, this.sDd.getPaddingRight(), 0);
      break;
      this.sDf.setBackgroundResource(d.d.spC);
      if (a(this.mCount, paramv))
      {
        this.sDd.setBackgroundResource(d.d.spE);
        break label249;
      }
      this.sDd.setBackgroundResource(d.d.spF);
      break label249;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6057);
    super.a(paramView, paramb);
    if (this.sEi != null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.dZy);
    if (paramb == null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb.inflate();
    this.sEi = paramView.findViewById(d.e.sqP);
    this.sDd = paramView.findViewById(d.e.sti);
    cAo();
    this.sCR = ((ImageView)this.sEi.findViewById(d.e.cover_iv));
    this.sHY = ((RelativeLayout)this.sEi.findViewById(d.e.cover_layout));
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(d.e.title_tv));
    this.sCT = ((ImageView)this.sEi.findViewById(d.e.dCV));
    this.sDf = ((ImageView)this.sEi.findViewById(d.e.dRn));
    this.sDg = ((LinearLayout)this.sEi.findViewById(d.e.srq));
    this.sDh = ((LinearLayout)this.sEi.findViewById(d.e.ssU));
    this.sDi = ((MMNeat7extView)this.sEi.findViewById(d.e.ssT));
    this.sDj = ((MMNeat7extView)this.sEi.findViewById(d.e.dVp));
    this.sHa = this.sEi.findViewById(d.e.stb);
    this.sHb = ((TextView)this.sEi.findViewById(d.e.srU));
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.e(this.sDe);
    }
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.e(this.sDi);
    }
    AppMethodBeat.o(6057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.at
 * JD-Core Version:    0.7.0.1
 */