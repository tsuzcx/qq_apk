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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ak
  extends y
{
  public MMNeat7extView oip;
  public ImageView okW;
  public TextView omf;
  public MMNeat7extView omg;
  
  public final void a(int paramInt1, v paramv, w paramw, int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6067);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.olc = true;
    label120:
    boolean bool;
    if (bu.isNullOrNil(paramv.title))
    {
      this.oip.aq(this.mContext.getResources().getString(2131756624));
      if ((bu.isNullOrNil(paramv.hGg)) || (this.mCount != 1)) {
        break label396;
      }
      Object localObject = c.YR(paramv.hGg);
      this.omg.setVisibility(0);
      this.omg.setMaxLines(2);
      this.omg.setEllipsize(TextUtils.TruncateAt.END);
      this.omg.aq((CharSequence)localObject);
      localObject = m.ol(paramv.hGi);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label408;
      }
      this.omf.setVisibility(0);
      this.omf.setText((CharSequence)localObject);
      label154:
      localObject = this.okW.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(paramw.field_msgId + "_0").equals(c.bTw())) {
        break label420;
      }
      this.okW.setImageResource(2131231272);
      if ((this.okW.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.okW.getDrawable()).start();
      }
      label256:
      a(this.okW, paramw, 0, paramv.hGe);
      a(this, paramw, paramv);
      localObject = this.oll;
      View localView = this.oio;
      if (this.mCount <= 1) {
        break label432;
      }
      bool = true;
      label301:
      ((b)localObject).a(paramv, paramw, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label438;
      }
      this.oio.setBackgroundResource(2131231256);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramv.hGg)) {
        break label450;
      }
      this.oio.setPadding(this.oio.getPaddingLeft(), 0, this.oio.getPaddingRight(), 0);
      AppMethodBeat.o(6067);
      return;
      this.oip.setVisibility(0);
      this.oip.aq(paramv.title);
      break;
      label396:
      this.omg.setVisibility(8);
      break label120;
      label408:
      this.omf.setVisibility(8);
      break label154;
      label420:
      this.okW.setImageResource(2131231271);
      break label256;
      label432:
      bool = false;
      break label301;
      label438:
      this.oio.setBackgroundResource(2131231262);
    }
    label450:
    this.oio.setPadding(this.oio.getPaddingLeft(), b.ofZ, this.oio.getPaddingRight(), b.ofW);
    AppMethodBeat.o(6067);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6066);
    super.a(paramView, paramb);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131297350);
    this.oio = paramView.findViewById(2131298114);
    bPv();
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305948));
    this.omf = ((TextView)this.oiV.findViewById(2131303288));
    this.okW = ((ImageView)this.oiV.findViewById(2131297219));
    this.omg = ((MMNeat7extView)this.oiV.findViewById(2131297349));
    AppMethodBeat.o(6066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ak
 * JD-Core Version:    0.7.0.1
 */