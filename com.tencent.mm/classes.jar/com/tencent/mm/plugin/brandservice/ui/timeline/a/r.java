package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class r
  extends l
{
  public ImageView nCl;
  public ImageView nCo;
  public MMNeat7extView nCy;
  public TextView nDo;
  public ImageView nDp;
  
  public final void a(int paramInt1, v paramv, final t paramt, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6045);
    super.a(paramInt1, paramv, paramt, paramInt2, paramu, paramInt3);
    label67:
    label84:
    boolean bool;
    if (bs.isNullOrNil(paramv.title))
    {
      this.nCy.setVisibility(8);
      if (TextUtils.isEmpty(paramv.hlr)) {
        break label327;
      }
      this.nDo.setVisibility(0);
      this.nDo.setText(paramv.hlr);
      if (paramv.hls != 2) {
        break label339;
      }
      this.nDp.setImageResource(2131689903);
      a(this.nCo, paramt, 0, paramv.hld);
      a(this, paramt, paramv);
      Object localObject1 = this.nCM;
      Object localObject2 = this.nCN;
      if (paramInt1 <= 1) {
        break label351;
      }
      bool = true;
      label126:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject1).a(paramv, paramt, paramInt2, paramu, (View)localObject2, bool, 0);
      if (!(paramt.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bNJ())) {
        break label357;
      }
      this.nCo.setImageResource(2131689906);
      label182:
      this.nCw.setVisibility(8);
      paramu = this.nCM.nzn;
      long l = paramt.field_msgId;
      localObject1 = paramv.hld;
      localObject2 = this.nCl;
      int i = com.tencent.mm.plugin.brandservice.ui.timeline.c.nza;
      paramu.a(l, 0, paramv, (String)localObject1, (ImageView)localObject2, i, i, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6043);
          r.this.nCw.setVisibility(0);
          if ((paramt.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bNJ())) {
            r.this.nCo.setImageResource(2131231672);
          }
          for (;;)
          {
            r.this.nCM.nzn.p(paramt.field_msgId, paramInt2);
            AppMethodBeat.o(6043);
            return;
            r.this.nCo.setImageResource(2131231673);
          }
        }
        
        public final void onStart() {}
      }, paramInt3, 2.0F);
      if (paramInt1 != 1) {
        break label369;
      }
      this.nCN.setBackgroundResource(2131231692);
    }
    for (;;)
    {
      paramv = this.nCN;
      if (paramInt1 <= 1) {
        break label381;
      }
      paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.c.nzc;
      paramInt2 = com.tencent.mm.plugin.brandservice.ui.timeline.c.nzc;
      paramv.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(6045);
      return;
      this.nCy.setVisibility(0);
      this.nCy.ar(paramv.title);
      break;
      label327:
      this.nDo.setVisibility(8);
      break label67;
      label339:
      this.nDp.setImageResource(2131689912);
      break label84;
      label351:
      bool = false;
      break label126;
      label357:
      this.nCo.setImageResource(2131689909);
      break label182;
      label369:
      this.nCN.setBackgroundResource(2131231693);
    }
    label381:
    paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.c.nzc;
    paramv.setPadding(paramInt1, paramInt1, com.tencent.mm.plugin.brandservice.ui.timeline.c.nzc, com.tencent.mm.plugin.brandservice.ui.timeline.c.nzb);
    AppMethodBeat.o(6045);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6044);
    super.a(paramView, paramc);
    if (this.nBh != null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramc = (ViewStub)paramView.findViewById(2131306450);
    if (paramc == null)
    {
      AppMethodBeat.o(6044);
      return;
    }
    paramc.inflate();
    this.nBh = paramView.findViewById(2131297343);
    this.nCN = paramView.findViewById(2131298106);
    bKk();
    this.nCl = ((ImageView)this.nBh.findViewById(2131298813));
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305948));
    this.nDo = ((TextView)this.nBh.findViewById(2131303307));
    this.nCo = ((ImageView)this.nBh.findViewById(2131303284));
    this.nDp = ((ImageView)this.nBh.findViewById(2131306868));
    this.nCw = ((ImageView)this.nBh.findViewById(2131298826));
    AppMethodBeat.o(6044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.r
 * JD-Core Version:    0.7.0.1
 */