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
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ag
  extends x
{
  public ImageView ocn;
  public RelativeLayout ofZ;
  
  public final void a(int paramInt1, final v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6058);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.ofc = false;
    this.ocB.setVisibility(8);
    dF(this.ofZ);
    dF(this.ocn);
    this.ocn.setVisibility(0);
    this.ocA.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.ocC.setBackgroundResource(2131233299);
    this.ocH.setTextColor(this.mContext.getResources().getColor(2131100541));
    paramInt3 = bOM();
    this.ofm.oas.a(paramw.field_msgId, 0, paramv, paramv.hDm, this.ocn, paramInt3, b.oad, false, new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6056);
        ag.this.ofc = true;
        ag.this.ocH.setTextColor(ag.this.mContext.getResources().getColor(2131099674));
        if (ag.this.ocB != null) {
          ag.this.ocB.setVisibility(0);
        }
        if (!ag.b(ag.this.mCount, paramv))
        {
          ag.this.ocA.setTextColor(ag.this.mContext.getResources().getColor(2131101182));
          if (ag.this.b(paramv)) {
            ag.this.ocC.setBackgroundResource(2131231281);
          }
        }
        for (;;)
        {
          ag.this.ofm.oas.p(paramw.field_msgId, paramInt2);
          AppMethodBeat.o(6056);
          return;
          ag.this.ocC.setBackgroundResource(2131231282);
          continue;
          if (ag.this.ofd > 0) {
            ag.this.ocC.setBackgroundResource(2131231282);
          }
        }
      }
      
      public final void onStart() {}
    }, b(paramv), this.ofe);
    a(this.mCount, paramv);
    label237:
    b localb;
    View localView;
    if (b(this.mCount, paramv))
    {
      this.ocz.setPadding(this.ocz.getPaddingLeft(), 0, this.ocz.getPaddingRight(), b.oag);
      if (!b(paramv)) {
        break label314;
      }
      this.ocB.setBackgroundResource(2131231251);
      this.ocz.setBackgroundResource(2131231256);
      a(this, paramw, paramv);
      localb = this.ofm;
      localView = this.ocz;
      if (paramInt1 <= 1) {
        break label358;
      }
    }
    label314:
    label358:
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramv, paramw, paramInt2, paramu, localView, bool, 0);
      AppMethodBeat.o(6058);
      return;
      this.ocz.setPadding(this.ocz.getPaddingLeft(), 0, this.ocz.getPaddingRight(), 0);
      break;
      this.ocB.setBackgroundResource(2131231253);
      if (b(this.mCount, paramv))
      {
        this.ocz.setBackgroundResource(2131231256);
        break label237;
      }
      this.ocz.setBackgroundResource(2131231262);
      break label237;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6057);
    super.a(paramView, paramb);
    if (this.odh != null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306453);
    if (paramb == null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb.inflate();
    this.odh = paramView.findViewById(2131297347);
    this.ocz = paramView.findViewById(2131305993);
    bOx();
    this.ocn = ((ImageView)this.odh.findViewById(2131298824));
    this.ofZ = ((RelativeLayout)this.odh.findViewById(2131298825));
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305948));
    this.ocp = ((ImageView)this.odh.findViewById(2131298826));
    this.ocB = ((ImageView)this.odh.findViewById(2131303387));
    this.ocC = ((LinearLayout)this.odh.findViewById(2131297367));
    this.ocD = ((LinearLayout)this.odh.findViewById(2131304831));
    this.ocE = ((MMNeat7extView)this.odh.findViewById(2131304829));
    this.ocF = ((MMNeat7extView)this.odh.findViewById(2131304827));
    AppMethodBeat.o(6057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ag
 * JD-Core Version:    0.7.0.1
 */