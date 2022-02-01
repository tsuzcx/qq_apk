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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class x
  extends l
{
  public ImageView nCo;
  public MMNeat7extView nCy;
  public TextView nDK;
  public MMNeat7extView nDL;
  
  public final void a(int paramInt1, v paramv, t paramt, int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6067);
    super.a(paramInt1, paramv, paramt, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.nCD = true;
    label120:
    boolean bool;
    if (bs.isNullOrNil(paramv.title))
    {
      this.nCy.ar(this.mContext.getResources().getString(2131756624));
      if ((bs.isNullOrNil(paramv.hlf)) || (this.mCount != 1)) {
        break label396;
      }
      Object localObject = com.tencent.mm.plugin.brandservice.ui.b.c.Ur(paramv.hlf);
      this.nDL.setVisibility(0);
      this.nDL.setMaxLines(2);
      this.nDL.setEllipsize(TextUtils.TruncateAt.END);
      this.nDL.ar((CharSequence)localObject);
      localObject = m.nJ(paramv.hlh);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label408;
      }
      this.nDK.setVisibility(0);
      this.nDK.setText((CharSequence)localObject);
      label154:
      localObject = this.nCo.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(paramt.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.bNJ())) {
        break label420;
      }
      this.nCo.setImageResource(2131231272);
      if ((this.nCo.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.nCo.getDrawable()).start();
      }
      label256:
      a(this.nCo, paramt, 0, paramv.hld);
      a(this, paramt, paramv);
      localObject = this.nCM;
      View localView = this.nCN;
      if (this.mCount <= 1) {
        break label432;
      }
      bool = true;
      label301:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.c)localObject).a(paramv, paramt, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label438;
      }
      this.nCN.setBackgroundResource(2131231256);
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramv.hlf)) {
        break label450;
      }
      this.nCN.setPadding(this.nCN.getPaddingLeft(), 0, this.nCN.getPaddingRight(), 0);
      AppMethodBeat.o(6067);
      return;
      this.nCy.setVisibility(0);
      this.nCy.ar(paramv.title);
      break;
      label396:
      this.nDL.setVisibility(8);
      break label120;
      label408:
      this.nDK.setVisibility(8);
      break label154;
      label420:
      this.nCo.setImageResource(2131231271);
      break label256;
      label432:
      bool = false;
      break label301;
      label438:
      this.nCN.setBackgroundResource(2131231262);
    }
    label450:
    this.nCN.setPadding(this.nCN.getPaddingLeft(), com.tencent.mm.plugin.brandservice.ui.timeline.c.nze, this.nCN.getPaddingRight(), com.tencent.mm.plugin.brandservice.ui.timeline.c.nzb);
    AppMethodBeat.o(6067);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6066);
    super.a(paramView, paramc);
    if (this.nBh != null)
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
    this.nBh = paramView.findViewById(2131297350);
    this.nCN = paramView.findViewById(2131298114);
    bKk();
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305948));
    this.nDK = ((TextView)this.nBh.findViewById(2131303288));
    this.nCo = ((ImageView)this.nBh.findViewById(2131297219));
    this.nDL = ((MMNeat7extView)this.nBh.findViewById(2131297349));
    AppMethodBeat.o(6066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.x
 * JD-Core Version:    0.7.0.1
 */