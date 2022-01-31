package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.f.g.h;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.o;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class l
  implements d
{
  private static final Pattern aKO = Pattern.compile("LOCAL:([^,]+)");
  private static final Pattern aKP = Pattern.compile("MPEGTS:(\\d+)");
  private final q aBX;
  private com.google.android.exoplayer2.c.f aFs;
  private final j aKQ;
  private byte[] aKR;
  private final String auI;
  private int sampleSize;
  
  public l(String paramString, q paramq)
  {
    this.auI = paramString;
    this.aBX = paramq;
    this.aKQ = new j();
    this.aKR = new byte[1024];
  }
  
  private k Q(long paramLong)
  {
    k localk = this.aFs.cQ(0);
    localk.f(Format.a("text/vtt", this.auI, paramLong));
    this.aFs.lV();
    return localk;
  }
  
  public final int a(e parame)
  {
    int j = (int)parame.getLength();
    Object localObject;
    if (this.sampleSize == this.aKR.length)
    {
      localObject = this.aKR;
      if (j == -1) {
        break label102;
      }
    }
    label102:
    for (int i = j;; i = this.aKR.length)
    {
      this.aKR = Arrays.copyOf((byte[])localObject, i * 3 / 2);
      i = parame.read(this.aKR, this.sampleSize, this.aKR.length - this.sampleSize);
      if (i == -1) {
        break;
      }
      this.sampleSize = (i + this.sampleSize);
      if ((j != -1) && (this.sampleSize == j)) {
        break;
      }
      return 0;
    }
    parame = new j(this.aKR);
    long l1;
    long l2;
    for (;;)
    {
      Matcher localMatcher1;
      try
      {
        h.k(parame);
        l1 = 0L;
        l2 = 0L;
        localObject = parame.readLine();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!((String)localObject).startsWith("X-TIMESTAMP-MAP")) {
          continue;
        }
        localMatcher1 = aKO.matcher((CharSequence)localObject);
        if (!localMatcher1.find()) {
          throw new o("X-TIMESTAMP-MAP doesn't contain local timestamp: " + (String)localObject);
        }
      }
      catch (com.google.android.exoplayer2.f.f parame)
      {
        throw new o(parame);
      }
      Matcher localMatcher2 = aKP.matcher((CharSequence)localObject);
      if (!localMatcher2.find()) {
        throw new o("X-TIMESTAMP-MAP doesn't contain media timestamp: " + (String)localObject);
      }
      l2 = h.ar(localMatcher1.group(1));
      l1 = q.Y(Long.parseLong(localMatcher2.group(1)));
    }
    parame = h.l(parame);
    if (parame == null) {
      Q(0L);
    }
    for (;;)
    {
      return -1;
      long l3 = h.ar(parame.group(1));
      l1 = this.aBX.W(q.Z(l1 + l3 - l2));
      parame = Q(l1 - l3);
      this.aKQ.m(this.aKR, this.sampleSize);
      parame.a(this.aKQ, this.sampleSize);
      parame.a(l1, 1, this.sampleSize, 0, null);
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.f paramf)
  {
    this.aFs = paramf;
    new j.a(-9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.l
 * JD-Core Version:    0.7.0.1
 */