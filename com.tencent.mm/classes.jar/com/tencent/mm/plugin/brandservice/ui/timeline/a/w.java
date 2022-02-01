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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class w
  extends l
{
  public ImageView ig;
  public ImageView nCl;
  public TextView nDH;
  public View nDI;
  public View nDr;
  
  public final void a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6065);
    super.a(paramInt, paramv);
    if ((this.nCy != null) && (this.nCy.getVisibility() == 0))
    {
      if (a.eb(this.mContext) >= 1.125F)
      {
        this.nCy.setMaxLines(1);
        AppMethodBeat.o(6065);
        return;
      }
      this.nCy.setMaxLines(2);
    }
    AppMethodBeat.o(6065);
  }
  
  public final void a(int paramInt1, v paramv, final t paramt, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6064);
    super.a(paramInt1, paramv, paramt, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.nCD = false;
    this.nCx.setVisibility(8);
    paramt.GCa = e.TA(paramt.field_talker);
    W(this.nDr, com.tencent.mm.plugin.brandservice.ui.timeline.c.nyZ);
    Object localObject = m.nJ(paramv.hlh);
    float f;
    label311:
    boolean bool;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.nDH.setVisibility(0);
      this.nDH.setText((CharSequence)localObject);
      this.nDH.setTextColor(this.mContext.getResources().getColor(2131100541));
      this.nDH.setShadowLayer(10.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131099662));
      this.nCl.setVisibility(0);
      this.nCy.setTextColor(this.mContext.getResources().getColor(2131100541));
      this.nCC.setBackgroundResource(2131233299);
      this.nCq.setTextColor(this.mContext.getResources().getColor(2131100541));
      paramInt1 = bKl();
      this.nCM.nzn.a(paramt.field_msgId, 0, paramv, paramv.hld, this.nCl, paramInt1, com.tencent.mm.plugin.brandservice.ui.timeline.c.nyZ, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6062);
          w.this.nCD = true;
          w.this.nCq.setTextColor(w.this.mContext.getResources().getColor(2131099674));
          if (w.this.nCx != null) {
            w.this.nCx.setVisibility(0);
          }
          if (w.this.mCount > 1) {
            w.this.nCy.setTextColor(w.this.mContext.getResources().getColor(2131101182));
          }
          if (w.this.nCE > 0) {
            w.this.nCC.setBackgroundResource(2131231282);
          }
          w.this.nDH.setTextColor(w.this.mContext.getResources().getColor(2131101182));
          w.this.nCM.nzn.p(paramt.field_msgId, paramInt2);
          AppMethodBeat.o(6062);
        }
        
        public final void onStart() {}
      }, false, this.nCF);
      a(this.mCount, paramv);
      if (this.nCy.getVisibility() != 0) {
        break label459;
      }
      this.nCy.measure(a.ig(this.mContext) - a.fromDPToPix(this.mContext, 48), 0);
      paramInt1 = this.nDr.getLayoutParams().height - this.nCy.getMeasuredHeight() - com.tencent.mm.plugin.brandservice.ui.timeline.c.nzi;
      f = 0.56F;
      if (this.nDI != null) {
        ((RelativeLayout.LayoutParams)this.nDI.getLayoutParams()).topMargin = ((int)(f * paramInt1 - a.fromDPToPix(this.mContext, 48) / 2));
      }
      localObject = this.nCM;
      View localView = this.nCN;
      if (this.mCount <= 1) {
        break label478;
      }
      bool = true;
      label373:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject).a(paramv, paramt, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label484;
      }
      this.nCN.setBackgroundResource(2131231256);
      this.nCN.setPadding(this.nCN.getPaddingLeft(), 0, this.nCN.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.c.nzb);
    }
    for (;;)
    {
      this.nCx.setBackgroundResource(2131231253);
      AppMethodBeat.o(6064);
      return;
      this.nDH.setVisibility(8);
      break;
      label459:
      paramInt1 = this.nDr.getLayoutParams().height;
      f = 0.5F;
      break label311;
      label478:
      bool = false;
      break label373;
      label484:
      this.nCN.setBackgroundResource(2131231262);
      this.nCN.setPadding(this.nCN.getPaddingLeft(), 0, this.nCN.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6063);
    super.a(paramView, paramc);
    if (this.nBh != null)
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
    this.nBh = paramView.findViewById(2131297348);
    this.nCN = paramView.findViewById(2131298112);
    bKk();
    this.nCl = ((ImageView)this.nBh.findViewById(2131298813));
    this.ig = ((ImageView)this.nBh.findViewById(2131306344));
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305948));
    this.nDH = ((TextView)this.nBh.findViewById(2131303288));
    this.nDr = this.nBh.findViewById(2131298187);
    this.nCx = ((ImageView)this.nBh.findViewById(2131303387));
    this.nDI = this.nBh.findViewById(2131306345);
    this.nCC = ((LinearLayout)this.nBh.findViewById(2131297367));
    this.nCz = ((LinearLayout)this.nBh.findViewById(2131304832));
    this.nCA = ((MMNeat7extView)this.nBh.findViewById(2131304829));
    this.nCB = ((MMNeat7extView)this.nBh.findViewById(2131304827));
    AppMethodBeat.o(6063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.w
 * JD-Core Version:    0.7.0.1
 */