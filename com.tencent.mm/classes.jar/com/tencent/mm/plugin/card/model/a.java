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
  public String iwv;
  public String ixw;
  public int nHh;
  public String pRX;
  public String pRY;
  public String pRZ;
  public String pSa;
  public int pSb;
  public String pSc;
  public int pSd;
  public String pSe;
  public String pSf;
  public String pSg;
  public boolean pSh;
  public String pnW;
  public String title;
  public String userName;
  
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
      locala.pRX = localJSONObject.optString("card_tp_id");
      locala.nHh = localJSONObject.optInt("card_type");
      locala.ixw = localJSONObject.optString("color");
      locala.iwv = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.pRY = localJSONObject.optString("sub_title");
      locala.pRZ = localJSONObject.optString("aux_title");
      locala.pSa = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.pSb = localJSONObject.optInt("end_time");
      locala.pSc = localJSONObject.optString("card_user_id");
      locala.pSd = localJSONObject.optInt("choose_optional");
      locala.pSf = localJSONObject.optString("invoice_item");
      locala.pSg = localJSONObject.optString("invoice_status");
      locala.pSe = localJSONObject.optString("invoice_title");
      locala.pSh = paramBoolean;
      localLinkedList.add(locala);
      i += 1;
    }
    AppMethodBeat.o(112716);
    return localLinkedList;
  }
  
  public static LinkedList<a> aji(String paramString)
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
  
  public static LinkedList<a> ajj(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a
 * JD-Core Version:    0.7.0.1
 */