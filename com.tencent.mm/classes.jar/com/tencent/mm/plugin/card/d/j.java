package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static auz Vx(String paramString)
  {
    AppMethodBeat.i(113807);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(113807);
      return null;
    }
    auz localauz = new auz();
    try
    {
      paramString = new JSONObject(paramString);
      localauz.EMV = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label358;
      }
      localauz.ENb = new ta();
      localauz.ENb.Enh = ak(localJSONObject.optJSONObject("expiring_list"));
      localauz.ENb.Eni = ak(localJSONObject.optJSONObject("member_card_list"));
      localauz.ENb.Enj = ak(localJSONObject.optJSONObject("nearby_list"));
      localauz.ENb.Enk = ak(localJSONObject.optJSONObject("label_list"));
      localauz.ENb.Enl = ak(localJSONObject.optJSONObject("first_list"));
      if ((localauz.ENb.Enl == null) || (localauz.ENb.Enl.Eng == null)) {
        break label286;
      }
      i = localauz.ENb.Enl.Eng.size() - 1;
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
        ac.printErrStackTrace("MicroMsg.CardStickyHelper", paramString, "", new Object[0]);
        continue;
        i -= 1;
      }
    }
    if (i >= 0)
    {
      paramString = (sy)localauz.ENb.Enl.Eng.get(i);
      if (!bs.isNullOrNil(paramString.dvO))
      {
        paramString = am.bQi().UF(paramString.dvO);
        if ((paramString != null) && (!paramString.bOP())) {
          localauz.ENb.Enl.Eng.remove(i);
        }
      }
    }
    else
    {
      localauz.ENc = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localauz.ENd = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.bQn().putValue("key_card_entrance_tips", paramString);
        localauz.ENe = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(113807);
        return localauz;
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
  
  private static sz ak(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113808);
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(113808);
      return null;
    }
    sz localsz = new sz();
    localsz.Eng = new LinkedList();
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
            if ((paramJSONObject == null) || ((paramJSONObject.nUv <= bs.aNx()) && (paramJSONObject.nUv != 0))) {
              break label196;
            }
            localsz.Eng.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new sy();
          paramJSONObject.nYx = localJSONObject.optString("announcement");
          paramJSONObject.dvO = localJSONObject.optString("card_id");
          paramJSONObject.nUv = localJSONObject.optInt("end_time", 0);
          paramJSONObject.EdN = localJSONObject.optInt("update_time", 0);
          paramJSONObject.Enf = localJSONObject.optString("label_wording");
          continue;
        }
        ac.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(113808);
        return localsz;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static void d(LinkedList<sy> paramLinkedList, int paramInt)
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
      Object localObject = (sy)paramLinkedList.get(i);
      c localc = am.bQi();
      String str1 = ((sy)localObject).dvO;
      String str2 = ((sy)localObject).nYx;
      int k = ((sy)localObject).nUv;
      if (bs.isNullOrNil(str1)) {
        ac.w("MicroMsg.CardInfoStorage", "cardId null");
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
  
  public static void e(LinkedList<sy> paramLinkedList, int paramInt)
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
      Object localObject = (sy)paramLinkedList.get(i);
      c localc = am.bQi();
      String str = ((sy)localObject).dvO;
      if (((sy)localObject).Enf != null) {}
      for (localObject = ((sy)localObject).Enf;; localObject = "")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.j
 * JD-Core Version:    0.7.0.1
 */