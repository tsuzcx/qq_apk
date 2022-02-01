package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class b
{
  private final String fLl;
  public f.a gIr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(153445);
    this.fLl = paramString;
    this.gIr = new f.a();
    this.gIr.reset();
    AppMethodBeat.o(153445);
  }
  
  public final void ald()
  {
    AppMethodBeat.i(153443);
    ae.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(153443);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153444);
    String str = "CodeMan task " + this.fLl + " cost : " + this.gIr.abs();
    AppMethodBeat.o(153444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ac.b
 * JD-Core Version:    0.7.0.1
 */