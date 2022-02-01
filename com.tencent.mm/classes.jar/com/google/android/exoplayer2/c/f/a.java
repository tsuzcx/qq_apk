package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class a
  implements e
{
  private static final int bfi;
  private final Format aSv;
  private int aXo;
  private int aYG;
  private com.google.android.exoplayer2.c.m aZw;
  private final com.google.android.exoplayer2.i.m bfj;
  private long bfk;
  private int bfl;
  private int version;
  
  static
  {
    AppMethodBeat.i(92187);
    bfi = x.aY("RCC\001");
    AppMethodBeat.o(92187);
  }
  
  public a(Format paramFormat)
  {
    AppMethodBeat.i(92182);
    this.aSv = paramFormat;
    this.bfj = new com.google.android.exoplayer2.i.m(9);
    this.aXo = 0;
    AppMethodBeat.o(92182);
  }
  
  private void m(f paramf)
  {
    AppMethodBeat.i(92186);
    while (this.bfl > 0)
    {
      this.bfj.reset();
      paramf.readFully(this.bfj.data, 0, 3);
      this.aZw.a(this.bfj, 3);
      this.aYG += 3;
      this.bfl -= 1;
    }
    if (this.aYG > 0) {
      this.aZw.a(this.bfk, 1, this.aYG, 0, null);
    }
    AppMethodBeat.o(92186);
  }
  
  public final int a(f paramf, k paramk)
  {
    AppMethodBeat.i(92185);
    int i;
    for (;;)
    {
      switch (this.aXo)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(92185);
        throw paramf;
      case 0: 
        this.bfj.reset();
        if (paramf.a(this.bfj.data, 0, 8, true))
        {
          if (this.bfj.readInt() != bfi)
          {
            paramf = new IOException("Input not RawCC");
            AppMethodBeat.o(92185);
            throw paramf;
          }
          this.version = this.bfj.readUnsignedByte();
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label138;
          }
          this.aXo = 1;
          break;
        }
        AppMethodBeat.o(92185);
        return -1;
      case 1: 
        label138:
        this.bfj.reset();
        if (this.version != 0) {
          break label232;
        }
        if (paramf.a(this.bfj.data, 0, 5, true)) {
          break label192;
        }
        i = 0;
        if (i == 0) {
          break label313;
        }
        this.aXo = 2;
      }
    }
    label192:
    for (this.bfk = (this.bfj.df() * 1000L / 45L);; this.bfk = this.bfj.readLong())
    {
      this.bfl = this.bfj.readUnsignedByte();
      this.aYG = 0;
      i = 1;
      break;
      label232:
      if (this.version != 1) {
        break label279;
      }
      if (!paramf.a(this.bfj.data, 0, 9, true))
      {
        i = 0;
        break;
      }
    }
    label279:
    paramf = new o("Unsupported version number: " + this.version);
    AppMethodBeat.o(92185);
    throw paramf;
    label313:
    this.aXo = 0;
    AppMethodBeat.o(92185);
    return -1;
    m(paramf);
    this.aXo = 1;
    AppMethodBeat.o(92185);
    return 0;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92183);
    paramg.a(new l.a(-9223372036854775807L));
    this.aZw = paramg.bh(0, 3);
    paramg.sL();
    this.aZw.f(this.aSv);
    AppMethodBeat.o(92183);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92184);
    this.bfj.reset();
    paramf.b(this.bfj.data, 0, 8);
    if (this.bfj.readInt() == bfi)
    {
      AppMethodBeat.o(92184);
      return true;
    }
    AppMethodBeat.o(92184);
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    this.aXo = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.a
 * JD-Core Version:    0.7.0.1
 */