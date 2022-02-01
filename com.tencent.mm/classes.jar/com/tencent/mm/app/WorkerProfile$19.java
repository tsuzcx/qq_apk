package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class WorkerProfile$19
  extends IListener<ok>
{
  WorkerProfile$19(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(161248);
    this.__eventId = ok.class.getName().hashCode();
    AppMethodBeat.o(161248);
  }
  
  private boolean Xj()
  {
    AppMethodBeat.i(19564);
    bg.azz().a(1145, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(19563);
        bg.azz().b(1145, this);
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
        if ((((bux)paramAnonymousString.iIu.iLK.iLR).Mbn & 0x1) == 0)
        {
          AppMethodBeat.o(19563);
          return;
        }
        boolean bool = paramAnonymousString.aXQ().KPb;
        bg.aVF();
        if (bool != c.azQ().getBoolean(ar.a.NYF, true))
        {
          Log.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          bg.aVF();
          c.azQ().set(ar.a.NYF, Boolean.valueOf(bool));
          EventCenter.instance.publish(new ri());
        }
        bool = paramAnonymousString.aXQ().Mbo;
        bg.aVF();
        if (bool != c.azQ().getBoolean(ar.a.NYG, true))
        {
          Log.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
          bg.aVF();
          c.azQ().set(ar.a.NYG, Boolean.valueOf(bool));
          EventCenter.instance.publish(new ri());
        }
        AppMethodBeat.o(19563);
      }
    });
    bg.azz().a(new r(5), 0);
    AppMethodBeat.o(19564);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.19
 * JD-Core Version:    0.7.0.1
 */