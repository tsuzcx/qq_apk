package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.ay.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelverify.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.i.a.a;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  implements h.b, a
{
  private List<a.a> vsY;
  
  public j()
  {
    AppMethodBeat.i(22360);
    this.vsY = new ArrayList();
    AppMethodBeat.o(22360);
  }
  
  public final void XN(String paramString)
  {
    AppMethodBeat.i(22361);
    Log.i("MicroMsg.DeleteContactService", "delete contact %s", new Object[] { paramString });
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().b(new d(paramString));
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaT().a(4, this);
    AppMethodBeat.o(22361);
  }
  
  public final void a(int paramInt, dzc paramdzc, k.b paramb)
  {
    AppMethodBeat.i(260645);
    for (;;)
    {
      Object localObject;
      try
      {
        Log.i("MicroMsg.DeleteContactService", "ret %d, title %d, content %s", new Object[] { Integer.valueOf(paramInt), paramdzc.hAP, paramdzc.nUB });
        if (paramb.getCmdId() != 4) {
          break;
        }
        paramb = w.a(((aid)new aid().parseFrom(paramb.getBuffer())).ZqL);
        Log.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", new Object[] { paramb, Integer.valueOf(paramInt) });
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramb);
        if (paramInt == 0)
        {
          ab.IU(paramb);
          br.a(paramb, null);
          ac.aY(paramb, 15);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxK(paramb);
          c.h(0L, paramb);
          c.h(0L, ((az)localObject).field_encryptUsername);
          localObject = this.vsY.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((a.a)((Iterator)localObject).next()).onDeleteContact(paramb, paramInt, paramdzc);
          continue;
        }
        ((au)localObject).aRK();
      }
      catch (Exception paramdzc)
      {
        Log.printErrStackTrace("MicroMsg.DeleteContactService", paramdzc, "BaseProtoBuf parseFrom error!", new Object[0]);
        AppMethodBeat.o(260645);
        return;
      }
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(paramb, (au)localObject);
    }
    AppMethodBeat.o(260645);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(22362);
    this.vsY.add(parama);
    AppMethodBeat.o(22362);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(22363);
    this.vsY.remove(parama);
    AppMethodBeat.o(22363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */