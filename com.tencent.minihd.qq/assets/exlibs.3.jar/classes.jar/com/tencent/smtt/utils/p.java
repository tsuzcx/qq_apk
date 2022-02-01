package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class p
{
  private b a = null;
  private b b = null;
  
  private boolean a(b paramb1, b paramb2)
  {
    if ((paramb1 != null) && (paramb1.a() != null) && (paramb2 != null) && (paramb2.a() != null))
    {
      Object localObject1 = paramb1.a();
      paramb1 = paramb2.a();
      paramb2 = ((Map)localObject1).entrySet().iterator();
      while (paramb2.hasNext())
      {
        Object localObject2 = (Map.Entry)paramb2.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (a)((Map.Entry)localObject2).getValue();
        if (paramb1.containsKey(localObject1))
        {
          localObject1 = (a)paramb1.get(localObject1);
          if ((((a)localObject2).a() != ((a)localObject1).a()) || (((a)localObject2).b() != ((a)localObject1).b())) {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void a(File paramFile)
  {
    this.a = new b(paramFile);
  }
  
  public boolean a()
  {
    if ((this.b == null) || (this.a == null)) {}
    while ((this.b.a().size() != this.a.a().size()) || (!a(this.a, this.b))) {
      return false;
    }
    return true;
  }
  
  public void b(File paramFile)
  {
    this.b = new b(paramFile);
  }
  
  class a
  {
    private String b;
    private long c;
    private long d;
    
    a(String paramString, long paramLong1, long paramLong2)
    {
      this.b = paramString;
      this.c = paramLong1;
      this.d = paramLong2;
    }
    
    long a()
    {
      return this.c;
    }
    
    long b()
    {
      return this.d;
    }
  }
  
  class b
  {
    private Map<String, p.a> b = new HashMap();
    
    b(File paramFile)
    {
      this.b.clear();
      a(paramFile);
    }
    
    private void a(File paramFile)
    {
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        if ((paramFile != null) || (Build.VERSION.SDK_INT < 26)) {}
      }
      while (!paramFile.isFile()) {
        for (;;)
        {
          return;
          int i = 0;
          while (i < paramFile.length)
          {
            a(paramFile[i]);
            i += 1;
          }
        }
      }
      a(paramFile.getName(), paramFile.length(), paramFile.lastModified());
    }
    
    private void a(String paramString, long paramLong1, long paramLong2)
    {
      if ((paramString != null) && (paramString.length() > 0) && (paramLong1 > 0L) && (paramLong2 > 0L))
      {
        p.a locala = new p.a(p.this, paramString, paramLong1, paramLong2);
        if (!this.b.containsKey(paramString)) {
          this.b.put(paramString, locala);
        }
      }
    }
    
    Map<String, p.a> a()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.p
 * JD-Core Version:    0.7.0.1
 */