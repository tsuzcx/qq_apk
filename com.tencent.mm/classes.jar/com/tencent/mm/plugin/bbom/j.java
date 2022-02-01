package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.d;
import com.tencent.mm.bj.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  implements h.a, a
{
  private List<a.a> peZ;
  
  public j()
  {
    AppMethodBeat.i(22360);
    this.peZ = new ArrayList();
    AppMethodBeat.o(22360);
  }
  
  public final void XA(String paramString)
  {
    AppMethodBeat.i(22361);
    Log.i("MicroMsg.DeleteContactService", "delete contact %s", new Object[] { paramString });
    ((l)g.af(l.class)).eis().b(new d(paramString));
    ((l)g.af(l.class)).eis().a(4, this);
    AppMethodBeat.o(22361);
  }
  
  public final void a(int paramInt, cxl paramcxl, k.b paramb)
  {
    AppMethodBeat.i(231634);
    for (;;)
    {
      Object localObject;
      try
      {
        Log.i("MicroMsg.DeleteContactService", "ret %d, title %d, content %s", new Object[] { Integer.valueOf(paramInt), paramcxl.Title, paramcxl.iAc });
        if (paramb.getCmdId() != 4) {
          break;
        }
        paramb = z.a(((afh)new afh().parseFrom(paramb.getBuffer())).Lqk);
        Log.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", new Object[] { paramb, Integer.valueOf(paramInt) });
        localObject = ((l)g.af(l.class)).aSN().Kn(paramb);
        if (paramInt == 0)
        {
          ab.IV(paramb);
          bp.a(paramb, null);
          ((l)g.af(l.class)).aST().bjW(paramb);
          c.f(0L, paramb);
          c.f(0L, ((ax)localObject).field_encryptUsername);
          localObject = this.peZ.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((a.a)((Iterator)localObject).next()).a(paramb, paramInt, paramcxl);
          continue;
        }
        ((as)localObject).aqQ();
      }
      catch (Exception paramcxl)
      {
        Log.printErrStackTrace("MicroMsg.DeleteContactService", paramcxl, "BaseProtoBuf parseFrom error!", new Object[0]);
        AppMethodBeat.o(231634);
        return;
      }
      ((l)g.af(l.class)).aSN().c(paramb, (as)localObject);
    }
    AppMethodBeat.o(231634);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(22362);
    this.peZ.add(parama);
    AppMethodBeat.o(22362);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(22363);
    this.peZ.remove(parama);
    AppMethodBeat.o(22363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */