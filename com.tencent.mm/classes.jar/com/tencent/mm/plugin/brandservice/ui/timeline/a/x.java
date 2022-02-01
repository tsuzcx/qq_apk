package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class x
  extends l
{
  public ImageView mZQ;
  public MMNeat7extView naa;
  public TextView nbm;
  public MMNeat7extView nbn;
  
  public final void a(int paramInt1, v paramv, s params, int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6067);
    super.a(paramInt1, paramv, params, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.naf = true;
    label120:
    boolean bool;
    if (bt.isNullOrNil(paramv.title))
    {
      this.naa.aq(this.mContext.getResources().getString(2131756624));
      if ((bt.isNullOrNil(paramv.gKF)) || (this.mCount != 1)) {
        break label396;
      }
      Object localObject = com.tencent.mm.plugin.brandservice.ui.b.c.Qf(paramv.gKF);
      this.nbn.setVisibility(0);
      this.nbn.setMaxLines(2);
      this.nbn.setEllipsize(TextUtils.TruncateAt.END);
      this.nbn.aq((CharSequence)localObject);
      localObject = m.mV(paramv.gKH);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label408;
      }
      this.nbm.setVisibility(0);
      this.nbm.setText((CharSequence)localObject);
      label154:
      localObject = this.mZQ.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(params.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bGw())) {
        break label420;
      }
      this.mZQ.setImageResource(2131231272);
      if ((this.mZQ.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.mZQ.getDrawable()).start();
      }
      label256:
      a(this.mZQ, params, 0, paramv.gKD);
      a(this, params, paramv);
      localObject = this.nao;
      View localView = this.nap;
      if (this.mCount <= 1) {
        break label432;
      }
      bool = true;
      label301:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject).a(paramv, params, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label438;
      }
      this.nap.setBackgroundResource(2131231256);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramv.gKF)) {
        break label450;
      }
      this.nap.setPadding(this.nap.getPaddingLeft(), 0, this.nap.getPaddingRight(), 0);
      AppMethodBeat.o(6067);
      return;
      this.naa.setVisibility(0);
      this.naa.aq(paramv.title);
      break;
      label396:
      this.nbn.setVisibility(8);
      break label120;
      label408:
      this.nbm.setVisibility(8);
      break label154;
      label420:
      this.mZQ.setImageResource(2131231271);
      break label256;
      label432:
      bool = false;
      break label301;
      label438:
      this.nap.setBackgroundResource(2131231262);
    }
    label450:
    this.nap.setPadding(this.nap.getPaddingLeft(), com.tencent.mm.plugin.brandservice.ui.timeline.c.mWF, this.nap.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.c.mWC);
    AppMethodBeat.o(6067);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6066);
    super.a(paramView, paramc);
    if (this.mYI != null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramc = (ViewStub)paramView.findViewById(2131306456);
    if (paramc == null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramc.inflate();
    this.mYI = paramView.findViewById(2131297350);
    this.nap = paramView.findViewById(2131298114);
    bDb();
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305948));
    this.nbm = ((TextView)this.mYI.findViewById(2131303288));
    this.mZQ = ((ImageView)this.mYI.findViewById(2131297219));
    this.nbn = ((MMNeat7extView)this.mYI.findViewById(2131297349));
    AppMethodBeat.o(6066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.x
 * JD-Core Version:    0.7.0.1
 */