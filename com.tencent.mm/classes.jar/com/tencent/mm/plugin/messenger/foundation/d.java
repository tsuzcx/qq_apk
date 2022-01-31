package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.az.n;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.x;
import java.util.HashMap;

public final class d
  implements c, j
{
  aj oDf;
  bw oDg;
  bj oDh;
  al oDi;
  n oDj;
  com.tencent.mm.az.a oDk;
  br oDl;
  ao oDm;
  ay oDn;
  aw oDo;
  bg oDp;
  bu oDq;
  cb oDr;
  x oDs;
  bc oDt;
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.g bPK()
  {
    AppMethodBeat.i(1028);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.az.a locala = this.oDk;
    AppMethodBeat.o(1028);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b bPL()
  {
    AppMethodBeat.i(1029);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    x localx = this.oDs;
    AppMethodBeat.o(1029);
    return localx;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(1030);
    Object localObject;
    if (this.oDf != null)
    {
      localObject = this.oDf;
      ((aj)localObject).yMl.clear();
      ((aj)localObject).yMm.clear();
    }
    if (this.oDj != null)
    {
      localObject = this.oDj;
      ((n)localObject).bat = new HashMap();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(681, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(806, (com.tencent.mm.ai.f)localObject);
    }
    AppMethodBeat.o(1030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */