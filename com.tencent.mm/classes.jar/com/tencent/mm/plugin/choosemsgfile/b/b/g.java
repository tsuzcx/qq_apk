package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public class g
  extends d
{
  private String kEL;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bi parambi)
  {
    super(paramg, parambi);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(54303);
    b.a(this.kEI.bgw().getContext(), paramView, parama);
    AppMethodBeat.o(54303);
  }
  
  protected String aaZ()
  {
    AppMethodBeat.i(54302);
    if (this.kEL == null)
    {
      this.kEL = o.ahC().c(this.kEz.field_imgPath, false, false);
      if ((!bo.isNullOrNil(this.kEL)) && (!this.kEL.endsWith("hd")) && (e.cN(this.kEL + "hd"))) {
        this.kEL += "hd";
      }
    }
    String str = this.kEL;
    AppMethodBeat.o(54302);
    return str;
  }
  
  public final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.g
 * JD-Core Version:    0.7.0.1
 */