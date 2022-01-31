package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"printWebViewState", "", "invoke"})
final class f$m
  extends k
  implements a<String>
{
  f$m(f paramf)
  {
    super(0);
  }
  
  public final String aXs()
  {
    AppMethodBeat.i(14826);
    Object localObject = new StringBuilder();
    if (this.kbu.kaX == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.kbu.kaN) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.kbu.kaQ)
    {
      ((StringBuilder)localObject).append("tmpl fail;");
      if (!this.kbu.kbp) {
        break label156;
      }
      ((StringBuilder)localObject).append("timeout;");
    }
    for (;;)
    {
      if (this.kbu.kaU) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (m.ap((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      j.p(localObject, "sb.toString()");
      AppMethodBeat.o(14826);
      return localObject;
      if (this.kbu.kaP) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label156:
      if (this.kbu.kbo) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.m
 * JD-Core Version:    0.7.0.1
 */