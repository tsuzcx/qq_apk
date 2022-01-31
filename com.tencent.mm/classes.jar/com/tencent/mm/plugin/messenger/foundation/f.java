package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.o.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private static final f.b oDB;
  private u oDC;
  
  static
  {
    AppMethodBeat.i(139743);
    oDB = new f.b((byte)0);
    AppMethodBeat.o(139743);
  }
  
  public static void a(t paramt)
  {
    AppMethodBeat.i(139741);
    oDB.at(paramt);
    AppMethodBeat.o(139741);
  }
  
  public static void b(t paramt)
  {
    AppMethodBeat.i(139742);
    oDB.remove(paramt);
    AppMethodBeat.o(139742);
  }
  
  public final void a(ud paramud, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(1062);
    r localr = r.a.yT(paramud.wMC);
    if (localr != null) {
      try
      {
        localr.a(paramud, paramArrayOfByte, paramBoolean, this.oDC);
        AppMethodBeat.o(1062);
        return;
      }
      catch (IOException paramud)
      {
        ab.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramud.getMessage());
        paramud = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(1062);
        throw paramud;
      }
    }
    ab.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramud.wMC) });
    AppMethodBeat.o(1062);
  }
  
  public final void bT(Object paramObject)
  {
    AppMethodBeat.i(1061);
    c localc = v.bPS();
    if (localc != null) {
      this.oDC = ((u)localc.get());
    }
    if (this.oDC == null) {
      this.oDC = new f.a((byte)0);
    }
    if ((paramObject instanceof com.tencent.mm.modelmulti.j))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Th(((com.tencent.mm.modelmulti.j)paramObject).TAG);
      oDB.W(paramObject);
      AppMethodBeat.o(1061);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Th((String)paramObject);
        oDB.W(paramObject);
        AppMethodBeat.o(1061);
      }
    }
    else if ((paramObject instanceof o.c))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Th(paramObject.toString());
      oDB.W(paramObject);
    }
    AppMethodBeat.o(1061);
  }
  
  public final void bU(Object paramObject)
  {
    AppMethodBeat.i(1063);
    if ((paramObject instanceof com.tencent.mm.modelmulti.j))
    {
      this.oDC.bPR();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Ti(((com.tencent.mm.modelmulti.j)paramObject).TAG);
      oDB.X(paramObject);
      AppMethodBeat.o(1063);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.oDC.bPR();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Ti((String)paramObject);
      oDB.X(paramObject);
      AppMethodBeat.o(1063);
      return;
    }
    if ((paramObject instanceof o.c))
    {
      this.oDC.bPR();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Ti(paramObject.toString());
      oDB.X(paramObject);
    }
    AppMethodBeat.o(1063);
  }
  
  public final void bV(Object paramObject)
  {
    AppMethodBeat.i(1064);
    if ((paramObject instanceof com.tencent.mm.modelmulti.j)) {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Ti(((com.tencent.mm.modelmulti.j)paramObject).TAG);
    }
    AppMethodBeat.o(1064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.f
 * JD-Core Version:    0.7.0.1
 */