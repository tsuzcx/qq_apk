package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static aio IA(String paramString)
  {
    AppMethodBeat.i(88879);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(88879);
      return null;
    }
    aio localaio = new aio();
    try
    {
      paramString = new JSONObject(paramString);
      localaio.xad = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label358;
      }
      localaio.xaj = new qf();
      localaio.xaj.wIE = U(localJSONObject.optJSONObject("expiring_list"));
      localaio.xaj.wIF = U(localJSONObject.optJSONObject("member_card_list"));
      localaio.xaj.wIG = U(localJSONObject.optJSONObject("nearby_list"));
      localaio.xaj.wIH = U(localJSONObject.optJSONObject("label_list"));
      localaio.xaj.wII = U(localJSONObject.optJSONObject("first_list"));
      if ((localaio.xaj.wII == null) || (localaio.xaj.wII.wID == null)) {
        break label286;
      }
      i = localaio.xaj.wII.wID.size() - 1;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        int i;
        label286:
        boolean bool;
        label358:
        ab.printErrStackTrace("MicroMsg.CardStickyHelper", paramString, "", new Object[0]);
        continue;
        i -= 1;
      }
    }
    if (i >= 0)
    {
      paramString = (qd)localaio.xaj.wII.wID.get(i);
      if (!bo.isNullOrNil(paramString.cHn))
      {
        paramString = am.bcd().HJ(paramString.cHn);
        if ((paramString != null) && (!paramString.baL())) {
          localaio.xaj.wII.wID.remove(i);
        }
      }
    }
    else
    {
      localaio.xak = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localaio.xal = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.bci().putValue("key_card_entrance_tips", paramString);
        localaio.xam = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(88879);
        return localaio;
      }
    }
  }
  
  private static qe U(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(88880);
    if (paramJSONObject == null)
    {
      ab.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(88880);
      return null;
    }
    qe localqe = new qe();
    localqe.wID = new LinkedList();
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("item_list");
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null)
          {
            paramJSONObject = null;
            if ((paramJSONObject == null) || ((paramJSONObject.kmq <= bo.aox()) && (paramJSONObject.kmq != 0))) {
              break label196;
            }
            localqe.wID.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new qd();
          paramJSONObject.kqd = localJSONObject.optString("announcement");
          paramJSONObject.cHn = localJSONObject.optString("card_id");
          paramJSONObject.kmq = localJSONObject.optInt("end_time", 0);
          paramJSONObject.wAo = localJSONObject.optInt("update_time", 0);
          paramJSONObject.wIC = localJSONObject.optString("label_wording");
          continue;
        }
        ab.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(88880);
        return localqe;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static String a(Context paramContext, int paramInt, CardInfo paramCardInfo)
  {
    AppMethodBeat.i(88881);
    switch (paramInt % 10)
    {
    default: 
      AppMethodBeat.o(88881);
      return null;
    case 3: 
      paramContext = paramContext.getString(2131298067);
      AppMethodBeat.o(88881);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131298068);
      AppMethodBeat.o(88881);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(2131298069);
      AppMethodBeat.o(88881);
      return paramContext;
    case 0: 
      paramContext = paramContext.getString(2131298070);
      AppMethodBeat.o(88881);
      return paramContext;
    }
    paramContext = paramCardInfo.field_label_wording;
    AppMethodBeat.o(88881);
    return paramContext;
  }
  
  public static void c(LinkedList<qd> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(88877);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(88877);
      return;
    }
    int j = paramLinkedList.size();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject = (qd)paramLinkedList.get(i);
      c localc = am.bcd();
      String str1 = ((qd)localObject).cHn;
      String str2 = ((qd)localObject).kqd;
      int k = ((qd)localObject).kmq;
      if (bo.isNullOrNil(str1)) {
        ab.w("MicroMsg.CardInfoStorage", "cardId null");
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = "update UserCardInfo set stickyIndex=" + ((j - i) * 10 + paramInt) + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + k + " where card_id='" + str1 + "'";
        localc.db.execSQL("UserCardInfo", (String)localObject);
      }
    }
    AppMethodBeat.o(88877);
  }
  
  public static void d(LinkedList<qd> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(88878);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(88878);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject = (qd)paramLinkedList.get(i);
      c localc = am.bcd();
      String str = ((qd)localObject).cHn;
      if (((qd)localObject).wIC != null) {}
      for (localObject = ((qd)localObject).wIC;; localObject = "")
      {
        localObject = "update UserCardInfo set stickyIndex=" + paramInt + ", label_wording='" + (String)localObject + "' where card_id='" + str + "'";
        localc.db.execSQL("UserCardInfo", (String)localObject);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(88878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.j
 * JD-Core Version:    0.7.0.1
 */