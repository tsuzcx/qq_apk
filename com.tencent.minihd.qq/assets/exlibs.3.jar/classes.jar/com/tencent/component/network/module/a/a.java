package com.tencent.component.network.module.a;

import android.content.Context;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.utils.NetworkUtils;
import cut;
import cuu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
{
  private final Map a = new HashMap();
  private final Map b = new HashMap();
  
  public static a a()
  {
    return cut.a;
  }
  
  private void a(List paramList, String paramString)
  {
    boolean bool2 = true;
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      cuu localcuu;
      int i;
      int k;
      int j;
      synchronized (this.b)
      {
        localcuu = (cuu)this.b.get(paramString);
        if (localcuu != null) {
          break label223;
        }
        localcuu = new cuu();
        this.b.put(paramString, localcuu);
        paramString = localcuu;
        paramList = paramList.iterator();
        i = 0;
        k = 0;
        j = 0;
        if (paramList.hasNext())
        {
          localcuu = (cuu)paramList.next();
          if (localcuu == null) {
            continue;
          }
          int m = j + 1;
          j = k;
          if (localcuu.a) {
            j = k + 1;
          }
          if (!localcuu.b) {
            break label220;
          }
          i += 1;
          k = j;
          j = m;
        }
      }
      if (j <= 0) {
        break;
      }
      if (k / j > 0.5F)
      {
        bool1 = true;
        paramString.a = bool1;
        if (i / j <= 0.5F) {
          break label214;
        }
      }
      label214:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramString.b = bool1;
        return;
        bool1 = false;
        break;
      }
      label220:
      continue;
      label223:
      paramString = localcuu;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!NetworkUtils.c(paramContext)) {
      return;
    }
    cuu localcuu = new cuu();
    localcuu.a = paramBoolean1;
    localcuu.b = paramBoolean2;
    synchronized (this.a)
    {
      String str = NetworkManager.a();
      com.tencent.component.network.module.a.a.a locala = (com.tencent.component.network.module.a.a.a)this.a.get(str);
      paramContext = locala;
      if (locala == null)
      {
        paramContext = new com.tencent.component.network.module.a.a.a(3, false);
        this.a.put(str, paramContext);
      }
      paramContext.add(0, localcuu);
      a(paramContext, str);
      return;
    }
  }
  
  public boolean a()
  {
    String str = NetworkManager.a();
    synchronized (this.b)
    {
      cuu localcuu2 = (cuu)this.b.get(str);
      cuu localcuu1 = localcuu2;
      if (localcuu2 == null)
      {
        localcuu1 = new cuu();
        this.b.put(str, localcuu1);
      }
      return localcuu1.a;
    }
  }
  
  public boolean b()
  {
    String str = NetworkManager.a();
    synchronized (this.b)
    {
      cuu localcuu2 = (cuu)this.b.get(str);
      cuu localcuu1 = localcuu2;
      if (localcuu2 == null)
      {
        localcuu1 = new cuu();
        this.b.put(str, localcuu1);
      }
      return localcuu1.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.a.a
 * JD-Core Version:    0.7.0.1
 */