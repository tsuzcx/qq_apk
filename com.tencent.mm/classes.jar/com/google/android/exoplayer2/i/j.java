package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.d.b;
import java.nio.charset.Charset;

public final class j
{
  public byte[] data;
  public int limit;
  public int position;
  
  public j() {}
  
  public j(int paramInt)
  {
    this.data = new byte[paramInt];
    this.limit = paramInt;
  }
  
  public j(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    this.limit = paramArrayOfByte.length;
  }
  
  public j(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
  }
  
  public final String a(int paramInt, Charset paramCharset)
  {
    paramCharset = new String(this.data, this.position, paramInt, paramCharset);
    this.position += paramInt;
    return paramCharset;
  }
  
  public final long bp()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l2 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l3 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    return (l1 & 0xFF) << 24 | (l2 & 0xFF) << 16 | (l3 & 0xFF) << 8 | arrayOfByte[i] & 0xFF;
  }
  
  public final void c(i parami, int paramInt)
  {
    readBytes(parami.data, 0, paramInt);
    parami.setPosition(0);
  }
  
  public final int capacity()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.length;
  }
  
  public final void dA(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.data.length)) {}
    for (boolean bool = true;; bool = false)
    {
      a.aB(bool);
      this.limit = paramInt;
      return;
    }
  }
  
  public final void dB(int paramInt)
  {
    setPosition(this.position + paramInt);
  }
  
  public final void m(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
    this.position = 0;
  }
  
  public final int oe()
  {
    return this.limit - this.position;
  }
  
  public final int of()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.data;
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = this.data;
    int k = this.position;
    this.position = (k + 1);
    return (i & 0xFF) << 16 | (j & 0xFF) << 8 | arrayOfByte[k] & 0xFF;
  }
  
  public final int og()
  {
    return readUnsignedByte() << 21 | readUnsignedByte() << 14 | readUnsignedByte() << 7 | readUnsignedByte();
  }
  
  public final int oh()
  {
    int i = readInt();
    if (i < 0) {
      throw new IllegalStateException("Top bit not zero: " + i);
    }
    return i;
  }
  
  public final long oi()
  {
    long l = readLong();
    if (l < 0L) {
      throw new IllegalStateException("Top bit not zero: " + l);
    }
    return l;
  }
  
  public final String oj()
  {
    if (oe() == 0) {
      return null;
    }
    int i = this.position;
    while ((i < this.limit) && (this.data[i] != 0)) {
      i += 1;
    }
    String str = new String(this.data, this.position, i - this.position);
    this.position = i;
    if (this.position < this.limit) {
      this.position += 1;
    }
    return str;
  }
  
  public final void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(this.data, this.position, paramArrayOfByte, paramInt1, paramInt2);
    this.position += paramInt2;
  }
  
  public final int readInt()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.data;
    int j = this.position;
    this.position = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = this.data;
    int k = this.position;
    this.position = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = this.data;
    int m = this.position;
    this.position = (m + 1);
    return (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
  }
  
  public final String readLine()
  {
    if (oe() == 0) {
      return null;
    }
    int i = this.position;
    while ((i < this.limit) && (!t.dE(this.data[i]))) {
      i += 1;
    }
    if ((i - this.position >= 3) && (this.data[this.position] == -17) && (this.data[(this.position + 1)] == -69) && (this.data[(this.position + 2)] == -65)) {
      this.position += 3;
    }
    String str = new String(this.data, this.position, i - this.position);
    this.position = i;
    if (this.position == this.limit) {
      return str;
    }
    if (this.data[this.position] == 13)
    {
      this.position += 1;
      if (this.position == this.limit) {
        return str;
      }
    }
    if (this.data[this.position] == 10) {
      this.position += 1;
    }
    return str;
  }
  
  public final long readLong()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l2 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l3 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l4 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l5 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l6 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    long l7 = arrayOfByte[i];
    arrayOfByte = this.data;
    i = this.position;
    this.position = (i + 1);
    return (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | arrayOfByte[i] & 0xFF;
  }
  
  public final String readString(int paramInt)
  {
    return a(paramInt, Charset.forName("UTF-8"));
  }
  
  public final int readUnsignedByte()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public final int readUnsignedShort()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.data;
    int j = this.position;
    this.position = (j + 1);
    return (i & 0xFF) << 8 | arrayOfByte[j] & 0xFF;
  }
  
  public final void reset(int paramInt)
  {
    if (capacity() < paramInt) {}
    for (byte[] arrayOfByte = new byte[paramInt];; arrayOfByte = this.data)
    {
      m(arrayOfByte, paramInt);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt > this.limit)) {
      b.i("ExoPlayer", "position%d, limit:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.limit) });
    }
    if ((paramInt >= 0) && (paramInt <= this.limit)) {}
    for (;;)
    {
      a.aB(bool);
      this.position = paramInt;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.j
 * JD-Core Version:    0.7.0.1
 */