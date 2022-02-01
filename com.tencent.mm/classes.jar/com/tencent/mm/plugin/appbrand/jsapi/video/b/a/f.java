package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.vfs.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
  implements Comparable<f>
{
  private static final Pattern pwc;
  public final long aFL;
  public final boolean bpU;
  public final long bpV;
  public final q file;
  public final String key;
  public final long nHt;
  public final long position;
  public final c pvP;
  
  static
  {
    AppMethodBeat.i(227724);
    pwc = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");
    AppMethodBeat.o(227724);
  }
  
  private f(String paramString, long paramLong1, long paramLong2, long paramLong3, c paramc, boolean paramBoolean, long paramLong4, q paramq)
  {
    this.key = paramString;
    this.position = paramLong1;
    this.aFL = paramLong2;
    this.nHt = paramLong3;
    this.pvP = paramc;
    this.bpU = paramBoolean;
    this.file = paramq;
    this.bpV = paramLong4;
  }
  
  public static f A(q paramq)
  {
    AppMethodBeat.i(227720);
    Matcher localMatcher = pwc.matcher(paramq.getName());
    if (!localMatcher.matches())
    {
      AppMethodBeat.o(227720);
      return null;
    }
    String str = localMatcher.group(1);
    long l1 = Long.parseLong(localMatcher.group(2));
    long l2 = Long.parseLong(localMatcher.group(3));
    c localc = c.aiY(localMatcher.group(4));
    long l3 = Long.parseLong(localMatcher.group(5));
    paramq = new f(str, l1, paramq.length(), l2, localc, true, l3, paramq);
    AppMethodBeat.o(227720);
    return paramq;
  }
  
  public static f S(String paramString, long paramLong)
  {
    AppMethodBeat.i(227714);
    paramString = new f(paramString, paramLong, -1L, -1L, c.pwO, false, -1L, null);
    AppMethodBeat.o(227714);
    return paramString;
  }
  
  public static f T(String paramString, long paramLong)
  {
    AppMethodBeat.i(227715);
    paramString = new f(paramString, paramLong, -1L, -1L, c.pwO, false, -1L, null);
    AppMethodBeat.o(227715);
    return paramString;
  }
  
  public static q a(q paramq, String paramString, long paramLong1, long paramLong2, c paramc, long paramLong3)
  {
    AppMethodBeat.i(227713);
    paramString = new StringBuilder().append(paramString).append(".").append(paramLong1).append(".").append(paramLong2).append(".");
    if (TextUtils.isEmpty(paramc.pwT)) {
      paramc.pwT = c.aiV(paramc.pwS);
    }
    paramq = new q(paramq, paramc.pwT + "." + paramLong3 + ".v1.dat");
    AppMethodBeat.o(227713);
    return paramq;
  }
  
  public static f p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227717);
    paramString = new f(paramString, paramLong1, paramLong2, -1L, c.pwO, false, -1L, null);
    AppMethodBeat.o(227717);
    return paramString;
  }
  
  public final int d(f paramf)
  {
    AppMethodBeat.i(227721);
    if (!this.key.equals(paramf.key))
    {
      int i = this.key.compareTo(paramf.key);
      AppMethodBeat.o(227721);
      return i;
    }
    long l = this.position - paramf.position;
    if (l == 0L)
    {
      AppMethodBeat.o(227721);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(227721);
      return -1;
    }
    AppMethodBeat.o(227721);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.f
 * JD-Core Version:    0.7.0.1
 */