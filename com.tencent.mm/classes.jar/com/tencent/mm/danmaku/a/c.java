package com.tencent.mm.danmaku.a;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static boolean gNA;
  private static Application gNz;
  
  public static Application arU()
  {
    AppMethodBeat.i(241600);
    if (gNz == null)
    {
      localObject = new RuntimeException("Danmaku not init, please call DanmakuConfig.init()");
      AppMethodBeat.o(241600);
      throw ((Throwable)localObject);
    }
    Object localObject = gNz;
    AppMethodBeat.o(241600);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.c
 * JD-Core Version:    0.7.0.1
 */