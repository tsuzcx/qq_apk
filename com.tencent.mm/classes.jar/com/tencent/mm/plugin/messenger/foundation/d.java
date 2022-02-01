package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.o;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storage.ch;
import com.tencent.mm.storage.cm;
import java.util.HashMap;

public final class d
  implements c, l
{
  bj vVA;
  bh vVB;
  bt vVC;
  cf vVD;
  cm vVE;
  af vVF;
  bp vVG;
  at vVr;
  ch vVs;
  bm vVt;
  bw vVu;
  av vVv;
  o vVw;
  com.tencent.mm.ba.a vVx;
  cc vVy;
  ay vVz;
  
  public final h doD()
  {
    AppMethodBeat.i(116879);
    g.ajS();
    g.ajP().aiU();
    com.tencent.mm.ba.a locala = this.vVx;
    AppMethodBeat.o(116879);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b doE()
  {
    AppMethodBeat.i(116880);
    g.ajS();
    g.ajP().aiU();
    af localaf = this.vVF;
    AppMethodBeat.o(116880);
    return localaf;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(116881);
    Object localObject;
    if (this.vVr != null)
    {
      localObject = this.vVr;
      ((at)localObject).JeM.clear();
      ((at)localObject).JeN.clear();
    }
    if (this.vVw != null)
    {
      localObject = this.vVw;
      ((o)localObject).bGq = new HashMap();
      g.ajS();
      g.ajQ().gDv.b(681, (com.tencent.mm.ak.f)localObject);
      g.ajS();
      g.ajQ().gDv.b(806, (com.tencent.mm.ak.f)localObject);
    }
    AppMethodBeat.o(116881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */