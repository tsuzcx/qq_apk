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
  public String hAD;
  public String hzB;
  public int mrl;
  public String nXq;
  public String oxM;
  public String oxN;
  public String oxO;
  public String oxP;
  public int oxQ;
  public String oxR;
  public int oxS;
  public String oxT;
  public String oxU;
  public String oxV;
  public boolean oxW;
  public String title;
  public String userName;
  
  public static LinkedList<a> Ym(String paramString)
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
  
  public static LinkedList<a> Yn(String paramString)
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
      locala.oxM = localJSONObject.optString("card_tp_id");
      locala.mrl = localJSONObject.optInt("card_type");
      locala.hAD = localJSONObject.optString("color");
      locala.hzB = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.oxN = localJSONObject.optString("sub_title");
      locala.oxO = localJSONObject.optString("aux_title");
      locala.oxP = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.oxQ = localJSONObject.optInt("end_time");
      locala.oxR = localJSONObject.optString("card_user_id");
      locala.oxS = localJSONObject.optInt("choose_optional");
      locala.oxU = localJSONObject.optString("invoice_item");
      locala.oxV = localJSONObject.optString("invoice_status");
      locala.oxT = localJSONObject.optString("invoice_title");
      locala.oxW = paramBoolean;
      localLinkedList.add(locala);
      i += 1;
    }
    AppMethodBeat.o(112716);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a
 * JD-Core Version:    0.7.0.1
 */