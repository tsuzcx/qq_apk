package com.c.a.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class b
  implements a
{
  private final int cqb = 1073741824;
  private final ByteBuffer[] cqc;
  private final long cqd;
  private long cqe;
  private final int mPadding = 1024;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private b(File paramFile)
  {
    this.cqd = paramFile.length();
    int j = (int)(this.cqd / this.cqb) + 1;
    this.cqc = new ByteBuffer[j];
    paramFile = new FileInputStream(paramFile);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        long l2 = Math.min(this.cqd - l1, this.cqb + this.mPadding);
        this.cqc[i] = paramFile.getChannel().map(FileChannel.MapMode.READ_ONLY, l1, l2);
        this.cqc[i].order(cqa);
        l1 += this.cqb;
        i += 1;
      }
      finally
      {
        paramFile.close();
      }
    }
    this.cqe = 0L;
    paramFile.close();
  }
  
  public b(File paramFile, byte paramByte)
  {
    this(paramFile);
  }
  
  private int getIndex()
  {
    return (int)(this.cqe / this.cqb);
  }
  
  private int getOffset()
  {
    return (int)(this.cqe % this.cqb);
  }
  
  public final long Kq()
  {
    return this.cqd - this.cqe;
  }
  
  public final void M(byte[] paramArrayOfByte)
  {
    int i = getIndex();
    this.cqc[i].position(getOffset());
    if (paramArrayOfByte.length <= this.cqc[i].remaining()) {
      this.cqc[i].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.cqe += paramArrayOfByte.length;
      return;
      int j = this.cqb - this.cqc[i].position();
      this.cqc[i].get(paramArrayOfByte, 0, j);
      this.cqc[(i + 1)].position(0);
      this.cqc[(i + 1)].get(paramArrayOfByte, j, paramArrayOfByte.length - j);
    }
  }
  
  public final void aT(long paramLong)
  {
    this.cqe = paramLong;
  }
  
  public final boolean hasRemaining()
  {
    return this.cqe < this.cqd;
  }
  
  public final long position()
  {
    return this.cqe;
  }
  
  public final byte readByte()
  {
    byte b = this.cqc[getIndex()].get(getOffset());
    this.cqe += 1L;
    return b;
  }
  
  public final char readChar()
  {
    char c = this.cqc[getIndex()].getChar(getOffset());
    this.cqe += 2L;
    return c;
  }
  
  public final double readDouble()
  {
    double d = this.cqc[getIndex()].getDouble(getOffset());
    this.cqe += 8L;
    return d;
  }
  
  public final float readFloat()
  {
    float f = this.cqc[getIndex()].getFloat(getOffset());
    this.cqe += 4L;
    return f;
  }
  
  public final int readInt()
  {
    int i = this.cqc[getIndex()].getInt(getOffset());
    this.cqe += 4L;
    return i;
  }
  
  public final long readLong()
  {
    long l = this.cqc[getIndex()].getLong(getOffset());
    this.cqe += 8L;
    return l;
  }
  
  public final short readShort()
  {
    short s = this.cqc[getIndex()].getShort(getOffset());
    this.cqe += 2L;
    return s;
  }
  
  public final void y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assert (paramInt2 < this.cqd);
    this.cqe += paramInt1;
    int k = getIndex();
    this.cqc[k].position(getOffset());
    if (paramArrayOfByte.length <= this.cqc[k].remaining()) {
      this.cqc[k].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.cqe += Math.min(paramArrayOfByte.length, paramInt2);
      return;
      int j = this.cqb - this.cqc[k].position();
      this.cqc[k].get(paramArrayOfByte, 0, j);
      paramInt1 = Math.min(paramInt2 - j, paramArrayOfByte.length - j);
      int m = (this.cqb + paramInt1 - 1) / this.cqb;
      int i = 0;
      while (i < m)
      {
        int n = Math.min(paramInt1, this.cqb);
        this.cqc[(k + 1 + i)].position(0);
        this.cqc[(k + 1 + i)].get(paramArrayOfByte, j, n);
        j += n;
        paramInt1 -= n;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.c.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */