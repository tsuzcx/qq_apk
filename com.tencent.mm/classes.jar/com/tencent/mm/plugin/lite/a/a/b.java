package com.tencent.mm.plugin.lite.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends e
{
  private static List<String> E(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(271541);
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      paramJSONArray = new LinkedList();
      AppMethodBeat.o(271541);
      return paramJSONArray;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    AppMethodBeat.o(271541);
    return localLinkedList;
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271555);
    Log.d("LiteAppJsApiPreloadMiniProgramContacts", "Invoke preloadMiniProgramContacts");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271555);
      return;
    }
    Object localObject = null;
    paramString = localObject;
    if (paramJSONObject.has("userNames"))
    {
      paramJSONObject = paramJSONObject.opt("userNames");
      if (!(paramJSONObject instanceof String)) {
        break label125;
      }
    }
    for (;;)
    {
      try
      {
        paramString = E(new JSONArray((String)paramJSONObject));
        if (Util.isNullOrNil(paramString)) {
          break;
        }
        ((k)h.ax(k.class)).cG(paramString);
        this.JZj.fTW();
        AppMethodBeat.o(271555);
        return;
      }
      catch (Exception paramString)
      {
        this.JZj.aJV("fail: params error");
        AppMethodBeat.o(271555);
        return;
      }
      label125:
      paramString = localObject;
      if ((paramJSONObject instanceof JSONArray)) {
        paramString = E((JSONArray)paramJSONObject);
      }
    }
    this.JZj.aJV("fail: params error");
    AppMethodBeat.o(271555);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.a.b
 * JD-Core Version:    0.7.0.1
 */