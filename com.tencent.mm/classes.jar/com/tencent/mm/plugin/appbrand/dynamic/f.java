package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static f fTS = new f();
  Map<String, f.b> fTT = new ConcurrentHashMap();
  b.a fTU = new f.1(this);
  
  public static f aeW()
  {
    return fTS;
  }
  
  public static void f(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpenWeappFial", true);
    localBundle.putInt("widgetState", paramInt);
    localBundle.putString("appid", paramString1);
    localBundle.putString("sceneNote", paramString2);
    com.tencent.mm.ipcinvoker.f.a(i.aeX().sX(sW(paramString2)), localBundle, f.a.class, null);
  }
  
  public static void sV(String paramString)
  {
    Bundle localBundle = new Bundle();
    paramString = sW(paramString);
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", 2109);
    com.tencent.mm.ipcinvoker.f.a(i.aeX().sX(paramString), localBundle, f.a.class, null);
  }
  
  private static String sW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Pattern.compile(":widgetId=.*:").matcher(paramString);
    if (paramString.matches())
    {
      paramString = paramString.group();
      if (!TextUtils.isEmpty(paramString)) {
        return paramString.substring(paramString.indexOf("=") + 1, paramString.lastIndexOf(":"));
      }
    }
    return "";
  }
  
  public final boolean aH(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!this.fTT.containsKey(paramString))
    {
      y.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", new Object[] { paramString });
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return ((f.b)this.fTT.get(paramString)).fTX.add(Integer.valueOf(paramInt));
      j.aeZ().C(paramString, 628, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f
 * JD-Core Version:    0.7.0.1
 */