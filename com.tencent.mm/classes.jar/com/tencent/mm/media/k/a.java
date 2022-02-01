package com.tencent.mm.media.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/util/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "plugin-mediaeditor_release"})
public final class a
{
  private final String fJi;
  public f.a gFK;
  
  public a(String paramString)
  {
    AppMethodBeat.i(93870);
    this.fJi = paramString;
    this.gFK = new f.a();
    this.gFK.reset();
    AppMethodBeat.o(93870);
  }
  
  public final void akO()
  {
    AppMethodBeat.i(93868);
    ad.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(93868);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93869);
    String str = "CodeMan task " + this.fJi + " cost : " + this.gFK.abj();
    AppMethodBeat.o(93869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.k.a
 * JD-Core Version:    0.7.0.1
 */