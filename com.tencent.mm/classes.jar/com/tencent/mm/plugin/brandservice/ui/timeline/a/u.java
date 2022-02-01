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
import com.tencent.mm.ah.v;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class u
  extends l
{
  public ImageView nCl;
  public RelativeLayout nDB;
  
  public final void a(int paramInt1, final v paramv, final t paramt, final int paramInt2, com.tencent.mm.ah.u paramu, int paramInt3)
  {
    AppMethodBeat.i(6058);
    super.a(paramInt1, paramv, paramt, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.nCD = false;
    this.nCx.setVisibility(8);
    dC(this.nDB);
    dC(this.nCl);
    this.nCl.setVisibility(0);
    this.nCy.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.nCC.setBackgroundResource(2131233299);
    this.nCq.setTextColor(this.mContext.getResources().getColor(2131100541));
    paramInt3 = bKl();
    this.nCM.nzn.a(paramt.field_msgId, 0, paramv, paramv.hld, this.nCl, paramInt3, com.tencent.mm.plugin.brandservice.ui.timeline.c.nyY, false, new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6056);
        u.this.nCD = true;
        u.this.nCq.setTextColor(u.this.mContext.getResources().getColor(2131099674));
        if (u.this.nCx != null) {
          u.this.nCx.setVisibility(0);
        }
        if (!u.b(u.this.mCount, paramv))
        {
          u.this.nCy.setTextColor(u.this.mContext.getResources().getColor(2131101182));
          if (u.this.b(paramv)) {
            u.this.nCC.setBackgroundResource(2131231281);
          }
        }
        for (;;)
        {
          u.this.nCM.nzn.p(paramt.field_msgId, paramInt2);
          AppMethodBeat.o(6056);
          return;
          u.this.nCC.setBackgroundResource(2131231282);
          continue;
          if (u.this.nCE > 0) {
            u.this.nCC.setBackgroundResource(2131231282);
          }
        }
      }
      
      public final void onStart() {}
    }, b(paramv), this.nCF);
    a(this.mCount, paramv);
    label237:
    com.tencent.mm.plugin.brandservice.ui.timeline.c localc;
    View localView;
    if (b(this.mCount, paramv))
    {
      this.nCN.setPadding(this.nCN.getPaddingLeft(), 0, this.nCN.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.c.nzb);
      if (!b(paramv)) {
        break label314;
      }
      this.nCx.setBackgroundResource(2131231251);
      this.nCN.setBackgroundResource(2131231256);
      a(this, paramt, paramv);
      localc = this.nCM;
      localView = this.nCN;
      if (paramInt1 <= 1) {
        break label358;
      }
    }
    label314:
    label358:
    for (boolean bool = true;; bool = false)
    {
      localc.a(paramv, paramt, paramInt2, paramu, localView, bool, 0);
      AppMethodBeat.o(6058);
      return;
      this.nCN.setPadding(this.nCN.getPaddingLeft(), 0, this.nCN.getPaddingRight(), 0);
      break;
      this.nCx.setBackgroundResource(2131231253);
      if (b(this.mCount, paramv))
      {
        this.nCN.setBackgroundResource(2131231256);
        break label237;
      }
      this.nCN.setBackgroundResource(2131231262);
      break label237;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6057);
    super.a(paramView, paramc);
    if (this.nBh != null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramc = (ViewStub)paramView.findViewById(2131306453);
    if (paramc == null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramc.inflate();
    this.nBh = paramView.findViewById(2131297347);
    this.nCN = paramView.findViewById(2131305993);
    bKk();
    this.nCl = ((ImageView)this.nBh.findViewById(2131298824));
    this.nDB = ((RelativeLayout)this.nBh.findViewById(2131298825));
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305948));
    this.nCw = ((ImageView)this.nBh.findViewById(2131298826));
    this.nCx = ((ImageView)this.nBh.findViewById(2131303387));
    this.nCC = ((LinearLayout)this.nBh.findViewById(2131297367));
    this.nCz = ((LinearLayout)this.nBh.findViewById(2131304831));
    this.nCA = ((MMNeat7extView)this.nBh.findViewById(2131304829));
    this.nCB = ((MMNeat7extView)this.nBh.findViewById(2131304827));
    AppMethodBeat.o(6057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.u
 * JD-Core Version:    0.7.0.1
 */