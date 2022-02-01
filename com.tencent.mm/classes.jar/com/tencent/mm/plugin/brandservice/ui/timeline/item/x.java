package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class x
  extends z
{
  public int mCount = 0;
  public MMNeat7extView ocA;
  public ImageView ocB;
  public LinearLayout ocC;
  public LinearLayout ocD;
  public MMNeat7extView ocE;
  public MMNeat7extView ocF;
  public View ocG;
  public TextView ocH;
  public ImageView ocp;
  public boolean ofc = false;
  public int ofd = 0;
  public int ofe = 0;
  
  private void a(MMNeat7extView paramMMNeat7extView, v paramv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(162406);
    paramMMNeat7extView.setMaxLines(2);
    int i;
    com.tencent.mm.plugin.brandservice.b.a locala;
    if (paramBoolean2)
    {
      i = 0;
      if (bt.isNullOrNil(paramv.title)) {
        break label69;
      }
      locala = com.tencent.mm.plugin.brandservice.b.a.nWn;
      com.tencent.mm.plugin.brandservice.b.a.a(paramv.title, paramMMNeat7extView, paramv, i);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        paramv = d.osr;
        d.a(paramMMNeat7extView);
      }
      AppMethodBeat.o(162406);
      return;
      i = 11;
      break;
      label69:
      locala = com.tencent.mm.plugin.brandservice.b.a.nWn;
      com.tencent.mm.plugin.brandservice.b.a.a(this.mContext.getString(2131756613), paramMMNeat7extView, paramv, i);
    }
  }
  
  public static boolean b(int paramInt, v paramv)
  {
    AppMethodBeat.i(6013);
    if ((paramv.type == 0) || (paramv.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.a.bSh()))
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
      this.ocA.setVisibility(8);
      this.ocD.setVisibility(0);
      a(this.ocE, paramv, false, true);
      MMNeat7extView localMMNeat7extView = this.ocF;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!bt.isNullOrNil(paramv.hDo))
      {
        paramv = c.Ya(paramv.hDo);
        localMMNeat7extView.setVisibility(0);
        localMMNeat7extView.ar(paramv);
        i = com.tencent.mm.cc.a.ip(this.mContext) - com.tencent.mm.cc.a.fromDPToPix(this.mContext, 48);
        this.ocE.setMaxLines(2);
        paramv = this.ocE.kK(i, 2147483647);
        if (paramv == null) {
          break label196;
        }
      }
      label196:
      for (paramInt = paramv.fSB();; paramInt = -1)
      {
        ad.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramv == null) || (paramv.fSB() < 2)) {
          break label201;
        }
        this.ocF.setMaxLines(1);
        AppMethodBeat.o(6012);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label201:
      this.ocF.setMaxLines(2);
      AppMethodBeat.o(6012);
      return;
    }
    this.ocA.setVisibility(0);
    this.ocD.setVisibility(8);
    a(this.ocA, paramv, true, false);
    AppMethodBeat.o(6012);
  }
  
  public void a(int paramInt1, v paramv, w paramw, int paramInt2, u paramu, int paramInt3)
  {
    this.mCount = paramInt1;
    this.ofc = false;
    this.ofd = 0;
    this.ofe = paramInt3;
  }
  
  public void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6008);
    super.a(paramView, paramb);
    AppMethodBeat.o(6008);
  }
  
  public void a(w paramw, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6010);
    super.a(paramw, paramv, paramView, paramTextView, paramInt);
    this.ofd = paramInt;
    if (this.ocC == null)
    {
      AppMethodBeat.o(6010);
      return;
    }
    if ((this.ofc) && ((this.ofd > 0) || (!b(this.mCount, paramv))))
    {
      paramw = this.ocC;
      if (b(paramv)) {}
      for (paramInt = 2131231281;; paramInt = 2131231282)
      {
        paramw.setBackgroundResource(paramInt);
        AppMethodBeat.o(6010);
        return;
      }
    }
    this.ocC.setBackgroundResource(2131233299);
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
  
  public final int bOM()
  {
    AppMethodBeat.i(209531);
    int i = com.tencent.mm.cc.a.ip(this.mContext);
    int j = b.oah;
    AppMethodBeat.o(209531);
    return i - j;
  }
  
  public final void bOx()
  {
    AppMethodBeat.i(6009);
    if (this.odh == null)
    {
      AppMethodBeat.o(6009);
      return;
    }
    this.ocG = this.odh.findViewById(2131305184);
    this.ocH = ((TextView)this.odh.findViewById(2131300305));
    AppMethodBeat.o(6009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.x
 * JD-Core Version:    0.7.0.1
 */