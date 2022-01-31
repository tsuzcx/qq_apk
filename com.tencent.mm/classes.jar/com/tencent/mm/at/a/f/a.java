package com.tencent.mm.at.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

public final class a
  implements Runnable
{
  private final com.tencent.mm.at.a.a.b fGZ;
  private final com.tencent.mm.at.a.b fHE;
  private final com.tencent.mm.at.a.c.c fHF;
  private final com.tencent.mm.at.a.a.c fHh;
  private final com.tencent.mm.at.a.c.a fHj;
  private final com.tencent.mm.at.a.c.b fHk;
  private final String url;
  
  public a(String paramString, com.tencent.mm.at.a.a.c paramc, com.tencent.mm.at.a.b paramb, com.tencent.mm.at.a.c.c paramc1)
  {
    AppMethodBeat.i(116104);
    this.url = paramString;
    this.fHE = paramb;
    this.fGZ = this.fHE.fGZ;
    if (paramc == null)
    {
      this.fHh = this.fGZ.fHh;
      this.fHF = paramc1;
      if (this.fHh.fHk == null) {
        break label97;
      }
    }
    label97:
    for (this.fHk = this.fHh.fHk;; this.fHk = this.fGZ.fHk)
    {
      this.fHj = this.fGZ.fHj;
      AppMethodBeat.o(116104);
      return;
      this.fHh = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(116105);
    new com.tencent.mm.at.a.d.b();
    com.tencent.mm.at.a.d.b localb = this.fHk.tB(this.url);
    if (localb == null)
    {
      if (this.fHF != null)
      {
        this.fHF.cZ(false);
        AppMethodBeat.o(116105);
      }
    }
    else if (((d.decodeByteArray(localb.data, 10, 10) != null) || (!this.fHh.eOg)) && (this.fHj.a(this.url, localb.data, this.fHh)))
    {
      if (this.fHF != null)
      {
        this.fHF.cZ(true);
        AppMethodBeat.o(116105);
      }
    }
    else if (this.fHF != null) {
      this.fHF.cZ(false);
    }
    AppMethodBeat.o(116105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.a.f.a
 * JD-Core Version:    0.7.0.1
 */