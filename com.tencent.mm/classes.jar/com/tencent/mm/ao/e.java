package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;

public final class e
  extends ao
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final boolean os(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20480);
    ae.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      g.yxI.dD(336, 14);
      bc.aCg();
      localObject1 = c.getDataDB();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
      localObject2 = ((StringBuilder)localObject2).toString();
      ae.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[] { localObject2 });
      localObject2 = ((h)localObject1).a((String)localObject2, null, 2);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
        do
        {
          localObject4 = ((Cursor)localObject2).getString(0);
          if (!x.AV((String)localObject4)) {
            ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
          }
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        localObject3 = ((StringBuilder)localObject3).toString();
        ae.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.TRUE, localObject3 });
        ((h)localObject1).execSQL("rconversation", (String)localObject3);
        bc.aCg();
        localObject1 = c.azL().aVa("officialaccounts");
        if (localObject1 != null) {
          break label549;
        }
        localObject1 = new au("officialaccounts");
        ((au)localObject1).fuK();
        bc.aCg();
        c.azL().e((au)localObject1);
      }
    }
    label549:
    for (;;)
    {
      bc.aCg();
      localObject3 = c.azL().fuS();
      if (bu.isNullOrNil((String)localObject3))
      {
        ae.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
        AppMethodBeat.o(20480);
        return;
      }
      bc.aCg();
      localObject3 = c.azI().arc((String)localObject3);
      if ((localObject3 == null) || (((ei)localObject3).field_msgId == 0L))
      {
        ae.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
        AppMethodBeat.o(20480);
        return;
      }
      ((au)localObject1).aK((bv)localObject3);
      ((au)localObject1).setContent(((ei)localObject3).field_talker + ":" + ((ei)localObject3).field_content);
      ((au)localObject1).tV(Integer.toString(((bv)localObject3).getType()));
      bc.aCg();
      localObject4 = c.azL().MV();
      if (localObject4 != null)
      {
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        PInt localPInt = new PInt();
        ((bv)localObject3).ui("officialaccounts");
        ((bv)localObject3).setContent(((ba)localObject1).field_content);
        ((br.b)localObject4).a((bv)localObject3, localPString1, localPString2, localPInt, false);
        ((au)localObject1).tW(localPString1.value);
        ((au)localObject1).tX(localPString2.value);
        ((au)localObject1).ku(localPInt.value);
      }
      bc.aCg();
      c.azL().a((au)localObject1, ((ba)localObject1).field_username);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        ((Cursor)localObject2).close();
      }
      AppMethodBeat.o(20480);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.e
 * JD-Core Version:    0.7.0.1
 */