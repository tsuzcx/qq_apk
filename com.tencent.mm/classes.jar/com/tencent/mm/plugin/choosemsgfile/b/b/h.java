package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class h
  extends d
{
  private String tMA;
  private String tMu;
  
  public h(g paramg, ca paramca)
  {
    super(paramg, paramca);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123278);
    c.a(cMM().cMX().getContext(), paramView, parama);
    AppMethodBeat.o(123278);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162329);
    super.a(paramm, paramInt, parama);
    paramm.tMN.setVisibility(0);
    paramm.tMO.setVisibility(0);
    paramm = paramm.tMO;
    if (this.tMA == null) {
      this.tMA = Util.formatSecToMin(y.Yk(this.tMi.field_imgPath).lvw);
    }
    paramm.setText(Util.nullAs(this.tMA, ""));
    AppMethodBeat.o(162329);
  }
  
  protected final String bfg()
  {
    AppMethodBeat.i(123276);
    if (this.tMu == null)
    {
      s.bqB();
      this.tMu = x.XU(this.tMi.field_imgPath);
    }
    String str = this.tMu;
    AppMethodBeat.o(123276);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.h
 * JD-Core Version:    0.7.0.1
 */