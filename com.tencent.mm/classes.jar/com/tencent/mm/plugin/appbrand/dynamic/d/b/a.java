package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public final class a
{
  private static Map<String, Map<Integer, e>> jmv;
  private static final Pattern jmw;
  
  static
  {
    AppMethodBeat.i(121361);
    jmw = Pattern.compile("(\\{\"method\":\"drawImage\",\"data\":\\[\"undefined\".*?\\})|(\\{\"method\":\"fillText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})|(\\{\"method\":\"strokeText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})");
    AppMethodBeat.o(121361);
  }
  
  public static void Hi(String paramString)
  {
    AppMethodBeat.i(121359);
    if (jmv == null)
    {
      AppMethodBeat.o(121359);
      return;
    }
    paramString = (Map)jmv.get(paramString);
    if (paramString != null)
    {
      Iterator localIterator = paramString.values().iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).reset();
      }
      paramString.clear();
    }
    AppMethodBeat.o(121359);
  }
  
  public static e bt(String paramString, int paramInt)
  {
    AppMethodBeat.i(121358);
    if (jmv == null)
    {
      localObject = new HashMap();
      jmv = (Map)localObject;
      ((Map)localObject).put(paramString, new HashMap());
    }
    Object localObject = (Map)jmv.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      jmv.put(paramString, localObject);
    }
    for (;;)
    {
      e locale = (e)((Map)localObject).get(Integer.valueOf(paramInt));
      paramString = locale;
      if (locale == null) {
        switch (paramInt)
        {
        default: 
          paramString = new c();
        }
      }
      for (;;)
      {
        ((Map)localObject).put(Integer.valueOf(paramInt), paramString);
        AppMethodBeat.o(121358);
        return paramString;
        paramString = new b();
        continue;
        paramString = new c();
        continue;
        paramString = new d();
      }
    }
  }
  
  public static void cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121360);
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(121360);
      return;
    }
    h.Iye.f(new a.1(paramString2, paramString1), "onDrawFrame");
    AppMethodBeat.o(121360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a
 * JD-Core Version:    0.7.0.1
 */