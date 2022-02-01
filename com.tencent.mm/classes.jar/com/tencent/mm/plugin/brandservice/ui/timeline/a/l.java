package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.b.b;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class l
  extends n
{
  public int mCount = 0;
  public View mZR;
  public TextView mZS;
  public ImageView mZY;
  public ImageView mZZ;
  public MMNeat7extView naa;
  public LinearLayout nab;
  public MMNeat7extView nac;
  public MMNeat7extView nad;
  public LinearLayout nae;
  public boolean naf = false;
  public int nag = 0;
  public int nah = 0;
  
  private void a(MMNeat7extView paramMMNeat7extView, v paramv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(162406);
    paramMMNeat7extView.setMaxLines(2);
    int i;
    b localb;
    if (paramBoolean2)
    {
      i = 0;
      if (bt.isNullOrNil(paramv.title)) {
        break label69;
      }
      localb = b.mSC;
      b.a(paramv.title, paramMMNeat7extView, paramv, i);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        paramv = d.nmK;
        d.a(paramMMNeat7extView);
      }
      AppMethodBeat.o(162406);
      return;
      i = 11;
      break;
      label69:
      localb = b.mSC;
      b.a(this.mContext.getString(2131756613), paramMMNeat7extView, paramv, i);
    }
  }
  
  public static boolean b(int paramInt, v paramv)
  {
    AppMethodBeat.i(6013);
    if ((paramv.type == 0) || (paramv.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.a.bGu()))
      {
        AppMethodBeat.o(6013);
        return true;
      }
      AppMethodBeat.o(6013);
      return false;
    }
    if (paramInt == 1)
    {
      AppMethodBeat.o(6013);
      return true;
    }
    AppMethodBeat.o(6013);
    return false;
  }
  
  public void a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6012);
    if (b(paramInt, paramv))
    {
      this.naa.setVisibility(8);
      this.nab.setVisibility(0);
      a(this.nac, paramv, false, true);
      MMNeat7extView localMMNeat7extView = this.nad;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!bt.isNullOrNil(paramv.gKF))
      {
        paramv = com.tencent.mm.plugin.brandservice.ui.b.c.Qf(paramv.gKF);
        localMMNeat7extView.setVisibility(0);
        localMMNeat7extView.aq(paramv);
        i = com.tencent.mm.cd.a.hV(this.mContext) - com.tencent.mm.cd.a.fromDPToPix(this.mContext, 48);
        this.nac.setMaxLines(2);
        paramv = this.nac.ki(i, 2147483647);
        if (paramv == null) {
          break label196;
        }
      }
      label196:
      for (paramInt = paramv.fkV();; paramInt = -1)
      {
        ad.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramv == null) || (paramv.fkV() < 2)) {
          break label201;
        }
        this.nad.setMaxLines(1);
        AppMethodBeat.o(6012);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label201:
      this.nad.setMaxLines(2);
      AppMethodBeat.o(6012);
      return;
    }
    this.naa.setVisibility(0);
    this.nab.setVisibility(8);
    a(this.naa, paramv, true, false);
    AppMethodBeat.o(6012);
  }
  
  public void a(int paramInt1, v paramv, s params, int paramInt2, u paramu, int paramInt3)
  {
    this.mCount = paramInt1;
    this.naf = false;
    this.nag = 0;
    this.nah = paramInt3;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6008);
    super.a(paramView, paramc);
    AppMethodBeat.o(6008);
  }
  
  public void a(s params, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6010);
    super.a(params, paramv, paramView, paramTextView, paramInt);
    this.nag = paramInt;
    if (this.nae == null)
    {
      AppMethodBeat.o(6010);
      return;
    }
    if ((this.naf) && ((this.nag > 0) || (!b(this.mCount, paramv))))
    {
      params = this.nae;
      if (b(paramv)) {}
      for (paramInt = 2131231281;; paramInt = 2131231282)
      {
        params.setBackgroundResource(paramInt);
        AppMethodBeat.o(6010);
        return;
      }
    }
    this.nae.setBackgroundResource(2131233299);
    AppMethodBeat.o(6010);
  }
  
  public final boolean b(v paramv)
  {
    AppMethodBeat.i(6011);
    if (this.mCount > 1)
    {
      AppMethodBeat.o(6011);
      return false;
    }
    if ((this.mCount == 1) && (!b(this.mCount, paramv)))
    {
      AppMethodBeat.o(6011);
      return true;
    }
    AppMethodBeat.o(6011);
    return false;
  }
  
  public final void bDb()
  {
    AppMethodBeat.i(6009);
    if (this.mYI == null)
    {
      AppMethodBeat.o(6009);
      return;
    }
    this.mZR = this.mYI.findViewById(2131305184);
    this.mZS = ((TextView)this.mYI.findViewById(2131300305));
    AppMethodBeat.o(6009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.l
 * JD-Core Version:    0.7.0.1
 */