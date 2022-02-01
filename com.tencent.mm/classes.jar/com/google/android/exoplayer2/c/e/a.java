package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  private long axI;
  final long cPW;
  private final e cSp;
  final long cSq;
  final h cSr;
  long cSs;
  private long cSt;
  private long cSu;
  private long cSv;
  private long cSw;
  private long start;
  private int state;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(92137);
    this.cSp = new e();
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      this.cSr = paramh;
      this.cSq = paramLong1;
      this.cPW = paramLong2;
      if (paramInt != paramLong2 - paramLong1) {
        break;
      }
      this.cSs = paramLong3;
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
    this.cSp.c(paramf, false);
    while (this.cSp.cSM < paramLong1)
    {
      paramf.eP(this.cSp.cOg + this.cSp.cSR);
      paramLong2 = this.cSp.cSM;
      this.cSp.c(paramf, false);
    }
    paramf.RS();
    AppMethodBeat.o(92141);
    return paramLong2;
  }
  
  private boolean a(com.google.android.exoplayer2.c.f paramf, long paramLong)
  {
    int j = 2048;
    AppMethodBeat.i(92140);
    paramLong = Math.min(3L + paramLong, this.cPW);
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
          paramf.eP(j);
          AppMethodBeat.o(92140);
          return true;
        }
        j += 1;
      }
      paramf.eP(i - 3);
      j = i;
    }
  }
  
  public final long ci(long paramLong)
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
    for (paramLong = 0L;; paramLong = this.cSr.ck(paramLong))
    {
      this.cSu = paramLong;
      this.state = 2;
      this.start = this.cSq;
      this.axI = this.cPW;
      this.cSv = 0L;
      this.cSw = this.cSs;
      paramLong = this.cSu;
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
      this.cSt = paramf.getPosition();
      this.state = 1;
      l1 = this.cPW - 65307L;
      if (l1 > this.cSt)
      {
        AppMethodBeat.o(92138);
        return l1;
      }
    case 1: 
      if (!a(paramf, this.cPW))
      {
        paramf = new EOFException();
        AppMethodBeat.o(92138);
        throw paramf;
      }
      this.cSp.reset();
      while (((this.cSp.type & 0x4) != 4) && (paramf.getPosition() < this.cPW))
      {
        this.cSp.c(paramf, false);
        paramf.eP(this.cSp.cOg + this.cSp.cSR);
      }
      this.cSs = this.cSp.cSM;
      this.state = 3;
      l1 = this.cSt;
      AppMethodBeat.o(92138);
      return l1;
    }
    if (this.cSu == 0L) {}
    for (long l1 = 0L;; l1 = a(paramf, this.cSu, -(l1 + 2L)))
    {
      this.state = 3;
      l1 = -(l1 + 2L);
      AppMethodBeat.o(92138);
      return l1;
      long l2 = this.cSu;
      if (this.start == this.axI) {
        l1 = -(this.cSv + 2L);
      }
      while (l1 >= 0L)
      {
        AppMethodBeat.o(92138);
        return l1;
        l1 = paramf.getPosition();
        if (!a(paramf, this.axI))
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
          this.cSp.c(paramf, false);
          paramf.RS();
          l2 -= this.cSp.cSM;
          int j = this.cSp.cOg + this.cSp.cSR;
          if ((l2 < 0L) || (l2 > 72000L))
          {
            if (l2 < 0L)
            {
              this.axI = l1;
              this.cSw = this.cSp.cSM;
            }
            for (;;)
            {
              if (this.axI - this.start < 100000L)
              {
                this.axI = this.start;
                l1 = this.start;
                break;
                this.start = (paramf.getPosition() + j);
                this.cSv = this.cSp.cSM;
                if (this.axI - this.start + j < 100000L)
                {
                  paramf.eP(j);
                  l1 = -(this.cSv + 2L);
                  break;
                }
              }
            }
            if (l2 <= 0L) {
              i = 2;
            }
            l1 = i * j;
            l1 = Math.min(Math.max(paramf.getPosition() - l1 + l2 * (this.axI - this.start) / (this.cSw - this.cSv), this.start), this.axI - 1L);
          }
          else
          {
            paramf.eP(j);
            l1 = -(this.cSp.cSM + 2L);
          }
        }
      }
    }
  }
  
  final class a
    implements l
  {
    private a() {}
    
    public final boolean RR()
    {
      return true;
    }
    
    public final long cc(long paramLong)
    {
      AppMethodBeat.i(92135);
      if (paramLong == 0L)
      {
        paramLong = a.this.cSq;
        AppMethodBeat.o(92135);
        return paramLong;
      }
      paramLong = a.this.cSr.ck(paramLong);
      a locala = a.this;
      long l = a.this.cSq;
      l = paramLong * (locala.cPW - locala.cSq) / locala.cSs - 30000L + l;
      paramLong = l;
      if (l < locala.cSq) {
        paramLong = locala.cSq;
      }
      l = paramLong;
      if (paramLong >= locala.cPW) {
        l = locala.cPW - 1L;
      }
      AppMethodBeat.o(92135);
      return l;
    }
    
    public final long getDurationUs()
    {
      AppMethodBeat.i(92136);
      long l = a.this.cSr.cj(a.this.cSs);
      AppMethodBeat.o(92136);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.a
 * JD-Core Version:    0.7.0.1
 */