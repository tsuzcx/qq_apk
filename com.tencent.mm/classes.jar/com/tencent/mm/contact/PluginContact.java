package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.messenger.foundation.a.u;

public class PluginContact
  extends f
  implements c, com.tencent.mm.kernel.api.bucket.c
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(233790);
    h.baF();
    h.b(u.class, new com.tencent.mm.contact.a.c());
    ab.a((at)h.ax(u.class));
    AppMethodBeat.o(233790);
  }
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.contact.PluginContact
 * JD-Core Version:    0.7.0.1
 */