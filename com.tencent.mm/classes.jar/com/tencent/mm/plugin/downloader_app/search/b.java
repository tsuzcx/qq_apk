package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  String appId;
  String iSX;
  String iSY;
  List<String> iSZ;
  String iconUrl;
  String jumpUrl;
  long size;
  int state;
  int type;
  
  public static void ad(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("search_history_href", 0);
    paramString = paramContext.getString("search_history_list", "").replace(Base64.encodeToString(paramString.getBytes(), 0) + ";", "");
    paramContext.edit().putString("search_history_list", paramString).commit();
  }
  
  public static List<b> cV(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("search_history_href", 0).getString("search_history_list", "");
    if (bk.bl(paramContext)) {}
    do
    {
      return localArrayList;
      paramContext = paramContext.split(";");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        String str = paramContext[i];
        if (!bk.bl(str))
        {
          b localb = new b();
          localb.type = 2;
          localb.iSX = new String(Base64.decode(str, 0));
          localArrayList.add(localb);
        }
        i += 1;
      }
    } while (bk.dk(localArrayList));
    paramContext = new b();
    paramContext.type = 1;
    localArrayList.add(0, paramContext);
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (((paramObject instanceof b)) && (((b)paramObject).iSX != null)) {
      return ((b)paramObject).iSX.equals(this.iSX);
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.b
 * JD-Core Version:    0.7.0.1
 */