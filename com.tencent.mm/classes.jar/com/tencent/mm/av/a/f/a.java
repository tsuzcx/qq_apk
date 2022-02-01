package com.tencent.mm.av.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.sdk.platformtools.h;

public final class a
  implements Runnable
{
  private final com.tencent.mm.av.a.a.b ifO;
  private final com.tencent.mm.av.a.a.c ifW;
  private final com.tencent.mm.av.a.c.b ifY;
  private final com.tencent.mm.av.a.c.c ifZ;
  private final com.tencent.mm.av.a.b igP;
  private final d igQ;
  private final String url;
  
  public a(String paramString, com.tencent.mm.av.a.a.c paramc, com.tencent.mm.av.a.b paramb, d paramd)
  {
    AppMethodBeat.i(130433);
    this.url = paramString;
    this.igP = paramb;
    this.ifO = this.igP.ifO;
    if (paramc == null)
    {
      this.ifW = this.ifO.ifW;
      this.igQ = paramd;
      if (this.ifW.ifZ == null) {
        break label97;
      }
    }
    label97:
    for (this.ifZ = this.ifW.ifZ;; this.ifZ = this.ifO.ifZ)
    {
      this.ifY = this.ifO.ifY;
      AppMethodBeat.o(130433);
      return;
      this.ifW = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(130434);
    new com.tencent.mm.av.a.d.b();
    com.tencent.mm.av.a.d.b localb = this.ifZ.Gj(this.url);
    if (localb == null)
    {
      if (this.igQ != null)
      {
        this.igQ.eM(false);
        AppMethodBeat.o(130434);
      }
    }
    else if (((h.decodeByteArray(localb.data, 10, 10) != null) || (!this.ifW.igE)) && (this.ifY.a(this.url, localb.data, this.ifW)))
    {
      if (this.igQ != null)
      {
        this.igQ.eM(true);
        AppMethodBeat.o(130434);
      }
    }
    else if (this.igQ != null) {
      this.igQ.eM(false);
    }
    AppMethodBeat.o(130434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.f.a
 * JD-Core Version:    0.7.0.1
 */