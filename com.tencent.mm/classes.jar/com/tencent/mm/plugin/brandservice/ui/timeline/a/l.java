package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class l
  extends n
{
  public int mCount = 0;
  public MMNeat7extView nCA;
  public MMNeat7extView nCB;
  public LinearLayout nCC;
  public boolean nCD = false;
  public int nCE = 0;
  public int nCF = 0;
  public View nCp;
  public TextView nCq;
  public ImageView nCw;
  public ImageView nCx;
  public MMNeat7extView nCy;
  public LinearLayout nCz;
  
  private void a(MMNeat7extView paramMMNeat7extView, v paramv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(162406);
    paramMMNeat7extView.setMaxLines(2);
    int i;
    com.tencent.mm.plugin.brandservice.b.a locala;
    if (paramBoolean2)
    {
      i = 0;
      if (bs.isNullOrNil(paramv.title)) {
        break label69;
      }
      locala = com.tencent.mm.plugin.brandservice.b.a.nuP;
      com.tencent.mm.plugin.brandservice.b.a.a(paramv.title, paramMMNeat7extView, paramv, i);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        paramv = d.nPK;
        d.a(paramMMNeat7extView);
      }
      AppMethodBeat.o(162406);
      return;
      i = 11;
      break;
      label69:
      locala = com.tencent.mm.plugin.brandservice.b.a.nuP;
      com.tencent.mm.plugin.brandservice.b.a.a(this.mContext.getString(2131756613), paramMMNeat7extView, paramv, i);
    }
  }
  
  public static boolean b(int paramInt, v paramv)
  {
    AppMethodBeat.i(6013);
    if ((paramv.type == 0) || (paramv.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.a.bNH()))
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
      this.nCy.setVisibility(8);
      this.nCz.setVisibility(0);
      a(this.nCA, paramv, false, true);
      MMNeat7extView localMMNeat7extView = this.nCB;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!bs.isNullOrNil(paramv.hlf))
      {
        paramv = com.tencent.mm.plugin.brandservice.ui.b.c.Ur(paramv.hlf);
        localMMNeat7extView.setVisibility(0);
        localMMNeat7extView.ar(paramv);
        i = com.tencent.mm.cc.a.ig(this.mContext) - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 48);
        this.nCA.setMaxLines(2);
        paramv = this.nCA.kv(i, 2147483647);
        if (paramv == null) {
          break label196;
        }
      }
      label196:
      for (paramInt = paramv.fBm();; paramInt = -1)
      {
        ac.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramv == null) || (paramv.fBm() < 2)) {
          break label201;
        }
        this.nCB.setMaxLines(1);
        AppMethodBeat.o(6012);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label201:
      this.nCB.setMaxLines(2);
      AppMethodBeat.o(6012);
      return;
    }
    this.nCy.setVisibility(0);
    this.nCz.setVisibility(8);
    a(this.nCy, paramv, true, false);
    AppMethodBeat.o(6012);
  }
  
  public void a(int paramInt1, v paramv, t paramt, int paramInt2, u paramu, int paramInt3)
  {
    this.mCount = paramInt1;
    this.nCD = false;
    this.nCE = 0;
    this.nCF = paramInt3;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    AppMethodBeat.i(6008);
    super.a(paramView, paramc);
    AppMethodBeat.o(6008);
  }
  
  public void a(t paramt, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6010);
    super.a(paramt, paramv, paramView, paramTextView, paramInt);
    this.nCE = paramInt;
    if (this.nCC == null)
    {
      AppMethodBeat.o(6010);
      return;
    }
    if ((this.nCD) && ((this.nCE > 0) || (!b(this.mCount, paramv))))
    {
      paramt = this.nCC;
      if (b(paramv)) {}
      for (paramInt = 2131231281;; paramInt = 2131231282)
      {
        paramt.setBackgroundResource(paramInt);
        AppMethodBeat.o(6010);
        return;
      }
    }
    this.nCC.setBackgroundResource(2131233299);
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
  
  public final void bKk()
  {
    AppMethodBeat.i(6009);
    if (this.nBh == null)
    {
      AppMethodBeat.o(6009);
      return;
    }
    this.nCp = this.nBh.findViewById(2131305184);
    this.nCq = ((TextView)this.nBh.findViewById(2131300305));
    AppMethodBeat.o(6009);
  }
  
  public final int bKl()
  {
    AppMethodBeat.i(198718);
    int i = com.tencent.mm.cc.a.ig(this.mContext);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.c.nzc;
    AppMethodBeat.o(198718);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.l
 * JD-Core Version:    0.7.0.1
 */