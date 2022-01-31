package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.f.a;
import com.tencent.mm.plugin.appbrand.page.q;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum n
{
  public static final Map<String, Integer> huc;
  public static final Set<String> hud;
  private static final a<q, aa> hue = new a();
  
  static
  {
    Object localObject = new HashSet();
    ((Set)localObject).add("text");
    ((Set)localObject).add("emoji");
    ((Set)localObject).add("number");
    ((Set)localObject).add("digit");
    ((Set)localObject).add("idcard");
    hud = Collections.unmodifiableSet((Set)localObject);
    localObject = new HashMap(3);
    ((Map)localObject).put("digit", Integer.valueOf(2));
    ((Map)localObject).put("number", Integer.valueOf(0));
    ((Map)localObject).put("idcard", Integer.valueOf(1));
    huc = Collections.unmodifiableMap((Map)localObject);
  }
  
  public static z a(q paramq, int paramInt)
  {
    return e.a(paramq, new n.1(paramInt));
  }
  
  static void a(q paramq, aa paramaa)
  {
    if (paramq == null) {
      return;
    }
    com.tencent.mm.plugin.appbrand.u.n.runOnUiThread(new n.3(paramq, paramaa));
  }
  
  public static void a(q paramq, String paramString, Integer paramInteger)
  {
    if (paramq == null) {
      return;
    }
    com.tencent.mm.plugin.appbrand.u.n.runOnUiThread(new n.2(paramq, paramString, paramInteger));
  }
  
  public static boolean a(q paramq, int paramInt1, int paramInt2, int paramInt3)
  {
    z localz = a(paramq, paramInt1);
    return (localz != null) && (localz.isAttachedTo(paramq)) && (localz.showKeyboard(paramInt2, paramInt3));
  }
  
  public static boolean a(q paramq, Integer paramInteger)
  {
    Integer localInteger = paramInteger;
    if (paramInteger == null)
    {
      paramInteger = (aa)hue.get(paramq);
      if (paramInteger == null) {
        return false;
      }
      localInteger = Integer.valueOf(paramInteger.getInputId());
    }
    paramq = a(paramq, localInteger.intValue());
    return (paramq != null) && (paramq.hideKeyboard());
  }
  
  static void b(q paramq, z paramz)
  {
    e.a(paramq, paramz);
  }
  
  public static boolean b(q paramq, int paramInt)
  {
    paramq = a(paramq, paramInt);
    return (paramq != null) && (paramq.removeSelf());
  }
  
  public static void v(q paramq)
  {
    if (paramq != null) {
      new k(paramq);
    }
  }
  
  public static boolean w(q paramq)
  {
    return a(paramq, null);
  }
  
  static void x(q paramq)
  {
    if (paramq == null) {
      return;
    }
    com.tencent.mm.plugin.appbrand.u.n.runOnUiThread(new n.4(paramq));
  }
  
  static z y(q paramq)
  {
    if (paramq == null) {
      return null;
    }
    aa localaa = (aa)hue.get(paramq);
    if (localaa == null) {
      return null;
    }
    return a(paramq, localaa.getInputId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.n
 * JD-Core Version:    0.7.0.1
 */