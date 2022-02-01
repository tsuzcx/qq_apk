package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.storage.w;

public final class ae
  extends x
{
  public ImageView ka;
  public View ocL;
  public ImageView ocn;
  
  public final void a(int paramInt1, v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6048);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    dF(this.ocL);
    this.ocp.setVisibility(8);
    this.ocH.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.ka.setBackgroundResource(2131689911);
    Object localObject3 = this.ofm.oas;
    long l = paramw.field_msgId;
    String str = paramv.hDm;
    Object localObject1 = this.ocn;
    int k = com.tencent.mm.plugin.brandservice.ui.timeline.b.oad;
    Object localObject2 = new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6046);
        ae.this.ocp.setVisibility(0);
        ae.this.ocH.setTextColor(ae.this.mContext.getResources().getColor(2131101182));
        ae.this.ka.setBackgroundResource(2131689782);
        ae.this.ofm.oas.p(paramw.field_msgId, paramInt2);
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
      ((ImageView)localObject1).setContentDescription(((c)localObject3).oac.getString(2131757186));
      str = c.FB(str);
      Object localObject4 = g.EVk;
      if (g.YP(1))
      {
        localObject4 = com.tencent.mm.pluginsdk.model.a.EKY;
        com.tencent.mm.pluginsdk.model.a.m(l, 0, paramv.url);
      }
      if (!bool) {
        break label418;
      }
      i = 2131231245;
      if (!bool) {
        break label424;
      }
      j = 2131231247;
      label184:
      float f = com.tencent.mm.cc.a.fromDPToPix(((c)localObject3).oac, 8);
      int m = ((c)localObject3).getContentWidth();
      localObject3 = com.tencent.mm.pluginsdk.model.b.ELx;
      localObject3 = new c.a();
      ((c.a)localObject3).idG = j;
      ((c.a)localObject3).idr = true;
      localObject3 = ((c.a)localObject3).dh(m, k);
      ((c.a)localObject3).idI = String.valueOf(i);
      ((c.a)localObject3).idg = new n(1);
      ((c.a)localObject3).idP = new e(1);
      ((c.a)localObject3).idQ = new l();
      ((c.a)localObject3).hdP = r.aLC(str);
      com.tencent.mm.pluginsdk.model.b.a(l, 0, paramv, str, (ImageView)localObject1, paramInt3, false, ((c.a)localObject3).aJc(), new m(1, m, k, false, bool, f, (m.a)localObject2));
      a(this, paramw, paramv);
      localObject1 = this.ofm;
      localObject2 = this.ocz;
      if (paramInt1 <= 1) {
        break label431;
      }
    }
    label418:
    label424:
    label431:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a(paramv, paramw, paramInt2, paramu, (View)localObject2, bool, 0);
      if (paramInt1 != 1) {
        break label437;
      }
      this.ocB.setBackgroundResource(2131231251);
      this.ocp.setBackgroundResource(2131231276);
      AppMethodBeat.o(6048);
      return;
      bool = false;
      break;
      i = 0;
      break label175;
      j = 2131231252;
      break label184;
    }
    label437:
    this.ocB.setBackgroundResource(2131231253);
    this.ocp.setBackgroundResource(2131231277);
    AppMethodBeat.o(6048);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6047);
    super.a(paramView, paramb);
    if (this.odh != null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306451);
    if (paramb == null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramb.inflate();
    this.odh = paramView.findViewById(2131297345);
    this.ocz = paramView.findViewById(2131298108);
    bOx();
    this.ocn = ((ImageView)this.odh.findViewById(2131298813));
    this.ocp = ((ImageView)this.odh.findViewById(2131298826));
    this.ka = ((ImageView)this.odh.findViewById(2131303256));
    this.ocL = this.odh.findViewById(2131298160);
    this.ocB = ((ImageView)this.odh.findViewById(2131303387));
    AppMethodBeat.o(6047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ae
 * JD-Core Version:    0.7.0.1
 */