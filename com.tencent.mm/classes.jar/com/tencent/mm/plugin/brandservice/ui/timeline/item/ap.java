package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.storage.z;

public final class ap
  extends ai
{
  public ImageView kc;
  public ImageView ptE;
  public View puc;
  
  public final void a(int paramInt1, v paramv, final z paramz, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6048);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    dw(this.puc);
    this.ptG.setVisibility(8);
    this.ptY.setTextColor(this.mContext.getResources().getColor(2131100679));
    this.kc.setBackgroundResource(2131689926);
    Object localObject3 = this.pxE.prc;
    long l = paramz.field_msgId;
    String str = paramv.iAo;
    Object localObject1 = this.ptE;
    int k = com.tencent.mm.plugin.brandservice.ui.timeline.b.prq;
    Object localObject2 = new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6046);
        ap.this.ptG.setVisibility(0);
        ap.this.ptY.setTextColor(ap.this.mContext.getResources().getColor(2131101427));
        ap.this.kc.setBackgroundResource(2131689793);
        ap.this.pxE.prc.m(paramz.field_msgId, paramInt2);
        AppMethodBeat.o(6046);
      }
      
      public final void onStart() {}
    };
    int i;
    label175:
    int j;
    if (paramInt1 == 1)
    {
      bool = true;
      ((ImageView)localObject1).setContentDescription(((d)localObject3).pro.getString(2131757392));
      str = d.OO(str);
      Object localObject4 = g.Kev;
      if (g.aig(1))
      {
        localObject4 = com.tencent.mm.pluginsdk.model.a.JUl;
        com.tencent.mm.pluginsdk.model.a.n(l, 0, paramv.url);
      }
      if (!bool) {
        break label418;
      }
      i = 2131231305;
      if (!bool) {
        break label424;
      }
      j = 2131231307;
      label184:
      float f = com.tencent.mm.cb.a.fromDPToPix(((d)localObject3).pro, 8);
      int m = ((d)localObject3).getContentWidth();
      localObject3 = com.tencent.mm.pluginsdk.model.b.JUJ;
      localObject3 = new c.a();
      ((c.a)localObject3).jbt = j;
      ((c.a)localObject3).jbf = true;
      localObject3 = ((c.a)localObject3).dr(m, k);
      ((c.a)localObject3).jbv = String.valueOf(i);
      ((c.a)localObject3).jaU = new n(1);
      ((c.a)localObject3).jbC = new e(1);
      ((c.a)localObject3).jbD = new l();
      ((c.a)localObject3).fullPath = s.bdu(str);
      com.tencent.mm.pluginsdk.model.b.a(l, 0, paramv, str, (ImageView)localObject1, paramInt3, false, ((c.a)localObject3).bdv(), new m(1, m, k, false, bool, f, (m.a)localObject2));
      a(this, paramz, paramv);
      localObject1 = this.pxE;
      localObject2 = this.ptQ;
      if (paramInt1 <= 1) {
        break label431;
      }
    }
    label418:
    label424:
    label431:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramz, paramInt2, paramu, (View)localObject2, bool, 0);
      if (paramInt1 != 1) {
        break label437;
      }
      this.ptS.setBackgroundResource(2131231311);
      this.ptG.setBackgroundResource(2131231336);
      AppMethodBeat.o(6048);
      return;
      bool = false;
      break;
      i = 0;
      break label175;
      j = 2131231312;
      break label184;
    }
    label437:
    this.ptS.setBackgroundResource(2131231313);
    this.ptG.setBackgroundResource(2131231337);
    AppMethodBeat.o(6048);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6047);
    super.a(paramView, paramb);
    if (this.puO != null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131309894);
    if (paramb == null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb.inflate();
    this.puO = paramView.findViewById(2131297556);
    this.ptQ = paramView.findViewById(2131298458);
    cmH();
    this.ptE = ((ImageView)this.puO.findViewById(2131299277));
    this.ptG = ((ImageView)this.puO.findViewById(2131299291));
    this.kc = ((ImageView)this.puO.findViewById(2131305927));
    this.puc = this.puO.findViewById(2131298538);
    this.ptS = ((ImageView)this.puO.findViewById(2131306101));
    AppMethodBeat.o(6047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ap
 * JD-Core Version:    0.7.0.1
 */