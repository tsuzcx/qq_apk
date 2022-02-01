package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String app_id;
  public int end_time;
  public String nQG;
  public String nRQ;
  public int tNW;
  public String title;
  public String userName;
  public String vCD;
  public String wsA;
  public String wsB;
  public String wsC;
  public int wsD;
  public String wsE;
  public String wsF;
  public String wsG;
  public boolean wsH;
  public String wsy;
  public String wsz;
  
  private static LinkedList<a> a(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(112716);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(112716);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      a locala = new a();
      locala.wsy = localJSONObject.optString("card_tp_id");
      locala.tNW = localJSONObject.optInt("card_type");
      locala.nRQ = localJSONObject.optString("color");
      locala.nQG = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.wsz = localJSONObject.optString("sub_title");
      locala.wsA = localJSONObject.optString("aux_title");
      locala.wsB = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.end_time = localJSONObject.optInt("end_time");
      locala.wsC = localJSONObject.optString("card_user_id");
      locala.wsD = localJSONObject.optInt("choose_optional");
      locala.wsF = localJSONObject.optString("invoice_item");
      locala.wsG = localJSONObject.optString("invoice_status");
      locala.wsE = localJSONObject.optString("invoice_title");
      locala.wsH = paramBoolean;
      localLinkedList.add(locala);
      i += 1;
    }
    AppMethodBeat.o(112716);
    return localLinkedList;
  }
  
  public static LinkedList<a> akA(String paramString)
  {
    AppMethodBeat.i(112714);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112714);
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString).optJSONArray("available_cards"), false);
      AppMethodBeat.o(112714);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(112714);
    }
    return null;
  }
  
  public static LinkedList<a> akB(String paramString)
  {
    AppMethodBeat.i(112715);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112715);
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString).optJSONArray("available_share_cards"), true);
      AppMethodBeat.o(112715);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(112715);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a
 * JD-Core Version:    0.7.0.1
 */