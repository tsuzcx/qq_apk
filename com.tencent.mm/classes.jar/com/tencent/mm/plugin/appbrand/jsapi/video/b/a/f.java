package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.vfs.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
  implements Comparable<f>
{
  private static final Pattern koJ;
  public final boolean byc;
  public final long byd;
  public final long iOo;
  public final String key;
  public final e kot;
  public final c kow;
  public final long length;
  public final long position;
  
  static
  {
    AppMethodBeat.i(193832);
    koJ = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    AppMethodBeat.o(193832);
  }
  
  private f(String paramString, long paramLong1, long paramLong2, long paramLong3, c paramc, boolean paramBoolean, long paramLong4, e parame)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    this.iOo = paramLong3;
    this.kow = paramc;
    this.byc = paramBoolean;
    this.kot = parame;
    this.byd = paramLong4;
  }
  
  public static f D(e parame)
  {
    AppMethodBeat.i(193829);
    Matcher localMatcher = koJ.matcher(parame.getName());
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(193829);
      return null;
    }
    String str = localMatcher.group(1);
    long l1 = Long.parseLong(localMatcher.group(2));
    long l2 = Long.parseLong(localMatcher.group(3));
    c localc = c.Jo(localMatcher.group(4));
    long l3 = Long.parseLong(localMatcher.group(5));
    parame = new f(str, l1, parame.length(), l2, localc, true, l3, parame);
    AppMethodBeat.o(193829);
    return parame;
  }
  
  public static f K(String paramString, long paramLong)
  {
    AppMethodBeat.i(193826);
    paramString = new f(paramString, paramLong, -1L, -1L, c.kpv, false, -1L, null);
    AppMethodBeat.o(193826);
    return paramString;
  }
  
  public static f L(String paramString, long paramLong)
  {
    AppMethodBeat.i(193827);
    paramString = new f(paramString, paramLong, -1L, -1L, c.kpv, false, -1L, null);
    AppMethodBeat.o(193827);
    return paramString;
  }
  
  public static e a(e parame, String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    AppMethodBeat.i(193825);
    paramString = new StringBuilder().append(paramString).append(".").append(paramLong1).append(".").append(paramLong2).append(".");
    if (TextUtils.isEmpty(paramc.kpA)) {
      paramc.kpA = c.Jl(paramc.kpz);
    }
    parame = new e(parame, paramc.kpA + "." + paramLong3 + ".v1.dat");
    AppMethodBeat.o(193825);
    return parame;
  }
  
  public static f s(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193828);
    paramString = new f(paramString, paramLong1, paramLong2, -1L, c.kpv, false, -1L, null);
    AppMethodBeat.o(193828);
    return paramString;
  }
  
  public final int d(f paramf)
  {
    AppMethodBeat.i(193830);
    if (!this.key.equals(paramf.key))
    {
      int i = this.key.compareTo(paramf.key);
      AppMethodBeat.o(193830);
      return i;
    }
    long l = this.position - paramf.position;
    if (l == 0L)
    {
      AppMethodBeat.o(193830);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(193830);
      return -1;
    }
    AppMethodBeat.o(193830);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.f
 * JD-Core Version:    0.7.0.1
 */