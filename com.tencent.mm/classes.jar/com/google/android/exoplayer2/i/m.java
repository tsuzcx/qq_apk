package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class m
{
  public byte[] data;
  public int limit;
  public int position;
  
  public m() {}
  
  public m(int paramInt)
  {
    AppMethodBeat.i(93165);
    this.data = new byte[paramInt];
    this.limit = paramInt;
    AppMethodBeat.o(93165);
  }
  
  public m(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93166);
    this.data = paramArrayOfByte;
    this.limit = paramArrayOfByte.length;
    AppMethodBeat.o(93166);
  }
  
  public m(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
  }
  
  public final String a(int paramInt, Charset paramCharset)
  {
    AppMethodBeat.i(93178);
    paramCharset = new String(this.data, this.position, paramInt, paramCharset);
    this.position += paramInt;
    AppMethodBeat.o(93178);
    return paramCharset;
  }
  
  public final void c(l paraml, int paramInt)
  {
    AppMethodBeat.i(93171);
    readBytes(paraml.data, 0, paramInt);
    paraml.setPosition(0);
    AppMethodBeat.o(93171);
  }
  
  public final int capacity()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.length;
  }
  
  public final long dB()
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
  
  public final void eZ(int paramInt)
  {
    AppMethodBeat.i(93168);
    if ((paramInt >= 0) && (paramInt <= this.data.length)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.limit = paramInt;
      AppMethodBeat.o(93168);
      return;
    }
  }
  
  public final void fa(int paramInt)
  {
    AppMethodBeat.i(93170);
    setPosition(this.position + paramInt);
    AppMethodBeat.o(93170);
  }
  
  public final String fb(int paramInt)
  {
    AppMethodBeat.i(93179);
    if (paramInt == 0)
    {
      AppMethodBeat.o(93179);
      return "";
    }
    int i = this.position + paramInt - 1;
    if ((i < this.limit) && (this.data[i] == 0)) {}
    for (i = paramInt - 1;; i = paramInt)
    {
      String str = new String(this.data, this.position, i);
      this.position += paramInt;
      AppMethodBeat.o(93179);
      return str;
    }
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
    this.position = 0;
  }
  
  public final void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93172);
    System.arraycopy(this.data, this.position, paramArrayOfByte, paramInt1, paramInt2);
    this.position += paramInt2;
    AppMethodBeat.o(93172);
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
    AppMethodBeat.i(93181);
    if (wV() == 0)
    {
      AppMethodBeat.o(93181);
      return null;
    }
    int i = this.position;
    while ((i < this.limit) && (!x.fe(this.data[i]))) {
      i += 1;
    }
    if ((i - this.position >= 3) && (this.data[this.position] == -17) && (this.data[(this.position + 1)] == -69) && (this.data[(this.position + 2)] == -65)) {
      this.position += 3;
    }
    String str = new String(this.data, this.position, i - this.position);
    this.position = i;
    if (this.position == this.limit)
    {
      AppMethodBeat.o(93181);
      return str;
    }
    if (this.data[this.position] == 13)
    {
      this.position += 1;
      if (this.position == this.limit)
      {
        AppMethodBeat.o(93181);
        return str;
      }
    }
    if (this.data[this.position] == 10) {
      this.position += 1;
    }
    AppMethodBeat.o(93181);
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
    AppMethodBeat.i(93177);
    String str = a(paramInt, Charset.forName("UTF-8"));
    AppMethodBeat.o(93177);
    return str;
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
  
  public final void reset()
  {
    this.position = 0;
    this.limit = 0;
  }
  
  public final void reset(int paramInt)
  {
    AppMethodBeat.i(93167);
    if (capacity() < paramInt) {}
    for (byte[] arrayOfByte = new byte[paramInt];; arrayOfByte = this.data)
    {
      n(arrayOfByte, paramInt);
      AppMethodBeat.o(93167);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(93169);
    if ((paramInt < 0) || (paramInt > this.limit)) {
      b.i("ExoPlayer", "position%d, limit:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.limit) });
    }
    if ((paramInt >= 0) && (paramInt <= this.limit)) {}
    for (;;)
    {
      a.checkArgument(bool);
      this.position = paramInt;
      AppMethodBeat.o(93169);
      return;
      bool = false;
    }
  }
  
  public final int wV()
  {
    return this.limit - this.position;
  }
  
  public final int wW()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.data;
    int j = this.position;
    this.position = (j + 1);
    return i & 0xFF | (arrayOfByte[j] & 0xFF) << 8;
  }
  
  public final int wX()
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
  
  public final long wY()
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
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (arrayOfByte[i] & 0xFF) << 24;
  }
  
  public final int wZ()
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
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (arrayOfByte[m] & 0xFF) << 24;
  }
  
  public final long xa()
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
    return l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (arrayOfByte[i] & 0xFF) << 56;
  }
  
  public final int xb()
  {
    AppMethodBeat.i(93173);
    int i = readUnsignedByte();
    int j = readUnsignedByte();
    int k = readUnsignedByte();
    int m = readUnsignedByte();
    AppMethodBeat.o(93173);
    return i << 21 | j << 14 | k << 7 | m;
  }
  
  public final int xc()
  {
    AppMethodBeat.i(93174);
    int i = readInt();
    if (i < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i)));
      AppMethodBeat.o(93174);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(93174);
    return i;
  }
  
  public final int xd()
  {
    AppMethodBeat.i(93175);
    int i = wZ();
    if (i < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i)));
      AppMethodBeat.o(93175);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(93175);
    return i;
  }
  
  public final long xe()
  {
    AppMethodBeat.i(93176);
    long l = readLong();
    if (l < 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(l)));
      AppMethodBeat.o(93176);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(93176);
    return l;
  }
  
  public final String xf()
  {
    AppMethodBeat.i(93180);
    if (wV() == 0)
    {
      AppMethodBeat.o(93180);
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
    AppMethodBeat.o(93180);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.m
 * JD-Core Version:    0.7.0.1
 */