package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.a;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.storage.cc;

public final class s
  implements aa
{
  private final a oMV;
  private j oMW;
  
  public s()
  {
    AppMethodBeat.i(116833);
    this.oMV = new a((byte)0);
    AppMethodBeat.o(116833);
  }
  
  public final void a(t.c paramc)
  {
    AppMethodBeat.i(243132);
    t.a(paramc);
    AppMethodBeat.o(243132);
  }
  
  public final void a(j paramj)
  {
    this.oMW = paramj;
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(116835);
    this.oMV.add(paramq);
    AppMethodBeat.o(116835);
  }
  
  public final String ak(cc paramcc)
  {
    AppMethodBeat.i(116834);
    if (this.oMW != null)
    {
      paramcc = this.oMW.ak(paramcc);
      AppMethodBeat.o(116834);
      return paramcc;
    }
    AppMethodBeat.o(116834);
    return null;
  }
  
  public final q bKU()
  {
    return this.oMV;
  }
  
  static final class a
    extends a<q>
    implements q
  {
    public final void a(final don paramdon, final cc paramcc)
    {
      AppMethodBeat.i(116832);
      a(new a.a() {});
      AppMethodBeat.o(116832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.s
 * JD-Core Version:    0.7.0.1
 */