package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ab;

public class n
  extends a
{
  public String mZD;
  private n.b mZE;
  private n.a mZF;
  
  public n(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(62021);
    this.mZE = new n.b(this);
    this.mZF = new n.a(this);
    AppMethodBeat.o(62021);
  }
  
  public a.b Pr()
  {
    return this.mZE;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(62022);
    parama = m.wA(this.lox);
    if (parama == null) {}
    for (this.mZD = "";; this.mZD = paramContext.getResources().getString(2131302976, new Object[] { parama }))
    {
      ab.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[] { this.mZD });
      AppMethodBeat.o(62022);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n
 * JD-Core Version:    0.7.0.1
 */