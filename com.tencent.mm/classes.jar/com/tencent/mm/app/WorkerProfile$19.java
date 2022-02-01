package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class WorkerProfile$19
  extends com.tencent.mm.sdk.b.c<ns>
{
  WorkerProfile$19(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(161248);
    this.__eventId = ns.class.getName().hashCode();
    AppMethodBeat.o(161248);
  }
  
  private boolean MX()
  {
    AppMethodBeat.i(19564);
    bc.ajj().a(1145, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(19563);
        bc.ajj().b(1145, this);
        ae.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          AppMethodBeat.o(19563);
          return;
        }
        if (paramAnonymousn.getType() != 1145)
        {
          AppMethodBeat.o(19563);
          return;
        }
        paramAnonymousString = (r)paramAnonymousn;
        if ((((biu)paramAnonymousString.hNp.hQD.hQJ).GWF & 0x1) == 0)
        {
          AppMethodBeat.o(19563);
          return;
        }
        boolean bool = paramAnonymousString.aEd().FVq;
        bc.aCg();
        if (bool != com.tencent.mm.model.c.ajA().getBoolean(am.a.IQE, true))
        {
          ae.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IQE, Boolean.valueOf(bool));
          a.IvT.l(new qo());
        }
        bool = paramAnonymousString.aEd().GWG;
        bc.aCg();
        if (bool != com.tencent.mm.model.c.ajA().getBoolean(am.a.IQF, true))
        {
          ae.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IQF, Boolean.valueOf(bool));
          a.IvT.l(new qo());
        }
        AppMethodBeat.o(19563);
      }
    });
    bc.ajj().a(new r(5), 0);
    AppMethodBeat.o(19564);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.19
 * JD-Core Version:    0.7.0.1
 */