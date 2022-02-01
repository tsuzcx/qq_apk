package com.tencent.mm.gpu.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static a gwq;
  private Map<Integer, List<Long>> gwr;
  public Handler gws;
  
  static
  {
    AppMethodBeat.i(209646);
    gwq = new a();
    AppMethodBeat.o(209646);
  }
  
  private a()
  {
    AppMethodBeat.i(209638);
    this.gwr = new HashMap();
    HandlerThread localHandlerThread = new HandlerThread("EGLAllResRecorder");
    localHandlerThread.start();
    this.gws = new Handler(localHandlerThread.getLooper());
    this.gwr.put(Integer.valueOf(17), new ArrayList());
    this.gwr.put(Integer.valueOf(18), new ArrayList());
    AppMethodBeat.o(209638);
  }
  
  public static a agZ()
  {
    return gwq;
  }
  
  private String aha()
  {
    AppMethodBeat.i(209643);
    for (;;)
    {
      synchronized (this.gwr)
      {
        Object localObject1 = (List)this.gwr.get(Integer.valueOf(17));
        localObject3 = (List)this.gwr.get(Integer.valueOf(18));
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
              AppMethodBeat.o(209643);
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
  
  private int mm(int paramInt)
  {
    AppMethodBeat.i(209641);
    synchronized (this.gwr)
    {
      List localList = (List)this.gwr.get(Integer.valueOf(paramInt));
      if (localList == null)
      {
        AppMethodBeat.o(209641);
        return 0;
      }
      paramInt = localList.size();
      AppMethodBeat.o(209641);
      return paramInt;
    }
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(209639);
    this.gws.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209635);
        if (paramb == null)
        {
          AppMethodBeat.o(209635);
          return;
        }
        a.a(a.this, paramb);
        AppMethodBeat.o(209635);
      }
    });
    AppMethodBeat.o(209639);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(209640);
    this.gws.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209636);
        if (paramb == null)
        {
          AppMethodBeat.o(209636);
          return;
        }
        a.b(a.this, paramb);
        AppMethodBeat.o(209636);
      }
    });
    AppMethodBeat.o(209640);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209642);
    Object localObject = new StringBuilder("(");
    String str1 = "TYPE_CONTEXT_CNT:" + mm(17);
    String str2 = "TYPE_SURFACE_CNT:" + mm(18);
    localObject = new StringBuilder().append(str1).append(" | ").append(str2).toString() + ")    (" + aha() + ")";
    AppMethodBeat.o(209642);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.d.a
 * JD-Core Version:    0.7.0.1
 */