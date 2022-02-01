package com.tencent.mm.media.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/util/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "plugin-mediaeditor_release"})
public final class a
{
  public f.a ghu;
  private final String ghv;
  
  public a(String paramString)
  {
    AppMethodBeat.i(93870);
    this.ghv = paramString;
    this.ghu = new f.a();
    this.ghu.reset();
    AppMethodBeat.o(93870);
  }
  
  public final void agL()
  {
    AppMethodBeat.i(93868);
    ad.i("MicroMsg.CodeUtil", toString());
    AppMethodBeat.o(93868);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93869);
    String str = "CodeMan task " + this.ghv + " cost : " + this.ghu.XK();
    AppMethodBeat.o(93869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.a
 * JD-Core Version:    0.7.0.1
 */