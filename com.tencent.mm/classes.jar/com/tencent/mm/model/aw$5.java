package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.p;

final class aw$5
  implements be.a
{
  aw$5(aw paramaw) {}
  
  public final void a(ak paramak, be parambe)
  {
    AppMethodBeat.i(16280);
    if (paramak == null)
    {
      AppMethodBeat.o(16280);
      return;
    }
    if ((!ad.arc(paramak.field_username)) && (!ad.are(paramak.field_username)) && (!ad.nM(paramak.field_username)) && (!t.nU(paramak.field_username)) && (!ad.arf(paramak.field_username)))
    {
      AppMethodBeat.o(16280);
      return;
    }
    if (ad.nM(paramak.field_username))
    {
      paramak = parambe.arH("floatbottle");
      if (paramak != null) {
        break label472;
      }
      paramak = new ak("floatbottle");
    }
    label472:
    for (int i = 1;; i = 0)
    {
      paramak.hK(1);
      paramak.hJ(l.Zj());
      aw.aaz();
      bi localbi = c.YC().To(" and not ( type = 10000 and isSend != 2 ) ");
      if ((localbi != null) && (localbi.field_msgId > 0L))
      {
        paramak.aq(localbi);
        paramak.setContent(ad.ark(localbi.field_talker) + ":" + localbi.field_content);
        paramak.jV(Integer.toString(localbi.getType()));
        be.b localb = parambe.BX();
        if (localb != null)
        {
          PString localPString1 = new PString();
          PString localPString2 = new PString();
          PInt localPInt = new PInt();
          localbi.kj("floatbottle");
          localbi.setContent(paramak.field_content);
          localb.a(localbi, localPString1, localPString2, localPInt, false);
          paramak.jW(localPString1.value);
          paramak.jX(localPString2.value);
          paramak.hM(localPInt.value);
        }
      }
      while (i != 0)
      {
        parambe.d(paramak);
        AppMethodBeat.o(16280);
        return;
        paramak.dxc();
      }
      parambe.a(paramak, paramak.field_username);
      AppMethodBeat.o(16280);
      return;
      if ((ad.arc(paramak.field_username)) || (ad.are(paramak.field_username)))
      {
        AppMethodBeat.o(16280);
        return;
      }
      g.E(o.class);
      p.b(paramak, parambe);
      if ("@blacklist".equals(paramak.field_parentRef))
      {
        aw.aaz();
        parambe = c.YA().arw(paramak.field_username);
        if ((parambe != null) && (!bo.isNullOrNil(parambe.field_username)) && (!parambe.NW()))
        {
          aw.aaz();
          c.YF().c(new String[] { paramak.field_username }, "");
        }
      }
      AppMethodBeat.o(16280);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.aw.5
 * JD-Core Version:    0.7.0.1
 */