package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.cc;

public final class e
  extends com.tencent.mm.model.au
{
  public final String getTag()
  {
    return "MicroMsg.ConversationDataTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(20480);
    Log.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(336, 14);
      bh.bCz();
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
          if (!com.tencent.mm.storage.au.bwx((String)localObject4)) {
            ((StringBuilder)localObject3).append(" or username = '").append((String)localObject4).append("'");
          }
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        localObject3 = ((StringBuilder)localObject3).toString();
        Log.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", new Object[] { Boolean.TRUE, localObject3 });
        ((com.tencent.mm.storagebase.h)localObject1).execSQL("rconversation", (String)localObject3);
        bh.bCz();
        localObject1 = c.bzG().bxM("officialaccounts");
        if (localObject1 != null) {
          break label564;
        }
        localObject1 = new bb("officialaccounts");
        ((bb)localObject1).jaJ();
        bh.bCz();
        c.bzG().h((bb)localObject1);
      }
    }
    label564:
    for (;;)
    {
      bh.bCz();
      localObject3 = c.bzG().jaR();
      if (Util.isNullOrNil((String)localObject3))
      {
        Log.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
        AppMethodBeat.o(20480);
        return;
      }
      bh.bCz();
      localObject3 = c.bzD().aLG((String)localObject3);
      if ((localObject3 == null) || (((fi)localObject3).field_msgId == 0L))
      {
        Log.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
        AppMethodBeat.o(20480);
        return;
      }
      ((bb)localObject1).bG((cc)localObject3);
      ((bb)localObject1).setContent(((fi)localObject3).field_talker + ":" + ((fi)localObject3).field_content);
      ((bb)localObject1).BE(Integer.toString(((cc)localObject3).getType()));
      bh.bCz();
      localObject4 = c.bzG().aDH();
      if (localObject4 != null)
      {
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        PInt localPInt = new PInt();
        ((cc)localObject3).BS("officialaccounts");
        ((cc)localObject3).setContent(((bd)localObject1).field_content);
        ((by.b)localObject4).a((cc)localObject3, localPString1, localPString2, localPInt, false);
        ((bb)localObject1).BF(localPString1.value);
        ((bb)localObject1).BG(localPString2.value);
        ((bb)localObject1).pJ(localPInt.value);
      }
      bh.bCz();
      c.bzG().c((bb)localObject1, ((bd)localObject1).field_username);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        ((Cursor)localObject2).close();
      }
      AppMethodBeat.o(20480);
      return;
    }
  }
  
  public final boolean vc(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604372991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ap.e
 * JD-Core Version:    0.7.0.1
 */