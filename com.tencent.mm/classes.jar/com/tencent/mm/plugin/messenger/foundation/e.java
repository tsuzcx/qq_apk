package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.b.f;
import com.tencent.mm.bd.a;
import com.tencent.mm.bd.o;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cu;
import java.util.HashMap;

public final class e
  implements com.tencent.mm.kernel.api.bucket.c, n
{
  ay EUU;
  cp EUV;
  br EUW;
  cb EUX;
  ba EUY;
  o EUZ;
  a EVa;
  ck EVb;
  bd EVc;
  bo EVd;
  bm EVe;
  by EVf;
  cn EVg;
  cu EVh;
  ak EVi;
  bu EVj;
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h eRY()
  {
    AppMethodBeat.i(116879);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    a locala = this.EVa;
    AppMethodBeat.o(116879);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b eRZ()
  {
    AppMethodBeat.i(116880);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    ak localak = this.EVi;
    AppMethodBeat.o(116880);
    return localak;
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(116881);
    Object localObject;
    if (this.EUU != null)
    {
      localObject = this.EUU;
      ((ay)localObject).VEA.clear();
      ((ay)localObject).VEB.clear();
    }
    if (this.EUZ != null)
    {
      localObject = this.EUZ;
      ((o)localObject).bqq = new HashMap();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(681, (i)localObject);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(806, (i)localObject);
    }
    AppMethodBeat.o(116881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.e
 * JD-Core Version:    0.7.0.1
 */