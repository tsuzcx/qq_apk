package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"printProcessState", "", "invoke"})
final class f$n
  extends k
  implements a<String>
{
  f$n(f paramf)
  {
    super(0);
  }
  
  public final String aXs()
  {
    AppMethodBeat.i(14828);
    Object localObject = new StringBuilder();
    if (this.kbu.kaX == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.kbu.kaW) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (m.ap((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    j.p(localObject, "sb.toString()");
    AppMethodBeat.o(14828);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.n
 * JD-Core Version:    0.7.0.1
 */