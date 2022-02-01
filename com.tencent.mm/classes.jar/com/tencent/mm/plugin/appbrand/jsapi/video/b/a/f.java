package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.vfs.k;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
  implements Comparable<f>
{
  private static final Pattern lrc;
  public final k aXd;
  public final boolean bFZ;
  public final long bGa;
  public final long jLu;
  public final String key;
  public final long length;
  public final c lqP;
  public final long position;
  
  static
  {
    AppMethodBeat.i(211018);
    lrc = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    AppMethodBeat.o(211018);
  }
  
  private f(String paramString, long paramLong1, long paramLong2, long paramLong3, c paramc, boolean paramBoolean, long paramLong4, k paramk)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    this.jLu = paramLong3;
    this.lqP = paramc;
    this.bFZ = paramBoolean;
    this.aXd = paramk;
    this.bGa = paramLong4;
  }
  
  public static f C(k paramk)
  {
    AppMethodBeat.i(211015);
    Matcher localMatcher = lrc.matcher(paramk.getName());
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(211015);
      return null;
    }
    String str = localMatcher.group(1);
    long l1 = Long.parseLong(localMatcher.group(2));
    long l2 = Long.parseLong(localMatcher.group(3));
    c localc = c.Ry(localMatcher.group(4));
    long l3 = Long.parseLong(localMatcher.group(5));
    paramk = new f(str, l1, paramk.length(), l2, localc, true, l3, paramk);
    AppMethodBeat.o(211015);
    return paramk;
  }
  
  public static f S(String paramString, long paramLong)
  {
    AppMethodBeat.i(211012);
    paramString = new f(paramString, paramLong, -1L, -1L, c.lrO, false, -1L, null);
    AppMethodBeat.o(211012);
    return paramString;
  }
  
  public static f T(String paramString, long paramLong)
  {
    AppMethodBeat.i(211013);
    paramString = new f(paramString, paramLong, -1L, -1L, c.lrO, false, -1L, null);
    AppMethodBeat.o(211013);
    return paramString;
  }
  
  public static k a(k paramk, String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    AppMethodBeat.i(211011);
    paramString = new StringBuilder().append(paramString).append(".").append(paramLong1).append(".").append(paramLong2).append(".");
    if (TextUtils.isEmpty(paramc.lrT)) {
      paramc.lrT = c.Rv(paramc.lrS);
    }
    paramk = new k(paramk, paramc.lrT + "." + paramLong3 + ".v1.dat");
    AppMethodBeat.o(211011);
    return paramk;
  }
  
  public static f p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(211014);
    paramString = new f(paramString, paramLong1, paramLong2, -1L, c.lrO, false, -1L, null);
    AppMethodBeat.o(211014);
    return paramString;
  }
  
  public final int d(f paramf)
  {
    AppMethodBeat.i(211016);
    if (!this.key.equals(paramf.key))
    {
      int i = this.key.compareTo(paramf.key);
      AppMethodBeat.o(211016);
      return i;
    }
    long l = this.position - paramf.position;
    if (l == 0L)
    {
      AppMethodBeat.o(211016);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(211016);
      return -1;
    }
    AppMethodBeat.o(211016);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.f
 * JD-Core Version:    0.7.0.1
 */