package com.tencent.mm.gpu.e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static b jVe;
  public Handler jVc;
  private final Map<Integer, Map<Long, List<Object>>> jVf;
  private final Map<Integer, Map<Long, List<Object>>> jVg;
  private HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(210742);
    jVe = new b();
    AppMethodBeat.o(210742);
  }
  
  private b()
  {
    AppMethodBeat.i(210731);
    this.jVf = new HashMap();
    this.jVg = new HashMap();
    this.mHandlerThread = new HandlerThread("OpenGLAllResRecorder");
    this.mHandlerThread.start();
    this.jVc = new Handler(this.mHandlerThread.getLooper());
    this.jVf.put(Integer.valueOf(4352), new HashMap());
    this.jVf.put(Integer.valueOf(4353), new HashMap());
    this.jVf.put(Integer.valueOf(4354), new HashMap());
    this.jVf.put(Integer.valueOf(4355), new HashMap());
    this.jVg.put(Integer.valueOf(4352), new HashMap());
    this.jVg.put(Integer.valueOf(4353), new HashMap());
    this.jVg.put(Integer.valueOf(4354), new HashMap());
    this.jVg.put(Integer.valueOf(4355), new HashMap());
    AppMethodBeat.o(210731);
  }
  
  public static b aEL()
  {
    return jVe;
  }
  
  private int aEM()
  {
    AppMethodBeat.i(210737);
    synchronized (this.jVg)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.jVg.values().iterator();
      if (localIterator.hasNext()) {
        localHashSet.addAll(((Map)localIterator.next()).keySet());
      }
    }
    int i = localObject.size();
    AppMethodBeat.o(210737);
    return i;
  }
  
  private Map<Integer, Map<Long, List<Object>>> rW(int paramInt)
  {
    AppMethodBeat.i(210734);
    if (paramInt == 4369) {}
    for (Object localObject = this.jVf;; localObject = this.jVg)
    {
      AppMethodBeat.o(210734);
      return localObject;
      if (paramInt != 8738) {
        break;
      }
    }
    Log.e("MicroMsg.OpenGLAllResRecorder", "unkonw recordType with ".concat(String.valueOf(paramInt)));
    localObject = new HashMap();
    AppMethodBeat.o(210734);
    return localObject;
  }
  
  private String rX(int paramInt)
  {
    AppMethodBeat.i(210738);
    synchronized (rW(paramInt))
    {
      localObject3 = new HashSet();
      Iterator localIterator1 = ???.values().iterator();
      if (localIterator1.hasNext()) {
        ((Set)localObject3).addAll(((Map)localIterator1.next()).keySet());
      }
    }
    Map localMap2 = (Map)???.get(Integer.valueOf(4352));
    Map localMap3 = (Map)???.get(Integer.valueOf(4353));
    Map localMap4 = (Map)???.get(Integer.valueOf(4354));
    Map localMap5 = (Map)???.get(Integer.valueOf(4355));
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = ((Set)localObject3).iterator();
    Long localLong;
    label224:
    Object localObject4;
    if (localIterator2.hasNext())
    {
      localLong = (Long)localIterator2.next();
      if (((StringBuilder)localObject2).toString().equals(""))
      {
        localObject2 = new StringBuilder(String.valueOf(localLong));
        localObject4 = localLong + "-";
        localObject3 = (List)localMap2.get(localLong);
        if (localObject3 != null) {
          break label477;
        }
        paramInt = 0;
        label265:
        localObject3 = localObject4;
        if (paramInt > 0) {
          localObject3 = (String)localObject4 + "t" + paramInt;
        }
        localObject4 = (List)localMap3.get(localLong);
        if (localObject4 != null) {
          break label487;
        }
        paramInt = 0;
        label318:
        localObject4 = localObject3;
        if (paramInt > 0) {
          localObject4 = (String)localObject3 + "b" + paramInt;
        }
        localObject3 = (List)localMap4.get(localLong);
        if (localObject3 != null) {
          break label498;
        }
        paramInt = 0;
        label369:
        if (paramInt <= 0) {
          break label559;
        }
      }
    }
    label419:
    label556:
    label559:
    for (Object localObject3 = (String)localObject4 + "f" + paramInt;; localObject3 = localObject4)
    {
      localObject4 = (List)localMap5.get(localLong);
      if (localObject4 == null)
      {
        paramInt = 0;
        if (paramInt <= 0) {
          break label556;
        }
        localObject3 = (String)localObject3 + "r" + paramInt;
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject3).append("@");
        break;
        ((StringBuilder)localObject2).append(",").append(localLong);
        break label224;
        label477:
        paramInt = ((List)localObject3).size();
        break label265;
        label487:
        paramInt = ((List)localObject4).size();
        break label318;
        label498:
        paramInt = ((List)localObject3).size();
        break label369;
        paramInt = ((List)localObject4).size();
        break label419;
        localObject2 = "EGL CONTEXT IDS:[" + localObject2 + "],details:" + localStringBuilder;
        AppMethodBeat.o(210738);
        return localObject2;
      }
    }
  }
  
  private String rY(int paramInt)
  {
    AppMethodBeat.i(210739);
    String str1 = "TYPE_TEXTURES_CNT:" + dh(4352, paramInt);
    String str2 = "TYPE_BUFFERS_STR:" + dh(4353, paramInt);
    String str3 = "TYPE_FRAMEBUFFERS_CNT:" + dh(4354, paramInt);
    String str4 = "TYPE_RENDERBUFFERS_CNT:" + dh(4355, paramInt);
    str1 = str1 + " | " + str2 + " | " + str3 + " | " + str4 + " | EGL CONTEXT CNT:" + aEM();
    AppMethodBeat.o(210739);
    return str1;
  }
  
  public final int dh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210736);
    synchronized (rW(paramInt2))
    {
      Map localMap2 = (Map)???.get(Integer.valueOf(paramInt1));
      if (localMap2 == null)
      {
        AppMethodBeat.o(210736);
        return 0;
      }
      Iterator localIterator = localMap2.keySet().iterator();
      paramInt1 = 0;
      while (localIterator.hasNext())
      {
        List localList = (List)localMap2.get((Long)localIterator.next());
        if (localList != null) {
          paramInt1 += localList.size();
        }
      }
      AppMethodBeat.o(210736);
      return paramInt1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210741);
    String str = "openGL records: \n (" + rY(4369) + ") (" + rX(4369) + ") \nEGL records: \n(" + rY(8738) + ") (" + rX(8738) + ") \n";
    AppMethodBeat.o(210741);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.gpu.e.b
 * JD-Core Version:    0.7.0.1
 */