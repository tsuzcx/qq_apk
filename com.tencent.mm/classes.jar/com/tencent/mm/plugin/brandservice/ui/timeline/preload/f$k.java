package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.preload.TmplParams;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"printDebugger", "", "invoke"})
final class f$k
  extends k
  implements a<String>
{
  f$k(f paramf)
  {
    super(0);
  }
  
  public final String aXs()
  {
    AppMethodBeat.i(14822);
    Object localObject1 = new StringBuilder();
    Object localObject2 = g.kbz;
    if (g.a.aXz()) {
      ((StringBuilder)localObject1).append("\nno re-direct;");
    }
    localObject2 = g.kbz;
    if (!g.a.aXu()) {
      ((StringBuilder)localObject1).append("\nno preload data;");
    }
    localObject2 = g.kbz;
    if (g.a.aXA()) {
      ((StringBuilder)localObject1).append("\nno preload webview;");
    }
    localObject2 = g.kbz;
    if (g.a.aXw()) {
      ((StringBuilder)localObject1).append("\ndata no expire;");
    }
    localObject2 = g.kbz;
    if (g.a.aXB()) {
      ((StringBuilder)localObject1).append("\nno red;");
    }
    localObject2 = this.kbu.aXn().uYK;
    j.p(localObject2, "tmplParams.headers");
    if (!m.ap((CharSequence)localObject2)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((StringBuilder)localObject1).append(this.kbu.aXn().uYK);
      }
      if (m.ap((CharSequence)localObject1)) {
        ((StringBuilder)localObject1).append("none;");
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      j.p(localObject1, "sb.toString()");
      AppMethodBeat.o(14822);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.k
 * JD-Core Version:    0.7.0.1
 */