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
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class t
  extends l
{
  public View nDr;
  public TextView nDt;
  View nDu;
  public ImageView nDv;
  public ImageView[] nDw;
  public View[] nDx;
  
  public t()
  {
    AppMethodBeat.i(6050);
    this.nDw = new ImageView[4];
    this.nDx = new View[4];
    AppMethodBeat.o(6050);
  }
  
  private boolean d(v paramv)
  {
    AppMethodBeat.i(6053);
    if ((this.mCount == 1) && (bs.isNullOrNil(paramv.hlf)))
    {
      AppMethodBeat.o(6053);
      return true;
    }
    AppMethodBeat.o(6053);
    return false;
  }
  
  public final void a(int paramInt1, v paramv, final com.tencent.mm.storage.t paramt, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6052);
    super.a(paramInt1, paramv, paramt, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.nCD = false;
    this.nCx.setVisibility(8);
    l.W(this.nDr, com.tencent.mm.plugin.brandservice.ui.timeline.c.nyZ);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.nDx.length)
    {
      localObject1 = this.nDx[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label101;
        }
        if (paramInt1 == this.nDx.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label101:
        ((View)localObject1).setVisibility(0);
        this.nDw[0] = ((ImageView)((View)localObject1).findViewById(2131297363));
        this.nDw[1] = ((ImageView)((View)localObject1).findViewById(2131297364));
        this.nDw[2] = ((ImageView)((View)localObject1).findViewById(2131297365));
        this.nDw[3] = ((ImageView)((View)localObject1).findViewById(2131297366));
      }
    }
    this.nDu.setBackgroundResource(2131233299);
    Object localObject2;
    if ((this.mCount == 1) && (!bs.isNullOrNil(paramv.hlf)))
    {
      this.nCz.setVisibility(0);
      this.nCB.ar(paramv.hlf);
      bool = d(paramv);
      if (this.nDw.length > 0)
      {
        localObject1 = this.nDw[0];
        localObject2 = paramv.hld;
        if ((localObject1 != null) && (!bs.isNullOrNil((String)localObject2)))
        {
          paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.c.nyZ;
          a.ig(this.mContext);
          a.getDensity(this.mContext);
          Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
          ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
          ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
          paramInt1 = localPoint.x;
          paramInt3 = localPoint.y;
          ((ImageView)localObject1).setVisibility(0);
          this.nDv.setImageResource(2131689781);
          this.nCM.nzn.a(paramt.field_msgId, 0, paramv, (String)localObject2, (ImageView)localObject1, paramInt1, paramInt3, false, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(6049);
              t.this.nCD = true;
              if (t.this.nDv != null) {
                t.this.nDv.setImageResource(2131689782);
              }
              if (t.this.nCx != null) {
                t.this.nCx.setVisibility(0);
              }
              View localView;
              if (t.this.nDu != null)
              {
                localView = t.this.nDu;
                if (!bool) {
                  break label153;
                }
              }
              label153:
              for (int i = 2131231281;; i = 2131231282)
              {
                localView.setBackgroundResource(i);
                if (this.nDz == 0)
                {
                  t.this.nCq.setTextColor(t.this.mContext.getResources().getColor(2131101182));
                  t.this.nCM.nzn.p(paramt.field_msgId, paramInt2);
                }
                AppMethodBeat.o(6049);
                return;
              }
            }
            
            public final void onStart() {}
          }, bool, this.nCF);
        }
      }
      if (paramv.hlt <= 1) {
        break label541;
      }
      this.nDt.setVisibility(0);
      this.nDt.setText(String.valueOf(paramv.hlt));
      label425:
      if (this.mCount != 1) {
        break label578;
      }
      if (!bool) {
        break label553;
      }
      this.nCN.setBackgroundResource(2131233299);
      this.nCN.setPadding(0, 0, 0, 0);
      label458:
      if (!d(paramv)) {
        break label601;
      }
      this.nCx.setBackgroundResource(2131231251);
      label475:
      a(this, paramt, paramv);
      localObject1 = this.nCM;
      localObject2 = this.nCN;
      if (this.mCount <= 1) {
        break label613;
      }
    }
    label541:
    label553:
    label578:
    label601:
    label613:
    for (final boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject1).a(paramv, paramt, paramInt2, paramu, (View)localObject2, bool, 0);
      AppMethodBeat.o(6052);
      return;
      this.nCz.setVisibility(8);
      break;
      this.nDt.setVisibility(8);
      break label425;
      this.nCN.setBackgroundResource(2131231256);
      this.nCN.setPadding(0, 0, 0, com.tencent.mm.plugin.brandservice.ui.timeline.c.nzb);
      break label458;
      this.nCN.setBackgroundResource(2131231262);
      this.nCN.setPadding(0, 0, 0, 0);
      break label458;
      this.nCx.setBackgroundResource(2131231253);
      break label475;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6051);
    super.a(paramView, paramc);
    if (this.nBh != null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramc = (ViewStub)paramView.findViewById(2131306452);
    if (paramc == null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramc.inflate();
    this.nBh = paramView.findViewById(2131297344);
    this.nCN = paramView.findViewById(2131298108);
    this.nDx[0] = this.nBh.findViewById(2131303260);
    this.nDx[1] = this.nBh.findViewById(2131303262);
    this.nDx[2] = this.nBh.findViewById(2131303261);
    this.nDx[3] = this.nBh.findViewById(2131303259);
    bKk();
    this.nDt = ((TextView)this.nBh.findViewById(2131303263));
    this.nDv = ((ImageView)this.nBh.findViewById(2131303256));
    this.nCx = ((ImageView)this.nBh.findViewById(2131303387));
    this.nDr = this.nBh.findViewById(2131298160);
    this.nDu = this.nBh.findViewById(2131297360);
    this.nCz = ((LinearLayout)this.nBh.findViewById(2131304830));
    this.nCB = ((MMNeat7extView)this.nBh.findViewById(2131304827));
    AppMethodBeat.o(6051);
  }
  
  public final void a(com.tencent.mm.storage.t paramt, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6054);
    super.a(paramt, paramv, paramView, paramTextView, paramInt);
    paramTextView.setTextColor(this.mContext.getResources().getColor(2131101182));
    AppMethodBeat.o(6054);
  }
  
  public final void dC(View paramView)
  {
    AppMethodBeat.i(210005);
    l.W(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c.nyZ);
    AppMethodBeat.o(210005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.t
 * JD-Core Version:    0.7.0.1
 */