package com.tencent.mm.plugin.brandservice.ui.timeline.item;

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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ai
  extends x
{
  public ImageView ka;
  public TextView ocK;
  public View ocL;
  public View ocM;
  public ImageView ocn;
  
  public final void a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6065);
    super.a(paramInt, paramv);
    if ((this.ocA != null) && (this.ocA.getVisibility() == 0))
    {
      if (a.eb(this.mContext) >= 1.125F)
      {
        this.ocA.setMaxLines(1);
        AppMethodBeat.o(6065);
        return;
      }
      this.ocA.setMaxLines(2);
    }
    AppMethodBeat.o(6065);
  }
  
  public final void a(int paramInt1, v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6064);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.ofc = false;
    this.ocB.setVisibility(8);
    paramw.Ioo = e.Xh(paramw.field_talker);
    X(this.ocL, b.oae);
    Object localObject = m.oi(paramv.hDq);
    float f;
    label311:
    boolean bool;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.ocK.setVisibility(0);
      this.ocK.setText((CharSequence)localObject);
      this.ocK.setTextColor(this.mContext.getResources().getColor(2131100541));
      this.ocK.setShadowLayer(10.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131099662));
      this.ocn.setVisibility(0);
      this.ocA.setTextColor(this.mContext.getResources().getColor(2131100541));
      this.ocC.setBackgroundResource(2131233299);
      this.ocH.setTextColor(this.mContext.getResources().getColor(2131100541));
      paramInt1 = bOM();
      this.ofm.oas.a(paramw.field_msgId, 0, paramv, paramv.hDm, this.ocn, paramInt1, b.oae, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6062);
          ai.this.ofc = true;
          ai.this.ocH.setTextColor(ai.this.mContext.getResources().getColor(2131099674));
          if (ai.this.ocB != null) {
            ai.this.ocB.setVisibility(0);
          }
          if (ai.this.mCount > 1) {
            ai.this.ocA.setTextColor(ai.this.mContext.getResources().getColor(2131101182));
          }
          if (ai.this.ofd > 0) {
            ai.this.ocC.setBackgroundResource(2131231282);
          }
          ai.this.ocK.setTextColor(ai.this.mContext.getResources().getColor(2131101182));
          ai.this.ofm.oas.p(paramw.field_msgId, paramInt2);
          AppMethodBeat.o(6062);
        }
        
        public final void onStart() {}
      }, false, this.ofe);
      a(this.mCount, paramv);
      if (this.ocA.getVisibility() != 0) {
        break label459;
      }
      this.ocA.measure(a.ip(this.mContext) - a.fromDPToPix(this.mContext, 48), 0);
      paramInt1 = this.ocL.getLayoutParams().height - this.ocA.getMeasuredHeight() - b.oan;
      f = 0.56F;
      if (this.ocM != null) {
        ((RelativeLayout.LayoutParams)this.ocM.getLayoutParams()).topMargin = ((int)(f * paramInt1 - a.fromDPToPix(this.mContext, 48) / 2));
      }
      localObject = this.ofm;
      View localView = this.ocz;
      if (this.mCount <= 1) {
        break label478;
      }
      bool = true;
      label373:
      ((b)localObject).a(paramv, paramw, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label484;
      }
      this.ocz.setBackgroundResource(2131231256);
      this.ocz.setPadding(this.ocz.getPaddingLeft(), 0, this.ocz.getPaddingRight(), b.oag);
    }
    for (;;)
    {
      this.ocB.setBackgroundResource(2131231253);
      AppMethodBeat.o(6064);
      return;
      this.ocK.setVisibility(8);
      break;
      label459:
      paramInt1 = this.ocL.getLayoutParams().height;
      f = 0.5F;
      break label311;
      label478:
      bool = false;
      break label373;
      label484:
      this.ocz.setBackgroundResource(2131231262);
      this.ocz.setPadding(this.ocz.getPaddingLeft(), 0, this.ocz.getPaddingRight(), 0);
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6063);
    super.a(paramView, paramb);
    if (this.odh != null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306455);
    if (paramb == null)
    {
      AppMethodBeat.o(6063);
      return;
    }
    paramb.inflate();
    this.odh = paramView.findViewById(2131297348);
    this.ocz = paramView.findViewById(2131298112);
    bOx();
    this.ocn = ((ImageView)this.odh.findViewById(2131298813));
    this.ka = ((ImageView)this.odh.findViewById(2131306344));
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305948));
    this.ocK = ((TextView)this.odh.findViewById(2131303288));
    this.ocL = this.odh.findViewById(2131298187);
    this.ocB = ((ImageView)this.odh.findViewById(2131303387));
    this.ocM = this.odh.findViewById(2131306345);
    this.ocC = ((LinearLayout)this.odh.findViewById(2131297367));
    this.ocD = ((LinearLayout)this.odh.findViewById(2131304832));
    this.ocE = ((MMNeat7extView)this.odh.findViewById(2131304829));
    this.ocF = ((MMNeat7extView)this.odh.findViewById(2131304827));
    AppMethodBeat.o(6063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
 * JD-Core Version:    0.7.0.1
 */