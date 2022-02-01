package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class b
{
  public f.a gma;
  private final String gmb;
  
  public b(String paramString)
  {
    AppMethodBeat.i(153445);
    this.gmb = paramString;
    this.gma = new f.a();
    this.gma.reset();
    AppMethodBeat.o(153445);
  }
  
  public final void aic()
  {
    AppMethodBeat.i(153443);
    ac.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(153443);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153444);
    String str = "CodeMan task " + this.gmb + " cost : " + this.gma.YH();
    AppMethodBeat.o(153444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ac.b
 * JD-Core Version:    0.7.0.1
 */