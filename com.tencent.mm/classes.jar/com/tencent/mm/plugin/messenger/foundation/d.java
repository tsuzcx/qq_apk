package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bb.o;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.cl;
import java.util.HashMap;

public final class d
  implements c, l
{
  cl vJA;
  ae vJB;
  bo vJC;
  as vJn;
  cg vJo;
  bl vJp;
  bv vJq;
  au vJr;
  o vJs;
  com.tencent.mm.bb.a vJt;
  cb vJu;
  ax vJv;
  bi vJw;
  bg vJx;
  bs vJy;
  ce vJz;
  
  public final h dlE()
  {
    AppMethodBeat.i(116879);
    g.ajD();
    g.ajA().aiF();
    com.tencent.mm.bb.a locala = this.vJt;
    AppMethodBeat.o(116879);
    return locala;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.b dlF()
  {
    AppMethodBeat.i(116880);
    g.ajD();
    g.ajA().aiF();
    ae localae = this.vJB;
    AppMethodBeat.o(116880);
    return localae;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(116881);
    Object localObject;
    if (this.vJn != null)
    {
      localObject = this.vJn;
      ((as)localObject).IKf.clear();
      ((as)localObject).IKg.clear();
    }
    if (this.vJs != null)
    {
      localObject = this.vJs;
      ((o)localObject).bGq = new HashMap();
      g.ajD();
      g.ajB().gAO.b(681, (com.tencent.mm.al.f)localObject);
      g.ajD();
      g.ajB().gAO.b(806, (com.tencent.mm.al.f)localObject);
    }
    AppMethodBeat.o(116881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */