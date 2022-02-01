package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.bd.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class c$1
  implements Runnable
{
  c$1(c paramc, q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(195499);
    Object localObject2 = ((b)this.ftz).lWF;
    Object localObject1 = new HashSet();
    try
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localb = (k.b)((Iterator)localObject2).next();
        if (localb.getCmdId() != 2) {
          break label151;
        }
        ((Set)localObject1).add(z.a(((cyb)new cyb().parseFrom(localb.getBuffer())).SrH));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        k.b localb;
        Log.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", localException, "BaseProtoBuf parseFrom error!", new Object[0]);
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          if (!Util.isNullOrNil(str)) {
            az.a.ltq.a(str, null, null);
          }
        }
        label151:
        if (localb.getCmdId() == 54) {
          ((Set)localObject1).add(((cye)new cye().parseFrom(localb.getBuffer())).TGE);
        } else if (localb.getCmdId() == 60) {
          ((Set)localObject1).add(((cyv)new cyv().parseFrom(localb.getBuffer())).TGE);
        }
      }
      AppMethodBeat.o(195499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c.1
 * JD-Core Version:    0.7.0.1
 */