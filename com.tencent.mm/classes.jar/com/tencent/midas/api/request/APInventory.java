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
    AppMethodBeat.i(217337);
    this.mPurchaseMap = new HashMap();
    this.mPurchaseList = new ArrayList();
    parsePurchse(paramString);
    AppMethodBeat.o(217337);
  }
  
  private void parsePurchse(String paramString)
  {
    AppMethodBeat.i(217346);
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
      AppMethodBeat.o(217346);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(217346);
    }
  }
  
  public void erasePurchase(String paramString)
  {
    AppMethodBeat.i(217375);
    if (this.mPurchaseMap.containsKey(paramString)) {
      this.mPurchaseMap.remove(paramString);
    }
    AppMethodBeat.o(217375);
  }
  
  List<String> getAllOwnedSkus()
  {
    AppMethodBeat.i(217382);
    ArrayList localArrayList = new ArrayList(this.mPurchaseMap.keySet());
    AppMethodBeat.o(217382);
    return localArrayList;
  }
  
  List<APPurchase> getAllPurchases()
  {
    AppMethodBeat.i(217387);
    ArrayList localArrayList = new ArrayList(this.mPurchaseMap.values());
    AppMethodBeat.o(217387);
    return localArrayList;
  }
  
  public APPurchase getPurchase(String paramString)
  {
    AppMethodBeat.i(217359);
    paramString = (APPurchase)this.mPurchaseMap.get(paramString);
    AppMethodBeat.o(217359);
    return paramString;
  }
  
  public List<APPurchase> getPurchaseList()
  {
    return this.mPurchaseList;
  }
  
  public boolean hasPurchase(String paramString)
  {
    AppMethodBeat.i(217367);
    boolean bool = this.mPurchaseMap.containsKey(paramString);
    AppMethodBeat.o(217367);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.api.request.APInventory
 * JD-Core Version:    0.7.0.1
 */