package com.tencent.mm.aw.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.d;
import com.tencent.mm.sdk.platformtools.f;

public final class a
  implements Runnable
{
  private final com.tencent.mm.aw.a.a.c hjG;
  private final com.tencent.mm.aw.a.c.b hjI;
  private final com.tencent.mm.aw.a.c.c hjJ;
  private final com.tencent.mm.aw.a.a.b hjy;
  private final d hkA;
  private final com.tencent.mm.aw.a.b hkz;
  private final String url;
  
  public a(String paramString, com.tencent.mm.aw.a.a.c paramc, com.tencent.mm.aw.a.b paramb, d paramd)
  {
    AppMethodBeat.i(130433);
    this.url = paramString;
    this.hkz = paramb;
    this.hjy = this.hkz.hjy;
    if (paramc == null)
    {
      this.hjG = this.hjy.hjG;
      this.hkA = paramd;
      if (this.hjG.hjJ == null) {
        break label97;
      }
    }
    label97:
    for (this.hjJ = this.hjG.hjJ;; this.hjJ = this.hjy.hjJ)
    {
      this.hjI = this.hjy.hjI;
      AppMethodBeat.o(130433);
      return;
      this.hjG = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(130434);
    new com.tencent.mm.aw.a.d.b();
    com.tencent.mm.aw.a.d.b localb = this.hjJ.yy(this.url);
    if (localb == null)
    {
      if (this.hkA != null)
      {
        this.hkA.en(false);
        AppMethodBeat.o(130434);
      }
    }
    else if (((f.decodeByteArray(localb.data, 10, 10) != null) || (!this.hjG.hko)) && (this.hjI.a(this.url, localb.data, this.hjG)))
    {
      if (this.hkA != null)
      {
        this.hkA.en(true);
        AppMethodBeat.o(130434);
      }
    }
    else if (this.hkA != null) {
      this.hkA.en(false);
    }
    AppMethodBeat.o(130434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.a.f.a
 * JD-Core Version:    0.7.0.1
 */