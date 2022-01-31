package com.tencent.mm.al;

import android.database.Cursor;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;

public final class f
  extends ah
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
  
  public final void transfer(int paramInt)
  {
    y.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.h(336L, 14L, 1L);
      au.Hx();
      localObject1 = c.Dv();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
      localObject2 = ((StringBuilder)localObject2).toString();
      y.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[] { localObject2 });
      localObject2 = ((com.tencent.mm.cf.h)localObject1).a((String)localObject2, null, 2);
      if ((localObject2 == null) || (!((Cursor)localObject2).moveToFirst())) {
        break label508;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
      do
      {
        localObject4 = ((Cursor)localObject2).getString(0);
        if (!s.hS((String)localObject4)) {
          ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
        }
      } while (((Cursor)localObject2).moveToNext());
      ((Cursor)localObject2).close();
      localObject3 = ((StringBuilder)localObject3).toString();
      y.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.valueOf(true), localObject3 });
      ((com.tencent.mm.cf.h)localObject1).gk("rconversation", (String)localObject3);
      au.Hx();
      localObject1 = c.FB().abv("officialaccounts");
      if (localObject1 != null) {
        break label528;
      }
      localObject1 = new ak("officialaccounts");
      ((ak)localObject1).cuB();
      au.Hx();
      c.FB().d((ak)localObject1);
    }
    label528:
    for (;;)
    {
      au.Hx();
      localObject3 = c.FB().cuL();
      if (bk.bl((String)localObject3)) {
        y.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
      }
      label508:
      do
      {
        return;
        au.Hx();
        localObject3 = c.Fy().HA((String)localObject3);
        if ((localObject3 == null) || (((cs)localObject3).field_msgId == 0L))
        {
          y.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
          return;
        }
        ((ak)localObject1).ai((bi)localObject3);
        ((ak)localObject1).setContent(((cs)localObject3).field_talker + ":" + ((cs)localObject3).field_content);
        ((ak)localObject1).dP(Integer.toString(((bi)localObject3).getType()));
        au.Hx();
        localObject4 = c.FB().tt();
        if (localObject4 != null)
        {
          PString localPString1 = new PString();
          PString localPString2 = new PString();
          PInt localPInt = new PInt();
          ((bi)localObject3).ec("officialaccounts");
          ((bi)localObject3).setContent(((as)localObject1).field_content);
          ((be.b)localObject4).a((bi)localObject3, localPString1, localPString2, localPInt, false);
          ((ak)localObject1).dQ(localPString1.value);
          ((ak)localObject1).dR(localPString2.value);
          ((ak)localObject1).fB(localPInt.value);
        }
        au.Hx();
        c.FB().a((ak)localObject1, ((as)localObject1).field_username);
      } while ((localObject2 == null) || (((Cursor)localObject2).isClosed()));
      ((Cursor)localObject2).close();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.al.f
 * JD-Core Version:    0.7.0.1
 */