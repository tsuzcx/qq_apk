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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class h
  extends d
{
  private String oYI;
  private String oYT;
  
  public h(g paramg, bv parambv)
  {
    super(paramg, parambv);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123278);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.oYF.caM().getContext(), paramView, parama);
    AppMethodBeat.o(123278);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162329);
    super.a(paramm, paramInt, parama);
    paramm.oZh.setVisibility(0);
    paramm.oZi.setVisibility(0);
    paramm = paramm.oZi;
    if (this.oYT == null) {
      this.oYT = bu.rb(u.Ia(this.oYw.field_imgPath).hKI);
    }
    paramm.setText(bu.bI(this.oYT, ""));
    AppMethodBeat.o(162329);
  }
  
  protected final String aCF()
  {
    AppMethodBeat.i(123276);
    if (this.oYI == null)
    {
      o.aNh();
      this.oYI = t.HK(this.oYw.field_imgPath);
    }
    String str = this.oYI;
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