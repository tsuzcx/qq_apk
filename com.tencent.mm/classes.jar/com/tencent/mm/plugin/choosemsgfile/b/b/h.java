package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class h
  extends d
{
  private String kEL;
  private String kEV;
  
  public h(g paramg, bi parambi)
  {
    super(paramg, parambi);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(54306);
    b.a(this.kEI.bgw().getContext(), paramView, parama);
    AppMethodBeat.o(54306);
  }
  
  public final void a(m paramm, int paramInt)
  {
    AppMethodBeat.i(54305);
    super.a(paramm, paramInt);
    paramm.kFi.setVisibility(0);
    paramm.kFj.setVisibility(0);
    paramm = paramm.kFj;
    if (this.kEV == null) {
      this.kEV = bo.mH(u.vr(this.kEz.field_imgPath).fXx);
    }
    paramm.setText(bo.bf(this.kEV, ""));
    AppMethodBeat.o(54305);
  }
  
  protected final String aaZ()
  {
    AppMethodBeat.i(54304);
    if (this.kEL == null)
    {
      o.alE();
      this.kEL = t.vg(this.kEz.field_imgPath);
    }
    String str = this.kEL;
    AppMethodBeat.o(54304);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.h
 * JD-Core Version:    0.7.0.1
 */