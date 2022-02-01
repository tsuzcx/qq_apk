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
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ar
  extends ai
{
  public ImageView ptE;
  public RelativeLayout pyv;
  
  public final void a(int paramInt1, final v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6058);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.pxB = false;
    this.ptS.setVisibility(8);
    dw(this.pyv);
    dw(this.ptE);
    this.ptE.setVisibility(0);
    this.ptR.setTextColor(this.mContext.getResources().getColor(2131100679));
    this.ptT.setBackgroundResource(2131233974);
    this.ptY.setTextColor(this.mContext.getResources().getColor(2131100679));
    paramInt3 = cnf();
    this.pxE.prc.a(paramz.field_msgId, 0, paramv, paramv.iAo, this.ptE, paramInt3, b.prq, false, new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6056);
        ar.this.pxB = true;
        ar.this.ptY.setTextColor(ar.this.mContext.getResources().getColor(2131099681));
        if (ar.this.ptS != null) {
          ar.this.ptS.setVisibility(0);
        }
        if (!ar.a(ar.this.mCount, paramv))
        {
          ar.this.ptR.setTextColor(ar.this.mContext.getResources().getColor(2131101427));
          if (ar.this.b(paramv)) {
            ar.this.ptT.setBackgroundResource(2131231341);
          }
        }
        for (;;)
        {
          ar.this.pxE.prc.m(paramz.field_msgId, paramInt2);
          AppMethodBeat.o(6056);
          return;
          ar.this.ptT.setBackgroundResource(2131231342);
          continue;
          if (ar.this.pxC > 0) {
            ar.this.ptT.setBackgroundResource(2131231342);
          }
        }
      }
      
      public final void onStart() {}
    }, b(paramv), this.pxD);
    a(this.mCount, paramv, paramz);
    label238:
    b localb;
    View localView;
    if (a(this.mCount, paramv))
    {
      this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), b.prv);
      if (!b(paramv)) {
        break label323;
      }
      this.ptS.setBackgroundResource(2131231311);
      this.ptQ.setBackgroundResource(2131231316);
      if (!a(paramInt1, paramv)) {
        a(this, paramz, paramv);
      }
      localb = this.pxE;
      localView = this.ptQ;
      if (paramInt1 <= 1) {
        break label367;
      }
    }
    label323:
    label367:
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramv, paramz, paramInt2, paramu, localView, bool, 0);
      AppMethodBeat.o(6058);
      return;
      this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), 0);
      break;
      this.ptS.setBackgroundResource(2131231313);
      if (a(this.mCount, paramv))
      {
        this.ptQ.setBackgroundResource(2131231316);
        break label238;
      }
      this.ptQ.setBackgroundResource(2131231322);
      break label238;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6057);
    super.a(paramView, paramb);
    if (this.puO != null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131309896);
    if (paramb == null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb.inflate();
    this.puO = paramView.findViewById(2131297558);
    this.ptQ = paramView.findViewById(2131309300);
    cmH();
    this.ptE = ((ImageView)this.puO.findViewById(2131299289));
    this.pyv = ((RelativeLayout)this.puO.findViewById(2131299290));
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131309249));
    this.ptG = ((ImageView)this.puO.findViewById(2131299291));
    this.ptS = ((ImageView)this.puO.findViewById(2131306101));
    this.ptT = ((LinearLayout)this.puO.findViewById(2131297585));
    this.ptU = ((LinearLayout)this.puO.findViewById(2131307917));
    this.ptV = ((MMNeat7extView)this.puO.findViewById(2131307915));
    this.ptW = ((MMNeat7extView)this.puO.findViewById(2131307913));
    this.pxz = this.puO.findViewById(2131308375);
    this.pxA = ((TextView)this.puO.findViewById(2131301797));
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      com.tencent.mm.plugin.brandservice.ui.b.d.c(this.ptR);
    }
    paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
    if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
    {
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      com.tencent.mm.plugin.brandservice.ui.b.d.c(this.ptV);
    }
    AppMethodBeat.o(6057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ar
 * JD-Core Version:    0.7.0.1
 */