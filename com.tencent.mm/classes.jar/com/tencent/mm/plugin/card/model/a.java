package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String app_id;
  public String color;
  public int iFL;
  public String jTi;
  public String kml;
  public String kmm;
  public String kmn;
  public String kmo;
  public String kmp;
  public int kmq;
  public String kmr;
  public int kms;
  public String kmt;
  public String kmu;
  public String kmv;
  public boolean kmw;
  public String title;
  public String userName;
  
  public static LinkedList<a> HH(String paramString)
  {
    AppMethodBeat.i(87772);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(87772);
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString).optJSONArray("available_cards"), false);
      AppMethodBeat.o(87772);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(87772);
    }
    return null;
  }
  
  public static LinkedList<a> HI(String paramString)
  {
    AppMethodBeat.i(87773);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(87773);
      return null;
    }
    try
    {
      paramString = a(new JSONObject(paramString).optJSONArray("available_share_cards"), true);
      AppMethodBeat.o(87773);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(87773);
    }
    return null;
  }
  
  private static LinkedList<a> a(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(87774);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(87774);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      a locala = new a();
      locala.kml = localJSONObject.optString("card_tp_id");
      locala.iFL = localJSONObject.optInt("card_type");
      locala.color = localJSONObject.optString("color");
      locala.kmm = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.kmn = localJSONObject.optString("sub_title");
      locala.kmo = localJSONObject.optString("aux_title");
      locala.kmp = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.kmq = localJSONObject.optInt("end_time");
      locala.kmr = localJSONObject.optString("card_user_id");
      locala.kms = localJSONObject.optInt("choose_optional");
      locala.kmu = localJSONObject.optString("invoice_item");
      locala.kmv = localJSONObject.optString("invoice_status");
      locala.kmt = localJSONObject.optString("invoice_title");
      locala.kmw = paramBoolean;
      localLinkedList.add(locala);
      i += 1;
    }
    AppMethodBeat.o(87774);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a
 * JD-Core Version:    0.7.0.1
 */