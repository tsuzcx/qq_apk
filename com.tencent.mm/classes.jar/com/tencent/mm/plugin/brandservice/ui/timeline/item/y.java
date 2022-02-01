package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class y
  extends aa
{
  public int mCount = 0;
  public ImageView oie;
  public MMNeat7extView oip;
  public ImageView oiq;
  public LinearLayout oir;
  public LinearLayout ois;
  public MMNeat7extView oit;
  public MMNeat7extView oiu;
  public View oiv;
  public TextView oiw;
  public boolean olc = false;
  public int old = 0;
  public int ole = 0;
  
  private void a(MMNeat7extView paramMMNeat7extView, v paramv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(162406);
    paramMMNeat7extView.setMaxLines(2);
    int i;
    com.tencent.mm.plugin.brandservice.b.a locala;
    if (paramBoolean2)
    {
      i = 0;
      if (bu.isNullOrNil(paramv.title)) {
        break label69;
      }
      locala = com.tencent.mm.plugin.brandservice.b.a.obW;
      com.tencent.mm.plugin.brandservice.b.a.a(paramv.title, paramMMNeat7extView, paramv, i);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        paramv = d.oyS;
        d.a(paramMMNeat7extView);
      }
      AppMethodBeat.o(162406);
      return;
      i = 11;
      break;
      label69:
      locala = com.tencent.mm.plugin.brandservice.b.a.obW;
      com.tencent.mm.plugin.brandservice.b.a.a(this.mContext.getString(2131756613), paramMMNeat7extView, paramv, i);
    }
  }
  
  public static boolean b(int paramInt, v paramv)
  {
    AppMethodBeat.i(6013);
    if ((paramv.type == 0) || (paramv.type == 1))
    {
      if ((paramInt == 1) && (com.tencent.mm.plugin.brandservice.ui.b.a.bTu()))
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
      this.oip.setVisibility(8);
      this.ois.setVisibility(0);
      a(this.oit, paramv, false, true);
      MMNeat7extView localMMNeat7extView = this.oiu;
      localMMNeat7extView.setMaxLines(2);
      int i;
      if (!bu.isNullOrNil(paramv.hGg))
      {
        paramv = c.YR(paramv.hGg);
        localMMNeat7extView.setVisibility(0);
        localMMNeat7extView.aq(paramv);
        i = com.tencent.mm.cb.a.iu(this.mContext) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48);
        this.oit.setMaxLines(2);
        paramv = this.oit.kR(i, 2147483647);
        if (paramv == null) {
          break label196;
        }
      }
      label196:
      for (paramInt = paramv.fXb();; paramInt = -1)
      {
        ae.v("MicroMsg.BizTimeLineItem", "alvinluo fillTitleLayout title line: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((paramv == null) || (paramv.fXb() < 2)) {
          break label201;
        }
        this.oiu.setMaxLines(1);
        AppMethodBeat.o(6012);
        return;
        localMMNeat7extView.setVisibility(8);
        break;
      }
      label201:
      this.oiu.setMaxLines(2);
      AppMethodBeat.o(6012);
      return;
    }
    this.oip.setVisibility(0);
    this.ois.setVisibility(8);
    a(this.oip, paramv, true, false);
    AppMethodBeat.o(6012);
  }
  
  public void a(int paramInt1, v paramv, w paramw, int paramInt2, u paramu, int paramInt3)
  {
    this.mCount = paramInt1;
    this.olc = false;
    this.old = 0;
    this.ole = paramInt3;
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
    this.old = paramInt;
    if (this.oir == null)
    {
      AppMethodBeat.o(6010);
      return;
    }
    if ((this.olc) && ((this.old > 0) || (!b(this.mCount, paramv))))
    {
      paramw = this.oir;
      if (b(paramv)) {}
      for (paramInt = 2131231281;; paramInt = 2131231282)
      {
        paramw.setBackgroundResource(paramInt);
        AppMethodBeat.o(6010);
        return;
      }
    }
    this.oir.setBackgroundResource(2131233299);
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
  
  public final int bPK()
  {
    AppMethodBeat.i(208487);
    int i = com.tencent.mm.cb.a.iu(this.mContext);
    int j = b.ofX;
    AppMethodBeat.o(208487);
    return i - j;
  }
  
  public final void bPv()
  {
    AppMethodBeat.i(6009);
    if (this.oiV == null)
    {
      AppMethodBeat.o(6009);
      return;
    }
    this.oiv = this.oiV.findViewById(2131305184);
    this.oiw = ((TextView)this.oiV.findViewById(2131300305));
    AppMethodBeat.o(6009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.y
 * JD-Core Version:    0.7.0.1
 */