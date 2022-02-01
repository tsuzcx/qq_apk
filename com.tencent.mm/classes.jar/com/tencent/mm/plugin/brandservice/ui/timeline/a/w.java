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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class w
  extends l
{
  public ImageView hg;
  public ImageView mZN;
  public View naT;
  public TextView nbj;
  public View nbk;
  
  public final void a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6065);
    super.a(paramInt, paramv);
    if ((this.naa != null) && (this.naa.getVisibility() == 0))
    {
      if (a.dT(this.mContext) >= 1.125F)
      {
        this.naa.setMaxLines(1);
        AppMethodBeat.o(6065);
        return;
      }
      this.naa.setMaxLines(2);
    }
    AppMethodBeat.o(6065);
  }
  
  public final void a(int paramInt1, v paramv, final s params, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6064);
    super.a(paramInt1, paramv, params, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.naf = false;
    this.mZZ.setVisibility(8);
    params.Feq = e.Pp(params.field_talker);
    V(this.naT, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWA);
    Object localObject = m.mV(paramv.gKH);
    float f;
    label315:
    boolean bool;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.nbj.setVisibility(0);
      this.nbj.setText((CharSequence)localObject);
      this.nbj.setTextColor(this.mContext.getResources().getColor(2131100541));
      this.nbj.setShadowLayer(10.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131099662));
      this.mZN.setVisibility(0);
      this.naa.setTextColor(this.mContext.getResources().getColor(2131100541));
      this.nae.setBackgroundResource(2131233299);
      this.mZS.setTextColor(this.mContext.getResources().getColor(2131100541));
      paramInt1 = (int)(com.tencent.mm.plugin.brandservice.ui.timeline.c.mWA * 1.777778F);
      this.nao.mWO.a(params.field_msgId, 0, paramv, paramv.gKD, this.mZN, paramInt1, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWA, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6062);
          w.this.naf = true;
          w.this.mZS.setTextColor(w.this.mContext.getResources().getColor(2131099674));
          if (w.this.mZZ != null) {
            w.this.mZZ.setVisibility(0);
          }
          if (w.this.mCount > 1) {
            w.this.naa.setTextColor(w.this.mContext.getResources().getColor(2131101182));
          }
          if (w.this.nag > 0) {
            w.this.nae.setBackgroundResource(2131231282);
          }
          w.this.nbj.setTextColor(w.this.mContext.getResources().getColor(2131101182));
          w.this.nao.mWO.o(params.field_msgId, paramInt2);
          AppMethodBeat.o(6062);
        }
        
        public final void onStart() {}
      }, false, this.nah);
      a(this.mCount, paramv);
      if (this.naa.getVisibility() != 0) {
        break label472;
      }
      this.naa.measure(a.hV(this.mContext) - a.fromDPToPix(this.mContext, 48), 0);
      paramInt1 = this.naT.getLayoutParams().height - this.naa.getMeasuredHeight() - com.tencent.mm.plugin.brandservice.ui.timeline.c.mWJ;
      f = 0.56F;
      if (this.nbk != null) {
        ((RelativeLayout.LayoutParams)this.nbk.getLayoutParams()).topMargin = ((int)(f * paramInt1 - a.fromDPToPix(this.mContext, 48) / 2));
      }
      a(this, params, paramv);
      localObject = this.nao;
      View localView = this.nap;
      if (this.mCount <= 1) {
        break label491;
      }
      bool = true;
      label385:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject).a(paramv, params, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label497;
      }
      this.nap.setBackgroundResource(2131231256);
      this.nap.setPadding(this.nap.getPaddingLeft(), 0, this.nap.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.c.mWC);
    }
    for (;;)
    {
      this.mZZ.setBackgroundResource(2131231253);
      AppMethodBeat.o(6064);
      return;
      this.nbj.setVisibility(8);
      break;
      label472:
      paramInt1 = this.naT.getLayoutParams().height;
      f = 0.5F;
      break label315;
      label491:
      bool = false;
      break label385;
      label497:
      this.nap.setBackgroundResource(2131231262);
      this.nap.setPadding(this.nap.getPaddingLeft(), 0, this.nap.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6063);
    super.a(paramView, paramc);
    if (this.mYI != null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramc = (ViewStub)paramView.findViewById(2131306455);
    if (paramc == null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramc.inflate();
    this.mYI = paramView.findViewById(2131297348);
    this.nap = paramView.findViewById(2131298112);
    bDb();
    this.mZN = ((ImageView)this.mYI.findViewById(2131298813));
    this.hg = ((ImageView)this.mYI.findViewById(2131306344));
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305948));
    this.nbj = ((TextView)this.mYI.findViewById(2131303288));
    this.naT = this.mYI.findViewById(2131298187);
    this.mZZ = ((ImageView)this.mYI.findViewById(2131303387));
    this.nbk = this.mYI.findViewById(2131306345);
    this.nae = ((LinearLayout)this.mYI.findViewById(2131297367));
    this.nab = ((LinearLayout)this.mYI.findViewById(2131304832));
    this.nac = ((MMNeat7extView)this.mYI.findViewById(2131304829));
    this.nad = ((MMNeat7extView)this.mYI.findViewById(2131304827));
    AppMethodBeat.o(6063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.w
 * JD-Core Version:    0.7.0.1
 */