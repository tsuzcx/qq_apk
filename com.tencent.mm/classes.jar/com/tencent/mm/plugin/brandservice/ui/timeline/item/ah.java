package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ah
  extends y
{
  public ImageView oic;
  public RelativeLayout olX;
  
  public final void a(int paramInt1, final v paramv, final w paramw, final int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6058);
    super.a(paramInt1, paramv, paramw, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.olc = false;
    this.oiq.setVisibility(8);
    dF(this.olX);
    dF(this.oic);
    this.oic.setVisibility(0);
    this.oip.setTextColor(this.mContext.getResources().getColor(2131100541));
    this.oir.setBackgroundResource(2131233299);
    this.oiw.setTextColor(this.mContext.getResources().getColor(2131100541));
    paramInt3 = bPK();
    this.oll.ogi.a(paramw.field_msgId, 0, paramv, paramv.hGe, this.oic, paramInt3, b.ofT, false, new m.a()
    {
      public final void onFinish()
      {
        AppMethodBeat.i(6056);
        ah.this.olc = true;
        ah.this.oiw.setTextColor(ah.this.mContext.getResources().getColor(2131099674));
        if (ah.this.oiq != null) {
          ah.this.oiq.setVisibility(0);
        }
        if (!ah.b(ah.this.mCount, paramv))
        {
          ah.this.oip.setTextColor(ah.this.mContext.getResources().getColor(2131101182));
          if (ah.this.b(paramv)) {
            ah.this.oir.setBackgroundResource(2131231281);
          }
        }
        for (;;)
        {
          ah.this.oll.ogi.p(paramw.field_msgId, paramInt2);
          AppMethodBeat.o(6056);
          return;
          ah.this.oir.setBackgroundResource(2131231282);
          continue;
          if (ah.this.old > 0) {
            ah.this.oir.setBackgroundResource(2131231282);
          }
        }
      }
      
      public final void onStart() {}
    }, b(paramv), this.ole);
    a(this.mCount, paramv);
    label237:
    b localb;
    View localView;
    if (b(this.mCount, paramv))
    {
      this.oio.setPadding(this.oio.getPaddingLeft(), 0, this.oio.getPaddingRight(), b.ofW);
      if (!b(paramv)) {
        break label314;
      }
      this.oiq.setBackgroundResource(2131231251);
      this.oio.setBackgroundResource(2131231256);
      a(this, paramw, paramv);
      localb = this.oll;
      localView = this.oio;
      if (paramInt1 <= 1) {
        break label358;
      }
    }
    label314:
    label358:
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramv, paramw, paramInt2, paramu, localView, bool, 0);
      AppMethodBeat.o(6058);
      return;
      this.oio.setPadding(this.oio.getPaddingLeft(), 0, this.oio.getPaddingRight(), 0);
      break;
      this.oiq.setBackgroundResource(2131231253);
      if (b(this.mCount, paramv))
      {
        this.oio.setBackgroundResource(2131231256);
        break label237;
      }
      this.oio.setBackgroundResource(2131231262);
      break label237;
    }
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6057);
    super.a(paramView, paramb);
    if (this.oiV != null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(2131306453);
    if (paramb == null)
    {
      AppMethodBeat.o(6057);
      return;
    }
    paramb.inflate();
    this.oiV = paramView.findViewById(2131297347);
    this.oio = paramView.findViewById(2131305993);
    bPv();
    this.oic = ((ImageView)this.oiV.findViewById(2131298824));
    this.olX = ((RelativeLayout)this.oiV.findViewById(2131298825));
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305948));
    this.oie = ((ImageView)this.oiV.findViewById(2131298826));
    this.oiq = ((ImageView)this.oiV.findViewById(2131303387));
    this.oir = ((LinearLayout)this.oiV.findViewById(2131297367));
    this.ois = ((LinearLayout)this.oiV.findViewById(2131304831));
    this.oit = ((MMNeat7extView)this.oiV.findViewById(2131304829));
    this.oiu = ((MMNeat7extView)this.oiV.findViewById(2131304827));
    AppMethodBeat.o(6057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ah
 * JD-Core Version:    0.7.0.1
 */