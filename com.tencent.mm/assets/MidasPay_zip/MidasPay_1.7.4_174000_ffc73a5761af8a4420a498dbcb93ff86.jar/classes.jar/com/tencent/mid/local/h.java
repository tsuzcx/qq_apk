package com.tencent.mid.local;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class h
{
  private static h b;
  private Map<Integer, g> a = null;
  
  private h(Context paramContext)
  {
    this.a.put(Integer.valueOf(1), new f(paramContext));
    this.a.put(Integer.valueOf(2), new b(paramContext));
    this.a.put(Integer.valueOf(4), new d(paramContext));
  }
  
  static h a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new h(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  c a()
  {
    return a(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
  }
  
  c a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Integer)paramList.next();
        localObject = (g)this.a.get(localObject);
        if (localObject != null)
        {
          localObject = ((g)localObject).d();
          if ((localObject != null) && (((c)localObject).a())) {
            return localObject;
          }
        }
      }
    }
    return new c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.h
 * JD-Core Version:    0.7.0.1
 */