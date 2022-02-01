package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.am;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h;

public final class e
  extends am
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final boolean op(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20480);
    ad.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      g.yhR.dD(336, 14);
      com.tencent.mm.model.ba.aBQ();
      localObject1 = c.getDataDB();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
      localObject2 = ((StringBuilder)localObject2).toString();
      ad.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[] { localObject2 });
      localObject2 = ((h)localObject1).a((String)localObject2, null, 2);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
        do
        {
          localObject4 = ((Cursor)localObject2).getString(0);
          if (!w.Al((String)localObject4)) {
            ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
          }
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        localObject3 = ((StringBuilder)localObject3).toString();
        ad.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.TRUE, localObject3 });
        ((h)localObject1).execSQL("rconversation", (String)localObject3);
        com.tencent.mm.model.ba.aBQ();
        localObject1 = c.azv().aTz("officialaccounts");
        if (localObject1 != null) {
          break label549;
        }
        localObject1 = new at("officialaccounts");
        ((at)localObject1).fqK();
        com.tencent.mm.model.ba.aBQ();
        c.azv().e((at)localObject1);
      }
    }
    label549:
    for (;;)
    {
      com.tencent.mm.model.ba.aBQ();
      localObject3 = c.azv().fqS();
      if (bt.isNullOrNil((String)localObject3))
      {
        ad.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
        AppMethodBeat.o(20480);
        return;
      }
      com.tencent.mm.model.ba.aBQ();
      localObject3 = c.azs().apX((String)localObject3);
      if ((localObject3 == null) || (((ei)localObject3).field_msgId == 0L))
      {
        ad.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
        AppMethodBeat.o(20480);
        return;
      }
      ((at)localObject1).aL((bu)localObject3);
      ((at)localObject1).setContent(((ei)localObject3).field_talker + ":" + ((ei)localObject3).field_content);
      ((at)localObject1).tA(Integer.toString(((bu)localObject3).getType()));
      com.tencent.mm.model.ba.aBQ();
      localObject4 = c.azv().Na();
      if (localObject4 != null)
      {
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        PInt localPInt = new PInt();
        ((bu)localObject3).tN("officialaccounts");
        ((bu)localObject3).setContent(((com.tencent.mm.g.c.ba)localObject1).field_content);
        ((bq.b)localObject4).a((bu)localObject3, localPString1, localPString2, localPInt, false);
        ((at)localObject1).tB(localPString1.value);
        ((at)localObject1).tC(localPString2.value);
        ((at)localObject1).ks(localPInt.value);
      }
      com.tencent.mm.model.ba.aBQ();
      c.azv().a((at)localObject1, ((com.tencent.mm.g.c.ba)localObject1).field_username);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        ((Cursor)localObject2).close();
      }
      AppMethodBeat.o(20480);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ap.e
 * JD-Core Version:    0.7.0.1
 */