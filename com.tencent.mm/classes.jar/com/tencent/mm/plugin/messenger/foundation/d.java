package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ah.p;
import com.tencent.mm.ay.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
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
  aj mcD;
  bw mcE;
  bj mcF;
  al mcG;
  m mcH;
  br mcI;
  ao mcJ;
  ay mcK;
  aw mcL;
  bg mcM;
  bu mcN;
  cb mcO;
  x mcP;
  bc mcQ;
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b bhJ()
  {
    g.DQ();
    g.DN().CX();
    return this.mcP;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    Object localObject;
    if (this.mcD != null)
    {
      localObject = this.mcD;
      ((aj)localObject).uAc.clear();
      ((aj)localObject).uAd.clear();
    }
    if (this.mcH != null)
    {
      localObject = this.mcH;
      ((m)localObject).elp = new HashMap();
      g.DQ();
      g.DO().dJT.b(681, (com.tencent.mm.ah.f)localObject);
      g.DQ();
      g.DO().dJT.b(806, (com.tencent.mm.ah.f)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */