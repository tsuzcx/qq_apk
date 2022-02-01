package com.h.a.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class b
  implements a
{
  private final long cCD;
  private final int ebW = 1073741824;
  private final int ebX = 1024;
  private final ByteBuffer[] ebY;
  private long ebZ;
  
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
    this.cCD = paramFile.length();
    int j = (int)(this.cCD / this.ebW) + 1;
    this.ebY = new ByteBuffer[j];
    paramFile = new FileInputStream(paramFile);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        long l2 = Math.min(this.cCD - l1, this.ebW + this.ebX);
        this.ebY[i] = paramFile.getChannel().map(FileChannel.MapMode.READ_ONLY, l1, l2);
        this.ebY[i].order(ebV);
        l1 += this.ebW;
        i += 1;
      }
      finally
      {
        paramFile.close();
      }
    }
    this.ebZ = 0L;
    paramFile.close();
  }
  
  public b(File paramFile, byte paramByte)
  {
    this(paramFile);
  }
  
  private int getIndex()
  {
    return (int)(this.ebZ / this.ebW);
  }
  
  private int getOffset()
  {
    return (int)(this.ebZ % this.ebW);
  }
  
  public final void I(byte[] paramArrayOfByte)
  {
    int i = getIndex();
    this.ebY[i].position(getOffset());
    if (paramArrayOfByte.length <= this.ebY[i].remaining()) {
      this.ebY[i].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.ebZ += paramArrayOfByte.length;
      return;
      int j = this.ebW - this.ebY[i].position();
      this.ebY[i].get(paramArrayOfByte, 0, j);
      this.ebY[(i + 1)].position(0);
      this.ebY[(i + 1)].get(paramArrayOfByte, j, paramArrayOfByte.length - j);
    }
  }
  
  public final long all()
  {
    return this.ebZ;
  }
  
  public final long alm()
  {
    return this.cCD - this.ebZ;
  }
  
  public final void jdMethod_do(long paramLong)
  {
    this.ebZ = paramLong;
  }
  
  public final boolean hasRemaining()
  {
    return this.ebZ < this.cCD;
  }
  
  public final byte readByte()
  {
    byte b = this.ebY[getIndex()].get(getOffset());
    this.ebZ += 1L;
    return b;
  }
  
  public final char readChar()
  {
    char c = this.ebY[getIndex()].getChar(getOffset());
    this.ebZ += 2L;
    return c;
  }
  
  public final double readDouble()
  {
    double d = this.ebY[getIndex()].getDouble(getOffset());
    this.ebZ += 8L;
    return d;
  }
  
  public final float readFloat()
  {
    float f = this.ebY[getIndex()].getFloat(getOffset());
    this.ebZ += 4L;
    return f;
  }
  
  public final int readInt()
  {
    int i = this.ebY[getIndex()].getInt(getOffset());
    this.ebZ += 4L;
    return i;
  }
  
  public final long readLong()
  {
    long l = this.ebY[getIndex()].getLong(getOffset());
    this.ebZ += 8L;
    return l;
  }
  
  public final short readShort()
  {
    short s = this.ebY[getIndex()].getShort(getOffset());
    this.ebZ += 2L;
    return s;
  }
  
  public final void w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assert (paramInt2 < this.cCD);
    this.ebZ += paramInt1;
    int k = getIndex();
    this.ebY[k].position(getOffset());
    if (paramArrayOfByte.length <= this.ebY[k].remaining()) {
      this.ebY[k].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.ebZ += Math.min(paramArrayOfByte.length, paramInt2);
      return;
      int j = this.ebW - this.ebY[k].position();
      this.ebY[k].get(paramArrayOfByte, 0, j);
      paramInt1 = Math.min(paramInt2 - j, paramArrayOfByte.length - j);
      int m = (this.ebW + paramInt1 - 1) / this.ebW;
      int i = 0;
      while (i < m)
      {
        int n = Math.min(paramInt1, this.ebW);
        this.ebY[(k + 1 + i)].position(0);
        this.ebY[(k + 1 + i)].get(paramArrayOfByte, j, n);
        j += n;
        paramInt1 -= n;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.h.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */