package com.e.a.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class b
  implements a
{
  private final ByteBuffer[] cfA;
  private final long cfB;
  private long cfC;
  private final int cfz = 1073741824;
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
    this.cfB = paramFile.length();
    int j = (int)(this.cfB / this.cfz) + 1;
    this.cfA = new ByteBuffer[j];
    paramFile = new FileInputStream(paramFile);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        long l2 = Math.min(this.cfB - l1, this.cfz + this.mPadding);
        this.cfA[i] = paramFile.getChannel().map(FileChannel.MapMode.READ_ONLY, l1, l2);
        this.cfA[i].order(cfy);
        l1 += this.cfz;
        i += 1;
      }
      finally
      {
        paramFile.close();
      }
    }
    this.cfC = 0L;
    paramFile.close();
  }
  
  public b(File paramFile, byte paramByte)
  {
    this(paramFile);
  }
  
  private int getIndex()
  {
    return (int)(this.cfC / this.cfz);
  }
  
  private int getOffset()
  {
    return (int)(this.cfC % this.cfz);
  }
  
  public final long Bx()
  {
    return this.cfB - this.cfC;
  }
  
  public final void aG(long paramLong)
  {
    this.cfC = paramLong;
  }
  
  public final boolean hasRemaining()
  {
    return this.cfC < this.cfB;
  }
  
  public final void p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assert (paramInt2 < this.cfB);
    this.cfC += paramInt1;
    int k = getIndex();
    this.cfA[k].position(getOffset());
    if (paramArrayOfByte.length <= this.cfA[k].remaining()) {
      this.cfA[k].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.cfC += Math.min(paramArrayOfByte.length, paramInt2);
      return;
      int j = this.cfz - this.cfA[k].position();
      this.cfA[k].get(paramArrayOfByte, 0, j);
      paramInt1 = Math.min(paramInt2 - j, paramArrayOfByte.length - j);
      int m = (this.cfz + paramInt1 - 1) / this.cfz;
      int i = 0;
      while (i < m)
      {
        int n = Math.min(paramInt1, this.cfz);
        this.cfA[(k + 1 + i)].position(0);
        this.cfA[(k + 1 + i)].get(paramArrayOfByte, j, n);
        j += n;
        paramInt1 -= n;
        i += 1;
      }
    }
  }
  
  public final long position()
  {
    return this.cfC;
  }
  
  public final byte readByte()
  {
    byte b = this.cfA[getIndex()].get(getOffset());
    this.cfC += 1L;
    return b;
  }
  
  public final char readChar()
  {
    char c = this.cfA[getIndex()].getChar(getOffset());
    this.cfC += 2L;
    return c;
  }
  
  public final double readDouble()
  {
    double d = this.cfA[getIndex()].getDouble(getOffset());
    this.cfC += 8L;
    return d;
  }
  
  public final float readFloat()
  {
    float f = this.cfA[getIndex()].getFloat(getOffset());
    this.cfC += 4L;
    return f;
  }
  
  public final int readInt()
  {
    int i = this.cfA[getIndex()].getInt(getOffset());
    this.cfC += 4L;
    return i;
  }
  
  public final long readLong()
  {
    long l = this.cfA[getIndex()].getLong(getOffset());
    this.cfC += 8L;
    return l;
  }
  
  public final short readShort()
  {
    short s = this.cfA[getIndex()].getShort(getOffset());
    this.cfC += 2L;
    return s;
  }
  
  public final void y(byte[] paramArrayOfByte)
  {
    int i = getIndex();
    this.cfA[i].position(getOffset());
    if (paramArrayOfByte.length <= this.cfA[i].remaining()) {
      this.cfA[i].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.cfC += paramArrayOfByte.length;
      return;
      int j = this.cfz - this.cfA[i].position();
      this.cfA[i].get(paramArrayOfByte, 0, j);
      this.cfA[(i + 1)].position(0);
      this.cfA[(i + 1)].get(paramArrayOfByte, j, paramArrayOfByte.length - j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */