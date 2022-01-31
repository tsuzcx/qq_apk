package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public String bVk;
  public long kDV;
  public int kDX;
  public int kDY;
  public int kDZ;
  public int kEa;
  public int kEb;
  public int kEc;
  public int kEd;
  public int kEe;
  public int kEf;
  public int kEg;
  public int kEh;
  public int kEi;
  public int kEj;
  public int kEk;
  public int kEl;
  public Map<String, String> kEm = new HashMap();
  
  public final String El(String paramString)
  {
    Object localObject = "";
    Map.Entry localEntry;
    if (!bk.bl(paramString))
    {
      localObject = new JSONArray();
      Iterator localIterator = this.kEm.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (!paramString.contains((CharSequence)localEntry.getValue())) {
          break label146;
        }
      }
    }
    label146:
    for (int i = 0;; i = 1)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", localEntry.getKey());
        localJSONObject.put("mod", i);
        ((JSONArray)localObject).put(localJSONObject);
      }
      catch (JSONException localJSONException) {}
      break;
      localObject = ((JSONArray)localObject).toString().replaceAll(",", ";");
      this.kEm.clear();
      return localObject;
    }
  }
  
  public final int aWt()
  {
    int i = this.kEj;
    this.kEj = 0;
    return i;
  }
  
  public final void reset()
  {
    this.bVk = "";
    this.kEl = 0;
    this.kEk = 0;
    this.kDV = 0L;
    this.kDX = 0;
    this.kDY = 0;
    this.kDZ = 0;
    this.kEa = 0;
    this.kEb = 0;
    this.kEc = 0;
    this.kEd = 0;
    this.kEe = 0;
    this.kEf = 0;
    this.kEg = 0;
    this.kEh = 0;
    this.kEi = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */