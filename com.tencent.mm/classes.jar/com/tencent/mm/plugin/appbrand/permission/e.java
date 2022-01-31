package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.app.a.a;
import com.tencent.luggage.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
{
  private static Map<String, List<a.a>> fxt = new HashMap();
  
  public static void a(String paramString, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      c.e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
    }
    for (;;)
    {
      return;
      paramString = (List)fxt.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((a.a)paramString.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        }
      }
    }
  }
  
  public static void a(String paramString, a.a parama)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      c.e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
      return;
    }
    List localList = (List)fxt.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      fxt.put(paramString, localObject);
    }
    ((List)localObject).add(parama);
  }
  
  @Deprecated
  public static void b(String paramString, a.a parama)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      c.e("Luggage.RequestPermissionRegistry", "setCallback fail, invalid arguments");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parama);
    fxt.put(paramString, localArrayList);
  }
  
  public static void vX(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      c.e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
    }
    do
    {
      return;
      paramString = (List)fxt.get(paramString);
    } while (paramString == null);
    paramString.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.e
 * JD-Core Version:    0.7.0.1
 */