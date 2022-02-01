package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;

public class g
  extends d
{
  private String oYI;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bv parambv)
  {
    super(paramg, parambv);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123275);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.oYF.caM().getContext(), paramView, parama);
    AppMethodBeat.o(123275);
  }
  
  protected String aCF()
  {
    AppMethodBeat.i(123274);
    if (this.oYI == null)
    {
      this.oYI = q.aIX().c(this.oYw.field_imgPath, false, false);
      if ((!bu.isNullOrNil(this.oYI)) && (!this.oYI.endsWith("hd")) && (o.fB(this.oYI + "hd"))) {
        this.oYI += "hd";
      }
    }
    String str = this.oYI;
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