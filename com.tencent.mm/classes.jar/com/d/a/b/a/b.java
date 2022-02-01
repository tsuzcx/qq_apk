package com.d.a.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class b
  implements a
{
  private final int clB = 1073741824;
  private final int clC = 1024;
  private final ByteBuffer[] clD;
  private final long clE;
  private long clF;
  
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
    this.clE = paramFile.length();
    int j = (int)(this.clE / this.clB) + 1;
    this.clD = new ByteBuffer[j];
    paramFile = new FileInputStream(paramFile);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        long l2 = Math.min(this.clE - l1, this.clB + this.clC);
        this.clD[i] = paramFile.getChannel().map(FileChannel.MapMode.READ_ONLY, l1, l2);
        this.clD[i].order(clA);
        l1 += this.clB;
        i += 1;
      }
      finally
      {
        paramFile.close();
      }
    }
    this.clF = 0L;
    paramFile.close();
  }
  
  public b(File paramFile, byte paramByte)
  {
    this(paramFile);
  }
  
  private int getIndex()
  {
    return (int)(this.clF / this.clB);
  }
  
  private int getOffset()
  {
    return (int)(this.clF % this.clB);
  }
  
  public final void J(byte[] paramArrayOfByte)
  {
    int i = getIndex();
    this.clD[i].position(getOffset());
    if (paramArrayOfByte.length <= this.clD[i].remaining()) {
      this.clD[i].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.clF += paramArrayOfByte.length;
      return;
      int j = this.clB - this.clD[i].position();
      this.clD[i].get(paramArrayOfByte, 0, j);
      this.clD[(i + 1)].position(0);
      this.clD[(i + 1)].get(paramArrayOfByte, j, paramArrayOfByte.length - j);
    }
  }
  
  public final long Lk()
  {
    return this.clF;
  }
  
  public final long Ll()
  {
    return this.clE - this.clF;
  }
  
  public final void aV(long paramLong)
  {
    this.clF = paramLong;
  }
  
  public final boolean hasRemaining()
  {
    return this.clF < this.clE;
  }
  
  public final byte readByte()
  {
    byte b = this.clD[getIndex()].get(getOffset());
    this.clF += 1L;
    return b;
  }
  
  public final char readChar()
  {
    char c = this.clD[getIndex()].getChar(getOffset());
    this.clF += 2L;
    return c;
  }
  
  public final double readDouble()
  {
    double d = this.clD[getIndex()].getDouble(getOffset());
    this.clF += 8L;
    return d;
  }
  
  public final float readFloat()
  {
    float f = this.clD[getIndex()].getFloat(getOffset());
    this.clF += 4L;
    return f;
  }
  
  public final int readInt()
  {
    int i = this.clD[getIndex()].getInt(getOffset());
    this.clF += 4L;
    return i;
  }
  
  public final long readLong()
  {
    long l = this.clD[getIndex()].getLong(getOffset());
    this.clF += 8L;
    return l;
  }
  
  public final short readShort()
  {
    short s = this.clD[getIndex()].getShort(getOffset());
    this.clF += 2L;
    return s;
  }
  
  public final void y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    assert (paramInt2 < this.clE);
    this.clF += paramInt1;
    int k = getIndex();
    this.clD[k].position(getOffset());
    if (paramArrayOfByte.length <= this.clD[k].remaining()) {
      this.clD[k].get(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    for (;;)
    {
      this.clF += Math.min(paramArrayOfByte.length, paramInt2);
      return;
      int j = this.clB - this.clD[k].position();
      this.clD[k].get(paramArrayOfByte, 0, j);
      paramInt1 = Math.min(paramInt2 - j, paramArrayOfByte.length - j);
      int m = (this.clB + paramInt1 - 1) / this.clB;
      int i = 0;
      while (i < m)
      {
        int n = Math.min(paramInt1, this.clB);
        this.clD[(k + 1 + i)].position(0);
        this.clD[(k + 1 + i)].get(paramArrayOfByte, j, n);
        j += n;
        paramInt1 -= n;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.d.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */