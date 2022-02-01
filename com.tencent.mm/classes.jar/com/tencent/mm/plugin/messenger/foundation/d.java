package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.ba.o;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import java.util.HashMap;

public final class d
  implements c, k
{
  bc uGA;
  bm uGB;
  by uGC;
  cf uGD;
  aa uGE;
  bi uGF;
  ao uGr;
  ca uGs;
  bp uGt;
  aq uGu;
  o uGv;
  com.tencent.mm.ba.a uGw;
  bv uGx;
  at uGy;
  be uGz;
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.g dcl()
  {
    AppMethodBeat.i(116879);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.ba.a locala = this.uGw;
    AppMethodBeat.o(116879);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b dcm()
  {
    AppMethodBeat.i(116880);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    aa localaa = this.uGE;
    AppMethodBeat.o(116880);
    return localaa;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(116881);
    Object localObject;
    if (this.uGr != null)
    {
      localObject = this.uGr;
      ((ao)localObject).GWS.clear();
      ((ao)localObject).GWT.clear();
    }
    if (this.uGv != null)
    {
      localObject = this.uGv;
      ((o)localObject).bwc = new HashMap();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(681, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(806, (com.tencent.mm.ak.g)localObject);
    }
    AppMethodBeat.o(116881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */