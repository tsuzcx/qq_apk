package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.an;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.r;

public class PluginContact
  extends f
  implements b, com.tencent.mm.kernel.api.bucket.c
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(221689);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.b(r.class, new com.tencent.mm.contact.a.c());
    x.a((an)com.tencent.mm.kernel.g.ab(r.class));
    AppMethodBeat.o(221689);
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.contact.PluginContact
 * JD-Core Version:    0.7.0.1
 */