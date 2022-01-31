package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class a
  implements d
{
  private static final int aDc = t.aG("ID3");
  public static final g azq = new a.1();
  private final long aDd;
  private final b aDe;
  private final j aDf;
  private boolean aDg;
  
  public a()
  {
    this(0L);
  }
  
  public a(long paramLong)
  {
    this.aDd = paramLong;
    this.aDe = new b();
    this.aDf = new j(2786);
  }
  
  public final int a(e parame)
  {
    int i = parame.read(this.aDf.data, 0, 2786);
    if (i == -1) {
      return -1;
    }
    this.aDf.setPosition(0);
    this.aDf.dA(i);
    if (!this.aDg)
    {
      this.aDe.ayE = this.aDd;
      this.aDg = true;
    }
    this.aDe.b(this.aDf);
    return 0;
  }
  
  public final void a(f paramf)
  {
    this.aDe.a(paramf, new u.d());
    paramf.lV();
    new j.a(-9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.a
 * JD-Core Version:    0.7.0.1
 */