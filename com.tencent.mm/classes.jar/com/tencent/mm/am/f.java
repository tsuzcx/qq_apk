package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;

public final class f
  extends ai
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(16434);
    ab.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.qsU.cT(336, 14);
      aw.aaz();
      localObject1 = c.Rq();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
      localObject2 = ((StringBuilder)localObject2).toString();
      ab.d("MicroMsg.ConversationDataTransfer", "select sql %s", new Object[] { localObject2 });
      localObject2 = ((com.tencent.mm.cg.h)localObject1).a((String)localObject2, null, 2);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
        do
        {
          localObject4 = ((Cursor)localObject2).getString(0);
          if (!t.oB((String)localObject4)) {
            ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
          }
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        localObject3 = ((StringBuilder)localObject3).toString();
        ab.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.TRUE, localObject3 });
        ((com.tencent.mm.cg.h)localObject1).execSQL("rconversation", (String)localObject3);
        aw.aaz();
        localObject1 = c.YF().arH("officialaccounts");
        if (localObject1 != null) {
          break label549;
        }
        localObject1 = new ak("officialaccounts");
        ((ak)localObject1).dxc();
        aw.aaz();
        c.YF().d((ak)localObject1);
      }
    }
    label549:
    for (;;)
    {
      aw.aaz();
      localObject3 = c.YF().dxl();
      if (bo.isNullOrNil((String)localObject3))
      {
        ab.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
        AppMethodBeat.o(16434);
        return;
      }
      aw.aaz();
      localObject3 = c.YC().Tm((String)localObject3);
      if ((localObject3 == null) || (((dd)localObject3).field_msgId == 0L))
      {
        ab.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
        AppMethodBeat.o(16434);
        return;
      }
      ((ak)localObject1).aq((bi)localObject3);
      ((ak)localObject1).setContent(((dd)localObject3).field_talker + ":" + ((dd)localObject3).field_content);
      ((ak)localObject1).jV(Integer.toString(((bi)localObject3).getType()));
      aw.aaz();
      localObject4 = c.YF().BX();
      if (localObject4 != null)
      {
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        PInt localPInt = new PInt();
        ((bi)localObject3).kj("officialaccounts");
        ((bi)localObject3).setContent(((au)localObject1).field_content);
        ((be.b)localObject4).a((bi)localObject3, localPString1, localPString2, localPInt, false);
        ((ak)localObject1).jW(localPString1.value);
        ((ak)localObject1).jX(localPString2.value);
        ((ak)localObject1).hM(localPInt.value);
      }
      aw.aaz();
      c.YF().a((ak)localObject1, ((au)localObject1).field_username);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        ((Cursor)localObject2).close();
      }
      AppMethodBeat.o(16434);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.f
 * JD-Core Version:    0.7.0.1
 */