package com.tencent.mm.ai;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    if (((paramb.egi != e.a.a.ege) && (paramb.egi != e.a.a.egg)) || (paramb.egj == null)) {}
    Object localObject;
    ak localak;
    do
    {
      do
      {
        do
        {
          return;
          localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(paramb.eeM);
        } while (localObject == null);
        if (!((ad)localObject).cua())
        {
          z.h(paramb.egj);
          return;
        }
      } while (s.hx(((ao)localObject).field_username));
      localak = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv(paramb.eeM);
      y.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[] { paramb.eeM });
      if ((paramb.egj.Lz()) && (paramb.egj.bS(false) != null) && (paramb.egj.bS(false).Mb() != null) && (!bk.bl(paramb.egj.LG())) && (bk.bl(paramb.egj.field_enterpriseFather)))
      {
        paramb.egj.field_enterpriseFather = paramb.egj.LG();
        z.My().e(paramb.egj);
        y.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[] { paramb.eeM, paramb.egj.field_enterpriseFather });
      }
    } while (localak == null);
    label352:
    int i;
    if (paramb.egj.Lz())
    {
      if (paramb.egj.bS(false) == null)
      {
        y.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
        return;
      }
      if (paramb.egj.bS(false).Mb() == null)
      {
        y.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
        return;
      }
      localObject = localak.field_parentRef;
      if (!paramb.egj.LA())
      {
        y.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[] { paramb.egj.LG(), paramb.eeM });
        localak.dS(bk.pm(paramb.egj.LG()));
        if ((localObject == null) || (localak.field_parentRef == null) || (((String)localObject).equals(localak.field_parentRef))) {
          break label573;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label378:
      y.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[] { paramb.eeM, localak.field_parentRef });
      for (;;)
      {
        if (i == 0) {
          break label951;
        }
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(localak, localak.field_username);
        if (bk.bl(localak.field_parentRef)) {
          break;
        }
        if ("officialaccounts".equals(localak.field_parentRef))
        {
          localak = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv("officialaccounts");
          paramb = localak;
          if (localak == null)
          {
            paramb = new ak("officialaccounts");
            paramb.cuB();
            ((j)com.tencent.mm.kernel.g.r(j.class)).FB().d(paramb);
          }
          if (!bk.bl(paramb.field_content)) {
            break;
          }
          y.i("MicroMsg.SubCoreBiz", "conv content is null");
          paramb = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().cuL();
          if (bk.bl(paramb))
          {
            y.w("MicroMsg.SubCoreBiz", "last convBiz is null");
            return;
            localak.dS(null);
            break label352;
            label573:
            if ((localObject == null) && (localak.field_parentRef != null))
            {
              i = 1;
              break label378;
            }
            if ((localObject == null) || (localak.field_parentRef != null)) {
              break label953;
            }
            i = 1;
            break label378;
            if (paramb.egj.Ly())
            {
              y.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[] { paramb.eeM });
              i = 1;
              continue;
            }
            if ((!paramb.egj.Lv()) && (!s.hS(((ao)localObject).field_username)) && (!"officialaccounts".equals(localak.field_parentRef)))
            {
              localak.dS("officialaccounts");
              i = 1;
              continue;
            }
            if ((!paramb.egj.Lv()) || (localak.field_parentRef == null)) {
              break label948;
            }
            localak.dS(null);
            i = 1;
            continue;
          }
          paramb = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(paramb);
          if ((paramb == null) || (paramb.field_msgId == 0L))
          {
            y.w("MicroMsg.SubCoreBiz", "last biz msg is error");
            return;
          }
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramb.field_msgId, paramb);
          return;
        }
        y.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[] { paramb.eeM, localak.field_parentRef });
        paramb = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv(localak.field_parentRef);
        if ((paramb == null) || (!bk.bl(paramb.field_content))) {
          break;
        }
        y.i("MicroMsg.SubCoreBiz", "conv content is null");
        paramb = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abJ(localak.field_parentRef);
        if (bk.bl(paramb))
        {
          y.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
          return;
        }
        paramb = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(paramb);
        if ((paramb == null) || (paramb.field_msgId == 0L))
        {
          y.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
          return;
        }
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramb.field_msgId, paramb);
        return;
        label948:
        i = 0;
      }
      label951:
      break;
      label953:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ai.z.2
 * JD-Core Version:    0.7.0.1
 */