package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.choosemsgfile.logic.c.c;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;

public class g
  extends d
{
  private String wPK;
  
  public g(com.tencent.mm.plugin.choosemsgfile.logic.ui.g paramg, cc paramcc)
  {
    super(paramg, paramcc);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123275);
    c.a(dqr().dqD().getContext(), paramView, parama);
    AppMethodBeat.o(123275);
  }
  
  protected String bCX()
  {
    AppMethodBeat.i(123274);
    if (this.wPK == null)
    {
      this.wPK = r.bKa().d(this.wPy.field_imgPath, false, false);
      if ((!Util.isNullOrNil(this.wPK)) && (!this.wPK.endsWith("hd")) && (y.ZC(this.wPK + "hd"))) {
        this.wPK += "hd";
      }
    }
    String str = this.wPK;
    AppMethodBeat.o(123274);
    return str;
  }
  
  public final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.g
 * JD-Core Version:    0.7.0.1
 */