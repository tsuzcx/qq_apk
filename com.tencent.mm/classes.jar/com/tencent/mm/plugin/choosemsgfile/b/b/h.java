package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class h
  extends d
{
  private String nLL;
  private String nLW;
  
  public h(g paramg, bl parambl)
  {
    super(paramg, parambl);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123278);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.nLI.bNH().getContext(), paramView, parama);
    AppMethodBeat.o(123278);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162329);
    super.a(paramm, paramInt, parama);
    paramm.nMk.setVisibility(0);
    paramm.nMl.setVisibility(0);
    paramm = paramm.nMl;
    if (this.nLW == null) {
      this.nLW = bt.pL(u.Ae(this.nLz.field_imgPath).gOY);
    }
    paramm.setText(bt.by(this.nLW, ""));
    AppMethodBeat.o(162329);
  }
  
  protected final String asu()
  {
    AppMethodBeat.i(123276);
    if (this.nLL == null)
    {
      o.aCI();
      this.nLL = t.zR(this.nLz.field_imgPath);
    }
    String str = this.nLL;
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