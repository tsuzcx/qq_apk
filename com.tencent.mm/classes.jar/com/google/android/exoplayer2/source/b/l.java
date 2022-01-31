package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.f.g.h;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class l
  implements e
{
  private static final Pattern aSi;
  private static final Pattern aSj;
  private final u aGN;
  private g aIN;
  private final com.google.android.exoplayer2.i.m aSk;
  private byte[] aSl;
  private final String axa;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(126008);
    aSi = Pattern.compile("LOCAL:([^,]+)");
    aSj = Pattern.compile("MPEGTS:(\\d+)");
    AppMethodBeat.o(126008);
  }
  
  public l(String paramString, u paramu)
  {
    AppMethodBeat.i(126002);
    this.axa = paramString;
    this.aGN = paramu;
    this.aSk = new com.google.android.exoplayer2.i.m();
    this.aSl = new byte[1024];
    AppMethodBeat.o(126002);
  }
  
  private com.google.android.exoplayer2.c.m Z(long paramLong)
  {
    AppMethodBeat.i(126007);
    com.google.android.exoplayer2.c.m localm = this.aIN.dm(0);
    localm.f(Format.a("text/vtt", this.axa, paramLong));
    this.aIN.nZ();
    AppMethodBeat.o(126007);
    return localm;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    AppMethodBeat.i(126006);
    int j = (int)paramf.getLength();
    if (this.sampleSize == this.aSl.length)
    {
      paramk = this.aSl;
      if (j == -1) {
        break label115;
      }
    }
    label115:
    for (int i = j;; i = this.aSl.length)
    {
      this.aSl = Arrays.copyOf(paramk, i * 3 / 2);
      i = paramf.read(this.aSl, this.sampleSize, this.aSl.length - this.sampleSize);
      if (i == -1) {
        break;
      }
      this.sampleSize = (i + this.sampleSize);
      if ((j != -1) && (this.sampleSize == j)) {
        break;
      }
      AppMethodBeat.o(126006);
      return 0;
    }
    paramf = new com.google.android.exoplayer2.i.m(this.aSl);
    long l2;
    long l1;
    for (;;)
    {
      Matcher localMatcher1;
      try
      {
        h.I(paramf);
        l2 = 0L;
        l1 = 0L;
        paramk = paramf.readLine();
        if (TextUtils.isEmpty(paramk)) {
          break;
        }
        if (!paramk.startsWith("X-TIMESTAMP-MAP")) {
          continue;
        }
        localMatcher1 = aSi.matcher(paramk);
        if (!localMatcher1.find())
        {
          paramf = new o("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(String.valueOf(paramk)));
          AppMethodBeat.o(126006);
          throw paramf;
        }
      }
      catch (com.google.android.exoplayer2.f.f paramf)
      {
        paramf = new o(paramf);
        AppMethodBeat.o(126006);
        throw paramf;
      }
      Matcher localMatcher2 = aSj.matcher(paramk);
      if (!localMatcher2.find())
      {
        paramf = new o("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(String.valueOf(paramk)));
        AppMethodBeat.o(126006);
        throw paramf;
      }
      l2 = h.aw(localMatcher1.group(1));
      l1 = u.aj(Long.parseLong(localMatcher2.group(1)));
    }
    paramf = h.J(paramf);
    if (paramf == null) {
      Z(0L);
    }
    for (;;)
    {
      AppMethodBeat.o(126006);
      return -1;
      long l3 = h.aw(paramf.group(1));
      l1 = this.aGN.ah(u.ak(l1 + l3 - l2));
      paramf = Z(l1 - l3);
      this.aSk.l(this.aSl, this.sampleSize);
      paramf.a(this.aSk, this.sampleSize);
      paramf.a(l1, 1, this.sampleSize, 0, null);
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(126004);
    this.aIN = paramg;
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(126004);
  }
  
  public final boolean a(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(126003);
    paramf = new IllegalStateException();
    AppMethodBeat.o(126003);
    throw paramf;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126005);
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(126005);
    throw localIllegalStateException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.l
 * JD-Core Version:    0.7.0.1
 */