package com.tencent.mm.av.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.sdk.platformtools.f;

public final class a
  implements Runnable
{
  private final com.tencent.mm.av.a.a.b hKb;
  private final com.tencent.mm.av.a.a.c hKj;
  private final com.tencent.mm.av.a.c.b hKl;
  private final com.tencent.mm.av.a.c.c hKm;
  private final com.tencent.mm.av.a.b hLc;
  private final d hLd;
  private final String url;
  
  public a(String paramString, com.tencent.mm.av.a.a.c paramc, com.tencent.mm.av.a.b paramb, d paramd)
  {
    AppMethodBeat.i(130433);
    this.url = paramString;
    this.hLc = paramb;
    this.hKb = this.hLc.hKb;
    if (paramc == null)
    {
      this.hKj = this.hKb.hKj;
      this.hLd = paramd;
      if (this.hKj.hKm == null) {
        break label97;
      }
    }
    label97:
    for (this.hKm = this.hKj.hKm;; this.hKm = this.hKb.hKm)
    {
      this.hKl = this.hKb.hKl;
      AppMethodBeat.o(130433);
      return;
      this.hKj = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(130434);
    new com.tencent.mm.av.a.d.b();
    com.tencent.mm.av.a.d.b localb = this.hKm.CD(this.url);
    if (localb == null)
    {
      if (this.hLd != null)
      {
        this.hLd.eI(false);
        AppMethodBeat.o(130434);
      }
    }
    else if (((f.decodeByteArray(localb.data, 10, 10) != null) || (!this.hKj.hKR)) && (this.hKl.a(this.url, localb.data, this.hKj)))
    {
      if (this.hLd != null)
      {
        this.hLd.eI(true);
        AppMethodBeat.o(130434);
      }
    }
    else if (this.hLd != null) {
      this.hLd.eI(false);
    }
    AppMethodBeat.o(130434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.av.a.f.a
 * JD-Core Version:    0.7.0.1
 */