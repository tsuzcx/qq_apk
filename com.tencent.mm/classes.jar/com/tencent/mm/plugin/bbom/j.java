package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.d;
import com.tencent.mm.bk.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  implements h.a, a
{
  private List<a.a> nOF;
  
  public j()
  {
    AppMethodBeat.i(22360);
    this.nOF = new ArrayList();
    AppMethodBeat.o(22360);
  }
  
  public final void NI(String paramString)
  {
    AppMethodBeat.i(22361);
    ad.i("MicroMsg.DeleteContactService", "delete contact %s", new Object[] { paramString });
    ((l)g.ab(l.class)).dlE().a(new d(paramString));
    ((l)g.ab(l.class)).dlE().a(4, this);
    AppMethodBeat.o(22361);
  }
  
  public final void a(int paramInt, cgk paramcgk, k.b paramb)
  {
    AppMethodBeat.i(193165);
    for (;;)
    {
      Object localObject;
      try
      {
        ad.i("MicroMsg.DeleteContactService", "ret %d, title %d, content %s", new Object[] { Integer.valueOf(paramInt), paramcgk.Title, paramcgk.hDa });
        if (paramb.getCmdId() != 4) {
          break;
        }
        paramb = z.a(((acv)new acv().parseFrom(paramb.getBuffer())).GbY);
        ad.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", new Object[] { paramb, Integer.valueOf(paramInt) });
        localObject = ((l)g.ab(l.class)).azp().Bf(paramb);
        if (paramInt == 0)
        {
          w.zG(paramb);
          bj.a(paramb, null);
          ((l)g.ab(l.class)).azv().aTx(paramb);
          c.f(0L, paramb);
          c.f(0L, ((aw)localObject).field_encryptUsername);
          localObject = this.nOF.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((a.a)((Iterator)localObject).next()).a(paramb, paramInt, paramcgk);
          continue;
        }
        ((am)localObject).acH();
      }
      catch (Exception paramcgk)
      {
        ad.printErrStackTrace("MicroMsg.DeleteContactService", paramcgk, "BaseProtoBuf parseFrom error!", new Object[0]);
        AppMethodBeat.o(193165);
        return;
      }
      ((l)g.ab(l.class)).azp().c(paramb, (am)localObject);
    }
    AppMethodBeat.o(193165);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(22362);
    this.nOF.add(parama);
    AppMethodBeat.o(22362);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(22363);
    this.nOF.remove(parama);
    AppMethodBeat.o(22363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */