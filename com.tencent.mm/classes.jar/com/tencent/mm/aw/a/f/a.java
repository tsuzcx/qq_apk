package com.tencent.mm.aw.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.d;
import com.tencent.mm.sdk.platformtools.g;

public final class a
  implements Runnable
{
  private final com.tencent.mm.aw.a.a.b icV;
  private final com.tencent.mm.aw.a.b idX;
  private final d idY;
  private final com.tencent.mm.aw.a.a.c idd;
  private final com.tencent.mm.aw.a.c.b idf;
  private final com.tencent.mm.aw.a.c.c idg;
  private final String url;
  
  public a(String paramString, com.tencent.mm.aw.a.a.c paramc, com.tencent.mm.aw.a.b paramb, d paramd)
  {
    AppMethodBeat.i(130433);
    this.url = paramString;
    this.idX = paramb;
    this.icV = this.idX.icV;
    if (paramc == null)
    {
      this.idd = this.icV.idd;
      this.idY = paramd;
      if (this.idd.idg == null) {
        break label97;
      }
    }
    label97:
    for (this.idg = this.idd.idg;; this.idg = this.icV.idg)
    {
      this.idf = this.icV.idf;
      AppMethodBeat.o(130433);
      return;
      this.idd = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(130434);
    new com.tencent.mm.aw.a.d.b();
    com.tencent.mm.aw.a.d.b localb = this.idg.FH(this.url);
    if (localb == null)
    {
      if (this.idY != null)
      {
        this.idY.eK(false);
        AppMethodBeat.o(130434);
      }
    }
    else if (((g.decodeByteArray(localb.data, 10, 10) != null) || (!this.idd.idM)) && (this.idf.a(this.url, localb.data, this.idd)))
    {
      if (this.idY != null)
      {
        this.idY.eK(true);
        AppMethodBeat.o(130434);
      }
    }
    else if (this.idY != null) {
      this.idY.eK(false);
    }
    AppMethodBeat.o(130434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.f.a
 * JD-Core Version:    0.7.0.1
 */