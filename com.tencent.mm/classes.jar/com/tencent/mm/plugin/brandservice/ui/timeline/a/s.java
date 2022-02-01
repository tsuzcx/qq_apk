package com.tencent.mm.plugin.brandservice.ui.timeline.a;

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
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;

public final class s
  extends l
{
  public ImageView hg;
  public ImageView mZN;
  public View naT;
  
  public final void a(int paramInt1, v paramv, final com.tencent.mm.storage.s params, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6048);
    super.a(paramInt1, paramv, params, paramInt2, paramu, paramInt3);
    dA(this.naT);
    this.mZY.setVisibility(8);
    this.mZS.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.hg.setBackgroundResource(2131689911);
    Object localObject3 = this.nao.mWO;
    long l = params.field_msgId;
    String str = paramv.gKD;
    Object localObject1 = this.mZN;
    int k = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWz;
    Object localObject2 = new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6046);
        s.this.mZY.setVisibility(0);
        s.this.mZS.setTextColor(s.this.mContext.getResources().getColor(2131101182));
        s.this.hg.setBackgroundResource(2131689782);
        s.this.nao.mWO.o(params.field_msgId, paramInt2);
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
      ((ImageView)localObject1).setContentDescription(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).mWy.getString(2131757186));
      str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ys(str);
      Object localObject4 = g.BXQ;
      if (g.UJ(1))
      {
        localObject4 = com.tencent.mm.pluginsdk.model.a.BOa;
        com.tencent.mm.pluginsdk.model.a.i(l, 0, paramv.url);
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
      float f = com.tencent.mm.cd.a.fromDPToPix(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).mWy, 8);
      int m = ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).getContentWidth();
      localObject3 = b.BOz;
      localObject3 = new c.a();
      ((c.a)localObject3).hki = j;
      ((c.a)localObject3).hjU = true;
      localObject3 = ((c.a)localObject3).de(m, k);
      ((c.a)localObject3).hkk = String.valueOf(i);
      ((c.a)localObject3).hjJ = new n(1);
      ((c.a)localObject3).hkr = new e(1);
      ((c.a)localObject3).hks = new com.tencent.mm.pluginsdk.ui.applet.l();
      ((c.a)localObject3).gjt = r.aAK(str);
      b.a(l, 0, paramv, str, (ImageView)localObject1, paramInt3, false, ((c.a)localObject3).azc(), new m(1, m, k, false, bool, f, (m.a)localObject2));
      a(this, params, paramv);
      localObject1 = this.nao;
      localObject2 = this.nap;
      if (paramInt1 <= 1) {
        break label431;
      }
    }
    label418:
    label424:
    label431:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject1).a(paramv, params, paramInt2, paramu, (View)localObject2, bool, 0);
      if (paramInt1 != 1) {
        break label437;
      }
      this.mZZ.setBackgroundResource(2131231251);
      this.mZY.setBackgroundResource(2131231276);
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
    this.mZZ.setBackgroundResource(2131231253);
    this.mZY.setBackgroundResource(2131231277);
    AppMethodBeat.o(6048);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6047);
    super.a(paramView, paramc);
    if (this.mYI != null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramc = (ViewStub)paramView.findViewById(2131306451);
    if (paramc == null)
    {
      AppMethodBeat.o(6047);
      return;
    }
    paramc.inflate();
    this.mYI = paramView.findViewById(2131297345);
    this.nap = paramView.findViewById(2131298108);
    bDb();
    this.mZN = ((ImageView)this.mYI.findViewById(2131298813));
    this.mZY = ((ImageView)this.mYI.findViewById(2131298826));
    this.hg = ((ImageView)this.mYI.findViewById(2131303256));
    this.naT = this.mYI.findViewById(2131298160);
    this.mZZ = ((ImageView)this.mYI.findViewById(2131303387));
    AppMethodBeat.o(6047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.s
 * JD-Core Version:    0.7.0.1
 */