package com.tencent.mm.app;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.nh;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class WorkerProfile$19$1
  implements f
{
  WorkerProfile$19$1(WorkerProfile.19 param19) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(1145, this);
    y.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramm.getType() != 1145);
        paramString = (com.tencent.mm.modelappbrand.p)paramm;
      } while ((((ake)paramString.dZP.ecE.ecN).tgK & 0x1) == 0);
      bool = paramString.Ju().sAN;
      au.Hx();
      if (bool != c.Dz().getBoolean(ac.a.uty, true))
      {
        y.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
        au.Hx();
        c.Dz().c(ac.a.uty, Boolean.valueOf(bool));
        a.udP.m(new nh());
      }
      bool = paramString.Ju().tgL;
      au.Hx();
    } while (bool == c.Dz().getBoolean(ac.a.utz, true));
    y.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
    au.Hx();
    c.Dz().c(ac.a.utz, Boolean.valueOf(bool));
    a.udP.m(new nh());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.19.1
 * JD-Core Version:    0.7.0.1
 */