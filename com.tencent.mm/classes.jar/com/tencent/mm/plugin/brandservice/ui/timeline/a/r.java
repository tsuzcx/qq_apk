package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class r
  extends l
{
  public ImageView mZN;
  public ImageView mZQ;
  public TextView naQ;
  public ImageView naR;
  public MMNeat7extView naa;
  
  public final void a(int paramInt1, v paramv, final s params, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6045);
    super.a(paramInt1, paramv, params, paramInt2, paramu, paramInt3);
    label67:
    label84:
    boolean bool;
    if (bt.isNullOrNil(paramv.title))
    {
      this.naa.setVisibility(8);
      if (TextUtils.isEmpty(paramv.gKR)) {
        break label327;
      }
      this.naQ.setVisibility(0);
      this.naQ.setText(paramv.gKR);
      if (paramv.gKS != 2) {
        break label339;
      }
      this.naR.setImageResource(2131689903);
      a(this.mZQ, params, 0, paramv.gKD);
      a(this, params, paramv);
      Object localObject1 = this.nao;
      Object localObject2 = this.nap;
      if (paramInt1 <= 1) {
        break label351;
      }
      bool = true;
      label126:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject1).a(paramv, params, paramInt2, paramu, (View)localObject2, bool, 0);
      if (!(params.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bGw())) {
        break label357;
      }
      this.mZQ.setImageResource(2131689906);
      label182:
      this.mZY.setVisibility(8);
      paramu = this.nao.mWO;
      long l = params.field_msgId;
      localObject1 = paramv.gKD;
      localObject2 = this.mZN;
      int i = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWB;
      paramu.a(l, 0, paramv, (String)localObject1, (ImageView)localObject2, i, i, false, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6043);
          r.this.mZY.setVisibility(0);
          if ((params.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bGw())) {
            r.this.mZQ.setImageResource(2131231672);
          }
          for (;;)
          {
            r.this.nao.mWO.o(params.field_msgId, paramInt2);
            AppMethodBeat.o(6043);
            return;
            r.this.mZQ.setImageResource(2131231673);
          }
        }
        
        public final void onStart() {}
      }, paramInt3, 2.0F);
      if (paramInt1 != 1) {
        break label369;
      }
      this.nap.setBackgroundResource(2131231692);
    }
    for (;;)
    {
      paramv = this.nap;
      if (paramInt1 <= 1) {
        break label381;
      }
      paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWD;
      paramInt2 = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWD;
      paramv.setPadding(paramInt1, paramInt1, paramInt2, paramInt2);
      AppMethodBeat.o(6045);
      return;
      this.naa.setVisibility(0);
      this.naa.aq(paramv.title);
      break;
      label327:
      this.naQ.setVisibility(8);
      break label67;
      label339:
      this.naR.setImageResource(2131689912);
      break label84;
      label351:
      bool = false;
      break label126;
      label357:
      this.mZQ.setImageResource(2131689909);
      break label182;
      label369:
      this.nap.setBackgroundResource(2131231693);
    }
    label381:
    paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWD;
    paramv.setPadding(paramInt1, paramInt1, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWD, com.tencent.mm.plugin.brandservice.ui.timeline.c.mWC);
    AppMethodBeat.o(6045);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6044);
    super.a(paramView, paramc);
    if (this.mYI != null)
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
    this.mYI = paramView.findViewById(2131297343);
    this.nap = paramView.findViewById(2131298106);
    bDb();
    this.mZN = ((ImageView)this.mYI.findViewById(2131298813));
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305948));
    this.naQ = ((TextView)this.mYI.findViewById(2131303307));
    this.mZQ = ((ImageView)this.mYI.findViewById(2131303284));
    this.naR = ((ImageView)this.mYI.findViewById(2131306868));
    this.mZY = ((ImageView)this.mYI.findViewById(2131298826));
    AppMethodBeat.o(6044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.r
 * JD-Core Version:    0.7.0.1
 */