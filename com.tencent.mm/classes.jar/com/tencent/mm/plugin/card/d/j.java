package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static ayx Zg(String paramString)
  {
    AppMethodBeat.i(113807);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(113807);
      return null;
    }
    ayx localayx = new ayx();
    try
    {
      paramString = new JSONObject(paramString);
      localayx.GvZ = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label358;
      }
      localayx.Gwf = new uv();
      localayx.Gwf.FUq = an(localJSONObject.optJSONObject("expiring_list"));
      localayx.Gwf.FUr = an(localJSONObject.optJSONObject("member_card_list"));
      localayx.Gwf.FUs = an(localJSONObject.optJSONObject("nearby_list"));
      localayx.Gwf.FUt = an(localJSONObject.optJSONObject("label_list"));
      localayx.Gwf.FUu = an(localJSONObject.optJSONObject("first_list"));
      if ((localayx.Gwf.FUu == null) || (localayx.Gwf.FUu.FUp == null)) {
        break label286;
      }
      i = localayx.Gwf.FUu.FUp.size() - 1;
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
        ad.printErrStackTrace("MicroMsg.CardStickyHelper", paramString, "", new Object[0]);
        continue;
        i -= 1;
      }
    }
    if (i >= 0)
    {
      paramString = (ut)localayx.Gwf.FUu.FUp.get(i);
      if (!bt.isNullOrNil(paramString.dHX))
      {
        paramString = am.bUN().Yo(paramString.dHX);
        if ((paramString != null) && (!paramString.bTu())) {
          localayx.Gwf.FUu.FUp.remove(i);
        }
      }
    }
    else
    {
      localayx.Gwg = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localayx.Gwh = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.bUS().putValue("key_card_entrance_tips", paramString);
        localayx.Gwi = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(113807);
        return localayx;
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
  
  private static uu an(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113808);
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(113808);
      return null;
    }
    uu localuu = new uu();
    localuu.FUp = new LinkedList();
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
            if ((paramJSONObject == null) || ((paramJSONObject.oxQ <= bt.aQJ()) && (paramJSONObject.oxQ != 0))) {
              break label196;
            }
            localuu.FUp.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new ut();
          paramJSONObject.oBR = localJSONObject.optString("announcement");
          paramJSONObject.dHX = localJSONObject.optString("card_id");
          paramJSONObject.oxQ = localJSONObject.optInt("end_time", 0);
          paramJSONObject.FKm = localJSONObject.optInt("update_time", 0);
          paramJSONObject.FUo = localJSONObject.optString("label_wording");
          continue;
        }
        ad.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(113808);
        return localuu;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static void d(LinkedList<ut> paramLinkedList, int paramInt)
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
      Object localObject = (ut)paramLinkedList.get(i);
      c localc = am.bUN();
      String str1 = ((ut)localObject).dHX;
      String str2 = ((ut)localObject).oBR;
      int k = ((ut)localObject).oxQ;
      if (bt.isNullOrNil(str1)) {
        ad.w("MicroMsg.CardInfoStorage", "cardId null");
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
  
  public static void e(LinkedList<ut> paramLinkedList, int paramInt)
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
      Object localObject = (ut)paramLinkedList.get(i);
      c localc = am.bUN();
      String str = ((ut)localObject).dHX;
      if (((ut)localObject).FUo != null) {}
      for (localObject = ((ut)localObject).FUo;; localObject = "")
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