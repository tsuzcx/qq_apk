package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class WorkerProfile$19
  extends com.tencent.mm.sdk.b.c<nr>
{
  WorkerProfile$19(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(161248);
    this.__eventId = nr.class.getName().hashCode();
    AppMethodBeat.o(161248);
  }
  
  private boolean Nc()
  {
    AppMethodBeat.i(19564);
    ba.aiU().a(1145, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(19563);
        ba.aiU().b(1145, this);
        ad.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
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
        if ((((bie)paramAnonymousString.hKw.hNK.hNQ).GDf & 0x1) == 0)
        {
          AppMethodBeat.o(19563);
          return;
        }
        boolean bool = paramAnonymousString.aDN().FCV;
        ba.aBQ();
        if (bool != com.tencent.mm.model.c.ajl().getBoolean(al.a.Iwg, true))
        {
          ad.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iwg, Boolean.valueOf(bool));
          a.IbL.l(new qn());
        }
        bool = paramAnonymousString.aDN().GDg;
        ba.aBQ();
        if (bool != com.tencent.mm.model.c.ajl().getBoolean(al.a.Iwh, true))
        {
          ad.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iwh, Boolean.valueOf(bool));
          a.IbL.l(new qn());
        }
        AppMethodBeat.o(19563);
      }
    });
    ba.aiU().a(new r(5), 0);
    AppMethodBeat.o(19564);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.19
 * JD-Core Version:    0.7.0.1
 */