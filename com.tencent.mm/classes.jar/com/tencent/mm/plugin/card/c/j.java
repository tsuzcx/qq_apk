package com.tencent.mm.plugin.card.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.mgr.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static String a(Context paramContext, int paramInt, CardInfo paramCardInfo)
  {
    AppMethodBeat.i(113809);
    switch (paramInt % 10)
    {
    default: 
      AppMethodBeat.o(113809);
      return null;
    case 3: 
      paramContext = paramContext.getString(a.g.wqw);
      AppMethodBeat.o(113809);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(a.g.wqx);
      AppMethodBeat.o(113809);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(a.g.wqy);
      AppMethodBeat.o(113809);
      return paramContext;
    case 0: 
      paramContext = paramContext.getString(a.g.wqz);
      AppMethodBeat.o(113809);
      return paramContext;
    }
    paramContext = paramCardInfo.field_label_wording;
    AppMethodBeat.o(113809);
    return paramContext;
  }
  
  private static xx aU(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113808);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(113808);
      return null;
    }
    xx localxx = new xx();
    localxx.ZgM = new LinkedList();
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
            if ((paramJSONObject == null) || ((paramJSONObject.end_time <= Util.nowSecond()) && (paramJSONObject.end_time != 0))) {
              break label196;
            }
            localxx.ZgM.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new xw();
          paramJSONObject.announcement = localJSONObject.optString("announcement");
          paramJSONObject.iaI = localJSONObject.optString("card_id");
          paramJSONObject.end_time = localJSONObject.optInt("end_time", 0);
          paramJSONObject.update_time = localJSONObject.optInt("update_time", 0);
          paramJSONObject.ZgL = localJSONObject.optString("label_wording");
          continue;
        }
        Log.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(113808);
        return localxx;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static cgz alu(String paramString)
  {
    AppMethodBeat.i(113807);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(113807);
      return null;
    }
    cgz localcgz = new cgz();
    try
    {
      paramString = new JSONObject(paramString);
      localcgz.aapD = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label359;
      }
      localcgz.aapJ = new xy();
      localcgz.aapJ.ZgN = aU(localJSONObject.optJSONObject("expiring_list"));
      localcgz.aapJ.ZgO = aU(localJSONObject.optJSONObject("member_card_list"));
      localcgz.aapJ.ZgP = aU(localJSONObject.optJSONObject("nearby_list"));
      localcgz.aapJ.ZgQ = aU(localJSONObject.optJSONObject("label_list"));
      localcgz.aapJ.ZgR = aU(localJSONObject.optJSONObject("first_list"));
      if ((localcgz.aapJ.ZgR == null) || (localcgz.aapJ.ZgR.ZgM == null)) {
        break label286;
      }
      i = localcgz.aapJ.ZgR.ZgM.size() - 1;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        int i;
        label286:
        boolean bool;
        label359:
        Log.printErrStackTrace("MicroMsg.CardStickyHelper", paramString, "", new Object[0]);
        continue;
        i -= 1;
      }
    }
    if (i >= 0)
    {
      paramString = (xw)localcgz.aapJ.ZgR.ZgM.get(i);
      if (!Util.isNullOrNil(paramString.iaI))
      {
        paramString = am.dkJ().akC(paramString.iaI);
        if ((paramString != null) && (!paramString.djq())) {
          localcgz.aapJ.ZgR.ZgM.remove(i);
        }
      }
    }
    else
    {
      localcgz.aapK = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localcgz.aapL = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.dkO().z("key_card_entrance_tips", paramString);
        localcgz.aapM = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(113807);
        return localcgz;
      }
    }
  }
  
  public static void e(LinkedList<xw> paramLinkedList, int paramInt)
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
      Object localObject = (xw)paramLinkedList.get(i);
      c localc = am.dkJ();
      String str1 = ((xw)localObject).iaI;
      String str2 = ((xw)localObject).announcement;
      int k = ((xw)localObject).end_time;
      if (Util.isNullOrNil(str1)) {
        Log.w("MicroMsg.CardInfoStorage", "cardId null");
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
  
  public static void f(LinkedList<xw> paramLinkedList, int paramInt)
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
      Object localObject = (xw)paramLinkedList.get(i);
      c localc = am.dkJ();
      String str = ((xw)localObject).iaI;
      if (((xw)localObject).ZgL != null) {}
      for (localObject = ((xw)localObject).ZgL;; localObject = "")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.j
 * JD-Core Version:    0.7.0.1
 */