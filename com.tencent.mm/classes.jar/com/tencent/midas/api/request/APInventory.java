package com.tencent.midas.api.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APInventory
{
  public ArrayList<APPurchase> mPurchaseList;
  public Map<String, APPurchase> mPurchaseMap;
  
  public APInventory(String paramString)
  {
    AppMethodBeat.i(192925);
    this.mPurchaseMap = new HashMap();
    this.mPurchaseList = new ArrayList();
    parsePurchse(paramString);
    AppMethodBeat.o(192925);
  }
  
  private void parsePurchse(String paramString)
  {
    AppMethodBeat.i(192926);
    new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        APPurchase localAPPurchase = new APPurchase((String)paramString.getJSONObject(i).get("data"), (String)paramString.getJSONObject(i).get("sign"));
        this.mPurchaseMap.put(localAPPurchase.getSku(), localAPPurchase);
        this.mPurchaseList.add(localAPPurchase);
        i += 1;
      }
      AppMethodBeat.o(192926);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(192926);
    }
  }
  
  public void erasePurchase(String paramString)
  {
    AppMethodBeat.i(192929);
    if (this.mPurchaseMap.containsKey(paramString)) {
      this.mPurchaseMap.remove(paramString);
    }
    AppMethodBeat.o(192929);
  }
  
  List<String> getAllOwnedSkus()
  {
    AppMethodBeat.i(192930);
    ArrayList localArrayList = new ArrayList(this.mPurchaseMap.keySet());
    AppMethodBeat.o(192930);
    return localArrayList;
  }
  
  List<APPurchase> getAllPurchases()
  {
    AppMethodBeat.i(192931);
    ArrayList localArrayList = new ArrayList(this.mPurchaseMap.values());
    AppMethodBeat.o(192931);
    return localArrayList;
  }
  
  public APPurchase getPurchase(String paramString)
  {
    AppMethodBeat.i(192927);
    paramString = (APPurchase)this.mPurchaseMap.get(paramString);
    AppMethodBeat.o(192927);
    return paramString;
  }
  
  public List<APPurchase> getPurchaseList()
  {
    return this.mPurchaseList;
  }
  
  public boolean hasPurchase(String paramString)
  {
    AppMethodBeat.i(192928);
    boolean bool = this.mPurchaseMap.containsKey(paramString);
    AppMethodBeat.o(192928);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.api.request.APInventory
 * JD-Core Version:    0.7.0.1
 */