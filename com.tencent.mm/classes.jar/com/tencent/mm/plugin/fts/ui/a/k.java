package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class k
  extends a
{
  public String mZq;
  private k.b mZr;
  private k.a mZs;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(62007);
    this.mZr = new k.b(this);
    this.mZs = new k.a(this);
    AppMethodBeat.o(62007);
  }
  
  public a.b Pr()
  {
    return this.mZr;
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(62008);
    this.mZq = bo.bf(m.wA(this.lox), "");
    ab.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.mZq });
    AppMethodBeat.o(62008);
  }
  
  public a.a bCW()
  {
    return this.mZs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k
 * JD-Core Version:    0.7.0.1
 */