package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ph;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.v.b;

final class WorkerProfile$19
  extends IListener<ph>
{
  WorkerProfile$19(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(161248);
    this.__eventId = ph.class.getName().hashCode();
    AppMethodBeat.o(161248);
  }
  
  private boolean abM()
  {
    AppMethodBeat.i(19564);
    bh.aGY().a(1145, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(19563);
        bh.aGY().b(1145, this);
        Log.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          AppMethodBeat.o(19563);
          return;
        }
        if (paramAnonymousq.getType() != 1145)
        {
          AppMethodBeat.o(19563);
          return;
        }
        paramAnonymousString = (r)paramAnonymousq;
        if ((((ccp)d.b.b(paramAnonymousString.lyx.lBR)).TkK & 0x1) == 0)
        {
          AppMethodBeat.o(19563);
          return;
        }
        boolean bool = paramAnonymousString.bgZ().RPZ;
        bh.beI();
        if (bool != c.aHp().getBoolean(ar.a.VmF, true))
        {
          Log.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          bh.beI();
          c.aHp().set(ar.a.VmF, Boolean.valueOf(bool));
          ((b)LifecycleEventCenter.getEvent(b.class)).publish();
        }
        bool = paramAnonymousString.bgZ().TkL;
        bh.beI();
        if (bool != c.aHp().getBoolean(ar.a.VmG, true))
        {
          Log.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          bh.beI();
          c.aHp().set(ar.a.VmG, Boolean.valueOf(bool));
          ((b)LifecycleEventCenter.getEvent(b.class)).publish();
        }
        AppMethodBeat.o(19563);
      }
    });
    bh.aGY().a(new r(5), 0);
    AppMethodBeat.o(19564);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.19
 * JD-Core Version:    0.7.0.1
 */