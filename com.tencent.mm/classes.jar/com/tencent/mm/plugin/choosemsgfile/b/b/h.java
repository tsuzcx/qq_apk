package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class h
  extends d
{
  private String oSg;
  private String oSr;
  
  public h(g paramg, bu parambu)
  {
    super(paramg, parambu);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123278);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.oSd.bZx().getContext(), paramView, parama);
    AppMethodBeat.o(123278);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162329);
    super.a(paramm, paramInt, parama);
    paramm.oSF.setVisibility(0);
    paramm.oSG.setVisibility(0);
    paramm = paramm.oSG;
    if (this.oSr == null) {
      this.oSr = bt.qY(u.Hy(this.oRU.field_imgPath).hHQ);
    }
    paramm.setText(bt.bI(this.oSr, ""));
    AppMethodBeat.o(162329);
  }
  
  protected final String aCp()
  {
    AppMethodBeat.i(123276);
    if (this.oSg == null)
    {
      o.aMJ();
      this.oSg = t.Hi(this.oRU.field_imgPath);
    }
    String str = this.oSg;
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