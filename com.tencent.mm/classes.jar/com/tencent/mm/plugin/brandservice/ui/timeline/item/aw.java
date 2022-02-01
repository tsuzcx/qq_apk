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
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aw
  extends ak
{
  public MMNeat7extView sDL;
  public MMNeat7extView sDe;
  public ImageView sGV;
  public TextView sIg;
  
  public final void a(int paramInt1, v paramv, z paramz, int paramInt2, u paramu, int paramInt3)
  {
    AppMethodBeat.i(6067);
    super.a(paramInt1, paramv, paramz, paramInt2, paramu, paramInt3);
    this.mCount = paramInt1;
    this.sHc = true;
    label121:
    boolean bool;
    if (Util.isNullOrNil(paramv.title))
    {
      this.sDe.aL(this.mContext.getResources().getString(d.i.suN));
      if ((Util.isNullOrNil(paramv.lpM)) || (this.mCount != 1)) {
        break label399;
      }
      Object localObject = c.aqF(paramv.lpM);
      this.sDL.setVisibility(0);
      this.sDL.setMaxLines(2);
      this.sDL.setEllipsize(TextUtils.TruncateAt.END);
      this.sDL.aL((CharSequence)localObject);
      localObject = m.uD(paramv.lpO);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label411;
      }
      this.sIg.setVisibility(0);
      this.sIg.setText((CharSequence)localObject);
      label155:
      localObject = this.sGV.getDrawable();
      if (((localObject instanceof AnimationDrawable)) && (((AnimationDrawable)localObject).isRunning())) {
        ((AnimationDrawable)localObject).stop();
      }
      if (!(paramz.field_msgId + "_0").equals(c.cEq())) {
        break label423;
      }
      this.sGV.setImageResource(d.d.dmz);
      if ((this.sGV.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)this.sGV.getDrawable()).start();
      }
      label258:
      a(this.sGV, paramz, 0, paramv.lpK);
      a(this, paramz, paramv);
      localObject = this.sHf;
      View localView = this.sDd;
      if (this.mCount <= 1) {
        break label436;
      }
      bool = true;
      label303:
      ((b)localObject).a(paramv, paramz, paramInt2, paramu, localView, bool, 0);
      if (this.mCount != 1) {
        break label442;
      }
      this.sDd.setBackgroundResource(d.d.spE);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramv.lpM)) {
        break label455;
      }
      this.sDd.setPadding(this.sDd.getPaddingLeft(), 0, this.sDd.getPaddingRight(), 0);
      AppMethodBeat.o(6067);
      return;
      this.sDe.setVisibility(0);
      this.sDe.aL(paramv.title);
      break;
      label399:
      this.sDL.setVisibility(8);
      break label121;
      label411:
      this.sIg.setVisibility(8);
      break label155;
      label423:
      this.sGV.setImageResource(d.d.dmy);
      break label258;
      label436:
      bool = false;
      break label303;
      label442:
      this.sDd.setBackgroundResource(d.d.spF);
    }
    label455:
    this.sDd.setPadding(this.sDd.getPaddingLeft(), b.sAw, this.sDd.getPaddingRight(), b.sAt);
    AppMethodBeat.o(6067);
  }
  
  public final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6066);
    super.a(paramView, paramb);
    if (this.sEi != null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb = (ViewStub)paramView.findViewById(d.e.dZB);
    if (paramb == null)
    {
      AppMethodBeat.o(6066);
      return;
    }
    paramb.inflate();
    this.sEi = paramView.findViewById(d.e.sqS);
    this.sDd = paramView.findViewById(d.e.srB);
    cAo();
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(d.e.title_tv));
    this.sIg = ((TextView)this.sEi.findViewById(d.e.sss));
    this.sGV = ((ImageView)this.sEi.findViewById(d.e.spP));
    this.sDL = ((MMNeat7extView)this.sEi.findViewById(d.e.sqR));
    paramView = d.sTw;
    if (d.cEs())
    {
      paramView = d.sTw;
      d.e(this.sDe);
    }
    AppMethodBeat.o(6066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aw
 * JD-Core Version:    0.7.0.1
 */