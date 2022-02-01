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
    AppMethodBeat.i(253315);
    this.mPurchaseMap = new HashMap();
    this.mPurchaseList = new ArrayList();
    parsePurchse(paramString);
    AppMethodBeat.o(253315);
  }
  
  private void parsePurchse(String paramString)
  {
    AppMethodBeat.i(253316);
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
      AppMethodBeat.o(253316);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(253316);
    }
  }
  
  public void erasePurchase(String paramString)
  {
    AppMethodBeat.i(253322);
    if (this.mPurchaseMap.containsKey(paramString)) {
      this.mPurchaseMap.remove(paramString);
    }
    AppMethodBeat.o(253322);
  }
  
  List<String> getAllOwnedSkus()
  {
    AppMethodBeat.i(253324);
    ArrayList localArrayList = new ArrayList(this.mPurchaseMap.keySet());
    AppMethodBeat.o(253324);
    return localArrayList;
  }
  
  List<APPurchase> getAllPurchases()
  {
    AppMethodBeat.i(253325);
    ArrayList localArrayList = new ArrayList(this.mPurchaseMap.values());
    AppMethodBeat.o(253325);
    return localArrayList;
  }
  
  public APPurchase getPurchase(String paramString)
  {
    AppMethodBeat.i(253319);
    paramString = (APPurchase)this.mPurchaseMap.get(paramString);
    AppMethodBeat.o(253319);
    return paramString;
  }
  
  public List<APPurchase> getPurchaseList()
  {
    return this.mPurchaseList;
  }
  
  public boolean hasPurchase(String paramString)
  {
    AppMethodBeat.i(253320);
    boolean bool = this.mPurchaseMap.containsKey(paramString);
    AppMethodBeat.o(253320);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.api.request.APInventory
 * JD-Core Version:    0.7.0.1
 */