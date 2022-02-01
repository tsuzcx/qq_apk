package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.d;
import com.tencent.mm.bj.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  implements h.a, a
{
  private List<a.a> nUl;
  
  public j()
  {
    AppMethodBeat.i(22360);
    this.nUl = new ArrayList();
    AppMethodBeat.o(22360);
  }
  
  public final void Oq(String paramString)
  {
    AppMethodBeat.i(22361);
    ae.i("MicroMsg.DeleteContactService", "delete contact %s", new Object[] { paramString });
    ((l)g.ab(l.class)).doD().b(new d(paramString));
    ((l)g.ab(l.class)).doD().a(4, this);
    AppMethodBeat.o(22361);
  }
  
  public final void a(int paramInt, che paramche, k.b paramb)
  {
    AppMethodBeat.i(186423);
    for (;;)
    {
      Object localObject;
      try
      {
        ae.i("MicroMsg.DeleteContactService", "ret %d, title %d, content %s", new Object[] { Integer.valueOf(paramInt), paramche.Title, paramche.hFS });
        if (paramb.getCmdId() != 4) {
          break;
        }
        paramb = z.a(((ade)new ade().parseFrom(paramb.getBuffer())).GuF);
        ae.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", new Object[] { paramb, Integer.valueOf(paramInt) });
        localObject = ((l)g.ab(l.class)).azF().BH(paramb);
        if (paramInt == 0)
        {
          x.Aq(paramb);
          bl.a(paramb, null);
          ((l)g.ab(l.class)).azL().aUY(paramb);
          c.f(0L, paramb);
          c.f(0L, ((aw)localObject).field_encryptUsername);
          localObject = this.nUl.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((a.a)((Iterator)localObject).next()).a(paramb, paramInt, paramche);
          continue;
        }
        ((an)localObject).acS();
      }
      catch (Exception paramche)
      {
        ae.printErrStackTrace("MicroMsg.DeleteContactService", paramche, "BaseProtoBuf parseFrom error!", new Object[0]);
        AppMethodBeat.o(186423);
        return;
      }
      ((l)g.ab(l.class)).azF().c(paramb, (an)localObject);
    }
    AppMethodBeat.o(186423);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(22362);
    this.nUl.add(parama);
    AppMethodBeat.o(22362);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(22363);
    this.nUl.remove(parama);
    AppMethodBeat.o(22363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */