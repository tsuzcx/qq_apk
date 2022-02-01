package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.vfs.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
  implements Comparable<f>
{
  private static final Pattern sBi;
  public final boolean djy;
  public final long djz;
  public final u file;
  public final String key;
  public final long length;
  public final long position;
  public final long qHg;
  public final c sAV;
  
  static
  {
    AppMethodBeat.i(328336);
    sBi = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    AppMethodBeat.o(328336);
  }
  
  private f(String paramString, long paramLong1, long paramLong2, long paramLong3, c paramc, boolean paramBoolean, long paramLong4, u paramu)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    this.qHg = paramLong3;
    this.sAV = paramc;
    this.djy = paramBoolean;
    this.file = paramu;
    this.djz = paramLong4;
  }
  
  public static f A(u paramu)
  {
    AppMethodBeat.i(328324);
    Matcher localMatcher = sBi.matcher(paramu.getName());
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(328324);
      return null;
    }
    String str = localMatcher.group(1);
    long l1 = Long.parseLong(localMatcher.group(2));
    long l2 = Long.parseLong(localMatcher.group(3));
    c localc = c.abX(localMatcher.group(4));
    long l3 = Long.parseLong(localMatcher.group(5));
    paramu = new f(str, l1, paramu.length(), l2, localc, true, l3, paramu);
    AppMethodBeat.o(328324);
    return paramu;
  }
  
  public static f X(String paramString, long paramLong)
  {
    AppMethodBeat.i(328297);
    paramString = new f(paramString, paramLong, -1L, -1L, c.sBU, false, -1L, null);
    AppMethodBeat.o(328297);
    return paramString;
  }
  
  public static f Y(String paramString, long paramLong)
  {
    AppMethodBeat.i(328305);
    paramString = new f(paramString, paramLong, -1L, -1L, c.sBU, false, -1L, null);
    AppMethodBeat.o(328305);
    return paramString;
  }
  
  public static u a(u paramu, String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    AppMethodBeat.i(328289);
    paramString = new StringBuilder().append(paramString).append(".").append(paramLong1).append(".").append(paramLong2).append(".");
    if (TextUtils.isEmpty(paramc.sBZ)) {
      paramc.sBZ = c.abU(paramc.sBY);
    }
    paramu = new u(paramu, paramc.sBZ + "." + paramLong3 + ".v1.dat");
    AppMethodBeat.o(328289);
    return paramu;
  }
  
  public static f r(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328315);
    paramString = new f(paramString, paramLong1, paramLong2, -1L, c.sBU, false, -1L, null);
    AppMethodBeat.o(328315);
    return paramString;
  }
  
  public final int d(f paramf)
  {
    AppMethodBeat.i(328349);
    if (!this.key.equals(paramf.key))
    {
      int i = this.key.compareTo(paramf.key);
      AppMethodBeat.o(328349);
      return i;
    }
    long l = this.position - paramf.position;
    if (l == 0L)
    {
      AppMethodBeat.o(328349);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(328349);
      return -1;
    }
    AppMethodBeat.o(328349);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.f
 * JD-Core Version:    0.7.0.1
 */