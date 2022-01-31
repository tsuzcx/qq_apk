package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Map;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString, e.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(136921);
    ab.i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", new Object[] { this.oEh });
    HashSet localHashSet = (HashSet)a.a(this.oEg).get(this.oEh);
    if (localHashSet == null)
    {
      AppMethodBeat.o(136921);
      return;
    }
    localHashSet.remove(this.oEi);
    if (localHashSet.size() == 0)
    {
      a.a(this.oEg).remove(this.oEh);
      AppMethodBeat.o(136921);
      return;
    }
    a.a(this.oEg).put(this.oEh, localHashSet);
    AppMethodBeat.o(136921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a.3
 * JD-Core Version:    0.7.0.1
 */