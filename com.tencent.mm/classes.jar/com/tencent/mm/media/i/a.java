package com.tencent.mm.media.i;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/util/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "plugin-mediaeditor_release"})
public final class a
{
  public g.a eMo;
  private final String eMp;
  
  public a(String paramString)
  {
    AppMethodBeat.i(13113);
    this.eMp = paramString;
    this.eMo = new g.a();
    this.eMo.reset();
    AppMethodBeat.o(13113);
  }
  
  public final void SS()
  {
    AppMethodBeat.i(13111);
    ab.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(13111);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13112);
    String str = "CodeMan task " + this.eMp + " cost : " + this.eMo.Mm();
    AppMethodBeat.o(13112);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.i.a
 * JD-Core Version:    0.7.0.1
 */