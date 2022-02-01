package com.tencent.mm.gpu.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static a gtJ;
  private Map<Integer, List<Long>> gtK;
  public Handler gtL;
  
  static
  {
    AppMethodBeat.i(219524);
    gtJ = new a();
    AppMethodBeat.o(219524);
  }
  
  private a()
  {
    AppMethodBeat.i(219516);
    this.gtK = new HashMap();
    HandlerThread localHandlerThread = new HandlerThread("EGLAllResRecorder");
    localHandlerThread.start();
    this.gtL = new Handler(localHandlerThread.getLooper());
    this.gtK.put(Integer.valueOf(17), new ArrayList());
    this.gtK.put(Integer.valueOf(18), new ArrayList());
    AppMethodBeat.o(219516);
  }
  
  public static a agK()
  {
    return gtJ;
  }
  
  private String agL()
  {
    AppMethodBeat.i(219521);
    for (;;)
    {
      synchronized (this.gtK)
      {
        Object localObject1 = (List)this.gtK.get(Integer.valueOf(17));
        localObject3 = (List)this.gtK.get(Integer.valueOf(18));
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
              AppMethodBeat.o(219521);
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
  
  private int mj(int paramInt)
  {
    AppMethodBeat.i(219519);
    synchronized (this.gtK)
    {
      List localList = (List)this.gtK.get(Integer.valueOf(paramInt));
      if (localList == null)
      {
        AppMethodBeat.o(219519);
        return 0;
      }
      paramInt = localList.size();
      AppMethodBeat.o(219519);
      return paramInt;
    }
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(219517);
    this.gtL.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219513);
        if (paramb == null)
        {
          AppMethodBeat.o(219513);
          return;
        }
        a.a(a.this, paramb);
        AppMethodBeat.o(219513);
      }
    });
    AppMethodBeat.o(219517);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(219518);
    this.gtL.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219514);
        if (paramb == null)
        {
          AppMethodBeat.o(219514);
          return;
        }
        a.b(a.this, paramb);
        AppMethodBeat.o(219514);
      }
    });
    AppMethodBeat.o(219518);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(219520);
    Object localObject = new StringBuilder("(");
    String str1 = "TYPE_CONTEXT_CNT:" + mj(17);
    String str2 = "TYPE_SURFACE_CNT:" + mj(18);
    localObject = new StringBuilder().append(str1).append(" | ").append(str2).toString() + ")    (" + agL() + ")";
    AppMethodBeat.o(219520);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.d.a
 * JD-Core Version:    0.7.0.1
 */