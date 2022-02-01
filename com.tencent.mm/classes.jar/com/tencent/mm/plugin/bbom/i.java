package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ba.b;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.ba.d;
import com.tencent.mm.bj.c;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.pluginsdk.f.a.a;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class i
  implements com.tencent.mm.ak.g, a
{
  private List<a.a> nnR;
  
  public i()
  {
    AppMethodBeat.i(22360);
    this.nnR = new ArrayList();
    AppMethodBeat.o(22360);
  }
  
  public final void Kp(String paramString)
  {
    AppMethodBeat.i(22361);
    ac.i("MicroMsg.DeleteContactService", "delete contact %s", new Object[] { paramString });
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new d(paramString));
    AppMethodBeat.o(22361);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(22362);
    this.nnR.add(parama);
    AppMethodBeat.o(22362);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(22363);
    this.nnR.remove(parama);
    AppMethodBeat.o(22363);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(22364);
    ac.i("MicroMsg.DeleteContactService", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    List localList;
    Object localObject1;
    if ((paramn instanceof b))
    {
      localList = ((b)paramn).hOW;
      localObject1 = ((b.c)((b)paramn).hOV.getRespObj()).hPa;
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
          localObject2 = z.a(((aav)new aav().parseFrom(((j.b)localObject2).getBuffer())).EuE);
          paramInt2 = ((Integer)((cbv)localObject1).FpR.EKK.get(paramInt1)).intValue();
          ac.i("MicroMsg.DeleteContactService", "handel delete contact %s,%d", new Object[] { localObject2, Integer.valueOf(paramInt2) });
          localObject3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt((String)localObject2);
          if (paramInt2 == 0)
          {
            w.wJ((String)localObject2);
            bi.a((String)localObject2, null);
            ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNG((String)localObject2);
            c.f(0L, (String)localObject2);
            c.f(0L, ((av)localObject3).field_encryptUsername);
            paramString.put(localObject2, ((cbv)localObject1).FpR.EKK.get(paramInt1));
            paramn.put(localObject2, ((cbv)localObject1).FpR.FpS.get(paramInt1));
            break label471;
          }
          ((ai)localObject3).aaf();
          ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().c((String)localObject2, (ai)localObject3);
          continue;
        }
        localIterator = this.nnR.iterator();
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.DeleteContactService", localException, "BaseProtoBuf parseFrom error!", new Object[0]);
      }
      Iterator localIterator;
      while (localIterator.hasNext())
      {
        localObject1 = (a.a)localIterator.next();
        localObject2 = paramString.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((a.a)localObject1).a((String)localObject3, ((Integer)paramString.get(localObject3)).intValue(), (cbt)paramn.get(localObject3));
        }
      }
      AppMethodBeat.o(22364);
      return;
      label471:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.i
 * JD-Core Version:    0.7.0.1
 */