package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import com.tencent.c.j.c;
import com.tencent.c.j.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class c$g
  extends u
  implements b<Boolean, ah>
{
  c$g(j.m<j.c> paramm, c paramc)
  {
    super(1);
  }
  
  private static final void a(j.m paramm, c paramc, Boolean paramBoolean)
  {
    AppMethodBeat.i(263417);
    s.u(paramc, "this$0");
    if (paramm != null) {
      paramm.success(c.z(paramBoolean));
    }
    AppMethodBeat.o(263417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.c.g
 * JD-Core Version:    0.7.0.1
 */