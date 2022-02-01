package com.tencent.magicbrush.utils;

import android.os.SystemClock;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/magicbrush/utils/Util;", "", "()V", "TAG", "", "currentTicks", "", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "isNullOrNil", "", "str", "loadLibrary", "", "libName", "loader", "Ljava/lang/ClassLoader;", "nullAsNil", "qualityClose", "c", "Ljava/io/Closeable;", "quietlyClose", "closeable", "ticksToNow", "tick", "forEachCopyOnWrite", "T", "", "action", "Lkotlin/Function1;", "lock", "lib-magicbrush-nano_release"})
public final class h
{
  public static final h csR;
  
  static
  {
    AppMethodBeat.i(140303);
    csR = new h();
    AppMethodBeat.o(140303);
  }
  
  public static final long GC()
  {
    AppMethodBeat.i(140300);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(140300);
    return l;
  }
  
  public static final long aS(long paramLong)
  {
    AppMethodBeat.i(140301);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(140301);
    return l - paramLong;
  }
  
  public static final void cP(String paramString)
  {
    AppMethodBeat.i(140302);
    k.h(paramString, "libName");
    b.d("MagicBrush.Util", "System.loadLibrary " + paramString + ' ' + null, new Object[0]);
    System.loadLibrary(paramString);
    AppMethodBeat.o(140302);
  }
  
  public static final boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(140299);
    if ((paramString == null) || (k.g("", paramString)))
    {
      AppMethodBeat.o(140299);
      return true;
    }
    AppMethodBeat.o(140299);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.utils.h
 * JD-Core Version:    0.7.0.1
 */