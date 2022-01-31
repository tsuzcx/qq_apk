package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  String appId;
  String iconUrl;
  String jumpUrl;
  String lbI;
  String lbJ;
  List<String> lbK;
  int position;
  long size;
  int state;
  int type;
  
  public static void ak(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(136195);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(136195);
      return;
    }
    al(paramContext, paramString);
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
    AppMethodBeat.o(136195);
  }
  
  public static void al(Context paramContext, String paramString)
  {
    AppMethodBeat.i(136196);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(136196);
      return;
    }
    paramContext = paramContext.getSharedPreferences("search_history_href", 0);
    paramString = paramContext.getString("search_history_list", "").replace(Base64.encodeToString(paramString.getBytes(), 0) + ";", "");
    paramContext.edit().putString("search_history_list", paramString).commit();
    AppMethodBeat.o(136196);
  }
  
  public static List<b> dI(Context paramContext)
  {
    AppMethodBeat.i(136194);
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("search_history_href", 0).getString("search_history_list", "");
    if (bo.isNullOrNil(paramContext))
    {
      AppMethodBeat.o(136194);
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
      if (!bo.isNullOrNil(str))
      {
        b localb = new b();
        localb.type = 2;
        localb.lbI = new String(Base64.decode(str, 0));
        k = j + 1;
        localb.position = k;
        localArrayList.add(localb);
      }
      i += 1;
    }
    if (!bo.es(localArrayList))
    {
      paramContext = new b();
      paramContext.type = 1;
      localArrayList.add(0, paramContext);
    }
    AppMethodBeat.o(136194);
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(136193);
    if (((paramObject instanceof b)) && (((b)paramObject).lbI != null))
    {
      bool = ((b)paramObject).lbI.equals(this.lbI);
      AppMethodBeat.o(136193);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(136193);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.b
 * JD-Core Version:    0.7.0.1
 */