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
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ag
  extends y
{
  public View oiA;
  public TextView olP;
  View olQ;
  public ImageView olR;
  public ImageView[] olS;
  public View[] olT;
  
  public ag()
  {
    AppMethodBeat.i(6050);
    this.olS = new ImageView[4];
    this.olT = new View[4];
    AppMethodBeat.o(6050);
  }
  
  private boolean d(v paramv)
  {
    AppMethodBeat.i(6053);
    if ((this.mCount == 1) && (bu.isNullOrNil(paramv.hGg)))
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
    this.olc = false;
    this.oiq.setVisibility(8);
    y.X(this.oiA, b.ofU);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.olT.length)
    {
      localObject1 = this.olT[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label101;
        }
        if (paramInt1 == this.olT.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label101:
        ((View)localObject1).setVisibility(0);
        this.olS[0] = ((ImageView)((View)localObject1).findViewById(2131297363));
        this.olS[1] = ((ImageView)((View)localObject1).findViewById(2131297364));
        this.olS[2] = ((ImageView)((View)localObject1).findViewById(2131297365));
        this.olS[3] = ((ImageView)((View)localObject1).findViewById(2131297366));
      }
    }
    this.olQ.setBackgroundResource(2131233299);
    Object localObject2;
    if ((this.mCount == 1) && (!bu.isNullOrNil(paramv.hGg)))
    {
      this.ois.setVisibility(0);
      this.oiu.aq(paramv.hGg);
      bool = d(paramv);
      if (this.olS.length > 0)
      {
        localObject1 = this.olS[0];
        localObject2 = paramv.hGe;
        if ((localObject1 != null) && (!bu.isNullOrNil((String)localObject2)))
        {
          paramInt1 = b.ofU;
          a.iu(this.mContext);
          a.getDensity(this.mContext);
          Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
          ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
          ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
          paramInt1 = localPoint.x;
          paramInt3 = localPoint.y;
          ((ImageView)localObject1).setVisibility(0);
          this.olR.setImageResource(2131689781);
          this.oll.ogi.a(paramw.field_msgId, 0, paramv, (String)localObject2, (ImageView)localObject1, paramInt1, paramInt3, false, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(6049);
              ag.this.olc = true;
              if (ag.this.olR != null) {
                ag.this.olR.setImageResource(2131689782);
              }
              if (ag.this.oiq != null) {
                ag.this.oiq.setVisibility(0);
              }
              View localView;
              if (ag.this.olQ != null)
              {
                localView = ag.this.olQ;
                if (!bool) {
                  break label153;
                }
              }
              label153:
              for (int i = 2131231281;; i = 2131231282)
              {
                localView.setBackgroundResource(i);
                if (this.olV == 0)
                {
                  ag.this.oiw.setTextColor(ag.this.mContext.getResources().getColor(2131101182));
                  ag.this.oll.ogi.p(paramw.field_msgId, paramInt2);
                }
                AppMethodBeat.o(6049);
                return;
              }
            }
            
            public final void onStart() {}
          }, bool, this.ole);
        }
      }
      if (paramv.hGu <= 1) {
        break label541;
      }
      this.olP.setVisibility(0);
      this.olP.setText(String.valueOf(paramv.hGu));
      label425:
      if (this.mCount != 1) {
        break label578;
      }
      if (!bool) {
        break label553;
      }
      this.oio.setBackgroundResource(2131233299);
      this.oio.setPadding(0, 0, 0, 0);
      label458:
      if (!d(paramv)) {
        break label601;
      }
      this.oiq.setBackgroundResource(2131231251);
      label475:
      a(this, paramw, paramv);
      localObject1 = this.oll;
      localObject2 = this.oio;
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
      this.ois.setVisibility(8);
      break;
      this.olP.setVisibility(8);
      break label425;
      this.oio.setBackgroundResource(2131231256);
      this.oio.setPadding(0, 0, 0, b.ofW);
      break label458;
      this.oio.setBackgroundResource(2131231262);
      this.oio.setPadding(0, 0, 0, 0);
      break label458;
      this.oiq.setBackgroundResource(2131231253);
      break label475;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6051);
    super.a(paramView, paramb);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131297344);
    this.oio = paramView.findViewById(2131298108);
    this.olT[0] = this.oiV.findViewById(2131303260);
    this.olT[1] = this.oiV.findViewById(2131303262);
    this.olT[2] = this.oiV.findViewById(2131303261);
    this.olT[3] = this.oiV.findViewById(2131303259);
    bPv();
    this.olP = ((TextView)this.oiV.findViewById(2131303263));
    this.olR = ((ImageView)this.oiV.findViewById(2131303256));
    this.oiq = ((ImageView)this.oiV.findViewById(2131303387));
    this.oiA = this.oiV.findViewById(2131298160);
    this.olQ = this.oiV.findViewById(2131297360);
    this.ois = ((LinearLayout)this.oiV.findViewById(2131304830));
    this.oiu = ((MMNeat7extView)this.oiV.findViewById(2131304827));
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
    AppMethodBeat.i(224127);
    y.X(paramView, b.ofU);
    AppMethodBeat.o(224127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ag
 * JD-Core Version:    0.7.0.1
 */