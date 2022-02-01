package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  String appId;
  String iconUrl;
  String jumpUrl;
  String oiJ;
  String oiK;
  List<String> oiL;
  int position;
  long size;
  int state;
  int type;
  
  public static void aj(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(8956);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8956);
      return;
    }
    ak(paramContext, paramString);
    paramContext = paramContext.getSharedPreferences("search_history_href", 0);
    String str = paramContext.getString("search_history_list", "");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(Base64.encodeToString(paramString.getBytes(), 0));
    localStringBuffer.append(";");
    localStringBuffer.append(str);
    paramString = localStringBuffer.toString().split(";");
    localStringBuffer.setLength(0);
    while ((i < paramString.length) && (i < 10))
    {
      localStringBuffer.append(paramString[i]);
      localStringBuffer.append(";");
      i += 1;
    }
    paramContext.edit().putString("search_history_list", localStringBuffer.toString()).commit();
    AppMethodBeat.o(8956);
  }
  
  public static void ak(Context paramContext, String paramString)
  {
    AppMethodBeat.i(8957);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8957);
      return;
    }
    paramContext = paramContext.getSharedPreferences("search_history_href", 0);
    paramString = paramContext.getString("search_history_list", "").replace(Base64.encodeToString(paramString.getBytes(), 0) + ";", "");
    paramContext.edit().putString("search_history_list", paramString).commit();
    AppMethodBeat.o(8957);
  }
  
  public static List<b> eq(Context paramContext)
  {
    AppMethodBeat.i(8955);
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("search_history_href", 0).getString("search_history_list", "");
    if (bt.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(8955);
      return localArrayList;
    }
    paramContext = paramContext.split(";");
    int m = paramContext.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      String str = paramContext[i];
      k = j;
      if (!bt.isNullOrNil(str))
      {
        b localb = new b();
        localb.type = 2;
        localb.oiJ = new String(Base64.decode(str, 0));
        k = j + 1;
        localb.position = k;
        localArrayList.add(localb);
      }
      i += 1;
    }
    if (!bt.gL(localArrayList))
    {
      paramContext = new b();
      paramContext.type = 1;
      localArrayList.add(0, paramContext);
    }
    AppMethodBeat.o(8955);
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(8954);
    if (((paramObject instanceof b)) && (((b)paramObject).oiJ != null))
    {
      bool = ((b)paramObject).oiJ.equals(this.oiJ);
      AppMethodBeat.o(8954);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(8954);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.b
 * JD-Core Version:    0.7.0.1
 */