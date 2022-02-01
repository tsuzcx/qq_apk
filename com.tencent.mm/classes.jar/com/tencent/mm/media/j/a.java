package com.tencent.mm.media.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/util/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "plugin-mediaeditor_release"})
public final class a
{
  public f.a gma;
  private final String gmb;
  
  public a(String paramString)
  {
    AppMethodBeat.i(93870);
    this.gmb = paramString;
    this.gma = new f.a();
    this.gma.reset();
    AppMethodBeat.o(93870);
  }
  
  public final void aic()
  {
    AppMethodBeat.i(93868);
    ac.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(93868);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93869);
    String str = "CodeMan task " + this.gmb + " cost : " + this.gma.YH();
    AppMethodBeat.o(93869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.j.a
 * JD-Core Version:    0.7.0.1
 */