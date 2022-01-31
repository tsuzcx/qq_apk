package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public final class a
{
  private static Map<String, Map<Integer, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e>> hpn;
  private static final Pattern hpo;
  
  static
  {
    AppMethodBeat.i(10881);
    hpo = Pattern.compile("(\\{\"method\":\"drawImage\",\"data\":\\[\"undefined\".*?\\})|(\\{\"method\":\"fillText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})|(\\{\"method\":\"strokeText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})");
    AppMethodBeat.o(10881);
  }
  
  public static void Bk(String paramString)
  {
    AppMethodBeat.i(10879);
    if (hpn == null)
    {
      AppMethodBeat.o(10879);
      return;
    }
    paramString = (Map)hpn.get(paramString);
    if (paramString != null)
    {
      Iterator localIterator = paramString.values().iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e)localIterator.next()).reset();
      }
      paramString.clear();
    }
    AppMethodBeat.o(10879);
  }
  
  public static void bQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10880);
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(10880);
      return;
    }
    com.tencent.mm.sdk.g.d.ysm.b(new a.1(paramString2, paramString1), "onDrawFrame");
    AppMethodBeat.o(10880);
  }
  
  public static com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(10878);
    if (hpn == null)
    {
      localObject = new HashMap();
      hpn = (Map)localObject;
      ((Map)localObject).put(paramString, new HashMap());
    }
    Object localObject = (Map)hpn.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      hpn.put(paramString, localObject);
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e locale = (com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e)((Map)localObject).get(Integer.valueOf(paramInt));
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
        AppMethodBeat.o(10878);
        return paramString;
        paramString = new b();
        continue;
        paramString = new c();
        continue;
        paramString = new com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a
 * JD-Core Version:    0.7.0.1
 */