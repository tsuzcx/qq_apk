package com.tencent.mm.plugin.appbrand.config;

import java.util.LinkedList;
import org.json.JSONArray;

final class t
{
  static LinkedList<String> j(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */