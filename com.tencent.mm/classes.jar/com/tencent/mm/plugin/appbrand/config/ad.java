package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;

final class ad
{
  static LinkedList<String> n(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(123526);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(123526);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    AppMethodBeat.o(123526);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ad
 * JD-Core Version:    0.7.0.1
 */