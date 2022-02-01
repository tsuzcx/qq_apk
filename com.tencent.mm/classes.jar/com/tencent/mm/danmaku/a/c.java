package com.tencent.mm.danmaku.a;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static Application jxU;
  public static boolean jxV;
  
  public static Application ayF()
  {
    AppMethodBeat.i(290677);
    if (jxU == null)
    {
      localObject = new RuntimeException("Danmaku not init, please call DanmakuConfig.init()");
      AppMethodBeat.o(290677);
      throw ((Throwable)localObject);
    }
    Object localObject = jxU;
    AppMethodBeat.o(290677);
    return localObject;
  }
  
  public static void h(Application paramApplication)
  {
    jxU = paramApplication;
    jxV = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.c
 * JD-Core Version:    0.7.0.1
 */