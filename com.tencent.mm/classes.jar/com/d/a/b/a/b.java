package com.d.a.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class b
  implements a
{
  private final int bXD = 1073741824;
  private final ByteBuffer[] bXE;
  private final long bXF;
  private long bXG;
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
    this.bXF = paramFile.length();
    int j = (int)(this.bXF / this.bXD) + 1;
    this.bXE = new ByteBuffer[j];
    paramFile = new FileInputStream(paramFile);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        long l2 = Math.min(this.bXF - l1, this.bXD + this.mPadding);
        this.bXE[i] = paramFile.getChannel().map(FileChannel.MapMode.READ_ONLY, l1, l2);
        this.bXE[i].order(bXC);
        l1 += this.bXD;
        i += 1;
      }
      finally
      {
        paramFile.close();
      }
    }
    this.bXG = 0L;
    paramFile.close();
  }
  
  public b(File paramFile, byte paramByte)
  {
    this(paramFile);
  }
  
  private int getIndex()
  {
    return (int)(this.bXG / this.bXD);
  }
  
  private int getOffset()
  {
    return (int)(this.bXG % this.bXD);
  }
  
  public final void A(byte[] paramArrayOfByte)
  {
    int i = getIndex();
    this.bXE[i].position(getOffset());
    if (paramArrayOfByte.length <= this.bXE[i].remaining()) {
      this.bXE[i].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.bXG += paramArrayOfByte.length;
      return;
      int j = this.bXD - this.bXE[i].position();
      this.bXE[i].get(paramArrayOfByte, 0, j);
      this.bXE[(i + 1)].position(0);
      this.bXE[(i + 1)].get(paramArrayOfByte, j, paramArrayOfByte.length - j);
    }
  }
  
  public final long An()
  {
    return this.bXF - this.bXG;
  }
  
  public final void aK(long paramLong)
  {
    this.bXG = paramLong;
  }
  
  public final boolean hasRemaining()
  {
    return this.bXG < this.bXF;
  }
  
  public final long position()
  {
    return this.bXG;
  }
  
  public final void q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assert (paramInt2 < this.bXF);
    this.bXG += paramInt1;
    int k = getIndex();
    this.bXE[k].position(getOffset());
    if (paramArrayOfByte.length <= this.bXE[k].remaining()) {
      this.bXE[k].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.bXG += Math.min(paramArrayOfByte.length, paramInt2);
      return;
      int j = this.bXD - this.bXE[k].position();
      this.bXE[k].get(paramArrayOfByte, 0, j);
      paramInt1 = Math.min(paramInt2 - j, paramArrayOfByte.length - j);
      int m = (this.bXD + paramInt1 - 1) / this.bXD;
      int i = 0;
      while (i < m)
      {
        int n = Math.min(paramInt1, this.bXD);
        this.bXE[(k + 1 + i)].position(0);
        this.bXE[(k + 1 + i)].get(paramArrayOfByte, j, n);
        j += n;
        paramInt1 -= n;
        i += 1;
      }
    }
  }
  
  public final byte readByte()
  {
    byte b = this.bXE[getIndex()].get(getOffset());
    this.bXG += 1L;
    return b;
  }
  
  public final char readChar()
  {
    char c = this.bXE[getIndex()].getChar(getOffset());
    this.bXG += 2L;
    return c;
  }
  
  public final double readDouble()
  {
    double d = this.bXE[getIndex()].getDouble(getOffset());
    this.bXG += 8L;
    return d;
  }
  
  public final float readFloat()
  {
    float f = this.bXE[getIndex()].getFloat(getOffset());
    this.bXG += 4L;
    return f;
  }
  
  public final int readInt()
  {
    int i = this.bXE[getIndex()].getInt(getOffset());
    this.bXG += 4L;
    return i;
  }
  
  public final long readLong()
  {
    long l = this.bXE[getIndex()].getLong(getOffset());
    this.bXG += 8L;
    return l;
  }
  
  public final short readShort()
  {
    short s = this.bXE[getIndex()].getShort(getOffset());
    this.bXG += 2L;
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */