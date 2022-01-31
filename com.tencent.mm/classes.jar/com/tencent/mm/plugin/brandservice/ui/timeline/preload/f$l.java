package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"printDataState", "", "invoke"})
final class f$l
  extends k
  implements a<String>
{
  f$l(f paramf)
  {
    super(0);
  }
  
  public final String aXs()
  {
    AppMethodBeat.i(14824);
    Object localObject = new StringBuilder();
    if (!this.kbu.kaM) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.kbu.kaR) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.kbu.kaV) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (m.ap((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    j.p(localObject, "sb.toString()");
    AppMethodBeat.o(14824);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.l
 * JD-Core Version:    0.7.0.1
 */