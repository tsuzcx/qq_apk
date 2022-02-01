package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;

public class g
  extends d
{
  private String ooL;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bo parambo)
  {
    super(paramg, parambo);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123275);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.ooI.bUS().getContext(), paramView, parama);
    AppMethodBeat.o(123275);
  }
  
  protected String azl()
  {
    AppMethodBeat.i(123274);
    if (this.ooL == null)
    {
      this.ooL = o.aFx().b(this.ooz.field_imgPath, false, false);
      if ((!bs.isNullOrNil(this.ooL)) && (!this.ooL.endsWith("hd")) && (i.eA(this.ooL + "hd"))) {
        this.ooL += "hd";
      }
    }
    String str = this.ooL;
    AppMethodBeat.o(123274);
    return str;
  }
  
  public final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.g
 * JD-Core Version:    0.7.0.1
 */