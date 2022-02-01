package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String app_id;
  public String hCp;
  public String hDr;
  public int mwj;
  public String oEo;
  public String oEp;
  public String oEq;
  public String oEr;
  public int oEs;
  public String oEt;
  public int oEu;
  public String oEv;
  public String oEw;
  public String oEx;
  public boolean oEy;
  public String ocZ;
  public String title;
  public String userName;
  
  public static LinkedList<a> Zd(String paramString)
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
      ae.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(112714);
    }
    return null;
  }
  
  public static LinkedList<a> Ze(String paramString)
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
      ae.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
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
      locala.oEo = localJSONObject.optString("card_tp_id");
      locala.mwj = localJSONObject.optInt("card_type");
      locala.hDr = localJSONObject.optString("color");
      locala.hCp = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.oEp = localJSONObject.optString("sub_title");
      locala.oEq = localJSONObject.optString("aux_title");
      locala.oEr = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.oEs = localJSONObject.optInt("end_time");
      locala.oEt = localJSONObject.optString("card_user_id");
      locala.oEu = localJSONObject.optInt("choose_optional");
      locala.oEw = localJSONObject.optString("invoice_item");
      locala.oEx = localJSONObject.optString("invoice_status");
      locala.oEv = localJSONObject.optString("invoice_title");
      locala.oEy = paramBoolean;
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