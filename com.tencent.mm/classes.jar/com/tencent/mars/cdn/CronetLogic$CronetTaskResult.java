package com.tencent.mars.cdn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CronetLogic$CronetTaskResult
{
  public int cronetErrorCode = 0;
  public byte[] data = null;
  public int errorCode = 0;
  public String errorMsg = "";
  public CronetLogic.HeaderMap[] headers = null;
  public String newLocation = "";
  public String originTaskId = "";
  public int quicErrorCode = 0;
  public String rawHeader = "";
  public int statusCode = 0;
  public String statusText = "";
  public long totalReceiveByte = 0L;
  public long totalWriteByte = 0L;
  public CronetLogic.WebPageProfile webPageProfile;
  
  public String getDataString()
  {
    try
    {
      String str = new String(this.data, "UTF-8");
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public Map<String, String> getHeaderMap()
  {
    IdentityHashMap localIdentityHashMap = new IdentityHashMap();
    if (this.headers != null)
    {
      CronetLogic.HeaderMap[] arrayOfHeaderMap = this.headers;
      int j = arrayOfHeaderMap.length;
      int i = 0;
      while (i < j)
      {
        CronetLogic.HeaderMap localHeaderMap = arrayOfHeaderMap[i];
        if ((localHeaderMap != null) && (localHeaderMap.key != null) && (localHeaderMap.value != null)) {
          localIdentityHashMap.put(new String(localHeaderMap.key), localHeaderMap.value);
        }
        i += 1;
      }
    }
    return localIdentityHashMap;
  }
  
  public Map<String, List<String>> getHeaderMapList()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = getHeaderMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str1 = (String)((Map.Entry)localObject).getKey();
      if ((str1 != null) && (!str1.isEmpty()))
      {
        String str2 = (String)((Map.Entry)localObject).getValue();
        List localList = (List)localHashMap.get(str1);
        localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(str2);
        localHashMap.put(str1, localObject);
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic.CronetTaskResult
 * JD-Core Version:    0.7.0.1
 */