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
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aq
  extends ai
{
  public View puc;
  public TextView pyn;
  View pyo;
  public ImageView pyp;
  public ImageView[] pyq;
  public View[] pyr;
  
  public aq()
  {
    AppMethodBeat.i(6050);
    this.pyq = new ImageView[4];
    this.pyr = new View[4];
    AppMethodBeat.o(6050);
  }
  
  private boolean cng()
  {
    return this.mCount == 1;
  }
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6052);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.pxB = false;
    this.ptS.setVisibility(8);
    ai.W(this.puc, b.prs);
    paramInt1 = 0;
    Object localObject1;
    if (paramInt1 < this.pyr.length)
    {
      localObject1 = this.pyr[paramInt1];
      if (localObject1 != null)
      {
        if (paramInt1 == 0) {
          break label101;
        }
        if (paramInt1 == this.pyr.length - 1) {}
        ((View)localObject1).setVisibility(8);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        label101:
        ((View)localObject1).setVisibility(0);
        this.pyq[0] = ((ImageView)((View)localObject1).findViewById(2131297581));
        this.pyq[1] = ((ImageView)((View)localObject1).findViewById(2131297582));
        this.pyq[2] = ((ImageView)((View)localObject1).findViewById(2131297583));
        this.pyq[3] = ((ImageView)((View)localObject1).findViewById(2131297584));
      }
    }
    this.pyo.setBackgroundResource(2131233974);
    this.ptU.setVisibility(8);
    final boolean bool = cng();
    Object localObject2;
    if (this.pyq.length > 0)
    {
      localObject1 = this.pyq[0];
      localObject2 = paramv.iAo;
      if ((localObject1 != null) && (!Util.isNullOrNil((String)localObject2)))
      {
        paramInt1 = b.prs;
        a.jn(this.mContext);
        a.getDensity(this.mContext);
        Point localPoint = new Point((int)(paramInt1 * 1.777778F), paramInt1);
        ((ImageView)localObject1).getLayoutParams().width = localPoint.x;
        ((ImageView)localObject1).getLayoutParams().height = localPoint.y;
        paramInt1 = localPoint.x;
        paramInt3 = localPoint.y;
        ((ImageView)localObject1).setVisibility(0);
        this.pyp.setImageResource(2131689792);
        this.pxE.prc.a(paramz.field_msgId, 0, paramv, (String)localObject2, (ImageView)localObject1, paramInt1, paramInt3, false, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(6049);
            aq.this.pxB = true;
            if (aq.this.pyp != null) {
              aq.this.pyp.setImageResource(2131689793);
            }
            if (aq.this.ptS != null) {
              aq.this.ptS.setVisibility(0);
            }
            View localView;
            if (aq.this.pyo != null)
            {
              localView = aq.this.pyo;
              if (!bool) {
                break label153;
              }
            }
            label153:
            for (int i = 2131231341;; i = 2131231342)
            {
              localView.setBackgroundResource(i);
              if (this.pyt == 0)
              {
                aq.this.ptY.setTextColor(aq.this.mContext.getResources().getColor(2131101427));
                aq.this.pxE.prc.m(paramz.field_msgId, paramInt2);
              }
              AppMethodBeat.o(6049);
              return;
            }
          }
          
          public final void onStart() {}
        }, bool, this.pxD);
      }
    }
    if (paramv.iAC > 1)
    {
      this.pyn.setVisibility(0);
      this.pyn.setText(String.valueOf(paramv.iAC));
      if (this.mCount != 1) {
        break label536;
      }
      if (!bool) {
        break label511;
      }
      this.ptQ.setBackgroundResource(2131233974);
      this.ptQ.setPadding(0, 0, 0, 0);
      label429:
      if (!cng()) {
        break label559;
      }
      this.ptS.setBackgroundResource(2131231311);
      label445:
      a(this, paramz, paramv);
      localObject1 = this.pxE;
      localObject2 = this.ptQ;
      if (this.mCount <= 1) {
        break label571;
      }
    }
    label536:
    label559:
    label571:
    for (bool = true;; bool = false)
    {
      ((b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool, 0);
      AppMethodBeat.o(6052);
      return;
      this.pyn.setVisibility(8);
      break;
      label511:
      this.ptQ.setBackgroundResource(2131231316);
      this.ptQ.setPadding(0, 0, 0, b.prv);
      break label429;
      this.ptQ.setBackgroundResource(2131231322);
      this.ptQ.setPadding(0, 0, 0, 0);
      break label429;
      this.ptS.setBackgroundResource(2131231313);
      break label445;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6051);
    super.a(paramView, paramb);
    if (this.puO != null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131309895);
    if (paramb == null)
    {
      AppMethodBeat.o(6051);
      return;
    }
    paramb.inflate();
    this.puO = paramView.findViewById(2131297555);
    this.ptQ = paramView.findViewById(2131298458);
    this.pyr[0] = this.puO.findViewById(2131305931);
    this.pyr[1] = this.puO.findViewById(2131305933);
    this.pyr[2] = this.puO.findViewById(2131305932);
    this.pyr[3] = this.puO.findViewById(2131305930);
    cmH();
    this.pyn = ((TextView)this.puO.findViewById(2131305934));
    this.pyp = ((ImageView)this.puO.findViewById(2131305927));
    this.ptS = ((ImageView)this.puO.findViewById(2131306101));
    this.puc = this.puO.findViewById(2131298538);
    this.pyo = this.puO.findViewById(2131297574);
    this.ptU = ((LinearLayout)this.puO.findViewById(2131307916));
    this.ptW = ((MMNeat7extView)this.puO.findViewById(2131307913));
    AppMethodBeat.o(6051);
  }
  
  public final void a(z paramz, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6054);
    super.a(paramz, paramv, paramView, paramTextView, paramInt);
    paramTextView.setTextColor(this.mContext.getResources().getColor(2131101427));
    AppMethodBeat.o(6054);
  }
  
  public final void dw(View paramView)
  {
    AppMethodBeat.i(258318);
    ai.W(paramView, b.prs);
    AppMethodBeat.o(258318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aq
 * JD-Core Version:    0.7.0.1
 */