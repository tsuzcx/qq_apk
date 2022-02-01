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
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.cd.a;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class t
  extends l
{
  public View naT;
  public TextView naV;
  View naW;
  public ImageView naX;
  public ImageView[] naY;
  public View[] naZ;
  
  public t()
  {
    AppMethodBeat.i(6050);
    this.naY = new ImageView[4];
    this.naZ = new View[4];
    AppMethodBeat.o(6050);
  }
  
  private boolean d(v paramv)
  {
    AppMethodBeat.i(6053);
    if ((this.mCount == 1) && (bt.isNullOrNil(paramv.gKF)))
    {
      AppMethodBeat.o(6053);
      return true;
    }
    AppMethodBeat.o(6053);
    return false;
  }
  
  public final void a(int paramInt1, v paramv, final s params, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6052);
    super.a(paramInt1, paramv, params, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.naf = false;
    this.mZZ.setVisibility(8);
    l.V(this.naT, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWA);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.naZ.length)
    {
      localObject1 = this.naZ[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label101;
        }
        if (paramInt1 == this.naZ.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label101:
        ((View)localObject1).setVisibility(0);
        this.naY[0] = ((ImageView)((View)localObject1).findViewById(2131297363));
        this.naY[1] = ((ImageView)((View)localObject1).findViewById(2131297364));
        this.naY[2] = ((ImageView)((View)localObject1).findViewById(2131297365));
        this.naY[3] = ((ImageView)((View)localObject1).findViewById(2131297366));
      }
    }
    this.naW.setBackgroundResource(2131233299);
    Object localObject2;
    if ((this.mCount == 1) && (!bt.isNullOrNil(paramv.gKF)))
    {
      this.nab.setVisibility(0);
      this.nad.aq(paramv.gKF);
      bool = d(paramv);
      if (this.naY.length > 0)
      {
        localObject1 = this.naY[0];
        localObject2 = paramv.gKD;
        if ((localObject1 != null) && (!bt.isNullOrNil((String)localObject2)))
        {
          paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWA;
          a.hV(this.mContext);
          a.getDensity(this.mContext);
          Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
          ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
          ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
          paramInt1 = localPoint.x;
          paramInt3 = localPoint.y;
          ((ImageView)localObject1).setVisibility(0);
          this.naX.setImageResource(2131689781);
          this.nao.mWO.a(params.field_msgId, 0, paramv, (String)localObject2, (ImageView)localObject1, paramInt1, paramInt3, false, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(6049);
              t.this.naf = true;
              if (t.this.naX != null) {
                t.this.naX.setImageResource(2131689782);
              }
              if (t.this.mZZ != null) {
                t.this.mZZ.setVisibility(0);
              }
              View localView;
              if (t.this.naW != null)
              {
                localView = t.this.naW;
                if (!bool) {
                  break label153;
                }
              }
              label153:
              for (int i = 2131231281;; i = 2131231282)
              {
                localView.setBackgroundResource(i);
                if (this.nbb == 0)
                {
                  t.this.mZS.setTextColor(t.this.mContext.getResources().getColor(2131101182));
                  t.this.nao.mWO.o(params.field_msgId, paramInt2);
                }
                AppMethodBeat.o(6049);
                return;
              }
            }
            
            public final void onStart() {}
          }, bool, this.nah);
        }
      }
      if (paramv.gKT <= 1) {
        break label541;
      }
      this.naV.setVisibility(0);
      this.naV.setText(String.valueOf(paramv.gKT));
      label425:
      if (this.mCount != 1) {
        break label578;
      }
      if (!bool) {
        break label553;
      }
      this.nap.setBackgroundResource(2131233299);
      this.nap.setPadding(0, 0, 0, 0);
      label458:
      if (!d(paramv)) {
        break label601;
      }
      this.mZZ.setBackgroundResource(2131231251);
      label475:
      a(this, params, paramv);
      localObject1 = this.nao;
      localObject2 = this.nap;
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
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject1).a(paramv, params, paramInt2, paramu, (View)localObject2, bool, 0);
      AppMethodBeat.o(6052);
      return;
      this.nab.setVisibility(8);
      break;
      this.naV.setVisibility(8);
      break label425;
      this.nap.setBackgroundResource(2131231256);
      this.nap.setPadding(0, 0, 0, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWC);
      break label458;
      this.nap.setBackgroundResource(2131231262);
      this.nap.setPadding(0, 0, 0, 0);
      break label458;
      this.mZZ.setBackgroundResource(2131231253);
      break label475;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6051);
    super.a(paramView, paramc);
    if (this.mYI != null)
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
    this.mYI = paramView.findViewById(2131297344);
    this.nap = paramView.findViewById(2131298108);
    this.naZ[0] = this.mYI.findViewById(2131303260);
    this.naZ[1] = this.mYI.findViewById(2131303262);
    this.naZ[2] = this.mYI.findViewById(2131303261);
    this.naZ[3] = this.mYI.findViewById(2131303259);
    bDb();
    this.naV = ((TextView)this.mYI.findViewById(2131303263));
    this.naX = ((ImageView)this.mYI.findViewById(2131303256));
    this.mZZ = ((ImageView)this.mYI.findViewById(2131303387));
    this.naT = this.mYI.findViewById(2131298160);
    this.naW = this.mYI.findViewById(2131297360);
    this.nab = ((LinearLayout)this.mYI.findViewById(2131304830));
    this.nad = ((MMNeat7extView)this.mYI.findViewById(2131304827));
    AppMethodBeat.o(6051);
  }
  
  public final void a(s params, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6054);
    super.a(params, paramv, paramView, paramTextView, paramInt);
    paramTextView.setTextColor(this.mContext.getResources().getColor(2131101182));
    AppMethodBeat.o(6054);
  }
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(205023);
    l.V(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWA);
    AppMethodBeat.o(205023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.t
 * JD-Core Version:    0.7.0.1
 */