package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class h
  extends d
{
  private String qnH;
  private String qnS;
  
  public h(g paramg, ca paramca)
  {
    super(paramg, paramca);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123278);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.qnE.cyC().getContext(), paramView, parama);
    AppMethodBeat.o(123278);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162329);
    super.a(paramm, paramInt, parama);
    paramm.qof.setVisibility(0);
    paramm.qog.setVisibility(0);
    paramm = paramm.qog;
    if (this.qnS == null) {
      this.qnS = Util.formatSecToMin(u.QN(this.qnv.field_imgPath).iFw);
    }
    paramm.setText(Util.nullAs(this.qnS, ""));
    AppMethodBeat.o(162329);
  }
  
  protected final String aWd()
  {
    AppMethodBeat.i(123276);
    if (this.qnH == null)
    {
      o.bhj();
      this.qnH = t.Qx(this.qnv.field_imgPath);
    }
    String str = this.qnH;
    AppMethodBeat.o(123276);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.h
 * JD-Core Version:    0.7.0.1
 */