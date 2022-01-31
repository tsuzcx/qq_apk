package com.tencent.mm.ai;

import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    Object localObject;
    if ((paramak != null) && (!bk.bl(paramak.field_username)))
    {
      parambe = paramak.field_username;
      localObject = ((j)g.r(j.class)).Fw().abl(parambe);
      if (localObject != null) {
        break label44;
      }
    }
    label44:
    do
    {
      do
      {
        return;
      } while ((!((ad)localObject).cua()) || (s.hx(parambe)));
      localObject = z.My().kQ(parambe);
      if (((d)localObject).ujK == -1L)
      {
        y.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
        return;
      }
      if (!((d)localObject).Lz()) {
        break label190;
      }
      if (((d)localObject).bS(false) == null)
      {
        paramak.dS(null);
        y.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
        return;
      }
      if (((d)localObject).bS(false).Mb() == null)
      {
        paramak.dS(null);
        y.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
        return;
      }
      if (((d)localObject).LA()) {
        break;
      }
      paramak.dS(bk.pm(((d)localObject).LG()));
    } while (!bk.bl(((d)localObject).LG()));
    y.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[] { paramak.field_username });
    return;
    paramak.dS(null);
    return;
    label190:
    if ((((d)localObject).Lv()) || (((d)localObject).Ly()) || (s.hS(parambe)))
    {
      paramak.dS(null);
      return;
    }
    paramak.dS("officialaccounts");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.z.10
 * JD-Core Version:    0.7.0.1
 */