package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  final long bmD;
  private final e boW;
  final long boX;
  final h boY;
  long boZ;
  private long bpa;
  private long bpb;
  private long bpc;
  private long bpd;
  private long bpe;
  private long start;
  private int state;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(92137);
    this.boW = new e();
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      this.boY = paramh;
      this.boX = paramLong1;
      this.bmD = paramLong2;
      if (paramInt != paramLong2 - paramLong1) {
        break;
      }
      this.boZ = paramLong3;
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
    this.boW.c(paramf, false);
    while (this.boW.bpu < paramLong1)
    {
      paramf.dU(this.boW.bkN + this.boW.bpz);
      paramLong2 = this.boW.bpu;
      this.boW.c(paramf, false);
    }
    paramf.uq();
    AppMethodBeat.o(92141);
    return paramLong2;
  }
  
  private boolean a(com.google.android.exoplayer2.c.f paramf, long paramLong)
  {
    int j = 2048;
    AppMethodBeat.i(92140);
    paramLong = Math.min(3L + paramLong, this.bmD);
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
          paramf.dU(j);
          AppMethodBeat.o(92140);
          return true;
        }
        j += 1;
      }
      paramf.dU(i - 3);
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
    for (paramLong = 0L;; paramLong = this.boY.T(paramLong))
    {
      this.bpb = paramLong;
      this.state = 2;
      this.start = this.boX;
      this.bpc = this.bmD;
      this.bpd = 0L;
      this.bpe = this.boZ;
      paramLong = this.bpb;
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
      this.bpa = paramf.getPosition();
      this.state = 1;
      l1 = this.bmD - 65307L;
      if (l1 > this.bpa)
      {
        AppMethodBeat.o(92138);
        return l1;
      }
    case 1: 
      if (!a(paramf, this.bmD))
      {
        paramf = new EOFException();
        AppMethodBeat.o(92138);
        throw paramf;
      }
      this.boW.reset();
      while (((this.boW.type & 0x4) != 4) && (paramf.getPosition() < this.bmD))
      {
        this.boW.c(paramf, false);
        paramf.dU(this.boW.bkN + this.boW.bpz);
      }
      this.boZ = this.boW.bpu;
      this.state = 3;
      l1 = this.bpa;
      AppMethodBeat.o(92138);
      return l1;
    }
    if (this.bpb == 0L) {}
    for (long l1 = 0L;; l1 = a(paramf, this.bpb, -(l1 + 2L)))
    {
      this.state = 3;
      l1 = -(l1 + 2L);
      AppMethodBeat.o(92138);
      return l1;
      long l2 = this.bpb;
      if (this.start == this.bpc) {
        l1 = -(this.bpd + 2L);
      }
      while (l1 >= 0L)
      {
        AppMethodBeat.o(92138);
        return l1;
        l1 = paramf.getPosition();
        if (!a(paramf, this.bpc))
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
          this.boW.c(paramf, false);
          paramf.uq();
          l2 -= this.boW.bpu;
          int j = this.boW.bkN + this.boW.bpz;
          if ((l2 < 0L) || (l2 > 72000L))
          {
            if (l2 < 0L)
            {
              this.bpc = l1;
              this.bpe = this.boW.bpu;
            }
            for (;;)
            {
              if (this.bpc - this.start < 100000L)
              {
                this.bpc = this.start;
                l1 = this.start;
                break;
                this.start = (paramf.getPosition() + j);
                this.bpd = this.boW.bpu;
                if (this.bpc - this.start + j < 100000L)
                {
                  paramf.dU(j);
                  l1 = -(this.bpd + 2L);
                  break;
                }
              }
            }
            if (l2 <= 0L) {
              i = 2;
            }
            l1 = i * j;
            l1 = Math.min(Math.max(paramf.getPosition() - l1 + l2 * (this.bpc - this.start) / (this.bpe - this.bpd), this.start), this.bpc - 1L);
          }
          else
          {
            paramf.dU(j);
            l1 = -(this.boW.bpu + 2L);
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
        paramLong = a.this.boX;
        AppMethodBeat.o(92135);
        return paramLong;
      }
      paramLong = a.this.boY.T(paramLong);
      a locala = a.this;
      long l = a.this.boX;
      l = paramLong * (locala.bmD - locala.boX) / locala.boZ - 30000L + l;
      paramLong = l;
      if (l < locala.boX) {
        paramLong = locala.boX;
      }
      l = paramLong;
      if (paramLong >= locala.bmD) {
        l = locala.bmD - 1L;
      }
      AppMethodBeat.o(92135);
      return l;
    }
    
    public final long getDurationUs()
    {
      AppMethodBeat.i(92136);
      long l = a.this.boY.S(a.this.boZ);
      AppMethodBeat.o(92136);
      return l;
    }
    
    public final boolean up()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.a
 * JD-Core Version:    0.7.0.1
 */