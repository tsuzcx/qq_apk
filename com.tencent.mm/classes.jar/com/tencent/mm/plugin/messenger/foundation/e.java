package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.o;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storage.cs;
import com.tencent.mm.storage.cx;
import java.util.HashMap;

public final class e
  implements com.tencent.mm.kernel.api.bucket.c, n
{
  a KQA;
  cn KQB;
  bf KQC;
  bq KQD;
  bo KQE;
  ca KQF;
  cq KQG;
  cx KQH;
  am KQI;
  bw KQJ;
  ba KQu;
  cs KQv;
  bt KQw;
  cd KQx;
  bc KQy;
  o KQz;
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h gaT()
  {
    AppMethodBeat.i(116879);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    a locala = this.KQA;
    AppMethodBeat.o(116879);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b gaU()
  {
    AppMethodBeat.i(116880);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    am localam = this.KQI;
    AppMethodBeat.o(116880);
    return localam;
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(116881);
    Object localObject;
    if (this.KQu != null)
    {
      localObject = this.KQu;
      ((ba)localObject).prM.clear();
      ((ba)localObject).adim.clear();
    }
    if (this.KQz != null)
    {
      localObject = this.KQz;
      ((o)localObject).djU = new HashMap();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(681, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(806, (com.tencent.mm.am.h)localObject);
    }
    AppMethodBeat.o(116881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.e
 * JD-Core Version:    0.7.0.1
 */