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
  private static final Pattern lmC;
  public final e aXd;
  public final boolean bFZ;
  public final long bGa;
  public final long jIt;
  public final String key;
  public final long length;
  public final c lmp;
  public final long position;
  
  static
  {
    AppMethodBeat.i(205991);
    lmC = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    AppMethodBeat.o(205991);
  }
  
  private f(String paramString, long paramLong1, long paramLong2, long paramLong3, c paramc, boolean paramBoolean, long paramLong4, e parame)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    this.jIt = paramLong3;
    this.lmp = paramc;
    this.bFZ = paramBoolean;
    this.aXd = parame;
    this.bGa = paramLong4;
  }
  
  public static f C(e parame)
  {
    AppMethodBeat.i(205988);
    Matcher localMatcher = lmC.matcher(parame.getName());
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(205988);
      return null;
    }
    String str = localMatcher.group(1);
    long l1 = Long.parseLong(localMatcher.group(2));
    long l2 = Long.parseLong(localMatcher.group(3));
    c localc = c.QP(localMatcher.group(4));
    long l3 = Long.parseLong(localMatcher.group(5));
    parame = new f(str, l1, parame.length(), l2, localc, true, l3, parame);
    AppMethodBeat.o(205988);
    return parame;
  }
  
  public static f S(String paramString, long paramLong)
  {
    AppMethodBeat.i(205985);
    paramString = new f(paramString, paramLong, -1L, -1L, c.lnp, false, -1L, null);
    AppMethodBeat.o(205985);
    return paramString;
  }
  
  public static f T(String paramString, long paramLong)
  {
    AppMethodBeat.i(205986);
    paramString = new f(paramString, paramLong, -1L, -1L, c.lnp, false, -1L, null);
    AppMethodBeat.o(205986);
    return paramString;
  }
  
  public static e a(e parame, String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    AppMethodBeat.i(205984);
    paramString = new StringBuilder().append(paramString).append(".").append(paramLong1).append(".").append(paramLong2).append(".");
    if (TextUtils.isEmpty(paramc.lnu)) {
      paramc.lnu = c.QM(paramc.lnt);
    }
    parame = new e(parame, paramc.lnu + "." + paramLong3 + ".v1.dat");
    AppMethodBeat.o(205984);
    return parame;
  }
  
  public static f p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205987);
    paramString = new f(paramString, paramLong1, paramLong2, -1L, c.lnp, false, -1L, null);
    AppMethodBeat.o(205987);
    return paramString;
  }
  
  public final int d(f paramf)
  {
    AppMethodBeat.i(205989);
    if (!this.key.equals(paramf.key))
    {
      int i = this.key.compareTo(paramf.key);
      AppMethodBeat.o(205989);
      return i;
    }
    long l = this.position - paramf.position;
    if (l == 0L)
    {
      AppMethodBeat.o(205989);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(205989);
      return -1;
    }
    AppMethodBeat.o(205989);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.f
 * JD-Core Version:    0.7.0.1
 */