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
import com.tencent.mm.ai.v;
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class u
  extends l
{
  public ImageView mZN;
  public RelativeLayout nbd;
  
  public final void a(int paramInt1, final v paramv, final s params, final int paramInt2, com.tencent.mm.ai.u paramu, int paramInt3)
  {
    AppMethodBeat.i(6058);
    super.a(paramInt1, paramv, params, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.naf = false;
    this.mZZ.setVisibility(8);
    dA(this.nbd);
    dA(this.mZN);
    this.mZN.setVisibility(0);
    this.naa.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.nae.setBackgroundResource(2131233299);
    this.mZS.setTextColor(this.mContext.getResources().getColor(2131100541));
    paramInt3 = a.hV(this.mContext);
    int i = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWD;
    this.nao.mWO.a(params.field_msgId, 0, paramv, paramv.gKD, this.mZN, paramInt3 - i, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWz, false, new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6056);
        u.this.naf = true;
        u.this.mZS.setTextColor(u.this.mContext.getResources().getColor(2131099674));
        if (u.this.mZZ != null) {
          u.this.mZZ.setVisibility(0);
        }
        if (!u.b(u.this.mCount, paramv))
        {
          u.this.naa.setTextColor(u.this.mContext.getResources().getColor(2131101182));
          if (u.this.b(paramv)) {
            u.this.nae.setBackgroundResource(2131231281);
          }
        }
        for (;;)
        {
          u.this.nao.mWO.o(params.field_msgId, paramInt2);
          AppMethodBeat.o(6056);
          return;
          u.this.nae.setBackgroundResource(2131231282);
          continue;
          if (u.this.nag > 0) {
            u.this.nae.setBackgroundResource(2131231282);
          }
        }
      }
      
      public final void onStart() {}
    }, b(paramv), this.nah);
    a(this.mCount, paramv);
    label248:
    com.tencent.mm.plugin.brandservice.ui.timeline.c localc;
    View localView;
    if (b(this.mCount, paramv))
    {
      this.nap.setPadding(this.nap.getPaddingLeft(), 0, this.nap.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.c.mWC);
      if (!b(paramv)) {
        break label325;
      }
      this.mZZ.setBackgroundResource(2131231251);
      this.nap.setBackgroundResource(2131231256);
      a(this, params, paramv);
      localc = this.nao;
      localView = this.nap;
      if (paramInt1 <= 1) {
        break label369;
      }
    }
    label325:
    label369:
    for (boolean bool = true;; bool = false)
    {
      localc.a(paramv, params, paramInt2, paramu, localView, bool, 0);
      AppMethodBeat.o(6058);
      return;
      this.nap.setPadding(this.nap.getPaddingLeft(), 0, this.nap.getPaddingRight(), 0);
      break;
      this.mZZ.setBackgroundResource(2131231253);
      if (b(this.mCount, paramv))
      {
        this.nap.setBackgroundResource(2131231256);
        break label248;
      }
      this.nap.setBackgroundResource(2131231262);
      break label248;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6057);
    super.a(paramView, paramc);
    if (this.mYI != null)
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
    this.mYI = paramView.findViewById(2131297347);
    this.nap = paramView.findViewById(2131305993);
    bDb();
    this.mZN = ((ImageView)this.mYI.findViewById(2131298824));
    this.nbd = ((RelativeLayout)this.mYI.findViewById(2131298825));
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305948));
    this.mZY = ((ImageView)this.mYI.findViewById(2131298826));
    this.mZZ = ((ImageView)this.mYI.findViewById(2131303387));
    this.nae = ((LinearLayout)this.mYI.findViewById(2131297367));
    this.nab = ((LinearLayout)this.mYI.findViewById(2131304831));
    this.nac = ((MMNeat7extView)this.mYI.findViewById(2131304829));
    this.nad = ((MMNeat7extView)this.mYI.findViewById(2131304827));
    AppMethodBeat.o(6057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.u
 * JD-Core Version:    0.7.0.1
 */