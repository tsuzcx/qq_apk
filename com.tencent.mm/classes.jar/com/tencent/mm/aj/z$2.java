package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;

final class z$2
  implements e.a
{
  z$2(z paramz) {}
  
  public final void a(e.a.b paramb)
  {
    AppMethodBeat.i(11464);
    Object localObject;
    ak localak;
    int i;
    if ((paramb.fwk == e.a.a.fwg) || (paramb.fwk == e.a.a.fwi))
    {
      if (paramb.fwl == null)
      {
        AppMethodBeat.o(11464);
        return;
      }
      localObject = ((j)g.E(j.class)).YA().arw(paramb.fuO);
      if (localObject == null)
      {
        AppMethodBeat.o(11464);
        return;
      }
      if (!((ad)localObject).dwz())
      {
        z.j(paramb.fwl);
        AppMethodBeat.o(11464);
        return;
      }
      if (t.og(((aq)localObject).field_username))
      {
        AppMethodBeat.o(11464);
        return;
      }
      localak = ((j)g.E(j.class)).YF().arH(paramb.fuO);
      ab.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramb.fuO });
      if ((paramb.fwl.aeh()) && (paramb.fwl.cU(false) != null) && (paramb.fwl.cU(false).aeI() != null) && (!bo.isNullOrNil(paramb.fwl.aeo())) && (bo.isNullOrNil(paramb.fwl.field_enterpriseFather)))
      {
        paramb.fwl.field_enterpriseFather = paramb.fwl.aeo();
        z.afi().e(paramb.fwl);
        ab.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramb.fuO, paramb.fwl.field_enterpriseFather });
      }
      if (localak == null)
      {
        AppMethodBeat.o(11464);
        return;
      }
      if (paramb.fwl.aeh())
      {
        if (paramb.fwl.cU(false) == null)
        {
          ab.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
          AppMethodBeat.o(11464);
          return;
        }
        if (paramb.fwl.cU(false).aeI() == null)
        {
          ab.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
          AppMethodBeat.o(11464);
          return;
        }
        localObject = localak.field_parentRef;
        if (!paramb.fwl.aei())
        {
          ab.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramb.fwl.aeo(), paramb.fuO });
          localak.jY(bo.nullAsNil(paramb.fwl.aeo()));
          if ((localObject == null) || (localak.field_parentRef == null) || (((String)localObject).equals(localak.field_parentRef))) {
            break label507;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      label429:
      ab.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramb.fuO, localak.field_parentRef });
      for (;;)
      {
        if (i != 0)
        {
          ((j)g.E(j.class)).YF().a(localak, localak.field_username);
          if (bo.isNullOrNil(localak.field_parentRef))
          {
            AppMethodBeat.o(11464);
            return;
            localak.jY(null);
            break;
            label507:
            if ((localObject == null) && (localak.field_parentRef != null))
            {
              i = 1;
              break label429;
            }
            if ((localObject == null) || (localak.field_parentRef != null)) {
              break label1055;
            }
            i = 1;
            break label429;
            if (paramb.fwl.aeg())
            {
              ab.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramb.fuO });
              i = 1;
              continue;
            }
            if ((!paramb.fwl.aed()) && (!t.oB(((aq)localObject).field_username)) && (!"officialaccounts".equals(localak.field_parentRef)))
            {
              localak.jY("officialaccounts");
              i = 1;
              continue;
            }
            if ((!paramb.fwl.aed()) || (localak.field_parentRef == null)) {
              break label1050;
            }
            localak.jY(null);
            i = 1;
            continue;
          }
          if ("officialaccounts".equals(localak.field_parentRef))
          {
            localak = ((j)g.E(j.class)).YF().arH("officialaccounts");
            paramb = localak;
            if (localak == null)
            {
              paramb = new ak("officialaccounts");
              paramb.dxc();
              ((j)g.E(j.class)).YF().d(paramb);
            }
            if (bo.isNullOrNil(paramb.field_content))
            {
              ab.i("MicroMsg.SubCoreBiz", "conv content is null");
              paramb = ((j)g.E(j.class)).YF().dxl();
              if (bo.isNullOrNil(paramb))
              {
                ab.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                AppMethodBeat.o(11464);
                return;
              }
              paramb = ((j)g.E(j.class)).bPQ().Tm(paramb);
              if ((paramb == null) || (paramb.field_msgId == 0L))
              {
                ab.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                AppMethodBeat.o(11464);
                return;
              }
              ((j)g.E(j.class)).bPQ().a(paramb.field_msgId, paramb);
            }
            AppMethodBeat.o(11464);
            return;
          }
          ab.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramb.fuO, localak.field_parentRef });
          paramb = ((j)g.E(j.class)).YF().arH(localak.field_parentRef);
          if (paramb == null)
          {
            AppMethodBeat.o(11464);
            return;
          }
          if (bo.isNullOrNil(paramb.field_content))
          {
            ab.i("MicroMsg.SubCoreBiz", "conv content is null");
            paramb = ((j)g.E(j.class)).YF().arT(localak.field_parentRef);
            if (bo.isNullOrNil(paramb))
            {
              ab.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
              AppMethodBeat.o(11464);
              return;
            }
            paramb = ((j)g.E(j.class)).bPQ().Tm(paramb);
            if ((paramb == null) || (paramb.field_msgId == 0L))
            {
              ab.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
              AppMethodBeat.o(11464);
              return;
            }
            ((j)g.E(j.class)).bPQ().a(paramb.field_msgId, paramb);
          }
        }
        AppMethodBeat.o(11464);
        return;
        label1050:
        i = 0;
      }
      label1055:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.z.2
 * JD-Core Version:    0.7.0.1
 */