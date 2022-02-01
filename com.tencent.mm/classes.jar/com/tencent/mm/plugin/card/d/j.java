package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static azn ZX(String paramString)
  {
    AppMethodBeat.i(113807);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(113807);
      return null;
    }
    azn localazn = new azn();
    try
    {
      paramString = new JSONObject(paramString);
      localazn.GPy = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label358;
      }
      localazn.GPE = new ux();
      localazn.GPE.GmP = an(localJSONObject.optJSONObject("expiring_list"));
      localazn.GPE.GmQ = an(localJSONObject.optJSONObject("member_card_list"));
      localazn.GPE.GmR = an(localJSONObject.optJSONObject("nearby_list"));
      localazn.GPE.GmS = an(localJSONObject.optJSONObject("label_list"));
      localazn.GPE.GmT = an(localJSONObject.optJSONObject("first_list"));
      if ((localazn.GPE.GmT == null) || (localazn.GPE.GmT.GmO == null)) {
        break label286;
      }
      i = localazn.GPE.GmT.GmO.size() - 1;
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
        ae.printErrStackTrace("MicroMsg.CardStickyHelper", paramString, "", new Object[0]);
        continue;
        i -= 1;
      }
    }
    if (i >= 0)
    {
      paramString = (uv)localazn.GPE.GmT.GmO.get(i);
      if (!bu.isNullOrNil(paramString.dJb))
      {
        paramString = am.bWc().Zf(paramString.dJb);
        if ((paramString != null) && (!paramString.bUJ())) {
          localazn.GPE.GmT.GmO.remove(i);
        }
      }
    }
    else
    {
      localazn.GPF = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localazn.GPG = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.bWh().putValue("key_card_entrance_tips", paramString);
        localazn.GPH = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(113807);
        return localazn;
      }
    }
  }
  
  public static String a(Context paramContext, int paramInt, CardInfo paramCardInfo)
  {
    AppMethodBeat.i(113809);
    switch (paramInt % 10)
    {
    default: 
      AppMethodBeat.o(113809);
      return null;
    case 3: 
      paramContext = paramContext.getString(2131757009);
      AppMethodBeat.o(113809);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131757010);
      AppMethodBeat.o(113809);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(2131757011);
      AppMethodBeat.o(113809);
      return paramContext;
    case 0: 
      paramContext = paramContext.getString(2131757012);
      AppMethodBeat.o(113809);
      return paramContext;
    }
    paramContext = paramCardInfo.field_label_wording;
    AppMethodBeat.o(113809);
    return paramContext;
  }
  
  private static uw an(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113808);
    if (paramJSONObject == null)
    {
      ae.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(113808);
      return null;
    }
    uw localuw = new uw();
    localuw.GmO = new LinkedList();
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
            if ((paramJSONObject == null) || ((paramJSONObject.oEs <= bu.aRi()) && (paramJSONObject.oEs != 0))) {
              break label196;
            }
            localuw.GmO.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new uv();
          paramJSONObject.oIt = localJSONObject.optString("announcement");
          paramJSONObject.dJb = localJSONObject.optString("card_id");
          paramJSONObject.oEs = localJSONObject.optInt("end_time", 0);
          paramJSONObject.GcL = localJSONObject.optInt("update_time", 0);
          paramJSONObject.GmN = localJSONObject.optString("label_wording");
          continue;
        }
        ae.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        ae.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(113808);
        return localuw;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static void d(LinkedList<uv> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(113805);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(113805);
      return;
    }
    int j = paramLinkedList.size();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject = (uv)paramLinkedList.get(i);
      c localc = am.bWc();
      String str1 = ((uv)localObject).dJb;
      String str2 = ((uv)localObject).oIt;
      int k = ((uv)localObject).oEs;
      if (bu.isNullOrNil(str1)) {
        ae.w("MicroMsg.CardInfoStorage", "cardId null");
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = "update UserCardInfo set stickyIndex=" + ((j - i) * 10 + paramInt) + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + k + " where card_id='" + str1 + "'";
        localc.db.execSQL("UserCardInfo", (String)localObject);
      }
    }
    AppMethodBeat.o(113805);
  }
  
  public static void e(LinkedList<uv> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(113806);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(113806);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject = (uv)paramLinkedList.get(i);
      c localc = am.bWc();
      String str = ((uv)localObject).dJb;
      if (((uv)localObject).GmN != null) {}
      for (localObject = ((uv)localObject).GmN;; localObject = "")
      {
        localObject = "update UserCardInfo set stickyIndex=" + paramInt + ", label_wording='" + (String)localObject + "' where card_id='" + str + "'";
        localc.db.execSQL("UserCardInfo", (String)localObject);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(113806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.j
 * JD-Core Version:    0.7.0.1
 */