package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.protocal.protobuf.we;
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
      paramContext = paramContext.getString(2131757179);
      AppMethodBeat.o(113809);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131757180);
      AppMethodBeat.o(113809);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(2131757181);
      AppMethodBeat.o(113809);
      return paramContext;
    case 0: 
      paramContext = paramContext.getString(2131757182);
      AppMethodBeat.o(113809);
      return paramContext;
    }
    paramContext = paramCardInfo.field_label_wording;
    AppMethodBeat.o(113809);
    return paramContext;
  }
  
  private static wd aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113808);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(113808);
      return null;
    }
    wd localwd = new wd();
    localwd.Lhs = new LinkedList();
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
            if ((paramJSONObject == null) || ((paramJSONObject.pSb <= Util.nowSecond()) && (paramJSONObject.pSb != 0))) {
              break label196;
            }
            localwd.Lhs.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new wc();
          paramJSONObject.pWh = localJSONObject.optString("announcement");
          paramJSONObject.eaO = localJSONObject.optString("card_id");
          paramJSONObject.pSb = localJSONObject.optInt("end_time", 0);
          paramJSONObject.KWR = localJSONObject.optInt("update_time", 0);
          paramJSONObject.Lhr = localJSONObject.optString("label_wording");
          continue;
        }
        Log.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(113808);
        return localwd;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static bkx akd(String paramString)
  {
    AppMethodBeat.i(113807);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(113807);
      return null;
    }
    bkx localbkx = new bkx();
    try
    {
      paramString = new JSONObject(paramString);
      localbkx.LTF = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label358;
      }
      localbkx.LTL = new we();
      localbkx.LTL.Lht = aF(localJSONObject.optJSONObject("expiring_list"));
      localbkx.LTL.Lhu = aF(localJSONObject.optJSONObject("member_card_list"));
      localbkx.LTL.Lhv = aF(localJSONObject.optJSONObject("nearby_list"));
      localbkx.LTL.Lhw = aF(localJSONObject.optJSONObject("label_list"));
      localbkx.LTL.Lhx = aF(localJSONObject.optJSONObject("first_list"));
      if ((localbkx.LTL.Lhx == null) || (localbkx.LTL.Lhx.Lhs == null)) {
        break label286;
      }
      i = localbkx.LTL.Lhx.Lhs.size() - 1;
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
        Log.printErrStackTrace("MicroMsg.CardStickyHelper", paramString, "", new Object[0]);
        continue;
        i -= 1;
      }
    }
    if (i >= 0)
    {
      paramString = (wc)localbkx.LTL.Lhx.Lhs.get(i);
      if (!Util.isNullOrNil(paramString.eaO))
      {
        paramString = am.ctQ().ajk(paramString.eaO);
        if ((paramString != null) && (!paramString.csx())) {
          localbkx.LTL.Lhx.Lhs.remove(i);
        }
      }
    }
    else
    {
      localbkx.LTM = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localbkx.LTN = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.ctV().putValue("key_card_entrance_tips", paramString);
        localbkx.LTO = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(113807);
        return localbkx;
      }
    }
  }
  
  public static void d(LinkedList<wc> paramLinkedList, int paramInt)
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
      Object localObject = (wc)paramLinkedList.get(i);
      c localc = am.ctQ();
      String str1 = ((wc)localObject).eaO;
      String str2 = ((wc)localObject).pWh;
      int k = ((wc)localObject).pSb;
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
  
  public static void e(LinkedList<wc> paramLinkedList, int paramInt)
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
      Object localObject = (wc)paramLinkedList.get(i);
      c localc = am.ctQ();
      String str = ((wc)localObject).eaO;
      if (((wc)localObject).Lhr != null) {}
      for (localObject = ((wc)localObject).Lhr;; localObject = "")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.j
 * JD-Core Version:    0.7.0.1
 */