package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class b
{
  private final String fJi;
  public f.a gFK;
  
  public b(String paramString)
  {
    AppMethodBeat.i(153445);
    this.fJi = paramString;
    this.gFK = new f.a();
    this.gFK.reset();
    AppMethodBeat.o(153445);
  }
  
  public final void akO()
  {
    AppMethodBeat.i(153443);
    ad.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(153443);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153444);
    String str = "CodeMan task " + this.fJi + " cost : " + this.gFK.abj();
    AppMethodBeat.o(153444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ad.b
 * JD-Core Version:    0.7.0.1
 */