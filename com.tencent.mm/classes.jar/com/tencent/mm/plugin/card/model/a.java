package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String app_id;
  public String color;
  public int end_time;
  public String ics;
  public String iln;
  public int ilo;
  public String ilp;
  public String ilq;
  public String ilr;
  public String ils;
  public String ilt;
  public int ilu;
  public String ilv;
  public String ilw;
  public String ilx;
  public boolean ily;
  public String title;
  public String userName;
  
  private static LinkedList<a> a(JSONArray paramJSONArray, boolean paramBoolean)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      a locala = new a();
      locala.iln = localJSONObject.optString("card_tp_id");
      locala.ilo = localJSONObject.optInt("card_type");
      locala.color = localJSONObject.optString("color");
      locala.ilp = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.ilq = localJSONObject.optString("sub_title");
      locala.ilr = localJSONObject.optString("aux_title");
      locala.ils = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.end_time = localJSONObject.optInt("end_time");
      locala.ilt = localJSONObject.optString("card_user_id");
      locala.ilu = localJSONObject.optInt("choose_optional");
      locala.ilw = localJSONObject.optString("invoice_item");
      locala.ilx = localJSONObject.optString("invoice_status");
      locala.ilv = localJSONObject.optString("invoice_title");
      locala.ily = paramBoolean;
      localLinkedList.add(locala);
      i += 1;
    }
    return localLinkedList;
  }
  
  public static LinkedList<a> yg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString).optJSONArray("available_cards"), false);
      return paramString;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static LinkedList<a> yh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString).optJSONArray("available_share_cards"), true);
      return paramString;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a
 * JD-Core Version:    0.7.0.1
 */