package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.vfs.o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
  implements Comparable<f>
{
  private static final Pattern mxI;
  public final boolean bGq;
  public final long bGr;
  public final o file;
  public final long kNt;
  public final String key;
  public final long length;
  public final c mxv;
  public final long position;
  
  static
  {
    AppMethodBeat.i(234687);
    mxI = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    AppMethodBeat.o(234687);
  }
  
  private f(String paramString, long paramLong1, long paramLong2, long paramLong3, c paramc, boolean paramBoolean, long paramLong4, o paramo)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    this.kNt = paramLong3;
    this.mxv = paramc;
    this.bGq = paramBoolean;
    this.file = paramo;
    this.bGr = paramLong4;
  }
  
  public static f B(o paramo)
  {
    AppMethodBeat.i(234684);
    Matcher localMatcher = mxI.matcher(paramo.getName());
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(234684);
      return null;
    }
    String str = localMatcher.group(1);
    long l1 = Long.parseLong(localMatcher.group(2));
    long l2 = Long.parseLong(localMatcher.group(3));
    c localc = c.abe(localMatcher.group(4));
    long l3 = Long.parseLong(localMatcher.group(5));
    paramo = new f(str, l1, paramo.length(), l2, localc, true, l3, paramo);
    AppMethodBeat.o(234684);
    return paramo;
  }
  
  public static f S(String paramString, long paramLong)
  {
    AppMethodBeat.i(234681);
    paramString = new f(paramString, paramLong, -1L, -1L, c.myu, false, -1L, null);
    AppMethodBeat.o(234681);
    return paramString;
  }
  
  public static f T(String paramString, long paramLong)
  {
    AppMethodBeat.i(234682);
    paramString = new f(paramString, paramLong, -1L, -1L, c.myu, false, -1L, null);
    AppMethodBeat.o(234682);
    return paramString;
  }
  
  public static o a(o paramo, String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    AppMethodBeat.i(234680);
    paramString = new StringBuilder().append(paramString).append(".").append(paramLong1).append(".").append(paramLong2).append(".");
    if (TextUtils.isEmpty(paramc.myz)) {
      paramc.myz = c.abb(paramc.myy);
    }
    paramo = new o(paramo, paramc.myz + "." + paramLong3 + ".v1.dat");
    AppMethodBeat.o(234680);
    return paramo;
  }
  
  public static f p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(234683);
    paramString = new f(paramString, paramLong1, paramLong2, -1L, c.myu, false, -1L, null);
    AppMethodBeat.o(234683);
    return paramString;
  }
  
  public final int d(f paramf)
  {
    AppMethodBeat.i(234685);
    if (!this.key.equals(paramf.key))
    {
      int i = this.key.compareTo(paramf.key);
      AppMethodBeat.o(234685);
      return i;
    }
    long l = this.position - paramf.position;
    if (l == 0L)
    {
      AppMethodBeat.o(234685);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(234685);
      return -1;
    }
    AppMethodBeat.o(234685);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.f
 * JD-Core Version:    0.7.0.1
 */