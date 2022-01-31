package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class l$b
{
  public l.a fFW;
  
  public l$b(l paraml, l.a parama)
  {
    this.fFW = parama;
  }
  
  final void aho()
  {
    AppMethodBeat.i(78330);
    if (l.b(this.fFT) == l.c(this.fFT)) {}
    for (Object localObject = l.d(this.fFT);; localObject = l.e(this.fFT))
    {
      if (((e)localObject).fDY == 1)
      {
        com.tencent.mm.plugin.report.service.g.Cy(23);
        com.tencent.mm.plugin.report.service.g.Cy(21);
      }
      ab.i(l.f(this.fFT), "UploadEndWrapper onUploadEnd %s done", new Object[] { l.f(l.d(this.fFT)) });
      if (o.ahC().a(Long.valueOf(l.c(this.fFT)), l.d(this.fFT)) < 0)
      {
        ab.e(l.f(this.fFT), "update db failed local id:" + l.c(this.fFT) + " server id:" + l.d(this.fFT).cFn);
        i.lz((int)l.b(this.fFT));
        i.ly((int)l.b(this.fFT));
        l.g(this.fFT).onSceneEnd(3, -1, "", this.fFT);
      }
      if (l.c(this.fFT) != l.b(this.fFT))
      {
        ab.i(l.f(this.fFT), "UploadEndWrapper onUploadEnd OriImg %s done", new Object[] { l.f(l.e(this.fFT)) });
        o.ahC().a(Long.valueOf(l.b(this.fFT)), l.e(this.fFT));
      }
      if ((!b.dsf()) && (!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE)) {
        break;
      }
      localObject = o.ahC().ahm();
      if (localObject == null) {
        break;
      }
      int i = 0;
      while (i < ((List)localObject).size())
      {
        ab.i(l.f(this.fFT), "UploadEndWrapper onUploadEnd duminfo %s %s", new Object[] { Integer.valueOf(i), l.f((e)((List)localObject).get(i)) });
        i += 1;
      }
    }
    l.a(this.fFT, l.c(this.fFT));
    if (l.b(this.fFT) != l.c(this.fFT)) {
      l.a(this.fFT, l.b(this.fFT));
    }
    if (this.fFW != null) {
      this.fFW.aho();
    }
    this.fFT.lA(l.h(this.fFT));
    l.i(this.fFT);
    AppMethodBeat.o(78330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.l.b
 * JD-Core Version:    0.7.0.1
 */