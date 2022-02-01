package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  final long bmy;
  private final e boR;
  final long boS;
  final h boT;
  long boU;
  private long boV;
  private long boW;
  private long boX;
  private long boY;
  private long boZ;
  private long start;
  private int state;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(92137);
    this.boR = new e();
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      this.boT = paramh;
      this.boS = paramLong1;
      this.bmy = paramLong2;
      if (paramInt != paramLong2 - paramLong1) {
        break;
      }
      this.boU = paramLong3;
      this.state = 3;
      AppMethodBeat.o(92137);
      return;
    }
    this.state = 0;
    AppMethodBeat.o(92137);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92141);
    this.boR.c(paramf, false);
    while (this.boR.bpp < paramLong1)
    {
      paramf.dP(this.boR.bkI + this.boR.bpu);
      paramLong2 = this.boR.bpp;
      this.boR.c(paramf, false);
    }
    paramf.uv();
    AppMethodBeat.o(92141);
    return paramLong2;
  }
  
  private boolean a(com.google.android.exoplayer2.c.f paramf, long paramLong)
  {
    int j = 2048;
    AppMethodBeat.i(92140);
    paramLong = Math.min(3L + paramLong, this.bmy);
    byte[] arrayOfByte = new byte[2048];
    for (;;)
    {
      int i = j;
      if (paramf.getPosition() + j > paramLong)
      {
        j = (int)(paramLong - paramf.getPosition());
        i = j;
        if (j < 4)
        {
          AppMethodBeat.o(92140);
          return false;
        }
      }
      paramf.b(arrayOfByte, 0, i, false);
      j = 0;
      while (j < i - 3)
      {
        if ((arrayOfByte[j] == 79) && (arrayOfByte[(j + 1)] == 103) && (arrayOfByte[(j + 2)] == 103) && (arrayOfByte[(j + 3)] == 83))
        {
          paramf.dP(j);
          AppMethodBeat.o(92140);
          return true;
        }
        j += 1;
      }
      paramf.dP(i - 3);
      j = i;
    }
  }
  
  public final long R(long paramLong)
  {
    AppMethodBeat.i(92139);
    boolean bool;
    if ((this.state == 3) || (this.state == 2))
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      if (paramLong != 0L) {
        break label91;
      }
    }
    label91:
    for (paramLong = 0L;; paramLong = this.boT.T(paramLong))
    {
      this.boW = paramLong;
      this.state = 2;
      this.start = this.boS;
      this.boX = this.bmy;
      this.boY = 0L;
      this.boZ = this.boU;
      paramLong = this.boW;
      AppMethodBeat.o(92139);
      return paramLong;
      bool = false;
      break;
    }
  }
  
  public final long i(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 1;
    AppMethodBeat.i(92138);
    switch (this.state)
    {
    default: 
      paramf = new IllegalStateException();
      AppMethodBeat.o(92138);
      throw paramf;
    case 3: 
      AppMethodBeat.o(92138);
      return -1L;
    case 0: 
      this.boV = paramf.getPosition();
      this.state = 1;
      l1 = this.bmy - 65307L;
      if (l1 > this.boV)
      {
        AppMethodBeat.o(92138);
        return l1;
      }
    case 1: 
      if (!a(paramf, this.bmy))
      {
        paramf = new EOFException();
        AppMethodBeat.o(92138);
        throw paramf;
      }
      this.boR.reset();
      while (((this.boR.type & 0x4) != 4) && (paramf.getPosition() < this.bmy))
      {
        this.boR.c(paramf, false);
        paramf.dP(this.boR.bkI + this.boR.bpu);
      }
      this.boU = this.boR.bpp;
      this.state = 3;
      l1 = this.boV;
      AppMethodBeat.o(92138);
      return l1;
    }
    if (this.boW == 0L) {}
    for (long l1 = 0L;; l1 = a(paramf, this.boW, -(l1 + 2L)))
    {
      this.state = 3;
      l1 = -(l1 + 2L);
      AppMethodBeat.o(92138);
      return l1;
      long l2 = this.boW;
      if (this.start == this.boX) {
        l1 = -(this.boY + 2L);
      }
      while (l1 >= 0L)
      {
        AppMethodBeat.o(92138);
        return l1;
        l1 = paramf.getPosition();
        if (!a(paramf, this.boX))
        {
          if (this.start == l1)
          {
            paramf = new IOException("No ogg page can be found.");
            AppMethodBeat.o(92138);
            throw paramf;
          }
          l1 = this.start;
        }
        else
        {
          this.boR.c(paramf, false);
          paramf.uv();
          l2 -= this.boR.bpp;
          int j = this.boR.bkI + this.boR.bpu;
          if ((l2 < 0L) || (l2 > 72000L))
          {
            if (l2 < 0L)
            {
              this.boX = l1;
              this.boZ = this.boR.bpp;
            }
            for (;;)
            {
              if (this.boX - this.start < 100000L)
              {
                this.boX = this.start;
                l1 = this.start;
                break;
                this.start = (paramf.getPosition() + j);
                this.boY = this.boR.bpp;
                if (this.boX - this.start + j < 100000L)
                {
                  paramf.dP(j);
                  l1 = -(this.boY + 2L);
                  break;
                }
              }
            }
            if (l2 <= 0L) {
              i = 2;
            }
            l1 = i * j;
            l1 = Math.min(Math.max(paramf.getPosition() - l1 + l2 * (this.boX - this.start) / (this.boZ - this.boY), this.start), this.boX - 1L);
          }
          else
          {
            paramf.dP(j);
            l1 = -(this.boR.bpp + 2L);
          }
        }
      }
    }
  }
  
  final class a
    implements l
  {
    private a() {}
    
    public final long L(long paramLong)
    {
      AppMethodBeat.i(92135);
      if (paramLong == 0L)
      {
        paramLong = a.this.boS;
        AppMethodBeat.o(92135);
        return paramLong;
      }
      paramLong = a.this.boT.T(paramLong);
      a locala = a.this;
      long l = a.this.boS;
      l = paramLong * (locala.bmy - locala.boS) / locala.boU - 30000L + l;
      paramLong = l;
      if (l < locala.boS) {
        paramLong = locala.boS;
      }
      l = paramLong;
      if (paramLong >= locala.bmy) {
        l = locala.bmy - 1L;
      }
      AppMethodBeat.o(92135);
      return l;
    }
    
    public final long getDurationUs()
    {
      AppMethodBeat.i(92136);
      long l = a.this.boT.S(a.this.boU);
      AppMethodBeat.o(92136);
      return l;
    }
    
    public final boolean uu()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.a
 * JD-Core Version:    0.7.0.1
 */