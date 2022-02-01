package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;

public class g
  extends d
{
  private String tMu;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, ca paramca)
  {
    super(paramg, paramca);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123275);
    c.a(cMM().cMX().getContext(), paramView, parama);
    AppMethodBeat.o(123275);
  }
  
  protected String bfg()
  {
    AppMethodBeat.i(123274);
    if (this.tMu == null)
    {
      this.tMu = q.bmh().d(this.tMi.field_imgPath, false, false);
      if ((!Util.isNullOrNil(this.tMu)) && (!this.tMu.endsWith("hd")) && (u.agG(this.tMu + "hd"))) {
        this.tMu += "hd";
      }
    }
    String str = this.tMu;
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