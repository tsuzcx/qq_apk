package com.bumptech.glide.c.d.a;

import com.bumptech.glide.c.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class m
  extends FilterInputStream
{
  private final b aFy;
  private volatile byte[] buf;
  private int count;
  private int marklimit;
  private int markpos;
  private int pos;
  
  public m(InputStream paramInputStream, b paramb)
  {
    this(paramInputStream, paramb, (byte)0);
  }
  
  private m(InputStream paramInputStream, b paramb, byte paramByte)
  {
    super(paramInputStream);
    AppMethodBeat.i(77417);
    this.markpos = -1;
    this.aFy = paramb;
    this.buf = ((byte[])paramb.a(65536, [B.class));
    AppMethodBeat.o(77417);
  }
  
  private int a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77422);
    if ((this.markpos == -1) || (this.pos - this.markpos >= this.marklimit))
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (i > 0)
      {
        this.markpos = -1;
        this.pos = 0;
        this.count = i;
      }
      AppMethodBeat.o(77422);
      return i;
    }
    int j;
    byte[] arrayOfByte;
    if ((this.markpos == 0) && (this.marklimit > paramArrayOfByte.length) && (this.count == paramArrayOfByte.length))
    {
      j = paramArrayOfByte.length * 2;
      i = j;
      if (j > this.marklimit) {
        i = this.marklimit;
      }
      arrayOfByte = (byte[])this.aFy.a(i, [B.class);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      this.buf = arrayOfByte;
      this.aFy.put(paramArrayOfByte);
      this.pos -= this.markpos;
      this.markpos = 0;
      this.count = 0;
      j = paramInputStream.read(arrayOfByte, this.pos, arrayOfByte.length - this.pos);
      if (j > 0) {
        break label251;
      }
    }
    label251:
    for (int i = this.pos;; i = this.pos + j)
    {
      this.count = i;
      AppMethodBeat.o(77422);
      return j;
      arrayOfByte = paramArrayOfByte;
      if (this.markpos <= 0) {
        break;
      }
      System.arraycopy(paramArrayOfByte, this.markpos, paramArrayOfByte, 0, paramArrayOfByte.length - this.markpos);
      arrayOfByte = paramArrayOfByte;
      break;
    }
  }
  
  private static IOException pB()
  {
    AppMethodBeat.i(77419);
    IOException localIOException = new IOException("BufferedInputStream is closed");
    AppMethodBeat.o(77419);
    throw localIOException;
  }
  
  public final int available()
  {
    try
    {
      AppMethodBeat.i(77418);
      Object localObject1 = this.in;
      if ((this.buf == null) || (localObject1 == null))
      {
        localObject1 = pB();
        AppMethodBeat.o(77418);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    int i = this.count;
    int j = this.pos;
    int k = localObject2.available();
    AppMethodBeat.o(77418);
    return k + (i - j);
  }
  
  public final void close()
  {
    AppMethodBeat.i(77421);
    if (this.buf != null)
    {
      this.aFy.put(this.buf);
      this.buf = null;
    }
    InputStream localInputStream = this.in;
    this.in = null;
    if (localInputStream != null) {
      localInputStream.close();
    }
    AppMethodBeat.o(77421);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(77423);
      this.marklimit = Math.max(this.marklimit, paramInt);
      this.markpos = this.pos;
      AppMethodBeat.o(77423);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void pC()
  {
    try
    {
      this.marklimit = this.buf.length;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int read()
  {
    int i = -1;
    byte[] arrayOfByte;
    try
    {
      AppMethodBeat.i(77424);
      arrayOfByte = this.buf;
      Object localObject1 = this.in;
      if ((arrayOfByte == null) || (localObject1 == null))
      {
        localObject1 = pB();
        AppMethodBeat.o(77424);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    if ((this.pos >= this.count) && (a(localInputStream, arrayOfByte) == -1)) {
      AppMethodBeat.o(77424);
    }
    for (;;)
    {
      return i;
      Object localObject2 = arrayOfByte;
      if (arrayOfByte != this.buf)
      {
        arrayOfByte = this.buf;
        localObject2 = arrayOfByte;
        if (arrayOfByte == null)
        {
          localObject2 = pB();
          AppMethodBeat.o(77424);
          throw ((Throwable)localObject2);
        }
      }
      if (this.count - this.pos > 0)
      {
        i = this.pos;
        this.pos = (i + 1);
        i = localObject2[i] & 0xFF;
        AppMethodBeat.o(77424);
      }
      else
      {
        AppMethodBeat.o(77424);
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2;
    try
    {
      AppMethodBeat.i(77425);
      localObject2 = this.buf;
      if (localObject2 == null)
      {
        paramArrayOfByte = pB();
        AppMethodBeat.o(77425);
        throw paramArrayOfByte;
      }
    }
    finally {}
    if (paramInt2 == 0)
    {
      paramInt2 = 0;
      AppMethodBeat.o(77425);
      return paramInt2;
    }
    InputStream localInputStream = this.in;
    if (localInputStream == null)
    {
      paramArrayOfByte = pB();
      AppMethodBeat.o(77425);
      throw paramArrayOfByte;
    }
    int i;
    if (this.pos < this.count)
    {
      if (this.count - this.pos >= paramInt2) {}
      for (i = paramInt2;; i = this.count - this.pos)
      {
        System.arraycopy(localObject2, this.pos, paramArrayOfByte, paramInt1, i);
        this.pos += i;
        if ((i != paramInt2) && (localInputStream.available() != 0)) {
          break label420;
        }
        AppMethodBeat.o(77425);
        paramInt2 = i;
        break;
      }
    }
    for (;;)
    {
      if ((this.markpos == -1) && (i >= localObject2.length))
      {
        int k = localInputStream.read(paramArrayOfByte, paramInt1, i);
        j = k;
        localObject1 = localObject2;
        if (k != -1) {
          break label353;
        }
        if (i == paramInt2)
        {
          AppMethodBeat.o(77425);
          paramInt2 = -1;
          break;
        }
        paramInt2 -= i;
        AppMethodBeat.o(77425);
        break;
      }
      if (a(localInputStream, (byte[])localObject2) == -1)
      {
        if (i == paramInt2)
        {
          AppMethodBeat.o(77425);
          paramInt2 = -1;
          break;
        }
        paramInt2 -= i;
        AppMethodBeat.o(77425);
        break;
      }
      Object localObject1 = localObject2;
      if (localObject2 != this.buf)
      {
        localObject2 = this.buf;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          paramArrayOfByte = pB();
          AppMethodBeat.o(77425);
          throw paramArrayOfByte;
        }
      }
      if (this.count - this.pos >= i) {}
      for (int j = i;; j = this.count - this.pos)
      {
        System.arraycopy(localObject1, this.pos, paramArrayOfByte, paramInt1, j);
        this.pos += j;
        label353:
        i -= j;
        if (i != 0) {
          break label387;
        }
        AppMethodBeat.o(77425);
        break;
      }
      label387:
      if (localInputStream.available() == 0)
      {
        paramInt2 -= i;
        AppMethodBeat.o(77425);
        break;
      }
      paramInt1 += j;
      localObject2 = localObject1;
      continue;
      label420:
      paramInt1 += i;
      i = paramInt2 - i;
      continue;
      i = paramInt2;
    }
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(77420);
      if (this.buf != null)
      {
        this.aFy.put(this.buf);
        this.buf = null;
      }
      AppMethodBeat.o(77420);
      return;
    }
    finally {}
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(77426);
      if (this.buf == null)
      {
        IOException localIOException = new IOException("Stream is closed");
        AppMethodBeat.o(77426);
        throw localIOException;
      }
    }
    finally {}
    if (-1 == this.markpos)
    {
      a locala = new a("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
      AppMethodBeat.o(77426);
      throw locala;
    }
    this.pos = this.markpos;
    AppMethodBeat.o(77426);
  }
  
  public final long skip(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77427);
        if (paramLong < 1L)
        {
          paramLong = 0L;
          AppMethodBeat.o(77427);
          return paramLong;
        }
        Object localObject1 = this.buf;
        if (localObject1 == null)
        {
          localObject1 = pB();
          AppMethodBeat.o(77427);
          throw ((Throwable)localObject1);
        }
      }
      finally {}
      InputStream localInputStream = this.in;
      IOException localIOException;
      if (localInputStream == null)
      {
        localIOException = pB();
        AppMethodBeat.o(77427);
        throw localIOException;
      }
      if (this.count - this.pos >= paramLong)
      {
        this.pos = ((int)(this.pos + paramLong));
        AppMethodBeat.o(77427);
      }
      else
      {
        long l = this.count - this.pos;
        this.pos = this.count;
        if ((this.markpos != -1) && (paramLong <= this.marklimit))
        {
          if (a(localInputStream, localIOException) == -1)
          {
            AppMethodBeat.o(77427);
            paramLong = l;
          }
          else if (this.count - this.pos >= paramLong - l)
          {
            this.pos = ((int)(this.pos + paramLong - l));
            AppMethodBeat.o(77427);
          }
          else
          {
            paramLong = l + this.count - this.pos;
            this.pos = this.count;
            AppMethodBeat.o(77427);
          }
        }
        else
        {
          paramLong = l + localInputStream.skip(paramLong - l);
          AppMethodBeat.o(77427);
        }
      }
    }
  }
  
  static final class a
    extends IOException
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.m
 * JD-Core Version:    0.7.0.1
 */