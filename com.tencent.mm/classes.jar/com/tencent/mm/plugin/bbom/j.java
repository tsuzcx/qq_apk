package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.d;
import com.tencent.mm.bl.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.i.a.a;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  implements h.b, a
{
  private List<a.a> shd;
  
  public j()
  {
    AppMethodBeat.i(22360);
    this.shd = new ArrayList();
    AppMethodBeat.o(22360);
  }
  
  public final void a(int paramInt, dgv paramdgv, k.b paramb)
  {
    AppMethodBeat.i(286055);
    for (;;)
    {
      Object localObject;
      try
      {
        Log.i("MicroMsg.DeleteContactService", "ret %d, title %d, content %s", new Object[] { Integer.valueOf(paramInt), paramdgv.fwr, paramdgv.lpy });
        if (paramb.getCmdId() != 4) {
          break;
        }
        paramb = z.a(((afq)new afq().parseFrom(paramb.getBuffer())).SrH);
        Log.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", new Object[] { paramb, Integer.valueOf(paramInt) });
        localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramb);
        if (paramInt == 0)
        {
          ab.Qo(paramb);
          bq.a(paramb, null);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv(paramb);
          c.g(0L, paramb);
          c.g(0L, ((ax)localObject).field_encryptUsername);
          localObject = this.shd.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((a.a)((Iterator)localObject).next()).a(paramb, paramInt, paramdgv);
          continue;
        }
        ((as)localObject).axk();
      }
      catch (Exception paramdgv)
      {
        Log.printErrStackTrace("MicroMsg.DeleteContactService", paramdgv, "BaseProtoBuf parseFrom error!", new Object[0]);
        AppMethodBeat.o(286055);
        return;
      }
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().c(paramb, (as)localObject);
    }
    AppMethodBeat.o(286055);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(22362);
    this.shd.add(parama);
    AppMethodBeat.o(22362);
  }
  
  public final void afm(String paramString)
  {
    AppMethodBeat.i(22361);
    Log.i("MicroMsg.DeleteContactService", "delete contact %s", new Object[] { paramString });
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRY().b(new d(paramString));
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eRY().a(4, this);
    AppMethodBeat.o(22361);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(22363);
    this.shd.remove(parama);
    AppMethodBeat.o(22363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */