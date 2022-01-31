package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  final long aGe;
  long aIA;
  private long aIB;
  private long aIC;
  private long aID;
  private long aIE;
  private long aIF;
  private final e aIx;
  final long aIy;
  final h aIz;
  private long start;
  private int state;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(95021);
    this.aIx = new e();
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      this.aIz = paramh;
      this.aIy = paramLong1;
      this.aGe = paramLong2;
      if (paramInt != paramLong2 - paramLong1) {
        break;
      }
      this.aIA = paramLong3;
      this.state = 3;
      AppMethodBeat.o(95021);
      return;
    }
    this.state = 0;
    AppMethodBeat.o(95021);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95025);
    this.aIx.c(paramf, false);
    while (this.aIx.aIU < paramLong1)
    {
      paramf.dg(this.aIx.aEo + this.aIx.aIZ);
      paramLong2 = this.aIx.aIU;
      this.aIx.c(paramf, false);
    }
    paramf.nW();
    AppMethodBeat.o(95025);
    return paramLong2;
  }
  
  private boolean a(com.google.android.exoplayer2.c.f paramf, long paramLong)
  {
    int j = 2048;
    AppMethodBeat.i(95024);
    paramLong = Math.min(3L + paramLong, this.aGe);
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
          AppMethodBeat.o(95024);
          return false;
        }
      }
      paramf.b(arrayOfByte, 0, i, false);
      j = 0;
      while (j < i - 3)
      {
        if ((arrayOfByte[j] == 79) && (arrayOfByte[(j + 1)] == 103) && (arrayOfByte[(j + 2)] == 103) && (arrayOfByte[(j + 3)] == 83))
        {
          paramf.dg(j);
          AppMethodBeat.o(95024);
          return true;
        }
        j += 1;
      }
      paramf.dg(i - 3);
      j = i;
    }
  }
  
  public final long K(long paramLong)
  {
    AppMethodBeat.i(95023);
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
    for (paramLong = 0L;; paramLong = this.aIz.M(paramLong))
    {
      this.aIC = paramLong;
      this.state = 2;
      this.start = this.aIy;
      this.aID = this.aGe;
      this.aIE = 0L;
      this.aIF = this.aIA;
      paramLong = this.aIC;
      AppMethodBeat.o(95023);
      return paramLong;
      bool = false;
      break;
    }
  }
  
  public final long i(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 1;
    AppMethodBeat.i(95022);
    switch (this.state)
    {
    default: 
      paramf = new IllegalStateException();
      AppMethodBeat.o(95022);
      throw paramf;
    case 3: 
      AppMethodBeat.o(95022);
      return -1L;
    case 0: 
      this.aIB = paramf.getPosition();
      this.state = 1;
      l1 = this.aGe - 65307L;
      if (l1 > this.aIB)
      {
        AppMethodBeat.o(95022);
        return l1;
      }
    case 1: 
      if (!a(paramf, this.aGe))
      {
        paramf = new EOFException();
        AppMethodBeat.o(95022);
        throw paramf;
      }
      this.aIx.reset();
      while (((this.aIx.type & 0x4) != 4) && (paramf.getPosition() < this.aGe))
      {
        this.aIx.c(paramf, false);
        paramf.dg(this.aIx.aEo + this.aIx.aIZ);
      }
      this.aIA = this.aIx.aIU;
      this.state = 3;
      l1 = this.aIB;
      AppMethodBeat.o(95022);
      return l1;
    }
    if (this.aIC == 0L) {}
    for (long l1 = 0L;; l1 = a(paramf, this.aIC, -(l1 + 2L)))
    {
      this.state = 3;
      l1 = -(l1 + 2L);
      AppMethodBeat.o(95022);
      return l1;
      long l2 = this.aIC;
      if (this.start == this.aID) {
        l1 = -(this.aIE + 2L);
      }
      while (l1 >= 0L)
      {
        AppMethodBeat.o(95022);
        return l1;
        l1 = paramf.getPosition();
        if (!a(paramf, this.aID))
        {
          if (this.start == l1)
          {
            paramf = new IOException("No ogg page can be found.");
            AppMethodBeat.o(95022);
            throw paramf;
          }
          l1 = this.start;
        }
        else
        {
          this.aIx.c(paramf, false);
          paramf.nW();
          l2 -= this.aIx.aIU;
          int j = this.aIx.aEo + this.aIx.aIZ;
          if ((l2 < 0L) || (l2 > 72000L))
          {
            if (l2 < 0L)
            {
              this.aID = l1;
              this.aIF = this.aIx.aIU;
            }
            for (;;)
            {
              if (this.aID - this.start < 100000L)
              {
                this.aID = this.start;
                l1 = this.start;
                break;
                this.start = (paramf.getPosition() + j);
                this.aIE = this.aIx.aIU;
                if (this.aID - this.start + j < 100000L)
                {
                  paramf.dg(j);
                  l1 = -(this.aIE + 2L);
                  break;
                }
              }
            }
            if (l2 <= 0L) {
              i = 2;
            }
            l1 = i * j;
            l1 = Math.min(Math.max(paramf.getPosition() - l1 + l2 * (this.aID - this.start) / (this.aIF - this.aIE), this.start), this.aID - 1L);
          }
          else
          {
            paramf.dg(j);
            l1 = -(this.aIx.aIU + 2L);
          }
        }
      }
    }
  }
  
  final class a
    implements l
  {
    private a() {}
    
    public final long E(long paramLong)
    {
      AppMethodBeat.i(95019);
      if (paramLong == 0L)
      {
        paramLong = a.this.aIy;
        AppMethodBeat.o(95019);
        return paramLong;
      }
      paramLong = a.this.aIz.M(paramLong);
      a locala = a.this;
      long l = a.this.aIy;
      l = paramLong * (locala.aGe - locala.aIy) / locala.aIA - 30000L + l;
      paramLong = l;
      if (l < locala.aIy) {
        paramLong = locala.aIy;
      }
      l = paramLong;
      if (paramLong >= locala.aGe) {
        l = locala.aGe - 1L;
      }
      AppMethodBeat.o(95019);
      return l;
    }
    
    public final long getDurationUs()
    {
      AppMethodBeat.i(95020);
      long l = a.this.aIz.L(a.this.aIA);
      AppMethodBeat.o(95020);
      return l;
    }
    
    public final boolean nV()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.a
 * JD-Core Version:    0.7.0.1
 */