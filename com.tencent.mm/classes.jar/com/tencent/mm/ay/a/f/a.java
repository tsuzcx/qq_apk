package com.tencent.mm.ay.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a
  implements Runnable
{
  private final com.tencent.mm.ay.a.a.b lRg;
  private final com.tencent.mm.ay.a.a.c lRp;
  private final com.tencent.mm.ay.a.c.b lRr;
  private final com.tencent.mm.ay.a.c.c lRs;
  private final com.tencent.mm.ay.a.b lSk;
  private final d lSl;
  private final String url;
  
  public a(String paramString, com.tencent.mm.ay.a.a.c paramc, com.tencent.mm.ay.a.b paramb, d paramd)
  {
    AppMethodBeat.i(130433);
    this.url = paramString;
    this.lSk = paramb;
    this.lRg = this.lSk.lRg;
    if (paramc == null)
    {
      this.lRp = this.lRg.lRp;
      this.lSl = paramd;
      if (this.lRp.lRs == null) {
        break label97;
      }
    }
    label97:
    for (this.lRs = this.lRp.lRs;; this.lRs = this.lRg.lRs)
    {
      this.lRr = this.lRg.lRr;
      AppMethodBeat.o(130433);
      return;
      this.lRp = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(130434);
    new com.tencent.mm.ay.a.d.b();
    com.tencent.mm.ay.a.d.b localb = this.lRs.Wt(this.url);
    if (localb == null)
    {
      if (this.lSl != null)
      {
        this.lSl.a(false, this.lRp.lSd);
        AppMethodBeat.o(130434);
      }
    }
    else if (((BitmapUtil.decodeByteArray(localb.data, 10, 10) != null) || (!this.lRp.lRY)) && (this.lRr.a(this.url, localb.data, this.lRp)))
    {
      if (this.lSl != null)
      {
        this.lSl.a(true, this.lRp.lSd);
        AppMethodBeat.o(130434);
      }
    }
    else if (this.lSl != null) {
      this.lSl.a(false, this.lRp.lSd);
    }
    AppMethodBeat.o(130434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ay.a.f.a
 * JD-Core Version:    0.7.0.1
 */