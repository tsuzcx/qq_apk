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
  private static final Pattern byK;
  private static final Pattern byL;
  private final u bnh;
  private g bph;
  private final com.google.android.exoplayer2.i.m byM;
  private byte[] byN;
  private final String language;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(62932);
    byK = Pattern.compile("LOCAL:([^,]+)");
    byL = Pattern.compile("MPEGTS:(\\d+)");
    AppMethodBeat.o(62932);
  }
  
  public l(String paramString, u paramu)
  {
    AppMethodBeat.i(62926);
    this.language = paramString;
    this.bnh = paramu;
    this.byM = new com.google.android.exoplayer2.i.m();
    this.byN = new byte[1024];
    AppMethodBeat.o(62926);
  }
  
  private com.google.android.exoplayer2.c.m ag(long paramLong)
  {
    AppMethodBeat.i(62931);
    com.google.android.exoplayer2.c.m localm = this.bph.dV(0);
    localm.f(Format.a("text/vtt", this.language, paramLong));
    this.bph.uy();
    AppMethodBeat.o(62931);
    return localm;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    AppMethodBeat.i(62930);
    int j = (int)paramf.getLength();
    if (this.sampleSize == this.byN.length)
    {
      paramk = this.byN;
      if (j == -1) {
        break label115;
      }
    }
    label115:
    for (int i = j;; i = this.byN.length)
    {
      this.byN = Arrays.copyOf(paramk, i * 3 / 2);
      i = paramf.read(this.byN, this.sampleSize, this.byN.length - this.sampleSize);
      if (i == -1) {
        break;
      }
      this.sampleSize = (i + this.sampleSize);
      if ((j != -1) && (this.sampleSize == j)) {
        break;
      }
      AppMethodBeat.o(62930);
      return 0;
    }
    paramf = new com.google.android.exoplayer2.i.m(this.byN);
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
        localMatcher1 = byK.matcher(paramk);
        if (!localMatcher1.find())
        {
          paramf = new o("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(String.valueOf(paramk)));
          AppMethodBeat.o(62930);
          throw paramf;
        }
      }
      catch (com.google.android.exoplayer2.f.f paramf)
      {
        paramf = new o(paramf);
        AppMethodBeat.o(62930);
        throw paramf;
      }
      Matcher localMatcher2 = byL.matcher(paramk);
      if (!localMatcher2.find())
      {
        paramf = new o("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(String.valueOf(paramk)));
        AppMethodBeat.o(62930);
        throw paramf;
      }
      l2 = h.bn(localMatcher1.group(1));
      l1 = u.aq(Long.parseLong(localMatcher2.group(1)));
    }
    paramf = h.J(paramf);
    if (paramf == null) {
      ag(0L);
    }
    for (;;)
    {
      AppMethodBeat.o(62930);
      return -1;
      long l3 = h.bn(paramf.group(1));
      l1 = this.bnh.ao(u.ar(l1 + l3 - l2));
      paramf = ag(l1 - l3);
      this.byM.n(this.byN, this.sampleSize);
      paramf.a(this.byM, this.sampleSize);
      paramf.a(l1, 1, this.sampleSize, 0, null);
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(62928);
    this.bph = paramg;
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(62928);
  }
  
  public final boolean a(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(62927);
    paramf = new IllegalStateException();
    AppMethodBeat.o(62927);
    throw paramf;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(62929);
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(62929);
    throw localIllegalStateException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.l
 * JD-Core Version:    0.7.0.1
 */