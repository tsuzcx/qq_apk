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
    AppMethodBeat.i(95903);
    this.data = new byte[paramInt];
    this.limit = paramInt;
    AppMethodBeat.o(95903);
  }
  
  public m(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95904);
    this.data = paramArrayOfByte;
    this.limit = paramArrayOfByte.length;
    AppMethodBeat.o(95904);
  }
  
  public m(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
  }
  
  public final String a(int paramInt, Charset paramCharset)
  {
    AppMethodBeat.i(95916);
    paramCharset = new String(this.data, this.position, paramInt, paramCharset);
    this.position += paramInt;
    AppMethodBeat.o(95916);
    return paramCharset;
  }
  
  public final void c(l paraml, int paramInt)
  {
    AppMethodBeat.i(95909);
    readBytes(paraml.data, 0, paramInt);
    paraml.setPosition(0);
    AppMethodBeat.o(95909);
  }
  
  public final int capacity()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.length;
  }
  
  public final long cc()
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
  
  public final void em(int paramInt)
  {
    AppMethodBeat.i(95906);
    if ((paramInt >= 0) && (paramInt <= this.data.length)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.limit = paramInt;
      AppMethodBeat.o(95906);
      return;
    }
  }
  
  public final void en(int paramInt)
  {
    AppMethodBeat.i(95908);
    setPosition(this.position + paramInt);
    AppMethodBeat.o(95908);
  }
  
  public final String eo(int paramInt)
  {
    AppMethodBeat.i(95917);
    if (paramInt == 0)
    {
      AppMethodBeat.o(95917);
      return "";
    }
    int i = this.position + paramInt - 1;
    if ((i < this.limit) && (this.data[i] == 0)) {}
    for (i = paramInt - 1;; i = paramInt)
    {
      String str = new String(this.data, this.position, i);
      this.position += paramInt;
      AppMethodBeat.o(95917);
      return str;
    }
  }
  
  public final void l(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
    this.position = 0;
  }
  
  public final int qM()
  {
    return this.limit - this.position;
  }
  
  public final int qN()
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
  
  public final int qO()
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
  
  public final long qP()
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
  
  public final int qQ()
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
  
  public final long qR()
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
  
  public final int qS()
  {
    AppMethodBeat.i(95911);
    int i = readUnsignedByte();
    int j = readUnsignedByte();
    int k = readUnsignedByte();
    int m = readUnsignedByte();
    AppMethodBeat.o(95911);
    return i << 21 | j << 14 | k << 7 | m;
  }
  
  public final int qT()
  {
    AppMethodBeat.i(95912);
    int i = readInt();
    if (i < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i)));
      AppMethodBeat.o(95912);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(95912);
    return i;
  }
  
  public final int qU()
  {
    AppMethodBeat.i(95913);
    int i = qQ();
    if (i < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(i)));
      AppMethodBeat.o(95913);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(95913);
    return i;
  }
  
  public final long qV()
  {
    AppMethodBeat.i(95914);
    long l = readLong();
    if (l < 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(l)));
      AppMethodBeat.o(95914);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(95914);
    return l;
  }
  
  public final String qW()
  {
    AppMethodBeat.i(95918);
    if (qM() == 0)
    {
      AppMethodBeat.o(95918);
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
    AppMethodBeat.o(95918);
    return str;
  }
  
  public final void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95910);
    System.arraycopy(this.data, this.position, paramArrayOfByte, paramInt1, paramInt2);
    this.position += paramInt2;
    AppMethodBeat.o(95910);
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
    AppMethodBeat.i(95919);
    if (qM() == 0)
    {
      AppMethodBeat.o(95919);
      return null;
    }
    int i = this.position;
    while ((i < this.limit) && (!x.er(this.data[i]))) {
      i += 1;
    }
    if ((i - this.position >= 3) && (this.data[this.position] == -17) && (this.data[(this.position + 1)] == -69) && (this.data[(this.position + 2)] == -65)) {
      this.position += 3;
    }
    String str = new String(this.data, this.position, i - this.position);
    this.position = i;
    if (this.position == this.limit)
    {
      AppMethodBeat.o(95919);
      return str;
    }
    if (this.data[this.position] == 13)
    {
      this.position += 1;
      if (this.position == this.limit)
      {
        AppMethodBeat.o(95919);
        return str;
      }
    }
    if (this.data[this.position] == 10) {
      this.position += 1;
    }
    AppMethodBeat.o(95919);
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
    AppMethodBeat.i(95915);
    String str = a(paramInt, Charset.forName("UTF-8"));
    AppMethodBeat.o(95915);
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
    AppMethodBeat.i(95905);
    if (capacity() < paramInt) {}
    for (byte[] arrayOfByte = new byte[paramInt];; arrayOfByte = this.data)
    {
      l(arrayOfByte, paramInt);
      AppMethodBeat.o(95905);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(95907);
    if ((paramInt < 0) || (paramInt > this.limit)) {
      b.i("ExoPlayer", "position%d, limit:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.limit) });
    }
    if ((paramInt >= 0) && (paramInt <= this.limit)) {}
    for (;;)
    {
      a.checkArgument(bool);
      this.position = paramInt;
      AppMethodBeat.o(95907);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.i.m
 * JD-Core Version:    0.7.0.1
 */