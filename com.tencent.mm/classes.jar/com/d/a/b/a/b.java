package com.d.a.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class b
  implements a
{
  private final int bVl = 1073741824;
  private final ByteBuffer[] bVm;
  private final long bVn;
  private long bVo;
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
    this.bVn = paramFile.length();
    int j = (int)(this.bVn / this.bVl) + 1;
    this.bVm = new ByteBuffer[j];
    paramFile = new FileInputStream(paramFile);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        long l2 = Math.min(this.bVn - l1, this.bVl + this.mPadding);
        this.bVm[i] = paramFile.getChannel().map(FileChannel.MapMode.READ_ONLY, l1, l2);
        this.bVm[i].order(bVk);
        l1 += this.bVl;
        i += 1;
      }
      finally
      {
        paramFile.close();
      }
    }
    this.bVo = 0L;
    paramFile.close();
  }
  
  public b(File paramFile, byte paramByte)
  {
    this(paramFile);
  }
  
  private int getIndex()
  {
    return (int)(this.bVo / this.bVl);
  }
  
  private int getOffset()
  {
    return (int)(this.bVo % this.bVl);
  }
  
  public final long Aa()
  {
    return this.bVn - this.bVo;
  }
  
  public final void aG(long paramLong)
  {
    this.bVo = paramLong;
  }
  
  public final boolean hasRemaining()
  {
    return this.bVo < this.bVn;
  }
  
  public final void p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assert (paramInt2 < this.bVn);
    this.bVo += paramInt1;
    int k = getIndex();
    this.bVm[k].position(getOffset());
    if (paramArrayOfByte.length <= this.bVm[k].remaining()) {
      this.bVm[k].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.bVo += Math.min(paramArrayOfByte.length, paramInt2);
      return;
      int j = this.bVl - this.bVm[k].position();
      this.bVm[k].get(paramArrayOfByte, 0, j);
      paramInt1 = Math.min(paramInt2 - j, paramArrayOfByte.length - j);
      int m = (this.bVl + paramInt1 - 1) / this.bVl;
      int i = 0;
      while (i < m)
      {
        int n = Math.min(paramInt1, this.bVl);
        this.bVm[(k + 1 + i)].position(0);
        this.bVm[(k + 1 + i)].get(paramArrayOfByte, j, n);
        j += n;
        paramInt1 -= n;
        i += 1;
      }
    }
  }
  
  public final long position()
  {
    return this.bVo;
  }
  
  public final byte readByte()
  {
    byte b = this.bVm[getIndex()].get(getOffset());
    this.bVo += 1L;
    return b;
  }
  
  public final char readChar()
  {
    char c = this.bVm[getIndex()].getChar(getOffset());
    this.bVo += 2L;
    return c;
  }
  
  public final double readDouble()
  {
    double d = this.bVm[getIndex()].getDouble(getOffset());
    this.bVo += 8L;
    return d;
  }
  
  public final float readFloat()
  {
    float f = this.bVm[getIndex()].getFloat(getOffset());
    this.bVo += 4L;
    return f;
  }
  
  public final int readInt()
  {
    int i = this.bVm[getIndex()].getInt(getOffset());
    this.bVo += 4L;
    return i;
  }
  
  public final long readLong()
  {
    long l = this.bVm[getIndex()].getLong(getOffset());
    this.bVo += 8L;
    return l;
  }
  
  public final short readShort()
  {
    short s = this.bVm[getIndex()].getShort(getOffset());
    this.bVo += 2L;
    return s;
  }
  
  public final void y(byte[] paramArrayOfByte)
  {
    int i = getIndex();
    this.bVm[i].position(getOffset());
    if (paramArrayOfByte.length <= this.bVm[i].remaining()) {
      this.bVm[i].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.bVo += paramArrayOfByte.length;
      return;
      int j = this.bVl - this.bVm[i].position();
      this.bVm[i].get(paramArrayOfByte, 0, j);
      this.bVm[(i + 1)].position(0);
      this.bVm[(i + 1)].get(paramArrayOfByte, j, paramArrayOfByte.length - j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */