package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(88874);
    if (paramLinkedList.size() == 0)
    {
      ab.e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
      AppMethodBeat.o(88874);
      return "";
    }
    ab.i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + paramBoolean + " scene:" + paramInt);
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
          break label325;
        }
        locale = (e)localIterator.next();
        localJSONStringer.object();
        if (paramInt == 26)
        {
          paramLinkedList = "cardId";
          localJSONStringer.key(paramLinkedList);
          localJSONStringer.value(locale.kml);
          if (paramInt != 26) {
            break label353;
          }
          paramLinkedList = "cardExt";
          localJSONStringer.key(paramLinkedList);
          if (locale.cHo != null) {
            break label272;
          }
          paramLinkedList = "";
          localJSONStringer.value(paramLinkedList);
          if (paramInt != 26) {
            break label359;
          }
          paramLinkedList = "isSuccess";
          localJSONStringer.key(paramLinkedList);
          if (!paramBoolean) {
            break label289;
          }
          if (paramInt != 26) {
            break label281;
          }
          paramLinkedList = Boolean.TRUE;
          localJSONStringer.value(paramLinkedList);
          localJSONStringer.key("code");
          if (locale.code != null) {
            break label316;
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
        ab.printErrStackTrace("MicroMsg.CardListItemParser", paramLinkedList, "", new Object[0]);
        AppMethodBeat.o(88874);
        return "";
      }
      continue;
      label272:
      paramLinkedList = locale.cHo;
      continue;
      label281:
      paramLinkedList = Integer.valueOf(1);
      continue;
      label289:
      if (paramInt == 26) {}
      for (paramLinkedList = Boolean.FALSE;; paramLinkedList = Integer.valueOf(0))
      {
        localJSONStringer.value(paramLinkedList);
        break;
      }
      label316:
      paramLinkedList = locale.code;
      continue;
      label325:
      localJSONStringer.endArray();
      if (paramInt == 8) {
        localJSONStringer.endObject();
      }
      paramLinkedList = localJSONStringer.toString();
      AppMethodBeat.o(88874);
      return paramLinkedList;
      label353:
      paramLinkedList = "card_ext";
      continue;
      label359:
      paramLinkedList = "is_succ";
    }
  }
  
  public static ArrayList<ot> bQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(88873);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
      AppMethodBeat.o(88873);
      return null;
    }
    if ((paramInt == 8) || (paramInt == 0)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("card_list");
        if ((paramString == null) || (paramString.length() == 0))
        {
          ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
          AppMethodBeat.o(88873);
          return null;
          if (paramInt == 26)
          {
            paramString = new JSONArray(paramString);
            continue;
          }
          paramString = new JSONArray(paramString);
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          ot localot = new ot();
          if (paramInt == 26)
          {
            str = "cardId";
            localot.kml = localJSONObject.optString(str);
            if (paramInt == 26)
            {
              str = "cardExt";
              localot.cHo = localJSONObject.optString(str);
              localArrayList.add(localot);
              i += 1;
              continue;
            }
            str = "card_ext";
            continue;
          }
        }
        else
        {
          AppMethodBeat.o(88873);
          return localArrayList;
        }
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.CardListItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(88873);
        return null;
      }
      String str = "card_id";
    }
  }
  
  public static String bR(String paramString, int paramInt)
  {
    AppMethodBeat.i(88875);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
      AppMethodBeat.o(88875);
      return null;
    }
    for (;;)
    {
      JSONStringer localJSONStringer;
      JSONObject localJSONObject;
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).optJSONArray("card_list");
        if ((localJSONArray == null) || (localJSONArray.length() == 0))
        {
          ab.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
          AppMethodBeat.o(88875);
          return null;
        }
        localJSONStringer = new JSONStringer();
        localJSONStringer.array();
        int i = 0;
        if (i >= localJSONArray.length()) {
          break label360;
        }
        localJSONObject = localJSONArray.optJSONObject(i);
        localJSONStringer.object();
        if (paramInt != 26) {
          break label379;
        }
        paramString = "cardId";
        localJSONStringer.key(paramString);
        localJSONStringer.value(localJSONObject.optString("card_id"));
        if (paramInt != 26) {
          break label385;
        }
        paramString = "cardExt";
        localJSONStringer.key(paramString);
        localJSONStringer.value(localJSONObject.optString("card_ext"));
        if (paramInt != 26) {
          break label391;
        }
        paramString = "isSuccess";
        localJSONStringer.key(paramString);
        if (paramInt == 26)
        {
          if (localJSONObject.optInt("is_succ") == 1)
          {
            localJSONStringer.value(true);
            localJSONStringer.key("code");
            if (TextUtils.isEmpty(localJSONObject.optString("encrypt_code"))) {
              break label344;
            }
            localJSONStringer.value(localJSONObject.optString("encrypt_code"));
            localJSONStringer.endObject();
            StringBuilder localStringBuilder = new StringBuilder("parseJsonToArray item").append(i).append("  is_succ:");
            if (paramInt != 26) {
              break label397;
            }
            paramString = "isSuccess";
            ab.i("MicroMsg.CardListItemParser", localJSONObject.optInt(paramString));
            i += 1;
            continue;
          }
          localJSONStringer.value(false);
          continue;
        }
        localJSONStringer.value(localJSONObject.optInt("is_succ"));
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.CardListItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(88875);
        return "";
      }
      continue;
      label344:
      localJSONStringer.value(localJSONObject.optString("code"));
      continue;
      label360:
      localJSONStringer.endArray();
      paramString = localJSONStringer.toString();
      AppMethodBeat.o(88875);
      return paramString;
      label379:
      paramString = "card_id";
      continue;
      label385:
      paramString = "card_ext";
      continue;
      label391:
      paramString = "is_succ";
      continue;
      label397:
      paramString = "is_succ";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.h
 * JD-Core Version:    0.7.0.1
 */