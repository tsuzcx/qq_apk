package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.storage.t;

public final class s
  extends l
{
  public ImageView ig;
  public ImageView nCl;
  public View nDr;
  
  public final void a(int paramInt1, v paramv, final t paramt, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6048);
    super.a(paramInt1, paramv, paramt, paramInt2, paramu, paramInt3);
    dC(this.nDr);
    this.nCw.setVisibility(8);
    this.nCq.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.ig.setBackgroundResource(2131689911);
    Object localObject3 = this.nCM.nzn;
    long l = paramt.field_msgId;
    String str = paramv.hld;
    Object localObject1 = this.nCl;
    int k = com.tencent.mm.plugin.brandservice.ui.timeline.c.nyY;
    Object localObject2 = new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6046);
        s.this.nCw.setVisibility(0);
        s.this.nCq.setTextColor(s.this.mContext.getResources().getColor(2131101182));
        s.this.ig.setBackgroundResource(2131689782);
        s.this.nCM.nzn.p(paramt.field_msgId, paramInt2);
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
      ((ImageView)localObject1).setContentDescription(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).nyX.getString(2131757186));
      str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.Cx(str);
      Object localObject4 = g.Dqh;
      if (g.WT(1))
      {
        localObject4 = com.tencent.mm.pluginsdk.model.a.Dgo;
        com.tencent.mm.pluginsdk.model.a.l(l, 0, paramv.url);
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
      float f = com.tencent.mm.cc.a.fromDPToPix(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).nyX, 8);
      int m = ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).getContentWidth();
      localObject3 = b.DgN;
      localObject3 = new c.a();
      ((c.a)localObject3).hKL = j;
      ((c.a)localObject3).hKx = true;
      localObject3 = ((c.a)localObject3).de(m, k);
      ((c.a)localObject3).hKN = String.valueOf(i);
      ((c.a)localObject3).hKm = new n(1);
      ((c.a)localObject3).hKU = new e(1);
      ((c.a)localObject3).hKV = new com.tencent.mm.pluginsdk.ui.applet.l();
      ((c.a)localObject3).gKe = r.aGc(str);
      b.a(l, 0, paramv, str, (ImageView)localObject1, paramInt3, false, ((c.a)localObject3).aFT(), new m(1, m, k, false, bool, f, (m.a)localObject2));
      a(this, paramt, paramv);
      localObject1 = this.nCM;
      localObject2 = this.nCN;
      if (paramInt1 <= 1) {
        break label431;
      }
    }
    label418:
    label424:
    label431:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject1).a(paramv, paramt, paramInt2, paramu, (View)localObject2, bool, 0);
      if (paramInt1 != 1) {
        break label437;
      }
      this.nCx.setBackgroundResource(2131231251);
      this.nCw.setBackgroundResource(2131231276);
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
    this.nCx.setBackgroundResource(2131231253);
    this.nCw.setBackgroundResource(2131231277);
    AppMethodBeat.o(6048);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6047);
    super.a(paramView, paramc);
    if (this.nBh != null)
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
    this.nBh = paramView.findViewById(2131297345);
    this.nCN = paramView.findViewById(2131298108);
    bKk();
    this.nCl = ((ImageView)this.nBh.findViewById(2131298813));
    this.nCw = ((ImageView)this.nBh.findViewById(2131298826));
    this.ig = ((ImageView)this.nBh.findViewById(2131303256));
    this.nDr = this.nBh.findViewById(2131298160);
    this.nCx = ((ImageView)this.nBh.findViewById(2131303387));
    AppMethodBeat.o(6047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.s
 * JD-Core Version:    0.7.0.1
 */