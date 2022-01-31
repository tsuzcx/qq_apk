package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class c
  implements com.google.android.exoplayer2.c.d
{
  private static final int aDc = t.aG("ID3");
  public static final g azq = new c.1();
  private final long aDd;
  private boolean aDg;
  private final d aDn;
  private final j aDo;
  
  public c()
  {
    this(0L);
  }
  
  public c(long paramLong)
  {
    this.aDd = paramLong;
    this.aDn = new d();
    this.aDo = new j(200);
  }
  
  public final int a(e parame)
  {
    int i = parame.read(this.aDo.data, 0, 200);
    if (i == -1) {
      return -1;
    }
    this.aDo.setPosition(0);
    this.aDo.dA(i);
    if (!this.aDg)
    {
      this.aDn.ayE = this.aDd;
      this.aDg = true;
    }
    this.aDn.b(this.aDo);
    return 0;
  }
  
  public final void a(f paramf)
  {
    this.aDn.a(paramf, new u.d());
    paramf.lV();
    new j.a(-9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.c
 * JD-Core Version:    0.7.0.1
 */