package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;

public class g
  extends d
{
  private String nLL;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bl parambl)
  {
    super(paramg, parambl);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123275);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.nLI.bNH().getContext(), paramView, parama);
    AppMethodBeat.o(123275);
  }
  
  protected String asu()
  {
    AppMethodBeat.i(123274);
    if (this.nLL == null)
    {
      this.nLL = o.ayF().b(this.nLz.field_imgPath, false, false);
      if ((!bt.isNullOrNil(this.nLL)) && (!this.nLL.endsWith("hd")) && (i.eK(this.nLL + "hd"))) {
        this.nLL += "hd";
      }
    }
    String str = this.nLL;
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