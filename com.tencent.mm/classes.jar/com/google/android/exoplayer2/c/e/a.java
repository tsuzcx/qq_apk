package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  final long aWa;
  private long aYA;
  private long aYB;
  private final e aYt;
  final long aYu;
  final h aYv;
  long aYw;
  private long aYx;
  private long aYy;
  private long aYz;
  private long start;
  private int state;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(92137);
    this.aYt = new e();
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      this.aYv = paramh;
      this.aYu = paramLong1;
      this.aWa = paramLong2;
      if (paramInt != paramLong2 - paramLong1) {
        break;
      }
      this.aYw = paramLong3;
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
    this.aYt.c(paramf, false);
    while (this.aYt.aYR < paramLong1)
    {
      paramf.ed(this.aYt.aUk + this.aYt.aYW);
      paramLong2 = this.aYt.aYR;
      this.aYt.c(paramf, false);
    }
    paramf.sp();
    AppMethodBeat.o(92141);
    return paramLong2;
  }
  
  private boolean a(com.google.android.exoplayer2.c.f paramf, long paramLong)
  {
    int j = 2048;
    AppMethodBeat.i(92140);
    paramLong = Math.min(3L + paramLong, this.aWa);
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
          paramf.ed(j);
          AppMethodBeat.o(92140);
          return true;
        }
        j += 1;
      }
      paramf.ed(i - 3);
      j = i;
    }
  }
  
  public final long U(long paramLong)
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
    for (paramLong = 0L;; paramLong = this.aYv.W(paramLong))
    {
      this.aYy = paramLong;
      this.state = 2;
      this.start = this.aYu;
      this.aYz = this.aWa;
      this.aYA = 0L;
      this.aYB = this.aYw;
      paramLong = this.aYy;
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
      this.aYx = paramf.getPosition();
      this.state = 1;
      l1 = this.aWa - 65307L;
      if (l1 > this.aYx)
      {
        AppMethodBeat.o(92138);
        return l1;
      }
    case 1: 
      if (!a(paramf, this.aWa))
      {
        paramf = new EOFException();
        AppMethodBeat.o(92138);
        throw paramf;
      }
      this.aYt.reset();
      while (((this.aYt.type & 0x4) != 4) && (paramf.getPosition() < this.aWa))
      {
        this.aYt.c(paramf, false);
        paramf.ed(this.aYt.aUk + this.aYt.aYW);
      }
      this.aYw = this.aYt.aYR;
      this.state = 3;
      l1 = this.aYx;
      AppMethodBeat.o(92138);
      return l1;
    }
    if (this.aYy == 0L) {}
    for (long l1 = 0L;; l1 = a(paramf, this.aYy, -(l1 + 2L)))
    {
      this.state = 3;
      l1 = -(l1 + 2L);
      AppMethodBeat.o(92138);
      return l1;
      long l2 = this.aYy;
      if (this.start == this.aYz) {
        l1 = -(this.aYA + 2L);
      }
      while (l1 >= 0L)
      {
        AppMethodBeat.o(92138);
        return l1;
        l1 = paramf.getPosition();
        if (!a(paramf, this.aYz))
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
          this.aYt.c(paramf, false);
          paramf.sp();
          l2 -= this.aYt.aYR;
          int j = this.aYt.aUk + this.aYt.aYW;
          if ((l2 < 0L) || (l2 > 72000L))
          {
            if (l2 < 0L)
            {
              this.aYz = l1;
              this.aYB = this.aYt.aYR;
            }
            for (;;)
            {
              if (this.aYz - this.start < 100000L)
              {
                this.aYz = this.start;
                l1 = this.start;
                break;
                this.start = (paramf.getPosition() + j);
                this.aYA = this.aYt.aYR;
                if (this.aYz - this.start + j < 100000L)
                {
                  paramf.ed(j);
                  l1 = -(this.aYA + 2L);
                  break;
                }
              }
            }
            if (l2 <= 0L) {
              i = 2;
            }
            l1 = i * j;
            l1 = Math.min(Math.max(paramf.getPosition() - l1 + l2 * (this.aYz - this.start) / (this.aYB - this.aYA), this.start), this.aYz - 1L);
          }
          else
          {
            paramf.ed(j);
            l1 = -(this.aYt.aYR + 2L);
          }
        }
      }
    }
  }
  
  final class a
    implements l
  {
    private a() {}
    
    public final long O(long paramLong)
    {
      AppMethodBeat.i(92135);
      if (paramLong == 0L)
      {
        paramLong = a.this.aYu;
        AppMethodBeat.o(92135);
        return paramLong;
      }
      paramLong = a.this.aYv.W(paramLong);
      a locala = a.this;
      long l = a.this.aYu;
      l = paramLong * (locala.aWa - locala.aYu) / locala.aYw - 30000L + l;
      paramLong = l;
      if (l < locala.aYu) {
        paramLong = locala.aYu;
      }
      l = paramLong;
      if (paramLong >= locala.aWa) {
        l = locala.aWa - 1L;
      }
      AppMethodBeat.o(92135);
      return l;
    }
    
    public final long getDurationUs()
    {
      AppMethodBeat.i(92136);
      long l = a.this.aYv.V(a.this.aYw);
      AppMethodBeat.o(92136);
      return l;
    }
    
    public final boolean so()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.a
 * JD-Core Version:    0.7.0.1
 */