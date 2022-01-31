package com.tencent.mm.model;

import com.tencent.mm.ai.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.p;

final class au$5
  implements be.a
{
  au$5(au paramau) {}
  
  public final void a(ak paramak, be parambe)
  {
    if (paramak == null)
    {
      break label4;
      break label4;
    }
    label4:
    while ((!ad.aaR(paramak.field_username)) && (!ad.aaT(paramak.field_username)) && (!ad.hd(paramak.field_username)) && (!s.hl(paramak.field_username)) && (!ad.aaU(paramak.field_username))) {
      return;
    }
    if (ad.hd(paramak.field_username))
    {
      paramak = parambe.abv("floatbottle");
      if (paramak != null) {
        break label428;
      }
      paramak = new ak("floatbottle");
    }
    label428:
    for (int i = 1;; i = 0)
    {
      paramak.fz(1);
      paramak.fy(k.Gf());
      au.Hx();
      bi localbi = c.Fy().HC(" and not ( type = 10000 and isSend != 2 ) ");
      if ((localbi != null) && (localbi.field_msgId > 0L))
      {
        paramak.ai(localbi);
        paramak.setContent(ad.aaZ(localbi.field_talker) + ":" + localbi.field_content);
        paramak.dP(Integer.toString(localbi.getType()));
        be.b localb = parambe.tt();
        if (localb != null)
        {
          PString localPString1 = new PString();
          PString localPString2 = new PString();
          PInt localPInt = new PInt();
          localbi.ec("floatbottle");
          localbi.setContent(paramak.field_content);
          localb.a(localbi, localPString1, localPString2, localPInt, false);
          paramak.dQ(localPString1.value);
          paramak.dR(localPString2.value);
          paramak.fB(localPInt.value);
        }
      }
      while (i != 0)
      {
        parambe.d(paramak);
        return;
        paramak.cuB();
      }
      parambe.a(paramak, paramak.field_username);
      return;
      if ((ad.aaR(paramak.field_username)) || (ad.aaT(paramak.field_username))) {
        break;
      }
      com.tencent.mm.kernel.g.r(o.class);
      p.b(paramak, parambe);
      if (!"@blacklist".equals(paramak.field_parentRef)) {
        break;
      }
      au.Hx();
      parambe = c.Fw().abl(paramak.field_username);
      if ((parambe == null) || (bk.bl(parambe.field_username)) || (parambe.Bg())) {
        break;
      }
      au.Hx();
      c.FB().d(new String[] { paramak.field_username }, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.au.5
 * JD-Core Version:    0.7.0.1
 */