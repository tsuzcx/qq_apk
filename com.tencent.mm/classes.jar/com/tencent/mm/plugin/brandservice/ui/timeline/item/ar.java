package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.storage.z;

public final class ar
  extends ak
{
  public ImageView bwJ;
  public ImageView sCR;
  public View sDp;
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6048);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    dU(this.sDp);
    this.sCT.setVisibility(8);
    this.sDl.setTextColor(this.mContext.getResources().getColor(d.b.light_grey_text_color));
    this.bwJ.setBackgroundResource(d.h.chatting_item_biz_pic_loading_icon);
    Object localObject3 = this.sHf.sAc;
    long l = paramz.field_msgId;
    String str = paramv.lpK;
    Object localObject1 = this.sCR;
    int k = b.sAo;
    Object localObject2 = new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6046);
        ar.this.sCT.setVisibility(0);
        ar.this.sDl.setTextColor(ar.this.mContext.getResources().getColor(d.b.white_text_color));
        ar.this.bwJ.setBackgroundResource(d.h.biz_time_line_pic_icon);
        ar.this.sHf.sAc.p(paramz.field_msgId, paramInt2);
        AppMethodBeat.o(6046);
      }
      
      public final void onStart() {}
    };
    int i;
    label179:
    int j;
    if (paramInt1 == 1)
    {
      bool = true;
      ((ImageView)localObject1).setContentDescription(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).sAm.getString(d.i.chatting_img_item_desc));
      str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.Wm(str);
      Object localObject4 = g.Rfj;
      if (g.aqi(1))
      {
        localObject4 = c.QUt;
        c.m(l, 0, paramv.url);
      }
      if (!bool) {
        break label425;
      }
      i = d.d.spx;
      if (!bool) {
        break label431;
      }
      j = d.d.spy;
      label189:
      float f = a.fromDPToPix(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).sAm, 8);
      int m = ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject3).getContentWidth();
      localObject3 = com.tencent.mm.pluginsdk.model.d.QUR;
      localObject3 = new c.a();
      ((c.a)localObject3).lRS = j;
      ((c.a)localObject3).lRD = true;
      localObject3 = ((c.a)localObject3).dO(m, k);
      ((c.a)localObject3).lRU = String.valueOf(i);
      ((c.a)localObject3).lRs = new n(1);
      ((c.a)localObject3).lSb = new e(1);
      ((c.a)localObject3).lSc = new l();
      ((c.a)localObject3).fullPath = w.bpO(str);
      com.tencent.mm.pluginsdk.model.d.a(l, 0, paramv, str, (ImageView)localObject1, paramInt3, false, ((c.a)localObject3).bmL(), new m(1, m, k, false, bool, f, (m.a)localObject2));
      a(this, paramz, paramv);
      localObject1 = this.sHf;
      localObject2 = this.sDd;
      if (paramInt1 <= 1) {
        break label439;
      }
    }
    label425:
    label431:
    label439:
    for (boolean bool = true;; bool = false)
    {
      ((b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool, 0);
      if (paramInt1 != 1) {
        break label445;
      }
      this.sDf.setBackgroundResource(d.d.spA);
      this.sCT.setBackgroundResource(d.d.spG);
      AppMethodBeat.o(6048);
      return;
      bool = false;
      break;
      i = 0;
      break label179;
      j = d.d.spB;
      break label189;
    }
    label445:
    this.sDf.setBackgroundResource(d.d.spC);
    this.sCT.setBackgroundResource(d.d.spH);
    AppMethodBeat.o(6048);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6047);
    super.a(paramView, paramb);
    if (this.sEi != null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.dZx);
    if (paramb == null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb.inflate();
    this.sEi = paramView.findViewById(d.e.sqN);
    this.sDd = paramView.findViewById(d.e.sry);
    cAo();
    this.sCR = ((ImageView)this.sEi.findViewById(d.e.cover));
    this.sCT = ((ImageView)this.sEi.findViewById(d.e.dCV));
    this.bwJ = ((ImageView)this.sEi.findViewById(d.e.dRf));
    this.sDp = this.sEi.findViewById(d.e.dza);
    this.sDf = ((ImageView)this.sEi.findViewById(d.e.dRn));
    AppMethodBeat.o(6047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ar
 * JD-Core Version:    0.7.0.1
 */