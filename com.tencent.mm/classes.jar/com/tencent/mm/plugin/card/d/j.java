package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static arv Rl(String paramString)
  {
    AppMethodBeat.i(113807);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.CardStickyHelper", "jsonRet null");
      AppMethodBeat.o(113807);
      return null;
    }
    arv localarv = new arv();
    try
    {
      paramString = new JSONObject(paramString);
      localarv.DrT = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label358;
      }
      localarv.DrZ = new sq();
      localarv.DrZ.CUx = ak(localJSONObject.optJSONObject("expiring_list"));
      localarv.DrZ.CUy = ak(localJSONObject.optJSONObject("member_card_list"));
      localarv.DrZ.CUz = ak(localJSONObject.optJSONObject("nearby_list"));
      localarv.DrZ.CUA = ak(localJSONObject.optJSONObject("label_list"));
      localarv.DrZ.CUB = ak(localJSONObject.optJSONObject("first_list"));
      if ((localarv.DrZ.CUB == null) || (localarv.DrZ.CUB.CUw == null)) {
        break label286;
      }
      i = localarv.DrZ.CUB.CUw.size() - 1;
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
      paramString = (so)localarv.DrZ.CUB.CUw.get(i);
      if (!bt.isNullOrNil(paramString.dyc))
      {
        paramString = am.bIV().Qt(paramString.dyc);
        if ((paramString != null) && (!paramString.bHC())) {
          localarv.DrZ.CUB.CUw.remove(i);
        }
      }
    }
    else
    {
      localarv.Dsa = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localarv.Dsb = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.bJa().putValue("key_card_entrance_tips", paramString);
        localarv.Dsc = localJSONObject.optInt("top_scene", 100);
        AppMethodBeat.o(113807);
        return localarv;
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
  
  private static sp ak(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(113808);
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      AppMethodBeat.o(113808);
      return null;
    }
    sp localsp = new sp();
    localsp.CUw = new LinkedList();
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
            if ((paramJSONObject == null) || ((paramJSONObject.nrv <= bt.aGK()) && (paramJSONObject.nrv != 0))) {
              break label196;
            }
            localsp.CUw.add(paramJSONObject);
            break label203;
          }
          paramJSONObject = new so();
          paramJSONObject.nvx = localJSONObject.optString("announcement");
          paramJSONObject.dyc = localJSONObject.optString("card_id");
          paramJSONObject.nrv = localJSONObject.optInt("end_time", 0);
          paramJSONObject.CLl = localJSONObject.optInt("update_time", 0);
          paramJSONObject.CUv = localJSONObject.optString("label_wording");
          continue;
        }
        ad.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
        AppMethodBeat.o(113808);
        return localsp;
      }
      label196:
      label203:
      i += 1;
    }
  }
  
  public static void d(LinkedList<so> paramLinkedList, int paramInt)
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
      Object localObject = (so)paramLinkedList.get(i);
      c localc = am.bIV();
      String str1 = ((so)localObject).dyc;
      String str2 = ((so)localObject).nvx;
      int k = ((so)localObject).nrv;
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
  
  public static void e(LinkedList<so> paramLinkedList, int paramInt)
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
      Object localObject = (so)paramLinkedList.get(i);
      c localc = am.bIV();
      String str = ((so)localObject).dyc;
      if (((so)localObject).CUv != null) {}
      for (localObject = ((so)localObject).CUv;; localObject = "")
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