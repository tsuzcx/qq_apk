package com.tencent.mm.gpu.d;

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
  private static a hje;
  private Map<Integer, List<Long>> hjf;
  public Handler hjg;
  
  static
  {
    AppMethodBeat.i(186178);
    hje = new a();
    AppMethodBeat.o(186178);
  }
  
  private a()
  {
    AppMethodBeat.i(186170);
    this.hjf = new HashMap();
    HandlerThread localHandlerThread = new HandlerThread("EGLAllResRecorder");
    localHandlerThread.start();
    this.hjg = new Handler(localHandlerThread.getLooper());
    this.hjf.put(Integer.valueOf(17), new ArrayList());
    this.hjf.put(Integer.valueOf(18), new ArrayList());
    AppMethodBeat.o(186170);
  }
  
  public static a axl()
  {
    return hje;
  }
  
  private String axm()
  {
    AppMethodBeat.i(186175);
    for (;;)
    {
      synchronized (this.hjf)
      {
        Object localObject1 = (List)this.hjf.get(Integer.valueOf(17));
        localObject3 = (List)this.hjf.get(Integer.valueOf(18));
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
              AppMethodBeat.o(186175);
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
  
  private int pz(int paramInt)
  {
    AppMethodBeat.i(186173);
    synchronized (this.hjf)
    {
      List localList = (List)this.hjf.get(Integer.valueOf(paramInt));
      if (localList == null)
      {
        AppMethodBeat.o(186173);
        return 0;
      }
      paramInt = localList.size();
      AppMethodBeat.o(186173);
      return paramInt;
    }
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(186171);
    this.hjg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186167);
        if (paramb == null)
        {
          AppMethodBeat.o(186167);
          return;
        }
        a.a(a.this, paramb);
        AppMethodBeat.o(186167);
      }
    });
    AppMethodBeat.o(186171);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(186172);
    this.hjg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186168);
        if (paramb == null)
        {
          AppMethodBeat.o(186168);
          return;
        }
        a.b(a.this, paramb);
        AppMethodBeat.o(186168);
      }
    });
    AppMethodBeat.o(186172);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186174);
    Object localObject = new StringBuilder("(");
    String str1 = "TYPE_CONTEXT_CNT:" + pz(17);
    String str2 = "TYPE_SURFACE_CNT:" + pz(18);
    localObject = new StringBuilder().append(str1).append(" | ").append(str2).toString() + ")    (" + axm() + ")";
    AppMethodBeat.o(186174);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.d.a
 * JD-Core Version:    0.7.0.1
 */