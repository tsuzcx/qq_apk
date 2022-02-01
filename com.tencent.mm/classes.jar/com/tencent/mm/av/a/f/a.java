package com.tencent.mm.av.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a
  implements Runnable
{
  private final com.tencent.mm.av.a.a.b jaJ;
  private final com.tencent.mm.av.a.a.c jaR;
  private final com.tencent.mm.av.a.c.b jaT;
  private final com.tencent.mm.av.a.c.c jaU;
  private final com.tencent.mm.av.a.b jbK;
  private final d jbL;
  private final String url;
  
  public a(String paramString, com.tencent.mm.av.a.a.c paramc, com.tencent.mm.av.a.b paramb, d paramd)
  {
    AppMethodBeat.i(130433);
    this.url = paramString;
    this.jbK = paramb;
    this.jaJ = this.jbK.jaJ;
    if (paramc == null)
    {
      this.jaR = this.jaJ.jaR;
      this.jbL = paramd;
      if (this.jaR.jaU == null) {
        break label97;
      }
    }
    label97:
    for (this.jaU = this.jaR.jaU;; this.jaU = this.jaJ.jaU)
    {
      this.jaT = this.jaJ.jaT;
      AppMethodBeat.o(130433);
      return;
      this.jaR = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(130434);
    new com.tencent.mm.av.a.d.b();
    com.tencent.mm.av.a.d.b localb = this.jaU.OV(this.url);
    if (localb == null)
    {
      if (this.jbL != null)
      {
        this.jbL.a(false, this.jaR.jbE);
        AppMethodBeat.o(130434);
      }
    }
    else if (((BitmapUtil.decodeByteArray(localb.data, 10, 10) != null) || (!this.jaR.jbz)) && (this.jaT.a(this.url, localb.data, this.jaR)))
    {
      if (this.jbL != null)
      {
        this.jbL.a(true, this.jaR.jbE);
        AppMethodBeat.o(130434);
      }
    }
    else if (this.jbL != null) {
      this.jbL.a(false, this.jaR.jbE);
    }
    AppMethodBeat.o(130434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.f.a
 * JD-Core Version:    0.7.0.1
 */