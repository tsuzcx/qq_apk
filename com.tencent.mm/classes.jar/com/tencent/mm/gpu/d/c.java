package com.tencent.mm.gpu.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static c gwv;
  private Map<Integer, Map<Long, List<d>>> gwr;
  public Handler gws;
  private HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(209660);
    gwv = new c();
    AppMethodBeat.o(209660);
  }
  
  private c()
  {
    AppMethodBeat.i(209651);
    this.gwr = new HashMap();
    this.mHandlerThread = new HandlerThread("OpenGLAllResRecorder");
    this.mHandlerThread.start();
    this.gws = new Handler(this.mHandlerThread.getLooper());
    this.gwr.put(Integer.valueOf(1), new HashMap());
    this.gwr.put(Integer.valueOf(2), new HashMap());
    this.gwr.put(Integer.valueOf(3), new HashMap());
    this.gwr.put(Integer.valueOf(4), new HashMap());
    AppMethodBeat.o(209651);
  }
  
  private String aha()
  {
    AppMethodBeat.i(209656);
    Object localObject3;
    synchronized (this.gwr)
    {
      localObject2 = new HashSet();
      Iterator localIterator1 = this.gwr.values().iterator();
      while (localIterator1.hasNext())
      {
        localObject3 = ((Map)localIterator1.next()).keySet().iterator();
        if (((Iterator)localObject3).hasNext()) {
          ((Set)localObject2).add((Long)((Iterator)localObject3).next());
        }
      }
    }
    Map localMap2 = (Map)this.gwr.get(Integer.valueOf(1));
    Map localMap3 = (Map)this.gwr.get(Integer.valueOf(2));
    Map localMap4 = (Map)this.gwr.get(Integer.valueOf(3));
    Map localMap5 = (Map)this.gwr.get(Integer.valueOf(4));
    String str1 = "";
    Iterator localIterator2 = ((Set)localObject2).iterator();
    String str2 = "";
    Long localLong;
    label232:
    int i;
    if (localIterator2.hasNext())
    {
      localLong = (Long)localIterator2.next();
      if (str1.equals(""))
      {
        str1 = String.valueOf(localLong);
        localObject3 = localLong + "-";
        localObject2 = (List)localMap2.get(localLong);
        if (localObject2 != null) {
          break label512;
        }
        i = 0;
        label273:
        localObject2 = localObject3;
        if (i > 0) {
          localObject2 = (String)localObject3 + "t" + i;
        }
        localObject3 = (List)localMap3.get(localLong);
        if (localObject3 != null) {
          break label522;
        }
        i = 0;
        label326:
        localObject3 = localObject2;
        if (i > 0) {
          localObject3 = (String)localObject2 + "b" + i;
        }
        localObject2 = (List)localMap4.get(localLong);
        if (localObject2 != null) {
          break label533;
        }
        i = 0;
        label377:
        if (i <= 0) {
          break label594;
        }
      }
    }
    label427:
    label591:
    label594:
    for (Object localObject2 = (String)localObject3 + "f" + i;; localObject2 = localObject3)
    {
      localObject3 = (List)localMap5.get(localLong);
      if (localObject3 == null)
      {
        i = 0;
        if (i <= 0) {
          break label591;
        }
        localObject2 = (String)localObject2 + "r" + i;
      }
      for (;;)
      {
        str2 = str2 + (String)localObject2 + "@";
        break;
        str1 = str1 + "," + localLong;
        break label232;
        i = ((List)localObject2).size();
        break label273;
        i = ((List)localObject3).size();
        break label326;
        i = ((List)localObject2).size();
        break label377;
        i = ((List)localObject3).size();
        break label427;
        str1 = "EGL CONTEXT IDS:[" + str1 + "],details:" + str2;
        AppMethodBeat.o(209656);
        return str1;
      }
    }
  }
  
  public static c ahb()
  {
    return gwv;
  }
  
  private int ahc()
  {
    AppMethodBeat.i(209655);
    synchronized (this.gwr)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator1 = this.gwr.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((Map)localIterator1.next()).keySet().iterator();
        if (localIterator2.hasNext()) {
          localHashSet.add((Long)localIterator2.next());
        }
      }
    }
    int i = localObject.size();
    AppMethodBeat.o(209655);
    return i;
  }
  
  public final void W(final List<d> paramList)
  {
    AppMethodBeat.i(209652);
    this.gws.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209647);
        if ((paramList == null) || (paramList.size() == 0))
        {
          AppMethodBeat.o(209647);
          return;
        }
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          c.a(c.this, (d)paramList.get(i));
          i += 1;
        }
        AppMethodBeat.o(209647);
      }
    });
    AppMethodBeat.o(209652);
  }
  
  public final void X(final List<d> paramList)
  {
    AppMethodBeat.i(209653);
    this.gws.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209648);
        if ((paramList == null) || (paramList.size() == 0))
        {
          AppMethodBeat.o(209648);
          return;
        }
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          c.b(c.this, (d)paramList.get(i));
          i += 1;
        }
        AppMethodBeat.o(209648);
      }
    });
    AppMethodBeat.o(209653);
  }
  
  public final int mm(int paramInt)
  {
    AppMethodBeat.i(209654);
    synchronized (this.gwr)
    {
      Map localMap2 = (Map)this.gwr.get(Integer.valueOf(paramInt));
      if (localMap2 == null)
      {
        AppMethodBeat.o(209654);
        return 0;
      }
      Iterator localIterator = localMap2.keySet().iterator();
      paramInt = 0;
      while (localIterator.hasNext())
      {
        List localList = (List)localMap2.get((Long)localIterator.next());
        if (localList != null) {
          paramInt += localList.size();
        }
      }
      AppMethodBeat.o(209654);
      return paramInt;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209657);
    Object localObject = new StringBuilder("(");
    String str1 = "TYPE_TEXTURES_CNT:" + mm(1);
    String str2 = "TYPE_TEXTURES_CNT:" + mm(2);
    String str3 = "TYPE_FRAMEBUFFERS_CNT:" + mm(3);
    String str4 = "TYPE_RENDERBUFFERS_CNT:" + mm(4);
    localObject = new StringBuilder().append(str1).append(" | ").append(str2).append(" | ").append(str3).append(" | ").append(str4).append(" | EGL CONTEXT CNT:").append(ahc()).toString() + ")    (" + aha() + ")";
    AppMethodBeat.o(209657);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.d.c
 * JD-Core Version:    0.7.0.1
 */