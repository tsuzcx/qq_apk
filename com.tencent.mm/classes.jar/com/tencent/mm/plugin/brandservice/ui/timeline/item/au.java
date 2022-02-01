package com.tencent.mm.plugin.brandservice.ui.timeline.item;

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
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class au
  extends ai
{
  public MMNeat7extView ptR;
  public MMNeat7extView puy;
  public ImageView pxu;
  public TextView pyD;
  
  public final void a(int paramInt1, v paramv, z paramz, int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6067);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.pxB = true;
    label120:
    boolean bool;
    if (Util.isNullOrNil(paramv.title))
    {
      this.ptR.aw(this.mContext.getResources().getString(2131756772));
      if ((Util.isNullOrNil(paramv.iAq)) || (this.mCount != 1)) {
        break label396;
      }
      Object localObject = c.aiW(paramv.iAq);
      this.puy.setVisibility(0);
      this.puy.setMaxLines(2);
      this.puy.setEllipsize(TextUtils.TruncateAt.END);
      this.puy.aw((CharSequence)localObject);
      localObject = m.rJ(paramv.iAs);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label408;
      }
      this.pyD.setVisibility(0);
      this.pyD.setText((CharSequence)localObject);
      label154:
      localObject = this.pxu.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(paramz.field_msgId + "_0").equals(c.crh())) {
        break label420;
      }
      this.pxu.setImageResource(2131231332);
      if ((this.pxu.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.pxu.getDrawable()).start();
      }
      label256:
      a(this.pxu, paramz, 0, paramv.iAo);
      a(this, paramz, paramv);
      localObject = this.pxE;
      View localView = this.ptQ;
      if (this.mCount <= 1) {
        break label432;
      }
      bool = true;
      label301:
      ((b)localObject).a(paramv, paramz, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label438;
      }
      this.ptQ.setBackgroundResource(2131231316);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramv.iAq)) {
        break label450;
      }
      this.ptQ.setPadding(this.ptQ.getPaddingLeft(), 0, this.ptQ.getPaddingRight(), 0);
      AppMethodBeat.o(6067);
      return;
      this.ptR.setVisibility(0);
      this.ptR.aw(paramv.title);
      break;
      label396:
      this.puy.setVisibility(8);
      break label120;
      label408:
      this.pyD.setVisibility(8);
      break label154;
      label420:
      this.pxu.setImageResource(2131231331);
      break label256;
      label432:
      bool = false;
      break label301;
      label438:
      this.ptQ.setBackgroundResource(2131231322);
    }
    label450:
    this.ptQ.setPadding(this.ptQ.getPaddingLeft(), b.pry, this.ptQ.getPaddingRight(), b.prv);
    AppMethodBeat.o(6067);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6066);
    super.a(paramView, paramb);
    if (this.puO != null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131309899);
    if (paramb == null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb.inflate();
    this.puO = paramView.findViewById(2131297561);
    this.ptQ = paramView.findViewById(2131298464);
    cmH();
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131309249));
    this.pyD = ((TextView)this.puO.findViewById(2131305961));
    this.pxu = ((ImageView)this.puO.findViewById(2131297374));
    this.puy = ((MMNeat7extView)this.puO.findViewById(2131297560));
    paramView = d.pMy;
    if (d.crj())
    {
      paramView = d.pMy;
      d.c(this.ptR);
    }
    AppMethodBeat.o(6066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.au
 * JD-Core Version:    0.7.0.1
 */