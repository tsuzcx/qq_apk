package com.tencent.mm.plugin.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class PluginHardcoder$2
  implements k.a
{
  PluginHardcoder$2(PluginHardcoder paramPluginHardcoder) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(60251);
    ab.i("MicroMsg.PluginHardcoder", "abTestListener onNotifyChange stack[%s]", new Object[] { bo.dtY() });
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString))) {
      g.RO().o(new PluginHardcoder.2.1(this), 100L);
    }
    AppMethodBeat.o(60251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder.2
 * JD-Core Version:    0.7.0.1
 */