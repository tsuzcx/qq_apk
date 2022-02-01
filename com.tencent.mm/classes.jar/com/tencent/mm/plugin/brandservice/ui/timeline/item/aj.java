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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aj
  extends x
{
  public MMNeat7extView ocA;
  public ImageView oeW;
  public TextView ogg;
  public MMNeat7extView ogh;
  
  public final void a(int paramInt1, v paramv, w paramw, int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6067);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.ofc = true;
    label120:
    boolean bool;
    if (bt.isNullOrNil(paramv.title))
    {
      this.ocA.ar(this.mContext.getResources().getString(2131756624));
      if ((bt.isNullOrNil(paramv.hDo)) || (this.mCount != 1)) {
        break label396;
      }
      Object localObject = c.Ya(paramv.hDo);
      this.ogh.setVisibility(0);
      this.ogh.setMaxLines(2);
      this.ogh.setEllipsize(TextUtils.TruncateAt.END);
      this.ogh.ar((CharSequence)localObject);
      localObject = m.oi(paramv.hDq);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label408;
      }
      this.ogg.setVisibility(0);
      this.ogg.setText((CharSequence)localObject);
      label154:
      localObject = this.oeW.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(paramw.field_msgId + "_0").equals(c.bSj())) {
        break label420;
      }
      this.oeW.setImageResource(2131231272);
      if ((this.oeW.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.oeW.getDrawable()).start();
      }
      label256:
      a(this.oeW, paramw, 0, paramv.hDm);
      a(this, paramw, paramv);
      localObject = this.ofm;
      View localView = this.ocz;
      if (this.mCount <= 1) {
        break label432;
      }
      bool = true;
      label301:
      ((b)localObject).a(paramv, paramw, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label438;
      }
      this.ocz.setBackgroundResource(2131231256);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramv.hDo)) {
        break label450;
      }
      this.ocz.setPadding(this.ocz.getPaddingLeft(), 0, this.ocz.getPaddingRight(), 0);
      AppMethodBeat.o(6067);
      return;
      this.ocA.setVisibility(0);
      this.ocA.ar(paramv.title);
      break;
      label396:
      this.ogh.setVisibility(8);
      break label120;
      label408:
      this.ogg.setVisibility(8);
      break label154;
      label420:
      this.oeW.setImageResource(2131231271);
      break label256;
      label432:
      bool = false;
      break label301;
      label438:
      this.ocz.setBackgroundResource(2131231262);
    }
    label450:
    this.ocz.setPadding(this.ocz.getPaddingLeft(), b.oaj, this.ocz.getPaddingRight(), b.oag);
    AppMethodBeat.o(6067);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6066);
    super.a(paramView, paramb);
    if (this.odh != null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306456);
    if (paramb == null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb.inflate();
    this.odh = paramView.findViewById(2131297350);
    this.ocz = paramView.findViewById(2131298114);
    bOx();
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305948));
    this.ogg = ((TextView)this.odh.findViewById(2131303288));
    this.oeW = ((ImageView)this.odh.findViewById(2131297219));
    this.ogh = ((MMNeat7extView)this.odh.findViewById(2131297349));
    AppMethodBeat.o(6066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
 * JD-Core Version:    0.7.0.1
 */