package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.f;

public class ak
  extends al
{
  public int mCount = 0;
  public ImageView sCT;
  public MMNeat7extView sDe;
  public ImageView sDf;
  public LinearLayout sDg;
  public LinearLayout sDh;
  public MMNeat7extView sDi;
  public MMNeat7extView sDj;
  public View sDk;
  public TextView sDl;
  public View sHa;
  public TextView sHb;
  public boolean sHc = false;
  public int sHd = 0;
  public int sHe = 0;
  
  private void a(MMNeat7extView paramMMNeat7extView, v paramv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(162406);
    paramMMNeat7extView.setMaxLines(2);
    int i;
    if (paramBoolean2)
    {
      i = 0;
      if (Util.isNullOrNil(paramv.title)) {
        break label67;
      }
      com.tencent.mm.plugin.brandservice.b.b.svR.a(paramv.title, paramMMNeat7extView, paramv, i);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        paramv = d.sTw;
        d.e(paramMMNeat7extView);
      }
      AppMethodBeat.o(162406);
      return;
      i = 11;
      break;
      label67:
      com.tencent.mm.plugin.brandservice.b.b.svR.a(this.mContext.getString(d.i.suF), paramMMNeat7extView, paramv, i);
    }
  }
  
  public static boolean a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6013);
    if ((paramv.type == 0) || (paramv.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.a.cEo()))
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
  
  public void a(int paramInt, v paramv, z paramz)
  {
    AppMethodBeat.i(264600);
    if (a(paramInt, paramv))
    {
      this.sDe.setVisibility(8);
      this.sDh.setVisibility(0);
      a(this.sDi, paramv, false, true);
      MMNeat7extView localMMNeat7extView = this.sDj;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!Util.isNullOrNil(paramv.lpM))
      {
        Object localObject = d.sTw;
        if (!((Boolean)d.sTu.getValue()).booleanValue())
        {
          localObject = c.aqF(paramv.lpM);
          localMMNeat7extView.setVisibility(0);
          localMMNeat7extView.aL((CharSequence)localObject);
          this.sDk.setVisibility(8);
          a(this.sHa, this.sHb, paramz, paramv);
          i = com.tencent.mm.ci.a.kr(this.mContext) - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 48);
          this.sDi.setMaxLines(2);
          paramv = this.sDi.nH(i, 2147483647);
          if (paramv == null) {
            break label245;
          }
        }
      }
      label245:
      for (paramInt = paramv.ikp();; paramInt = -1)
      {
        Log.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramv == null) || (paramv.ikp() < 2)) {
          break label250;
        }
        this.sDj.setMaxLines(1);
        AppMethodBeat.o(264600);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label250:
      this.sDj.setMaxLines(2);
      AppMethodBeat.o(264600);
      return;
    }
    this.sDe.setVisibility(0);
    this.sDh.setVisibility(8);
    a(this.sDe, paramv, true, false);
    AppMethodBeat.o(264600);
  }
  
  public void a(int paramInt1, v paramv, z paramz, int paramInt2, u paramu, int paramInt3)
  {
    this.mCount = paramInt1;
    this.sHc = false;
    this.sHd = 0;
    this.sHe = paramInt3;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6008);
    super.a(paramView, paramb);
    AppMethodBeat.o(6008);
  }
  
  public void a(z paramz, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6010);
    super.a(paramz, paramv, paramView, paramTextView, paramInt);
    this.sHd = paramInt;
    if (this.sDg == null)
    {
      AppMethodBeat.o(6010);
      return;
    }
    if ((this.sHc) && ((this.sHd > 0) || (!a(this.mCount, paramv))))
    {
      paramz = this.sDg;
      if (b(paramv)) {}
      for (paramInt = d.d.spI;; paramInt = d.d.dmA)
      {
        paramz.setBackgroundResource(paramInt);
        AppMethodBeat.o(6010);
        return;
      }
    }
    this.sDg.setBackgroundResource(d.d.mm_trans);
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
    if ((this.mCount == 1) && (!a(this.mCount, paramv)))
    {
      AppMethodBeat.o(6011);
      return true;
    }
    AppMethodBeat.o(6011);
    return false;
  }
  
  public final void cAo()
  {
    AppMethodBeat.i(6009);
    if (this.sEi == null)
    {
      AppMethodBeat.o(6009);
      return;
    }
    this.sDk = this.sEi.findViewById(d.e.sta);
    this.sDl = ((TextView)this.sEi.findViewById(d.e.srT));
    AppMethodBeat.o(6009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ak
 * JD-Core Version:    0.7.0.1
 */