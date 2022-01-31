package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static f hnu;
  Map<String, f.b> hnv;
  b.a hnw;
  
  static
  {
    AppMethodBeat.i(10691);
    hnu = new f();
    AppMethodBeat.o(10691);
  }
  
  public f()
  {
    AppMethodBeat.i(10685);
    this.hnv = new ConcurrentHashMap();
    this.hnw = new f.1(this);
    AppMethodBeat.o(10685);
  }
  
  public static void AW(String paramString)
  {
    AppMethodBeat.i(10687);
    Bundle localBundle = new Bundle();
    paramString = AX(paramString);
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", 2109);
    com.tencent.mm.ipcinvoker.f.a(i.azB().AY(paramString), localBundle, f.a.class, null);
    AppMethodBeat.o(10687);
  }
  
  private static String AX(String paramString)
  {
    AppMethodBeat.i(10689);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10689);
      return "";
    }
    paramString = Pattern.compile(":widgetId=.*:").matcher(paramString);
    if (paramString.matches())
    {
      paramString = paramString.group();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.substring(paramString.indexOf("=") + 1, paramString.lastIndexOf(":"));
        AppMethodBeat.o(10689);
        return paramString;
      }
    }
    AppMethodBeat.o(10689);
    return "";
  }
  
  public static f azz()
  {
    return hnu;
  }
  
  public static void n(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(10688);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpenWeappFial", true);
    localBundle.putInt("widgetState", paramInt);
    localBundle.putString("appid", paramString1);
    localBundle.putString("sceneNote", paramString2);
    com.tencent.mm.ipcinvoker.f.a(i.azB().AY(AX(paramString2)), localBundle, f.a.class, null);
    AppMethodBeat.o(10688);
  }
  
  public final boolean aZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(10686);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10686);
      return false;
    }
    if (!this.hnv.containsKey(paramString))
    {
      ab.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(10686);
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      boolean bool = ((f.b)this.hnv.get(paramString)).hnz.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(10686);
      return bool;
      j.azD().O(paramString, 628, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f
 * JD-Core Version:    0.7.0.1
 */