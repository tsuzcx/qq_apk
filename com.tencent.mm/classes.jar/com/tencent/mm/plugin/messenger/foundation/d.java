package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.f;
import com.tencent.mm.ba.o;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.ct;
import java.util.HashMap;

public final class d
  implements c, l
{
  ba zpA;
  o zpB;
  com.tencent.mm.ba.a zpC;
  cj zpD;
  bd zpE;
  bo zpF;
  bm zpG;
  by zpH;
  cm zpI;
  ct zpJ;
  ak zpK;
  bu zpL;
  ay zpw;
  co zpx;
  br zpy;
  cb zpz;
  
  public final h eis()
  {
    AppMethodBeat.i(116879);
    g.aAi();
    g.aAf().azk();
    com.tencent.mm.ba.a locala = this.zpC;
    AppMethodBeat.o(116879);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b eit()
  {
    AppMethodBeat.i(116880);
    g.aAi();
    g.aAf().azk();
    ak localak = this.zpK;
    AppMethodBeat.o(116880);
    return localak;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(116881);
    Object localObject;
    if (this.zpw != null)
    {
      localObject = this.zpw;
      ((ay)localObject).OoH.clear();
      ((ay)localObject).OoI.clear();
    }
    if (this.zpB != null)
    {
      localObject = this.zpB;
      ((o)localObject).bGH = new HashMap();
      g.aAi();
      g.aAg().hqi.b(681, (i)localObject);
      g.aAi();
      g.aAg().hqi.b(806, (i)localObject);
    }
    AppMethodBeat.o(116881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */