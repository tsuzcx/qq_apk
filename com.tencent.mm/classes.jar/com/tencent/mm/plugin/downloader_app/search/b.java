package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  String appId;
  String iconUrl;
  String jumpUrl;
  int position;
  long size;
  int state;
  int type;
  String version;
  String xts;
  String xtt;
  List<String> xtu;
  String xtv;
  String xtw;
  String xtx;
  
  public static void av(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(8956);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8956);
      return;
    }
    aw(paramContext, paramString);
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
  
  public static void aw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(8957);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8957);
      return;
    }
    paramContext = paramContext.getSharedPreferences("search_history_href", 0);
    paramString = paramContext.getString("search_history_list", "").replace(Base64.encodeToString(paramString.getBytes(), 0) + ";", "");
    paramContext.edit().putString("search_history_list", paramString).commit();
    AppMethodBeat.o(8957);
  }
  
  public static List<b> fY(Context paramContext)
  {
    AppMethodBeat.i(8955);
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("search_history_href", 0).getString("search_history_list", "");
    if (Util.isNullOrNil(paramContext))
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
      if (!Util.isNullOrNil(str))
      {
        b localb = new b();
        localb.type = 2;
        localb.xts = new String(Base64.decode(str, 0));
        k = j + 1;
        localb.position = k;
        localArrayList.add(localb);
      }
      i += 1;
    }
    if (!Util.isNullOrNil(localArrayList))
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
    if (((paramObject instanceof b)) && (((b)paramObject).xts != null))
    {
      bool = ((b)paramObject).xts.equals(this.xts);
      AppMethodBeat.o(8954);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(8954);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.b
 * JD-Core Version:    0.7.0.1
 */