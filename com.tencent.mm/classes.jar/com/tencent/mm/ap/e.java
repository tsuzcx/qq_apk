package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.al;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.b;
import com.tencent.mm.storage.bl;

public final class e
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final boolean nb(int paramInt)
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
      com.tencent.mm.plugin.report.service.h.vKh.dB(336, 14);
      az.arV();
      localObject1 = c.afg();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
      localObject2 = ((StringBuilder)localObject2).toString();
      ad.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[] { localObject2 });
      localObject2 = ((com.tencent.mm.storagebase.h)localObject1).a((String)localObject2, null, 2);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
        do
        {
          localObject4 = ((Cursor)localObject2).getString(0);
          if (!w.tl((String)localObject4)) {
            ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
          }
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        localObject3 = ((StringBuilder)localObject3).toString();
        ad.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.TRUE, localObject3 });
        ((com.tencent.mm.storagebase.h)localObject1).execSQL("rconversation", (String)localObject3);
        az.arV();
        localObject1 = c.apR().aIn("officialaccounts");
        if (localObject1 != null) {
          break label549;
        }
        localObject1 = new am("officialaccounts");
        ((am)localObject1).eLf();
        az.arV();
        c.apR().e((am)localObject1);
      }
    }
    label549:
    for (;;)
    {
      az.arV();
      localObject3 = c.apR().eLn();
      if (bt.isNullOrNil((String)localObject3))
      {
        ad.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
        AppMethodBeat.o(20480);
        return;
      }
      az.arV();
      localObject3 = c.apO().agq((String)localObject3);
      if ((localObject3 == null) || (((du)localObject3).field_msgId == 0L))
      {
        ad.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
        AppMethodBeat.o(20480);
        return;
      }
      ((am)localObject1).aG((bl)localObject3);
      ((am)localObject1).setContent(((du)localObject3).field_talker + ":" + ((du)localObject3).field_content);
      ((am)localObject1).nK(Integer.toString(((bl)localObject3).getType()));
      az.arV();
      localObject4 = c.apR().Lu();
      if (localObject4 != null)
      {
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        PInt localPInt = new PInt();
        ((bl)localObject3).nY("officialaccounts");
        ((bl)localObject3).setContent(((ay)localObject1).field_content);
        ((bh.b)localObject4).a((bl)localObject3, localPString1, localPString2, localPInt, false);
        ((am)localObject1).nL(localPString1.value);
        ((am)localObject1).nM(localPString2.value);
        ((am)localObject1).jW(localPInt.value);
      }
      az.arV();
      c.apR().a((am)localObject1, ((ay)localObject1).field_username);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        ((Cursor)localObject2).close();
      }
      AppMethodBeat.o(20480);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ap.e
 * JD-Core Version:    0.7.0.1
 */