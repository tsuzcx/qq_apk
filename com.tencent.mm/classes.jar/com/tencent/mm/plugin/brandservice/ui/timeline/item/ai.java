package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.f;

public class ai
  extends aj
{
  public int mCount = 0;
  public ImageView ptG;
  public MMNeat7extView ptR;
  public ImageView ptS;
  public LinearLayout ptT;
  public LinearLayout ptU;
  public MMNeat7extView ptV;
  public MMNeat7extView ptW;
  public View ptX;
  public TextView ptY;
  public TextView pxA;
  public boolean pxB = false;
  public int pxC = 0;
  public int pxD = 0;
  public View pxz;
  
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
      com.tencent.mm.plugin.brandservice.b.a.pmT.a(paramv.title, paramMMNeat7extView, paramv, i);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        paramv = d.pMy;
        d.c(paramMMNeat7extView);
      }
      AppMethodBeat.o(162406);
      return;
      i = 11;
      break;
      label67:
      com.tencent.mm.plugin.brandservice.b.a.pmT.a(this.mContext.getString(2131756755), paramMMNeat7extView, paramv, i);
    }
  }
  
  public static boolean a(int paramInt, v paramv)
  {
    AppMethodBeat.i(6013);
    if ((paramv.type == 0) || (paramv.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.a.crf()))
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
    AppMethodBeat.i(194971);
    if (a(paramInt, paramv))
    {
      this.ptR.setVisibility(8);
      this.ptU.setVisibility(0);
      a(this.ptV, paramv, false, true);
      MMNeat7extView localMMNeat7extView = this.ptW;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!Util.isNullOrNil(paramv.iAq))
      {
        Object localObject = d.pMy;
        if (!((Boolean)d.pMw.getValue()).booleanValue())
        {
          localObject = c.aiW(paramv.iAq);
          localMMNeat7extView.setVisibility(0);
          localMMNeat7extView.aw((CharSequence)localObject);
          this.ptX.setVisibility(8);
          a(this.pxz, this.pxA, paramz, paramv);
          i = com.tencent.mm.cb.a.jn(this.mContext) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48);
          this.ptV.setMaxLines(2);
          paramv = this.ptV.mq(i, 2147483647);
          if (paramv == null) {
            break label245;
          }
        }
      }
      label245:
      for (paramInt = paramv.hiG();; paramInt = -1)
      {
        Log.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramv == null) || (paramv.hiG() < 2)) {
          break label250;
        }
        this.ptW.setMaxLines(1);
        AppMethodBeat.o(194971);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label250:
      this.ptW.setMaxLines(2);
      AppMethodBeat.o(194971);
      return;
    }
    this.ptR.setVisibility(0);
    this.ptU.setVisibility(8);
    a(this.ptR, paramv, true, false);
    AppMethodBeat.o(194971);
  }
  
  public void a(int paramInt1, v paramv, z paramz, int paramInt2, u paramu, int paramInt3)
  {
    this.mCount = paramInt1;
    this.pxB = false;
    this.pxC = 0;
    this.pxD = paramInt3;
  }
  
  public void a(View paramView, b paramb)
  {
    AppMethodBeat.i(6008);
    super.a(paramView, paramb);
    AppMethodBeat.o(6008);
  }
  
  public void a(z paramz, v paramv, View paramView, TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(6010);
    super.a(paramz, paramv, paramView, paramTextView, paramInt);
    this.pxC = paramInt;
    if (this.ptT == null)
    {
      AppMethodBeat.o(6010);
      return;
    }
    if ((this.pxB) && ((this.pxC > 0) || (!a(this.mCount, paramv))))
    {
      paramz = this.ptT;
      if (b(paramv)) {}
      for (paramInt = 2131231341;; paramInt = 2131231342)
      {
        paramz.setBackgroundResource(paramInt);
        AppMethodBeat.o(6010);
        return;
      }
    }
    this.ptT.setBackgroundResource(2131233974);
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
  
  public final void cmH()
  {
    AppMethodBeat.i(6009);
    if (this.puO == null)
    {
      AppMethodBeat.o(6009);
      return;
    }
    this.ptX = this.puO.findViewById(2131308374);
    this.ptY = ((TextView)this.puO.findViewById(2131301796));
    AppMethodBeat.o(6009);
  }
  
  public final int cnf()
  {
    AppMethodBeat.i(194970);
    int i = com.tencent.mm.cb.a.jn(this.mContext);
    int j = b.prw;
    AppMethodBeat.o(194970);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ai
 * JD-Core Version:    0.7.0.1
 */