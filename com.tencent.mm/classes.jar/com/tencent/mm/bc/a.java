package com.tencent.mm.bc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.appbrand.u.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

public final class a
{
  public static int a(JSONObject paramJSONObject, String paramString, Context paramContext)
  {
    if (paramJSONObject == null) {}
    for (int i = 0;; i = paramJSONObject.optInt("businessType"))
    {
      int j = i;
      if (i == 0)
      {
        if (!paramString.equals(paramContext.getString(R.l.search_education_article))) {
          break;
        }
        j = 2;
      }
      return j;
    }
    if (paramString.equals(paramContext.getString(R.l.search_education_timeline))) {
      return 8;
    }
    if (paramString.equals(paramContext.getString(R.l.search_education_biz_contact))) {
      return 1;
    }
    y.i("MicroMsg.FTS.FTSExportLogic", "option " + paramString + " no type");
    return i;
  }
  
  public static boolean ay(String paramString1, String paramString2)
  {
    int i = 0;
    boolean bool = false;
    if (paramString1 == paramString2) {
      bool = true;
    }
    while (TextUtils.isEmpty(paramString1)) {
      return bool;
    }
    if (paramString1.startsWith(paramString2)) {
      return true;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    StringBuilder localStringBuilder;
    for (paramString1 = "";; paramString1 = localStringBuilder.toString())
    {
      return paramString1.startsWith(paramString2);
      localStringBuilder = new StringBuilder(paramString1.length());
      while (i < paramString1.length())
      {
        localStringBuilder.append(SpellMap.e(paramString1.charAt(i)));
        i += 1;
      }
    }
  }
  
  public static Drawable b(int paramInt, Context paramContext)
  {
    int i = R.k.sos_search_icon;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return paramContext.getResources().getDrawable(paramInt);
      paramInt = R.k.sos_offical_icon;
      continue;
      paramInt = R.k.sos_moments_icon;
      continue;
      paramInt = R.k.sos_article_icon;
      continue;
      paramInt = R.k.sos_mini_program_icon;
      continue;
      paramInt = R.k.sos_emoji_icon;
      continue;
      paramInt = R.k.sos_music_icon;
      continue;
      paramInt = R.k.sos_novel_icon;
      continue;
      paramInt = R.k.sos_video_icon;
      continue;
      paramInt = R.k.sos_wiki_icon;
      continue;
      paramInt = R.k.sos_question_icon;
    }
  }
  
  public static String b(int paramInt, Map<String, String> paramMap)
  {
    switch (paramInt)
    {
    default: 
      return aa.v(paramMap);
    case 201: 
      return r.v(paramMap);
    }
    return aa.c(paramMap, 1);
  }
  
  public static Map<String, String> bu(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return aa.b(paramInt1, false, paramInt2);
    }
    return r.b(paramInt1, false, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bc.a
 * JD-Core Version:    0.7.0.1
 */