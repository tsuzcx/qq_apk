package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class c
{
  public f.a hvh;
  private final String taskName;
  
  public c(String paramString)
  {
    AppMethodBeat.i(153445);
    this.taskName = paramString;
    this.hvh = new f.a();
    this.hvh.reset();
    AppMethodBeat.o(153445);
  }
  
  public final void aBw()
  {
    AppMethodBeat.i(153443);
    Log.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(153443);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153444);
    String str = "CodeMan task " + this.taskName + " cost : " + this.hvh.apr();
    AppMethodBeat.o(153444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ac.c
 * JD-Core Version:    0.7.0.1
 */