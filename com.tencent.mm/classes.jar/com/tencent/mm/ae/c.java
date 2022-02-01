package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class c
{
  public f.a khd;
  private final String taskName;
  
  public c(String paramString)
  {
    AppMethodBeat.i(153445);
    this.taskName = paramString;
    this.khd = new f.a();
    this.khd.reset();
    AppMethodBeat.o(153445);
  }
  
  public final void aIZ()
  {
    AppMethodBeat.i(153443);
    Log.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(153443);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153444);
    String str = "CodeMan task " + this.taskName + " cost : " + this.khd.avE();
    AppMethodBeat.o(153444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.c
 * JD-Core Version:    0.7.0.1
 */