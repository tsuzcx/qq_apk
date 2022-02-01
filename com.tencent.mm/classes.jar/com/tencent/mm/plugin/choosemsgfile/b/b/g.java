package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public class g
  extends d
{
  private String oSg;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bu parambu)
  {
    super(paramg, parambu);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123275);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.oSd.bZx().getContext(), paramView, parama);
    AppMethodBeat.o(123275);
  }
  
  protected String aCp()
  {
    AppMethodBeat.i(123274);
    if (this.oSg == null)
    {
      this.oSg = q.aIF().c(this.oRU.field_imgPath, false, false);
      if ((!bt.isNullOrNil(this.oSg)) && (!this.oSg.endsWith("hd")) && (com.tencent.mm.vfs.i.fv(this.oSg + "hd"))) {
        this.oSg += "hd";
      }
    }
    String str = this.oSg;
    AppMethodBeat.o(123274);
    return str;
  }
  
  public final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.g
 * JD-Core Version:    0.7.0.1
 */