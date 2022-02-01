package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String app_id;
  public String gGR;
  public String gHT;
  public int lpz;
  public String mTA;
  public String nrA;
  public boolean nrB;
  public String nrr;
  public String nrs;
  public String nrt;
  public String nru;
  public int nrv;
  public String nrw;
  public int nrx;
  public String nry;
  public String nrz;
  public String title;
  public String userName;
  
  public static LinkedList<a> Qr(String paramString)
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
      ad.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(112714);
    }
    return null;
  }
  
  public static LinkedList<a> Qs(String paramString)
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
      ad.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(112715);
    }
    return null;
  }
  
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
      locala.nrr = localJSONObject.optString("card_tp_id");
      locala.lpz = localJSONObject.optInt("card_type");
      locala.gHT = localJSONObject.optString("color");
      locala.gGR = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.nrs = localJSONObject.optString("sub_title");
      locala.nrt = localJSONObject.optString("aux_title");
      locala.nru = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.nrv = localJSONObject.optInt("end_time");
      locala.nrw = localJSONObject.optString("card_user_id");
      locala.nrx = localJSONObject.optInt("choose_optional");
      locala.nrz = localJSONObject.optString("invoice_item");
      locala.nrA = localJSONObject.optString("invoice_status");
      locala.nry = localJSONObject.optString("invoice_title");
      locala.nrB = paramBoolean;
      localLinkedList.add(locala);
      i += 1;
    }
    AppMethodBeat.o(112716);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a
 * JD-Core Version:    0.7.0.1
 */