package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class b
{
  public f.a ghu;
  private final String ghv;
  
  public b(String paramString)
  {
    AppMethodBeat.i(153445);
    this.ghv = paramString;
    this.ghu = new f.a();
    this.ghu.reset();
    AppMethodBeat.o(153445);
  }
  
  public final void agL()
  {
    AppMethodBeat.i(153443);
    ad.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(153443);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153444);
    String str = "CodeMan task " + this.ghv + " cost : " + this.ghu.XK();
    AppMethodBeat.o(153444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ad.b
 * JD-Core Version:    0.7.0.1
 */