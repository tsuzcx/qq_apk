package com.tencent.mm.plugin.card.sharecard.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

final class b$1
  implements Runnable
{
  b$1(String paramString, ak paramak) {}
  
  public final void run()
  {
    Object localObject1 = null;
    AppMethodBeat.i(87982);
    ab.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
    Object localObject2 = am.bcl();
    Object localObject3 = this.kpJ;
    ab.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(" where ( status=0) ");
    ((StringBuilder)localObject4).append(" AND (card_tp_id = '" + (String)localObject3 + "' )");
    ((StringBuilder)localObject4).append(" order by share_time desc ");
    localObject3 = "select * from ShareCardInfo" + ((StringBuilder)localObject4).toString();
    localObject3 = ((k)localObject2).db.a((String)localObject3, null, 2);
    if (localObject3 == null)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
      ab.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        ab.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
        AppMethodBeat.o(87982);
      }
    }
    else
    {
      localObject2 = new ArrayList();
      localObject4 = new ArrayList();
    }
    label181:
    label445:
    label448:
    for (;;)
    {
      ShareCardInfo localShareCardInfo;
      int i;
      if (((Cursor)localObject3).moveToNext())
      {
        localShareCardInfo = new ShareCardInfo();
        localShareCardInfo.convertFrom((Cursor)localObject3);
        if (!((ArrayList)localObject4).contains(localShareCardInfo.field_from_username))
        {
          localObject1 = new r();
          ((r)localObject1).kml = localShareCardInfo.field_card_tp_id;
          ((r)localObject1).kqi = localShareCardInfo.field_from_username;
          ((r)localObject1).kqk = new ArrayList();
          ((r)localObject1).kqk.add(localShareCardInfo.field_card_id);
          ((r)localObject1).kqj = 1;
          ((ArrayList)localObject2).add(localObject1);
          ((ArrayList)localObject4).add(localShareCardInfo.field_from_username);
          continue;
        }
        i = 0;
        localObject1 = null;
        if (i >= ((ArrayList)localObject2).size()) {
          break label445;
        }
        localObject1 = (r)((ArrayList)localObject2).get(i);
        if ((localShareCardInfo.field_from_username == null) || (!localShareCardInfo.field_from_username.equals(((r)localObject1).kqi))) {}
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label448;
        }
        ((r)localObject1).kqk.add(0, localShareCardInfo.field_card_id);
        ((r)localObject1).kqj += 1;
        ((ArrayList)localObject2).set(i, localObject1);
        break label181;
        i += 1;
        break label299;
        ((Cursor)localObject3).close();
        localObject1 = localObject2;
        break;
        if (((ArrayList)localObject1).get(0) != null) {
          ((r)((ArrayList)localObject1).get(0)).kql = true;
        }
        ab.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
        this.kpK.post(new b.1.1(this, (ArrayList)localObject1));
        AppMethodBeat.o(87982);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.b.1
 * JD-Core Version:    0.7.0.1
 */