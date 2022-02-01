package com.tencent.magicbrush.utils;

import android.os.SystemClock;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/utils/Util;", "", "()V", "TAG", "", "currentTicks", "", "findLibPath", "libName", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "isNullOrNil", "", "str", "loadLibrary", "", "loader", "Ljava/lang/ClassLoader;", "nullAsNil", "qualityClose", "c", "Ljava/io/Closeable;", "quietlyClose", "closeable", "ticksToNow", "tick", "forEachCopyOnWrite", "T", "", "action", "Lkotlin/Function1;", "lock", "lib-magicbrush-nano_release"})
public final class i
{
  public static final i cQr;
  
  static
  {
    AppMethodBeat.i(140303);
    cQr = new i();
    AppMethodBeat.o(140303);
  }
  
  public static final long currentTicks()
  {
    AppMethodBeat.i(140300);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(140300);
    return l;
  }
  
  public static final void eG(String paramString)
  {
    AppMethodBeat.i(140302);
    p.k(paramString, "libName");
    b.d("MagicBrush.Util", "System.loadLibrary " + paramString + ' ' + null, new Object[0]);
    System.loadLibrary(paramString);
    AppMethodBeat.o(140302);
  }
  
  public static final String findLibPath(String paramString)
  {
    AppMethodBeat.i(206338);
    p.k(paramString, "libName");
    b.d("MagicBrush.Util", "hy: try find lib path " + paramString + " with dummy imp", new Object[0]);
    AppMethodBeat.o(206338);
    return "";
  }
  
  public static final boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(140299);
    if ((paramString == null) || (p.h("", paramString)))
    {
      AppMethodBeat.o(140299);
      return true;
    }
    AppMethodBeat.o(140299);
    return false;
  }
  
  public static final long ticksToNow(long paramLong)
  {
    AppMethodBeat.i(140301);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(140301);
    return l - paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.utils.i
 * JD-Core Version:    0.7.0.1
 */