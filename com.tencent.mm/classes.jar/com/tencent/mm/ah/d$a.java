package com.tencent.mm.ah;

import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentHashMap;

public final class d$a
{
  private static ConcurrentHashMap<Object, d> ecP = new ConcurrentHashMap();
  
  public static void a(d paramd)
  {
    y.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(12399999), Integer.valueOf(0) });
    ecP.put(Integer.valueOf(0), paramd);
    e.d.a(Integer.valueOf(12399999), paramd);
  }
  
  public static d aA(Object paramObject)
  {
    return (d)ecP.get(paramObject);
  }
  
  public static void b(d paramd)
  {
    y.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(12399999), Integer.valueOf(0) });
    ecP.remove(Integer.valueOf(0));
    e.d.b(Integer.valueOf(12399999), paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.d.a
 * JD-Core Version:    0.7.0.1
 */