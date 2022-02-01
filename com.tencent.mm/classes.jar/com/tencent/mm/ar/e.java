package com.tencent.mm.ar;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;

public final class e
  extends at
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(20480);
    Log.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(336, 14);
      bh.beI();
      localObject1 = c.getDataDB();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("select rconversation.username from rconversation, rcontact").append(", bizinfo where rconversation.username = rcontact").append(".username and rconversation.username = bizinfo").append(".username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
      localObject2 = ((StringBuilder)localObject2).toString();
      Log.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[] { localObject2 });
      localObject2 = ((com.tencent.mm.storagebase.h)localObject1).rawQuery((String)localObject2, null, 2);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
        do
        {
          localObject4 = ((Cursor)localObject2).getString(0);
          if (!ab.QT((String)localObject4)) {
            ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
          }
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        localObject3 = ((StringBuilder)localObject3).toString();
        Log.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.TRUE, localObject3 });
        ((com.tencent.mm.storagebase.h)localObject1).execSQL("rconversation", (String)localObject3);
        bh.beI();
        localObject1 = c.bbR().bwx("officialaccounts");
        if (localObject1 != null) {
          break label564;
        }
        localObject1 = new az("officialaccounts");
        ((az)localObject1).hyE();
        bh.beI();
        c.bbR().e((az)localObject1);
      }
    }
    label564:
    for (;;)
    {
      bh.beI();
      localObject3 = c.bbR().hyM();
      if (Util.isNullOrNil((String)localObject3))
      {
        Log.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
        AppMethodBeat.o(20480);
        return;
      }
      bh.beI();
      localObject3 = c.bbO().aOH((String)localObject3);
      if ((localObject3 == null) || (((et)localObject3).field_msgId == 0L))
      {
        Log.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
        AppMethodBeat.o(20480);
        return;
      }
      ((az)localObject1).bq((ca)localObject3);
      ((az)localObject1).setContent(((et)localObject3).field_talker + ":" + ((et)localObject3).field_content);
      ((az)localObject1).IZ(Integer.toString(((ca)localObject3).getType()));
      bh.beI();
      localObject4 = c.bbR().abK();
      if (localObject4 != null)
      {
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        PInt localPInt = new PInt();
        ((ca)localObject3).Jm("officialaccounts");
        ((ca)localObject3).setContent(((bb)localObject1).field_content);
        ((bw.b)localObject4).a((ca)localObject3, localPString1, localPString2, localPInt, false);
        ((az)localObject1).Ja(localPString1.value);
        ((az)localObject1).Jb(localPString2.value);
        ((az)localObject1).pK(localPInt.value);
      }
      bh.beI();
      c.bbR().a((az)localObject1, ((bb)localObject1).field_username);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        ((Cursor)localObject2).close();
      }
      AppMethodBeat.o(20480);
      return;
    }
  }
  
  public final boolean uQ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ar.e
 * JD-Core Version:    0.7.0.1
 */