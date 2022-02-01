package com.tencent.mm.plugin.brandservice.ui.timeline.item;

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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class af
  extends x
{
  public View ocL;
  public TextView ofR;
  View ofS;
  public ImageView ofT;
  public ImageView[] ofU;
  public View[] ofV;
  
  public af()
  {
    AppMethodBeat.i(6050);
    this.ofU = new ImageView[4];
    this.ofV = new View[4];
    AppMethodBeat.o(6050);
  }
  
  private boolean d(v paramv)
  {
    AppMethodBeat.i(6053);
    if ((this.mCount == 1) && (bt.isNullOrNil(paramv.hDo)))
    {
      AppMethodBeat.o(6053);
      return true;
    }
    AppMethodBeat.o(6053);
    return false;
  }
  
  public final void a(int paramInt1, v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6052);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.ofc = false;
    this.ocB.setVisibility(8);
    x.X(this.ocL, b.oae);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.ofV.length)
    {
      localObject1 = this.ofV[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label101;
        }
        if (paramInt1 == this.ofV.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label101:
        ((View)localObject1).setVisibility(0);
        this.ofU[0] = ((ImageView)((View)localObject1).findViewById(2131297363));
        this.ofU[1] = ((ImageView)((View)localObject1).findViewById(2131297364));
        this.ofU[2] = ((ImageView)((View)localObject1).findViewById(2131297365));
        this.ofU[3] = ((ImageView)((View)localObject1).findViewById(2131297366));
      }
    }
    this.ofS.setBackgroundResource(2131233299);
    Object localObject2;
    if ((this.mCount == 1) && (!bt.isNullOrNil(paramv.hDo)))
    {
      this.ocD.setVisibility(0);
      this.ocF.ar(paramv.hDo);
      bool = d(paramv);
      if (this.ofU.length > 0)
      {
        localObject1 = this.ofU[0];
        localObject2 = paramv.hDm;
        if ((localObject1 != null) && (!bt.isNullOrNil((String)localObject2)))
        {
          paramInt1 = b.oae;
          a.ip(this.mContext);
          a.getDensity(this.mContext);
          Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
          ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
          ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
          paramInt1 = localPoint.x;
          paramInt3 = localPoint.y;
          ((ImageView)localObject1).setVisibility(0);
          this.ofT.setImageResource(2131689781);
          this.ofm.oas.a(paramw.field_msgId, 0, paramv, (String)localObject2, (ImageView)localObject1, paramInt1, paramInt3, false, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(6049);
              af.this.ofc = true;
              if (af.this.ofT != null) {
                af.this.ofT.setImageResource(2131689782);
              }
              if (af.this.ocB != null) {
                af.this.ocB.setVisibility(0);
              }
              View localView;
              if (af.this.ofS != null)
              {
                localView = af.this.ofS;
                if (!bool) {
                  break label153;
                }
              }
              label153:
              for (int i = 2131231281;; i = 2131231282)
              {
                localView.setBackgroundResource(i);
                if (this.ofX == 0)
                {
                  af.this.ocH.setTextColor(af.this.mContext.getResources().getColor(2131101182));
                  af.this.ofm.oas.p(paramw.field_msgId, paramInt2);
                }
                AppMethodBeat.o(6049);
                return;
              }
            }
            
            public final void onStart() {}
          }, bool, this.ofe);
        }
      }
      if (paramv.hDC <= 1) {
        break label541;
      }
      this.ofR.setVisibility(0);
      this.ofR.setText(String.valueOf(paramv.hDC));
      label425:
      if (this.mCount != 1) {
        break label578;
      }
      if (!bool) {
        break label553;
      }
      this.ocz.setBackgroundResource(2131233299);
      this.ocz.setPadding(0, 0, 0, 0);
      label458:
      if (!d(paramv)) {
        break label601;
      }
      this.ocB.setBackgroundResource(2131231251);
      label475:
      a(this, paramw, paramv);
      localObject1 = this.ofm;
      localObject2 = this.ocz;
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
      ((b)localObject1).a(paramv, paramw, paramInt2, paramu, (View)localObject2, bool, 0);
      AppMethodBeat.o(6052);
      return;
      this.ocD.setVisibility(8);
      break;
      this.ofR.setVisibility(8);
      break label425;
      this.ocz.setBackgroundResource(2131231256);
      this.ocz.setPadding(0, 0, 0, b.oag);
      break label458;
      this.ocz.setBackgroundResource(2131231262);
      this.ocz.setPadding(0, 0, 0, 0);
      break label458;
      this.ocB.setBackgroundResource(2131231253);
      break label475;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6051);
    super.a(paramView, paramb);
    if (this.odh != null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306452);
    if (paramb == null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb.inflate();
    this.odh = paramView.findViewById(2131297344);
    this.ocz = paramView.findViewById(2131298108);
    this.ofV[0] = this.odh.findViewById(2131303260);
    this.ofV[1] = this.odh.findViewById(2131303262);
    this.ofV[2] = this.odh.findViewById(2131303261);
    this.ofV[3] = this.odh.findViewById(2131303259);
    bOx();
    this.ofR = ((TextView)this.odh.findViewById(2131303263));
    this.ofT = ((ImageView)this.odh.findViewById(2131303256));
    this.ocB = ((ImageView)this.odh.findViewById(2131303387));
    this.ocL = this.odh.findViewById(2131298160);
    this.ofS = this.odh.findViewById(2131297360);
    this.ocD = ((LinearLayout)this.odh.findViewById(2131304830));
    this.ocF = ((MMNeat7extView)this.odh.findViewById(2131304827));
    AppMethodBeat.o(6051);
  }
  
  public final void a(w paramw, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6054);
    super.a(paramw, paramv, paramView, paramTextView, paramInt);
    paramTextView.setTextColor(this.mContext.getResources().getColor(2131101182));
    AppMethodBeat.o(6054);
  }
  
  public final void dF(View paramView)
  {
    AppMethodBeat.i(221698);
    x.X(paramView, b.oae);
    AppMethodBeat.o(221698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.af
 * JD-Core Version:    0.7.0.1
 */