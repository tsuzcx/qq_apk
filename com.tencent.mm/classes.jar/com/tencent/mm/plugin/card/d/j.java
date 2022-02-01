package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.we;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.protocal.protobuf.wg;
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
      paramContext = paramContext.getString(a.g.tlX);
      AppMethodBeat.o(113809);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(a.g.tlY);
      AppMethodBeat.o(113809);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(a.g.tlZ);
      AppMethodBeat.o(113809);
      return paramContext;
    case 0: 
      paramContext = paramContext.getString(a.g.tma);
      AppMethodBeat.o(113809);
      return paramContext;
    }
    paramContext = paramCardInfo.field_label_wording;
    AppMethodBeat.o(113809);
    return paramContext;
  }
  
  private static wf aJ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113808);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(113808);
      return null;
    }
    wf localwf = new wf();
    localwf.SiG = new LinkedList();
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
            localwf.SiG.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new we();
          paramJSONObject.announcement = localJSONObject.optString("announcement");
          paramJSONObject.fUL = localJSONObject.optString("card_id");
          paramJSONObject.end_time = localJSONObject.optInt("end_time", 0);
          paramJSONObject.update_time = localJSONObject.optInt("update_time", 0);
          paramJSONObject.SiF = localJSONObject.optString("label_wording");
          continue;
        }
        Log.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(113808);
        return localwf;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static bsg arQ(String paramString)
  {
    AppMethodBeat.i(113807);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(113807);
      return null;
    }
    bsg localbsg = new bsg();
    try
    {
      paramString = new JSONObject(paramString);
      localbsg.Tco = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label359;
      }
      localbsg.Tcu = new wg();
      localbsg.Tcu.SiH = aJ(localJSONObject.optJSONObject("expiring_list"));
      localbsg.Tcu.SiI = aJ(localJSONObject.optJSONObject("member_card_list"));
      localbsg.Tcu.SiJ = aJ(localJSONObject.optJSONObject("nearby_list"));
      localbsg.Tcu.SiK = aJ(localJSONObject.optJSONObject("label_list"));
      localbsg.Tcu.SiL = aJ(localJSONObject.optJSONObject("first_list"));
      if ((localbsg.Tcu.SiL == null) || (localbsg.Tcu.SiL.SiG == null)) {
        break label286;
      }
      i = localbsg.Tcu.SiL.SiG.size() - 1;
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
      paramString = (we)localbsg.Tcu.SiL.SiG.get(i);
      if (!Util.isNullOrNil(paramString.fUL))
      {
        paramString = am.cHs().aqX(paramString.fUL);
        if ((paramString != null) && (!paramString.cFY())) {
          localbsg.Tcu.SiL.SiG.remove(i);
        }
      }
    }
    else
    {
      localbsg.Tcv = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localbsg.Tcw = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.cHx().r("key_card_entrance_tips", paramString);
        localbsg.Tcx = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(113807);
        return localbsg;
      }
    }
  }
  
  public static void d(LinkedList<we> paramLinkedList, int paramInt)
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
      Object localObject = (we)paramLinkedList.get(i);
      c localc = am.cHs();
      String str1 = ((we)localObject).fUL;
      String str2 = ((we)localObject).announcement;
      int k = ((we)localObject).end_time;
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
  
  public static void e(LinkedList<we> paramLinkedList, int paramInt)
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
      Object localObject = (we)paramLinkedList.get(i);
      c localc = am.cHs();
      String str = ((we)localObject).fUL;
      if (((we)localObject).SiF != null) {}
      for (localObject = ((we)localObject).SiF;; localObject = "")
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