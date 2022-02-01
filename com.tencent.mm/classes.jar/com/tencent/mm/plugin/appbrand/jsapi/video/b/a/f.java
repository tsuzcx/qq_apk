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
  private static final Pattern kQc;
  public final boolean bvL;
  public final long bvM;
  public final long jox;
  public final e kPM;
  public final c kPP;
  public final String key;
  public final long length;
  public final long position;
  
  static
  {
    AppMethodBeat.i(194179);
    kQc = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    AppMethodBeat.o(194179);
  }
  
  private f(String paramString, long paramLong1, long paramLong2, long paramLong3, c paramc, boolean paramBoolean, long paramLong4, e parame)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    this.jox = paramLong3;
    this.kPP = paramc;
    this.bvL = paramBoolean;
    this.kPM = parame;
    this.bvM = paramLong4;
  }
  
  public static f C(e parame)
  {
    AppMethodBeat.i(194176);
    Matcher localMatcher = kQc.matcher(parame.getName());
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(194176);
      return null;
    }
    String str = localMatcher.group(1);
    long l1 = Long.parseLong(localMatcher.group(2));
    long l2 = Long.parseLong(localMatcher.group(3));
    c localc = c.Ns(localMatcher.group(4));
    long l3 = Long.parseLong(localMatcher.group(5));
    parame = new f(str, l1, parame.length(), l2, localc, true, l3, parame);
    AppMethodBeat.o(194176);
    return parame;
  }
  
  public static f L(String paramString, long paramLong)
  {
    AppMethodBeat.i(194173);
    paramString = new f(paramString, paramLong, -1L, -1L, c.kQO, false, -1L, null);
    AppMethodBeat.o(194173);
    return paramString;
  }
  
  public static f M(String paramString, long paramLong)
  {
    AppMethodBeat.i(194174);
    paramString = new f(paramString, paramLong, -1L, -1L, c.kQO, false, -1L, null);
    AppMethodBeat.o(194174);
    return paramString;
  }
  
  public static e a(e parame, String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    AppMethodBeat.i(194172);
    paramString = new StringBuilder().append(paramString).append(".").append(paramLong1).append(".").append(paramLong2).append(".");
    if (TextUtils.isEmpty(paramc.kQT)) {
      paramc.kQT = c.Np(paramc.kQS);
    }
    parame = new e(parame, paramc.kQT + "." + paramLong3 + ".v1.dat");
    AppMethodBeat.o(194172);
    return parame;
  }
  
  public static f p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194175);
    paramString = new f(paramString, paramLong1, paramLong2, -1L, c.kQO, false, -1L, null);
    AppMethodBeat.o(194175);
    return paramString;
  }
  
  public final int d(f paramf)
  {
    AppMethodBeat.i(194177);
    if (!this.key.equals(paramf.key))
    {
      int i = this.key.compareTo(paramf.key);
      AppMethodBeat.o(194177);
      return i;
    }
    long l = this.position - paramf.position;
    if (l == 0L)
    {
      AppMethodBeat.o(194177);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(194177);
      return -1;
    }
    AppMethodBeat.o(194177);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.f
 * JD-Core Version:    0.7.0.1
 */