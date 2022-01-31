package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"printTmplState", "", "invoke"})
final class f$o
  extends k
  implements a<String>
{
  f$o(f paramf)
  {
    super(0);
  }
  
  public final String aXs()
  {
    AppMethodBeat.i(14830);
    Object localObject = new StringBuilder();
    if (this.kbu.kaS) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.kbu.kaT) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (m.ap((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    j.p(localObject, "sb.toString()");
    AppMethodBeat.o(14830);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.o
 * JD-Core Version:    0.7.0.1
 */