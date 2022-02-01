package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public class g
  extends d
{
  private String qnH;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, ca paramca)
  {
    super(paramg, paramca);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123275);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.qnE.cyC().getContext(), paramView, parama);
    AppMethodBeat.o(123275);
  }
  
  protected String aWd()
  {
    AppMethodBeat.i(123274);
    if (this.qnH == null)
    {
      this.qnH = q.bcR().d(this.qnv.field_imgPath, false, false);
      if ((!Util.isNullOrNil(this.qnH)) && (!this.qnH.endsWith("hd")) && (s.YS(this.qnH + "hd"))) {
        this.qnH += "hd";
      }
    }
    String str = this.qnH;
    AppMethodBeat.o(123274);
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