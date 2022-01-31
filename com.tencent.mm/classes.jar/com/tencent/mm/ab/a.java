package com.tencent.mm.ab;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class a
{
  public g.a eMo;
  private final String eMp;
  
  public a(String paramString)
  {
    AppMethodBeat.i(114168);
    this.eMp = paramString;
    this.eMo = new g.a();
    this.eMo.reset();
    AppMethodBeat.o(114168);
  }
  
  public final void SS()
  {
    AppMethodBeat.i(114166);
    ab.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(114166);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114167);
    String str = "CodeMan task " + this.eMp + " cost : " + this.eMo.Mm();
    AppMethodBeat.o(114167);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ab.a
 * JD-Core Version:    0.7.0.1
 */