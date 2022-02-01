package com.tencent.mm.plugin.card.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.sdk.platformtools.Log;
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
    AppMethodBeat.i(113802);
    if (paramLinkedList.size() == 0)
    {
      Log.e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
      AppMethodBeat.o(113802);
      return "";
    }
    Log.i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + paramBoolean + " scene:" + paramInt);
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
          localJSONStringer.value(locale.wsy);
          if (paramInt != 26) {
            break label353;
          }
          paramLinkedList = "cardExt";
          localJSONStringer.key(paramLinkedList);
          if (locale.iaJ != null) {
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
        Log.printErrStackTrace("MicroMsg.CardListItemParser", paramLinkedList, "", new Object[0]);
        AppMethodBeat.o(113802);
        return "";
      }
      continue;
      label272:
      paramLinkedList = locale.iaJ;
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
      AppMethodBeat.o(113802);
      return paramLinkedList;
      label353:
      paramLinkedList = "card_ext";
      continue;
      label359:
      paramLinkedList = "is_succ";
    }
  }
  
  public static ArrayList<wf> dM(String paramString, int paramInt)
  {
    AppMethodBeat.i(113801);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
      AppMethodBeat.o(113801);
      return null;
    }
    if ((paramInt == 8) || (paramInt == 0)) {}
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("card_list");
        if ((paramString == null) || (paramString.length() == 0))
        {
          Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
          AppMethodBeat.o(113801);
          return null;
          if (paramInt == 26)
          {
            paramString = new JSONArray(paramString);
            continue;
          }
          paramString = new JSONArray(paramString);
          continue;
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i >= paramString.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramString.optJSONObject(i);
        if (localJSONObject != null) {
          break label293;
        }
        if (paramInt != 26) {
          break label296;
        }
        boolean bool = paramString.opt(i) instanceof String;
        if (!bool) {
          break label296;
        }
        try
        {
          localJSONObject = new JSONObject(paramString.optString(i));
          wf localwf = new wf();
          if (paramInt == 26)
          {
            str = "cardId";
            localwf.wsy = localJSONObject.optString(str);
            if (paramInt != 26) {
              break label278;
            }
            str = "cardExt";
            localwf.iaJ = localJSONObject.optString(str);
            localArrayList.add(localwf);
          }
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.CardListItemParser", localJSONException, "protect itemJSON for AppBrand", new Object[0]);
        }
        str = "card_id";
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.CardListItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(113801);
        return null;
      }
      continue;
      label278:
      String str = "card_ext";
      continue;
      label285:
      AppMethodBeat.o(113801);
      return localArrayList;
      label293:
      continue;
      label296:
      i += 1;
    }
  }
  
  public static String dN(String paramString, int paramInt)
  {
    AppMethodBeat.i(113803);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
      AppMethodBeat.o(113803);
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
          Log.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
          AppMethodBeat.o(113803);
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
            Log.i("MicroMsg.CardListItemParser", localJSONObject.optInt(paramString));
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
        Log.printErrStackTrace("MicroMsg.CardListItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(113803);
        return "";
      }
      continue;
      label344:
      localJSONStringer.value(localJSONObject.optString("code"));
      continue;
      label360:
      localJSONStringer.endArray();
      paramString = localJSONStringer.toString();
      AppMethodBeat.o(113803);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.h
 * JD-Core Version:    0.7.0.1
 */