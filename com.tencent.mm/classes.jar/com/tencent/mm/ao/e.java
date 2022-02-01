package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.al;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.storage.bo;

public final class e
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final boolean nP(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20480);
    ac.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.wUl.dB(336, 14);
      com.tencent.mm.model.az.ayM();
      localObject1 = c.agw();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
      localObject2 = ((StringBuilder)localObject2).toString();
      ac.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[] { localObject2 });
      localObject2 = ((com.tencent.mm.storagebase.h)localObject1).a((String)localObject2, null, 2);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
        do
        {
          localObject4 = ((Cursor)localObject2).getString(0);
          if (!w.xo((String)localObject4)) {
            ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
          }
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        localObject3 = ((StringBuilder)localObject3).toString();
        ac.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.TRUE, localObject3 });
        ((com.tencent.mm.storagebase.h)localObject1).execSQL("rconversation", (String)localObject3);
        com.tencent.mm.model.az.ayM();
        localObject1 = c.awG().aNI("officialaccounts");
        if (localObject1 != null) {
          break label549;
        }
        localObject1 = new ap("officialaccounts");
        ((ap)localObject1).faH();
        com.tencent.mm.model.az.ayM();
        c.awG().e((ap)localObject1);
      }
    }
    label549:
    for (;;)
    {
      com.tencent.mm.model.az.ayM();
      localObject3 = c.awG().faP();
      if (bs.isNullOrNil((String)localObject3))
      {
        ac.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
        AppMethodBeat.o(20480);
        return;
      }
      com.tencent.mm.model.az.ayM();
      localObject3 = c.awD().alk((String)localObject3);
      if ((localObject3 == null) || (((dy)localObject3).field_msgId == 0L))
      {
        ac.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
        AppMethodBeat.o(20480);
        return;
      }
      ((ap)localObject1).aI((bo)localObject3);
      ((ap)localObject1).setContent(((dy)localObject3).field_talker + ":" + ((dy)localObject3).field_content);
      ((ap)localObject1).qQ(Integer.toString(((bo)localObject3).getType()));
      com.tencent.mm.model.az.ayM();
      localObject4 = c.awG().Ls();
      if (localObject4 != null)
      {
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        PInt localPInt = new PInt();
        ((bo)localObject3).re("officialaccounts");
        ((bo)localObject3).setContent(((com.tencent.mm.g.c.az)localObject1).field_content);
        ((bk.b)localObject4).a((bo)localObject3, localPString1, localPString2, localPInt, false);
        ((ap)localObject1).qR(localPString1.value);
        ((ap)localObject1).qS(localPString2.value);
        ((ap)localObject1).jU(localPInt.value);
      }
      com.tencent.mm.model.az.ayM();
      c.awG().a((ap)localObject1, ((com.tencent.mm.g.c.az)localObject1).field_username);
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