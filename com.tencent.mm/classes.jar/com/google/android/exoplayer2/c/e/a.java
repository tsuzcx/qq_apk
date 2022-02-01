package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  final long bci;
  private final e beB;
  final long beC;
  final h beD;
  long beE;
  private long beF;
  private long beG;
  private long beH;
  private long beI;
  private long beJ;
  private long start;
  private int state;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(92137);
    this.beB = new e();
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      this.beD = paramh;
      this.beC = paramLong1;
      this.bci = paramLong2;
      if (paramInt != paramLong2 - paramLong1) {
        break;
      }
      this.beE = paramLong3;
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
    this.beB.c(paramf, false);
    while (this.beB.beZ < paramLong1)
    {
      paramf.dQ(this.beB.bas + this.beB.bfe);
      paramLong2 = this.beB.beZ;
      this.beB.c(paramf, false);
    }
    paramf.sR();
    AppMethodBeat.o(92141);
    return paramLong2;
  }
  
  private boolean a(com.google.android.exoplayer2.c.f paramf, long paramLong)
  {
    int j = 2048;
    AppMethodBeat.i(92140);
    paramLong = Math.min(3L + paramLong, this.bci);
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
          paramf.dQ(j);
          AppMethodBeat.o(92140);
          return true;
        }
        j += 1;
      }
      paramf.dQ(i - 3);
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
    for (paramLong = 0L;; paramLong = this.beD.T(paramLong))
    {
      this.beG = paramLong;
      this.state = 2;
      this.start = this.beC;
      this.beH = this.bci;
      this.beI = 0L;
      this.beJ = this.beE;
      paramLong = this.beG;
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
      this.beF = paramf.getPosition();
      this.state = 1;
      l1 = this.bci - 65307L;
      if (l1 > this.beF)
      {
        AppMethodBeat.o(92138);
        return l1;
      }
    case 1: 
      if (!a(paramf, this.bci))
      {
        paramf = new EOFException();
        AppMethodBeat.o(92138);
        throw paramf;
      }
      this.beB.reset();
      while (((this.beB.type & 0x4) != 4) && (paramf.getPosition() < this.bci))
      {
        this.beB.c(paramf, false);
        paramf.dQ(this.beB.bas + this.beB.bfe);
      }
      this.beE = this.beB.beZ;
      this.state = 3;
      l1 = this.beF;
      AppMethodBeat.o(92138);
      return l1;
    }
    if (this.beG == 0L) {}
    for (long l1 = 0L;; l1 = a(paramf, this.beG, -(l1 + 2L)))
    {
      this.state = 3;
      l1 = -(l1 + 2L);
      AppMethodBeat.o(92138);
      return l1;
      long l2 = this.beG;
      if (this.start == this.beH) {
        l1 = -(this.beI + 2L);
      }
      while (l1 >= 0L)
      {
        AppMethodBeat.o(92138);
        return l1;
        l1 = paramf.getPosition();
        if (!a(paramf, this.beH))
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
          this.beB.c(paramf, false);
          paramf.sR();
          l2 -= this.beB.beZ;
          int j = this.beB.bas + this.beB.bfe;
          if ((l2 < 0L) || (l2 > 72000L))
          {
            if (l2 < 0L)
            {
              this.beH = l1;
              this.beJ = this.beB.beZ;
            }
            for (;;)
            {
              if (this.beH - this.start < 100000L)
              {
                this.beH = this.start;
                l1 = this.start;
                break;
                this.start = (paramf.getPosition() + j);
                this.beI = this.beB.beZ;
                if (this.beH - this.start + j < 100000L)
                {
                  paramf.dQ(j);
                  l1 = -(this.beI + 2L);
                  break;
                }
              }
            }
            if (l2 <= 0L) {
              i = 2;
            }
            l1 = i * j;
            l1 = Math.min(Math.max(paramf.getPosition() - l1 + l2 * (this.beH - this.start) / (this.beJ - this.beI), this.start), this.beH - 1L);
          }
          else
          {
            paramf.dQ(j);
            l1 = -(this.beB.beZ + 2L);
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
        paramLong = a.this.beC;
        AppMethodBeat.o(92135);
        return paramLong;
      }
      paramLong = a.this.beD.T(paramLong);
      a locala = a.this;
      long l = a.this.beC;
      l = paramLong * (locala.bci - locala.beC) / locala.beE - 30000L + l;
      paramLong = l;
      if (l < locala.beC) {
        paramLong = locala.beC;
      }
      l = paramLong;
      if (paramLong >= locala.bci) {
        l = locala.bci - 1L;
      }
      AppMethodBeat.o(92135);
      return l;
    }
    
    public final long getDurationUs()
    {
      AppMethodBeat.i(92136);
      long l = a.this.beD.S(a.this.beE);
      AppMethodBeat.o(92136);
      return l;
    }
    
    public final boolean sQ()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.a
 * JD-Core Version:    0.7.0.1
 */