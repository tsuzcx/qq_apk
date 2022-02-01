package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.b.f;
import com.tencent.mm.bb.n;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public final class d
  implements c, k
{
  al txT;
  bx txU;
  bm txV;
  an txW;
  n txX;
  com.tencent.mm.bb.a txY;
  bs txZ;
  aq tya;
  bb tyb;
  az tyc;
  bj tyd;
  bv tye;
  cc tyf;
  z tyg;
  bf tyh;
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.g cOC()
  {
    AppMethodBeat.i(116879);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.bb.a locala = this.txY;
    AppMethodBeat.o(116879);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b cOD()
  {
    AppMethodBeat.i(116880);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    z localz = this.tyg;
    AppMethodBeat.o(116880);
    return localz;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(116881);
    Object localObject;
    if (this.txT != null)
    {
      localObject = this.txT;
      ((al)localObject).FxS.clear();
      ((al)localObject).FxT.clear();
    }
    if (this.txX != null)
    {
      localObject = this.txX;
      ((n)localObject).byu = new HashMap();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(681, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(806, (com.tencent.mm.al.g)localObject);
    }
    AppMethodBeat.o(116881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */