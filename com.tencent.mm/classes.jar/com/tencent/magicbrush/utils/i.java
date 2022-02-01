package com.tencent.magicbrush.utils;

import android.os.SystemClock;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/Util;", "", "()V", "TAG", "", "currentTicks", "", "findLibPath", "libName", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "isNullOrNil", "", "str", "loadLibrary", "", "loader", "Ljava/lang/ClassLoader;", "nullAsNil", "qualityClose", "c", "Ljava/io/Closeable;", "quietlyClose", "closeable", "ticksToNow", "tick", "forEachCopyOnWrite", "T", "", "action", "Lkotlin/Function1;", "lock", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class i
{
  public static final i eLv;
  
  static
  {
    AppMethodBeat.i(140303);
    eLv = new i();
    AppMethodBeat.o(140303);
  }
  
  public static final long currentTicks()
  {
    AppMethodBeat.i(140300);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(140300);
    return l;
  }
  
  public static final String findLibPath(String paramString)
  {
    AppMethodBeat.i(228785);
    s.t(paramString, "libName");
    b.d("MagicBrush.Util", "hy: try find lib path " + paramString + " with dummy imp", new Object[0]);
    AppMethodBeat.o(228785);
    return "";
  }
  
  public static final void ge(String paramString)
  {
    AppMethodBeat.i(140302);
    s.t(paramString, "libName");
    b.d("MagicBrush.Util", "System.loadLibrary " + paramString + ' ' + null, new Object[0]);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/tencent/magicbrush/utils/Util", "loadLibrary", "(Ljava/lang/String;Ljava/lang/ClassLoader;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/magicbrush/utils/Util", "loadLibrary", "(Ljava/lang/String;Ljava/lang/ClassLoader;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(140302);
  }
  
  public static final boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(140299);
    if ((paramString == null) || (s.p("", paramString)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.utils.i
 * JD-Core Version:    0.7.0.1
 */