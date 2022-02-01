package com.tencent.mm.plugin.brandservice.ui.timeline.item;

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
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.storage.w;

public final class af
  extends y
{
  public ImageView ka;
  public View oiA;
  public ImageView oic;
  
  public final void a(int paramInt1, v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6048);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    dF(this.oiA);
    this.oie.setVisibility(8);
    this.oiw.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.ka.setBackgroundResource(2131689911);
    Object localObject3 = this.oll.ogi;
    long l = paramw.field_msgId;
    String str = paramv.hGe;
    Object localObject1 = this.oic;
    int k = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofT;
    Object localObject2 = new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6046);
        af.this.oie.setVisibility(0);
        af.this.oiw.setTextColor(af.this.mContext.getResources().getColor(2131101182));
        af.this.ka.setBackgroundResource(2131689782);
        af.this.oll.ogi.p(paramw.field_msgId, paramInt2);
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
      ((ImageView)localObject1).setContentDescription(((c)localObject3).ofS.getString(2131757186));
      str = c.Gd(str);
      Object localObject4 = g.FnF;
      if (g.Zv(1))
      {
        localObject4 = com.tencent.mm.pluginsdk.model.a.Fdw;
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
      float f = com.tencent.mm.cb.a.fromDPToPix(((c)localObject3).ofS, 8);
      int m = ((c)localObject3).getContentWidth();
      localObject3 = com.tencent.mm.pluginsdk.model.b.FdV;
      localObject3 = new c.a();
      ((c.a)localObject3).igy = j;
      ((c.a)localObject3).igk = true;
      localObject3 = ((c.a)localObject3).dh(m, k);
      ((c.a)localObject3).igA = String.valueOf(i);
      ((c.a)localObject3).ifZ = new n(1);
      ((c.a)localObject3).igH = new e(1);
      ((c.a)localObject3).igI = new l();
      ((c.a)localObject3).hgD = r.aMY(str);
      com.tencent.mm.pluginsdk.model.b.a(l, 0, paramv, str, (ImageView)localObject1, paramInt3, false, ((c.a)localObject3).aJu(), new m(1, m, k, false, bool, f, (m.a)localObject2));
      a(this, paramw, paramv);
      localObject1 = this.oll;
      localObject2 = this.oio;
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
      this.oiq.setBackgroundResource(2131231251);
      this.oie.setBackgroundResource(2131231276);
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
    this.oiq.setBackgroundResource(2131231253);
    this.oie.setBackgroundResource(2131231277);
    AppMethodBeat.o(6048);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6047);
    super.a(paramView, paramb);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131297345);
    this.oio = paramView.findViewById(2131298108);
    bPv();
    this.oic = ((ImageView)this.oiV.findViewById(2131298813));
    this.oie = ((ImageView)this.oiV.findViewById(2131298826));
    this.ka = ((ImageView)this.oiV.findViewById(2131303256));
    this.oiA = this.oiV.findViewById(2131298160);
    this.oiq = ((ImageView)this.oiV.findViewById(2131303387));
    AppMethodBeat.o(6047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.af
 * JD-Core Version:    0.7.0.1
 */