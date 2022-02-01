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
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class as
  extends ak
{
  public View sDp;
  public TextView sHQ;
  View sHR;
  public ImageView sHS;
  public ImageView[] sHT;
  public View[] sHU;
  
  public as()
  {
    AppMethodBeat.i(6050);
    this.sHT = new ImageView[4];
    this.sHU = new View[4];
    AppMethodBeat.o(6050);
  }
  
  private boolean cAR()
  {
    return this.mCount == 1;
  }
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6052);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.sHc = false;
    this.sDf.setVisibility(8);
    ak.Y(this.sDp, b.sAq);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.sHU.length)
    {
      localObject1 = this.sHU[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label101;
        }
        if (paramInt1 == this.sHU.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label101:
        ((View)localObject1).setVisibility(0);
        this.sHT[0] = ((ImageView)((View)localObject1).findViewById(d.e.srm));
        this.sHT[1] = ((ImageView)((View)localObject1).findViewById(d.e.srn));
        this.sHT[2] = ((ImageView)((View)localObject1).findViewById(d.e.sro));
        this.sHT[3] = ((ImageView)((View)localObject1).findViewById(d.e.srp));
      }
    }
    this.sHR.setBackgroundResource(d.d.mm_trans);
    this.sDh.setVisibility(8);
    final boolean bool = cAR();
    Object localObject2;
    if (this.sHT.length > 0)
    {
      localObject1 = this.sHT[0];
      localObject2 = paramv.lpK;
      if ((localObject1 != null) && (!Util.isNullOrNil((String)localObject2)))
      {
        paramInt1 = b.sAq;
        a.kr(this.mContext);
        a.getDensity(this.mContext);
        Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
        ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
        ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
        paramInt1 = localPoint.x;
        paramInt3 = localPoint.y;
        ((ImageView)localObject1).setVisibility(0);
        this.sHS.setImageResource(d.h.biz_time_line_loading_pic_icon);
        this.sHf.sAc.a(paramz.field_msgId, 0, paramv, (String)localObject2, (ImageView)localObject1, paramInt1, paramInt3, false, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(6049);
            as.this.sHc = true;
            if (as.this.sHS != null) {
              as.this.sHS.setImageResource(d.h.biz_time_line_pic_icon);
            }
            if (as.this.sDf != null) {
              as.this.sDf.setVisibility(0);
            }
            View localView;
            if (as.this.sHR != null)
            {
              localView = as.this.sHR;
              if (!bool) {
                break label156;
              }
            }
            label156:
            for (int i = d.d.spI;; i = d.d.dmA)
            {
              localView.setBackgroundResource(i);
              if (this.sHW == 0)
              {
                as.this.sDl.setTextColor(as.this.mContext.getResources().getColor(d.b.white_text_color));
                as.this.sHf.sAc.p(paramz.field_msgId, paramInt2);
              }
              AppMethodBeat.o(6049);
              return;
            }
          }
          
          public final void onStart() {}
        }, bool, this.sHe);
      }
    }
    if (paramv.lqa > 1)
    {
      this.sHQ.setVisibility(0);
      this.sHQ.setText(String.valueOf(paramv.lqa));
      if (this.mCount != 1) {
        break label545;
      }
      if (!bool) {
        break label519;
      }
      this.sDd.setBackgroundResource(d.d.mm_trans);
      this.sDd.setPadding(0, 0, 0, 0);
      label436:
      if (!cAR()) {
        break label569;
      }
      this.sDf.setBackgroundResource(d.d.spA);
      label453:
      a(this, paramz, paramv);
      localObject1 = this.sHf;
      localObject2 = this.sDd;
      if (this.mCount <= 1) {
        break label582;
      }
    }
    label519:
    label545:
    label569:
    label582:
    for (bool = true;; bool = false)
    {
      ((b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool, 0);
      AppMethodBeat.o(6052);
      return;
      this.sHQ.setVisibility(8);
      break;
      this.sDd.setBackgroundResource(d.d.spE);
      this.sDd.setPadding(0, 0, 0, b.sAt);
      break label436;
      this.sDd.setBackgroundResource(d.d.spF);
      this.sDd.setPadding(0, 0, 0, 0);
      break label436;
      this.sDf.setBackgroundResource(d.d.spC);
      break label453;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6051);
    super.a(paramView, paramb);
    if (this.sEi != null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.stA);
    if (paramb == null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb.inflate();
    this.sEi = paramView.findViewById(d.e.sqM);
    this.sDd = paramView.findViewById(d.e.sry);
    this.sHU[0] = this.sEi.findViewById(d.e.ssn);
    this.sHU[1] = this.sEi.findViewById(d.e.ssp);
    this.sHU[2] = this.sEi.findViewById(d.e.sso);
    this.sHU[3] = this.sEi.findViewById(d.e.ssm);
    cAo();
    this.sHQ = ((TextView)this.sEi.findViewById(d.e.dRg));
    this.sHS = ((ImageView)this.sEi.findViewById(d.e.dRf));
    this.sDf = ((ImageView)this.sEi.findViewById(d.e.dRn));
    this.sDp = this.sEi.findViewById(d.e.dza);
    this.sHR = this.sEi.findViewById(d.e.sre);
    this.sDh = ((LinearLayout)this.sEi.findViewById(d.e.dVq));
    this.sDj = ((MMNeat7extView)this.sEi.findViewById(d.e.dVp));
    AppMethodBeat.o(6051);
  }
  
  public final void a(z paramz, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6054);
    super.a(paramz, paramv, paramView, paramTextView, paramInt);
    paramTextView.setTextColor(this.mContext.getResources().getColor(d.b.white_text_color));
    AppMethodBeat.o(6054);
  }
  
  public final void dU(View paramView)
  {
    AppMethodBeat.i(293179);
    ak.Y(paramView, b.sAq);
    AppMethodBeat.o(293179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.as
 * JD-Core Version:    0.7.0.1
 */