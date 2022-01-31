package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class h
{
  public static String a(LinkedList<e> paramLinkedList, boolean paramBoolean, int paramInt)
  {
    if (paramLinkedList.size() == 0)
    {
      y.e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
      return "";
    }
    y.i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + paramBoolean + " scene:" + paramInt);
    JSONStringer localJSONStringer = new JSONStringer();
    if (paramInt == 8) {}
    for (;;)
    {
      e locale;
      try
      {
        localJSONStringer.object();
        localJSONStringer.key("card_list");
        localJSONStringer.array();
        Iterator localIterator = paramLinkedList.iterator();
        if (!localIterator.hasNext()) {
          break label312;
        }
        locale = (e)localIterator.next();
        localJSONStringer.object();
        if (paramInt == 26)
        {
          paramLinkedList = "cardId";
          localJSONStringer.key(paramLinkedList);
          localJSONStringer.value(locale.iln);
          if (paramInt != 26) {
            break label335;
          }
          paramLinkedList = "cardExt";
          localJSONStringer.key(paramLinkedList);
          if (locale.bZd != null) {
            break label258;
          }
          paramLinkedList = "";
          localJSONStringer.value(paramLinkedList);
          if (paramInt != 26) {
            break label341;
          }
          paramLinkedList = "isSuccess";
          localJSONStringer.key(paramLinkedList);
          if (!paramBoolean) {
            break label275;
          }
          if (paramInt != 26) {
            break label267;
          }
          paramLinkedList = Boolean.valueOf(true);
          localJSONStringer.value(paramLinkedList);
          localJSONStringer.key("code");
          if (locale.code != null) {
            break label303;
          }
          paramLinkedList = "";
          localJSONStringer.value(paramLinkedList);
          localJSONStringer.endObject();
          continue;
        }
        paramLinkedList = "card_id";
      }
      catch (Exception paramLinkedList)
      {
        y.printErrStackTrace("MicroMsg.CardListItemParser", paramLinkedList, "", new Object[0]);
        return "";
      }
      continue;
      label258:
      paramLinkedList = locale.bZd;
      continue;
      label267:
      paramLinkedList = Integer.valueOf(1);
      continue;
      label275:
      if (paramInt == 26) {}
      for (paramLinkedList = Boolean.valueOf(false);; paramLinkedList = Integer.valueOf(0))
      {
        localJSONStringer.value(paramLinkedList);
        break;
      }
      label303:
      paramLinkedList = locale.code;
      continue;
      label312:
      localJSONStringer.endArray();
      if (paramInt == 8) {
        localJSONStringer.endObject();
      }
      paramLinkedList = localJSONStringer.toString();
      return paramLinkedList;
      label335:
      paramLinkedList = "card_ext";
      continue;
      label341:
      paramLinkedList = "is_succ";
    }
  }
  
  public static ArrayList<lw> bn(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
      return null;
    }
    if ((paramInt == 8) || (paramInt == 0)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("card_list");
        if ((paramString != null) && (paramString.length() != 0)) {
          break;
        }
        y.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
        return null;
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("MicroMsg.CardListItemParser", paramString, "", new Object[0]);
        return null;
      }
      if (paramInt == 26) {
        paramString = new JSONArray(paramString);
      } else {
        paramString = new JSONArray(paramString);
      }
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    JSONObject localJSONObject;
    lw locallw;
    if (i < paramString.length())
    {
      localJSONObject = paramString.optJSONObject(i);
      locallw = new lw();
      if (paramInt != 26) {
        break label204;
      }
    }
    label204:
    for (String str = "cardId";; str = "card_id")
    {
      locallw.iln = localJSONObject.optString(str);
      if (paramInt == 26) {}
      for (str = "cardExt";; str = "card_ext")
      {
        locallw.bZd = localJSONObject.optString(str);
        localArrayList.add(locallw);
        i += 1;
        break;
      }
      return localArrayList;
    }
  }
  
  public static String bo(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
      return null;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONObject(paramString).optJSONArray("card_list");
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        y.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.CardListItemParser", paramString, "", new Object[0]);
      return "";
    }
    JSONStringer localJSONStringer = new JSONStringer();
    localJSONStringer.array();
    int i = 0;
    JSONObject localJSONObject;
    label113:
    StringBuilder localStringBuilder;
    if (i < localJSONArray.length())
    {
      localJSONObject = localJSONArray.optJSONObject(i);
      localJSONStringer.object();
      if (paramInt != 26) {
        break label354;
      }
      paramString = "cardId";
      localJSONStringer.key(paramString);
      localJSONStringer.value(localJSONObject.optString("card_id"));
      if (paramInt != 26) {
        break label360;
      }
      paramString = "cardExt";
      label142:
      localJSONStringer.key(paramString);
      localJSONStringer.value(localJSONObject.optString("card_ext"));
      if (paramInt != 26) {
        break label366;
      }
      paramString = "isSuccess";
      label171:
      localJSONStringer.key(paramString);
      if (paramInt == 26) {
        if (localJSONObject.optInt("is_succ") == 1)
        {
          localJSONStringer.value(true);
          label202:
          localJSONStringer.key("code");
          if (TextUtils.isEmpty(localJSONObject.optString("encrypt_code"))) {
            break label324;
          }
          localJSONStringer.value(localJSONObject.optString("encrypt_code"));
          label236:
          localJSONStringer.endObject();
          localStringBuilder = new StringBuilder("parseJsonToArray item").append(i).append("  is_succ:");
          if (paramInt != 26) {
            break label372;
          }
        }
      }
    }
    label324:
    label354:
    label360:
    label366:
    label372:
    for (paramString = "isSuccess";; paramString = "is_succ")
    {
      y.i("MicroMsg.CardListItemParser", localJSONObject.optInt(paramString));
      i += 1;
      break;
      localJSONStringer.value(false);
      break label202;
      localJSONStringer.value(localJSONObject.optInt("is_succ"));
      break label202;
      localJSONStringer.value(localJSONObject.optString("code"));
      break label236;
      localJSONStringer.endArray();
      paramString = localJSONStringer.toString();
      return paramString;
      paramString = "card_id";
      break label113;
      paramString = "card_ext";
      break label142;
      paramString = "is_succ";
      break label171;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.h
 * JD-Core Version:    0.7.0.1
 */