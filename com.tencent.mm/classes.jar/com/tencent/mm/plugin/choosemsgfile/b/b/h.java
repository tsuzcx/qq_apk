package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class h
  extends d
{
  private String ooL;
  private String ooW;
  
  public h(g paramg, bo parambo)
  {
    super(paramg, parambo);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123278);
    com.tencent.mm.plugin.choosemsgfile.b.d.c.a(this.ooI.bUS().getContext(), paramView, parama);
    AppMethodBeat.o(123278);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162329);
    super.a(paramm, paramInt, parama);
    paramm.opk.setVisibility(0);
    paramm.opl.setVisibility(0);
    paramm = paramm.opl;
    if (this.ooW == null) {
      this.ooW = bs.qy(u.Ej(this.ooz.field_imgPath).hpy);
    }
    paramm.setText(bs.bG(this.ooW, ""));
    AppMethodBeat.o(162329);
  }
  
  protected final String azl()
  {
    AppMethodBeat.i(123276);
    if (this.ooL == null)
    {
      o.aJy();
      this.ooL = t.DW(this.ooz.field_imgPath);
    }
    String str = this.ooL;
    AppMethodBeat.o(123276);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.h
 * JD-Core Version:    0.7.0.1
 */