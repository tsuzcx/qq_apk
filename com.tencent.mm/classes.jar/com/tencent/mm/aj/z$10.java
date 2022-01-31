package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;

final class z$10
  implements be.a
{
  z$10(z paramz) {}
  
  public final void a(ak paramak, be parambe)
  {
    AppMethodBeat.i(11466);
    if ((paramak != null) && (!bo.isNullOrNil(paramak.field_username)))
    {
      parambe = paramak.field_username;
      Object localObject = ((j)g.E(j.class)).YA().arw(parambe);
      if (localObject == null)
      {
        AppMethodBeat.o(11466);
        return;
      }
      if ((((ad)localObject).dwz()) && (!t.og(parambe)))
      {
        localObject = z.afi().rK(parambe);
        if (((d)localObject).systemRowid == -1L)
        {
          ab.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
          AppMethodBeat.o(11466);
          return;
        }
        if (((d)localObject).aeh())
        {
          if (((d)localObject).cU(false) == null)
          {
            paramak.jY(null);
            ab.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
            AppMethodBeat.o(11466);
            return;
          }
          if (((d)localObject).cU(false).aeI() == null)
          {
            paramak.jY(null);
            ab.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
            AppMethodBeat.o(11466);
            return;
          }
          if (!((d)localObject).aei())
          {
            paramak.jY(bo.nullAsNil(((d)localObject).aeo()));
            if (bo.isNullOrNil(((d)localObject).aeo()))
            {
              ab.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramak.field_username });
              AppMethodBeat.o(11466);
            }
          }
          else
          {
            paramak.jY(null);
          }
          AppMethodBeat.o(11466);
          return;
        }
        if ((((d)localObject).aed()) || (((d)localObject).aeg()) || (t.oB(parambe)))
        {
          paramak.jY(null);
          AppMethodBeat.o(11466);
          return;
        }
        paramak.jY("officialaccounts");
      }
    }
    AppMethodBeat.o(11466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aj.z.10
 * JD-Core Version:    0.7.0.1
 */