package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.choosemsgfile.logic.c.c;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.g;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class h
  extends d
{
  private String wPK;
  private String wPQ;
  
  public h(g paramg, cc paramcc)
  {
    super(paramg, paramcc);
  }
  
  public final void a(View paramView, a parama)
  {
    AppMethodBeat.i(123278);
    c.a(dqr().dqD().getContext(), paramView, parama);
    AppMethodBeat.o(123278);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162329);
    super.a(paramm, paramInt, parama);
    paramm.wQd.setVisibility(0);
    paramm.wQe.setVisibility(0);
    paramm = paramm.wQe;
    if (this.wPQ == null) {
      this.wPQ = Util.formatSecToMin(ab.Qo(this.wPy.field_imgPath).omT);
    }
    paramm.setText(Util.nullAs(this.wPQ, ""));
    AppMethodBeat.o(162329);
  }
  
  protected final String bCX()
  {
    AppMethodBeat.i(123276);
    if (this.wPK == null)
    {
      v.bOh();
      this.wPK = aa.PY(this.wPy.field_imgPath);
    }
    String str = this.wPK;
    AppMethodBeat.o(123276);
    return str;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.h
 * JD-Core Version:    0.7.0.1
 */