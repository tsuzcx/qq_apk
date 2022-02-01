package com.tencent.mm.gpu.e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static a jVa;
  private final Map<Integer, List<Long>> jVb;
  public Handler jVc;
  
  static
  {
    AppMethodBeat.i(210685);
    jVa = new a();
    AppMethodBeat.o(210685);
  }
  
  private a()
  {
    AppMethodBeat.i(210679);
    this.jVb = new HashMap();
    HandlerThread localHandlerThread = new HandlerThread("EGLAllResRecorder");
    localHandlerThread.start();
    this.jVc = new Handler(localHandlerThread.getLooper());
    this.jVb.put(Integer.valueOf(17), new ArrayList());
    this.jVb.put(Integer.valueOf(18), new ArrayList());
    AppMethodBeat.o(210679);
  }
  
  public static a aEJ()
  {
    return jVa;
  }
  
  private String aEK()
  {
    AppMethodBeat.i(210683);
    for (;;)
    {
      synchronized (this.jVb)
      {
        Object localObject1 = (List)this.jVb.get(Integer.valueOf(17));
        localObject3 = (List)this.jVb.get(Integer.valueOf(18));
        if (localObject1 != null)
        {
          if (((List)localObject1).size() == 0)
          {
            break label141;
            if (localObject3 == null) {
              break label147;
            }
            if (((List)localObject3).size() == 0)
            {
              break label147;
              localObject1 = "egl context detail: " + (String)localObject1 + "\negl surface detail: " + (String)localObject3;
              AppMethodBeat.o(210683);
              return localObject1;
            }
          }
          else
          {
            localObject1 = localObject1.toString();
            continue;
          }
          localObject3 = localObject3.toString();
        }
      }
      label141:
      String str = "[null]";
      continue;
      label147:
      Object localObject3 = "[null]";
    }
  }
  
  private int rV(int paramInt)
  {
    AppMethodBeat.i(210680);
    synchronized (this.jVb)
    {
      List localList = (List)this.jVb.get(Integer.valueOf(paramInt));
      if (localList == null)
      {
        AppMethodBeat.o(210680);
        return 0;
      }
      paramInt = localList.size();
      AppMethodBeat.o(210680);
      return paramInt;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210682);
    Object localObject = new StringBuilder("(");
    String str1 = "TYPE_CONTEXT_CNT:" + rV(17);
    String str2 = "TYPE_SURFACE_CNT:" + rV(18);
    localObject = new StringBuilder().append(str1).append(" | ").append(str2).toString() + ")    (" + aEK() + ")";
    AppMethodBeat.o(210682);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.gpu.e.a
 * JD-Core Version:    0.7.0.1
 */