package com.tencent.mm.gpu.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static a gak;
  private Map<Integer, Map<Long, List<b>>> gal;
  private Handler gam;
  private HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(209422);
    gak = new a();
    AppMethodBeat.o(209422);
  }
  
  private a()
  {
    AppMethodBeat.i(209413);
    this.gal = new HashMap();
    this.mHandlerThread = new HandlerThread("OpenGLAllResRecorder");
    this.mHandlerThread.start();
    this.gam = new Handler(this.mHandlerThread.getLooper());
    this.gal.put(Integer.valueOf(1), new HashMap());
    this.gal.put(Integer.valueOf(2), new HashMap());
    this.gal.put(Integer.valueOf(3), new HashMap());
    this.gal.put(Integer.valueOf(4), new HashMap());
    AppMethodBeat.o(209413);
  }
  
  public static a aef()
  {
    return gak;
  }
  
  private int aeg()
  {
    AppMethodBeat.i(209417);
    synchronized (this.gal)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator1 = this.gal.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((Map)localIterator1.next()).keySet().iterator();
        if (localIterator2.hasNext()) {
          localHashSet.add((Long)localIterator2.next());
        }
      }
    }
    int i = localObject.size();
    AppMethodBeat.o(209417);
    return i;
  }
  
  private String aeh()
  {
    AppMethodBeat.i(209418);
    Object localObject3;
    synchronized (this.gal)
    {
      localObject2 = new HashSet();
      Iterator localIterator1 = this.gal.values().iterator();
      while (localIterator1.hasNext())
      {
        localObject3 = ((Map)localIterator1.next()).keySet().iterator();
        if (((Iterator)localObject3).hasNext()) {
          ((Set)localObject2).add((Long)((Iterator)localObject3).next());
        }
      }
    }
    Map localMap2 = (Map)this.gal.get(Integer.valueOf(1));
    Map localMap3 = (Map)this.gal.get(Integer.valueOf(2));
    Map localMap4 = (Map)this.gal.get(Integer.valueOf(3));
    Map localMap5 = (Map)this.gal.get(Integer.valueOf(4));
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
        AppMethodBeat.o(209418);
        return str1;
      }
    }
  }
  
  public final void V(final List<b> paramList)
  {
    AppMethodBeat.i(209414);
    this.gam.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209411);
        if ((paramList == null) || (paramList.size() == 0))
        {
          AppMethodBeat.o(209411);
          return;
        }
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          a.a(a.this, (b)paramList.get(i));
          i += 1;
        }
        AppMethodBeat.o(209411);
      }
    });
    AppMethodBeat.o(209414);
  }
  
  public final void W(final List<b> paramList)
  {
    AppMethodBeat.i(209415);
    this.gam.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209412);
        if ((paramList == null) || (paramList.size() == 0))
        {
          AppMethodBeat.o(209412);
          return;
        }
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          a.b(a.this, (b)paramList.get(i));
          i += 1;
        }
        AppMethodBeat.o(209412);
      }
    });
    AppMethodBeat.o(209415);
  }
  
  public final int lK(int paramInt)
  {
    AppMethodBeat.i(209416);
    Map localMap = (Map)this.gal.get(Integer.valueOf(paramInt));
    if (localMap == null)
    {
      AppMethodBeat.o(209416);
      return 0;
    }
    Iterator localIterator = localMap.keySet().iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      List localList = (List)localMap.get((Long)localIterator.next());
      if (localList != null) {
        paramInt = localList.size() + paramInt;
      }
    }
    AppMethodBeat.o(209416);
    return paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209419);
    Object localObject = new StringBuilder("(");
    String str1 = "TYPE_TEXTURES_CNT:" + lK(1);
    String str2 = "TYPE_TEXTURES_CNT:" + lK(2);
    String str3 = "TYPE_FRAMEBUFFERS_CNT:" + lK(3);
    String str4 = "TYPE_RENDERBUFFERS_CNT:" + lK(4);
    localObject = new StringBuilder().append(str1).append(" | ").append(str2).append(" | ").append(str3).append(" | ").append(str4).append(" | EGL CONTEXT CNT:").append(aeg()).toString() + ")    (" + aeh() + ")";
    AppMethodBeat.o(209419);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.d.a
 * JD-Core Version:    0.7.0.1
 */