package com.tencent.mm.bd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

public final class a
{
  public static int a(JSONObject paramJSONObject, String paramString, Context paramContext)
  {
    AppMethodBeat.i(91302);
    int j;
    int i;
    if (paramJSONObject == null)
    {
      j = 0;
      i = j;
      if (j == 0)
      {
        if (!paramString.equals(paramContext.getString(2131302999))) {
          break label53;
        }
        i = 2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(91302);
      return i;
      j = paramJSONObject.optInt("businessType");
      break;
      label53:
      if (paramString.equals(paramContext.getString(2131303003)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(2131303000)))
      {
        i = 1;
      }
      else
      {
        ab.i("MicroMsg.FTS.FTSExportLogic", "option " + paramString + " no type");
        i = j;
      }
    }
  }
  
  public static boolean aR(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(91304);
    if (paramString1 == paramString2)
    {
      AppMethodBeat.o(91304);
      return true;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(91304);
      return false;
    }
    if (paramString1.startsWith(paramString2))
    {
      AppMethodBeat.o(91304);
      return true;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    StringBuilder localStringBuilder;
    for (paramString1 = "";; paramString1 = localStringBuilder.toString())
    {
      boolean bool = paramString1.startsWith(paramString2);
      AppMethodBeat.o(91304);
      return bool;
      localStringBuilder = new StringBuilder(paramString1.length());
      while (i < paramString1.length())
      {
        localStringBuilder.append(SpellMap.u(paramString1.charAt(i)));
        i += 1;
      }
    }
  }
  
  public static Drawable b(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(91303);
    int i = 2131232053;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(91303);
      return paramContext;
      paramInt = 2131232051;
      continue;
      paramInt = 2131232048;
      continue;
      paramInt = 2131232037;
      continue;
      paramInt = 2131232047;
      continue;
      paramInt = 2131232042;
      continue;
      paramInt = 2131232049;
      continue;
      paramInt = 2131232050;
      continue;
      paramInt = 2131232056;
      continue;
      paramInt = 2131232057;
      continue;
      paramInt = 2131232052;
    }
  }
  
  public static String b(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(91301);
    switch (paramInt)
    {
    default: 
      paramMap = aa.F(paramMap);
      AppMethodBeat.o(91301);
      return paramMap;
    case 201: 
      paramMap = r.F(paramMap);
      AppMethodBeat.o(91301);
      return paramMap;
    }
    paramMap = aa.d(paramMap, 1);
    AppMethodBeat.o(91301);
    return paramMap;
  }
  
  public static Map<String, String> cE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91300);
    switch (paramInt1)
    {
    default: 
      localMap = aa.d(paramInt1, false, paramInt2);
      AppMethodBeat.o(91300);
      return localMap;
    }
    Map localMap = r.d(paramInt1, false, paramInt2);
    AppMethodBeat.o(91300);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bd.a
 * JD-Core Version:    0.7.0.1
 */