package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Map;

final class a$2
  implements Runnable
{
  a$2(a parama, String paramString, e.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(136920);
    ab.i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", new Object[] { this.oEh });
    HashSet localHashSet2 = (HashSet)a.a(this.oEg).get(this.oEh);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    if (!localHashSet1.contains(this.oEi)) {
      localHashSet1.add(this.oEi);
    }
    a.a(this.oEg).put(this.oEh, localHashSet1);
    AppMethodBeat.o(136920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a.2
 * JD-Core Version:    0.7.0.1
 */