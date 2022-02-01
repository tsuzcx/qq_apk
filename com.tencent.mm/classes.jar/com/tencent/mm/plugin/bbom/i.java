package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.b.a;
import com.tencent.mm.bb.b.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.pluginsdk.f.a.a;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class i
  implements com.tencent.mm.al.g, a
{
  private List<a.a> mLI;
  
  public i()
  {
    AppMethodBeat.i(22360);
    this.mLI = new ArrayList();
    AppMethodBeat.o(22360);
  }
  
  public final void Gl(String paramString)
  {
    AppMethodBeat.i(22361);
    ad.i("MicroMsg.DeleteContactService", "delete contact %s", new Object[] { paramString });
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(new com.tencent.mm.bb.c(paramString));
    AppMethodBeat.o(22361);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(22362);
    this.mLI.add(parama);
    AppMethodBeat.o(22362);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(22363);
    this.mLI.remove(parama);
    AppMethodBeat.o(22363);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(22364);
    ad.i("MicroMsg.DeleteContactService", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    List localList;
    Object localObject1;
    if ((paramn instanceof b))
    {
      localList = ((b)paramn).hot;
      localObject1 = ((b.c)((b)paramn).hos.getRespObj()).hox;
      paramString = new HashMap();
      paramn = new HashMap();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        if (paramInt1 < localList.size())
        {
          localObject2 = (j.b)localList.get(paramInt1);
          if (((j.b)localObject2).getCmdId() != 4) {
            break label471;
          }
          localObject2 = z.a(((zw)new zw().parseFrom(((j.b)localObject2).getBuffer())).Dby);
          paramInt2 = ((Integer)((bxb)localObject1).DTv.DpH.get(paramInt1)).intValue();
          ad.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", new Object[] { localObject2, Integer.valueOf(paramInt2) });
          localObject3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY((String)localObject2);
          if (paramInt2 == 0)
          {
            w.sG((String)localObject2);
            bi.a((String)localObject2, null);
            ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIl((String)localObject2);
            com.tencent.mm.bk.c.f(0L, (String)localObject2);
            com.tencent.mm.bk.c.f(0L, ((au)localObject3).field_encryptUsername);
            paramString.put(localObject2, ((bxb)localObject1).DTv.DpH.get(paramInt1));
            paramn.put(localObject2, ((bxb)localObject1).DTv.DTw.get(paramInt1));
            break label471;
          }
          ((af)localObject3).Zk();
          ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().c((String)localObject2, (af)localObject3);
          continue;
        }
        localIterator = this.mLI.iterator();
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.DeleteContactService", localException, "BaseProtoBuf parseFrom error!", new Object[0]);
      }
      Iterator localIterator;
      while (localIterator.hasNext())
      {
        localObject1 = (a.a)localIterator.next();
        localObject2 = paramString.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((a.a)localObject1).a((String)localObject3, ((Integer)paramString.get(localObject3)).intValue(), (bwz)paramn.get(localObject3));
        }
      }
      AppMethodBeat.o(22364);
      return;
      label471:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.i
 * JD-Core Version:    0.7.0.1
 */