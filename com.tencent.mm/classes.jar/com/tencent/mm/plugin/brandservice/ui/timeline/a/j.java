package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.f;

public final class j
  extends c
{
  public ImageView iTH;
  public ImageView jXx;
  public View jYA;
  
  public final void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, com.tencent.mm.af.p paramp)
  {
    AppMethodBeat.i(152638);
    super.a(paramInt1, paramq, paramq1, paramInt2, paramp);
    dd(this.jYA);
    this.jXG.setVisibility(8);
    this.jXA.setTextColor(this.mContext.getResources().getColor(2131690208));
    this.iTH.setBackgroundResource(2131231117);
    Object localObject3 = this.jXV.jVJ;
    String str = paramq.fjJ;
    Object localObject1 = this.jXx;
    int k = com.tencent.mm.plugin.brandservice.ui.timeline.a.jVt;
    Object localObject2 = new j.1(this, paramq1, paramInt2);
    int i;
    label139:
    int j;
    if (paramInt1 == 1)
    {
      bool = true;
      ((ImageView)localObject1).setContentDescription(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).jVs.getString(2131298197));
      str = com.tencent.mm.at.q.ts(str);
      if (!bool) {
        break label350;
      }
      i = 2130837949;
      if (!bool) {
        break label356;
      }
      j = 2130837951;
      label148:
      float f = com.tencent.mm.cb.a.fromDPToPix(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).jVs, 8);
      int m = ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).getContentWidth();
      localObject3 = o.ahG();
      c.a locala = new c.a();
      locala.eOa = j;
      locala.eNM = true;
      locala = locala.cx(m, k);
      locala.eOc = String.valueOf(i);
      locala.fHk = new f();
      locala.eNO = com.tencent.mm.pluginsdk.model.p.aln(str);
      ((com.tencent.mm.at.a.a)localObject3).a(str, (ImageView)localObject1, locala.ahY(), null, new e(m, k, false, bool, f, (e.a)localObject2));
      a(this, paramq1, paramq);
      localObject1 = this.jXV;
      localObject2 = this.jXW;
      if (paramInt1 <= 1) {
        break label363;
      }
    }
    label350:
    label356:
    label363:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a)localObject1).a(paramq, paramq1, paramInt2, paramp, (View)localObject2, bool, 0);
      if (paramInt1 != 1) {
        break label369;
      }
      this.jXH.setBackgroundResource(2130837955);
      this.jXG.setBackgroundResource(2130837978);
      AppMethodBeat.o(152638);
      return;
      bool = false;
      break;
      i = 0;
      break label139;
      j = 2130837956;
      break label148;
    }
    label369:
    this.jXH.setBackgroundResource(2130837957);
    this.jXG.setBackgroundResource(2130837979);
    AppMethodBeat.o(152638);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14271);
    super.a(paramView, parama);
    if (this.jXr != null)
    {
      AppMethodBeat.o(14271);
      return;
    }
    parama = (ViewStub)paramView.findViewById(2131821880);
    if (parama == null)
    {
      AppMethodBeat.o(14271);
      return;
    }
    parama.inflate();
    this.jXr = paramView.findViewById(2131821918);
    this.jXW = paramView.findViewById(2131821919);
    aWY();
    this.jXx = ((ImageView)this.jXr.findViewById(2131821438));
    this.jXG = ((ImageView)this.jXr.findViewById(2131821917));
    this.iTH = ((ImageView)this.jXr.findViewById(2131821921));
    this.jYA = this.jXr.findViewById(2131821920);
    this.jXH = ((ImageView)this.jXr.findViewById(2131821909));
    AppMethodBeat.o(14271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.j
 * JD-Core Version:    0.7.0.1
 */