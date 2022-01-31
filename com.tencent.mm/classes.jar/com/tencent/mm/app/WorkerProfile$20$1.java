package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class WorkerProfile$20$1
  implements f
{
  WorkerProfile$20$1(WorkerProfile.20 param20) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(15504);
    aw.Rc().b(1145, this);
    ab.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(15504);
      return;
    }
    if (paramm.getType() != 1145)
    {
      AppMethodBeat.o(15504);
      return;
    }
    paramString = (com.tencent.mm.modelappbrand.p)paramm;
    if ((((app)paramString.fpW.fsV.fta).xfs & 0x1) == 0)
    {
      AppMethodBeat.o(15504);
      return;
    }
    boolean bool = paramString.acs().wvc;
    aw.aaz();
    if (bool != c.Ru().getBoolean(ac.a.yDB, true))
    {
      ab.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
      aw.aaz();
      c.Ru().set(ac.a.yDB, Boolean.valueOf(bool));
      a.ymk.l(new oe());
    }
    bool = paramString.acs().xft;
    aw.aaz();
    if (bool != c.Ru().getBoolean(ac.a.yDC, true))
    {
      ab.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
      aw.aaz();
      c.Ru().set(ac.a.yDC, Boolean.valueOf(bool));
      a.ymk.l(new oe());
    }
    AppMethodBeat.o(15504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.20.1
 * JD-Core Version:    0.7.0.1
 */