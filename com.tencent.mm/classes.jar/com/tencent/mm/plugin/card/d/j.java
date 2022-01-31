package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.nb;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private static nc N(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
      return null;
    }
    nc localnc = new nc();
    localnc.sKO = new LinkedList();
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
            if ((paramJSONObject != null) && ((paramJSONObject.end_time > bk.UX()) || (paramJSONObject.end_time == 0)))
            {
              localnc.sKO.add(paramJSONObject);
              break label188;
            }
          }
          else
          {
            paramJSONObject = new nb();
            paramJSONObject.ioW = localJSONObject.optString("announcement");
            paramJSONObject.bZc = localJSONObject.optString("card_id");
            paramJSONObject.end_time = localJSONObject.optInt("end_time", 0);
            paramJSONObject.sKM = localJSONObject.optInt("update_time", 0);
            paramJSONObject.sKN = localJSONObject.optString("label_wording");
            continue;
          }
        }
        else
        {
          return localnc;
        }
      }
      catch (JSONException paramJSONObject)
      {
        y.printErrStackTrace("MicroMsg.CardStickyHelper", paramJSONObject, "", new Object[0]);
      }
      y.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
      label188:
      i += 1;
    }
  }
  
  public static String a(Context paramContext, int paramInt, CardInfo paramCardInfo)
  {
    switch (paramInt % 10)
    {
    default: 
      return null;
    case 3: 
      return paramContext.getString(a.g.card_sticky_expiring_title);
    case 2: 
      return paramContext.getString(a.g.card_sticky_member_card_title);
    case 1: 
      return paramContext.getString(a.g.card_sticky_nearby_title);
    case 0: 
      return paramContext.getString(a.g.card_sticky_order_title);
    }
    return paramCardInfo.field_label_wording;
  }
  
  public static void c(LinkedList<nb> paramLinkedList, int paramInt)
  {
    if (paramLinkedList == null) {
      return;
    }
    int j = paramLinkedList.size();
    int i = 0;
    label12:
    Object localObject;
    c localc;
    String str1;
    String str2;
    int k;
    if (i < paramLinkedList.size())
    {
      localObject = (nb)paramLinkedList.get(i);
      localc = am.aAs();
      str1 = ((nb)localObject).bZc;
      str2 = ((nb)localObject).ioW;
      k = ((nb)localObject).end_time;
      if (!bk.bl(str1)) {
        break label78;
      }
      y.w("MicroMsg.CardInfoStorage", "cardId null");
    }
    for (;;)
    {
      i += 1;
      break label12;
      break;
      label78:
      localObject = "update UserCardInfo set stickyIndex=" + ((j - i) * 10 + paramInt) + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + k + " where card_id='" + str1 + "'";
      localc.dXw.gk("UserCardInfo", (String)localObject);
    }
  }
  
  public static void d(LinkedList<nb> paramLinkedList, int paramInt)
  {
    if (paramLinkedList == null) {
      return;
    }
    int i = 0;
    label7:
    c localc;
    String str;
    if (i < paramLinkedList.size())
    {
      localObject = (nb)paramLinkedList.get(i);
      localc = am.aAs();
      str = ((nb)localObject).bZc;
      if (((nb)localObject).sKN == null) {
        break label109;
      }
    }
    label109:
    for (Object localObject = ((nb)localObject).sKN;; localObject = "")
    {
      localObject = "update UserCardInfo set stickyIndex=" + paramInt + ", label_wording='" + (String)localObject + "' where card_id='" + str + "'";
      localc.dXw.gk("UserCardInfo", (String)localObject);
      i += 1;
      break label7;
      break;
    }
  }
  
  public static adu yQ(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.CardStickyHelper", "jsonRet null");
      return null;
    }
    adu localadu = new adu();
    try
    {
      paramString = new JSONObject(paramString);
      localadu.tbK = paramString.optString("layout_buff");
      localJSONObject = paramString.getJSONObject("list");
      if (localJSONObject == null) {
        break label354;
      }
      localadu.tbQ = new nd();
      localadu.tbQ.sKP = N(localJSONObject.optJSONObject("expiring_list"));
      localadu.tbQ.sKQ = N(localJSONObject.optJSONObject("member_card_list"));
      localadu.tbQ.sKR = N(localJSONObject.optJSONObject("nearby_list"));
      localadu.tbQ.sKS = N(localJSONObject.optJSONObject("label_list"));
      localadu.tbQ.sKT = N(localJSONObject.optJSONObject("first_list"));
      if ((localadu.tbQ.sKT == null) || (localadu.tbQ.sKT.sKO == null)) {
        break label277;
      }
      i = localadu.tbQ.sKT.sKO.size() - 1;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        int i;
        label277:
        boolean bool;
        label354:
        y.printErrStackTrace("MicroMsg.CardStickyHelper", paramString, "", new Object[0]);
        continue;
        i -= 1;
      }
    }
    if (i >= 0)
    {
      paramString = (nb)localadu.tbQ.sKT.sKO.get(i);
      if (!bk.bl(paramString.bZc))
      {
        paramString = am.aAs().yi(paramString.bZc);
        if ((paramString != null) && (!paramString.azf())) {
          localadu.tbQ.sKT.sKO.remove(i);
        }
      }
    }
    else
    {
      localadu.tbR = localJSONObject.optString("red_dot_wording");
      if (localJSONObject.optInt("show_red_dot", 0) == 1) {}
      for (bool = true;; bool = false)
      {
        localadu.tbS = bool;
        String str = localJSONObject.optString("title");
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        am.aAx().putValue("key_card_entrance_tips", paramString);
        localadu.tbT = localJSONObject.optInt("top_scene", 100);
        return localadu;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.j
 * JD-Core Version:    0.7.0.1
 */