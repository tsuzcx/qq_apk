package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String app_id;
  public String hhs;
  public String hiu;
  public int lRv;
  public String nUA;
  public boolean nUB;
  public String nUr;
  public String nUs;
  public String nUt;
  public String nUu;
  public int nUv;
  public String nUw;
  public int nUx;
  public String nUy;
  public String nUz;
  public String nvS;
  public String title;
  public String userName;
  
  public static LinkedList<a> UD(String paramString)
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
      ac.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
      AppMethodBeat.o(112714);
    }
    return null;
  }
  
  public static LinkedList<a> UE(String paramString)
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
      ac.printErrStackTrace("MicroMsg.AvailableCardItem", paramString, "", new Object[0]);
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
      locala.nUr = localJSONObject.optString("card_tp_id");
      locala.lRv = localJSONObject.optInt("card_type");
      locala.hiu = localJSONObject.optString("color");
      locala.hhs = localJSONObject.optString("logo_url");
      locala.title = localJSONObject.optString("title");
      locala.nUs = localJSONObject.optString("sub_title");
      locala.nUt = localJSONObject.optString("aux_title");
      locala.nUu = localJSONObject.optString("encrypt_code");
      locala.userName = localJSONObject.optString("from_user_name");
      locala.app_id = localJSONObject.optString("app_id");
      locala.nUv = localJSONObject.optInt("end_time");
      locala.nUw = localJSONObject.optString("card_user_id");
      locala.nUx = localJSONObject.optInt("choose_optional");
      locala.nUz = localJSONObject.optString("invoice_item");
      locala.nUA = localJSONObject.optString("invoice_status");
      locala.nUy = localJSONObject.optString("invoice_title");
      locala.nUB = paramBoolean;
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