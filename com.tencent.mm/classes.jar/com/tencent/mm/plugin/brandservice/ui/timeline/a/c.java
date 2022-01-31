package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class c
  extends e
{
  public TextView jXA;
  public ImageView jXG;
  public ImageView jXH;
  public MMNeat7extView jXI;
  public LinearLayout jXJ;
  public MMNeat7extView jXK;
  public MMNeat7extView jXL;
  public LinearLayout jXM;
  public boolean jXN = false;
  public int jXO = 0;
  public View jXz;
  public int mCount = 0;
  
  private void a(MMNeat7extView paramMMNeat7extView, com.tencent.mm.af.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(152634);
    paramMMNeat7extView.setMaxLines(2);
    if (!bo.isNullOrNil(paramq.title)) {
      paramMMNeat7extView.af(paramq.title);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramq = d.kiX;
        d.a(paramMMNeat7extView);
      }
      AppMethodBeat.o(152634);
      return;
      paramMMNeat7extView.af(this.mContext.getText(2131297697));
    }
  }
  
  public static boolean b(int paramInt, com.tencent.mm.af.q paramq)
  {
    AppMethodBeat.i(152633);
    if ((paramq.type == 0) || (paramq.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.a.aZW()))
      {
        AppMethodBeat.o(152633);
        return true;
      }
      AppMethodBeat.o(152633);
      return false;
    }
    if (paramInt == 1)
    {
      AppMethodBeat.o(152633);
      return true;
    }
    AppMethodBeat.o(152633);
    return false;
  }
  
  public void a(int paramInt, com.tencent.mm.af.q paramq)
  {
    AppMethodBeat.i(152632);
    if (b(paramInt, paramq))
    {
      this.jXI.setVisibility(8);
      this.jXJ.setVisibility(0);
      a(this.jXK, paramq, false);
      MMNeat7extView localMMNeat7extView = this.jXL;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!bo.isNullOrNil(paramq.fjL))
      {
        paramq = com.tencent.mm.plugin.brandservice.ui.b.c.Hv(paramq.fjL);
        localMMNeat7extView.setVisibility(0);
        localMMNeat7extView.af(paramq);
        i = com.tencent.mm.cb.a.gw(this.mContext) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48);
        this.jXK.setMaxLines(2);
        paramq = this.jXK.Sa(i);
        if (paramq == null) {
          break label191;
        }
      }
      label191:
      for (paramInt = paramq.dTo();; paramInt = -1)
      {
        ab.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramq == null) || (paramq.dTo() < 2)) {
          break label196;
        }
        this.jXL.setMaxLines(1);
        AppMethodBeat.o(152632);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label196:
      this.jXL.setMaxLines(2);
      AppMethodBeat.o(152632);
      return;
    }
    this.jXI.setVisibility(0);
    this.jXJ.setVisibility(8);
    a(this.jXI, paramq, true);
    AppMethodBeat.o(152632);
  }
  
  public void a(int paramInt1, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt2, p paramp)
  {
    this.mCount = paramInt1;
    this.jXN = false;
    this.jXO = 0;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14243);
    super.a(paramView, parama);
    AppMethodBeat.o(14243);
  }
  
  public void a(com.tencent.mm.storage.q paramq, com.tencent.mm.af.q paramq1, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(152630);
    super.a(paramq, paramq1, paramView, paramTextView, paramInt);
    this.jXO = paramInt;
    if (this.jXM == null)
    {
      AppMethodBeat.o(152630);
      return;
    }
    if ((this.jXN) && ((this.jXO > 0) || (!b(this.mCount, paramq1))))
    {
      paramq = this.jXM;
      if (b(paramq1)) {}
      for (paramInt = 2130837981;; paramInt = 2130837982)
      {
        paramq.setBackgroundResource(paramInt);
        AppMethodBeat.o(152630);
        return;
      }
    }
    this.jXM.setBackgroundResource(2130839676);
    AppMethodBeat.o(152630);
  }
  
  public final void aWY()
  {
    AppMethodBeat.i(14244);
    if (this.jXr == null)
    {
      AppMethodBeat.o(14244);
      return;
    }
    this.jXz = this.jXr.findViewById(2131821900);
    this.jXA = ((TextView)this.jXr.findViewById(2131821901));
    AppMethodBeat.o(14244);
  }
  
  public final boolean b(com.tencent.mm.af.q paramq)
  {
    AppMethodBeat.i(152631);
    if (this.mCount > 1)
    {
      AppMethodBeat.o(152631);
      return false;
    }
    if ((this.mCount == 1) && (!b(this.mCount, paramq)))
    {
      AppMethodBeat.o(152631);
      return true;
    }
    AppMethodBeat.o(152631);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c
 * JD-Core Version:    0.7.0.1
 */