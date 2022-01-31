package com.tencent.mm.as;

import com.tencent.mm.ah.f;
import com.tencent.mm.sdk.platformtools.y;

final class l$b
{
  public l.a epw;
  
  public l$b(l paraml, l.a parama)
  {
    this.epw = parama;
  }
  
  final void Ow()
  {
    if (l.b(this.ept) == l.c(this.ept)) {}
    for (e locale = l.d(this.ept);; locale = l.e(this.ept))
    {
      if (locale.enB == 1)
      {
        com.tencent.mm.plugin.report.service.g.wJ(23);
        com.tencent.mm.plugin.report.service.g.wJ(21);
      }
      if (o.OJ().a(Long.valueOf(l.c(this.ept)), l.d(this.ept)) < 0)
      {
        y.e(l.f(this.ept), "update db failed local id:" + l.c(this.ept) + " server id:" + l.d(this.ept).bXr);
        i.iL((int)l.b(this.ept));
        i.iK((int)l.b(this.ept));
        l.g(this.ept).onSceneEnd(3, -1, "", this.ept);
      }
      if (l.c(this.ept) != l.b(this.ept)) {
        o.OJ().a(Long.valueOf(l.b(this.ept)), l.e(this.ept));
      }
      l.a(this.ept, l.c(this.ept));
      if (l.b(this.ept) != l.c(this.ept)) {
        l.a(this.ept, l.b(this.ept));
      }
      if (this.epw != null) {
        this.epw.Ow();
      }
      this.ept.iM(l.h(this.ept));
      l.i(this.ept);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.as.l.b
 * JD-Core Version:    0.7.0.1
 */