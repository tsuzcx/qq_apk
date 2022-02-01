package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  final long bbw;
  private final e bdP;
  final long bdQ;
  final h bdR;
  long bdS;
  private long bdT;
  private long bdU;
  private long bdV;
  private long bdW;
  private long bdX;
  private long start;
  private int state;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(92137);
    this.bdP = new e();
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      this.bdR = paramh;
      this.bdQ = paramLong1;
      this.bbw = paramLong2;
      if (paramInt != paramLong2 - paramLong1) {
        break;
      }
      this.bdS = paramLong3;
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
    this.bdP.c(paramf, false);
    while (this.bdP.ben < paramLong1)
    {
      paramf.dR(this.bdP.aZG + this.bdP.bes);
      paramLong2 = this.bdP.ben;
      this.bdP.c(paramf, false);
    }
    paramf.sI();
    AppMethodBeat.o(92141);
    return paramLong2;
  }
  
  private boolean a(com.google.android.exoplayer2.c.f paramf, long paramLong)
  {
    int j = 2048;
    AppMethodBeat.i(92140);
    paramLong = Math.min(3L + paramLong, this.bbw);
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
          paramf.dR(j);
          AppMethodBeat.o(92140);
          return true;
        }
        j += 1;
      }
      paramf.dR(i - 3);
      j = i;
    }
  }
  
  public final long Q(long paramLong)
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
    for (paramLong = 0L;; paramLong = this.bdR.S(paramLong))
    {
      this.bdU = paramLong;
      this.state = 2;
      this.start = this.bdQ;
      this.bdV = this.bbw;
      this.bdW = 0L;
      this.bdX = this.bdS;
      paramLong = this.bdU;
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
      this.bdT = paramf.getPosition();
      this.state = 1;
      l1 = this.bbw - 65307L;
      if (l1 > this.bdT)
      {
        AppMethodBeat.o(92138);
        return l1;
      }
    case 1: 
      if (!a(paramf, this.bbw))
      {
        paramf = new EOFException();
        AppMethodBeat.o(92138);
        throw paramf;
      }
      this.bdP.reset();
      while (((this.bdP.type & 0x4) != 4) && (paramf.getPosition() < this.bbw))
      {
        this.bdP.c(paramf, false);
        paramf.dR(this.bdP.aZG + this.bdP.bes);
      }
      this.bdS = this.bdP.ben;
      this.state = 3;
      l1 = this.bdT;
      AppMethodBeat.o(92138);
      return l1;
    }
    if (this.bdU == 0L) {}
    for (long l1 = 0L;; l1 = a(paramf, this.bdU, -(l1 + 2L)))
    {
      this.state = 3;
      l1 = -(l1 + 2L);
      AppMethodBeat.o(92138);
      return l1;
      long l2 = this.bdU;
      if (this.start == this.bdV) {
        l1 = -(this.bdW + 2L);
      }
      while (l1 >= 0L)
      {
        AppMethodBeat.o(92138);
        return l1;
        l1 = paramf.getPosition();
        if (!a(paramf, this.bdV))
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
          this.bdP.c(paramf, false);
          paramf.sI();
          l2 -= this.bdP.ben;
          int j = this.bdP.aZG + this.bdP.bes;
          if ((l2 < 0L) || (l2 > 72000L))
          {
            if (l2 < 0L)
            {
              this.bdV = l1;
              this.bdX = this.bdP.ben;
            }
            for (;;)
            {
              if (this.bdV - this.start < 100000L)
              {
                this.bdV = this.start;
                l1 = this.start;
                break;
                this.start = (paramf.getPosition() + j);
                this.bdW = this.bdP.ben;
                if (this.bdV - this.start + j < 100000L)
                {
                  paramf.dR(j);
                  l1 = -(this.bdW + 2L);
                  break;
                }
              }
            }
            if (l2 <= 0L) {
              i = 2;
            }
            l1 = i * j;
            l1 = Math.min(Math.max(paramf.getPosition() - l1 + l2 * (this.bdV - this.start) / (this.bdX - this.bdW), this.start), this.bdV - 1L);
          }
          else
          {
            paramf.dR(j);
            l1 = -(this.bdP.ben + 2L);
          }
        }
      }
    }
  }
  
  final class a
    implements l
  {
    private a() {}
    
    public final long K(long paramLong)
    {
      AppMethodBeat.i(92135);
      if (paramLong == 0L)
      {
        paramLong = a.this.bdQ;
        AppMethodBeat.o(92135);
        return paramLong;
      }
      paramLong = a.this.bdR.S(paramLong);
      a locala = a.this;
      long l = a.this.bdQ;
      l = paramLong * (locala.bbw - locala.bdQ) / locala.bdS - 30000L + l;
      paramLong = l;
      if (l < locala.bdQ) {
        paramLong = locala.bdQ;
      }
      l = paramLong;
      if (paramLong >= locala.bbw) {
        l = locala.bbw - 1L;
      }
      AppMethodBeat.o(92135);
      return l;
    }
    
    public final long getDurationUs()
    {
      AppMethodBeat.i(92136);
      long l = a.this.bdR.R(a.this.bdS);
      AppMethodBeat.o(92136);
      return l;
    }
    
    public final boolean sH()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.a
 * JD-Core Version:    0.7.0.1
 */