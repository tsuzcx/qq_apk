package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
{
  private static c e;
  private static boolean g = false;
  private String a = "EmergenceMsgPublisher";
  private String b = "tbs_emergence";
  private String c = "emergence_executed_ids";
  private String d = "emergence_ids";
  private final Map<Integer, a> f = new LinkedHashMap();
  
  public static c a()
  {
    if (e == null) {
      e = new c();
    }
    return e;
  }
  
  private void a(Context paramContext, b paramb, a parama)
  {
    if (parama != null)
    {
      a("Executed command: " + paramb.b + ", extra: " + paramb.c);
      parama.a(paramb.c);
      paramContext = paramContext.getSharedPreferences(this.b, 4);
      Object localObject = paramContext.getString(this.c, "");
      parama = new HashSet();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if ((localObject != null) && (localObject.length > 0)) {
          try
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              parama.add(Integer.valueOf(Integer.parseInt(localObject[i])));
              i += 1;
            }
            parama.add(Integer.valueOf(paramb.a));
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
      paramb = new StringBuilder();
      parama = parama.iterator();
      while (parama.hasNext())
      {
        paramb.append((Integer)parama.next());
        paramb.append(",");
      }
      paramContext = paramContext.edit();
      paramContext.putString(this.c, paramb.toString());
      paramContext.commit();
    }
  }
  
  private void a(String paramString) {}
  
  public Map<Integer, b> a(Context paramContext)
  {
    int k = 0;
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramContext.getSharedPreferences(this.b, 0);
    if (paramContext == null)
    {
      a("Unexpected null context!");
      return localHashMap;
    }
    paramContext = ((SharedPreferences)localObject1).getString(this.d, "");
    if (TextUtils.isEmpty(paramContext))
    {
      a("Empty local emergence ids!");
      return localHashMap;
    }
    a("Local emergence ids: " + paramContext);
    paramContext = paramContext.split(";");
    int j;
    int i;
    Object localObject2;
    if (paramContext != null)
    {
      j = paramContext.length;
      i = 0;
      if (i < j)
      {
        localObject2 = paramContext[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
    for (;;)
    {
      i += 1;
      break;
      String[] arrayOfString = ((String)localObject2).split(",");
      if ((arrayOfString == null) || (arrayOfString.length != 4)) {
        continue;
      }
      localObject2 = new b();
      try
      {
        ((b)localObject2).a = Integer.parseInt(arrayOfString[0]);
        ((b)localObject2).b = Integer.parseInt(arrayOfString[1]);
        ((b)localObject2).c = String.valueOf(arrayOfString[2]);
        ((b)localObject2).d = Long.parseLong(arrayOfString[3]);
        label208:
        if (System.currentTimeMillis() >= ((b)localObject2).d) {
          continue;
        }
        localHashMap.put(Integer.valueOf(((b)localObject2).a), localObject2);
        continue;
        paramContext = ((SharedPreferences)localObject1).getString(this.c, "");
        a("Executed ids: " + paramContext);
        paramContext = paramContext.split(",");
        if (paramContext != null)
        {
          localObject1 = new ArrayList();
          int n = paramContext.length;
          i = 0;
          j = k;
          if (i < n)
          {
            localObject2 = paramContext[i];
            if (TextUtils.isEmpty((CharSequence)localObject2)) {}
            for (;;)
            {
              i += 1;
              break;
              j = -1;
              try
              {
                int m = Integer.parseInt((String)localObject2);
                j = m;
              }
              catch (Throwable localThrowable1)
              {
                for (;;)
                {
                  localThrowable1.printStackTrace();
                }
              }
              if (j > 0) {
                ((List)localObject1).add(Integer.valueOf(j));
              }
            }
          }
          while (j < ((List)localObject1).size())
          {
            localHashMap.remove(((List)localObject1).get(j));
            j += 1;
          }
        }
        return localHashMap;
      }
      catch (Throwable localThrowable2)
      {
        break label208;
      }
    }
  }
  
  public void a(Context paramContext, Integer paramInteger, a parama)
  {
    Map localMap = a(paramContext);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localb = (b)localMap.get((Integer)localIterator.next());
      if (localb == null) {
        a("Unexpected null command!");
      } else if (localb.b == paramInteger.intValue()) {
        a(paramContext, localb, parama);
      }
    }
    while (g)
    {
      b localb;
      return;
    }
    this.f.put(paramInteger, parama);
    a("Emergence config did not arrived yet, code[" + paramInteger + "] has been suspended");
  }
  
  public void b(Context paramContext)
  {
    Map localMap = a(paramContext);
    a("On notify emergence, validate commands: " + localMap);
    g = true;
    Iterator localIterator1 = this.f.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Integer localInteger1 = (Integer)localIterator1.next();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        Integer localInteger2 = (Integer)localIterator2.next();
        if (((b)localMap.get(localInteger2)).b == localInteger1.intValue()) {
          a(paramContext, (b)localMap.get(localInteger2), (a)this.f.get(localInteger1));
        }
      }
    }
    if (!this.f.isEmpty())
    {
      a("Emergency code[" + this.f.keySet() + "] did not happen, clear suspended queries");
      this.f.clear();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
  
  public static class b
  {
    public int a = -1;
    public int b = -1;
    public String c = "";
    public long d = -1L;
    
    public String toString()
    {
      return "{seqId=" + this.a + ", code=" + this.b + ", extra='" + this.c + '\'' + ", expired=" + this.d + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */